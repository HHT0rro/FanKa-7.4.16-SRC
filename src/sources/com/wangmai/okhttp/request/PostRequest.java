package com.wangmai.okhttp.request;

import com.wangmai.okhttp.model.HttpMethod;
import com.wangmai.okhttp.request.base.BodyRequest;
import okhttp3.Request;
import okhttp3.RequestBody;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class PostRequest<T> extends BodyRequest<T, PostRequest<T>> {
    public PostRequest(String str) {
        super(str);
    }

    @Override // com.wangmai.okhttp.request.base.Request
    public Request generateRequest(RequestBody requestBody) {
        return generateRequestBuilder(requestBody).post(requestBody).url(this.url).tag(this.tag).build();
    }

    @Override // com.wangmai.okhttp.request.base.Request
    public HttpMethod getMethod() {
        return HttpMethod.POST;
    }
}
