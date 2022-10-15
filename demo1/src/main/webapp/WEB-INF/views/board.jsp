<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>Document</title>
</head>
<body>
    <h1>BOARD</h1>
    <form action="insert" method="post">
        <label> 제목 </label>
        <input type="text" id="title" placeholder="제목을 입력하세요" name="title">

        <label> 내용 </label>
        <textarea id="content" placeholder="내용을 입력하세요" name="content"></textarea>
            
        <button> 글쓰기 </button>
    </form>
</body>
</html>

