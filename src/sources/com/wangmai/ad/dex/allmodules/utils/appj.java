package com.wangmai.ad.dex.allmodules.utils;

import com.wangmai.common.bean.SdkThirdPlatform;
import java.util.Comparator;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class6.dex
 */
/* compiled from: DemandRequestCompareUtils.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class6.dex.bak */
public class appj implements Comparator<SdkThirdPlatform> {
    @Override // java.util.Comparator
    /* renamed from: appa, reason: merged with bridge method [inline-methods] */
    public int compare(SdkThirdPlatform sdkThirdPlatform, SdkThirdPlatform sdkThirdPlatform2) {
        return (int) ((sdkThirdPlatform2.getSdkThirdAdslotConfig().getDspBidPrice() * 100.0d) - ((int) (sdkThirdPlatform.getSdkThirdAdslotConfig().getDspBidPrice() * 100.0d)));
    }
}
