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
            <h2>Hello ${user.name}</h2>
        <br><br>
        Last votes(5)
            <br>
            <c:forEach var="quotesLats" items="${quotesLast}">
                ${quotesLats.name}
                <br>
            </c:forEach>
            <br>
            <input type="button" value="Exit"
                   onclick="window.location.href = '/'"/>
        </th>
    </tr>
    <tr>
        <th  align="left" width="60%"><c:forEach var="quotesTop" items="${quotes}">
            <c:url var="decrement" value="/decrement">
            <c:param name="QuoteId" value="${quotesTop.id}"/>
                <c:param name="UserId" value="${user.id}"/>
            </c:url>
            <c:url var="delete" value="/delete">
                <c:param name="QuoteId" value="${quotesTop.id}"/>
                <c:param name="UserId" value="${user.id}"/>
            </c:url>
            <c:url var="update" value="/update">
                <c:param name="QuoteId" value="${quotesTop.id}"/>
                <c:param name="UserId" value="${user.id}"/>
            </c:url>
            <c:url var="increment" value="/increment">
                <c:param name="QuoteId" value="${quotesTop.id}"/>
                <c:param name="UserId" value="${user.id}"/>
            </c:url>
            <h3>${quotesTop.name}</h3>
            <input type="button" value="Delete"
                   onclick="window.location.href = '${delete}'"/> <input type="button" value="Update"
                   onclick="window.location.href = '${update}'"/>
            <br><br>
            <input type="button" value="&#128078;"
                   onclick="window.location.href = '${decrement}'"/>
            ${quotesTop.count}
            <input type="button" value="&#128077;"
                   onclick="window.location.href = '${increment}'"/>
            Posted by ${quotesTop.author}
        </c:forEach>
        </th>
    </tr>
    <tr>
        <c:url var="newQuote" value="/newQuote">
            <c:param name="UserId" value="${user.id}"/>
        </c:url>
        <input type="button" value="Create new Quote"
               onclick="window.location.href = '${newQuote}'"/>
    </tr>
</table>
<br><br>
</body>
</html>
