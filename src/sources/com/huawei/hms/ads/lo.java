package com.huawei.hms.ads;

import android.content.Context;
import android.view.View;
import com.huawei.openalliance.ad.beans.parameter.AdSlotParam;
import com.huawei.openalliance.ad.inter.data.AdContentData;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface lo extends hp, hy {
    Integer Code(AdContentData adContentData);

    void Code(int i10);

    void Code(int i10, int i11, String str, boolean z10, Integer num);

    void Code(int i10, boolean z10);

    void Code(View view);

    void Code(lq lqVar, Integer num);

    void Code(mb mbVar);

    void Code(AdContentData adContentData, int i10);

    void I(int i10);

    lq V(int i10);

    void V();

    AdSlotParam getAdSlotParam();

    int getAdType();

    int getAudioFocusType();

    Context getContext();
}
