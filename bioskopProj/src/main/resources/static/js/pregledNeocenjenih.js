$(document).ready(function(){
	$.ajax({
		type:"GET",
		url:"http://localhost:8080/api/pregledNeocenjenih",
		dataType:"json",
		success:function(data){
			console.log("SUCCESS:",data);
			for(i=0;i<data.length;i++){
				var row="<tr>";
				row+="<td>"+data[i]['naziv']+"</td>";
				row+="<td>"+data[i]['opis']+"</td>"
				row+="<td>"+data[i]['zanr']+"</td>";
				row+="<td>"+data[i]['trajanje']+"</td>";
				row+="<td>"+data[i]['ocena']+"</td>";
				
				 var btn = "<button class='oceni' id = " + data[i]['id'] + ">Oceni</button>";
	             row += "<td>" + btn + "</td>"; 
	             row+="</tr>";
	             row+="<br>";
	             
	             $('#pregledNeocenjenih').append(row);
			}
		},
		error:function(data){
			console.log("ERROR:",data);
		}
	});
});
$(document).on('click', '.oceni', function () {       
	 
 $.ajax({
     type: "GET",
     url: "http://localhost:8080/api/oceniFilm/" + this.id,  
     dataType: "json",
     success: function (data) {
     	console.log("SUCCESS : ", data);
     	var row="<label for='id'><b>id</b></label><input type='text'   id='id'  value="+data['id']+"  disabled='disabled'>"+"<label for='ocena'><b>Ocena</b></label><input type='text'   id='ocena' value="+data['ocena']+">"; 
     	row+="<button type='submit' class='oceniFilm'>Oceni film</button>";
 
     	$('#naslov').hide();
     	 $('#ocenjivanje').append(row);
     	$('#pregledNeocenjenih').hide();
     },
     error: function (data) {
     	alert("Doslo je do greske");
         console.log("ERROR : ", data);
     }
 });
});

$(document).on('click', '.oceniFilm', function () {       
    
	var id=$("#id").val();
	var ocena=$("#ocena").val();
	
	var newSalaJSON=formToJSON2(id,ocena);

$.ajax({
		type:"POST",
		url:"http://localhost:8080/api/ocena",
		dataType:"json",
		contentType:"application/json",
		data:newSalaJSON,
		success:function(){
			alert("Film je uspesno ocenjen");
			window.location.href="pregledNeocenjenih.html";
		},
		error:function(data){
			alert("Greska! Pokušajte ponovo.");
		}
	});
	});

function formToJSON2(id,ocena){
	return JSON.stringify({
		"id":id,
		"ocena":ocena
	});
}
