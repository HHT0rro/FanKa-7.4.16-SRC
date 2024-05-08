package p001.p002.p003.p004.p005.p013;

import com.alibaba.wireless.security.mainplugin.SecurityGuardMainPlugin;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.SecurityGuardParamContext;
import com.alibaba.wireless.security.open.initialize.ISecurityGuardPlugin;
import com.alibaba.wireless.security.open.securesignature.ISecureSignatureComponent;
import com.alibaba.wireless.security.open.securesignature.SecureSignatureDefine;
import com.alibaba.wireless.security.open.staticdataencrypt.IStaticDataEncryptComponent;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class9.dex
 */
/* renamed from: а.а.а.а.а.з.а, reason: contains not printable characters */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class9.dex.bak */
public class C0856 implements ISecureSignatureComponent {

    /* renamed from: а, reason: contains not printable characters */
    private ISecurityGuardPlugin f633 = null;

    public C0856(SecurityGuardMainPlugin securityGuardMainPlugin) {
        init(securityGuardMainPlugin, new Object[0]);
    }

    @Override // com.alibaba.wireless.security.open.securesignature.ISecureSignatureComponent
    public String getSafeCookie(String str, String str2, String str3) throws SecException {
        try {
            ISecureSignatureComponent iSecureSignatureComponent = (ISecureSignatureComponent) this.f633.getInterface(ISecureSignatureComponent.class);
            IStaticDataEncryptComponent iStaticDataEncryptComponent = (IStaticDataEncryptComponent) this.f633.getInterface(IStaticDataEncryptComponent.class);
            HashMap hashMap = new HashMap();
            hashMap.put(SecureSignatureDefine.OPEN_KEY_SIGN_INPUT, str);
            SecurityGuardParamContext securityGuardParamContext = new SecurityGuardParamContext();
            securityGuardParamContext.appKey = str2;
            securityGuardParamContext.paramMap = hashMap;
            securityGuardParamContext.requestType = 3;
            return "AE001" + iStaticDataEncryptComponent.staticSafeEncrypt(16, str2, iSecureSignatureComponent.signRequest(securityGuardParamContext, str3) + str, str3);
        } catch (SecException e2) {
            int i10 = 699;
            if (e2.getErrorCode() > 600 && e2.getErrorCode() < 699) {
                throw e2;
            }
            switch (e2.getErrorCode()) {
                case 302:
                    i10 = 607;
                    break;
                case 303:
                    i10 = 608;
                    break;
                case 304:
                    i10 = 304;
                    break;
                case 305:
                    i10 = 305;
                    break;
                case 306:
                    i10 = 306;
                    break;
                case 307:
                    i10 = 307;
                    break;
                case 308:
                    i10 = 308;
                    break;
            }
            throw new SecException(i10);
        }
    }

    @Override // com.alibaba.wireless.security.open.IComponent
    public int init(ISecurityGuardPlugin iSecurityGuardPlugin, Object... objArr) {
        this.f633 = iSecurityGuardPlugin;
        return 0;
    }

    @Override // com.alibaba.wireless.security.open.securesignature.ISecureSignatureComponent
    public String signRequest(SecurityGuardParamContext securityGuardParamContext, String str) throws SecException {
        Map<String, String> map;
        if (securityGuardParamContext == null || (map = securityGuardParamContext.paramMap) == null) {
            throw new SecException("", 601);
        }
        String str2 = securityGuardParamContext.appKey;
        int i10 = securityGuardParamContext.requestType;
        if (map == null || map.isEmpty()) {
            throw new SecException("", 601);
        }
        if (i10 == 0) {
            if (map.get(SecureSignatureDefine.OPEN_KEY_SIGN_SEEDKEY) == null) {
                throw new SecException(606);
            }
        } else if (i10 == 5 || i10 == 7 || i10 == 8) {
            String str3 = map.get(SecureSignatureDefine.OPEN_KEY_SIGN_ATLAS);
            if (map.size() == 2 && (str3 == null || str3.length() <= 0)) {
                throw new SecException(601);
            }
        }
        String str4 = (String) this.f633.getRouter().doCommand(10401, map, str2, Integer.valueOf(i10), str, true);
        return ((i10 == 0 || i10 == 2) && str4 != null) ? str4.toUpperCase() : str4;
    }
}
