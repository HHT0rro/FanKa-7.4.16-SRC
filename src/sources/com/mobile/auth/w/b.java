package com.mobile.auth.w;

import android.util.SparseArray;
import com.mobile.auth.gatewayauth.ExceptionProcessor;
import com.mobile.auth.gatewayauth.ResultCode;
import com.mobile.auth.gatewayauth.model.VendorConfig;
import com.mobile.auth.gatewayauth.model.psc_info_upload.AllRBInfo;
import com.mobile.auth.gatewayauth.model.psc_info_upload.Module;
import com.mobile.auth.gatewayauth.model.psc_info_upload.ModuleList;
import com.mobile.auth.gatewayauth.model.psc_info_upload.PnsVendorQueryResponse;
import com.mobile.auth.gatewayauth.model.psc_info_upload.Result;
import com.mobile.auth.gatewayauth.utils.AESUtils;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class b extends a {

    /* renamed from: a, reason: collision with root package name */
    private SparseArray<VendorConfig> f37659a;

    public b(boolean z10, String str, String str2) {
        super(z10, str, str2);
        this.f37659a = new SparseArray<>(3);
        f();
    }

    private synchronized void a(AllRBInfo allRBInfo, String str) {
        try {
            PnsVendorQueryResponse response = allRBInfo.getResponse();
            Result result = response != null ? response.getResult() : null;
            ModuleList module_list = result != null ? result.getModule_list() : null;
            for (Module module : module_list != null ? module_list.getModule() : null) {
                VendorConfig vendorConfig = new VendorConfig();
                vendorConfig.setRequestId(response.getRequest_id());
                vendorConfig.setVendorAccessId(AESUtils.decrypt(module.getVendor_access_id(), str));
                vendorConfig.setVendorAccessSecret(AESUtils.decrypt(module.getVendor_access_secret(), str));
                vendorConfig.setVendorKey(AESUtils.decrypt(module.getVendor_key(), str));
                int a10 = com.mobile.auth.gatewayauth.utils.c.a(vendorConfig.getVendorKey());
                if (a10 != 4) {
                    this.f37659a.put(a10, vendorConfig);
                }
            }
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    private void f() {
        PnsVendorQueryResponse response;
        ModuleList module_list;
        List<Module> module;
        try {
            AllRBInfo fromJson = AllRBInfo.fromJson(c());
            if (fromJson != null && (response = fromJson.getResponse()) != null) {
                a(response.getRequest_id());
                Result result = response.getResult();
                if (result != null && (module_list = result.getModule_list()) != null && (module = module_list.getModule()) != null && module.size() > 0 && module.get(0) != null) {
                    a(true);
                    a(fromJson, d());
                    return;
                }
            }
            a(false);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    @Override // com.mobile.auth.w.a
    public synchronized SparseArray<VendorConfig> e() {
        try {
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
        return this.f37659a;
    }

    @Override // com.nirvana.tools.requestqueue.TimeoutResponse
    public boolean isResultTimeout() {
        PnsVendorQueryResponse response;
        Result result;
        try {
            AllRBInfo fromJson = AllRBInfo.fromJson(c());
            if (fromJson == null || (response = fromJson.getResponse()) == null || (result = response.getResult()) == null) {
                return false;
            }
            return ResultCode.CODE_ERROR_FUNCTION_TIME_OUT.equals(result.getCode());
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
}
