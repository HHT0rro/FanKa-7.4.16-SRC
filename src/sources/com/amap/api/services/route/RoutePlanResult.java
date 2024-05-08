package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class RoutePlanResult implements Parcelable {
    public static final Parcelable.Creator<RoutePlanResult> CREATOR = new Parcelable.Creator<RoutePlanResult>() { // from class: com.amap.api.services.route.RoutePlanResult.1
        private static RoutePlanResult a(Parcel parcel) {
            return new RoutePlanResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RoutePlanResult createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RoutePlanResult[] newArray(int i10) {
            return a(i10);
        }

        private static RoutePlanResult[] a(int i10) {
            return new RoutePlanResult[i10];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private LatLonPoint f8870a;

    /* renamed from: b, reason: collision with root package name */
    private LatLonPoint f8871b;

    public RoutePlanResult(Parcel parcel) {
        this.f8870a = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f8871b = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LatLonPoint getStartPos() {
        return this.f8870a;
    }

    public LatLonPoint getTargetPos() {
        return this.f8871b;
    }

    public void setStartPos(LatLonPoint latLonPoint) {
        this.f8870a = latLonPoint;
    }

    public void setTargetPos(LatLonPoint latLonPoint) {
        this.f8871b = latLonPoint;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.f8870a, i10);
        parcel.writeParcelable(this.f8871b, i10);
    }

    public RoutePlanResult() {
    }
}
