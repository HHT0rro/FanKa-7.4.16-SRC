package com.tencent.bugly.idasc.crashreport.crash;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.bugly.idasc.crashreport.common.info.PlugInBean;
import com.tencent.bugly.idasc.proguard.ap;
import java.util.Map;
import java.util.UUID;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class CrashDetailBean implements Parcelable, Comparable<CrashDetailBean> {
    public static final Parcelable.Creator<CrashDetailBean> CREATOR = new Parcelable.Creator<CrashDetailBean>() { // from class: com.tencent.bugly.idasc.crashreport.crash.CrashDetailBean.1
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
    public long I;
    public long J;
    public long K;
    public String L;
    public String M;
    public String N;
    public String O;
    public String P;
    public long Q;
    public boolean R;
    public Map<String, String> S;
    public Map<String, String> T;
    public int U;
    public int V;
    public Map<String, String> W;
    public Map<String, String> X;
    public byte[] Y;
    public String Z;

    /* renamed from: a, reason: collision with root package name */
    public long f39408a;

    /* renamed from: aa, reason: collision with root package name */
    public String f39409aa;

    /* renamed from: b, reason: collision with root package name */
    public int f39410b;

    /* renamed from: c, reason: collision with root package name */
    public String f39411c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f39412d;

    /* renamed from: e, reason: collision with root package name */
    public String f39413e;

    /* renamed from: f, reason: collision with root package name */
    public String f39414f;

    /* renamed from: g, reason: collision with root package name */
    public String f39415g;

    /* renamed from: h, reason: collision with root package name */
    public Map<String, PlugInBean> f39416h;

    /* renamed from: i, reason: collision with root package name */
    public Map<String, PlugInBean> f39417i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f39418j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f39419k;

    /* renamed from: l, reason: collision with root package name */
    public int f39420l;

    /* renamed from: m, reason: collision with root package name */
    public String f39421m;

    /* renamed from: n, reason: collision with root package name */
    public String f39422n;

    /* renamed from: o, reason: collision with root package name */
    public String f39423o;

    /* renamed from: p, reason: collision with root package name */
    public String f39424p;

    /* renamed from: q, reason: collision with root package name */
    public String f39425q;

    /* renamed from: r, reason: collision with root package name */
    public long f39426r;

    /* renamed from: s, reason: collision with root package name */
    public String f39427s;

    /* renamed from: t, reason: collision with root package name */
    public int f39428t;

    /* renamed from: u, reason: collision with root package name */
    public String f39429u;

    /* renamed from: v, reason: collision with root package name */
    public String f39430v;

    /* renamed from: w, reason: collision with root package name */
    public String f39431w;

    /* renamed from: x, reason: collision with root package name */
    public String f39432x;

    /* renamed from: y, reason: collision with root package name */
    public byte[] f39433y;

    /* renamed from: z, reason: collision with root package name */
    public Map<String, String> f39434z;

    public CrashDetailBean() {
        this.f39408a = -1L;
        this.f39410b = 0;
        this.f39411c = UUID.randomUUID().toString();
        this.f39412d = false;
        this.f39413e = "";
        this.f39414f = "";
        this.f39415g = "";
        this.f39416h = null;
        this.f39417i = null;
        this.f39418j = false;
        this.f39419k = false;
        this.f39420l = 0;
        this.f39421m = "";
        this.f39422n = "";
        this.f39423o = "";
        this.f39424p = "";
        this.f39425q = "";
        this.f39426r = -1L;
        this.f39427s = null;
        this.f39428t = 0;
        this.f39429u = "";
        this.f39430v = "";
        this.f39431w = null;
        this.f39432x = null;
        this.f39433y = null;
        this.f39434z = null;
        this.A = "";
        this.B = "";
        this.C = -1L;
        this.D = -1L;
        this.E = -1L;
        this.F = -1L;
        this.G = -1L;
        this.H = -1L;
        this.I = -1L;
        this.J = -1L;
        this.K = -1L;
        this.L = "";
        this.M = "";
        this.N = "";
        this.O = "";
        this.P = "";
        this.Q = -1L;
        this.R = false;
        this.S = null;
        this.T = null;
        this.U = -1;
        this.V = -1;
        this.W = null;
        this.X = null;
        this.Y = null;
        this.Z = null;
        this.f39409aa = null;
    }

    public CrashDetailBean(Parcel parcel) {
        this.f39408a = -1L;
        this.f39410b = 0;
        this.f39411c = UUID.randomUUID().toString();
        this.f39412d = false;
        this.f39413e = "";
        this.f39414f = "";
        this.f39415g = "";
        this.f39416h = null;
        this.f39417i = null;
        this.f39418j = false;
        this.f39419k = false;
        this.f39420l = 0;
        this.f39421m = "";
        this.f39422n = "";
        this.f39423o = "";
        this.f39424p = "";
        this.f39425q = "";
        this.f39426r = -1L;
        this.f39427s = null;
        this.f39428t = 0;
        this.f39429u = "";
        this.f39430v = "";
        this.f39431w = null;
        this.f39432x = null;
        this.f39433y = null;
        this.f39434z = null;
        this.A = "";
        this.B = "";
        this.C = -1L;
        this.D = -1L;
        this.E = -1L;
        this.F = -1L;
        this.G = -1L;
        this.H = -1L;
        this.I = -1L;
        this.J = -1L;
        this.K = -1L;
        this.L = "";
        this.M = "";
        this.N = "";
        this.O = "";
        this.P = "";
        this.Q = -1L;
        this.R = false;
        this.S = null;
        this.T = null;
        this.U = -1;
        this.V = -1;
        this.W = null;
        this.X = null;
        this.Y = null;
        this.Z = null;
        this.f39409aa = null;
        this.f39410b = parcel.readInt();
        this.f39411c = parcel.readString();
        this.f39412d = parcel.readByte() == 1;
        this.f39413e = parcel.readString();
        this.f39414f = parcel.readString();
        this.f39415g = parcel.readString();
        this.f39418j = parcel.readByte() == 1;
        this.f39419k = parcel.readByte() == 1;
        this.f39420l = parcel.readInt();
        this.f39421m = parcel.readString();
        this.f39422n = parcel.readString();
        this.f39423o = parcel.readString();
        this.f39424p = parcel.readString();
        this.f39425q = parcel.readString();
        this.f39426r = parcel.readLong();
        this.f39427s = parcel.readString();
        this.f39428t = parcel.readInt();
        this.f39429u = parcel.readString();
        this.f39430v = parcel.readString();
        this.f39431w = parcel.readString();
        this.f39434z = ap.b(parcel);
        this.A = parcel.readString();
        this.B = parcel.readString();
        this.C = parcel.readLong();
        this.D = parcel.readLong();
        this.E = parcel.readLong();
        this.F = parcel.readLong();
        this.G = parcel.readLong();
        this.H = parcel.readLong();
        this.L = parcel.readString();
        this.M = parcel.readString();
        this.N = parcel.readString();
        this.O = parcel.readString();
        this.P = parcel.readString();
        this.Q = parcel.readLong();
        this.R = parcel.readByte() == 1;
        this.S = ap.b(parcel);
        this.f39416h = ap.a(parcel);
        this.f39417i = ap.a(parcel);
        this.U = parcel.readInt();
        this.V = parcel.readInt();
        this.W = ap.b(parcel);
        this.X = ap.b(parcel);
        this.Y = parcel.createByteArray();
        this.f39433y = parcel.createByteArray();
        this.Z = parcel.readString();
        this.f39409aa = parcel.readString();
        this.f39432x = parcel.readString();
        this.I = parcel.readLong();
        this.J = parcel.readLong();
        this.K = parcel.readLong();
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(CrashDetailBean crashDetailBean) {
        CrashDetailBean crashDetailBean2 = crashDetailBean;
        if (crashDetailBean2 == null) {
            return 1;
        }
        long j10 = this.f39426r - crashDetailBean2.f39426r;
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
        parcel.writeInt(this.f39410b);
        parcel.writeString(this.f39411c);
        parcel.writeByte(this.f39412d ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f39413e);
        parcel.writeString(this.f39414f);
        parcel.writeString(this.f39415g);
        parcel.writeByte(this.f39418j ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f39419k ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f39420l);
        parcel.writeString(this.f39421m);
        parcel.writeString(this.f39422n);
        parcel.writeString(this.f39423o);
        parcel.writeString(this.f39424p);
        parcel.writeString(this.f39425q);
        parcel.writeLong(this.f39426r);
        parcel.writeString(this.f39427s);
        parcel.writeInt(this.f39428t);
        parcel.writeString(this.f39429u);
        parcel.writeString(this.f39430v);
        parcel.writeString(this.f39431w);
        ap.b(parcel, this.f39434z);
        parcel.writeString(this.A);
        parcel.writeString(this.B);
        parcel.writeLong(this.C);
        parcel.writeLong(this.D);
        parcel.writeLong(this.E);
        parcel.writeLong(this.F);
        parcel.writeLong(this.G);
        parcel.writeLong(this.H);
        parcel.writeString(this.L);
        parcel.writeString(this.M);
        parcel.writeString(this.N);
        parcel.writeString(this.O);
        parcel.writeString(this.P);
        parcel.writeLong(this.Q);
        parcel.writeByte(this.R ? (byte) 1 : (byte) 0);
        ap.b(parcel, this.S);
        ap.a(parcel, this.f39416h);
        ap.a(parcel, this.f39417i);
        parcel.writeInt(this.U);
        parcel.writeInt(this.V);
        ap.b(parcel, this.W);
        ap.b(parcel, this.X);
        parcel.writeByteArray(this.Y);
        parcel.writeByteArray(this.f39433y);
        parcel.writeString(this.Z);
        parcel.writeString(this.f39409aa);
        parcel.writeString(this.f39432x);
        parcel.writeLong(this.I);
        parcel.writeLong(this.J);
        parcel.writeLong(this.K);
    }
}
