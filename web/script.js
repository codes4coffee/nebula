var enableClientSideValidation = false;

function regValidate() {
    if (enableClientSideValidation) {
        var username = document.forms["regform"]["username"].value;
        var password = document.forms["regform"]["password"].value;
        var rpassword = document.forms["regform"]["retry-password"].value;

        if (username == "") {
            alert("Please enter a username!");
            document.forms["regform"]["username"].focus();
            return false;
        } else if (password == "") {
            alert("Please enter your password!");
            document.forms["regform"]["password"].focus();
            return false;
        } else if (rpassword == "") {
            alert("Please re-enter your password.");
            document.forms["regform"]["retry-password"].focus();
            return false;
        } else if (password != rpassword) {
            alert("Your passwords do not match.");
            document.forms["regform"]["password"].focus();
            return false;
        }
    }
}

function loginValidate() {
    if (enableClientSideValidation) {
        var username = document.forms["loginform"]["username"].value;
        var password = document.forms["loginform"]["password"].value;

        if (username == "") {
            alert("Please enter a username!");
            document.forms["loginform"]["username"].focus();
            return false;
        } else if (password == "") {
            alert("Please enter your password!");
            document.forms["loginform"]["password"].focus();
            return false;
        } else if (rpassword == "") {
            alert("Please re-enter your password.");
            document.forms["loginform"]["retry-password"].focus();
            return false;
        } else if (password != rpassword) {
            alert("Your passwords do not match.");
            document.forms["loginform"]["password"].focus();
            return false;
        }
    }
}
