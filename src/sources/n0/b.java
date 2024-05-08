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
import com.bigkoo.pickerview.R$string;
import com.huawei.appgallery.agd.pageframe.api.CardEventType;
import java.util.List;

/* compiled from: OptionsPickerView.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class b<T> extends a implements View.OnClickListener {

    /* renamed from: r, reason: collision with root package name */
    public d<T> f52045r;

    public b(k0.a aVar) {
        super(aVar.R);
        this.f52027f = aVar;
        y(aVar.R);
    }

    public void A() {
        if (this.f52027f.f50584a != null) {
            int[] e2 = this.f52045r.e();
            this.f52027f.f50584a.a(e2[0], e2[1], e2[2], this.f52035n);
        }
    }

    public void B(List<T> list, List<T> list2, List<T> list3) {
        this.f52045r.p(false);
        this.f52045r.q(list, list2, list3);
        z();
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
            A();
        } else if (str.equals(CardEventType.CLICK_ACTION_CANCEL) && (onClickListener = this.f52027f.f50588c) != null) {
            onClickListener.onClick(view);
        }
        f();
    }

    public final void y(Context context) {
        r();
        n();
        l();
        m();
        l0.a aVar = this.f52027f.f50594f;
        if (aVar == null) {
            LayoutInflater.from(context).inflate(this.f52027f.O, this.f52024c);
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
        LinearLayout linearLayout = (LinearLayout) i(R$id.optionspicker);
        linearLayout.setBackgroundColor(this.f52027f.Y);
        d<T> dVar = new d<>(linearLayout, this.f52027f.f50617s);
        this.f52045r = dVar;
        l0.d dVar2 = this.f52027f.f50592e;
        if (dVar2 != null) {
            dVar.r(dVar2);
        }
        this.f52045r.u(this.f52027f.f50589c0);
        this.f52045r.m(this.f52027f.f50611n0);
        this.f52045r.h(this.f52027f.f50613o0);
        d<T> dVar3 = this.f52045r;
        k0.a aVar2 = this.f52027f;
        dVar3.n(aVar2.f50596g, aVar2.f50598h, aVar2.f50600i);
        d<T> dVar4 = this.f52045r;
        k0.a aVar3 = this.f52027f;
        dVar4.v(aVar3.f50608m, aVar3.f50610n, aVar3.f50612o);
        d<T> dVar5 = this.f52045r;
        k0.a aVar4 = this.f52027f;
        dVar5.j(aVar4.f50614p, aVar4.f50615q, aVar4.f50616r);
        this.f52045r.w(this.f52027f.f50607l0);
        t(this.f52027f.f50603j0);
        this.f52045r.k(this.f52027f.f50595f0);
        this.f52045r.l(this.f52027f.f50609m0);
        this.f52045r.o(this.f52027f.f50599h0);
        this.f52045r.t(this.f52027f.f50591d0);
        this.f52045r.s(this.f52027f.f50593e0);
        this.f52045r.f(this.f52027f.f50605k0);
    }

    public final void z() {
        d<T> dVar = this.f52045r;
        if (dVar != null) {
            k0.a aVar = this.f52027f;
            dVar.i(aVar.f50602j, aVar.f50604k, aVar.f50606l);
        }
    }
}
