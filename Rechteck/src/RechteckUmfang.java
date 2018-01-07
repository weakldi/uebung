
public class RechteckUmfang {
	private double laenge, umfang;

	public RechteckUmfang(double laenge, double umfang) {
		super();
		this.laenge = laenge;
		this.umfang = umfang;
	}
	
	public double getBreite() {
		return (umfang - 2 * laenge) / 2.0;
	}
	
	public double getLaenge() {
		return laenge;
	}

	public double getUmfang() {
		return umfang;
	}
	
	public double getFlaeche() {
		return laenge * getBreite();
	}

	
	
	
}
