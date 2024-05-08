package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.route.RouteSearch;
import com.amap.api.services.route.RouteSearchV2;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class RideRouteResultV2 extends RouteResult {
    public static final Parcelable.Creator<RideRouteResultV2> CREATOR = new Parcelable.Creator<RideRouteResultV2>() { // from class: com.amap.api.services.route.RideRouteResultV2.1
        private static RideRouteResultV2 a(Parcel parcel) {
            return new RideRouteResultV2(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RideRouteResultV2 createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RideRouteResultV2[] newArray(int i10) {
            return a(i10);
        }

        private static RideRouteResultV2[] a(int i10) {
            return new RideRouteResultV2[i10];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private List<RidePath> f8851a;

    /* renamed from: b, reason: collision with root package name */
    private RouteSearchV2.RideRouteQuery f8852b;

    public RideRouteResultV2(Parcel parcel) {
        super(parcel);
        this.f8851a = new ArrayList();
        this.f8851a = parcel.createTypedArrayList(RidePath.CREATOR);
        this.f8852b = (RouteSearchV2.RideRouteQuery) parcel.readParcelable(RouteSearch.RideRouteQuery.class.getClassLoader());
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<RidePath> getPaths() {
        return this.f8851a;
    }

    public RouteSearchV2.RideRouteQuery getRideQuery() {
        return this.f8852b;
    }

    public void setPaths(List<RidePath> list) {
        this.f8851a = list;
    }

    public void setRideQuery(RouteSearchV2.RideRouteQuery rideRouteQuery) {
        this.f8852b = rideRouteQuery;
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeTypedList(this.f8851a);
        parcel.writeParcelable(this.f8852b, i10);
    }

    public RideRouteResultV2() {
        this.f8851a = new ArrayList();
    }
}
