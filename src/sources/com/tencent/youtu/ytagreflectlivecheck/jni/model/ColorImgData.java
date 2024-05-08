package com.tencent.youtu.ytagreflectlivecheck.jni.model;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class ColorImgData {
    private long capture_time;
    public String checksum;
    private String image;

    /* renamed from: x, reason: collision with root package name */
    private int f46040x;

    /* renamed from: y, reason: collision with root package name */
    private int f46041y;

    public long getCapture_time() {
        return this.capture_time;
    }

    public String getImage() {
        return this.image;
    }

    public int getX() {
        return this.f46040x;
    }

    public int getY() {
        return this.f46041y;
    }

    public void setCapture_time(long j10) {
        this.capture_time = j10;
    }

    public void setImage(String str) {
        this.image = str;
    }

    public void setX(int i10) {
        this.f46040x = i10;
    }

    public void setY(int i10) {
        this.f46041y = i10;
    }

    public String toString() {
        return "ColorImgData{image='" + this.image + "', capture_time=" + this.capture_time + ", checksum='" + this.checksum + "', x=" + this.f46040x + ", y=" + this.f46041y + '}';
    }
}
