package com.ss.android.downloadlib.hc;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.huawei.openalliance.ad.constant.u;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class np {
    @NonNull
    public static DownloadSetting dk(DownloadModel downloadModel) {
        return DownloadSetting.obtain(m(downloadModel));
    }

    public static int ej(@NonNull DownloadModel downloadModel) {
        return m(dk(downloadModel));
    }

    public static boolean hc(int i10) {
        return DownloadSetting.obtain(i10).optInt("clean_app_cache_dir", 0) == 1;
    }

    public static boolean l(int i10) {
        return DownloadSetting.obtain(i10).optLong("clean_fetch_apk_switch", 0L) == 1;
    }

    @Nullable
    public static JSONObject m() {
        return com.ss.android.downloadlib.addownload.c.w().optJSONObject("ad");
    }

    public static boolean n(int i10) {
        return DownloadSetting.obtain(i10).optInt("clean_space_switch", 0) == 1;
    }

    public static boolean np(int i10) {
        return DownloadSetting.obtain(i10).optLong("clean_space_before_download_switch", 0L) == 1;
    }

    public static boolean dk(com.ss.android.downloadad.api.m.m mVar) {
        return m(mVar).optInt("pause_reserve_on_wifi", 0) == 1 && mVar.t();
    }

    public static long l() {
        long optLong = com.ss.android.downloadlib.addownload.c.w().optLong("start_install_interval");
        return optLong == 0 ? u.as : optLong;
    }

    public static JSONObject m(DownloadModel downloadModel) {
        if (downloadModel == null) {
            return null;
        }
        return downloadModel.isAd() ? ve.m(com.ss.android.downloadlib.addownload.c.w(), downloadModel.getDownloadSettings()) : downloadModel.getDownloadSettings();
    }

    public static long np() {
        long optLong = com.ss.android.downloadlib.addownload.c.w().optLong("next_install_min_interval");
        if (optLong == 0) {
            return 10000L;
        }
        return optLong;
    }

    public static boolean ej(com.ss.android.downloadad.api.m.m mVar) {
        return m(mVar).optInt("cancel_pause_optimise_wifi_retain_switch", 0) == 1 && mVar.t();
    }

    public static long dk(int i10) {
        return DownloadSetting.obtain(i10).optLong("storage_min_size", 0L);
    }

    public static boolean dk(DownloadSetting downloadSetting) {
        return downloadSetting != null && downloadSetting.optInt("kllk_need_rename_apk", 0) == 1;
    }

    public static long ej(int i10) {
        return DownloadSetting.obtain(i10).optLong("clean_fetch_apk_head_time_out", 800L);
    }

    @NonNull
    public static DownloadSetting m(com.ss.android.downloadad.api.m.m mVar) {
        if (mVar == null) {
            return DownloadSetting.obtainGlobal();
        }
        if (mVar.x() != 0) {
            return DownloadSetting.obtain(mVar.x());
        }
        if (mVar.ej()) {
            return DownloadSetting.obtain(m());
        }
        if (mVar.f() != null) {
            return DownloadSetting.obtain(mVar.f());
        }
        return DownloadSetting.obtainGlobal();
    }

    public static boolean dk() {
        return DownloadSetting.obtainGlobal().optBugFix("fix_notification_anr");
    }

    public static boolean ej() {
        return com.ss.android.downloadlib.addownload.c.w().optInt("is_enable_start_install_again") == 1;
    }

    public static int m(@NonNull DownloadSetting downloadSetting) {
        return downloadSetting.optInt("external_storage_permission_path_type", 0);
    }

    public static double m(int i10) {
        return DownloadSetting.obtain(i10).optDouble("clean_min_install_size", ShadowDrawableWrapper.COS_45);
    }
}
