package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class DrivePlanStep implements Parcelable {
    public static final Parcelable.Creator<DrivePlanStep> CREATOR = new Parcelable.Creator<DrivePlanStep>() { // from class: com.amap.api.services.route.DrivePlanStep.1
        private static DrivePlanStep a(Parcel parcel) {
            return new DrivePlanStep(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DrivePlanStep createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ DrivePlanStep[] newArray(int i10) {
            return null;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f8790a;

    /* renamed from: b, reason: collision with root package name */
    private String f8791b;

    /* renamed from: c, reason: collision with root package name */
    private float f8792c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f8793d;

    /* renamed from: e, reason: collision with root package name */
    private List<LatLonPoint> f8794e;

    public DrivePlanStep(Parcel parcel) {
        this.f8794e = new ArrayList();
        this.f8790a = parcel.readString();
        this.f8791b = parcel.readString();
        this.f8792c = parcel.readFloat();
        this.f8793d = parcel.readInt() == 1;
        this.f8792c = parcel.readFloat();
        this.f8794e = parcel.createTypedArrayList(LatLonPoint.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAdCode() {
        return this.f8791b;
    }

    public float getDistance() {
        return this.f8792c;
    }

    public List<LatLonPoint> getPolyline() {
        return this.f8794e;
    }

    public String getRoad() {
        return this.f8790a;
    }

    public boolean getToll() {
        return this.f8793d;
    }

    public void setAdCode(String str) {
        this.f8791b = str;
    }

    public void setDistance(float f10) {
        this.f8792c = f10;
    }

    public void setPolyline(List<LatLonPoint> list) {
        this.f8794e = list;
    }

    public void setRoad(String str) {
        this.f8790a = str;
    }

    public void setToll(boolean z10) {
        this.f8793d = z10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f8790a);
        parcel.writeString(this.f8791b);
        parcel.writeFloat(this.f8792c);
        parcel.writeInt(this.f8793d ? 1 : 0);
        parcel.writeFloat(this.f8792c);
        parcel.writeTypedList(this.f8794e);
    }

    public DrivePlanStep() {
        this.f8794e = new ArrayList();
    }
}
