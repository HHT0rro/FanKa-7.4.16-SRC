package com.wangmai.ad.dex.allmodules.utils;

import android.content.Context;
import com.wangmai.ad.dex.allmodules.bean.ApiBean;
import com.wangmai.ad.dex.allmodules.bean.VirtualClickAdSlotInfo;
import com.wangmai.ad.dex.allmodules.utils.appa;
import com.wangmai.common.utils.ThreadUtils;
import com.wangmai.common.utils.TimerUtil;
import java.util.TimerTask;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* compiled from: SimulatedClickHelper.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class appu extends com.wangmai.ad.dex.allmodules.utils.appa {
    private static final String appg = "appu";
    private appa.appc appf;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: SimulatedClickHelper.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appa extends TimerTask {
        appa() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            appu.this.appi();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: SimulatedClickHelper.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public class appb implements Runnable {
        appb() {
        }

        @Override // java.lang.Runnable
        public void run() {
            appa.appa.appf.appd.appe(appu.appg, "触发模拟点击>>>");
            appu.this.appf.appa(-1, -1.0f, -1.0f, -1.0f, -1.0f);
        }
    }

    public appu(Context context, String str, ApiBean.Optimization optimization, boolean z10) {
        super(context, str, optimization, z10);
    }

    private boolean apph() {
        return (appb() || appd()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void appi() {
        if (!apph() || this.appf == null) {
            return;
        }
        ThreadUtils.runOnUIThread(new appb());
    }

    protected boolean appc() {
        if (!((this.appc || this.appd.getInteractiveObjs() == null || this.appd.getInteractiveObjs().isEmpty()) ? false : true)) {
            return false;
        }
        appa.appa.appf.appd.appe(appg, "未触发模拟点击逻辑(互动形式限制)");
        return true;
    }

    protected boolean appd() {
        VirtualClickAdSlotInfo appa2 = appa();
        if (appa2 != null) {
            long currentTimeMillis = System.currentTimeMillis() - appa2.getLastSimulatedClickTime();
            if (currentTimeMillis < ((long) (this.appd.getSimulateClickInterval() * 1000))) {
                appa.appa.appf.appd.appe(appg, "未触发模拟点击逻辑(点击时间间隔限制)", currentTimeMillis + " < " + (this.appd.getSimulateClickInterval() * 1000));
                return true;
            }
        }
        return false;
    }

    protected boolean appe() {
        ApiBean.Optimization optimization = this.appd;
        boolean z10 = optimization == null || optimization.getSimulateClickFrequency() <= 0 || this.appd.getSimulateClickWait() <= 0;
        if (z10) {
            appa.appa.appf.appd.appe(appg, "未触发模拟点击逻辑（无效配置限制）");
        }
        return z10;
    }

    public void appf() {
        appb(appf.appm);
    }

    public void appa(appa.appc appcVar) {
        appa.appa.appf.appd.appa(appg, "销毁模拟点击监测", appcVar);
        this.appf = null;
    }

    public void appb(appa.appc appcVar) {
        if (appa(appf.appm) || appc(appcVar) || appe() || appc()) {
            return;
        }
        appa.appa.appf.appd.appe(appg, "启用本次模点击监听");
        this.appf = appcVar;
        TimerUtil.getInstance().schedule(this.appd.getSimulateClickWait(), new appa());
    }

    private boolean appc(appa.appc appcVar) {
        boolean z10 = appcVar == null;
        if (z10) {
            appa.appa.appf.appd.appe(appg, "未触发模拟点击逻辑（无效参数限制）:,callbackListener 为空:");
        }
        return z10;
    }

    protected boolean appb() {
        VirtualClickAdSlotInfo appa2 = appa();
        if (appa2 == null || appa2.isExpired() || appa2.getSimulatedClickedCount() <= this.appd.getSimulateClickFrequency()) {
            return false;
        }
        appa.appa.appf.appd.appe(appg, "未触发模拟点击逻辑(点击频次限制)");
        return true;
    }
}
