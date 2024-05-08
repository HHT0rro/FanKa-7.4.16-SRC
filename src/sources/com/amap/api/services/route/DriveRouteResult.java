package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.route.RouteSearch;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class DriveRouteResult extends RouteResult {
    public static final Parcelable.Creator<DriveRouteResult> CREATOR = new Parcelable.Creator<DriveRouteResult>() { // from class: com.amap.api.services.route.DriveRouteResult.1
        private static DriveRouteResult a(Parcel parcel) {
            return new DriveRouteResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DriveRouteResult createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DriveRouteResult[] newArray(int i10) {
            return a(i10);
        }

        private static DriveRouteResult[] a(int i10) {
            return new DriveRouteResult[i10];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private float f8798a;

    /* renamed from: b, reason: collision with root package name */
    private List<DrivePath> f8799b;

    /* renamed from: c, reason: collision with root package name */
    private RouteSearch.DriveRouteQuery f8800c;

    public DriveRouteResult(Parcel parcel) {
        super(parcel);
        this.f8799b = new ArrayList();
        this.f8798a = parcel.readFloat();
        this.f8799b = parcel.createTypedArrayList(DrivePath.CREATOR);
        this.f8800c = (RouteSearch.DriveRouteQuery) parcel.readParcelable(RouteSearch.DriveRouteQuery.class.getClassLoader());
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public RouteSearch.DriveRouteQuery getDriveQuery() {
        return this.f8800c;
    }

    public List<DrivePath> getPaths() {
        return this.f8799b;
    }

    public float getTaxiCost() {
        return this.f8798a;
    }

    public void setDriveQuery(RouteSearch.DriveRouteQuery driveRouteQuery) {
        this.f8800c = driveRouteQuery;
    }

    public void setPaths(List<DrivePath> list) {
        this.f8799b = list;
    }

    public void setTaxiCost(float f10) {
        this.f8798a = f10;
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeFloat(this.f8798a);
        parcel.writeTypedList(this.f8799b);
        parcel.writeParcelable(this.f8800c, i10);
    }

    public DriveRouteResult() {
        this.f8799b = new ArrayList();
    }
}
