<%-- 
    Document   : index
    Created on : Nov 10, 2013, 1:40:56 PM
    Author     : root
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
        <jsp:include page="header.jsp" />
    <body>
        <div id="title">
            <h1>Nouveau questionnaire</h1>
        </div>
        <div id="content" >
            <%-- Not idempotent, GET is default --%>
            <form method="POST" action="CommenceTest.do">
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
                            <select name="from" id="from" size="1" onChange="refreshElements(this.options[this.selectedIndex].value);">
                                <option value="francais"> français </option>
                                <option value="caractere"> chinois simplifié </option>
                                <option value="pinyin"> pinyin </option>
                            </select>
                            et devinez la réponse correcte en 
                            <select name="to" id="to" size="1">
                                <option value="pinyin"> pinyin </option>
                                <option value="caractere"> chinois simplifié </option>
                                <option value="francais"> français </option>
                            </select>
                             <center>
                                 <input type="submit" value="Commencez">
                            </center>
                        </th>
                    </tr>
                </table>
            </form>
        </div>
        <div id="footer" >
            <jsp:include page="footer.jsp" />
        </div>
    </body>
</html>