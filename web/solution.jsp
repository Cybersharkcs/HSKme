<%-- 
    Document   : solution
    Created on : Nov 30, 2013, 12:38:10 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
        <jsp:include page="header.jsp" />
    <body>
        <div id="title">
            <h1>Solution</h1>
        </div>
        <div id="content" >
            ${questionList[numero].solution} <br>
            <a href="question.jsp" >retour question</a>
        </div>
        <div id="footer" >
            <jsp:include page="footer.jsp" />
        </div>
    </body>
</html>
