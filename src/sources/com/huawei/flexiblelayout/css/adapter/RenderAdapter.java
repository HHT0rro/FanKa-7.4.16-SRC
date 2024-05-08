package com.huawei.flexiblelayout.css.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.huawei.flexiblelayout.C0862r;
import com.huawei.flexiblelayout.FLEngine;
import com.huawei.flexiblelayout.css.CSSRule;
import com.huawei.flexiblelayout.css.action.CSSAction;
import com.huawei.flexiblelayout.css.adapter.param.MethodSignature;
import com.huawei.flexiblelayout.css.adapter.type.CSSValue;
import com.huawei.flexiblelayout.log.Log;
import com.huawei.flexiblelayout.services.effect.FLEffect;
import com.huawei.flexiblelayout.services.effect.FLEffectService;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class RenderAdapter {
    private static final String TAG = "RenderAdapter";

    private static CSSAction getCSSAction(String str, View view) {
        CSSAction a10 = com.huawei.flexiblelayout.css.action.a.b().a(str);
        if (a10 == null || !a10.answerActionSelf(view)) {
            return null;
        }
        return a10;
    }

    private static FLEffect getEffect(Context context, String str) {
        return ((FLEffectService) FLEngine.getInstance(context).getService(FLEffectService.class)).getEffect(str);
    }

    public static Method getMethod(Class<?> cls, String str, Class<?>... clsArr) {
        if (cls != null && !TextUtils.isEmpty(str)) {
            try {
                return cls.getMethod(str, clsArr);
            } catch (NoSuchMethodException e2) {
                Log.e(TAG, "Not such method:" + str + e2.getMessage());
            }
        }
        return null;
    }

    public abstract MethodSignature getMethod(String str);

    public List<FLEffect> render(View view, CSSRule cSSRule) {
        ArrayList arrayList = new ArrayList();
        for (String str : cSSRule.getPropertyNames()) {
            CSSValue propertyValue = cSSRule.getPropertyValue(str);
            if (propertyValue != null) {
                FLEffect effect = getEffect(view.getContext(), str);
                if (effect != null) {
                    if (propertyValue instanceof C0862r) {
                        effect.apply(view, ((C0862r) propertyValue).a());
                        arrayList.add(effect);
                    }
                } else {
                    CSSAction cSSAction = getCSSAction(str, view);
                    if (cSSAction != null) {
                        cSSAction.bind(view, propertyValue);
                    } else {
                        MethodSignature method = getMethod(str);
                        if (method != null) {
                            method.invoke(view, propertyValue);
                        }
                    }
                }
            }
        }
        return arrayList;
    }
}
