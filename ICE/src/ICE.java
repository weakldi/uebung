
public class ICE {
	private short zugnummer;
	private String ziehlbahnhof;
	private int geschwindigkeit = 0; //Sollte sowieso 0 sein ist ja nicht c
	/**
	 * Konstruktor fuer den ICE.
	 * Der Konstruktor erwartet eine Zugnummer vom Typ short und einen String der den Ziehlbahnhof angibt.
	 * Das Attribut geschwindikteit wird mit 0 initialisiert.
	 * @param zugnummer Die Zugnummer.
	 * @param ziehlbahnhof Der Ziehlbahnhof.
	 */
	public ICE(short zugnummer, String ziehlbahnhof) {
		super();
		this.zugnummer = zugnummer;
		this.ziehlbahnhof = ziehlbahnhof;
		//Geschwindigkeit ist schon 0.
	}
	/**
	 * Erhoeht die Geschwindigkeit um 15.
	 */
	public void beschelunigen() {
		geschwindigkeit+=15;
	}
	/**
	 * Reduziert die Geschwindigkeit um 20
	 */
	public void bremsAb() {
		geschwindigkeit -= 20;
	}
	
	
	/**
	 * @return the zugnummer
	 */
	public short getZugnummer() {
		return zugnummer;
	}
	/**
	 * @return the ziehlbahnhof
	 */
	public String getZiehlbahnhof() {
		return ziehlbahnhof;
	}
	/**
	 * @return the geschwindigkeit
	 */
	public int getGeschwindigkeit() {
		return geschwindigkeit;
	}
	
	
	
}
