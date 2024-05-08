package com.huawei.hianalytics;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class n {
    public abstract int lmn();

    public final String lmn(Context context) {
        e eVar = c.klm().lmn;
        if (TextUtils.isEmpty(eVar.ijk)) {
            eVar.ijk = l.hij(context);
        }
        return eVar.ijk;
    }
}
