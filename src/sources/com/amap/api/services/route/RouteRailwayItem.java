package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class RouteRailwayItem extends Railway {
    public static final Parcelable.Creator<RouteRailwayItem> CREATOR = new Parcelable.Creator<RouteRailwayItem>() { // from class: com.amap.api.services.route.RouteRailwayItem.1
        private static RouteRailwayItem a(Parcel parcel) {
            return new RouteRailwayItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RouteRailwayItem createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RouteRailwayItem[] newArray(int i10) {
            return a(i10);
        }

        private static RouteRailwayItem[] a(int i10) {
            return new RouteRailwayItem[i10];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private String f8872a;

    /* renamed from: b, reason: collision with root package name */
    private String f8873b;

    /* renamed from: c, reason: collision with root package name */
    private float f8874c;

    /* renamed from: d, reason: collision with root package name */
    private String f8875d;

    /* renamed from: e, reason: collision with root package name */
    private RailwayStationItem f8876e;

    /* renamed from: f, reason: collision with root package name */
    private RailwayStationItem f8877f;

    /* renamed from: g, reason: collision with root package name */
    private List<RailwayStationItem> f8878g;

    /* renamed from: h, reason: collision with root package name */
    private List<Railway> f8879h;

    /* renamed from: i, reason: collision with root package name */
    private List<RailwaySpace> f8880i;

    public RouteRailwayItem() {
        this.f8878g = new ArrayList();
        this.f8879h = new ArrayList();
        this.f8880i = new ArrayList();
    }

    @Override // com.amap.api.services.route.Railway, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<Railway> getAlters() {
        return this.f8879h;
    }

    public RailwayStationItem getArrivalstop() {
        return this.f8877f;
    }

    public RailwayStationItem getDeparturestop() {
        return this.f8876e;
    }

    public float getDistance() {
        return this.f8874c;
    }

    public List<RailwaySpace> getSpaces() {
        return this.f8880i;
    }

    public String getTime() {
        return this.f8872a;
    }

    public String getTrip() {
        return this.f8873b;
    }

    public String getType() {
        return this.f8875d;
    }

    public List<RailwayStationItem> getViastops() {
        return this.f8878g;
    }

    public void setAlters(List<Railway> list) {
        this.f8879h = list;
    }

    public void setArrivalstop(RailwayStationItem railwayStationItem) {
        this.f8877f = railwayStationItem;
    }

    public void setDeparturestop(RailwayStationItem railwayStationItem) {
        this.f8876e = railwayStationItem;
    }

    public void setDistance(float f10) {
        this.f8874c = f10;
    }

    public void setSpaces(List<RailwaySpace> list) {
        this.f8880i = list;
    }

    public void setTime(String str) {
        this.f8872a = str;
    }

    public void setTrip(String str) {
        this.f8873b = str;
    }

    public void setType(String str) {
        this.f8875d = str;
    }

    public void setViastops(List<RailwayStationItem> list) {
        this.f8878g = list;
    }

    @Override // com.amap.api.services.route.Railway, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeString(this.f8872a);
        parcel.writeString(this.f8873b);
        parcel.writeFloat(this.f8874c);
        parcel.writeString(this.f8875d);
        parcel.writeParcelable(this.f8876e, i10);
        parcel.writeParcelable(this.f8877f, i10);
        parcel.writeTypedList(this.f8878g);
        parcel.writeTypedList(this.f8879h);
        parcel.writeTypedList(this.f8880i);
    }

    public RouteRailwayItem(Parcel parcel) {
        super(parcel);
        this.f8878g = new ArrayList();
        this.f8879h = new ArrayList();
        this.f8880i = new ArrayList();
        this.f8872a = parcel.readString();
        this.f8873b = parcel.readString();
        this.f8874c = parcel.readFloat();
        this.f8875d = parcel.readString();
        this.f8876e = (RailwayStationItem) parcel.readParcelable(RailwayStationItem.class.getClassLoader());
        this.f8877f = (RailwayStationItem) parcel.readParcelable(RailwayStationItem.class.getClassLoader());
        this.f8878g = parcel.createTypedArrayList(RailwayStationItem.CREATOR);
        this.f8879h = parcel.createTypedArrayList(Railway.CREATOR);
        this.f8880i = parcel.createTypedArrayList(RailwaySpace.CREATOR);
    }
}
