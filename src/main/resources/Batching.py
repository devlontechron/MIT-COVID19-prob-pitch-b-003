# Script to produce matches
import pandas as pd
import numpy as np
import mysql.connector as sql
import datetime as dt
from scipy.spatial import distance



def dist_ranger(dist, coord):
    lat = abs(0.621371*dist)/69.1
    long = abs(0.621371*dist)/53.0
    return({'lat': (coord[0]-lat, coord[0]+lat),
            'long': (coord[1]-long, coord[1]+long)})



def batching(classification, distance, batch_size, db_conn):

    query = f"""
    SELECT 
    test_id, date_dt, classification
    , age, gender, race
    , latitude, longitude
    , symp_fever, symp_cough, symp_fatigue, symp_appetite, symp_breathing, symp_aches, symp_diarrhea
    , risk_heart, risk_bp, risk_lung, risk_kidney, risk_cancer, risk_immune, risk_diabetes
    , trans_travel , trans_occupation
    FROM test_data a
    LEFT JOIN organizations b
        ON a.provider_id = b.provider_id
    WHERE data_class = {classification}
        AND data_batch is null
    """

    col1 = ['test_id', 'latitude', 'longitude']
    col2 = ['age', 'symp_fever', 'symp_cough', 'symp_fatigue', 'symp_appetite', 'symp_breathing', 'symp_aches',
            'symp_diarrhea', 'risk_heart', 'risk_bp', 'risk_lung', 'risk_kidney', 'risk_cancer', 'risk_immune',
            'risk_diabetes', 'trans_travel', 'trans_occupation']


    df = pd.read_sql(query, con=db_conn)
    df['date'] = dt.date.today().strftime("%Y-%m-%d")
    df['batched'] = False
    df['batch_id'] = None
    i = 1

    while len(df.query('batched==False')) > 0:
        batch_no = f'{dt.date.today().strftime("%y%m%d")}_{classification}_{i}'
        sub = df.query('batched==False')
        assign_id, lat, long = sub.query(f'date_dt=={min(sub.query().date_dt)}')[col1].iloc[0,:]
        dist_base = sub.query(f'date_dt=={min(sub.query().date_dt)}')[col2].iloc[0,:]
        square = dist_ranger(distance, (lat, long))
        sub = sub.query(f'{min(square["lat"])} <= latitude <= {max(square["lat"])} & {min(square["long"])} <= longitude <= {max(square["long"])}')
        sub['dist'] = sub.apply(lambda x: distance.euclidean(x[col2], dist_base), axis=1)
        df.loc[(df.apply(lambda x: x.test_id in list(
            sub.sort_values(by='dist', ascending=True, na_position='last').test_id[0:batch_size]),
                         axis=1)), 'batched'] = True
        df.loc[(df.apply(lambda x: x.test_id in list(sub.sort_values(by='dist', ascending=True, na_position='last').test_id[0:batch_size]),
                         axis=1)), 'batch_id'] = batch_no
        i += 1

    return(df[['date', 'batch_id', 'test_id', 'classification']])


db_connection = sql.connect(host='3.21.156.213', database='covid', user='devin', password='rug6y')
group_a = batching(classification='A', distance=3-, batch_size=5, db_conn=db_connection)
group_b = batching(classification='B', distance=3-, batch_size=5, db_conn=db_connection)

cursor = db_connection.cursor()

add_batchrow = ("INSERT INTO batch_output "
                "(batch_day, batch_id, test_id, classification) "
                "VALUES (%s, %s, %s, %s)")

for df in (group_a, group_b):
    for index, row in df.iterrows():
        cursor.execute(add_batchrow, (row.date, row.batch_id, row.test_id, row.classification))
        emp_no = cursor.lastrowid

# Make sure data is committed to the database
db_connection.commit()

cursor.close()
db_connection.close()
