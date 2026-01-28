<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>dailyShop - Re-Seller Profile</title>

<style>
    body {
        margin: 0;
        padding: 0;
        font-family: Arial, sans-serif;
        background: #eef3ff;
    }

    .container {
        width: 420px;
        margin: 70px auto;
        background: #ffffff;
        padding: 30px;
        border-radius: 15px;
        box-shadow: 0 0 18px rgba(0,0,0,0.15);
    }

    h2 {
        text-align: center;
        color: #0066ff;
        margin-bottom: 25px;
    }

    label {
        font-size: 15px;
        color: #333;
    }

    input[type="text"], input[type="password"] {
        width: 100%;
        padding: 12px;
        margin: 10px 0 18px;
        border: 1px solid #ccc;
        border-radius: 8px;
        box-sizing: border-box;
        font-size: 15px;
    }

    input[type="submit"] {
        width: 100%;
        background: #007bff;
        color: white;
        padding: 12px;
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

    <h2>Create Re-Seller Profile</h2>

    <form action="createReSellerProfile" method="post">

        <label>First Name:</label>
        <input type="text" name="firstName">

        <label>Last Name:</label>
        <input type="text" name="lastName">

        <label>Email:</label>
        <input type="text" name="email">

        <label>Mobile:</label>
        <input type="text" name="mobile">

        <label>Password:</label>
        <input type="password" name="password">

        <input type="submit" value="Submit">
    </form>

</div>

</body>
</html>
