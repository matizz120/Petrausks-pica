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
	
	public static double pilditcena(double piedevacena) {
		double piedeva;
		String Pepperoni = JOptionPane.showInputDialog("Visas piedevas ir 0.75 EUR, picas nâk kopâ ar sieru,\nVçlaties Pepperoni? (Y/N)  ");
		String Senes = JOptionPane.showInputDialog("Vçlaties Sçnes? (Y/N)  ");
		String Sipoli = JOptionPane.showInputDialog("Vçlaties Sîpolus? (Y/N)  ");
		String Shkinkis = JOptionPane.showInputDialog("Vçlaties Ğíiòíi? (Y/N)  ");
		
		if(Pepperoni == "Y" && Senes == "Y" && Sipoli == "Y" && Shkinkis == "Y") {
			piedeva = 3;
		}else if(Senes == "Y" && Sipoli == "Y" && Shkinkis == "Y" || Pepperoni == "Y" && Senes == "Y" && Sipoli == "Y" || Sipoli == "Y" && Shkinkis == "Y" && Pepperoni == "Y" ) {
			piedeva = 2.25;
		}else if(Senes == "Y" && Sipoli == "Y" || Senes == "Y" && Pepperoni == "Y" || Senes == "Y" && Shkinkis == "Y" || Shkinkis == "Y" && Sipoli == "Y" || Shkinkis == "Y" && Pepperoni == "Y" || Pepperoni == "Y" && Sipoli == "Y") {
			piedeva = 1.5;
		}else if(Pepperoni == "Y" || Senes == "Y" || Sipoli == "Y" || Shkinkis == "Y") {
			piedeva = 0.75;
		}else {
			piedeva = 0;
		}
		piedevacena = piedeva;
		
		return piedevacena;
		
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
	
	public static int saglabat(int pica, double piedevacena){
		int lielums = pica;
		double piedeva = piedevacena;
		double picascena = 0;
		JOptionPane.showMessageDialog(null, piedevacena);
		try {
			FileWriter fw = new FileWriter("Pica.txt");
			PrintWriter raksta = new PrintWriter(fw);
			if(lielums == 30) {
				picascena = 5;
			}else if(lielums == 40) {
				picascena = 7.5;
			}else if(lielums == 50) {
				picascena = 10;
			}
		if(lielums==30 || lielums==40 || lielums==50) {
				raksta.println("Picas lielums: "+lielums+ " cm");
				raksta.println("Picas piedevas: "+lielums);
				raksta.println("Picas cena: "+(picascena+piedeva)+ " EUR");
				JOptionPane.showMessageDialog(null, "Jûsu pica ir veiksmîgi saglabâta failâ!");
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
		double piedevacena = 0;
		
		do {
			izvele = JOptionPane.showInputDialog("pica - Izveidot picas garumu \npildcena - Pildît picu ar piedavâm/nosaukt cenu \npersona - Reìistrçt personu \nsaglabat - Reìistrçt picu \niziet - Beigt pasûtîjumu");	
			switch(izvele) {
			case "pica":
				pica = izveidot(pica);
			break;
			
			case "pildcena":
				piedevacena = pilditcena(piedevacena);
			break;
			
			case "persona":
				registret(pica);
			break;
			
			case "saglabat":
				saglabat(pica, piedevacena);
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