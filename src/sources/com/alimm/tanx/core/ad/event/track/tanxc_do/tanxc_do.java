package com.alimm.tanx.core.ad.event.track.tanxc_do;

import com.alimm.tanx.core.ad.ITanxAd;
import com.alimm.tanx.core.net.NetWorkManager;
import com.alimm.tanx.core.net.bean.RequestBean;
import com.alimm.tanx.core.net.callback.NetWorkCallBack;
import com.alimm.tanx.core.ut.UtErrorCode;
import com.alimm.tanx.core.ut.impl.TanxBaseUt;
import com.alimm.tanx.core.utils.LogUtils;
import java.util.Iterator;
import java.util.List;

/* compiled from: BiddingUpload.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class tanxc_do {
    public static tanxc_do tanxc_do;

    public static tanxc_do tanxc_do() {
        if (tanxc_do == null) {
            synchronized (tanxc_do.class) {
                if (tanxc_do == null) {
                    tanxc_do = new tanxc_do();
                }
            }
        }
        return tanxc_do;
    }

    public void tanxc_do(List<ITanxAd> list) {
        if (list != null) {
            Iterator<ITanxAd> iterator2 = list.iterator2();
            while (iterator2.hasNext()) {
                try {
                    RequestBean build = new RequestBean().setUrl(iterator2.next().getBidInfo().getWinNoticeUrl()).build();
                    build.setOverrideError(true);
                    NetWorkManager.getInstance().sendHttpGet(build, Object.class, false, false, new NetWorkCallBack() { // from class: com.alimm.tanx.core.ad.event.track.tanxc_do.tanxc_do.1
                        @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
                        public void error(int i10, String str, String str2) {
                            LogUtils.d("BiddingUpload", str2);
                        }

                        @Override // com.alimm.tanx.core.net.callback.NetWorkCallBack
                        public void succ(Object obj) {
                            LogUtils.d("BiddingUpload", obj.toString());
                        }
                    });
                } catch (Exception e2) {
                    e2.printStackTrace();
                    LogUtils.e("BiddingUpload", e2);
                    TanxBaseUt.utError(UtErrorCode.CRASH_ERROR.getIntCode(), "BiddingUpload", LogUtils.getStackTraceMessage(e2), "");
                }
            }
        }
    }
}
