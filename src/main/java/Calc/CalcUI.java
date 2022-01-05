package Calc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalcUI {

	public static void main(String[] args) throws InterruptedException {

		// Variable declaration
		double vorsorgeVerm�gen = 0;
		double vorsorgeVerm�gen1 = 0;
		double konten;
		double tax1 = 0;
		double tax2 = 0;
		double tax3 = 0;
		double tax4 = 0;
		double tax5 = 0;
		double tax6 = 0;
		double tax7 = 0;
		double tax8 = 0;
		double tax9 = 0;
		int eingabe;
		String eingabe1;
		int beenden = 0;

		CalcImpl calculator = new CalcImpl();
		Scanner sc = new Scanner(System.in);

		System.out.println("****************************************************");
		System.out.println("Willkommen in der MAT1 Aufgabe von Jonas Zehnder");
		System.out.println("****************************************************");
		System.out.println();
		System.out.println(
				"Dieses Programm berechnet Ihnen die m�gliche Steuerersparnis mit verschiedenen Konten und die optimale Anzahl davon.");

		do {
			System.out.println(
					"Eigene Steuersaetze eingeben [1]   Auswahl aus verfuegbaren Ortschaften [2]   Beenden [3]");
			eingabe = sc.nextInt();
			System.out.println();

			if (eingabe == 1) {
				System.out.println(
						"Sie brauchen folgende Angaben griffbereit: Ihr Vorsorgeverm�gen und die beigelegte Steuertabelle.");
				System.out.println();
				System.out.println("Nun kommen wir zu den Eingaben.");
				System.out.println("Geben Sie ihr Vorsorgeverm�gen ein: ");
				vorsorgeVerm�gen = sc.nextDouble();
				System.out.println("Geben Sie den Steuersatz 1 gem�ss Tabelle ein (Muster: X.X): ");
				tax1 = sc.nextDouble();
				System.out.println("Geben Sie den Steuersatz 2 gem�ss Tabelle ein (Muster: X.X): ");
				tax2 = sc.nextDouble();
				System.out.println("Geben Sie den Steuersatz 3 gem�ss Tabelle ein (Muster: X.X): ");
				tax3 = sc.nextDouble();
				System.out.println("Geben Sie den Steuersatz 4 gem�ss Tabelle ein (Muster: X.X): ");
				tax4 = sc.nextDouble();
				System.out.println("Geben Sie den Steuersatz 5 gem�ss Tabelle ein (Muster: X.X): ");
				tax5 = sc.nextDouble();
				System.out.println("Geben Sie den Steuersatz 6 gem�ss Tabelle ein (Muster: X.X): ");
				tax6 = sc.nextDouble();
				System.out.println("Geben Sie den Steuersatz 7 gem�ss Tabelle ein (Muster: X.X): ");
				tax7 = sc.nextDouble();
				System.out.println("Geben Sie den Steuersatz 8 gem�ss Tabelle ein (Muster: X.X): ");
				tax8 = sc.nextDouble();
				System.out.println("Geben Sie den Steuersatz 9 gem�ss Tabelle ein (Muster: X.X): ");
				tax9 = sc.nextDouble();

				// Calculation
				double optKonto = vorsorgeVerm�gen / 50000;
				double steuern = calculator.calc(vorsorgeVerm�gen, tax1, tax2, tax3, tax4, tax5, tax6, tax7, tax8,
						tax9);
				System.out.println("Optimale Anzahl Konten: " + optKonto);
				konten = optKonto;
				if (optKonto > 10) {
					System.out.println("Die hoechste Anzahl sinnvoller Konten bei f�nf Jahren l�ngerer Arbeit ist 10");
					konten = 10;
				}
				double optGeld = vorsorgeVerm�gen / konten;
				double optSteuern = konten
						* calculator.calc(optGeld, tax1, tax2, tax3, tax4, tax5, tax6, tax7, tax8, tax9);
				double diff = steuern - optSteuern;
				System.out.println("Steuern ohne Optimierung: " + steuern);
				System.out.println("Steuern mit Optimierung: " + optSteuern);
				System.out.println("Differenz: " + diff);
			}

			if (eingabe == 2) {

				System.out.println("Folgende Staedte stehen zur Verfuegung: ");
				System.out.println(calculator.availableCities());
				System.out.println("Geben Sie den Namen wie er oben steht ein, damit die Stadt ausgewaehlt wird.");
				eingabe1 = sc.next();
				System.out.println("Geben Sie ihr Vorsorgeverm�gen ein: ");
				vorsorgeVerm�gen1 = sc.nextDouble();

				ArrayList<Double> list = calculator.taxBracketsByCity(eingabe1);

				// Calculation
				double optKonto = vorsorgeVerm�gen1 / 50000;
				double steuern = calculator.calc(vorsorgeVerm�gen1, list.get(0), list.get(1), list.get(2), list.get(3),
						list.get(4), list.get(5), list.get(6), list.get(7), list.get(8));

				System.out.println("Optimale Anzahl Konten: " + optKonto);

				konten = optKonto;

				if (optKonto > 10) {
					System.out.println("Die hoechste Anzahl sinnvoller Konten bei f�nf Jahren l�ngerer Arbeit ist 10");
					konten = 10;
				}
				double optGeld = vorsorgeVerm�gen1 / konten;
				double optSteuern = konten * calculator.calc(optGeld, list.get(0), list.get(1), list.get(2),
						list.get(3), list.get(4), list.get(5), list.get(6), list.get(7), list.get(8));
				double diff = steuern - optSteuern;
				System.out.println("Steuern ohne Optimierung: " + steuern);
				System.out.println("Steuern mit Optimierung: " + optSteuern);
				System.out.println("Differenz: " + diff);
			}

			if (eingabe == 3) {
				beenden = 1;
			}

		} while (beenden != 1);
		System.out.println("Das Programm wird beendet.");
	}

}
