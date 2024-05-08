package com.alimm.tanx.core.ad.ad.template.rendering.reward;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.alimm.tanx.core.TanxCoreManager;
import com.alimm.tanx.core.ad.ad.reward.ITanxRewardVideoAd;
import com.alimm.tanx.core.ad.ad.template.rendering.feed.dialog.FeedBackDialog;
import com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardVideoPortraitActivity;
import com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil;
import com.alimm.tanx.core.ad.event.track.interaction.InteractionUpload;
import com.alimm.tanx.core.ad.listener.ITanxInteractionListener;
import com.alimm.tanx.core.ad.listener.bean.NewTrackItem;
import com.alimm.tanx.core.ad.view.TanxAdView;
import com.alimm.tanx.core.request.TanxPlayerError;
import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.ut.impl.TanxBaseUt;
import com.alimm.tanx.core.ut.impl.TanxRewardUt;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.NotConfused;
import com.alimm.tanx.core.utils.TanxCountDownTimer;
import com.alimm.tanx.core.utils.VideoCacheManager;
import com.alimm.tanx.core.view.player.VideoScaleMode;
import com.alimm.tanx.core.view.player.core.ITanxPlayer;
import com.alimm.tanx.core.view.player.core.OnVideoBufferingListener;
import com.alimm.tanx.core.view.player.core.OnVideoErrorListener;
import com.alimm.tanx.core.view.player.core.OnVideoStateChangeListener;
import com.alimm.tanx.core.view.player.core.PlayerBufferingState;
import com.alimm.tanx.core.view.player.core.PlayerState;
import com.alimm.tanx.core.view.player.ui.TanxPlayerView;
import com.wangmai.appsdkdex.R$id;
import com.wangmai.appsdkdex.R$layout;
import com.wangmai.appsdkdex.R$mipmap;
import com.wangmai.appsdkdex.R$style;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class RewardVideoPortraitActivity extends Activity implements NotConfused {
    public Button btnForceClose;
    public FrameLayout flVideo;
    public LinearLayout flWeb;
    public ImageView ivAdLogo;
    public ImageView ivForceClose;
    public ImageView ivVoice;
    public LinearLayout llRewardVideoPlay;
    public TanxRewardVideoAdView mAdView;
    public TanxCountDownTimer mCountDownTimer;
    public ITanxRewardVideoAd mTanxAd;
    public ViewStub operationButton;
    public ITanxPlayer player;
    public TanxPlayerView playerView;
    public String reqID;
    public tanxc_new tanxRewardVideoExpressAd;
    public RewardWebViewUtil webViewUtil;
    public final String TAG = "RewardVideoPortraitActivity";
    public int nowVoiceRes = R$mipmap.ic_voice;
    public long nowCurrentPosition = 0;
    public long totalTime = 0;
    public String nowPlayerState = "ready";
    public volatile boolean startTimerSwitch = false;
    public boolean h5Pause = false;
    public volatile boolean isFront = false;
    public boolean isFirstDraw = true;
    public boolean isSendRewardArrived = false;
    public volatile boolean isHsUt = false;

    private void adCloseStartTimer() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("startTimer - startSwitch:");
        sb2.append(this.startTimerSwitch);
        sb2.append("  btnForceClose.Visibility：");
        sb2.append(this.btnForceClose.getVisibility() == 0);
        sb2.append(" isFront：");
        sb2.append(this.isFront);
        LogUtils.d("adCloseStartTimer", sb2.toString());
        try {
            if (this.isFront && !this.startTimerSwitch && this.btnForceClose.getVisibility() != 0) {
                TanxPlayerView tanxPlayerView = this.playerView;
                if (tanxPlayerView != null && tanxPlayerView.getState() != null && (this.playerView.getState() == PlayerState.COMPLETED || this.playerView.getState() == PlayerState.END)) {
                    LogUtils.d("adCloseStartTimer", "启动强制关闭倒计时");
                    TanxCountDownTimer tanxCountDownTimer = new TanxCountDownTimer(10000L, 1000L) { // from class: com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardVideoPortraitActivity.3
                        @Override // com.alimm.tanx.core.utils.TanxCountDownTimer
                        public void onFinish() {
                            LogUtils.d("adCloseStartTimer", "onFinish");
                            RewardVideoPortraitActivity.this.startTimerSwitch = false;
                        }

                        @Override // com.alimm.tanx.core.utils.TanxCountDownTimer
                        public void onTick(long j10) {
                            int round = Math.round(((float) j10) / 1000.0f);
                            if (round <= 1) {
                                RewardVideoPortraitActivity.this.btnForceClose.post(new Runnable() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardVideoPortraitActivity.3.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        RewardVideoPortraitActivity.this.btnForceClose.setVisibility(0);
                                    }
                                });
                            }
                            LogUtils.d("adCloseStartTimer", round + "");
                        }
                    };
                    this.mCountDownTimer = tanxCountDownTimer;
                    tanxCountDownTimer.start();
                    this.startTimerSwitch = true;
                    return;
                }
                String str = "";
                if (this.playerView != null) {
                    str = "" + ((Object) this.playerView.getState());
                }
                LogUtils.d("adCloseStartTimer", "不满足启动条件playerView.getState():" + str);
                return;
            }
            LogUtils.d("adCloseStartTimer", "return");
        } catch (Exception e2) {
            LogUtils.e("adCloseStartTimer", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adCloseUpload() {
        ITanxRewardVideoAd iTanxRewardVideoAd = this.mTanxAd;
        if (iTanxRewardVideoAd == null || iTanxRewardVideoAd.getBidInfo() == null || this.mTanxAd.getBidInfo().getEventTrack() == null) {
            return;
        }
        InteractionUpload interactionUpload = InteractionUpload.getInstance();
        List<NewTrackItem> eventTrack = this.mTanxAd.getBidInfo().getEventTrack();
        InteractionUpload.getInstance();
        interactionUpload.uploadInteraction(eventTrack, 3);
    }

    private void adCloseUtAndUpload() {
        RewardWebViewUtil rewardWebViewUtil = this.webViewUtil;
        if (rewardWebViewUtil != null) {
            rewardWebViewUtil.tanxc_if(2);
        }
        adCloseUpload();
    }

    private void bindMonitor() {
        this.mTanxAd.bindRewardVideoAdView(this.mAdView, new ITanxInteractionListener<ITanxRewardVideoAd>() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardVideoPortraitActivity.2
            @Override // com.alimm.tanx.core.ad.listener.ITanxInteractionListener
            public /* synthetic */ void onAdClicked(TanxAdView tanxAdView, ITanxRewardVideoAd iTanxRewardVideoAd) {
                tanxc_do();
            }

            public void tanxc_do() {
                LogUtils.d("RewardVideoPortraitActivity", "onAdClicked");
            }

            @Override // com.alimm.tanx.core.ad.listener.ITanxInteractionListener
            /* renamed from: tanxc_do, reason: merged with bridge method [inline-methods] */
            public void onAdShow(ITanxRewardVideoAd iTanxRewardVideoAd) {
                LogUtils.d("RewardVideoPortraitActivity", "onAdShow");
                if (RewardVideoPortraitActivity.this.tanxRewardVideoExpressAd == null || RewardVideoPortraitActivity.this.tanxRewardVideoExpressAd.tanxc_if() == null) {
                    return;
                }
                RewardVideoPortraitActivity.this.tanxRewardVideoExpressAd.tanxc_if().onAdShow(iTanxRewardVideoAd);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: dispatchBufferingState, reason: merged with bridge method [inline-methods] */
    public void dexa(PlayerBufferingState playerBufferingState) {
        this.nowPlayerState = TextUtils.isEmpty(tanxc_do.tanxc_do(playerBufferingState)) ? this.nowPlayerState : tanxc_do.tanxc_do(playerBufferingState);
        LogUtils.d("RewardVideoPortraitActivity", "nowPlayerState:" + this.nowPlayerState);
        RewardWebViewUtil rewardWebViewUtil = this.webViewUtil;
        if (rewardWebViewUtil != null) {
            rewardWebViewUtil.tanxc_do(tanxc_do.tanxc_do(playerBufferingState));
        }
        if (playerBufferingState != PlayerBufferingState.BUFFERING_START && playerBufferingState == PlayerBufferingState.BUFFERING_END) {
            timerCancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: dispatchStateChange, reason: merged with bridge method [inline-methods] */
    public void dexa(ITanxPlayer iTanxPlayer, PlayerState playerState) {
        try {
            String tanxc_do = tanxc_do.tanxc_do(playerState);
            if (TextUtils.isEmpty(tanxc_do)) {
                tanxc_do = this.nowPlayerState;
            }
            this.nowPlayerState = tanxc_do;
            LogUtils.d("RewardVideoPortraitActivity", "nowPlayerState:" + this.nowPlayerState);
            RewardWebViewUtil rewardWebViewUtil = this.webViewUtil;
            if (rewardWebViewUtil != null) {
                rewardWebViewUtil.tanxc_do(tanxc_do.tanxc_do(playerState));
            }
            if (playerState == PlayerState.STARTED) {
                if (this.isFirstDraw) {
                    LogUtils.d("utLog", "utViewDraw");
                    TanxRewardUt.utViewDraw(this.mTanxAd, 1);
                }
                this.isFirstDraw = false;
                timerCancel();
                ITanxRewardVideoAd iTanxRewardVideoAd = this.mTanxAd;
                if (iTanxRewardVideoAd != null) {
                    iTanxRewardVideoAd.onResourceLoadSuccess();
                }
            }
            if (playerState == PlayerState.COMPLETED || playerState == PlayerState.END) {
                videoCompleteAndRewardArrived();
            }
        } catch (Exception e2) {
            LogUtils.e("RewardVideoPortraitActivity", e2);
        }
    }

    private boolean getIntentData() {
        try {
            String stringExtra = getIntent().getStringExtra("REQ_ID");
            this.reqID = stringExtra;
            if (TextUtils.isEmpty(stringExtra)) {
                return false;
            }
            tanxc_new tanxc_newVar = (tanxc_new) tanxc_if.tanxc_do.get(this.reqID);
            this.tanxRewardVideoExpressAd = tanxc_newVar;
            if (tanxc_newVar == null) {
                return false;
            }
            this.mTanxAd = tanxc_newVar.tanxc_if;
            return true;
        } catch (Exception e2) {
            LogUtils.e(e2);
            return false;
        }
    }

    private void init() {
        this.llRewardVideoPlay = (LinearLayout) findViewById(R$id.ll_reward_video_play);
        this.ivVoice = (ImageView) findViewById(R$id.iv_voice);
        this.ivForceClose = (ImageView) findViewById(R$id.iv_force_close);
        this.mAdView = (TanxRewardVideoAdView) findViewById(R$id.root_view);
        this.flVideo = (FrameLayout) findViewById(R$id.fl_video);
        this.flWeb = (LinearLayout) findViewById(R$id.fl_reward_video_portrait_wb);
        this.btnForceClose = (Button) findViewById(R$id.btn_force_close);
    }

    private void initVideo() {
        try {
            TanxPlayerView tanxPlayerView = new TanxPlayerView(this);
            this.playerView = tanxPlayerView;
            this.flVideo.addView(tanxPlayerView, 0, new FrameLayout.LayoutParams(-1, -1, 17));
            ITanxPlayer create = TanxCoreManager.getInstance().getTanxCoreInstanceConfig().getTanxPlayer().create();
            this.player = create;
            this.playerView.setTanxPlayer(create);
            this.playerView.setDataSource(this.mTanxAd.getBidInfo().getCreativeItem().getVideo());
            this.playerView.setVideoScaleMode(VideoScaleMode.FIT_CENTER);
            this.playerView.setCover(this.mTanxAd.getBidInfo().getCreativeItem().getImageUrl());
            LogUtils.d("RewardVideoPortraitActivity", this.mTanxAd.getBidInfo().getCreativeItem().getVideo());
            this.playerView.prepare();
            if (this.tanxRewardVideoExpressAd.tanxc_do.mute) {
                this.playerView.mute();
            } else {
                this.playerView.resumeVolume();
            }
            this.playerView.setOnVideoStateChangeListener(new OnVideoStateChangeListener() { // from class: r.d
                @Override // com.alimm.tanx.core.view.player.core.OnVideoStateChangeListener
                public final void onStateChange(ITanxPlayer iTanxPlayer, PlayerState playerState) {
                    RewardVideoPortraitActivity.this.dexa(iTanxPlayer, playerState);
                }
            });
            this.playerView.setOnVideoBufferingListener(new OnVideoBufferingListener() { // from class: r.b
                @Override // com.alimm.tanx.core.view.player.core.OnVideoBufferingListener
                public final void OnBufferStateChanged(PlayerBufferingState playerBufferingState) {
                    RewardVideoPortraitActivity.this.dexa(playerBufferingState);
                }
            });
            this.playerView.setOnVideoErrorListener(new OnVideoErrorListener() { // from class: r.c
                @Override // com.alimm.tanx.core.view.player.core.OnVideoErrorListener
                public final boolean onError(ITanxPlayer iTanxPlayer, TanxPlayerError tanxPlayerError) {
                    boolean dexa;
                    dexa = RewardVideoPortraitActivity.this.dexa(iTanxPlayer, tanxPlayerError);
                    return dexa;
                }
            });
        } catch (Exception e2) {
            LogUtils.d("RewardVideoPortraitActivity", "initVideo()-" + LogUtils.getStackTraceMessage(e2));
            TanxRewardUt.utViewDraw(this.mTanxAd, 0);
        }
    }

    private void initView() {
        initVideo();
        initWeb();
    }

    private void initWeb() {
        RewardWebViewUtil rewardWebViewUtil = new RewardWebViewUtil();
        this.webViewUtil = rewardWebViewUtil;
        rewardWebViewUtil.tanxc_do(this.flWeb, this.mTanxAd.getBidInfo(), this.mTanxAd.getAdSlot(), this.tanxRewardVideoExpressAd, new RewardWebViewUtil.RewardInterface() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardVideoPortraitActivity.1
            @Override // com.alimm.tanx.core.ad.base.BaseWebViewUtil.BaseWebInterface
            public void adClose() {
                RewardVideoPortraitActivity.this.adCloseUpload();
                RewardVideoPortraitActivity.this.finish();
            }

            @Override // com.alimm.tanx.core.ad.base.BaseWebViewUtil.BaseWebInterface
            public void adSkip(boolean z10) {
                if (RewardVideoPortraitActivity.this.tanxRewardVideoExpressAd != null && RewardVideoPortraitActivity.this.tanxRewardVideoExpressAd.tanxc_if() != null) {
                    RewardVideoPortraitActivity.this.tanxRewardVideoExpressAd.tanxc_if().onSkippedVideo();
                }
                if (z10) {
                    RewardVideoPortraitActivity.this.adCloseUpload();
                    RewardVideoPortraitActivity.this.finish();
                } else if (RewardVideoPortraitActivity.this.playerView != null) {
                    RewardVideoPortraitActivity.this.playerView.stop();
                }
            }

            @Override // com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.RewardInterface
            public long getCurrentTime() {
                if (RewardVideoPortraitActivity.this.playerView == null) {
                    return 0L;
                }
                RewardVideoPortraitActivity.this.nowCurrentPosition = r0.playerView.getCurrentPosition() / 1000;
                LogUtils.d("RewardVideoPortraitActivity", "当前视频进度：" + RewardVideoPortraitActivity.this.nowCurrentPosition);
                return RewardVideoPortraitActivity.this.nowCurrentPosition;
            }

            @Override // com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.RewardInterface
            public String getPlayState() {
                return RewardVideoPortraitActivity.this.nowPlayerState;
            }

            @Override // com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.RewardInterface
            public long getTotalTime() {
                if (RewardVideoPortraitActivity.this.playerView == null) {
                    return 0L;
                }
                RewardVideoPortraitActivity.this.totalTime = r0.playerView.getDuration() / 1000;
                return RewardVideoPortraitActivity.this.totalTime;
            }

            @Override // com.alimm.tanx.core.ad.base.BaseWebViewUtil.BaseWebInterface
            public void h5NotifyDrawSuccess() {
                RewardVideoPortraitActivity.this.ivForceClose.post(new Runnable() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardVideoPortraitActivity.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        RewardVideoPortraitActivity.this.ivForceClose.setVisibility(8);
                    }
                });
            }

            @Override // com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.RewardInterface
            public void setPlayer(Boolean bool, Boolean bool2) {
                if (RewardVideoPortraitActivity.this.playerView != null) {
                    if (bool != null) {
                        if (bool.booleanValue()) {
                            RewardVideoPortraitActivity.this.tanxRewardVideoExpressAd.tanxc_do.mute = true;
                            RewardVideoPortraitActivity.this.playerView.mute();
                        } else {
                            RewardVideoPortraitActivity.this.tanxRewardVideoExpressAd.tanxc_do.mute = false;
                            RewardVideoPortraitActivity.this.playerView.resumeVolume();
                        }
                    }
                    if (bool2 != null) {
                        if (bool2.booleanValue()) {
                            RewardVideoPortraitActivity.this.h5Pause = true;
                            RewardVideoPortraitActivity.this.playerView.pause();
                        } else {
                            RewardVideoPortraitActivity.this.h5Pause = false;
                            RewardVideoPortraitActivity.this.playerView.start();
                        }
                    }
                }
            }

            @Override // com.alimm.tanx.core.ad.base.BaseWebViewUtil.BaseWebInterface
            public void webDrawStatus(boolean z10) {
                if (z10 || RewardVideoPortraitActivity.this.isHsUt) {
                    return;
                }
                TanxBaseUt.utErrorCode(RewardVideoPortraitActivity.this.mTanxAd, UtErrorCode.CRASH_H5_ERROR);
                RewardVideoPortraitActivity.this.isHsUt = true;
            }

            @Override // com.alimm.tanx.core.ad.base.BaseWebViewUtil.BaseWebInterface
            public void webError(int i10, String str) {
                LogUtils.e("RewardVideoPortraitActivity", "激励视频：webError: cmd :" + i10 + " msg:" + str);
            }

            @Override // com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.RewardInterface
            public void webNotifyCountDown(int i10, int i11) {
            }
        });
    }

    private void timerCancel() {
        try {
            LogUtils.e("RewardVideoPortraitActivity", "adCloseTimerCancel");
            TanxCountDownTimer tanxCountDownTimer = this.mCountDownTimer;
            if (tanxCountDownTimer != null) {
                tanxCountDownTimer.cancel();
                this.mCountDownTimer = null;
            }
            this.btnForceClose.post(new Runnable() { // from class: r.e
                @Override // java.lang.Runnable
                public final void run() {
                    RewardVideoPortraitActivity.this.dexa();
                }
            });
            this.startTimerSwitch = false;
        } catch (Exception e2) {
            LogUtils.e("timerCancel", e2);
        }
    }

    private void videoCompleteAndRewardArrived() {
        adCloseStartTimer();
        LogUtils.d("RewardVideoPortraitActivity", "开始判断发奖 totalTime：" + this.totalTime + "  nowCurrentPosition：" + this.nowCurrentPosition + "  isSendRewardArrived:" + this.isSendRewardArrived);
        if (this.isSendRewardArrived) {
            return;
        }
        long j10 = this.totalTime;
        if (j10 <= 0 || j10 - this.nowCurrentPosition > 1) {
            return;
        }
        LogUtils.d("RewardVideoPortraitActivity", "触发发奖");
        this.isSendRewardArrived = true;
        TanxRewardUt.utIsRewardValid(this.mTanxAd, 0);
        this.tanxRewardVideoExpressAd.tanxc_if().onVideoComplete();
        this.tanxRewardVideoExpressAd.tanxc_if().onRewardArrived(true, 0, null);
    }

    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 == R$id.ll_reward_video_feed_back) {
            new FeedBackDialog(this, R$style.CommonDialog).show();
            return;
        }
        if (id2 == R$id.iv_voice) {
            int i10 = this.nowVoiceRes;
            int i11 = R$mipmap.ic_voice;
            if (i10 == i11) {
                i11 = R$mipmap.ic_mute;
            }
            this.ivVoice.setImageResource(i11);
            this.nowVoiceRes = i11;
            return;
        }
        if (id2 == R$id.ll_reward_video_play) {
            this.llRewardVideoPlay.setVisibility(8);
            return;
        }
        if (id2 == R$id.iv_close) {
            this.mTanxAd.click("", "");
            return;
        }
        if (id2 == R$id.btn_pre_load_h5) {
            this.mCountDownTimer.cancel();
            this.mCountDownTimer.resume();
            return;
        }
        if (id2 == R$id.btn_send_play_state) {
            RewardWebViewUtil rewardWebViewUtil = this.webViewUtil;
            if (rewardWebViewUtil != null) {
                rewardWebViewUtil.tanxc_do("2123");
                return;
            }
            return;
        }
        if (id2 == R$id.btn_send_audio) {
            RewardWebViewUtil rewardWebViewUtil2 = this.webViewUtil;
            if (rewardWebViewUtil2 != null) {
                rewardWebViewUtil2.tanxc_do(0);
                return;
            }
            return;
        }
        if (id2 == R$id.btn_force_close) {
            adCloseUtAndUpload();
            finish();
        } else if (id2 == R$id.iv_force_close) {
            adCloseUtAndUpload();
            finish();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.activity_reward_video_portrait);
        if (!getIntentData()) {
            LogUtils.d("RewardVideoPortraitActivity", "getIntentData数据有问题。");
            finish();
        } else {
            init();
            initView();
            bindMonitor();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        try {
            if (this.playerView != null) {
                TanxRewardUt.utCloseAdVideoProgress(this.mTanxAd, r0.getCurrentPosition());
                this.playerView.release();
            }
            VideoCacheManager.getInstance().clearThis(this.tanxRewardVideoExpressAd);
            tanxc_if.tanxc_do(this.reqID);
            tanxc_new tanxc_newVar = this.tanxRewardVideoExpressAd;
            if (tanxc_newVar != null && tanxc_newVar.tanxc_if() != null) {
                this.tanxRewardVideoExpressAd.tanxc_if().onAdClose();
            }
            RewardWebViewUtil rewardWebViewUtil = this.webViewUtil;
            if (rewardWebViewUtil != null) {
                rewardWebViewUtil.tanxc_if();
            }
            timerCancel();
        } catch (Exception e2) {
            LogUtils.e("RewardVideoPortraitActivity", LogUtils.getStackTraceMessage(e2));
            TanxBaseUt.utError(UtErrorCode.CRASH_ERROR.getIntCode(), "RewardVideoPortraitActivity", LogUtils.getStackTraceMessage(e2), "");
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i10, KeyEvent keyEvent) {
        if (i10 != 4 || this.btnForceClose.getVisibility() != 0) {
            return true;
        }
        adCloseUtAndUpload();
        return super.onKeyUp(i10, keyEvent);
    }

    @Override // android.app.Activity
    public void onPause() {
        LogUtils.d("RewardVideoPortraitActivity", "onPause");
        super.onPause();
        this.isFront = false;
        timerCancel();
        if (this.playerView != null) {
            LogUtils.d("RewardVideoPortraitActivity", "playerView onPause");
            this.playerView.pause();
        }
        if (this.webViewUtil != null) {
            LogUtils.d("RewardVideoPortraitActivity", "webViewUtil onPause");
            this.webViewUtil.tanxc_for();
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.isFront = true;
        TanxPlayerView tanxPlayerView = this.playerView;
        if (tanxPlayerView != null && tanxPlayerView.getState() == PlayerState.PAUSED && !this.h5Pause) {
            this.playerView.start();
        }
        RewardWebViewUtil rewardWebViewUtil = this.webViewUtil;
        if (rewardWebViewUtil != null) {
            rewardWebViewUtil.tanxc_int();
        }
        adCloseStartTimer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean dexa(ITanxPlayer iTanxPlayer, TanxPlayerError tanxPlayerError) {
        LogUtils.e("playerView", tanxPlayerError);
        tanxc_new tanxc_newVar = this.tanxRewardVideoExpressAd;
        if (tanxc_newVar != null && tanxc_newVar.tanxc_if() != null) {
            this.tanxRewardVideoExpressAd.tanxc_if().onVideoError(tanxPlayerError);
        }
        TanxRewardUt.utViewDraw(this.mTanxAd, 0);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void dexa() {
        this.btnForceClose.setVisibility(8);
    }
}
