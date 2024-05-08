package com.huawei.quickcard.framework;

import androidx.annotation.NonNull;
import com.huawei.quickcard.IFullScreenHelper;
import com.huawei.quickcard.base.annotation.DoNotShrink;
import com.huawei.quickcard.base.log.CardLogUtils;
import com.huawei.quickcard.framework.ui.Component;
import java.util.HashMap;
import java.util.Map;

@DoNotShrink
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class FullScreenRegistry {

    /* renamed from: a, reason: collision with root package name */
    private static final String f33733a = "FullScreenRegistry";

    /* renamed from: b, reason: collision with root package name */
    private static final Map<String, Class<? extends IFullScreenHelper>> f33734b = new HashMap();

    public static void clearAll() {
        f33734b.clear();
    }

    public static IFullScreenHelper get(@NonNull Component component) {
        return getFullScreenHelper(component.getName());
    }

    public static IFullScreenHelper getFullScreenHelper(String str) {
        Class<? extends IFullScreenHelper> cls = f33734b.get(str);
        if (cls == null) {
            return null;
        }
        try {
            return cls.newInstance();
        } catch (IllegalAccessException | InstantiationException unused) {
            CardLogUtils.e("get fullScreenHelper instance failed");
            return null;
        }
    }

    public static void register(@NonNull Component component, Class<? extends IFullScreenHelper> cls) {
        registerFullScreenHelper(component.getName(), cls);
    }

    public static void registerFullScreenHelper(String str, Class<? extends IFullScreenHelper> cls) {
        f33734b.put(str, cls);
    }

    public static void unRegister(@NonNull Component component) {
        unRegisterFullScreenHelper(component.getName());
    }

    public static void unRegisterFullScreenHelper(String str) {
        f33734b.remove(str);
    }

    @Deprecated
    public static void register(@NonNull Component component, IFullScreenHelper iFullScreenHelper) {
        registerFullScreenHelper(component.getName(), iFullScreenHelper);
    }

    @Deprecated
    public static void registerFullScreenHelper(String str, IFullScreenHelper iFullScreenHelper) {
        registerFullScreenHelper(str, (Class<? extends IFullScreenHelper>) iFullScreenHelper.getClass());
    }
}
