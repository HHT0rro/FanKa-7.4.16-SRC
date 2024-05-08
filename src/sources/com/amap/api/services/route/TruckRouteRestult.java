package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.route.RouteSearch;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class TruckRouteRestult implements Parcelable {
    public static final Parcelable.Creator<TruckRouteRestult> CREATOR = new Parcelable.Creator<TruckRouteRestult>() { // from class: com.amap.api.services.route.TruckRouteRestult.1
        private static TruckRouteRestult a(Parcel parcel) {
            return new TruckRouteRestult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ TruckRouteRestult createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ TruckRouteRestult[] newArray(int i10) {
            return a(i10);
        }

        private static TruckRouteRestult[] a(int i10) {
            return new TruckRouteRestult[i10];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private RouteSearch.TruckRouteQuery f9037a;

    /* renamed from: b, reason: collision with root package name */
    private List<TruckPath> f9038b;

    /* renamed from: c, reason: collision with root package name */
    private LatLonPoint f9039c;

    /* renamed from: d, reason: collision with root package name */
    private LatLonPoint f9040d;

    public TruckRouteRestult() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<TruckPath> getPaths() {
        return this.f9038b;
    }

    public LatLonPoint getStartPos() {
        return this.f9039c;
    }

    public LatLonPoint getTargetPos() {
        return this.f9040d;
    }

    public RouteSearch.TruckRouteQuery getTruckQuery() {
        return this.f9037a;
    }

    public void setPaths(List<TruckPath> list) {
        this.f9038b = list;
    }

    public void setStartPos(LatLonPoint latLonPoint) {
        this.f9039c = latLonPoint;
    }

    public void setTargetPos(LatLonPoint latLonPoint) {
        this.f9040d = latLonPoint;
    }

    public void setTruckQuery(RouteSearch.TruckRouteQuery truckRouteQuery) {
        this.f9037a = truckRouteQuery;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeTypedList(this.f9038b);
        parcel.writeParcelable(this.f9039c, i10);
        parcel.writeParcelable(this.f9040d, i10);
    }

    public TruckRouteRestult(Parcel parcel) {
        this.f9038b = parcel.createTypedArrayList(TruckPath.CREATOR);
        this.f9039c = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f9040d = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
    }
}
