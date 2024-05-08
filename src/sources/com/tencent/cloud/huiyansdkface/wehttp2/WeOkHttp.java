package com.tencent.cloud.huiyansdkface.wehttp2;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.cloud.huiyansdkface.okhttp3.Call;
import com.tencent.cloud.huiyansdkface.okhttp3.OkHttpClient;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class WeOkHttp {

    /* renamed from: a, reason: collision with root package name */
    private static Handler f42401a = new Handler(Looper.getMainLooper());

    /* renamed from: b, reason: collision with root package name */
    private WeConfig f42402b;

    public WeOkHttp() {
        this.f42402b = new WeConfig();
    }

    public WeOkHttp(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("savedConfigName is empty");
        }
        this.f42402b = new WeConfig(context, str);
    }

    public WeOkHttp(WeConfigLoader weConfigLoader) {
        this.f42402b = new WeConfig(weConfigLoader);
    }

    public WeOkHttp(String str) {
        this(null, str);
    }

    private void a(Object obj, List<Call> list) {
        for (int i10 = 0; i10 < list.size(); i10++) {
            Call call = list.get(i10);
            if (obj != null && obj.equals(call.request().tag())) {
                call.cancel();
            }
        }
    }

    public static void runUi(Runnable runnable) {
        if (runnable != null) {
            f42401a.post(runnable);
        }
    }

    public void cancel(Object obj) {
        if (obj == null) {
            client().dispatcher().cancelAll();
        } else {
            a(obj, this.f42402b.client().dispatcher().runningCalls());
            a(obj, this.f42402b.client().dispatcher().queuedCalls());
        }
    }

    public OkHttpClient client() {
        return this.f42402b.client();
    }

    public WeConfig config() {
        if (this.f42402b == null) {
            this.f42402b = new WeConfig();
        }
        return this.f42402b;
    }

    public BodyReq delete(String str) {
        return new BodyReq(this, "DELETE", str);
    }

    public SimpleReq get(String str) {
        return new SimpleReq(this, "GET", str);
    }

    public SimpleReq head(String str) {
        return new SimpleReq(this, "HEAD", str);
    }

    @Deprecated
    public WeConfig init() {
        return config();
    }

    public BodyReq patch(String str) {
        return new BodyReq(this, "PATCH", str);
    }

    public BodyReq post(String str) {
        return new BodyReq(this, "POST", str);
    }

    public BodyReq put(String str) {
        return new BodyReq(this, "PUT", str);
    }
}
