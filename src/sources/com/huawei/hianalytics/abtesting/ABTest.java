package com.huawei.hianalytics.abtesting;

import android.text.TextUtils;
import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hianalytics.ghi;
import com.huawei.hianalytics.ijk;
import com.huawei.hianalytics.ikl;
import com.huawei.hianalytics.klm;
import com.huawei.hianalytics.lmn;
import com.huawei.hianalytics.process.HiAnalyticsInstance;
import com.huawei.openalliance.ad.constant.as;
import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ABTest {
    public static final String TAG = "ABTest";

    /* JADX WARN: Removed duplicated region for block: B:22:0x0059 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getExpParam(java.lang.String r4, java.lang.String r5) {
        /*
            java.lang.String r0 = "ABTest"
            java.lang.String r1 = "getExpParam() is execute"
            com.huawei.hianalytics.core.log.HiLog.i(r0, r1)
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            if (r0 == 0) goto L16
            java.lang.String r4 = "ABTest"
            java.lang.String r0 = "paramkey is null"
            com.huawei.hianalytics.core.log.HiLog.w(r4, r0)
            goto L99
        L16:
            com.huawei.hianalytics.lmn r0 = com.huawei.hianalytics.lmn.ghi
            java.util.Objects.requireNonNull(r0)
            com.huawei.hianalytics.ikl r1 = com.huawei.hianalytics.ikl.hij
            monitor-enter(r1)
            boolean r2 = r1.ikl     // Catch: java.lang.Throwable -> L9d
            monitor-exit(r1)
            if (r2 != 0) goto L2d
            java.lang.String r4 = "ABTestManager"
            java.lang.String r0 = "ABTest sdk is not initialized"
            com.huawei.hianalytics.core.log.HiLog.w(r4, r0)
            java.lang.String r4 = ""
            goto L92
        L2d:
            com.huawei.hianalytics.ikl r1 = com.huawei.hianalytics.ikl.hij
            java.lang.String r2 = ""
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.huawei.hianalytics.ijk> r3 = r1.lmn
            if (r3 != 0) goto L3d
            java.lang.String r4 = "ABDataCenter"
            java.lang.String r1 = "getParamValue(): Experiment data is empty."
            com.huawei.hianalytics.core.log.HiLog.w(r4, r1)
            goto L55
        L3d:
            java.lang.Object r3 = r3.get(r4)
            if (r3 == 0) goto L4e
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.huawei.hianalytics.ijk> r1 = r1.lmn
            java.lang.Object r4 = r1.get(r4)
            com.huawei.hianalytics.ijk r4 = (com.huawei.hianalytics.ijk) r4
            java.lang.String r4 = r4.lmn
            goto L56
        L4e:
            java.lang.String r4 = "ABDataCenter"
            java.lang.String r1 = "getParamValue() : No corresponding value was found."
            com.huawei.hianalytics.core.log.HiLog.w(r4, r1)
        L55:
            r4 = r2
        L56:
            com.huawei.hianalytics.ikl r1 = com.huawei.hianalytics.ikl.hij
            monitor-enter(r1)
            boolean r2 = r1.klm     // Catch: java.lang.Throwable -> L9a
            monitor-exit(r1)
            if (r2 != 0) goto L8b
            com.huawei.hianalytics.ikl r1 = com.huawei.hianalytics.ikl.hij
            r2 = 1
            monitor-enter(r1)
            r1.klm = r2     // Catch: java.lang.Throwable -> L88
            monitor-exit(r1)
            boolean r1 = r0.lmn()
            if (r1 == 0) goto L7d
            java.lang.String r1 = "ABTestManager"
            java.lang.String r2 = "syncDataTask(): requesting network..."
            com.huawei.hianalytics.core.log.HiLog.i(r1, r2)
            java.util.concurrent.ExecutorService r0 = r0.ijk
            com.huawei.hianalytics.ghi r1 = new com.huawei.hianalytics.ghi
            r1.<init>()
            r0.execute(r1)
            goto L92
        L7d:
            com.huawei.hianalytics.ikl r0 = com.huawei.hianalytics.ikl.hij
            r1 = 0
            monitor-enter(r0)
            r0.klm = r1     // Catch: java.lang.Throwable -> L85
            monitor-exit(r0)
            goto L92
        L85:
            r4 = move-exception
            monitor-exit(r0)
            throw r4
        L88:
            r4 = move-exception
            monitor-exit(r1)
            throw r4
        L8b:
            java.lang.String r0 = "ABTestManager"
            java.lang.String r1 = "Already requesting network, quit."
            com.huawei.hianalytics.core.log.HiLog.i(r0, r1)
        L92:
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            if (r0 != 0) goto L99
            return r4
        L99:
            return r5
        L9a:
            r4 = move-exception
            monitor-exit(r1)
            throw r4
        L9d:
            r4 = move-exception
            monitor-exit(r1)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hianalytics.abtesting.ABTest.getExpParam(java.lang.String, java.lang.String):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void initABTest(android.content.Context r6, com.huawei.hianalytics.abtesting.ABTestConfig r7) {
        /*
            Method dump skipped, instructions count: 261
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hianalytics.abtesting.ABTest.initABTest(android.content.Context, com.huawei.hianalytics.abtesting.ABTestConfig):void");
    }

    public static void onEvent(String str, String str2, LinkedHashMap<String, String> linkedHashMap) {
        boolean z10;
        String str3;
        HiLog.i(TAG, "onEvent() is execute");
        if (TextUtils.isEmpty(str)) {
            HiLog.w(TAG, "onEvent() paramkey is null");
            return;
        }
        lmn lmnVar = lmn.ghi;
        Objects.requireNonNull(lmnVar);
        ikl iklVar = ikl.hij;
        synchronized (iklVar) {
            z10 = iklVar.ikl;
        }
        if (!z10) {
            HiLog.w("ABTestManager", "ABTest sdk is not initialized");
            return;
        }
        if (lmnVar.ikl == null) {
            HiLog.w("ABTestManager", "onEvent : instance is null");
            return;
        }
        if (linkedHashMap == null) {
            HiLog.i("ABTestManager", "onEvent: mapValue is empty!");
            linkedHashMap = new LinkedHashMap<>();
        }
        ikl iklVar2 = ikl.hij;
        String str4 = "";
        ConcurrentHashMap<String, ijk> concurrentHashMap = iklVar2.lmn;
        if (concurrentHashMap == null) {
            HiLog.w("ABDataCenter", "getGroupID(): Experiment data is empty.");
        } else if (concurrentHashMap.get(str) == null) {
            HiLog.i("ABDataCenter", "getGroupID: Not found getGroupId from expParamKey");
        } else {
            str4 = iklVar2.lmn.get(str).klm;
            if (str4 == null) {
                HiLog.i("ABDataCenter", "getGroupID: groupId is null");
                str4 = "";
            }
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("groupId", str4);
        } catch (JSONException unused) {
            HiLog.w("ABTestManager", "json exception from getGroupId");
        }
        linkedHashMap.put("experiment", jSONObject.toString());
        klm klmVar = ikl.hij.ijk;
        if (klmVar == null) {
            HiLog.i("ABDataCenter", "getUserID(): ABDataCenter needs init first");
            str3 = "";
        } else {
            str3 = klmVar.ijk;
        }
        if (!str3.equals(linkedHashMap.get(as.f32242q))) {
            linkedHashMap.put(as.f32242q, str3);
        }
        lmnVar.ikl.onEvent(str2, linkedHashMap);
    }

    public static void onReport() {
        boolean z10;
        HiLog.i(TAG, "onReport() is execute");
        lmn lmnVar = lmn.ghi;
        Objects.requireNonNull(lmnVar);
        ikl iklVar = ikl.hij;
        synchronized (iklVar) {
            z10 = iklVar.ikl;
        }
        if (!z10) {
            HiLog.w("ABTestManager", "onReport : ABTest sdk is not initialized");
            return;
        }
        HiAnalyticsInstance hiAnalyticsInstance = lmnVar.ikl;
        if (hiAnalyticsInstance == null) {
            HiLog.w("ABTestManager", "instance is null");
        } else {
            hiAnalyticsInstance.onReport(0);
        }
    }

    public static void setExpSyncInterval(int i10) {
        boolean z10;
        HiLog.i(TAG, "setExpSyncInterval() is execute");
        if (i10 < 10) {
            i10 = 10;
        }
        lmn lmnVar = lmn.ghi;
        Objects.requireNonNull(lmnVar);
        ikl iklVar = ikl.hij;
        synchronized (iklVar) {
            z10 = iklVar.ikl;
        }
        if (!z10) {
            HiLog.w("ABTestManager", "setSyncInterval : ABTest sdk is not initialized");
        } else {
            lmnVar.hij = i10 * 60000;
        }
    }

    public static void syncExpParameters() {
        boolean z10;
        HiLog.i(TAG, "syncExpParameters() is execute");
        lmn lmnVar = lmn.ghi;
        Objects.requireNonNull(lmnVar);
        ikl iklVar = ikl.hij;
        synchronized (iklVar) {
            z10 = iklVar.ikl;
        }
        if (!z10) {
            HiLog.w("ABTestManager", "syncExpParameters: ABTest sdk is not initialized");
        } else {
            lmnVar.ijk.execute(new ghi());
        }
    }
}
