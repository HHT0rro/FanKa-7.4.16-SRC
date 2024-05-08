package com.huawei.hms.hmsscankit;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.huawei.hms.scankit.R;

/* compiled from: CustomDialog.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class a implements DialogInterface {

    /* renamed from: a, reason: collision with root package name */
    private final Context f30272a;

    /* renamed from: b, reason: collision with root package name */
    private final CharSequence f30273b;

    /* renamed from: c, reason: collision with root package name */
    private final CharSequence f30274c;

    /* renamed from: d, reason: collision with root package name */
    private final String f30275d;

    /* renamed from: e, reason: collision with root package name */
    private final String f30276e;

    /* renamed from: f, reason: collision with root package name */
    private final int f30277f;

    /* renamed from: g, reason: collision with root package name */
    private final int f30278g;

    /* renamed from: h, reason: collision with root package name */
    private final int f30279h;

    /* renamed from: i, reason: collision with root package name */
    private final int f30280i;

    /* renamed from: j, reason: collision with root package name */
    private final boolean f30281j;

    /* renamed from: k, reason: collision with root package name */
    private final int f30282k;

    /* renamed from: l, reason: collision with root package name */
    private final DialogInterface.OnClickListener f30283l;

    /* renamed from: m, reason: collision with root package name */
    private final DialogInterface.OnClickListener f30284m;

    /* renamed from: n, reason: collision with root package name */
    private AlertDialog f30285n;

    /* renamed from: o, reason: collision with root package name */
    public TextView f30286o;

    /* renamed from: p, reason: collision with root package name */
    public TextView f30287p;

    /* renamed from: q, reason: collision with root package name */
    public TextView f30288q;

    /* renamed from: r, reason: collision with root package name */
    public TextView f30289r;

    /* compiled from: CustomDialog.java */
    /* renamed from: com.huawei.hms.hmsscankit.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class ViewOnClickListenerC0323a implements View.OnClickListener {
        public ViewOnClickListenerC0323a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f30284m != null) {
                a.this.f30284m.onClick(a.this, -2);
            }
            a.this.dismiss();
        }
    }

    /* compiled from: CustomDialog.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f30283l != null) {
                a.this.f30283l.onClick(a.this, -1);
            }
            a.this.dismiss();
        }
    }

    /* compiled from: CustomDialog.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private final Context f30292a;

        /* renamed from: b, reason: collision with root package name */
        private CharSequence f30293b;

        /* renamed from: c, reason: collision with root package name */
        private CharSequence f30294c;

        /* renamed from: d, reason: collision with root package name */
        private String f30295d;

        /* renamed from: e, reason: collision with root package name */
        private String f30296e;

        /* renamed from: f, reason: collision with root package name */
        private int f30297f;

        /* renamed from: g, reason: collision with root package name */
        private int f30298g;

        /* renamed from: h, reason: collision with root package name */
        private int f30299h;

        /* renamed from: i, reason: collision with root package name */
        private int f30300i;

        /* renamed from: j, reason: collision with root package name */
        private boolean f30301j = true;

        /* renamed from: k, reason: collision with root package name */
        private int f30302k = 80;

        /* renamed from: l, reason: collision with root package name */
        private DialogInterface.OnClickListener f30303l;

        /* renamed from: m, reason: collision with root package name */
        private DialogInterface.OnClickListener f30304m;

        public c(Context context) {
            this.f30292a = context;
        }

        public c a(CharSequence charSequence) {
            this.f30294c = charSequence;
            return this;
        }

        public c b(CharSequence charSequence) {
            this.f30293b = charSequence;
            return this;
        }

        public c a(String str, DialogInterface.OnClickListener onClickListener) {
            this.f30295d = str;
            this.f30304m = onClickListener;
            return this;
        }

        public c b(String str, DialogInterface.OnClickListener onClickListener) {
            this.f30296e = str;
            this.f30303l = onClickListener;
            return this;
        }

        public a a() {
            return new a(this, null);
        }
    }

    public /* synthetic */ a(c cVar, ViewOnClickListenerC0323a viewOnClickListenerC0323a) {
        this(cVar);
    }

    public void c() {
        AlertDialog alertDialog = this.f30285n;
        if (alertDialog != null) {
            alertDialog.show();
        }
    }

    @Override // android.content.DialogInterface
    public void cancel() {
        AlertDialog alertDialog = this.f30285n;
        if (alertDialog != null) {
            alertDialog.cancel();
        }
    }

    @Override // android.content.DialogInterface
    public void dismiss() {
        AlertDialog alertDialog = this.f30285n;
        if (alertDialog == null || !alertDialog.isShowing()) {
            return;
        }
        this.f30285n.dismiss();
    }

    private a(c cVar) {
        this.f30272a = cVar.f30292a;
        this.f30273b = cVar.f30293b;
        this.f30274c = cVar.f30294c;
        this.f30275d = cVar.f30296e;
        this.f30276e = cVar.f30295d;
        this.f30277f = cVar.f30297f;
        this.f30278g = cVar.f30298g;
        this.f30279h = cVar.f30300i;
        this.f30280i = cVar.f30299h;
        this.f30281j = cVar.f30301j;
        this.f30282k = cVar.f30302k;
        this.f30283l = cVar.f30303l;
        this.f30284m = cVar.f30304m;
        a();
    }

    private void a() {
        if (this.f30272a != null) {
            this.f30285n = new AlertDialog.Builder(this.f30272a, R.style.BottomFullDialogStyle).create();
            View inflate = LayoutInflater.from(this.f30272a).inflate(R.layout.scankit_dialog_custom, (ViewGroup) null);
            Window window = this.f30285n.getWindow();
            if (window != null) {
                window.setGravity(this.f30282k);
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.f817y = 16;
                window.setAttributes(attributes);
            }
            this.f30286o = (TextView) inflate.findViewById(R.id.dialog_title);
            this.f30287p = (TextView) inflate.findViewById(R.id.dialog_message);
            this.f30288q = (TextView) inflate.findViewById(R.id.dialog_negative);
            this.f30289r = (TextView) inflate.findViewById(R.id.dialog_positive);
            this.f30285n.setView(inflate);
            CharSequence charSequence = this.f30273b;
            if (charSequence != null) {
                this.f30286o.setText(charSequence);
            }
            this.f30285n.setCanceledOnTouchOutside(false);
            this.f30286o.setMovementMethod(LinkMovementMethod.getInstance());
            this.f30287p.setMovementMethod(LinkMovementMethod.getInstance());
            this.f30287p.setText(this.f30274c);
            b();
        }
    }

    private void b() {
        this.f30288q.setText(this.f30276e);
        int i10 = this.f30280i;
        if (i10 != 0) {
            this.f30288q.setTextColor(i10);
        }
        this.f30288q.setOnClickListener(new ViewOnClickListenerC0323a());
        if (TextUtils.isEmpty(this.f30276e)) {
            this.f30288q.setVisibility(8);
        } else {
            this.f30288q.setVisibility(0);
        }
        this.f30289r.setText(this.f30275d);
        int i11 = this.f30279h;
        if (i11 != 0) {
            this.f30289r.setTextColor(i11);
        }
        this.f30289r.setOnClickListener(new b());
        if (TextUtils.isEmpty(this.f30275d)) {
            this.f30289r.setVisibility(8);
        } else {
            this.f30289r.setVisibility(0);
        }
        this.f30285n.setCancelable(this.f30281j);
    }
}
