<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<body>
<table>
    <tr>
        <th>
            <input type="button" value="Profile"
                   onclick="window.location.href = '/profile'"/>
        </th>
        <th> <input type="button" value="Top 10" style="background: cadetblue"
                    onclick="window.location.href = '/hello'"/></th>
        <th> <input type="button" value="Flop 10"
                    onclick="window.location.href = '/flop'"/></th>
        <th> <input type="button" value="Last"
                    onclick="window.location.href = '/last'"/></th>
    </tr>
</table>
<br><br>
<table width="100%">
    <tr>
        <th  align="left" width="60%">${randomQuote.name}</th>
        <th  align="left" width="40%">
            <form:form action="/userOpen" modelAttribute="user">
            Name <form:input path="name"/>
            <br><br>
            Password <form:input path="password"/>
                <br><br>
            <input type="submit" value="Sing in">
            </form:form></th>
    </tr>
    <tr>
        <th  align="left" width="60%"><c:forEach var="quotesTop" items="${quotes}">
            <h3>${quotesTop.name}</h3>
            <input type="button" value="&#128078;"/>
            ${quotesTop.count}
            <input type="button" value="&#128077;"/>
            Posted by ${quotesTop.author}
        </c:forEach>
        </th>
    </tr>
</table>

<br><br>
</body>
</html>
