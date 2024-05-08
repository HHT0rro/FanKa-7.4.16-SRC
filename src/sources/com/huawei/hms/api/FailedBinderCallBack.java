package com.huawei.hms.api;

import com.huawei.hms.support.log.HMSLog;
import java.sql.Timestamp;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class FailedBinderCallBack {
    private static final long AGING_TIME = 10000;
    public static final String CALLER_ID = "callId";
    private static final String TAG = "FailedBinderCallBack";
    private static FailedBinderCallBack instance;
    private static Map<Long, BinderCallBack> binderCallBackMap = new ConcurrentHashMap();
    private static final Object LOCK_OBJECT = new Object();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface BinderCallBack {
        void binderCallBack(int i10);
    }

    private FailedBinderCallBack() {
    }

    private void agingCheck() {
        long time = new Timestamp(System.currentTimeMillis()).getTime() - AGING_TIME;
        for (Long l10 : binderCallBackMap.h()) {
            if (time >= l10.longValue()) {
                binderCallBackMap.remove(l10);
            }
        }
    }

    public static FailedBinderCallBack getInstance() {
        synchronized (LOCK_OBJECT) {
            if (instance == null) {
                instance = new FailedBinderCallBack();
            }
        }
        return instance;
    }

    private void putCallBackInMap(Long l10, BinderCallBack binderCallBack) {
        if (binderCallBackMap == null) {
            HMSLog.e(TAG, "binderCallBackMap is null");
        } else {
            agingCheck();
            binderCallBackMap.put(l10, binderCallBack);
        }
    }

    public BinderCallBack getCallBack(Long l10) {
        Map<Long, BinderCallBack> map = binderCallBackMap;
        if (map == null) {
            HMSLog.e(TAG, "binderCallBackMap is null");
            return null;
        }
        return map.remove(l10);
    }

    public void setCallBack(Long l10, BinderCallBack binderCallBack) {
        putCallBackInMap(l10, binderCallBack);
    }
}
