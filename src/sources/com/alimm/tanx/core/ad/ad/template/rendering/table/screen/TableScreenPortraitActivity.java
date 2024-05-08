package com.alimm.tanx.core.ad.ad.template.rendering.table.screen;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.alimm.tanx.core.ad.ad.table.screen.ITanxTableScreenAd;
import com.alimm.tanx.core.ad.ad.template.rendering.feed.dialog.FeedBackDialog;
import com.alimm.tanx.core.ad.ad.template.rendering.reward.TanxRewardAdView;
import com.alimm.tanx.core.ad.ad.template.rendering.splash.shake.InteractiveCallback;
import com.alimm.tanx.core.ad.ad.template.rendering.splash.shake.ShakeView;
import com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenPortraitActivity;
import com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenWebViewUtil;
import com.alimm.tanx.core.ad.bean.BidInfo;
import com.alimm.tanx.core.ad.event.track.interaction.InteractionUpload;
import com.alimm.tanx.core.ad.listener.ITanxInteractionListener;
import com.alimm.tanx.core.ad.listener.bean.NewTrackItem;
import com.alimm.tanx.core.ad.view.TanxAdView;
import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.ut.impl.TanxBaseUt;
import com.alimm.tanx.core.ut.impl.TanxCommonUt;
import com.alimm.tanx.core.ut.impl.TanxTableScreenUt;
import com.alimm.tanx.core.utils.DimenUtil;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.NotConfused;
import com.alimm.tanx.core.utils.TanxCountDownTimer;
import com.wangmai.appsdkdex.R$id;
import com.wangmai.appsdkdex.R$layout;
import com.wangmai.appsdkdex.R$style;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class TableScreenPortraitActivity extends Activity implements NotConfused {
    public Button btnForceClose;
    public com.alimm.tanx.core.ad.ad.template.rendering.feed.dialog.tanxc_if errorPopupWindow;
    public LinearLayout flWeb;
    public ImageView ivAdLogo;
    public ImageView ivForceClose;
    public ImageView ivVoice;
    public LinearLayout llRewardVideoPlay;
    public TanxRewardAdView mAdView;
    public BidInfo mBidInfo;
    public TanxCountDownTimer mCountDownTimer;
    public long mShakeStartTime;
    public ShakeView mShakeView;
    public ITanxTableScreenAd mTanxAd;
    public ViewStub operationButton;
    public String reqID;
    public RelativeLayout rlShake;
    public tanxc_if tanxTableScreenExpressAd;
    public TableScreenWebViewUtil webViewUtil;
    public final String TAG = "RewardPortraitActivity";
    public volatile boolean startTimerSwitch = false;
    public volatile boolean isFront = false;
    public final boolean webCountDownOver = false;
    public long adStartTime = 0;
    public long nowExposureTime = 0;
    public volatile boolean isH5Ut = false;

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
        ITanxTableScreenAd iTanxTableScreenAd = this.mTanxAd;
        if (iTanxTableScreenAd == null || iTanxTableScreenAd.getBidInfo() == null || this.mTanxAd.getBidInfo().getEventTrack() == null) {
            return;
        }
        InteractionUpload interactionUpload = InteractionUpload.getInstance();
        List<NewTrackItem> eventTrack = this.mTanxAd.getBidInfo().getEventTrack();
        InteractionUpload.getInstance();
        interactionUpload.uploadInteraction(eventTrack, 3);
    }

    private void adCloseUtAndUpload() {
        adCloseUpload();
    }

    private void addInteractionView(@NonNull ViewGroup viewGroup) {
        this.mShakeStartTime = SystemClock.elapsedRealtime();
        showNativeShakeView(viewGroup);
        addShakeViewUt(this.mBidInfo, "table_add_interaction_view", null);
    }

    public static void addShakeViewUt(BidInfo bidInfo, String str, Map<String, String> map) {
        HashMap hashMap = new HashMap();
        if (map != null) {
            hashMap.putAll(map);
        }
        TanxBaseUt.shake(str, bidInfo, null);
    }

    private void bindMonitor() {
        this.mTanxAd.bindTableScreenAdView(this.mAdView, new ITanxInteractionListener<ITanxTableScreenAd>() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenPortraitActivity.2
            @Override // com.alimm.tanx.core.ad.listener.ITanxInteractionListener
            public /* synthetic */ void onAdClicked(TanxAdView tanxAdView, ITanxTableScreenAd iTanxTableScreenAd) {
                tanxc_do();
            }

            public void tanxc_do() {
                LogUtils.d("RewardPortraitActivity", "onAdClicked");
                if (TableScreenPortraitActivity.this.mTanxAd == null || TableScreenPortraitActivity.this.mTanxAd.getAdSlot() == null || !TableScreenPortraitActivity.this.mTanxAd.getAdSlot().isClickAdClose()) {
                    return;
                }
                TableScreenPortraitActivity.this.finish();
            }

            @Override // com.alimm.tanx.core.ad.listener.ITanxInteractionListener
            /* renamed from: tanxc_do, reason: merged with bridge method [inline-methods] */
            public void onAdShow(ITanxTableScreenAd iTanxTableScreenAd) {
                LogUtils.d("RewardPortraitActivity", "onAdShow");
                if (TableScreenPortraitActivity.this.tanxTableScreenExpressAd == null || TableScreenPortraitActivity.this.tanxTableScreenExpressAd.tanxc_if() == null) {
                    return;
                }
                TableScreenPortraitActivity.this.tanxTableScreenExpressAd.tanxc_if().onAdShow(iTanxTableScreenAd);
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
            tanxc_if tanxc_ifVar = (tanxc_if) com.alimm.tanx.core.ad.ad.template.rendering.reward.tanxc_if.tanxc_do.get(this.reqID);
            this.tanxTableScreenExpressAd = tanxc_ifVar;
            if (tanxc_ifVar == null) {
                return false;
            }
            this.mTanxAd = tanxc_ifVar.tanxc_do;
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
        this.rlShake = (RelativeLayout) findViewById(R$id.rl_shake);
        this.btnForceClose = (Button) findViewById(R$id.btn_force_close);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initShake() {
        ITanxTableScreenAd iTanxTableScreenAd = this.mTanxAd;
        if (iTanxTableScreenAd != null) {
            this.mBidInfo = iTanxTableScreenAd.getBidInfo();
        }
        BidInfo bidInfo = this.mBidInfo;
        if (bidInfo == null || !bidInfo.getInteractType2Shake()) {
            return;
        }
        addInteractionView(this.rlShake);
    }

    private void initView() {
        initWeb();
    }

    private void initWeb() {
        TableScreenWebViewUtil tableScreenWebViewUtil = new TableScreenWebViewUtil();
        this.webViewUtil = tableScreenWebViewUtil;
        tableScreenWebViewUtil.tanxc_do(this.flWeb, this.mTanxAd.getBidInfo(), this.mTanxAd.getAdSlot(), this.tanxTableScreenExpressAd, new TableScreenWebViewUtil.TableScreenInterface() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenPortraitActivity.1
            @Override // com.alimm.tanx.core.ad.base.BaseWebViewUtil.BaseWebInterface
            public void adClose() {
                TableScreenPortraitActivity.this.adCloseUpload();
                TableScreenPortraitActivity.this.finish();
            }

            @Override // com.alimm.tanx.core.ad.base.BaseWebViewUtil.BaseWebInterface
            public void adSkip(boolean z10) {
            }

            @Override // com.alimm.tanx.core.ad.base.BaseWebViewUtil.BaseWebInterface
            public void h5NotifyDrawSuccess() {
                TableScreenPortraitActivity.this.ivForceClose.post(new Runnable() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenPortraitActivity.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        TableScreenPortraitActivity.this.initShake();
                        if (TableScreenPortraitActivity.this.errorPopupWindow != null && TableScreenPortraitActivity.this.errorPopupWindow.tanxc_do()) {
                            TableScreenPortraitActivity.this.errorPopupWindow.tanxc_if();
                        }
                        TableScreenPortraitActivity.this.ivForceClose.setVisibility(8);
                    }
                });
                TableScreenPortraitActivity.this.adStartTime = System.currentTimeMillis();
            }

            @Override // com.alimm.tanx.core.ad.base.BaseWebViewUtil.BaseWebInterface
            public void webDrawStatus(boolean z10) {
                if (z10) {
                    LogUtils.d("utLog", "utViewDraw");
                    TanxTableScreenUt.utViewDraw(TableScreenPortraitActivity.this.mTanxAd, 1);
                    return;
                }
                TanxTableScreenUt.utViewDraw(TableScreenPortraitActivity.this.mTanxAd, 0);
                if (!TableScreenPortraitActivity.this.isH5Ut) {
                    TanxBaseUt.utErrorCode(TableScreenPortraitActivity.this.mTanxAd, UtErrorCode.CRASH_H5_ERROR);
                    TableScreenPortraitActivity.this.isH5Ut = true;
                }
                TableScreenPortraitActivity.this.showErrorDialog();
            }

            @Override // com.alimm.tanx.core.ad.base.BaseWebViewUtil.BaseWebInterface
            public void webError(int i10, String str) {
                LogUtils.e("RewardPortraitActivity", "webError: cmd :" + i10 + " msg:" + str);
                TableScreenPortraitActivity.this.showErrorDialog();
            }
        });
    }

    private void rewardArrived(int i10, int i11) {
    }

    private void sendInteractionViewShowExpose() {
        HashMap hashMap = new HashMap();
        hashMap.put("table_add_interaction_view_time", String.valueOf(SystemClock.elapsedRealtime() - this.mShakeStartTime));
        TanxBaseUt.shake("add_interaction_view_time", null, hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showErrorDialog() {
        if (this.errorPopupWindow == null) {
            this.errorPopupWindow = new com.alimm.tanx.core.ad.ad.template.rendering.feed.dialog.tanxc_if(this);
        }
        this.flWeb.postDelayed(new Runnable() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenPortraitActivity.3
            @Override // java.lang.Runnable
            public void run() {
                TableScreenPortraitActivity.this.errorPopupWindow.tanxc_do(TableScreenPortraitActivity.this.mAdView, new View.OnClickListener() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenPortraitActivity.3.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TableScreenPortraitActivity.this.errorPopupWindow.tanxc_if();
                        TableScreenPortraitActivity.this.finish();
                    }
                });
            }
        }, 200L);
    }

    private void showNativeShakeView(@NonNull ViewGroup viewGroup) {
        LogUtils.d("RewardPortraitActivity", "tableShowNativeShakeView");
        if (this.mShakeView == null) {
            this.mShakeView = new ShakeView(this, "摇一摇跳转详情");
        }
        this.rlShake.setVisibility(0);
        this.mShakeView.setClickable(false);
        this.mShakeView.setOnTouchListener(null);
        BidInfo bidInfo = this.mBidInfo;
        float shakeSplash2Int = (bidInfo == null || bidInfo.getTemplateConf() == null) ? 15.0f : this.mBidInfo.getTemplateConf().getShakeSplash2Int();
        this.mShakeView.getClass();
        if (shakeSplash2Int < 1.0f) {
            shakeSplash2Int = 15.0f;
        }
        this.mShakeView.getClass();
        this.mShakeView.load(new InteractiveCallback() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.table.screen.TableScreenPortraitActivity.4
            @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.shake.InteractiveCallback
            public void destroy(String str) {
                TanxCommonUt.utShakeDestroy(TableScreenPortraitActivity.this.mTanxAd, str);
            }

            @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.shake.InteractiveCallback
            public void onShake() {
                LogUtils.d("RewardPortraitActivity", "tableShowNativeShakeView 互动成功摇一摇跳转");
                TableScreenPortraitActivity tableScreenPortraitActivity = TableScreenPortraitActivity.this;
                tableScreenPortraitActivity.mShakeView.getClass();
                tableScreenPortraitActivity.onGestureInteractionEnd(true, 1, true);
            }
        }, shakeSplash2Int <= 50.0f ? shakeSplash2Int : 15.0f, false);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, DimenUtil.dp2px(this, 280.0f));
        layoutParams.gravity = 80;
        viewGroup.addView(this.mShakeView, layoutParams);
        sendInteractionViewShowExpose();
    }

    private void timerCancel() {
        try {
            LogUtils.e("RewardPortraitActivity", "adCloseTimerCancel");
            TanxCountDownTimer tanxCountDownTimer = this.mCountDownTimer;
            if (tanxCountDownTimer != null) {
                tanxCountDownTimer.cancel();
                this.mCountDownTimer = null;
            }
            this.btnForceClose.post(new Runnable() { // from class: s.a
                @Override // java.lang.Runnable
                public final void run() {
                    TableScreenPortraitActivity.this.dexa();
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
        } else if (id2 == R$id.btn_force_close) {
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
        setContentView(R$layout.activity_table_screen_portrait);
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
            com.alimm.tanx.core.ad.ad.template.rendering.reward.tanxc_if.tanxc_do(this.reqID);
            tanxc_if tanxc_ifVar = this.tanxTableScreenExpressAd;
            if (tanxc_ifVar != null && tanxc_ifVar.tanxc_if() != null) {
                this.tanxTableScreenExpressAd.tanxc_if().onAdClose();
            }
            TableScreenWebViewUtil tableScreenWebViewUtil = this.webViewUtil;
            if (tableScreenWebViewUtil != null) {
                tableScreenWebViewUtil.tanxc_if();
            }
            timerCancel();
            long j10 = this.nowExposureTime;
            if (j10 > 0) {
                TanxTableScreenUt.utRewardExposureTime(this.mTanxAd, j10);
            }
        } catch (Exception e2) {
            LogUtils.e("RewardPortraitActivity", LogUtils.getStackTraceMessage(e2));
            TanxBaseUt.utError(UtErrorCode.CRASH_ERROR.getIntCode(), "RewardPortraitActivity", LogUtils.getStackTraceMessage(e2), "");
        }
    }

    public void onGestureInteractionEnd(boolean z10, int i10, boolean z11) {
        ITanxTableScreenAd iTanxTableScreenAd;
        long currentTimeMillis = System.currentTimeMillis();
        TableScreenWebViewUtil tableScreenWebViewUtil = this.webViewUtil;
        if (currentTimeMillis - tableScreenWebViewUtil.tanxc_do >= 500) {
            tableScreenWebViewUtil.tanxc_do = System.currentTimeMillis();
            tanxc_if tanxc_ifVar = this.tanxTableScreenExpressAd;
            if (tanxc_ifVar == null || (iTanxTableScreenAd = tanxc_ifVar.tanxc_do) == null) {
                return;
            }
            iTanxTableScreenAd.shake();
            if (this.tanxTableScreenExpressAd.tanxc_if() != null) {
                this.tanxTableScreenExpressAd.tanxc_if().onAdShake();
                return;
            }
            return;
        }
        LogUtils.d("RewardPortraitActivity", "mClickedOnce = true");
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i10, KeyEvent keyEvent) {
        Button button;
        if (i10 != 4 || (button = this.btnForceClose) == null || button.getVisibility() != 0) {
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
        if (this.adStartTime > 0) {
            this.nowExposureTime += System.currentTimeMillis() - this.adStartTime;
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.isFront = true;
        TableScreenWebViewUtil tableScreenWebViewUtil = this.webViewUtil;
        if (tableScreenWebViewUtil != null) {
            tableScreenWebViewUtil.tanxc_int();
        }
        adCloseStartTimer();
        if (this.adStartTime > 0) {
            this.adStartTime = System.currentTimeMillis();
        }
    }
}