<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Order Status</title>
</head>
<body>

	<h1>Update Order Status</h1>

	<div>

		<form action="changeStatus" method="post">
			<p>
				<label for="orderId">Order Id: </label> <input id="orderId"
					value="orderId" readonly="readonly" />
			</p>
			<p>
				<label for="customerName">Customer Name: </label> <input
					id="customerName" value="customerName" readonly="readonly" />
			</p>

			<table class="table">
				<tbody>
					<tr>
						<th>Items</th>
						<th>Units</th>
						<th>Price per Unit</th>
						<th>Total Price</th>
					</tr>
					<tr>
						<td>T-shirt</td>
						<td>2</td>
						<td>5</td>
						<td>10</td>
					</tr>

				</tbody>
			</table>

			<p>
				<label for="status">Status: </label> 
				<select id="status" name="status">
					<option value="Processing">Processing</option>
					<option value="Pick up">Pick up</option>
					<option value="Printing">Printing</option>
					<option value="Delivery">Delivery</option>
					<option value="Completed">Completed</option>
				</select>
					
			</p>

		</form>


	</div>

</body>
</html>