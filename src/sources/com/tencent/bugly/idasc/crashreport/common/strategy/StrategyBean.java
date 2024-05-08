package com.tencent.bugly.idasc.crashreport.common.strategy;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.openalliance.ad.constant.u;
import com.tencent.bugly.idasc.proguard.ap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class StrategyBean implements Parcelable {
    public static final Parcelable.Creator<StrategyBean> CREATOR = new Parcelable.Creator<StrategyBean>() { // from class: com.tencent.bugly.idasc.crashreport.common.strategy.StrategyBean.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ StrategyBean createFromParcel(Parcel parcel) {
            return new StrategyBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ StrategyBean[] newArray(int i10) {
            return new StrategyBean[i10];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public static String f39385a = "https://android.bugly.qq.com/rqd/async";

    /* renamed from: b, reason: collision with root package name */
    public static String f39386b = "https://android.bugly.qq.com/rqd/async";

    /* renamed from: c, reason: collision with root package name */
    public static String f39387c;

    /* renamed from: d, reason: collision with root package name */
    public long f39388d;

    /* renamed from: e, reason: collision with root package name */
    public long f39389e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f39390f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f39391g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f39392h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f39393i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f39394j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f39395k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f39396l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f39397m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f39398n;

    /* renamed from: o, reason: collision with root package name */
    public long f39399o;

    /* renamed from: p, reason: collision with root package name */
    public long f39400p;

    /* renamed from: q, reason: collision with root package name */
    public String f39401q;

    /* renamed from: r, reason: collision with root package name */
    public String f39402r;

    /* renamed from: s, reason: collision with root package name */
    public String f39403s;

    /* renamed from: t, reason: collision with root package name */
    public Map<String, String> f39404t;

    /* renamed from: u, reason: collision with root package name */
    public int f39405u;

    /* renamed from: v, reason: collision with root package name */
    public long f39406v;

    /* renamed from: w, reason: collision with root package name */
    public long f39407w;

    public StrategyBean() {
        this.f39388d = -1L;
        this.f39389e = -1L;
        this.f39390f = true;
        this.f39391g = true;
        this.f39392h = true;
        this.f39393i = true;
        this.f39394j = false;
        this.f39395k = true;
        this.f39396l = true;
        this.f39397m = true;
        this.f39398n = true;
        this.f39400p = 30000L;
        this.f39401q = f39385a;
        this.f39402r = f39386b;
        this.f39405u = 10;
        this.f39406v = u.as;
        this.f39407w = -1L;
        this.f39389e = System.currentTimeMillis();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("S(@L@L@)");
        f39387c = sb2.toString();
        sb2.setLength(0);
        sb2.append("*^@K#K@!");
        this.f39403s = sb2.toString();
    }

    public StrategyBean(Parcel parcel) {
        this.f39388d = -1L;
        this.f39389e = -1L;
        boolean z10 = true;
        this.f39390f = true;
        this.f39391g = true;
        this.f39392h = true;
        this.f39393i = true;
        this.f39394j = false;
        this.f39395k = true;
        this.f39396l = true;
        this.f39397m = true;
        this.f39398n = true;
        this.f39400p = 30000L;
        this.f39401q = f39385a;
        this.f39402r = f39386b;
        this.f39405u = 10;
        this.f39406v = u.as;
        this.f39407w = -1L;
        try {
            f39387c = "S(@L@L@)";
            this.f39389e = parcel.readLong();
            this.f39390f = parcel.readByte() == 1;
            this.f39391g = parcel.readByte() == 1;
            this.f39392h = parcel.readByte() == 1;
            this.f39401q = parcel.readString();
            this.f39402r = parcel.readString();
            this.f39403s = parcel.readString();
            this.f39404t = ap.b(parcel);
            this.f39393i = parcel.readByte() == 1;
            this.f39394j = parcel.readByte() == 1;
            this.f39397m = parcel.readByte() == 1;
            this.f39398n = parcel.readByte() == 1;
            this.f39400p = parcel.readLong();
            this.f39395k = parcel.readByte() == 1;
            if (parcel.readByte() != 1) {
                z10 = false;
            }
            this.f39396l = z10;
            this.f39399o = parcel.readLong();
            this.f39405u = parcel.readInt();
            this.f39406v = parcel.readLong();
            this.f39407w = parcel.readLong();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeLong(this.f39389e);
        parcel.writeByte(this.f39390f ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f39391g ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f39392h ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f39401q);
        parcel.writeString(this.f39402r);
        parcel.writeString(this.f39403s);
        ap.b(parcel, this.f39404t);
        parcel.writeByte(this.f39393i ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f39394j ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f39397m ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f39398n ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f39400p);
        parcel.writeByte(this.f39395k ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f39396l ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f39399o);
        parcel.writeInt(this.f39405u);
        parcel.writeLong(this.f39406v);
        parcel.writeLong(this.f39407w);
    }
}
