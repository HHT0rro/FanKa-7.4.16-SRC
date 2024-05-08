package com.alibaba.wireless.security.jaq;

import android.content.Context;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.SecurityGuardParamContext;
import com.alibaba.wireless.security.open.securesignature.SecureSignatureDefine;
import java.util.HashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class SecuritySignature {

    /* renamed from: а, reason: contains not printable characters */
    private Context f149;

    public SecuritySignature(Context context) {
        if (context != null) {
            this.f149 = context.getApplicationContext();
        }
    }

    public String atlasSign(String str, String str2) throws JAQException {
        HashMap hashMap = new HashMap();
        hashMap.put(SecureSignatureDefine.OPEN_KEY_SIGN_INPUT, str);
        hashMap.put(SecureSignatureDefine.OPEN_KEY_SIGN_ATLAS, "a");
        SecurityGuardParamContext securityGuardParamContext = new SecurityGuardParamContext();
        securityGuardParamContext.appKey = str2;
        securityGuardParamContext.paramMap = hashMap;
        securityGuardParamContext.requestType = 5;
        try {
            if (SecurityGuardManager.getInstance(this.f149).getAtlasEncryptComp() != null) {
                return SecurityGuardManager.getInstance(this.f149).getSecureSignatureComp().signRequest(securityGuardParamContext, "0335");
            }
            throw new SecException(1098);
        } catch (SecException e2) {
            e2.printStackTrace();
            throw new JAQException(e2.getErrorCode());
        }
    }

    public String sign(String str, String str2) throws JAQException {
        HashMap hashMap = new HashMap();
        hashMap.put(SecureSignatureDefine.OPEN_KEY_SIGN_INPUT, str);
        SecurityGuardParamContext securityGuardParamContext = new SecurityGuardParamContext();
        securityGuardParamContext.appKey = str2;
        securityGuardParamContext.paramMap = hashMap;
        securityGuardParamContext.requestType = 3;
        try {
            return SecurityGuardManager.getInstance(this.f149).getSecureSignatureComp().signRequest(securityGuardParamContext, "0335");
        } catch (SecException e2) {
            e2.printStackTrace();
            throw new JAQException(e2.getErrorCode());
        }
    }

    public String signWithSimulator(String str, String str2) throws JAQException {
        HashMap hashMap = new HashMap();
        hashMap.put(SecureSignatureDefine.OPEN_KEY_SIGN_INPUT, str);
        SecurityGuardParamContext securityGuardParamContext = new SecurityGuardParamContext();
        securityGuardParamContext.appKey = str2;
        securityGuardParamContext.paramMap = hashMap;
        securityGuardParamContext.requestType = 6;
        try {
            return SecurityGuardManager.getInstance(this.f149).getSecureSignatureComp().signRequest(securityGuardParamContext, "0335");
        } catch (SecException e2) {
            e2.printStackTrace();
            throw new JAQException(e2.getErrorCode());
        }
    }
}
