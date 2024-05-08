package com.huawei.flexiblelayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.flexiblelayout.services.configuration.ConfigurationService;
import com.huawei.flexiblelayout.services.configuration.ServerUrlProvider;
import java.util.HashMap;

/* compiled from: ConfigurationServiceImpl.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class l1 implements ConfigurationService {

    /* renamed from: a, reason: collision with root package name */
    private final HashMap<ConfigurationService.Alias, ServerUrlProvider> f28193a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private final Object f28194b = new Object();

    @Override // com.huawei.flexiblelayout.services.configuration.ConfigurationService
    @Nullable
    public ServerUrlProvider getServerUrlProvider(@NonNull ConfigurationService.Alias alias) {
        ServerUrlProvider serverUrlProvider;
        synchronized (this.f28194b) {
            serverUrlProvider = this.f28193a.get(alias);
        }
        return serverUrlProvider;
    }

    @Override // com.huawei.flexiblelayout.services.configuration.ConfigurationService
    public void registerServerUrlProvider(@NonNull ConfigurationService.Alias alias, @Nullable ServerUrlProvider serverUrlProvider) {
        synchronized (this.f28194b) {
            this.f28193a.put(alias, serverUrlProvider);
        }
    }
}
