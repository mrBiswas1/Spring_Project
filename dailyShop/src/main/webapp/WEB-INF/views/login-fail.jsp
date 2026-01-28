<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Invalid Credential</title>

<style>
    body {
        margin: 0;
        padding: 0;
        background: #ffefef;
        font-family: Arial, sans-serif;
    }

    .box {
        width: 400px;
        margin: 120px auto;
        background: #ffffff;
        padding: 30px;
        border-radius: 12px;
        text-align: center;
        box-shadow: 0 0 15px rgba(255,0,0,0.2);
        animation: fadeIn 0.8s ease-in-out;
    }

    h2 {
        color: #d60000;
        margin-bottom: 10px;
        animation: shake 0.4s ease-in-out;
    }

    @keyframes fadeIn {
        from { opacity: 0; transform: translateY(-20px); }
        to   { opacity: 1; transform: translateY(0); }
    }

    @keyframes shake {
        0%   { transform: translateX(0); }
        20%  { transform: translateX(-8px); }
        40%  { transform: translateX(8px); }
        60%  { transform: translateX(-5px); }
        80%  { transform: translateX(5px); }
        100% { transform: translateX(0); }
    }

    a {
        display: inline-block;
        margin-top: 20px;
        text-decoration: none;
        color: #ffffff;
        background: #d60000;
        padding: 10px 20px;
        border-radius: 8px;
        transition: 0.3s;
    }

    a:hover {
        background: #a80000;
    }
</style>

</head>
<body>

<div class="box">
    <h2>Invalid Credential!</h2>
    <a href="login.jsp">Try Again</a>
</div>

</body>
</html>
