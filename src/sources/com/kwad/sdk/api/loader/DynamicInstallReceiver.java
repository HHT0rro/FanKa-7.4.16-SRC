package com.kwad.sdk.api.loader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Build;
import androidx.annotation.Keep;
import com.huawei.openalliance.ad.constant.bg;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

@Keep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class DynamicInstallReceiver extends BroadcastReceiver {
    private static final AtomicBoolean HAS_REGISTER = new AtomicBoolean(false);
    private static final String TAG = "KSAd_DYI";

    @Keep
    public static void registerToApp(Context context) {
        if (context != null) {
            AtomicBoolean atomicBoolean = HAS_REGISTER;
            if (atomicBoolean.get() || context.getApplicationContext() == null) {
                return;
            }
            String str = context.getPackageName() + ".loader.install.DynamicApk";
            new StringBuilder("registerToApp action:").append(str);
            IntentFilter intentFilter = new IntentFilter(str);
            Context applicationContext = context.getApplicationContext();
            if (Build.VERSION.SDK_INT >= 33) {
                applicationContext.registerReceiver(new DynamicInstallReceiver(), intentFilter, 2);
            } else {
                applicationContext.registerReceiver(new DynamicInstallReceiver(), intentFilter);
            }
            atomicBoolean.set(true);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra("apkPath");
        final String stringExtra2 = intent.getStringExtra(bg.e.Code);
        final File file = new File(stringExtra);
        if (!file.exists()) {
            new StringBuilder("downloadFile not exists: ").append((Object) file);
            return;
        }
        StringBuilder sb2 = new StringBuilder("downloadFile is exists, apkPath :");
        sb2.append(stringExtra);
        sb2.append(" sdkVersion:");
        sb2.append(stringExtra2);
        AsyncTask.execute(new Runnable() { // from class: com.kwad.sdk.api.loader.DynamicInstallReceiver.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    if (b.a(context, AnonymousClass1.class.getClassLoader(), file.getPath(), stringExtra2)) {
                        g.n(context, stringExtra2);
                        h.h(file);
                    }
                } catch (Exception e2) {
                    new StringBuilder("onReceive ApkInstaller installApk error:").append((Object) e2);
                    e2.printStackTrace();
                }
            }
        });
    }
}
