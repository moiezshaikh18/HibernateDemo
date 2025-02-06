package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class NewStudent {

    @Id
    private int roll_no;
    private String sname;
    private int age;

    public int getRoll_no() {
        return roll_no;
    }

    public void setRoll_no(int roll_no) {
        System.out.println("This is tha student roll number setter");
        this.roll_no = roll_no;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "roll_no=" + roll_no +
                ", sname='" + sname + '\'' +
                ", age=" + age +
                '}';
    }
}
