package com.huawei.hianalytics;

import android.content.Context;
import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hianalytics.log.LogTag;
import com.huawei.hianalytics.process.HiAnalyticsManager;
import java.lang.Thread;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class a implements Thread.UncaughtExceptionHandler {
    public static a efg;
    public static final String fgh = LogTag.get(a.class, new Class[0]);
    public Context ijk;
    public boolean ikl;
    public Thread.UncaughtExceptionHandler klm;
    public b lmn;
    public String hij = "";
    public String ghi = "";

    public static a lmn() {
        a aVar;
        synchronized (a.class) {
            if (efg == null) {
                efg = new a();
            }
            aVar = efg;
        }
        return aVar;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        boolean z10;
        StackTraceElement[] stackTrace;
        if (this.klm != null) {
            if (this.ijk != null) {
                String str = fgh;
                HiLog.e(str, "uncaughtException.");
                boolean z11 = true;
                if (th == null) {
                    z11 = false;
                } else {
                    String name = th.getClass().getName();
                    HiLog.i(str, "crash error is Grey list");
                    String[] strArr = {"java.io.FileNotFoundException", "java.sql.SQLException", "java.net.BindException", "java.util.ConcurrentModificationException", "javax.naming.InsufficientResourcesException", "java.util.MissingResourceException", "java.util.jar.JarException", "java.lang.OutOfMemoryError", "java.lang.StackOverflowError", "java.security.acl.NotOwnerException"};
                    int i10 = 0;
                    while (true) {
                        if (i10 >= 10) {
                            z10 = true;
                            break;
                        } else {
                            if (name.equals(strArr[i10])) {
                                z10 = false;
                                break;
                            }
                            i10++;
                        }
                    }
                    if (z10) {
                        this.hij = name;
                        StringBuffer stringBuffer = new StringBuffer();
                        Throwable cause = th.getCause();
                        if (cause != null) {
                            stackTrace = cause.getStackTrace();
                        } else {
                            stackTrace = th.getStackTrace();
                        }
                        for (StackTraceElement stackTraceElement : stackTrace) {
                            stringBuffer.append(stackTraceElement.toString().trim());
                            stringBuffer.append(System.lineSeparator());
                        }
                        this.ghi = stringBuffer.toString();
                    } else {
                        this.ghi = "An exception occurred";
                    }
                    if (this.ikl) {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("_crash_class", this.hij);
                            jSONObject.put("_crash_stack", this.ghi);
                        } catch (JSONException unused) {
                            HiLog.e(fgh, "eventManager handlerEx json put error!");
                        }
                        b bVar = this.lmn;
                        Objects.requireNonNull(bVar);
                        HiAnalyticsManager.getInstanceByTag("_instance_ex_tag").onEvent(bVar.lmn, "$AppOnCrash", jSONObject.toString());
                        this.hij = "";
                        this.ghi = "";
                    }
                }
                if (z11) {
                    HiLog.e(fgh, "Throwable is doing.");
                }
            }
            this.klm.uncaughtException(thread, th);
        }
    }
}
