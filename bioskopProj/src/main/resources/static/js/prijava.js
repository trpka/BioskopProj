$(document).on("submit","form",function(event){
	event.preventDefault();
	var userName=$("#userName").val();
	var password=$("#password").val();
	
	var newKorisnikJSON=formToJSON(userName,password);
	
	$.ajax({
		type:"POST",
		url:"http://localhost:8080/api/prijava",
		dataType:"json",
		contentType:"application/json",
		data:newKorisnikJSON,
		success:function(data){
			console.log("SUCCESS: ",data);
			alert(userName + " je uspesno uspeo da se prijavi");
			window.location.href="index.html";
		},
		error:function(data){
			console.log("ERROR: ",data);
			alert("Greska");
		}
	});
});

function formToJSON(userName,password){
	return JSON.stringify({
		"userName":userName,
		"password":password	
	});
}