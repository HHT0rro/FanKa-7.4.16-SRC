package com.alimm.tanx.core.ad.ad.reward.model;

import com.alimm.tanx.core.ad.bean.BaseBean;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class VideoParam extends BaseBean {
    public boolean looping;
    public boolean mute;

    public VideoParam() {
        this.mute = false;
        this.looping = false;
    }

    public VideoParam(boolean z10) {
        this.looping = false;
        this.mute = z10;
    }

    public VideoParam(boolean z10, boolean z11) {
        this.mute = z10;
        this.looping = z11;
    }
}
