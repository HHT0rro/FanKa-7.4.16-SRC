package com.mobile.auth.r;

import android.content.Context;
import com.mobile.auth.gatewayauth.ExceptionProcessor;
import com.mobile.auth.gatewayauth.ResultCode;
import com.mobile.auth.gatewayauth.manager.VendorSdkInfoManager;
import com.mobile.auth.gatewayauth.model.psc_info_upload.AllRBInfo;
import com.mobile.auth.gatewayauth.model.psc_info_upload.PnsVendorQueryResponse;
import com.mobile.auth.gatewayauth.model.psc_info_upload.Result;
import com.mobile.auth.gatewayauth.network.RequestState;
import com.mobile.auth.gatewayauth.network.RequestUtil;
import com.mobile.auth.gatewayauth.utils.EncryptUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class b extends a<com.mobile.auth.w.b> {

    /* renamed from: a, reason: collision with root package name */
    private com.mobile.auth.q.a f37579a;

    /* renamed from: b, reason: collision with root package name */
    private VendorSdkInfoManager f37580b;

    public b(Context context, VendorSdkInfoManager vendorSdkInfoManager, com.mobile.auth.gatewayauth.manager.b bVar, com.mobile.auth.q.a aVar) {
        super(context, bVar);
        this.f37579a = aVar;
        this.f37580b = vendorSdkInfoManager;
    }

    @Override // com.mobile.auth.r.a
    public /* synthetic */ com.mobile.auth.w.b a() {
        try {
            return d();
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

    @Override // com.mobile.auth.r.a
    public /* synthetic */ com.mobile.auth.w.b a(String str) {
        try {
            return b(str);
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

    public com.mobile.auth.w.b b(String str) {
        String str2;
        str2 = "";
        try {
            try {
                str2 = RequestState.getInstance().checkTokenValied(1) ? RequestUtil.getVendorListByPop(RequestState.getInstance().getKeyRespone().getSk(), EncryptUtils.encryptToken(c(), null, null, null, this.f37580b.c(), str, null, null, null, false, null)) : "";
                this.f37579a.a("PopRequest-GetVendorList:" + str2);
            } catch (Exception unused) {
            }
            return new com.mobile.auth.w.b(false, str2, str);
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

    public com.mobile.auth.w.b d() {
        try {
            AllRBInfo allRBInfo = new AllRBInfo();
            PnsVendorQueryResponse pnsVendorQueryResponse = new PnsVendorQueryResponse();
            Result result = new Result();
            result.setCode(ResultCode.CODE_ERROR_FUNCTION_LIMIT);
            result.setMessage("GetVendorList Limited");
            pnsVendorQueryResponse.setResult(result);
            allRBInfo.setResponse(pnsVendorQueryResponse);
            return new com.mobile.auth.w.b(false, allRBInfo.toJson().toString(), "");
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

    public com.mobile.auth.w.a e() {
        try {
            return new com.mobile.auth.w.b(true, "{}", "");
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
    public /* synthetic */ com.mobile.auth.w.a onTimeout() {
        try {
            return e();
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
