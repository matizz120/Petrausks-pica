import javax.swing.JOptionPane;

public class picerija {
	
	public static int izveidot(int pica){
		int lielums = 0;
			lielums = Integer.parseInt(JOptionPane.showInputDialog("Ievadi picas garumu/platumu (30, 40, 50 cm): "));
			if(lielums > 50 || lielums < 30) {
				JOptionPane.showMessageDialog(null, "T�ds lielums nepast�v! (30, 40, 50 cm!)");
			}else if(lielums==30 || lielums==40 || lielums==50) {
				JOptionPane.showMessageDialog(null, "Picas lielums ir "+lielums);
			}else {
				JOptionPane.showMessageDialog(null, "T�ds lielums nepast�v! (30, 40, 50 cm!)");
			}
			pica = lielums;
		return pica;
	}
	
	public static void main(String[] args) {
		String izvele;
		int pica = 0;
		
		do {
			izvele = JOptionPane.showInputDialog("pica - Izveidot picas garumu \npildcena - Pild�t picu ar piedav�m/nosaukt cenu \npersona - Re�istr�t personu \nsaglabat - Re�istr�t picu \niziet - Beigt pas�t�jumu");	
			switch(izvele) {
			case "pica":
				izveidot(pica);
			break;
			
			case "pildcena":
				pilditcena(pica);
			break;
			
			case "persona":
				registret(pica);
			break;
			
			case "saglabat":
				saglabat(pica);
			break;
			
			case "iziet":
				JOptionPane.showMessageDialog(null, "J�s esat beidzis s�t�t �dienu!");		
			break;
			
			default:
				JOptionPane.showMessageDialog(null, "��da darb�ba nepast�v!", "K��me!", JOptionPane.ERROR_MESSAGE);
			break;
			}
		}while(!izvele.equals("iziet"));
	}
}