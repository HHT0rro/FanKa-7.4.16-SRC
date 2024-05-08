package j0;

import android.content.Context;
import android.graphics.Typeface;
import android.view.ViewGroup;
import androidx.annotation.ColorInt;
import com.contrarywind.view.WheelView;
import l0.d;
import l0.e;

/* compiled from: OptionsPickerBuilder.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public k0.a f50224a;

    public a(Context context, e eVar) {
        k0.a aVar = new k0.a(1);
        this.f50224a = aVar;
        aVar.R = context;
        aVar.f50584a = eVar;
    }

    public <T> n0.b<T> a() {
        return new n0.b<>(this.f50224a);
    }

    public a b(int i10) {
        this.f50224a.f50589c0 = i10;
        return this;
    }

    public a c(ViewGroup viewGroup) {
        this.f50224a.P = viewGroup;
        return this;
    }

    public a d(@ColorInt int i10) {
        this.f50224a.f50595f0 = i10;
        return this;
    }

    public a e(WheelView.DividerType dividerType) {
        this.f50224a.f50609m0 = dividerType;
        return this;
    }

    public a f(int i10) {
        this.f50224a.f50611n0 = i10;
        return this;
    }

    public a g(int i10, l0.a aVar) {
        k0.a aVar2 = this.f50224a;
        aVar2.O = i10;
        aVar2.f50594f = aVar;
        return this;
    }

    public a h(float f10) {
        this.f50224a.f50599h0 = f10;
        return this;
    }

    public a i(d dVar) {
        this.f50224a.f50592e = dVar;
        return this;
    }

    public a j(boolean z10) {
        this.f50224a.f50603j0 = z10;
        return this;
    }

    public a k(int i10) {
        this.f50224a.f50602j = i10;
        return this;
    }

    public a l(int i10, int i11) {
        k0.a aVar = this.f50224a;
        aVar.f50602j = i10;
        aVar.f50604k = i11;
        return this;
    }

    public a m(int i10, int i11, int i12) {
        k0.a aVar = this.f50224a;
        aVar.f50602j = i10;
        aVar.f50604k = i11;
        aVar.f50606l = i12;
        return this;
    }

    public a n(int i10) {
        this.f50224a.f50593e0 = i10;
        return this;
    }

    public a o(@ColorInt int i10) {
        this.f50224a.f50591d0 = i10;
        return this;
    }

    public a p(Typeface typeface) {
        this.f50224a.f50607l0 = typeface;
        return this;
    }
}
