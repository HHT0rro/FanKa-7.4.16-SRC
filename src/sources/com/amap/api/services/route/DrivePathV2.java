package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class DrivePathV2 extends Path {
    public static final Parcelable.Creator<DrivePathV2> CREATOR = new Parcelable.Creator<DrivePathV2>() { // from class: com.amap.api.services.route.DrivePathV2.1
        private static DrivePathV2 a(Parcel parcel) {
            return new DrivePathV2(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DrivePathV2 createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ DrivePathV2[] newArray(int i10) {
            return null;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f8781a;

    /* renamed from: b, reason: collision with root package name */
    private List<DriveStepV2> f8782b;

    /* renamed from: c, reason: collision with root package name */
    private int f8783c;

    /* renamed from: d, reason: collision with root package name */
    private Cost f8784d;

    /* renamed from: e, reason: collision with root package name */
    private ElecConsumeInfo f8785e;

    /* renamed from: f, reason: collision with root package name */
    private List<ChargeStationInfo> f8786f;

    public DrivePathV2(Parcel parcel) {
        super(parcel);
        this.f8782b = new ArrayList();
        this.f8786f = new ArrayList();
        this.f8781a = parcel.readString();
        this.f8782b = parcel.createTypedArrayList(DriveStepV2.CREATOR);
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<ChargeStationInfo> getChargeStationInfo() {
        return this.f8786f;
    }

    public Cost getCost() {
        return this.f8784d;
    }

    public ElecConsumeInfo getElecConsumeInfo() {
        return this.f8785e;
    }

    public int getRestriction() {
        return this.f8783c;
    }

    public List<DriveStepV2> getSteps() {
        return this.f8782b;
    }

    public String getStrategy() {
        return this.f8781a;
    }

    public void setChargeStationInfo(List<ChargeStationInfo> list) {
        this.f8786f = list;
    }

    public void setCost(Cost cost) {
        this.f8784d = cost;
    }

    public void setElecConsumeInfo(ElecConsumeInfo elecConsumeInfo) {
        this.f8785e = elecConsumeInfo;
    }

    public void setRestriction(int i10) {
        this.f8783c = i10;
    }

    public void setSteps(List<DriveStepV2> list) {
        this.f8782b = list;
    }

    public void setStrategy(String str) {
        this.f8781a = str;
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeTypedList(this.f8782b);
    }

    public DrivePathV2() {
        this.f8782b = new ArrayList();
        this.f8786f = new ArrayList();
    }
}
