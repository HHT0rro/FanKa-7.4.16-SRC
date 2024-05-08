package com.ss.android.socialbase.downloader.utils;

import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class DownloadSettingsUtils {
    public static boolean isOptimizeAddListener(DownloadInfo downloadInfo) {
        return downloadInfo != null && DownloadSetting.obtain(downloadInfo.getId()).optInt(DownloadSettingKeys.OptimizeForError.OPTIMIZE_ADD_LISTENER) == 1;
    }

    public static boolean isOptimizeHeadRequest(DownloadInfo downloadInfo) {
        return downloadInfo != null && DownloadSetting.obtain(downloadInfo.getId()).optInt(DownloadSettingKeys.OptimizeForError.OPTIMIZE_HEAD_REQUEST) == 1;
    }

    public static boolean isOptimizeSavePath(DownloadInfo downloadInfo) {
        return downloadInfo != null && DownloadSetting.obtain(downloadInfo.getId()).optInt(DownloadSettingKeys.OptimizeForError.OPTIMIZE_SAVE_PATH) == 1;
    }
}
