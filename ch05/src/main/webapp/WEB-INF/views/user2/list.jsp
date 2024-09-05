<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User2::list</title>
</head>
<body>
<h3>User2 목록</h3>
<a href="/ch05/">처음으로</a>
<a href="/ch05/user2/register">등록</a>
<table border="1">
    <tr>
        <th>아이디</th>
        <th>이름</th>
        <th>생년월일</th>
        <th>주소</th>
        <th>관리</th>
    </tr>
    <%--
        - Spring JSP에서는 EL문법이 기본적으로 비활성 되는거 같음
        - Spring JSP에서 EL문법을 처리하기 위해 상단 page 지시자에 isELIgnored="false" 추가
    --%>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.uid}</td>
            <td>${user.name}</td>
            <td>${user.birth}</td>
            <td>${user.addr}</td>
            <td>
                <a href="/ch05/user2/modify?uid=${user.uid}">수정</a>
                <a href="/ch05/user2/delete?uid=${user.uid}">삭제</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>