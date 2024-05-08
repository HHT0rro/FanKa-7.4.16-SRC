package com.alibaba.security.realidentity.utils;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ImageData implements Parcelable {
    public static final Parcelable.Creator<ImageData> CREATOR = new Parcelable.Creator<ImageData>() { // from class: com.alibaba.security.realidentity.utils.ImageData.1
        private static ImageData a(Parcel parcel) {
            return new ImageData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ ImageData createFromParcel(Parcel parcel) {
            return new ImageData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ ImageData[] newArray(int i10) {
            return new ImageData[i10];
        }

        private static ImageData[] a(int i10) {
            return new ImageData[i10];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public String f4052a;

    /* renamed from: b, reason: collision with root package name */
    public int f4053b;

    /* renamed from: c, reason: collision with root package name */
    public String f4054c;

    /* renamed from: d, reason: collision with root package name */
    public String f4055d;

    public ImageData() {
    }

    private String a() {
        return this.f4055d;
    }

    private void b(String str) {
        this.f4052a = str;
    }

    private int c() {
        return this.f4053b;
    }

    private String d() {
        return this.f4054c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ImageData{source='" + this.f4055d + "', path='" + this.f4052a + "', type=" + this.f4053b + ", gestureUrl='" + this.f4054c + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f4052a);
        parcel.writeInt(this.f4053b);
        parcel.writeString(this.f4054c);
        parcel.writeString(this.f4055d);
    }

    public ImageData(Parcel parcel) {
        this.f4052a = parcel.readString();
        this.f4053b = parcel.readInt();
        this.f4054c = parcel.readString();
    }

    private void a(String str) {
        this.f4055d = str;
    }

    private String b() {
        return this.f4052a;
    }

    private void c(String str) {
        this.f4054c = str;
    }

    private void a(int i10) {
        this.f4053b = i10;
    }
}
