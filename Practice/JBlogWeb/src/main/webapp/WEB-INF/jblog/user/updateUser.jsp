<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@include file="../layout/header.jsp"%>

<br>
<div class = "container mt-3">
    <form>
        <input type="hidden" id="id" value="${principal.user.id}">
        <div class="mb-3">
            <label for="username">Username:</label>
            <input type="text" class="form-control" id="username" placeholder="Enter username" value="${principal.user.username}">
        </div>
        <div class="mb-3">
            <label for="password" class="form-label">Password:</label>
            <input type="password" class="form-control" id="password" placeholder="Enter password">
        </div>
        <div class="mb-3">
            <label for="email" class="form-label">Email:</label>
            <input type="email" class="form-control" id="email" placeholder="Enter email" name="email" value="${principal.user.email}">
        </div>
        <button id="btn-update" class="btn btn-secondary">회원 정보 수정</button>
    </form>
</div>

<script src="/js/user.js"></script>

<%@include file="../layout/footer.jsp"%>
