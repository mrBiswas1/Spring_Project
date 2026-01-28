<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>dailyShop - Main Page</title>

<style>
    body {
        margin: 0;
        padding: 0;
        font-family: Arial, sans-serif;
        background: #eef2ff;
    }

    .title {
        text-align: center;
        margin-top: 40px;
        font-size: 28px;
        color: #0066ff;
        font-weight: bold;
    }

    .card {
        width: 380px;
        margin: 40px auto;
        background: #ffffff;
        padding: 30px;
        border-radius: 12px;
        box-shadow: 0 4px 15px rgba(0,0,0,0.1);
        text-align: center;
    }

    h3 {
        margin-bottom: 20px;
        color: #333;
    }

    .btn {
        display: block;
        width: 200px;
        margin: 10px auto;
        padding: 12px;
        border-radius: 8px;
        font-size: 16px;
        text-decoration: none;
        color: #ffffff;
        background: #007bff;
        transition: 0.3s;
    }

    .btn:hover {
        background: #005ed0;
    }

    .btn-danger {
        background: #ff3b3b;
    }

    .btn-danger:hover {
        background: #d40000;
    }
</style>

</head>
<body>

<h2 class="title">Welcome to dailyShop</h2>

<div class="card">
    <h3>Main Menu</h3>

    <a href="viewProducts" class="btn">Create Stocks</a>
    <a href="updateStocks" class="btn">Update Stocks</a>
    <a href="deleteStocks" class="btn">Delete Stocks</a>

    <a href="logout" class="btn btn-danger">Logout</a>
</div>

</body>
</html>
