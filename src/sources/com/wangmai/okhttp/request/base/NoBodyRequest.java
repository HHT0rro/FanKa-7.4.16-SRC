package com.wangmai.okhttp.request.base;

import com.wangmai.okhttp.request.base.NoBodyRequest;
import com.wangmai.okhttp.utils.HttpUtils;
import okhttp3.Request;
import okhttp3.RequestBody;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class NoBodyRequest<T, R extends NoBodyRequest> extends Request<T, R> {
    public static final long serialVersionUID = 1200621102761691196L;

    public NoBodyRequest(String str) {
        super(str);
    }

    @Override // com.wangmai.okhttp.request.base.Request
    public RequestBody generateRequestBody() {
        return null;
    }

    public Request.Builder generateRequestBuilder(RequestBody requestBody) {
        this.url = HttpUtils.createUrlFromParams(this.baseUrl, this.params.urlParamsMap);
        return HttpUtils.appendHeaders(new Request.Builder(), this.headers);
    }
}
