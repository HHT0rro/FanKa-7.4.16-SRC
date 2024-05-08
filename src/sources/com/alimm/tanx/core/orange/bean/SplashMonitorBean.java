package com.alimm.tanx.core.orange.bean;

import com.alimm.tanx.core.ad.bean.BaseBean;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class SplashMonitorBean extends BaseBean {
    public String coverRatio;

    public float getCoverRatio() {
        try {
            return Float.parseFloat(this.coverRatio);
        } catch (Exception unused) {
            return 0.0f;
        }
    }
}
