/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5.UI;

import assignment5.BLL.Person;
import assignment5.BLL.PersonManager;
import assignment5.BLL.Teacher;
import assignment5.BLL.Test;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author sebok
 */
public class PersonDisplayFXMLController implements Initializable
{

    private PersonManager pm = new PersonManager();
    
    @FXML
    private AnchorPane anchorPane;
     /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        createSeimplePersonDisplay();
        createTeacherDisplay();
        createStudentDisplay();
    }    
    
    
    private void createSeimplePersonDisplay()
    {
        TableView<Person> table = new TableView();
        
        table.setEditable(true);
        
        TableColumn idCol = new TableColumn("ID");
        idCol.setCellValueFactory(new PropertyValueFactory<Person, Integer>("id"));
        
        TableColumn nameCol = new TableColumn("Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("name"));
        
        TableColumn emailCol = new TableColumn("Email");
        emailCol.setMinWidth(150);
        emailCol.setCellValueFactory(new PropertyValueFactory<Person, String>("email"));
        
        table.getColumns().addAll(idCol, nameCol, emailCol);
        table.setItems(pm.getObservablePersons());
        
        VBox vBox = new VBox();
        
        vBox.setSpacing(5);
        vBox.setPadding(new Insets(10, 0, 0, 10));
        vBox.getChildren().add(table);
        
        anchorPane.getChildren().add(vBox);
    }
    
    private void createTeacherDisplay()
    {
        TableView<Teacher> table = new TableView();
        table.setTranslateX(400);
        table.setMinWidth(400);
        table.setEditable(true);        

        TableColumn idCol = new TableColumn("ID");
        idCol.setCellValueFactory(new PropertyValueFactory<Teacher, Integer>("id"));
        
        TableColumn nameCol = new TableColumn("Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<Teacher, String>("name"));
        
        TableColumn emailCol = new TableColumn("Email");
        emailCol.setMinWidth(150);
        emailCol.setCellValueFactory(new PropertyValueFactory<Teacher, String>("email"));
        
        TableColumn initCol = new TableColumn("Initials");
        initCol.setMinWidth(50);
        initCol.setCellValueFactory(new PropertyValueFactory<Teacher, String>("initials"));
        
        TableColumn mainCol = new TableColumn("Main");
        mainCol.setMinWidth(100);
        mainCol.setCellValueFactory(new PropertyValueFactory<Teacher, String>("main"));

        
        table.getColumns().addAll(idCol, nameCol, emailCol, initCol, mainCol);
        table.setItems(pm.getObservableTeachers());
        
        VBox vBox = new VBox();
        
        vBox.setSpacing(5);
        vBox.setPadding(new Insets(10, 0, 0, 10));
        vBox.getChildren().add(table);
        
        anchorPane.getChildren().add(vBox);
    }
    
    
    private void createStudentDisplay()
    {
        TableView table = new TableView();
        table.setTranslateX(1000);
        table.setMinWidth(400);
        table.setEditable(true);        

        TableColumn idCol = new TableColumn("ID");
        idCol.setCellValueFactory(new PropertyValueFactory<Person, Integer>("id"));
        
        TableColumn nameCol = new TableColumn("Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("name"));
        
        TableColumn emailCol = new TableColumn("Email");
        emailCol.setMinWidth(150);
        emailCol.setCellValueFactory(new PropertyValueFactory<Person, String>("email"));
        
        TableColumn eduCol = new TableColumn("Education");
        eduCol.setMinWidth(50);
        eduCol.setCellValueFactory(new PropertyValueFactory<Person, String>("education"));
        
        TableColumn avgCol = new TableColumn("AVG. Grade");
        avgCol.setMinWidth(100);
        avgCol.setCellValueFactory(new PropertyValueFactory<Person, Double>("getAvarageGrade"));

        
        table.getColumns().addAll(idCol, nameCol, emailCol, eduCol, avgCol);
        table.setItems(pm.getObservableTeachers());
        
        VBox vBox = new VBox();
        
        vBox.setSpacing(5);
        vBox.setPadding(new Insets(10, 0, 0, 10));
        vBox.getChildren().add(table);
        
        anchorPane.getChildren().add(vBox);
    }
}
