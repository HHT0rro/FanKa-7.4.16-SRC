package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class RouteBusWalkItem extends WalkPath {
    public static final Parcelable.Creator<RouteBusWalkItem> CREATOR = new Parcelable.Creator<RouteBusWalkItem>() { // from class: com.amap.api.services.route.RouteBusWalkItem.1
        private static RouteBusWalkItem a(Parcel parcel) {
            return new RouteBusWalkItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ RouteBusWalkItem createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ RouteBusWalkItem[] newArray(int i10) {
            return null;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private LatLonPoint f8868a;

    /* renamed from: b, reason: collision with root package name */
    private LatLonPoint f8869b;

    public RouteBusWalkItem(Parcel parcel) {
        super(parcel);
        this.f8868a = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f8869b = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
    }

    @Override // com.amap.api.services.route.WalkPath, com.amap.api.services.route.Path, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public LatLonPoint getDestination() {
        return this.f8869b;
    }

    public LatLonPoint getOrigin() {
        return this.f8868a;
    }

    public void setDestination(LatLonPoint latLonPoint) {
        this.f8869b = latLonPoint;
    }

    public void setOrigin(LatLonPoint latLonPoint) {
        this.f8868a = latLonPoint;
    }

    @Override // com.amap.api.services.route.WalkPath, com.amap.api.services.route.Path, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeParcelable(this.f8868a, i10);
        parcel.writeParcelable(this.f8869b, i10);
    }

    public RouteBusWalkItem() {
    }
}
