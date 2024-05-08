package com.tencent.cloud.huiyansdkface.okhttp3;

import java.util.concurrent.TimeUnit;
import java.util.zip.ZipUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class CacheControl {

    /* renamed from: a, reason: collision with root package name */
    public static final CacheControl f41271a = new Builder().noCache().build();

    /* renamed from: b, reason: collision with root package name */
    public static final CacheControl f41272b = new Builder().onlyIfCached().maxStale(Integer.MAX_VALUE, TimeUnit.SECONDS).build();

    /* renamed from: c, reason: collision with root package name */
    public String f41273c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f41274d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f41275e;

    /* renamed from: f, reason: collision with root package name */
    private final int f41276f;

    /* renamed from: g, reason: collision with root package name */
    private final int f41277g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f41278h;

    /* renamed from: i, reason: collision with root package name */
    private final boolean f41279i;

    /* renamed from: j, reason: collision with root package name */
    private final boolean f41280j;

    /* renamed from: k, reason: collision with root package name */
    private final int f41281k;

    /* renamed from: l, reason: collision with root package name */
    private final int f41282l;

    /* renamed from: m, reason: collision with root package name */
    private final boolean f41283m;

    /* renamed from: n, reason: collision with root package name */
    private final boolean f41284n;

    /* renamed from: o, reason: collision with root package name */
    private final boolean f41285o;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public boolean f41286a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f41287b;

        /* renamed from: c, reason: collision with root package name */
        public int f41288c = -1;

        /* renamed from: d, reason: collision with root package name */
        public int f41289d = -1;

        /* renamed from: e, reason: collision with root package name */
        public int f41290e = -1;

        /* renamed from: f, reason: collision with root package name */
        public boolean f41291f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f41292g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f41293h;

        public CacheControl build() {
            return new CacheControl(this);
        }

        public Builder immutable() {
            this.f41293h = true;
            return this;
        }

        public Builder maxAge(int i10, TimeUnit timeUnit) {
            if (i10 >= 0) {
                long seconds = timeUnit.toSeconds(i10);
                this.f41288c = seconds > ZipUtils.UPPER_UNIXTIME_BOUND ? Integer.MAX_VALUE : (int) seconds;
                return this;
            }
            throw new IllegalArgumentException("maxAge < 0: " + i10);
        }

        public Builder maxStale(int i10, TimeUnit timeUnit) {
            if (i10 >= 0) {
                long seconds = timeUnit.toSeconds(i10);
                this.f41289d = seconds > ZipUtils.UPPER_UNIXTIME_BOUND ? Integer.MAX_VALUE : (int) seconds;
                return this;
            }
            throw new IllegalArgumentException("maxStale < 0: " + i10);
        }

        public Builder minFresh(int i10, TimeUnit timeUnit) {
            if (i10 >= 0) {
                long seconds = timeUnit.toSeconds(i10);
                this.f41290e = seconds > ZipUtils.UPPER_UNIXTIME_BOUND ? Integer.MAX_VALUE : (int) seconds;
                return this;
            }
            throw new IllegalArgumentException("minFresh < 0: " + i10);
        }

        public Builder noCache() {
            this.f41286a = true;
            return this;
        }

        public Builder noStore() {
            this.f41287b = true;
            return this;
        }

        public Builder noTransform() {
            this.f41292g = true;
            return this;
        }

        public Builder onlyIfCached() {
            this.f41291f = true;
            return this;
        }
    }

    public CacheControl(Builder builder) {
        this.f41274d = builder.f41286a;
        this.f41275e = builder.f41287b;
        this.f41276f = builder.f41288c;
        this.f41277g = -1;
        this.f41278h = false;
        this.f41279i = false;
        this.f41280j = false;
        this.f41281k = builder.f41289d;
        this.f41282l = builder.f41290e;
        this.f41283m = builder.f41291f;
        this.f41284n = builder.f41292g;
        this.f41285o = builder.f41293h;
    }

    private CacheControl(boolean z10, boolean z11, int i10, int i11, boolean z12, boolean z13, boolean z14, int i12, int i13, boolean z15, boolean z16, boolean z17, String str) {
        this.f41274d = z10;
        this.f41275e = z11;
        this.f41276f = i10;
        this.f41277g = i11;
        this.f41278h = z12;
        this.f41279i = z13;
        this.f41280j = z14;
        this.f41281k = i12;
        this.f41282l = i13;
        this.f41283m = z15;
        this.f41284n = z16;
        this.f41285o = z17;
        this.f41273c = str;
    }

    private String a() {
        StringBuilder sb2 = new StringBuilder();
        if (this.f41274d) {
            sb2.append("no-cache, ");
        }
        if (this.f41275e) {
            sb2.append("no-store, ");
        }
        if (this.f41276f != -1) {
            sb2.append("max-age=");
            sb2.append(this.f41276f);
            sb2.append(", ");
        }
        if (this.f41277g != -1) {
            sb2.append("s-maxage=");
            sb2.append(this.f41277g);
            sb2.append(", ");
        }
        if (this.f41278h) {
            sb2.append("private, ");
        }
        if (this.f41279i) {
            sb2.append("public, ");
        }
        if (this.f41280j) {
            sb2.append("must-revalidate, ");
        }
        if (this.f41281k != -1) {
            sb2.append("max-stale=");
            sb2.append(this.f41281k);
            sb2.append(", ");
        }
        if (this.f41282l != -1) {
            sb2.append("min-fresh=");
            sb2.append(this.f41282l);
            sb2.append(", ");
        }
        if (this.f41283m) {
            sb2.append("only-if-cached, ");
        }
        if (this.f41284n) {
            sb2.append("no-transform, ");
        }
        if (this.f41285o) {
            sb2.append("immutable, ");
        }
        if (sb2.length() == 0) {
            return "";
        }
        sb2.delete(sb2.length() - 2, sb2.length());
        return sb2.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.tencent.cloud.huiyansdkface.okhttp3.CacheControl parse(com.tencent.cloud.huiyansdkface.okhttp3.Headers r22) {
        /*
            Method dump skipped, instructions count: 333
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.cloud.huiyansdkface.okhttp3.CacheControl.parse(com.tencent.cloud.huiyansdkface.okhttp3.Headers):com.tencent.cloud.huiyansdkface.okhttp3.CacheControl");
    }

    public boolean immutable() {
        return this.f41285o;
    }

    public boolean isPrivate() {
        return this.f41278h;
    }

    public boolean isPublic() {
        return this.f41279i;
    }

    public int maxAgeSeconds() {
        return this.f41276f;
    }

    public int maxStaleSeconds() {
        return this.f41281k;
    }

    public int minFreshSeconds() {
        return this.f41282l;
    }

    public boolean mustRevalidate() {
        return this.f41280j;
    }

    public boolean noCache() {
        return this.f41274d;
    }

    public boolean noStore() {
        return this.f41275e;
    }

    public boolean noTransform() {
        return this.f41284n;
    }

    public boolean onlyIfCached() {
        return this.f41283m;
    }

    public int sMaxAgeSeconds() {
        return this.f41277g;
    }

    public String toString() {
        String str = this.f41273c;
        if (str != null) {
            return str;
        }
        String a10 = a();
        this.f41273c = a10;
        return a10;
    }
}
