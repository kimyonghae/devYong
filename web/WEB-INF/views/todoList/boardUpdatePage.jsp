<%--
  Created by IntelliJ IDEA.
  User: yong
  Date: 2018. 7. 1.
  Time: AM 4:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function(){
            boardData();
        });

        function boardData() {
            console.log(window.location)
            $.ajax({
                url : '/boardRead'+window.location.search,
                type : 'GET',
                async: true,
                success: function(result) {
                    var item = result.item;

                    $('#work').val(item.work);
                    $('#id').val(item.id);
                    if(item.procYn == 0){
                        $('#procYn').attr("checked", false);
                    }else{
                        $('#procYn').attr("checked", true);
                    }

                    //처리가능여부
                    if(item.procAble == 0 || item.procYn == 1){
//                        document.getElementById("procYn").disabled= true;
                        $('#procYn').attr("disabled", true);
                    }
                },
                error: function(xhr, status, err) {
                    alert("수정 오류 발생!");
                }
            });
            return false;
        }

        function boardUpdate() {
            var formData = $('#formData').serialize();
            $.ajax({
                type : "POST",
                url : '/boardUpdate',
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
<div class="title"><h3>게시판 수정</h3></div>
<div class="wrapper-table">
    <form id="formData">
        <input type="hidden" name="id" id="id">
        <table class="board">
            <colgroup>
                <col width="10%"/>
                <col width="*"/>
                <col width="10%"/>
                <col width="*"/>
            </colgroup>
            <tbody>
            <tr>
                <td>완료처리</td>
                <td><input type="checkbox" name="procYn" id="procYn"></td>
                <td>할일</td>
                <td><input type="text" name="work" id="work"></td>
            </tr>
            </tbody>
        </table>
    </form>
    <div class="buttons">
        <button onclick="boardUpdate()">수정</button>
    </div>
</div>
</body>
</html>
