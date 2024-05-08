package com.huawei.hianalytics;

import com.huawei.hianalytics.core.storage.Event;
import com.huawei.hianalytics.framework.config.ICallback;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class b0 implements ICallback {
    @Override // com.huawei.hianalytics.framework.config.ICallback
    public boolean isNeedStorage() {
        return true;
    }

    @Override // com.huawei.hianalytics.framework.config.ICallback
    public void onResult(int i10, long j10, List<Event> list) {
    }
}
