<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>

<head>
    <title>Create Leave Application form</title>


</head>

<body>

<h1>Create Leave Application </h1>

<form:form action = "saveLeaveApplication" modelAttribute = "leaveApplication">


<br><br>

Date : <form:input path = "date" />

<br><br>

duration : <form:input path = "duration" />

<br><br>

Trainer Id : <form:input path = "trainerid" />

<br><br>


<input type="submit" value = "Submit" />



</form:form>

</body>



</html>