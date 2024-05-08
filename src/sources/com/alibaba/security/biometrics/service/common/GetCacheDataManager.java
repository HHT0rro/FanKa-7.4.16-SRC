package com.alibaba.security.biometrics.service.common;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class GetCacheDataManager {
    private static volatile GetCacheDataManager mInstance;
    private String mUmidToken;
    private boolean mUseHwMagicWindow;
    private long uploadTimeOut = 30;

    private GetCacheDataManager() {
    }

    public static GetCacheDataManager getInstance() {
        if (mInstance == null) {
            synchronized (GetCacheDataManager.class) {
                if (mInstance == null) {
                    mInstance = new GetCacheDataManager();
                }
            }
        }
        return mInstance;
    }

    public String getUmidToken() {
        return this.mUmidToken;
    }

    public long getUploadTimeOut() {
        return this.uploadTimeOut;
    }

    public boolean getUseHwMagicWindow() {
        return this.mUseHwMagicWindow;
    }

    public void setUmidToken(String str) {
        this.mUmidToken = str;
    }

    public void setUploadTimeOut(String str) {
        try {
            this.uploadTimeOut = Long.parseLong(str);
        } catch (Throwable unused) {
            this.uploadTimeOut = 30L;
        }
    }

    public void setUseHwMagicWindow(boolean z10) {
        this.mUseHwMagicWindow = z10;
    }
}
