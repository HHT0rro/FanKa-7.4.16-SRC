package com.huawei.hwwidgetsupport.api.platforms.tv;

import androidx.annotation.NonNull;
import com.huawei.hwwidgetsupport.b;
import com.huawei.hwwidgetsupport.c;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class TvWidgetService extends c {
    @Override // com.huawei.hwwidgetsupport.c
    @NonNull
    public String a(@NonNull String str) {
        return b.c(str);
    }

    @Override // com.huawei.hwwidgetsupport.c
    @NonNull
    public Class<?> b() {
        return TvViewPager.class;
    }
}
