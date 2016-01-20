function formValidation() {
	var uname = document.Register_employee.name;
	var ucont = document.Register_employee.contact;
	var uemail = document.Register_employee.mail;
	var uloginid = document.Register_employee.loginid;
	var passid = document.Register_employee.password;
	var udob = document.Register_employee.dob;

	{
		if (allLetter(uname)) {
			if (Contactvalid(ucont, 10)) {
					if (ValidateEmail(uemail)) {
						if (loginid_validation(uloginid, 2, 4)) {
							if (passid_validation(passid, 7, 12)) {
								if (Validate_DOB(udob)) {
								}
							}
						}
					}
				}
			}
		}
	

	return false;

}
	
	function allLetter(uname) {
		var letters = /^[A-Za-z]+$/;
		if (uname.value.match(letters)) {
			return true;
		} else {
			alert('Username must have alphabet characters only');
			uname.focus();
			return false;
		}
	}

	function alphanumeric(uadd) {
		var letters = /^[0-9a-zA-Z]+$/;
		if (uadd.value.match(letters)) {
			return true;
		} else {
			alert('User address must have alphanumeric characters only');
			uadd.focus();
			return false;
		}
	}

	function Contactvalid(ucont, mn) {
		var cont_len = ucont.value.length;
		var exp = '/^[0-9\+\-]{7,}$/';

		if (cont_len == 0 || cont_len < 10 || ucont.value.match(exp)) {
			alert("Contact number should not be empty / it should have 10 numbers");
			ucont.focus();
			return false;
		}
		return true;
	}

	function ValidateEmail(uemail) {
		var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
		if (uemail.value.match(mailformat)) {
			return true;
		} else {
			alert("You have entered an invalid email address!");
			uemail.focus();
			return false;
		}
	}

	function loginid_validation(uloginid, min, max) {

		// alert(uloginid.value.length);
		var loginid = uloginid.value.length;
		if (loginid == 0 || uloginid.value.length < 2 || uloginid.value.length > 4) {

			alert("Login Id should not be empty / length be between 2 and 4");
			uloginid.focus();
			return false;

		} else {
			return true;

		}
	}

	function passid_validation(passid, mx, my) {

		if (passid.value.length == 0 || passid.value.length < 7
				|| passid.value.length > 12) {
			alert("Password should not be empty / length be between 7 to 12");
			passid.focus();
			return false;
		} else {
			return true;
		}
	}

	function Validate_DOB(udob) {
		var allowBlank = " ";
		var minYear = 1902;
		var maxYear = (new Date()).getFullYear();

		var errorMsg = "";

		// regular expression to match required date format
		re = /^(\d{4})-(\d{1,2})-(\d{1,2})$/;

		if (udob.value != '') {
			if (regs = udob.value.match(re)) {
				if (regs[3] < 1 || regs[3] > 31) {
					errorMsg = "Invalid value for day: " + regs[3];
				} else if (regs[2] < 1 || regs[2] > 12) {
					errorMsg = "Invalid value for month: " + regs[2];
				} else if (regs[1] < minYear || regs[1] > maxYear) {
					errorMsg = "Invalid value for year: " + regs[1]
							+ " - must be between " + minYear + " and " + maxYear;
				}
			} else {
				errorMsg = "Invalid date format: " + udob.value;
			}
		} else if (allowBlank) {
			errorMsg = "Empty date not allowed!";
		}

		if (errorMsg != "") {
			alert(errorMsg);
			udob.focus();
			return false;

		}
		else
			{
			window.navigate("Register_done_employee.jsp");
			return true;
			}
	}
