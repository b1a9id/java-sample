package sample1;

import java.time.LocalDate;

public class SalesResult {
	public static void main(String[] args) {
		LocalDate today = LocalDate.now();
		int[] records = {65000, 73000, 90000};
		int total = 0;

		for (int record : records) {
			System.out.println("total => " + total);
			total += record;
		}

		System.out.println("** " + today + " **");
		System.out.println("Total : " + total );
		System.out.println("Average : " + getAverage(total, records.length));
		System.out.println("MaxValue : " + getMaxValue(records));
		System.out.println("MinValue : " + getMinValue(records));
	}

	private static int getAverage(int total, int arrayLength) {
		return total / arrayLength;
	}

	private static int getMaxValue(int[] records) {
		Integer maxValue = null;
		for (int record : records) {
			maxValue = (maxValue == null || record > maxValue) ? record : maxValue;
		}
		return maxValue;
	}

	private static int getMinValue(int[] records) {
		Integer minValue = null;
		for (int record : records) {
			minValue = (minValue == null || record < minValue) ? record : minValue;
		}
		return minValue;
	}
}
