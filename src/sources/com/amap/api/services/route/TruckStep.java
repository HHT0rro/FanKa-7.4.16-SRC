package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class TruckStep implements Parcelable {
    public static final Parcelable.Creator<TruckStep> CREATOR = new Parcelable.Creator<TruckStep>() { // from class: com.amap.api.services.route.TruckStep.1
        private static TruckStep a(Parcel parcel) {
            return new TruckStep(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ TruckStep createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ TruckStep[] newArray(int i10) {
            return a(i10);
        }

        private static TruckStep[] a(int i10) {
            return new TruckStep[i10];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f9041a;

    /* renamed from: b, reason: collision with root package name */
    private String f9042b;

    /* renamed from: c, reason: collision with root package name */
    private String f9043c;

    /* renamed from: d, reason: collision with root package name */
    private float f9044d;

    /* renamed from: e, reason: collision with root package name */
    private float f9045e;

    /* renamed from: f, reason: collision with root package name */
    private float f9046f;

    /* renamed from: g, reason: collision with root package name */
    private String f9047g;

    /* renamed from: h, reason: collision with root package name */
    private float f9048h;

    /* renamed from: i, reason: collision with root package name */
    private List<LatLonPoint> f9049i;

    /* renamed from: j, reason: collision with root package name */
    private String f9050j;

    /* renamed from: k, reason: collision with root package name */
    private String f9051k;

    /* renamed from: l, reason: collision with root package name */
    private List<RouteSearchCity> f9052l;

    /* renamed from: m, reason: collision with root package name */
    private List<TMC> f9053m;

    public TruckStep() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAction() {
        return this.f9050j;
    }

    public String getAssistantAction() {
        return this.f9051k;
    }

    public float getDistance() {
        return this.f9045e;
    }

    public float getDuration() {
        return this.f9048h;
    }

    public String getInstruction() {
        return this.f9041a;
    }

    public String getOrientation() {
        return this.f9042b;
    }

    public List<LatLonPoint> getPolyline() {
        return this.f9049i;
    }

    public String getRoad() {
        return this.f9043c;
    }

    public List<RouteSearchCity> getRouteSearchCityList() {
        return this.f9052l;
    }

    public List<TMC> getTMCs() {
        return this.f9053m;
    }

    public float getTollDistance() {
        return this.f9046f;
    }

    public String getTollRoad() {
        return this.f9047g;
    }

    public float getTolls() {
        return this.f9044d;
    }

    public void setAction(String str) {
        this.f9050j = str;
    }

    public void setAssistantAction(String str) {
        this.f9051k = str;
    }

    public void setDistance(float f10) {
        this.f9045e = f10;
    }

    public void setDuration(float f10) {
        this.f9048h = f10;
    }

    public void setInstruction(String str) {
        this.f9041a = str;
    }

    public void setOrientation(String str) {
        this.f9042b = str;
    }

    public void setPolyline(List<LatLonPoint> list) {
        this.f9049i = list;
    }

    public void setRoad(String str) {
        this.f9043c = str;
    }

    public void setRouteSearchCityList(List<RouteSearchCity> list) {
        this.f9052l = list;
    }

    public void setTMCs(List<TMC> list) {
        this.f9053m = list;
    }

    public void setTollDistance(float f10) {
        this.f9046f = f10;
    }

    public void setTollRoad(String str) {
        this.f9047g = str;
    }

    public void setTolls(float f10) {
        this.f9044d = f10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f9041a);
        parcel.writeString(this.f9042b);
        parcel.writeString(this.f9043c);
        parcel.writeFloat(this.f9044d);
        parcel.writeFloat(this.f9045e);
        parcel.writeFloat(this.f9046f);
        parcel.writeString(this.f9047g);
        parcel.writeFloat(this.f9048h);
        parcel.writeTypedList(this.f9049i);
        parcel.writeString(this.f9050j);
        parcel.writeString(this.f9051k);
        parcel.writeTypedList(this.f9052l);
        parcel.writeTypedList(this.f9053m);
    }

    public TruckStep(Parcel parcel) {
        this.f9041a = parcel.readString();
        this.f9042b = parcel.readString();
        this.f9043c = parcel.readString();
        this.f9044d = parcel.readFloat();
        this.f9045e = parcel.readFloat();
        this.f9046f = parcel.readFloat();
        this.f9047g = parcel.readString();
        this.f9048h = parcel.readFloat();
        this.f9049i = parcel.createTypedArrayList(LatLonPoint.CREATOR);
        this.f9050j = parcel.readString();
        this.f9051k = parcel.readString();
        this.f9052l = parcel.createTypedArrayList(RouteSearchCity.CREATOR);
        this.f9053m = parcel.createTypedArrayList(TMC.CREATOR);
    }
}
