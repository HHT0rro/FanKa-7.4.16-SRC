package l9;

import com.huawei.openalliance.ad.constant.as;

/* compiled from: DownloadStatusUtil.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class a {
    public static String a(int i10) {
        switch (i10) {
            case -1:
                return "WAIT_FOR_WIFI";
            case 0:
            case 9:
            default:
                return "downloadStatus: " + i10;
            case 1:
                return "PRE_DOWNLOAD";
            case 2:
                return "DOWNLOAD";
            case 3:
                return "CANCEL_DOWNLOAD";
            case 4:
                return "DOWNLOADED";
            case 5:
                return "DOWNLOAD_FAILED";
            case 6:
                return "DOWNLOAD_PAUSED";
            case 7:
                return "DOWNLOAD_MERGE";
            case 8:
                return "DOWNLOAD_EXCEPTION";
            case 10:
                return "REDOWNLOAD_START_IN_HTTPS";
        }
    }

    public static String b(int i10) {
        if (i10 == -2) {
            return "SILENT_INSTALL_FAILED";
        }
        if (i10 == -1) {
            return "INSTALL_FAILED";
        }
        if (i10 == 0) {
            return "WAIT_INSTALL";
        }
        if (i10 == 1) {
            return "INSTALLING";
        }
        if (i10 == 2) {
            return "INSTALL_SUCCESS";
        }
        return "installstatus: " + i10;
    }

    public static String c(int i10) {
        switch (i10) {
            case 0:
                return "unInstalled";
            case 1:
                return "downloading";
            case 2:
                return "download paused";
            case 3:
                return as.ah;
            case 4:
                return "installed";
            case 5:
                return "install failed";
            case 6:
                return "download failed";
            case 7:
                return "download success";
            default:
                return "";
        }
    }
}
