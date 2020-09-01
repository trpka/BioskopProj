$(document).ready(function(){
    $("#pretrazeno").hide();
});


$(document).on("submit","form",function(event){
	event.preventDefault();
	$(".container").hide();
	var naziv=$("#naziv").val();
	var opis=$("#opis").val();
	var zanr=$("#zanr").val();
	var ocena=$("#ocena").val();
	var dan=$("#dan").val();
	var cena=$("#cena").val();
	
	var newKorisnikJSON=formToJSON(naziv,opis,zanr,ocena,dan,cena);
	
	$.ajax({
		type:"POST",
		url:"http://localhost:8080/api/filmoviPretraga",
		dataType:"json",
		contentType:"application/json",
		data:newKorisnikJSON,
		success:function(data){
			for(i=0;i<data.length;i++){
				var row="<tr>";
				row+="<td>"+data[i]['naziv']+"</td>";
				row+="<td>"+data[i]['opis']+"</td>"
				row+="<td>"+data[i]['zanr']+"</td>";
				row+="<td>"+data[i]['ocena']+"</td>";
				row+="<td>"+data[i]['dan']+"</td>"
				row+="<td>"+data[i]['cena']+"</td>";
				
	             row+="</tr>";
	             row+="<br>";
	             
	             $('#pretrazeno').append(row);
			}
			
			$("#pretrazeno").show();
		},
		error:function(data){
			alert("Nema pronadjenih filmova!");
			window.location.href="filmoviPretraga.html";
		}
	});
	
});

function formToJSON(naziv,opis,zanr,ocena,dan,cena){
	return JSON.stringify({
		"naziv":naziv,
		"opis,":opis,
		"zanr":zanr,
		"ocena":ocena,
		"dan":dan,
		"cena":cena
	});
}
	
