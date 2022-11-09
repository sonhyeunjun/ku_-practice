<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Basic-글 리스트 출력</title>
  </head>
  <style>
    table,
    tr,
    td {
      border: 1px solid black;
    }
  </style>
  <body>
    <%@ include file="/WEB-INF/views/header.jsp" %>
    <form action="/list.do" method="get">
      <input type="text" name="keyword">
      <button type="submit" onclick="keyword">검색</button>
  </form><br>
  <table>
      <tr>
          <th>글 번호</th>
          <th><c:out value="${loginId}" /></th>
      </tr>
      <c:forEach items="${list}" var="board">
          <tr>
              <td><c:out value="${board.id}" /></td>
              <td><a href="${pageContext.request.contextPath}/detail.do?id=${board.id}" style="text-decoration: underline;"><c:out value="${board.title}"/></a></td>
              <td><c:out value="${board.content}" /></td>
          </tr>
      </c:forEach>
  </table>
  <div style="width: 600px; margin: auto; text-align: right; ">
      <button type="button" onclick="location.href='write.do';">글작성</button>
  </div>
  </body>
</html>
