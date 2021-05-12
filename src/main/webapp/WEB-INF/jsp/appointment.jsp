<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Appointment</title>

<script src="static/js/bootstrap.min.js"></script>
<link href="static/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>


	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="row">
					<div class="col-md-6">
						<form class="form-horizontal" action="appointment" method="POST">
							<fieldset>

								<!-- Form Name -->
								<legend>Appointment Add</legend>

								<!-- Text input-->
								<div class="form-group">
									<label class="col-md-4 control-label" for="id">ID</label>
									<div class="col-md-4">
										<input id="id" name="id" type="number" placeholder=""
											class="form-control input-md">

									</div>
								</div>

								<!-- Text input-->
								<div class="form-group">
									<label class="col-md-4 control-label" for="problem">Problem</label>
									<div class="col-md-4">
										<input id="problem" name="problem" type="text" placeholder=""
											class="form-control input-md">

									</div>
								</div>

								<!-- Text input-->
								<div class="form-group">
									<label class="col-md-4 control-label" for="patient">PatientId</label>
									<div class="col-md-4">
										<input id="patient" name="patient" type="number"
											placeholder="" class="form-control input-md">

									</div>
								</div>
								<!-- Text input-->
								<div class="form-group">
									<label class="col-md-4 control-label" for="doctor">DoctorId</label>
									<div class="col-md-4">
										<input id="doctor" name="doctor" type="number" placeholder=""
											class="form-control input-md">

									</div>
								</div>
								<div class="form-group">
									<label class="col-md-4 control-label" for="date">Date</label>
									<div class="col-md-4">
										<input id="date" name="date" type="text" placeholder=""
											class="form-control input-md">

									</div>
								</div>
								<!-- Button -->
								<div class="form-group">
									<label class="col-md-4 control-label" for="add"></label>
									<div class="col-md-4">
										<input type="submit" class="btn btn-info"
											value="Add Appointment">
									</div>
								</div>

							</fieldset>
						</form>
					</div>
					<div class="col-md-6"></div>
				</div>

				<div class="row">
					<div class="col-md-6">
						<legend> List</legend>
						<div class="table-responsive">
							<table id="appointment"
								class="table table-striped table-bordered">

								<thead>
									<tr>
										<th>ID</th>
										<th>Problem</th>
										<th>PatientId</th>
										<th>DoctorId</th>
										<th>Date</th>
								
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${allAppointments}" var="appointment">
										<tr>
											<td><c:out value="${appointment.id}" /></td>
											<td><c:out value="${appointment.problem}" /></td>
											<td><c:out value="${appointment.patient}" /></td>
											<td><c:out value="${appointment.doctor}" /></td>
											<td><c:out value="${appointment.date}" /></td>
										<tr>
									</c:forEach>

								</tbody>
							</table>
						</div>
					</div>
					<div class="col-md-6"></div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>
