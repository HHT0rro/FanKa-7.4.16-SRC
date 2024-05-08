package com.huawei.openalliance.ad.activity;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import androidx.annotation.Nullable;
import com.huawei.hms.ads.base.R;
import com.huawei.hms.ads.dynamic.ObjectWrapper;
import com.huawei.hms.ads.f;
import com.huawei.hms.ads.gl;
import com.huawei.hms.ads.ky;
import com.huawei.hms.ads.uiengine.IPPSUiEngineCallback;
import com.huawei.hms.ads.uiengine.IRemoteCreator;
import com.huawei.hms.ads.uiengine.IRemoteViewDelegate;
import com.huawei.openalliance.ad.constant.bg;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.utils.SafeIntent;
import com.huawei.openalliance.ad.utils.ay;
import com.huawei.openalliance.ad.utils.ba;
import com.huawei.openalliance.ad.utils.z;
import java.lang.ref.WeakReference;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class TemplateStubActivity extends Activity {
    private static final String Code = "TemplateStubActivity";
    private static AdContentData I;
    private boolean B = false;
    private IRemoteViewDelegate V;
    private View Z;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a extends IPPSUiEngineCallback.b {
        private WeakReference<TemplateStubActivity> V;

        public a(TemplateStubActivity templateStubActivity) {
            this.V = new WeakReference<>(templateStubActivity);
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x0054, code lost:
        
            if (r6.equals(com.huawei.openalliance.ad.constant.bg.b.S) == false) goto L4;
         */
        @Override // com.huawei.hms.ads.uiengine.IPPSUiEngineCallback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onCallResult(java.lang.String r6, android.os.Bundle r7) {
            /*
                r5 = this;
                r0 = 1
                java.lang.Object[] r1 = new java.lang.Object[r0]
                r2 = 0
                r1[r2] = r6
                java.lang.String r3 = "TemplateStubActivity"
                java.lang.String r4 = "onCallResult method: %s"
                com.huawei.hms.ads.gl.V(r3, r4, r1)
                java.lang.ref.WeakReference<com.huawei.openalliance.ad.activity.TemplateStubActivity> r1 = r5.V
                java.lang.Object r1 = r1.get()
                com.huawei.openalliance.ad.activity.TemplateStubActivity r1 = (com.huawei.openalliance.ad.activity.TemplateStubActivity) r1
                r6.hashCode()
                int r3 = r6.hashCode()
                r4 = -1
                switch(r3) {
                    case -599445191: goto L57;
                    case 3135262: goto L4e;
                    case 3529469: goto L43;
                    case 94750088: goto L38;
                    case 94756344: goto L2d;
                    case 1671672458: goto L22;
                    default: goto L20;
                }
            L20:
                r0 = -1
                goto L61
            L22:
                java.lang.String r0 = "dismiss"
                boolean r6 = r6.equals(r0)
                if (r6 != 0) goto L2b
                goto L20
            L2b:
                r0 = 5
                goto L61
            L2d:
                java.lang.String r0 = "close"
                boolean r6 = r6.equals(r0)
                if (r6 != 0) goto L36
                goto L20
            L36:
                r0 = 4
                goto L61
            L38:
                java.lang.String r0 = "click"
                boolean r6 = r6.equals(r0)
                if (r6 != 0) goto L41
                goto L20
            L41:
                r0 = 3
                goto L61
            L43:
                java.lang.String r0 = "show"
                boolean r6 = r6.equals(r0)
                if (r6 != 0) goto L4c
                goto L20
            L4c:
                r0 = 2
                goto L61
            L4e:
                java.lang.String r2 = "fail"
                boolean r6 = r6.equals(r2)
                if (r6 != 0) goto L61
                goto L20
            L57:
                java.lang.String r0 = "complete"
                boolean r6 = r6.equals(r0)
                if (r6 != 0) goto L60
                goto L20
            L60:
                r0 = 0
            L61:
                switch(r0) {
                    case 0: goto Le0;
                    case 1: goto Lcb;
                    case 2: goto Lb1;
                    case 3: goto L91;
                    case 4: goto L7c;
                    case 5: goto L66;
                    default: goto L64;
                }
            L64:
                goto Lf4
            L66:
                if (r1 == 0) goto Lf4
                com.huawei.openalliance.ad.activity.TemplateStubActivity.Code(r1)
                android.content.Context r6 = r1.getApplicationContext()
                com.huawei.hms.ads.ky r6 = com.huawei.hms.ads.ky.Code(r6)
                com.huawei.openalliance.ad.inter.data.AdContentData r7 = com.huawei.openalliance.ad.activity.TemplateStubActivity.Code()
                r6.V(r7)
                goto Lf4
            L7c:
                if (r1 == 0) goto Lf4
                com.huawei.openalliance.ad.activity.TemplateStubActivity.Code(r1)
                android.content.Context r6 = r1.getApplicationContext()
                com.huawei.hms.ads.ky r6 = com.huawei.hms.ads.ky.Code(r6)
                com.huawei.openalliance.ad.inter.data.AdContentData r0 = com.huawei.openalliance.ad.activity.TemplateStubActivity.Code()
                r6.V(r0, r7)
                goto Lf4
            L91:
                if (r1 == 0) goto Lf4
                android.content.Context r6 = r1.getApplicationContext()
                com.huawei.hms.ads.ky r6 = com.huawei.hms.ads.ky.Code(r6)
                com.huawei.openalliance.ad.inter.data.AdContentData r0 = com.huawei.openalliance.ad.activity.TemplateStubActivity.Code()
                java.lang.Class r2 = r1.getClass()
                java.lang.String r2 = r2.getSimpleName()
                boolean r6 = r6.Code(r1, r0, r7, r2)
                if (r6 == 0) goto Lf4
                com.huawei.openalliance.ad.activity.TemplateStubActivity.Code(r1)
                goto Lf4
            Lb1:
                if (r1 == 0) goto Lf4
                android.content.Context r6 = r1.getApplicationContext()
                com.huawei.hms.ads.ky r6 = com.huawei.hms.ads.ky.Code(r6)
                com.huawei.openalliance.ad.inter.data.AdContentData r7 = com.huawei.openalliance.ad.activity.TemplateStubActivity.Code()
                java.lang.Class r0 = r1.getClass()
                java.lang.String r0 = r0.getSimpleName()
                r6.Code(r7, r0)
                goto Lf4
            Lcb:
                if (r1 == 0) goto Lf4
                com.huawei.openalliance.ad.activity.TemplateStubActivity.Code(r1)
                android.content.Context r6 = r1.getApplicationContext()
                com.huawei.hms.ads.ky r6 = com.huawei.hms.ads.ky.Code(r6)
                com.huawei.openalliance.ad.inter.data.AdContentData r0 = com.huawei.openalliance.ad.activity.TemplateStubActivity.Code()
                r6.I(r0, r7)
                goto Lf4
            Le0:
                if (r1 == 0) goto Lf4
                com.huawei.openalliance.ad.activity.TemplateStubActivity.Code(r1)
                android.content.Context r6 = r1.getApplicationContext()
                com.huawei.hms.ads.ky r6 = com.huawei.hms.ads.ky.Code(r6)
                com.huawei.openalliance.ad.inter.data.AdContentData r0 = com.huawei.openalliance.ad.activity.TemplateStubActivity.Code()
                r6.Code(r0, r7)
            Lf4:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.openalliance.ad.activity.TemplateStubActivity.a.onCallResult(java.lang.String, android.os.Bundle):void");
        }
    }

    private void B() {
        try {
            IRemoteViewDelegate iRemoteViewDelegate = this.V;
            if (iRemoteViewDelegate != null) {
                iRemoteViewDelegate.onDestroy();
            }
        } catch (Throwable th) {
            gl.I(Code, "onDestroy failed: " + th.getClass().getSimpleName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bundle Code(String str, Bundle bundle) {
        try {
            IRemoteViewDelegate iRemoteViewDelegate = this.V;
            if (iRemoteViewDelegate != null) {
                return iRemoteViewDelegate.sendCommand(str, bundle);
            }
            return null;
        } catch (Throwable th) {
            gl.I(Code, "%s failed: %s ", str, th.getClass().getSimpleName());
            return null;
        }
    }

    private static void Code(AdContentData adContentData) {
        I = adContentData;
    }

    private void I() {
        getWindow().setFlags(1024, 1024);
        int i10 = Build.VERSION.SDK_INT;
        getWindow().addFlags(134217728);
        if (i10 >= 28) {
            try {
                if (1 == getResources().getConfiguration().orientation) {
                    WindowManager.LayoutParams attributes = getWindow().getAttributes();
                    attributes.layoutInDisplayCutoutMode = 1;
                    getWindow().setAttributes(attributes);
                }
            } catch (Throwable th) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("set CutoutMode error:");
                sb2.append(th.getClass().getSimpleName());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V() {
        finish();
        overridePendingTransition(0, R.anim.hiad_anim_fade_out);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z() {
        try {
            IRemoteViewDelegate iRemoteViewDelegate = this.V;
            if (iRemoteViewDelegate != null) {
                View view = (View) ObjectWrapper.unwrap(iRemoteViewDelegate.getView());
                this.Z = view;
                setContentView(view);
            }
        } catch (Throwable th) {
            gl.I(Code, "plugRemoteView " + th.getClass().getSimpleName());
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0, R.anim.hiad_anim_fade_out);
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        SafeIntent safeIntent = new SafeIntent(getIntent());
        String stringExtra = safeIntent.getStringExtra("content");
        Code((AdContentData) z.V(stringExtra, AdContentData.class, new Class[0]));
        if (ay.V(getApplicationContext())) {
            gl.V(Code, "screen locked");
            ky.Code(getApplicationContext()).Code(I, 1);
            finish();
        }
        IRemoteCreator Code2 = f.Code(getApplicationContext());
        if (Code2 == null) {
            ky.Code(getApplicationContext()).Code(I, 2);
            finish();
            return;
        }
        I();
        Bundle bundle2 = new Bundle();
        bundle2.putString("filePath", safeIntent.getStringExtra("filePath"));
        bundle2.putString("content", stringExtra);
        try {
            IRemoteViewDelegate newRemoteViewDelegate = Code2.newRemoteViewDelegate(ObjectWrapper.wrap(this), safeIntent.getStringExtra(bg.e.F), null);
            this.V = newRemoteViewDelegate;
            newRemoteViewDelegate.onCreate(bundle2);
            this.V.setCallback(new a(this));
            ba.Code(new Runnable() { // from class: com.huawei.openalliance.ad.activity.TemplateStubActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    TemplateStubActivity.this.Z();
                    TemplateStubActivity.this.Code("start", null);
                    ay.Code(TemplateStubActivity.this.Z, TemplateStubActivity.this);
                    TemplateStubActivity.this.Z.startAnimation(AnimationUtils.loadAnimation(TemplateStubActivity.this.getApplicationContext(), R.anim.hiad_anim_fade_in));
                }
            });
        } catch (Throwable th) {
            gl.I(Code, "create remoteViewDelegate err: %s", th.getClass().getSimpleName());
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        gl.V(Code, "onDestroy");
        B();
        ky.Code(getApplicationContext()).V(I);
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        gl.V(Code, "onPause");
        this.B = true;
        try {
            IRemoteViewDelegate iRemoteViewDelegate = this.V;
            if (iRemoteViewDelegate != null) {
                iRemoteViewDelegate.onPause();
            }
        } catch (Throwable th) {
            gl.I(Code, "onPause " + th.getClass().getSimpleName());
        }
    }

    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
        gl.V(Code, "onRestart, hasPause= %s", Boolean.valueOf(this.B));
        if (this.B) {
            finish();
        }
        try {
            IRemoteViewDelegate iRemoteViewDelegate = this.V;
            if (iRemoteViewDelegate != null) {
                iRemoteViewDelegate.onRestart();
            }
        } catch (Throwable th) {
            gl.I(Code, "onRestart " + th.getClass().getSimpleName());
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        gl.V(Code, "onResume, hasPause= %s", Boolean.valueOf(this.B));
        if (this.B) {
            finish();
        }
        try {
            IRemoteViewDelegate iRemoteViewDelegate = this.V;
            if (iRemoteViewDelegate != null) {
                iRemoteViewDelegate.onResume();
            }
        } catch (Throwable th) {
            gl.I(Code, "onResume " + th.getClass().getSimpleName());
        }
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        try {
            IRemoteViewDelegate iRemoteViewDelegate = this.V;
            if (iRemoteViewDelegate != null) {
                iRemoteViewDelegate.onStart();
            }
        } catch (Throwable th) {
            gl.I(Code, "onStart " + th.getClass().getSimpleName());
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        gl.V(Code, "onStop");
        try {
            IRemoteViewDelegate iRemoteViewDelegate = this.V;
            if (iRemoteViewDelegate != null) {
                iRemoteViewDelegate.onStop();
            }
        } catch (Throwable th) {
            gl.I(Code, "onStop " + th.getClass().getSimpleName());
        }
        finish();
    }
}
