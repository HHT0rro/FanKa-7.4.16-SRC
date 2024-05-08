package com.huawei.flrequest.api;

import com.huawei.flrequest.impl.bean.ResponseBean;
import org.json.JSONArray;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class FLListResponse extends ResponseBean {
    public abstract String getDataId();

    public abstract JSONArray getLayoutData();

    public abstract int hasMore();
}
