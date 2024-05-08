package com.tencent.bugly.crashreport.crash;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import com.tencent.bugly.proguard.z;
import java.util.Map;
import java.util.UUID;

/* compiled from: BUGLY */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class CrashDetailBean implements Parcelable, Comparable<CrashDetailBean> {
    public static final Parcelable.Creator<CrashDetailBean> CREATOR = new Parcelable.Creator<CrashDetailBean>() { // from class: com.tencent.bugly.crashreport.crash.CrashDetailBean.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ CrashDetailBean createFromParcel(Parcel parcel) {
            return new CrashDetailBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ CrashDetailBean[] newArray(int i10) {
            return new CrashDetailBean[i10];
        }
    };
    public String A;
    public String B;
    public long C;
    public long D;
    public long E;
    public long F;
    public long G;
    public long H;
    public String I;
    public String J;
    public String K;
    public String L;
    public long M;
    public boolean N;
    public Map<String, String> O;
    public Map<String, String> P;
    public int Q;
    public int R;
    public Map<String, String> S;
    public Map<String, String> T;
    public byte[] U;
    public String V;
    public String W;
    private String X;

    /* renamed from: a, reason: collision with root package name */
    public long f39160a;

    /* renamed from: b, reason: collision with root package name */
    public int f39161b;

    /* renamed from: c, reason: collision with root package name */
    public String f39162c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f39163d;

    /* renamed from: e, reason: collision with root package name */
    public String f39164e;

    /* renamed from: f, reason: collision with root package name */
    public String f39165f;

    /* renamed from: g, reason: collision with root package name */
    public String f39166g;

    /* renamed from: h, reason: collision with root package name */
    public Map<String, PlugInBean> f39167h;

    /* renamed from: i, reason: collision with root package name */
    public Map<String, PlugInBean> f39168i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f39169j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f39170k;

    /* renamed from: l, reason: collision with root package name */
    public int f39171l;

    /* renamed from: m, reason: collision with root package name */
    public String f39172m;

    /* renamed from: n, reason: collision with root package name */
    public String f39173n;

    /* renamed from: o, reason: collision with root package name */
    public String f39174o;

    /* renamed from: p, reason: collision with root package name */
    public String f39175p;

    /* renamed from: q, reason: collision with root package name */
    public String f39176q;

    /* renamed from: r, reason: collision with root package name */
    public long f39177r;

    /* renamed from: s, reason: collision with root package name */
    public String f39178s;

    /* renamed from: t, reason: collision with root package name */
    public int f39179t;

    /* renamed from: u, reason: collision with root package name */
    public String f39180u;

    /* renamed from: v, reason: collision with root package name */
    public String f39181v;

    /* renamed from: w, reason: collision with root package name */
    public String f39182w;

    /* renamed from: x, reason: collision with root package name */
    public String f39183x;

    /* renamed from: y, reason: collision with root package name */
    public byte[] f39184y;

    /* renamed from: z, reason: collision with root package name */
    public Map<String, String> f39185z;

    public CrashDetailBean() {
        this.f39160a = -1L;
        this.f39161b = 0;
        this.f39162c = UUID.randomUUID().toString();
        this.f39163d = false;
        this.f39164e = "";
        this.f39165f = "";
        this.f39166g = "";
        this.f39167h = null;
        this.f39168i = null;
        this.f39169j = false;
        this.f39170k = false;
        this.f39171l = 0;
        this.f39172m = "";
        this.f39173n = "";
        this.f39174o = "";
        this.f39175p = "";
        this.f39176q = "";
        this.f39177r = -1L;
        this.f39178s = null;
        this.f39179t = 0;
        this.f39180u = "";
        this.f39181v = "";
        this.f39182w = null;
        this.f39183x = null;
        this.f39184y = null;
        this.f39185z = null;
        this.A = "";
        this.B = "";
        this.C = -1L;
        this.D = -1L;
        this.E = -1L;
        this.F = -1L;
        this.G = -1L;
        this.H = -1L;
        this.I = "";
        this.X = "";
        this.J = "";
        this.K = "";
        this.L = "";
        this.M = -1L;
        this.N = false;
        this.O = null;
        this.P = null;
        this.Q = -1;
        this.R = -1;
        this.S = null;
        this.T = null;
        this.U = null;
        this.V = null;
        this.W = null;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(CrashDetailBean crashDetailBean) {
        CrashDetailBean crashDetailBean2 = crashDetailBean;
        if (crashDetailBean2 == null) {
            return 1;
        }
        long j10 = this.f39177r - crashDetailBean2.f39177r;
        if (j10 <= 0) {
            return j10 < 0 ? -1 : 0;
        }
        return 1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f39161b);
        parcel.writeString(this.f39162c);
        parcel.writeByte(this.f39163d ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f39164e);
        parcel.writeString(this.f39165f);
        parcel.writeString(this.f39166g);
        parcel.writeByte(this.f39169j ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f39170k ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f39171l);
        parcel.writeString(this.f39172m);
        parcel.writeString(this.f39173n);
        parcel.writeString(this.f39174o);
        parcel.writeString(this.f39175p);
        parcel.writeString(this.f39176q);
        parcel.writeLong(this.f39177r);
        parcel.writeString(this.f39178s);
        parcel.writeInt(this.f39179t);
        parcel.writeString(this.f39180u);
        parcel.writeString(this.f39181v);
        parcel.writeString(this.f39182w);
        z.b(parcel, this.f39185z);
        parcel.writeString(this.A);
        parcel.writeString(this.B);
        parcel.writeLong(this.C);
        parcel.writeLong(this.D);
        parcel.writeLong(this.E);
        parcel.writeLong(this.F);
        parcel.writeLong(this.G);
        parcel.writeLong(this.H);
        parcel.writeString(this.I);
        parcel.writeString(this.X);
        parcel.writeString(this.J);
        parcel.writeString(this.K);
        parcel.writeString(this.L);
        parcel.writeLong(this.M);
        parcel.writeByte(this.N ? (byte) 1 : (byte) 0);
        z.b(parcel, this.O);
        z.a(parcel, this.f39167h);
        z.a(parcel, this.f39168i);
        parcel.writeInt(this.Q);
        parcel.writeInt(this.R);
        z.b(parcel, this.S);
        z.b(parcel, this.T);
        parcel.writeByteArray(this.U);
        parcel.writeByteArray(this.f39184y);
        parcel.writeString(this.V);
        parcel.writeString(this.W);
        parcel.writeString(this.f39183x);
    }

    public CrashDetailBean(Parcel parcel) {
        this.f39160a = -1L;
        this.f39161b = 0;
        this.f39162c = UUID.randomUUID().toString();
        this.f39163d = false;
        this.f39164e = "";
        this.f39165f = "";
        this.f39166g = "";
        this.f39167h = null;
        this.f39168i = null;
        this.f39169j = false;
        this.f39170k = false;
        this.f39171l = 0;
        this.f39172m = "";
        this.f39173n = "";
        this.f39174o = "";
        this.f39175p = "";
        this.f39176q = "";
        this.f39177r = -1L;
        this.f39178s = null;
        this.f39179t = 0;
        this.f39180u = "";
        this.f39181v = "";
        this.f39182w = null;
        this.f39183x = null;
        this.f39184y = null;
        this.f39185z = null;
        this.A = "";
        this.B = "";
        this.C = -1L;
        this.D = -1L;
        this.E = -1L;
        this.F = -1L;
        this.G = -1L;
        this.H = -1L;
        this.I = "";
        this.X = "";
        this.J = "";
        this.K = "";
        this.L = "";
        this.M = -1L;
        this.N = false;
        this.O = null;
        this.P = null;
        this.Q = -1;
        this.R = -1;
        this.S = null;
        this.T = null;
        this.U = null;
        this.V = null;
        this.W = null;
        this.f39161b = parcel.readInt();
        this.f39162c = parcel.readString();
        this.f39163d = parcel.readByte() == 1;
        this.f39164e = parcel.readString();
        this.f39165f = parcel.readString();
        this.f39166g = parcel.readString();
        this.f39169j = parcel.readByte() == 1;
        this.f39170k = parcel.readByte() == 1;
        this.f39171l = parcel.readInt();
        this.f39172m = parcel.readString();
        this.f39173n = parcel.readString();
        this.f39174o = parcel.readString();
        this.f39175p = parcel.readString();
        this.f39176q = parcel.readString();
        this.f39177r = parcel.readLong();
        this.f39178s = parcel.readString();
        this.f39179t = parcel.readInt();
        this.f39180u = parcel.readString();
        this.f39181v = parcel.readString();
        this.f39182w = parcel.readString();
        this.f39185z = z.b(parcel);
        this.A = parcel.readString();
        this.B = parcel.readString();
        this.C = parcel.readLong();
        this.D = parcel.readLong();
        this.E = parcel.readLong();
        this.F = parcel.readLong();
        this.G = parcel.readLong();
        this.H = parcel.readLong();
        this.I = parcel.readString();
        this.X = parcel.readString();
        this.J = parcel.readString();
        this.K = parcel.readString();
        this.L = parcel.readString();
        this.M = parcel.readLong();
        this.N = parcel.readByte() == 1;
        this.O = z.b(parcel);
        this.f39167h = z.a(parcel);
        this.f39168i = z.a(parcel);
        this.Q = parcel.readInt();
        this.R = parcel.readInt();
        this.S = z.b(parcel);
        this.T = z.b(parcel);
        this.U = parcel.createByteArray();
        this.f39184y = parcel.createByteArray();
        this.V = parcel.readString();
        this.W = parcel.readString();
        this.f39183x = parcel.readString();
    }
}
