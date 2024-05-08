package j0;

import android.content.Context;
import android.graphics.Typeface;
import android.view.ViewGroup;
import androidx.annotation.ColorInt;
import com.contrarywind.view.WheelView;
import java.util.Calendar;
import l0.f;
import l0.g;
import n0.c;

/* compiled from: TimePickerBuilder.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public k0.a f50225a;

    public b(Context context, g gVar) {
        k0.a aVar = new k0.a(2);
        this.f50225a = aVar;
        aVar.R = context;
        aVar.f50586b = gVar;
    }

    public c a() {
        return new c(this.f50225a);
    }

    public b b(int i10) {
        this.f50225a.f50589c0 = i10;
        return this;
    }

    public b c(Calendar calendar) {
        this.f50225a.f50619u = calendar;
        return this;
    }

    public b d(ViewGroup viewGroup) {
        this.f50225a.P = viewGroup;
        return this;
    }

    public b e(@ColorInt int i10) {
        this.f50225a.f50595f0 = i10;
        return this;
    }

    public b f(WheelView.DividerType dividerType) {
        this.f50225a.f50609m0 = dividerType;
        return this;
    }

    public b g(int i10) {
        this.f50225a.f50611n0 = i10;
        return this;
    }

    public b h(String str, String str2, String str3, String str4, String str5, String str6) {
        k0.a aVar = this.f50225a;
        aVar.C = str;
        aVar.D = str2;
        aVar.E = str3;
        aVar.F = str4;
        aVar.G = str5;
        aVar.H = str6;
        return this;
    }

    public b i(int i10, l0.a aVar) {
        k0.a aVar2 = this.f50225a;
        aVar2.O = i10;
        aVar2.f50594f = aVar;
        return this;
    }

    public b j(float f10) {
        this.f50225a.f50599h0 = f10;
        return this;
    }

    public b k(boolean z10) {
        this.f50225a.f50603j0 = z10;
        return this;
    }

    public b l(Calendar calendar, Calendar calendar2) {
        k0.a aVar = this.f50225a;
        aVar.f50620v = calendar;
        aVar.f50621w = calendar2;
        return this;
    }

    public b m(boolean z10) {
        this.f50225a.A = z10;
        return this;
    }

    public b n(@ColorInt int i10) {
        this.f50225a.f50593e0 = i10;
        return this;
    }

    public b o(@ColorInt int i10) {
        this.f50225a.f50591d0 = i10;
        return this;
    }

    public b p(int i10, int i11, int i12, int i13, int i14, int i15) {
        k0.a aVar = this.f50225a;
        aVar.I = i10;
        aVar.J = i11;
        aVar.K = i12;
        aVar.L = i13;
        aVar.M = i14;
        aVar.N = i15;
        return this;
    }

    public b q(f fVar) {
        this.f50225a.f50590d = fVar;
        return this;
    }

    public b r(boolean[] zArr) {
        this.f50225a.f50618t = zArr;
        return this;
    }

    public b s(Typeface typeface) {
        this.f50225a.f50607l0 = typeface;
        return this;
    }
}
