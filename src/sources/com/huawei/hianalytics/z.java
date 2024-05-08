package com.huawei.hianalytics;

import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hianalytics.framework.constant.FrameworkConstant;
import com.huawei.hianalytics.log.LogTag;
import com.huawei.hianalytics.process.HiAnalyticsInstance;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class z {
    public static final String cde = LogTag.get(HiAnalyticsInstance.class, new Class[0]);
    public String def;
    public String efg;
    public String fgh;
    public String ghi;
    public String hij;
    public w ijk;
    public w ikl;
    public w klm;
    public w lmn;

    public z(String str) {
    }

    public w lmn(String str) {
        if (FrameworkConstant.DataType.STRING_OPER.equals(str)) {
            return this.klm;
        }
        if (FrameworkConstant.DataType.STRING_MAINT.equals(str)) {
            return this.lmn;
        }
        if (FrameworkConstant.DataType.STRING_DIFFPRIVACY.equals(str)) {
            return this.ikl;
        }
        if (FrameworkConstant.DataType.STRING_PREINS.equals(str)) {
            return this.ijk;
        }
        HiLog.sw(cde, "HiAnalyticsInstData.getConfig(type): wrong type!");
        return null;
    }
}
