package com.alimm.tanx.core.ad.monitor;

import android.os.SystemClock;
import android.util.ArrayMap;
import com.alibaba.fastjson.JSON;
import com.alimm.tanx.core.ad.view.TanxAdView;
import com.alimm.tanx.core.orange.OrangeManager;
import com.alimm.tanx.core.orange.bean.OrangeBean;
import com.alimm.tanx.core.orange.bean.OrangeUtBean;
import com.alimm.tanx.core.orange.bean.SplashMonitorBean;
import com.alimm.tanx.core.ut.impl.TanxMonitorUt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: TanxSplashAdMonitor.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class tanxc_new extends tanxc_do {
    public long tanxc_break;
    public long tanxc_catch;
    public float tanxc_class;
    public long tanxc_const;
    public float tanxc_long;
    public final List<Map<String, Object>> tanxc_this;
    public long tanxc_void;

    public tanxc_new(TanxAdView tanxAdView, ITanxExposureCallback iTanxExposureCallback) {
        super(tanxAdView, iTanxExposureCallback, 1);
        OrangeUtBean orangeUtBean;
        SplashMonitorBean splashMonitorBean;
        this.tanxc_long = 0.2f;
        this.tanxc_this = new ArrayList();
        OrangeBean orangeBean = OrangeManager.getInstance().getOrangeBean();
        if (orangeBean == null || (orangeUtBean = orangeBean.ut) == null || (splashMonitorBean = orangeUtBean.splashMonitor) == null) {
            return;
        }
        this.tanxc_long = splashMonitorBean.getCoverRatio();
    }

    private Map<String, Object> tanxc_if(float f10) {
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("timestamp", Long.valueOf(System.currentTimeMillis()));
        arrayMap.put("width", Integer.valueOf(this.tanxc_do.getWidth()));
        arrayMap.put("height", Integer.valueOf(this.tanxc_do.getHeight()));
        arrayMap.put("cover_percent", Float.valueOf(f10));
        return arrayMap;
    }

    @Override // com.alimm.tanx.core.ad.monitor.tanxc_do, com.alimm.tanx.core.ad.monitor.ITanxAdMonitor
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.tanxc_if == null || !TanxMonitorUt.isOpenSplashMonitor()) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("monitors", JSON.toJSONString(this.tanxc_this));
        hashMap.put("total_time", String.valueOf(this.tanxc_catch));
        hashMap.put("exposure_time", String.valueOf(this.tanxc_break));
        this.tanxc_if.onMonitor(hashMap);
    }

    @Override // com.alimm.tanx.core.ad.monitor.tanxc_do, android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        return super.onPreDraw();
    }

    @Override // com.alimm.tanx.core.ad.monitor.tanxc_do, com.alimm.tanx.core.ad.monitor.ITanxAdMonitor
    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        if (z10) {
            return;
        }
        tanxc_do(1.0f);
    }

    @Override // com.alimm.tanx.core.ad.monitor.tanxc_do
    public void tanxc_do() {
        this.tanxc_char = 0L;
        this.tanxc_case = 0.5f;
    }

    @Override // com.alimm.tanx.core.ad.monitor.tanxc_do
    public void tanxc_for() {
        super.tanxc_for();
        float tanxc_char = tanxc_char();
        if (this.tanxc_int) {
            tanxc_do(tanxc_char);
        }
    }

    @Override // com.alimm.tanx.core.ad.monitor.tanxc_do
    public void tanxc_new() {
        super.tanxc_new();
    }

    private void tanxc_do(float f10) {
        if (TanxMonitorUt.isOpenSplashMonitor()) {
            if (this.tanxc_this.size() <= 0) {
                this.tanxc_class = f10;
                this.tanxc_void = SystemClock.elapsedRealtime();
                this.tanxc_this.add(tanxc_if(f10));
            } else {
                Map<String, Object> map = this.tanxc_this.get(r0.size() - 1);
                if (map != null && map.get("cover_percent") != null) {
                    this.tanxc_class = ((Float) map.get("cover_percent")).floatValue();
                }
                if (Math.abs(f10 - this.tanxc_class) > 0.05d) {
                    this.tanxc_this.add(tanxc_if(f10));
                }
            }
            if (this.tanxc_const == 0) {
                this.tanxc_const = SystemClock.elapsedRealtime();
            }
            float f11 = this.tanxc_class;
            float f12 = this.tanxc_long;
            if (f11 < f12 && f10 < f12) {
                this.tanxc_break += SystemClock.elapsedRealtime() - this.tanxc_const;
            }
            this.tanxc_const = SystemClock.elapsedRealtime();
            this.tanxc_class = f10;
            this.tanxc_catch = SystemClock.elapsedRealtime() - this.tanxc_void;
        }
    }
}
