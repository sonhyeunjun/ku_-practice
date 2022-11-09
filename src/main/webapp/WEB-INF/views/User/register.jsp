<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원가입 페이지</title>
    <script>
      function signup_btn()
      {
        alert('회원가입이 완료되었습니다.');
      }
    </script>
</head>
<body>
<div class="wrap">
    <div class="login" style="height: 700px;">
        <h2 style="color: #288CFF;">회원가입</h2>
        <form action="/registersave.do" method="POST">
            <div class="login_id">
                <h4>ID</h4>
                <input type="email" name="email" placeholder="아이디 입력">
            </div>
            <div class="login_pw">
                <h4>Password</h4>
                <input type="password" name="password" placeholder="비밀번호 입력">
            </div>
            <br>
            <div class="submit">
                <button id="signup-btn" type="submit" onclick="javascript:signup_btn()">회원가입 완료</button>
            </div>
        </form>
    </div>
</div>
</body>
</html>