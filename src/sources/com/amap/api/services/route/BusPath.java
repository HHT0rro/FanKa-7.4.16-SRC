package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class BusPath extends Path {
    public static final Parcelable.Creator<BusPath> CREATOR = new Parcelable.Creator<BusPath>() { // from class: com.amap.api.services.route.BusPath.1
        private static BusPath a(Parcel parcel) {
            return new BusPath(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BusPath createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ BusPath[] newArray(int i10) {
            return null;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private float f8711a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f8712b;

    /* renamed from: c, reason: collision with root package name */
    private float f8713c;

    /* renamed from: d, reason: collision with root package name */
    private float f8714d;

    /* renamed from: e, reason: collision with root package name */
    private List<BusStep> f8715e;

    public BusPath(Parcel parcel) {
        super(parcel);
        this.f8715e = new ArrayList();
        this.f8711a = parcel.readFloat();
        boolean[] zArr = new boolean[1];
        parcel.readBooleanArray(zArr);
        this.f8712b = zArr[0];
        this.f8713c = parcel.readFloat();
        this.f8714d = parcel.readFloat();
        this.f8715e = parcel.createTypedArrayList(BusStep.CREATOR);
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getBusDistance() {
        return this.f8714d;
    }

    public float getCost() {
        return this.f8711a;
    }

    public List<BusStep> getSteps() {
        return this.f8715e;
    }

    public float getWalkDistance() {
        return this.f8713c;
    }

    public boolean isNightBus() {
        return this.f8712b;
    }

    public void setBusDistance(float f10) {
        this.f8714d = f10;
    }

    public void setCost(float f10) {
        this.f8711a = f10;
    }

    public void setNightBus(boolean z10) {
        this.f8712b = z10;
    }

    public void setSteps(List<BusStep> list) {
        this.f8715e = list;
    }

    public void setWalkDistance(float f10) {
        this.f8713c = f10;
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeFloat(this.f8711a);
        parcel.writeBooleanArray(new boolean[]{this.f8712b});
        parcel.writeFloat(this.f8713c);
        parcel.writeFloat(this.f8714d);
        parcel.writeTypedList(this.f8715e);
    }

    public BusPath() {
        this.f8715e = new ArrayList();
    }
}
