package n0;

import android.graphics.Typeface;
import android.view.View;
import com.alimm.tanx.core.web.cache.utils.TimeUtils;
import com.bigkoo.pickerview.R$id;
import com.bigkoo.pickerview.R$string;
import com.contrarywind.view.WheelView;
import com.huawei.openalliance.ad.constant.u;
import com.tencent.connect.common.Constants;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

/* compiled from: WheelTime.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class e {

    /* renamed from: u, reason: collision with root package name */
    public static DateFormat f52061u = new SimpleDateFormat(TimeUtils.STARD_FROMAT);

    /* renamed from: a, reason: collision with root package name */
    public View f52062a;

    /* renamed from: b, reason: collision with root package name */
    public WheelView f52063b;

    /* renamed from: c, reason: collision with root package name */
    public WheelView f52064c;

    /* renamed from: d, reason: collision with root package name */
    public WheelView f52065d;

    /* renamed from: e, reason: collision with root package name */
    public WheelView f52066e;

    /* renamed from: f, reason: collision with root package name */
    public WheelView f52067f;

    /* renamed from: g, reason: collision with root package name */
    public WheelView f52068g;

    /* renamed from: h, reason: collision with root package name */
    public int f52069h;

    /* renamed from: i, reason: collision with root package name */
    public boolean[] f52070i;

    /* renamed from: p, reason: collision with root package name */
    public int f52077p;

    /* renamed from: q, reason: collision with root package name */
    public int f52078q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f52079r;

    /* renamed from: t, reason: collision with root package name */
    public l0.b f52081t;

    /* renamed from: j, reason: collision with root package name */
    public int f52071j = 1900;

    /* renamed from: k, reason: collision with root package name */
    public int f52072k = 2100;

    /* renamed from: l, reason: collision with root package name */
    public int f52073l = 1;

    /* renamed from: m, reason: collision with root package name */
    public int f52074m = 12;

    /* renamed from: n, reason: collision with root package name */
    public int f52075n = 1;

    /* renamed from: o, reason: collision with root package name */
    public int f52076o = 31;

    /* renamed from: s, reason: collision with root package name */
    public boolean f52080s = false;

    /* compiled from: WheelTime.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public class a implements s0.b {
        public a() {
        }

        @Override // s0.b
        public void a(int i10) {
            int h10;
            int i11 = i10 + e.this.f52071j;
            e.this.f52064c.setAdapter(new i0.a(m0.a.d(i11)));
            if (m0.a.g(i11) != 0 && e.this.f52064c.getCurrentItem() > m0.a.g(i11) - 1) {
                e.this.f52064c.setCurrentItem(e.this.f52064c.getCurrentItem() + 1);
            } else {
                e.this.f52064c.setCurrentItem(e.this.f52064c.getCurrentItem());
            }
            int currentItem = e.this.f52065d.getCurrentItem();
            if (m0.a.g(i11) != 0 && e.this.f52064c.getCurrentItem() > m0.a.g(i11) - 1) {
                if (e.this.f52064c.getCurrentItem() == m0.a.g(i11) + 1) {
                    e.this.f52065d.setAdapter(new i0.a(m0.a.b(m0.a.f(i11))));
                    h10 = m0.a.f(i11);
                } else {
                    e.this.f52065d.setAdapter(new i0.a(m0.a.b(m0.a.h(i11, e.this.f52064c.getCurrentItem()))));
                    h10 = m0.a.h(i11, e.this.f52064c.getCurrentItem());
                }
            } else {
                e.this.f52065d.setAdapter(new i0.a(m0.a.b(m0.a.h(i11, e.this.f52064c.getCurrentItem() + 1))));
                h10 = m0.a.h(i11, e.this.f52064c.getCurrentItem() + 1);
            }
            int i12 = h10 - 1;
            if (currentItem > i12) {
                e.this.f52065d.setCurrentItem(i12);
            }
            if (e.this.f52081t != null) {
                e.this.f52081t.a();
            }
        }
    }

    /* compiled from: WheelTime.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public class b implements s0.b {
        public b() {
        }

        @Override // s0.b
        public void a(int i10) {
            int h10;
            int currentItem = e.this.f52063b.getCurrentItem() + e.this.f52071j;
            int currentItem2 = e.this.f52065d.getCurrentItem();
            if (m0.a.g(currentItem) != 0 && i10 > m0.a.g(currentItem) - 1) {
                if (e.this.f52064c.getCurrentItem() == m0.a.g(currentItem) + 1) {
                    e.this.f52065d.setAdapter(new i0.a(m0.a.b(m0.a.f(currentItem))));
                    h10 = m0.a.f(currentItem);
                } else {
                    e.this.f52065d.setAdapter(new i0.a(m0.a.b(m0.a.h(currentItem, i10))));
                    h10 = m0.a.h(currentItem, i10);
                }
            } else {
                int i11 = i10 + 1;
                e.this.f52065d.setAdapter(new i0.a(m0.a.b(m0.a.h(currentItem, i11))));
                h10 = m0.a.h(currentItem, i11);
            }
            int i12 = h10 - 1;
            if (currentItem2 > i12) {
                e.this.f52065d.setCurrentItem(i12);
            }
            if (e.this.f52081t != null) {
                e.this.f52081t.a();
            }
        }
    }

    /* compiled from: WheelTime.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public class c implements s0.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f52084a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List f52085b;

        public c(List list, List list2) {
            this.f52084a = list;
            this.f52085b = list2;
        }

        @Override // s0.b
        public void a(int i10) {
            if (e.this.v()) {
                e.this.f52064c.setVisibility(e.this.f52070i[1] ? 4 : 8);
                e.this.f52065d.setVisibility(e.this.f52070i[2] ? 4 : 8);
                e.this.f52066e.setVisibility(e.this.f52070i[3] ? 4 : 8);
                e.this.f52067f.setVisibility(e.this.f52070i[4] ? 4 : 8);
                e.this.f52068g.setVisibility(e.this.f52070i[5] ? 4 : 8);
                if (e.this.f52081t != null) {
                    e.this.f52081t.a();
                    return;
                }
                return;
            }
            e.this.f52064c.setVisibility(e.this.f52070i[1] ? 0 : 8);
            e.this.f52065d.setVisibility(e.this.f52070i[2] ? 0 : 8);
            e.this.f52066e.setVisibility(e.this.f52070i[3] ? 0 : 8);
            e.this.f52067f.setVisibility(e.this.f52070i[4] ? 0 : 8);
            e.this.f52068g.setVisibility(e.this.f52070i[5] ? 0 : 8);
            int i11 = i10 + e.this.f52071j;
            e.this.f52077p = i11;
            int currentItem = e.this.f52064c.getCurrentItem();
            if (e.this.f52071j == e.this.f52072k) {
                e.this.f52064c.setAdapter(new i0.b(e.this.f52073l, e.this.f52074m));
                if (currentItem > e.this.f52064c.getAdapter().a() - 1) {
                    currentItem = e.this.f52064c.getAdapter().a() - 1;
                    e.this.f52064c.setCurrentItem(currentItem);
                }
                int i12 = currentItem + e.this.f52073l;
                if (e.this.f52073l == e.this.f52074m) {
                    e eVar = e.this;
                    eVar.K(i11, i12, eVar.f52075n, e.this.f52076o, this.f52084a, this.f52085b);
                } else if (i12 == e.this.f52073l) {
                    e eVar2 = e.this;
                    eVar2.K(i11, i12, eVar2.f52075n, 31, this.f52084a, this.f52085b);
                } else if (i12 == e.this.f52074m) {
                    e eVar3 = e.this;
                    eVar3.K(i11, i12, 1, eVar3.f52076o, this.f52084a, this.f52085b);
                } else {
                    e.this.K(i11, i12, 1, 31, this.f52084a, this.f52085b);
                }
            } else if (i11 == e.this.f52071j) {
                e.this.f52064c.setAdapter(new i0.b(e.this.f52073l, 12));
                if (currentItem > e.this.f52064c.getAdapter().a() - 1) {
                    currentItem = e.this.f52064c.getAdapter().a() - 1;
                    e.this.f52064c.setCurrentItem(currentItem);
                }
                int i13 = currentItem + e.this.f52073l;
                if (i13 == e.this.f52073l) {
                    e eVar4 = e.this;
                    eVar4.K(i11, i13, eVar4.f52075n, 31, this.f52084a, this.f52085b);
                } else {
                    e.this.K(i11, i13, 1, 31, this.f52084a, this.f52085b);
                }
            } else if (i11 == e.this.f52072k) {
                e.this.f52064c.setAdapter(new i0.b(1, e.this.f52074m));
                if (currentItem > e.this.f52064c.getAdapter().a() - 1) {
                    currentItem = e.this.f52064c.getAdapter().a() - 1;
                    e.this.f52064c.setCurrentItem(currentItem);
                }
                int i14 = currentItem + 1;
                if (i14 == e.this.f52074m) {
                    e eVar5 = e.this;
                    eVar5.K(i11, i14, 1, eVar5.f52076o, this.f52084a, this.f52085b);
                } else {
                    e.this.K(i11, i14, 1, 31, this.f52084a, this.f52085b);
                }
            } else {
                e.this.f52064c.setAdapter(new i0.b(1, 12));
                e eVar6 = e.this;
                eVar6.K(i11, eVar6.f52064c.getCurrentItem() + 1, 1, 31, this.f52084a, this.f52085b);
            }
            if (e.this.f52081t != null) {
                e.this.f52081t.a();
            }
        }
    }

    /* compiled from: WheelTime.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public class d implements s0.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f52087a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List f52088b;

        public d(List list, List list2) {
            this.f52087a = list;
            this.f52088b = list2;
        }

        @Override // s0.b
        public void a(int i10) {
            int i11 = i10 + 1;
            if (e.this.f52071j == e.this.f52072k) {
                int i12 = (i11 + e.this.f52073l) - 1;
                if (e.this.f52073l == e.this.f52074m) {
                    e eVar = e.this;
                    eVar.K(eVar.f52077p, i12, e.this.f52075n, e.this.f52076o, this.f52087a, this.f52088b);
                } else if (e.this.f52073l == i12) {
                    e eVar2 = e.this;
                    eVar2.K(eVar2.f52077p, i12, e.this.f52075n, 31, this.f52087a, this.f52088b);
                } else if (e.this.f52074m == i12) {
                    e eVar3 = e.this;
                    eVar3.K(eVar3.f52077p, i12, 1, e.this.f52076o, this.f52087a, this.f52088b);
                } else {
                    e eVar4 = e.this;
                    eVar4.K(eVar4.f52077p, i12, 1, 31, this.f52087a, this.f52088b);
                }
            } else if (e.this.f52077p == e.this.f52071j) {
                int i13 = (i11 + e.this.f52073l) - 1;
                if (i13 == e.this.f52073l) {
                    e eVar5 = e.this;
                    eVar5.K(eVar5.f52077p, i13, e.this.f52075n, 31, this.f52087a, this.f52088b);
                } else {
                    e eVar6 = e.this;
                    eVar6.K(eVar6.f52077p, i13, 1, 31, this.f52087a, this.f52088b);
                }
            } else if (e.this.f52077p == e.this.f52072k) {
                if (i11 == e.this.f52074m) {
                    e eVar7 = e.this;
                    eVar7.K(eVar7.f52077p, e.this.f52064c.getCurrentItem() + 1, 1, e.this.f52076o, this.f52087a, this.f52088b);
                } else {
                    e eVar8 = e.this;
                    eVar8.K(eVar8.f52077p, e.this.f52064c.getCurrentItem() + 1, 1, 31, this.f52087a, this.f52088b);
                }
            } else {
                e eVar9 = e.this;
                eVar9.K(eVar9.f52077p, i11, 1, 31, this.f52087a, this.f52088b);
            }
            if (e.this.f52081t != null) {
                e.this.f52081t.a();
            }
        }
    }

    /* compiled from: WheelTime.java */
    /* renamed from: n0.e$e, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public class C0793e implements s0.b {
        public C0793e() {
        }

        @Override // s0.b
        public void a(int i10) {
            e.this.f52081t.a();
        }
    }

    public e(View view, boolean[] zArr, int i10, int i11, boolean z10) {
        this.f52062a = view;
        this.f52070i = zArr;
        this.f52069h = i10;
        this.f52078q = i11;
        this.f52079r = z10;
    }

    public void A(int i10) {
        this.f52065d.setDividerColor(i10);
        this.f52064c.setDividerColor(i10);
        this.f52063b.setDividerColor(i10);
        this.f52066e.setDividerColor(i10);
        this.f52067f.setDividerColor(i10);
        this.f52068g.setDividerColor(i10);
    }

    public void B(WheelView.DividerType dividerType) {
        this.f52065d.setDividerType(dividerType);
        this.f52064c.setDividerType(dividerType);
        this.f52063b.setDividerType(dividerType);
        this.f52066e.setDividerType(dividerType);
        this.f52067f.setDividerType(dividerType);
        this.f52068g.setDividerType(dividerType);
    }

    public void C(int i10) {
        this.f52072k = i10;
    }

    public void D(int i10) {
        this.f52065d.setItemsVisibleCount(i10);
        this.f52064c.setItemsVisibleCount(i10);
        this.f52063b.setItemsVisibleCount(i10);
        this.f52066e.setItemsVisibleCount(i10);
        this.f52067f.setItemsVisibleCount(i10);
        this.f52068g.setItemsVisibleCount(i10);
    }

    public void E(String str, String str2, String str3, String str4, String str5, String str6) {
        if (this.f52080s) {
            return;
        }
        if (str != null) {
            this.f52063b.setLabel(str);
        } else {
            this.f52063b.setLabel(this.f52062a.getContext().getString(R$string.pickerview_year));
        }
        if (str2 != null) {
            this.f52064c.setLabel(str2);
        } else {
            this.f52064c.setLabel(this.f52062a.getContext().getString(R$string.pickerview_month));
        }
        if (str3 != null) {
            this.f52065d.setLabel(str3);
        } else {
            this.f52065d.setLabel(this.f52062a.getContext().getString(R$string.pickerview_day));
        }
        if (str4 != null) {
            this.f52066e.setLabel(str4);
        } else {
            this.f52066e.setLabel(this.f52062a.getContext().getString(R$string.pickerview_hours));
        }
        if (str5 != null) {
            this.f52067f.setLabel(str5);
        } else {
            this.f52067f.setLabel(this.f52062a.getContext().getString(R$string.pickerview_minutes));
        }
        if (str6 != null) {
            this.f52068g.setLabel(str6);
        } else {
            this.f52068g.setLabel(this.f52062a.getContext().getString(R$string.pickerview_seconds));
        }
    }

    public void F(float f10) {
        this.f52065d.setLineSpacingMultiplier(f10);
        this.f52064c.setLineSpacingMultiplier(f10);
        this.f52063b.setLineSpacingMultiplier(f10);
        this.f52066e.setLineSpacingMultiplier(f10);
        this.f52067f.setLineSpacingMultiplier(f10);
        this.f52068g.setLineSpacingMultiplier(f10);
    }

    public final void G(int i10, int i11, int i12, boolean z10, int i13, int i14, int i15) {
        WheelView wheelView = (WheelView) this.f52062a.findViewById(R$id.year);
        this.f52063b = wheelView;
        wheelView.setAdapter(new i0.a(m0.a.e(this.f52071j, this.f52072k)));
        this.f52063b.setLabel("");
        this.f52063b.setCurrentItem(i10 - this.f52071j);
        this.f52063b.setGravity(this.f52069h);
        WheelView wheelView2 = (WheelView) this.f52062a.findViewById(R$id.month);
        this.f52064c = wheelView2;
        wheelView2.setAdapter(new i0.a(m0.a.d(i10)));
        this.f52064c.setLabel("");
        int g3 = m0.a.g(i10);
        if (g3 != 0 && (i11 > g3 - 1 || z10)) {
            this.f52064c.setCurrentItem(i11 + 1);
        } else {
            this.f52064c.setCurrentItem(i11);
        }
        this.f52064c.setGravity(this.f52069h);
        this.f52065d = (WheelView) this.f52062a.findViewById(R$id.day);
        if (m0.a.g(i10) == 0) {
            this.f52065d.setAdapter(new i0.a(m0.a.b(m0.a.h(i10, i11))));
        } else {
            this.f52065d.setAdapter(new i0.a(m0.a.b(m0.a.f(i10))));
        }
        this.f52065d.setLabel("");
        this.f52065d.setCurrentItem(i12 - 1);
        this.f52065d.setGravity(this.f52069h);
        WheelView wheelView3 = (WheelView) this.f52062a.findViewById(R$id.hour);
        this.f52066e = wheelView3;
        wheelView3.setAdapter(new i0.b(0, 23));
        this.f52066e.setCurrentItem(i13);
        this.f52066e.setGravity(this.f52069h);
        WheelView wheelView4 = (WheelView) this.f52062a.findViewById(R$id.min);
        this.f52067f = wheelView4;
        wheelView4.setAdapter(new i0.b(0, 59));
        this.f52067f.setCurrentItem(i14);
        this.f52067f.setGravity(this.f52069h);
        WheelView wheelView5 = (WheelView) this.f52062a.findViewById(R$id.second);
        this.f52068g = wheelView5;
        wheelView5.setAdapter(new i0.b(0, 59));
        this.f52068g.setCurrentItem(i14);
        this.f52068g.setGravity(this.f52069h);
        this.f52063b.setOnItemSelectedListener(new a());
        this.f52064c.setOnItemSelectedListener(new b());
        x(this.f52065d);
        x(this.f52066e);
        x(this.f52067f);
        x(this.f52068g);
        boolean[] zArr = this.f52070i;
        if (zArr.length == 6) {
            this.f52063b.setVisibility(zArr[0] ? 0 : 8);
            this.f52064c.setVisibility(this.f52070i[1] ? 0 : 8);
            this.f52065d.setVisibility(this.f52070i[2] ? 0 : 8);
            this.f52066e.setVisibility(this.f52070i[3] ? 0 : 8);
            this.f52067f.setVisibility(this.f52070i[4] ? 0 : 8);
            this.f52068g.setVisibility(this.f52070i[5] ? 0 : 8);
            y();
            return;
        }
        throw new RuntimeException("type[] length is not 6");
    }

    public void H(boolean z10) {
        this.f52080s = z10;
    }

    public void I(int i10, int i11, int i12, int i13, int i14, int i15) {
        if (this.f52080s) {
            int[] d10 = m0.b.d(i10, i11 + 1, i12);
            G(d10[0], d10[1] - 1, d10[2], d10[3] == 1, i13, i14, i15);
        } else {
            M(i10, i11, i12, i13, i14, i15);
        }
    }

    public void J(Calendar calendar, Calendar calendar2) {
        if (calendar == null && calendar2 != null) {
            int i10 = calendar2.get(1);
            int i11 = calendar2.get(2) + 1;
            int i12 = calendar2.get(5);
            int i13 = this.f52071j;
            if (i10 > i13) {
                this.f52072k = i10;
                this.f52074m = i11;
                this.f52076o = i12;
                return;
            } else {
                if (i10 == i13) {
                    int i14 = this.f52073l;
                    if (i11 > i14) {
                        this.f52072k = i10;
                        this.f52074m = i11;
                        this.f52076o = i12;
                        return;
                    } else {
                        if (i11 != i14 || i12 <= this.f52075n) {
                            return;
                        }
                        this.f52072k = i10;
                        this.f52074m = i11;
                        this.f52076o = i12;
                        return;
                    }
                }
                return;
            }
        }
        if (calendar == null || calendar2 != null) {
            if (calendar == null || calendar2 == null) {
                return;
            }
            this.f52071j = calendar.get(1);
            this.f52072k = calendar2.get(1);
            this.f52073l = calendar.get(2) + 1;
            this.f52074m = calendar2.get(2) + 1;
            this.f52075n = calendar.get(5);
            this.f52076o = calendar2.get(5);
            return;
        }
        int i15 = calendar.get(1);
        int i16 = calendar.get(2) + 1;
        int i17 = calendar.get(5);
        int i18 = this.f52072k;
        if (i15 < i18) {
            this.f52073l = i16;
            this.f52075n = i17;
            this.f52071j = i15;
        } else if (i15 == i18) {
            int i19 = this.f52074m;
            if (i16 < i19) {
                this.f52073l = i16;
                this.f52075n = i17;
                this.f52071j = i15;
            } else {
                if (i16 != i19 || i17 >= this.f52076o) {
                    return;
                }
                this.f52073l = i16;
                this.f52075n = i17;
                this.f52071j = i15;
            }
        }
    }

    public final void K(int i10, int i11, int i12, int i13, List<String> list, List<String> list2) {
        int currentItem = this.f52065d.getCurrentItem();
        if (list.contains(String.valueOf(i11))) {
            if (i13 > 31) {
                i13 = 31;
            }
            this.f52065d.setAdapter(new i0.b(i12, i13));
        } else if (list2.contains(String.valueOf(i11))) {
            if (i13 > 30) {
                i13 = 30;
            }
            this.f52065d.setAdapter(new i0.b(i12, i13));
        } else if ((i10 % 4 == 0 && i10 % 100 != 0) || i10 % 400 == 0) {
            if (i13 > 29) {
                i13 = 29;
            }
            this.f52065d.setAdapter(new i0.b(i12, i13));
        } else {
            if (i13 > 28) {
                i13 = 28;
            }
            this.f52065d.setAdapter(new i0.b(i12, i13));
        }
        if (currentItem > this.f52065d.getAdapter().a() - 1) {
            this.f52065d.setCurrentItem(this.f52065d.getAdapter().a() - 1);
        }
    }

    public void L(l0.b bVar) {
        this.f52081t = bVar;
    }

    public final void M(int i10, int i11, int i12, int i13, int i14, int i15) {
        int i16;
        int i17;
        List asList = Arrays.asList("1", "3", "5", "7", "8", "10", Constants.VIA_REPORT_TYPE_SET_AVATAR);
        List asList2 = Arrays.asList("4", "6", "9", "11");
        this.f52077p = i10;
        this.f52063b = (WheelView) this.f52062a.findViewById(R$id.year);
        i0.b bVar = new i0.b(this.f52071j, this.f52072k);
        bVar.b(this.f52079r);
        this.f52063b.setAdapter(bVar);
        this.f52063b.setCurrentItem(i10 - this.f52071j);
        this.f52063b.setGravity(this.f52069h);
        WheelView wheelView = (WheelView) this.f52062a.findViewById(R$id.month);
        this.f52064c = wheelView;
        int i18 = this.f52071j;
        int i19 = this.f52072k;
        if (i18 == i19) {
            wheelView.setAdapter(new i0.b(this.f52073l, this.f52074m));
            this.f52064c.setCurrentItem((i11 + 1) - this.f52073l);
        } else if (i10 == i18) {
            wheelView.setAdapter(new i0.b(this.f52073l, 12));
            this.f52064c.setCurrentItem((i11 + 1) - this.f52073l);
        } else if (i10 == i19) {
            wheelView.setAdapter(new i0.b(1, this.f52074m));
            this.f52064c.setCurrentItem(i11);
        } else {
            wheelView.setAdapter(new i0.b(1, 12));
            this.f52064c.setCurrentItem(i11);
        }
        this.f52064c.setGravity(this.f52069h);
        this.f52065d = (WheelView) this.f52062a.findViewById(R$id.day);
        boolean z10 = (i10 % 4 == 0 && i10 % 100 != 0) || i10 % 400 == 0;
        int i20 = this.f52071j;
        int i21 = this.f52072k;
        if (i20 == i21 && this.f52073l == this.f52074m) {
            int i22 = i11 + 1;
            if (asList.contains(String.valueOf(i22))) {
                if (this.f52076o > 31) {
                    this.f52076o = 31;
                }
                this.f52065d.setAdapter(new i0.b(this.f52075n, this.f52076o));
            } else if (asList2.contains(String.valueOf(i22))) {
                if (this.f52076o > 30) {
                    this.f52076o = 30;
                }
                this.f52065d.setAdapter(new i0.b(this.f52075n, this.f52076o));
            } else if (z10) {
                if (this.f52076o > 29) {
                    this.f52076o = 29;
                }
                this.f52065d.setAdapter(new i0.b(this.f52075n, this.f52076o));
            } else {
                if (this.f52076o > 28) {
                    this.f52076o = 28;
                }
                this.f52065d.setAdapter(new i0.b(this.f52075n, this.f52076o));
            }
            this.f52065d.setCurrentItem(i12 - this.f52075n);
        } else if (i10 == i20 && (i17 = i11 + 1) == this.f52073l) {
            if (asList.contains(String.valueOf(i17))) {
                this.f52065d.setAdapter(new i0.b(this.f52075n, 31));
            } else if (asList2.contains(String.valueOf(i17))) {
                this.f52065d.setAdapter(new i0.b(this.f52075n, 30));
            } else {
                this.f52065d.setAdapter(new i0.b(this.f52075n, z10 ? 29 : 28));
            }
            this.f52065d.setCurrentItem(i12 - this.f52075n);
        } else if (i10 == i21 && (i16 = i11 + 1) == this.f52074m) {
            if (asList.contains(String.valueOf(i16))) {
                if (this.f52076o > 31) {
                    this.f52076o = 31;
                }
                this.f52065d.setAdapter(new i0.b(1, this.f52076o));
            } else if (asList2.contains(String.valueOf(i16))) {
                if (this.f52076o > 30) {
                    this.f52076o = 30;
                }
                this.f52065d.setAdapter(new i0.b(1, this.f52076o));
            } else {
                if (z10) {
                    if (this.f52076o > 29) {
                        this.f52076o = 29;
                    }
                } else if (this.f52076o > 28) {
                    this.f52076o = 28;
                }
                this.f52065d.setAdapter(new i0.b(1, this.f52076o));
            }
            this.f52065d.setCurrentItem(i12 - 1);
        } else {
            int i23 = i11 + 1;
            if (asList.contains(String.valueOf(i23))) {
                this.f52065d.setAdapter(new i0.b(1, 31));
            } else if (asList2.contains(String.valueOf(i23))) {
                this.f52065d.setAdapter(new i0.b(1, 30));
            } else {
                this.f52065d.setAdapter(new i0.b(this.f52075n, z10 ? 29 : 28));
            }
            this.f52065d.setCurrentItem(i12 - 1);
        }
        this.f52065d.setGravity(this.f52069h);
        WheelView wheelView2 = (WheelView) this.f52062a.findViewById(R$id.hour);
        this.f52066e = wheelView2;
        wheelView2.setAdapter(new i0.b(0, 23));
        this.f52066e.setCurrentItem(i13);
        this.f52066e.setGravity(this.f52069h);
        WheelView wheelView3 = (WheelView) this.f52062a.findViewById(R$id.min);
        this.f52067f = wheelView3;
        wheelView3.setAdapter(new i0.b(0, 59));
        this.f52067f.setCurrentItem(i14);
        this.f52067f.setGravity(this.f52069h);
        WheelView wheelView4 = (WheelView) this.f52062a.findViewById(R$id.second);
        this.f52068g = wheelView4;
        wheelView4.setAdapter(new i0.b(0, 59));
        this.f52068g.setCurrentItem(i15);
        this.f52068g.setGravity(this.f52069h);
        this.f52063b.setOnItemSelectedListener(new c(asList, asList2));
        this.f52064c.setOnItemSelectedListener(new d(asList, asList2));
        x(this.f52065d);
        x(this.f52066e);
        x(this.f52067f);
        x(this.f52068g);
        boolean[] zArr = this.f52070i;
        if (zArr.length == 6) {
            this.f52063b.setVisibility(zArr[0] ? 0 : 8);
            this.f52064c.setVisibility(this.f52070i[1] ? 0 : 8);
            this.f52065d.setVisibility(this.f52070i[2] ? 0 : 8);
            this.f52066e.setVisibility(this.f52070i[3] ? 0 : 8);
            this.f52067f.setVisibility(this.f52070i[4] ? 0 : 8);
            this.f52068g.setVisibility(this.f52070i[5] ? 0 : 8);
            y();
            return;
        }
        throw new IllegalArgumentException("type[] length is not 6");
    }

    public void N(int i10) {
        this.f52071j = i10;
    }

    public void O(int i10) {
        this.f52065d.setTextColorCenter(i10);
        this.f52064c.setTextColorCenter(i10);
        this.f52063b.setTextColorCenter(i10);
        this.f52066e.setTextColorCenter(i10);
        this.f52067f.setTextColorCenter(i10);
        this.f52068g.setTextColorCenter(i10);
    }

    public void P(int i10) {
        this.f52065d.setTextColorOut(i10);
        this.f52064c.setTextColorOut(i10);
        this.f52063b.setTextColorOut(i10);
        this.f52066e.setTextColorOut(i10);
        this.f52067f.setTextColorOut(i10);
        this.f52068g.setTextColorOut(i10);
    }

    public void Q(int i10, int i11, int i12, int i13, int i14, int i15) {
        this.f52063b.setTextXOffset(i10);
        this.f52064c.setTextXOffset(i11);
        this.f52065d.setTextXOffset(i12);
        this.f52066e.setTextXOffset(i13);
        this.f52067f.setTextXOffset(i14);
        this.f52068g.setTextXOffset(i15);
    }

    public void R(Typeface typeface) {
        this.f52063b.setTypeface(typeface);
        this.f52064c.setTypeface(typeface);
        this.f52065d.setTypeface(typeface);
        this.f52066e.setTypeface(typeface);
        this.f52067f.setTypeface(typeface);
        this.f52068g.setTypeface(typeface);
    }

    public final String s() {
        int currentItem;
        boolean z10;
        int currentItem2;
        StringBuilder sb2 = new StringBuilder();
        int currentItem3 = this.f52063b.getCurrentItem() + this.f52071j;
        if (m0.a.g(currentItem3) == 0) {
            currentItem2 = this.f52064c.getCurrentItem();
        } else if ((this.f52064c.getCurrentItem() + 1) - m0.a.g(currentItem3) <= 0) {
            currentItem2 = this.f52064c.getCurrentItem();
        } else {
            if ((this.f52064c.getCurrentItem() + 1) - m0.a.g(currentItem3) == 1) {
                currentItem = this.f52064c.getCurrentItem();
                z10 = true;
                int[] b4 = m0.b.b(currentItem3, currentItem, this.f52065d.getCurrentItem() + 1, z10);
                sb2.append(b4[0]);
                sb2.append("-");
                sb2.append(b4[1]);
                sb2.append("-");
                sb2.append(b4[2]);
                sb2.append(" ");
                sb2.append(this.f52066e.getCurrentItem());
                sb2.append(u.bD);
                sb2.append(this.f52067f.getCurrentItem());
                sb2.append(u.bD);
                sb2.append(this.f52068g.getCurrentItem());
                return sb2.toString();
            }
            currentItem = this.f52064c.getCurrentItem();
            z10 = false;
            int[] b42 = m0.b.b(currentItem3, currentItem, this.f52065d.getCurrentItem() + 1, z10);
            sb2.append(b42[0]);
            sb2.append("-");
            sb2.append(b42[1]);
            sb2.append("-");
            sb2.append(b42[2]);
            sb2.append(" ");
            sb2.append(this.f52066e.getCurrentItem());
            sb2.append(u.bD);
            sb2.append(this.f52067f.getCurrentItem());
            sb2.append(u.bD);
            sb2.append(this.f52068g.getCurrentItem());
            return sb2.toString();
        }
        currentItem = currentItem2 + 1;
        z10 = false;
        int[] b422 = m0.b.b(currentItem3, currentItem, this.f52065d.getCurrentItem() + 1, z10);
        sb2.append(b422[0]);
        sb2.append("-");
        sb2.append(b422[1]);
        sb2.append("-");
        sb2.append(b422[2]);
        sb2.append(" ");
        sb2.append(this.f52066e.getCurrentItem());
        sb2.append(u.bD);
        sb2.append(this.f52067f.getCurrentItem());
        sb2.append(u.bD);
        sb2.append(this.f52068g.getCurrentItem());
        return sb2.toString();
    }

    public String t() {
        if (this.f52080s) {
            return s();
        }
        if (v()) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        if (this.f52077p == this.f52071j) {
            int currentItem = this.f52064c.getCurrentItem();
            int i10 = this.f52073l;
            if (currentItem + i10 == i10) {
                sb2.append(this.f52063b.getCurrentItem() + this.f52071j);
                sb2.append("-");
                sb2.append(this.f52064c.getCurrentItem() + this.f52073l);
                sb2.append("-");
                sb2.append(this.f52065d.getCurrentItem() + this.f52075n);
                sb2.append(" ");
                sb2.append(this.f52066e.getCurrentItem());
                sb2.append(u.bD);
                sb2.append(this.f52067f.getCurrentItem());
                sb2.append(u.bD);
                sb2.append(this.f52068g.getCurrentItem());
            } else {
                sb2.append(this.f52063b.getCurrentItem() + this.f52071j);
                sb2.append("-");
                sb2.append(this.f52064c.getCurrentItem() + this.f52073l);
                sb2.append("-");
                sb2.append(this.f52065d.getCurrentItem() + 1);
                sb2.append(" ");
                sb2.append(this.f52066e.getCurrentItem());
                sb2.append(u.bD);
                sb2.append(this.f52067f.getCurrentItem());
                sb2.append(u.bD);
                sb2.append(this.f52068g.getCurrentItem());
            }
        } else {
            sb2.append(this.f52063b.getCurrentItem() + this.f52071j);
            sb2.append("-");
            sb2.append(this.f52064c.getCurrentItem() + 1);
            sb2.append("-");
            sb2.append(this.f52065d.getCurrentItem() + 1);
            sb2.append(" ");
            sb2.append(this.f52066e.getCurrentItem());
            sb2.append(u.bD);
            sb2.append(this.f52067f.getCurrentItem());
            sb2.append(u.bD);
            sb2.append(this.f52068g.getCurrentItem());
        }
        return sb2.toString();
    }

    public void u(boolean z10) {
        this.f52065d.i(z10);
        this.f52064c.i(z10);
        this.f52063b.i(z10);
        this.f52066e.i(z10);
        this.f52067f.i(z10);
        this.f52068g.i(z10);
    }

    public final boolean v() {
        return this.f52079r && this.f52063b.getCurrentItem() == this.f52063b.getItemsCount() - 1;
    }

    public void w(boolean z10) {
        this.f52065d.setAlphaGradient(z10);
        this.f52064c.setAlphaGradient(z10);
        this.f52063b.setAlphaGradient(z10);
        this.f52066e.setAlphaGradient(z10);
        this.f52067f.setAlphaGradient(z10);
        this.f52068g.setAlphaGradient(z10);
    }

    public final void x(WheelView wheelView) {
        if (this.f52081t != null) {
            wheelView.setOnItemSelectedListener(new C0793e());
        }
    }

    public final void y() {
        this.f52065d.setTextSize(this.f52078q);
        this.f52064c.setTextSize(this.f52078q);
        this.f52063b.setTextSize(this.f52078q);
        this.f52066e.setTextSize(this.f52078q);
        this.f52067f.setTextSize(this.f52078q);
        this.f52068g.setTextSize(this.f52078q);
    }

    public void z(boolean z10) {
        this.f52063b.setCyclic(z10);
        this.f52064c.setCyclic(z10);
        this.f52065d.setCyclic(z10);
        this.f52066e.setCyclic(z10);
        this.f52067f.setCyclic(z10);
        this.f52068g.setCyclic(z10);
    }
}
