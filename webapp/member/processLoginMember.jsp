<%@page import="user.mvc.model.UserDTO"%>
<%@page import="session.SessionHandler"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%
	request.setCharacterEncoding("UTF-8");

	String id = request.getParameter("id");
	String password = request.getParameter("password");
%>

<sql:setDataSource var="dataSource"
	url="jdbc:mysql://192.168.0.171:3306/DVDMarketDB"
	driver="com.mysql.jdbc.Driver" user="dvdmarket" password="dvd1234" />
	
<sql:query dataSource="${dataSource}" var="resultSet">
   SELECT * FROM user_tbl_old WHERE user_id=? and user_pw=?  
   <sql:param value="<%=id%>" />
	<sql:param value="<%=password%>" />
</sql:query>

<c:forEach var="row" items="${resultSet.rows}">
	<c:set var="adminFlag" value="${row.is_admin}" />
	<%
		var isAdmin = Integer.parseInt( pageContext.getAttribute("adminFlag").toString());	
	
		var user = new UserDTO();
		user.setUser_id(id);
		user.setIs_admin(isAdmin);
	
		SessionHandler.getInstance().onLoginEvent(user);
		
		System.out.print(SessionHandler.getInstance().getCurrentUser().getUser_id() + " is logon");
	
		session.setAttribute("sessionId", id);
	%>
	<c:redirect url="resultMember.jsp?msg=2" />
</c:forEach>

<c:redirect url="loginMember.jsp?error=1" />
