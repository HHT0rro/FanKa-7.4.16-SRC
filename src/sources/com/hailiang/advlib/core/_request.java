package com.hailiang.advlib.core;

import android.os.Bundle;
import androidx.annotation.Keep;
import com.hailiang.advlib.core.ICliUtils;
import java.util.List;

@Keep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface _request {
    void InvokeADV(String str, int i10, int i11, int i12);

    void InvokeADV(String str, int i10, int i11, int i12, Bundle bundle);

    void InvokeADV(List<String> list);

    void InvokeADV(String... strArr);

    void bindAdContentListener(ICliUtils.a aVar);

    void onClickedReport();

    void onShowedReport();

    void removeAdContentListener();

    void unbindAdContentListener(ICliUtils.a aVar);
}
