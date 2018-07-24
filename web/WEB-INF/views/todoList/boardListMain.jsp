<%--
  Created by IntelliJ IDEA.
  User: yong
  Date: 2018. 6. 30.
  Time: PM 5:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function(){
            boardData(0,0);
        });

        function boardData(Page, Size) {
            var currentPage = Page;//기본 첫페이지
            var pageSize = Size;//페이지당 글 수

            //메인페이지 오픈 시 1페이지 5개의 글을 default로 설정
            if(currentPage == 0 && pageSize == 0){
                currentPage = 1;
                pageSize = 10;
            }

            $.ajax({
                url : '/boardList?currentPage='+currentPage+'&pageSize='+pageSize,
                type : 'GET',
//            dataType : 'text',
//            processData : false,
//            contentType: "application/x-www-form-urlencoded; charset=utf-8",
                async: true,
                success: function(result) {
                    var items = result.items;
                    $('#tbody').empty();

                    for (var i=0; i<items.length; i++) {

                        var item = items[i];
                        var html = '';
                        html += '<tr>';
                        html += '<td>'+item.id+'</td>';
                        html += '<td><a href="/boardUpdatePage?id='+item.id+'">'+item.work+'</a></td>';
                        html += '<td>'+item.createDate+'</td>';
                        html += '<td>'+item.lastModifyDate+'</td>';
                        if(item.procYn == 0){
                            html += '<td><input type="checkbox" disabled></td>';
                        }else{
                            html += '<td><input type="checkbox" disabled checked></td>';
                        }

                        html += '</tr>';
                        $('#tbody').append(html);
                    }

                    var pagination = result.pagination;
                    $('#pagination').empty();

                    for(var j=1; j<=pagination.totalCount; j++){
                        var html = '';
                        html += '<a href="javascript:void(0);" onclick="boardData('+j+','+pageSize+');" style="margin-left: 10px;">';
                        if(j==pagination.currentPage){
                            html += '<strong style="font-size: 18px">'+j+'</strong>';
                        }else{
                            html += j;
                        }
                        html += '</a>';

                        $('#pagination').append(html);
                    }
                },
                error: function(xhr, status, err) {
                    alert("등록 오류 발생!");
                }
            });

            return false;
        }

        function boardCreatePage() {
            window.location.href = '/boardCreatePage';
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
    <div class="title"><h3>게시판 목록</h3></div>
    <div class="wrapper-table">
        <table class="board_list">
            <thead>
                <tr>
                    <th width="10%">ID</th>
                    <th width="40%">할일</th>
                    <th width="20%">작성일시</th>
                    <th width="20%">최종수정일시</th>
                    <th width="10%">완료처리</th>
                </tr>
            </thead>
            <tbody id="tbody">
            </tbody>
        </table>

        <div id="pagination">
        </div>
        <div class="buttons">
            <button onclick="boardCreatePage()">등록</button>
        </div>
    </div>
</body>
</html>