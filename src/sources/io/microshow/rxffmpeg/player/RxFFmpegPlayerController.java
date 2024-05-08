package io.microshow.rxffmpeg.player;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class RxFFmpegPlayerController extends FrameLayout {
    public BaseMediaPlayer mPlayer;
    public RxFFmpegPlayerView mPlayerView;

    public RxFFmpegPlayerController(Context context) {
        super(context);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(getLayoutId(), (ViewGroup) this, true);
        initView();
    }

    public abstract int getLayoutId();

    public abstract void initListener();

    public abstract void initView();

    public abstract void onPause();

    public abstract void onResume();

    public void setPlayerView(RxFFmpegPlayerView rxFFmpegPlayerView) {
        if (rxFFmpegPlayerView != null) {
            this.mPlayerView = rxFFmpegPlayerView;
            this.mPlayer = rxFFmpegPlayerView.mPlayer;
            initListener();
        }
    }
}
