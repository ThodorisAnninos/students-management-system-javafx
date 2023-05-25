package api;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;

public class Database {
    private static ArrayList<Student> students = new ArrayList<>();;

    private Database() {
    }

    public static ArrayList<Student> getStudents() {
//        students.add(new Student("Ele", "Nik", 4100, new HashSet<>()));
        return students;
    }

    public static void load(){
        students.clear();
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("data.dat"))){
            ArrayList<Student> temp = (ArrayList<Student>) in.readObject();
            students.addAll(temp);
            System.out.println("Loaded!");
        } catch (IOException | ClassNotFoundException e){
            System.out.println("Error!");
        }
    }

    public static void save(){
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data.dat"))){
            out.writeObject(students);
            System.out.println("Saved!");
        } catch (IOException e){
            System.out.println("Error!");
        }
    }

    public static void exportToTXT(File path){
        try(BufferedWriter out = new BufferedWriter(new FileWriter(path+".txt"))){
            String separator = ", ";
            for (Student student : students) {
                out.write(student.getName()+separator);
                out.write(student.getSurname()+separator);
                out.write(student.getAem()+"");
                for (Grade grade : student.getGrades()) {
                    out.write(separator+grade.getLessonName()+":"+grade.getLessonGrade());
                }
                out.newLine();
            }
            System.out.println("Saved to TXT");
        } catch (IOException e){
            System.out.println("Error saving to TXT!");
        }
    }

    public static void loadFromTXT(File path){
        students.clear();
        HashSet<Student> temp = new HashSet<>();
        try(BufferedReader in = new BufferedReader(new FileReader(path))){
            String line;
            while ((line = in.readLine()) != null){
                String[] data = line.split(", ");
                ArrayList<Grade> grades = new ArrayList<>();
                for (int i = 0; i < 5; i++) {
                    String[] data_grade = data[3 + i].split(":");
                    Grade g = new Grade(data_grade[0], Integer.parseInt(data_grade[1]));
                    grades.add(g);
                }
                Student s = new Student(data[0], data[1], Integer.parseInt(data[2]), grades);
                temp.add(s);
            }
            students.addAll(temp);
            System.out.println("Loaded from TXT");
        } catch(IOException e){
            System.out.println("Error opening from TXT!");
        }
    }

    public static void addStudent(Student s){
        students.add(s);
    }
    public static void deleteStudent(Student s){
        students.remove(s);
    }
    public static void editStudent(Student oldS, Student newS){
        students.remove(oldS);
        students.add(newS);
    }
}
