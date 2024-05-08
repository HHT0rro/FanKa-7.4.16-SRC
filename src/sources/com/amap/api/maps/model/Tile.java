package com.amap.api.maps.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.col.p0003l.dx;
import com.autonavi.ae.gmap.maploader.Pools;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

@JBindingInclude
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class Tile implements Parcelable {
    public static final b CREATOR = new b();
    private static final Pools.SynchronizedPool<Tile> M_POOL = new Pools.SynchronizedPool<>(18);

    @JBindingInclude
    private BitmapDescriptor bitmapDescriptor;

    @JBindingInclude
    public final byte[] data;

    @JBindingInclude
    public final int height;

    @JBindingInclude
    private final boolean isBitmap;

    @JBindingInclude
    private final int mVersionCode;

    @JBindingInclude
    public final int width;

    public Tile(int i10, int i11, int i12, byte[] bArr, boolean z10) {
        this.mVersionCode = i10;
        this.width = i11;
        this.height = i12;
        this.data = bArr;
        if (bArr != null) {
            try {
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                this.bitmapDescriptor = BitmapDescriptorFactory.fromBitmap(decodeByteArray);
                dx.a(decodeByteArray);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        this.isBitmap = z10;
    }

    public static Tile obtain(int i10, int i11, byte[] bArr) {
        Tile acquire = M_POOL.acquire();
        return acquire != null ? acquire : new Tile(i10, i11, bArr);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final void recycle() {
        M_POOL.release(this);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.mVersionCode);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeByteArray(this.data);
        parcel.writeInt(this.isBitmap ? 1 : 0);
    }

    public Tile(int i10, int i11, byte[] bArr) {
        this(1, i10, i11, bArr, true);
    }

    public Tile(int i10, int i11, byte[] bArr, boolean z10) {
        this(1, i10, i11, bArr, z10);
    }
}
