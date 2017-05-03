package phromphong.testloginfacebookbyputpictureandname.PutPictureAndName;

import java.util.ArrayList;

/**
 * Created by phrompongkhagtes on 5/1/2017 AD.
 */

public class Student {
    float score;
    String name;

    public Student(String name,float score) {
        this.score = score;
        this.name = name;

    }

    public float getScore() { // แก้ข้อมูลตัวเลข ตรง chart

        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public String getName()
    {

        name = "chopper";
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public static ArrayList<Student> getSampleStudentData(int size){
        ArrayList<Student> student = new ArrayList<>();
        for(int i=0;i<size;i++){
            student.add(new Student("Andriod v"+i,(float)Math.random()*100));
        }
        return student;
    }
}
