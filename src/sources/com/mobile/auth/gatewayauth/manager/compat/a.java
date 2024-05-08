package com.mobile.auth.gatewayauth.manager.compat;

import com.mobile.auth.gatewayauth.Constant;
import com.mobile.auth.gatewayauth.ExceptionProcessor;
import com.mobile.auth.gatewayauth.ResultCode;
import com.mobile.auth.gatewayauth.model.TokenRet;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a implements ResultCodeProcessor {
    public String a(String str, String str2) {
        if (str == null) {
            return str2;
        }
        char c4 = 65535;
        try {
            if (str.hashCode() == 1591780832) {
                if (str.equals(ResultCode.CODE_ERROR_ANALYZE_SDK_INFO)) {
                    c4 = 0;
                }
            }
            return c4 != 0 ? str2 : "获取运营商配置信息失败";
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

    @Override // com.mobile.auth.gatewayauth.manager.compat.ResultCodeProcessor
    public String convertCode(String str) {
        if (str == null) {
            return Constant.CODE_ERROR_UNKNOWN_FAIL;
        }
        try {
            char c4 = 65535;
            if (str.hashCode() == 1591780832) {
                if (str.equals(ResultCode.CODE_ERROR_ANALYZE_SDK_INFO)) {
                    c4 = 0;
                }
            }
            return c4 != 0 ? str : Constant.CODE_ERROR_GET_CONFIG_FAIL;
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

    @Override // com.mobile.auth.gatewayauth.manager.compat.ResultCodeProcessor
    public TokenRet convertErrorInfo(String str, String str2, String str3) {
        try {
            TokenRet tokenRet = new TokenRet();
            tokenRet.setCode(convertCode(str));
            tokenRet.setMsg(a(str, str2));
            tokenRet.setVendorName(str3);
            return tokenRet;
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

    @Override // com.mobile.auth.gatewayauth.manager.compat.ResultCodeProcessor
    public String getApiLevel() {
        try {
            return String.valueOf(0);
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
