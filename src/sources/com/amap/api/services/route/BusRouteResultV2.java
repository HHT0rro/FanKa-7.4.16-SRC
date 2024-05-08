package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.route.RouteSearchV2;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class BusRouteResultV2 extends RouteResult {
    public static final Parcelable.Creator<BusRouteResultV2> CREATOR = new Parcelable.Creator<BusRouteResultV2>() { // from class: com.amap.api.services.route.BusRouteResultV2.1
        private static BusRouteResultV2 a(Parcel parcel) {
            return new BusRouteResultV2(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BusRouteResultV2 createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BusRouteResultV2[] newArray(int i10) {
            return a(i10);
        }

        private static BusRouteResultV2[] a(int i10) {
            return new BusRouteResultV2[i10];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private float f8724a;

    /* renamed from: b, reason: collision with root package name */
    private List<BusPathV2> f8725b;

    /* renamed from: c, reason: collision with root package name */
    private RouteSearchV2.BusRouteQuery f8726c;

    /* renamed from: d, reason: collision with root package name */
    private float f8727d;

    public BusRouteResultV2(Parcel parcel) {
        super(parcel);
        this.f8725b = new ArrayList();
        this.f8724a = parcel.readFloat();
        this.f8725b = parcel.createTypedArrayList(BusPathV2.CREATOR);
        this.f8726c = (RouteSearchV2.BusRouteQuery) parcel.readParcelable(RouteSearchV2.BusRouteQuery.class.getClassLoader());
        this.f8727d = parcel.readFloat();
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public RouteSearchV2.BusRouteQuery getBusQuery() {
        return this.f8726c;
    }

    public float getDistance() {
        return this.f8727d;
    }

    public List<BusPathV2> getPaths() {
        return this.f8725b;
    }

    public float getTaxiCost() {
        return this.f8724a;
    }

    public void setBusQuery(RouteSearchV2.BusRouteQuery busRouteQuery) {
        this.f8726c = busRouteQuery;
    }

    public void setDistance(float f10) {
        this.f8727d = f10;
    }

    public void setPaths(List<BusPathV2> list) {
        this.f8725b = list;
    }

    public void setTaxiCost(float f10) {
        this.f8724a = f10;
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeFloat(this.f8724a);
        parcel.writeTypedList(this.f8725b);
        parcel.writeParcelable(this.f8726c, i10);
        parcel.writeFloat(this.f8727d);
    }

    public BusRouteResultV2() {
        this.f8725b = new ArrayList();
    }
}
