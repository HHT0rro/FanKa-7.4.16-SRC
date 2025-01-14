package com.alimm.tanx.core.view.player.cache;

import android.os.Handler;
import android.os.Looper;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.view.player.cache.videocache.HttpProxyCacheServer;
import com.alimm.tanx.core.view.player.cache.videocache.PreloadListener;
import java.util.concurrent.ExecutorService;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class PreloadTask implements Runnable {
    public static final String TAG = "PreloadTask";
    public Handler handler;
    public HttpProxyCacheServer mCacheServer;
    public boolean mIsCanceled;
    public boolean mIsExecuted;
    public int mPosition;
    public int mPreloadLimit = -1;
    public PreloadListener mPreloadListener;
    public String mRawUrl;

    private void onComplete(final Exception exc) {
        if (this.mPreloadListener != null) {
            if (this.handler == null) {
                this.handler = new Handler(Looper.getMainLooper());
            }
            this.handler.post(new Runnable() { // from class: com.alimm.tanx.core.view.player.cache.PreloadTask.1
                @Override // java.lang.Runnable
                public void run() {
                    Exception exc2 = exc;
                    if (exc2 != null) {
                        PreloadTask preloadTask = PreloadTask.this;
                        preloadTask.mPreloadListener.onError(preloadTask.mRawUrl, exc2);
                    } else {
                        PreloadTask preloadTask2 = PreloadTask.this;
                        preloadTask2.mPreloadListener.onCached(preloadTask2.mRawUrl);
                    }
                }
            });
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0059, code lost:
    
        com.alimm.tanx.core.utils.LogUtils.i(com.alimm.tanx.core.view.player.cache.PreloadTask.TAG, "结束预加载：" + r9.mPosition);
     */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00f0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void start() {
        /*
            Method dump skipped, instructions count: 244
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alimm.tanx.core.view.player.cache.PreloadTask.start():void");
    }

    public void cancel() {
        if (this.mIsExecuted) {
            this.mIsCanceled = true;
        }
        Handler handler = this.handler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    public void executeOn(ExecutorService executorService) {
        if (this.mIsExecuted) {
            return;
        }
        this.mIsExecuted = true;
        executorService.submit(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        LogUtils.i(TAG, "mIsCanceled：" + this.mIsCanceled);
        if (!this.mIsCanceled) {
            start();
        }
        this.mIsExecuted = false;
        this.mIsCanceled = false;
    }
}
