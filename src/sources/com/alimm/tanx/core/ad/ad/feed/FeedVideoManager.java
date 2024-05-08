package com.alimm.tanx.core.ad.ad.feed;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.alimm.tanx.core.TanxCoreManager;
import com.alimm.tanx.core.TanxCoreSdk;
import com.alimm.tanx.core.ad.monitor.ITanxFeedVideoMonitorCallback;
import com.alimm.tanx.core.ad.monitor.tanxc_for;
import com.alimm.tanx.core.orange.OrangeManager;
import com.alimm.tanx.core.request.TanxError;
import com.alimm.tanx.core.request.TanxPlayerError;
import com.alimm.tanx.core.ut.impl.TanxRewardUt;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.NetWorkUtil;
import com.alimm.tanx.core.utils.NotConfused;
import com.alimm.tanx.core.utils.TanxCountDownTimer;
import com.alimm.tanx.core.utils.VideoCacheManager;
import com.alimm.tanx.core.view.feed.ITanxFeedCacheContext;
import com.alimm.tanx.core.view.player.VideoScaleMode;
import com.alimm.tanx.core.view.player.cache.VideoGetSizeManager;
import com.alimm.tanx.core.view.player.core.ITanxPlayer;
import com.alimm.tanx.core.view.player.core.OnVideoBufferingListener;
import com.alimm.tanx.core.view.player.core.OnVideoErrorListener;
import com.alimm.tanx.core.view.player.core.OnVideoStateChangeListener;
import com.alimm.tanx.core.view.player.core.PlayerBufferingState;
import com.alimm.tanx.core.view.player.core.PlayerState;
import com.alimm.tanx.core.view.player.ui.TanxPlayerView;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class FeedVideoManager implements ITanxVideoView, NotConfused, ITanxFeedCacheContext {
    public static final String TAG = "FeedVideoManager";
    public final ITanxFeedAd iTanxFeedAd;
    public ITanxFeedVideoAdListener iTanxFeedVideoAdListener;
    public ITanxFeedVideoMonitorCallback iTanxFeedVideoMonitorCallback;
    public ITanxPlayer player;
    public volatile TanxCountDownTimer tanxCountDownTimer;
    public final com.alimm.tanx.core.view.feed.tanxc_do tanxFeedVideoViewCache;
    public TanxVideoView tanxVideoView;
    public int duration = 0;
    public int nowCurrentCount = 0;
    public boolean nowViewAttach = false;
    public final long defaultVideoSize = 52428800;
    public boolean isPlayed = false;
    public boolean nowMute = false;
    public volatile boolean isShow = false;

    public FeedVideoManager(ITanxFeedAd iTanxFeedAd, com.alimm.tanx.core.view.feed.tanxc_do tanxc_doVar, Context context) {
        this.tanxFeedVideoViewCache = tanxc_doVar;
        this.iTanxFeedAd = iTanxFeedAd;
        initVideoView(context);
        LogUtils.d(TAG, iTanxFeedAd.getBidInfo().getCreativeItem().getVideo());
    }

    private void autoPlayCheck(boolean z10) {
        LogUtils.d(TAG, "autoPlayCheck isIdle:" + z10);
        if (this.isPlayed) {
            playItem(z10, true);
            return;
        }
        if (this.iTanxFeedAd.getAdSlot().getVideoParam() != null && this.iTanxFeedAd.getAdSlot().getVideoParam().mute) {
            mute();
        }
        if (this.iTanxFeedAd.getAdSlot().isNotAutoPlay()) {
            LogUtils.d(TAG, "媒体设置不自动播放");
            playItem(z10, false);
            return;
        }
        if (this.iTanxFeedAd.getAdSlot().isPlayUnderWifi()) {
            LogUtils.d(TAG, "媒体设置wifi下自动播放 NetworkType" + NetWorkUtil.getNetworkType(TanxCoreSdk.getApplication()).getKey());
            if (NetWorkUtil.getNetworkType(TanxCoreSdk.getApplication()).getKey() == 1) {
                playItem(z10, true);
                return;
            }
            LogUtils.d(TAG, "当前非wifi环境只准备，不自动播放");
            this.player.setPlayWhenReady(false);
            playItem(z10, false);
            return;
        }
        playItem(z10, true);
    }

    private void callBackAndSetUi(PlayerState playerState) {
        if (this.tanxVideoView != null) {
            PlayerState playerState2 = PlayerState.STARTED;
            if (playerState == playerState2) {
                this.iTanxFeedVideoAdListener.onVideoAdStartPlay(this.iTanxFeedAd);
            } else if (playerState != PlayerState.PAUSED && playerState != PlayerState.STOPPED) {
                if (playerState == PlayerState.COMPLETED || playerState == PlayerState.END) {
                    this.iTanxFeedVideoAdListener.onVideoComplete();
                }
            } else {
                this.iTanxFeedVideoAdListener.onVideoAdPaused(this.iTanxFeedAd);
            }
            if (playerState != PlayerState.IDLE && playerState != PlayerState.INITIALIZED && playerState != PlayerState.ERROR && playerState != PlayerState.PAUSED && playerState != PlayerState.STOPPED) {
                if (playerState == PlayerState.PREPARING) {
                    this.tanxVideoView.setLoadingType();
                    return;
                }
                if (playerState != PlayerState.COMPLETED && playerState != PlayerState.END && playerState != playerState2) {
                    if (playerState == PlayerState.PREPARED) {
                        LogUtils.d(TAG, "onStateChangeTest " + this.player.getState().name());
                        ITanxPlayer iTanxPlayer = this.player;
                        if (iTanxPlayer == null || iTanxPlayer.getState() == playerState2) {
                            return;
                        }
                        this.tanxVideoView.setPauseType();
                        return;
                    }
                    return;
                }
                this.tanxVideoView.setPlayType();
                return;
            }
            this.tanxVideoView.setPauseType();
        }
    }

    private void cancelVideoProgress() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("cancelVideoProgress played:");
        TanxVideoView tanxVideoView = this.tanxVideoView;
        sb2.append(tanxVideoView != null ? tanxVideoView.getState().name() : "");
        LogUtils.d(TAG, sb2.toString());
        try {
            this.tanxCountDownTimer.cancel();
            this.tanxCountDownTimer = null;
        } catch (Exception e2) {
            LogUtils.e(TAG, "cancelVideoProgress", e2);
        }
    }

    private TanxPlayerView getVideoView() {
        try {
            if (this.tanxVideoView == null) {
                initVideoView(TanxCoreSdk.getApplication());
            }
        } catch (Exception e2) {
            LogUtils.d(TAG, "getVideoView()-" + LogUtils.getStackTraceMessage(e2));
            TanxRewardUt.utViewDraw(this.iTanxFeedAd, 0);
        }
        return this.tanxVideoView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initState(PlayerState playerState) {
        playCheck(playerState);
        setVideoProgress(playerState);
        callBackAndSetUi(playerState);
    }

    private void initVideoProgress() {
        try {
            if (this.tanxCountDownTimer != null) {
                return;
            }
            TanxVideoView tanxVideoView = this.tanxVideoView;
            if (tanxVideoView != null) {
                this.duration = tanxVideoView.getDuration();
            }
            LogUtils.d(TAG, "initVideoProgress duration" + this.duration + "");
            if (this.tanxCountDownTimer == null) {
                this.tanxCountDownTimer = new TanxCountDownTimer(this.duration, 1000L) { // from class: com.alimm.tanx.core.ad.ad.feed.FeedVideoManager.6
                    @Override // com.alimm.tanx.core.utils.TanxCountDownTimer
                    public void onFinish() {
                        try {
                            if (FeedVideoManager.this.iTanxFeedAd.getAdSlot().getVideoParam().looping) {
                                FeedVideoManager feedVideoManager = FeedVideoManager.this;
                                feedVideoManager.initState(feedVideoManager.tanxVideoView.getState());
                            }
                        } catch (Exception e2) {
                            LogUtils.e(e2);
                        }
                        LogUtils.d(FeedVideoManager.TAG, "initVideoProgress - onFinish");
                    }

                    @Override // com.alimm.tanx.core.utils.TanxCountDownTimer
                    public void onTick(long j10) {
                        if (FeedVideoManager.this.tanxVideoView != null && FeedVideoManager.this.tanxVideoView.getState() != PlayerState.STARTED) {
                            FeedVideoManager.this.stopVideoProgress();
                        }
                        FeedVideoManager.this.nowCurrentCount = Math.round(((float) j10) / 1000.0f);
                        int round = Math.round(FeedVideoManager.this.duration / 1000.0f);
                        FeedVideoManager.this.iTanxFeedVideoAdListener.onProgressUpdate(FeedVideoManager.this.nowCurrentCount, round);
                        LogUtils.d(FeedVideoManager.TAG, "initVideoProgress nowCurrentCount：" + FeedVideoManager.this.nowCurrentCount + " duration：" + round);
                        if (round - FeedVideoManager.this.nowCurrentCount > 1) {
                            FeedVideoManager.this.isPlayed = true;
                        }
                    }
                };
            }
        } catch (Exception e2) {
            LogUtils.e(TAG, "initVideoProgress", e2);
        }
    }

    private void initVideoView(Context context) {
        try {
            TanxVideoView tanxc_do = this.tanxFeedVideoViewCache.tanxc_do(this, context);
            this.tanxVideoView = tanxc_do;
            tanxc_do.setTanxAd(this.iTanxFeedAd);
            ITanxPlayer create = TanxCoreManager.getInstance().getTanxCoreInstanceConfig().getTanxPlayer().create();
            this.player = create;
            create.setLooping(this.iTanxFeedAd.getAdSlot().getVideoParam().looping);
            ITanxFeedVideoMonitorCallback iTanxFeedVideoMonitorCallback = new ITanxFeedVideoMonitorCallback() { // from class: com.alimm.tanx.core.ad.ad.feed.FeedVideoManager.1
                @Override // com.alimm.tanx.core.ad.monitor.ITanxFeedVideoMonitorCallback
                public void attach() {
                    FeedVideoManager.this.startPlay(true);
                    FeedVideoManager.this.iTanxFeedVideoAdListener.onVideoLoad(FeedVideoManager.this.iTanxFeedAd);
                    FeedVideoManager.this.nowViewAttach = true;
                }

                @Override // com.alimm.tanx.core.ad.monitor.ITanxFeedVideoMonitorCallback
                public void detached() {
                    try {
                        FeedVideoManager.this.isShow = false;
                        FeedVideoManager.this.nowViewAttach = false;
                        LogUtils.d(FeedVideoManager.TAG, "detached:" + FeedVideoManager.this.tanxVideoView.getState().name());
                        FeedVideoManager.this.stop();
                        FeedVideoManager.this.iTanxFeedVideoMonitorCallback = null;
                    } catch (Exception e2) {
                        LogUtils.e(e2);
                    }
                }

                @Override // com.alimm.tanx.core.ad.monitor.ITanxExposureCallback
                public void exposure() {
                }

                @Override // com.alimm.tanx.core.ad.monitor.ITanxExposureCallback
                public void exposureTime(long j10) {
                }

                @Override // com.alimm.tanx.core.ad.monitor.ITanxExposureCallback
                public void onMonitor(Map<String, Object> map) {
                }

                @Override // com.alimm.tanx.core.ad.monitor.ITanxFeedVideoMonitorCallback
                public void remove() {
                    FeedVideoManager.this.isShow = false;
                    FeedVideoManager.this.stop();
                }

                @Override // com.alimm.tanx.core.ad.monitor.ITanxFeedVideoMonitorCallback
                public void show() {
                    FeedVideoManager.this.isShow = true;
                    FeedVideoManager.this.startPlay(true);
                }
            };
            this.iTanxFeedVideoMonitorCallback = iTanxFeedVideoMonitorCallback;
            this.tanxVideoView.setAdMonitor(new tanxc_for(this.tanxVideoView, iTanxFeedVideoMonitorCallback));
            this.tanxVideoView.setOnVideoStateChangeListener(new OnVideoStateChangeListener() { // from class: com.alimm.tanx.core.ad.ad.feed.FeedVideoManager.2
                @Override // com.alimm.tanx.core.view.player.core.OnVideoStateChangeListener
                public void onStateChange(ITanxPlayer iTanxPlayer, PlayerState playerState) {
                    LogUtils.d(FeedVideoManager.TAG, "onStateChange state " + playerState.name() + "");
                    FeedVideoManager.this.initState(playerState);
                }
            });
            this.tanxVideoView.setOnVideoBufferingListener(new OnVideoBufferingListener() { // from class: com.alimm.tanx.core.ad.ad.feed.FeedVideoManager.3
                @Override // com.alimm.tanx.core.view.player.core.OnVideoBufferingListener
                public void OnBufferStateChanged(PlayerBufferingState playerBufferingState) {
                }
            });
            this.tanxVideoView.setOnVideoErrorListener(new OnVideoErrorListener() { // from class: com.alimm.tanx.core.ad.ad.feed.FeedVideoManager.4
                @Override // com.alimm.tanx.core.view.player.core.OnVideoErrorListener
                public boolean onError(ITanxPlayer iTanxPlayer, TanxPlayerError tanxPlayerError) {
                    FeedVideoManager.this.iTanxFeedVideoAdListener.onVideoError(tanxPlayerError);
                    TanxRewardUt.utViewDraw(FeedVideoManager.this.iTanxFeedAd, 0);
                    return false;
                }
            });
            this.tanxVideoView.setPlayClickListener(new View.OnClickListener() { // from class: com.alimm.tanx.core.ad.ad.feed.FeedVideoManager.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    FeedVideoManager.this.play();
                }
            });
        } catch (Exception e2) {
            LogUtils.d(TAG, "initVideoView()-" + LogUtils.getStackTraceMessage(e2));
            TanxRewardUt.utViewDraw(this.iTanxFeedAd, 0);
        }
    }

    private void playCheck(PlayerState playerState) {
        if (!playerState.equals(PlayerState.STARTED) || this.nowViewAttach) {
            return;
        }
        stop();
    }

    private void playItem(boolean z10, boolean z11) {
        LogUtils.d(TAG, "playItem isIdle:" + z10 + " isStart:" + z11 + " isShow:" + this.isShow);
        if (z10) {
            if (!z11 || !this.isShow) {
                this.player.setPlayWhenReady(false);
            }
            this.tanxVideoView.prepare();
        }
        if (z11 && this.isShow) {
            this.player.setPlayWhenReady(true);
            this.tanxVideoView.start();
        }
    }

    private void setVideoProgress(PlayerState playerState) {
        if (playerState == PlayerState.STARTED) {
            startVideoProgress();
        } else {
            stopVideoProgress();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPlay(boolean z10) {
        LogUtils.d(TAG, "startPlay fromAttach：" + z10);
        if (videoSizeCheck(this.iTanxFeedAd)) {
            if (this.tanxVideoView != null) {
                LogUtils.d(TAG, "startPlay tanxVideoView.getState()：" + this.tanxVideoView.getState().name());
                if (this.tanxVideoView.getState().equals(PlayerState.COMPLETED)) {
                    return;
                }
                if (this.tanxVideoView.getState().equals(PlayerState.ERROR)) {
                    this.tanxVideoView.reset();
                }
                if (this.tanxVideoView.getState().equals(PlayerState.IDLE)) {
                    this.tanxVideoView.setTanxPlayer(this.player);
                    this.tanxVideoView.setDataSource(this.iTanxFeedAd.getBidInfo().getCreativeItem().getVideo());
                    this.tanxVideoView.setVideoScaleMode(VideoScaleMode.FIT_CENTER);
                    this.tanxVideoView.setCover(this.iTanxFeedAd.getBidInfo().getCreativeItem().getImageUrl());
                    if (z10) {
                        autoPlayCheck(true);
                    } else {
                        playItem(true, true);
                    }
                } else if (z10) {
                    autoPlayCheck(false);
                } else {
                    playItem(false, true);
                }
                this.iTanxFeedAd.onResourceLoadSuccess();
                return;
            }
            return;
        }
        this.iTanxFeedVideoAdListener.onError(new TanxError(this.iTanxFeedAd.getRequestId(), "视频超限"));
    }

    private synchronized void startVideoProgress() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("startVideoProgress played:");
        TanxVideoView tanxVideoView = this.tanxVideoView;
        sb2.append(tanxVideoView != null ? tanxVideoView.getState().name() : "");
        LogUtils.d(TAG, sb2.toString());
        try {
            initVideoProgress();
            if (this.tanxCountDownTimer.isPaused() && this.tanxVideoView.getState() == PlayerState.STARTED) {
                TanxVideoView tanxVideoView2 = this.tanxVideoView;
                if (tanxVideoView2 != null && tanxVideoView2.getDuration() - this.tanxVideoView.getCurrentPosition() > 0) {
                    this.tanxCountDownTimer.updateTime(this.tanxVideoView.getDuration() - this.tanxVideoView.getCurrentPosition());
                }
                this.tanxCountDownTimer.resume();
            } else {
                this.tanxCountDownTimer.start();
            }
        } catch (Exception e2) {
            LogUtils.e(TAG, "startVideoProgress", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop() {
        TanxVideoView tanxVideoView = this.tanxVideoView;
        if (tanxVideoView == null || tanxVideoView.getState().equals(PlayerState.COMPLETED)) {
            return;
        }
        this.tanxVideoView.stop();
        stopVideoProgress();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopVideoProgress() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("stopVideoProgress played:");
        TanxVideoView tanxVideoView = this.tanxVideoView;
        sb2.append(tanxVideoView != null ? tanxVideoView.getState().name() : "");
        LogUtils.d(TAG, sb2.toString());
        try {
            if (this.tanxCountDownTimer == null || this.tanxVideoView.getState() == PlayerState.STARTED) {
                return;
            }
            this.tanxCountDownTimer.pause();
        } catch (Exception e2) {
            LogUtils.e(TAG, "startVideoProgress", e2);
        }
    }

    private boolean videoSizeCheck(ITanxFeedAd iTanxFeedAd) {
        Long l10;
        if (iTanxFeedAd == null || iTanxFeedAd.getBidInfo() == null || iTanxFeedAd.getBidInfo().getCreativeItem() == null || TextUtils.isEmpty(iTanxFeedAd.getBidInfo().getCreativeItem().getVideo())) {
            return true;
        }
        LinkedHashMap<String, Long> linkedHashMap = VideoGetSizeManager.mCachedVideoSizeMap;
        long j10 = 0;
        if (linkedHashMap != null && (l10 = linkedHashMap.get(iTanxFeedAd.getBidInfo().getCreativeItem().getVideo())) != null) {
            j10 = l10.longValue();
        }
        return j10 <= (OrangeManager.getInstance().getThreshold(OrangeManager.FEED_VIDEO_MAX_SIZE) > -1 ? (OrangeManager.getInstance().getThreshold(OrangeManager.FEED_VIDEO_MAX_SIZE) * 1024) * 1024 : 52428800L);
    }

    @Override // com.alimm.tanx.core.ad.ad.feed.ITanxVideoView
    public void destroy() {
        TanxVideoView tanxVideoView = this.tanxVideoView;
        if (tanxVideoView != null) {
            tanxVideoView.release();
        }
        VideoCacheManager.getInstance().clearThis(this.iTanxFeedAd);
        cancelVideoProgress();
    }

    @Override // com.alimm.tanx.core.ad.ad.feed.ITanxVideoView
    public View getVideoAdView(ITanxFeedVideoAdListener iTanxFeedVideoAdListener) {
        this.iTanxFeedVideoAdListener = iTanxFeedVideoAdListener;
        return getVideoView();
    }

    @Override // com.alimm.tanx.core.ad.ad.feed.ITanxVideoView
    public boolean isMute() {
        return this.nowMute;
    }

    @Override // com.alimm.tanx.core.ad.ad.feed.ITanxVideoView
    public void mute() {
        TanxVideoView tanxVideoView = this.tanxVideoView;
        if (tanxVideoView != null) {
            tanxVideoView.mute();
            this.nowMute = true;
        }
    }

    @Override // com.alimm.tanx.core.ad.ad.feed.ITanxVideoView
    public void pause() {
        stop();
    }

    @Override // com.alimm.tanx.core.ad.ad.feed.ITanxVideoView
    public void play() {
        startPlay(false);
    }

    @Override // com.alimm.tanx.core.view.feed.ITanxFeedCacheContext
    public View remove() {
        TanxVideoView tanxVideoView = this.tanxVideoView;
        if (tanxVideoView != null) {
            tanxVideoView.release();
        }
        this.tanxVideoView = null;
        return tanxVideoView;
    }

    @Override // com.alimm.tanx.core.ad.ad.feed.ITanxVideoView
    public void resumeVolume() {
        TanxVideoView tanxVideoView = this.tanxVideoView;
        if (tanxVideoView != null) {
            tanxVideoView.resumeVolume();
            this.nowMute = false;
        }
    }

    @Override // com.alimm.tanx.core.ad.ad.feed.ITanxVideoView
    public void setVolume(int i10) {
        TanxVideoView tanxVideoView = this.tanxVideoView;
        if (tanxVideoView != null) {
            tanxVideoView.setVolume(i10);
            this.nowMute = i10 <= 0;
        }
    }
}
