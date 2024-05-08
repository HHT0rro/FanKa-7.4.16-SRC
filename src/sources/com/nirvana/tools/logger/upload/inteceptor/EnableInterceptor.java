package com.nirvana.tools.logger.upload.inteceptor;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class EnableInterceptor implements BaseInterceptor {
    private boolean mEnabled;

    @Override // com.nirvana.tools.logger.upload.inteceptor.BaseInterceptor
    public boolean isAllowUploading() {
        return this.mEnabled;
    }

    public void setEnabled(boolean z10) {
        this.mEnabled = z10;
    }
}
