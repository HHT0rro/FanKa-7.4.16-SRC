package com.huawei.hms.core.aidl;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class DataBuffer implements Parcelable {
    public static final Parcelable.Creator<DataBuffer> CREATOR = new a();
    public String URI;

    /* renamed from: a, reason: collision with root package name */
    private int f29778a;

    /* renamed from: b, reason: collision with root package name */
    private Bundle f29779b;
    public Bundle header;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class a implements Parcelable.Creator<DataBuffer> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public DataBuffer createFromParcel(Parcel parcel) {
            return new DataBuffer(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public DataBuffer[] newArray(int i10) {
            return new DataBuffer[i10];
        }
    }

    public /* synthetic */ DataBuffer(Parcel parcel, a aVar) {
        this(parcel);
    }

    private static ClassLoader a(Class cls) {
        return cls.getClassLoader();
    }

    public DataBuffer addBody(Bundle bundle) {
        this.f29779b = bundle;
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Bundle getBody() {
        return this.f29779b;
    }

    public int getBodySize() {
        return this.f29779b == null ? 0 : 1;
    }

    public int getProtocol() {
        return this.f29778a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        if (parcel == null) {
            return;
        }
        parcel.writeInt(this.f29778a);
        parcel.writeString(this.URI);
        parcel.writeBundle(this.header);
        parcel.writeBundle(this.f29779b);
    }

    private DataBuffer(Parcel parcel) {
        this.header = null;
        this.f29778a = 1;
        this.f29779b = null;
        a(parcel);
    }

    private void a(Parcel parcel) {
        this.f29778a = parcel.readInt();
        this.URI = parcel.readString();
        this.header = parcel.readBundle(a(Bundle.class));
        this.f29779b = parcel.readBundle(a(Bundle.class));
    }

    public DataBuffer() {
        this.header = null;
        this.f29778a = 1;
        this.f29779b = null;
    }

    public DataBuffer(String str) {
        this.header = null;
        this.f29778a = 1;
        this.f29779b = null;
        this.URI = str;
    }

    public DataBuffer(String str, int i10) {
        this.header = null;
        this.f29779b = null;
        this.URI = str;
        this.f29778a = i10;
    }
}
