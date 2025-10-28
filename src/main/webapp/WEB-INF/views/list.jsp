<%--
  Created by IntelliJ IDEA.
  User: JangwooJoo
  Date: 2025-10-28
  Time: 오후 4:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <ul>
        <c:forEach items="${list}" var="dto">
            <li>아이디: ${dto.getMid()}&nbsp;비밀번호: ${dto.getMpw()}&nbsp;이름: ${dto.getMname()}</li>
        </c:forEach>
    </ul>
    <script>
        window.onload(() => {
           alert(${message});
        });
    </script>
</body>
</html>
