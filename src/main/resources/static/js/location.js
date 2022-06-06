$(document).ready(function() {
	$("#countries").change(function() {
		var countryId = $(this).val();
		var s = '<option value=' + -1 + '>Select Department</option>';
		var s1 = '<option value=' + -1 + '>Select Province</option>';
		if (countryId > 0) {
			$.ajax({
				url: '/location/loadDeparmentByCountry/' + countryId,
				success: function(result) {
					var result = JSON.parse(result);
					for (var i = 0; i < result.length; i++) {
						s += '<option value="' + result[i].id + '">' + result[i].name + '</option>';
					}
					$('#department').html(s);
				}
			});
		}
		//reset data
		$('#department').html(s);
		$('#province').html(s1);
	});

	$("#department").change(function() {
		var departmentId = $(this).val();
		var s = '<option value=' + -1 + '>Select Province</option>';
		if (departmentId > 0) {
			$.ajax({
				url: '/location/loadProvinceByDeparment/' + departmentId,
				success: function(result) {
					var result = JSON.parse(result);
					for (var i = 0; i < result.length; i++) {
						s += '<option value="' + result[i].id + '">' + result[i].name + '</option>';
					}
					$('#province').html(s);
				}
			});
		}
		//reset data
		$('#province').html(s);
	});
});