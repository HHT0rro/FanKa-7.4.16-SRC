package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class RouteResult implements Parcelable {
    public static final Parcelable.Creator<RouteResult> CREATOR = new Parcelable.Creator<RouteResult>() { // from class: com.amap.api.services.route.RouteResult.1
        private static RouteResult a(Parcel parcel) {
            return new RouteResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RouteResult createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RouteResult[] newArray(int i10) {
            return a(i10);
        }

        private static RouteResult[] a(int i10) {
            return new RouteResult[i10];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private LatLonPoint f8881a;

    /* renamed from: b, reason: collision with root package name */
    private LatLonPoint f8882b;

    public RouteResult(Parcel parcel) {
        this.f8881a = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f8882b = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LatLonPoint getStartPos() {
        return this.f8881a;
    }

    public LatLonPoint getTargetPos() {
        return this.f8882b;
    }

    public void setStartPos(LatLonPoint latLonPoint) {
        this.f8881a = latLonPoint;
    }

    public void setTargetPos(LatLonPoint latLonPoint) {
        this.f8882b = latLonPoint;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.f8881a, i10);
        parcel.writeParcelable(this.f8882b, i10);
    }

    public RouteResult() {
    }
}
