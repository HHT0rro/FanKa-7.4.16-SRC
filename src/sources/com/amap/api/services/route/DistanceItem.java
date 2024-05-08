package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class DistanceItem implements Parcelable {
    public static final Parcelable.Creator<DistanceItem> CREATOR = new Parcelable.Creator<DistanceItem>() { // from class: com.amap.api.services.route.DistanceItem.1
        private static DistanceItem a(Parcel parcel) {
            return new DistanceItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DistanceItem createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DistanceItem[] newArray(int i10) {
            return a(i10);
        }

        private static DistanceItem[] a(int i10) {
            return new DistanceItem[i10];
        }
    };
    public final int ERROR_CODE_NOT_IN_CHINA;
    public final int ERROR_CODE_NO_DRIVE;
    public final int ERROR_CODE_TOO_FAR;

    /* renamed from: a, reason: collision with root package name */
    private int f8757a;

    /* renamed from: b, reason: collision with root package name */
    private int f8758b;

    /* renamed from: c, reason: collision with root package name */
    private float f8759c;

    /* renamed from: d, reason: collision with root package name */
    private float f8760d;

    /* renamed from: e, reason: collision with root package name */
    private String f8761e;

    /* renamed from: f, reason: collision with root package name */
    private int f8762f;

    public DistanceItem() {
        this.ERROR_CODE_NO_DRIVE = 1;
        this.ERROR_CODE_TOO_FAR = 2;
        this.ERROR_CODE_NOT_IN_CHINA = 3;
        this.f8757a = 1;
        this.f8758b = 1;
        this.f8759c = 0.0f;
        this.f8760d = 0.0f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getDestId() {
        return this.f8758b;
    }

    public float getDistance() {
        return this.f8759c;
    }

    public float getDuration() {
        return this.f8760d;
    }

    public int getErrorCode() {
        return this.f8762f;
    }

    public String getErrorInfo() {
        return this.f8761e;
    }

    public int getOriginId() {
        return this.f8757a;
    }

    public void setDestId(int i10) {
        this.f8758b = i10;
    }

    public void setDistance(float f10) {
        this.f8759c = f10;
    }

    public void setDuration(float f10) {
        this.f8760d = f10;
    }

    public void setErrorCode(int i10) {
        this.f8762f = i10;
    }

    public void setErrorInfo(String str) {
        this.f8761e = str;
    }

    public void setOriginId(int i10) {
        this.f8757a = i10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f8757a);
        parcel.writeInt(this.f8758b);
        parcel.writeFloat(this.f8759c);
        parcel.writeFloat(this.f8760d);
        parcel.writeString(this.f8761e);
        parcel.writeInt(this.f8762f);
    }

    public DistanceItem(Parcel parcel) {
        this.ERROR_CODE_NO_DRIVE = 1;
        this.ERROR_CODE_TOO_FAR = 2;
        this.ERROR_CODE_NOT_IN_CHINA = 3;
        this.f8757a = 1;
        this.f8758b = 1;
        this.f8759c = 0.0f;
        this.f8760d = 0.0f;
        this.f8757a = parcel.readInt();
        this.f8758b = parcel.readInt();
        this.f8759c = parcel.readFloat();
        this.f8760d = parcel.readFloat();
        this.f8761e = parcel.readString();
        this.f8762f = parcel.readInt();
    }
}
