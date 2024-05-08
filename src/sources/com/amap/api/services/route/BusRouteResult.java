package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.route.RouteSearch;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class BusRouteResult extends RouteResult {
    public static final Parcelable.Creator<BusRouteResult> CREATOR = new Parcelable.Creator<BusRouteResult>() { // from class: com.amap.api.services.route.BusRouteResult.1
        private static BusRouteResult a(Parcel parcel) {
            return new BusRouteResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BusRouteResult createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ BusRouteResult[] newArray(int i10) {
            return a(i10);
        }

        private static BusRouteResult[] a(int i10) {
            return new BusRouteResult[i10];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private float f8721a;

    /* renamed from: b, reason: collision with root package name */
    private List<BusPath> f8722b;

    /* renamed from: c, reason: collision with root package name */
    private RouteSearch.BusRouteQuery f8723c;

    public BusRouteResult(Parcel parcel) {
        super(parcel);
        this.f8722b = new ArrayList();
        this.f8721a = parcel.readFloat();
        this.f8722b = parcel.createTypedArrayList(BusPath.CREATOR);
        this.f8723c = (RouteSearch.BusRouteQuery) parcel.readParcelable(RouteSearch.BusRouteQuery.class.getClassLoader());
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public RouteSearch.BusRouteQuery getBusQuery() {
        return this.f8723c;
    }

    public List<BusPath> getPaths() {
        return this.f8722b;
    }

    public float getTaxiCost() {
        return this.f8721a;
    }

    public void setBusQuery(RouteSearch.BusRouteQuery busRouteQuery) {
        this.f8723c = busRouteQuery;
    }

    public void setPaths(List<BusPath> list) {
        this.f8722b = list;
    }

    public void setTaxiCost(float f10) {
        this.f8721a = f10;
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeFloat(this.f8721a);
        parcel.writeTypedList(this.f8722b);
        parcel.writeParcelable(this.f8723c, i10);
    }

    public BusRouteResult() {
        this.f8722b = new ArrayList();
    }
}
