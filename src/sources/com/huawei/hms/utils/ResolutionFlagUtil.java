package com.huawei.hms.utils;

import android.text.TextUtils;
import com.huawei.hms.support.log.HMSLog;
import java.sql.Timestamp;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ResolutionFlagUtil {

    /* renamed from: a, reason: collision with root package name */
    private static volatile ResolutionFlagUtil f31971a;

    /* renamed from: b, reason: collision with root package name */
    private static final Map<String, Long> f31972b = new ConcurrentHashMap();

    /* renamed from: c, reason: collision with root package name */
    private static final Object f31973c = new Object();

    private ResolutionFlagUtil() {
    }

    private void a() {
        long time = new Timestamp(System.currentTimeMillis()).getTime() - 10800000;
        for (String str : f31972b.h()) {
            Map<String, Long> map = f31972b;
            Long l10 = map.get(str);
            if (l10 == null || l10.longValue() == 0) {
                map.remove(str);
                HMSLog.i("ResolutionFlagUtil", "remove resolution flag because the data in this pair was abnormal: " + str);
            } else if (time >= l10.longValue()) {
                map.remove(str);
                HMSLog.i("ResolutionFlagUtil", "remove resolution flag because aging time: " + str);
            }
        }
    }

    public static ResolutionFlagUtil getInstance() {
        if (f31971a != null) {
            return f31971a;
        }
        synchronized (f31973c) {
            if (f31971a == null) {
                f31971a = new ResolutionFlagUtil();
            }
        }
        return f31971a;
    }

    public long getResolutionFlag(String str) {
        if (str == null) {
            HMSLog.e("ResolutionFlagUtil", "transactionId is null");
            return 0L;
        }
        Map<String, Long> map = f31972b;
        if (map.get(str) != null) {
            return map.get(str).longValue();
        }
        return 0L;
    }

    public void removeResolutionFlag(String str) {
        if (str == null) {
            HMSLog.e("ResolutionFlagUtil", "transactionId is null");
        } else {
            f31972b.remove(str);
            HMSLog.i("ResolutionFlagUtil", "remove resolution flag");
        }
    }

    public void saveResolutionFlag(String str, long j10) {
        if (!TextUtils.isEmpty(str) && j10 != 0) {
            a(str, j10);
            return;
        }
        HMSLog.e("ResolutionFlagUtil", "saveResolutionFlag error, transactionId: " + str + ", timestamp: " + j10);
    }

    private void a(String str, long j10) {
        Map<String, Long> map = f31972b;
        synchronized (map) {
            a();
            map.put(str, Long.valueOf(j10));
            HMSLog.i("ResolutionFlagUtil", "save resolution flag");
        }
    }
}
