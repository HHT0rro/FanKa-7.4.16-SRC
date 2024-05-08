package com.huawei.quickcard;

import androidx.annotation.Nullable;
import com.huawei.quickcard.base.log.CardLogUtils;
import com.huawei.quickcard.extension.ExtensionManager;
import com.huawei.quickcard.extension.ability.NativeAbility;
import com.huawei.quickcard.extension.global.api.IGlobalFunction;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class q1 {

    /* renamed from: a, reason: collision with root package name */
    private static final String f34189a = "RequireModuleImpl";

    public static Object a(@Nullable String str, IGlobalFunction iGlobalFunction, Map<String, NativeAbility> map) {
        NativeAbility nativeAbility = map != null ? map.get(str) : null;
        if (nativeAbility == null) {
            nativeAbility = a(str, iGlobalFunction);
        }
        if (nativeAbility == null) {
            return null;
        }
        if (map != null) {
            map.put(str, nativeAbility);
        }
        return nativeAbility;
    }

    @Nullable
    private static NativeAbility a(@Nullable String str, IGlobalFunction iGlobalFunction) {
        Class<? extends NativeAbility> pollAbility = ExtensionManager.INSTANCE.pollAbility(str);
        if (pollAbility == null) {
            return null;
        }
        try {
            return pollAbility.getConstructor(IGlobalFunction.class).newInstance(iGlobalFunction);
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException unused) {
            CardLogUtils.e(f34189a, "can not create module instance: " + str);
            return null;
        }
    }
}
