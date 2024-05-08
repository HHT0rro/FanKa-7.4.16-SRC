package com.alimm.tanx.core.ad.ad.splash;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.alimm.tanx.core.utils.LogUtils;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* compiled from: SplashAdAnalytics.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class tanxc_do {
    public static tanxc_do tanxc_do;
    public List<RsDownloadStatus> tanxc_if = new ArrayList();
    public Queue<String> tanxc_for = new LinkedList();
    public long tanxc_int = 0;

    public static tanxc_do tanxc_do() {
        if (tanxc_do == null) {
            synchronized (tanxc_do.class) {
                if (tanxc_do == null) {
                    tanxc_do = new tanxc_do();
                }
            }
        }
        return tanxc_do;
    }

    public synchronized void tanxc_do(@NonNull Context context) {
        this.tanxc_if.clear();
        SharedPreferences.Editor edit = context.getSharedPreferences("mm_adsdk_rs_download_info", 0).edit();
        edit.clear();
        edit.apply();
    }

    public synchronized void tanxc_do(@NonNull Context context, @NonNull String str, int i10) {
        LogUtils.d("SplashAdAnalytics", "setRsDownloadStatus: resourceName = " + str + ", status = " + i10);
        if (i10 == 0) {
            RsDownloadStatus rsDownloadStatus = new RsDownloadStatus(str, i10);
            this.tanxc_if.add(rsDownloadStatus);
            tanxc_do(context, rsDownloadStatus);
        } else {
            for (RsDownloadStatus rsDownloadStatus2 : this.tanxc_if) {
                if (TextUtils.equals(rsDownloadStatus2.getFileName(), str)) {
                    rsDownloadStatus2.setStatus(i10);
                    tanxc_do(context, rsDownloadStatus2);
                }
            }
        }
    }

    private void tanxc_do(@NonNull Context context, @NonNull RsDownloadStatus rsDownloadStatus) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mm_adsdk_rs_download_info", 0).edit();
        edit.putInt(rsDownloadStatus.getFileName(), rsDownloadStatus.getStatus());
        edit.apply();
    }
}
