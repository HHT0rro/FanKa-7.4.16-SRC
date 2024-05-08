package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class WalkStep implements Parcelable {
    public static final Parcelable.Creator<WalkStep> CREATOR = new Parcelable.Creator<WalkStep>() { // from class: com.amap.api.services.route.WalkStep.1
        private static WalkStep a(Parcel parcel) {
            return new WalkStep(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ WalkStep createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ WalkStep[] newArray(int i10) {
            return null;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f9059a;

    /* renamed from: b, reason: collision with root package name */
    private String f9060b;

    /* renamed from: c, reason: collision with root package name */
    private String f9061c;

    /* renamed from: d, reason: collision with root package name */
    private float f9062d;

    /* renamed from: e, reason: collision with root package name */
    private float f9063e;

    /* renamed from: f, reason: collision with root package name */
    private List<LatLonPoint> f9064f;

    /* renamed from: g, reason: collision with root package name */
    private String f9065g;

    /* renamed from: h, reason: collision with root package name */
    private String f9066h;

    /* renamed from: i, reason: collision with root package name */
    private int f9067i;

    public WalkStep(Parcel parcel) {
        this.f9064f = new ArrayList();
        this.f9059a = parcel.readString();
        this.f9060b = parcel.readString();
        this.f9061c = parcel.readString();
        this.f9062d = parcel.readFloat();
        this.f9063e = parcel.readFloat();
        this.f9064f = parcel.createTypedArrayList(LatLonPoint.CREATOR);
        this.f9065g = parcel.readString();
        this.f9066h = parcel.readString();
        this.f9067i = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAction() {
        return this.f9065g;
    }

    public String getAssistantAction() {
        return this.f9066h;
    }

    public float getDistance() {
        return this.f9062d;
    }

    public float getDuration() {
        return this.f9063e;
    }

    public String getInstruction() {
        return this.f9059a;
    }

    public String getOrientation() {
        return this.f9060b;
    }

    public List<LatLonPoint> getPolyline() {
        return this.f9064f;
    }

    public String getRoad() {
        return this.f9061c;
    }

    public int getRoadType() {
        return this.f9067i;
    }

    public void setAction(String str) {
        this.f9065g = str;
    }

    public void setAssistantAction(String str) {
        this.f9066h = str;
    }

    public void setDistance(float f10) {
        this.f9062d = f10;
    }

    public void setDuration(float f10) {
        this.f9063e = f10;
    }

    public void setInstruction(String str) {
        this.f9059a = str;
    }

    public void setOrientation(String str) {
        this.f9060b = str;
    }

    public void setPolyline(List<LatLonPoint> list) {
        this.f9064f = list;
    }

    public void setRoad(String str) {
        this.f9061c = str;
    }

    public void setRoadType(int i10) {
        this.f9067i = i10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f9059a);
        parcel.writeString(this.f9060b);
        parcel.writeString(this.f9061c);
        parcel.writeFloat(this.f9062d);
        parcel.writeFloat(this.f9063e);
        parcel.writeTypedList(this.f9064f);
        parcel.writeString(this.f9065g);
        parcel.writeString(this.f9066h);
        parcel.writeInt(this.f9067i);
    }

    public WalkStep() {
        this.f9064f = new ArrayList();
    }
}
