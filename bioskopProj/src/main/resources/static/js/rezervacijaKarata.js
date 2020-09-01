$(document).ready(function(){
	$.ajax({
		type:"GET",
		url:"http://localhost:8080/api/rezervacijaKarata",
		dataType:"json",
		success:function(data){
			console.log("SUCCESS:",data);
			for(i=0;i<data.length;i++){
				var row="<tr>";
				
				row+="<td>"+data[i]['dan']+"</td>";
				row+="<td>"+data[i]['vreme']+"</td>";
				row+="<td>"+data[i]['cena']+"</td>"
				
				var btn = "<button class='rezervisiKartu' id = " + data[i]['id'] + ">Rezervisi kartu</button>";
	              row += "<td>" + btn + "</td>"; 
	             
	              row+="</tr>";
	             row+="<br>";
	             
	             $('#rezervacijaKarata').append(row);
			}
		},
		error:function(data){
			console.log("ERROR:",data);
		}
	});
});

$(document).on('click', '.rezervisiKartu', function () {       
    
$.ajax({
        type: "GET",
        url: "http://localhost:8080/api/rezervisi/" + this.id,
        dataType: "json",
        success: function (data) {
        	console.log("SUCCESS : ", data);
        	var row="<label for='id'><b>id</b></label><input type='text'   id='id'  value="+data['id']+"  disabled='disabled'>"+"<label for='rezervisan'><b>Kapacitet</b></label><input type='text'   id='rezervisan' value="+data['rezervisan']+">"               
        	var row2="<button type='submit' class='potvrda' style='color:black'>Potvrdi rezervaciju</button>";
        	$('#podaci').append(row);
        	$('#podaci').hide();
        	$('#potvrdi').append(row2);
        	$('#pregledKarata').hide();
        	$('#naslov').hide();
        	
        },
        error: function (data) {
        	alert("Doslo je do greske");
            console.log("ERROR : ", data);
        }
    });
});
$(document).on('click', '.potvrda', function () {       
    
	var id=$("#id").val();
	var rezervisan=$("#rezervisan").val();
	
	var newSalaJSON=formToJSON2(id,rezervisan);

	$.ajax({
		type:"POST",
		url:"http://localhost:8080/api/potvrdiRezervaciju",
		dataType:"json",
		contentType:"application/json",
		data:newSalaJSON,
		success:function(){
			alert("Karta je uspesno rezervisana");
			window.location.href="rezervacijaKarata.html";
		},
		error:function(data){
			alert("Greska! Pokušajte ponovo.");
		}
	});

	});

function formToJSON2(id,rezervisan){
	return JSON.stringify({
		"id":id,
		"rezervisan":rezervisan
	
		
	});
}