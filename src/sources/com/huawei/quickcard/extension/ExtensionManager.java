package com.huawei.quickcard.extension;

import android.os.Build;
import androidx.annotation.NonNull;
import androidx.core.util.Pair;
import com.alipay.sdk.util.i;
import com.android.ims.ImsConfig;
import com.huawei.quickcard.base.annotation.DoNotShrink;
import com.huawei.quickcard.base.log.CardLogUtils;
import com.huawei.quickcard.extension.ability.NativeAbility;
import com.huawei.quickcard.extension.global.api.IJsFunction;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@DoNotShrink
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public enum ExtensionManager {
    INSTANCE;


    /* renamed from: d, reason: collision with root package name */
    private static final String f33637d = "ExtensionManager";

    /* renamed from: c, reason: collision with root package name */
    private final Object f33641c = new Object();

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, Class<? extends NativeAbility>> f33639a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private volatile String f33640b = "";

    ExtensionManager() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    private String a(@NonNull Class<? extends IJsFunction> cls) {
        int length;
        ArrayList<Pair> arrayList = new ArrayList();
        for (Method method : cls.getDeclaredMethods()) {
            String name = method.getName();
            if (Build.VERSION.SDK_INT >= 26) {
                length = method.getParameterCount();
            } else {
                length = method.getParameterTypes().length;
            }
            arrayList.add(new Pair(name, Integer.valueOf(length)));
        }
        StringBuilder sb2 = new StringBuilder();
        for (Pair pair : arrayList) {
            sb2.append("this['");
            sb2.append((String) pair.first);
            sb2.append("']");
            sb2.append(" = function");
            sb2.append(a(((Integer) pair.second).intValue()));
            sb2.append("{ return $Export.");
            sb2.append((String) pair.first);
            sb2.append(a(((Integer) pair.second).intValue()));
            sb2.append(i.f4738d);
            sb2.append(System.lineSeparator());
        }
        return sb2.toString();
    }

    public Map<String, Class<? extends NativeAbility>> getAbilityMap() {
        return this.f33639a;
    }

    public String getJsFunctionTemplate() {
        return this.f33640b;
    }

    public void init(@NonNull Class<? extends IJsFunction> cls) {
        synchronized (this.f33641c) {
            this.f33640b = a(cls);
        }
    }

    public Class<? extends NativeAbility> pollAbility(String str) {
        return this.f33639a.get(str);
    }

    public void putAbility(String str, Class<? extends NativeAbility> cls) {
        CardLogUtils.i(f33637d, "register ability " + str);
        this.f33639a.put(str, cls);
    }

    private String a(int i10) {
        if (i10 <= 0) {
            return "()";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("(");
        for (int i11 = 0; i11 < i10; i11++) {
            sb2.append(ImsConfig.EXTRA_CHANGED_ITEM);
            sb2.append(i11);
            if (i11 != i10 - 1) {
                sb2.append(",");
            }
        }
        sb2.append(")");
        return sb2.toString();
    }
}
