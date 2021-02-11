<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Agile Dashboard</title>
<!--===============================================================================================-->
	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="SaveChanges/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="SaveChanges/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="SaveChanges/fonts/iconic/css/material-design-iconic-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="SaveChanges/vendor/animate/animate.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="SaveChanges/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="SaveChanges/vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="SaveChanges/vendor/select2/select2.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="SaveChanges/vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="SaveChanges/vendor/noui/nouislider.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="SaveChanges/css/util.css">
	<link rel="stylesheet" type="text/css" href="SaveChanges/css/main.css">
<!--===============================================================================================-->
</head>
<body>

	

	<div class="container-contact100">
		<div class="wrap-contact100">
			<form class="contact100-form validate-form" action= "saveDetails" method="post">
				<span class="contact100-form-title">
					Edit Task
				</span>
				
				<input type="hidden" name="id" value="${task.id}">
				<div class="wrap-input100 validate-input bg1" data-validate="Please Type Your Name">
					<span class="label-input100">TASK NAME *</span>
					<input class="input100" type="text" value="<c:out value= "${task.name}"/>"name="name" placeholder="Enter Your Name">
				</div>

				<div class="wrap-input100 validate-input bg1 rs1-wrap-input100">
					<span class="label-input100">ISSUED Date *</span>
					<input class="input100" type="text" value="<c:out value= "${task.issuedDate}"/>" name="issued_date" placeholder="Issued Date ">
				</div>

				<div class="wrap-input100 bg1 rs1-wrap-input100">
					<span class="label-input100">LAST DATE</span>
					<input class="input100" type="text" value="<c:out value= "${task.lastDate}"/>" name="last_date" placeholder="LAST DATE">
				</div>
				
				

				<div class="w-full dis-none js-show-service">
					<div class="wrap-contact100-form-radio">
						<span class="label-input100">What type of products do you sell?</span>

						<div class="contact100-form-radio m-t-15">
							<input class="input-radio100" id="radio1" type="radio" name="type-product" value="physical" checked="checked">
							<label class="label-radio100" for="radio1">
								Phycical Products
							</label>
						</div>

						<div class="contact100-form-radio">
							<input class="input-radio100" id="radio2" type="radio" name="type-product" value="digital">
							<label class="label-radio100" for="radio2">
								Digital Products
							</label>
						</div>

						<div class="contact100-form-radio">
							<input class="input-radio100" id="radio3" type="radio" name="type-product" value="service">
							<label class="label-radio100" for="radio3">
								Services Consulting
							</label>
						</div>
					</div>

					<div class="wrap-contact100-form-range">
						<span class="label-input100">Budget *</span>

						<div class="contact100-form-range-value">
							$<span id="value-lower">610</span> - $<span id="value-upper">980</span>
							<input type="text" name="from-value">
							<input type="text" name="to-value">
						</div>

						<div class="contact100-form-range-bar">
							<div id="filter-bar"></div>
						</div>
					</div>
				</div>

				<div class="wrap-input100 validate-input bg0 rs1-alert-validate" data-validate = "Please Type Your Message">
					<span class="label-input100">Description</span>
					<textarea class="input100" name="description" placeholder="Description here...">${task.description}</textarea>
				</div>

				<div class="container-contact100-form-btn">
					<button class="contact100-form-btn">
						<span>
							Save Changes
							<i class="fa fa-long-arrow-right m-l-7" aria-hidden="true"></i>
						</span>
					</button>
				</div>
			</form>
		</div>
	</div>



<!--===============================================================================================-->
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/select2/select2.min.js"></script>
	<script>
		$(".js-select2").each(function(){
			$(this).select2({
				minimumResultsForSearch: 20,
				dropdownParent: $(this).next('.dropDownSelect2')
			});


			$(".js-select2").each(function(){
				$(this).on('select2:close', function (e){
					if($(this).val() == "Please chooses") {
						$('.js-show-service').slideUp();
					}
					else {
						$('.js-show-service').slideUp();
						$('.js-show-service').slideDown();
					}
				});
			});
		})
	</script>
<!--===============================================================================================-->
	<script src="SaveChanges/vendor/daterangepicker/moment.min.js"></script>
	<script src="SaveChanges/vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="SaveChanges/vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="SaveChanges/vendor/noui/nouislider.min.js"></script>
	<script>
	    var filterBar = document.getElementById('filter-bar');

	    noUiSlider.create(filterBar, {
	        start: [ 1500, 3900 ],
	        connect: true,
	        range: {
	            'min': 1500,
	            'max': 7500
	        }
	    });

	    var skipValues = [
	    document.getElementById('value-lower'),
	    document.getElementById('value-upper')
	    ];

	    filterBar.noUiSlider.on('update', function( values, handle ) {
	        skipValues[handle].innerHTML = Math.round(values[handle]);
	        $('.contact100-form-range-value input[name="from-value"]').val($('#value-lower').html());
	        $('.contact100-form-range-value input[name="to-value"]').val($('#value-upper').html());
	    });
	</script>
<!--===============================================================================================-->
	<script src="js/main.js"></script>

<!-- Global site tag (gtag.js) - Google Analytics -->
<script async src="https://www.googletagmanager.com/gtag/js?id=UA-23581568-13"></script>
<script>
  window.dataLayer = window.dataLayer || [];
  function gtag(){dataLayer.push(arguments);}
  gtag('js', new Date());

  gtag('config', 'UA-23581568-13');
</script>
	

</body>
</html>