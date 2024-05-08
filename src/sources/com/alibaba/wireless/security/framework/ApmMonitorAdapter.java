package com.alibaba.wireless.security.framework;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ApmMonitorAdapter {
    public static boolean isEnableFullTrackRecord() {
        return SGApmMonitorManager.getInstance().isEnableFullTrackRecord();
    }

    public static boolean isForeground() {
        return SGApmMonitorManager.getInstance().isForeground();
    }

    public static void jstage(String str, String str2) {
        SGApmMonitorManager.getInstance().addTrackInfo("j_" + str + "_" + str2);
    }

    public static void jstageEnd(String str, String str2) {
        SGApmMonitorManager.getInstance().addTrackInfo("j_" + str + "_" + str2 + "_e");
    }

    public static void jstageStart(String str, String str2) {
        SGApmMonitorManager.getInstance().addTrackInfo("j_" + str + "_" + str2 + "_s");
    }

    public static void stage(String str, String str2) {
        SGApmMonitorManager.getInstance().addTrackInfo(str + "_" + str2);
    }

    public static void stageEnd(String str, String str2) {
        SGApmMonitorManager.getInstance().addTrackInfo(str + "_" + str2 + "_e");
    }

    public static void stageStart(String str, String str2) {
        SGApmMonitorManager.getInstance().addTrackInfo(str + "_" + str2 + "_s");
    }
}
