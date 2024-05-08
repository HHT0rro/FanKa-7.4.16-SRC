package com.huawei.qcardsupport.qcard.cardmanager.impl;

import androidx.annotation.NonNull;
import com.huawei.flexiblelayout.FLEngine;
import com.huawei.flexiblelayout.log.Log;
import com.huawei.flexiblelayout.services.configuration.ConfigurationService;
import com.huawei.flexiblelayout.services.configuration.ServerUrlProvider;
import com.huawei.quickcard.base.grs.CardServerConfig;
import com.huawei.quickcard.base.http.CardHttpAdapter;
import com.huawei.quickcard.base.interfaces.ICardHAUrl;
import com.huawei.quickcard.base.log.CardLogUtils;
import com.huawei.quickcard.base.log.ILogAdapter;
import com.huawei.quickcard.flnetworkadapter.FlexLayoutHttpClient;

/* compiled from: ModuleInit.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private static volatile boolean f33223a;

    /* compiled from: ModuleInit.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a implements ILogAdapter {
        @Override // com.huawei.quickcard.base.log.ILogAdapter
        public void print(int i10, @NonNull String str, String str2, Throwable th) {
            Log.println(i10, str, str2, th);
        }
    }

    /* compiled from: ModuleInit.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class b implements ICardHAUrl {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FLEngine f33224a;

        public b(FLEngine fLEngine) {
            this.f33224a = fLEngine;
        }

        @Override // com.huawei.quickcard.base.interfaces.ICardHAUrl
        public String getHAUrl() {
            String url;
            ServerUrlProvider serverUrlProvider = ((ConfigurationService) this.f33224a.getService(ConfigurationService.class)).getServerUrlProvider(ConfigurationService.Alias.HI_ANALYTICS);
            return (serverUrlProvider == null || (url = serverUrlProvider.getUrl()) == null) ? "" : url;
        }
    }

    private e() {
    }

    public static void a(@NonNull FLEngine fLEngine) {
        if (f33223a) {
            return;
        }
        synchronized (e.class) {
            if (!f33223a) {
                a();
                b(fLEngine);
                CardHttpAdapter.setClient(FlexLayoutHttpClient.class);
            }
            f33223a = true;
        }
    }

    private static void b(@NonNull FLEngine fLEngine) {
        CardServerConfig.setMode(0);
        CardServerConfig.setHAUrl(new b(fLEngine));
    }

    private static void a() {
        CardLogUtils.addEngineLogAdapter(new a());
    }
}
