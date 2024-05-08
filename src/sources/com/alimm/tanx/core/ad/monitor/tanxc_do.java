package com.alimm.tanx.core.ad.monitor;

import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.alimm.tanx.core.ad.view.TanxAdView;
import com.alimm.tanx.core.constant.AdConstants;
import com.alimm.tanx.core.orange.OrangeManager;
import com.alimm.tanx.core.orange.bean.ExposureConfigBean;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.TanxCountDownTimer;

/* compiled from: TanxAdMonitor.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class tanxc_do implements ViewTreeObserver.OnPreDrawListener, ITanxAdMonitor {
    public volatile boolean tanxc_byte;
    public float tanxc_case;
    public long tanxc_char;
    public TanxAdView tanxc_do;
    public Rect tanxc_else;
    public boolean tanxc_for;
    public String tanxc_goto;
    public ITanxExposureCallback tanxc_if;
    public boolean tanxc_int;
    public volatile TanxCountDownTimer tanxc_long;
    public boolean tanxc_new;
    public long tanxc_this;
    public volatile boolean tanxc_try;
    public final int tanxc_void;

    public tanxc_do(TanxAdView tanxAdView, ITanxExposureCallback iTanxExposureCallback, int i10) {
        this.tanxc_for = false;
        this.tanxc_int = true;
        this.tanxc_try = false;
        this.tanxc_byte = false;
        this.tanxc_else = new Rect();
        this.tanxc_goto = "";
        this.tanxc_do = tanxAdView;
        this.tanxc_if = iTanxExposureCallback;
        this.tanxc_void = i10;
        tanxc_if();
    }

    private void tanxc_else() {
        try {
            LogUtils.d("TanxAdMonitor", "initTimer  init");
            if (!OrangeManager.getInstance().getCommonSwitch("useRealTimeExposer")) {
                LogUtils.d("TanxAdMonitor", "initTimer 开关关闭");
            } else {
                if (this.tanxc_long != null) {
                    return;
                }
                LogUtils.d("TanxAdMonitor", "initTimer  init start");
                final long j10 = 180000;
                final long j11 = 200;
                this.tanxc_long = new TanxCountDownTimer(j10, j11) { // from class: com.alimm.tanx.core.ad.monitor.TanxAdMonitor$1
                    @Override // com.alimm.tanx.core.utils.TanxCountDownTimer
                    public void onFinish() {
                        LogUtils.d("TanxAdMonitor", "initTimer - onFinish");
                    }

                    @Override // com.alimm.tanx.core.utils.TanxCountDownTimer
                    public void onTick(long j12) {
                        LogUtils.d("TanxAdMonitor", "initTimer  onTick exposureCompleted: " + tanxc_do.this.tanxc_byte + " isOnExposure: " + tanxc_do.this.tanxc_try);
                        if (tanxc_do.this.tanxc_byte) {
                            tanxc_do.this.tanxc_this();
                        } else if (tanxc_do.this.tanxc_try) {
                            tanxc_do.this.onPreDraw();
                        }
                    }
                };
            }
        } catch (Exception e2) {
            LogUtils.e("TanxAdMonitor", "initTimer", e2);
        }
    }

    private void tanxc_goto() {
        try {
            LogUtils.d("TanxAdMonitor", "startTimer");
            if (!OrangeManager.getInstance().getCommonSwitch("useRealTimeExposer")) {
                LogUtils.d("TanxAdMonitor", "startTimer 开关关闭");
                return;
            }
            if (this.tanxc_byte) {
                LogUtils.d("TanxAdMonitor", "startTimer 已经曝光，不再重复启动");
                return;
            }
            tanxc_else();
            if (this.tanxc_long != null) {
                if (this.tanxc_long.isPaused()) {
                    LogUtils.d("TanxAdMonitor", "startTimer resume");
                    this.tanxc_long.resume();
                    return;
                } else {
                    LogUtils.d("TanxAdMonitor", "startTimer start");
                    this.tanxc_long.start();
                    return;
                }
            }
            LogUtils.d("TanxAdMonitor", "startTimer tanxExposureCheckTimer为空");
        } catch (Exception e2) {
            LogUtils.e("TanxAdMonitor", "startTimer", e2);
        }
    }

    private void tanxc_long() {
        try {
            LogUtils.d("TanxAdMonitor", "stopTimer");
            if (!OrangeManager.getInstance().getCommonSwitch("useRealTimeExposer")) {
                LogUtils.d("TanxAdMonitor", "stopTimer 开关关闭");
            } else if (this.tanxc_long != null) {
                this.tanxc_long.pause();
            }
        } catch (Exception e2) {
            LogUtils.e("TanxAdMonitor", "stopTimer", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tanxc_this() {
        try {
            LogUtils.d("TanxAdMonitor", "cancelTimer");
            if (!OrangeManager.getInstance().getCommonSwitch("useRealTimeExposer")) {
                LogUtils.d("TanxAdMonitor", "cancelTimer 开关关闭");
            } else if (this.tanxc_long != null) {
                this.tanxc_long.cancel();
                this.tanxc_long = null;
            }
        } catch (Exception e2) {
            LogUtils.e("TanxAdMonitor", "cancelTimer", e2);
        }
    }

    @Override // com.alimm.tanx.core.ad.monitor.ITanxAdMonitor
    public void onAttachedToWindow() {
        this.tanxc_for = true;
        this.tanxc_do.getViewTreeObserver().addOnPreDrawListener(this);
        tanxc_else();
        LogUtils.d("TanxAdMonitor_Lifecycle", "广告onAttachedToWindow");
    }

    @Override // com.alimm.tanx.core.ad.monitor.ITanxAdMonitor
    public void onDetachedFromWindow() {
        this.tanxc_for = false;
        this.tanxc_do.getViewTreeObserver().removeOnPreDrawListener(this);
        LogUtils.d("TanxAdMonitor_Lifecycle", "广告onDetachedFromWindow");
        tanxc_new();
        tanxc_this();
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        boolean z10 = this.tanxc_do.getLocalVisibleRect(this.tanxc_else) && this.tanxc_do.isShown();
        LogUtils.i("TanxAdMonitor", "onPreDraw isVisible->" + z10 + " showRatio：" + this.tanxc_case);
        if (!z10) {
            tanxc_new();
            return true;
        }
        if (this.tanxc_case <= 0.0f) {
            tanxc_for();
        } else if (Math.abs(this.tanxc_else.height()) > this.tanxc_do.getHeight() * this.tanxc_case && Math.abs(this.tanxc_else.width()) > this.tanxc_do.getWidth() * this.tanxc_case) {
            LogUtils.i("TanxAdMonitor", "满足曝光面积");
            tanxc_for();
        } else {
            tanxc_new();
        }
        return true;
    }

    @Override // com.alimm.tanx.core.ad.monitor.ITanxAdMonitor
    public void onVisibilityAggregated(boolean z10) {
        this.tanxc_new = z10;
        if (z10) {
            return;
        }
        LogUtils.d("TanxAdMonitor_Lifecycle", "广告变为不可见");
        tanxc_new();
    }

    @Override // com.alimm.tanx.core.ad.monitor.ITanxAdMonitor
    public void onWindowFocusChanged(boolean z10) {
        this.tanxc_int = z10;
        LogUtils.d("TanxAdMonitor_Lifecycle", "广告焦点发生变化，onWindowFocusChanged=" + z10);
        tanxc_new();
        if (z10) {
            onPreDraw();
        }
    }

    public void tanxc_byte() {
        this.tanxc_try = true;
        this.tanxc_this = System.currentTimeMillis();
    }

    public void tanxc_case() {
        this.tanxc_try = false;
    }

    public float tanxc_char() {
        if (this.tanxc_do.getVisibility() != 0) {
            return 1.0f;
        }
        View view = this.tanxc_do;
        Rect rect = new Rect();
        if (!view.getGlobalVisibleRect(rect)) {
            return 1.0f;
        }
        int measuredHeight = (this.tanxc_do.getMeasuredHeight() * this.tanxc_do.getMeasuredWidth()) - (rect.width() * rect.height());
        float f10 = 0.0f;
        while (view.getParent() instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup.getVisibility() != 0) {
                return 1.0f;
            }
            int tanxc_do = tanxc_do(view, viewGroup);
            while (true) {
                tanxc_do++;
                if (tanxc_do < viewGroup.getChildCount()) {
                    View childAt = viewGroup.getChildAt(tanxc_do);
                    if (childAt.getVisibility() != 0) {
                        break;
                    }
                    Rect rect2 = new Rect();
                    this.tanxc_do.getGlobalVisibleRect(rect2);
                    Rect rect3 = new Rect();
                    childAt.getGlobalVisibleRect(rect3);
                    if (rect3.intersect(rect2)) {
                        f10 = Math.max(f10, ((rect3.width() * rect3.height()) + measuredHeight) / ((rect2.width() * rect2.height()) * 1.0f));
                    }
                }
            }
            view = viewGroup;
        }
        return Math.round(f10 * 100.0f) / 100.0f;
    }

    public void tanxc_for() {
        this.tanxc_new = this.tanxc_do.getVisibility() == 0;
        LogUtils.i("TanxAdMonitor", "tryStartExposure 尝试开始曝光计时，相关数据：attachedWindow=" + this.tanxc_for + "; hasWindowFocus" + this.tanxc_int + "; visibilityAggregated" + this.tanxc_new + "; isOnExposure=" + this.tanxc_try);
        if (this.tanxc_for && this.tanxc_int && this.tanxc_new) {
            if (!this.tanxc_try) {
                tanxc_byte();
                LogUtils.i("TanxAdMonitor", "开始曝光计时showTime:" + this.tanxc_char);
            }
            tanxc_int();
        }
        tanxc_goto();
    }

    public void tanxc_if() {
        ExposureConfigBean exposureConfigBean = OrangeManager.getInstance().getExposureConfigBean(this.tanxc_void);
        if (exposureConfigBean == null) {
            tanxc_do();
        } else {
            this.tanxc_case = exposureConfigBean.showRatio;
            this.tanxc_char = exposureConfigBean.showTime;
        }
        if (this.tanxc_goto.equals(AdConstants.PID_STYLE_NEW_REWARD_ID) || this.tanxc_goto.equals(AdConstants.PID_STYLE_ORDER_REWARD_ID)) {
            LogUtils.d("TanxAdMonitor", "新激励浏览直接曝光 adType=" + this.tanxc_void + " pidStyleId=" + this.tanxc_goto);
            tanxc_try();
            tanxc_do(0L);
        }
    }

    public void tanxc_int() {
        if (this.tanxc_char == 0) {
            tanxc_case();
            tanxc_try();
            tanxc_do(0L);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.tanxc_this;
        LogUtils.i("TanxAdMonitor", "tryExposure 曝光时长=" + currentTimeMillis + " showTime=" + this.tanxc_char);
        if (currentTimeMillis > this.tanxc_char) {
            tanxc_try();
            LogUtils.i("TanxAdMonitor", "tryExposure 广告曝光成功，曝光时长=" + currentTimeMillis);
        }
    }

    public void tanxc_new() {
        if (this.tanxc_try) {
            tanxc_case();
            long currentTimeMillis = System.currentTimeMillis() - this.tanxc_this;
            LogUtils.i("TanxAdMonitor", "停止曝光,曝光时长=" + currentTimeMillis + " showTime=" + this.tanxc_char);
            if (currentTimeMillis > this.tanxc_char) {
                tanxc_try();
                tanxc_do(currentTimeMillis);
                LogUtils.i("TanxAdMonitor", "广告曝光总时长=" + currentTimeMillis);
            }
        }
        tanxc_long();
    }

    public void tanxc_try() {
        if (this.tanxc_byte) {
            return;
        }
        this.tanxc_byte = true;
        ITanxExposureCallback iTanxExposureCallback = this.tanxc_if;
        if (iTanxExposureCallback != null) {
            iTanxExposureCallback.exposure();
        }
    }

    public void tanxc_do() {
        this.tanxc_case = 0.5f;
        this.tanxc_char = 1000L;
    }

    public void tanxc_do(long j10) {
        ITanxExposureCallback iTanxExposureCallback = this.tanxc_if;
        if (iTanxExposureCallback != null) {
            iTanxExposureCallback.exposureTime(j10);
        }
    }

    private int tanxc_do(View view, ViewGroup viewGroup) {
        int i10 = 0;
        while (i10 < viewGroup.getChildCount() && viewGroup.getChildAt(i10) != view) {
            i10++;
        }
        return i10;
    }

    public tanxc_do(TanxAdView tanxAdView, ITanxExposureCallback iTanxExposureCallback, int i10, String str) {
        this.tanxc_for = false;
        this.tanxc_int = true;
        this.tanxc_try = false;
        this.tanxc_byte = false;
        this.tanxc_else = new Rect();
        this.tanxc_goto = "";
        this.tanxc_do = tanxAdView;
        this.tanxc_if = iTanxExposureCallback;
        this.tanxc_void = i10;
        if (!TextUtils.isEmpty(str)) {
            this.tanxc_goto = str;
        }
        tanxc_if();
    }
}
