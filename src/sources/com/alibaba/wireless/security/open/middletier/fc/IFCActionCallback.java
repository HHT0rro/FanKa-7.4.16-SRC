package com.alibaba.wireless.security.open.middletier.fc;

import com.alibaba.wireless.security.open.middletier.fc.FCAction;
import java.util.HashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface IFCActionCallback {
    void onAction(long j10, FCAction.FCMainAction fCMainAction, long j11, HashMap hashMap);

    void onPreAction(long j10, boolean z10);
}
