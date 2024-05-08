package com.tencent.bugly.idasc.crashreport.biz;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.bugly.idasc.proguard.ap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class UserInfoBean implements Parcelable {
    public static final Parcelable.Creator<UserInfoBean> CREATOR = new Parcelable.Creator<UserInfoBean>() { // from class: com.tencent.bugly.idasc.crashreport.biz.UserInfoBean.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ UserInfoBean createFromParcel(Parcel parcel) {
            return new UserInfoBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ UserInfoBean[] newArray(int i10) {
            return new UserInfoBean[i10];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public long f39363a;

    /* renamed from: b, reason: collision with root package name */
    public int f39364b;

    /* renamed from: c, reason: collision with root package name */
    public String f39365c;

    /* renamed from: d, reason: collision with root package name */
    public String f39366d;

    /* renamed from: e, reason: collision with root package name */
    public long f39367e;

    /* renamed from: f, reason: collision with root package name */
    public long f39368f;

    /* renamed from: g, reason: collision with root package name */
    public long f39369g;

    /* renamed from: h, reason: collision with root package name */
    public long f39370h;

    /* renamed from: i, reason: collision with root package name */
    public long f39371i;

    /* renamed from: j, reason: collision with root package name */
    public String f39372j;

    /* renamed from: k, reason: collision with root package name */
    public long f39373k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f39374l;

    /* renamed from: m, reason: collision with root package name */
    public String f39375m;

    /* renamed from: n, reason: collision with root package name */
    public String f39376n;

    /* renamed from: o, reason: collision with root package name */
    public int f39377o;

    /* renamed from: p, reason: collision with root package name */
    public int f39378p;

    /* renamed from: q, reason: collision with root package name */
    public int f39379q;

    /* renamed from: r, reason: collision with root package name */
    public Map<String, String> f39380r;

    /* renamed from: s, reason: collision with root package name */
    public Map<String, String> f39381s;

    public UserInfoBean() {
        this.f39373k = 0L;
        this.f39374l = false;
        this.f39375m = "unknown";
        this.f39378p = -1;
        this.f39379q = -1;
        this.f39380r = null;
        this.f39381s = null;
    }

    public UserInfoBean(Parcel parcel) {
        this.f39373k = 0L;
        this.f39374l = false;
        this.f39375m = "unknown";
        this.f39378p = -1;
        this.f39379q = -1;
        this.f39380r = null;
        this.f39381s = null;
        this.f39364b = parcel.readInt();
        this.f39365c = parcel.readString();
        this.f39366d = parcel.readString();
        this.f39367e = parcel.readLong();
        this.f39368f = parcel.readLong();
        this.f39369g = parcel.readLong();
        this.f39370h = parcel.readLong();
        this.f39371i = parcel.readLong();
        this.f39372j = parcel.readString();
        this.f39373k = parcel.readLong();
        this.f39374l = parcel.readByte() == 1;
        this.f39375m = parcel.readString();
        this.f39378p = parcel.readInt();
        this.f39379q = parcel.readInt();
        this.f39380r = ap.b(parcel);
        this.f39381s = ap.b(parcel);
        this.f39376n = parcel.readString();
        this.f39377o = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f39364b);
        parcel.writeString(this.f39365c);
        parcel.writeString(this.f39366d);
        parcel.writeLong(this.f39367e);
        parcel.writeLong(this.f39368f);
        parcel.writeLong(this.f39369g);
        parcel.writeLong(this.f39370h);
        parcel.writeLong(this.f39371i);
        parcel.writeString(this.f39372j);
        parcel.writeLong(this.f39373k);
        parcel.writeByte(this.f39374l ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f39375m);
        parcel.writeInt(this.f39378p);
        parcel.writeInt(this.f39379q);
        ap.b(parcel, this.f39380r);
        ap.b(parcel, this.f39381s);
        parcel.writeString(this.f39376n);
        parcel.writeInt(this.f39377o);
    }
}
