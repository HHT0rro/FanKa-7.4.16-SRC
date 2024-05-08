package com.tencent.cloud.huiyansdkface.facelight.provider;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class WillParam implements Parcelable {
    public static final Parcelable.Creator<WillParam> CREATOR = new Parcelable.Creator<WillParam>() { // from class: com.tencent.cloud.huiyansdkface.facelight.provider.WillParam.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public WillParam createFromParcel(Parcel parcel) {
            return new WillParam(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public WillParam[] newArray(int i10) {
            return new WillParam[i10];
        }
    };
    private String A;
    private String B;

    /* renamed from: a, reason: collision with root package name */
    private int f40876a;

    /* renamed from: b, reason: collision with root package name */
    private int f40877b;

    /* renamed from: c, reason: collision with root package name */
    private int f40878c;

    /* renamed from: d, reason: collision with root package name */
    private int f40879d;

    /* renamed from: e, reason: collision with root package name */
    private int f40880e;

    /* renamed from: f, reason: collision with root package name */
    private float f40881f;

    /* renamed from: g, reason: collision with root package name */
    private float f40882g;

    /* renamed from: h, reason: collision with root package name */
    private float f40883h;

    /* renamed from: i, reason: collision with root package name */
    private float f40884i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f40885j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f40886k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f40887l;

    /* renamed from: m, reason: collision with root package name */
    private float f40888m;

    /* renamed from: n, reason: collision with root package name */
    private float f40889n;

    /* renamed from: o, reason: collision with root package name */
    private float f40890o;

    /* renamed from: p, reason: collision with root package name */
    private double f40891p;

    /* renamed from: q, reason: collision with root package name */
    private long f40892q;

    /* renamed from: r, reason: collision with root package name */
    private long f40893r;

    /* renamed from: s, reason: collision with root package name */
    private long f40894s;

    /* renamed from: t, reason: collision with root package name */
    private float f40895t;

    /* renamed from: u, reason: collision with root package name */
    private int f40896u;

    /* renamed from: v, reason: collision with root package name */
    private int f40897v;

    /* renamed from: w, reason: collision with root package name */
    private int f40898w;

    /* renamed from: x, reason: collision with root package name */
    private int f40899x;

    /* renamed from: y, reason: collision with root package name */
    private String f40900y;

    /* renamed from: z, reason: collision with root package name */
    private String f40901z;

    public WillParam() {
    }

    public WillParam(Parcel parcel) {
        this.f40876a = parcel.readInt();
        this.f40877b = parcel.readInt();
        this.f40878c = parcel.readInt();
        this.f40879d = parcel.readInt();
        this.f40880e = parcel.readInt();
        this.f40881f = parcel.readFloat();
        this.f40882g = parcel.readFloat();
        this.f40883h = parcel.readFloat();
        this.f40884i = parcel.readFloat();
        this.f40885j = parcel.readByte() != 0;
        this.f40886k = parcel.readByte() != 0;
        this.f40887l = parcel.readByte() != 0;
        this.f40888m = parcel.readFloat();
        this.f40889n = parcel.readFloat();
        this.f40890o = parcel.readFloat();
        this.f40891p = parcel.readDouble();
        this.f40892q = parcel.readLong();
        this.f40893r = parcel.readLong();
        this.f40894s = parcel.readLong();
        this.f40895t = parcel.readFloat();
        this.f40896u = parcel.readInt();
        this.f40897v = parcel.readInt();
        this.f40898w = parcel.readInt();
        this.f40899x = parcel.readInt();
        this.f40900y = parcel.readString();
        this.f40901z = parcel.readString();
        this.A = parcel.readString();
        this.B = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAnswer() {
        return this.A;
    }

    public int getAsrCurCount() {
        return this.f40898w;
    }

    public int getAsrRequestRetryCount() {
        return this.f40897v;
    }

    public int getAsrRequestTimeout() {
        return this.f40896u;
    }

    public int getAsrRetryCount() {
        return this.f40899x;
    }

    public String getAudio() {
        return this.B;
    }

    public float getBorderTop() {
        return this.f40883h;
    }

    public int getCamHeight() {
        return this.f40877b;
    }

    public int getCamRotate() {
        return this.f40878c;
    }

    public int getCamWidth() {
        return this.f40876a;
    }

    public float getLeft() {
        return this.f40881f;
    }

    public float getLowestPlayVolThre() {
        return this.f40889n;
    }

    public double getMuteThreshold() {
        return this.f40891p;
    }

    public long getMuteTimeout() {
        return this.f40892q;
    }

    public long getMuteWaitTime() {
        return this.f40893r;
    }

    public long getPlayModeWaitTime() {
        return this.f40894s;
    }

    public float getPlayVolThreshold() {
        return this.f40888m;
    }

    public int getPreviewPicHeight() {
        return this.f40880e;
    }

    public int getPreviewPicWidth() {
        return this.f40879d;
    }

    public String getQuestion() {
        return this.f40901z;
    }

    public float getScale() {
        return this.f40884i;
    }

    public float getScreenshotTime() {
        return this.f40890o;
    }

    public float getTop() {
        return this.f40882g;
    }

    public String getWillType() {
        return this.f40900y;
    }

    public float getWillVideoBitrateFactor() {
        return this.f40895t;
    }

    public boolean isPassVolCheck() {
        return this.f40887l;
    }

    public boolean isRecordWillVideo() {
        return this.f40885j;
    }

    public boolean isScreenshot() {
        return this.f40886k;
    }

    public WillParam setAnswer(String str) {
        this.A = str;
        return this;
    }

    public WillParam setAsrCurCount(int i10) {
        this.f40898w = i10;
        return this;
    }

    public WillParam setAsrRequestRetryCount(int i10) {
        this.f40897v = i10;
        return this;
    }

    public WillParam setAsrRequestTimeout(int i10) {
        this.f40896u = i10;
        return this;
    }

    public WillParam setAsrRetryCount(int i10) {
        this.f40899x = i10;
        return this;
    }

    public WillParam setAudio(String str) {
        this.B = str;
        return this;
    }

    public WillParam setBorderTop(float f10) {
        this.f40883h = f10;
        return this;
    }

    public WillParam setCamHeight(int i10) {
        this.f40877b = i10;
        return this;
    }

    public WillParam setCamRotate(int i10) {
        this.f40878c = i10;
        return this;
    }

    public WillParam setCamWidth(int i10) {
        this.f40876a = i10;
        return this;
    }

    public WillParam setLeft(float f10) {
        this.f40881f = f10;
        return this;
    }

    public WillParam setLowestPlayVolThre(float f10) {
        this.f40889n = f10;
        return this;
    }

    public WillParam setMuteThreshold(double d10) {
        this.f40891p = d10;
        return this;
    }

    public WillParam setMuteTimeout(long j10) {
        this.f40892q = j10;
        return this;
    }

    public WillParam setMuteWaitTime(long j10) {
        this.f40893r = j10;
        return this;
    }

    public WillParam setPassVolCheck(boolean z10) {
        this.f40887l = z10;
        return this;
    }

    public WillParam setPlayModeWaitTime(long j10) {
        this.f40894s = j10;
        return this;
    }

    public WillParam setPlayVolThreshold(float f10) {
        this.f40888m = f10;
        return this;
    }

    public WillParam setPreviewPicHeight(int i10) {
        this.f40880e = i10;
        return this;
    }

    public WillParam setPreviewPicWidth(int i10) {
        this.f40879d = i10;
        return this;
    }

    public WillParam setQuestion(String str) {
        this.f40901z = str;
        return this;
    }

    public WillParam setRecordWillVideo(boolean z10) {
        this.f40885j = z10;
        return this;
    }

    public WillParam setScale(float f10) {
        this.f40884i = f10;
        return this;
    }

    public WillParam setScreenshot(boolean z10) {
        this.f40886k = z10;
        return this;
    }

    public WillParam setScreenshotTime(float f10) {
        this.f40890o = f10;
        return this;
    }

    public WillParam setTop(float f10) {
        this.f40882g = f10;
        return this;
    }

    public WillParam setWillType(String str) {
        this.f40900y = str;
        return this;
    }

    public WillParam setWillVideoBitrateFactor(float f10) {
        this.f40895t = f10;
        return this;
    }

    public String toString() {
        return "WillParam{camWidth=" + this.f40876a + ", camHeight=" + this.f40877b + ", camRotate=" + this.f40878c + ", previewPicWidth=" + this.f40879d + ", previewPicHeight=" + this.f40880e + ", left=" + this.f40881f + ", top=" + this.f40882g + ", borderTop=" + this.f40883h + ", scale=" + this.f40884i + ", isRecordWillVideo=" + this.f40885j + ", screenshot=" + this.f40886k + ", isPassVolCheck=" + this.f40887l + ", playVolThreshold=" + this.f40888m + ", lowestPlayVolThre=" + this.f40889n + ", screenshotTime=" + this.f40890o + ", muteThreshold=" + this.f40891p + ", muteTimeout=" + this.f40892q + ", muteWaitTime=" + this.f40893r + ", playModeWaitTime=" + this.f40894s + ", willVideoBitrateFactor=" + this.f40895t + ", asrRequestTimeout=" + this.f40896u + ", asrRequestRetryCount=" + this.f40897v + ", asrCurCount=" + this.f40898w + ", asrRetryCount=" + this.f40899x + ", willType='" + this.f40900y + "', question='" + this.f40901z + "', answer='" + this.A + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f40876a);
        parcel.writeInt(this.f40877b);
        parcel.writeInt(this.f40878c);
        parcel.writeInt(this.f40879d);
        parcel.writeInt(this.f40880e);
        parcel.writeFloat(this.f40881f);
        parcel.writeFloat(this.f40882g);
        parcel.writeFloat(this.f40883h);
        parcel.writeFloat(this.f40884i);
        parcel.writeByte(this.f40885j ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f40886k ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f40887l ? (byte) 1 : (byte) 0);
        parcel.writeFloat(this.f40888m);
        parcel.writeFloat(this.f40889n);
        parcel.writeFloat(this.f40890o);
        parcel.writeDouble(this.f40891p);
        parcel.writeLong(this.f40892q);
        parcel.writeLong(this.f40893r);
        parcel.writeLong(this.f40894s);
        parcel.writeFloat(this.f40895t);
        parcel.writeInt(this.f40896u);
        parcel.writeInt(this.f40897v);
        parcel.writeInt(this.f40898w);
        parcel.writeInt(this.f40899x);
        parcel.writeString(this.f40900y);
        parcel.writeString(this.f40901z);
        parcel.writeString(this.A);
        parcel.writeString(this.B);
    }
}
