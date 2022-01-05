package Calc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalcImpl {

	public double calc(double d, double tax1, double tax2, double tax3, double tax4, double tax5, double tax6,
			double tax7, double tax8, double tax9) {
		double maxTax1 = 50000 * tax1 / 100;
		double maxTax2 = maxTax1 + 50000 * tax2 / 100;
		double maxTax3 = maxTax2 + 150000 * tax3 / 100;
		double maxTax4 = maxTax3 + 250000 * tax4 / 100;
		double maxTax5 = maxTax4 + 500000 * tax5 / 100;
		double maxTax6 = maxTax5 + 1000000 * tax6 / 100;
		double maxTax7 = maxTax6 + 3000000 * tax7 / 100;
		double maxTax8 = maxTax7 + 5000000 * tax8 / 100;
		double maxTax9 = maxTax8 + 10000000 * tax9 / 100;

		double calculated = 0.0;
		double v = 0.0;

		if (0 < d && d <= 50000) {
			calculated = d * tax1 / 100;
			return calculated;
		}
		if (50000 <= d && d <= 100000) {
			v = d - 50000;
			calculated = maxTax1 + v * tax2 / 100;
			return calculated;
		}
		if (100000 <= d && d <= 250000) {
			v = d - 100000;
			calculated = maxTax2 + v * tax3 / 100;
			return calculated;
		}
		if (250000 <= d && d <= 500000) {
			v = d - 250000;
			calculated = maxTax3 + v * tax4 / 100;
			return calculated;
		}
		if (500000 <= d && d <= 1000000) {
			v = d - 500000;
			calculated = maxTax4 + v * tax5 / 100;
			return calculated;
		}
		if (1000000 <= d && d <= 2000000) {
			v = d - 1000000;
			calculated = maxTax5 + v * tax6 / 100;
			return calculated;
		}
		if (2000000 <= d && d <= 5000000) {
			v = d - 2000000;
			calculated = maxTax6 + v * tax7 / 100;
			return calculated;
		}
		if (5000000 <= d && d <= 10000000) {
			v = d - 5000000;
			calculated = maxTax7 + v * tax8 / 100;
			return calculated;
		}
		if (10000000 < d && d <= 20000000) {
			v = d - 10000000;
			calculated = maxTax8 + v * tax9 / 100;
			return calculated;
		}
		if (20000000 < d) {
			v = d - 20000000;
			calculated = maxTax9 + v * tax9 / 100;
			return calculated;
		}
		return calculated;
	}

	public ArrayList<Double> taxBracketsByCity(String name) {

		if (name.equals("Schwyz")) {

			ArrayList<Double> list = new ArrayList<Double>(Arrays.asList(1.4, 2.6, 6.3, 9.3, 11.4, 11.4, 11.4, 11.4, 11.4));
			return list;
		}

		if (name.equals("Luzern")) {

			ArrayList<Double> list = new ArrayList<Double>(Arrays.asList(4.1, 5.4, 7.4, 8.3, 8.7, 8.9, 8.9, 8.9, 8.9));
			return list;
		}

		if (name.equals("Zuerich")) {

			ArrayList<Double> list = new ArrayList<Double>(Arrays.asList(4.6, 5.0, 6.9, 11.3, 16.1, 20.9, 26.6, 28.7, 29.7));
			return list;
		}
		
		if (name.equals("Altdorf")) {

			ArrayList<Double> list = new ArrayList<Double>(Arrays.asList(3.9, 4.3, 5.3, 5.8, 6.0, 6.0, 6.0, 6.0, 6.0));
			return list;
		}

		return null;
	}

	public List<String> availableCities() {

		List<String> list = new ArrayList<String>(Arrays.asList("Schwyz", "Luzern", "Zuerich", "Altdorf"));

		return list;
	}

}
