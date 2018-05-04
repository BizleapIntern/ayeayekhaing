package com.bizleap.training.assignment.three;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
public class MonthMapBuilder {
	private Map<Integer, List<Month>> monthMapBuilder = new HashMap<Integer, List<Month>>();

    private class Month {

        private int numberOfDays;
        private String name;
        private int year;

        public Month(String name, int numberOfDays, int year) {
            this.name = name;
            this.numberOfDays = numberOfDays;
            this.year = year;
        }

        public String toString() {
            return this.year + " " + this.name;
        }
    }

    LinkedList<Month> initializeMonthsRange(int firstYear, int secondYear) {
        LinkedList<Month> ListOfMonth = new LinkedList<Month>();
        for (int year = firstYear; year <= secondYear; year++) {
            initializeMonthsYear(year, ListOfMonth);
        }
        return ListOfMonth;
    }

    public Map<Integer, List<Month>> makeMonthMap(int firstYear, int secondYear, int numberOfDays) {
        if (validate(firstYear, secondYear)) {
            for (MonthMapBuilder.Month month : initializeMonthsRange(firstYear, secondYear)) {
                if (month.numberOfDays == numberOfDays) {
                    addMonthMap(month);
                }
            }
        }
        return this.monthMapBuilder;
    }

    private boolean isLeapYear(int year) {
        return (year % 4 != 0 && year % 100 != 0);

    }
    LinkedList<String> linkedlist = new LinkedList<String>();

    private void initializeMonthsYear(int firstYear, LinkedList<Month> LinkedListofmonth) {
        boolean b = isLeapYear(firstYear);
        LinkedListofmonth.add(new Month("January", 31, firstYear));
        LinkedListofmonth.add(new Month("March", 31, firstYear));
        LinkedListofmonth.add(new Month("May", 31, firstYear));
        LinkedListofmonth.add(new Month("July", 31, firstYear));
        LinkedListofmonth.add(new Month("Augest", 31, firstYear));
        LinkedListofmonth.add(new Month("Octomber", 31, firstYear));
        LinkedListofmonth.add(new Month("December", 31, firstYear));
        LinkedListofmonth.add(new Month("April", 30, firstYear));
        LinkedListofmonth.add(new Month("June", 30, firstYear));
        LinkedListofmonth.add(new Month("September", 30, firstYear));
        LinkedListofmonth.add(new Month("November", 30, firstYear));
        if (b) {
            LinkedListofmonth.add(new Month("February", 29, firstYear));
        } else {
            LinkedListofmonth.add(new Month("February", 28, firstYear));
        }
    }

    private boolean validate(int firstYear, int secondYear) {
        if (firstYear <= 0 || secondYear <= 0 || firstYear > secondYear
                || firstYear > 2018 || secondYear > 2018) {
            System.out.println("Your input is invalid!!");
            return false;
        } else {
            return firstYear == secondYear || firstYear <= secondYear;
        }
    }//End of statement

    public void addMonthMap(MonthMapBuilder.Month month) {
        List<MonthMapBuilder.Month> monthList = this.monthMapBuilder.get(month.numberOfDays);

        if (monthList != null) {
            monthList.add(month);

        } else {
            monthList = new ArrayList<Month>();
            monthList.add(month);
            monthMapBuilder.put(month.numberOfDays, monthList);
        }
        System.out.println(month.numberOfDays + " " + month.name + " " + month.year);
    }

//    private void addMonthToMap(int year, Month month) {
//        monthMapBuilder.put(year, month);
//    }
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the first year:");
        int firstYear = scan.nextInt();
        System.out.println("Enter the second year:");
        int secondYear = scan.nextInt();
        System.out.println("Enter numbers of Days:");
        int numberOfDays = scan.nextInt();
        MonthMapBuilder monthMap = new MonthMapBuilder();
        monthMap.makeMonthMap(firstYear, secondYear, numberOfDays);
    }
}
