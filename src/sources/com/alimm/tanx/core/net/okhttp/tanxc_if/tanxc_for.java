package com.alimm.tanx.core.net.okhttp.tanxc_if;

import com.alimm.tanx.core.TanxCoreManager;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.NetWorkUtil;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* compiled from: OfflineCacheInterceptor.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class tanxc_for implements Interceptor {
    public static tanxc_for tanxc_do;
    public int tanxc_if;

    public static tanxc_for tanxc_do() {
        if (tanxc_do == null) {
            synchronized (tanxc_for.class) {
                if (tanxc_do == null) {
                    tanxc_do = new tanxc_for();
                }
            }
        }
        return tanxc_do;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        LogUtils.d("OfflineCacheInterceptor", "start");
        Request request = chain.request();
        if (!NetWorkUtil.isNetworkConnected(TanxCoreManager.getInstance().getAppContext())) {
            LogUtils.d("OfflineCacheInterceptor", "没网络 offlineCacheTime：" + this.tanxc_if);
            int i10 = this.tanxc_if;
            if (i10 != 0) {
                request = request.newBuilder().header("Cache-Control", "public, only-if-cached, max-stale=" + i10).build();
                this.tanxc_if = 0;
            } else {
                request = request.newBuilder().header("Cache-Control", "no-cache").build();
            }
        }
        String str = "return 前：";
        try {
            str = "return 前：" + request.url().host() + request.url().url().getFile();
        } catch (Exception e2) {
            LogUtils.e("OfflineCacheInterceptor", e2);
        }
        LogUtils.d("OfflineCacheInterceptor", str);
        return chain.proceed(request);
    }

    public void tanxc_do(int i10) {
        this.tanxc_if = i10;
    }
}
