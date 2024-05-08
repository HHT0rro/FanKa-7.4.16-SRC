package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class BusStepV2 implements Parcelable {
    public static final Parcelable.Creator<BusStepV2> CREATOR = new Parcelable.Creator<BusStepV2>() { // from class: com.amap.api.services.route.BusStepV2.1
        private static BusStepV2 a(Parcel parcel) {
            return new BusStepV2(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BusStepV2 createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ BusStepV2[] newArray(int i10) {
            return null;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private RouteBusWalkItem f8734a;

    /* renamed from: b, reason: collision with root package name */
    private List<RouteBusLineItem> f8735b;

    /* renamed from: c, reason: collision with root package name */
    private Doorway f8736c;

    /* renamed from: d, reason: collision with root package name */
    private Doorway f8737d;

    /* renamed from: e, reason: collision with root package name */
    private RouteRailwayItem f8738e;

    /* renamed from: f, reason: collision with root package name */
    private TaxiItemV2 f8739f;

    public BusStepV2(Parcel parcel) {
        this.f8735b = new ArrayList();
        this.f8734a = (RouteBusWalkItem) parcel.readParcelable(RouteBusWalkItem.class.getClassLoader());
        this.f8735b = parcel.createTypedArrayList(RouteBusLineItem.CREATOR);
        this.f8736c = (Doorway) parcel.readParcelable(Doorway.class.getClassLoader());
        this.f8737d = (Doorway) parcel.readParcelable(Doorway.class.getClassLoader());
        this.f8738e = (RouteRailwayItem) parcel.readParcelable(RouteRailwayItem.class.getClassLoader());
        this.f8739f = (TaxiItemV2) parcel.readParcelable(TaxiItem.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Deprecated
    public RouteBusLineItem getBusLine() {
        List<RouteBusLineItem> list = this.f8735b;
        if (list == null || list.size() == 0) {
            return null;
        }
        return this.f8735b.get(0);
    }

    public List<RouteBusLineItem> getBusLines() {
        return this.f8735b;
    }

    public Doorway getEntrance() {
        return this.f8736c;
    }

    public Doorway getExit() {
        return this.f8737d;
    }

    public RouteRailwayItem getRailway() {
        return this.f8738e;
    }

    public TaxiItemV2 getTaxi() {
        return this.f8739f;
    }

    public RouteBusWalkItem getWalk() {
        return this.f8734a;
    }

    @Deprecated
    public void setBusLine(RouteBusLineItem routeBusLineItem) {
        List<RouteBusLineItem> list = this.f8735b;
        if (list == null) {
            return;
        }
        if (list.size() == 0) {
            this.f8735b.add(routeBusLineItem);
        }
        this.f8735b.set(0, routeBusLineItem);
    }

    public void setBusLines(List<RouteBusLineItem> list) {
        this.f8735b = list;
    }

    public void setEntrance(Doorway doorway) {
        this.f8736c = doorway;
    }

    public void setExit(Doorway doorway) {
        this.f8737d = doorway;
    }

    public void setRailway(RouteRailwayItem routeRailwayItem) {
        this.f8738e = routeRailwayItem;
    }

    public void setTaxi(TaxiItemV2 taxiItemV2) {
        this.f8739f = taxiItemV2;
    }

    public void setWalk(RouteBusWalkItem routeBusWalkItem) {
        this.f8734a = routeBusWalkItem;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.f8734a, i10);
        parcel.writeTypedList(this.f8735b);
        parcel.writeParcelable(this.f8736c, i10);
        parcel.writeParcelable(this.f8737d, i10);
        parcel.writeParcelable(this.f8738e, i10);
        parcel.writeParcelable(this.f8739f, i10);
    }

    public BusStepV2() {
        this.f8735b = new ArrayList();
    }
}
