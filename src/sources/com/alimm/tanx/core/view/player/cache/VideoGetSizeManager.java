package com.alimm.tanx.core.view.player.cache;

import android.content.Context;
import com.alimm.tanx.core.ad.ITanxAd;
import com.alimm.tanx.core.orange.OrangeManager;
import com.alimm.tanx.core.ut.core.thread.VideoSizeThreadPool;
import com.alimm.tanx.core.ut.impl.TanxCommonUt;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.view.player.cache.VideoGetSizeManager;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class VideoGetSizeManager {
    public static final int CACHED_VIDEO_SIZE_MAX_NUM = 50;
    public static final String TAG = "VideoGetSizeManager";
    public static LinkedHashMap<String, Long> mCachedVideoSizeMap = new LinkedHashMap<String, Long>(50) { // from class: com.alimm.tanx.core.view.player.cache.VideoGetSizeManager.1
        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<String, Long> entry) {
            return VideoGetSizeManager.mCachedVideoSizeMap.size() > 50;
        }
    };
    public static VideoGetSizeManager sPreloadManager;
    public long tempSize = 50;

    public VideoGetSizeManager(Context context) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void dexa(String str, ITanxAd iTanxAd) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setConnectTimeout(3000);
            httpURLConnection.setReadTimeout(3000);
            httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
            long contentLength = httpURLConnection.getContentLength();
            if (contentLength > 0) {
                mCachedVideoSizeMap.put(str, Long.valueOf(contentLength));
                if (OrangeManager.getInstance().getThreshold(OrangeManager.FEED_VIDEO_MAX_SIZE) > -1) {
                    this.tempSize = OrangeManager.getInstance().getThreshold(OrangeManager.FEED_VIDEO_MAX_SIZE) * 1024 * 1024;
                }
                TanxCommonUt.fileSizeCheck(iTanxAd, contentLength, contentLength > this.tempSize ? 1 : 0, System.currentTimeMillis() - currentTimeMillis);
            }
            LogUtils.d(TAG, "视频:" + str + " 长度：" + httpURLConnection.getContentLength() + " 时间：" + (System.currentTimeMillis() - currentTimeMillis));
        } catch (Exception e2) {
            e2.printStackTrace();
            LogUtils.e(TAG, e2);
        }
    }

    public static VideoGetSizeManager getInstance(Context context) {
        if (sPreloadManager == null) {
            synchronized (VideoGetSizeManager.class) {
                if (sPreloadManager == null) {
                    sPreloadManager = new VideoGetSizeManager(context.getApplicationContext());
                }
            }
        }
        return sPreloadManager;
    }

    public void getVideoSize(final ITanxAd iTanxAd) {
        LogUtils.d(TAG, "getVideoSize");
        final String video = iTanxAd.getBidInfo().getCreativeItem().getVideo();
        if (isPreloaded(video)) {
            return;
        }
        VideoSizeThreadPool.post(new Runnable() { // from class: w.a
            @Override // java.lang.Runnable
            public final void run() {
                VideoGetSizeManager.this.dexa(video, iTanxAd);
            }
        });
    }

    public boolean isPreloaded(String str) {
        return mCachedVideoSizeMap.get(str) != null;
    }
}
