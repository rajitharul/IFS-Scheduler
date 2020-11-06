<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>

<head>
    <title>Update Training Session form</title>


</head>

<body>

<h1>Update Training Session</h1>

<form:form action = "updateTrainingSession" modelAttribute = "trainingSession">


Session ID : <form:input path = "sessionId" />
<br><br>

Session Name : <form:input path = "sessionName" />
<br><br>

ifsApplicationVersion : <form:input path = "ifsApplicationVersion" />

<br><br>

duration : <form:input path = "duration" />

<br><br>

maxParticipants : <form:input path = "maxParticipants" />

<br><br>

managerComment : <form:input path = "managerComment" />

<br><br>

deliveryMethod : <form:input path = "deliveryMethod" />

<br><br>

date : <form:input path = "startDate" />

<br><br>


Please Choose the trainers for this event 

<br><br>
<br><br>

Amila <form:checkbox path = "trainerids" value = "1"/>
Dulitha <form:checkbox path = "trainerids" value = "2"/>


I3 Machine <form:checkbox path = "vmIds" value = "1"/>
I5 Machine <form:checkbox path = "vmIds" value = "2"/>



<input type="submit" value = "Submit" />


</form:form>

</body>



</html>