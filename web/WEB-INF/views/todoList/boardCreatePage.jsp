<%--
  Created by IntelliJ IDEA.
  User: yong
  Date: 2018. 7. 1.
  Time: AM 3:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript">
        function boardCreate() {
            var formData = $('#formData').serialize();
            $.ajax({
                    type : "POST",
                    url : '/boardCreate',
                    cache : false,
                    data : formData,
                    success : onSuccess,
                    error : onError
            });
        }
        function onSuccess(){
            alert("저장완료");
            window.location.href = '/boardMain';
        }
        function onError(){
            alert("저장실패");
        }

        function boardRelation() {
            var url = '/popBoardRelation';
            var style = 'width=450,height=500,target=_blank,margin_left=200,left=100';

            window.open(url,'',style);
        }
    </script>
    <style type="text/css">
        .title {
            width: 100%;
            text-align: center;
        }
        .wrapper-table {
            margin: 0 auto;
            width: 1200px;
            text-align: center;
        }
        table {
            margin: 0 auto;
            width: 100%;
            border: 2px solid #ccc
        }
        table thead tr th {
            background-color: rgba(19, 33, 40, 0.36);
            border: 2px solid #ccc;
            text-align: center;
        }
        table tbody tr td {
            border: 1px solid #ccc;
            text-align: center;
        }
        .buttons {
            margin-top: 10px;
            text-align: left;
        }
        button {
            padding: 5px 10px;
        }
        input {
            width: 90%;
        }
    </style>
</head>
<body>
<div class="title"><h3>게시판 등록</h3></div>
<div class="wrapper-table">
    <form id="formData">
        <table class="board">
            <colgroup>
                <col width="10%"/>
                <col width="*"/>
            </colgroup>
            <tbody>
                <tr>
                    <td>할일</td>
                    <td><input type="text" name="work"></td>
                </tr>
                <tr>
                    <td>참조</td>
                    <td><input type="text" id="relationId" name="relationId" readonly="true"></td>
                </tr>
            </tbody>
        </table>
    </form>
    <div class="buttons">
        <button onclick="boardRelation()">참조설정</button>
        <button onclick="boardCreate()">저장</button>
    </div>
</div>
</body>
</html>
