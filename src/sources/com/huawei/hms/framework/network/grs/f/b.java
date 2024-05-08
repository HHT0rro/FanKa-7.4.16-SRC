package com.huawei.hms.framework.network.grs.f;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.AssetsUtil;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    private static final Map<String, b> f29966b = new ConcurrentHashMap(16);

    /* renamed from: c, reason: collision with root package name */
    private static final Object f29967c = new Object();

    /* renamed from: a, reason: collision with root package name */
    private a f29968a;

    public b(Context context, boolean z10) {
        a(context, z10);
        f29966b.put(context.getPackageName(), this);
    }

    public static b a(String str) {
        return f29966b.get(str);
    }

    private void a(Context context, boolean z10) {
        String[] split;
        long currentTimeMillis = System.currentTimeMillis();
        String a10 = com.huawei.hms.framework.network.grs.h.c.a("grs_route_config_files_list.txt", context);
        Logger.i("LocalManagerProxy", "initLocalManager configFileListContent TimeCost:%d  Content:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), a10);
        if (TextUtils.isEmpty(a10)) {
            long currentTimeMillis2 = System.currentTimeMillis();
            split = AssetsUtil.list(context, GrsApp.getInstance().getBrand(""));
            Logger.i("LocalManagerProxy", "list by AssetsManager, timeCost:" + (System.currentTimeMillis() - currentTimeMillis2));
        } else {
            split = a10.split("#");
        }
        List<String> arrayList = split == null ? new ArrayList<>() : Arrays.asList(split);
        String appConfigName = GrsApp.getInstance().getAppConfigName();
        Logger.i("LocalManagerProxy", "appConfigName is: " + appConfigName);
        this.f29968a = new d(false, z10);
        if (arrayList.contains("grs_app_global_route_config.json") || !TextUtils.isEmpty(appConfigName)) {
            this.f29968a = new d(context, appConfigName, z10);
        }
        if (!this.f29968a.c() && arrayList.contains("grs_sdk_global_route_config.json")) {
            this.f29968a = new c(context, z10);
        }
        this.f29968a.a(context, arrayList);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("on initLocalManager finish, check appGrs: ");
        sb2.append(this.f29968a.f29961a == null);
        Logger.i("LocalManagerProxy", sb2.toString());
    }

    public com.huawei.hms.framework.network.grs.local.model.a a() {
        return this.f29968a.a();
    }

    public String a(Context context, com.huawei.hms.framework.network.grs.e.a aVar, GrsBaseInfo grsBaseInfo, String str, String str2, boolean z10) {
        String a10;
        synchronized (f29967c) {
            a10 = this.f29968a.a(context, aVar, grsBaseInfo, str, str2, z10);
        }
        return a10;
    }

    public Map<String, String> a(Context context, com.huawei.hms.framework.network.grs.e.a aVar, GrsBaseInfo grsBaseInfo, String str, boolean z10) {
        Map<String, String> a10;
        synchronized (f29967c) {
            a10 = this.f29968a.a(context, aVar, grsBaseInfo, str, z10);
        }
        return a10;
    }

    public Set<String> b() {
        return this.f29968a.b();
    }
}
