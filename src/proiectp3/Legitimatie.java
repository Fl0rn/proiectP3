
package proiectp3;

public class Legitimatie {
	@Override
	public String toString() {
		return "Legitimatie [nume=" + nume + ", adresa=" + adresa + ", ani=" + ani + ", cnp=" + cnp + "]";
	}


	String nume;
	String adresa;
	int ani;
	String cnp;
	
	
	public Legitimatie(String nume, String adresa, int ani, String cnp) {
		super();
		this.nume = nume;
		this.adresa = adresa;
		this.ani = ani;
		this.cnp = cnp;
	}

	public Legitimatie() {
		// TODO Auto-generated constructor stub
	}

	public String getNume() {
		return nume;
	}


	public void setNume(String nume) {
		this.nume = nume;
	}


	public String getAdresa() {
		return adresa;
	}


	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}


	public int getAni() {
		return ani;
	}


	public void setAni(int ani) {
		this.ani = ani;
	}


	public String getCnp() {
		return cnp;
	}


	public void setCnp(String cnp) {
		this.cnp = cnp;
	}


	


	

}
