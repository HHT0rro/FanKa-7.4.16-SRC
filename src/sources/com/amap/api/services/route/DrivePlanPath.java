package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class DrivePlanPath implements Parcelable {
    public static final Parcelable.Creator<DrivePlanPath> CREATOR = new Parcelable.Creator<DrivePlanPath>() { // from class: com.amap.api.services.route.DrivePlanPath.1
        private static DrivePlanPath a(Parcel parcel) {
            return new DrivePlanPath(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DrivePlanPath createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ DrivePlanPath[] newArray(int i10) {
            return null;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public float f8787a;

    /* renamed from: b, reason: collision with root package name */
    public int f8788b;

    /* renamed from: c, reason: collision with root package name */
    private List<DrivePlanStep> f8789c;

    public DrivePlanPath(Parcel parcel) {
        this.f8789c = new ArrayList();
        this.f8787a = parcel.readFloat();
        this.f8788b = parcel.readInt();
        this.f8789c = parcel.createTypedArrayList(DrivePlanStep.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getDistance() {
        return this.f8787a;
    }

    public List<DrivePlanStep> getSteps() {
        return this.f8789c;
    }

    public float getTrafficLights() {
        return this.f8788b;
    }

    public void setDistance(float f10) {
        this.f8787a = f10;
    }

    public void setSteps(List<DrivePlanStep> list) {
        this.f8789c = list;
    }

    public void setTrafficLights(int i10) {
        this.f8788b = i10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeFloat(this.f8787a);
        parcel.writeInt(this.f8788b);
        parcel.writeTypedList(this.f8789c);
    }

    public DrivePlanPath() {
        this.f8789c = new ArrayList();
    }
}
