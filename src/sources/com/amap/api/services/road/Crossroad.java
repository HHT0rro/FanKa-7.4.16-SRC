package com.amap.api.services.road;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class Crossroad extends Road {
    public static final Parcelable.Creator<Crossroad> CREATOR = new Parcelable.Creator<Crossroad>() { // from class: com.amap.api.services.road.Crossroad.1
        private static Crossroad a(Parcel parcel) {
            return new Crossroad(parcel, (byte) 0);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Crossroad createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Crossroad[] newArray(int i10) {
            return null;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private float f8699a;

    /* renamed from: b, reason: collision with root package name */
    private String f8700b;

    /* renamed from: c, reason: collision with root package name */
    private String f8701c;

    /* renamed from: d, reason: collision with root package name */
    private String f8702d;

    /* renamed from: e, reason: collision with root package name */
    private String f8703e;

    /* renamed from: f, reason: collision with root package name */
    private String f8704f;

    public /* synthetic */ Crossroad(Parcel parcel, byte b4) {
        this(parcel);
    }

    @Override // com.amap.api.services.road.Road, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String getDirection() {
        return this.f8700b;
    }

    public final float getDistance() {
        return this.f8699a;
    }

    public final String getFirstRoadId() {
        return this.f8701c;
    }

    public final String getFirstRoadName() {
        return this.f8702d;
    }

    public final String getSecondRoadId() {
        return this.f8703e;
    }

    public final String getSecondRoadName() {
        return this.f8704f;
    }

    public final void setDirection(String str) {
        this.f8700b = str;
    }

    public final void setDistance(float f10) {
        this.f8699a = f10;
    }

    public final void setFirstRoadId(String str) {
        this.f8701c = str;
    }

    public final void setFirstRoadName(String str) {
        this.f8702d = str;
    }

    public final void setSecondRoadId(String str) {
        this.f8703e = str;
    }

    public final void setSecondRoadName(String str) {
        this.f8704f = str;
    }

    @Override // com.amap.api.services.road.Road, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeFloat(this.f8699a);
        parcel.writeString(this.f8700b);
        parcel.writeString(this.f8701c);
        parcel.writeString(this.f8702d);
        parcel.writeString(this.f8703e);
        parcel.writeString(this.f8704f);
    }

    public Crossroad() {
    }

    private Crossroad(Parcel parcel) {
        super(parcel);
        this.f8699a = parcel.readFloat();
        this.f8700b = parcel.readString();
        this.f8701c = parcel.readString();
        this.f8702d = parcel.readString();
        this.f8703e = parcel.readString();
        this.f8704f = parcel.readString();
    }
}
