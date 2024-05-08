package com.ss.android.downloadlib.ej;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.alibaba.wireless.security.securitybodysdk.BuildConfig;
import com.ss.android.downloadlib.addownload.c;
import com.ss.android.socialbase.downloader.constants.DbJsonConstants;
import com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.File;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class m implements IDownloadCompleteHandler {
    private boolean m(DownloadInfo downloadInfo) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(downloadInfo.getSavePath());
        String str = File.separator;
        sb2.append(str);
        sb2.append(downloadInfo.getName());
        String sb3 = sb2.toString();
        File file = new File(sb3);
        String m10 = com.ss.android.socialbase.appdownloader.n.m.np.m(c.getContext(), com.ss.android.socialbase.appdownloader.ej.m(downloadInfo, file), sb3);
        boolean z10 = false;
        if (!TextUtils.isEmpty(m10)) {
            String str2 = m10 + ".apk";
            if (str2.equals(downloadInfo.getName())) {
                return true;
            }
            try {
                z10 = file.renameTo(new File(downloadInfo.getSavePath() + str + str2));
                if (z10) {
                    downloadInfo.setName(str2);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return z10;
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler
    public void handle(DownloadInfo downloadInfo) throws BaseException {
        if (downloadInfo == null || !m(downloadInfo)) {
            return;
        }
        m(c.getContext(), downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.depend.IDownloadCompleteHandler
    public boolean needHandle(DownloadInfo downloadInfo) {
        if (downloadInfo != null) {
            return com.ss.android.downloadlib.hc.np.dk(DownloadSetting.obtain(downloadInfo.getId()));
        }
        return false;
    }

    private void m(Context context, final DownloadInfo downloadInfo) {
        String str = downloadInfo.getSavePath() + File.separator + downloadInfo.getName();
        Cursor query = context.getContentResolver().query(MediaStore.Files.getContentUri(BuildConfig.FLAVOR), new String[]{"_id"}, "_data=? ", new String[]{str}, null);
        if (query != null && query.moveToFirst()) {
            downloadInfo.safePutToDBJsonData(DbJsonConstants.CONTENT_URI, ContentUris.withAppendedId(MediaStore.Files.getContentUri(BuildConfig.FLAVOR), query.getInt(query.getColumnIndex("_id"))).toString());
        } else {
            MediaScannerConnection.scanFile(context, new String[]{str}, new String[]{"application/vnd.android.package-archive"}, new MediaScannerConnection.OnScanCompletedListener() { // from class: com.ss.android.downloadlib.ej.m.1
                @Override // android.media.MediaScannerConnection.OnScanCompletedListener
                public void onScanCompleted(String str2, Uri uri) {
                    if (uri != null) {
                        downloadInfo.safePutToDBJsonData(DbJsonConstants.CONTENT_URI, uri.toString());
                        DownloadComponentManager.getDownloadCache().updateDownloadInfo(downloadInfo);
                    }
                }
            });
        }
        DownloadUtils.safeClose(query);
    }
}
