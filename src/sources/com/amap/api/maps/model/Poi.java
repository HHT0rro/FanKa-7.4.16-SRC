package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class Poi implements Parcelable {
    public static final PoiCreator CREATOR = new PoiCreator();
    private final LatLng coordinate;
    private final String name;
    private final String poiid;

    public Poi(String str, LatLng latLng, String str2) {
        this.name = str;
        this.coordinate = latLng;
        this.poiid = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof Poi)) {
            Poi poi = (Poi) obj;
            if (poi.getName().equals(this.name) && poi.getCoordinate().equals(this.coordinate) && poi.getPoiId().equals(this.poiid)) {
                return true;
            }
        }
        return false;
    }

    public LatLng getCoordinate() {
        return this.coordinate;
    }

    public String getName() {
        return this.name;
    }

    public String getPoiId() {
        return this.poiid;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return "poiid " + this.poiid + " name:" + this.name + "  coordinate:" + this.coordinate.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.name);
        parcel.writeParcelable(this.coordinate, i10);
        parcel.writeString(this.poiid);
    }
}
