import javax.swing.JOptionPane;

public class Vetores6 {

	static int[] a;
	static int[] b;
	static int[] c;

	public static void main(String[] args) {

		a = new int[2];
		b = new int[2];
		c = new int[a.length + b.length];

		for (int i = 0; i < a.length; i++) {
			a[i] = Integer.parseInt(JOptionPane.showInputDialog("informe um valor Vetor A #" + (i + 1)));
			b[i] = Integer.parseInt(JOptionPane.showInputDialog("informe um valor Vetor B #" + (i + 1)));
		}

		/*for (int i = 0; i < c.length; i++) {
			if ((i % 2) == 0) {
				if (i == 0) {
					c[i] = a[i];
				} else {
					c[i] = a[i / 2];
				}
			} else {

				if (i == 1) {
					c[i] = b[0];
				} else {
					c[i] = b[i - 2];

				}
			}
		}*/
		
		/*for (int j = 0; j < a.length; j++) {
			if(j==0) {
				c[j]=a[j];
			}else {
				c[j+1]=a[j];				
			}
		}
		
		for (int j = 0; j < a.length; j++) {
			if(j==0) {
				c[1]=b[0];
			}else {
				c[j+2]=b[j];				
			}
		}*/
		
		
	}
}
