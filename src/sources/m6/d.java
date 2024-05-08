package m6;

import android.text.TextUtils;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: WebvttCssStyle.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class d {

    /* renamed from: f, reason: collision with root package name */
    @ColorInt
    public int f51888f;

    /* renamed from: h, reason: collision with root package name */
    public int f51890h;

    /* renamed from: o, reason: collision with root package name */
    public float f51897o;

    /* renamed from: a, reason: collision with root package name */
    public String f51883a = "";

    /* renamed from: b, reason: collision with root package name */
    public String f51884b = "";

    /* renamed from: c, reason: collision with root package name */
    public Set<String> f51885c = Collections.emptySet();

    /* renamed from: d, reason: collision with root package name */
    public String f51886d = "";

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public String f51887e = null;

    /* renamed from: g, reason: collision with root package name */
    public boolean f51889g = false;

    /* renamed from: i, reason: collision with root package name */
    public boolean f51891i = false;

    /* renamed from: j, reason: collision with root package name */
    public int f51892j = -1;

    /* renamed from: k, reason: collision with root package name */
    public int f51893k = -1;

    /* renamed from: l, reason: collision with root package name */
    public int f51894l = -1;

    /* renamed from: m, reason: collision with root package name */
    public int f51895m = -1;

    /* renamed from: n, reason: collision with root package name */
    public int f51896n = -1;

    /* renamed from: p, reason: collision with root package name */
    public int f51898p = -1;

    /* renamed from: q, reason: collision with root package name */
    public boolean f51899q = false;

    public static int B(int i10, String str, @Nullable String str2, int i11) {
        if (str.isEmpty() || i10 == -1) {
            return i10;
        }
        if (str.equals(str2)) {
            return i10 + i11;
        }
        return -1;
    }

    public d A(boolean z10) {
        this.f51893k = z10 ? 1 : 0;
        return this;
    }

    public int a() {
        if (this.f51891i) {
            return this.f51890h;
        }
        throw new IllegalStateException("Background color not defined.");
    }

    public boolean b() {
        return this.f51899q;
    }

    public int c() {
        if (this.f51889g) {
            return this.f51888f;
        }
        throw new IllegalStateException("Font color not defined");
    }

    @Nullable
    public String d() {
        return this.f51887e;
    }

    public float e() {
        return this.f51897o;
    }

    public int f() {
        return this.f51896n;
    }

    public int g() {
        return this.f51898p;
    }

    public int h(@Nullable String str, @Nullable String str2, Set<String> set, @Nullable String str3) {
        if (this.f51883a.isEmpty() && this.f51884b.isEmpty() && this.f51885c.isEmpty() && this.f51886d.isEmpty()) {
            return TextUtils.isEmpty(str2) ? 1 : 0;
        }
        int B = B(B(B(0, this.f51883a, str, 1073741824), this.f51884b, str2, 2), this.f51886d, str3, 4);
        if (B == -1 || !set.containsAll(this.f51885c)) {
            return 0;
        }
        return B + (this.f51885c.size() * 4);
    }

    public int i() {
        int i10 = this.f51894l;
        if (i10 == -1 && this.f51895m == -1) {
            return -1;
        }
        return (i10 == 1 ? 1 : 0) | (this.f51895m == 1 ? 2 : 0);
    }

    public boolean j() {
        return this.f51891i;
    }

    public boolean k() {
        return this.f51889g;
    }

    public boolean l() {
        return this.f51892j == 1;
    }

    public boolean m() {
        return this.f51893k == 1;
    }

    public d n(int i10) {
        this.f51890h = i10;
        this.f51891i = true;
        return this;
    }

    public d o(boolean z10) {
        this.f51894l = z10 ? 1 : 0;
        return this;
    }

    public d p(boolean z10) {
        this.f51899q = z10;
        return this;
    }

    public d q(int i10) {
        this.f51888f = i10;
        this.f51889g = true;
        return this;
    }

    public d r(@Nullable String str) {
        this.f51887e = str == null ? null : com.google.common.base.a.e(str);
        return this;
    }

    public d s(float f10) {
        this.f51897o = f10;
        return this;
    }

    public d t(int i10) {
        this.f51896n = i10;
        return this;
    }

    public d u(boolean z10) {
        this.f51895m = z10 ? 1 : 0;
        return this;
    }

    public d v(int i10) {
        this.f51898p = i10;
        return this;
    }

    public void w(String[] strArr) {
        this.f51885c = new HashSet(Arrays.asList(strArr));
    }

    public void x(String str) {
        this.f51883a = str;
    }

    public void y(String str) {
        this.f51884b = str;
    }

    public void z(String str) {
        this.f51886d = str;
    }
}
