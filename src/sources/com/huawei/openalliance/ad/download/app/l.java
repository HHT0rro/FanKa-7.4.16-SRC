package com.huawei.openalliance.ad.download.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.huawei.hms.ads.gl;
import com.huawei.hms.ads.kv;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class l {
    private static l B = null;
    private static final String Code = "GPDownloadManager";
    private static final int V = 900000;
    private Context C;
    private static final byte[] I = new byte[0];
    private static final byte[] Z = new byte[0];
    private Map<String, AppDownloadTask> S = new ConcurrentHashMap();
    private BroadcastReceiver F = new BroadcastReceiver() { // from class: com.huawei.openalliance.ad.download.app.l.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            String dataString = intent.getDataString();
            if (TextUtils.isEmpty(dataString)) {
                gl.I(l.Code, "itRer dataString is empty");
                return;
            }
            String substring = dataString.substring(8);
            try {
                if ("android.intent.action.PACKAGE_ADDED".equals(intent.getAction())) {
                    l.this.Code(substring);
                }
            } catch (Throwable th) {
                gl.I(l.Code, "itRer: %s", th.getClass().getSimpleName());
            }
        }
    };

    private l(Context context) {
        this.C = context.getApplicationContext();
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        this.C.registerReceiver(this.F, intentFilter);
    }

    public static l Code(Context context) {
        l lVar;
        synchronized (I) {
            if (B == null) {
                B = new l(context);
            }
            lVar = B;
        }
        return lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(String str) {
        gl.V(Code, "dealWithAdd");
        synchronized (Z) {
            if (this.S.containsKey(str)) {
                AppDownloadTask appDownloadTask = this.S.get(str);
                this.S.remove(str);
                gl.V(Code, "task size after remove: %s", Integer.valueOf(this.S.size()));
                AdContentData f10 = appDownloadTask.f();
                if (f10 != null && f10.u() != null) {
                    kv.Code(this.C, f10, appDownloadTask.b(), f10.u().i());
                }
            }
        }
    }

    public void Code(String str, AppDownloadTask appDownloadTask) {
        synchronized (Z) {
            gl.Code(Code, "task size before: %s", Integer.valueOf(this.S.size()));
            for (Map.Entry entry : new ConcurrentHashMap(this.S).entrySet()) {
                gl.Code(Code, "entry key: %s time: %s", entry.getKey(), Long.valueOf(((AppDownloadTask) entry.getValue()).o()));
                if (System.currentTimeMillis() - ((AppDownloadTask) entry.getValue()).o() > 900000) {
                    this.S.remove(entry.getKey());
                }
            }
            this.S.put(str, appDownloadTask);
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(this.S.size());
            objArr[1] = str;
            objArr[2] = this.S.get(str) != null ? Long.valueOf(this.S.get(str).o()) : null;
            gl.V(Code, "task size after: %s, packageName: %s time: %s", objArr);
        }
    }
}
