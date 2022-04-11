/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dormsignout;

import java.util.ArrayList;

/**
 *
 * @author frank
 */

//import java.util.ArrayList;
public class SignOutInfo {
    
    private String friends; //string
    private String location;
    private String teacher;
    //private String dorm;
    private String timeLeaving;
    private String timeBack;
    private boolean isBack;
    private String date;
    private Student studentInfo;

    
    public SignOutInfo(String friends, String location, String teacher, String timeLeaving, String timeBack, String isBack, String date, Student studentInfo)
    {
//        this.dorm = dorm;
        this.friends = friends;
        this.location = location;
        this.teacher = teacher;
        this.timeBack = timeBack;
        this.timeLeaving = timeLeaving;
        this.studentInfo = studentInfo;
        if(isBack.equals("0"))
        {
            this.isBack = true;
        }
        else
        {
            this.isBack = false;
        }
        this.date = date;
    }
    
    public SignOutInfo()
    {
//        this.dorm = null;
        this.friends = null;
        this.location = null;
        this.teacher = null;
        this.timeBack = null;
        this.timeLeaving = null;
        this.isBack = false;  
        this.date = null;
        this.studentInfo = null;
    }
    
//    public String getDrom()
//    {
//        return dorm;
//    }
    
    public String getFriends()
    {
        return friends;
    }
    
    public String getLocation()
    {
        return location;
    }
    
    public String getDate()
    {
        return date;
    }
    
    public String getTeacher()
    {
        return teacher;
    }
    
    public String getTimeBack()
    {
        return timeBack;
    }
    
    public Student getStudentInfo()
    {
        return studentInfo;
    }
    
    public String getTimeLeaving()
    {
        return timeLeaving;
    }
    
    public boolean backOrNot()
    {
        return isBack;
    }
    
//    public void setDorm(String dorm)
//    {
//        this.dorm = dorm;
//    }
    
    public void setFriends(String friends)
    {
        this.friends = friends;
    }
    
    public void setLocation(String location)
    {
        this.location = location;
    }
    
    public void setTeacher(String teacher)
    {
        this.teacher = teacher;
    }
    
    public void setTimeBack(String timeBack)
    {
        this.timeBack = timeBack;
    }
    
    public void setDate(String date)
    {
        this.date = date;
    }
    
    public void setTimeLeaving(String timeLeaving)
    {
        this.timeLeaving = timeLeaving;
    }
    
    public void setBack(boolean isBack)
    {
        this.isBack = isBack;
    }
    
    public void setStudentInfo(Student studentInfo)
    {
        this.studentInfo = studentInfo;
    }
}
