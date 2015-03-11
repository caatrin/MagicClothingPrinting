"use strict"
$(function() {
	
	 $('#name').change(function() {
		 var selectedValue = $("#name").val();
		 findItem(selectedValue);
	 });
	 
		  function findItem(name) {
		        $.post("/MagicClothingPrinting/order/getItem", {
		            "name": name
		        })
		                .done(addName)
		                .fail(notifyAjaxFailure);
		    }

		    function addName(response) {
		        if (response) {
		            var data = response;
		            alert(data.name);
		            console.log(data.name);
		            $('#price').val(data.price);
		       
		        }
		    }
		    
		    function notifyAjaxFailure() {
		        console.log("Error: ajax failure");
		    }
	
	
	
})