package com.amap.api.col.p0003l;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.maps.model.BaseOptions;
import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ContourLineOptions.java */
@JBindingInclude
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class eo extends BaseOptions implements Parcelable {

    @JBindingExclude
    public static final Parcelable.Creator<eo> CREATOR = new Parcelable.Creator<eo>() { // from class: com.amap.api.col.3l.eo.1
        private static eo a(Parcel parcel) {
            return new eo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ eo createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ eo[] newArray(int i10) {
            return a(i10);
        }

        private static eo[] a(int i10) {
            return new eo[i10];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private float f5575a;

    /* renamed from: b, reason: collision with root package name */
    private float f5576b;

    /* renamed from: c, reason: collision with root package name */
    private float f5577c;

    /* renamed from: d, reason: collision with root package name */
    private float f5578d;

    /* renamed from: e, reason: collision with root package name */
    private float f5579e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f5580f;

    /* renamed from: g, reason: collision with root package name */
    private int f5581g;

    /* renamed from: h, reason: collision with root package name */
    private double f5582h;

    /* renamed from: i, reason: collision with root package name */
    private List<en> f5583i;

    public eo() {
        this.f5575a = 3.0f;
        this.f5576b = 20.0f;
        this.f5577c = Float.MIN_VALUE;
        this.f5578d = Float.MAX_VALUE;
        this.f5579e = 200.0f;
        this.f5580f = true;
        this.f5581g = -3355444;
        this.f5582h = 3.0d;
        this.f5583i = new ArrayList();
        this.type = "ContourLineOptions";
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeFloat(this.f5575a);
        parcel.writeFloat(this.f5576b);
        parcel.writeFloat(this.f5577c);
        parcel.writeFloat(this.f5578d);
        parcel.writeFloat(this.f5579e);
        parcel.writeBooleanArray(new boolean[]{this.f5580f});
        parcel.writeInt(this.f5581g);
        parcel.writeDouble(this.f5582h);
        parcel.writeList(this.f5583i);
    }

    @JBindingExclude
    public eo(Parcel parcel) {
        this.f5575a = 3.0f;
        this.f5576b = 20.0f;
        this.f5577c = Float.MIN_VALUE;
        this.f5578d = Float.MAX_VALUE;
        this.f5579e = 200.0f;
        this.f5580f = true;
        this.f5581g = -3355444;
        this.f5582h = 3.0d;
        this.f5583i = new ArrayList();
        this.f5575a = parcel.readFloat();
        this.f5576b = parcel.readFloat();
        this.f5577c = parcel.readFloat();
        this.f5578d = parcel.readFloat();
        this.f5579e = parcel.readFloat();
        boolean[] zArr = new boolean[1];
        parcel.readBooleanArray(zArr);
        this.f5580f = zArr[0];
        this.f5581g = parcel.readInt();
        this.f5582h = parcel.readDouble();
        this.f5583i = parcel.readArrayList(en.class.getClassLoader());
    }
}
