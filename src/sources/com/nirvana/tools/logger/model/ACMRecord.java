package com.nirvana.tools.logger.model;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class ACMRecord {
    public static final int FLAG_ALL = -1;
    public static final int UPLOAD_FLAG_FAILED = 1;
    public static final int UPLOAD_FLAG_NONE = 0;
    public static final int UPLOAD_FLAG_SUCCEED = 2;
    public static final int UPLOAD_STRATEGY_ALL_NETWORK = 2;
    public static final int UPLOAD_STRATEGY_ONLY_WIFI = 1;
    private String content;

    /* renamed from: id, reason: collision with root package name */
    private long f37692id;
    private long timestamp = System.currentTimeMillis();
    private int strategy = 2;
    private int uploadCount = 0;
    private int uploadFlag = 0;

    public String getContent() {
        return this.content;
    }

    public long getId() {
        return this.f37692id;
    }

    public int getStrategy() {
        return this.strategy;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public int getUploadCount() {
        return this.uploadCount;
    }

    public int getUploadFlag() {
        return this.uploadFlag;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setId(long j10) {
        this.f37692id = j10;
    }

    public void setStrategy(int i10) {
        this.strategy = i10;
    }

    public void setTimestamp(long j10) {
        this.timestamp = j10;
    }

    public void setUploadCount(int i10) {
        this.uploadCount = i10;
    }

    public void setUploadFlag(int i10) {
        this.uploadFlag = i10;
    }
}
