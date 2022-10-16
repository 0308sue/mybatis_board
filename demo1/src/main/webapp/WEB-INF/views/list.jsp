<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>
    <h1>LIST(${count})</h1>
    <table>
        <thead>
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>내용</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${list }" var="list" varStatus="st">
                <tr>
                    <td>${list.num}</td>
                    <td><a href="detail/${list.num}"> ${list.title }</a></td>
                    <td>${list.content }</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>

