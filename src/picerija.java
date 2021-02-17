import javax.swing.JOptionPane;

public class picerija {

	public static void main(String[] args) {
		String izvele;
		int pica = 0;
		
		do {
			izvele = JOptionPane.showInputDialog("pica - Izveidot picas garumu \npildcena - Pildît picu ar piedavâm/nosaukt cenu \npersona - Reìistrçt personu \nsaglabat - Reìistrçt picu \niziet - Beigt pasûtîjumu");	
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
				JOptionPane.showMessageDialog(null, "Jûs esat beidzis sûtît çdienu!");		
			break;
			
			default:
				JOptionPane.showMessageDialog(null, "Ðâda darbîba nepastâv!", "Kïûme!", JOptionPane.ERROR_MESSAGE);
			break;
			}
		}while(!izvele.equals("iziet"));
	}
}