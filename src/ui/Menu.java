package ui;

import java.math.BigDecimal;
import java.util.Scanner;

import model.Komputer;
import model.Produkt;
import model.Sklep;
import model.Szkolenie;

public class Menu {
	public void wyswietlMenu() {
		
		
		Sklep sklep = new Sklep("www.sklep.pl");
		Scanner skaner = new Scanner(System.in);
		System.out.println("1 - dodaj komputer");
		System.out.println("2 - usun produkt");
		System.out.println("3 - edytuj komputer");
		System.out.println("4 - wyswietl produkty");
		System.out.println("5 - dodaj szkolenie ");
		System.out.println("6 - Wyswietl rabaty");
		System.out.println("q - wyjscie");
		String wybor;
		do {
			System.out.print("Podaj wybor: ");
			wybor = skaner.nextLine();

			switch (wybor) {
			case "1": {
				System.out.println(" Podaj cene : ");
				BigDecimal cena = skaner.nextBigDecimal();
				skaner.nextLine();
				System.out.println(" Podaj nazwe :");
				String nazwa =skaner.nextLine();
				System.out.println(" Podaj CPU :");
				String cpu =skaner.nextLine();
				System.out.println(" Podaj ram :");
				String ram =skaner.nextLine();
				
				Komputer komputer = new Komputer(cena, nazwa , cpu , ram);
				sklep.dodajProdukt(komputer);
			}
				break;
			case "2":{
				if (sklep.czyPusty()) {
					System.out.println(" Sklep pusty ");
				} else {
					sklep.wyswietlListe();
					System.out.print(" Podaj index do usuniecia: ");
					int index = skaner.nextInt();
					skaner.nextLine();
					if (sklep.sprawdzIndex(index)) {
					sklep.usunProdukt(index);
					System.out.println(" Produkt zostal poprawnie usuniety " );
				} else {
					System.out.println(" Poda³es niepoprawny index ");
				}
			}
			} break;
			case "3":{
				sklep.wyswietlListe();
				System.out.print(" Ktory element edytujemy: ");
				int index = skaner.nextInt();
				skaner.nextLine();
				Produkt produkt = sklep.znajdzProdukt(index);
				
				if (produkt instanceof Komputer) {
					Komputer komputer = (Komputer)sklep.znajdzProdukt(index);
					System.out.print(" Podaj nowa cene ( aktualna cena :  " +  komputer.getCena() + "): ");
					BigDecimal cena = skaner.nextBigDecimal();
					skaner.nextLine();
					System.out.print(" Podaj nowa nazwa : ( aktualna nazwa : " + komputer.getNazwa() + "): ");
					String nazwa = skaner.nextLine();
					
					System.out.print(" Podaj nowe cpu : ( aktualne cpu : " + komputer.getCpu() + "): ");
					String cpu = skaner.nextLine();
					
					System.out.print(" Podaj nowy ram : ( aktualny ram : " + komputer.getRam() + ") : ");
					String ram = skaner.nextLine();
				
					
//					komputer.setCena(cena);
//					komputer.setNazwa(nazwa);
//					komputer.setCpu(cpu);
//					komputer.setRam(ram);
					
					komputer.zaktualizuj(cena, nazwa,cpu, ram);
					
					
					
					sklep.zmodyfikujProdukt(index, komputer);
				} else {
					System.out.println(" To nie jest komputer");
				}
				}
				
				break;
			case "4":{
				sklep.wyswietlListe();
			}break;
			case "5" :{
				System.out.println(" Podaj cene : ");
				BigDecimal cena = skaner.nextBigDecimal();
				skaner.nextLine();
				System.out.println(" Podaj nazwe :");
				String nazwa = skaner.nextLine();
				System.out.println(" Podaj technologie :");
				String technologia = skaner.nextLine();
			
				
				Szkolenie szkolenie = new Szkolenie(cena, nazwa , technologia);
				sklep.dodajProdukt(szkolenie);
				
			}
				
				break;
			case "6" : {
				sklep.wyswietlRabaty();
				
			} break;
			case "q":
			case "Q":
				System.out.println("Koniec programu");
				break;
			default:
				System.out.println("Bledny wybor");
				break;
			}
		} while (!wybor.equalsIgnoreCase("q"));
		
		
	}
	

}
