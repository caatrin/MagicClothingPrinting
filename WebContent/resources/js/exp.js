"use strict"
$(function() {

	$('#name').change(function() {
		var selectedValue = $("#name").val();
		findItem(selectedValue);
	});

	function findItem(name) {
		$.ajax({
			url: '/MagicClothingPrinting/getItem',
			type: 'GET',
			async:false,
			dataType: "json",
			data:'name=' + name,
			success: function (response) {
				addName(response);
			},
			error: function(){
				notifyAjaxFailure

			} 
		});
	}
	function addName(response) {
		if (response) {
			var data = response;
			$('#price').val(data.price);

		}
	}
	function notifyAjaxFailure() {
		console.log("Error: ajax failure");
	}

	$('#units').change(function() {
		var units = $("#units").val();
		var price = $('#price').val();
		setTotalPrice(units, price);
	});
	
	function setTotalPrice(units, price) {
		 $("#totalPrice").val(units * price);
	}


})