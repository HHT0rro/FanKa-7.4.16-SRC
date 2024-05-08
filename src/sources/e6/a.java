package e6;

import android.graphics.Bitmap;
import android.text.Layout;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.TextUtils;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import com.google.common.base.l;

/* compiled from: Cue.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class a {

    /* renamed from: r, reason: collision with root package name */
    public static final a f48882r = new b().o("").a();

    /* renamed from: s, reason: collision with root package name */
    public static final com.google.android.exoplayer2.g<a> f48883s = a5.a.f700a;

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public final CharSequence f48884a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public final Layout.Alignment f48885b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public final Layout.Alignment f48886c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public final Bitmap f48887d;

    /* renamed from: e, reason: collision with root package name */
    public final float f48888e;

    /* renamed from: f, reason: collision with root package name */
    public final int f48889f;

    /* renamed from: g, reason: collision with root package name */
    public final int f48890g;

    /* renamed from: h, reason: collision with root package name */
    public final float f48891h;

    /* renamed from: i, reason: collision with root package name */
    public final int f48892i;

    /* renamed from: j, reason: collision with root package name */
    public final float f48893j;

    /* renamed from: k, reason: collision with root package name */
    public final float f48894k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f48895l;

    /* renamed from: m, reason: collision with root package name */
    public final int f48896m;

    /* renamed from: n, reason: collision with root package name */
    public final int f48897n;

    /* renamed from: o, reason: collision with root package name */
    public final float f48898o;

    /* renamed from: p, reason: collision with root package name */
    public final int f48899p;

    /* renamed from: q, reason: collision with root package name */
    public final float f48900q;

    /* compiled from: Cue.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        @Nullable
        public CharSequence f48901a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        public Bitmap f48902b;

        /* renamed from: c, reason: collision with root package name */
        @Nullable
        public Layout.Alignment f48903c;

        /* renamed from: d, reason: collision with root package name */
        @Nullable
        public Layout.Alignment f48904d;

        /* renamed from: e, reason: collision with root package name */
        public float f48905e;

        /* renamed from: f, reason: collision with root package name */
        public int f48906f;

        /* renamed from: g, reason: collision with root package name */
        public int f48907g;

        /* renamed from: h, reason: collision with root package name */
        public float f48908h;

        /* renamed from: i, reason: collision with root package name */
        public int f48909i;

        /* renamed from: j, reason: collision with root package name */
        public int f48910j;

        /* renamed from: k, reason: collision with root package name */
        public float f48911k;

        /* renamed from: l, reason: collision with root package name */
        public float f48912l;

        /* renamed from: m, reason: collision with root package name */
        public float f48913m;

        /* renamed from: n, reason: collision with root package name */
        public boolean f48914n;

        /* renamed from: o, reason: collision with root package name */
        @ColorInt
        public int f48915o;

        /* renamed from: p, reason: collision with root package name */
        public int f48916p;

        /* renamed from: q, reason: collision with root package name */
        public float f48917q;

        public a a() {
            return new a(this.f48901a, this.f48903c, this.f48904d, this.f48902b, this.f48905e, this.f48906f, this.f48907g, this.f48908h, this.f48909i, this.f48910j, this.f48911k, this.f48912l, this.f48913m, this.f48914n, this.f48915o, this.f48916p, this.f48917q);
        }

        public b b() {
            this.f48914n = false;
            return this;
        }

        public int c() {
            return this.f48907g;
        }

        public int d() {
            return this.f48909i;
        }

        @Nullable
        public CharSequence e() {
            return this.f48901a;
        }

        public b f(Bitmap bitmap) {
            this.f48902b = bitmap;
            return this;
        }

        public b g(float f10) {
            this.f48913m = f10;
            return this;
        }

        public b h(float f10, int i10) {
            this.f48905e = f10;
            this.f48906f = i10;
            return this;
        }

        public b i(int i10) {
            this.f48907g = i10;
            return this;
        }

        public b j(@Nullable Layout.Alignment alignment) {
            this.f48904d = alignment;
            return this;
        }

        public b k(float f10) {
            this.f48908h = f10;
            return this;
        }

        public b l(int i10) {
            this.f48909i = i10;
            return this;
        }

        public b m(float f10) {
            this.f48917q = f10;
            return this;
        }

        public b n(float f10) {
            this.f48912l = f10;
            return this;
        }

        public b o(CharSequence charSequence) {
            this.f48901a = charSequence;
            return this;
        }

        public b p(@Nullable Layout.Alignment alignment) {
            this.f48903c = alignment;
            return this;
        }

        public b q(float f10, int i10) {
            this.f48911k = f10;
            this.f48910j = i10;
            return this;
        }

        public b r(int i10) {
            this.f48916p = i10;
            return this;
        }

        public b s(@ColorInt int i10) {
            this.f48915o = i10;
            this.f48914n = true;
            return this;
        }

        public b() {
            this.f48901a = null;
            this.f48902b = null;
            this.f48903c = null;
            this.f48904d = null;
            this.f48905e = -3.4028235E38f;
            this.f48906f = Integer.MIN_VALUE;
            this.f48907g = Integer.MIN_VALUE;
            this.f48908h = -3.4028235E38f;
            this.f48909i = Integer.MIN_VALUE;
            this.f48910j = Integer.MIN_VALUE;
            this.f48911k = -3.4028235E38f;
            this.f48912l = -3.4028235E38f;
            this.f48913m = -3.4028235E38f;
            this.f48914n = false;
            this.f48915o = -16777216;
            this.f48916p = Integer.MIN_VALUE;
        }

        public b(a aVar) {
            this.f48901a = aVar.f48884a;
            this.f48902b = aVar.f48887d;
            this.f48903c = aVar.f48885b;
            this.f48904d = aVar.f48886c;
            this.f48905e = aVar.f48888e;
            this.f48906f = aVar.f48889f;
            this.f48907g = aVar.f48890g;
            this.f48908h = aVar.f48891h;
            this.f48909i = aVar.f48892i;
            this.f48910j = aVar.f48897n;
            this.f48911k = aVar.f48898o;
            this.f48912l = aVar.f48893j;
            this.f48913m = aVar.f48894k;
            this.f48914n = aVar.f48895l;
            this.f48915o = aVar.f48896m;
            this.f48916p = aVar.f48899p;
            this.f48917q = aVar.f48900q;
        }
    }

    public b a() {
        return new b();
    }

    public boolean equals(@Nullable Object obj) {
        Bitmap bitmap;
        Bitmap bitmap2;
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        return TextUtils.equals(this.f48884a, aVar.f48884a) && this.f48885b == aVar.f48885b && this.f48886c == aVar.f48886c && ((bitmap = this.f48887d) != null ? !((bitmap2 = aVar.f48887d) == null || !bitmap.sameAs(bitmap2)) : aVar.f48887d == null) && this.f48888e == aVar.f48888e && this.f48889f == aVar.f48889f && this.f48890g == aVar.f48890g && this.f48891h == aVar.f48891h && this.f48892i == aVar.f48892i && this.f48893j == aVar.f48893j && this.f48894k == aVar.f48894k && this.f48895l == aVar.f48895l && this.f48896m == aVar.f48896m && this.f48897n == aVar.f48897n && this.f48898o == aVar.f48898o && this.f48899p == aVar.f48899p && this.f48900q == aVar.f48900q;
    }

    public int hashCode() {
        return l.b(this.f48884a, this.f48885b, this.f48886c, this.f48887d, Float.valueOf(this.f48888e), Integer.valueOf(this.f48889f), Integer.valueOf(this.f48890g), Float.valueOf(this.f48891h), Integer.valueOf(this.f48892i), Float.valueOf(this.f48893j), Float.valueOf(this.f48894k), Boolean.valueOf(this.f48895l), Integer.valueOf(this.f48896m), Integer.valueOf(this.f48897n), Float.valueOf(this.f48898o), Integer.valueOf(this.f48899p), Float.valueOf(this.f48900q));
    }

    public a(@Nullable CharSequence charSequence, @Nullable Layout.Alignment alignment, @Nullable Layout.Alignment alignment2, @Nullable Bitmap bitmap, float f10, int i10, int i11, float f11, int i12, int i13, float f12, float f13, float f14, boolean z10, int i14, int i15, float f15) {
        if (charSequence == null) {
            com.google.android.exoplayer2.util.a.e(bitmap);
        } else {
            com.google.android.exoplayer2.util.a.a(bitmap == null);
        }
        if (charSequence instanceof Spanned) {
            this.f48884a = SpannedString.valueOf(charSequence);
        } else if (charSequence != null) {
            this.f48884a = charSequence.toString();
        } else {
            this.f48884a = null;
        }
        this.f48885b = alignment;
        this.f48886c = alignment2;
        this.f48887d = bitmap;
        this.f48888e = f10;
        this.f48889f = i10;
        this.f48890g = i11;
        this.f48891h = f11;
        this.f48892i = i12;
        this.f48893j = f13;
        this.f48894k = f14;
        this.f48895l = z10;
        this.f48896m = i14;
        this.f48897n = i13;
        this.f48898o = f12;
        this.f48899p = i15;
        this.f48900q = f15;
    }
}
