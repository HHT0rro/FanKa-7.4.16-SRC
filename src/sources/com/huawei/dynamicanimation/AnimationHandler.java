package com.huawei.dynamicanimation;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.Choreographer;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class AnimationHandler {
    public static final ThreadLocal<AnimationHandler> ANIMATOR_HANDLER = new ThreadLocal<>();
    public static final long FRAME_DELAY_MS = 10;
    public AnimationFrameCallbackProvider mProvider;
    public final HashMap<AnimationFrameCallback, Long> mDelayCallbackMap = new HashMap<>();
    public final ArrayList<AnimationFrameCallback> mAnimationCallbackList = new ArrayList<>();
    public final AnimationCallbackDispatcher mCallbackDispatcher = new AnimationCallbackDispatcher();
    public long mCurrentFrameTime = 0;
    public boolean mIsListDirty = false;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class AnimationCallbackDispatcher {
        public AnimationCallbackDispatcher() {
        }

        public void dispatchAnimationFrame() {
            AnimationHandler.this.mCurrentFrameTime = SystemClock.uptimeMillis();
            AnimationHandler animationHandler = AnimationHandler.this;
            animationHandler.doAnimationFrame(animationHandler.mCurrentFrameTime);
            if (AnimationHandler.this.mAnimationCallbackList.size() > 0) {
                AnimationHandler.this.getProvider().postFrameCallback();
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface AnimationFrameCallback {
        boolean doAnimationFrame(long j10);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static abstract class AnimationFrameCallbackProvider {
        public final AnimationCallbackDispatcher mDispatcher;

        public AnimationFrameCallbackProvider(AnimationCallbackDispatcher animationCallbackDispatcher) {
            this.mDispatcher = animationCallbackDispatcher;
        }

        public abstract void postFrameCallback();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class FrameCallbackProvider14 extends AnimationFrameCallbackProvider {
        public static final long DEFAULT_FRAME_TIME = -1;
        public final Handler mHandler;
        public long mLastFrameTime;
        public final Runnable mRunnable;

        public FrameCallbackProvider14(AnimationCallbackDispatcher animationCallbackDispatcher) {
            super(animationCallbackDispatcher);
            this.mLastFrameTime = -1L;
            this.mRunnable = new Runnable() { // from class: com.huawei.dynamicanimation.AnimationHandler.FrameCallbackProvider14.1
                @Override // java.lang.Runnable
                public void run() {
                    FrameCallbackProvider14.this.mLastFrameTime = SystemClock.uptimeMillis();
                    FrameCallbackProvider14.this.mDispatcher.dispatchAnimationFrame();
                }
            };
            this.mHandler = new Handler(Looper.myLooper());
        }

        @Override // com.huawei.dynamicanimation.AnimationHandler.AnimationFrameCallbackProvider
        public void postFrameCallback() {
            this.mHandler.postDelayed(this.mRunnable, Math.max(10 - (SystemClock.uptimeMillis() - this.mLastFrameTime), 0L));
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class FrameCallbackProvider16 extends AnimationFrameCallbackProvider {
        public final Choreographer mChoreographer;
        public final Choreographer.FrameCallback mChoreographerCallback;

        public FrameCallbackProvider16(AnimationCallbackDispatcher animationCallbackDispatcher) {
            super(animationCallbackDispatcher);
            this.mChoreographer = Choreographer.getInstance();
            this.mChoreographerCallback = new Choreographer.FrameCallback() { // from class: com.huawei.dynamicanimation.AnimationHandler.FrameCallbackProvider16.1
                @Override // android.view.Choreographer.FrameCallback
                public void doFrame(long j10) {
                    FrameCallbackProvider16.this.mDispatcher.dispatchAnimationFrame();
                }
            };
        }

        @Override // com.huawei.dynamicanimation.AnimationHandler.AnimationFrameCallbackProvider
        public void postFrameCallback() {
            this.mChoreographer.postFrameCallback(this.mChoreographerCallback);
        }
    }

    private void cleanUpList() {
        if (this.mIsListDirty) {
            for (int size = this.mAnimationCallbackList.size() - 1; size >= 0; size--) {
                if (this.mAnimationCallbackList.get(size) == null) {
                    this.mAnimationCallbackList.remove(size);
                }
            }
            this.mIsListDirty = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doAnimationFrame(long j10) {
        long uptimeMillis = SystemClock.uptimeMillis();
        for (int i10 = 0; i10 < this.mAnimationCallbackList.size(); i10++) {
            AnimationFrameCallback animationFrameCallback = this.mAnimationCallbackList.get(i10);
            if (animationFrameCallback != null && isCallbackDue(animationFrameCallback, uptimeMillis)) {
                animationFrameCallback.doAnimationFrame(j10);
            }
        }
        cleanUpList();
    }

    public static long getFrameTime() {
        ThreadLocal<AnimationHandler> threadLocal = ANIMATOR_HANDLER;
        if (threadLocal.get() == null) {
            return 0L;
        }
        return threadLocal.get().mCurrentFrameTime;
    }

    public static AnimationHandler getInstance() {
        ThreadLocal<AnimationHandler> threadLocal = ANIMATOR_HANDLER;
        if (threadLocal.get() == null) {
            threadLocal.set(new AnimationHandler());
        }
        return threadLocal.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AnimationFrameCallbackProvider getProvider() {
        if (this.mProvider == null) {
            this.mProvider = new FrameCallbackProvider16(this.mCallbackDispatcher);
        }
        return this.mProvider;
    }

    private boolean isCallbackDue(AnimationFrameCallback animationFrameCallback, long j10) {
        if (this.mDelayCallbackMap.get(animationFrameCallback) == null) {
            return true;
        }
        if (this.mDelayCallbackMap.get(animationFrameCallback).longValue() >= j10) {
            return false;
        }
        this.mDelayCallbackMap.remove(animationFrameCallback);
        return true;
    }

    public void addAnimationFrameCallback(AnimationFrameCallback animationFrameCallback, long j10) {
        if (this.mAnimationCallbackList.size() == 0) {
            getProvider().postFrameCallback();
        }
        if (!this.mAnimationCallbackList.contains(animationFrameCallback)) {
            this.mAnimationCallbackList.add(animationFrameCallback);
        }
        if (j10 > 0) {
            this.mDelayCallbackMap.put(animationFrameCallback, Long.valueOf(SystemClock.uptimeMillis() + j10));
        }
    }

    public void removeCallback(AnimationFrameCallback animationFrameCallback) {
        this.mDelayCallbackMap.remove(animationFrameCallback);
        int indexOf = this.mAnimationCallbackList.indexOf(animationFrameCallback);
        if (indexOf >= 0) {
            this.mAnimationCallbackList.set(indexOf, null);
            this.mIsListDirty = true;
        }
    }

    public void setProvider(AnimationFrameCallbackProvider animationFrameCallbackProvider) {
        this.mProvider = animationFrameCallbackProvider;
    }
}
