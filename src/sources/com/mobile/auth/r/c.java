package com.mobile.auth.r;

import android.content.Context;
import com.baidu.mobads.sdk.internal.by;
import com.mobile.auth.gatewayauth.ExceptionProcessor;
import com.mobile.auth.gatewayauth.manager.VendorSdkInfoManager;
import com.mobile.auth.gatewayauth.model.psc_sdk_config.ConfigRB;
import com.mobile.auth.gatewayauth.network.RequestState;
import com.mobile.auth.gatewayauth.network.RequestUtil;
import com.mobile.auth.gatewayauth.network.UTSharedPreferencesHelper;
import com.mobile.auth.gatewayauth.utils.EncryptUtils;
import com.nirvana.tools.requestqueue.TimeoutCallable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class c implements TimeoutCallable<com.mobile.auth.w.c> {

    /* renamed from: a, reason: collision with root package name */
    private Context f37581a;

    /* renamed from: b, reason: collision with root package name */
    private com.mobile.auth.q.a f37582b;

    /* renamed from: c, reason: collision with root package name */
    private VendorSdkInfoManager f37583c;

    public c(Context context, VendorSdkInfoManager vendorSdkInfoManager, com.mobile.auth.q.a aVar) {
        this.f37581a = context;
        this.f37582b = aVar;
        this.f37583c = vendorSdkInfoManager;
    }

    public com.mobile.auth.w.c a() {
        try {
            return new com.mobile.auth.w.c(true);
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

    public com.mobile.auth.w.c b() throws Exception {
        try {
            if (!RequestState.getInstance().checkTokenValied(1)) {
                this.f37582b.e("request expiration date out");
                return new com.mobile.auth.w.c(false);
            }
            try {
                String sDKConfigByPop = RequestUtil.getSDKConfigByPop(RequestState.getInstance().getKeyRespone().getSk(), EncryptUtils.noEncryptTinfo(this.f37581a, this.f37583c.c(), com.mobile.auth.gatewayauth.utils.c.b(this.f37581a)));
                this.f37582b.a("getSdkConfig Ret:", sDKConfigByPop);
                ConfigRB fromJson = ConfigRB.fromJson(sDKConfigByPop);
                if (fromJson != null) {
                    if (fromJson.getResponse() == null || fromJson.getResponse().getResult() == null) {
                        if (fromJson.getErrorResponse() != null) {
                            if (fromJson.getErrorResponse().getCode() == 22) {
                                UTSharedPreferencesHelper.saveSDKConfigCloseFlag(this.f37581a, true);
                            } else if (fromJson.getErrorResponse().getCode() == 7) {
                                UTSharedPreferencesHelper.saveSDKConfigLimitFlag(this.f37581a, com.mobile.auth.gatewayauth.utils.a.a());
                            }
                        }
                    } else if (fromJson.getResponse().getResult().getModel() != null && by.f9988k.equals(fromJson.getResponse().getResult().getCode())) {
                        return new com.mobile.auth.w.c(false, fromJson.getResponse().getResult().getModel());
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return new com.mobile.auth.w.c(false);
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

    @Override // java.util.concurrent.Callable
    public /* synthetic */ Object call() throws Exception {
        try {
            return b();
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

    @Override // com.nirvana.tools.requestqueue.TimeoutCallable
    public /* synthetic */ com.mobile.auth.w.c onTimeout() {
        try {
            return a();
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
}
