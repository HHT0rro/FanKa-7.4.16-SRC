package com.amap.api.maps.model;

import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class VisibleRegionCreator implements Parcelable.Creator<VisibleRegion> {
    public static final int CONTENT_DESCRIPTION = 0;

    public static void a(VisibleRegion visibleRegion, Parcel parcel, int i10) {
        parcel.writeInt(visibleRegion.a());
        parcel.writeParcelable(visibleRegion.nearLeft, i10);
        parcel.writeParcelable(visibleRegion.nearRight, i10);
        parcel.writeParcelable(visibleRegion.farLeft, i10);
        parcel.writeParcelable(visibleRegion.farRight, i10);
        parcel.writeParcelable(visibleRegion.latLngBounds, i10);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public VisibleRegion createFromParcel(Parcel parcel) {
        LatLng latLng;
        LatLng latLng2;
        LatLng latLng3;
        LatLng latLng4;
        LatLngBounds latLngBounds;
        int readInt = parcel.readInt();
        try {
            latLng = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
            try {
                latLng2 = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
            } catch (BadParcelableException e2) {
                e = e2;
                latLng2 = null;
                latLng3 = latLng2;
                latLng4 = latLng3;
                e.printStackTrace();
                latLngBounds = null;
                return new VisibleRegion(readInt, latLng, latLng2, latLng3, latLng4, latLngBounds);
            }
            try {
                latLng3 = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
                try {
                    latLng4 = (LatLng) parcel.readParcelable(LatLng.class.getClassLoader());
                    try {
                        latLngBounds = (LatLngBounds) parcel.readParcelable(LatLngBounds.class.getClassLoader());
                    } catch (BadParcelableException e10) {
                        e = e10;
                        e.printStackTrace();
                        latLngBounds = null;
                        return new VisibleRegion(readInt, latLng, latLng2, latLng3, latLng4, latLngBounds);
                    }
                } catch (BadParcelableException e11) {
                    e = e11;
                    latLng4 = null;
                }
            } catch (BadParcelableException e12) {
                e = e12;
                latLng3 = null;
                latLng4 = latLng3;
                e.printStackTrace();
                latLngBounds = null;
                return new VisibleRegion(readInt, latLng, latLng2, latLng3, latLng4, latLngBounds);
            }
        } catch (BadParcelableException e13) {
            e = e13;
            latLng = null;
            latLng2 = null;
        }
        return new VisibleRegion(readInt, latLng, latLng2, latLng3, latLng4, latLngBounds);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public VisibleRegion[] newArray(int i10) {
        return new VisibleRegion[i10];
    }
}
