<%@ taglib  uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
<head>
<title>List Training Sessions </title>
<!-- reference out style sheet -->


</head>
<body>

<div id = "wrapper">
<div id = "header">
<h2>Training Sessions</h2>

</div>
</div>

<div id  ="container">

<div id = "content">
	<!-- add our html table here  -->
	
	
	<table>
	
	<tr>
		<th> sessionName </th>
		<th> Date</th>
		<th> ifsApplicationVersion </th>
		<th> managerComment</th>
		<th> Trainers</th>
		<th> VM</th>
		
		
	</tr>
	
		<!-- loop over and print our customers  -->
	
	<c:forEach var = "tempTrainingSession" items ="${trainingSessions}">
		
	<tr>
		<td> ${tempTrainingSession.sessionName} </td>
		<td> ${tempTrainingSession.startDate} </td>
		<td> ${tempTrainingSession.ifsApplicationVersion} </td>
		<td> ${tempTrainingSession.managerComment} </td>
			
		
	</tr>
	</c:forEach>
	</table>
	
	
	
</div>

</div>


	<a href ="${pageContext.request.contextPath}/trainingSession/addTrainingSession">Add new Training Session</a>

<br><br>

	<a href ="${pageContext.request.contextPath}/trainingSession/showFormForUpdate">Update Training Session</a>

<br><br><br><br>

	<a href ="${pageContext.request.contextPath}/virtualMachine/addVirtualMachine">Add Virtual Machine</a>


<br><br><br><br>

	<a href ="${pageContext.request.contextPath}/leaveApplication/addLeaveApplication">Add LeaveApplication</a>


</body>



</html>