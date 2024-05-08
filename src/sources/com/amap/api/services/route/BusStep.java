package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class BusStep implements Parcelable {
    public static final Parcelable.Creator<BusStep> CREATOR = new Parcelable.Creator<BusStep>() { // from class: com.amap.api.services.route.BusStep.1
        private static BusStep a(Parcel parcel) {
            return new BusStep(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BusStep createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ BusStep[] newArray(int i10) {
            return null;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private RouteBusWalkItem f8728a;

    /* renamed from: b, reason: collision with root package name */
    private List<RouteBusLineItem> f8729b;

    /* renamed from: c, reason: collision with root package name */
    private Doorway f8730c;

    /* renamed from: d, reason: collision with root package name */
    private Doorway f8731d;

    /* renamed from: e, reason: collision with root package name */
    private RouteRailwayItem f8732e;

    /* renamed from: f, reason: collision with root package name */
    private TaxiItem f8733f;

    public BusStep(Parcel parcel) {
        this.f8729b = new ArrayList();
        this.f8728a = (RouteBusWalkItem) parcel.readParcelable(RouteBusWalkItem.class.getClassLoader());
        this.f8729b = parcel.createTypedArrayList(RouteBusLineItem.CREATOR);
        this.f8730c = (Doorway) parcel.readParcelable(Doorway.class.getClassLoader());
        this.f8731d = (Doorway) parcel.readParcelable(Doorway.class.getClassLoader());
        this.f8732e = (RouteRailwayItem) parcel.readParcelable(RouteRailwayItem.class.getClassLoader());
        this.f8733f = (TaxiItem) parcel.readParcelable(TaxiItem.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Deprecated
    public RouteBusLineItem getBusLine() {
        List<RouteBusLineItem> list = this.f8729b;
        if (list == null || list.size() == 0) {
            return null;
        }
        return this.f8729b.get(0);
    }

    public List<RouteBusLineItem> getBusLines() {
        return this.f8729b;
    }

    public Doorway getEntrance() {
        return this.f8730c;
    }

    public Doorway getExit() {
        return this.f8731d;
    }

    public RouteRailwayItem getRailway() {
        return this.f8732e;
    }

    public TaxiItem getTaxi() {
        return this.f8733f;
    }

    public RouteBusWalkItem getWalk() {
        return this.f8728a;
    }

    @Deprecated
    public void setBusLine(RouteBusLineItem routeBusLineItem) {
        List<RouteBusLineItem> list = this.f8729b;
        if (list == null) {
            return;
        }
        if (list.size() == 0) {
            this.f8729b.add(routeBusLineItem);
        }
        this.f8729b.set(0, routeBusLineItem);
    }

    public void setBusLines(List<RouteBusLineItem> list) {
        this.f8729b = list;
    }

    public void setEntrance(Doorway doorway) {
        this.f8730c = doorway;
    }

    public void setExit(Doorway doorway) {
        this.f8731d = doorway;
    }

    public void setRailway(RouteRailwayItem routeRailwayItem) {
        this.f8732e = routeRailwayItem;
    }

    public void setTaxi(TaxiItem taxiItem) {
        this.f8733f = taxiItem;
    }

    public void setWalk(RouteBusWalkItem routeBusWalkItem) {
        this.f8728a = routeBusWalkItem;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.f8728a, i10);
        parcel.writeTypedList(this.f8729b);
        parcel.writeParcelable(this.f8730c, i10);
        parcel.writeParcelable(this.f8731d, i10);
        parcel.writeParcelable(this.f8732e, i10);
        parcel.writeParcelable(this.f8733f, i10);
    }

    public BusStep() {
        this.f8729b = new ArrayList();
    }
}
