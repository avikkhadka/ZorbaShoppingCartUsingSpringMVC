<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Product</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
        }

        .container {
            width: 400px;
            margin: 50px auto;
            background-color: #fff;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0px 0px 15px rgba(0,0,0,0.2);
        }

        h2 {
            text-align: center;
            color: #333;
        }

        input[type=text], input[type=number], select {
            width: 100%;
            padding: 10px;
            margin: 8px 0 20px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        select {
            background-color: #fff;
            color: #333;
        }

        input[type=submit] {
            width: 100%;
            padding: 12px;
            background-color: #4CAF50;
            border: none;
            border-radius: 4px;
            color: white;
            font-weight: bold;
            cursor: pointer;
        }

        input[type=submit]:hover {
            background-color: #45a049;
        }

        .message {
            color: green;
            text-align: center;
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
        <label>Product Name</label>
        <input type="text" name="name" placeholder="Enter product name" required/>

        <label>Category</label>
        <select name="type" required>
            <option value="">Select Category</option>
            <option value="Grocery">Grocery</option>
            <option value="Dairy">Dairy</option>
            <option value="Cosmetics">Cosmetics</option>
            <option value="Fashion">Fashion</option>
            <option value="Electronics">Electronics</option>
        </select>

        <label>Available Quantity</label>
        <input type="number" name="availableQuantity" placeholder="Enter quantity" min="1" required/>

        <label>Price</label>
        <input type="number" name="price" placeholder="Enter price" step="0.01" min="0" required/>

        <input type="submit" value="Add Product"/>
    </form>
</div>
</body>
</html>
