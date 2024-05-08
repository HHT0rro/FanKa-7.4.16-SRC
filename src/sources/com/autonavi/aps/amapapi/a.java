package com.autonavi.aps.amapapi;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: AMapLocationStaticsEntity.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>() { // from class: com.autonavi.aps.amapapi.a.1
        private static a a(Parcel parcel) {
            a aVar = new a();
            aVar.c(parcel.readString());
            aVar.d(parcel.readString());
            aVar.e(parcel.readString());
            aVar.f(parcel.readString());
            aVar.b(parcel.readString());
            aVar.c(parcel.readLong());
            aVar.d(parcel.readLong());
            aVar.a(parcel.readLong());
            aVar.b(parcel.readLong());
            aVar.a(parcel.readString());
            return aVar;
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ a createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ a[] newArray(int i10) {
            return a(i10);
        }

        private static a[] a(int i10) {
            return new a[i10];
        }
    };

    /* renamed from: e, reason: collision with root package name */
    private String f9311e;

    /* renamed from: f, reason: collision with root package name */
    private String f9312f;

    /* renamed from: a, reason: collision with root package name */
    private long f9307a = 0;

    /* renamed from: b, reason: collision with root package name */
    private long f9308b = 0;

    /* renamed from: c, reason: collision with root package name */
    private long f9309c = 0;

    /* renamed from: d, reason: collision with root package name */
    private long f9310d = 0;

    /* renamed from: g, reason: collision with root package name */
    private String f9313g = "first";

    /* renamed from: h, reason: collision with root package name */
    private String f9314h = "";

    /* renamed from: i, reason: collision with root package name */
    private String f9315i = "";

    /* renamed from: j, reason: collision with root package name */
    private String f9316j = null;

    public final long a() {
        long j10 = this.f9310d;
        long j11 = this.f9309c;
        if (j10 - j11 <= 0) {
            return 0L;
        }
        return j10 - j11;
    }

    public final String b() {
        return this.f9315i;
    }

    public final void c(long j10) {
        this.f9307a = j10;
    }

    public final void d(long j10) {
        this.f9308b = j10;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String e() {
        return this.f9312f;
    }

    public final String f() {
        return this.f9313g;
    }

    public final String g() {
        return this.f9314h;
    }

    public final long h() {
        long j10 = this.f9308b;
        long j11 = this.f9307a;
        if (j10 <= j11) {
            return 0L;
        }
        return j10 - j11;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        try {
            parcel.writeString(this.f9311e);
            parcel.writeString(this.f9312f);
            parcel.writeString(this.f9313g);
            parcel.writeString(this.f9314h);
            parcel.writeString(this.f9316j);
            parcel.writeLong(this.f9307a);
            parcel.writeLong(this.f9308b);
            parcel.writeLong(this.f9309c);
            parcel.writeLong(this.f9310d);
            parcel.writeString(this.f9315i);
        } catch (Throwable unused) {
        }
    }

    public final void a(String str) {
        this.f9315i = str;
    }

    public final void b(long j10) {
        this.f9310d = j10;
    }

    public final String c() {
        return this.f9316j;
    }

    public final String d() {
        return this.f9311e;
    }

    public final void e(String str) {
        this.f9313g = str;
    }

    public final void f(String str) {
        this.f9314h = str;
    }

    public final void a(long j10) {
        this.f9309c = j10;
    }

    public final void b(String str) {
        this.f9316j = str;
    }

    public final void c(String str) {
        this.f9311e = str;
    }

    public final void d(String str) {
        this.f9312f = str;
    }
}
