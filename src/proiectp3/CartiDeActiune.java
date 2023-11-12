package proiectp3;

public class CartiDeActiune extends Carti{
	boolean benzi_desenate;

	public CartiDeActiune() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CartiDeActiune(String autor, String titlu, int pret, boolean de_vanzare,int nr_de_bucati,boolean benzi_desenate) {
		super(autor, titlu, pret, de_vanzare, nr_de_bucati);
		this.benzi_desenate=benzi_desenate;
		
		}
	

}
