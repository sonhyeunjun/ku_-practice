<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Basic-로그인 화면</title>
</head>
<script>
    function login_btn()
    {
      if(session['SPRING_SECURITY_LAST_EXCEPTION'] != null)
      {
        alert('로그인 실패.');
      }
      else
      {
        alert('로그인 되었습니다.');
      }
    }
  </script>
<style>
    table,tr,td{
     border: 1px solid black;
    }
</style>
<body>
    로그인 페이지 입니다.
    <form action="/loginsucces.do" method="post">
        <div class="user-box">
            <input type="text" name="email" id="sublogin">
            <label>Username</label>
        </div>
        <div class="user-box">
            <input type="password" name="password" >
            <label>Password</label>
        </div>
        <div class="submit">
            <button type="submit" onclick="javascript:login_btn()">로그인</button>
        </div>
        <input type="button" value="회원가입" onclick="location.href='/register.do'">
    </form>
    
</body>
</html>