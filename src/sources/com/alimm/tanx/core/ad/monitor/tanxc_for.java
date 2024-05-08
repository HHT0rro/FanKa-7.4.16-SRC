package com.alimm.tanx.core.ad.monitor;

import android.os.SystemClock;
import com.alimm.tanx.core.ad.view.TanxAdView;
import com.alimm.tanx.core.orange.OrangeManager;
import com.alimm.tanx.core.orange.bean.FeedMonitorBean;
import com.alimm.tanx.core.orange.bean.OrangeBean;
import com.alimm.tanx.core.orange.bean.OrangeUtBean;
import com.alimm.tanx.core.ut.impl.TanxMonitorUt;

/* compiled from: TanxFeedVideoPlayerMonitor.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class tanxc_for extends tanxc_do {
    public long tanxc_break;
    public boolean tanxc_catch;
    public float tanxc_class;
    public int tanxc_const;
    public int tanxc_final;
    public boolean tanxc_long;
    public ITanxFeedVideoMonitorCallback tanxc_this;
    public long tanxc_void;

    public tanxc_for(TanxAdView tanxAdView, ITanxFeedVideoMonitorCallback iTanxFeedVideoMonitorCallback) {
        super(tanxAdView, iTanxFeedVideoMonitorCallback, 2);
        OrangeUtBean orangeUtBean;
        FeedMonitorBean feedMonitorBean;
        this.tanxc_catch = true;
        this.tanxc_class = 0.2f;
        this.tanxc_long = false;
        this.tanxc_this = iTanxFeedVideoMonitorCallback;
        OrangeBean orangeBean = OrangeManager.getInstance().getOrangeBean();
        if (orangeBean == null || (orangeUtBean = orangeBean.ut) == null || (feedMonitorBean = orangeUtBean.feedMonitor) == null) {
            return;
        }
        this.tanxc_class = feedMonitorBean.getMinRatio();
    }

    private void tanxc_else() {
        if (TanxMonitorUt.isOpenFeedMonitor()) {
            if ((this.tanxc_for && this.tanxc_int && this.tanxc_new && this.tanxc_else.width() > 0 && this.tanxc_else.height() > 0) || this.tanxc_void == 0 || !this.tanxc_catch) {
                return;
            }
            this.tanxc_catch = false;
            this.tanxc_break = SystemClock.elapsedRealtime() - this.tanxc_void;
            this.tanxc_void = 0L;
        }
    }

    @Override // com.alimm.tanx.core.ad.monitor.tanxc_do, com.alimm.tanx.core.ad.monitor.ITanxAdMonitor
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.tanxc_this.attach();
    }

    @Override // com.alimm.tanx.core.ad.monitor.tanxc_do, com.alimm.tanx.core.ad.monitor.ITanxAdMonitor
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        tanxc_else();
        this.tanxc_long = false;
        this.tanxc_this.detached();
    }

    @Override // com.alimm.tanx.core.ad.monitor.tanxc_do, android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        boolean onPreDraw = super.onPreDraw();
        if (Math.abs(this.tanxc_else.height()) > this.tanxc_do.getHeight() * this.tanxc_class && Math.abs(this.tanxc_else.width()) > this.tanxc_do.getWidth() * this.tanxc_class && this.tanxc_void == 0) {
            this.tanxc_void = SystemClock.elapsedRealtime();
        }
        this.tanxc_const = this.tanxc_do.getWidth();
        this.tanxc_final = this.tanxc_do.getHeight();
        return onPreDraw;
    }

    @Override // com.alimm.tanx.core.ad.monitor.tanxc_do, com.alimm.tanx.core.ad.monitor.ITanxAdMonitor
    public void onVisibilityAggregated(boolean z10) {
        super.onVisibilityAggregated(z10);
        if (z10) {
            this.tanxc_catch = true;
        } else {
            tanxc_else();
        }
    }

    @Override // com.alimm.tanx.core.ad.monitor.tanxc_do, com.alimm.tanx.core.ad.monitor.ITanxAdMonitor
    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        if (z10) {
            this.tanxc_catch = true;
        } else {
            tanxc_else();
        }
    }

    @Override // com.alimm.tanx.core.ad.monitor.tanxc_do
    public void tanxc_for() {
        super.tanxc_for();
        if (this.tanxc_for && this.tanxc_int && this.tanxc_new && !this.tanxc_long) {
            this.tanxc_this.show();
            this.tanxc_long = true;
        }
    }

    @Override // com.alimm.tanx.core.ad.monitor.tanxc_do
    public void tanxc_new() {
        super.tanxc_new();
        if (this.tanxc_for && this.tanxc_long) {
            this.tanxc_this.remove();
            this.tanxc_long = false;
        }
    }

    @Override // com.alimm.tanx.core.ad.monitor.tanxc_do
    public void tanxc_try() {
        super.tanxc_try();
    }
}
