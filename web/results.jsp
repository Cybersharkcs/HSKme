<%-- 
    Document   : results
    Created on : Nov 10, 2013, 2:29:03 PM
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <jsp:include page="header.jsp" >
        <jsp:param name="title" value="HSKme" />
    </jsp:include>
    <body>
        <h1>Resultats</h1>
        <table>
            <tr>
                <td>
                    Question 
                </td>
                <td>
                    Solution 
                </td>
                <td>
                    Reponse 
                </td>
                <td>
                    Valide ?
                </td>
            </tr>
            <c:forEach var="quest" items="${questionnaire}" varStatus="questCount" >
            <tr>
                <td>
                    ${quest.question}
                </td>
                <td>
                    ${quest.solution}
                </td>
                <td>
                    ${quest.reponse}
                </td>
                <td>                    
                    <c:if test="${quest.solution eq quest.reponse}" >
                        <c:set target="${quest}" property="valid" value="true" />
                    </c:if>
                    ${quest.valid}
                </td>
            </tr>
            </c:forEach>
        </table>
        Score final : ${stats.nbtotalquest} <br>
        <a href="index.jsp">Nouveau questionnaire</a>
    </body>
</html>
