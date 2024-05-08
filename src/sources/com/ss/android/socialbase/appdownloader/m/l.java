package com.ss.android.socialbase.appdownloader.m;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.dynamicloader.b;
import com.ss.android.socialbase.downloader.constants.DbJsonConstants;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import java.io.File;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class l {
    public static m m(Context context, String str, JSONObject jSONObject, DownloadInfo downloadInfo) {
        if (downloadInfo == null || context == null || jSONObject == null) {
            return null;
        }
        String savePath = downloadInfo.getSavePath();
        if (TextUtils.isEmpty(savePath) || TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(savePath);
        DownloadSetting obtain = DownloadSetting.obtain(downloadInfo);
        if (str.equals(b.f29144f)) {
            return new oa(context, obtain, downloadInfo.getTargetFilePath());
        }
        if (str.equals("v2")) {
            return new c(context, obtain, file.getAbsolutePath());
        }
        if (str.equals(com.huawei.hms.feature.dynamic.b.f29880u)) {
            return new ve(context, obtain, file.getAbsolutePath());
        }
        if (str.equals("o1")) {
            return new hc(context, obtain, file.getAbsolutePath());
        }
        if (str.equals("o2")) {
            return new e(context, obtain, file.getAbsolutePath());
        }
        if (str.equals("o3")) {
            String dBJsonString = downloadInfo.getDBJsonString(DbJsonConstants.CONTENT_URI);
            if (TextUtils.isEmpty(dBJsonString)) {
                return null;
            }
            return new w(context, obtain, file.getAbsolutePath(), dBJsonString, downloadInfo.getName());
        }
        if (str.equals("custom")) {
            return new ej(context, obtain, file.getAbsolutePath(), jSONObject);
        }
        if (!str.equals("vbi")) {
            return null;
        }
        return new sy(context, obtain, com.ss.android.socialbase.appdownloader.ej.m(downloadInfo.getId(), Downloader.getInstance(context).getDownloadFileUriProvider(downloadInfo.getId()), context, com.ss.android.socialbase.appdownloader.l.oa().l(), new File(downloadInfo.getSavePath() + File.separator + downloadInfo.getName())).toString());
    }

    public static boolean m(Context context, String str, JSONObject jSONObject, DownloadSetting downloadSetting) {
        if (context == null || str == null) {
            return false;
        }
        m mVar = null;
        String dk = com.ss.android.socialbase.appdownloader.ej.dk();
        if (TextUtils.isEmpty(dk) || TextUtils.isEmpty(str)) {
            return false;
        }
        if (com.ss.android.socialbase.appdownloader.n.np.l() && str.equals(b.f29144f)) {
            mVar = new oa(context, downloadSetting, dk);
        } else if (com.ss.android.socialbase.appdownloader.n.np.l() && str.equals("v2")) {
            mVar = new c(context, downloadSetting, dk);
        } else if (com.ss.android.socialbase.appdownloader.n.np.l() && str.equals(com.huawei.hms.feature.dynamic.b.f29880u)) {
            mVar = new ve(context, downloadSetting, dk);
        } else if (com.ss.android.socialbase.appdownloader.n.np.np() && str.equals("o1")) {
            mVar = new hc(context, downloadSetting, dk);
        } else if (com.ss.android.socialbase.appdownloader.n.np.np() && str.equals("o2")) {
            mVar = new e(context, downloadSetting, dk);
        } else if (com.ss.android.socialbase.appdownloader.n.np.np() && str.equals("o3")) {
            mVar = new w(context, downloadSetting, dk, dk, dk);
        } else if (com.ss.android.socialbase.appdownloader.n.np.l() && str.equals("custom")) {
            mVar = new ej(context, downloadSetting, dk, jSONObject);
        } else if (com.ss.android.socialbase.appdownloader.n.np.l() && str.equals("vbi")) {
            mVar = new sy(context, downloadSetting, dk);
        }
        return mVar != null && mVar.m();
    }
}
