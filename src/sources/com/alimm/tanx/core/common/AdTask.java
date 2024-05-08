package com.alimm.tanx.core.common;

import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.ut.impl.TanxBaseUt;
import com.alimm.tanx.core.utils.LogUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class AdTask implements Runnable {
    public Runnable tanxc_do;
    public onErrorListener tanxc_for;
    public String tanxc_if;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface onErrorListener {
        void onError(String str);
    }

    public AdTask(Runnable runnable, String str) {
        this.tanxc_do = runnable;
        this.tanxc_if = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.tanxc_do.run();
        } catch (Exception e2) {
            e2.printStackTrace();
            onErrorListener onerrorlistener = this.tanxc_for;
            if (onerrorlistener != null) {
                onerrorlistener.onError(e2.getMessage());
            }
            LogUtils.e("AdTask", e2, "AdTask");
            TanxBaseUt.utError(UtErrorCode.CRASH_ERROR.getIntCode(), "AdTask", LogUtils.getStackTraceMessage(e2), "AdTask");
        }
    }

    public AdTask(Runnable runnable, String str, onErrorListener onerrorlistener) {
        this.tanxc_do = runnable;
        this.tanxc_if = str;
        this.tanxc_for = onerrorlistener;
    }
}
