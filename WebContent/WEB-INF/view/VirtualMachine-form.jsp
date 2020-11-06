<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>

<head>
    <title>Add Virtual Machine</title>

</head>

<body>

<h1>Add Virtual Machine</h1>

<form:form action = "saveVirtualMachine" modelAttribute = "virtualMachine">

Product : <form:input path = "product" />
<br><br>

Version : <form:input path = "version" />
<br><br>

Region : <form:input path = "region" />

<br><br>

Status : <form:input path = "status" />

<br><br>

<input type="submit" value = "Submit" />


</form:form>

</body>



</html>