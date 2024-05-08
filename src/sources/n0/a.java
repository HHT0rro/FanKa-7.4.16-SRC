package n0;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.bigkoo.pickerview.R$id;
import com.bigkoo.pickerview.R$layout;
import com.bigkoo.pickerview.R$style;

/* compiled from: BasePickerView.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    public Context f52023b;

    /* renamed from: c, reason: collision with root package name */
    public ViewGroup f52024c;

    /* renamed from: d, reason: collision with root package name */
    public ViewGroup f52025d;

    /* renamed from: e, reason: collision with root package name */
    public ViewGroup f52026e;

    /* renamed from: f, reason: collision with root package name */
    public k0.a f52027f;

    /* renamed from: g, reason: collision with root package name */
    public l0.c f52028g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f52029h;

    /* renamed from: i, reason: collision with root package name */
    public Animation f52030i;

    /* renamed from: j, reason: collision with root package name */
    public Animation f52031j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f52032k;

    /* renamed from: m, reason: collision with root package name */
    public Dialog f52034m;

    /* renamed from: n, reason: collision with root package name */
    public View f52035n;

    /* renamed from: l, reason: collision with root package name */
    public int f52033l = 80;

    /* renamed from: o, reason: collision with root package name */
    public boolean f52036o = true;

    /* renamed from: p, reason: collision with root package name */
    public View.OnKeyListener f52037p = new d();

    /* renamed from: q, reason: collision with root package name */
    public final View.OnTouchListener f52038q = new e();

    /* compiled from: BasePickerView.java */
    /* renamed from: n0.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public class ViewOnClickListenerC0792a implements View.OnClickListener {
        public ViewOnClickListenerC0792a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.f();
        }
    }

    /* compiled from: BasePickerView.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public class b implements Animation.AnimationListener {
        public b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            a.this.h();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* compiled from: BasePickerView.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            aVar.f52027f.P.removeView(aVar.f52025d);
            a.this.f52032k = false;
            a.this.f52029h = false;
            if (a.this.f52028g != null) {
                a.this.f52028g.a(a.this);
            }
        }
    }

    /* compiled from: BasePickerView.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public class d implements View.OnKeyListener {
        public d() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i10, KeyEvent keyEvent) {
            if (i10 != 4 || keyEvent.getAction() != 0 || !a.this.p()) {
                return false;
            }
            a.this.f();
            return true;
        }
    }

    /* compiled from: BasePickerView.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public class e implements View.OnTouchListener {
        public e() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0) {
                return false;
            }
            a.this.f();
            return false;
        }
    }

    /* compiled from: BasePickerView.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public class f implements DialogInterface.OnDismissListener {
        public f() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (a.this.f52028g != null) {
                a.this.f52028g.a(a.this);
            }
        }
    }

    public a(Context context) {
        this.f52023b = context;
    }

    private void g() {
        Dialog dialog = this.f52034m;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    public void e() {
        if (this.f52026e != null) {
            Dialog dialog = new Dialog(this.f52023b, R$style.custom_dialog2);
            this.f52034m = dialog;
            dialog.setCancelable(this.f52027f.f50603j0);
            this.f52034m.setContentView(this.f52026e);
            Window window = this.f52034m.getWindow();
            if (window != null) {
                window.setWindowAnimations(R$style.picker_view_scale_anim);
                window.setGravity(17);
            }
            this.f52034m.setOnDismissListener(new f());
        }
    }

    public void f() {
        if (o()) {
            g();
            return;
        }
        if (this.f52029h) {
            return;
        }
        if (this.f52036o) {
            this.f52030i.setAnimationListener(new b());
            this.f52024c.startAnimation(this.f52030i);
        } else {
            h();
        }
        this.f52029h = true;
    }

    public void h() {
        this.f52027f.P.post(new c());
    }

    public View i(int i10) {
        return this.f52024c.findViewById(i10);
    }

    public final Animation j() {
        return AnimationUtils.loadAnimation(this.f52023b, m0.c.a(this.f52033l, true));
    }

    public final Animation k() {
        return AnimationUtils.loadAnimation(this.f52023b, m0.c.a(this.f52033l, false));
    }

    public void l() {
        this.f52031j = j();
        this.f52030i = k();
    }

    public void m() {
    }

    public void n() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2, 80);
        LayoutInflater from = LayoutInflater.from(this.f52023b);
        if (o()) {
            ViewGroup viewGroup = (ViewGroup) from.inflate(R$layout.layout_basepickerview, (ViewGroup) null, false);
            this.f52026e = viewGroup;
            viewGroup.setBackgroundColor(0);
            ViewGroup viewGroup2 = (ViewGroup) this.f52026e.findViewById(R$id.content_container);
            this.f52024c = viewGroup2;
            layoutParams.leftMargin = 30;
            layoutParams.rightMargin = 30;
            viewGroup2.setLayoutParams(layoutParams);
            e();
            this.f52026e.setOnClickListener(new ViewOnClickListenerC0792a());
        } else {
            k0.a aVar = this.f52027f;
            if (aVar.P == null) {
                aVar.P = (ViewGroup) ((Activity) this.f52023b).getWindow().getDecorView();
            }
            ViewGroup viewGroup3 = (ViewGroup) from.inflate(R$layout.layout_basepickerview, this.f52027f.P, false);
            this.f52025d = viewGroup3;
            viewGroup3.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            int i10 = this.f52027f.f50597g0;
            if (i10 != -1) {
                this.f52025d.setBackgroundColor(i10);
            }
            ViewGroup viewGroup4 = (ViewGroup) this.f52025d.findViewById(R$id.content_container);
            this.f52024c = viewGroup4;
            viewGroup4.setLayoutParams(layoutParams);
        }
        s(true);
    }

    public boolean o() {
        throw null;
    }

    public boolean p() {
        if (o()) {
            return false;
        }
        return this.f52025d.getParent() != null || this.f52032k;
    }

    public final void q(View view) {
        this.f52027f.P.addView(view);
        if (this.f52036o) {
            this.f52024c.startAnimation(this.f52031j);
        }
    }

    public void r() {
        Dialog dialog = this.f52034m;
        if (dialog != null) {
            dialog.setCancelable(this.f52027f.f50603j0);
        }
    }

    public void s(boolean z10) {
        ViewGroup viewGroup;
        if (o()) {
            viewGroup = this.f52026e;
        } else {
            viewGroup = this.f52025d;
        }
        viewGroup.setFocusable(z10);
        viewGroup.setFocusableInTouchMode(z10);
        if (z10) {
            viewGroup.setOnKeyListener(this.f52037p);
        } else {
            viewGroup.setOnKeyListener(null);
        }
    }

    public a t(boolean z10) {
        ViewGroup viewGroup = this.f52025d;
        if (viewGroup != null) {
            View findViewById = viewGroup.findViewById(R$id.outmost_container);
            if (z10) {
                findViewById.setOnTouchListener(this.f52038q);
            } else {
                findViewById.setOnTouchListener(null);
            }
        }
        return this;
    }

    public void u() {
        if (o()) {
            x();
        } else {
            if (p()) {
                return;
            }
            this.f52032k = true;
            q(this.f52025d);
            this.f52025d.requestFocus();
        }
    }

    public void v(View view, boolean z10) {
        this.f52035n = view;
        this.f52036o = z10;
        u();
    }

    public void w(boolean z10) {
        v(null, z10);
    }

    public final void x() {
        Dialog dialog = this.f52034m;
        if (dialog != null) {
            dialog.show();
        }
    }
}
