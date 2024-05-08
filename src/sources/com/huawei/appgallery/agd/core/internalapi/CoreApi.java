package com.huawei.appgallery.agd.core.internalapi;

import androidx.annotation.NonNull;
import com.huawei.appgallery.agd.core.api.AdSlot;
import com.huawei.appgallery.agd.core.impl.report.OpenUploadEventUtil;
import com.huawei.appgallery.agd.core.internalapi.IQueryCardData;
import com.huawei.appgallery.agd.core.internalapi.IQueryConfigList;
import com.huawei.appgallery.agd.core.internalapi.IQueryMediaParams;
import m9.h;
import s9.c;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class CoreApi {
    public static void queryCardData(@NonNull AdSlot adSlot, @NonNull IQueryCardData.Callback callback) {
        q9.a.b(adSlot, callback);
    }

    public static void queryCardDataV2(@NonNull AdSlot adSlot, int i10, @NonNull IQueryCardData.Callback callback) {
        h.d(adSlot, i10, callback);
    }

    public static void queryConfigList(String[] strArr, @NonNull IQueryConfigList.Callback callback) {
        r9.a.b(strArr, callback);
    }

    public static void queryMediaParams(String str, @NonNull IQueryMediaParams.Callback callback) {
        c.b(str, 1, callback);
    }

    public static void reportEvent(String str, @NonNull OpenEventInfo openEventInfo) {
        OpenUploadEventUtil.reportEvent(str, openEventInfo);
    }

    public static void queryMediaParams(@NonNull IQueryMediaParams.Callback callback) {
        c.b(null, 0, callback);
    }
}
