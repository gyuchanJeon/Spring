<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User5::modify</title>
</head>
<body>
<h3>User5 수정</h3>

<a href="/ch05/">처음으로</a>
<a href="/ch05/user5/list">목록</a>

<form action="/ch05/user5/modify" method="post">
    <table border="1">
        <tr>
            <td>고유번호</td>
            <td><input type="number" name="seq" value="${user.seq}" readonly/></td>
        </tr>
        <tr>
            <td>이름</td>
            <td><input type="text" name="name" value="${user.name}"/></td>
        </tr>
        <tr>
            <td>성별</td>
            <td><input type="text" name="gender" value="${user.gender}"/></td>
        </tr>
        <tr>
            <td>나이</td>
            <td><input type="number" name="age" value="${user.age}"/></td>
        </tr>
        <tr>
            <td>주소</td>
            <td><input type="text" name="addr" value="${user.addr}"/></td>
        </tr>
        <tr>
            <td colspan="2" align="right">
                <input type="submit" value="수정하기"/>
            </td>
        </tr>
    </table>

</form>


</body>
</html>