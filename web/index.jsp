<%-- 
    Document   : index
    Created on : Nov 10, 2013, 1:40:56 PM
    Author     : root
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="header.jsp" >
        <jsp:param name="title" value="HSKme" />
    </jsp:include>
    <body>
        <h1>Nouveau questionnaire</h1>
        <form method="POST" action="beginTest.do">
            <table>
                <tr>
                    <th>
                        Niveau :
                        <input type="radio" name="hsk" value="2" />HSK2
                        <input type="radio" name="hsk" value="3" checked />HSK3
                    </th>
                </tr>
                <tr>
                    <th>
                        Nombre de questions :
                        <input name="nb" value="10" >
                    </th>
                </tr>
                <tr>
                    <th>
                        Montrez en 
                        <select name="from" size="1">
                            <option value="caractere"> chinois simplifié </option>
                            <option value="francais"> français </option>
                            <option value="pinyin"> pinyin </option>
                        </select>
                        et devinez la réponse correcte en 
                        <select name="to" size="1">
                            <option value="pinyin"> pinyin </option>
                            <option value="francais"> français </option>
                            <option value="caractere"> chinois simplifié </option>
                        </select>
                         <center>
                             <input type="submit" value="Commencez">
                        </center>
                    </th>
                </tr>
            </table>
        </form>
    </body>
</html>