/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    function getXmlHttpRequest() {
        try
        {
            // Firefox, Opera 8.0+, Safari
            return new XMLHttpRequest();
        }
        catch (e)
        {
            // Internet Explorer
            try
            {
                return new ActiveXObject("Msxml2.XMLHTTP");
            }
            catch (e)
            {
                try
                {
                    return new ActiveXObject("Microsoft.XMLHTTP");
                }
                catch (e)
                {
                    alert("Your browser does not support AJAX!");
                    return null;
                }
            }
        }
    }

    function constructDisplay(xmlDoc){
        var out = "<table><tr><th>UserID</th> <th>name</th> <th>address</th> <th>userGroupID</th></tr>"                
        var users = xmlDoc.getElementsByTagName("userDO")
        var i;

        for (i = 0; i < users.length; i++){
            out += "<tr><td>";
            out += users[i].getElementsByTagName("userID")[0].childNodes[0].nodeValue;
            out += "</td><td>";
            out += users[i].getElementsByTagName("name")[0].childNodes[0].nodeValue;
            out += "</td><td>";
            out += users[i].getElementsByTagName("address")[0].childNodes[0].nodeValue;
            out += "</td><td>";
            out += users[i].getElementsByTagName("userGroupID")[0].childNodes[0].nodeValue;
            out += "</td><tr>";                                        
        }                    
        out +="</table>"
        return out;
    }

    function getUsers()
    {
        var xmlHttp = getXmlHttpRequest();
        xmlHttp.onreadystatechange=function()
        {
            if(xmlHttp.readyState==4)
            {
                document.getElementById("query").innerHTML="GET rest/users";

                document.getElementById("output").innerHTML=constructDisplay(xmlHttp.responseXML);
            }
        }
        xmlHttp.open("GET","rest/users/",true);
        xmlHttp.send(null);
    }


    function getUser(index)
    {
        var xmlHttp = getXmlHttpRequest();
        xmlHttp.onreadystatechange=function()
        {
            if(xmlHttp.readyState==4)
            {
                document.getElementById("query").innerHTML="GET rest/users/" + index;
                if(xmlHttp.responseText.indexOf("<body>") != -1) {
                    s = xmlHttp.responseText.substring(xmlHttp.responseText.indexOf("<body>") + 6, xmlHttp.responseText.indexOf("</body>"))
                    document.getElementById("output").innerHTML=s;
                } else {
                    document.getElementById("output").innerHTML=xmlHttp.responseText;
                }

            }
        }
        xmlHttp.open("GET","rest/users/" + index,true);
        xmlHttp.send(null);
    }

//    function deleteMessage(index)
//    {
//        var xmlHttp = getXmlHttpRequest();
//        xmlHttp.onreadystatechange=function()
//        {
//            if(xmlHttp.readyState==4)
//            {
//                document.getElementById("query").innerHTML="DELETE rest/users/" + index;
//                if(xmlHttp.responseText.indexOf("<body>") != -1) {
//                    s = xmlHttp.responseText.substring(xmlHttp.responseText.indexOf("<body>") + 6, xmlHttp.responseText.indexOf("</body>"))
//                    document.getElementById("output").innerHTML=s;
//                } else {
//                    document.getElementById("output").innerHTML=xmlHttp.responseText;
//                }
//            }
//        }
//        xmlHttp.open("DELETE","rest/users/" + index,true);
//        xmlHttp.send(null);
//    }

    function addUserFunct(name, address, userGroupID)
    {
        var message = getXMLText(name, address, userGroupID)
        document.getElementById("debug").innerHTML=message;
        var xmlHttp = getXmlHttpRequest();
        xmlHttp.onreadystatechange=function()
        {
            if(xmlHttp.readyState==4)
            {
                document.getElementById("query").innerHTML="POST rest/users";
                document.getElementById("output").innerHTML="";
            }
        }
        
        xmlHttp.open("POST","rest/users/",true);
        xmlHttp.send(message);

    }
    
    function getXMLText(name, address, userGroupID){
        var out = "<userDO>";
        out += "<address>"+address+"</address>";
        out += "<name>"+name+"</name>";
        out += "<userGroupID>"+userGroupID+"</userGroupID>";
        //out += "<userID>"+userID+"</userID>";
        out += "</userDO>";
        document.getElementById("debug").innerHTML="out: "+out;
        return out;        
    }
    
    




