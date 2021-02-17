import java.io.FileWriter;
import java.io.PrintWriter;

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
	
	public static int pilditcena(int pica){
		return pica;
		
	}
	
	public static int registret(int pica){
			try {
				String personasVards = JOptionPane.showInputDialog("Ievadiet j�su v�rdu: ");
				String personasAdrese = JOptionPane.showInputDialog("Ievadiet j�su adresi: ");
				int personasTalrunis = Integer.parseInt(JOptionPane.showInputDialog("Ievadiet j�su t�lruni: "));
				FileWriter fileWriter = new FileWriter("Persona.txt");
				PrintWriter raksta = new PrintWriter(fileWriter);
					raksta.println("Pirc�ja v�rds - "+personasVards);
					raksta.println("Pirc�ja adrese - "+personasAdrese);
					raksta.println("Pirc�ja t�lrunis - "+personasTalrunis);
				
				JOptionPane.showMessageDialog(null, "Persona ir veiksm�gi saglab�ta!");
				raksta.close();	
			}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "K��me ierakstot faila!", "K��me!", JOptionPane.ERROR_MESSAGE);
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
				JOptionPane.showMessageDialog(null, "Ierakst�ts fail�!");
				raksta.close();
		}else{
			JOptionPane.showMessageDialog(null, "T�ds lielums nepast�v! (30, 40, 50 cm!)");
		}
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "K��me ierakstot faila!", "K��me!", JOptionPane.ERROR_MESSAGE);
		}
		return pica;
		
		}
	
	public static void main(String[] args) {
		String izvele;
		int pica = 0;
		
		do {
			izvele = JOptionPane.showInputDialog("pica - Izveidot picas garumu \npildcena - Pild�t picu ar piedav�m/nosaukt cenu \npersona - Re�istr�t personu \nsaglabat - Re�istr�t picu \niziet - Beigt pas�t�jumu");	
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
				JOptionPane.showMessageDialog(null, "J�s esat beidzis s�t�t �dienu!");		
			break;
			
			default:
				JOptionPane.showMessageDialog(null, "��da darb�ba nepast�v!", "K��me!", JOptionPane.ERROR_MESSAGE);
			break;
			}
		}while(!izvele.equals("iziet"));
	}
}