<%-- 
    Document   : results
    Created on : Nov 10, 2013, 2:29:03 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <jsp:include page="header.jsp" />
    <body>
        <div id="title"><h1>Resultats</h1></div>
        <div id="content" >
            <table>
                <tr>
                    <td>Question</td>
                    <td>Solution</td>
                    <td>Reponse</td>
                    <td>Valide ?</td>
                </tr>
                <c:forEach var="question" items="${questionList}" varStatus="questCount" >
                    <tr>
                        <td>${question.question}</td>
                        <td>${question.solution}</td>
                        <td>${question.reponse}</td>
                        <td>${question.valid}</td>
                    </tr>
                </c:forEach>
            </table>
            Score final : ${stats} %<br>
            <a href="index.jsp">Nouveau questionnaire</a>
        </div>
        <div id="footer" ><jsp:include page="footer.jsp" /></div>
    </body>
</html>
