package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class DriveStep implements Parcelable {
    public static final Parcelable.Creator<DriveStep> CREATOR = new Parcelable.Creator<DriveStep>() { // from class: com.amap.api.services.route.DriveStep.1
        private static DriveStep a(Parcel parcel) {
            return new DriveStep(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DriveStep createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ DriveStep[] newArray(int i10) {
            return null;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f8804a;

    /* renamed from: b, reason: collision with root package name */
    private String f8805b;

    /* renamed from: c, reason: collision with root package name */
    private String f8806c;

    /* renamed from: d, reason: collision with root package name */
    private float f8807d;

    /* renamed from: e, reason: collision with root package name */
    private float f8808e;

    /* renamed from: f, reason: collision with root package name */
    private float f8809f;

    /* renamed from: g, reason: collision with root package name */
    private String f8810g;

    /* renamed from: h, reason: collision with root package name */
    private float f8811h;

    /* renamed from: i, reason: collision with root package name */
    private List<LatLonPoint> f8812i;

    /* renamed from: j, reason: collision with root package name */
    private String f8813j;

    /* renamed from: k, reason: collision with root package name */
    private String f8814k;

    /* renamed from: l, reason: collision with root package name */
    private List<RouteSearchCity> f8815l;

    /* renamed from: m, reason: collision with root package name */
    private List<TMC> f8816m;

    public DriveStep(Parcel parcel) {
        this.f8812i = new ArrayList();
        this.f8815l = new ArrayList();
        this.f8816m = new ArrayList();
        this.f8804a = parcel.readString();
        this.f8805b = parcel.readString();
        this.f8806c = parcel.readString();
        this.f8807d = parcel.readFloat();
        this.f8808e = parcel.readFloat();
        this.f8809f = parcel.readFloat();
        this.f8810g = parcel.readString();
        this.f8811h = parcel.readFloat();
        this.f8812i = parcel.createTypedArrayList(LatLonPoint.CREATOR);
        this.f8813j = parcel.readString();
        this.f8814k = parcel.readString();
        this.f8815l = parcel.createTypedArrayList(RouteSearchCity.CREATOR);
        this.f8816m = parcel.createTypedArrayList(TMC.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAction() {
        return this.f8813j;
    }

    public String getAssistantAction() {
        return this.f8814k;
    }

    public float getDistance() {
        return this.f8807d;
    }

    public float getDuration() {
        return this.f8811h;
    }

    public String getInstruction() {
        return this.f8804a;
    }

    public String getOrientation() {
        return this.f8805b;
    }

    public List<LatLonPoint> getPolyline() {
        return this.f8812i;
    }

    public String getRoad() {
        return this.f8806c;
    }

    public List<RouteSearchCity> getRouteSearchCityList() {
        return this.f8815l;
    }

    public List<TMC> getTMCs() {
        return this.f8816m;
    }

    public float getTollDistance() {
        return this.f8809f;
    }

    public String getTollRoad() {
        return this.f8810g;
    }

    public float getTolls() {
        return this.f8808e;
    }

    public void setAction(String str) {
        this.f8813j = str;
    }

    public void setAssistantAction(String str) {
        this.f8814k = str;
    }

    public void setDistance(float f10) {
        this.f8807d = f10;
    }

    public void setDuration(float f10) {
        this.f8811h = f10;
    }

    public void setInstruction(String str) {
        this.f8804a = str;
    }

    public void setOrientation(String str) {
        this.f8805b = str;
    }

    public void setPolyline(List<LatLonPoint> list) {
        this.f8812i = list;
    }

    public void setRoad(String str) {
        this.f8806c = str;
    }

    public void setRouteSearchCityList(List<RouteSearchCity> list) {
        this.f8815l = list;
    }

    public void setTMCs(List<TMC> list) {
        this.f8816m = list;
    }

    public void setTollDistance(float f10) {
        this.f8809f = f10;
    }

    public void setTollRoad(String str) {
        this.f8810g = str;
    }

    public void setTolls(float f10) {
        this.f8808e = f10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f8804a);
        parcel.writeString(this.f8805b);
        parcel.writeString(this.f8806c);
        parcel.writeFloat(this.f8807d);
        parcel.writeFloat(this.f8808e);
        parcel.writeFloat(this.f8809f);
        parcel.writeString(this.f8810g);
        parcel.writeFloat(this.f8811h);
        parcel.writeTypedList(this.f8812i);
        parcel.writeString(this.f8813j);
        parcel.writeString(this.f8814k);
        parcel.writeTypedList(this.f8815l);
        parcel.writeTypedList(this.f8816m);
    }

    public DriveStep() {
        this.f8812i = new ArrayList();
        this.f8815l = new ArrayList();
        this.f8816m = new ArrayList();
    }
}
