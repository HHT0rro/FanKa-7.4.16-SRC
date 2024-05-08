package gc;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.t0;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public String f49427a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f49428b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f49429c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f49430d;

    /* renamed from: e, reason: collision with root package name */
    public long f49431e;

    /* renamed from: f, reason: collision with root package name */
    public long f49432f;

    /* renamed from: g, reason: collision with root package name */
    public long f49433g;

    /* renamed from: gc.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class C0741a {

        /* renamed from: a, reason: collision with root package name */
        public int f49434a = -1;

        /* renamed from: b, reason: collision with root package name */
        public int f49435b = -1;

        /* renamed from: c, reason: collision with root package name */
        public int f49436c = -1;

        /* renamed from: d, reason: collision with root package name */
        public String f49437d = null;

        /* renamed from: e, reason: collision with root package name */
        public long f49438e = -1;

        /* renamed from: f, reason: collision with root package name */
        public long f49439f = -1;

        /* renamed from: g, reason: collision with root package name */
        public long f49440g = -1;

        public a h(Context context) {
            return new a(context, this);
        }

        public C0741a i(String str) {
            this.f49437d = str;
            return this;
        }

        public C0741a j(boolean z10) {
            this.f49434a = z10 ? 1 : 0;
            return this;
        }

        public C0741a k(long j10) {
            this.f49439f = j10;
            return this;
        }

        public C0741a l(boolean z10) {
            this.f49435b = z10 ? 1 : 0;
            return this;
        }

        public C0741a m(long j10) {
            this.f49438e = j10;
            return this;
        }

        public C0741a n(long j10) {
            this.f49440g = j10;
            return this;
        }

        public C0741a o(boolean z10) {
            this.f49436c = z10 ? 1 : 0;
            return this;
        }
    }

    public a(Context context, C0741a c0741a) {
        this.f49428b = true;
        this.f49429c = false;
        this.f49430d = false;
        this.f49431e = 1048576L;
        this.f49432f = 86400L;
        this.f49433g = 86400L;
        if (c0741a.f49434a == 0) {
            this.f49428b = false;
        } else {
            int unused = c0741a.f49434a;
            this.f49428b = true;
        }
        this.f49427a = !TextUtils.isEmpty(c0741a.f49437d) ? c0741a.f49437d : t0.b(context);
        this.f49431e = c0741a.f49438e > -1 ? c0741a.f49438e : 1048576L;
        if (c0741a.f49439f > -1) {
            this.f49432f = c0741a.f49439f;
        } else {
            this.f49432f = 86400L;
        }
        if (c0741a.f49440g > -1) {
            this.f49433g = c0741a.f49440g;
        } else {
            this.f49433g = 86400L;
        }
        if (c0741a.f49435b != 0 && c0741a.f49435b == 1) {
            this.f49429c = true;
        } else {
            this.f49429c = false;
        }
        if (c0741a.f49436c != 0 && c0741a.f49436c == 1) {
            this.f49430d = true;
        } else {
            this.f49430d = false;
        }
    }

    public static a a(Context context) {
        return b().j(true).i(t0.b(context)).m(1048576L).l(false).k(86400L).o(false).n(86400L).h(context);
    }

    public static C0741a b() {
        return new C0741a();
    }

    public long c() {
        return this.f49432f;
    }

    public long d() {
        return this.f49431e;
    }

    public long e() {
        return this.f49433g;
    }

    public boolean f() {
        return this.f49428b;
    }

    public boolean g() {
        return this.f49429c;
    }

    public boolean h() {
        return this.f49430d;
    }

    public String toString() {
        return "Config{mEventEncrypted=" + this.f49428b + ", mAESKey='" + this.f49427a + "', mMaxFileLength=" + this.f49431e + ", mEventUploadSwitchOpen=" + this.f49429c + ", mPerfUploadSwitchOpen=" + this.f49430d + ", mEventUploadFrequency=" + this.f49432f + ", mPerfUploadFrequency=" + this.f49433g + '}';
    }
}
