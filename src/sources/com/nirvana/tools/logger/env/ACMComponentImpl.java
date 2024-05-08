package com.nirvana.tools.logger.env;

import com.nirvana.tools.logger.model.ACMLimitConfig;
import com.nirvana.tools.logger.upload.AbstractACMUploadManager;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class ACMComponentImpl implements ACMComponent {
    private AbstractACMUploadManager mUploadManager;

    public ACMComponentImpl(AbstractACMUploadManager abstractACMUploadManager) {
        this.mUploadManager = abstractACMUploadManager;
    }

    @Override // com.nirvana.tools.logger.env.ACMComponent
    public void clearLimitConfig() {
        this.mUploadManager.clearLimitConfig();
    }

    @Override // com.nirvana.tools.logger.env.ACMComponent
    public void setLimitConfig(ACMLimitConfig aCMLimitConfig) {
        this.mUploadManager.setLimitConfig(aCMLimitConfig);
    }

    @Override // com.nirvana.tools.logger.env.ACMComponent
    public void setUploadEnabled(boolean z10) {
        this.mUploadManager.setUploadEnable(z10);
    }

    @Override // com.nirvana.tools.logger.env.ACMComponent
    public void uploadFailed() {
        this.mUploadManager.uploadFailed();
    }
}
