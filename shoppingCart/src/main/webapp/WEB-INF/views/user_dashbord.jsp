<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f0f0f0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .dashboard-container {
            background: #fff;
            padding: 30px 40px;
            border-radius: 8px;
            box-shadow: 0px 0px 10px #aaa;
            text-align: center;
        }
        a.logout {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 20px;
            background: #dc3545;
            color: #fff;
            text-decoration: none;
            border-radius: 4px;
        }
        a.logout:hover {
            background: #c82333;
        }
    </style>
</head>
<body>
<div class="dashboard-container">
    <h2>Welcome!</h2>
    <p>You have successfully logged in.</p>
    <a class="logout" href="/user/logout">Logout</a>
</div>
</body>
</html>
