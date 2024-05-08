package com.inno.innosdk.pb;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class Option {
    public static final int ReportPolicyBatch = 2;
    public static final int ReportPolicyInterval = 1;
    public static final int ReportPolicyNoReport = 3;
    public int report = 3;
    public int interval = 90;
    public boolean isUpTouch = true;
    public boolean isUpGyro = true;
    public boolean bReportJSData = false;
    public String turl = "";
    public String rurl = "";
    public boolean isAppList = true;
    public boolean fcUpload = true;
    public boolean httpsVerify = false;

    public static int getReportPolicyBatch() {
        return 2;
    }

    public static int getReportPolicyInterval() {
        return 1;
    }

    public static int getReportPolicyNoReport() {
        return 3;
    }

    public int getInterval() {
        return this.interval;
    }

    public int getReport() {
        return this.report;
    }

    public String getRurl() {
        return this.rurl;
    }

    public String getTurl() {
        return this.turl;
    }

    public boolean isAppList() {
        return this.isAppList;
    }

    public boolean isHttpsVerify() {
        return this.httpsVerify;
    }

    public boolean isUpGyro() {
        return this.isUpGyro;
    }

    public boolean isUpTouch() {
        return this.isUpTouch;
    }

    public boolean isbReportJSData() {
        return this.bReportJSData;
    }

    public boolean needFcUpload() {
        return this.fcUpload;
    }

    public void setAppList(boolean z10) {
        this.isAppList = z10;
    }

    public void setFcUpload(boolean z10) {
        this.fcUpload = z10;
    }

    public void setHttpsVerify(boolean z10) {
        this.httpsVerify = z10;
    }

    public void setInterval(int i10) {
        this.interval = i10;
    }

    public void setReport(int i10) {
        this.report = i10;
    }

    public void setRurl(String str) {
        this.rurl = str;
    }

    public void setTurl(String str) {
        this.turl = str;
    }

    public void setUpGyro(boolean z10) {
        this.isUpGyro = z10;
    }

    public void setUpTouch(boolean z10) {
        this.isUpTouch = z10;
    }

    public void setbReportJSData(boolean z10) {
        this.bReportJSData = z10;
    }
}
