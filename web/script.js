function regValidate() {

	var username = document.forms["regform"]["username"].value;
	var password = document.forms["regform"]["password"].value;
	var rpassword = document.forms["regform"]["retry-password"].value;
	
	if (username == "") {
        alert("username must be filled out");
        document.forms["regform"]["username"].focus();
        return false;
    }else if (password== "") {
        alert("password must be filled out");
        document.forms["regform"]["password"].focus();
        return false;
    }else if (rpassword == "") {
        alert("retry-password must be filled out");
        document.forms["regform"]["retry-password"].focus();
        return false;
    }else if(password != rpassword){
    	alert("password doesnt match");
        document.forms["regform"]["password"].focus();
        return false;
    }
}
function loginValidate(){
	var username = document.forms["loginform"]["username"].value;
	var password = document.forms["loginform"]["password"].value;
	
	if (username == "") {
        alert("username must be filled out");
        document.forms["loginform"]["username"].focus();
        return false;
    }else if (password== "") {
        alert("password must be filled out");
        document.forms["loginform"]["password"].focus();
        return false;
    }else if (rpassword == "") {
        alert("retry-password must be filled out");
        document.forms["loginform"]["retry-password"].focus();
        return false;
    }else if(password != rpassword){
    	alert("password doesnt match");
        document.forms["loginform"]["password"].focus();
        return false;
    }
}
