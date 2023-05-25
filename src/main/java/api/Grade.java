package api;

import java.io.Serializable;
import java.util.Objects;

public class Grade implements Serializable {
    private String lessonName;
    private int lessonGrade;

    public Grade(String lessonName, int lessonGrade) {
        this.lessonName = lessonName;
        this.lessonGrade = lessonGrade;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public int getLessonGrade() {
        return lessonGrade;
    }

    public void setLessonGrade(int lessonGrade) {
        this.lessonGrade = lessonGrade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Grade grade)) return false;

        return Objects.equals(lessonName, grade.lessonName);
    }

    @Override
    public int hashCode() {
        return lessonName != null ? lessonName.hashCode() : 0;
    }
}
