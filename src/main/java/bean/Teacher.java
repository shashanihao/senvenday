package bean;

public class Teacher {
    private Integer id;
    private String teacherName;
    private String teacherAge;
    private String teacherSex;
    private String whichCourse;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherAge() {
        return teacherAge;
    }

    public void setTeacherAge(String teacherAge) {
        this.teacherAge = teacherAge;
    }

    public String getTeacherSex() {
        return teacherSex;
    }

    public void setTeacherSex(String teacherSex) {
        this.teacherSex = teacherSex;
    }

    public String getWhichCourse() {
        return whichCourse;
    }

    public void setWhichCourse(String whichCourse) {
        this.whichCourse = whichCourse;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", teacherName='" + teacherName + '\'' +
                ", teacherAge='" + teacherAge + '\'' +
                ", teacherSex='" + teacherSex + '\'' +
                ", whichCourse='" + whichCourse + '\'' +
                '}';
    }
}
