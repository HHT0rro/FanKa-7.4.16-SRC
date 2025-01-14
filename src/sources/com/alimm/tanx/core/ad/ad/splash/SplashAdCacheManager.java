package com.alimm.tanx.core.ad.ad.splash;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.alimm.tanx.core.TanxCoreSdk;
import com.alimm.tanx.core.ad.bean.BidInfo;
import com.alimm.tanx.core.ad.listener.bean.IBidInfo;
import com.alimm.tanx.core.net.NetWorkManager;
import com.alimm.tanx.core.net.bean.DownLoadRequestBean;
import com.alimm.tanx.core.net.okhttp.callback.OnDownloadListener;
import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.ut.impl.TanxBaseUt;
import com.alimm.tanx.core.utils.FileUtils;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.MD5Utils;
import com.alimm.tanx.core.utils.NotConfused;
import com.alimm.tanx.core.utils.Utils;
import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class SplashAdCacheManager implements NotConfused {
    public static final String MAIN_PAGE = "index.html";
    public static final String PREF_KEY_PRE_REQUEST_ID = "pre_request_id";
    public static final String PREF_LOCAL_ADV_IDS = "tanx_adsdk_local_adv_ids";
    public static final String SPLASH_AD_CACHE_PATH = "ad/splash";
    public static final String SPLASH_AD_RESPONSE_CACHE_PATH = "ad/response";
    public static final String SPLASH_AD_ZIP_PATH = "zip";
    public static final String TAG = "SplashAdCacheManager";
    public static String sSplashAdCachePath;
    public static String sSplashAdResponseDir;
    public static String sSplashAdResponseFile;
    public static String sSplashAdZipCachePath;
    public final int DEFAULT_AD_EXPIRED_DAYS;
    public final int DEFAULT_EXPIRED_DAYS;
    public final int DEFAULT_MAX_AD_COUNT;
    public final Context mContext;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class SingletonHolder implements NotConfused {
        public static final SplashAdCacheManager INSTANCE = new SplashAdCacheManager();
    }

    private void deleteAssetForExpired(@NonNull final Context context, int i10) {
        try {
            FileUtils.deleteExpiredFiles(getSplashAdCacheDirPath(context), i10, new FileUtils.FileKeepRule() { // from class: com.alimm.tanx.core.ad.ad.splash.SplashAdCacheManager.4
                @Override // com.alimm.tanx.core.utils.FileUtils.FileKeepRule
                public boolean needKept(String str) {
                    tanxc_do.tanxc_do().tanxc_do(context, str, 3);
                    return false;
                }
            });
        } catch (Exception e2) {
            LogUtils.e(TAG, "deleteAssetForExpired: exception.", e2);
            TanxBaseUt.utError(UtErrorCode.CRASH_ERROR.getIntCode(), TAG, "deleteAssetForExpired: exception." + LogUtils.getStackTraceMessage(e2), "");
        }
    }

    private void deleteFileForCacheFull(@NonNull Context context, int i10, boolean z10) {
        List<File> files = FileUtils.getFiles(z10 ? getSplashAdResponseDir(context) : getSplashAdCacheDirPath(context));
        int size = files.size();
        LogUtils.d(TAG, "deleteFileForCacheFull: maxCacheNum = " + i10 + ", fileCount = " + size);
        if (size >= i10) {
            sortFilesByModifyTime(files);
            int i11 = size - (i10 / 2);
            LogUtils.d(TAG, "deleteFileForCacheFull: deleteFileCount = " + i11);
            for (int i12 = 0; i12 < i11; i12++) {
                File file = files.get(i12);
                tanxc_do.tanxc_do().tanxc_do(context, file.getName(), 4);
                LogUtils.d(TAG, "deleteFileForCacheFull: deleteFile = " + file.getName());
                FileUtils.deleteFile(file);
            }
        }
    }

    public static SplashAdCacheManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public static String getSplashAdCacheDirPath(@NonNull Context context) {
        if (TextUtils.isEmpty(sSplashAdCachePath)) {
            File externalDir = FileUtils.getExternalDir(context, 0);
            if (externalDir != null) {
                sSplashAdCachePath = FileUtils.joinPath(externalDir.getAbsolutePath(), SPLASH_AD_CACHE_PATH);
            } else {
                File externalDir2 = FileUtils.getExternalDir(context, 1);
                if (externalDir2 != null) {
                    sSplashAdCachePath = FileUtils.joinPath(externalDir2.getAbsolutePath(), SPLASH_AD_CACHE_PATH);
                }
            }
            LogUtils.d(TAG, "getSplashAdCacheDirPath: path = " + sSplashAdCachePath);
        }
        return sSplashAdCachePath;
    }

    public static String getSplashAdResponseDir(@NonNull Context context) {
        try {
            if (TextUtils.isEmpty(sSplashAdResponseDir)) {
                File externalDir = FileUtils.getExternalDir(context, 0);
                if (externalDir != null) {
                    sSplashAdResponseDir = FileUtils.joinPath(externalDir.getAbsolutePath(), SPLASH_AD_RESPONSE_CACHE_PATH);
                } else {
                    File externalDir2 = FileUtils.getExternalDir(context, 1);
                    if (externalDir2 != null) {
                        sSplashAdResponseDir = FileUtils.joinPath(externalDir2.getAbsolutePath(), SPLASH_AD_RESPONSE_CACHE_PATH);
                    }
                }
                LogUtils.d(TAG, "getSplashAdResponseDir: sSplashAdResponseDir = " + sSplashAdResponseDir);
            }
        } catch (Exception e2) {
            LogUtils.e(e2);
        }
        return sSplashAdResponseDir;
    }

    public static String getSplashAdResponseFile(@NonNull Context context, String str) {
        try {
        } catch (Exception e2) {
            LogUtils.e(e2);
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (TextUtils.isEmpty(sSplashAdResponseFile) || !sSplashAdResponseFile.contains(str)) {
            if (TextUtils.isEmpty(sSplashAdResponseDir)) {
                getSplashAdResponseDir(context);
            }
            sSplashAdResponseFile = FileUtils.joinPath(sSplashAdResponseDir, str);
            LogUtils.d(TAG, "getSplashAdResponseFile: fileName = " + sSplashAdResponseFile);
        }
        return sSplashAdResponseFile;
    }

    public static String getSplashAdZipCacheDirPath(@NonNull Context context) {
        if (TextUtils.isEmpty(sSplashAdZipCachePath)) {
            sSplashAdZipCachePath = FileUtils.joinPath(getSplashAdCacheDirPath(context), SPLASH_AD_ZIP_PATH);
        }
        return sSplashAdZipCachePath;
    }

    public static String getSplashCacheFile(@NonNull Context context, String str) {
        if (!FileUtils.exists(getSplashAdCacheDirPath(context))) {
            return null;
        }
        String joinPath = FileUtils.joinPath(getSplashAdCacheDirPath(context), str);
        if (FileUtils.exists(joinPath)) {
            return joinPath;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleAssetDownloadFinished(@NonNull Context context, @NonNull List<? extends IBidInfo> list) {
        HashMap hashMap = new HashMap(16);
        for (IBidInfo iBidInfo : list) {
            if (isAssetCached(iBidInfo)) {
                String formatTimeInMillis = Utils.formatTimeInMillis(iBidInfo.getReleaseStartTime() * 1000, "yyyy-MM-dd");
                String str = hashMap.get(formatTimeInMillis);
                if (TextUtils.isEmpty(str)) {
                    hashMap.put(formatTimeInMillis, iBidInfo.getCreativeId());
                } else {
                    hashMap.put(formatTimeInMillis, str + "," + iBidInfo.getCreativeId());
                }
            }
        }
        setCacheAdvIds(hashMap);
    }

    private void setCacheAdvIds(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        SharedPreferences.Editor edit = this.mContext.getSharedPreferences(PREF_LOCAL_ADV_IDS, 0).edit();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            edit.putString(entry.getKey(), entry.getValue());
            LogUtils.d(TAG, "setCacheAdvIds: date = " + entry.getKey() + ", cached_ids = " + entry.getValue());
        }
        edit.apply();
    }

    public static void sortFilesByModifyTime(List<File> list) {
        if (list == null || list.size() <= 1) {
            return;
        }
        try {
            Collections.sort(list, new Comparator<File>() { // from class: com.alimm.tanx.core.ad.ad.splash.SplashAdCacheManager.1
                @Override // java.util.Comparator
                /* renamed from: tanxc_do, reason: merged with bridge method [inline-methods] */
                public int compare(File file, File file2) {
                    if (file == null && file2 == null) {
                        return 0;
                    }
                    if (file == null && file2 != null) {
                        return -1;
                    }
                    if (file != null && file2 == null) {
                        return 1;
                    }
                    if (file.lastModified() < file2.lastModified()) {
                        return -1;
                    }
                    return file.lastModified() == file2.lastModified() ? 0 : 1;
                }
            });
        } catch (IllegalArgumentException e2) {
            LogUtils.d(TAG, "sortFilesByModifyTime: exception.", e2);
        }
    }

    public void clearAllCachedAsset() {
        LogUtils.d(TAG, "clearAllCachedAsset.");
        FileUtils.delete(getSplashAdCacheDirPath(this.mContext));
    }

    public void clearCachedAdvIds() {
        LogUtils.d(TAG, "clearCachedAdvIds.");
        SharedPreferences.Editor edit = this.mContext.getSharedPreferences(PREF_LOCAL_ADV_IDS, 0).edit();
        edit.clear();
        edit.apply();
    }

    public void deleteAllCachedFiles() {
        LogUtils.d(TAG, "deleteAllCachedFiles.");
        deleteCachedResponseJson();
        clearAllCachedAsset();
        clearCachedAdvIds();
    }

    public void deleteCachedResponseJson() {
        LogUtils.d(TAG, "deleteCachedResponseJson.");
        FileUtils.delete(getSplashAdCacheDirPath(this.mContext));
    }

    public void downloadAdAsset(List<? extends IBidInfo> list, final AssetDownloadCallback assetDownloadCallback) {
        tanxc_do.tanxc_do().tanxc_do(this.mContext);
        if (list != null && !list.isEmpty()) {
            String splashAdCacheDirPath = getSplashAdCacheDirPath(this.mContext);
            LogUtils.d(TAG, "downloadAdAsset cachePath=." + splashAdCacheDirPath);
            for (IBidInfo iBidInfo : list) {
                if (iBidInfo != null) {
                    LogUtils.d(TAG, "下载素材 downloadAdAsset: rs = " + iBidInfo.getCreativePath() + ", name = " + iBidInfo.getCreativeName() + ", RST = " + iBidInfo.getCreativeType() + ", MD5 = " + iBidInfo.getCreativeMd5());
                    String creativePath = iBidInfo.getCreativePath();
                    if (!TextUtils.isEmpty(creativePath) && !isAssetCached(iBidInfo)) {
                        NetWorkManager.getInstance().sendHttpDownload(new DownLoadRequestBean().setPath(splashAdCacheDirPath).setFileName(iBidInfo.getCreativeName()).setTag(iBidInfo.getCreativeName()).setUrl(creativePath), new OnDownloadListener() { // from class: com.alimm.tanx.core.ad.ad.splash.SplashAdCacheManager.2
                            @Override // com.alimm.tanx.core.net.okhttp.callback.OnDownloadListener
                            public void onDownLoadTotal(long j10) {
                                LogUtils.d("onDownLoadTotal", j10 + "");
                            }

                            @Override // com.alimm.tanx.core.net.okhttp.callback.OnDownloadListener
                            public void onDownloadFailed(int i10, String str) {
                                AssetDownloadCallback assetDownloadCallback2 = assetDownloadCallback;
                                if (assetDownloadCallback2 != null) {
                                    assetDownloadCallback2.onFail(i10, str);
                                }
                                LogUtils.d("onDownloadFailed", "code:" + i10 + "  msg:" + str);
                            }

                            @Override // com.alimm.tanx.core.net.okhttp.callback.OnDownloadListener
                            public void onDownloadSuccess(File file) {
                                LogUtils.d("onDownloadSuccess" + file.getAbsolutePath(), new String[0]);
                                AssetDownloadCallback assetDownloadCallback2 = assetDownloadCallback;
                                if (assetDownloadCallback2 != null) {
                                    assetDownloadCallback2.onSuccess(file);
                                }
                            }

                            @Override // com.alimm.tanx.core.net.okhttp.callback.OnDownloadListener
                            public void onDownloading(int i10) {
                                LogUtils.d("onDownloading", i10 + "");
                            }
                        });
                    }
                }
            }
            return;
        }
        LogUtils.d(TAG, "downloadAdAsset no adv information.");
    }

    public String getAdvIds(long j10) {
        String formatTimeInMillis = Utils.formatTimeInMillis(j10, "yyyy-MM-dd");
        String string = this.mContext.getSharedPreferences(PREF_LOCAL_ADV_IDS, 0).getString(formatTimeInMillis, "");
        LogUtils.d(TAG, "getAdvIds: date = " + formatTimeInMillis + ", advIds = " + string);
        return string;
    }

    public String getPreRequestId() {
        return this.mContext.getSharedPreferences(PREF_LOCAL_ADV_IDS, 0).getString(PREF_KEY_PRE_REQUEST_ID, "");
    }

    public boolean isAssetCached(@NonNull IBidInfo iBidInfo) {
        return isAssetCached(iBidInfo, false);
    }

    public boolean isFileMd5Matched(BidInfo bidInfo, String str) {
        if (bidInfo != null && !TextUtils.isEmpty(bidInfo.getCreativeMd5()) && !TextUtils.isEmpty(str)) {
            LogUtils.d(TAG, "isFileMd5Matched bidInfo.getCreativeMd5= " + bidInfo.getCreativeMd5() + " ---getFilePathMD5String= " + MD5Utils.getFilePathMD5String(str));
            return bidInfo.getCreativeMd5().equalsIgnoreCase(MD5Utils.getFilePathMD5String(str));
        }
        LogUtils.d(TAG, "isFileMd5Matched MD5校验是否通过:false ---bidInfo = " + ((Object) bidInfo));
        if (bidInfo != null && TextUtils.isEmpty(bidInfo.getCreativeMd5())) {
            LogUtils.d(TAG, "isFileMd5Matched MD5校验是否通过:bidInfo.getCreativeMd5() 为空");
        }
        if (!TextUtils.isEmpty(str)) {
            return false;
        }
        LogUtils.d(TAG, "isFileMd5Matched MD5校验是否通过:本地缓存文件名称MD5 为空");
        return false;
    }

    public void setPreRequestId(String str) {
        LogUtils.d(TAG, "setPreRequestId: preRequestId = " + str);
        SharedPreferences.Editor edit = this.mContext.getSharedPreferences(PREF_LOCAL_ADV_IDS, 0).edit();
        edit.putString(PREF_KEY_PRE_REQUEST_ID, str);
        edit.apply();
    }

    public void trimLocalCache() {
        deleteAssetForExpired(this.mContext, 7);
        deleteFileForCacheFull(this.mContext, 15, false);
        deleteFileForCacheFull(this.mContext, 15, true);
    }

    public void trimLocalCache2Json() {
        FileUtils.deleteExpiredFile(getSplashAdResponseDir(this.mContext), 1, (FileUtils.FileKeepRule) null);
    }

    public SplashAdCacheManager() {
        this.DEFAULT_EXPIRED_DAYS = 7;
        this.DEFAULT_AD_EXPIRED_DAYS = 1;
        this.DEFAULT_MAX_AD_COUNT = 15;
        this.mContext = TanxCoreSdk.getApplication();
    }

    public boolean isAssetCached(@NonNull IBidInfo iBidInfo, boolean z10) {
        LogUtils.d(TAG, "isAssetCached: filePath = " + getSplashCacheFile(this.mContext, iBidInfo.getCreativeName()) + ", replaceAssetPath = " + z10 + ", creativeName = " + iBidInfo.getCreativeName());
        return !TextUtils.isEmpty(r0);
    }

    public void downloadAdAsset(final List<? extends IBidInfo> list) {
        downloadAdAsset(list, new AssetDownloadCallback() { // from class: com.alimm.tanx.core.ad.ad.splash.SplashAdCacheManager.3
            @Override // com.alimm.tanx.core.ad.ad.splash.AssetDownloadCallback
            public void onFail(int i10, String str) {
            }

            @Override // com.alimm.tanx.core.ad.ad.splash.AssetDownloadCallback
            public void onSuccess(File file) {
                SplashAdCacheManager splashAdCacheManager = SplashAdCacheManager.this;
                splashAdCacheManager.handleAssetDownloadFinished(splashAdCacheManager.mContext, list);
            }
        });
    }
}
