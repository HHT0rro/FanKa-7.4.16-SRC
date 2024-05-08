package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.route.RouteSearchV2;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class WalkRouteResultV2 extends RouteResult {
    public static final Parcelable.Creator<WalkRouteResultV2> CREATOR = new Parcelable.Creator<WalkRouteResultV2>() { // from class: com.amap.api.services.route.WalkRouteResultV2.1
        private static WalkRouteResultV2 a(Parcel parcel) {
            return new WalkRouteResultV2(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ WalkRouteResultV2 createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ WalkRouteResultV2[] newArray(int i10) {
            return a(i10);
        }

        private static WalkRouteResultV2[] a(int i10) {
            return new WalkRouteResultV2[i10];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private List<WalkPath> f9057a;

    /* renamed from: b, reason: collision with root package name */
    private RouteSearchV2.WalkRouteQuery f9058b;

    public WalkRouteResultV2(Parcel parcel) {
        super(parcel);
        this.f9057a = new ArrayList();
        this.f9057a = parcel.createTypedArrayList(WalkPath.CREATOR);
        this.f9058b = (RouteSearchV2.WalkRouteQuery) parcel.readParcelable(RouteSearchV2.WalkRouteQuery.class.getClassLoader());
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<WalkPath> getPaths() {
        return this.f9057a;
    }

    public RouteSearchV2.WalkRouteQuery getWalkQuery() {
        return this.f9058b;
    }

    public void setPaths(List<WalkPath> list) {
        this.f9057a = list;
    }

    public void setWalkQuery(RouteSearchV2.WalkRouteQuery walkRouteQuery) {
        this.f9058b = walkRouteQuery;
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeTypedList(this.f9057a);
        parcel.writeParcelable(this.f9058b, i10);
    }

    public WalkRouteResultV2() {
        this.f9057a = new ArrayList();
    }
}
