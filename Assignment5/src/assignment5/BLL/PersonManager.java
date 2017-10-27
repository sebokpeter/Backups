/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5.BLL;

import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author sebok
 */
public class PersonManager
{
    private List<Person> persons;
    
    public PersonManager()
    {
        persons = new ArrayList();
        addDefaultPersons();
    }
    
        private void addDefaultPersons()
    {
        String[] names = new String[] {"Hans Nielsen", "Niels Hansen", "Ib Boesen"};
        
        Teacher t1 = new Teacher(4, "Bent H. Pedersen");
        t1.addSubject("Programming");
        
        Student s1 = new Student(5, "Bo Ibsen ", "CS");
        s1.addGrade(new GradeInfo("CS", 10));
        s1.addGrade(new GradeInfo("CS", 6));
        
        for (int i = 0; i < names.length; i++)
        {
            int j = i;
            persons.add(new SimplePerson(j++, names[i]));
        }
        
        persons.add(s1);                
        persons.add(t1);
    }
    
    public void addPerson(Person p)
    {
        //If the list already contains a person with this name, do not add that person to the list
        for (Person person : persons)
        {
            if (person.getName().equals(p.getName()))
            {
                return;
            }
        }
        persons.add(p);
    }
    
    public void removePerson(String name)
    {
        for (Person person : persons)
        {
            if(person.getName().equals(name))
            {
                persons.remove(person);
                return;
            }
        }
    }
    
    public Person getPerson(String name)
    {
        for (Person person : persons)
        {
            if(person.getName().equals(name))
            {
                return person;
            }
        }
        
        return null;
    }
    
    public List<Person> getAllPersons()
    {
        return persons;
    }

    
     public List<Person> getSimplePersons()
    {
        List<Person> simple = new ArrayList();
        for (Person person : persons)
        {
            if(SimplePerson.class.isInstance(person))
            {
                simple.add(person);
            }
        }
        
        return simple;
    }
     
     public ObservableList<Person> getObservablePersons()
     {
         ObservableList<Person> simpleObservable = FXCollections.observableArrayList();
              
        for (Person person : persons)
        {
            if(SimplePerson.class.isInstance(person))
            {
                simpleObservable.add(person);
            }
         }
        
        return simpleObservable;
     }
    
    
    public List<Person> getTeachers()
    {
        List<Person> teachers = new ArrayList();
        for (Person person : persons)
        {
            if(Teacher.class.isInstance(person))
            {
                teachers.add(person);
            }
        }
        
        return teachers;
    }
    
    public ObservableList<Teacher> getObservableTeachers()
    {
        ObservableList<Teacher> teacherObservable = FXCollections.observableArrayList();
              
        for (Person person : persons)
        {
            if(Teacher.class.isInstance(person))
            {
                teacherObservable.add((Teacher)person);
            }
         }
        
        return teacherObservable;
     }
    
    public List<Person> getStudents()
    {
        List<Person> students = new ArrayList();
        for (Person person : persons)
        {
            if(Student.class.isInstance(person))
            {
                students.add(person);
            }
        }
        
        return students;
    }    
    
    public ObservableList<Person> getObservableStudents()
    {
        ObservableList<Person> studentObservable = FXCollections.observableArrayList();
              
        for (Person person : persons)
        {
            if(Student.class.isInstance(person))
            {
                studentObservable.add(person);
            }
         }
        
        return studentObservable;
     }
    
    public int getNextID()
    {
        return persons.size()+1;
    }
    
}



