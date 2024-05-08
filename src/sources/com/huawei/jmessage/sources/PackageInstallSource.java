package com.huawei.jmessage.sources;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.huawei.flexiblelayout.data.primitive.FLMap;
import com.huawei.flexiblelayout.log.Log;
import com.huawei.hmf.orb.IMessageEntity;
import com.huawei.jmessage.api.EventCallback;
import com.huawei.jmessage.api.EventSource;
import com.huawei.jmessage.api.Subscriber;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class PackageInstallSource extends EventSource {
    public static final String TOPIC = "PackageInstall";

    /* renamed from: c, reason: collision with root package name */
    private static final String f32078c = "PackageInstallSource";

    /* renamed from: a, reason: collision with root package name */
    private Context f32079a;

    /* renamed from: b, reason: collision with root package name */
    private BroadcastReceiver f32080b;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class InstallState implements IMessageEntity {
        public String packageName;
        public int state;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                PackageInstallSource.this.c(intent);
            }
        }
    }

    public PackageInstallSource(Context context) {
        this.f32079a = context.getApplicationContext();
    }

    private String b(Intent intent) {
        Uri data = intent.getData();
        return data != null ? data.getEncodedSchemeSpecificPart() : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void c(android.content.Intent r3) {
        /*
            r2 = this;
            int r0 = r2.a(r3)     // Catch: java.lang.Exception -> L1d
            java.lang.String r3 = r2.b(r3)     // Catch: java.lang.Exception -> L1d
            r1 = -1
            if (r0 == r1) goto L1c
            boolean r1 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Exception -> L1d
            if (r1 == 0) goto L12
            goto L1c
        L12:
            com.huawei.jmessage.sources.PackageInstallSource$InstallState r1 = new com.huawei.jmessage.sources.PackageInstallSource$InstallState     // Catch: java.lang.Exception -> L1d
            r1.<init>()     // Catch: java.lang.Exception -> L1d
            r1.state = r0     // Catch: java.lang.Exception -> L1e
            r1.packageName = r3     // Catch: java.lang.Exception -> L1e
            goto L25
        L1c:
            return
        L1d:
            r1 = 0
        L1e:
            java.lang.String r3 = "PackageInstallSource"
            java.lang.String r0 = "Exception when receiving 'android.intent.action.PACKAGE_XX'."
            com.huawei.flexiblelayout.log.Log.e(r3, r0)
        L25:
            if (r1 == 0) goto L2a
            r2.fire(r1)
        L2a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.jmessage.sources.PackageInstallSource.c(android.content.Intent):void");
    }

    @Override // com.huawei.jmessage.api.EventSource
    public boolean onDispatch(@NonNull Subscriber subscriber, @NonNull EventCallback.Message message) {
        if (!(message.payload instanceof InstallState)) {
            Log.e(f32078c, "This type of payload is not supported, expected InstallState.");
            return false;
        }
        String optString = subscriber.getParam() instanceof FLMap ? ((FLMap) subscriber.getParam()).optString("packageName") : "";
        return TextUtils.isEmpty(optString) || optString.equals(((InstallState) message.payload).packageName);
    }

    @Override // com.huawei.jmessage.api.EventSource
    public void onInitialize(EventSource.Firer firer) {
        super.onInitialize(firer);
        Log.i(f32078c, "onInitialize, PackageInstall");
        if (this.f32079a != null) {
            a aVar = new a();
            this.f32080b = aVar;
            this.f32079a.registerReceiver(aVar, a());
        }
    }

    @Override // com.huawei.jmessage.api.EventSource
    public void onRelease() {
        BroadcastReceiver broadcastReceiver;
        Log.i(f32078c, "onRelease, PackageInstall");
        Context context = this.f32079a;
        if (context == null || (broadcastReceiver = this.f32080b) == null) {
            return;
        }
        try {
            context.unregisterReceiver(broadcastReceiver);
        } catch (Exception unused) {
        }
    }

    private static IntentFilter a() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addDataScheme("package");
        return intentFilter;
    }

    private int a(Intent intent) {
        if ("android.intent.action.PACKAGE_ADDED".equals(intent.getAction())) {
            return 1;
        }
        return (!"android.intent.action.PACKAGE_REMOVED".equals(intent.getAction()) || intent.getBooleanExtra("android.intent.extra.REPLACING", false)) ? -1 : 0;
    }
}
