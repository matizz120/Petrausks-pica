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
		double piedeva = 0;
		int Pepperoni = Integer.parseInt(JOptionPane.showInputDialog("Visas piedevas ir 0.75 EUR, picas nâk kopâ ar sieru,\nVçlaties Pepperoni? (1/0)  "));
		int Senes = Integer.parseInt(JOptionPane.showInputDialog("Vçlaties Sçnes? (1/0)  "));
		int Sipoli = Integer.parseInt(JOptionPane.showInputDialog("Vçlaties Sîpolus? (1/0)  "));
		int Shkinkis = Integer.parseInt(JOptionPane.showInputDialog("Vçlaties Ğíiòíi? (1/0)  "));
		
		if(Pepperoni == 1 && Senes == 1 && Sipoli == 1 && Shkinkis == 1) {
			piedeva = 3;
		}else if(Senes == 1 && Sipoli == 1 && Shkinkis == 1 || Pepperoni == 1 && Senes == 1 && Sipoli == 1 || Sipoli == 1 && Shkinkis == 1 && Pepperoni == 1 ) {
			piedeva = 2.25;
		}else if(Senes == 1 && Sipoli == 1 || Senes == 1 && Pepperoni == 1 || Senes == 1 && Shkinkis == 1 || Shkinkis == 1 && Sipoli == 1 || Shkinkis == 1 && Pepperoni == 1 || Pepperoni == 1 && Sipoli == 1) {
			piedeva = 1.5;
		}else if(Pepperoni == 1 || Senes == 1 || Sipoli == 1 || Shkinkis == 1) {
			piedeva = 0.75;
		}else if(Pepperoni == 0 && Senes == 0 && Sipoli == 0 && Shkinkis == 0){
			piedeva = 0;
		}
		piedevacena = piedeva;
		JOptionPane.showMessageDialog(null, "Piedevu kopçjâ cena: "+piedevacena);
		
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
				if(piedevacena == 3) {
					raksta.println("Picas piedevas: Ğíiòíis, Sîpoli, Pepperoni un Sçnes");
				}else if(piedevacena == 2.25) {
					raksta.println("Picas piedevas: Ğíiòíis, Sîpoli un Pepperoni / Ğíiòíis, Sçnes un Pepperoni / Sîpoli, Sçnes un Pepperoni / Sîpoli, Sçnes un Ğíiòíis");
				}else if(piedevacena == 1.5) {
					raksta.println("Picas piedevas: Ğíiòíis un Sîpoli / Pepperoni un Sçnes / Ğíiòíis un Sçnes / Ğíiòíis un Pepperoni / Pepperoni un Sîpoli / Sçnes un Sîpoli");
				}else if(piedevacena == 0.75) {
					raksta.println("Picas piedevas: Ğíiòíis/Sîpoli/Pepperoni/Sçnes");
				}else if(piedevacena == 0) {
					raksta.println("Picas piedevas: Nav");
				}
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