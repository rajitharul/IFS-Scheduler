<%@ taglib  uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
<head>
<title>List Leave Applications </title>
<!-- reference out style sheet -->


</head>
<body>

<div id = "wrapper">
<div id = "header">
<h2>Leave Applications</h2>

</div>
</div>

<div id  ="container">

<div id = "content">
	<!-- add our html table here  -->
	
	
	<table>
	
	<tr>
		<th> Leave Date </th>
		<th> Duration </th>
		<th> Trainer Id </th>
		
		
	</tr>
	
		<!-- loop over and print our customers  -->
	
	<c:forEach var = "tempLeaveApplication" items ="${leaveApplications}">
		
	<tr>
		<td> ${tempLeaveApplication.date} </td>
		<td> ${tempLeaveApplication.duration} </td>
		<td> ${tempLeaveApplication.trainer.name} </td>

		
	</tr>
	</c:forEach>
	</table>
	
	
	
</div>

</div>



</body>



</html>