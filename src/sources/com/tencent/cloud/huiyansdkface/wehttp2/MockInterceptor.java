package com.tencent.cloud.huiyansdkface.wehttp2;

import com.tencent.cloud.huiyansdkface.okhttp3.HttpUrl;
import com.tencent.cloud.huiyansdkface.okhttp3.Interceptor;
import com.tencent.cloud.huiyansdkface.okhttp3.MediaType;
import com.tencent.cloud.huiyansdkface.okhttp3.Protocol;
import com.tencent.cloud.huiyansdkface.okhttp3.Request;
import com.tencent.cloud.huiyansdkface.okhttp3.Response;
import com.tencent.cloud.huiyansdkface.okhttp3.ResponseBody;
import com.tencent.cloud.huiyansdkface.wejson.WeJson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class MockInterceptor implements Interceptor {

    /* renamed from: a, reason: collision with root package name */
    private List<Mock> f42288a = new ArrayList();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static abstract class JsonMock<T> implements Mock {
        public boolean isMock(HttpUrl httpUrl, Request request) {
            return false;
        }

        public boolean isPathMock(String str) {
            return false;
        }

        @Override // com.tencent.cloud.huiyansdkface.wehttp2.MockInterceptor.Mock
        public Response mock(Interceptor.Chain chain) {
            String mockPath;
            Request request = chain.request();
            HttpUrl url = request.url();
            boolean isMock = isMock(url, request);
            if (!isMock) {
                isMock = isPathMock(request.url().encodedPath());
            }
            if (!isMock && (mockPath = mockPath()) != null && !mockPath.equals("") && url.encodedPath().endsWith(mockPath)) {
                isMock = true;
            }
            if (!isMock) {
                return null;
            }
            Response resp = resp(request);
            if (resp != null) {
                return resp;
            }
            Response.Builder request2 = new Response.Builder().protocol(Protocol.HTTP_1_1).code(200).message("ok").request(request);
            ResponseBody respBody = respBody(request);
            if (respBody == null) {
                WeJson weJson = new WeJson();
                T respObj = respObj(request);
                respBody = ResponseBody.create(MediaType.f41436g, !(respObj instanceof String) ? weJson.toJson(respObj) : (String) respObj);
            }
            return request2.body(respBody).build();
        }

        public abstract String mockPath();

        public Response resp(Request request) {
            return null;
        }

        public ResponseBody respBody(Request request) {
            return null;
        }

        public abstract T respObj(Request request);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface Mock {
        Response mock(Interceptor.Chain chain);
    }

    public MockInterceptor addMock(Mock mock) {
        if (mock != null && !this.f42288a.contains(mock)) {
            this.f42288a.add(mock);
        }
        return this;
    }

    public MockInterceptor clear() {
        this.f42288a.clear();
        return this;
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        if (this.f42288a.size() != 0) {
            for (int size = this.f42288a.size() - 1; size >= 0; size--) {
                Response mock = this.f42288a.get(size).mock(chain);
                if (mock != null) {
                    return mock;
                }
            }
        }
        return chain.proceed(chain.request());
    }

    public MockInterceptor removeMock(Mock mock) {
        if (mock != null && this.f42288a.contains(mock)) {
            this.f42288a.remove(mock);
        }
        return this;
    }
}
