<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.sql.*"%>


<html>
<head>
 <link rel ="stylesheet" href ="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />
<title>DVD 편집</title>
<script type="text/javascript">
	function deleteConfirm(id) {
		if (confirm("해당 영상을 삭제합니다!!") == true)
			location.href = "./deleteBook.jsp?id=" + id;
		else
			return;
	}
</script>

</head>
<%
	String edit = request.getParameter("edit");
%>
<body>
<div class="container py-4">
   <%@ include file="menu.jsp"%>	

   <div class="p-5 mb-4 bg-body-tertiary rounded-3">
      <div class="container-fluid py-5">
        <h1 class="display-5 fw-bold">DVD 편집</h1>
        <p class="col-md-8 fs-4">DVD Editing</p>      
      </div>
    </div>
    <%@ include file="dbconn.jsp" %>
     <div class="row align-items-md-stretch   text-center">
	<%
		/* Request request; 
		res = request.exec();
		Dto = new Dto(res); */
	
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				
				String sql = "select * from dvd_tbl";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while (rs.next()) {
			%>
      
	
	
     	<div class="col-md-4">
       		<div class="h-100 p-2 round-3">		
       		    <img src="./resources/images/<%=rs.getString("dvd_thumbnailUrl")%>" style="width: 250; height:350" />	
				<p><h5><b><%=rs.getString("dvd_name")%></b></h5>
				<p><%=rs.getString("dvd_author")%>
				<br> <%=rs.getString("dvd_publisher")%> | <%=rs.getString("dvd_releaseDate")%>
				<p> <%=rs.getString("dvd_description").substring(0,60)%>....
				<p><%=rs.getString("dvd_unitPrice")%>원
				<p><%
						if (edit.equals("update")) {
					%>
					<a href="./updateBook.jsp?id=<%=rs.getString("dvd_id")%>" class="btn btn-success" role="button"> 수정 &raquo;></a>
					
					<%
						} else if (edit.equals("delete")) {
					%>
					<a href="#" onclick="deleteConfirm('<%=rs.getString("dvd_id")%>')" class="btn btn-danger" role="button">삭제 &raquo;></a>
					<%
						}
					%>	
			</div>	
		</div>			
		<%
			}
			 
              if (rs != null)
                  rs.close();
              if (pstmt != null)
                  pstmt.close();
              if (conn != null)
                  conn.close();
		%>
	
		</div>	
		<%@ include file="footer.jsp"%>   
  </div>
</body>
</html>
