package n0;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bigkoo.pickerview.R$id;
import com.bigkoo.pickerview.R$layout;
import com.bigkoo.pickerview.R$string;
import com.huawei.appgallery.agd.pageframe.api.CardEventType;
import java.text.ParseException;
import java.util.Calendar;

/* compiled from: TimePickerView.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class c extends n0.a implements View.OnClickListener {

    /* renamed from: r, reason: collision with root package name */
    public e f52046r;

    /* compiled from: TimePickerView.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public class a implements l0.b {
        public a() {
        }

        @Override // l0.b
        public void a() {
            try {
                if (c.this.f52046r.t() != null) {
                    c.this.f52027f.f50590d.a(e.f52061u.parse(c.this.f52046r.t()));
                } else {
                    c.this.f52027f.f50590d.a(null);
                }
            } catch (ParseException e2) {
                e2.printStackTrace();
            }
        }
    }

    public c(k0.a aVar) {
        super(aVar.R);
        this.f52027f = aVar;
        A(aVar.R);
    }

    public final void A(Context context) {
        r();
        n();
        l();
        l0.a aVar = this.f52027f.f50594f;
        if (aVar == null) {
            LayoutInflater.from(context).inflate(R$layout.pickerview_time, this.f52024c);
            TextView textView = (TextView) i(R$id.tvTitle);
            RelativeLayout relativeLayout = (RelativeLayout) i(R$id.rv_topbar);
            Button button = (Button) i(R$id.btnSubmit);
            Button button2 = (Button) i(R$id.btnCancel);
            button.setTag("submit");
            button2.setTag(CardEventType.CLICK_ACTION_CANCEL);
            button.setOnClickListener(this);
            button2.setOnClickListener(this);
            button.setText(TextUtils.isEmpty(this.f52027f.S) ? context.getResources().getString(R$string.pickerview_submit) : this.f52027f.S);
            button2.setText(TextUtils.isEmpty(this.f52027f.T) ? context.getResources().getString(R$string.pickerview_cancel) : this.f52027f.T);
            textView.setText(TextUtils.isEmpty(this.f52027f.U) ? "" : this.f52027f.U);
            button.setTextColor(this.f52027f.V);
            button2.setTextColor(this.f52027f.W);
            textView.setTextColor(this.f52027f.X);
            relativeLayout.setBackgroundColor(this.f52027f.Z);
            button.setTextSize(this.f52027f.f50585a0);
            button2.setTextSize(this.f52027f.f50585a0);
            textView.setTextSize(this.f52027f.f50587b0);
        } else {
            aVar.a(LayoutInflater.from(context).inflate(this.f52027f.O, this.f52024c));
        }
        LinearLayout linearLayout = (LinearLayout) i(R$id.timepicker);
        linearLayout.setBackgroundColor(this.f52027f.Y);
        B(linearLayout);
    }

    public final void B(LinearLayout linearLayout) {
        int i10;
        k0.a aVar = this.f52027f;
        e eVar = new e(linearLayout, aVar.f50618t, aVar.Q, aVar.f50589c0, aVar.A);
        this.f52046r = eVar;
        if (this.f52027f.f50590d != null) {
            eVar.L(new a());
        }
        this.f52046r.H(this.f52027f.B);
        k0.a aVar2 = this.f52027f;
        int i11 = aVar2.f50622x;
        if (i11 != 0 && (i10 = aVar2.f50623y) != 0 && i11 <= i10) {
            E();
        }
        k0.a aVar3 = this.f52027f;
        Calendar calendar = aVar3.f50620v;
        if (calendar == null || aVar3.f50621w == null) {
            if (calendar != null) {
                if (calendar.get(1) >= 1900) {
                    D();
                } else {
                    throw new IllegalArgumentException("The startDate can not as early as 1900");
                }
            } else {
                Calendar calendar2 = aVar3.f50621w;
                if (calendar2 != null) {
                    if (calendar2.get(1) <= 2100) {
                        D();
                    } else {
                        throw new IllegalArgumentException("The endDate should not be later than 2100");
                    }
                } else {
                    D();
                }
            }
        } else if (calendar.getTimeInMillis() <= this.f52027f.f50621w.getTimeInMillis()) {
            D();
        } else {
            throw new IllegalArgumentException("startDate can't be later than endDate");
        }
        F();
        e eVar2 = this.f52046r;
        k0.a aVar4 = this.f52027f;
        eVar2.E(aVar4.C, aVar4.D, aVar4.E, aVar4.F, aVar4.G, aVar4.H);
        e eVar3 = this.f52046r;
        k0.a aVar5 = this.f52027f;
        eVar3.Q(aVar5.I, aVar5.J, aVar5.K, aVar5.L, aVar5.M, aVar5.N);
        this.f52046r.D(this.f52027f.f50611n0);
        this.f52046r.w(this.f52027f.f50613o0);
        t(this.f52027f.f50603j0);
        this.f52046r.z(this.f52027f.f50624z);
        this.f52046r.A(this.f52027f.f50595f0);
        this.f52046r.B(this.f52027f.f50609m0);
        this.f52046r.F(this.f52027f.f50599h0);
        this.f52046r.P(this.f52027f.f50591d0);
        this.f52046r.O(this.f52027f.f50593e0);
        this.f52046r.u(this.f52027f.f50605k0);
        this.f52046r.R(this.f52027f.f50607l0);
    }

    public void C() {
        if (this.f52027f.f50586b != null) {
            try {
                if (this.f52046r.t() != null) {
                    this.f52027f.f50586b.a(e.f52061u.parse(this.f52046r.t()), this.f52035n);
                } else {
                    this.f52027f.f50586b.a(null, this.f52035n);
                }
            } catch (ParseException e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void D() {
        e eVar = this.f52046r;
        k0.a aVar = this.f52027f;
        eVar.J(aVar.f50620v, aVar.f50621w);
        z();
    }

    public final void E() {
        this.f52046r.N(this.f52027f.f50622x);
        this.f52046r.C(this.f52027f.f50623y);
    }

    public final void F() {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = this.f52027f.f50619u;
        if (calendar2 == null) {
            calendar.setTimeInMillis(System.currentTimeMillis());
            i10 = calendar.get(1);
            i11 = calendar.get(2);
            i12 = calendar.get(5);
            i13 = calendar.get(11);
            i14 = calendar.get(12);
            i15 = calendar.get(13);
        } else {
            i10 = calendar2.get(1);
            i11 = this.f52027f.f50619u.get(2);
            i12 = this.f52027f.f50619u.get(5);
            i13 = this.f52027f.f50619u.get(11);
            i14 = this.f52027f.f50619u.get(12);
            i15 = this.f52027f.f50619u.get(13);
        }
        int i16 = i13;
        int i17 = i12;
        int i18 = i11;
        e eVar = this.f52046r;
        eVar.I(i10, i18, i17, i16, i14, i15);
    }

    @Override // n0.a
    public boolean o() {
        return this.f52027f.f50601i0;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View.OnClickListener onClickListener;
        String str = (String) view.getTag();
        if (str.equals("submit")) {
            C();
        } else if (str.equals(CardEventType.CLICK_ACTION_CANCEL) && (onClickListener = this.f52027f.f50588c) != null) {
            onClickListener.onClick(view);
        }
        f();
    }

    public final void z() {
        k0.a aVar = this.f52027f;
        Calendar calendar = aVar.f50620v;
        if (calendar == null || aVar.f50621w == null) {
            if (calendar != null) {
                aVar.f50619u = calendar;
                return;
            }
            Calendar calendar2 = aVar.f50621w;
            if (calendar2 != null) {
                aVar.f50619u = calendar2;
                return;
            }
            return;
        }
        Calendar calendar3 = aVar.f50619u;
        if (calendar3 == null || calendar3.getTimeInMillis() < this.f52027f.f50620v.getTimeInMillis() || this.f52027f.f50619u.getTimeInMillis() > this.f52027f.f50621w.getTimeInMillis()) {
            k0.a aVar2 = this.f52027f;
            aVar2.f50619u = aVar2.f50620v;
        }
    }
}
