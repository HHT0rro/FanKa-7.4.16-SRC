package com.huawei.flrequest.api;

import android.content.Context;
import com.huawei.flrequest.impl.bean.RequestBean;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class FLListRequest extends RequestBean {
    public FLListRequest(Context context) throws FLRequestException {
        super(context);
    }

    public abstract String getDataId();

    public abstract int getPageNum();

    public abstract String getReferrer();
}
