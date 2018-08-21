<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<table align='center' border='1' cellspacing='0'>
    <tr>
        <td>num</td>
        <td>id</td>
        <td>name</td>
        <td>email</td>
        <td>lastLoginTime2</td>
        <td>status</td>
    </tr>
    <c:forEach items="${students}" var="s" varStatus="st">
        <tr>
            <td>${st.count}</td>
            <td>${s.id}</td>
            <td>${s.nickname}</td>
            <td>${s.email}</td>
            <td>
                <fmt:formatDate value="${s.last_Login_Time}" pattern="yyyy-MM-dd HH:mm:ss"/>
            </td>
            <td>${s.status}</td>
        </tr>
    </c:forEach>
</table>