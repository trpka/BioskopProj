
$(document).on("submit","form",function(event){
	event.preventDefault();
	
	var userName=$("#userName").val();
	var password=$("#password").val();
	var name=$("#name").val();
	var surname=$("#surname").val();
	var contactTel=$("#contactTel").val();
	var email=document.getElementById("email").value;
	var Date=$("#Date").val();
	
	var newKorisnikJSON=formToJSON(userName,password,name,surname,contactTel,email,Date);
	
	$.ajax({
		type:"POST",
		url:"http://localhost:8080/api/registracijaMenadzera",
		dataType:"json",
		contentType:"application/json",
		data:newKorisnikJSON,
		success:function(){
			alert(name+" "+surname+" je uspesno registrovan kao menadzer");
			window.location.href="prijava.html";
		},
		error:function(data){
			alert("Greska! Pokušajte ponovo.");
		}
	});
	
});

function formToJSON(userName,password,name,surname,contactTel,email,Date){
	return JSON.stringify({
		"userName":userName,
		"password,":password,
		"name":name,
		"surname":surname,
		"contactTel":contactTel,
		"email":email,
		"Date":Date
	});
}