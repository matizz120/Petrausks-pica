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
	
	public static double pilditcena(double piedevacena) {
		double piedeva = 0;
		int Pepperoni = Integer.parseInt(JOptionPane.showInputDialog("Visas piedevas ir 0.75 EUR, picas n�k kop� ar sieru,\nV�laties Pepperoni? (1/0)  "));
		int Senes = Integer.parseInt(JOptionPane.showInputDialog("V�laties S�nes? (1/0)  "));
		int Sipoli = Integer.parseInt(JOptionPane.showInputDialog("V�laties S�polus? (1/0)  "));
		int Shkinkis = Integer.parseInt(JOptionPane.showInputDialog("V�laties ��i��i? (1/0)  "));
		
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
		JOptionPane.showMessageDialog(null, "Piedevu kop�j� cena: "+piedevacena);
		
		return piedevacena;
		
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
					raksta.println("Picas piedevas: ��i��is, S�poli, Pepperoni un S�nes");
				}else if(piedevacena == 2.25) {
					raksta.println("Picas piedevas: ��i��is, S�poli un Pepperoni / ��i��is, S�nes un Pepperoni / S�poli, S�nes un Pepperoni / S�poli, S�nes un ��i��is");
				}else if(piedevacena == 1.5) {
					raksta.println("Picas piedevas: ��i��is un S�poli / Pepperoni un S�nes / ��i��is un S�nes / ��i��is un Pepperoni / Pepperoni un S�poli / S�nes un S�poli");
				}else if(piedevacena == 0.75) {
					raksta.println("Picas piedevas: ��i��is/S�poli/Pepperoni/S�nes");
				}else if(piedevacena == 0) {
					raksta.println("Picas piedevas: Nav");
				}
				raksta.println("Picas cena: "+(picascena+piedeva)+ " EUR");
				JOptionPane.showMessageDialog(null, "J�su pica ir veiksm�gi saglab�ta fail�!");
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
		double piedevacena = 0;
		
		do {
			izvele = JOptionPane.showInputDialog("pica - Izveidot picas garumu \npildcena - Pild�t picu ar piedav�m/nosaukt cenu \npersona - Re�istr�t personu \nsaglabat - Re�istr�t picu \niziet - Beigt pas�t�jumu");	
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
				JOptionPane.showMessageDialog(null, "J�s esat beidzis s�t�t �dienu!");		
			break;
			
			default:
				JOptionPane.showMessageDialog(null, "��da darb�ba nepast�v!", "K��me!", JOptionPane.ERROR_MESSAGE);
			break;
			}
		}while(!izvele.equals("iziet"));
	}
}