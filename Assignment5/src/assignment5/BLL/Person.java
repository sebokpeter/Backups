/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5.BLL;

/**
 *
 * @author sebok
 */
public abstract class Person
{
    private int id;
    private String name;
    private String email;
    

    public Person(int id, String name)
    {
        this.id = id;
        this.name = name;
        generateEmail();
    }
    
    public void setName(String name)
    {
        this.name = name;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getEmail()
    {
        return email;
    }
    
    @Override
    public String toString()
    {
        return (Integer.toString(id) + "\t " + name + "\t " + email);
    }
    
    
    private void generateEmail()
    {
        String[] names = name.split("\\s");
        
        String initials = "";
        
        if (names.length == 2)
        {
            initials = names[0].toLowerCase().substring(0,1) + names[1].toLowerCase().substring(0,2);
            this.email = initials + "@easv.dk";
        }
        else
        {
            for (String name : names)
            {
                initials += name.toLowerCase().substring(0, 1);
            }
            
            this.email = initials + "@easv.dk";
        }
    }

    @Override
    public boolean equals(Object o)
    {
        if(!Person.class.isInstance(o))
        {
            return false;
        }
        
        Person other = (Person)o;
        if(other.id == this.id)
        {
            return true;
        }
        return false;
    }
    
    
}
