/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5.UI;

import java.util.Scanner;

 /**
 * Abstract class implementing the basic functionality of a console based
 * menu class. A menu can be created by sub-classing this class and implement
 * the abstract method doAction(option).
 *
 * The constructor of the sub-class must invoke the super-class constructor by
 * the instruction
 *
 *          super(“some header”, “menuoption1", "menuoption2");
 * 
 * Note, that this instruction must be the first instruction of the sub-class
 * constructor.
 *
 * @author bhp
 */
public abstract class Menu
{
    //Value used to exit the menu
    //Can be changed by sub-class constructor
    protected int EXIT_OPTION = 0;
    
    //Menu header text
    private String header;
    
    //List of menu options texts
    private String[] menuItems;
    
    /**
     *Abstract method stating what should be done, when a menu option is selected
     * Must be overwritten by sub-class
     * @param option the menu option that has been selected
    */
    
    protected abstract void doAction(int option);
    
    /**
     * Creates an instance of the class with the given header text and menu options
     * @param header The header text of the menu
     * @param menuItems the list of menu items
     */
    public Menu(String header, String[] menuItems)
    {
        this.header = header;
        this.menuItems = menuItems;
    }
    
    /**
     * Executes the menu until EXIT_OPTION is selected
     */
    public void run()
    {
        boolean done = false;
        while(!done)
        {
            showMenu();
            int option = getOption();
            doAction(option);
            
            if(option == EXIT_OPTION)
            {
                done = true;
            }
        }
    }
    
    /**
     * Returns a valid menu option from the keyboard
     * Continues prompting for a valid value
     * @return a valid menu option
     */
    private int getOption()
    {
        int input = getInput();
        
        while (input < EXIT_OPTION || input > menuItems.length)
        {            
            System.out.println("Invalid selection! Please select a valid option!");
            input = getInput();
        }
        
        return input;
    }
    
    private int getInput()
    {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.next();
        int input = -1;
        
        if(tryParseInt(inputString))
        {
            input = Integer.parseInt(inputString);
        }
        
        return input;
    }
    
    /**
     * Prints out a console menu with a header text an a list of menu options.
     * The options are numbered starting from 1
     */
    private void showMenu()
    {   
        System.out.println(header);
        int i = 0;
        for (String menuItem : menuItems)
        {
            System.out.println(Integer.toString(i++) + " " + menuItem);
        }
    }
    
    /**
     * Waits until the 'enter' key is pressed
     */
    private void pause()
    {
    }
    
    /**
     * Clears the screen
     */
    protected void clear()
    {
        for (int i = 0; i < 5; i++)
        {
            System.out.println();
        }
    }
    
    /**
     * Checks to see if a string is a valid integer
     * @param s The input string
     * @return True if the string can be converted to a int, false otherwise
     */
    private boolean tryParseInt(String s)
    {
        try
        {
            Integer.parseInt(s);
            return true;
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }
}
