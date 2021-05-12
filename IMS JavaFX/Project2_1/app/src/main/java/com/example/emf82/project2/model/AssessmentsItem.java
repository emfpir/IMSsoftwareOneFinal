package com.example.emf82.project2.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.UUID;

public class AssessmentsItem implements Parcelable {

    private String assessmentsId;
    private String assessmentsName;
    private String assessmentsType;
    private String assessmentsStart;
    private String assessmentsEnd;
    private String assessmentsCoursesId;

    public AssessmentsItem() {
    }

    public AssessmentsItem(String assessmentsId, String assessmentsName, String assessmentsType,
                           String assessmentsStart, String assessmentsEnd, String assessmentsCoursesId) {
        if (assessmentsId == null) {
            assessmentsId = UUID.randomUUID().toString();
        }

        this.assessmentsId = assessmentsId;
        this.assessmentsName = assessmentsName;
        this.assessmentsType = assessmentsType;
        this.assessmentsStart = assessmentsStart;
        this.assessmentsEnd = assessmentsEnd;
        this.assessmentsCoursesId = assessmentsCoursesId;
    }

    public String getAssessmentsId() {
        return assessmentsId;
    }

    public void setAssessmentsId(String assessmentsId) {
        this.assessmentsId = assessmentsId;
    }

    public String getAssessmentsName() {
        return assessmentsName;
    }

    public void setAssessmentsName(String assessmentsName) {
        this.assessmentsName = assessmentsName;
    }

    public String getAssessmentsType() {
        return assessmentsType;
    }

    public void setAssessmentsType(String assessmentsType) {
        this.assessmentsType = assessmentsType;
    }

    public String getAssessmentsStart() {
        return assessmentsStart;
    }

    public void setAssessmentsStart(String assessmentsStart) {
        this.assessmentsStart = assessmentsStart;
    }

    public String getAssessmentsEnd() {
        return assessmentsEnd;
    }

    public void setAssessmentsEnd(String assessmentsEnd) {
        this.assessmentsEnd = assessmentsEnd;
    }

    public String getAssessmentsCoursesId() {
        return assessmentsCoursesId;
    }

    public void setAssessmentsCoursesId(String assessmentsCoursesId) {
        this.assessmentsCoursesId = assessmentsCoursesId;
    }

    @Override
    public String toString() {
        return "AssessmentsItem{" +
                "assessmentsId='" + assessmentsId + '\'' +
                ", assessmentsName='" + assessmentsName + '\'' +
                ", assessmentsType='" + assessmentsType + '\'' +
                ", assessmentsStart='" + assessmentsStart + '\'' +
                ", assessmentsEnd='" + assessmentsEnd + '\'' +
                ", assessmentsCoursesId='" + assessmentsCoursesId + '\'' +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.assessmentsId);
        dest.writeString(this.assessmentsName);
        dest.writeString(this.assessmentsType);
        dest.writeString(this.assessmentsStart);
        dest.writeString(this.assessmentsEnd);
        dest.writeString(this.assessmentsCoursesId);
    }

    protected AssessmentsItem(Parcel in) {
        this.assessmentsId = in.readString();
        this.assessmentsName = in.readString();
        this.assessmentsType = in.readString();
        this.assessmentsStart = in.readString();
        this.assessmentsEnd = in.readString();
        this.assessmentsCoursesId = in.readString();
    }

    public static final Creator<AssessmentsItem> CREATOR = new Creator<AssessmentsItem>() {
        @Override
        public AssessmentsItem createFromParcel(Parcel source) {
            return new AssessmentsItem(source);
        }

        @Override
        public AssessmentsItem[] newArray(int size) {
            return new AssessmentsItem[size];
        }
    };
}
