<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@include file="../layout/header.jsp"%>

<br>
<div class = "container mt-3">
    <form>
        <div class="mb-3">
            <label for="userName"><spring:message code="user.login.form.userName"/>:</label>
            <input type="text" class="form-control" id="userName" placeholder="Enter username" name="userName">
        </div>
        <div class="mb-3">
            <label for="pwd" class="form-label"><spring:message code="user.login.form.password"/>:</label>
            <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd">
        </div>
        <button id="btn-login" class="btn btn-secondary"><spring:message code="user.login.form.login_btn"/></button>
    </form>
</div>

<script src="/js/login.js"></script>

<%@include file="../layout/footer.jsp"%>


</body>
</html>
