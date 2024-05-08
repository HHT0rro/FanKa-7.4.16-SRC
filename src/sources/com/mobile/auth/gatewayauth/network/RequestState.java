package com.mobile.auth.gatewayauth.network;

import android.text.TextUtils;
import com.mobile.auth.gatewayauth.ExceptionProcessor;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class RequestState {
    private static volatile RequestState mInstance;
    private boolean useRequest = false;
    private volatile PrivateKeyRespone keyRespone = null;

    public static RequestState getInstance() {
        try {
            if (mInstance == null) {
                synchronized (RequestState.class) {
                    if (mInstance == null) {
                        mInstance = new RequestState();
                    }
                }
            }
            return mInstance;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    public boolean checkTokenValied(int i10) {
        try {
            if (this.keyRespone != null && !TextUtils.isEmpty(this.keyRespone.getAk()) && !TextUtils.isEmpty(this.keyRespone.getSk()) && !TextUtils.isEmpty(this.keyRespone.getStsToken())) {
                return this.keyRespone.getExpiredTime() - System.currentTimeMillis() > ((long) ((i10 * 60) * 1000));
            }
            return false;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return false;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return false;
            }
        }
    }

    public PrivateKeyRespone getKeyRespone() {
        try {
            return this.keyRespone;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    public boolean isUseRequest() {
        try {
            return this.useRequest;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return false;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return false;
            }
        }
    }

    public void setKeyRespone(PrivateKeyRespone privateKeyRespone) {
        try {
            this.keyRespone = privateKeyRespone;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public void setUseRequest(boolean z10) {
        try {
            this.useRequest = z10;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }
}
