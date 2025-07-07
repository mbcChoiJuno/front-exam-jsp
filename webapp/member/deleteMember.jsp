<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%
	String sessionId = (String) session.getAttribute("sessionId");
%>
<sql:setDataSource var="dataSource"
	url="jdbc:mysql://192.168.0.171:3306/DVDMarketDB"
	driver="com.mysql.jdbc.Driver" user="dvdmarket" password="dvd1234" />

<sql:update dataSource="${dataSource}" var="resultSet">
   DELETE FROM user_tbl_old WHERE user_id = ?
   <sql:param value="<%=sessionId%>" />
</sql:update>

<c:if test="${resultSet>=1}">
	<c:import var="url" url="logoutMember.jsp" />
	<c:redirect url="resultMember.jsp?msg=0" />
</c:if>

