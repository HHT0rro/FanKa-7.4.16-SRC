package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.route.RouteSearch;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class DriveRoutePlanResult extends RoutePlanResult {
    public static final Parcelable.Creator<DriveRoutePlanResult> CREATOR = new Parcelable.Creator<DriveRoutePlanResult>() { // from class: com.amap.api.services.route.DriveRoutePlanResult.1
        private static DriveRoutePlanResult a(Parcel parcel) {
            return new DriveRoutePlanResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DriveRoutePlanResult createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ DriveRoutePlanResult[] newArray(int i10) {
            return a(i10);
        }

        private static DriveRoutePlanResult[] a(int i10) {
            return new DriveRoutePlanResult[i10];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private List<DrivePlanPath> f8795a;

    /* renamed from: b, reason: collision with root package name */
    private List<TimeInfo> f8796b;

    /* renamed from: c, reason: collision with root package name */
    private RouteSearch.DrivePlanQuery f8797c;

    public DriveRoutePlanResult(Parcel parcel) {
        super(parcel);
        this.f8795a = new ArrayList();
        this.f8796b = new ArrayList();
        this.f8795a = parcel.createTypedArrayList(DrivePlanPath.CREATOR);
        this.f8796b = parcel.createTypedArrayList(TimeInfo.CREATOR);
        this.f8797c = (RouteSearch.DrivePlanQuery) parcel.readParcelable(RouteSearch.DrivePlanQuery.class.getClassLoader());
    }

    @Override // com.amap.api.services.route.RoutePlanResult, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<DrivePlanPath> getPaths() {
        return this.f8795a;
    }

    public List<TimeInfo> getTimeInfos() {
        return this.f8796b;
    }

    public void setDrivePlanQuery(RouteSearch.DrivePlanQuery drivePlanQuery) {
        this.f8797c = drivePlanQuery;
        RouteSearch.FromAndTo fromAndTo = drivePlanQuery.getFromAndTo();
        if (fromAndTo != null) {
            setStartPos(fromAndTo.getFrom());
            setTargetPos(fromAndTo.getTo());
        }
    }

    public void setPaths(List<DrivePlanPath> list) {
        this.f8795a = list;
    }

    public void setTimeInfos(List<TimeInfo> list) {
        this.f8796b = list;
    }

    @Override // com.amap.api.services.route.RoutePlanResult, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeTypedList(this.f8795a);
        parcel.writeTypedList(this.f8796b);
        parcel.writeParcelable(this.f8797c, i10);
    }

    public DriveRoutePlanResult() {
        this.f8795a = new ArrayList();
        this.f8796b = new ArrayList();
    }
}
