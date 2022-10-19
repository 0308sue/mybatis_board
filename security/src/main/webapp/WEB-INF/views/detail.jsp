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
    <h1>DETAIL(${board.num})</h1>
    <a href="/list">리스트</a><td/>
    <form action="update" method="post">
        <label> 제목 </label>
        <input type="text" id="title" value="${board.title}" name="title">

        <label> 내용 </label>
        <textarea id="content" name="content">${board.content}</textarea>
        <td/>
            
        <button type="button" id="btnUpdate"> 수정 </button> 
        <button type="button" id="btnDelete"> 삭제 </button> 
    </form>
    <div>
        <input type="text" id="comment" placeholder="댓글을 입력하세요" name="comment">
        <button type="button" id="btninsert">입력</button>       
    </div>

    <div id="commentList"></div>
</body>
</html>

<script>
    $("#btnDelete").click(function(){
        if(!confirm("정말 삭제 할까요?"))
        return false;
        $.ajax({
            type:"delete",
            url :"/delete/${board.num}",
            success:function(resp){
                if(resp=="success"){
                    alert("삭제 성공!")
                    location.href = "/list"
                }
            }
        })
    })

    $("#btnUpdate").click(function(){
        data = {
            "num" : "${board.num}",
            "title" : $("#title").val(),
            "content" : $("#content").val()
        }
        if(!confirm("정말 수정할까요?"))
        return false;
        $.ajax({
            type : "put",
            url : "/update",
            contentType:"application/json;charset=utf-8",
			data:JSON.stringify(data),
            success:function(resp){
                if(resp =="success"){
                    alert("수정 성공!")
                    location.href = "/list"
                }
            }
        })
    })

    $("#btninsert").click(function(){
        data = {
            "bnum" : "${board.num}",
            "comment" : $("#comment").val()
        }
        $.ajax({
            type : "post",
            url : "/commentInsert",
            contentType:"application/json;charset=utf-8",
			data:JSON.stringify(data)
        }).done(function(resp){
            $("#comment").val("");
            init()
        }).fail(function(e){
            alert("댓글 추가 실패")
        })
    })

    let init = function(){
        $.ajax({
            type : "get",
            url : "/commentList",
            data : {"bnum":"${board.num}"}
        }).done(function(resp){
            alert("aaa")
            let str = "<table>"
			console.log(resp)
			$.each(resp,function(key,val){
				str +="<tr>"
				str +="<td>"+val.cnum+"</td>"
				str +="<td>"+val.comment+"</td>"							
				str += "<td> <a href = javascript:fdel('"+val.cnum+"')>삭제</a></td>"				
				str +="</tr>"
			})
			str +="</table>"
			$("#commentList").html(str);
        })
    }

    init()
</script>   

