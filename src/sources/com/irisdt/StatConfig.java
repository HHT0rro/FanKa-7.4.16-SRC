package com.irisdt;

import android.content.Context;
import com.irisdt.util.Logger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class StatConfig {
    private static final int ABTEST_MASK = 32;
    private static final int APM_MASK = 1;
    private static final int CLIENT_MASK = 16;
    private static final int DAU_MASK = 8;
    private static final int EVENT_MASK = 2;
    public static final int MINUTE = 60000;
    private static final int PAGE_MASK = 4;
    public static final int SECOND = 1000;
    public static final int STACK_MAX = 30;
    public static final int STAT_DAU_PERIOD = 300000;
    public static final int STAT_PERIOD = 5000;
    private static final int TOTAL_MASK = 63;
    private static Context appContext;
    private static int enableStatistics;
    private static int logEnable;
    public static final String LIB_NAME = "irisdt";
    private static Logger logger = new Logger(LIB_NAME);

    public static Context getAppContext() {
        return appContext;
    }

    public static String getThreadName(String str) {
        if (str == null || str.trim().length() <= 0) {
            return LIB_NAME;
        }
        return LIB_NAME + "-" + str;
    }

    public static boolean isAbtestEnable() {
        return isBizEnable(32);
    }

    public static boolean isAbtestLogEnable() {
        return isBizLogEnable(32);
    }

    public static boolean isApmEnable() {
        return isBizEnable(1);
    }

    public static boolean isApmLogEnable() {
        return isBizLogEnable(1);
    }

    private static boolean isBizEnable(int i10) {
        return (enableStatistics & i10) == i10;
    }

    private static boolean isBizLogEnable(int i10) {
        return (logEnable & i10) == i10;
    }

    public static boolean isClientEnable() {
        return isBizEnable(16);
    }

    public static boolean isClientLogEnable() {
        return isBizLogEnable(16);
    }

    public static boolean isDauEnable() {
        return isBizEnable(8);
    }

    public static boolean isDauLogEnable() {
        return isBizLogEnable(8);
    }

    public static boolean isEventEnable() {
        return isBizEnable(2);
    }

    public static boolean isEventLogEnable() {
        return isBizLogEnable(2);
    }

    public static boolean isLogEnable() {
        return logEnable != 0;
    }

    public static boolean isPageEnable() {
        return isBizEnable(4);
    }

    public static boolean isPageLogEnable() {
        return isBizLogEnable(4);
    }

    public static Logger log() {
        return logger;
    }

    public static void setAbtestEnable(boolean z10) {
        setBizEnable(32, z10);
    }

    public static void setAbtestLogEnable(boolean z10) {
        setBizLogEnable(32, z10);
    }

    public static void setApmEnable(boolean z10) {
        setBizEnable(1, z10);
    }

    public static void setApmLogEnable(boolean z10) {
        setBizLogEnable(1, z10);
    }

    public static void setAppContext(Context context) {
        appContext = context;
    }

    private static void setBizEnable(int i10, boolean z10) {
        enableStatistics = (z10 ? 63 : ~i10) & enableStatistics;
    }

    private static void setBizLogEnable(int i10, boolean z10) {
        if (z10) {
            logEnable = i10 | logEnable;
        } else {
            logEnable = (~i10) & logEnable;
        }
    }

    public static void setClientEnable(boolean z10) {
        setBizEnable(16, z10);
    }

    public static void setClientLogEnable(boolean z10) {
        setBizLogEnable(16, z10);
    }

    public static void setDauEnable(boolean z10) {
        setBizEnable(8, z10);
    }

    public static void setDauLogEnable(boolean z10) {
        setBizLogEnable(8, z10);
    }

    public static void setEnable(boolean z10) {
        enableStatistics = z10 ? 63 : 0;
        if (z10) {
            return;
        }
        setLogEnable(false);
    }

    public static void setEventEnable(boolean z10) {
        setBizEnable(2, z10);
    }

    public static void setEventLogEnable(boolean z10) {
        setBizLogEnable(2, z10);
    }

    public static void setLogEnable(boolean z10) {
        logEnable = z10 ? 63 : 0;
    }

    public static void setPageEnable(boolean z10) {
        setBizEnable(4, z10);
    }

    public static void setPageLogEnable(boolean z10) {
        setBizLogEnable(4, z10);
    }
}
