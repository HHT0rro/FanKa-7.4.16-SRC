package com.kwad.components.offline.api.core.api;

import com.kwad.sdk.commercial.c;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface ILoggerReporter {

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public @interface Category {
        public static final String APM_LOG = "ad_client_apm_log";
        public static final String ERROR_LOG = "ad_client_error_log";
    }

    void reportEvent(c cVar);
}
