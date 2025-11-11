<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
        }

        .container {
            width: 900px;
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

        .top-bar {
            display: flex;
            justify-content: space-between;
            margin-bottom: 20px;
        }

        .btn {
            background-color: #4CAF50;
            color: white;
            padding: 8px 16px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            text-decoration: none;
        }

        .btn:hover {
            background-color: #45a049;
        }

        select {
            padding: 6px;
            border-radius: 4px;
            border: 1px solid #ccc;
        }

        .message {
            color: green;
            text-align: center;
            margin-bottom: 15px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #4CAF50;
            color: white;
        }

        .action-btn {
            background-color: #28a745;
            color: white;
            padding: 6px 12px;
            border: none;
            border-radius: 4px;
            text-decoration: none;
        }

        .action-btn:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Product Dashboard</h2>

    <c:if test="${not empty message}">
        <div class="message">${message}</div>
    </c:if>

    <div class="top-bar">
        <a href="${pageContext.request.contextPath}/product/add" class="btn">Add Product</a>

        <form action="${pageContext.request.contextPath}/product/list" method="get">
            <label>Filter by Category: </label>
            <select name="type" onchange="this.form.submit()">
                <option value="">All</option>
                <option value="Grocery" <c:if test="${param.type=='Grocery'}">selected</c:if>>Grocery</option>
                <option value="Dairy" <c:if test="${param.type=='Dairy'}">selected</c:if>>Dairy</option>
                <option value="Cosmetics" <c:if test="${param.type=='Cosmetics'}">selected</c:if>>Cosmetics</option>
                <option value="Fashion" <c:if test="${param.type=='Fashion'}">selected</c:if>>Fashion</option>
                <option value="Electronics" <c:if test="${param.type=='Electronics'}">selected</c:if>>Electronics</option>
            </select>
        </form>
    </div>

    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Category</th>
            <th>Available Quantity</th>
            <th>Price</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
         <c:if test="${not empty sessionScope.loggedInUser}">
                <p>Welcome, ${sessionScope.loggedInUser.username}!</p>
            </c:if>
        <c:forEach var="product" items="${products}">
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.type}</td>
                <td>${product.availableQuantity}</td>
                <td>${product.price}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/product/view/${product.id}" class="action-btn">
                        Add to Cart
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
