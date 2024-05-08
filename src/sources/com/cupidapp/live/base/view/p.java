package com.cupidapp.live.base.view;

import androidx.annotation.ColorInt;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKViewPagerTitleLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public final List<String> f12857a;

    /* renamed from: b, reason: collision with root package name */
    public final float f12858b;

    /* renamed from: c, reason: collision with root package name */
    public int f12859c;

    /* renamed from: d, reason: collision with root package name */
    public int f12860d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f12861e;

    public p(@NotNull List<String> titles, float f10, @ColorInt int i10, @ColorInt int i11, boolean z10) {
        kotlin.jvm.internal.s.i(titles, "titles");
        this.f12857a = titles;
        this.f12858b = f10;
        this.f12859c = i10;
        this.f12860d = i11;
        this.f12861e = z10;
    }

    public final int a() {
        return this.f12859c;
    }

    public final boolean b() {
        return this.f12861e;
    }

    public final float c() {
        return this.f12858b;
    }

    @NotNull
    public final List<String> d() {
        return this.f12857a;
    }

    public final int e() {
        return this.f12860d;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return kotlin.jvm.internal.s.d(this.f12857a, pVar.f12857a) && Float.compare(this.f12858b, pVar.f12858b) == 0 && this.f12859c == pVar.f12859c && this.f12860d == pVar.f12860d && this.f12861e == pVar.f12861e;
    }

    public final void f(int i10) {
        this.f12859c = i10;
    }

    public final void g(boolean z10) {
        this.f12861e = z10;
    }

    public final void h(int i10) {
        this.f12860d = i10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((this.f12857a.hashCode() * 31) + Float.floatToIntBits(this.f12858b)) * 31) + this.f12859c) * 31) + this.f12860d) * 31;
        boolean z10 = this.f12861e;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return hashCode + i10;
    }

    @NotNull
    public String toString() {
        List<String> list = this.f12857a;
        return "TitleStyle(titles=" + ((Object) list) + ", textSize=" + this.f12858b + ", checkedColor=" + this.f12859c + ", unCheckedColor=" + this.f12860d + ", dynamicLineVisible=" + this.f12861e + ")";
    }

    public /* synthetic */ p(List list, float f10, int i10, int i11, boolean z10, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, (i12 & 2) != 0 ? 16.0f : f10, (i12 & 4) != 0 ? -15066598 : i10, (i12 & 8) != 0 ? com.cupidapp.live.base.utils.h.a(-15066598, 0.3f) : i11, (i12 & 16) != 0 ? true : z10);
    }
}
