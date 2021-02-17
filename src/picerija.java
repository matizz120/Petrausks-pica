import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class picerija {
	
	public static int izveidot(int pica){
		int lielums = 0;
			lielums = Integer.parseInt(JOptionPane.showInputDialog("Ievadi picas garumu/platumu (30, 40, 50 cm): "));
			if(lielums > 50 || lielums < 30) {
				JOptionPane.showMessageDialog(null, "Tâds lielums nepastâv! (30, 40, 50 cm!)");
			}else if(lielums==30 || lielums==40 || lielums==50) {
				JOptionPane.showMessageDialog(null, "Picas lielums ir "+lielums);
			}else {
				JOptionPane.showMessageDialog(null, "Tâds lielums nepastâv! (30, 40, 50 cm!)");
			}
			pica = lielums;
		return pica;
	}
	
	public static int pilditcena(int pica){
		return pica;
		
	}
	
	public static int registret(int pica){
			try {
				String personasVards = JOptionPane.showInputDialog("Ievadiet jûsu vârdu: ");
				String personasAdrese = JOptionPane.showInputDialog("Ievadiet jûsu adresi: ");
				int personasTalrunis = Integer.parseInt(JOptionPane.showInputDialog("Ievadiet jûsu tâlruni: "));
				FileWriter fileWriter = new FileWriter("Persona.txt");
				PrintWriter raksta = new PrintWriter(fileWriter);
					raksta.println("Pircçja vârds - "+personasVards);
					raksta.println("Pircçja adrese - "+personasAdrese);
					raksta.println("Pircçja tâlrunis - "+personasTalrunis);
				
				JOptionPane.showMessageDialog(null, "Persona ir veiksmîgi saglabâta!");
				raksta.close();	
			}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Kïûme ierakstot faila!", "Kïûme!", JOptionPane.ERROR_MESSAGE);
		}
		return pica;
	}
	
	public static int saglabat(int pica){
		int lielums = pica;
		JOptionPane.showMessageDialog(null, lielums);
		try {
			FileWriter fw = new FileWriter("Pica.txt");
			PrintWriter raksta = new PrintWriter(fw);
		if(lielums==30 || lielums==40 || lielums==50) {
				raksta.println("Picas lielums: "+lielums);
				raksta.println("Picas piedevas: "+lielums);
				raksta.println("Picas cena: "+lielums);
				JOptionPane.showMessageDialog(null, "Ierakstîts failâ!");
				raksta.close();
		}else{
			JOptionPane.showMessageDialog(null, "Tâds lielums nepastâv! (30, 40, 50 cm!)");
		}
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Kïûme ierakstot faila!", "Kïûme!", JOptionPane.ERROR_MESSAGE);
		}
		return pica;
		
		}
	
	public static void main(String[] args) {
		String izvele;
		int pica = 0;
		
		do {
			izvele = JOptionPane.showInputDialog("pica - Izveidot picas garumu \npildcena - Pildît picu ar piedavâm/nosaukt cenu \npersona - Reìistrçt personu \nsaglabat - Reìistrçt picu \niziet - Beigt pasûtîjumu");	
			switch(izvele) {
			case "pica":
				pica = izveidot(pica);
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
				JOptionPane.showMessageDialog(null, "Ğâda darbîba nepastâv!", "Kïûme!", JOptionPane.ERROR_MESSAGE);
			break;
			}
		}while(!izvele.equals("iziet"));
	}
}