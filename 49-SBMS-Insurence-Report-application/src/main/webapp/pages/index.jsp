<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Reports Application</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/css/bootstrap.min.css" rel="stylesheet"
		integrity="sha384-SgOJa3DmI69IUzQ2PVdRZhwQ+dy64/BUtbMJw1MZ8t5HZApcHrRKUc4W0kG879m7"
		crossorigin="anonymous">
</head>
<body>
<div class="container py-5">
	<div class="card shadow">
		<div class="card-header bg-primary text-white">
			<h4 class="mb-0">Insurance Form</h4>
		</div>
		<div class="card-body">
			<form:form action="search" modelAttribute="search" method="POST">
				<div class="row mb-3">
					<div class="col-md-4">
						<label class="form-label">Plan Name:</label>
						<form:select path="planName" cssClass="form-select">
							<form:option value="">Select</form:option>
							<form:options items="${names}"/>
						</form:select>
					</div>
					<div class="col-md-4">
						<label class="form-label">Plan Status:</label>
						<form:select path="planStatus" cssClass="form-select">
							<form:option value="">Select</form:option>
							<form:options items="${status}"/>
						</form:select>
					</div>
					<div class="col-md-4">
						<label class="form-label">Gender:</label>
						<form:select path="gender" cssClass="form-select">
							<form:option value="">Select</form:option>
							<form:option value="Male">Male</form:option>
							<form:option value="Female">Female</form:option>
						</form:select>
					</div>
				</div>

				<div class="row mb-3">
					<div class="col-md-6">
						<label class="form-label">Start Date:</label>
						<form:input path="planStartDate" type="date" cssClass="form-control"/>
					</div>
					<div class="col-md-6">
						<label class="form-label">End Date:</label>
						<form:input path="planEndDate" type="date" cssClass="form-control"/>
					</div>
				</div>

				<div class="text-end">
					<button type="submit" class="btn btn-success">Search</button>
				</div>
			</form:form>
		</div>
	</div>

	<!-- Export Buttons -->
	<div class="mt-4 text-end">
		<span class="me-2 fw-bold">Export:</span>
		<a href="/export/pdf" class="btn btn-outline-danger btn-sm me-2">PDF</a>
		<a href="excel" class="btn btn-outline-success btn-sm">Excel</a>
	</div>

	<!-- Result Table -->
	<div class="table-responsive mt-4">
		<table class="table table-dark table-hover">
			<thead class="table-dark">
				<tr>
					<th>ID</th>
					<th>Holder Name</th>
					<th>Plan Name</th>
					<th>Plan Status</th>
					<th>Start Date</th>
					<th>End Date</th>
					<th>Benefit Amount</th>
					
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${plans}" var="plan">
					<tr>
						<td>${plan.citizenId}</td>
						<td>${plan.citizenName}</td>
						<td>${plan.planName}</td>
						<td>${plan.planStatus}</td>
						<td>${plan.planStartDate}</td>
						<td>${plan.planEndDate}</td>
						<td>${plan.benefitAmt}</td>
						
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-k6d4wzSIapyDyv1kpU366/PK5hCdSbCRGRCMv+eplOQJWyd1fbcAu9OCUj5zNLiq"
	crossorigin="anonymous"></script>
</body>
</html>
