package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class TimeInfosElement implements Parcelable {
    public static final Parcelable.Creator<TimeInfosElement> CREATOR = new Parcelable.Creator<TimeInfosElement>() { // from class: com.amap.api.services.route.TimeInfosElement.1
        private static TimeInfosElement a(Parcel parcel) {
            return new TimeInfosElement(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ TimeInfosElement createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ TimeInfosElement[] newArray(int i10) {
            return null;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public int f9024a;

    /* renamed from: b, reason: collision with root package name */
    public float f9025b;

    /* renamed from: c, reason: collision with root package name */
    public float f9026c;

    /* renamed from: d, reason: collision with root package name */
    public int f9027d;

    /* renamed from: e, reason: collision with root package name */
    private List<TMC> f9028e;

    public TimeInfosElement(Parcel parcel) {
        this.f9028e = new ArrayList();
        this.f9024a = parcel.readInt();
        this.f9025b = parcel.readFloat();
        this.f9026c = parcel.readFloat();
        this.f9027d = parcel.readInt();
        this.f9028e = parcel.createTypedArrayList(TMC.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getDuration() {
        return this.f9025b;
    }

    public int getPathindex() {
        return this.f9024a;
    }

    public int getRestriction() {
        return this.f9027d;
    }

    public List<TMC> getTMCs() {
        return this.f9028e;
    }

    public float getTolls() {
        return this.f9026c;
    }

    public void setDuration(float f10) {
        this.f9025b = f10;
    }

    public void setPathindex(int i10) {
        this.f9024a = i10;
    }

    public void setRestriction(int i10) {
        this.f9027d = i10;
    }

    public void setTMCs(List<TMC> list) {
        this.f9028e = list;
    }

    public void setTolls(float f10) {
        this.f9026c = f10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f9024a);
        parcel.writeFloat(this.f9025b);
        parcel.writeFloat(this.f9026c);
        parcel.writeInt(this.f9027d);
        parcel.writeTypedList(this.f9028e);
    }

    public TimeInfosElement() {
        this.f9028e = new ArrayList();
    }
}
