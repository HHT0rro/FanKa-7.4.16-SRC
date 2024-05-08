package com.tanx.exposer.achieve;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public enum AdMonitorType {
    CLICK("点击"),
    EXPOSE("曝光"),
    INTERACT("互动");

    public String description;

    AdMonitorType(String str) {
        this.description = str;
    }

    public static boolean inSystemTypes(AdMonitorType adMonitorType) {
        if (adMonitorType != null) {
            return adMonitorType == CLICK || adMonitorType == EXPOSE || adMonitorType == INTERACT;
        }
        return false;
    }
}
