<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>OutputByAuthor</title>
<style>
.error { color: red; } .success { color:${param.color}; }
</style>

</head>

<body>

       <table> 
       <tr><th>Book Title</th></tr>
       ${title}
       </table>

</body>
</html>