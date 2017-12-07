function checkUser (username)
{
	var check = new XMLHttpRequest() ;
	check.onreadystatechange = function()
	{
		if(check.readyState == 4&&check.status == 200)
		{
			document.getElementById("checkUsername").innerHTML = check.responseText ;
		}
	}
	check.open("POST","../UserNameCheck?"+"username="+username,true) ;
	check.send() ;
}

function checkEmail (email)
{
	alert(email) ;
	var check = new XMLHttpRequest() ;
	check.onreadystatechange = function()
	{
		if(check.readyState == 4&&check.status == 200)
		{
			document.getElementById("checkEmail").innerHTML = check.responseText ;
		}
	}
	check.open("POST","../EmailCheck?"+"email="+email,true) ;
	check.send() ;
}

