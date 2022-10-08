package com.example.teamupboard.model;

import android.graphics.Bitmap;

import java.sql.Time;
import java.sql.Timestamp;

public class TeamupBoard {
    private int tbId;
    private String tbMasterId;
    private Timestamp createTime;
    private Timestamp deadline;
    private Timestamp startTime;
    private String tbMasterAdd;
    private String tbTitle;
    private String tbDetail;
    private String[] tbType;
    private int perNum;
    private Bitmap tbMasterPicture;
    private Boolean online;

    public TeamupBoard(int tbId, String tbTitle, String tbDetail, String[] tbType, Bitmap tbMasterPicture, Boolean online) {
        this.tbId = tbId;
        this.tbTitle = tbTitle;
        this.tbDetail = tbDetail;
        this.tbType = tbType;
        this.tbMasterPicture = tbMasterPicture;
        this.online = online;
    }

    public String getTbTitle() {
        return tbTitle;
    }

    public int getTbId() {
        return tbId;
    }

    public String getTbDetail() {
        return tbDetail;
    }

    public Bitmap getTbMasterPicture() {
        return tbMasterPicture;
    }

    public String[] getTbType() {
        return tbType;
    }

    public Boolean getOnline() {
        return online;
    }
}
