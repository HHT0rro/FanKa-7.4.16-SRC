package com.hailiang.advlib.core;

import android.content.pm.PackageInfo;
import android.os.Bundle;
import androidx.annotation.Keep;
import java.util.List;

@Keep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface _factory extends Runnable {
    void appListFromClientNotice();

    IMultiAdRequest createNativeMultiAdRequest();

    void notifyMsg(int i10, Bundle bundle);

    @Override // java.lang.Runnable
    void run();

    void setAppList(List<PackageInfo> list);

    void setImageAutoDownload(boolean z10);

    void terminate();

    void useDebugServer(int i10);

    void useDebugServer(boolean z10);

    void whenPermDialogReturns(int i10, String[] strArr, int[] iArr);
}
