package com.tencent.bugly.crashreport.biz;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.bugly.proguard.z;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class UserInfoBean implements Parcelable {
    public static final Parcelable.Creator<UserInfoBean> CREATOR = new Parcelable.Creator<UserInfoBean>() { // from class: com.tencent.bugly.crashreport.biz.UserInfoBean.1
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
    public long f39037a;

    /* renamed from: b, reason: collision with root package name */
    public int f39038b;

    /* renamed from: c, reason: collision with root package name */
    public String f39039c;

    /* renamed from: d, reason: collision with root package name */
    public String f39040d;

    /* renamed from: e, reason: collision with root package name */
    public long f39041e;

    /* renamed from: f, reason: collision with root package name */
    public long f39042f;

    /* renamed from: g, reason: collision with root package name */
    public long f39043g;

    /* renamed from: h, reason: collision with root package name */
    public long f39044h;

    /* renamed from: i, reason: collision with root package name */
    public long f39045i;

    /* renamed from: j, reason: collision with root package name */
    public String f39046j;

    /* renamed from: k, reason: collision with root package name */
    public long f39047k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f39048l;

    /* renamed from: m, reason: collision with root package name */
    public String f39049m;

    /* renamed from: n, reason: collision with root package name */
    public String f39050n;

    /* renamed from: o, reason: collision with root package name */
    public int f39051o;

    /* renamed from: p, reason: collision with root package name */
    public int f39052p;

    /* renamed from: q, reason: collision with root package name */
    public int f39053q;

    /* renamed from: r, reason: collision with root package name */
    public Map<String, String> f39054r;

    /* renamed from: s, reason: collision with root package name */
    public Map<String, String> f39055s;

    public UserInfoBean() {
        this.f39047k = 0L;
        this.f39048l = false;
        this.f39049m = "unknown";
        this.f39052p = -1;
        this.f39053q = -1;
        this.f39054r = null;
        this.f39055s = null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f39038b);
        parcel.writeString(this.f39039c);
        parcel.writeString(this.f39040d);
        parcel.writeLong(this.f39041e);
        parcel.writeLong(this.f39042f);
        parcel.writeLong(this.f39043g);
        parcel.writeLong(this.f39044h);
        parcel.writeLong(this.f39045i);
        parcel.writeString(this.f39046j);
        parcel.writeLong(this.f39047k);
        parcel.writeByte(this.f39048l ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f39049m);
        parcel.writeInt(this.f39052p);
        parcel.writeInt(this.f39053q);
        z.b(parcel, this.f39054r);
        z.b(parcel, this.f39055s);
        parcel.writeString(this.f39050n);
        parcel.writeInt(this.f39051o);
    }

    public UserInfoBean(Parcel parcel) {
        this.f39047k = 0L;
        this.f39048l = false;
        this.f39049m = "unknown";
        this.f39052p = -1;
        this.f39053q = -1;
        this.f39054r = null;
        this.f39055s = null;
        this.f39038b = parcel.readInt();
        this.f39039c = parcel.readString();
        this.f39040d = parcel.readString();
        this.f39041e = parcel.readLong();
        this.f39042f = parcel.readLong();
        this.f39043g = parcel.readLong();
        this.f39044h = parcel.readLong();
        this.f39045i = parcel.readLong();
        this.f39046j = parcel.readString();
        this.f39047k = parcel.readLong();
        this.f39048l = parcel.readByte() == 1;
        this.f39049m = parcel.readString();
        this.f39052p = parcel.readInt();
        this.f39053q = parcel.readInt();
        this.f39054r = z.b(parcel);
        this.f39055s = z.b(parcel);
        this.f39050n = parcel.readString();
        this.f39051o = parcel.readInt();
    }
}
