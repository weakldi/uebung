
public class Test {
	public static void main(String[] args) {
		double m = 8.7, n = 22.6;
		int i = 4, j = 5;
		char a = 'F';
		float p = 15.4f, q = 7.2f;

		a = (char) m; // Notwendig weil Double mehr bytes als char benötigt
					 // und weil double eine kommazahl speichert.
		q = (float) (n + i); // Notwendig weil double mehr bytes und damit eine höhere genauigkeit besitzt als float.
							 // Da n ein double ist ist n + i somit ein double und da q ein float ist muss somit der Typ 
							 // explizit umgewandelt werden.
		m = (p * j); // Weil alle float und int werte in ein double passen muss keine explizite typumwandlung statfinden.
					 // die JVM macht dies automatisch.
		p = j + (float) n; // j muss nicht umgewandelt werden weil j ein int ist und dies automatisch geschieht.
						   // n ist jedoch ein double- Wert und muss deswegen expliziet umgewandelt werden da eine 
						   // double Wert moeglicherweise nicht in ein float wert passt.
		
	}
}
