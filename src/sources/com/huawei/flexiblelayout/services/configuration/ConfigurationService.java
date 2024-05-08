package com.huawei.flexiblelayout.services.configuration;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface ConfigurationService {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public enum Alias {
        HI_ANALYTICS
    }

    @Nullable
    ServerUrlProvider getServerUrlProvider(@NonNull Alias alias);

    void registerServerUrlProvider(@NonNull Alias alias, @Nullable ServerUrlProvider serverUrlProvider);
}
