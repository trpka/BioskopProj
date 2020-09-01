$(document).ready(function(){
	$.ajax({
		type:"GET",
		url:"http://localhost:8080/api/pregledBioskopa",
		dataType:"json",
		success:function(data){
			console.log("SUCCESS:",data);
			for(i=0;i<data.length;i++){
				var row="<tr>";
				row+="<td>"+data[i]['naziv']+"</td>";
				row+="<td>"+data[i]['adresa']+"</td>"
				row+="<td>"+data[i]['email']+"</td>";
				row+="<td>"+data[i]['brCentrale']+"</td>";
				
				
				 var btn = "<button class='obrisiBioskop' id = " + data[i]['id'] + ">Obrisi</button>";
	              row += "<td>" + btn + "</td>"; 
	              var izmena = "<button class='izmeniBioskop' id = " + data[i]['id'] + ">Izmeni</button>";
	              row += "<td>" + izmena + "</td>"; 
	              row+="</tr>";
	             row+="<br>";
	             
	             $('#pregledBioskopa').append(row);

			}
		},
		error:function(data){
			console.log("ERROR:",data);
		}
	});
});

$(document).on('click', '.obrisiBioskop', function () {       
    

 
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/obrisiBioskop/" + this.id,  
        dataType: "json",
        success: function (data) {
        	console.log("SUCCESS : ", data);
        	alert("Bioskop je uspesno obrisan");
        	location.reload(true);   
        },
        error: function (data) {
        	alert("Doslo je do greske");
            console.log("ERROR : ", data);
        }
    });
});
$(document).on('click', '.izmeniBioskop', function () {       
     
 $.ajax({
      type: "GET",
      url: "http://localhost:8080/api/izmeniBioskop/" + this.id,  
      dataType: "json",
      success: function (data) {
      	console.log("SUCCESS : ", data);
      	var row="<label for='id'><b>id</b></label><input type='text'   id='id'  value="+data['id']+"  disabled='disabled'>"+"<label for='naziv'><b>Naziv</b></label><input type='text'   id='naziv' value="+data['naziv']+">" +
      	"<label for='adresa'><b>Adresa</b></label><input type='text'   id='adresa'  value="+data['adresa']+">"+"<label for='email'><b>Email</b></label><input type='text'   id='email'  value="+data['email']+">"
      	+"<label for='brCentrale'><b>Broj centrale</b></label><input type='text'   id='brCentrale'  value="+data['brCentrale']+">";
      	row+="<button type='submit' class='izmenaBio'>Izmeni bioskop</button>";
  
      	$('#naslov').hide();
      	 $('#izmenaBioskop').append(row);
      	$('#pregledBioskopa').hide();
      },
      error: function (data) {
      	alert("Doslo je do greske");
          console.log("ERROR : ", data);
      }
  });
});
$(document).on('click', '.izmenaBio', function () {       
    
	var id=$("#id").val();
	var naziv=$("#naziv").val();
	var adresa=$("#adresa").val();
	var brCentrale=$("#brCentrale").val();
	var email=document.getElementById("email").value;

	var newSalaJSON=formToJSON2(id,naziv,adresa,brCentrale,email);

	$.ajax({
		type:"POST",
		url:"http://localhost:8080/api/izmenaBioskop",
		dataType:"json",
		contentType:"application/json",
		data:newSalaJSON,
		success:function(){
			alert("Bioskop je uspesno izmenjen");
			window.location.href="bioskop.html";
		},
		error:function(data){
			alert("Greska! Pokušajte ponovo.");
		}
	});

	});

function formToJSON2(id,naziv,adresa,brCentrale,email){
	return JSON.stringify({
		"id":id,
		"naziv":naziv,
		"adresa":adresa,
		"brCentrale":brCentrale,
		"email":email
	});
}