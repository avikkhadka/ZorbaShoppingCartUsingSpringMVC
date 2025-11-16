<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <title>Access Denied</title>
    <style>
        body { font-family: Arial; text-align: center; padding: 50px; }
        h1 { color: #f44336; }
        a { text-decoration: none; color: #4CAF50; }
    </style>
</head>
<body>
    <h1>Access Denied</h1>
    <p>You do not have permission to access this page.</p>
    <a href="${pageContext.request.contextPath}/product/list">Go back to Products</a>
</body>
</html>
