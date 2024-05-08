package com.amap.api.maps.model;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.col.p0003l.dx;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

@JBindingInclude
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class BitmapDescriptor implements Parcelable, Cloneable {
    public static final BitmapDescriptorCreator CREATOR = new BitmapDescriptorCreator();

    /* renamed from: a, reason: collision with root package name */
    public int f8197a;

    /* renamed from: b, reason: collision with root package name */
    public int f8198b;

    @JBindingInclude
    public Object mBitmap;

    @JBindingInclude
    private String mId;

    public BitmapDescriptor(Bitmap bitmap, String str) {
        this.f8197a = 0;
        this.f8198b = 0;
        if (bitmap != null) {
            try {
                this.f8197a = bitmap.getWidth();
                this.f8198b = bitmap.getHeight();
                if (bitmap.getConfig() == null) {
                    this.mBitmap = bitmap.copy(Bitmap.Config.ARGB_8888, true);
                } else {
                    this.mBitmap = bitmap.copy(bitmap.getConfig(), true);
                }
            } catch (Throwable th) {
                dx.a(th);
                return;
            }
        }
        this.mId = str;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        BitmapDescriptor bitmapDescriptor;
        Object obj2;
        Object obj3 = this.mBitmap;
        if (obj3 == null || ((Bitmap) obj3).isRecycled() || obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (BitmapDescriptor.class == obj.getClass() && (obj2 = (bitmapDescriptor = (BitmapDescriptor) obj).mBitmap) != null && !((Bitmap) obj2).isRecycled() && this.f8197a == bitmapDescriptor.getWidth() && this.f8198b == bitmapDescriptor.getHeight()) {
            try {
                return ((Bitmap) this.mBitmap).sameAs((Bitmap) bitmapDescriptor.mBitmap);
            } catch (Throwable th) {
                dx.a(th);
            }
        }
        return false;
    }

    public final Bitmap getBitmap() {
        return (Bitmap) this.mBitmap;
    }

    public final int getHeight() {
        return this.f8198b;
    }

    public final String getId() {
        return this.mId;
    }

    public final int getWidth() {
        return this.f8197a;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public final void recycle() {
        try {
            dx.a((Bitmap) this.mBitmap);
        } catch (Throwable th) {
            dx.a(th);
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.mId);
        parcel.writeParcelable((Bitmap) this.mBitmap, i10);
        parcel.writeInt(this.f8197a);
        parcel.writeInt(this.f8198b);
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public final BitmapDescriptor m1960clone() {
        try {
            Object obj = this.mBitmap;
            return new BitmapDescriptor(((Bitmap) obj).copy(((Bitmap) obj).getConfig(), true), this.f8197a, this.f8198b, this.mId);
        } catch (Throwable th) {
            th.printStackTrace();
            dx.a(th);
            return null;
        }
    }

    private BitmapDescriptor(Bitmap bitmap, int i10, int i11, String str) {
        this.f8197a = i10;
        this.f8198b = i11;
        this.mBitmap = bitmap;
        this.mId = str;
    }
}
