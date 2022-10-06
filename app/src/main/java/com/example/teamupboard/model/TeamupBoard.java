package com.example.teamupboard.model;

import android.graphics.Bitmap;

import java.sql.Time;
import java.sql.Timestamp;

public class TeamupBoard {
    private String tbId;
    private String tbMasterId;
    private Timestamp createTime;
    private Timestamp deadline;
    private Timestamp startTime;
    private String tbMasterAdd;
    private String tbTitle;
    private String tbDetail;
    private String tbType;
    private int perNum;
    private Bitmap tbMasterPicture;

    public TeamupBoard(String tbId, String tbTitle, String tbDetail, Bitmap tbMasterPicture) {
        this.tbTitle = tbTitle;
        this.tbDetail = tbDetail;
        this.tbMasterPicture = tbMasterPicture;
    }

    public String getTbTitle() {
        return tbTitle;
    }

    public String getTbId() {
        return tbId;
    }

    public String getTbDetail() {
        return tbDetail;
    }

    public Bitmap getTbMasterPicture() {
        return tbMasterPicture;
    }
}
