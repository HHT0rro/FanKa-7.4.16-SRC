package com.amap.api.services.road;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class Road implements Parcelable {
    public static final Parcelable.Creator<Road> CREATOR = new Parcelable.Creator<Road>() { // from class: com.amap.api.services.road.Road.1
        private static Road a(Parcel parcel) {
            return new Road(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Road createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Road[] newArray(int i10) {
            return null;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f8705a;

    /* renamed from: b, reason: collision with root package name */
    private String f8706b;

    /* renamed from: c, reason: collision with root package name */
    private String f8707c;

    /* renamed from: d, reason: collision with root package name */
    private float f8708d;

    /* renamed from: e, reason: collision with root package name */
    private String f8709e;

    /* renamed from: f, reason: collision with root package name */
    private LatLonPoint f8710f;

    public Road() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LatLonPoint getCenterPoint() {
        return this.f8710f;
    }

    public String getCityCode() {
        return this.f8707c;
    }

    public String getId() {
        return this.f8705a;
    }

    public String getName() {
        return this.f8706b;
    }

    public float getRoadWidth() {
        return this.f8708d;
    }

    public String getType() {
        return this.f8709e;
    }

    public void setCenterPoint(LatLonPoint latLonPoint) {
        this.f8710f = latLonPoint;
    }

    public void setCityCode(String str) {
        this.f8707c = str;
    }

    public void setId(String str) {
        this.f8705a = str;
    }

    public void setName(String str) {
        this.f8706b = str;
    }

    public void setRoadWidth(float f10) {
        this.f8708d = f10;
    }

    public void setType(String str) {
        this.f8709e = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f8705a);
        parcel.writeString(this.f8706b);
        parcel.writeString(this.f8707c);
        parcel.writeFloat(this.f8708d);
        parcel.writeString(this.f8709e);
        parcel.writeValue(this.f8710f);
    }

    public Road(String str, String str2) {
        this.f8705a = str;
        this.f8706b = str2;
    }

    public Road(Parcel parcel) {
        this.f8705a = parcel.readString();
        this.f8706b = parcel.readString();
        this.f8707c = parcel.readString();
        this.f8708d = parcel.readFloat();
        this.f8709e = parcel.readString();
        this.f8710f = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
    }
}
