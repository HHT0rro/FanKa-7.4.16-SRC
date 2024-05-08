package com.alibaba.security.rp;

import android.content.Context;
import com.alibaba.security.realidentity.RPEventListener;
import com.alibaba.security.realidentity.RPResult;
import com.alibaba.security.realidentity.RPVerify;
import com.alibaba.security.realidentity.build.j;

@Deprecated
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class RPSDK {

    @Deprecated
    public static Enum curEnv = RPSDKEnv.RPSDKEnv_ONLINE;
    private static String errorCode;
    private static RPCompletedListener mRPCompletedListener;

    @Deprecated
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public enum AUDIT {
        AUDIT_NOT(-1),
        AUDIT_PASS(1),
        AUDIT_FAIL(2);

        private int audit;

        AUDIT(int i10) {
            this.audit = i10;
        }
    }

    @Deprecated
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface RPCompletedListener {
        void onAuditResult(AUDIT audit, String str);
    }

    @Deprecated
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public enum RPSDKEnv {
        RPSDKEnv_ONLINE(0),
        RPSDKEnv_PRE(1),
        RPSDKEnv_DAILY(2);

        private int env;

        RPSDKEnv(int i10) {
            this.env = i10;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static AUDIT changeToAudit(RPResult rPResult) {
        if (rPResult == RPResult.AUDIT_FAIL) {
            return AUDIT.AUDIT_FAIL;
        }
        if (rPResult == RPResult.AUDIT_PASS) {
            return AUDIT.AUDIT_PASS;
        }
        if (rPResult == RPResult.AUDIT_NOT) {
            return AUDIT.AUDIT_NOT;
        }
        return AUDIT.AUDIT_NOT;
    }

    @Deprecated
    public static Context getContext() {
        return j.a.f3944a.f3894d;
    }

    @Deprecated
    public static String getErrorCode() {
        return errorCode;
    }

    @Deprecated
    public static RPCompletedListener getRPCompletedListener() {
        return new RPCompletedListener() { // from class: com.alibaba.security.rp.RPSDK.4
            @Override // com.alibaba.security.rp.RPSDK.RPCompletedListener
            public final void onAuditResult(AUDIT audit, String str) {
                if (RPSDK.mRPCompletedListener != null) {
                    RPSDK.mRPCompletedListener.onAuditResult(audit, str);
                }
            }
        };
    }

    @Deprecated
    public static void initialize(Context context) {
        RPVerify.init(context);
    }

    @Deprecated
    public static void setContext(Context context) {
        j unused = j.a.f3944a;
    }

    @Deprecated
    public static void setErrorCode(String str) {
        errorCode = str;
    }

    @Deprecated
    public static void setRPCompletedListener(RPCompletedListener rPCompletedListener) {
        mRPCompletedListener = rPCompletedListener;
    }

    @Deprecated
    public static void start(String str, Context context, final RPCompletedListener rPCompletedListener) {
        RPVerify.start(context, str, new RPEventListener() { // from class: com.alibaba.security.rp.RPSDK.1
            @Override // com.alibaba.security.realidentity.RPEventListener
            public final void onFinish(RPResult rPResult, String str2, String str3) {
                RPCompletedListener rPCompletedListener2 = RPCompletedListener.this;
                if (rPCompletedListener2 != null) {
                    rPCompletedListener2.onAuditResult(RPSDK.changeToAudit(rPResult), str2);
                }
            }
        });
    }

    @Deprecated
    public static void startVerifyByNative(String str, Context context, final RPCompletedListener rPCompletedListener) {
        RPVerify.startByNative(context, str, new RPEventListener() { // from class: com.alibaba.security.rp.RPSDK.3
            @Override // com.alibaba.security.realidentity.RPEventListener
            public final void onFinish(RPResult rPResult, String str2, String str3) {
                RPCompletedListener rPCompletedListener2 = RPCompletedListener.this;
                if (rPCompletedListener2 != null) {
                    rPCompletedListener2.onAuditResult(RPSDK.changeToAudit(rPResult), str2);
                }
            }
        });
    }

    @Deprecated
    public static void startVerifyWithUrl(String str, Context context, final RPCompletedListener rPCompletedListener) {
        RPVerify.startWithUrl(context, str, new RPEventListener() { // from class: com.alibaba.security.rp.RPSDK.2
            @Override // com.alibaba.security.realidentity.RPEventListener
            public final void onFinish(RPResult rPResult, String str2, String str3) {
                RPCompletedListener rPCompletedListener2 = RPCompletedListener.this;
                if (rPCompletedListener2 != null) {
                    rPCompletedListener2.onAuditResult(RPSDK.changeToAudit(rPResult), str2);
                }
            }
        });
    }

    @Deprecated
    public static void initialize(RPSDKEnv rPSDKEnv, Context context) {
        curEnv = rPSDKEnv;
        RPVerify.init(context);
    }
}
