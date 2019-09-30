package com.example.newsapp;

import com.google.gson.annotations.SerializedName;

public class Source {

    @SerializedName("id")
    private  String mId;
    @SerializedName("name")
    private  String mName;

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }
}
