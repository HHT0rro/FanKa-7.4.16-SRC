package com.alibaba.security.realidentity.business.dynamic;

import com.alibaba.security.realidentity.build.a;
import com.alibaba.security.realidentity.http.BaseHttpRequest;
import com.alibaba.security.realidentity.http.annotation.Api;
import com.alibaba.security.realidentity.http.annotation.Body;
import com.alibaba.security.realidentity.http.model.HttpMethod;
import java.util.List;

@Api(method = HttpMethod.POST, name = a.f2997c)
@Body
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class DynamicHttpRequest extends BaseHttpRequest {
    private List<String> keys;

    public DynamicHttpRequest(String str) {
        super(str);
    }

    public List<String> getKeys() {
        return this.keys;
    }

    public void setKeys(List<String> list) {
        this.keys = list;
    }
}
