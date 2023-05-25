package gui;

import api.Student;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StudentDialog {

    private ObservableList<Student> table;
    private Student student;
    private boolean view;

    public StudentDialog(Student student, boolean view) throws Exception {
        this.student = student;
        this.view = view;
        open();

    }


    public void open() throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("student-dialog.fxml"));
        Parent root = loader.load();

        Stage dialogStage = new Stage();
        dialogStage.setTitle("Καρτέλα Φοιτητή");
        dialogStage.setScene(new Scene(root));
        dialogStage.setResizable(false);

        StudentDialogController s = loader.getController();
        s.setDialog(dialogStage);
        s.setStudent(student);

        if (view){
            s.disableFields();
        }

        dialogStage.showAndWait();
    }
}
