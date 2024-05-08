package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class DrivePath extends Path {
    public static final Parcelable.Creator<DrivePath> CREATOR = new Parcelable.Creator<DrivePath>() { // from class: com.amap.api.services.route.DrivePath.1
        private static DrivePath a(Parcel parcel) {
            return new DrivePath(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DrivePath createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ DrivePath[] newArray(int i10) {
            return null;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f8775a;

    /* renamed from: b, reason: collision with root package name */
    private float f8776b;

    /* renamed from: c, reason: collision with root package name */
    private float f8777c;

    /* renamed from: d, reason: collision with root package name */
    private int f8778d;

    /* renamed from: e, reason: collision with root package name */
    private List<DriveStep> f8779e;

    /* renamed from: f, reason: collision with root package name */
    private int f8780f;

    public DrivePath(Parcel parcel) {
        super(parcel);
        this.f8779e = new ArrayList();
        this.f8775a = parcel.readString();
        this.f8776b = parcel.readFloat();
        this.f8777c = parcel.readFloat();
        this.f8779e = parcel.createTypedArrayList(DriveStep.CREATOR);
        this.f8778d = parcel.readInt();
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getRestriction() {
        return this.f8780f;
    }

    public List<DriveStep> getSteps() {
        return this.f8779e;
    }

    public String getStrategy() {
        return this.f8775a;
    }

    public float getTollDistance() {
        return this.f8777c;
    }

    public float getTolls() {
        return this.f8776b;
    }

    public int getTotalTrafficlights() {
        return this.f8778d;
    }

    public void setRestriction(int i10) {
        this.f8780f = i10;
    }

    public void setSteps(List<DriveStep> list) {
        this.f8779e = list;
    }

    public void setStrategy(String str) {
        this.f8775a = str;
    }

    public void setTollDistance(float f10) {
        this.f8777c = f10;
    }

    public void setTolls(float f10) {
        this.f8776b = f10;
    }

    public void setTotalTrafficlights(int i10) {
        this.f8778d = i10;
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeString(this.f8775a);
        parcel.writeFloat(this.f8776b);
        parcel.writeFloat(this.f8777c);
        parcel.writeTypedList(this.f8779e);
        parcel.writeInt(this.f8778d);
    }

    public DrivePath() {
        this.f8779e = new ArrayList();
    }
}
