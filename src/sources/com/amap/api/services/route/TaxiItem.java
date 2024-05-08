package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class TaxiItem implements Parcelable {
    public static final Parcelable.Creator<TaxiItem> CREATOR = new Parcelable.Creator<TaxiItem>() { // from class: com.amap.api.services.route.TaxiItem.1
        private static TaxiItem a(Parcel parcel) {
            return new TaxiItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ TaxiItem createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ TaxiItem[] newArray(int i10) {
            return a(i10);
        }

        private static TaxiItem[] a(int i10) {
            return new TaxiItem[i10];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private LatLonPoint f9008a;

    /* renamed from: b, reason: collision with root package name */
    private LatLonPoint f9009b;

    /* renamed from: c, reason: collision with root package name */
    private float f9010c;

    /* renamed from: d, reason: collision with root package name */
    private float f9011d;

    /* renamed from: e, reason: collision with root package name */
    private String f9012e;

    /* renamed from: f, reason: collision with root package name */
    private String f9013f;

    public TaxiItem() {
    }

    public TaxiItem(Parcel parcel) {
        this.f9008a = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f9009b = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f9010c = parcel.readFloat();
        this.f9011d = parcel.readFloat();
        this.f9012e = parcel.readString();
        this.f9013f = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LatLonPoint getDestination() {
        return this.f9009b;
    }

    public float getDistance() {
        return this.f9010c;
    }

    public float getDuration() {
        return this.f9011d;
    }

    public LatLonPoint getOrigin() {
        return this.f9008a;
    }

    public String getmSname() {
        return this.f9012e;
    }

    public String getmTname() {
        return this.f9013f;
    }

    public void setDestination(LatLonPoint latLonPoint) {
        this.f9009b = latLonPoint;
    }

    public void setDistance(float f10) {
        this.f9010c = f10;
    }

    public void setDuration(float f10) {
        this.f9011d = f10;
    }

    public void setOrigin(LatLonPoint latLonPoint) {
        this.f9008a = latLonPoint;
    }

    public void setSname(String str) {
        this.f9012e = str;
    }

    public void setTname(String str) {
        this.f9013f = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.f9008a, i10);
        parcel.writeParcelable(this.f9009b, i10);
        parcel.writeFloat(this.f9010c);
        parcel.writeFloat(this.f9011d);
        parcel.writeString(this.f9012e);
        parcel.writeString(this.f9013f);
    }
}
