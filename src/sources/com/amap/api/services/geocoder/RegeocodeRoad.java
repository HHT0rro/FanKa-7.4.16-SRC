package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class RegeocodeRoad implements Parcelable {
    public static final Parcelable.Creator<RegeocodeRoad> CREATOR = new Parcelable.Creator<RegeocodeRoad>() { // from class: com.amap.api.services.geocoder.RegeocodeRoad.1
        private static RegeocodeRoad a(Parcel parcel) {
            return new RegeocodeRoad(parcel, (byte) 0);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RegeocodeRoad createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ RegeocodeRoad[] newArray(int i10) {
            return null;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f8562a;

    /* renamed from: b, reason: collision with root package name */
    private String f8563b;

    /* renamed from: c, reason: collision with root package name */
    private float f8564c;

    /* renamed from: d, reason: collision with root package name */
    private String f8565d;

    /* renamed from: e, reason: collision with root package name */
    private LatLonPoint f8566e;

    public /* synthetic */ RegeocodeRoad(Parcel parcel, byte b4) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String getDirection() {
        return this.f8565d;
    }

    public final float getDistance() {
        return this.f8564c;
    }

    public final String getId() {
        return this.f8562a;
    }

    public final LatLonPoint getLatLngPoint() {
        return this.f8566e;
    }

    public final String getName() {
        return this.f8563b;
    }

    public final void setDirection(String str) {
        this.f8565d = str;
    }

    public final void setDistance(float f10) {
        this.f8564c = f10;
    }

    public final void setId(String str) {
        this.f8562a = str;
    }

    public final void setLatLngPoint(LatLonPoint latLonPoint) {
        this.f8566e = latLonPoint;
    }

    public final void setName(String str) {
        this.f8563b = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f8562a);
        parcel.writeString(this.f8563b);
        parcel.writeFloat(this.f8564c);
        parcel.writeString(this.f8565d);
        parcel.writeValue(this.f8566e);
    }

    public RegeocodeRoad() {
    }

    private RegeocodeRoad(Parcel parcel) {
        this.f8562a = parcel.readString();
        this.f8563b = parcel.readString();
        this.f8564c = parcel.readFloat();
        this.f8565d = parcel.readString();
        this.f8566e = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
    }
}
