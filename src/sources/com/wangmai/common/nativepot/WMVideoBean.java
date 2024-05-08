package com.wangmai.common.nativepot;

import android.view.View;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class WMVideoBean {
    public WMVideoControl videoControl;
    public View videoView;

    public WMVideoBean(WMVideoControl wMVideoControl, View view) {
        this.videoControl = wMVideoControl;
        this.videoView = view;
    }

    public WMVideoControl getVideoControl() {
        return this.videoControl;
    }

    public View getVideoView() {
        return this.videoView;
    }

    public WMVideoBean setVideoControl(WMVideoControl wMVideoControl) {
        this.videoControl = wMVideoControl;
        return this;
    }

    public WMVideoBean setVideoView(View view) {
        this.videoView = view;
        return this;
    }
}
