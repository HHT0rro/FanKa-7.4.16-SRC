package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.route.RouteSearch;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class WalkRouteResult extends RouteResult {
    public static final Parcelable.Creator<WalkRouteResult> CREATOR = new Parcelable.Creator<WalkRouteResult>() { // from class: com.amap.api.services.route.WalkRouteResult.1
        private static WalkRouteResult a(Parcel parcel) {
            return new WalkRouteResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ WalkRouteResult createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ WalkRouteResult[] newArray(int i10) {
            return a(i10);
        }

        private static WalkRouteResult[] a(int i10) {
            return new WalkRouteResult[i10];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private List<WalkPath> f9055a;

    /* renamed from: b, reason: collision with root package name */
    private RouteSearch.WalkRouteQuery f9056b;

    public WalkRouteResult(Parcel parcel) {
        super(parcel);
        this.f9055a = new ArrayList();
        this.f9055a = parcel.createTypedArrayList(WalkPath.CREATOR);
        this.f9056b = (RouteSearch.WalkRouteQuery) parcel.readParcelable(RouteSearch.WalkRouteQuery.class.getClassLoader());
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<WalkPath> getPaths() {
        return this.f9055a;
    }

    public RouteSearch.WalkRouteQuery getWalkQuery() {
        return this.f9056b;
    }

    public void setPaths(List<WalkPath> list) {
        this.f9055a = list;
    }

    public void setWalkQuery(RouteSearch.WalkRouteQuery walkRouteQuery) {
        this.f9056b = walkRouteQuery;
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeTypedList(this.f9055a);
        parcel.writeParcelable(this.f9056b, i10);
    }

    public WalkRouteResult() {
        this.f9055a = new ArrayList();
    }
}
