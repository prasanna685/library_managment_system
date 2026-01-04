package com.projects;

import java.util.Scanner;

public class Electricbill {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice;

		do {
			System.out.print("\nEnter number of days to record usage: ");
			int days = sc.nextInt();

			int[] units = new int[days];

			// ---------- 1. FOR LOOP → Taking Daily Unit Inputs ----------
			System.out.println("\nEnter Electricity Units Day-wise:");
			for (int i = 0; i < days; i++) {
				System.out.print("Day " + (i + 1) + " Units: ");
				units[i] = sc.nextInt();
			}

			// ---------- 2. WHILE LOOP → Calculate Total Units ----------
			int i = 0, totalUnits = 0;
			while (i < days) {
				totalUnits += units[i];
				i++;
			}

			// ---------- 3. DO-WHILE LOOP → Calculate Bill using Slabs ----------
			int[] slabLimit = { 100, 200, Integer.MAX_VALUE }; // No if-else required
			double[] rate = { 5, 6, 8 }; // Rate per slab

			int consumed = totalUnits;
			int index = 0;
			double bill = 0;

			do {
				int validUnits = Math.min(consumed, slabLimit[index] - (index > 0 ? slabLimit[index - 1] : 0));
				bill += validUnits * rate[index];
				consumed -= validUnits;
				index++;
			} while (consumed > 0);

			double fixedCharge = 50;
			double finalBill = bill + fixedCharge;

			// ---------- Output ----------
			System.out.println("\n📄 SMART ELECTRICITY BILL REPORT");
			System.out.println("--------------------------------");
			System.out.println("Days Recorded       : " + days);
			System.out.println("Total Units Used    : " + totalUnits + " units");
			System.out.println("Energy Cost         : " + bill);
			System.out.println("Fixed Charges       : " + fixedCharge);
			System.out.println("--------------------------------");
			System.out.println("Total Payable Bill  : " + finalBill);
			System.out.println("--------------------------------");

			System.out.print("\nDo you want to calculate again? (1 = Yes / 0 = No): ");
			choice = sc.nextInt();

		} while (choice == 1);

		sc.close();
		System.out.println("\nThank you for using Smart Billing System!");
	}

}
