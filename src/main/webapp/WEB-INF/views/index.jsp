<%-- 
    Document   : index
    Created on : 20.04.2017, 19:31:07
    Author     : Jeso
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCss" />
<spring:url value="/resources/js/bootstrap.min.js" var="bootstrapJs" />
<spring:url value="/resources/scripts/ajaxContent.js" var="ajaxContentJs" />
<spring:url value="/resources/css/styles.css" var="userStylesCss"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Jeso Guestbook REST(test 2)</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <link href="${bootstrapCss}" rel="stylesheet"/>
        <link href="${userStylesCss}" rel="stylesheet"/>
        <script src="${bootstrapJs}"></script>
        <script src="${ajaxContentJs}"></script>
        
    </head>
    <body>
        <div class="panel panel-header user_header" style="text-align:center"><h1>Welcome to Guestbook</h1></div>
        
	<div class="container">
            
            <div class="row">
                <!--TODO fix it later. This action works strange in IE-->
                <form class="form-horizontal col-sm-6" action="javascript:submitButtonHandler()" >
                    <div class="form-group">
                        <label for="author" class="col-sm-2 control-label">Your name</label>
			<div class="col-sm-10">
                            <input id="author" name="author" type="text" required="true" maxlength="45" class="form-control"/>
			</div>
                    </div>
                    <div class="form-group">
                        <label for="messageText" class="col-sm-2 control-label">Your Message</label>
			<div class="col-sm-10">
                            <textarea id ="messageText" name="messageText" required="true" maxlength="255" class="form-control"></textarea>
			</div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-default">Send</button>
                        </div>
                    </div>
                </form>
            </div>
    
            <div class="row">		
                <div id="contentDiv" class="col-sm-6"></div>
            </div>
            
	</div>
    </body>
</html>
