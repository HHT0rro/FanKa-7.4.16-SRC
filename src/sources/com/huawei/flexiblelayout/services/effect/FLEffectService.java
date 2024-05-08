package com.huawei.flexiblelayout.services.effect;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface FLEffectService {
    FLEffect getEffect(String str);

    boolean isEffect(String str);

    void register(String str, Class<? extends FLEffect> cls);
}
