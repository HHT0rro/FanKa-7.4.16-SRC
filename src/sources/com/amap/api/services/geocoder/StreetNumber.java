package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class StreetNumber implements Parcelable {
    public static final Parcelable.Creator<StreetNumber> CREATOR = new Parcelable.Creator<StreetNumber>() { // from class: com.amap.api.services.geocoder.StreetNumber.1
        private static StreetNumber a(Parcel parcel) {
            return new StreetNumber(parcel, (byte) 0);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ StreetNumber createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ StreetNumber[] newArray(int i10) {
            return null;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f8567a;

    /* renamed from: b, reason: collision with root package name */
    private String f8568b;

    /* renamed from: c, reason: collision with root package name */
    private LatLonPoint f8569c;

    /* renamed from: d, reason: collision with root package name */
    private String f8570d;

    /* renamed from: e, reason: collision with root package name */
    private float f8571e;

    public /* synthetic */ StreetNumber(Parcel parcel, byte b4) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String getDirection() {
        return this.f8570d;
    }

    public final float getDistance() {
        return this.f8571e;
    }

    public final LatLonPoint getLatLonPoint() {
        return this.f8569c;
    }

    public final String getNumber() {
        return this.f8568b;
    }

    public final String getStreet() {
        return this.f8567a;
    }

    public final void setDirection(String str) {
        this.f8570d = str;
    }

    public final void setDistance(float f10) {
        this.f8571e = f10;
    }

    public final void setLatLonPoint(LatLonPoint latLonPoint) {
        this.f8569c = latLonPoint;
    }

    public final void setNumber(String str) {
        this.f8568b = str;
    }

    public final void setStreet(String str) {
        this.f8567a = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f8567a);
        parcel.writeString(this.f8568b);
        parcel.writeValue(this.f8569c);
        parcel.writeString(this.f8570d);
        parcel.writeFloat(this.f8571e);
    }

    public StreetNumber() {
    }

    private StreetNumber(Parcel parcel) {
        this.f8567a = parcel.readString();
        this.f8568b = parcel.readString();
        this.f8569c = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f8570d = parcel.readString();
        this.f8571e = parcel.readFloat();
    }
}
