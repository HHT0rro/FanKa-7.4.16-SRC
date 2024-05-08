package com.cmic.sso.sdk.view;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Point;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.cmic.sso.sdk.view.f;
import com.huawei.quickcard.base.Attributes;
import com.mobile.auth.gatewayauth.Constant;
import com.mobile.auth.n.n;
import com.mobile.auth.n.q;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class LoginAuthActivity extends Activity implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public static final String f11460a = LoginAuthActivity.class.getSimpleName();
    private com.cmic.sso.sdk.view.a A;
    private int B;
    private int C;
    private boolean D;
    private Dialog E;

    /* renamed from: b, reason: collision with root package name */
    private Handler f11461b;

    /* renamed from: c, reason: collision with root package name */
    private Context f11462c;

    /* renamed from: d, reason: collision with root package name */
    private RelativeLayout f11463d;

    /* renamed from: e, reason: collision with root package name */
    private h f11464e;

    /* renamed from: f, reason: collision with root package name */
    private h f11465f;

    /* renamed from: g, reason: collision with root package name */
    private h f11466g;

    /* renamed from: h, reason: collision with root package name */
    private h f11467h;

    /* renamed from: i, reason: collision with root package name */
    private h f11468i;

    /* renamed from: j, reason: collision with root package name */
    private ArrayList<h> f11469j;

    /* renamed from: k, reason: collision with root package name */
    private ArrayList<String> f11470k;

    /* renamed from: l, reason: collision with root package name */
    private String[] f11471l;

    /* renamed from: m, reason: collision with root package name */
    private com.cmic.sso.sdk.a f11472m;

    /* renamed from: n, reason: collision with root package name */
    private com.mobile.auth.g.c f11473n;

    /* renamed from: p, reason: collision with root package name */
    private CheckBox f11475p;

    /* renamed from: q, reason: collision with root package name */
    private RelativeLayout f11476q;

    /* renamed from: r, reason: collision with root package name */
    private RelativeLayout f11477r;

    /* renamed from: v, reason: collision with root package name */
    private com.mobile.auth.g.b f11481v;

    /* renamed from: x, reason: collision with root package name */
    private RelativeLayout f11483x;

    /* renamed from: y, reason: collision with root package name */
    private String f11484y;

    /* renamed from: z, reason: collision with root package name */
    private String f11485z;

    /* renamed from: o, reason: collision with root package name */
    private String f11474o = "";

    /* renamed from: s, reason: collision with root package name */
    private long f11478s = 0;

    /* renamed from: t, reason: collision with root package name */
    private int f11479t = 0;

    /* renamed from: u, reason: collision with root package name */
    private a f11480u = null;

    /* renamed from: w, reason: collision with root package name */
    private boolean f11482w = true;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class a extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public WeakReference<LoginAuthActivity> f11494a;

        public a(LoginAuthActivity loginAuthActivity) {
            this.f11494a = new WeakReference<>(loginAuthActivity);
        }

        private void a(Message message) {
            LoginAuthActivity loginAuthActivity = this.f11494a.get();
            if (loginAuthActivity == null || message.what != 1) {
                return;
            }
            loginAuthActivity.c();
            loginAuthActivity.k();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                a(message);
            } catch (Exception e2) {
                com.cmic.sso.sdk.d.c.f11453b.add(e2);
                e2.printStackTrace();
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class b extends n.a {

        /* renamed from: a, reason: collision with root package name */
        public WeakReference<LoginAuthActivity> f11495a;

        /* renamed from: b, reason: collision with root package name */
        public WeakReference<c> f11496b;

        public b(LoginAuthActivity loginAuthActivity, c cVar) {
            this.f11495a = new WeakReference<>(loginAuthActivity);
            this.f11496b = new WeakReference<>(cVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean b() {
            c cVar = this.f11496b.get();
            if (this.f11495a.get() == null || cVar == null) {
                return false;
            }
            return cVar.a(false);
        }

        @Override // com.mobile.auth.n.n.a
        public void a() {
            final LoginAuthActivity loginAuthActivity = this.f11495a.get();
            loginAuthActivity.f11472m.a("logintype", 1);
            com.mobile.auth.n.h.a(true, false);
            loginAuthActivity.f11473n.b(loginAuthActivity.f11472m, new com.mobile.auth.g.d() { // from class: com.cmic.sso.sdk.view.LoginAuthActivity.b.1
                @Override // com.mobile.auth.g.d
                public void a(String str, String str2, com.cmic.sso.sdk.a aVar, JSONObject jSONObject) {
                    if (b.this.b()) {
                        long b4 = aVar.b("loginTime", 0L);
                        String b10 = aVar.b("phonescrip");
                        if (b4 != 0) {
                            aVar.a("loginTime", System.currentTimeMillis() - b4);
                        }
                        if (!"103000".equals(str) || TextUtils.isEmpty(b10)) {
                            loginAuthActivity.f11482w = false;
                            com.cmic.sso.sdk.d.a.a("authClickFailed");
                        } else {
                            com.cmic.sso.sdk.d.a.a("authClickSuccess");
                            loginAuthActivity.f11482w = true;
                        }
                        loginAuthActivity.a(str, str2, aVar, jSONObject);
                        try {
                            Thread.sleep(1000L);
                        } catch (InterruptedException e2) {
                            e2.printStackTrace();
                        }
                        loginAuthActivity.f11480u.sendEmptyMessage(1);
                    }
                }
            });
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public class c implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        private com.cmic.sso.sdk.a f11500b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f11501c;

        public c(com.cmic.sso.sdk.a aVar) {
            this.f11500b = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized boolean a(boolean z10) {
            boolean z11;
            z11 = this.f11501c;
            this.f11501c = z10;
            return !z11;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a(true)) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("resultCode", "102507");
                    jSONObject.put("resultString", "请求超时");
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                LoginAuthActivity.this.f11482w = false;
                com.cmic.sso.sdk.d.a.a("authClickFailed");
                LoginAuthActivity.this.f11480u.sendEmptyMessage(1);
                long b4 = this.f11500b.b("loginTime", 0L);
                if (b4 != 0) {
                    this.f11500b.a("loginTime", System.currentTimeMillis() - b4);
                }
                LoginAuthActivity.this.a("102507", "请求超时", this.f11500b, jSONObject);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, com.cmic.sso.sdk.a aVar, JSONObject jSONObject) {
        com.mobile.auth.g.a a10;
        try {
            this.f11461b.removeCallbacksAndMessages(null);
            if ("103000".equals(str)) {
                if (com.mobile.auth.g.a.a(this) == null || com.mobile.auth.n.e.c(aVar.b("traceId")) == null) {
                    return;
                }
                aVar.a("keepListener", true);
                a10 = com.mobile.auth.g.a.a(this);
            } else {
                if ("200020".equals(str)) {
                    if (com.mobile.auth.g.a.a(this) != null) {
                        if (com.mobile.auth.n.e.c(aVar.b("traceId")) != null) {
                            com.mobile.auth.g.a.a(this).a(str, str2, aVar, jSONObject);
                        }
                        a();
                        return;
                    }
                    return;
                }
                aVar.a("keepListener", true);
                a10 = com.mobile.auth.g.a.a(this);
            }
            a10.a(str, str2, aVar, jSONObject);
        } catch (Exception e2) {
            com.mobile.auth.n.c.a(f11460a, "CallbackResult:未知错误");
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z10) {
        try {
            com.cmic.sso.sdk.d.a.a("authPageOut");
            a("200020", "登录页面关闭", this.f11472m, null);
        } catch (Exception e2) {
            com.cmic.sso.sdk.d.c.f11453b.add(e2);
            e2.printStackTrace();
        }
    }

    private void d() {
        String str;
        com.cmic.sso.sdk.a d10 = com.mobile.auth.n.e.d(getIntent().getStringExtra("traceId"));
        this.f11472m = d10;
        if (d10 == null) {
            this.f11472m = new com.cmic.sso.sdk.a(0);
        }
        this.f11481v = com.mobile.auth.n.e.c(this.f11472m.b("traceId", ""));
        getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
        this.f11461b = new Handler(getMainLooper());
        this.f11480u = new a(this);
        this.f11474o = this.f11472m.b("securityphone");
        String str2 = f11460a;
        com.mobile.auth.n.c.b(str2, "mSecurityPhone value is " + this.f11474o);
        String b4 = this.f11472m.b("operatortype", "");
        com.mobile.auth.n.c.b(str2, "operator value is " + b4);
        if (this.A.ap() == 1) {
            this.f11471l = com.cmic.sso.sdk.c.f11423b;
        } else if (this.A.ap() == 2) {
            this.f11471l = com.cmic.sso.sdk.c.f11424c;
        } else {
            this.f11471l = com.cmic.sso.sdk.c.f11422a;
        }
        if (b4.equals("1")) {
            this.f11484y = this.f11471l[0];
            str = "http://wap.cmpassport.com/resources/html/contract.html";
        } else if (b4.equals("3")) {
            this.f11484y = this.f11471l[1];
            str = Constant.CTCC_PROTOCOL_URL;
        } else {
            this.f11484y = this.f11471l[2];
            str = Constant.CUCC_PROTOCOL_URL;
        }
        h hVar = new h(this.f11462c, 16973840, this.f11484y, str);
        this.f11464e = hVar;
        hVar.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.cmic.sso.sdk.view.LoginAuthActivity.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
                if (i10 == 4 && keyEvent.getAction() == 1 && keyEvent.getRepeatCount() == 0) {
                    LoginAuthActivity.this.f11464e.b();
                }
                return true;
            }
        });
        this.f11469j = new ArrayList<>();
        this.f11470k = new ArrayList<>();
        if (!TextUtils.isEmpty(this.A.N())) {
            h hVar2 = new h(this.f11462c, 16973840, this.A.M(), this.A.N());
            this.f11465f = hVar2;
            hVar2.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.cmic.sso.sdk.view.LoginAuthActivity.2
                @Override // android.content.DialogInterface.OnKeyListener
                public boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
                    if (i10 == 4 && keyEvent.getAction() == 1 && keyEvent.getRepeatCount() == 0) {
                        LoginAuthActivity.this.f11465f.b();
                    }
                    return true;
                }
            });
            this.f11469j.add(this.f11465f);
            this.f11470k.add(this.A.M());
        }
        if (!TextUtils.isEmpty(this.A.P())) {
            h hVar3 = new h(this.f11462c, 16973840, this.A.O(), this.A.P());
            this.f11466g = hVar3;
            hVar3.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.cmic.sso.sdk.view.LoginAuthActivity.3
                @Override // android.content.DialogInterface.OnKeyListener
                public boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
                    if (i10 == 4 && keyEvent.getAction() == 1 && keyEvent.getRepeatCount() == 0) {
                        LoginAuthActivity.this.f11466g.b();
                    }
                    return true;
                }
            });
            this.f11469j.add(this.f11466g);
            this.f11470k.add(this.A.O());
        }
        if (!TextUtils.isEmpty(this.A.R())) {
            h hVar4 = new h(this.f11462c, 16973840, this.A.Q(), this.A.R());
            this.f11467h = hVar4;
            hVar4.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.cmic.sso.sdk.view.LoginAuthActivity.4
                @Override // android.content.DialogInterface.OnKeyListener
                public boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
                    if (i10 == 4 && keyEvent.getAction() == 1 && keyEvent.getRepeatCount() == 0) {
                        LoginAuthActivity.this.f11467h.b();
                    }
                    return true;
                }
            });
            this.f11469j.add(this.f11467h);
            this.f11470k.add(this.A.Q());
        }
        if (!TextUtils.isEmpty(this.A.T())) {
            h hVar5 = new h(this.f11462c, 16973840, this.A.S(), this.A.T());
            this.f11468i = hVar5;
            hVar5.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.cmic.sso.sdk.view.LoginAuthActivity.5
                @Override // android.content.DialogInterface.OnKeyListener
                public boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
                    if (i10 == 4 && keyEvent.getAction() == 1 && keyEvent.getRepeatCount() == 0) {
                        LoginAuthActivity.this.f11468i.b();
                    }
                    return true;
                }
            });
            this.f11469j.add(this.f11468i);
            this.f11470k.add(this.A.S());
        }
        j();
        if (this.A.ad()) {
            for (int i10 = 0; i10 < this.f11470k.size(); i10++) {
                String format = String.format("《%s》", this.f11470k.get(i10));
                this.f11485z = this.f11485z.replaceFirst(this.f11470k.get(i10), format);
                this.f11470k.set(i10, format);
            }
        }
        f.a().a(new f.a() { // from class: com.cmic.sso.sdk.view.LoginAuthActivity.6
            @Override // com.cmic.sso.sdk.view.f.a
            public void a() {
                LoginAuthActivity.this.f11461b.removeCallbacksAndMessages(null);
                if (LoginAuthActivity.this.f11464e != null && LoginAuthActivity.this.f11464e.isShowing()) {
                    LoginAuthActivity.this.f11464e.dismiss();
                }
                if (LoginAuthActivity.this.f11465f != null && LoginAuthActivity.this.f11465f.isShowing()) {
                    LoginAuthActivity.this.f11465f.dismiss();
                }
                LoginAuthActivity.this.a(true);
            }
        });
    }

    private void e() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f11477r.getLayoutParams();
        if (this.A.p() > 0 || this.A.q() < 0) {
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            this.f11477r.measure(makeMeasureSpec, makeMeasureSpec);
            String str = f11460a;
            com.mobile.auth.n.c.b(str, "mPhoneLayout.getMeasuredHeight()=" + this.f11477r.getMeasuredHeight());
            if (this.A.p() <= 0 || (this.B - this.f11477r.getMeasuredHeight()) - i.a(this.f11462c, this.A.p()) <= 0) {
                layoutParams.addRule(12, -1);
            } else {
                com.mobile.auth.n.c.b(str, "numberField_top");
                layoutParams.addRule(10, -1);
                layoutParams.setMargins(0, i.a(this.f11462c, this.A.p()), 0, 0);
            }
        } else if (this.A.q() <= 0 || (this.B - this.f11477r.getMeasuredHeight()) - i.a(this.f11462c, this.A.q()) <= 0) {
            layoutParams.addRule(10, -1);
        } else {
            com.mobile.auth.n.c.b(f11460a, "numberField_bottom");
            layoutParams.addRule(12, -1);
            layoutParams.setMargins(0, 0, 0, i.a(this.f11462c, this.A.q()));
        }
        this.f11477r.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f11463d.getLayoutParams();
        int max = Math.max(this.A.y(), 0);
        int max2 = Math.max(this.A.z(), 0);
        if (this.A.A() > 0 || this.A.B() < 0) {
            if (this.A.A() <= 0 || this.B - i.a(this.f11462c, this.A.x() + this.A.A()) <= 0) {
                layoutParams2.addRule(12, -1);
                layoutParams2.setMargins(i.a(this.f11462c, max), 0, i.a(this.f11462c, max2), 0);
            } else {
                com.mobile.auth.n.c.b(f11460a, "logBtn_top");
                layoutParams2.addRule(10, -1);
                layoutParams2.setMargins(i.a(this.f11462c, max), i.a(this.f11462c, this.A.A()), i.a(this.f11462c, max2), 0);
            }
        } else if (this.A.B() <= 0 || this.B - i.a(this.f11462c, this.A.x() + this.A.B()) <= 0) {
            layoutParams2.addRule(10, -1);
            layoutParams2.setMargins(i.a(this.f11462c, max), 0, i.a(this.f11462c, max2), 0);
        } else {
            com.mobile.auth.n.c.b(f11460a, "logBtn_bottom");
            layoutParams2.addRule(12, -1);
            layoutParams2.setMargins(i.a(this.f11462c, max), 0, i.a(this.f11462c, max2), i.a(this.f11462c, this.A.B()));
        }
        this.f11463d.setLayoutParams(layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f11476q.getLayoutParams();
        int Z = this.A.Z() >= 0 ? this.A.I() > 30 ? this.A.Z() : this.A.Z() - (30 - this.A.I()) : this.A.I() > 30 ? 0 : -(30 - this.A.I());
        int max3 = Math.max(this.A.aa(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.f11476q.measure(makeMeasureSpec2, makeMeasureSpec2);
        if (this.A.ab() > 0 || this.A.ac() < 0) {
            if (this.A.ab() <= 0 || (this.B - this.f11476q.getMeasuredHeight()) - i.a(this.f11462c, this.A.ab()) <= 0) {
                com.mobile.auth.n.c.b(f11460a, "privacy_bottom=" + Z);
                layoutParams3.addRule(12, -1);
                layoutParams3.setMargins(i.a(this.f11462c, (float) Z), 0, i.a(this.f11462c, (float) max3), 0);
            } else {
                com.mobile.auth.n.c.b(f11460a, "privacy_top = " + this.f11476q.getMeasuredHeight());
                layoutParams3.addRule(10, -1);
                layoutParams3.setMargins(i.a(this.f11462c, (float) Z), i.a(this.f11462c, (float) this.A.ab()), i.a(this.f11462c, (float) max3), 0);
            }
        } else if (this.A.ac() <= 0 || (this.B - this.f11476q.getMeasuredHeight()) - i.a(this.f11462c, this.A.ac()) <= 0) {
            layoutParams3.addRule(10, -1);
            layoutParams3.setMargins(i.a(this.f11462c, Z), 0, i.a(this.f11462c, max3), 0);
            com.mobile.auth.n.c.b(f11460a, "privacy_top");
        } else {
            com.mobile.auth.n.c.b(f11460a, "privacy_bottom=" + this.f11476q.getMeasuredHeight());
            layoutParams3.addRule(12, -1);
            layoutParams3.setMargins(i.a(this.f11462c, (float) Z), 0, i.a(this.f11462c, (float) max3), i.a(this.f11462c, (float) this.A.ac()));
        }
        this.f11476q.setLayoutParams(layoutParams3);
    }

    private void f() {
        int i10 = Build.VERSION.SDK_INT;
        getWindow().addFlags(67108864);
        getWindow().addFlags(134217728);
        if (this.A.a() != 0) {
            getWindow().addFlags(Integer.MIN_VALUE);
            getWindow().clearFlags(67108864);
            getWindow().setStatusBarColor(this.A.a());
            getWindow().setNavigationBarColor(this.A.a());
        }
        if (i10 >= 23) {
            if (this.A.b()) {
                getWindow().getDecorView().setSystemUiVisibility(8192);
            } else {
                getWindow().getDecorView().setSystemUiVisibility(0);
            }
        }
        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        View c4 = this.A.c();
        if (c4 != null) {
            ViewParent parent = c4.getParent();
            if (parent != null) {
                ((ViewGroup) parent).removeView(c4);
            }
            relativeLayout.addView(c4);
        } else if (this.A.d() != -1) {
            getLayoutInflater().inflate(this.A.d(), relativeLayout);
        }
        setContentView(relativeLayout);
        int requestedOrientation = getRequestedOrientation();
        this.B = i.b(this.f11462c);
        int a10 = i.a(this.f11462c);
        this.C = a10;
        boolean z10 = true;
        if ((requestedOrientation == 1 && a10 > this.B) || (requestedOrientation == 0 && a10 < this.B)) {
            this.C = this.B;
            this.B = a10;
        }
        com.mobile.auth.n.c.b(f11460a, "orientation = " + requestedOrientation + "--screenWidth = " + this.C + "--screenHeight = " + this.B);
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        if (this.A.aj() != 0) {
            getWindow().getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
            getWindowManager().getDefaultDisplay().getSize(new Point());
            attributes.width = i.a(this.f11462c, this.A.aj());
            int a11 = i.a(this.f11462c, this.A.ak());
            attributes.height = a11;
            this.C = attributes.width;
            this.B = a11;
            attributes.f816x = i.a(this.f11462c, this.A.al());
            if (this.A.an() == 1) {
                getWindow().setGravity(80);
            } else {
                attributes.f817y = i.a(this.f11462c, this.A.am());
            }
            getWindow().setAttributes(attributes);
        }
        relativeLayout.setFitsSystemWindows(this.A.aq());
        relativeLayout.setClipToPadding(true);
        try {
            g();
            relativeLayout.addView(this.f11477r);
            relativeLayout.addView(h());
            relativeLayout.addView(i());
            e();
            this.f11463d.setOnClickListener(this);
            this.f11483x.setOnClickListener(this);
            this.f11475p.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.cmic.sso.sdk.view.LoginAuthActivity.7
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public void onCheckedChanged(CompoundButton compoundButton, boolean z11) {
                    CheckBox checkBox;
                    LoginAuthActivity loginAuthActivity;
                    String str;
                    boolean z12 = true;
                    if (z11) {
                        LoginAuthActivity.this.f11463d.setEnabled(true);
                        try {
                            CheckBox checkBox2 = LoginAuthActivity.this.f11475p;
                            LoginAuthActivity loginAuthActivity2 = LoginAuthActivity.this;
                            checkBox2.setBackgroundResource(g.b(loginAuthActivity2, loginAuthActivity2.A.G()));
                            return;
                        } catch (Exception unused) {
                            checkBox = LoginAuthActivity.this.f11475p;
                            loginAuthActivity = LoginAuthActivity.this;
                            str = "umcsdk_check_image";
                        }
                    } else {
                        RelativeLayout relativeLayout2 = LoginAuthActivity.this.f11463d;
                        if (LoginAuthActivity.this.A.F() == null && TextUtils.isEmpty(LoginAuthActivity.this.A.C())) {
                            z12 = false;
                        }
                        relativeLayout2.setEnabled(z12);
                        try {
                            CheckBox checkBox3 = LoginAuthActivity.this.f11475p;
                            LoginAuthActivity loginAuthActivity3 = LoginAuthActivity.this;
                            checkBox3.setBackgroundResource(g.b(loginAuthActivity3, loginAuthActivity3.A.H()));
                            return;
                        } catch (Exception unused2) {
                            checkBox = LoginAuthActivity.this.f11475p;
                            loginAuthActivity = LoginAuthActivity.this;
                            str = "umcsdk_uncheck_image";
                        }
                    }
                    checkBox.setBackgroundResource(g.b(loginAuthActivity, str));
                }
            });
            k();
            try {
                if (this.A.K()) {
                    this.f11475p.setChecked(true);
                    this.f11475p.setBackgroundResource(g.b(this, this.A.G()));
                    this.f11463d.setEnabled(true);
                    return;
                }
                this.f11475p.setChecked(false);
                RelativeLayout relativeLayout2 = this.f11463d;
                if (this.A.F() == null && TextUtils.isEmpty(this.A.C())) {
                    z10 = false;
                }
                relativeLayout2.setEnabled(z10);
                this.f11475p.setBackgroundResource(g.b(this, this.A.H()));
            } catch (Exception unused) {
                this.f11475p.setChecked(false);
            }
        } catch (Exception e2) {
            com.cmic.sso.sdk.d.c.f11453b.add(e2);
            e2.printStackTrace();
            com.mobile.auth.n.c.a(f11460a, e2.toString());
            a("200040", "UI资源加载异常", this.f11472m, null);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(13:1|(1:3)(11:(2:22|(1:24)(1:25))|5|6|7|8|(1:10)|11|12|13|14|15)|4|5|6|7|8|(0)|11|12|13|14|15) */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0094, code lost:
    
        r0.setTextColor(-13421773);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0069, code lost:
    
        r0.setTextSize(2, 18.0f);
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x007b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void g() {
        /*
            r6 = this;
            android.widget.RelativeLayout r0 = new android.widget.RelativeLayout
            r0.<init>(r6)
            r6.f11477r = r0
            r1 = 13107(0x3333, float:1.8367E-41)
            r0.setId(r1)
            android.widget.RelativeLayout$LayoutParams r0 = new android.widget.RelativeLayout$LayoutParams
            r1 = -1
            r2 = -2
            r0.<init>(r1, r2)
            android.widget.RelativeLayout r1 = r6.f11477r
            r1.setLayoutParams(r0)
            android.widget.TextView r0 = new android.widget.TextView
            r0.<init>(r6)
            android.widget.RelativeLayout$LayoutParams r1 = new android.widget.RelativeLayout$LayoutParams
            r1.<init>(r2, r2)
            r2 = 15
            r0.setGravity(r2)
            com.cmic.sso.sdk.view.a r2 = r6.A
            int r2 = r2.o()
            r3 = 0
            if (r2 != 0) goto L36
            r2 = 13
        L32:
            r1.addRule(r2)
            goto L5d
        L36:
            if (r2 <= 0) goto L5d
            int r4 = r6.C
            int r5 = r0.getWidth()
            int r4 = r4 - r5
            android.content.Context r5 = r6.f11462c
            float r2 = (float) r2
            int r5 = com.cmic.sso.sdk.view.i.a(r5, r2)
            int r4 = r4 - r5
            if (r4 <= 0) goto L53
            android.content.Context r4 = r6.f11462c
            int r2 = com.cmic.sso.sdk.view.i.a(r4, r2)
            r1.setMargins(r2, r3, r3, r3)
            goto L5d
        L53:
            java.lang.String r2 = com.cmic.sso.sdk.view.LoginAuthActivity.f11460a
            java.lang.String r4 = "RelativeLayout.ALIGN_PARENT_RIGHT"
            com.mobile.auth.n.c.b(r2, r4)
            r2 = 11
            goto L32
        L5d:
            r2 = 2
            com.cmic.sso.sdk.view.a r4 = r6.A     // Catch: java.lang.Exception -> L69
            int r4 = r4.l()     // Catch: java.lang.Exception -> L69
            float r4 = (float) r4     // Catch: java.lang.Exception -> L69
            r0.setTextSize(r2, r4)     // Catch: java.lang.Exception -> L69
            goto L6e
        L69:
            r4 = 1099956224(0x41900000, float:18.0)
            r0.setTextSize(r2, r4)
        L6e:
            java.lang.String r2 = r6.f11474o
            r0.setText(r2)
            com.cmic.sso.sdk.view.a r2 = r6.A
            boolean r2 = r2.m()
            if (r2 == 0) goto L80
            android.graphics.Typeface r2 = android.graphics.Typeface.DEFAULT_BOLD
            r0.setTypeface(r2)
        L80:
            r2 = 30583(0x7777, float:4.2856E-41)
            r0.setId(r2)
            android.widget.RelativeLayout r2 = r6.f11477r
            r2.addView(r0, r1)
            com.cmic.sso.sdk.view.a r1 = r6.A     // Catch: java.lang.Exception -> L94
            int r1 = r1.n()     // Catch: java.lang.Exception -> L94
            r0.setTextColor(r1)     // Catch: java.lang.Exception -> L94
            goto L9a
        L94:
            r1 = -13421773(0xffffffffff333333, float:-2.3819765E38)
            r0.setTextColor(r1)
        L9a:
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r3, r3)
            android.widget.RelativeLayout r1 = r6.f11477r
            r1.measure(r0, r0)
            java.lang.String r0 = com.cmic.sso.sdk.view.LoginAuthActivity.f11460a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "mPhoneLayout.getMeasuredHeight()="
            r1.append(r2)
            android.widget.RelativeLayout r2 = r6.f11477r
            int r2 = r2.getMeasuredHeight()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.mobile.auth.n.c.b(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cmic.sso.sdk.view.LoginAuthActivity.g():void");
    }

    private RelativeLayout h() {
        RelativeLayout relativeLayout = new RelativeLayout(this);
        this.f11463d = relativeLayout;
        relativeLayout.setId(17476);
        this.f11463d.setLayoutParams(new RelativeLayout.LayoutParams(i.a(this.f11462c, this.A.w()), i.a(this.f11462c, this.A.x())));
        TextView textView = new TextView(this);
        textView.setTextSize(2, this.A.s());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        textView.setLayoutParams(layoutParams);
        if (this.A.t()) {
            textView.setTypeface(Typeface.DEFAULT_BOLD);
        }
        this.f11463d.addView(textView);
        textView.setText(this.A.r());
        try {
            textView.setTextColor(this.A.u());
        } catch (Exception unused) {
            textView.setTextColor(-1);
        }
        try {
            this.f11463d.setBackgroundResource(g.b(this.f11462c, this.A.v()));
        } catch (Exception e2) {
            e2.printStackTrace();
            this.f11463d.setBackgroundResource(g.b(this.f11462c, "umcsdk_login_btn_bg"));
        }
        return this.f11463d;
    }

    private RelativeLayout i() {
        RelativeLayout relativeLayout = new RelativeLayout(this);
        this.f11476q = relativeLayout;
        relativeLayout.setHorizontalGravity(1);
        this.f11476q.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        int I = this.A.I();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i.a(this.f11462c, Math.max(I, 30)), i.a(this.f11462c, Math.max(this.A.J(), 30)));
        if (this.A.ae() == 1) {
            layoutParams.addRule(15, -1);
        }
        RelativeLayout relativeLayout2 = new RelativeLayout(this);
        this.f11483x = relativeLayout2;
        relativeLayout2.setId(34952);
        this.f11483x.setLayoutParams(layoutParams);
        CheckBox checkBox = new CheckBox(this);
        this.f11475p = checkBox;
        checkBox.setChecked(false);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i.a(this.f11462c, this.A.I()), i.a(this.f11462c, this.A.J()));
        layoutParams2.setMargins(i.a(this.f11462c, I > 30 ? 0.0f : 30 - I), 0, 0, 0);
        layoutParams2.addRule(11, -1);
        if (this.A.ae() == 1) {
            layoutParams2.addRule(15, -1);
        }
        this.f11475p.setLayoutParams(layoutParams2);
        this.f11483x.addView(this.f11475p);
        this.f11476q.addView(this.f11483x);
        TextView textView = new TextView(this);
        textView.setTextSize(2, this.A.U());
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.setMargins(i.a(this.f11462c, 5.0f), 0, 0, i.a(this.f11462c, 5.0f));
        layoutParams3.addRule(1, 34952);
        textView.setLayoutParams(layoutParams3);
        this.f11476q.addView(textView);
        textView.setTextColor(this.A.W());
        textView.setText(i.a(this, this.f11485z, this.f11484y, this.f11464e, this.f11469j, this.f11470k));
        textView.setLineSpacing(8.0f, 1.0f);
        textView.setIncludeFontPadding(false);
        if (this.A.V()) {
            textView.setTypeface(Typeface.DEFAULT_BOLD);
        }
        if (this.A.Y()) {
            textView.setGravity(17);
        }
        textView.setHighlightColor(getResources().getColor(17170445));
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        this.f11475p.lambda$setButtonIconAsync$1(new ColorDrawable());
        try {
            this.f11475p.setBackgroundResource(g.b(this, this.A.H()));
        } catch (Exception unused) {
            this.f11475p.setBackgroundResource(g.b(this, "umcsdk_uncheck_image"));
        }
        return this.f11476q;
    }

    private String j() {
        this.f11485z = this.A.L();
        if (this.A.ad()) {
            this.f11484y = String.format("《%s》", this.f11484y);
        }
        if (this.f11485z.contains("$$运营商条款$$")) {
            this.f11485z = this.f11485z.replace("$$运营商条款$$", this.f11484y);
        }
        return this.f11485z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        this.f11463d.setClickable(true);
        this.f11475p.setClickable(true);
    }

    private void l() {
        this.f11463d.setClickable(false);
        this.f11475p.setClickable(false);
    }

    private void m() {
        try {
            if (this.f11479t >= 5) {
                Toast.makeText(this.f11462c, "网络不稳定,请返回重试其他登录方式", 1).show();
                this.f11463d.setClickable(true);
                return;
            }
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            StringBuilder sb2 = new StringBuilder();
            for (StackTraceElement stackTraceElement : stackTrace) {
                com.mobile.auth.n.c.a(Attributes.Component.STACK, stackTraceElement.getClassName());
                String className = stackTraceElement.getClassName();
                if (!TextUtils.isEmpty(className) && className.contains("com.cmic.sso.sdk.activity") && !sb2.toString().contains(className)) {
                    sb2.append(className);
                    sb2.append(";");
                }
            }
            this.f11472m.a("loginTime", System.currentTimeMillis());
            String b4 = this.f11472m.b("traceId", "");
            if (!TextUtils.isEmpty(b4) && com.mobile.auth.n.e.a(b4)) {
                String c4 = q.c();
                this.f11472m.a("traceId", c4);
                com.mobile.auth.n.e.a(c4, this.f11481v);
            }
            b();
            l();
            c cVar = new c(this.f11472m);
            this.f11461b.postDelayed(cVar, com.mobile.auth.g.a.a(this).c());
            n.a(new b(this, cVar));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void a() {
        this.f11461b.removeCallbacksAndMessages(null);
        h hVar = this.f11464e;
        if (hVar != null && hVar.isShowing()) {
            this.f11464e.dismiss();
        }
        h hVar2 = this.f11465f;
        if (hVar2 != null && hVar2.isShowing()) {
            this.f11465f.dismiss();
        }
        c();
        this.E = null;
        this.f11476q.clearAnimation();
        finish();
        if (this.A.ah() == null || this.A.ai() == null) {
            return;
        }
        overridePendingTransition(g.c(this, this.A.ai()), g.c(this, this.A.ah()));
    }

    public void b() {
        com.mobile.auth.n.c.a(f11460a, "loginClickStart");
        try {
            this.D = true;
            if (this.A.E() != null) {
                this.A.E().a(this.f11462c, null);
            } else {
                Dialog dialog = this.E;
                if (dialog != null) {
                    dialog.show();
                    return;
                }
                AlertDialog create = new AlertDialog.Builder(this).create();
                this.E = create;
                create.setCancelable(false);
                this.E.setCanceledOnTouchOutside(false);
                this.E.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.cmic.sso.sdk.view.LoginAuthActivity.8
                    @Override // android.content.DialogInterface.OnKeyListener
                    public boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
                        return i10 == 4;
                    }
                });
                RelativeLayout relativeLayout = new RelativeLayout(this.E.getContext());
                relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
                ImageView imageView = new ImageView(this.E.getContext());
                imageView.setImageResource(g.b(this.f11462c, "dialog_loading"));
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(80, 80);
                layoutParams.addRule(13, -1);
                relativeLayout.addView(imageView, layoutParams);
                if (this.E.getWindow() != null) {
                    this.E.getWindow().setDimAmount(0.0f);
                }
                this.E.show();
                this.E.setContentView(relativeLayout);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        com.mobile.auth.n.c.a(f11460a, "loginClickStart");
    }

    public void c() {
        try {
            com.mobile.auth.n.c.a(f11460a, "loginClickComplete");
            if (this.A.E() == null || !this.D) {
                Dialog dialog = this.E;
                if (dialog != null && dialog.isShowing()) {
                    this.E.dismiss();
                }
            } else {
                this.D = false;
                this.A.E().b(this.f11462c, null);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        try {
            int id2 = view.getId();
            if (id2 != 17476) {
                if (id2 == 26214) {
                    a(false);
                    return;
                } else {
                    if (id2 != 34952) {
                        return;
                    }
                    if (this.f11475p.isChecked()) {
                        this.f11475p.setChecked(false);
                        return;
                    } else {
                        this.f11475p.setChecked(true);
                        return;
                    }
                }
            }
            if (!this.f11475p.isChecked()) {
                if (this.A.as() != null) {
                    Context context = this.f11462c;
                    this.f11476q.startAnimation(AnimationUtils.loadAnimation(context, g.c(context, this.A.as())));
                }
                if (this.A.F() != null) {
                    this.A.F().a(this.f11462c, null);
                    return;
                } else if (!TextUtils.isEmpty(this.A.C())) {
                    Toast.makeText(this.f11462c, this.A.C(), 1).show();
                    return;
                }
            }
            this.f11479t++;
            m();
        } catch (Exception e2) {
            com.cmic.sso.sdk.d.c.f11453b.add(e2);
            e2.printStackTrace();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
            if (bundle != null) {
                finish();
            }
            this.f11462c = this;
            com.cmic.sso.sdk.view.a a10 = com.mobile.auth.g.a.a(this).a();
            this.A = a10;
            if (a10 != null) {
                if (a10.ao() != -1) {
                    setTheme(this.A.ao());
                }
                if (this.A.af() != null && this.A.ag() != null) {
                    overridePendingTransition(g.c(this, this.A.af()), g.c(this, this.A.ag()));
                }
            }
            com.cmic.sso.sdk.d.a.a("authPageIn");
            this.f11478s = System.currentTimeMillis();
            this.f11473n = com.mobile.auth.g.c.a(this);
            d();
            f();
        } catch (Exception e2) {
            this.f11472m.a().f11427a.add(e2);
            com.mobile.auth.n.c.a(f11460a, e2.toString());
            e2.printStackTrace();
            a("200025", "发生未知错误", this.f11472m, null);
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        try {
            this.f11461b.removeCallbacksAndMessages(null);
            com.cmic.sso.sdk.d.a.a("timeOnAuthPage", (System.currentTimeMillis() - this.f11478s) + "");
            com.cmic.sso.sdk.d.a.a("authPrivacyState", this.f11475p.isChecked() ? "1" : "0");
            this.E = null;
            f.a().c();
            this.f11480u.removeCallbacksAndMessages(null);
        } catch (Exception e2) {
            com.mobile.auth.n.c.a(f11460a, "LoginAuthActivity clear failed");
            com.cmic.sso.sdk.d.c.f11453b.add(e2);
            e2.printStackTrace();
        }
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i10, KeyEvent keyEvent) {
        if (i10 != 4 || keyEvent.isCanceled() || keyEvent.getRepeatCount() != 0) {
            return true;
        }
        if (this.A.D() != null) {
            this.A.D().a();
        }
        if (this.A.aj() != 0 && !this.A.ar()) {
            return true;
        }
        a(false);
        return true;
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        try {
            com.cmic.sso.sdk.a aVar = this.f11472m;
            if (aVar != null) {
                aVar.a("loginMethod", "loginAuth");
            }
            com.mobile.auth.g.a.a(this).a("200087", (JSONObject) null);
        } catch (Exception e2) {
            this.f11472m.a().f11427a.add(e2);
            a("200025", "发生未知错误", this.f11472m, null);
        }
    }
}
