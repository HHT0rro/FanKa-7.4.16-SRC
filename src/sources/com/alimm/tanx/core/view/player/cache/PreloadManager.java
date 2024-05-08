package com.alimm.tanx.core.view.player.cache;

import android.content.Context;
import com.alimm.tanx.core.TanxCoreSdk;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.NetWorkUtil;
import com.alimm.tanx.core.view.player.cache.videocache.HttpProxyCacheServer;
import com.alimm.tanx.core.view.player.cache.videocache.PreloadListener;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class PreloadManager {
    public static final int PRELOAD_LENGTH = 1048576;
    public static final String TAG = "PreloadManager";
    public static PreloadManager sPreloadManager;
    public HttpProxyCacheServer mHttpProxyCacheServer;
    public final ExecutorService mExecutorService = Executors.newSingleThreadExecutor();
    public final LinkedHashMap<String, PreloadTask> mPreloadTasks = new LinkedHashMap<>();
    public boolean mIsStartPreload = true;

    public PreloadManager(Context context) {
        try {
            this.mHttpProxyCacheServer = ProxyCacheManager.getProxy(context);
        } catch (Exception e2) {
            LogUtils.e(TAG, e2);
        }
    }

    public static PreloadManager getInstance(Context context) {
        if (sPreloadManager == null) {
            synchronized (PreloadManager.class) {
                if (sPreloadManager == null) {
                    sPreloadManager = new PreloadManager(context.getApplicationContext());
                }
            }
        }
        return sPreloadManager;
    }

    public void addPreloadTask(String str, boolean z10, PreloadListener preloadListener) {
        addPreloadTask(str, 0, -1, z10, preloadListener);
    }

    public void continuePreLoad(int i10, boolean z10) {
        LogUtils.d(TAG, "resumePreload：" + i10 + " isReverseScroll: " + z10);
        this.mIsStartPreload = true;
        Iterator<Map.Entry<String, PreloadTask>> iterator2 = this.mPreloadTasks.entrySet().iterator2();
        while (iterator2.hasNext()) {
            PreloadTask value = iterator2.next().getValue();
            if (z10) {
                if (value.mPosition < i10 && !isPreloaded(value.mRawUrl)) {
                    value.executeOn(this.mExecutorService);
                }
            } else if (value.mPosition > i10 && !isPreloaded(value.mRawUrl)) {
                value.executeOn(this.mExecutorService);
            }
        }
    }

    public boolean deleteCacheFile(String str) {
        try {
            File cacheFile = ProxyCacheManager.getCacheFile(str);
            if (!cacheFile.exists()) {
                return true;
            }
            cacheFile.delete();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public String getPlayUrl(String str) {
        PreloadTask preloadTask = this.mPreloadTasks.get(str);
        if (preloadTask != null) {
            preloadTask.cancel();
        }
        if (isPreloaded(str)) {
            HttpProxyCacheServer httpProxyCacheServer = this.mHttpProxyCacheServer;
            if (httpProxyCacheServer != null) {
                return httpProxyCacheServer.getProxyUrl(str);
            }
            LogUtils.e(TAG, "getPlayUrl mHttpProxyCacheServer为空");
        }
        return str;
    }

    public boolean isPreloaded(String str) {
        File cacheFile = ProxyCacheManager.getCacheFile(str);
        if (!cacheFile.exists()) {
            File tempCacheFile = ProxyCacheManager.getTempCacheFile(str);
            return tempCacheFile.exists() && tempCacheFile.length() >= 1048576;
        }
        if (cacheFile.length() >= 1024) {
            return true;
        }
        cacheFile.delete();
        return false;
    }

    public void pauseAll() {
        LogUtils.d(TAG, "pauseAll");
        Iterator<Map.Entry<String, PreloadTask>> iterator2 = this.mPreloadTasks.entrySet().iterator2();
        while (iterator2.hasNext()) {
            PreloadTask value = iterator2.next().getValue();
            if (!isPreloaded(value.mRawUrl)) {
                value.cancel();
            }
        }
    }

    public void pausePreload(int i10, boolean z10) {
        LogUtils.d(TAG, "pausePreload：" + i10 + " isReverseScroll: " + z10);
        this.mIsStartPreload = false;
        Iterator<Map.Entry<String, PreloadTask>> iterator2 = this.mPreloadTasks.entrySet().iterator2();
        while (iterator2.hasNext()) {
            PreloadTask value = iterator2.next().getValue();
            if (z10) {
                if (value.mPosition >= i10) {
                    value.cancel();
                }
            } else if (value.mPosition <= i10) {
                value.cancel();
            }
        }
    }

    public void removeAllPreloadTask() {
        Iterator<Map.Entry<String, PreloadTask>> iterator2 = this.mPreloadTasks.entrySet().iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().getValue().cancel();
            iterator2.remove();
        }
    }

    public void removePreloadTask(String str) {
        PreloadTask preloadTask = this.mPreloadTasks.get(str);
        if (preloadTask != null) {
            preloadTask.cancel();
            this.mPreloadTasks.remove(str);
        }
    }

    public void resumeAll() {
        LogUtils.d(TAG, "resumeAll");
        this.mIsStartPreload = true;
        Iterator<Map.Entry<String, PreloadTask>> iterator2 = this.mPreloadTasks.entrySet().iterator2();
        while (iterator2.hasNext()) {
            PreloadTask value = iterator2.next().getValue();
            isPreloaded(value.mRawUrl);
            value.executeOn(this.mExecutorService);
        }
    }

    public void resumePreload(int i10, boolean z10) {
        LogUtils.d(TAG, "resumePreload：" + i10 + " isReverseScroll: " + z10);
        this.mIsStartPreload = true;
        Iterator<Map.Entry<String, PreloadTask>> iterator2 = this.mPreloadTasks.entrySet().iterator2();
        while (iterator2.hasNext()) {
            PreloadTask value = iterator2.next().getValue();
            if (z10) {
                if (value.mPosition < i10) {
                    isPreloaded(value.mRawUrl);
                    value.executeOn(this.mExecutorService);
                }
            } else if (value.mPosition > i10) {
                isPreloaded(value.mRawUrl);
                value.executeOn(this.mExecutorService);
            }
        }
    }

    public void stopAllPreloadTask() {
        Iterator<Map.Entry<String, PreloadTask>> iterator2 = this.mPreloadTasks.entrySet().iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().getValue().cancel();
        }
    }

    public void addPreloadTask(String str, int i10, int i11, boolean z10, PreloadListener preloadListener) {
        if (this.mHttpProxyCacheServer == null) {
            LogUtils.e(TAG, "addPreloadTask-mHttpProxyCacheServer为空");
            return;
        }
        if (isPreloaded(str)) {
            if (preloadListener != null) {
                preloadListener.onCached(str);
                return;
            }
            return;
        }
        PreloadTask preloadTask = new PreloadTask();
        preloadTask.mRawUrl = str;
        preloadTask.mPosition = i10;
        preloadTask.mPreloadLimit = i11;
        preloadTask.mPreloadListener = preloadListener;
        preloadTask.mCacheServer = this.mHttpProxyCacheServer;
        LogUtils.i(TAG, "addPreloadTask: " + i10);
        this.mPreloadTasks.put(str, preloadTask);
        if (this.mIsStartPreload) {
            if (!z10) {
                preloadTask.executeOn(this.mExecutorService);
            } else if (NetWorkUtil.getNetworkType(TanxCoreSdk.getApplication()).getKey() == 1) {
                preloadTask.executeOn(this.mExecutorService);
            }
            LogUtils.d(TAG, "task.executeOn");
        }
    }
}
