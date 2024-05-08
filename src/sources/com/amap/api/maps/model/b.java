package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: TileCreator.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
final class b implements Parcelable.Creator<Tile> {
    private static Tile a(Parcel parcel) {
        return new Tile(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.createByteArray(), parcel.readInt() == 1);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Tile createFromParcel(Parcel parcel) {
        return a(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Tile[] newArray(int i10) {
        return a(i10);
    }

    private static Tile[] a(int i10) {
        return new Tile[i10];
    }
}
