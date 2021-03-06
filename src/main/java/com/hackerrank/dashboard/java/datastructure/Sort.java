package com.hackerrank.dashboard.java.datastructure;

import java.util.Comparator;
import java.util.Scanner;

public class Sort {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());

        java.util.List<StudentCompare> studentList = new java.util.ArrayList<>();
        while (testCases > 0) {
            int id = in.nextInt();
            String fname = in.next();
            double cgpa = in.nextDouble();

            StudentCompare st = new StudentCompare(id, fname, cgpa);
            studentList.add(st);

            testCases--;
        }

        studentList.sort(new StudentComparator());

        for (StudentCompare st : studentList) {
            System.out.println(st.getFname());
        }
    }
}

class StudentComparator implements Comparator<StudentCompare> {

    @Override
    public int compare(StudentCompare s1, StudentCompare s2) {
        if (s1.getCgpa() > s2.getCgpa()) return -1;
        if (s1.getCgpa() < s2.getCgpa()) return 1;
        else {
            return s1.getFname().compareTo(s2.getFname()) == 0 ? Integer.compare(s1.getId(), s2.getId()) : s1.getFname().compareTo(s2.getFname());
        }

    }
}

class StudentCompare {
    private int id;
    private String fname;
    private double cgpa;

    public StudentCompare(int id, String fname, double cgpa) {
        super();
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }

    public int getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public double getCgpa() {
        return cgpa;
    }
}

