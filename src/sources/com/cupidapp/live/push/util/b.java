package com.cupidapp.live.push.util;

import com.cupidapp.live.base.network.gson.GsonUtil;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKPushExtraData.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class b {
    @Nullable
    public static final PushExtraData a(@Nullable String str) {
        if (str != null) {
            return (PushExtraData) GsonUtil.f12000a.b().fromJson(str, PushExtraData.class);
        }
        return null;
    }
}
