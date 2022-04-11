/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dormsignout;

/**
 *
 * @author frank
 */
import java.util.ArrayList;
public class Student {
   
    private String firstName;
    private String lastName;
    private String dorm;
    private String studentID;
    //private ArrayList<SignOutInfo> signOutData;
    
    
    public Student(String firstName, String lastName, String studentID, String dorm)
    {
       this.firstName = firstName;
       this.lastName = lastName;
       this.studentID = studentID;
       //this.signOutData = signOutData;
    }
    
    //override
//    public Student(String firstName, String lastName, String studentID, String dorm)
//    {
//       this.firstName = firstName;
//       this.lastName = lastName;
//       this.studentID = studentID;
//       this.signOutData = null;
//    }
    
    //override
    public Student()
    {
        this.firstName = null;
        this.lastName = null;
        this.studentID = null;
        //signOutData = new ArrayList<SignOutInfo>();
    }
    
    public String getDorm()
    {
        return dorm;
    }
    
    public String getFirstName()
    {
        return firstName;
    }
    
    public String getLastName()
    {
        return lastName;
    }
    
    public String getStudentID()
    {
        return studentID;
    }
    
//    public ArrayList<SignOutInfo> getSignOutData()
//    {
//        return signOutData;
//    }
    
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
    
    public void setStudentID(String studentID)
    {
        this.studentID = studentID;
    }
    
    public void setDorm(String dorm)
    {
        this.dorm = dorm;
    }
    
//    public void setSignOutData(ArrayList<SignOutInfo> signOutData)
//    {
//        this.signOutData = signOutData;
//    }
}   
