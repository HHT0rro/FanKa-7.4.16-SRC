package io.microshow.rxffmpeg.player;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import io.microshow.rxffmpeg.R;
import io.microshow.rxffmpeg.player.IMediaPlayer;
import io.microshow.rxffmpeg.player.RxFFmpegPlayerView;
import java.lang.ref.WeakReference;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class RxFFmpegPlayerControllerImpl extends RxFFmpegPlayerController {
    private boolean isSeeking;
    private View mBottomPanel;
    public int mPosition;
    private ProgressBar mProgressBar;
    private SeekBar mProgressView;
    private TextView mTimeView;
    private ImageView muteImage;
    private ImageView playBtn;
    private View repeatPlay;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class PlayerListener implements IMediaPlayer.OnCompletionListener, IMediaPlayer.OnErrorListener, IMediaPlayer.OnLoadingListener, IMediaPlayer.OnTimeUpdateListener {
        private WeakReference<RxFFmpegPlayerControllerImpl> mWeakReference;

        public PlayerListener(RxFFmpegPlayerControllerImpl rxFFmpegPlayerControllerImpl) {
            this.mWeakReference = new WeakReference<>(rxFFmpegPlayerControllerImpl);
        }

        @Override // io.microshow.rxffmpeg.player.IMediaPlayer.OnCompletionListener
        public void onCompletion(IMediaPlayer iMediaPlayer) {
            RxFFmpegPlayerControllerImpl rxFFmpegPlayerControllerImpl = this.mWeakReference.get();
            if (rxFFmpegPlayerControllerImpl != null) {
                rxFFmpegPlayerControllerImpl.onCompletion(iMediaPlayer);
            }
        }

        @Override // io.microshow.rxffmpeg.player.IMediaPlayer.OnErrorListener
        public void onError(IMediaPlayer iMediaPlayer, int i10, String str) {
            RxFFmpegPlayerControllerImpl rxFFmpegPlayerControllerImpl = this.mWeakReference.get();
            if (rxFFmpegPlayerControllerImpl != null) {
                rxFFmpegPlayerControllerImpl.onError(iMediaPlayer, i10, str);
            }
        }

        @Override // io.microshow.rxffmpeg.player.IMediaPlayer.OnLoadingListener
        public void onLoading(IMediaPlayer iMediaPlayer, boolean z10) {
            RxFFmpegPlayerControllerImpl rxFFmpegPlayerControllerImpl = this.mWeakReference.get();
            if (rxFFmpegPlayerControllerImpl != null) {
                rxFFmpegPlayerControllerImpl.onLoading(iMediaPlayer, z10);
            }
        }

        @Override // io.microshow.rxffmpeg.player.IMediaPlayer.OnTimeUpdateListener
        public void onTimeUpdate(IMediaPlayer iMediaPlayer, int i10, int i11) {
            RxFFmpegPlayerControllerImpl rxFFmpegPlayerControllerImpl = this.mWeakReference.get();
            if (rxFFmpegPlayerControllerImpl != null) {
                rxFFmpegPlayerControllerImpl.onTimeUpdate(iMediaPlayer, i10, i11);
            }
        }
    }

    public RxFFmpegPlayerControllerImpl(Context context) {
        super(context);
        this.isSeeking = false;
    }

    @Override // io.microshow.rxffmpeg.player.RxFFmpegPlayerController
    public int getLayoutId() {
        return R.layout.rxffmpeg_player_controller;
    }

    @Override // io.microshow.rxffmpeg.player.RxFFmpegPlayerController
    public void initListener() {
        PlayerListener playerListener = new PlayerListener(this);
        this.mPlayer.setOnLoadingListener(playerListener);
        this.mPlayer.setOnTimeUpdateListener(playerListener);
        this.mPlayer.setOnErrorListener(playerListener);
        this.mPlayer.setOnCompleteListener(playerListener);
        this.mProgressView.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: io.microshow.rxffmpeg.player.RxFFmpegPlayerControllerImpl.5
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i10, boolean z10) {
                RxFFmpegPlayerControllerImpl rxFFmpegPlayerControllerImpl = RxFFmpegPlayerControllerImpl.this;
                rxFFmpegPlayerControllerImpl.mPosition = (i10 * rxFFmpegPlayerControllerImpl.mPlayer.getDuration()) / 100;
                if (RxFFmpegPlayerControllerImpl.this.isSeeking) {
                    RxFFmpegPlayerControllerImpl rxFFmpegPlayerControllerImpl2 = RxFFmpegPlayerControllerImpl.this;
                    RxFFmpegPlayerView.PlayerCoreType playerCoreType = rxFFmpegPlayerControllerImpl2.mPlayerView.mPlayerCoreType;
                    if (playerCoreType == RxFFmpegPlayerView.PlayerCoreType.PCT_RXFFMPEG_PLAYER) {
                        rxFFmpegPlayerControllerImpl2.onTimeUpdate(null, rxFFmpegPlayerControllerImpl2.mPosition, rxFFmpegPlayerControllerImpl2.mPlayer.getDuration());
                    } else if (playerCoreType == RxFFmpegPlayerView.PlayerCoreType.PCT_SYSTEM_MEDIA_PLAYER) {
                        rxFFmpegPlayerControllerImpl2.onTimeUpdate(null, rxFFmpegPlayerControllerImpl2.mPosition / 1000, rxFFmpegPlayerControllerImpl2.mPlayer.getDuration() / 1000);
                    }
                    RxFFmpegPlayerControllerImpl rxFFmpegPlayerControllerImpl3 = RxFFmpegPlayerControllerImpl.this;
                    rxFFmpegPlayerControllerImpl3.mPlayer.seekTo(rxFFmpegPlayerControllerImpl3.mPosition);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                RxFFmpegPlayerControllerImpl.this.isSeeking = true;
                RxFFmpegPlayerControllerImpl.this.mPlayer.pause();
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                RxFFmpegPlayerControllerImpl.this.mPlayer.resume();
                RxFFmpegPlayerControllerImpl rxFFmpegPlayerControllerImpl = RxFFmpegPlayerControllerImpl.this;
                rxFFmpegPlayerControllerImpl.mPlayer.seekTo(rxFFmpegPlayerControllerImpl.mPosition);
                RxFFmpegPlayerControllerImpl.this.isSeeking = false;
            }
        });
    }

    @Override // io.microshow.rxffmpeg.player.RxFFmpegPlayerController
    public void initView() {
        this.mBottomPanel = findViewById(R.id.bottomPanel);
        this.mProgressView = (SeekBar) findViewById(R.id.progress_view);
        this.mTimeView = (TextView) findViewById(R.id.time_view);
        this.mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        this.playBtn = (ImageView) findViewById(R.id.iv_play);
        View findViewById = findViewById(R.id.repeatPlay);
        this.repeatPlay = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: io.microshow.rxffmpeg.player.RxFFmpegPlayerControllerImpl.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RxFFmpegPlayerControllerImpl.this.mPlayerView.repeatPlay();
                RxFFmpegPlayerControllerImpl.this.repeatPlay.setVisibility(8);
            }
        });
        findViewById(R.id.iv_fullscreen).setOnClickListener(new View.OnClickListener() { // from class: io.microshow.rxffmpeg.player.RxFFmpegPlayerControllerImpl.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RxFFmpegPlayerView rxFFmpegPlayerView = RxFFmpegPlayerControllerImpl.this.mPlayerView;
                if (rxFFmpegPlayerView != null) {
                    rxFFmpegPlayerView.switchScreen();
                }
            }
        });
        ImageView imageView = (ImageView) findViewById(R.id.iv_mute);
        this.muteImage = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: io.microshow.rxffmpeg.player.RxFFmpegPlayerControllerImpl.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RxFFmpegPlayerControllerImpl.this.switchMute();
            }
        });
        this.playBtn.setOnClickListener(new View.OnClickListener() { // from class: io.microshow.rxffmpeg.player.RxFFmpegPlayerControllerImpl.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RxFFmpegPlayerView rxFFmpegPlayerView = RxFFmpegPlayerControllerImpl.this.mPlayerView;
                if (rxFFmpegPlayerView != null) {
                    if (rxFFmpegPlayerView.isPlaying()) {
                        RxFFmpegPlayerControllerImpl.this.mPlayerView.pause();
                    } else {
                        RxFFmpegPlayerControllerImpl.this.mPlayerView.resume();
                    }
                }
            }
        });
    }

    public void onCompletion(IMediaPlayer iMediaPlayer) {
        post(new Runnable() { // from class: io.microshow.rxffmpeg.player.RxFFmpegPlayerControllerImpl.6
            @Override // java.lang.Runnable
            public void run() {
                RxFFmpegPlayerView rxFFmpegPlayerView = RxFFmpegPlayerControllerImpl.this.mPlayerView;
                if (rxFFmpegPlayerView != null && !rxFFmpegPlayerView.isLooping()) {
                    RxFFmpegPlayerControllerImpl.this.repeatPlay.setVisibility(0);
                } else {
                    RxFFmpegPlayerControllerImpl.this.repeatPlay.setVisibility(8);
                }
            }
        });
    }

    public void onError(IMediaPlayer iMediaPlayer, final int i10, final String str) {
        post(new Runnable() { // from class: io.microshow.rxffmpeg.player.RxFFmpegPlayerControllerImpl.7
            @Override // java.lang.Runnable
            public void run() {
                Toast.makeText(RxFFmpegPlayerControllerImpl.this.getContext(), "出错了：code=" + i10 + ", msg=" + str, 0).show();
            }
        });
    }

    public void onLoading(IMediaPlayer iMediaPlayer, final boolean z10) {
        post(new Runnable() { // from class: io.microshow.rxffmpeg.player.RxFFmpegPlayerControllerImpl.9
            @Override // java.lang.Runnable
            public void run() {
                RxFFmpegPlayerControllerImpl.this.mProgressBar.setVisibility(z10 ? 0 : 8);
            }
        });
    }

    @Override // io.microshow.rxffmpeg.player.RxFFmpegPlayerController
    public void onPause() {
        this.playBtn.setImageResource(R.mipmap.rxffmpeg_player_start);
        this.playBtn.animate().alpha(1.0f).start();
    }

    @Override // io.microshow.rxffmpeg.player.RxFFmpegPlayerController
    public void onResume() {
        this.playBtn.setImageResource(R.mipmap.rxffmpeg_player_pause);
        this.playBtn.animate().alpha(1.0f).start();
        RxFFmpegPlayerView rxFFmpegPlayerView = this.mPlayerView;
        if (rxFFmpegPlayerView != null) {
            this.muteImage.setImageResource(rxFFmpegPlayerView.getVolume() == 0 ? R.mipmap.rxffmpeg_player_mute : R.mipmap.rxffmpeg_player_unmute);
        }
    }

    public void onTimeUpdate(IMediaPlayer iMediaPlayer, final int i10, final int i11) {
        post(new Runnable() { // from class: io.microshow.rxffmpeg.player.RxFFmpegPlayerControllerImpl.8
            @Override // java.lang.Runnable
            public void run() {
                if (i11 <= 0) {
                    RxFFmpegPlayerControllerImpl.this.mBottomPanel.setVisibility(8);
                    return;
                }
                RxFFmpegPlayerControllerImpl.this.mBottomPanel.setVisibility(0);
                TextView textView = RxFFmpegPlayerControllerImpl.this.mTimeView;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(Helper.secdsToDateFormat(i10, i11));
                sb2.append(" / ");
                int i12 = i11;
                sb2.append(Helper.secdsToDateFormat(i12, i12));
                textView.setText(sb2.toString());
                if (RxFFmpegPlayerControllerImpl.this.isSeeking || i11 <= 0) {
                    return;
                }
                RxFFmpegPlayerControllerImpl.this.mProgressView.setProgress((i10 * 100) / i11);
            }
        });
    }

    public void switchMute() {
        RxFFmpegPlayerView rxFFmpegPlayerView = this.mPlayerView;
        if (rxFFmpegPlayerView != null) {
            if (rxFFmpegPlayerView.getVolume() == 0) {
                this.mPlayerView.setVolume(100);
                this.muteImage.setImageResource(R.mipmap.rxffmpeg_player_unmute);
            } else {
                this.mPlayerView.setVolume(0);
                this.muteImage.setImageResource(R.mipmap.rxffmpeg_player_mute);
            }
        }
    }
}
