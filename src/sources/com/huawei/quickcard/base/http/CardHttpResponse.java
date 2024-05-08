package com.huawei.quickcard.base.http;

import androidx.annotation.NonNull;
import com.huawei.quickcard.base.annotation.DoNotShrink;
import java.io.IOException;
import java.util.Map;

@DoNotShrink
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface CardHttpResponse {
    int getCode();

    Map<String, Object> getHeaders();

    String getMessage();

    @NonNull
    String getResponse() throws IOException;

    boolean isSuccessful();
}
