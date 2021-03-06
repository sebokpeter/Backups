/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5.BLL;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sebok
 */
public class Teacher extends Person
{
    private List<String> subjects;
    private String main;
    private String initials;
    private double salary;

    public String getMain()
    {
        return main;
    }
    
    public Teacher(int id, String name)
    {
        super(id, name);
        subjects = new ArrayList();
        this.main = "";
        setInitials();
    }
    
    public Teacher(int id, String name, String main)
    {
        super(id, name);
        subjects = new ArrayList();
        subjects.add(main);
        this.main = main;
        setInitials();
    }
    
    private void setInitials()
    {
        String[] names = super.getName().split("\\s");
        
        initials = "";
        
        if (names.length == 2)
        {
            initials = names[0].toLowerCase().substring(0,1) + names[1].toLowerCase().substring(0,2); 
        }
        else
        {
            for (String currentName : names)
            {
                initials += currentName.toLowerCase().substring(0, 1);
            }
        }
    }
        
    public String getInitials()
    {
        return initials;
    }

    public double getSalary()
    {
        return salary;
    }

    public void setSalary(double salary)
    {
        this.salary = salary;
    }
    
    public void addSubject(String subject)
    {
        this.subjects.add(subject);
        if (this.main.equals(""))
        {
            main = subject;
        }
    }
    
    @Override
    public String toString()
    {
        return super.toString() + "\t " + this.initials + "\t " + subjects.get(0);
    }
}
