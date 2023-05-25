package gui;

import api.Database;
import api.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class MainScreenController {

    @FXML
    private Button add;

    @FXML
    private TableColumn<Student, Integer> aemColumn;

    @FXML
    private ButtonBar buttons;

    @FXML
    private Button delete;

    @FXML
    private Button edit;

    @FXML
    private MenuItem exportTXT;

    @FXML
    private Menu file;

    @FXML
    private Label header;

    @FXML
    private MenuItem importTXT;

    @FXML
    private MenuBar menu;

    @FXML
    private TableColumn<Student, String> nameColumn;

    @FXML
    private TableColumn<Student, String> surnameColumn;

    @FXML
    private TableView<Student> table;

    private ObservableList<Student> students;


    public void initialize(){
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        surnameColumn.setCellValueFactory(new PropertyValueFactory<>("surname"));
        aemColumn.setCellValueFactory(new PropertyValueFactory<>("aem"));


        students = FXCollections.observableArrayList(Database.getStudents());
        table.setItems(students);
    }

    public void refreshTable(){
        this.table.setItems(FXCollections.observableArrayList(Database.getStudents()));
    }

    public void addStudentDialog() throws Exception{
        StudentDialog d = new StudentDialog(null, false);
        refreshTable();
    }

    public void editStudentDialog() throws Exception{
        Student s = table.getSelectionModel().getSelectedItem();
        if (s!=null){
            StudentDialog d = new StudentDialog(s, false);
            refreshTable();
        }
    }

    public void viewStudent() throws Exception{
        Student s = table.getSelectionModel().getSelectedItem();
        if (s!=null){
            StudentDialog d = new StudentDialog(s, true);
            refreshTable();
        }
    }

    public void deleteStudent(){
        Student s = table.getSelectionModel().getSelectedItem();
        if (s!=null){
            Database.deleteStudent(s);
            refreshTable();
        }
    }

    public void exportToTXTfile(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Αποθήκευση ως...");
        File file = fileChooser.showSaveDialog(new Stage());
        if (file != null)
            Database.exportToTXT(file.getAbsoluteFile());
    }


    public void importFromTXTfile(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Άνοιγμα...");
        File file = fileChooser.showOpenDialog(new Stage());
        if (file != null) {
            Database.loadFromTXT(file.getAbsoluteFile());
            refreshTable();
        }
    }

}
