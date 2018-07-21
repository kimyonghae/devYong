<%--
  Created by IntelliJ IDEA.
  User: yong
  Date: 2018. 7. 1.
  Time: PM 4:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function(){
            boardRelationList();
        });
        function boardRelationList() {
            $.ajax({
                url : '/boardRelationList',
                type : 'GET',
                async: true,
                success: function(result) {
                    var items = result.items;

                    for (var i=0; i<items.length; i++) {
                        var item = items[i];

                        var html = '';
                        html += '<tr>';
                        html += '<td><input type="checkbox" name="checkbox"></td>';
                        html += '<td id="'+item.id+'">'+item.id+'</td>';
                        html += '<td>'+item.work+'</td>';
                        html += '</tr>';

                        $('#tbody').append(html);
                    }
                },
                error: function(xhr, status, err) {
                    alert("선택 오류 발생!");
                }
            });
            return false;
        }
        
        function boardRelationSelect() {
            var chkbox = document.getElementsByName('checkbox');
            var str = '';
            for(var i=0 ; i<chkbox.length ; i++) {
                if(chkbox[i].checked) {
                    if(str==''){
                        str += document.getElementById("tbody").rows[i].cells[1].innerHTML;
                    }else{
                        str += ',' + document.getElementById("tbody").rows[i].cells[1].innerHTML;
                    }
                }
            }
            opener.document.getElementById("relationId").value = str;
            window.close();
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
    </style>
</head>
<body>
<div class="title"><h3>참조 선택</h3></div>
<div class="wrapper-table">
    <table class="board" width="450">
        <thead>
            <tr>
                <th width="10%">선택</th>
                <th width="30%">ID</th>
                <th width="60%">할일</th>
            </tr>
        </thead>
        <tbody id="tbody">
        </tbody>
    </table>
    <div class="buttons">
        <button onclick="boardRelationSelect()">적용</button>
    </div>
</div>
</body>
</html>

