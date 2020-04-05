var thisFName = "";
var thisScore = 0;


function saveName(){
    thisFName = document.getElementById("fname").value;

    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("POST", 'https://hdproc.azurewebsites.net/api/login?code=5idtbN5FwHae6VffSl14MuWtaT0pC2hBlgOeErrF7IEgVpupHrt65w==&name='+thisFName , true);
    xmlhttp.setRequestHeader("Content-Type", "application/json")
    xmlhttp.setRequestHeader("Authorization", "basic")
    xmlhttp.send();
    xmlhttp.onreadystatechange = function(){
        var response = xmlhttp.responseText;
        console.log(response);
        if (xmlhttp.readyState == 4){
            alert(response)

            if(xmlhttp.status == 200){
                window.location = 'main.html';
            }
        }
    }
}

function getTestById(){
       var xmlhttp = new XMLHttpRequest();
       xmlhttp.open("GET", 'http://mitcovid-env.eba-kp5pu7vi.us-east-2.elasticbeanstalk.com/testData/%7B%7D' , true);
       xmlhttp.setRequestHeader("Content-Type", "application/json")
       xmlhttp.setRequestHeader("Authorization", "basic")
       xmlhttp.send();
       xmlhttp.onreadystatechange = function(){
           if (this.readyState == 4 && this.status == 200) {
           // Typical action to be performed when the document is ready:
            var response = xmlhttp.responseText;
            console.log(response);
            setTestResultPage(response)

        }
    };
}

function setTestResultPage(receivedData){
    var data = JSON.parse(receivedData);
    var topPhrase = data;
    for (var i = 0; i < data.phrases.length; i++) {
        var newRow = document.getElementById("tr");
        var data1 = document.createElement("td");
        data1.appendChild(document.createTextNode(data.phrases[i].phrase));
        var data2 = document.createElement("td");
        data2.appendChild(document.createTextNode(data.phrases[i].count));
        newRow.appendChild(data1);
        newRow.appendChild(data2);
        document.getElementById("phraseTable").appendChild(newRow);
    }

    // for (var i = 0; i < data.phrases.length; i++) {
    //     var currPhase = data.phrases[i].phrase ;
    //     var currPhraseCount = data.phrases[i].count;

    //     for (var j = 0; j < topPhrase.length; j++) {
    //         if(topPhrase[j].count > currPhase){
    //             if(topPhrase.length > j && topPhrase[j+1].score<currPhraseCount){
    //                 topPhrase.put(j, data.phrase[i]);
    //             }
    //         }
    //     }
    // }

}




function savePatient(){
    age = document.getElementById("PatientAge").value;
    gender = document.getElementById("gender").value;
    race = document.getElementById("Race").value;
    location3 = document.getElementById("zip").value;
    weight = document.getElementById("Weight").value;

    var newPatient = {
        "age": age,
        "created": new Date(),
        "gender": gender,
        "id": "0",
        "lastUpdated": new Date(),
        "location": location3,
        "race": race
    }

    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("POST", 'https://mitcovid-env.eba-kp5pu7vi.us-east-2.elasticbeanstalk.com/civilian/new', true);
    xmlhttp.setRequestHeader("Content-Type", "application/json")
    xmlhttp.setRequestHeader("Authorization", "basic")
    xmlhttp.send(JSON.stringify(newPatient));
    xmlhttp.onreadystatechange = function(){
        var response = xmlhttp.responseText;
        console.log(response);
        if (xmlhttp.readyState == 4){
            alert(response)

            if(xmlhttp.status == 200){
                window.location = 'main.html';
            }
        }
    }
}


function saveNewPhrase(){
    var newPhrase = prompt("Enter a new phrase:", "");

    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("POST", 'https://hdproc.azurewebsites.net/api/createPhrase?code=H16r8CUTl56FyAWPsLogJSJZpKM6MaMJajinyY9pPXpUjhrtLWmd0Q==&phrase='+newPhrase , true);
    xmlhttp.setRequestHeader("Content-Type", "application/json")
    xmlhttp.setRequestHeader("Authorization", "basic")
    xmlhttp.send();
    xmlhttp.onreadystatechange = function(){
        var response = xmlhttp.responseText;
        console.log(response);
        if (xmlhttp.readyState == 4){
            alert(response)

            if(xmlhttp.status == 200){
                window.location = 'main.html';
            }
        }
    }
}


function setTopUsers(recievedData){
    var topRank = [];
    var data = JSON.parse(recievedData);
    for (var i = 0; i < data.users.length; i++) {
        var currScore = data.users[i].score;

        var leader = document.createElement('div');
        leader.setAttribute("class", "currLeader");

        var score = document.createElement('p');
        score.setAttribute("class", "score");
        score.appendChild(document.createTextNode(data.users[i].score));

        var name = document.createElement('p');
        name.setAttribute("class", "name");
        name.appendChild(document.createTextNode(data.users[i].name));

        leader.appendChild(score);
        leader.appendChild(name);

        document.getElementById("leaders").appendChild(leader);


        // for(var j = 0; j < topRank.length; j++){
        //     if(topRank[j].score > currScore){
        //         topRank[j].put
        //     }else if(topRank[j].score > currScore){
        //         topRank[j-1].put();
        //     }
        // }
    }

}




function loadMainData(){
       var xmlhttp = new XMLHttpRequest();
       xmlhttp.open("GET", 'https://hdproc.azurewebsites.net/api/getUsers?code=lxbnR/D9QQzGhPGr8cmMA3OaslvT3z1HaISNZL/fvLKUuP0teDLK0A==' , true);
       xmlhttp.setRequestHeader("Content-Type", "application/json")
       xmlhttp.setRequestHeader("Authorization", "basic")
       xmlhttp.send();
       xmlhttp.onreadystatechange = function(){
           if (this.readyState == 4 && this.status == 200) {
           // Typical action to be performed when the document is ready:
            var response = xmlhttp.responseText;
            console.log(response);
            setTopPhrases(response)
            setTopUsers(response)
        }
    };
}