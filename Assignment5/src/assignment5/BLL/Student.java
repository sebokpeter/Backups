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
public class Student extends Person
{
    List<GradeInfo> gradeReport;
    String education;
    
    public Student(int id, String name, String education)
    {
        super(id, name);
        this.education = education;
        gradeReport = new ArrayList();
    }

    public List<GradeInfo> getGradeReport()
    {
        return gradeReport;
    }

    public String getEducation()
    {
        return education;
    }
    
    public double getAvarageGrade()
    {
        double avg = 0.0;
        
        for (GradeInfo gradeInfo : gradeReport)
        {
            avg += gradeInfo.getGrade();
        }
        
        return (avg/gradeReport.size());
    }
    
    public int getGrade(String subject)
    {
        for (GradeInfo gradeInfo : gradeReport)
        {
            if(gradeInfo.getSubject().equals(subject))
            {
                return gradeInfo.getGrade();
            }
        }
        
        return -1;
    }
    
    public void addGrade(GradeInfo grade)
    {
        gradeReport.add(grade);
    }
    
    @Override
    public String toString()
    {
        return super.toString() + "\t " + education + "\t\t " + getAvarageGrade();
    }
    
}
