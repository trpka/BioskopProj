$(document).ready(function(){
	$.ajax({
		type:"GET",
		url:"http://localhost:8080/api/izmenaBrisanjeSala",
		dataType:"json",
		success:function(data){
			console.log("SUCCESS:",data);
			for(i=0;i<data.length;i++){
				var row="<tr>";
				
				row+="<td>"+data[i]['kapacitet']+"</td>";
				row+="<td>"+data[i]['oznaka']+"</td>"
				
				var btn = "<button class='obrisiSalu' id = " + data[i]['id'] + ">Obrisi</button>";
	              row += "<td>" + btn + "</td>"; 
	              var izmena = "<button class='izmeniSalu' id = " + data[i]['id'] + ">Izmeni</button>";
	              row += "<td>" + izmena + "</td>"; 
	              row+="</tr>";
	             row+="<br>";
	             
	             $('#izmenaBrisanjeSala').append(row);

			}
		},
		error:function(data){
			console.log("ERROR:",data);
		}
	});
});

$(document).on('click', '.obrisiSalu', function () {       
    

	 
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/obrisiSalu/" + this.id,  
        dataType: "json",
        success: function (data) {
        	console.log("SUCCESS : ", data);
        	alert("Sala je uspesno obrisana");
        	//location.reload(true);
        	
                           
        	window.location.href="izmenaBrisanjeSala.html";
        },
        error: function (data) {
        	alert("Doslo je do greske");
            console.log("ERROR : ", data);
        }
    });
});

$(document).on('click', '.izmeniSalu', function () {       
    
	 //$('#pregledSala').hide();
	 
   $.ajax({
       type: "GET",
       url: "http://localhost:8080/api/izmeniSalu/" + this.id,  
       dataType: "json",
       success: function (data) {
       	console.log("SUCCESS : ", data);
       	var row="<label for='id'><b>id</b></label><input type='text'   id='id'  value="+data['id']+"  disabled='disabled'>"+"<label for='kapacitet'><b>Kapacitet</b></label><input type='text'   id='kapacitet' value="+data['kapacitet']+">" +
       	"<label for='oznaka'><b>Oznaka</b></label><input type='text'   id='oznaka'  value="+data['oznaka']+">";
       	row+="<button type='submit' class='izmena'>Izmeni salu</button>";
   
       	$('#naslov').hide();
       	 $('#izmenaSale').append(row);
       	$('#izmenaBrisanjeSala').hide();
       },
       error: function (data) {
       	alert("Doslo je do greske");
           console.log("ERROR : ", data);
       }
   });
});

$(document).on('click', '.izmena', function () {       
    
	var id=$("#id").val();
	var kapacitet=$("#kapacitet").val();
	var oznaka=$("#oznaka").val();



	var newSalaJSON=formToJSON2(id,kapacitet,oznaka);

	$.ajax({
		type:"POST",
		url:"http://localhost:8080/api/izmena",
		dataType:"json",
		contentType:"application/json",
		data:newSalaJSON,
		success:function(){
			alert("Nova sala je uspesno izmenjena!");
			window.location.href="izmenaBrisanjeSala.html";//menjao sam 
		},
		error:function(data){
			alert("Greska! Pokušajte ponovo.");
		}
	});

	});

function formToJSON2(id,kapacitet,oznaka){
	return JSON.stringify({
		"id":id,
		"kapacitet":kapacitet,
		"oznaka":oznaka
		
	});
}

