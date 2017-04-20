<%-- 
    Document   : index
    Created on : 13.04.2017, 19:31:07
    Author     : Jeso
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Guestbook REST</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        
        <!--Bootstrap CSS styles-->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        
    </head>
    <body>
        <h1>Welcome to Guestbook</h1>
        <div class="container">
            <form method="post" action="rest/v1/messages">
                <div class="form-group">
                    <label for="author">Your name</label>
                    <input id="author" name="author" type="text" required="true" maxlength="45" />
                </div>
                <div class="form-group">
                    <label for="messageText">Your Message</label>
                    <textarea id ="messageText" name="messageText" required="true" maxlength="255"></textarea>
                </div>
                <button type="submit" class="btn btn-default">Send</button>
            </form>
        </div>
    </body>
</html>
