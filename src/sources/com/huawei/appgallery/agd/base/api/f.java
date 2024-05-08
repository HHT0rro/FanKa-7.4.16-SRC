package com.huawei.appgallery.agd.base.api;

/* compiled from: AgdManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final /* synthetic */ class f {
    public static String a(int i10) {
        switch (i10) {
            case 1:
                return "VERIFICATION_FAIL";
            case 2:
                return "CHILD_OMDLE_FAIL";
            case 3:
                return "CONTENT_LIMIT_FAIL";
            case 4:
                return "LOCAL_HIGH_VERSION_FAIL";
            case 5:
                return "MOBIL_NET_DIALOG_FAIL";
            case 6:
                return "RESUME_TASK";
            case 7:
                return "UN_KNOW_DISTWAY";
            case 8:
                return "HIDDEN_INFO_NULL";
            case 9:
                return "APP_INSTALLING";
            case 10:
                return "WLAN_DOWNLOAD_BY_OTHER_MEDIA";
            case 11:
                return "CALLTYPE_DEFAULT";
            default:
                return "unknown childCode: " + i10;
        }
    }
}
