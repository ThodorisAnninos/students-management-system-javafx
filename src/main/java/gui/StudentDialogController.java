package gui;

import api.Database;
import api.Grade;
import api.Student;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashSet;

public class StudentDialogController {

    @FXML
    private Label aemL;

    @FXML
    private TextField aemT;

    @FXML
    private ButtonBar buttons;

    @FXML
    private Button cancel;

    @FXML
    private Label header;

    @FXML
    private TextField lesson1G;

    @FXML
    private Label lesson1L;

    @FXML
    private TextField lesson1N;

    @FXML
    private TextField lesson2G;

    @FXML
    private Label lesson2L;

    @FXML
    private TextField lesson2N;

    @FXML
    private TextField lesson3G;

    @FXML
    private Label lesson3L;

    @FXML
    private TextField lesson3N;

    @FXML
    private TextField lesson4G;

    @FXML
    private Label lesson4L;

    @FXML
    private TextField lesson4N;

    @FXML
    private TextField lesson5G;

    @FXML
    private Label lesson5L;

    @FXML
    private TextField lesson5N;

    @FXML
    private Label nameL;

    @FXML
    private TextField nameT;

    @FXML
    private Button save;

    @FXML
    private Label surnameL;

    @FXML
    private TextField surnameT;

    @FXML
    private Button view;

    private Stage dialog;

    private Student student;



    public void setDialog(Stage dialog) {
        this.dialog = dialog;
    }

    public void closeDialog(){
        dialog.close();
    }



    public void saveStudent(){
        Student s;
        ArrayList<Grade> grades = new ArrayList<>();
        grades.add(new Grade(lesson1N.getText(), Integer.parseInt(lesson1G.getText())));
        grades.add(new Grade(lesson2N.getText(), Integer.parseInt(lesson2G.getText())));
        grades.add(new Grade(lesson3N.getText(), Integer.parseInt(lesson3G.getText())));
        grades.add(new Grade(lesson4N.getText(), Integer.parseInt(lesson4G.getText())));
        grades.add(new Grade(lesson5N.getText(), Integer.parseInt(lesson5G.getText())));

        s = new Student(nameT.getText(),
                surnameT.getText(),
                Integer.parseInt(aemT.getText()),
                grades);


        if (this.student == null) {
            Database.addStudent(s);
        } else {
            Database.editStudent(this.student, s);
        }


        closeDialog();
    }

    public void setStudent(Student student){
        this.student = student;

        feedWithData();
    }

    private void feedWithData(){
        if (this.student!=null) {
            this.nameT.setText(this.student.getName());
            this.surnameT.setText(this.student.getSurname());
            this.aemT.setText(this.student.getAem() + "");
            Grade[] grades = this.student.getGrades().toArray(new Grade[0]);
            this.lesson1N.setText(grades[0].getLessonName());
            this.lesson1G.setText(grades[0].getLessonGrade() + "");
            this.lesson2N.setText(grades[1].getLessonName());
            this.lesson2G.setText(grades[1].getLessonGrade() + "");
            this.lesson3N.setText(grades[2].getLessonName());
            this.lesson3G.setText(grades[2].getLessonGrade() + "");
            this.lesson4N.setText(grades[3].getLessonName());
            this.lesson4G.setText(grades[3].getLessonGrade() + "");
            this.lesson5N.setText(grades[4].getLessonName());
            this.lesson5G.setText(grades[4].getLessonGrade() + "");
        }
    }

    public void disableFields(){
        this.nameT.setDisable(true);
        this.surnameT.setDisable(true);
        this.aemT.setDisable(true);
        this.lesson1N.setDisable(true);
        this.lesson1G.setDisable(true);
        this.lesson2N.setDisable(true);
        this.lesson2G.setDisable(true);
        this.lesson3N.setDisable(true);
        this.lesson3G.setDisable(true);
        this.lesson4N.setDisable(true);
        this.lesson4G.setDisable(true);
        this.lesson5N.setDisable(true);
        this.lesson5G.setDisable(true);

        this.save.setDisable(true);
    }

}
