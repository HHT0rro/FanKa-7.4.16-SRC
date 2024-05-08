package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class TileProjection implements Parcelable {
    public static final TileProjection CREATOR = new TileProjection(0, 0, 0, 0, 0, 0);
    public final int maxX;
    public final int maxY;
    public final int minX;
    public final int minY;
    public final int offsetX;
    public final int offsetY;

    public TileProjection(int i10, int i11, int i12, int i13, int i14, int i15) {
        this.offsetX = i10;
        this.offsetY = i11;
        this.minX = i12;
        this.maxX = i13;
        this.minY = i14;
        this.maxY = i15;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.offsetX);
        parcel.writeInt(this.offsetY);
        parcel.writeInt(this.minX);
        parcel.writeInt(this.maxX);
        parcel.writeInt(this.maxX);
        parcel.writeInt(this.maxY);
    }
}
