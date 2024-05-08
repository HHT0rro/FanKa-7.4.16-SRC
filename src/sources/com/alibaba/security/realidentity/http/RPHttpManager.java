package com.alibaba.security.realidentity.http;

import com.alibaba.security.realidentity.RPEnv;
import com.alibaba.security.realidentity.build.gx;
import com.alibaba.security.realidentity.build.gy;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class RPHttpManager {
    public void init(gx gxVar, RPEnv rPEnv) {
        HttpRequestManager.getInstance().init(gxVar, rPEnv);
    }

    public void setTrackLog(gy gyVar) {
        HttpRequestManager.getInstance().setTrackLog(gyVar);
    }

    public void updateEnv(RPEnv rPEnv) {
        HttpRequestManager.getInstance().setCurEnv(rPEnv);
    }
}
