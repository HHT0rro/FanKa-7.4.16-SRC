package com.huawei.flrequest.api;

import androidx.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Deprecated
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface FLCardResponse {
    @Nullable
    JSONArray getCards();

    @Nullable
    JSONObject getRedirects();
}
