package com.huawei.hms.scankit.p;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Result.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class s6 implements Parcelable {
    public static final Parcelable.Creator<s6> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private final String f31509a;

    /* renamed from: b, reason: collision with root package name */
    private final byte[] f31510b;

    /* renamed from: c, reason: collision with root package name */
    private final int f31511c;

    /* renamed from: d, reason: collision with root package name */
    private u6[] f31512d;

    /* renamed from: e, reason: collision with root package name */
    private BarcodeFormat f31513e;

    /* renamed from: f, reason: collision with root package name */
    private final long f31514f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f31515g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f31516h;

    /* renamed from: i, reason: collision with root package name */
    private final float f31517i;

    /* renamed from: j, reason: collision with root package name */
    private int f31518j;

    /* renamed from: k, reason: collision with root package name */
    private List<Rect> f31519k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f31520l;

    /* renamed from: m, reason: collision with root package name */
    private int f31521m;

    /* renamed from: n, reason: collision with root package name */
    private List<Rect> f31522n;

    /* renamed from: o, reason: collision with root package name */
    private long f31523o;

    /* renamed from: p, reason: collision with root package name */
    private long f31524p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f31525q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f31526r;

    /* compiled from: Result.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class a implements Parcelable.Creator<s6> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public s6 createFromParcel(Parcel parcel) {
            return new s6(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public s6[] newArray(int i10) {
            return new s6[i10];
        }
    }

    public s6(float f10) {
        this.f31515g = false;
        this.f31525q = false;
        this.f31526r = false;
        this.f31517i = f10;
        this.f31509a = null;
        this.f31510b = new byte[0];
        this.f31511c = 0;
        this.f31512d = new u6[0];
        this.f31513e = BarcodeFormat.NONE;
        this.f31514f = 0L;
        this.f31516h = false;
        this.f31518j = 0;
        this.f31520l = false;
        this.f31521m = 0;
        this.f31519k = new ArrayList();
        this.f31522n = new ArrayList();
    }

    public void a(float f10) {
        if (f10 < 20.0f) {
            this.f31518j = 0;
            return;
        }
        if (f10 < 50.0f) {
            this.f31518j = 2;
            return;
        }
        if (f10 < 90.0f) {
            this.f31518j = 1;
            return;
        }
        if (f10 < 140.0f) {
            this.f31518j = 0;
        } else if (f10 < 190.0f) {
            this.f31518j = -1;
        } else if (f10 <= 255.0f) {
            this.f31518j = -2;
        }
    }

    public void b(float f10) {
        if (f10 < 50.0f) {
            this.f31521m = 2;
            return;
        }
        if (f10 < 90.0f) {
            this.f31521m = 1;
            return;
        }
        if (f10 < 140.0f) {
            this.f31521m = 0;
        } else if (f10 < 190.0f) {
            this.f31521m = -1;
        } else if (f10 <= 255.0f) {
            this.f31521m = -2;
        }
    }

    public void c(boolean z10) {
        this.f31515g = z10;
    }

    public List<Rect> d() {
        return this.f31519k;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long e() {
        return this.f31523o;
    }

    public int f() {
        return this.f31518j;
    }

    public List<Rect> g() {
        return this.f31522n;
    }

    public int h() {
        return this.f31521m;
    }

    public byte[] i() {
        return this.f31510b;
    }

    public u6[] j() {
        return this.f31512d;
    }

    public String k() {
        return this.f31509a;
    }

    public float l() {
        return this.f31517i;
    }

    public boolean m() {
        return this.f31525q;
    }

    public boolean n() {
        return this.f31520l;
    }

    public boolean o() {
        return this.f31526r;
    }

    public boolean p() {
        return this.f31515g;
    }

    public String toString() {
        return this.f31509a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f31509a);
        parcel.writeByteArray(this.f31510b);
        parcel.writeInt(this.f31511c);
        parcel.writeTypedArray(this.f31512d, i10);
        parcel.writeParcelable(this.f31513e, i10);
        parcel.writeLong(this.f31514f);
        parcel.writeInt(this.f31515g ? 1 : 0);
        parcel.writeInt(this.f31516h ? 1 : 0);
        parcel.writeFloat(this.f31517i);
        parcel.writeInt(this.f31518j);
        parcel.writeList(this.f31519k);
        parcel.writeLong(this.f31523o);
        parcel.writeLong(this.f31524p);
        parcel.writeInt(this.f31525q ? 1 : 0);
    }

    public BarcodeFormat c() {
        return this.f31513e;
    }

    public void b(i2 i2Var) {
        int d10 = (int) i2Var.d();
        int e2 = (int) i2Var.e();
        this.f31522n.add(new Rect(d10, e2, ((int) i2Var.f()) + d10, ((int) i2Var.c()) + e2));
    }

    public void a(i2 i2Var) {
        int d10 = (int) i2Var.d();
        int e2 = (int) i2Var.e();
        this.f31519k.add(new Rect(d10, e2, ((int) i2Var.f()) + d10, ((int) i2Var.c()) + e2));
    }

    public void b(boolean z10) {
        this.f31520l = z10;
    }

    public void a(int i10) {
        this.f31521m = i10;
    }

    public void b(long j10) {
        this.f31523o = j10;
    }

    public void a(u6[] u6VarArr) {
        u6[] u6VarArr2 = this.f31512d;
        if (u6VarArr2 == null) {
            this.f31512d = u6VarArr;
            return;
        }
        if (u6VarArr == null || u6VarArr.length <= 0) {
            return;
        }
        u6[] u6VarArr3 = new u6[u6VarArr2.length + u6VarArr.length];
        System.arraycopy(u6VarArr2, 0, u6VarArr3, 0, u6VarArr2.length);
        System.arraycopy(u6VarArr, 0, u6VarArr3, u6VarArr2.length, u6VarArr.length);
        this.f31512d = u6VarArr3;
    }

    public long b() {
        return this.f31524p;
    }

    public void b(u6[] u6VarArr) {
        this.f31512d = u6VarArr;
    }

    public s6(float f10, boolean z10) {
        this.f31515g = false;
        this.f31525q = false;
        this.f31526r = false;
        this.f31517i = f10;
        this.f31509a = null;
        this.f31510b = new byte[0];
        this.f31511c = 0;
        this.f31512d = new u6[0];
        this.f31513e = BarcodeFormat.NONE;
        this.f31514f = 0L;
        this.f31516h = false;
        this.f31518j = 0;
        this.f31520l = false;
        this.f31521m = 0;
        this.f31526r = z10;
        this.f31519k = new ArrayList();
        this.f31522n = new ArrayList();
    }

    public void a(long j10) {
        this.f31524p = j10;
    }

    public void a(boolean z10) {
        this.f31525q = z10;
    }

    public void a() {
        this.f31512d = new u6[0];
    }

    public s6(String str, byte[] bArr, u6[] u6VarArr, BarcodeFormat barcodeFormat) {
        this(str, bArr, u6VarArr, barcodeFormat, System.currentTimeMillis());
    }

    public s6(String str, byte[] bArr, u6[] u6VarArr, BarcodeFormat barcodeFormat, long j10) {
        this(str, bArr, bArr == null ? 0 : bArr.length * 8, u6VarArr, barcodeFormat, j10);
    }

    public s6(String str, byte[] bArr, int i10, u6[] u6VarArr, BarcodeFormat barcodeFormat, long j10) {
        this.f31515g = false;
        this.f31525q = false;
        this.f31526r = false;
        this.f31509a = str;
        this.f31510b = bArr;
        this.f31511c = i10;
        this.f31512d = u6VarArr;
        this.f31513e = barcodeFormat;
        this.f31514f = j10;
        this.f31517i = 1.0f;
        this.f31516h = false;
    }

    public s6(Parcel parcel) {
        this.f31515g = false;
        this.f31525q = false;
        this.f31526r = false;
        this.f31509a = parcel.readString();
        this.f31510b = parcel.createByteArray();
        this.f31511c = parcel.readInt();
        this.f31512d = (u6[]) parcel.createTypedArray(u6.CREATOR);
        this.f31513e = (BarcodeFormat) parcel.readParcelable(s6.class.getClassLoader());
        this.f31514f = parcel.readLong();
        this.f31515g = parcel.readInt() == 1;
        this.f31516h = parcel.readInt() == 1;
        this.f31517i = parcel.readFloat();
        this.f31518j = parcel.readInt();
        if (this.f31519k == null) {
            this.f31519k = new ArrayList();
        }
        parcel.readList(this.f31519k, s6.class.getClassLoader());
        this.f31523o = parcel.readLong();
        this.f31524p = parcel.readLong();
        this.f31525q = parcel.readInt() == 1;
    }
}
