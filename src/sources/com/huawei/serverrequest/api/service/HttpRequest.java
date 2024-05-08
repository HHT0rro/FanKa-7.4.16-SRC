package com.huawei.serverrequest.api.service;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface HttpRequest {
    @NonNull
    String body();

    @Nullable
    String contentType();

    @NonNull
    Map<String, String> headers();

    @NonNull
    String method();

    @NonNull
    String url();
}
