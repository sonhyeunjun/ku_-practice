<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header style="z-index: 999;">
    <ul>
        <li>
            <a href="${pageContext.request.contextPath}/list.do">게시판</a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/mapmain.do">지도</a>
        </li>
  
    </ul>
    <div class="spring"></div>
    <ul>
        <c:if test="${loginId == null}">
        <li>
            <a href="${pageContext.request.contextPath}/login.do">로그인</a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/register.do">회원가입</a>
        </li>

        </c:if>

        <c:if test="${loginId != null}">
            <li>
                <b>${loginId}</b><a>님 환영합니다.</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/modify.do">정보 수정</a>
            </li>
            <li>
                <a href="${pageContext.request.contextPath}/logout.do">로그아웃</a>
            </li>
        </c:if>
    </ul>
</header>