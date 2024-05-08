package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class PoiNavi implements Parcelable {
    public static final Parcelable.Creator<PoiNavi> CREATOR = new Parcelable.Creator<PoiNavi>() { // from class: com.amap.api.services.poisearch.PoiNavi.1
        private static PoiNavi a(Parcel parcel) {
            return new PoiNavi(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ PoiNavi createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ PoiNavi[] newArray(int i10) {
            return null;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f8626a;

    /* renamed from: b, reason: collision with root package name */
    private LatLonPoint f8627b;

    /* renamed from: c, reason: collision with root package name */
    private LatLonPoint f8628c;

    /* renamed from: d, reason: collision with root package name */
    private String f8629d;

    public PoiNavi() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LatLonPoint getEnter() {
        return this.f8627b;
    }

    public LatLonPoint getExit() {
        return this.f8628c;
    }

    public String getGridCode() {
        return this.f8629d;
    }

    public String getNaviPoiID() {
        return this.f8626a;
    }

    public void setEnter(LatLonPoint latLonPoint) {
        this.f8627b = latLonPoint;
    }

    public void setExit(LatLonPoint latLonPoint) {
        this.f8628c = latLonPoint;
    }

    public void setGridCode(String str) {
        this.f8629d = str;
    }

    public void setNaviPoiID(String str) {
        this.f8626a = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f8626a);
        parcel.writeValue(this.f8627b);
        parcel.writeValue(this.f8628c);
        parcel.writeString(this.f8629d);
    }

    public PoiNavi(String str, LatLonPoint latLonPoint, LatLonPoint latLonPoint2, String str2) {
        this.f8626a = str;
        this.f8627b = latLonPoint;
        this.f8628c = latLonPoint2;
        this.f8629d = str2;
    }

    public PoiNavi(Parcel parcel) {
        this.f8626a = parcel.readString();
        this.f8627b = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f8628c = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f8629d = parcel.readString();
    }
}
