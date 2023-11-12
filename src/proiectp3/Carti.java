package proiectp3;

public class Carti {
	String autor;
	String titlu;
	int pret;
	boolean de_vanzare;
	int nr_de_bucati;
	public Carti(String autor, String titlu, int pret, boolean de_vanzare, int nr_de_bucati) {
		super();
		this.autor = autor;
		this.titlu = titlu;
		this.pret = pret;
		this.de_vanzare = de_vanzare;
		this.nr_de_bucati=nr_de_bucati;
	}
	public int getNr_de_bucati() {
		return nr_de_bucati;
	}
	public void setNr_de_bucati(int nr_de_bucati) {
		this.nr_de_bucati = nr_de_bucati;
	}
	public Carti() {
		
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getTitlu() {
		return titlu;
	}
	public void setTitlu(String titlu) {
		this.titlu = titlu;
	}
	public int getPret() {
		return pret;
	}
	public void setPret(int pret) {
		this.pret = pret;
	}
	public boolean isDe_vanzare() {
		return de_vanzare;
	}
	public void setDe_vanzare(boolean de_vanzare) {
		this.de_vanzare = de_vanzare;
	}
	
}
