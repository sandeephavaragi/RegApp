/**
 * The js has the Registration validation feilds validation rules
 */


	function checkForm(form) {
		
		if (form.username.value == "" || form.username.value.length < 3) {
			alert("Error: Username must at least 3 characters long with only letters and numbers!");
			form.username.focus();
			return false;
		}
		re = /^\w+$/;
		if (!re.test(form.username.value)) {
			alert("Error: Username must at least 3 characters long with only letters and numbers!");
			form.username.focus();
			return false;
		}

		if (form.password.value != ""
				&& form.password.value == form.Retype_password.value) {
			if (form.password.value.length < 8) {
				alert("Error: Password must contain at least 8 characters!");
				form.password.focus();
				return false;
			}
			if (form.password.value == form.username.value) {
				alert("Error: Password must be different from Username!");
				form.password.focus();
				return false;
			}
			re = /[0-9]/;
			if (!re.test(form.password.value)) {
				alert("Error: password must contain at least one number (0-9)!");
				form.password.focus();
				return false;
			}
			re = /[a-z]/;
			if (!re.test(form.password.value)) {
				alert("Error: password must contain at least one lowercase letter (a-z)!");
				form.password.focus();
				return false;
			}
			re = /[A-Z]/;
			if (!re.test(form.password.value)) {
				alert("Error: password must contain at least one uppercase letter (A-Z)!");
				form.password.focus();
				return false;
			}
		} else {
			alert("Error: Password and Retype Password Does not match!");
			form.password.focus();
			return false;
		}

		return true;
	}
