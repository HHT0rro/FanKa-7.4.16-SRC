package com.huawei.flexiblelayout.css.adapter.value.integrate;

import android.util.ArrayMap;
import com.huawei.flexiblelayout.css.adapter.CSSPropertyName;
import com.huawei.flexiblelayout.css.adapter.value.wrapper.CSSValueWrapper;
import com.huawei.flexiblelayout.css.annotation.ValueIntegrate;
import com.huawei.flexiblelayout.log.Log;
import java.lang.reflect.Field;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class CSSValueIntegrator {
    private static final String TAG = "CSSValueIntegrator";
    private static volatile CSSValueIntegrator mInstance;
    public Map<String, CSSValueWrapper> mValueWrapperMap = new ArrayMap();

    private CSSValueIntegrator() {
        fillValueWrapperMap();
    }

    private void fillValueWrapperMap() {
        for (Field field : CSSPropertyName.class.getFields()) {
            if (field.isAnnotationPresent(ValueIntegrate.class)) {
                try {
                    String str = (String) field.get(null);
                    ValueIntegrate valueIntegrate = (ValueIntegrate) field.getAnnotation(ValueIntegrate.class);
                    CSSValueWrapper newInstance = valueIntegrate.valueWrapper().newInstance();
                    newInstance.setPropertyTag(valueIntegrate.propertyTag());
                    newInstance.setValueClass(valueIntegrate.valueClass());
                    newInstance.setMethodName(valueIntegrate.methodName());
                    this.mValueWrapperMap.put(str, newInstance);
                } catch (IllegalAccessException e2) {
                    Log.w(TAG, "fillValueWrapperMap IllegalAccessException, e: " + e2.getMessage());
                } catch (InstantiationException e10) {
                    Log.w(TAG, "fillValueWrapperMap InstantiationException, e: " + e10.getMessage());
                }
            }
        }
    }

    public static synchronized CSSValueIntegrator getInstance() {
        CSSValueIntegrator cSSValueIntegrator;
        synchronized (CSSValueIntegrator.class) {
            if (mInstance == null) {
                mInstance = new CSSValueIntegrator();
            }
            cSSValueIntegrator = mInstance;
        }
        return cSSValueIntegrator;
    }

    public CSSValueWrapper getCSSValueWrapper(String str) {
        return this.mValueWrapperMap.get(str);
    }
}
