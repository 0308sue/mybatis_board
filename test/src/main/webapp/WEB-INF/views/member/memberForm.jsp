<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <style type="text/css">
        .fieldError{
            color: #bd2130;
        }
    </style>
</head>
<body>
    <h1>SEQURITY</h1>
    <form action="/members/new" method="post">
        <div>       
            <label> 이름 </label>
            <input type="text" id="name" placeholder="이름을 입력하세요" name="name">
            <spring:hasBindErrors name="memberDTO">
                <c:if test="${errors.hasFieldErrors('name') }">                                     
                    <p class="fieldError">${errors.getFieldError( 'name' ).defaultMessage }</p>
                </c:if>
            </spring:hasBindErrors>
        </div>
        <div>       
            <label> 이메일 </label>
            <input type="email" id="email" placeholder="이메일을 입력하세요" name="content">
            <spring:hasBindErrors name="memberDTO">
                <c:if test="${errors.hasFieldErrors('email') }">                                     
                    <p class="fieldError">${errors.getFieldError( 'email' ).defaultMessage }</p>
                </c:if>
            </spring:hasBindErrors>
        </div>
        <div>       
            <label> 비밀번호 </label>
            <input type="password" id="password" placeholder="비밀번호를 입력하세요" name="content">
            <spring:hasBindErrors name="memberDTO">
                <c:if test="${errors.hasFieldErrors('password') }">                                     
                    <p class="fieldError">${errors.getFieldError( 'password' ).defaultMessage }</p>
                </c:if>
            </spring:hasBindErrors>
        </div>
        <div>       
            <label> 주소 </label>
            <input type="text" id="address" placeholder="주소를 입력하세요" name="content">
            <spring:hasBindErrors name="memberDTO">
                <c:if test="${errors.hasFieldErrors('address') }">                                     
                    <p class="fieldError">${errors.getFieldError( 'address' ).defaultMessage }</p>
                </c:if>
            </spring:hasBindErrors>
        </div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        <div>       
            <button> 글쓰기 </button>
        </div>
    </form>
</body>
</html>

<!-- <script>
    $(document).ready(function(){
        let errorMessage = [[${errorMessage}]];
        if(errorMessage != null){
            alert(errorMessage);
        }
    });
</script> -->