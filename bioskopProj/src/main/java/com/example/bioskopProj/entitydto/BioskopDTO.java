package com.example.bioskopProj.entitydto;

public class BioskopDTO {
	private Long id;
	private String naziv;
	private String adresa;
	private String email;
	private String brCentrale;
	public BioskopDTO(Long id, String naziv, String adresa, String email, String brCentrale) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.adresa = adresa;
		this.email = email;
		this.brCentrale = brCentrale;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBrCentrale() {
		return brCentrale;
	}
	public void setBrCentrale(String brCentrale) {
		this.brCentrale = brCentrale;
	
}
}
