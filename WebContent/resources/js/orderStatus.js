"use strict"
$(function() {
	$('#changeStatus').click(function() {
		var selectedOrder = $('#orderId').val();
		var selectedStatus = $("#status").val();
		updateOrderStatus(selectedStatus, selectedOrder);
	});
	
	function updateOrderStatus(status, orderId) {
		$.ajax({
			url: '/MagicClothingPrinting/orderId/' + orderId +'/changeStatus/'+ status,
			type: 'PUT',
			async:false,
			dataType: "json",
			data:'name=' + name,
			success: function (response) {
				location.reload(true);
			},
			error: function(){
				notifyAjaxFailure

			} 
		});
	}
	
})

