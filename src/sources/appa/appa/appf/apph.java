package appa.appa.appf;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.wangmai.appsdkdex.TransActivity;
import com.wangmai.common.utils.MessageEvent;
import com.wangmai.common.utils.ThreadUtils;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* compiled from: TransActivityWrapper.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class apph {
    private static final String appd = "apph";

    /* renamed from: appa, reason: collision with root package name */
    private Activity f1019appa;
    private int appb;
    boolean appc = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: TransActivityWrapper.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appa implements Runnable {

        /* renamed from: appa, reason: collision with root package name */
        final /* synthetic */ Intent f1020appa;

        appa(Intent intent) {
            this.f1020appa = intent;
        }

        @Override // java.lang.Runnable
        public void run() {
            appd.appa(apph.appd, "延迟50ms，再次唤醒");
            try {
                apph.this.f1019appa.startActivity(this.f1020appa);
                apph.this.appc = true;
            } catch (Throwable th) {
                appd.appe(apph.appd, "延迟50ms，再次唤醒失败:" + th.getMessage());
                apph.this.appc = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: TransActivityWrapper.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appb implements Runnable {
        appb() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (apph.this.appc) {
                appd.appc(apph.appd, "延迟50ms，获取最终唤醒结果：唤醒成功");
                MessageEvent.notify(MessageEvent.EVENT_SUCCESS);
            } else {
                appd.appe(apph.appd, "延迟50ms，获取最终唤醒结果：唤醒失败");
                MessageEvent.notify(MessageEvent.EVENT_FAIL);
            }
        }
    }

    private void appc() {
        ThreadUtils.mMainHandler.postDelayed(new appb(), 100L);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(6:7|(5:12|13|14|15|16)|21|22|23|16) */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0094, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0095, code lost:
    
        appa.appa.appf.appd.appe(appa.appa.appf.apph.appd, "唤醒失败：" + r3);
        r8.appc = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void appd() {
        /*
            r8 = this;
            r0 = 1
            r1 = 2
            r2 = 0
            android.app.Activity r3 = r8.f1019appa     // Catch: java.lang.Throwable -> Lbd
            android.content.Intent r3 = r3.getIntent()     // Catch: java.lang.Throwable -> Lbd
            java.lang.String r4 = "dp_url"
            java.lang.String r3 = r3.getStringExtra(r4)     // Catch: java.lang.Throwable -> Lbd
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> Lbd
            if (r4 != 0) goto L1a
            android.content.Intent r3 = appa(r3)     // Catch: java.lang.Throwable -> Lbd
            goto L28
        L1a:
            android.app.Activity r3 = r8.f1019appa     // Catch: java.lang.Throwable -> Lbd
            android.content.Intent r3 = r3.getIntent()     // Catch: java.lang.Throwable -> Lbd
            java.lang.String r4 = "target_intent"
            android.os.Parcelable r3 = r3.getParcelableExtra(r4)     // Catch: java.lang.Throwable -> Lbd
            android.content.Intent r3 = (android.content.Intent) r3     // Catch: java.lang.Throwable -> Lbd
        L28:
            if (r3 == 0) goto Lda
            boolean r4 = appa.appa.appf.appg.appa()     // Catch: java.lang.Throwable -> Lbd
            if (r4 != 0) goto L7f
            boolean r4 = appa.appa.appf.appg.appb()     // Catch: java.lang.Throwable -> Lbd
            if (r4 == 0) goto L37
            goto L7f
        L37:
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> Lbd
            java.lang.String r5 = appa.appa.appf.apph.appd     // Catch: java.lang.Throwable -> Lbd
            r4[r2] = r5     // Catch: java.lang.Throwable -> Lbd
            java.lang.String r5 = "startActivities"
            r4[r0] = r5     // Catch: java.lang.Throwable -> Lbd
            appa.appa.appf.appd.appa(r4)     // Catch: java.lang.Throwable -> Lbd
            android.content.Intent r4 = new android.content.Intent     // Catch: java.lang.Throwable -> Lbd
            android.app.Activity r5 = r8.f1019appa     // Catch: java.lang.Throwable -> Lbd
            java.lang.Class<com.wangmai.appsdkdex.TransActivity> r6 = com.wangmai.appsdkdex.TransActivity.class
            r4.<init>(r5, r6)     // Catch: java.lang.Throwable -> Lbd
            java.lang.String r5 = "source_from"
            r4.putExtra(r5, r1)     // Catch: java.lang.Throwable -> Lbd
            android.app.Activity r5 = r8.f1019appa     // Catch: java.lang.Throwable -> L5e
            android.content.Intent[] r6 = new android.content.Intent[r1]     // Catch: java.lang.Throwable -> L5e
            r6[r2] = r3     // Catch: java.lang.Throwable -> L5e
            r6[r0] = r4     // Catch: java.lang.Throwable -> L5e
            r5.startActivities(r6)     // Catch: java.lang.Throwable -> L5e
            goto L7b
        L5e:
            r4 = move-exception
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> Lbd
            java.lang.String r6 = appa.appa.appf.apph.appd     // Catch: java.lang.Throwable -> Lbd
            r5[r2] = r6     // Catch: java.lang.Throwable -> Lbd
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lbd
            r6.<init>()     // Catch: java.lang.Throwable -> Lbd
            java.lang.String r7 = "静默唤醒失败:"
            r6.append(r7)     // Catch: java.lang.Throwable -> Lbd
            r6.append(r4)     // Catch: java.lang.Throwable -> Lbd
            java.lang.String r4 = r6.toString()     // Catch: java.lang.Throwable -> Lbd
            r5[r0] = r4     // Catch: java.lang.Throwable -> Lbd
            appa.appa.appf.appd.appe(r5)     // Catch: java.lang.Throwable -> Lbd
        L7b:
            r8.appb(r3)     // Catch: java.lang.Throwable -> Lbd
            goto Lb7
        L7f:
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L94
            java.lang.String r5 = appa.appa.appf.apph.appd     // Catch: java.lang.Throwable -> L94
            r4[r2] = r5     // Catch: java.lang.Throwable -> L94
            java.lang.String r5 = "startActivity"
            r4[r0] = r5     // Catch: java.lang.Throwable -> L94
            appa.appa.appf.appd.appa(r4)     // Catch: java.lang.Throwable -> L94
            android.app.Activity r4 = r8.f1019appa     // Catch: java.lang.Throwable -> L94
            r4.startActivity(r3)     // Catch: java.lang.Throwable -> L94
            r8.appc = r0     // Catch: java.lang.Throwable -> L94
            goto Lb3
        L94:
            r3 = move-exception
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> Lbd
            java.lang.String r5 = appa.appa.appf.apph.appd     // Catch: java.lang.Throwable -> Lbd
            r4[r2] = r5     // Catch: java.lang.Throwable -> Lbd
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lbd
            r5.<init>()     // Catch: java.lang.Throwable -> Lbd
            java.lang.String r6 = "唤醒失败："
            r5.append(r6)     // Catch: java.lang.Throwable -> Lbd
            r5.append(r3)     // Catch: java.lang.Throwable -> Lbd
            java.lang.String r3 = r5.toString()     // Catch: java.lang.Throwable -> Lbd
            r4[r0] = r3     // Catch: java.lang.Throwable -> Lbd
            appa.appa.appf.appd.appe(r4)     // Catch: java.lang.Throwable -> Lbd
            r8.appc = r2     // Catch: java.lang.Throwable -> Lbd
        Lb3:
            r3 = 0
            r8.appb(r3)     // Catch: java.lang.Throwable -> Lbd
        Lb7:
            android.app.Activity r3 = r8.f1019appa     // Catch: java.lang.Throwable -> Lbd
            r3.overridePendingTransition(r2, r2)     // Catch: java.lang.Throwable -> Lbd
            goto Lda
        Lbd:
            r3 = move-exception
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r4 = appa.appa.appf.apph.appd
            r1[r2] = r4
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "openTargetIntent error:"
            r2.append(r4)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1[r0] = r2
            appa.appa.appf.appd.appe(r1)
        Lda:
            r8.appa()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: appa.appa.appf.apph.appd():void");
    }

    private void appe() {
        try {
            appa();
            Intent intent = new Intent(this.f1019appa, (Class<?>) TransActivity.class);
            intent.putExtra("source_from", 0);
            this.f1019appa.startActivity(intent);
            this.f1019appa.overridePendingTransition(0, 0);
        } catch (Throwable th) {
            appd.appe(appd, "openTransActivity error:" + th);
        }
    }

    private void appb(Intent intent) {
        if (!appg.appa() && !appg.appb()) {
            appa(intent);
            appc();
        } else {
            appc();
        }
    }

    public void appa(Activity activity) {
        try {
            if (activity == null) {
                appd.appe(appd, "activity为空");
                MessageEvent.notify(MessageEvent.EVENT_FAIL);
                return;
            }
            this.f1019appa = activity;
            this.appb = activity.getIntent().getIntExtra("source_from", 0);
            int i10 = this.appb;
            if (i10 == 1) {
                appd();
            } else if (i10 != 2) {
                appa();
            } else {
                appe();
            }
        } catch (Throwable th) {
            appd.appe(appd, "dispatchAction error:" + th);
            MessageEvent.notify(MessageEvent.EVENT_FAIL);
        }
    }

    public static Intent appa(String str) {
        try {
            appd.appa(appd, "buildIntent");
            Uri parse = Uri.parse(str);
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setFlags(268435456);
            intent.setData(parse);
            return intent;
        } catch (Throwable th) {
            appd.appa(appd, "buildIntent error:" + th);
            return null;
        }
    }

    void appa() {
        try {
            this.f1019appa.finish();
            this.f1019appa.overridePendingTransition(0, 0);
        } catch (Throwable th) {
            appd.appe(appd, "finish error:" + th);
        }
    }

    private void appa(Intent intent) {
        ThreadUtils.mMainHandler.postDelayed(new appa(intent), 50L);
    }
}
