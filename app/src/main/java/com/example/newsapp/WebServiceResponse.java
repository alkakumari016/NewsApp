package com.example.newsapp;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WebServiceResponse {

    @SerializedName("articles")
    private List<Article> mArtices;

    @SerializedName("status")
    private String mStatus;

    @SerializedName("totalResults")
    private long mtotalResults;

    public List<Article> getmArtices() {
        return mArtices;
    }

    public void setmArtices(List<Article> mArtices) {
        this.mArtices = mArtices;
    }

    public String getmStatus() {
        return mStatus;
    }

    public void setmStatus(String mStatus) {
        this.mStatus = mStatus;
    }

    public long getMtotalResults() {
        return mtotalResults;
    }

    public void setMtotalResults(long mtotalResults) {
        this.mtotalResults = mtotalResults;
    }
}
