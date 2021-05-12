package com.example.emf82.project2.model;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;

import com.example.emf82.project2.database.termsTable;

import java.util.UUID;

public class TermsItem implements Parcelable {

    private Integer termsId;
    private String termsTitle;
    private String termsStart;
    private String termsEnd;

    public TermsItem() {
    }

    public TermsItem(Integer termsId, String termsTitle, String termsStart, String termsEnd) {



        this.termsId = termsId;
        this.termsTitle = termsTitle;
        this.termsStart = termsStart;
        this.termsEnd = termsEnd;
    }

    public Integer getTermsId() {
        return termsId;
    }

    public void setTermsId(Integer termsId) {
        this.termsId = termsId;
    }

    public String getTermsTitle() {
        return termsTitle;
    }

    public void setTermsTitle(String termsTitle) {
        this.termsTitle = termsTitle;
    }

    public String getTermsStart() {
        return termsStart;
    }

    public void setTermsStart(String termsStart) {
        this.termsStart = termsStart;
    }

    public String getTermsEnd() {
        return termsEnd;
    }

    public void setTermsEnd(String termsEnd) {
        this.termsEnd = termsEnd;
    }

    public ContentValues toValues() {
        ContentValues values = new ContentValues(4);

        values.put(termsTable.COLUMN_TERMS_ID, termsId);
        values.put(termsTable.COLUMN_TERMS_NAME, termsTitle);
        values.put(termsTable.COLUMN_TERMS_START, termsStart);
        values.put(termsTable.COLUMN_TERMS_END, termsEnd);

        return values;
    }

    @Override
    public String toString() {
        return "TermsItem{" +
                "termsId='" + termsId + '\'' +
                ", termsTitle='" + termsTitle + '\'' +
                ", termsStart='" + termsStart + '\'' +
                ", termsEnd='" + termsEnd + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.termsId);
        dest.writeString(this.termsTitle);
        dest.writeString(this.termsStart);
        dest.writeString(this.termsEnd);
    }

    protected TermsItem(Parcel in) {
        this.termsId = in.readInt();
        this.termsTitle = in.readString();
        this.termsStart = in.readString();
        this.termsEnd = in.readString();
    }

    public static final Parcelable.Creator<TermsItem> CREATOR = new Parcelable.Creator<TermsItem>() {
        @Override
        public TermsItem createFromParcel(Parcel source) {
            return new TermsItem(source);
        }

        @Override
        public TermsItem[] newArray(int size) {
            return new TermsItem[size];
        }
    };
}
