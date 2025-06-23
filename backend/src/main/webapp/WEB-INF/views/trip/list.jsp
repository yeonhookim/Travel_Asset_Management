<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
  <title>내 여행 목록</title>
</head>
<body>
<h2>내 여행 목록</h2>

<c:forEach var="trip" items="${tripList}">
  <div>
    <strong>${trip.title}</strong><br>
    여행지: ${trip.destination}<br>
    기간: ${trip.startDate} ~ ${trip.endDate}<br>
    <hr>
  </div>
</c:forEach>

</body>
</html>