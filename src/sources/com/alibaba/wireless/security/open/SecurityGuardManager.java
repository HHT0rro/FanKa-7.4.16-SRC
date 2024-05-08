package com.alibaba.wireless.security.open;

import android.content.Context;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alibaba.wireless.security.framework.C0059;
import com.alibaba.wireless.security.framework.ISGPluginManager;
import com.alibaba.wireless.security.open.atlasencrypt.IAtlasEncryptComponent;
import com.alibaba.wireless.security.open.compat.ICompatComponent;
import com.alibaba.wireless.security.open.datacollection.IDataCollectionComponent;
import com.alibaba.wireless.security.open.dynamicdataencrypt.IDynamicDataEncryptComponent;
import com.alibaba.wireless.security.open.dynamicdatastore.IDynamicDataStoreComponent;
import com.alibaba.wireless.security.open.initialize.C0082;
import com.alibaba.wireless.security.open.initialize.C0085;
import com.alibaba.wireless.security.open.initialize.IInitializeComponent;
import com.alibaba.wireless.security.open.maldetection.IMalDetect;
import com.alibaba.wireless.security.open.nocaptcha.INoCaptchaComponent;
import com.alibaba.wireless.security.open.opensdk.IOpenSDKComponent;
import com.alibaba.wireless.security.open.pkgvaliditycheck.IPkgValidityCheckComponent;
import com.alibaba.wireless.security.open.safetoken.ISafeTokenComponent;
import com.alibaba.wireless.security.open.securesignature.ISecureSignatureComponent;
import com.alibaba.wireless.security.open.securitybody.ISecurityBodyComponent;
import com.alibaba.wireless.security.open.simulatordetect.ISimulatorDetectComponent;
import com.alibaba.wireless.security.open.staticdataencrypt.IStaticDataEncryptComponent;
import com.alibaba.wireless.security.open.staticdatastore.IStaticDataStoreComponent;
import com.alibaba.wireless.security.open.statickeyencrypt.IStaticKeyEncryptComponent;
import com.alibaba.wireless.security.open.umid.IUMIDComponent;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class SecurityGuardManager {

    /* renamed from: в, reason: contains not printable characters */
    private static volatile SecurityGuardManager f163;

    /* renamed from: г, reason: contains not printable characters */
    private static volatile IInitializeComponent f164;

    /* renamed from: е, reason: contains not printable characters */
    private static JSONObject f166;

    /* renamed from: ё, reason: contains not printable characters */
    private static boolean f168;

    /* renamed from: а, reason: contains not printable characters */
    private ISGPluginManager f169;

    /* renamed from: б, reason: contains not printable characters */
    private final Map<Integer, Class> f170 = new C0077(this);

    /* renamed from: д, reason: contains not printable characters */
    private static final Object f165 = new Object();

    /* renamed from: ж, reason: contains not printable characters */
    private static Object f167 = new Object();

    /* renamed from: com.alibaba.wireless.security.open.SecurityGuardManager$а, reason: contains not printable characters */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class C0077 extends HashMap<Integer, Class> {
        public C0077(SecurityGuardManager securityGuardManager) {
            put(1, ISecureSignatureComponent.class);
            put(2, IDynamicDataStoreComponent.class);
            put(3, IStaticDataStoreComponent.class);
            put(5, IDataCollectionComponent.class);
            put(6, IStaticDataEncryptComponent.class);
            put(7, IDynamicDataEncryptComponent.class);
            put(8, ISimulatorDetectComponent.class);
            put(9, IStaticKeyEncryptComponent.class);
            put(10, IOpenSDKComponent.class);
            put(11, IUMIDComponent.class);
            put(12, IPkgValidityCheckComponent.class);
            put(13, IAtlasEncryptComponent.class);
            put(14, IMalDetect.class);
            put(15, INoCaptchaComponent.class);
            put(16, ISafeTokenComponent.class);
            put(17, ISecurityBodyComponent.class);
            put(18, ICompatComponent.class);
        }
    }

    private SecurityGuardManager(ISGPluginManager iSGPluginManager) {
        this.f169 = iSGPluginManager;
    }

    private static String getGlobalUserData() {
        String jSONObject;
        synchronized (f167) {
            jSONObject = f166.toString();
        }
        return jSONObject;
    }

    public static IInitializeComponent getInitializer() {
        return getInitializer(null);
    }

    public static IInitializeComponent getInitializer(String str) {
        if (f164 == null) {
            synchronized (f165) {
                if (f164 == null) {
                    f164 = new C0082(str);
                }
            }
        }
        return f164;
    }

    public static SecurityGuardManager getInstance(Context context) throws SecException {
        return getInstance(context, null);
    }

    public static SecurityGuardManager getInstance(Context context, String str) throws SecException {
        if (f163 == null) {
            synchronized (SecurityGuardManager.class) {
                if (context == null) {
                    return null;
                }
                if (f163 == null && getInitializer(str).initialize(context) == 0) {
                    ISGPluginManager m1942 = ((C0082) getInitializer(str)).m1942();
                    if (m1942 instanceof C0059) {
                        ((C0059) m1942).m1915(f168);
                    }
                    f163 = new SecurityGuardManager(m1942);
                }
            }
        }
        if (f163.f169 instanceof C0059) {
            ((C0059) f163.f169).m1915(f168);
        }
        return f163;
    }

    public static boolean getSilentMode() {
        return f168;
    }

    public static boolean setGlobalUserData(String str, String str2) throws SecException {
        try {
            synchronized (f167) {
                if (str == null && str2 == null) {
                    f166 = null;
                } else {
                    if (str == null || str2 == null) {
                        throw new SecException(118);
                    }
                    if (f166 == null) {
                        f166 = new JSONObject();
                    }
                    f166.put(str, str2);
                }
            }
            return true;
        } catch (JSONException e2) {
            throw new SecException(e2.getMessage(), 119);
        }
    }

    public static void setSilentMode(boolean z10) {
        f168 = z10;
    }

    public IAtlasEncryptComponent getAtlasEncryptComp() {
        IAtlasEncryptComponent iAtlasEncryptComponent = (IAtlasEncryptComponent) m1927(13);
        if (iAtlasEncryptComponent == null) {
            new SecException(1098).printStackTrace();
        }
        return iAtlasEncryptComponent;
    }

    public ICompatComponent getCompatComp() {
        return (ICompatComponent) m1927(18);
    }

    public IDataCollectionComponent getDataCollectionComp() {
        return (IDataCollectionComponent) m1927(5);
    }

    public IDynamicDataEncryptComponent getDynamicDataEncryptComp() {
        return (IDynamicDataEncryptComponent) m1927(7);
    }

    public IDynamicDataStoreComponent getDynamicDataStoreComp() {
        return (IDynamicDataStoreComponent) m1927(2);
    }

    public <T> T getInterface(Class<T> cls) throws SecException {
        return (T) this.f169.getInterface(cls);
    }

    public IMalDetect getMalDetectionComp() {
        IMalDetect iMalDetect = (IMalDetect) m1927(14);
        if (iMalDetect == null) {
            new SecException(1398).printStackTrace();
        }
        return iMalDetect;
    }

    public INoCaptchaComponent getNoCaptchaComp() {
        INoCaptchaComponent iNoCaptchaComponent = (INoCaptchaComponent) m1927(15);
        if (iNoCaptchaComponent == null) {
            new SecException(1299).printStackTrace();
        }
        return iNoCaptchaComponent;
    }

    public IOpenSDKComponent getOpenSDKComp() {
        return (IOpenSDKComponent) m1927(10);
    }

    public IPkgValidityCheckComponent getPackageValidityCheckComp() {
        return (IPkgValidityCheckComponent) m1927(12);
    }

    public String getSDKVerison() {
        return C0085.m1953();
    }

    public ISGPluginManager getSGPluginManager() {
        return this.f169;
    }

    public ISafeTokenComponent getSafeTokenComp() {
        ISafeTokenComponent iSafeTokenComponent = (ISafeTokenComponent) m1927(16);
        if (iSafeTokenComponent == null) {
            new SecException(1699).printStackTrace();
        }
        return iSafeTokenComponent;
    }

    public ISecureSignatureComponent getSecureSignatureComp() {
        return (ISecureSignatureComponent) m1927(1);
    }

    public ISecurityBodyComponent getSecurityBodyComp() {
        ISecurityBodyComponent iSecurityBodyComponent = (ISecurityBodyComponent) m1927(17);
        if (iSecurityBodyComponent == null) {
            new SecException(SecExceptionCode.SEC_ERROR_SECURITYBODY_UNSUPPORTED).printStackTrace();
        }
        return iSecurityBodyComponent;
    }

    public ISimulatorDetectComponent getSimulatorDetectComp() {
        ISimulatorDetectComponent iSimulatorDetectComponent = (ISimulatorDetectComponent) m1927(8);
        if (iSimulatorDetectComponent == null) {
            new SecException(1598).printStackTrace();
        }
        return iSimulatorDetectComponent;
    }

    public IStaticDataEncryptComponent getStaticDataEncryptComp() {
        return (IStaticDataEncryptComponent) m1927(6);
    }

    public IStaticDataStoreComponent getStaticDataStoreComp() {
        return (IStaticDataStoreComponent) m1927(3);
    }

    public IStaticKeyEncryptComponent getStaticKeyEncryptComp() {
        return (IStaticKeyEncryptComponent) m1927(9);
    }

    public IUMIDComponent getUMIDComp() {
        return (IUMIDComponent) m1927(11);
    }

    public Boolean isOpen() {
        return Boolean.TRUE;
    }

    /* renamed from: а, reason: contains not printable characters */
    public IComponent m1927(int i10) {
        try {
            return (IComponent) getInterface(this.f170.get(Integer.valueOf(i10)));
        } catch (SecException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
