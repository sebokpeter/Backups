/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5.BLL;

import assignment5.UI.PersonTypeMenu;

/**
 *
 * @author sebok
 */
public class MainMenu extends Menu
{
    Test t = new Test();

    public MainMenu(String header, String[] menuItems)
    {
        super(header, menuItems);
    }
    
    @Override
    protected void doAction(int option)
    {
        switch (option)
        {
            case 1: 
                t.displayAllPersons();
                break;
            case 2:
                t.displayTeachers();
                break;
            case 3: 
                t.displayStudents();
                break;
            case 4:
                Menu m = new PersonTypeMenu("Select the type", new String[] {"Exit", "Simple person", "Teacher", "Student"}, t);
                m.run();
            case 5:
                super.clear();
                break;
        }
    }
    
    
    
}
