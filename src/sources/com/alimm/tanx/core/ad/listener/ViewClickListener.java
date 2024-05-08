package com.alimm.tanx.core.ad.listener;

import android.view.View;
import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.ut.impl.TanxBaseUt;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.NotConfused;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class ViewClickListener implements View.OnClickListener, NotConfused {
    public long lastClickTime = 0;
    public final long clickInterval = 500;
    public final String TAG = "ViewClickListener";

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        try {
            if (System.currentTimeMillis() - this.lastClickTime > 500) {
                this.lastClickTime = System.currentTimeMillis();
                viewClick(view);
            } else {
                LogUtils.d("ViewClickListener", "点击过快");
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            LogUtils.e("ViewClickListener", e2.getMessage());
            TanxBaseUt.utError(UtErrorCode.CRASH_ERROR.getIntCode(), "ViewClickListener", LogUtils.getStackTraceMessage(e2), "");
        }
    }

    public abstract void viewClick(View view);
}
