package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class TruckPath implements Parcelable {
    public static final Parcelable.Creator<TruckPath> CREATOR = new Parcelable.Creator<TruckPath>() { // from class: com.amap.api.services.route.TruckPath.1
        private static TruckPath a(Parcel parcel) {
            return new TruckPath(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ TruckPath createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ TruckPath[] newArray(int i10) {
            return a(i10);
        }

        private static TruckPath[] a(int i10) {
            return new TruckPath[i10];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private float f9029a;

    /* renamed from: b, reason: collision with root package name */
    private long f9030b;

    /* renamed from: c, reason: collision with root package name */
    private String f9031c;

    /* renamed from: d, reason: collision with root package name */
    private float f9032d;

    /* renamed from: e, reason: collision with root package name */
    private float f9033e;

    /* renamed from: f, reason: collision with root package name */
    private int f9034f;

    /* renamed from: g, reason: collision with root package name */
    private int f9035g;

    /* renamed from: h, reason: collision with root package name */
    private List<TruckStep> f9036h;

    public TruckPath() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getDistance() {
        return this.f9029a;
    }

    public long getDuration() {
        return this.f9030b;
    }

    public int getRestriction() {
        return this.f9035g;
    }

    public List<TruckStep> getSteps() {
        return this.f9036h;
    }

    public String getStrategy() {
        return this.f9031c;
    }

    public float getTollDistance() {
        return this.f9033e;
    }

    public float getTolls() {
        return this.f9032d;
    }

    public int getTotalTrafficlights() {
        return this.f9034f;
    }

    public void setDistance(float f10) {
        this.f9029a = f10;
    }

    public void setDuration(long j10) {
        this.f9030b = j10;
    }

    public void setRestriction(int i10) {
        this.f9035g = i10;
    }

    public void setSteps(List<TruckStep> list) {
        this.f9036h = list;
    }

    public void setStrategy(String str) {
        this.f9031c = str;
    }

    public void setTollDistance(float f10) {
        this.f9033e = f10;
    }

    public void setTolls(float f10) {
        this.f9032d = f10;
    }

    public void setTotalTrafficlights(int i10) {
        this.f9034f = i10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeFloat(this.f9029a);
        parcel.writeLong(this.f9030b);
        parcel.writeString(this.f9031c);
        parcel.writeFloat(this.f9032d);
        parcel.writeFloat(this.f9033e);
        parcel.writeInt(this.f9034f);
        parcel.writeInt(this.f9035g);
        parcel.writeTypedList(this.f9036h);
    }

    public TruckPath(Parcel parcel) {
        this.f9029a = parcel.readFloat();
        this.f9030b = parcel.readLong();
        this.f9031c = parcel.readString();
        this.f9032d = parcel.readFloat();
        this.f9033e = parcel.readFloat();
        this.f9034f = parcel.readInt();
        this.f9035g = parcel.readInt();
        this.f9036h = parcel.createTypedArrayList(TruckStep.CREATOR);
    }
}
