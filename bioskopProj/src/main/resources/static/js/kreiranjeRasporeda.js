$(document).on("submit","form",function(event){
	event.preventDefault();
	
	var dan=$("#dan").val();
	var vreme=$("#vreme").val();

	
	var newKorisnikJSON=formToJSON(dan,cena,vreme);
	
	$.ajax({
		type:"POST",
		url:"http://localhost:8080/api/kreiranjeRasporeda",
		dataType:"json",
		contentType:"application/json",
		data:newKorisnikJSON,
		success:function(){
			alert("Novi raspored  je uspesno kreiran");
			window.location.href="bioskop.html";
		},
		error:function(data){
			alert("Greska! Pokušajte ponovo.");
		}
	});
	
});

function formToJSON(dan,cena,vreme){
	return JSON.stringify({
		"dan":dan,
		"vreme":vreme
	});
}
	
