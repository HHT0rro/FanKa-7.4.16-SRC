package com.huawei.hms.framework.common.hianalytics;

import android.content.Context;
import android.provider.Settings;
import androidx.annotation.NonNull;
import com.huawei.hianalytics.process.HiAnalyticsInstance;
import com.huawei.hianalytics.process.HiAnalyticsManager;
import com.huawei.hms.framework.common.ContextHolder;
import com.huawei.hms.framework.common.ExecutorsUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtils;
import com.huawei.hms.utils.HMSBIInitializer;
import java.security.SecureRandom;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class HianalyticsHelper {
    private static final String DEAULT_HA_SERVICE_TAG = "_default_config_tag";
    private static final String HWID_HA_SERVICE_TAG = "hms_hwid";
    private static final String TAG = "HianalyticsHelper";
    private static final int TYPE_MAINTF = 1;
    private static final String USER_EXPERIENCE_INVOLVED = "user_experience_involved";
    private static final int USER_EXPERIENCE_ON = 1;
    private static volatile HianalyticsHelper instance;
    private boolean bInstallWelink;
    private boolean hasHMSBI;
    private boolean hasHianalytics;
    private ReportCallBack reportCallback;
    private String haTag = HWID_HA_SERVICE_TAG;
    private HiAnalyticsInstance hInstance = null;
    private boolean isEnablePrivacyPolicy = false;
    private ExecutorService reportExecutor = ExecutorsUtils.newSingleThreadExecutor("report_ha");
    private boolean bReportable = true;
    private boolean bQuicReportable = true;
    private final int random = new SecureRandom().nextInt(1000);

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class HianalyticsRunnable implements Runnable {
        private final HianalyticsBaseData data;
        private final String event;

        public HianalyticsRunnable(HianalyticsBaseData hianalyticsBaseData, String str) {
            this.data = hianalyticsBaseData;
            this.event = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            HianalyticsHelper.getInstance().onEvent(this.data.get(), this.event);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public interface ReportCallBack {
        void onReport(int i10, String str, LinkedHashMap<String, String> linkedHashMap);
    }

    private HianalyticsHelper() {
        try {
            HiAnalyticsManager.getInitFlag(DEAULT_HA_SERVICE_TAG);
            this.hasHianalytics = true;
        } catch (Throwable unused) {
            Logger.i(TAG, "Hianalytics sdk not found");
            this.hasHianalytics = false;
        }
        if (!this.hasHianalytics) {
            tryHMSBIInit(ContextHolder.getAppContext());
        }
        try {
            this.bInstallWelink = ContextHolder.getAppContext().getPackageManager().getPackageInfo("com.huawei.works", 0) != null;
        } catch (Exception unused2) {
            this.bInstallWelink = false;
        }
        Logger.v(TAG, "this time the ha %s, mini %s", Boolean.valueOf(this.hasHianalytics), Boolean.valueOf(this.hasHMSBI));
    }

    public static HianalyticsHelper getInstance() {
        if (instance == null) {
            synchronized (HianalyticsHelper.class) {
                if (instance == null) {
                    instance = new HianalyticsHelper();
                }
            }
        }
        return instance;
    }

    private boolean isHianalyticsOk() {
        if (this.hInstance != null) {
            return true;
        }
        if (HiAnalyticsManager.getInitFlag(DEAULT_HA_SERVICE_TAG)) {
            this.hInstance = HiAnalyticsManager.getInstanceByTag(DEAULT_HA_SERVICE_TAG);
        } else {
            this.hInstance = HiAnalyticsManager.getInstanceByTag(this.haTag);
        }
        return this.hInstance != null;
    }

    private void onNewEvent(Context context, String str, Map map, int i10) {
        if (context == null || map == null) {
            return;
        }
        Logger.v(TAG, "data = %s", map);
        try {
            HiAnalyticsUtils.getInstance().onNewEvent(context, str, map, i10);
        } catch (NoSuchMethodError unused) {
            Logger.w(TAG, "may be you need upgrade stats sdk");
        } catch (Throwable unused2) {
            Logger.i(TAG, "the stats has other error,pls check it");
        }
    }

    private void tryHMSBIInit(Context context) {
        if (context == null) {
            Logger.i(TAG, "the appContext hasn't init");
            return;
        }
        try {
            HMSBIInitializer.getInstance(context).initBI();
            this.hasHMSBI = true;
        } catch (NoClassDefFoundError unused) {
            Logger.w(TAG, "maybe you need add base sdk!");
        } catch (Throwable unused2) {
            Logger.w(TAG, "the hms base has other error!");
        }
    }

    public void enablePrivacyPolicy(boolean z10) {
        this.isEnablePrivacyPolicy = z10;
    }

    public void executeReportHa(HianalyticsBaseData hianalyticsBaseData, String str) {
        getReportExecutor().execute(new HianalyticsRunnable(hianalyticsBaseData, str));
    }

    public ExecutorService getReportExecutor() {
        return this.reportExecutor;
    }

    public boolean inRate() {
        return this.bReportable;
    }

    public boolean isEnableReport(Context context) {
        return isEnableReport(context, true, false);
    }

    public boolean isEnableReportNoSeed(Context context) {
        return isEnableReport(context, false, false);
    }

    public boolean isQuicEnableReport(Context context) {
        return isEnableReport(context, true, true);
    }

    public void onEvent(LinkedHashMap<String, String> linkedHashMap, String str) {
        onEvent(linkedHashMap, str, 1);
    }

    public void reportData(Context context, LinkedHashMap<String, String> linkedHashMap, String str, int i10) {
        if (isEnableReportNoSeed(context)) {
            onEvent(linkedHashMap, str, i10);
        }
    }

    public void reportException(final Throwable th, final String str) {
        if (getInstance().isEnableReportNoSeed(ContextHolder.getAppContext())) {
            final String name = Thread.currentThread().getName();
            try {
                this.reportExecutor.submit(new Runnable() { // from class: com.huawei.hms.framework.common.hianalytics.HianalyticsHelper.1
                    @Override // java.lang.Runnable
                    public void run() {
                        CrashHianalyticsData crashHianalyticsData = new CrashHianalyticsData();
                        crashHianalyticsData.put("sdk_version", "7.0.2.301");
                        crashHianalyticsData.put(CrashHianalyticsData.CRASH_TYPE, "exception");
                        crashHianalyticsData.put(CrashHianalyticsData.THREAD_NAME, name);
                        crashHianalyticsData.put(CrashHianalyticsData.EXCEPTION_NAME, th.getClass().getName());
                        crashHianalyticsData.put("message", StringUtils.anonymizeMessage(th.getMessage()));
                        crashHianalyticsData.put(CrashHianalyticsData.STACK_TRACE, StringUtils.getTraceInfo(th));
                        HianalyticsHelper.getInstance().onEvent(crashHianalyticsData.get(), str);
                    }
                });
            } catch (RejectedExecutionException unused) {
                Logger.i(TAG, "reportException error RejectedExecutionException");
            } catch (Exception unused2) {
                Logger.i(TAG, "reportException error!", th);
            }
        }
    }

    public void setHaTag(String str) {
        this.haTag = str;
    }

    public void setQuicRate(int i10) {
        boolean z10 = true;
        if (i10 >= 0 && i10 < 1000) {
            if (this.random >= i10 && !this.bInstallWelink) {
                z10 = false;
            }
            this.bQuicReportable = z10;
            return;
        }
        this.bQuicReportable = true;
    }

    public void setRate(int i10) {
        boolean z10 = true;
        if (i10 >= 0 && i10 < 1000) {
            if (this.random >= i10 && !this.bInstallWelink) {
                z10 = false;
            }
            this.bReportable = z10;
            Logger.i(TAG, "bReportable = " + this.bReportable + ", inuser = " + this.bInstallWelink + ", rate = " + i10);
            return;
        }
        this.bReportable = true;
    }

    public void setReportCallback(ReportCallBack reportCallBack) {
        this.reportCallback = reportCallBack;
    }

    private boolean isEnableReport(@NonNull Context context, boolean z10, boolean z11) {
        if (this.reportCallback != null) {
            return true;
        }
        if (z10 && ((z11 && !this.bQuicReportable) || (!z11 && !this.bReportable))) {
            return false;
        }
        if (this.hasHMSBI) {
            return true;
        }
        if (!this.hasHianalytics) {
            return false;
        }
        if (this.isEnablePrivacyPolicy) {
            return isHianalyticsOk();
        }
        try {
            if (Settings.Secure.getInt(context.getContentResolver(), USER_EXPERIENCE_INVOLVED, -1) == 1) {
                return isHianalyticsOk();
            }
        } catch (IllegalStateException unused) {
            Logger.w(TAG, "the setting has illegalStateException");
        } catch (Throwable unused2) {
            Logger.w(TAG, "the setting has other error");
        }
        Logger.i(TAG, "user experience involved needs to be opened");
        return false;
    }

    public void onEvent(LinkedHashMap<String, String> linkedHashMap, String str, int i10) {
        if (linkedHashMap == null) {
            return;
        }
        linkedHashMap.put("in_user", "" + (this.bInstallWelink ? 1 : 0));
        Logger.v(TAG, "data = %s", linkedHashMap);
        ReportCallBack reportCallBack = this.reportCallback;
        if (reportCallBack != null) {
            reportCallBack.onReport(i10, str, linkedHashMap);
            return;
        }
        if (this.hasHMSBI) {
            onNewEvent(ContextHolder.getAppContext(), str, linkedHashMap, i10);
        } else if (i10 == 0) {
            Logger.v(TAG, "the base sdk isn't exsit, and reportType is %s", Integer.valueOf(i10));
            return;
        }
        if (this.hasHianalytics) {
            HiAnalyticsInstance hiAnalyticsInstance = this.hInstance;
            if (hiAnalyticsInstance != null) {
                hiAnalyticsInstance.onEvent(1, str, linkedHashMap);
            } else {
                Logger.e(TAG, "the ha has error,has init but is null!");
            }
        }
    }

    public void onEvent(LinkedHashMap<String, String> linkedHashMap) {
        onEvent(linkedHashMap, HianalyticsBaseData.EVENT_ID);
    }
}
