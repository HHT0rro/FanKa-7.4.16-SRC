package com.alibaba.security.common.track.model;

import com.alibaba.security.biometrics.logic.view.ALBiometricsActivityParentView;
import com.alibaba.security.common.track.model.TrackConstants;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public enum LastExitTrackMsgPage {
    H5(TrackConstants.Layer.H5),
    BIO(ALBiometricsActivityParentView.f2435k),
    TAKE_PHOTO("takephoto");

    private String msg;

    LastExitTrackMsgPage(String str) {
        this.msg = str;
    }

    public String getMsg() {
        return this.msg;
    }
}
