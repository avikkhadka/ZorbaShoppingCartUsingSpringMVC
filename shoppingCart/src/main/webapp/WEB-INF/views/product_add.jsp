<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Product</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f5f6fa;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .container {
            background: #fff;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0px 0px 20px rgba(0,0,0,0.1);
            width: 400px;
        }

        h2 {
            text-align: center;
            margin-bottom: 30px;
            color: #333;
        }

        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }

        input[type=text], input[type=number] {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        input[type=submit] {
            width: 100%;
            padding: 12px;
            background-color: #4CAF50;
            border: none;
            color: white;
            font-size: 16px;
            border-radius: 5px;
            cursor: pointer;
        }

        input[type=submit]:hover {
            background-color: #45a049;
        }

        .message {
            text-align: center;
            color: green;
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Add Product</h2>

    <c:if test="${not empty message}">
        <div class="message">${message}</div>
    </c:if>

    <form action="${pageContext.request.contextPath}/product/add" method="post">
        <label>Name:</label>
        <input type="text" name="name" required/>

        <label>Type:</label>
        <input type="text" name="type" required/>

        <label>Available Quantity:</label>
        <input type="number" name="availableQuantity" min="1" required/>

        <label>Price:</label>
        <input type="number" name="price" step="0.01" min="0" required/>

        <input type="submit" value="Add Product"/>
    </form>
</div>
</body>
</html>
