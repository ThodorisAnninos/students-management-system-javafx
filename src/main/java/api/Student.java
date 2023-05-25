package api;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;

public class Student implements Serializable {
    private String name, surname;
    private int aem;
    private ArrayList<Grade> grades;

    public Student(String name, String surname, int aem, ArrayList<Grade> grades) {
        this.name = name;
        this.surname = surname;
        this.aem = aem;
        this.grades = grades;
    }

    public boolean addGrade(Grade g){
        return this.grades.add(g);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAem() {
        return aem;
    }

    public void setAem(int aem) {
        this.aem = aem;
    }

    public ArrayList<Grade> getGrades() {
        return grades;
    }

    public void setGrades(ArrayList<Grade> grades) {
        this.grades = grades;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;

        return aem == student.aem;
    }

    @Override
    public int hashCode() {
        return aem;
    }
}
