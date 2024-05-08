package com.tencent.cloud.huiyansdkface.wehttp2;

import com.tencent.cloud.huiyansdkface.okhttp3.Call;
import com.tencent.cloud.huiyansdkface.okhttp3.HttpUrl;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class SimpleReq extends BaseReq<SimpleReq> {
    public SimpleReq(WeOkHttp weOkHttp, String str, String str2) {
        super(weOkHttp, str, str2);
    }

    @Override // com.tencent.cloud.huiyansdkface.wehttp2.BaseReq
    public Call c() {
        HttpUrl build = b().build();
        this.f42178e.url(build).method(this.f42174a, null).tag(LogTag.class, new LogTag(this.f42177d.config().iLogTag().tag(build, this.f42178e.tag())));
        return this.f42177d.client().newCall(this.f42178e.build());
    }
}
