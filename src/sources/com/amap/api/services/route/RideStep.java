package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class RideStep implements Parcelable {
    public static final Parcelable.Creator<RideStep> CREATOR = new Parcelable.Creator<RideStep>() { // from class: com.amap.api.services.route.RideStep.1
        private static RideStep a(Parcel parcel) {
            return new RideStep(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RideStep createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RideStep[] newArray(int i10) {
            return a(i10);
        }

        private static RideStep[] a(int i10) {
            return new RideStep[i10];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f8853a;

    /* renamed from: b, reason: collision with root package name */
    private String f8854b;

    /* renamed from: c, reason: collision with root package name */
    private String f8855c;

    /* renamed from: d, reason: collision with root package name */
    private float f8856d;

    /* renamed from: e, reason: collision with root package name */
    private float f8857e;

    /* renamed from: f, reason: collision with root package name */
    private List<LatLonPoint> f8858f;

    /* renamed from: g, reason: collision with root package name */
    private String f8859g;

    /* renamed from: h, reason: collision with root package name */
    private String f8860h;

    /* renamed from: i, reason: collision with root package name */
    private int f8861i;

    public RideStep() {
        this.f8858f = new ArrayList();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAction() {
        return this.f8859g;
    }

    public String getAssistantAction() {
        return this.f8860h;
    }

    public float getDistance() {
        return this.f8856d;
    }

    public float getDuration() {
        return this.f8857e;
    }

    public String getInstruction() {
        return this.f8853a;
    }

    public String getOrientation() {
        return this.f8854b;
    }

    public List<LatLonPoint> getPolyline() {
        return this.f8858f;
    }

    public String getRoad() {
        return this.f8855c;
    }

    public int getRoadType() {
        return this.f8861i;
    }

    public void setAction(String str) {
        this.f8859g = str;
    }

    public void setAssistantAction(String str) {
        this.f8860h = str;
    }

    public void setDistance(float f10) {
        this.f8856d = f10;
    }

    public void setDuration(float f10) {
        this.f8857e = f10;
    }

    public void setInstruction(String str) {
        this.f8853a = str;
    }

    public void setOrientation(String str) {
        this.f8854b = str;
    }

    public void setPolyline(List<LatLonPoint> list) {
        this.f8858f = list;
    }

    public void setRoad(String str) {
        this.f8855c = str;
    }

    public void setRoadType(int i10) {
        this.f8861i = i10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f8853a);
        parcel.writeString(this.f8854b);
        parcel.writeString(this.f8855c);
        parcel.writeFloat(this.f8856d);
        parcel.writeFloat(this.f8857e);
        parcel.writeTypedList(this.f8858f);
        parcel.writeString(this.f8859g);
        parcel.writeString(this.f8860h);
    }

    public RideStep(Parcel parcel) {
        this.f8858f = new ArrayList();
        this.f8853a = parcel.readString();
        this.f8854b = parcel.readString();
        this.f8855c = parcel.readString();
        this.f8856d = parcel.readFloat();
        this.f8857e = parcel.readFloat();
        this.f8858f = parcel.createTypedArrayList(LatLonPoint.CREATOR);
        this.f8859g = parcel.readString();
        this.f8860h = parcel.readString();
    }
}
