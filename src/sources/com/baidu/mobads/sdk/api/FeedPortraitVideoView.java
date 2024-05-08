package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.internal.as;
import com.baidu.mobads.sdk.internal.br;
import com.baidu.mobads.sdk.internal.x;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class FeedPortraitVideoView extends RelativeLayout {
    private static final String FEED_CLICK = "pauseBtnClick";
    private static final String PLAY_END = "playCompletion";
    private static final String PLAY_ERROR = "playError";
    private static final String PLAY_PAUSE = "playPause";
    private static final String PLAY_RESUME = "playResume";
    private static final String PLAY_START = "playRenderingStart";
    private static final String TAG = "FeedPortraitVideoView";
    private View mAdView;
    private IFeedPortraitListener mFeedVideoListener;
    private ClassLoader mLoader;
    private String mRemoteClassName;
    private Context mViewContext;
    private boolean useDownloadFrame;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public class InvocationHandlerImp implements InvocationHandler {
        public InvocationHandlerImp() {
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            String name = method.getName();
            if (TextUtils.isEmpty(name)) {
                return null;
            }
            if (name.equals(FeedPortraitVideoView.PLAY_END)) {
                if (FeedPortraitVideoView.this.mFeedVideoListener != null) {
                    FeedPortraitVideoView.this.mFeedVideoListener.playCompletion();
                }
            } else if (name.equals(FeedPortraitVideoView.PLAY_ERROR)) {
                if (FeedPortraitVideoView.this.mFeedVideoListener != null) {
                    FeedPortraitVideoView.this.mFeedVideoListener.playError();
                }
            } else if (name.equals(FeedPortraitVideoView.PLAY_START)) {
                if (FeedPortraitVideoView.this.mFeedVideoListener != null) {
                    FeedPortraitVideoView.this.mFeedVideoListener.playRenderingStart();
                }
            } else if (name.equals("playPause")) {
                if (FeedPortraitVideoView.this.mFeedVideoListener != null) {
                    FeedPortraitVideoView.this.mFeedVideoListener.playPause();
                }
            } else if (name.equals("playResume")) {
                if (FeedPortraitVideoView.this.mFeedVideoListener != null) {
                    FeedPortraitVideoView.this.mFeedVideoListener.playResume();
                }
            } else if (name.equals(FeedPortraitVideoView.FEED_CLICK) && FeedPortraitVideoView.this.mFeedVideoListener != null) {
                FeedPortraitVideoView.this.mFeedVideoListener.pauseBtnClick();
            }
            return null;
        }
    }

    public FeedPortraitVideoView(Context context) {
        this(context, null);
    }

    private void init(Context context) {
        this.mViewContext = context;
        Object[] objArr = {context};
        ClassLoader a10 = br.a(context);
        this.mLoader = a10;
        View view = (View) as.a(this.mRemoteClassName, a10, (Class<?>[]) new Class[]{Context.class}, objArr);
        this.mAdView = view;
        if (view != null) {
            addView(view, new RelativeLayout.LayoutParams(-1, -1));
        }
    }

    public long getCurrentPosition() {
        View view = this.mAdView;
        if (view == null) {
            return 0L;
        }
        Object a10 = as.a(this.mRemoteClassName, view, this.mLoader, "getCurrentPosition", new Class[0], new Object[0]);
        if (a10 instanceof Long) {
            return ((Long) a10).longValue();
        }
        return 0L;
    }

    public long getDuration() {
        View view = this.mAdView;
        if (view == null) {
            return 0L;
        }
        Object a10 = as.a(this.mRemoteClassName, view, this.mLoader, "getDuration", new Class[0], new Object[0]);
        if (a10 instanceof Long) {
            return ((Long) a10).longValue();
        }
        return 0L;
    }

    public void handleFeedCover(AbstractData abstractData) {
        View view = this.mAdView;
        if (view != null) {
            as.a(this.mRemoteClassName, view, this.mLoader, "handleCover", new Class[]{Object.class}, abstractData);
        }
    }

    public void hideFeedCoverPic(AbstractData abstractData) {
        View view = this.mAdView;
        if (view != null) {
            as.a(this.mRemoteClassName, view, this.mLoader, "hideFeedCoverPic", new Class[]{Object.class}, abstractData);
        }
    }

    public void hideFeedPauseBtn(AbstractData abstractData) {
        View view = this.mAdView;
        if (view != null) {
            as.a(this.mRemoteClassName, view, this.mLoader, "hidePauseBtn", new Class[]{Object.class}, abstractData);
        }
    }

    public boolean isPlaying() {
        View view = this.mAdView;
        if (view != null) {
            Object a10 = as.a(this.mRemoteClassName, view, this.mLoader, "isPlaying", new Class[0], new Object[0]);
            if (a10 instanceof Boolean) {
                return ((Boolean) a10).booleanValue();
            }
        }
        return false;
    }

    public boolean isShowEndFrame() {
        View view = this.mAdView;
        if (view != null) {
            Object a10 = as.a(this.mRemoteClassName, view, this.mLoader, "isShowEndFrame", new Class[0], new Object[0]);
            if (a10 instanceof Boolean) {
                return ((Boolean) a10).booleanValue();
            }
        }
        return false;
    }

    public void pause() {
        View view = this.mAdView;
        if (view != null) {
            as.a(this.mRemoteClassName, view, this.mLoader, "pause", new Class[0], new Object[0]);
        }
    }

    public void play() {
        View view = this.mAdView;
        if (view != null) {
            as.a(this.mRemoteClassName, view, this.mLoader, "play", new Class[0], new Object[0]);
        }
    }

    public void resume() {
        View view = this.mAdView;
        if (view != null) {
            as.a(this.mRemoteClassName, view, this.mLoader, "resume", new Class[0], new Object[0]);
        }
    }

    public void seekTo(int i10) {
        View view = this.mAdView;
        if (view != null) {
            as.a(this.mRemoteClassName, view, this.mLoader, "seekTo", new Class[]{Integer.TYPE}, Integer.valueOf(i10));
        }
    }

    public void setAdData(AbstractData abstractData) {
        View view;
        if (abstractData == null || (view = this.mAdView) == null) {
            return;
        }
        if (abstractData instanceof NativeCPUAdData) {
            as.a(this.mRemoteClassName, view, this.mLoader, "setCpuAdData", new Class[]{Object.class}, abstractData);
        } else {
            as.a(this.mRemoteClassName, view, this.mLoader, "setAdData", new Class[]{Object.class}, abstractData);
        }
    }

    public void setCanClickVideo(boolean z10) {
        View view = this.mAdView;
        if (view != null) {
            as.a(this.mRemoteClassName, view, this.mLoader, "setCanClickVideo", new Class[]{Boolean.TYPE}, Boolean.valueOf(z10));
        }
    }

    public void setFeedPortraitListener(IFeedPortraitListener iFeedPortraitListener) {
        this.mFeedVideoListener = iFeedPortraitListener;
        try {
            Class<?> a10 = as.a("com.component.feed.IFeedPortraitListener", this.mLoader);
            if (a10 != null) {
                Object newProxyInstance = Proxy.newProxyInstance(a10.getClassLoader(), new Class[]{a10}, new InvocationHandlerImp());
                View view = this.mAdView;
                if (view != null) {
                    as.a(this.mRemoteClassName, view, this.mLoader, "setFeedPortraitListener", new Class[]{a10}, newProxyInstance);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void setPlayBackSpeed(float f10) {
        View view = this.mAdView;
        if (view != null) {
            as.a(this.mRemoteClassName, view, this.mLoader, "setPlayBackSpeed", new Class[]{Float.TYPE}, Float.valueOf(f10));
        }
    }

    public void setProgressBackgroundColor(int i10) {
        View view = this.mAdView;
        if (view != null) {
            as.a(this.mRemoteClassName, view, this.mLoader, "setProgressBackgroundColor", new Class[]{Integer.TYPE}, Integer.valueOf(i10));
        }
    }

    public void setProgressBarColor(int i10) {
        View view = this.mAdView;
        if (view != null) {
            as.a(this.mRemoteClassName, view, this.mLoader, "setProgressBarColor", new Class[]{Integer.TYPE}, Integer.valueOf(i10));
        }
    }

    public void setProgressHeightInDp(int i10) {
        View view = this.mAdView;
        if (view != null) {
            as.a(this.mRemoteClassName, view, this.mLoader, "setProgressHeightDp", new Class[]{Integer.TYPE}, Integer.valueOf(i10));
        }
    }

    public void setShowProgress(boolean z10) {
        View view = this.mAdView;
        if (view != null) {
            as.a(this.mRemoteClassName, view, this.mLoader, "setShowProgressBar", new Class[]{Boolean.TYPE}, Boolean.valueOf(z10));
        }
    }

    public void setUseDownloadFrame(boolean z10) {
        View view = this.mAdView;
        if (view != null) {
            as.a(this.mRemoteClassName, view, this.mLoader, "setUseDownloadFrame", new Class[]{Boolean.TYPE}, Boolean.valueOf(z10));
        }
    }

    public void setVideoMute(boolean z10) {
        try {
            View view = this.mAdView;
            if (view != null) {
                as.a(this.mRemoteClassName, view, this.mLoader, "userSetVideoMute", new Class[]{Boolean.TYPE}, Boolean.valueOf(z10));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void showFeedVideoCover(AbstractData abstractData) {
        View view = this.mAdView;
        if (view != null) {
            as.a(this.mRemoteClassName, view, this.mLoader, "showFeedVideoCover", new Class[]{Object.class}, abstractData);
        }
    }

    public void showNormalPic(AbstractData abstractData) {
        View view;
        if (abstractData == null || (view = this.mAdView) == null) {
            return;
        }
        as.a(this.mRemoteClassName, view, this.mLoader, "showNormalPic", new Class[]{Object.class}, abstractData);
    }

    public void stop() {
        View view = this.mAdView;
        if (view != null) {
            as.a(this.mRemoteClassName, view, this.mLoader, "stop", new Class[0], new Object[0]);
        }
    }

    public void systemSetVideoMute(boolean z10) {
        try {
            View view = this.mAdView;
            if (view != null) {
                as.a(this.mRemoteClassName, view, this.mLoader, "setVideoMute", new Class[]{Boolean.TYPE}, Boolean.valueOf(z10));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public FeedPortraitVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FeedPortraitVideoView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mRemoteClassName = x.f10419d;
        this.useDownloadFrame = false;
        init(context);
    }
}
