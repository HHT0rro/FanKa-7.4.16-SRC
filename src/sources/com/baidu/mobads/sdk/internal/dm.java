package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.os.CountDownTimer;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.mobads.sdk.api.AdSize;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class dm {

    /* renamed from: f, reason: collision with root package name */
    private static final int f10195f = 5;

    /* renamed from: c, reason: collision with root package name */
    private RelativeLayout f10198c;

    /* renamed from: d, reason: collision with root package name */
    private TextView f10199d;

    /* renamed from: e, reason: collision with root package name */
    private CountDownTimer f10200e;

    /* renamed from: g, reason: collision with root package name */
    private dp f10201g;

    /* renamed from: j, reason: collision with root package name */
    private Activity f10204j;

    /* renamed from: k, reason: collision with root package name */
    private Boolean f10205k;

    /* renamed from: a, reason: collision with root package name */
    public final String f10196a = "html5_intersitial";

    /* renamed from: h, reason: collision with root package name */
    private boolean f10202h = false;

    /* renamed from: i, reason: collision with root package name */
    private boolean f10203i = false;

    /* renamed from: b, reason: collision with root package name */
    public final bs f10197b = bs.a();

    public dm(Context context, RelativeLayout relativeLayout, Boolean bool, AdSize adSize, String str) {
    }

    private boolean e() {
        return b();
    }

    private View f() {
        this.f10200e = new Cdo(this, 6000L, 1000L).start();
        return this.f10198c;
    }

    private void g() {
        RelativeLayout relativeLayout = this.f10198c;
        if (relativeLayout != null && relativeLayout.getParent() != null) {
            ((ViewGroup) this.f10198c.getParent()).removeView(this.f10198c);
        }
        if (this.f10200e != null) {
            this.f10197b.a("cancel countDownTimer before it finished");
            try {
                this.f10200e.cancel();
            } catch (Exception e2) {
                this.f10197b.a(e2);
            }
        }
    }

    private RelativeLayout.LayoutParams h() {
        return null;
    }

    public void a() {
    }

    public void a(int i10, int i11) {
    }

    public boolean a(int i10, KeyEvent keyEvent) {
        return true;
    }

    public boolean b() {
        return AdSize.InterstitialForVideoBeforePlay.getValue() == 0;
    }

    public void c() {
        Activity activity = this.f10204j;
        if (activity == null) {
            return;
        }
        activity.runOnUiThread(new dn(this));
    }

    public boolean d() {
        return this.f10202h;
    }

    public void a(Activity activity, RelativeLayout relativeLayout) {
        try {
            this.f10197b.a("showInterstitialAdInit");
            boolean z10 = this.f10202h;
            if (z10 && !this.f10203i) {
                this.f10203i = true;
                this.f10202h = false;
                this.f10204j = activity;
                a();
                c();
                return;
            }
            if (this.f10203i) {
                this.f10197b.b("interstitial ad is showing now");
            } else {
                if (z10) {
                    return;
                }
                this.f10197b.b("interstitial ad is not ready");
            }
        } catch (Exception e2) {
            this.f10197b.a(e2);
        }
    }
}
