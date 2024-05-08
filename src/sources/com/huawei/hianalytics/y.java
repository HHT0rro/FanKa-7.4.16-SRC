package com.huawei.hianalytics;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hianalytics.framework.constant.FrameworkConstant;
import com.huawei.hianalytics.global.AutoCollectEventType;
import com.huawei.hianalytics.log.LogTag;
import com.huawei.hianalytics.process.HiAnalyticsInstanceEx;
import com.huawei.hianalytics.process.impl.HAImpl;
import java.util.List;
import java.util.Objects;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class y extends HAImpl implements HiAnalyticsInstanceEx {
    public static final String lmn = LogTag.get(HAImpl.class, new Class[0]);

    public y() {
        super("_instance_ex_tag");
    }

    @Override // com.huawei.hianalytics.process.HiAnalyticsInstanceEx
    @Deprecated
    public void handleV1Cache() {
        if (!l0.ijk.lmn()) {
            HiLog.w(lmn, "userManager.isUserUnlocked() == false");
        } else {
            HiLog.i(lmn, "handleV1Cache() is executed.");
        }
    }

    public void lmn(List<AutoCollectEventType> list) {
        String str = lmn;
        HiLog.i(str, "autoCollect() is executed.");
        if (!l0.ijk.lmn()) {
            HiLog.w(str, "userManager.isUserUnlocked() == false");
            return;
        }
        if (list == null) {
            HiLog.w(str, "autoCollect() eventTypes is null,End this method!");
            return;
        }
        if (list.contains(AutoCollectEventType.APP_FIRST_RUN) && lmn()) {
            HiLog.i(str, "autoCollect: APP_FIRST_RUN");
            if (d.lmn() == null) {
                HiLog.w(str, "onFirstRun() SDK was not init. context is null");
            } else {
                JSONObject lmn2 = e0.lmn(d.lmn());
                if (lmn2 != null) {
                    getFrameworkInstance().onEvent(FrameworkConstant.DataType.STRING_OPER, "$AppFirstStart", lmn2, null);
                } else {
                    HiLog.w(str, "onFirstRun() getInfoJson is null,The end of the event ");
                }
            }
        }
        String str2 = c.klm().lmn.def;
        String str3 = c.klm().lmn.cde;
        if (list.contains(AutoCollectEventType.APP_UPGRADE)) {
            if ((TextUtils.isEmpty(str3) || str3.equals(str2)) ? false : true) {
                HiLog.i(str, "autoCollect: APP_UPGRADE");
                if (d.lmn() == null) {
                    HiLog.w(str, "onAppUpgrade() SDK was not init.");
                } else {
                    JSONObject lmn3 = e0.lmn(str2, str3);
                    if (lmn3 != null) {
                        getFrameworkInstance().onEvent(FrameworkConstant.DataType.STRING_OPER, "$AppOnUpdate", lmn3, null);
                    } else {
                        HiLog.w(str, "onAppUpgrade() getInfoJson is null,The end of the event ");
                    }
                }
            }
        }
        if (list.contains(AutoCollectEventType.APP_CRASH)) {
            HiLog.i(str, "autoCollect: APP_CRASH : true");
            lmn(true);
        } else {
            HiLog.i(str, "autoCollect: APP_CRASH : false");
            lmn(false);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0068  */
    @Override // com.huawei.hianalytics.process.HiAnalyticsInstanceEx
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onStartApp(java.lang.String r4, java.lang.String r5) {
        /*
            r3 = this;
            java.lang.String r0 = com.huawei.hianalytics.y.lmn
            java.lang.String r1 = "onStartApp() is executed."
            com.huawei.hianalytics.core.log.HiLog.i(r0, r1)
            com.huawei.hianalytics.l0 r1 = com.huawei.hianalytics.l0.ijk
            boolean r1 = r1.lmn()
            if (r1 != 0) goto L15
            java.lang.String r4 = "userManager.isUserUnlocked() == false"
            com.huawei.hianalytics.core.log.HiLog.w(r0, r4)
            return
        L15:
            java.lang.String r1 = "startType"
            r2 = 4096(0x1000, float:5.74E-42)
            boolean r1 = com.huawei.hianalytics.i0.lmn(r1, r4, r2)
            if (r1 == 0) goto L70
            java.lang.String r1 = "startCMD"
            boolean r1 = com.huawei.hianalytics.i0.lmn(r1, r5, r2)
            if (r1 != 0) goto L28
            goto L70
        L28:
            android.content.Context r1 = com.huawei.hianalytics.d.lmn()
            if (r1 != 0) goto L34
            java.lang.String r4 = "onStartApp() SDK was not init. context is null"
            com.huawei.hianalytics.core.log.HiLog.w(r0, r4)
            return
        L34:
            android.content.Context r0 = com.huawei.hianalytics.d.lmn()
            org.json.JSONObject r0 = com.huawei.hianalytics.e0.lmn(r0)
            r1 = 0
            if (r0 == 0) goto L52
            java.lang.String r2 = "_start_type"
            r0.put(r2, r4)     // Catch: org.json.JSONException -> L4a
            java.lang.String r4 = "_start_cmd"
            r0.put(r4, r5)     // Catch: org.json.JSONException -> L4a
            goto L5a
        L4a:
            java.lang.String r4 = com.huawei.hianalytics.e0.lmn
            java.lang.String r5 = "startType or startCMD error"
            com.huawei.hianalytics.core.log.HiLog.e(r4, r5)
            goto L59
        L52:
            java.lang.String r4 = com.huawei.hianalytics.e0.lmn
            java.lang.String r5 = "getInfoJson is null"
            com.huawei.hianalytics.core.log.HiLog.w(r4, r5)
        L59:
            r0 = r1
        L5a:
            if (r0 == 0) goto L68
            com.huawei.hianalytics.framework.HAFrameworkInstance r4 = r3.getFrameworkInstance()
            java.lang.String r5 = "oper"
            java.lang.String r2 = "$AppOnStart"
            r4.onEvent(r5, r2, r0, r1)
            goto L6f
        L68:
            java.lang.String r4 = com.huawei.hianalytics.y.lmn
            java.lang.String r5 = "onStartApp() getInfoJson is null,The end of the event "
            com.huawei.hianalytics.core.log.HiLog.w(r4, r5)
        L6f:
            return
        L70:
            java.lang.String r4 = "onStartApp() Parameter error, please enter the correct parameter"
            com.huawei.hianalytics.core.log.HiLog.w(r0, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hianalytics.y.onStartApp(java.lang.String, java.lang.String):void");
    }

    public final boolean lmn() {
        boolean lmn2 = j0.lmn("global_v2", "isFirstRun", false);
        if (!lmn2) {
            j0.klm("global_v2", "isFirstRun", true);
        }
        return !lmn2;
    }

    public void lmn(boolean z10) {
        if (d.lmn() == null) {
            HiLog.w(lmn, "onEventCrashInit() SDK was not init.");
            return;
        }
        if (z10) {
            b lmn2 = b.lmn();
            Objects.requireNonNull(lmn2);
            a lmn3 = a.lmn();
            Context context = lmn2.lmn;
            lmn3.lmn = lmn2;
            lmn3.ikl = true;
            synchronized (a.class) {
                if (lmn3.ijk == null) {
                    lmn3.ijk = context;
                    lmn3.klm = Thread.getDefaultUncaughtExceptionHandler();
                    Thread.setDefaultUncaughtExceptionHandler(lmn3);
                }
            }
            return;
        }
        Objects.requireNonNull(b.lmn());
        a.lmn().ikl = false;
    }
}
