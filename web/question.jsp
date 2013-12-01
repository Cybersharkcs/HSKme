<%-- 
    Document   : form
    Created on : Nov 10, 2013, 2:27:13 PM
    Author     : root
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="header.jsp" />
    <body>
        <div id="title">
            <h1>Question</h1>
        </div>
        <div id="content" >
            <form method="GET" action="TraiteQuestion">
            <table>
                <tr>
                    <th>Voici le ${from} : </th>
                    <th><font size="5pt">${questionList[numero].question}</font></th>
                </tr>
                <tr>
                    <th>Choisir son ${to} : </th>
                    <th>
                        <table>
                                <c:set var="random" value="${randomb.nextInt}" scope="page"/>
                                <c:forEach var="dicoCount" begin="1" end="5">
                                    <c:choose>
                                        <c:when test="${to eq 'caractere'}" >
                                            <c:set var="aleasolution" value="${dictionnaire.vocabAlea.caractere}" />
                                        </c:when>
                                        <c:when test="${to eq 'francais'}" >
                                            <c:set var="aleasolution" value="${dictionnaire.vocabAlea.traduction}" />
                                        </c:when>
                                        <c:when test="${to eq 'pinyin'}" >
                                            <c:set var="aleasolution" value="${dictionnaire.vocabAlea.pinyin}" />
                                        </c:when>
                                    </c:choose>
                                    <c:if test="${dicoCount == random}" >
                                        <c:set var="aleasolution" value="${questionList[numero].solution}" />
                                    </c:if>
                                    <tr>
                                        <td><input type="submit" value="${aleasolution}" name="reponse"></td>
                                    </tr>
                                </c:forEach>
                        </table>
                    </th>
                </tr>
                <tr>
                    <th></th>
                    <th></th>
                </tr>
                <tr>
                    <th>
                        <a href="index.jsp">Nouveau questionnaire</a></th>
                    <th>
                        <a href="solution.jsp">Solution</a></th>
                    </th>
                </tr>
            </table>
            </form>
        </div>
        <div id="footer" ><jsp:include page="footer.jsp" /></div>
    </body>
</html>