<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@include file="../layout/header.jsp"%>

<br>
<div class = "container mt-3">
    <form>
        <div class="mb-3">
            <label for="userName">Username:</label>
            <input type="text" class="form-control" id="userName" placeholder="Enter username" name="userName">
        </div>
        <div class="mb-3">
            <label for="pwd" class="form-label">Password:</label>
            <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd">
        </div>
        <div class="mb-3">
            <label for="email" class="form-label">Email:</label>
            <input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
        </div>
        <button id="btn-save" class="btn btn-secondary">회원 가입</button>
    </form>
</div>

<script src="/js/user.js"></script>

<%@include file="../layout/footer.jsp"%>


</body>
</html>
