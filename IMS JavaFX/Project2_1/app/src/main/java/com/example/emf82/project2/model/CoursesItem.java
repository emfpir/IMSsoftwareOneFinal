package com.example.emf82.project2.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.UUID;

public class CoursesItem implements Parcelable {

    private String coursesId;
    private String coursesCode;
    private String coursesName;
    private String coursesStart;
    private String coursesEnd;
    private String coursesStatus;
    private String coursesNote;
    private String coursesTermsId;

    public CoursesItem(){}

    public CoursesItem(String coursesId, String coursesCode, String coursesName,
                       String coursesStart, String coursesEnd, String coursesStatus,
                       String coursesNote, String coursesTermsId){
        if (coursesId == null) {
            coursesId = UUID.randomUUID().toString();
        }

        this.coursesId = coursesId;
        this.coursesCode = coursesCode;
        this.coursesName = coursesName;
        this.coursesStart = coursesStart;
        this.coursesEnd = coursesEnd;
        this.coursesStatus = coursesStatus;
        this.coursesNote = coursesNote;
        this.coursesTermsId = coursesTermsId;
    }

    public String getCoursesId() {
        return coursesId;
    }

    public void setCoursesId(String coursesId) {
        this.coursesId = coursesId;
    }

    public String getCoursesCode() {
        return coursesCode;
    }

    public void setCoursesCode(String coursesCode) {
        this.coursesCode = coursesCode;
    }

    public String getCoursesName() {
        return coursesName;
    }

    public void setCoursesName(String coursesName) {
        this.coursesName = coursesName;
    }

    public String getCoursesStart() {
        return coursesStart;
    }

    public void setCoursesStart(String coursesStart) {
        this.coursesStart = coursesStart;
    }

    public String getCoursesEnd() {
        return coursesEnd;
    }

    public void setCoursesEnd(String coursesEnd) {
        this.coursesEnd = coursesEnd;
    }

    public String getCoursesStatus() {
        return coursesStatus;
    }

    public void setCoursesStatus(String coursesStatus) {
        this.coursesStatus = coursesStatus;
    }

    public String getCoursesNote() {
        return coursesNote;
    }

    public void setCoursesNote(String coursesNote) {
        this.coursesNote = coursesNote;
    }

    public String getCoursesTermsId() {
        return coursesTermsId;
    }

    public void setCoursesTermsId(String coursesTermsId) {
        this.coursesTermsId = coursesTermsId;
    }

    @Override
    public String toString() {
        return "CoursesItem{" +
                "coursesId='" + coursesId + '\'' +
                ", coursesCode='" + coursesCode + '\'' +
                ", coursesName='" + coursesName + '\'' +
                ", coursesStart='" + coursesStart + '\'' +
                ", coursesEnd='" + coursesEnd + '\'' +
                ", coursesStatus='" + coursesStatus + '\'' +
                ", coursesNote='" + coursesNote + '\'' +
                ", coursesTermsId='" + coursesTermsId + '\'' +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.coursesId);
        dest.writeString(this.coursesCode);
        dest.writeString(this.coursesName);
        dest.writeString(this.coursesStart);
        dest.writeString(this.coursesEnd);
        dest.writeString(this.coursesStatus);
        dest.writeString(this.coursesNote);
        dest.writeString(this.coursesTermsId);
    }

    protected CoursesItem(Parcel in) {
        this.coursesId = in.readString();
        this.coursesCode = in.readString();
        this.coursesName = in.readString();
        this.coursesStart = in.readString();
        this.coursesEnd = in.readString();
        this.coursesStatus = in.readString();
        this.coursesNote = in.readString();
        this.coursesTermsId = in.readString();
    }

    public static final Creator<CoursesItem> CREATOR = new Creator<CoursesItem>() {
        @Override
        public CoursesItem createFromParcel(Parcel source) {
            return new CoursesItem(source);
        }

        @Override
        public CoursesItem[] newArray(int size) {
            return new CoursesItem[size];
        }
    };
}
