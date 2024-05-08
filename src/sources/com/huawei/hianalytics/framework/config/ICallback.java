package com.huawei.hianalytics.framework.config;

import com.huawei.hianalytics.core.storage.Event;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface ICallback {
    boolean isNeedStorage();

    void onResult(int i10, long j10, List<Event> list);
}
