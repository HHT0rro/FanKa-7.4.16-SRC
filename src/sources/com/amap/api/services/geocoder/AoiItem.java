package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class AoiItem implements Parcelable {
    public static final Parcelable.Creator<AoiItem> CREATOR = new Parcelable.Creator<AoiItem>() { // from class: com.amap.api.services.geocoder.AoiItem.1
        private static AoiItem a(Parcel parcel) {
            return new AoiItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AoiItem createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AoiItem[] newArray(int i10) {
            return a(i10);
        }

        private static AoiItem[] a(int i10) {
            return new AoiItem[i10];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f8511a;

    /* renamed from: b, reason: collision with root package name */
    private String f8512b;

    /* renamed from: c, reason: collision with root package name */
    private String f8513c;

    /* renamed from: d, reason: collision with root package name */
    private LatLonPoint f8514d;

    /* renamed from: e, reason: collision with root package name */
    private Float f8515e;

    public AoiItem() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAdCode() {
        return this.f8513c;
    }

    public Float getAoiArea() {
        return this.f8515e;
    }

    public LatLonPoint getAoiCenterPoint() {
        return this.f8514d;
    }

    public String getAoiId() {
        return this.f8511a;
    }

    public String getAoiName() {
        return this.f8512b;
    }

    public void setAdcode(String str) {
        this.f8513c = str;
    }

    public void setArea(Float f10) {
        this.f8515e = f10;
    }

    public void setId(String str) {
        this.f8511a = str;
    }

    public void setLocation(LatLonPoint latLonPoint) {
        this.f8514d = latLonPoint;
    }

    public void setName(String str) {
        this.f8512b = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f8511a);
        parcel.writeString(this.f8512b);
        parcel.writeString(this.f8513c);
        parcel.writeParcelable(this.f8514d, i10);
        parcel.writeFloat(this.f8515e.floatValue());
    }

    public AoiItem(Parcel parcel) {
        this.f8511a = parcel.readString();
        this.f8512b = parcel.readString();
        this.f8513c = parcel.readString();
        this.f8514d = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f8515e = Float.valueOf(parcel.readFloat());
    }
}
