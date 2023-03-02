package com.h2;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Scanner;

public class SavingsCalculator {
    //Amount representing income
    private ArrayList<Float> credits = new ArrayList<>();
    //Amount representing expenses
    private ArrayList<Float> debits = new ArrayList<>();

    public SavingsCalculator(ArrayList credits, ArrayList debits){
        this.credits = credits;
        this.debits = debits;
    }
    public SavingsCalculator(){}

    private float sumOfCredits(){
        float sum = 0.0f;
        for(float credit : credits){
            sum += credit;
        }
        return sum;
    }

    private float sumOfDebits(){
        float sum = 0.0f;
        for(float debit : debits){
            sum += debit;
        }
        return sum;
    }
    private static int remainingDaysInMonth(LocalDate date){
        YearMonth yearMonth = YearMonth.of(date.getYear(), date.getMonth());
        int totalDaysInMonth = yearMonth.lengthOfMonth();
        int remainingDays = totalDaysInMonth - date.getDayOfMonth();
        return remainingDays;
    }
    //Returns the amount of savings or left over each month
    public float calculate() {
        return sumOfCredits() - sumOfDebits();
    }

    public ArrayList<Float> getCredits() {
        return credits;
    }

    public void setCredits(ArrayList credits) {
        this.credits = credits;
    }

    public ArrayList<Float> getDebits() {
        return debits;
    }

    public void setDebits(ArrayList debits) {
        this.debits = debits;
    }

    public static void main(String[] args){
        SavingsCalculator savings = new SavingsCalculator();
        Scanner input = new Scanner(System.in);
        if (!input.equals(0)){
            System.out.println("Enter a credit amount, if no more credits, enter '0': ");
            Float newCredit = input.nextFloat();
            savings.credits.add(newCredit);

        } else if (input.equals(0)){
            System.out.println("Enter a bill amount, if no more bills, enter '0'");
        }


        System.out.println(savings.getCredits());

    }

}
