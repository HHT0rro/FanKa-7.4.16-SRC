package com.wangmai.ad.dex.allmodules.utils;

import com.wangmai.ad.dex.allmodules.bean.DemandEntityHandle;
import java.util.Comparator;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* compiled from: ComparatorUtils.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class appe implements Comparator<DemandEntityHandle> {
    private static final String appb = appe.class.getSimpleName();

    /* renamed from: appa, reason: collision with root package name */
    int f46824appa;

    public appe(int i10) {
        this.f46824appa = i10;
    }

    @Override // java.util.Comparator
    /* renamed from: appa, reason: merged with bridge method [inline-methods] */
    public int compare(DemandEntityHandle demandEntityHandle, DemandEntityHandle demandEntityHandle2) {
        int cacheNum;
        int cacheNum2;
        int cacheNum3;
        int cacheNum4;
        if (demandEntityHandle2.getSortType() == 1 || demandEntityHandle.getSortType() == 1) {
            return demandEntityHandle2.getSortType() == 1 ? -1 : 1;
        }
        if (demandEntityHandle2.getClientBidPrice() != demandEntityHandle.getClientBidPrice()) {
            cacheNum = demandEntityHandle2.getClientBidPrice();
            cacheNum2 = demandEntityHandle.getClientBidPrice();
        } else {
            if (demandEntityHandle2.getRequestIndex() != demandEntityHandle.getRequestIndex()) {
                cacheNum3 = demandEntityHandle.getRequestIndex();
                cacheNum4 = demandEntityHandle2.getRequestIndex();
            } else {
                int i10 = this.f46824appa;
                if (i10 == 1) {
                    cacheNum3 = demandEntityHandle.getCacheNum();
                    cacheNum4 = demandEntityHandle2.getCacheNum();
                } else {
                    if (i10 != 2) {
                        appa.appa.appf.appd.appe(appb, "未知排序方式：" + this.f46824appa);
                        return 0;
                    }
                    cacheNum = demandEntityHandle2.getCacheNum();
                    cacheNum2 = demandEntityHandle.getCacheNum();
                }
            }
            return cacheNum3 - cacheNum4;
        }
        return cacheNum - cacheNum2;
    }
}
