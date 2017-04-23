/* 
 * Created on : 21.04.2017, 19:31:07
 * Author     : Jeso
 */

//global variables
var contentDiv;
var ajaxHostURL = 'http://localhost:8080/GuestbookRest';

        
//start ajax-function after loading document
document.addEventListener("DOMContentLoaded", function(event) { 
    contentDiv = document.getElementById("contentDiv");
    getMessages();
});

//AJAX request for all messages
function getMessages(){
    var xhr = createXhr();
    xhr.open('GET', ajaxHostURL + '/rest/v1/messages', true);
    xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4) {
            if (xhr.status != 200) {
                alert( "Sorry, error during connection" ); 
            } 
            else {
                var myObj = JSON.parse(this.responseText);
                myObj.forEach(innerIterate);
            }
        }
    };
    xhr.send();
}

//inner object iteration, creating html-elements for message
function innerIterate(innerObj){
    var myDir = document.createElement("div");
    myDir.setAttribute("id", "message");

    for (var property in innerObj) {
        if (innerObj.hasOwnProperty(property)){
            if(property=="id") continue;
            if(property=="userAuthor"){ 
                    var block = document.createElement("p");
                    block.setAttribute("class", "lead");
            }
            if(property=="messageText") var block = document.createElement("p");
            if(property=="creationDate") {
                    var block = document.createElement("h6");
                    block.setAttribute("class", "text-right");
            }
            var text = document.createTextNode(innerObj[property]);
            block.appendChild(text);
            myDir.appendChild(block);
        }				
    }
    contentDiv.appendChild(myDir);
}

//AjaxHandler for form Button
function submitButtonHandler(){
    var author = document.getElementById("author").value;
    var messageText = document.getElementById("messageText").value;
    var xhr = createXhr();
    xhr.open('POST', ajaxHostURL + '/rest/v1/messages', true);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.send("author=" + encodeURIComponent(author) + "&messageText=" + encodeURIComponent(messageText));
    
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4) {
            if (xhr.status != 200) {
                alert( "Sorry, error during connection" ); 
            } 
            else {
                //clean contentDiv before
                while(contentDiv.firstChild){
                    contentDiv.removeChild(contentDiv.firstChild);
                }
                //show new list of messages
                getMessages();
            }
        }
    }
}

//crossbrowser xhr factory
function createXhr() {
    var xhr;
    //For Chrome, Firefox, Opera
    if (window.XMLHttpRequest) {
        xhr = new XMLHttpRequest();
    //For IE
    } else if (window.ActiveXObject) {
        try {
            //new version
            xhr = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (e) {
            //old version
            xhr = new ActiveXObject("Microsoft.XMLHTTP");
        }
    }
    return xhr;
}