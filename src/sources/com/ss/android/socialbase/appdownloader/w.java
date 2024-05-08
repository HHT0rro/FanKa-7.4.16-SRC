package com.ss.android.socialbase.appdownloader;

import android.content.Context;
import com.huawei.quickcard.base.Attributes;
import com.huawei.quickcard.framework.bean.CardElement;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class w {
    public static int dk(String str) {
        return m(DownloadComponentManager.getAppContext(), str);
    }

    public static int ej(String str) {
        try {
            return m(str, DownloadComponentManager.getAppContext().getPackageName());
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static int l(String str) {
        try {
            return DownloadComponentManager.getAppContext().getResources().getIdentifier(str, "style", DownloadComponentManager.getAppContext().getPackageName());
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static int m(String str) {
        try {
            return DownloadComponentManager.getAppContext().getResources().getIdentifier(str, "layout", DownloadComponentManager.getAppContext().getPackageName());
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static int n(String str) {
        try {
            return DownloadComponentManager.getAppContext().getResources().getIdentifier(str, "color", DownloadComponentManager.getAppContext().getPackageName());
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static int np(String str) {
        try {
            return DownloadComponentManager.getAppContext().getResources().getIdentifier(str, "id", DownloadComponentManager.getAppContext().getPackageName());
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static int dk(String str, String str2) {
        try {
            return DownloadComponentManager.getAppContext().getResources().getIdentifier(str, CardElement.Field.ATTRIBUTES, str2);
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static int m(Context context, String str) {
        try {
            return context.getResources().getIdentifier(str, Attributes.TextOverflow.STRING, context.getPackageName());
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static int m(String str, String str2) {
        try {
            return DownloadComponentManager.getAppContext().getResources().getIdentifier(str, "drawable", str2);
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }
}
