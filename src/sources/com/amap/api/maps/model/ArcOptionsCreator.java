package com.amap.api.maps.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class ArcOptionsCreator implements Parcelable.Creator<ArcOptions> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public ArcOptions createFromParcel(Parcel parcel) {
        ArcOptions arcOptions = new ArcOptions();
        Bundle readBundle = parcel.readBundle();
        arcOptions.point(new LatLng(readBundle.getDouble("startlat"), readBundle.getDouble("startlng")), new LatLng(readBundle.getDouble("passedlat"), readBundle.getDouble("passedlng")), new LatLng(readBundle.getDouble("endlat"), readBundle.getDouble("endlng")));
        arcOptions.strokeWidth(parcel.readFloat());
        arcOptions.strokeColor(parcel.readInt());
        arcOptions.zIndex(parcel.readFloat());
        arcOptions.visible(parcel.readByte() == 1);
        arcOptions.f8196a = parcel.readString();
        return arcOptions;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public ArcOptions[] newArray(int i10) {
        return new ArcOptions[i10];
    }
}
