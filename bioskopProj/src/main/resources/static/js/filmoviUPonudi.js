$(document).ready(function(){
	$.ajax({
		type:"GET",
		url:"http://localhost:8080/api/filmoviUPonudi",
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
				 
	             row+="</tr>";
	             row+="<br>";
	             
	             $('#filmoviUPonudi').append(row);
			}
		},
		error:function(data){
			console.log("ERROR:",data);
		}
	});
});



