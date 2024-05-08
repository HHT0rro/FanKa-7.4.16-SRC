package com.alimm.tanx.core.ad.ad.template.rendering.reward;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.alimm.tanx.core.ad.ad.reward.ITanxRewardVideoAd;
import com.alimm.tanx.core.ad.ad.template.rendering.feed.dialog.FeedBackDialog;
import com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity;
import com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil;
import com.alimm.tanx.core.ad.event.track.interaction.InteractionUpload;
import com.alimm.tanx.core.ad.listener.ITanxInteractionListener;
import com.alimm.tanx.core.ad.listener.bean.NewTrackItem;
import com.alimm.tanx.core.ad.view.TanxAdView;
import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.ut.impl.TanxBaseUt;
import com.alimm.tanx.core.ut.impl.TanxRewardUt;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.NotConfused;
import com.alimm.tanx.core.utils.TanxCountDownTimer;
import com.wangmai.appsdkdex.R$id;
import com.wangmai.appsdkdex.R$layout;
import com.wangmai.appsdkdex.R$mipmap;
import com.wangmai.appsdkdex.R$style;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class RewardPortraitActivity extends Activity implements NotConfused {
    public Button btnForceClose;
    public com.alimm.tanx.core.ad.ad.template.rendering.feed.dialog.tanxc_if errorPopupWindow;
    public LinearLayout flWeb;
    public ImageView ivAdLogo;
    public ImageView ivForceClose;
    public ImageView ivVoice;
    public LinearLayout llRewardVideoPlay;
    public TanxRewardAdView mAdView;
    public TanxCountDownTimer mCountDownTimer;
    public ITanxRewardVideoAd mTanxAd;
    public ViewStub operationButton;
    public String reqID;
    public tanxc_new tanxRewardVideoExpressAd;
    public RewardWebViewUtil webViewUtil;
    public final String TAG = "RewardPortraitActivity";
    public int nowVoiceRes = R$mipmap.ic_voice;
    public volatile boolean startTimerSwitch = false;
    public volatile boolean isFront = false;
    public boolean isSendRewardArrived = false;
    public boolean webCountDownOver = false;
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
                if (this.webCountDownOver) {
                    LogUtils.d("adCloseStartTimer", "启动强制关闭倒计时");
                    TanxCountDownTimer tanxCountDownTimer = new TanxCountDownTimer(10000L, 1000L) { // from class: com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity.4
                        @Override // com.alimm.tanx.core.utils.TanxCountDownTimer
                        public void onFinish() {
                            LogUtils.d("adCloseStartTimer", "onFinish");
                            RewardPortraitActivity.this.startTimerSwitch = false;
                        }

                        @Override // com.alimm.tanx.core.utils.TanxCountDownTimer
                        public void onTick(long j10) {
                            int round = Math.round(((float) j10) / 1000.0f);
                            if (round <= 1) {
                                RewardPortraitActivity.this.btnForceClose.post(new Runnable() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity.4.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        RewardPortraitActivity.this.btnForceClose.setVisibility(0);
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
                LogUtils.d("adCloseStartTimer", "不满足启动条件 webCountDownOverfalse");
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
        this.mTanxAd.bindRewardVideoAdView(this.mAdView, new ITanxInteractionListener<ITanxRewardVideoAd>() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity.2
            @Override // com.alimm.tanx.core.ad.listener.ITanxInteractionListener
            public /* synthetic */ void onAdClicked(TanxAdView tanxAdView, ITanxRewardVideoAd iTanxRewardVideoAd) {
                tanxc_do();
            }

            public void tanxc_do() {
                LogUtils.d("RewardPortraitActivity", "onAdClicked");
            }

            @Override // com.alimm.tanx.core.ad.listener.ITanxInteractionListener
            /* renamed from: tanxc_do, reason: merged with bridge method [inline-methods] */
            public void onAdShow(ITanxRewardVideoAd iTanxRewardVideoAd) {
                LogUtils.d("RewardPortraitActivity", "onAdShow");
                if (RewardPortraitActivity.this.tanxRewardVideoExpressAd == null || RewardPortraitActivity.this.tanxRewardVideoExpressAd.tanxc_if() == null) {
                    return;
                }
                RewardPortraitActivity.this.tanxRewardVideoExpressAd.tanxc_if().onAdShow(iTanxRewardVideoAd);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void dexa() {
        this.btnForceClose.setVisibility(8);
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
        this.mAdView = (TanxRewardAdView) findViewById(R$id.root_view);
        this.flWeb = (LinearLayout) findViewById(R$id.fl_reward_video_portrait_wb);
        this.btnForceClose = (Button) findViewById(R$id.btn_force_close);
    }

    private void initView() {
        initWeb();
    }

    private void initWeb() {
        RewardWebViewUtil rewardWebViewUtil = new RewardWebViewUtil();
        this.webViewUtil = rewardWebViewUtil;
        rewardWebViewUtil.tanxc_do(this.flWeb, this.mTanxAd.getBidInfo(), this.mTanxAd.getAdSlot(), this.tanxRewardVideoExpressAd, new RewardWebViewUtil.RewardInterface() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity.1
            @Override // com.alimm.tanx.core.ad.base.BaseWebViewUtil.BaseWebInterface
            public void adClose() {
                RewardPortraitActivity.this.adCloseUpload();
                RewardPortraitActivity.this.finish();
            }

            @Override // com.alimm.tanx.core.ad.base.BaseWebViewUtil.BaseWebInterface
            public void adSkip(boolean z10) {
                if (RewardPortraitActivity.this.tanxRewardVideoExpressAd != null && RewardPortraitActivity.this.tanxRewardVideoExpressAd.tanxc_if() != null) {
                    RewardPortraitActivity.this.tanxRewardVideoExpressAd.tanxc_if().onSkippedVideo();
                }
                if (z10) {
                    RewardPortraitActivity.this.adCloseUpload();
                    RewardPortraitActivity.this.finish();
                }
            }

            @Override // com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.RewardInterface
            public long getCurrentTime() {
                return 0L;
            }

            @Override // com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.RewardInterface
            public String getPlayState() {
                return null;
            }

            @Override // com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.RewardInterface
            public long getTotalTime() {
                return 0L;
            }

            @Override // com.alimm.tanx.core.ad.base.BaseWebViewUtil.BaseWebInterface
            public void h5NotifyDrawSuccess() {
                LogUtils.d("RewardPortraitActivity", "h5NotifyDrawSuccess");
                RewardPortraitActivity.this.ivForceClose.post(new Runnable() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (RewardPortraitActivity.this.errorPopupWindow != null && RewardPortraitActivity.this.errorPopupWindow.tanxc_do()) {
                            RewardPortraitActivity.this.errorPopupWindow.tanxc_if();
                        }
                        RewardPortraitActivity.this.ivForceClose.setVisibility(8);
                    }
                });
            }

            @Override // com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.RewardInterface
            public void setPlayer(Boolean bool, Boolean bool2) {
            }

            @Override // com.alimm.tanx.core.ad.base.BaseWebViewUtil.BaseWebInterface
            public void webDrawStatus(boolean z10) {
                if (z10) {
                    RewardPortraitActivity.this.mTanxAd.onResourceLoadSuccess();
                    LogUtils.d("utLog", "utViewDraw");
                    TanxRewardUt.utViewDraw(RewardPortraitActivity.this.mTanxAd, 1);
                } else {
                    RewardPortraitActivity.this.showErrorDialog();
                    if (RewardPortraitActivity.this.isHsUt) {
                        return;
                    }
                    TanxBaseUt.utErrorCode(RewardPortraitActivity.this.mTanxAd, UtErrorCode.CRASH_H5_ERROR);
                    RewardPortraitActivity.this.isHsUt = true;
                }
            }

            @Override // com.alimm.tanx.core.ad.base.BaseWebViewUtil.BaseWebInterface
            public void webError(int i10, String str) {
                LogUtils.e("RewardPortraitActivity", "webError: cmd :" + i10 + " msg:" + str);
                RewardPortraitActivity.this.showErrorDialog();
            }

            @Override // com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardWebViewUtil.RewardInterface
            public void webNotifyCountDown(int i10, int i11) {
                RewardPortraitActivity.this.rewardArrived(i10, i11);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rewardArrived(int i10, int i11) {
        try {
            if (i10 > 0 && i11 > 0 && i11 >= i10) {
                this.webCountDownOver = true;
                adCloseStartTimer();
                LogUtils.d("RewardPortraitActivity", "开始判断发奖 isSendRewardArrived:" + this.isSendRewardArrived + " totalTime：" + i10 + "currentTime：" + i11);
                if (this.isSendRewardArrived) {
                    return;
                }
                LogUtils.d("RewardPortraitActivity", "触发发奖");
                this.isSendRewardArrived = true;
                TanxRewardUt.utIsRewardValid(this.mTanxAd, 0);
                this.tanxRewardVideoExpressAd.tanxc_if().onVideoComplete();
                this.tanxRewardVideoExpressAd.tanxc_if().onRewardArrived(true, 0, null);
                return;
            }
            this.isSendRewardArrived = false;
        } catch (Exception e2) {
            LogUtils.e("RewardPortraitActivity", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showErrorDialog() {
        if (this.errorPopupWindow == null) {
            this.errorPopupWindow = new com.alimm.tanx.core.ad.ad.template.rendering.feed.dialog.tanxc_if(this);
        }
        this.flWeb.postDelayed(new Runnable() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity.3
            @Override // java.lang.Runnable
            public void run() {
                RewardPortraitActivity.this.errorPopupWindow.tanxc_do(RewardPortraitActivity.this.mAdView, new View.OnClickListener() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.reward.RewardPortraitActivity.3.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        RewardPortraitActivity.this.errorPopupWindow.tanxc_if();
                        RewardPortraitActivity.this.finish();
                    }
                });
            }
        }, 200L);
    }

    private void timerCancel() {
        try {
            LogUtils.e("RewardPortraitActivity", "adCloseTimerCancel");
            TanxCountDownTimer tanxCountDownTimer = this.mCountDownTimer;
            if (tanxCountDownTimer != null) {
                tanxCountDownTimer.cancel();
                this.mCountDownTimer = null;
            }
            this.btnForceClose.post(new Runnable() { // from class: r.a
                @Override // java.lang.Runnable
                public final void run() {
                    RewardPortraitActivity.this.dexa();
                }
            });
            this.startTimerSwitch = false;
        } catch (Exception e2) {
            LogUtils.e("timerCancel", e2);
        }
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
            finish();
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
        setContentView(R$layout.activity_reward_portrait);
        if (!getIntentData()) {
            LogUtils.d("RewardPortraitActivity", "getIntentData数据有问题。");
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
            LogUtils.e("RewardPortraitActivity", LogUtils.getStackTraceMessage(e2));
            TanxBaseUt.utError(UtErrorCode.CRASH_ERROR.getIntCode(), "RewardPortraitActivity", LogUtils.getStackTraceMessage(e2), "");
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
        LogUtils.d("RewardPortraitActivity", "onPause");
        super.onPause();
        this.isFront = false;
        timerCancel();
        if (this.webViewUtil != null) {
            LogUtils.d("RewardPortraitActivity", "webViewUtil onPause");
            this.webViewUtil.tanxc_for();
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.isFront = true;
        RewardWebViewUtil rewardWebViewUtil = this.webViewUtil;
        if (rewardWebViewUtil != null) {
            rewardWebViewUtil.tanxc_int();
        }
        adCloseStartTimer();
    }
}
