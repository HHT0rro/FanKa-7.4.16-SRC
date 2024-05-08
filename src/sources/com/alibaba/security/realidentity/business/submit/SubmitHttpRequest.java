package com.alibaba.security.realidentity.business.submit;

import com.alibaba.security.realidentity.build.a;
import com.alibaba.security.realidentity.http.BaseHttpRequest;
import com.alibaba.security.realidentity.http.annotation.Api;
import com.alibaba.security.realidentity.http.annotation.Body;
import com.alibaba.security.realidentity.http.model.HttpMethod;

@Api(method = HttpMethod.POST, name = a.f3000f)
@Body
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class SubmitHttpRequest extends BaseHttpRequest {
    public SubmitHttpRequest(String str) {
        super(str);
    }
}
