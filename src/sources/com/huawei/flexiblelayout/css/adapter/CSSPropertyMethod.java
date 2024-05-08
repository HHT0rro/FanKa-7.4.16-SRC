package com.huawei.flexiblelayout.css.adapter;

import android.text.TextUtils;
import android.util.ArrayMap;
import com.huawei.flexiblelayout.css.adapter.param.MethodSignature;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class CSSPropertyMethod {
    public Map<String, MethodSignature> methods = new ArrayMap();

    public CSSPropertyMethod add(String str, MethodSignature methodSignature) {
        if (!TextUtils.isEmpty(str) && methodSignature != null) {
            this.methods.put(str, methodSignature);
        }
        return this;
    }

    public MethodSignature getSignature(String str) {
        return this.methods.get(str);
    }

    public CSSPropertyMethod inherit(CSSPropertyMethod cSSPropertyMethod) {
        this.methods.putAll(cSSPropertyMethod.methods);
        return this;
    }
}
