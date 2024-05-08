package com.alibaba.security.realidentity.business.start;

import com.alibaba.security.realidentity.build.a;
import com.alibaba.security.realidentity.http.BaseHttpRequest;
import com.alibaba.security.realidentity.http.annotation.Api;
import com.alibaba.security.realidentity.http.annotation.Body;
import com.alibaba.security.realidentity.http.model.HttpMethod;

@Api(method = HttpMethod.POST, name = a.f2998d)
@Body
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class StartHttpRequest extends BaseHttpRequest {
    public StartHttpRequest(String str) {
        super(str);
    }
}
