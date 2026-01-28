<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>dailyShop Profile - Success</title>

<style>
    body {
        margin: 0;
        padding: 0;
        font-family: Arial, sans-serif;
        background: #eef2ff;
    }

    .container {
        width: 450px;
        margin: 70px auto;
        background: #ffffff;
        padding: 35px;
        border-radius: 15px;
        box-shadow: 0 0 18px rgba(0,0,0,0.15);
        text-align: center;
    }

    h2 {
        color: #007bff;
        margin-bottom: 15px;
    }

    p {
        font-size: 18px;
        margin-bottom: 25px;
        color: #333;
    }

    h3 {
        color: #555;
        margin-bottom: 25px;
    }

    label {
        float: left;
        margin-bottom: 5px;
        font-weight: bold;
        color: #444;
    }

    input[type="text"], input[type="password"] {
        width: 100%;
        padding: 12px;
        margin-bottom: 18px;
        border: 1px solid #ccc;
        border-radius: 8px;
        font-size: 15px;
        box-sizing: border-box;
    }

    input[type="submit"] {
        width: 100%;
        padding: 12px;
        background: #007bff;
        color: white;
        border: none;
        font-size: 16px;
        border-radius: 8px;
        cursor: pointer;
        transition: 0.3s;
    }

    input[type="submit"]:hover {
        background: #005ed1;
    }
</style>

</head>
<body>

<div class="container">

    <h2>Profile Created Successfully!</h2>

    <p>Your User ID is: <strong>${userId}</strong></p>

    <h3>To explore dailyShop features, login now</h3>

    <form action="validateUser" method="post">

        <label>Email:</label>
        <input type="text" name="email">

        <label>Password:</label>
        <input type="password" name="password">

        <input type="submit" value="Login">

    </form>

</div>

</body>
</html>
