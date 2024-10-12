package application;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static List<TaxPayer> list = new ArrayList<>();

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of tax payers: ");
        int n = sc.nextInt();
        // Limpeza do buffer
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.printf("Tax payer #%d data:\n", i + 1);
            System.out.print("Individual or company (i/c)? ");
            char option = sc.next().charAt(0);
            sc.nextLine(); //Limpeza de buffer
            while (option != 'i' && option != 'c') {
                System.out.print("Individual or company (i/c)? ");
                option = sc.next().charAt(0);
                sc.nextLine(); //Limpeza de buffer
            }
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Anual income: ");
            double anualIncome = sc.nextDouble();
            if (option == 'i') {
                System.out.print("Health expenditures: ");
                double healthExpenditures = sc.nextDouble();
                list.add(new Individual(name, anualIncome, healthExpenditures));
            } else {
                System.out.print("Number of employees: ");
                int numberOfEmployees = sc.nextInt();
                list.add(new Company(name, anualIncome, numberOfEmployees));
            }
        }
        System.out.println();//pular linha
        System.out.println("TAXES PAID:");
        report();
        System.out.println();
        System.out.print("TOTAL TAXES: " + totalTax());

        sc.close();
    }

    public static void report() {
        StringBuilder sb = new StringBuilder();

        for (TaxPayer tp : list) {
            sb.append(tp.getName());
            sb.append(": $ ");
            sb.append(String.format("%.2f", tp.tax()));
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static double totalTax() {
        double sum = 0.0;
        for (TaxPayer tp : list) {
            sum += tp.tax();
        }
        return sum;
    }
}
