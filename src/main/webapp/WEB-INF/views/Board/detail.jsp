<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Basic-글 상세보기</title>
</head>
<style>
    table,tr,td{
     border: 1px solid black;
    }
</style>
<body>
    <table>
        <tr>
            <th>글 번호</th>
            <th>글 제목</th>
            <th>글 내용</th>
        </tr>
        <tr>
            <td ><c:out value="${boardVo.id}"/></td>
            <td><c:out value="${boardVo.title}"/></td>
            <td><c:out value="${boardVo.content}"/></td>

        </tr>
    </table>
    <div style="width: 600px; margin: auto; text-align: right; ">
        <a href="${pageContext.request.contextPath}/list.do" style="margin-right: 0.5rem;">목록</a>
        <a href="${pageContext.request.contextPath}/modify.do?id=${boardVo.id}" style="margin-right: 0.5rem;">수정</a>
        <a href="#" onclick="if (confirm('정말로 게시글을 삭제할까요?')) {window.location.href='${pageContext.request.contextPath}/delete.do?id=${boardVo.id}';}">삭제</a>
    </div>
</body>