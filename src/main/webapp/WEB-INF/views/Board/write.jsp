<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Basic-글 작성</title>
</head>
<style>
    table,tr,td{
     border: 1px solid black;
    }
</style>
<body>

    <form action="/writesave.do" method="post">
        <table>
            <tr>
                <!-- 라벨을 넣으면 제목을 눌렀을 때 커서가 input에 자동으로 들어가게 해준다 id와 일치해야 함 -->
                <th width="20%"><label for="title">제목</label></th>
                <td width="80%"><input type="text" name="title" id="title" class="input_title"></td>
            </tr>
            <tr>
                <th><label for="content">내용</label></th>
                <td><textarea name="content" id="content" class="textarea_content"></textarea></td>
            </tr>
            <tr>
                <th colspan="2" style="text-align: right;"> <!-- colspan: 가로합침 -->
                    <button type="submit">작성</button>
                    <button type="reset">취소</button>
                </th>
            </tr>
        </table>
    
</body>
</html>