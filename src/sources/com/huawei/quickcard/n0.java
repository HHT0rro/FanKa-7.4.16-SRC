package com.huawei.quickcard;

import android.content.Context;
import com.huawei.quickcard.base.http.CardHttpClientManager;
import com.huawei.quickcard.base.http.CardHttpRequest;
import com.huawei.quickcard.base.http.CardHttpResponse;
import com.huawei.quickcard.base.http.impl.CardHttpRequestImpl;
import com.huawei.quickcard.cardmanager.http.ManagerHttpClient;
import com.huawei.quickcard.cardmanager.http.ManagerHttpRequest;
import com.huawei.quickcard.cardmanager.http.ManagerHttpResponse;
import java.io.IOException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class n0 implements ManagerHttpClient {
    @Override // com.huawei.quickcard.cardmanager.http.ManagerHttpClient
    public ManagerHttpResponse request(Context context, ManagerHttpRequest managerHttpRequest) throws IOException {
        CardHttpResponse request = CardHttpClientManager.get(context).request(CardHttpRequestImpl.Builder.create().uri(managerHttpRequest.getUrl()).body(managerHttpRequest.getBody()).method(CardHttpRequest.RequestMethod.POST).addHeaders(managerHttpRequest.getHeaders()).contentType(managerHttpRequest.getContentType()).build());
        ManagerHttpResponse managerHttpResponse = new ManagerHttpResponse();
        if (request != null) {
            managerHttpResponse.setCode(request.getCode());
            managerHttpResponse.setResponse(request.getResponse());
            managerHttpResponse.setMessage(request.getMessage());
            managerHttpResponse.setHeaders(request.getHeaders());
        } else {
            managerHttpResponse.setCode(15);
            managerHttpResponse.setMessage("response is empty");
        }
        return managerHttpResponse;
    }
}
