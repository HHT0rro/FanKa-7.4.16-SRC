package com.huawei.openalliance.ad.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.huawei.hms.ads.AdvertiserInfo;
import com.huawei.hms.ads.base.R;
import com.huawei.hms.ads.gi;
import com.huawei.hms.ads.gl;
import com.huawei.openalliance.ad.activity.a;
import com.huawei.openalliance.ad.constant.ax;
import com.huawei.openalliance.ad.constant.u;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.utils.ay;
import com.huawei.openalliance.ad.utils.o;
import com.huawei.openalliance.ad.utils.z;
import com.huawei.openalliance.ad.views.PPSBaseDialogContentView;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ComplianceActivity extends a {

    /* renamed from: n, reason: collision with root package name */
    private static final String f32118n = "ComplianceActivity";

    /* renamed from: o, reason: collision with root package name */
    private static final int f32119o = 2;

    /* renamed from: p, reason: collision with root package name */
    private static b f32120p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f32121q;

    /* renamed from: r, reason: collision with root package name */
    private AdContentData f32122r = new AdContentData();

    public static void Code(Context context, View view, AdContentData adContentData, boolean z10) {
        if (view == null) {
            return;
        }
        try {
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            gl.V(f32118n, "startFeedbackActivity, anchorView.getLocationInWindow [x,y]= %d, %d", Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]));
            int[] iArr2 = new int[2];
            view.getLocationOnScreen(iArr2);
            int[] iArr3 = {view.getMeasuredWidth(), view.getMeasuredHeight()};
            view.getViewTreeObserver().addOnGlobalLayoutListener(new a.ViewTreeObserverOnGlobalLayoutListenerC0328a(view, context, iArr2));
            Code(context, iArr, iArr3, adContentData, z10);
        } catch (Throwable th) {
            gl.I(f32118n, "start Activity error: %s", th.getClass().getSimpleName());
        }
    }

    public static void Code(Context context, int[] iArr, int[] iArr2, AdContentData adContentData, boolean z10) {
        if (Code(adContentData)) {
            return;
        }
        Intent intent = new Intent(context, (Class<?>) ComplianceActivity.class);
        intent.putExtra(ax.ao, iArr);
        intent.putExtra(ax.ap, iArr2);
        intent.setFlags(65536);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        String X = adContentData.X();
        if (TextUtils.isEmpty(X)) {
            X = adContentData.W();
        }
        intent.putExtra(ax.au, X);
        intent.putExtra(ax.av, z.V(adContentData.aG()));
        intent.putExtra(ax.aw, z10);
        intent.setClipData(u.cG);
        ay.Code(context, intent);
    }

    public static void Code(b bVar) {
        f32120p = bVar;
    }

    private static boolean Code(AdContentData adContentData) {
        if (!o.Code()) {
            return adContentData == null;
        }
        gl.V(f32118n, "repeat click too fast");
        return true;
    }

    private void F() {
        RelativeLayout relativeLayout = this.f32140j;
        if (relativeLayout == null || this.f32134d == null || this.f32135e == null) {
            return;
        }
        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.huawei.openalliance.ad.activity.ComplianceActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ComplianceActivity.this.finish();
            }
        });
        this.f32134d.setViewClickListener(new gi() { // from class: com.huawei.openalliance.ad.activity.ComplianceActivity.2
            @Override // com.huawei.hms.ads.gi
            public void Code() {
                ComplianceActivity.this.finish();
            }
        });
        this.f32135e.setViewClickListener(new gi() { // from class: com.huawei.openalliance.ad.activity.ComplianceActivity.3
            @Override // com.huawei.hms.ads.gi
            public void Code() {
                ComplianceActivity.this.finish();
            }
        });
    }

    public static void S() {
        f32120p = null;
    }

    @Override // com.huawei.openalliance.ad.activity.a
    public boolean B() {
        String stringExtra = getIntent().getStringExtra(ax.au);
        String stringExtra2 = getIntent().getStringExtra(ax.av);
        if (!TextUtils.isEmpty(stringExtra2)) {
            this.f32122r.D((List<AdvertiserInfo>) z.V(stringExtra2, List.class, AdvertiserInfo.class));
        }
        this.f32121q = getIntent().getBooleanExtra(ax.aw, false);
        this.f32122r.D(stringExtra);
        return super.B();
    }

    @Override // com.huawei.openalliance.ad.activity.a
    public void Code() {
        this.f32140j = (RelativeLayout) findViewById(R.id.compliance_activity_root);
        this.f32141k = findViewById(R.id.margin_view);
        this.f32142l = findViewById(R.id.compliance_anchor_view);
        this.f32134d = (PPSBaseDialogContentView) findViewById(R.id.top_compliance_view);
        this.f32137g = (ImageView) findViewById(R.id.top_compliance_iv);
        this.f32135e = (PPSBaseDialogContentView) findViewById(R.id.bottom_compliance_view);
        this.f32138h = (ImageView) findViewById(R.id.bottom_compliance_iv);
    }

    @Override // com.huawei.openalliance.ad.activity.a
    public void I() {
        C();
        this.f32136f.Code(this.f32131a, this.f32132b);
        this.f32136f.setShowWhyThisAd(this.f32121q);
        this.f32136f.setAdContentData(this.f32122r);
    }

    @Override // com.huawei.openalliance.ad.activity.a
    public int V() {
        return R.layout.hiad_activity_compliance;
    }

    @Override // com.huawei.openalliance.ad.activity.a, android.app.Activity
    public void finish() {
        super.finish();
        b bVar = f32120p;
        if (bVar != null) {
            bVar.V();
        }
    }

    @Override // com.huawei.openalliance.ad.activity.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        F();
        b bVar = f32120p;
        if (bVar != null) {
            bVar.Code();
        }
    }
}
