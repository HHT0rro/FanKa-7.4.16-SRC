package com.amap.api.services.routepoisearch;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class RoutePOIItem implements Parcelable {
    public static final Parcelable.Creator<RoutePOIItem> CREATOR = new Parcelable.Creator<RoutePOIItem>() { // from class: com.amap.api.services.routepoisearch.RoutePOIItem.1
        private static RoutePOIItem a(Parcel parcel) {
            return new RoutePOIItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RoutePOIItem createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RoutePOIItem[] newArray(int i10) {
            return a(i10);
        }

        private static RoutePOIItem[] a(int i10) {
            return new RoutePOIItem[i10];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f9068a;

    /* renamed from: b, reason: collision with root package name */
    private String f9069b;

    /* renamed from: c, reason: collision with root package name */
    private LatLonPoint f9070c;

    /* renamed from: d, reason: collision with root package name */
    private float f9071d;

    /* renamed from: e, reason: collision with root package name */
    private float f9072e;

    /* renamed from: f, reason: collision with root package name */
    private String f9073f;

    public RoutePOIItem() {
    }

    public RoutePOIItem(Parcel parcel) {
        this.f9068a = parcel.readString();
        this.f9069b = parcel.readString();
        this.f9070c = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f9071d = parcel.readFloat();
        this.f9072e = parcel.readFloat();
        this.f9073f = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getCPID() {
        return this.f9073f;
    }

    public float getDistance() {
        return this.f9071d;
    }

    public float getDuration() {
        return this.f9072e;
    }

    public String getID() {
        return this.f9068a;
    }

    public LatLonPoint getPoint() {
        return this.f9070c;
    }

    public String getTitle() {
        return this.f9069b;
    }

    public void setCPID(String str) {
        this.f9073f = str;
    }

    public void setDistance(float f10) {
        this.f9071d = f10;
    }

    public void setDuration(float f10) {
        this.f9072e = f10;
    }

    public void setID(String str) {
        this.f9068a = str;
    }

    public void setPoint(LatLonPoint latLonPoint) {
        this.f9070c = latLonPoint;
    }

    public void setTitle(String str) {
        this.f9069b = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f9068a);
        parcel.writeString(this.f9069b);
        parcel.writeParcelable(this.f9070c, i10);
        parcel.writeFloat(this.f9071d);
        parcel.writeFloat(this.f9072e);
        parcel.writeString(this.f9073f);
    }
}
