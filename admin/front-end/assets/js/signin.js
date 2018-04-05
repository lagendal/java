function sighIn(){
	var login=document.getElementById("login").value;
	var password=document.getElementById("password").value;
	if (login.length == 0){
		alert("Введите логин");
		return;
	}
	if (password.length ==0){
		alert("Введите пароль");
		return;
	}
	$.ajax({
		success:function(data){
			console.log(data);
		},
		error:function(err){
			console.log(err);
		},
		url: "localhost:9000/signin",
		type: "POST",
		data: JSON.stringify({
			login: login,
			password: password
		})
	});
}