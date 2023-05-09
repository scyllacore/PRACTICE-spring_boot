<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="\webjars\bootstrap\5.2.3\css\bootstrap.min.css" rel="stylesheet">
    <script src="\webjars\bootstrap\5.2.3\js\bootstrap.bundle.min.js"></script>
    <script src="\webjars\jquery\3.6.3\dist\jquery.min.js"></script>
    <!-- include summernote css/js -->
    <link href="\webjars\summernote\0.8.20\dist\summernote-bs5.min.css" rel="stylesheet">
    <script src="\webjars\summernote\0.8.20\dist\summernote-bs5.min.js"></script>
</head>

<body>
<nav class="navbar navbar-expand-sm bg-light">
    <div class="container-fluid">
        <c:if test="${sessionScope.principal == null}">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="/">Main</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/auth/login">Login</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/auth/insertUser">Register</a>
                </li>
            </ul>
        </c:if>
        <c:if test="${sessionScope.principal != null}">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="/">Main</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/user/updateUser">회원 상세</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/post/insertPost">포스트 등록</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/auth/logout">로그아웃</a>
                </li>
            </ul>
        </c:if>
    </div>
</nav>
