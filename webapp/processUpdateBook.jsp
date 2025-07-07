<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.oreilly.servlet.*"%>
<%@ page import="com.oreilly.servlet.multipart.*"%>
<%@ page import="java.sql.*"%>
<%@ include file="dbconn.jsp" %>

<%
	request.setCharacterEncoding("UTF-8");


	String filename = "";
	//String realFolder = "C:\\upload"; //웹 어플리케이션상의 절대 경로


	String realFolder = application.getRealPath("/resources/images");
	String encType = "utf-8"; //인코딩 타입
	int maxSize = 5 * 1024 * 1024; //최대 업로드될 파일의 크기5Mb
	
	MultipartRequest multi = new MultipartRequest(request, realFolder, maxSize, encType, new DefaultFileRenamePolicy());

	
	
	String bookId = multi.getParameter("bookId");
	String name = multi.getParameter("name");
	String unitPrice = multi.getParameter("unitPrice");
	String author = multi.getParameter("author");
	String publisher = multi.getParameter("publisher");
	String releaseDate = multi.getParameter("releaseDate");	
	String description = multi.getParameter("description");	
	String category = multi.getParameter("category");
	String unitsInStock = multi.getParameter("unitsInStock");
	String condition = multi.getParameter("condition");

	Enumeration files = multi.getFileNames();
	String fname = (String) files.nextElement();
	String fileName = multi.getFilesystemName(fname);
	
	int price;

	if (unitPrice.isEmpty())
		price = 0;
	else
		price = Integer.valueOf(unitPrice);

	long stock;

	if (unitsInStock.isEmpty())
		stock = 0;
	else
		stock = Long.valueOf(unitsInStock);
	
	
	
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	String sql = "select * from dvd_tbl where dvd_id = ?";
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, bookId);
	rs = pstmt.executeQuery();	
	
	
	if (rs.next()) {		
		if (fileName != null) {
			sql = "UPDATE dvd_tbl SET dvd_name=?, dvd_unitPrice=?, dvd_author=?, dvd_description=?, dvd_publisher=?, dvd_category=?, dvd_unitsInStock=?, dvd_releaseDate=?, dvd_condition=?, dvd_thumbnailUrl=? WHERE dvd_id=?";	
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2, price);
			pstmt.setString(3, author);
			pstmt.setString(4, description);
			pstmt.setString(5, publisher);
			pstmt.setString(6, category);
			pstmt.setLong(7, stock);
			pstmt.setString(8, releaseDate);		
			pstmt.setString(9, condition);	
			pstmt.setString(10, fileName);	
			pstmt.setString(11, bookId);	
			pstmt.executeUpdate();
			
					
		} else {
			sql = "UPDATE dvd_tbl SET dvd_name=?, dvd_unitPrice=?, dvd_author=?, dvd_description=?, dvd_publisher=?, dvd_category=?, dvd_unitsInStock=?, dvd_releaseDate=?, dvd_condition=? WHERE dvd_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2, price);
			pstmt.setString(3, author);
			pstmt.setString(4, description);
			pstmt.setString(5, publisher);
			pstmt.setString(6, category);
			pstmt.setLong(7, stock);
			pstmt.setString(8, releaseDate);		
			pstmt.setString(9, condition);			
			pstmt.setString(10, bookId);	
			pstmt.executeUpdate();
		}		
	}
	

	
	if (pstmt != null)
		pstmt.close();
	if (conn != null)
		conn.close();
	

	response.sendRedirect("editBook.jsp?edit=update");

%>
