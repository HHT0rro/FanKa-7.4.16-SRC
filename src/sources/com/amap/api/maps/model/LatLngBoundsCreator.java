package com.amap.api.maps.model;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class LatLngBoundsCreator implements Parcelable.Creator<LatLngBounds> {
    public static final int CONTENT_DESCRIPTION = 0;

    public static void a(LatLngBounds latLngBounds, Parcel parcel, int i10) {
        parcel.writeInt(latLngBounds.a());
        parcel.writeParcelable(latLngBounds.southwest, i10);
        parcel.writeParcelable(latLngBounds.northeast, i10);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public LatLngBounds createFromParcel(Parcel parcel) {
        LatLng latLng;
        int readInt = parcel.readInt();
        LatLng latLng2 = null;
        try {
            latLng = (LatLng) parcel.readParcelable(LatLngBounds.class.getClassLoader());
            try {
                latLng2 = (LatLng) parcel.readParcelable(LatLngBounds.class.getClassLoader());
            } catch (BadParcelableException e2) {
                e = e2;
                e.printStackTrace();
                return new LatLngBounds(readInt, latLng, latLng2);
            }
        } catch (BadParcelableException e10) {
            e = e10;
            latLng = null;
        }
        return new LatLngBounds(readInt, latLng, latLng2);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public LatLngBounds[] newArray(int i10) {
        return new LatLngBounds[i10];
    }
}
