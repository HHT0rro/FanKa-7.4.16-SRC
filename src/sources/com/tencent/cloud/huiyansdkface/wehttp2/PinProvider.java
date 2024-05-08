package com.tencent.cloud.huiyansdkface.wehttp2;

import java.util.List;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface PinProvider {
    Set<String> getPinSet(String str);

    void onPinVerifyFailed(String str, List<String> list);
}
