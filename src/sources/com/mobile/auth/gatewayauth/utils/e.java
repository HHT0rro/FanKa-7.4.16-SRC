package com.mobile.auth.gatewayauth.utils;

import com.huawei.openalliance.ad.constant.u;
import com.mobile.auth.gatewayauth.ExceptionProcessor;
import com.mobile.auth.gatewayauth.manager.FeatureManager;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class e {

    /* renamed from: b, reason: collision with root package name */
    private static e f37383b;

    /* renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap<String, StringBuffer> f37384a = new ConcurrentHashMap<>();

    private e() {
    }

    public static e a() {
        try {
            if (f37383b == null) {
                synchronized (e.class) {
                    if (f37383b == null) {
                        f37383b = new e();
                    }
                }
            }
            return f37383b;
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

    public String a(String str) {
        StringBuffer remove;
        try {
            if (FeatureManager.getInstance().get(FeatureManager.FEATURE_KEY_PERFORMANCE_TRACKER) == null && (remove = this.f37384a.remove(str)) != null) {
                return remove.toString();
            }
            return null;
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

    public void a(String str, String str2, long j10) {
        try {
            a(str, str2, j.a(j10));
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public void a(String str, String str2, String str3) {
        try {
            if (FeatureManager.getInstance().get(FeatureManager.FEATURE_KEY_PERFORMANCE_TRACKER) != null) {
                return;
            }
            StringBuffer stringBuffer = null;
            if (this.f37384a.containsKey(str)) {
                stringBuffer = this.f37384a.get(str);
            } else {
                synchronized (this.f37384a) {
                    if (!this.f37384a.containsKey(str)) {
                        stringBuffer = new StringBuffer(str);
                        this.f37384a.put(str, stringBuffer);
                    }
                }
            }
            stringBuffer.append("[" + str2 + u.bD + str3 + "]");
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }
}
