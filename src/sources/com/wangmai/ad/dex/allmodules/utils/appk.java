package com.wangmai.ad.dex.allmodules.utils;

import android.text.TextUtils;
import com.wangmai.ad.dex.allmodules.bean.DemandEntityHandle;
import com.wangmai.common.utils.ConstantInfo;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* compiled from: DemandSupportUtils.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class appk {

    /* renamed from: appa, reason: collision with root package name */
    private static final String f46851appa = "appk";

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
    /* compiled from: DemandSupportUtils.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
    public static class appa {
        public static void appa(ArrayBlockingQueue<DemandEntityHandle> arrayBlockingQueue) {
            Iterator<DemandEntityHandle> iterator2 = arrayBlockingQueue.iterator2();
            while (iterator2.hasNext()) {
                DemandEntityHandle next = iterator2.next();
                if (TextUtils.equals(next.getDemandClassType(), "guangdiantong") && next.getStatus() == 3) {
                    ConstantInfo.responseSuccessRoundByYLH++;
                    return;
                }
            }
        }

        public static void appa(List<DemandEntityHandle> list) {
            if (ConstantInfo.responseSuccessRoundByYLH == 2) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    if (TextUtils.equals(list.get(size).getDemandClassType(), "guangdiantong")) {
                        appa.appa.appf.appd.appe(appk.f46851appa, "销毁缓存中优量汇首次请求，未得到曝光且不支持缓存的实例" + list.get(size).getDemandProcesserKey());
                        list.get(size).onDestroy();
                        list.remove(size);
                    }
                }
            }
        }
    }
}
