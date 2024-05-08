package com.huawei.flexiblelayout;

import androidx.collection.ArrayMap;
import com.huawei.flexiblelayout.log.Log;
import com.huawei.flexiblelayout.services.effect.FLEffect;
import com.huawei.flexiblelayout.services.effect.FLEffectService;
import java.util.Map;

/* compiled from: FLEffectServiceImpl.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class m1 implements FLEffectService {

    /* renamed from: b, reason: collision with root package name */
    private static final String f28261b = "FLEffectServiceImpl";

    /* renamed from: a, reason: collision with root package name */
    private Map<String, Class<? extends FLEffect>> f28262a = new ArrayMap();

    private m1() {
        register(m.f28227f, m.class);
        register(n.f28264e, n.class);
    }

    public static FLEffectService a() {
        return new m1();
    }

    @Override // com.huawei.flexiblelayout.services.effect.FLEffectService
    public FLEffect getEffect(String str) {
        try {
            Class<? extends FLEffect> cls = this.f28262a.get(str);
            if (cls != null) {
                return cls.newInstance();
            }
            return null;
        } catch (IllegalAccessException | InstantiationException e2) {
            Log.w(f28261b, "getEffect, e: " + e2.getMessage());
            return null;
        }
    }

    @Override // com.huawei.flexiblelayout.services.effect.FLEffectService
    public boolean isEffect(String str) {
        return this.f28262a.h().contains(str);
    }

    @Override // com.huawei.flexiblelayout.services.effect.FLEffectService
    public void register(String str, Class<? extends FLEffect> cls) {
        this.f28262a.put(str, cls);
    }
}
