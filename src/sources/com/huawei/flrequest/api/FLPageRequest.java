package com.huawei.flrequest.api;

import android.content.Context;
import com.huawei.flrequest.impl.bean.RequestBean;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class FLPageRequest extends RequestBean {
    public FLPageRequest(Context context) throws FLRequestException {
        super(context);
    }

    public abstract String getPageId();

    public abstract String getReferrer();
}
