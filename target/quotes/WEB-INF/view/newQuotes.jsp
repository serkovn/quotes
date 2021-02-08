<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<body>
<h2>New Quote</h2>

<form action = "/saveNew" method = "GET">
    Name <input type="text" name="name" value="${quote.name}"/>
    <br><br>
    <input type="hidden" value="${quote.id}" name="QuoteId">
    <input type="hidden" value="${user.id}" name="UserId">
    <input type="submit" value="Create!">
</form>
</body>
</html>