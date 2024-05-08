package com.alibaba.security.realidentity.build;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.alibaba.security.common.log.RPLogging;
import com.alibaba.security.common.track.model.TrackLog;
import com.alibaba.security.common.utils.CommonUtils;
import com.alibaba.security.realidentity.RPEnv;
import com.alibaba.wireless.security.open.SecException;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.SecurityGuardParamContext;
import com.alibaba.wireless.security.open.initialize.IInitializeComponent;
import com.alibaba.wireless.security.open.securesignature.ISecureSignatureComponent;
import com.alibaba.wireless.security.open.securesignature.SecureSignatureDefine;
import com.alibaba.wireless.security.open.securitybody.ISecurityBodyComponent;
import com.alibaba.wireless.security.open.staticdatastore.IStaticDataStoreComponent;
import com.alibaba.wireless.security.open.umid.IUMIDComponent;
import java.util.HashMap;

/* compiled from: BaseSecurityManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class gw {

    /* renamed from: b, reason: collision with root package name */
    public static final String f3783b = "SecurityGuardManager";

    /* renamed from: a, reason: collision with root package name */
    public RPEnv f3784a = RPEnv.ONLINE;

    /* renamed from: c, reason: collision with root package name */
    public Context f3785c;

    /* renamed from: d, reason: collision with root package name */
    public String f3786d;

    /* renamed from: e, reason: collision with root package name */
    public String f3787e;

    /* renamed from: f, reason: collision with root package name */
    public gy f3788f;

    public gw(gy gyVar) {
        this.f3788f = gyVar;
    }

    private static int l() {
        return 1;
    }

    private int m() {
        RPEnv rPEnv = this.f3784a;
        if (rPEnv == RPEnv.DAILY) {
            return 2;
        }
        if (rPEnv == RPEnv.PRE) {
            return 1;
        }
        RPEnv rPEnv2 = RPEnv.ONLINE;
        return 0;
    }

    private String n() {
        RPEnv rPEnv = this.f3784a;
        if (rPEnv == RPEnv.DAILY) {
            return "DAILY";
        }
        if (rPEnv == RPEnv.PRE) {
            return "PREONLINE";
        }
        RPEnv rPEnv2 = RPEnv.ONLINE;
        return "ONLINE";
    }

    public final void a(Context context) {
        this.f3785c = context;
        try {
            if (a()) {
                IInitializeComponent initializer = SecurityGuardManager.getInitializer();
                initializer.registerInitFinishListener(new IInitializeComponent.IInitFinishListener() { // from class: com.alibaba.security.realidentity.build.gw.1
                    @Override // com.alibaba.wireless.security.open.initialize.IInitializeComponent.IInitFinishListener
                    public final void onError() {
                        gw.this.c("security guard initialize error");
                    }

                    @Override // com.alibaba.wireless.security.open.initialize.IInitializeComponent.IInitFinishListener
                    public final void onSuccess() {
                    }
                });
                initializer.initializeAsync(context.getApplicationContext());
            }
        } catch (Throwable th) {
            a("security guard initialize fail", th);
            a(th);
        }
    }

    public boolean a() {
        return true;
    }

    public byte[] a(byte[] bArr) {
        return null;
    }

    public final Pair<Boolean, String> b() {
        try {
            if (!a()) {
                return new Pair<>(Boolean.FALSE, "v1 signature not found");
            }
            if (((ISecurityBodyComponent) b(this.f3785c).getInterface(ISecurityBodyComponent.class)).enterRiskScene(2, null)) {
                return new Pair<>(Boolean.TRUE, "");
            }
            return new Pair<>(Boolean.FALSE, "SecurityGuard enter risk scene failed");
        } catch (Throwable th) {
            a("security guard enter fail", th);
            a(th);
            if (th instanceof SecException) {
                return new Pair<>(Boolean.FALSE, "SecurityGuard enter risk scene exception, error code is: " + th.getErrorCode());
            }
            return new Pair<>(Boolean.FALSE, "SecurityGuard enter risk scene exception, error code is: " + CommonUtils.getStackTrace(th));
        }
    }

    public final void c() {
        SecurityGuardManager b4;
        try {
            if (a() && (b4 = b(this.f3785c)) != null) {
                ((ISecurityBodyComponent) b4.getInterface(ISecurityBodyComponent.class)).leaveRiskScene(2);
            }
        } catch (Throwable th) {
            a("security guard leave fail", th);
            a(th);
        }
    }

    public final String d() {
        try {
            if (a()) {
                return e();
            }
            return null;
        } catch (Throwable th) {
            a("getSgDataStoreComponent fail", th);
            a(th);
            return null;
        }
    }

    public final String e() throws Throwable {
        IStaticDataStoreComponent staticDataStoreComp;
        if (a() && (staticDataStoreComp = b(this.f3785c).getStaticDataStoreComp()) != null) {
            return staticDataStoreComp.getAppKeyByIndex(1, k());
        }
        return null;
    }

    public final String f() {
        IStaticDataStoreComponent staticDataStoreComp;
        try {
            if (a() && (staticDataStoreComp = b(this.f3785c).getStaticDataStoreComp()) != null) {
                return staticDataStoreComp.getAppKeyByIndex(0, k());
            }
            return null;
        } catch (Throwable th) {
            a("getSgMd5AppKey fail", th);
            a(th);
            return null;
        }
    }

    public final String g() {
        if (!a()) {
            return null;
        }
        if (!TextUtils.isEmpty(this.f3787e)) {
            return this.f3787e;
        }
        try {
            ISecurityBodyComponent securityBodyComp = b(this.f3785c).getSecurityBodyComp();
            if (securityBodyComp == null) {
                c("getWuaToken securityBodyComponent null");
                return null;
            }
            HashMap<String, String> hashMap = new HashMap<>();
            RPEnv rPEnv = this.f3784a;
            String str = "ONLINE";
            if (rPEnv == RPEnv.DAILY) {
                str = "DAILY";
            } else if (rPEnv == RPEnv.PRE) {
                str = "PREONLINE";
            } else {
                RPEnv rPEnv2 = RPEnv.ONLINE;
            }
            hashMap.put("HOSTENV", str);
            String securityBodyDataEx = securityBodyComp.getSecurityBodyDataEx(null, null, k(), hashMap, 4, 0);
            this.f3787e = securityBodyDataEx;
            return securityBodyDataEx;
        } catch (Throwable th) {
            a(th);
            a("getWuaToken fail", th);
            return null;
        }
    }

    public final String h() {
        try {
            if (a()) {
                return ((ISecurityBodyComponent) SecurityGuardManager.getInstance(this.f3785c).getInterface(ISecurityBodyComponent.class)).getSecurityBodyDataEx(null, null, "", null, 4, 0);
            }
            return null;
        } catch (Throwable th) {
            a(th);
            a("getWuaToken fail", th);
            return null;
        }
    }

    public final String i() {
        try {
            if (a()) {
                return ((ISecurityBodyComponent) b(this.f3785c).getInterface(ISecurityBodyComponent.class)).getSecurityBodyDataEx(null, null, null, null, 8, 4);
            }
            return null;
        } catch (Throwable th) {
            a(th);
            a("getMiniWuaToken fail", th);
            return null;
        }
    }

    public final String j() {
        int i10;
        if (!a()) {
            return null;
        }
        if (!TextUtils.isEmpty(this.f3786d)) {
            return this.f3786d;
        }
        try {
            IUMIDComponent uMIDComp = b(this.f3785c).getUMIDComp();
            if (uMIDComp == null) {
                c("getUmidToken umidComponent is null");
                return null;
            }
            RPEnv rPEnv = this.f3784a;
            if (rPEnv == RPEnv.DAILY) {
                i10 = 2;
            } else if (rPEnv == RPEnv.PRE) {
                i10 = 1;
            } else {
                RPEnv rPEnv2 = RPEnv.ONLINE;
                i10 = 0;
            }
            uMIDComp.initUMIDSync(i10);
            String securityToken = uMIDComp.getSecurityToken(i10);
            this.f3786d = securityToken;
            return securityToken;
        } catch (Throwable th) {
            a(th);
            a("getSgDataStoreComponent fail", th);
            return null;
        }
    }

    public abstract String k();

    public final void c(String str) {
        TrackLog createSdkExceptionLog = TrackLog.createSdkExceptionLog(str, "", "");
        createSdkExceptionLog.setCode(-1);
        gy gyVar = this.f3788f;
        if (gyVar != null) {
            gyVar.collectLog(createSdkExceptionLog);
        }
    }

    public final String a(@NonNull String str) {
        try {
            if (!a()) {
                return null;
            }
            ISecureSignatureComponent secureSignatureComp = b(this.f3785c).getSecureSignatureComp();
            SecurityGuardParamContext securityGuardParamContext = new SecurityGuardParamContext();
            HashMap hashMap = new HashMap();
            hashMap.put(SecureSignatureDefine.OPEN_KEY_SIGN_INPUT, str);
            securityGuardParamContext.appKey = d();
            securityGuardParamContext.paramMap = hashMap;
            securityGuardParamContext.requestType = 3;
            return secureSignatureComp.signRequest(securityGuardParamContext, k());
        } catch (Throwable th) {
            a("getSgSignSHA1Result fail", th);
            a(th);
            return null;
        }
    }

    public final String b(@NonNull String str) {
        try {
            if (!a()) {
                return null;
            }
            ISecureSignatureComponent secureSignatureComp = b(this.f3785c).getSecureSignatureComp();
            SecurityGuardParamContext securityGuardParamContext = new SecurityGuardParamContext();
            HashMap hashMap = new HashMap();
            hashMap.put(SecureSignatureDefine.OPEN_KEY_SIGN_INPUT, str);
            securityGuardParamContext.appKey = f();
            securityGuardParamContext.paramMap = hashMap;
            securityGuardParamContext.requestType = 4;
            return secureSignatureComp.signRequest(securityGuardParamContext, k());
        } catch (Throwable th) {
            a("getSgSignMd5Result fail", th);
            a(th);
            return null;
        }
    }

    private void a(Throwable th) {
        RPLogging.e(f3783b, "看到该日志，说明接入的图片yw_1222_" + k() + "存在问题。图片错误码：", th);
    }

    public final void a(String str, Throwable th) {
        TrackLog createSdkExceptionLog = TrackLog.createSdkExceptionLog(str, CommonUtils.getStackTrace(th), "");
        createSdkExceptionLog.setCode(-1);
        gy gyVar = this.f3788f;
        if (gyVar != null) {
            gyVar.collectLog(createSdkExceptionLog);
        }
    }

    private void a(RPEnv rPEnv) {
        this.f3784a = rPEnv;
        this.f3786d = null;
        this.f3787e = null;
    }

    private SecurityGuardManager b(Context context) throws Throwable {
        return SecurityGuardManager.getInstance(context, k());
    }
}
