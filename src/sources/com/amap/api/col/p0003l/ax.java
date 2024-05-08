package com.amap.api.col.p0003l;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.amap.api.col.p0003l.bp;
import com.amap.api.col.p0003l.by;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import java.io.File;

/* compiled from: CityObject.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ax extends OfflineMapCity implements bg, bx {
    public static final Parcelable.Creator<ax> CREATOR = new Parcelable.Creator<ax>() { // from class: com.amap.api.col.3l.ax.2
        private static ax a(Parcel parcel) {
            return new ax(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ ax createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ ax[] newArray(int i10) {
            return a(i10);
        }

        private static ax[] a(int i10) {
            return new ax[i10];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public final cb f5056a;

    /* renamed from: b, reason: collision with root package name */
    public final cb f5057b;

    /* renamed from: c, reason: collision with root package name */
    public final cb f5058c;

    /* renamed from: d, reason: collision with root package name */
    public final cb f5059d;

    /* renamed from: e, reason: collision with root package name */
    public final cb f5060e;

    /* renamed from: f, reason: collision with root package name */
    public final cb f5061f;

    /* renamed from: g, reason: collision with root package name */
    public final cb f5062g;

    /* renamed from: h, reason: collision with root package name */
    public final cb f5063h;

    /* renamed from: i, reason: collision with root package name */
    public final cb f5064i;

    /* renamed from: j, reason: collision with root package name */
    public final cb f5065j;

    /* renamed from: k, reason: collision with root package name */
    public final cb f5066k;

    /* renamed from: l, reason: collision with root package name */
    public cb f5067l;

    /* renamed from: m, reason: collision with root package name */
    public Context f5068m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f5069n;

    /* renamed from: o, reason: collision with root package name */
    private String f5070o;

    /* renamed from: p, reason: collision with root package name */
    private String f5071p;

    /* renamed from: q, reason: collision with root package name */
    private long f5072q;

    /* compiled from: CityObject.java */
    /* renamed from: com.amap.api.col.3l.ax$3, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static /* synthetic */ class AnonymousClass3 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f5076a;

        static {
            int[] iArr = new int[by.a.values().length];
            f5076a = iArr;
            try {
                iArr[by.a.amap_exception.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5076a[by.a.file_io_exception.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5076a[by.a.network_exception.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public ax(Context context, OfflineMapCity offlineMapCity) {
        this(context, offlineMapCity.getState());
        setCity(offlineMapCity.getCity());
        setUrl(offlineMapCity.getUrl());
        setState(offlineMapCity.getState());
        setCompleteCode(offlineMapCity.getcompleteCode());
        setAdcode(offlineMapCity.getAdcode());
        setVersion(offlineMapCity.getVersion());
        setSize(offlineMapCity.getSize());
        setCode(offlineMapCity.getCode());
        setJianpin(offlineMapCity.getJianpin());
        setPinyin(offlineMapCity.getPinyin());
        s();
    }

    private String A() {
        if (TextUtils.isEmpty(this.f5070o)) {
            return null;
        }
        String str = this.f5070o;
        return str.substring(0, str.lastIndexOf("."));
    }

    private String B() {
        if (TextUtils.isEmpty(this.f5070o)) {
            return null;
        }
        String A = A();
        return A.substring(0, A.lastIndexOf(46));
    }

    private boolean C() {
        bv.a();
        getSize();
        getcompleteCode();
        getSize();
        return false;
    }

    private void z() {
        ay a10 = ay.a(this.f5068m);
        if (a10 != null) {
            a10.a(this);
        }
    }

    @Override // com.amap.api.col.p0003l.bg
    public final String b() {
        return getUrl();
    }

    public final cb c() {
        return this.f5067l;
    }

    public final void d() {
        ay a10 = ay.a(this.f5068m);
        if (a10 != null) {
            a10.c(this);
        }
    }

    @Override // com.amap.api.maps.offlinemap.OfflineMapCity, com.amap.api.maps.offlinemap.City, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final void e() {
        ay a10 = ay.a(this.f5068m);
        if (a10 != null) {
            a10.e(this);
            d();
        }
    }

    public final void f() {
        c().b();
        if (this.f5067l.equals(this.f5059d)) {
            this.f5067l.d();
            return;
        }
        if (this.f5067l.equals(this.f5058c)) {
            this.f5067l.e();
            return;
        }
        if (!this.f5067l.equals(this.f5062g) && !this.f5067l.equals(this.f5063h)) {
            if (!this.f5067l.equals(this.f5065j) && !this.f5067l.equals(this.f5064i) && !this.f5067l.a(this.f5066k)) {
                c().h();
                return;
            } else {
                this.f5067l.c();
                return;
            }
        }
        z();
        this.f5069n = true;
    }

    public final void g() {
        this.f5067l.e();
    }

    public final void h() {
        this.f5067l.a(this.f5066k.b());
    }

    public final void i() {
        this.f5067l.a();
        if (this.f5069n) {
            this.f5067l.h();
        }
        this.f5069n = false;
    }

    public final void j() {
        this.f5067l.equals(this.f5061f);
        this.f5067l.f();
    }

    public final void k() {
        ay a10 = ay.a(this.f5068m);
        if (a10 != null) {
            a10.b(this);
        }
    }

    public final void l() {
        ay a10 = ay.a(this.f5068m);
        if (a10 != null) {
            a10.d(this);
        }
    }

    @Override // com.amap.api.col.p0003l.by
    public final void m() {
        this.f5072q = 0L;
        this.f5067l.equals(this.f5057b);
        this.f5067l.c();
    }

    @Override // com.amap.api.col.p0003l.by
    public final void n() {
        this.f5067l.equals(this.f5058c);
        this.f5067l.g();
    }

    @Override // com.amap.api.col.p0003l.by
    public final void o() {
        e();
    }

    @Override // com.amap.api.col.p0003l.bq
    public final void p() {
        this.f5072q = 0L;
        setCompleteCode(0);
        this.f5067l.equals(this.f5060e);
        this.f5067l.c();
    }

    @Override // com.amap.api.col.p0003l.bq
    public final void q() {
        this.f5067l.equals(this.f5060e);
        this.f5067l.a(this.f5063h.b());
    }

    @Override // com.amap.api.col.p0003l.bq
    public final void r() {
        e();
    }

    public final void s() {
        String str = ay.f5077a;
        String b4 = bv.b(getUrl());
        if (b4 != null) {
            this.f5070o = str + b4 + ".zip.tmp";
            return;
        }
        this.f5070o = str + getPinyin() + ".zip.tmp";
    }

    public final bi t() {
        setState(this.f5067l.b());
        bi biVar = new bi(this, this.f5068m);
        biVar.a(a());
        a();
        return biVar;
    }

    @Override // com.amap.api.col.p0003l.bx
    public final boolean u() {
        return C();
    }

    @Override // com.amap.api.col.p0003l.bx
    public final String v() {
        StringBuffer stringBuffer = new StringBuffer();
        String b4 = bv.b(getUrl());
        if (b4 != null) {
            stringBuffer.append(b4);
        } else {
            stringBuffer.append(getPinyin());
        }
        stringBuffer.append(".zip");
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.p0003l.bx
    public final String w() {
        return getAdcode();
    }

    @Override // com.amap.api.maps.offlinemap.OfflineMapCity, com.amap.api.maps.offlinemap.City, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeString(this.f5071p);
    }

    @Override // com.amap.api.col.p0003l.br
    public final String x() {
        return A();
    }

    @Override // com.amap.api.col.p0003l.br
    public final String y() {
        return B();
    }

    @Override // com.amap.api.col.p0003l.bq
    public final void b(String str) {
        this.f5067l.equals(this.f5060e);
        this.f5071p = str;
        String A = A();
        String B = B();
        if (!TextUtils.isEmpty(A) && !TextUtils.isEmpty(B)) {
            File file = new File(B + "/");
            File file2 = new File(dx.a(this.f5068m) + File.separator + "map/");
            File file3 = new File(dx.a(this.f5068m));
            if (file3.exists() || file3.mkdir()) {
                if (file2.exists() || file2.mkdir()) {
                    a(file, file2, A);
                    return;
                }
                return;
            }
            return;
        }
        q();
    }

    public final void a(String str) {
        this.f5071p = str;
    }

    public final String a() {
        return this.f5071p;
    }

    public final void a(int i10) {
        if (i10 == -1) {
            this.f5067l = this.f5063h;
        } else if (i10 == 0) {
            this.f5067l = this.f5058c;
        } else if (i10 == 1) {
            this.f5067l = this.f5060e;
        } else if (i10 == 2) {
            this.f5067l = this.f5057b;
        } else if (i10 == 3) {
            this.f5067l = this.f5059d;
        } else if (i10 == 4) {
            this.f5067l = this.f5061f;
        } else if (i10 == 6) {
            this.f5067l = this.f5056a;
        } else if (i10 != 7) {
            switch (i10) {
                case 101:
                    this.f5067l = this.f5064i;
                    break;
                case 102:
                    this.f5067l = this.f5065j;
                    break;
                case 103:
                    this.f5067l = this.f5066k;
                    break;
                default:
                    if (i10 < 0) {
                        this.f5067l = this.f5063h;
                        break;
                    }
                    break;
            }
        } else {
            this.f5067l = this.f5062g;
        }
        setState(i10);
    }

    private ax(Context context, int i10) {
        this.f5056a = new cd(this);
        this.f5057b = new ck(this);
        this.f5058c = new cg(this);
        this.f5059d = new ci(this);
        this.f5060e = new cj(this);
        this.f5061f = new cc(this);
        this.f5062g = new ch(this);
        this.f5063h = new ce(-1, this);
        this.f5064i = new ce(101, this);
        this.f5065j = new ce(102, this);
        this.f5066k = new ce(103, this);
        this.f5070o = null;
        this.f5071p = "";
        this.f5069n = false;
        this.f5072q = 0L;
        this.f5068m = context;
        a(i10);
    }

    public final cb b(int i10) {
        switch (i10) {
            case 101:
                return this.f5064i;
            case 102:
                return this.f5065j;
            case 103:
                return this.f5066k;
            default:
                return this.f5063h;
        }
    }

    public final void a(cb cbVar) {
        this.f5067l = cbVar;
        setState(cbVar.b());
    }

    @Override // com.amap.api.col.p0003l.by
    public final void a(long j10, long j11) {
        int i10 = (int) ((j11 * 100) / j10);
        if (i10 != getcompleteCode()) {
            setCompleteCode(i10);
            d();
        }
    }

    @Override // com.amap.api.col.p0003l.by
    public final void a(by.a aVar) {
        int b4;
        int i10 = AnonymousClass3.f5076a[aVar.ordinal()];
        if (i10 == 1) {
            b4 = this.f5065j.b();
        } else if (i10 != 2) {
            b4 = i10 != 3 ? 6 : this.f5064i.b();
        } else {
            b4 = this.f5066k.b();
        }
        if (this.f5067l.equals(this.f5058c) || this.f5067l.equals(this.f5057b)) {
            this.f5067l.a(b4);
        }
    }

    @Override // com.amap.api.col.p0003l.bq
    public final void a(long j10) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f5072q > 500) {
            int i10 = (int) j10;
            if (i10 > getcompleteCode()) {
                setCompleteCode(i10);
                d();
            }
            this.f5072q = currentTimeMillis;
        }
    }

    public ax(Parcel parcel) {
        super(parcel);
        this.f5056a = new cd(this);
        this.f5057b = new ck(this);
        this.f5058c = new cg(this);
        this.f5059d = new ci(this);
        this.f5060e = new cj(this);
        this.f5061f = new cc(this);
        this.f5062g = new ch(this);
        this.f5063h = new ce(-1, this);
        this.f5064i = new ce(101, this);
        this.f5065j = new ce(102, this);
        this.f5066k = new ce(103, this);
        this.f5070o = null;
        this.f5071p = "";
        this.f5069n = false;
        this.f5072q = 0L;
        this.f5071p = parcel.readString();
    }

    private void a(final File file, File file2, final String str) {
        new bp().a(file, file2, -1L, bv.a(file), new bp.a() { // from class: com.amap.api.col.3l.ax.1
            @Override // com.amap.api.col.3l.bp.a
            public final void a(float f10) {
                int i10 = (int) ((f10 * 0.39d) + 60.0d);
                if (i10 - ax.this.getcompleteCode() <= 0 || System.currentTimeMillis() - ax.this.f5072q <= 1000) {
                    return;
                }
                ax.this.setCompleteCode(i10);
                ax.this.f5072q = System.currentTimeMillis();
            }

            @Override // com.amap.api.col.3l.bp.a
            public final void b() {
                ax axVar = ax.this;
                axVar.f5067l.a(axVar.f5066k.b());
            }

            @Override // com.amap.api.col.3l.bp.a
            public final void a() {
                try {
                    if (new File(str).delete()) {
                        bv.b(file);
                        ax.this.setCompleteCode(100);
                        ax.this.f5067l.g();
                    }
                } catch (Exception unused) {
                    ax axVar = ax.this;
                    axVar.f5067l.a(axVar.f5066k.b());
                }
            }
        });
    }
}
