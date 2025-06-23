<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>여행 추가</title>
</head>
<body>
<h2>여행 추가</h2>
<form action="${pageContext.request.contextPath}/trip/add" method="post">
    제목: <input type="text" name="title" required /><br/>
    여행지: <input type="text" name="destination" required /><br/>
    시작일: <input type="date" name="startDate" required /><br/>
    종료일: <input type="date" name="endDate" required /><br/>
    <button type="submit">등록</button>
</form>
</body>
</html>