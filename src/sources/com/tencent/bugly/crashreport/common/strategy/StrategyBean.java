package com.tencent.bugly.crashreport.common.strategy;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.openalliance.ad.constant.u;
import com.tencent.bugly.proguard.z;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class StrategyBean implements Parcelable {
    public static final Parcelable.Creator<StrategyBean> CREATOR = new Parcelable.Creator<StrategyBean>() { // from class: com.tencent.bugly.crashreport.common.strategy.StrategyBean.1
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
    public static String f39122a = "https://android.bugly.qq.com/rqd/async";

    /* renamed from: b, reason: collision with root package name */
    public static String f39123b = "https://android.bugly.qq.com/rqd/async";

    /* renamed from: c, reason: collision with root package name */
    public long f39124c;

    /* renamed from: d, reason: collision with root package name */
    public long f39125d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f39126e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f39127f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f39128g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f39129h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f39130i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f39131j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f39132k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f39133l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f39134m;

    /* renamed from: n, reason: collision with root package name */
    public long f39135n;

    /* renamed from: o, reason: collision with root package name */
    public long f39136o;

    /* renamed from: p, reason: collision with root package name */
    public String f39137p;

    /* renamed from: q, reason: collision with root package name */
    public String f39138q;

    /* renamed from: r, reason: collision with root package name */
    public String f39139r;

    /* renamed from: s, reason: collision with root package name */
    public Map<String, String> f39140s;

    /* renamed from: t, reason: collision with root package name */
    public int f39141t;

    /* renamed from: u, reason: collision with root package name */
    public long f39142u;

    /* renamed from: v, reason: collision with root package name */
    public long f39143v;

    public StrategyBean() {
        this.f39124c = -1L;
        this.f39125d = -1L;
        this.f39126e = true;
        this.f39127f = true;
        this.f39128g = true;
        this.f39129h = true;
        this.f39130i = false;
        this.f39131j = true;
        this.f39132k = true;
        this.f39133l = true;
        this.f39134m = true;
        this.f39136o = 30000L;
        this.f39137p = f39122a;
        this.f39138q = f39123b;
        this.f39141t = 10;
        this.f39142u = u.as;
        this.f39143v = -1L;
        this.f39125d = System.currentTimeMillis();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("S(@L@L");
        sb2.append("@)");
        sb2.setLength(0);
        sb2.append("*^@K#K");
        sb2.append("@!");
        this.f39139r = sb2.toString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeLong(this.f39125d);
        parcel.writeByte(this.f39126e ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f39127f ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f39128g ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f39137p);
        parcel.writeString(this.f39138q);
        parcel.writeString(this.f39139r);
        z.b(parcel, this.f39140s);
        parcel.writeByte(this.f39129h ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f39130i ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f39133l ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f39134m ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f39136o);
        parcel.writeByte(this.f39131j ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f39132k ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f39135n);
        parcel.writeInt(this.f39141t);
        parcel.writeLong(this.f39142u);
        parcel.writeLong(this.f39143v);
    }

    public StrategyBean(Parcel parcel) {
        this.f39124c = -1L;
        this.f39125d = -1L;
        boolean z10 = true;
        this.f39126e = true;
        this.f39127f = true;
        this.f39128g = true;
        this.f39129h = true;
        this.f39130i = false;
        this.f39131j = true;
        this.f39132k = true;
        this.f39133l = true;
        this.f39134m = true;
        this.f39136o = 30000L;
        this.f39137p = f39122a;
        this.f39138q = f39123b;
        this.f39141t = 10;
        this.f39142u = u.as;
        this.f39143v = -1L;
        try {
            this.f39125d = parcel.readLong();
            this.f39126e = parcel.readByte() == 1;
            this.f39127f = parcel.readByte() == 1;
            this.f39128g = parcel.readByte() == 1;
            this.f39137p = parcel.readString();
            this.f39138q = parcel.readString();
            this.f39139r = parcel.readString();
            this.f39140s = z.b(parcel);
            this.f39129h = parcel.readByte() == 1;
            this.f39130i = parcel.readByte() == 1;
            this.f39133l = parcel.readByte() == 1;
            this.f39134m = parcel.readByte() == 1;
            this.f39136o = parcel.readLong();
            this.f39131j = parcel.readByte() == 1;
            if (parcel.readByte() != 1) {
                z10 = false;
            }
            this.f39132k = z10;
            this.f39135n = parcel.readLong();
            this.f39141t = parcel.readInt();
            this.f39142u = parcel.readLong();
            this.f39143v = parcel.readLong();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
