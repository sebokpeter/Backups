/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5.BLL;

import assignment5.UI.PersonDisplay;
import javafx.stage.Stage;

/**
 *
 * @author sebok
 */
public class Assignment5
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        /*
        String[] options = new String[]{"Exit", "Print all person", "Print all teachers", "Print all students", "Add new person", "Clear"};
        Menu menu = new MainMenu("Please select an option", options);
        menu.run();
        */
        
        PersonDisplay.launch(PersonDisplay.class);
    }
    
}
