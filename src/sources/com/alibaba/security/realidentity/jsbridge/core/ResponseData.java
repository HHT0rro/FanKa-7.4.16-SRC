package com.alibaba.security.realidentity.jsbridge.core;

import com.alibaba.security.common.utils.JsonUtils;
import com.alibaba.security.realidentity.build.bf;
import java.io.Serializable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ResponseData implements Serializable {
    public String result;
    public int which = 0;

    public ResponseData() {
    }

    public void fail() {
        this.which = 0;
    }

    public void setResult(bf bfVar) {
        if (bfVar != null) {
            this.result = bfVar.a();
        }
    }

    public void success() {
        this.which = 1;
    }

    public String toJsonString() {
        return JsonUtils.toJSON(this);
    }

    public ResponseData(bf bfVar) {
        setResult(bfVar);
    }
}
