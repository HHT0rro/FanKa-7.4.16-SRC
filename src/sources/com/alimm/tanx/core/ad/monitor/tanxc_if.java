package com.alimm.tanx.core.ad.monitor;

import android.os.SystemClock;
import com.alimm.tanx.core.ad.view.TanxAdView;
import com.alimm.tanx.core.orange.OrangeManager;
import com.alimm.tanx.core.orange.bean.FeedMonitorBean;
import com.alimm.tanx.core.orange.bean.OrangeBean;
import com.alimm.tanx.core.orange.bean.OrangeUtBean;
import com.alimm.tanx.core.ut.impl.TanxMonitorUt;
import java.util.HashMap;

/* compiled from: TanxFeedAdMonitor.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class tanxc_if extends tanxc_do {
    public float tanxc_break;
    public int tanxc_catch;
    public int tanxc_class;
    public long tanxc_long;
    public long tanxc_this;
    public boolean tanxc_void;

    public tanxc_if(TanxAdView tanxAdView, ITanxExposureCallback iTanxExposureCallback) {
        super(tanxAdView, iTanxExposureCallback, 2);
        OrangeUtBean orangeUtBean;
        FeedMonitorBean feedMonitorBean;
        this.tanxc_void = true;
        this.tanxc_break = 0.2f;
        OrangeBean orangeBean = OrangeManager.getInstance().getOrangeBean();
        if (orangeBean == null || (orangeUtBean = orangeBean.ut) == null || (feedMonitorBean = orangeUtBean.feedMonitor) == null) {
            return;
        }
        this.tanxc_break = feedMonitorBean.getMinRatio();
    }

    private void tanxc_else() {
        if (TanxMonitorUt.isOpenFeedMonitor()) {
            if ((this.tanxc_for && this.tanxc_int && this.tanxc_new && this.tanxc_else.width() > 0 && this.tanxc_else.height() > 0) || this.tanxc_long == 0 || !this.tanxc_void) {
                return;
            }
            this.tanxc_void = false;
            this.tanxc_this = SystemClock.elapsedRealtime() - this.tanxc_long;
            this.tanxc_long = 0L;
            if (this.tanxc_if != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("exposure_time", String.valueOf(this.tanxc_this));
                hashMap.put("min_ratio", String.valueOf(this.tanxc_break));
                hashMap.put("width", String.valueOf(this.tanxc_catch));
                hashMap.put("height", String.valueOf(this.tanxc_class));
                this.tanxc_if.onMonitor(hashMap);
            }
        }
    }

    @Override // com.alimm.tanx.core.ad.monitor.tanxc_do, com.alimm.tanx.core.ad.monitor.ITanxAdMonitor
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        tanxc_else();
    }

    @Override // com.alimm.tanx.core.ad.monitor.tanxc_do, android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        boolean onPreDraw = super.onPreDraw();
        if (Math.abs(this.tanxc_else.height()) > this.tanxc_do.getHeight() * this.tanxc_break && Math.abs(this.tanxc_else.width()) > this.tanxc_do.getWidth() * this.tanxc_break && this.tanxc_long == 0) {
            this.tanxc_long = SystemClock.elapsedRealtime();
        }
        this.tanxc_catch = this.tanxc_do.getWidth();
        this.tanxc_class = this.tanxc_do.getHeight();
        return onPreDraw;
    }

    @Override // com.alimm.tanx.core.ad.monitor.tanxc_do, com.alimm.tanx.core.ad.monitor.ITanxAdMonitor
    public void onVisibilityAggregated(boolean z10) {
        super.onVisibilityAggregated(z10);
        if (z10) {
            this.tanxc_void = true;
        } else {
            tanxc_else();
        }
    }

    @Override // com.alimm.tanx.core.ad.monitor.tanxc_do, com.alimm.tanx.core.ad.monitor.ITanxAdMonitor
    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        if (z10) {
            this.tanxc_void = true;
        } else {
            tanxc_else();
        }
    }

    @Override // com.alimm.tanx.core.ad.monitor.tanxc_do
    public void tanxc_new() {
        super.tanxc_new();
    }

    @Override // com.alimm.tanx.core.ad.monitor.tanxc_do
    public void tanxc_try() {
        super.tanxc_try();
    }
}
