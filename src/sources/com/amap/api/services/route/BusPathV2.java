package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class BusPathV2 extends Path {
    public static final Parcelable.Creator<BusPathV2> CREATOR = new Parcelable.Creator<BusPathV2>() { // from class: com.amap.api.services.route.BusPathV2.1
        private static BusPathV2 a(Parcel parcel) {
            return new BusPathV2(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BusPathV2 createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ BusPathV2[] newArray(int i10) {
            return null;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private float f8716a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f8717b;

    /* renamed from: c, reason: collision with root package name */
    private float f8718c;

    /* renamed from: d, reason: collision with root package name */
    private float f8719d;

    /* renamed from: e, reason: collision with root package name */
    private List<BusStepV2> f8720e;

    public BusPathV2(Parcel parcel) {
        super(parcel);
        this.f8720e = new ArrayList();
        this.f8716a = parcel.readFloat();
        boolean[] zArr = new boolean[1];
        parcel.readBooleanArray(zArr);
        this.f8717b = zArr[0];
        this.f8718c = parcel.readFloat();
        this.f8719d = parcel.readFloat();
        this.f8720e = parcel.createTypedArrayList(BusStepV2.CREATOR);
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getBusDistance() {
        return this.f8719d;
    }

    public float getCost() {
        return this.f8716a;
    }

    public List<BusStepV2> getSteps() {
        return this.f8720e;
    }

    public float getWalkDistance() {
        return this.f8718c;
    }

    public boolean isNightBus() {
        return this.f8717b;
    }

    public void setBusDistance(float f10) {
        this.f8719d = f10;
    }

    public void setCost(float f10) {
        this.f8716a = f10;
    }

    public void setNightBus(boolean z10) {
        this.f8717b = z10;
    }

    public void setSteps(List<BusStepV2> list) {
        this.f8720e = list;
    }

    public void setWalkDistance(float f10) {
        this.f8718c = f10;
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeFloat(this.f8716a);
        parcel.writeBooleanArray(new boolean[]{this.f8717b});
        parcel.writeFloat(this.f8718c);
        parcel.writeFloat(this.f8719d);
        parcel.writeTypedList(this.f8720e);
    }

    public BusPathV2() {
        this.f8720e = new ArrayList();
    }
}
