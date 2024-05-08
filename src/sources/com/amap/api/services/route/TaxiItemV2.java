package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class TaxiItemV2 implements Parcelable {
    public static final Parcelable.Creator<TaxiItemV2> CREATOR = new Parcelable.Creator<TaxiItemV2>() { // from class: com.amap.api.services.route.TaxiItemV2.1
        private static TaxiItemV2 a(Parcel parcel) {
            return new TaxiItemV2(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ TaxiItemV2 createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ TaxiItemV2[] newArray(int i10) {
            return a(i10);
        }

        private static TaxiItemV2[] a(int i10) {
            return new TaxiItemV2[i10];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private LatLonPoint f9014a;

    /* renamed from: b, reason: collision with root package name */
    private LatLonPoint f9015b;

    /* renamed from: c, reason: collision with root package name */
    private float f9016c;

    /* renamed from: d, reason: collision with root package name */
    private float f9017d;

    /* renamed from: e, reason: collision with root package name */
    private String f9018e;

    /* renamed from: f, reason: collision with root package name */
    private String f9019f;

    /* renamed from: g, reason: collision with root package name */
    private float f9020g;

    /* renamed from: h, reason: collision with root package name */
    private List<LatLonPoint> f9021h;

    public TaxiItemV2() {
        this.f9021h = new ArrayList();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LatLonPoint getDestination() {
        return this.f9015b;
    }

    public float getDistance() {
        return this.f9016c;
    }

    public float getDuration() {
        return this.f9017d;
    }

    public LatLonPoint getOrigin() {
        return this.f9014a;
    }

    public List<LatLonPoint> getPolyline() {
        return this.f9021h;
    }

    public float getPrice() {
        return this.f9020g;
    }

    public String getmSname() {
        return this.f9018e;
    }

    public String getmTname() {
        return this.f9019f;
    }

    public void setDestination(LatLonPoint latLonPoint) {
        this.f9015b = latLonPoint;
    }

    public void setDistance(float f10) {
        this.f9016c = f10;
    }

    public void setDuration(float f10) {
        this.f9017d = f10;
    }

    public void setOrigin(LatLonPoint latLonPoint) {
        this.f9014a = latLonPoint;
    }

    public void setPolyline(List<LatLonPoint> list) {
        this.f9021h = list;
    }

    public void setPrice(float f10) {
        this.f9020g = f10;
    }

    public void setSname(String str) {
        this.f9018e = str;
    }

    public void setTname(String str) {
        this.f9019f = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.f9014a, i10);
        parcel.writeParcelable(this.f9015b, i10);
        parcel.writeFloat(this.f9016c);
        parcel.writeFloat(this.f9017d);
        parcel.writeString(this.f9018e);
        parcel.writeString(this.f9019f);
        parcel.writeFloat(this.f9020g);
        parcel.writeTypedList(this.f9021h);
    }

    public TaxiItemV2(Parcel parcel) {
        this.f9021h = new ArrayList();
        this.f9014a = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f9015b = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f9016c = parcel.readFloat();
        this.f9017d = parcel.readFloat();
        this.f9018e = parcel.readString();
        this.f9019f = parcel.readString();
        this.f9020g = parcel.readFloat();
        this.f9021h = parcel.createTypedArrayList(LatLonPoint.CREATOR);
    }
}
