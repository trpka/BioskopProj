$(document).ready(function(){
	$.ajax({
		type:"GET",
		url:"http://localhost:8080/api/izmenaRasporedaa",
		dataType:"json",
		success:function(data){
			console.log("SUCCESS:",data);
			for(i=0;i<data.length;i++){
				var row="<tr>";
				
				row+="<td>"+data[i]['dan']+"</td>";
				row+="<td>"+data[i]['vreme']+"</td>";
				
				var btn = "<button class='izmeniRaspored' id = " + data[i]['id'] + ">Izmeni raspored</button>";
	              row += "<td>" + btn + "</td>"; 
	             
	              row+="</tr>";
	              row+="<br>";//ako treba brisi
	             
	             $('#izmenaRasporedaa').append(row);

			}
		},
		error:function(data){
			console.log("ERROR:",data);
		}
	});
});


$(document).on('click', '.izmeniRaspored', function () {       
	 
 $.ajax({
       type: "GET",
       url: "http://localhost:8080/api/izmeniRaspored/" + this.id,  
       dataType: "json",
       success: function (data) {
       	console.log("SUCCESS : ", data);
       	var row="<label for='id'><b>id</b></label><input type='text'   id='id'  value="+data['id']+"  disabled='disabled'>"+"<label for='dan'><b>Dan</b></label><input type='text'   id='dan' value="+data['dan']+">" +
       	"<label for='vreme'><b>Vreme</b></label><input type='text'   id='vreme'  value="+data['vreme']+">";
       	row+="<button type='submit' class='izmenaRasp'>Izmeni raspored</button>";
   
       	$('#naslov').hide();
       	 $('#izmenaRasporeda').append(row);
       	$('#izmenaRasporedaa').hide();
       },
       error: function (data) {
       	alert("Doslo je do greske");
           console.log("ERROR : ", data);
       }
   });
});

$(document).on('click', '.izmenaRasp', function () {       
    
	var id=$("#id").val();
	var dan=$("#dan").val();
	var vreme=$("#vreme").val();


	var newSalaJSON=formToJSON2(id,dan,vreme);

	$.ajax({
		type:"POST",
		url:"http://localhost:8080/api/izmenaRasp",
		dataType:"json",
		contentType:"application/json",
		data:newSalaJSON,
		success:function(){
			alert("Raspored je uspesno izmenjen");
			window.location.href="izmenaRasporedaa.html";
		},
		error:function(data){
			alert("Greska! Pokušajte ponovo.");
		}
	});

	});

function formToJSON2(id,dan,vreme){
	return JSON.stringify({
		"id":id,
		"dan":dan,
		"vreme":vreme
		
	});
}




