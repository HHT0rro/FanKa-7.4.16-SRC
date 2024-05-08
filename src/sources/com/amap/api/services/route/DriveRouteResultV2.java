package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.route.RouteSearchV2;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class DriveRouteResultV2 extends RouteResult {
    public static final Parcelable.Creator<DriveRouteResultV2> CREATOR = new Parcelable.Creator<DriveRouteResultV2>() { // from class: com.amap.api.services.route.DriveRouteResultV2.1
        private static DriveRouteResultV2 a(Parcel parcel) {
            return new DriveRouteResultV2(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DriveRouteResultV2 createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DriveRouteResultV2[] newArray(int i10) {
            return a(i10);
        }

        private static DriveRouteResultV2[] a(int i10) {
            return new DriveRouteResultV2[i10];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private float f8801a;

    /* renamed from: b, reason: collision with root package name */
    private List<DrivePathV2> f8802b;

    /* renamed from: c, reason: collision with root package name */
    private RouteSearchV2.DriveRouteQuery f8803c;

    public DriveRouteResultV2(Parcel parcel) {
        super(parcel);
        this.f8802b = new ArrayList();
        this.f8801a = parcel.readFloat();
        this.f8802b = parcel.createTypedArrayList(DrivePathV2.CREATOR);
        this.f8803c = (RouteSearchV2.DriveRouteQuery) parcel.readParcelable(RouteSearchV2.DriveRouteQuery.class.getClassLoader());
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public RouteSearchV2.DriveRouteQuery getDriveQuery() {
        return this.f8803c;
    }

    public List<DrivePathV2> getPaths() {
        return this.f8802b;
    }

    public float getTaxiCost() {
        return this.f8801a;
    }

    public void setDriveQuery(RouteSearchV2.DriveRouteQuery driveRouteQuery) {
        this.f8803c = driveRouteQuery;
    }

    public void setPaths(List<DrivePathV2> list) {
        this.f8802b = list;
    }

    public void setTaxiCost(float f10) {
        this.f8801a = f10;
    }

    @Override // com.amap.api.services.route.RouteResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeFloat(this.f8801a);
        parcel.writeTypedList(this.f8802b);
        parcel.writeParcelable(this.f8803c, i10);
    }

    public DriveRouteResultV2() {
        this.f8802b = new ArrayList();
    }
}
