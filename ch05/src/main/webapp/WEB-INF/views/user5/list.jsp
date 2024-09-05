<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User5::list</title>
</head>
<body>
<h3>User5 목록</h3>
<a href="/ch05/">처음으로</a>
<a href="/ch05/user5/register">등록</a>
<table border="1">
    <tr>
        <th>고유번호</th>
        <th>이름</th>
        <th>성별</th>
        <th>나이</th>
        <th>주소</th>
        <th>관리</th>
    </tr>
    <%--
        - Spring JSP에서는 EL문법이 기본적으로 비활성 되는거 같음
        - Spring JSP에서 EL문법을 처리하기 위해 상단 page 지시자에 isELIgnored="false" 추가
    --%>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.seq}</td>
            <td>${user.name}</td>
            <td>${user.gender}</td>
            <td>${user.age}</td>
            <td>${user.addr}</td>
            <td>
                <a href="/ch05/user5/modify?seq=${user.seq}">수정</a>
                <a href="/ch05/user5/delete?seq=${user.seq}">삭제</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>