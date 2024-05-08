package com.heytap.msp.push.mode;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class DataMessage extends BaseMode {
    private String mAppPackage;
    private String mContent;
    private String mDescription;
    private String mMessageID;
    private int mNotifyID;
    private String mTaskID = "";
    private String mTitle;

    public String getAppPackage() {
        return this.mAppPackage;
    }

    public String getContent() {
        return this.mContent;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public String getMessageID() {
        return this.mMessageID;
    }

    public int getNotifyID() {
        return this.mNotifyID;
    }

    public String getTaskID() {
        return this.mTaskID;
    }

    public String getTitle() {
        return this.mTitle;
    }

    @Override // com.heytap.msp.push.mode.BaseMode
    public int getType() {
        return 4103;
    }

    public void setAppPackage(String str) {
        this.mAppPackage = str;
    }

    public void setContent(String str) {
        this.mContent = str;
    }

    public void setDescription(String str) {
        this.mDescription = str;
    }

    public void setMessageID(String str) {
        this.mMessageID = str;
    }

    public void setNotifyID(int i10) {
        this.mNotifyID = i10;
    }

    public void setTaskID(int i10) {
        this.mTaskID = i10 + "";
    }

    public void setTaskID(String str) {
        this.mTaskID = str;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public String toString() {
        return "DataMessage{mMessageID='" + this.mMessageID + "'mAppPackage='" + this.mAppPackage + "', mTaskID='" + this.mTaskID + "'mTitle='" + this.mTitle + "'mNotifyID='" + this.mNotifyID + "', mContent='" + this.mContent + "', mDescription='" + this.mDescription + "'}";
    }
}
