package com.alimm.tanx.core.ad.event.track.expose;

import com.alibaba.fastjson.JSON;
import com.alimm.tanx.core.net.NetWorkManager;
import com.alimm.tanx.core.net.bean.RequestBean;
import com.alimm.tanx.core.net.callback.NetWorkCallBack;
import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.utils.LogUtils;

/* compiled from: DefaultExposer.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class tanxc_do implements IExposer {
    @Override // com.alimm.tanx.core.ad.event.track.expose.IExposer
    public void onExpose(String str, final String str2, final ExposeCallback exposeCallback) {
        try {
            RequestBean build = new RequestBean().setUrl(str2).build();
            build.setOverrideError(true);
            exposeCallback.send(str2);
            NetWorkManager.getInstance().sendHttpGet(build, Object.class, false, false, new NetWorkCallBack() { // from class: com.alimm.tanx.core.ad.event.track.expose.tanxc_do.1
                @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
                public void error(int i10, String str3, String str4) {
                    LogUtils.d("DefaultExposer", str2);
                    LogUtils.d("DefaultExposer", str4);
                    ExposeCallback exposeCallback2 = exposeCallback;
                    if (exposeCallback2 != null) {
                        exposeCallback2.onFail(i10, str4, str2);
                    }
                }

                @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
                public void succ(Object obj) {
                    LogUtils.d("DefaultExposer", JSON.toJSONString(obj));
                    ExposeCallback exposeCallback2 = exposeCallback;
                    if (exposeCallback2 != null) {
                        exposeCallback2.onSucceed(200, str2);
                    }
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
            LogUtils.d("DefaultExposer", str2);
            if (exposeCallback != null) {
                exposeCallback.onFail(UtErrorCode.CRASH_ERROR.getIntCode(), LogUtils.getStackTraceMessage(e2), str2);
            }
        }
    }
}
