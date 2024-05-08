package n0;

import android.graphics.Typeface;
import android.view.View;
import com.bigkoo.pickerview.R$id;
import com.contrarywind.view.WheelView;
import java.util.List;

/* compiled from: WheelOptions.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class d<T> {

    /* renamed from: a, reason: collision with root package name */
    public View f52048a;

    /* renamed from: b, reason: collision with root package name */
    public WheelView f52049b;

    /* renamed from: c, reason: collision with root package name */
    public WheelView f52050c;

    /* renamed from: d, reason: collision with root package name */
    public WheelView f52051d;

    /* renamed from: e, reason: collision with root package name */
    public List<T> f52052e;

    /* renamed from: f, reason: collision with root package name */
    public List<List<T>> f52053f;

    /* renamed from: g, reason: collision with root package name */
    public List<List<List<T>>> f52054g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f52055h = true;

    /* renamed from: i, reason: collision with root package name */
    public boolean f52056i;

    /* renamed from: j, reason: collision with root package name */
    public l0.d f52057j;

    /* compiled from: WheelOptions.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public class a implements s0.b {
        public a() {
        }

        @Override // s0.b
        public void a(int i10) {
            d.this.f52057j.a(i10, d.this.f52050c.getCurrentItem(), d.this.f52051d.getCurrentItem());
        }
    }

    /* compiled from: WheelOptions.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public class b implements s0.b {
        public b() {
        }

        @Override // s0.b
        public void a(int i10) {
            d.this.f52057j.a(d.this.f52049b.getCurrentItem(), i10, d.this.f52051d.getCurrentItem());
        }
    }

    /* compiled from: WheelOptions.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public class c implements s0.b {
        public c() {
        }

        @Override // s0.b
        public void a(int i10) {
            d.this.f52057j.a(d.this.f52049b.getCurrentItem(), d.this.f52050c.getCurrentItem(), i10);
        }
    }

    public d(View view, boolean z10) {
        this.f52056i = z10;
        this.f52048a = view;
        this.f52049b = (WheelView) view.findViewById(R$id.options1);
        this.f52050c = (WheelView) view.findViewById(R$id.options2);
        this.f52051d = (WheelView) view.findViewById(R$id.options3);
    }

    public int[] e() {
        int[] iArr = new int[3];
        iArr[0] = this.f52049b.getCurrentItem();
        List<List<T>> list = this.f52053f;
        if (list != null && list.size() > 0) {
            iArr[1] = this.f52050c.getCurrentItem() > this.f52053f.get(iArr[0]).size() - 1 ? 0 : this.f52050c.getCurrentItem();
        } else {
            iArr[1] = this.f52050c.getCurrentItem();
        }
        List<List<List<T>>> list2 = this.f52054g;
        if (list2 != null && list2.size() > 0) {
            iArr[2] = this.f52051d.getCurrentItem() <= this.f52054g.get(iArr[0]).get(iArr[1]).size() - 1 ? this.f52051d.getCurrentItem() : 0;
        } else {
            iArr[2] = this.f52051d.getCurrentItem();
        }
        return iArr;
    }

    public void f(boolean z10) {
        this.f52049b.i(z10);
        this.f52050c.i(z10);
        this.f52051d.i(z10);
    }

    public final void g(int i10, int i11, int i12) {
        if (this.f52052e != null) {
            this.f52049b.setCurrentItem(i10);
        }
        List<List<T>> list = this.f52053f;
        if (list != null) {
            this.f52050c.setAdapter(new i0.a(list.get(i10)));
            this.f52050c.setCurrentItem(i11);
        }
        List<List<List<T>>> list2 = this.f52054g;
        if (list2 != null) {
            this.f52051d.setAdapter(new i0.a(list2.get(i10).get(i11)));
            this.f52051d.setCurrentItem(i12);
        }
    }

    public void h(boolean z10) {
        this.f52049b.setAlphaGradient(z10);
        this.f52050c.setAlphaGradient(z10);
        this.f52051d.setAlphaGradient(z10);
    }

    public void i(int i10, int i11, int i12) {
        if (this.f52055h) {
            g(i10, i11, i12);
            return;
        }
        this.f52049b.setCurrentItem(i10);
        this.f52050c.setCurrentItem(i11);
        this.f52051d.setCurrentItem(i12);
    }

    public void j(boolean z10, boolean z11, boolean z12) {
        this.f52049b.setCyclic(z10);
        this.f52050c.setCyclic(z11);
        this.f52051d.setCyclic(z12);
    }

    public void k(int i10) {
        this.f52049b.setDividerColor(i10);
        this.f52050c.setDividerColor(i10);
        this.f52051d.setDividerColor(i10);
    }

    public void l(WheelView.DividerType dividerType) {
        this.f52049b.setDividerType(dividerType);
        this.f52050c.setDividerType(dividerType);
        this.f52051d.setDividerType(dividerType);
    }

    public void m(int i10) {
        this.f52049b.setItemsVisibleCount(i10);
        this.f52050c.setItemsVisibleCount(i10);
        this.f52051d.setItemsVisibleCount(i10);
    }

    public void n(String str, String str2, String str3) {
        if (str != null) {
            this.f52049b.setLabel(str);
        }
        if (str2 != null) {
            this.f52050c.setLabel(str2);
        }
        if (str3 != null) {
            this.f52051d.setLabel(str3);
        }
    }

    public void o(float f10) {
        this.f52049b.setLineSpacingMultiplier(f10);
        this.f52050c.setLineSpacingMultiplier(f10);
        this.f52051d.setLineSpacingMultiplier(f10);
    }

    public void p(boolean z10) {
        this.f52055h = z10;
    }

    public void q(List<T> list, List<T> list2, List<T> list3) {
        this.f52049b.setAdapter(new i0.a(list));
        this.f52049b.setCurrentItem(0);
        if (list2 != null) {
            this.f52050c.setAdapter(new i0.a(list2));
        }
        WheelView wheelView = this.f52050c;
        wheelView.setCurrentItem(wheelView.getCurrentItem());
        if (list3 != null) {
            this.f52051d.setAdapter(new i0.a(list3));
        }
        WheelView wheelView2 = this.f52051d;
        wheelView2.setCurrentItem(wheelView2.getCurrentItem());
        this.f52049b.setIsOptions(true);
        this.f52050c.setIsOptions(true);
        this.f52051d.setIsOptions(true);
        if (this.f52057j != null) {
            this.f52049b.setOnItemSelectedListener(new a());
        }
        if (list2 == null) {
            this.f52050c.setVisibility(8);
        } else {
            this.f52050c.setVisibility(0);
            if (this.f52057j != null) {
                this.f52050c.setOnItemSelectedListener(new b());
            }
        }
        if (list3 == null) {
            this.f52051d.setVisibility(8);
            return;
        }
        this.f52051d.setVisibility(0);
        if (this.f52057j != null) {
            this.f52051d.setOnItemSelectedListener(new c());
        }
    }

    public void r(l0.d dVar) {
        this.f52057j = dVar;
    }

    public void s(int i10) {
        this.f52049b.setTextColorCenter(i10);
        this.f52050c.setTextColorCenter(i10);
        this.f52051d.setTextColorCenter(i10);
    }

    public void t(int i10) {
        this.f52049b.setTextColorOut(i10);
        this.f52050c.setTextColorOut(i10);
        this.f52051d.setTextColorOut(i10);
    }

    public void u(int i10) {
        float f10 = i10;
        this.f52049b.setTextSize(f10);
        this.f52050c.setTextSize(f10);
        this.f52051d.setTextSize(f10);
    }

    public void v(int i10, int i11, int i12) {
        this.f52049b.setTextXOffset(i10);
        this.f52050c.setTextXOffset(i11);
        this.f52051d.setTextXOffset(i12);
    }

    public void w(Typeface typeface) {
        this.f52049b.setTypeface(typeface);
        this.f52050c.setTypeface(typeface);
        this.f52051d.setTypeface(typeface);
    }
}
