<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product Details</title>
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
            margin-bottom: 20px;
        }

        label {
            font-weight: bold;
            display: block;
            margin-top: 10px;
        }

        input[type=number] {
            width: 100%;
            padding: 10px;
            margin: 5px 0 20px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        .btn {
            width: 100%;
            padding: 12px;
            background-color: #4CAF50;
            color: white;
            font-weight: bold;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            text-decoration: none;
            text-align: center;
        }

        .btn:hover {
            background-color: #45a049;
        }

        .details {
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Product Details</h2>

    <div class="details">
        <p><strong>Name:</strong> ${product.name}</p>
        <p><strong>Category:</strong> ${product.type}</p>
        <p><strong>Available Quantity:</strong> ${product.availableQuantity}</p>
        <p><strong>Price:</strong> $${product.price}</p>
    </div>

    <form action="${pageContext.request.contextPath}/cart/add" method="post">
        <input type="hidden" name="productId" value="${product.id}" />
        <label>Quantity:</label>
        <input type="number" name="quantity" min="1" max="${product.availableQuantity}" required/>
        <input type="submit" value="Add to Cart" class="btn"/>
    </form>
</div>
</body>
</html>
