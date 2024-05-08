package com.tencent.open.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.open.log.SLog;
import java.lang.ref.WeakReference;
import java.net.URL;

/* compiled from: ProGuard */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private static h f45307a;

    /* renamed from: b, reason: collision with root package name */
    private volatile WeakReference<SharedPreferences> f45308b = null;

    public static synchronized h a() {
        h hVar;
        synchronized (h.class) {
            if (f45307a == null) {
                f45307a = new h();
            }
            hVar = f45307a;
        }
        return hVar;
    }

    public String a(Context context, String str) {
        if (this.f45308b == null || this.f45308b.get() == null) {
            this.f45308b = new WeakReference<>(context.getSharedPreferences("ServerPrefs", 0));
        }
        try {
            String host = new URL(str).getHost();
            if (host == null) {
                SLog.e("openSDK_LOG.ServerSetting", "Get host error. url=" + str);
                return str;
            }
            String string = this.f45308b.get().getString(host, null);
            if (string != null && !host.equals(string)) {
                String replace = str.replace(host, string);
                SLog.v("openSDK_LOG.ServerSetting", "return environment url : " + replace);
                return replace;
            }
            SLog.v("openSDK_LOG.ServerSetting", "host=" + host + ", envHost=" + string);
            return str;
        } catch (Exception e2) {
            SLog.e("openSDK_LOG.ServerSetting", "getEnvUrl url=" + str + "error.: " + e2.getMessage());
            return str;
        }
    }
}
