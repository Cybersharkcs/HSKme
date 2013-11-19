<%-- 
    Document   : form
    Created on : Nov 10, 2013, 2:27:13 PM
    Author     : root
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="header.jsp" >
        <jsp:param name="title" value="HSKme" />
    </jsp:include>
    <body>
        <h1>Question</h1>
        <%--DEBUG : before Count : ${count}, Nb : ${nb-1} --%>
        <%-- Ordre declarations à respecter imperativement --%>
        <c:set var="post" value="question.jsp" />
        <jsp:useBean id="randomb" class="com.hskme.web.RandomBean" scope="application" />
        <c:choose>
            <c:when test="${param.submit eq 'solution'}" >
                <c:set var="solution" value="${questionnaire[count].solution}" />
            </c:when>
            <c:when test="${param.submit ne null}" >
                <c:set var="count" scope="application" value="${count + 1}" />
            </c:when>
        </c:choose>
        <c:if test="${count eq nb-1}">
            <c:set var="post" value="results.jsp" />
        </c:if>
        <form method="POST" action="${post}">
        <table>
            <tr>
                <th>
                    Voici le ${from} : 
                </th>
                <th>
                    <font size="5pt">${questionnaire[count].question}</font>
                </th>
            </tr>
            <tr>
                <th>
                    Donnez son ${to} : 
                </th>
                <table style="width: 100%; border-collapse:collapse;">
                    <c:set var="random" value="${randomb.nextInt}" />
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
                                <c:set var="aleasolution" value="${questionnaire[count].solution}" />
                            </c:if>
                        <tr>
                            <td><input type="submit" value="${aleasolution}" name="submit"></td>
                        </tr>
                        </c:forEach>
                </table>
                    <c:if test="${count != 0}" >
                        <c:set var="count1" value="${count}" />
                        <c:set target="${questionnaire[count1-1]}" property="reponse" value="${param.submit}"/>
                    </c:if>
            </tr>
            <tr>
                <th>
                    DEBUG : after Count : ${count}, Nb : ${nb-1}
                </th>
                <th>
                    ${solution}
                </th>
            </tr>
            <tr>
                <th>
                    <input type="submit" name="submit" value="solution">
                </th>
                <th>
                    <a href="index.jsp">Nouveau questionnaire</a>
                </th>
            </tr>
        </table>
        </form>
    </body>
</html>