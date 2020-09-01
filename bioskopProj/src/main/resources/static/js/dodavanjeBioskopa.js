$(document).on("submit","form",function(event){
	event.preventDefault();
	
	var naziv=$("#naziv").val();
	var adresa=$("#adresa").val();
	var brCentrale=$("#brCentrale").val();
	var email=document.getElementById("email").value;

	
	var newKorisnikJSON=formToJSON(naziv,adresa,brCentrale,email);
	
	$.ajax({
		type:"POST",
		url:"http://localhost:8080/api/dodavanjeBioskopa",
		dataType:"json",
		contentType:"application/json",
		data:newKorisnikJSON,
		success:function(){
			alert("Novi bioskop je uspesno dodat!");
			window.location.href="bioskop.html";
		},
		error:function(data){
			alert("Greska! Pokušajte ponovo.");
		}
	});
	
});

function formToJSON(naziv,adresa,brCentrale,email){
	return JSON.stringify({
		"naziv":naziv,
		"adresa":adresa,
		"brCentrale":brCentrale,
		"email":email
	});
}
	
