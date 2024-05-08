package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import com.alipay.sdk.util.l;
import com.baidu.mobads.sdk.internal.by;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class AlipayResultActivity extends Activity {

    /* renamed from: a, reason: collision with root package name */
    public static final int f4352a = 9000;

    /* renamed from: b, reason: collision with root package name */
    public static final int f4353b = 5000;

    /* renamed from: c, reason: collision with root package name */
    public static final int f4354c = 4000;

    /* renamed from: e, reason: collision with root package name */
    private static final Map<String, WeakReference<a>> f4356e = new ConcurrentHashMap();

    /* renamed from: d, reason: collision with root package name */
    public static final ConcurrentHashMap<String, WeakReference<b>> f4355d = new ConcurrentHashMap<>();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface a {
        void a(int i10, String str, Bundle bundle);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface b {
        void a(int i10, String str, String str2);
    }

    public static void a(String str, int i10, String str2, Bundle bundle) {
        Map<String, WeakReference<a>> map = f4356e;
        WeakReference<a> weakReference = map.get(str);
        if (weakReference == null) {
            return;
        }
        map.remove(str);
        a aVar = weakReference.get();
        if (aVar != null) {
            aVar.a(i10, str2, bundle);
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        JSONObject jSONObject;
        Bundle bundle2;
        super.onCreate(bundle);
        com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.f4432b, "BSPReturned", "");
        Intent intent = getIntent();
        try {
            String stringExtra = intent.getStringExtra("session");
            Bundle bundleExtra = intent.getBundleExtra("result");
            String stringExtra2 = intent.getStringExtra("scene");
            com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.f4432b, "BSPSession", stringExtra);
            if (TextUtils.equals("mqpSchemePay", stringExtra2)) {
                a(stringExtra, bundleExtra);
                return;
            }
            if ((TextUtils.isEmpty(stringExtra) || bundleExtra == null) && intent.getData() != null) {
                try {
                    JSONObject jSONObject2 = new JSONObject(new String(Base64.decode(intent.getData().getQuery(), 2), "UTF-8"));
                    jSONObject = jSONObject2.getJSONObject("result");
                    stringExtra = jSONObject2.getString("session");
                    com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.f4432b, "BSPUriSession", stringExtra);
                    bundle2 = new Bundle();
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        bundle2.putString(next, jSONObject.getString(next));
                    }
                    bundleExtra = bundle2;
                } catch (Throwable th2) {
                    th = th2;
                    bundleExtra = bundle2;
                    com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.f4432b, "BSPResEx", th);
                    if (TextUtils.isEmpty(stringExtra)) {
                    }
                    return;
                }
            }
            if (!TextUtils.isEmpty(stringExtra) || bundleExtra == null) {
                return;
            }
            try {
                a(stringExtra, 9000, by.f9988k, bundleExtra);
            } finally {
                com.alipay.sdk.app.statistic.a.b(this, "");
                finish();
            }
        } catch (Throwable th3) {
            com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.f4432b, "BSPSerError", th3);
            finish();
        }
    }

    private void a(String str, Bundle bundle) {
        b bVar;
        ConcurrentHashMap<String, WeakReference<b>> concurrentHashMap = f4355d;
        WeakReference<b> weakReference = concurrentHashMap.get(str);
        if (weakReference != null) {
            bVar = weakReference.get();
            concurrentHashMap.remove(str);
        } else {
            bVar = null;
        }
        if (bVar == null) {
            return;
        }
        try {
            bVar.a(bundle.getInt("endCode"), bundle.getString(l.f4747b), bundle.getString("result"));
        } finally {
            finish();
        }
    }
}
