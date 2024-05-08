package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.route.RouteSearch;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class RideRouteResult extends RouteResult {
    public static final Parcelable.Creator<RideRouteResult> CREATOR = new Parcelable.Creator<RideRouteResult>() { // from class: com.amap.api.services.route.RideRouteResult.1
        private static RideRouteResult a(Parcel parcel) {
            return new RideRouteResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RideRouteResult createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RideRouteResult[] newArray(int i10) {
            return a(i10);
        }

        private static RideRouteResult[] a(int i10) {
            return new RideRouteResult[i10];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private List<RidePath> f8849a;

    /* renamed from: b, reason: collision with root package name */
    private RouteSearch.RideRouteQuery f8850b;

    public RideRouteResult(Parcel parcel) {
        super(parcel);
        this.f8849a = new ArrayList();
        this.f8849a = parcel.createTypedArrayList(RidePath.CREATOR);
        this.f8850b = (RouteSearch.RideRouteQuery) parcel.readParcelable(RouteSearch.RideRouteQuery.class.getClassLoader());
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<RidePath> getPaths() {
        return this.f8849a;
    }

    public RouteSearch.RideRouteQuery getRideQuery() {
        return this.f8850b;
    }

    public void setPaths(List<RidePath> list) {
        this.f8849a = list;
    }

    public void setRideQuery(RouteSearch.RideRouteQuery rideRouteQuery) {
        this.f8850b = rideRouteQuery;
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeTypedList(this.f8849a);
        parcel.writeParcelable(this.f8850b, i10);
    }

    public RideRouteResult() {
        this.f8849a = new ArrayList();
    }
}
