package com.nirvana.tools.logger.env;

import com.nirvana.tools.logger.model.ACMLimitConfig;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface ACMComponent {
    void clearLimitConfig();

    void setLimitConfig(ACMLimitConfig aCMLimitConfig);

    void setUploadEnabled(boolean z10);

    void uploadFailed();
}
