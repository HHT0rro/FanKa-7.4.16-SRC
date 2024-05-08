package com.huawei.flexiblelayout.card.buildin;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.huawei.flexiblelayout.FLContext;
import com.huawei.flexiblelayout.card.FLCard;
import com.huawei.flexiblelayout.common.c;
import com.huawei.flexiblelayout.data.FLCardData;
import com.huawei.flexiblelayout.data.FLDataGroup;
import com.huawei.flexiblelayout.services.exposure.NonExposureTarget;

@NonExposureTarget
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class FLDivider extends FLCard<FLCardData> {

    /* renamed from: g, reason: collision with root package name */
    public static final String f27816g = "divider";

    @Override // com.huawei.flexiblelayout.card.FLCard
    public View build(FLContext fLContext, ViewGroup viewGroup) {
        Context context = fLContext.getContext();
        View view = new View(fLContext.getContext());
        view.setLayoutParams(new ViewGroup.MarginLayoutParams(-1, c.a(context, 1.0f)));
        view.setBackgroundColor(-16777216);
        return view;
    }

    @Override // com.huawei.flexiblelayout.card.FLCard
    public void setData(FLContext fLContext, FLDataGroup fLDataGroup, FLCardData fLCardData) {
    }
}
