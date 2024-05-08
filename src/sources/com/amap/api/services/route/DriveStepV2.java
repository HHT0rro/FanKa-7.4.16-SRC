package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class DriveStepV2 implements Parcelable {
    public static final Parcelable.Creator<DriveStepV2> CREATOR = new Parcelable.Creator<DriveStepV2>() { // from class: com.amap.api.services.route.DriveStepV2.1
        private static DriveStepV2 a(Parcel parcel) {
            return new DriveStepV2(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DriveStepV2 createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ DriveStepV2[] newArray(int i10) {
            return null;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f8817a;

    /* renamed from: b, reason: collision with root package name */
    private String f8818b;

    /* renamed from: c, reason: collision with root package name */
    private String f8819c;

    /* renamed from: d, reason: collision with root package name */
    private List<LatLonPoint> f8820d;

    /* renamed from: e, reason: collision with root package name */
    private List<RouteSearchCity> f8821e;

    /* renamed from: f, reason: collision with root package name */
    private List<TMC> f8822f;

    /* renamed from: g, reason: collision with root package name */
    private int f8823g;

    /* renamed from: h, reason: collision with root package name */
    private Cost f8824h;

    /* renamed from: i, reason: collision with root package name */
    private Navi f8825i;

    public DriveStepV2(Parcel parcel) {
        this.f8820d = new ArrayList();
        this.f8821e = new ArrayList();
        this.f8822f = new ArrayList();
        this.f8823g = -1;
        this.f8817a = parcel.readString();
        this.f8818b = parcel.readString();
        this.f8819c = parcel.readString();
        this.f8820d = parcel.createTypedArrayList(LatLonPoint.CREATOR);
        this.f8821e = parcel.createTypedArrayList(RouteSearchCity.CREATOR);
        this.f8822f = parcel.createTypedArrayList(TMC.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Cost getCostDetail() {
        return this.f8824h;
    }

    public String getInstruction() {
        return this.f8817a;
    }

    public Navi getNavi() {
        return this.f8825i;
    }

    public String getOrientation() {
        return this.f8818b;
    }

    public List<LatLonPoint> getPolyline() {
        return this.f8820d;
    }

    public String getRoad() {
        return this.f8819c;
    }

    public List<RouteSearchCity> getRouteSearchCityList() {
        return this.f8821e;
    }

    public int getStepDistance() {
        return this.f8823g;
    }

    public List<TMC> getTMCs() {
        return this.f8822f;
    }

    public void setCostDetail(Cost cost) {
        this.f8824h = cost;
    }

    public void setInstruction(String str) {
        this.f8817a = str;
    }

    public void setNavi(Navi navi) {
        this.f8825i = navi;
    }

    public void setOrientation(String str) {
        this.f8818b = str;
    }

    public void setPolyline(List<LatLonPoint> list) {
        this.f8820d = list;
    }

    public void setRoad(String str) {
        this.f8819c = str;
    }

    public void setRouteSearchCityList(List<RouteSearchCity> list) {
        this.f8821e = list;
    }

    public void setStepDistance(int i10) {
        this.f8823g = i10;
    }

    public void setTMCs(List<TMC> list) {
        this.f8822f = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f8817a);
        parcel.writeString(this.f8818b);
        parcel.writeString(this.f8819c);
        parcel.writeTypedList(this.f8820d);
        parcel.writeTypedList(this.f8821e);
        parcel.writeTypedList(this.f8822f);
    }

    public DriveStepV2() {
        this.f8820d = new ArrayList();
        this.f8821e = new ArrayList();
        this.f8822f = new ArrayList();
        this.f8823g = -1;
    }
}
