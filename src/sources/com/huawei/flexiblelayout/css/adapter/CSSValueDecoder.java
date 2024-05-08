package com.huawei.flexiblelayout.css.adapter;

import android.util.ArrayMap;
import com.huawei.flexiblelayout.css.adapter.type.CSSValue;
import com.huawei.flexiblelayout.css.adapter.type.factory.CSSValueFactory;
import com.huawei.flexiblelayout.css.annotation.ValueFactory;
import com.huawei.flexiblelayout.log.Log;
import java.lang.reflect.Field;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class CSSValueDecoder {
    private static final String TAG = "CSSValueDecoder";
    private static CSSValueDecoder instance = new CSSValueDecoder();
    private Map<String, CSSValueFactory> valueFactoryMap = new ArrayMap();

    private CSSValueDecoder() {
        fillValueFactoryMap();
    }

    private void fillValueFactoryMap() {
        for (Field field : CSSPropertyName.class.getFields()) {
            if (field.isAnnotationPresent(ValueFactory.class)) {
                try {
                    this.valueFactoryMap.put((String) field.get(null), ((ValueFactory) field.getAnnotation(ValueFactory.class)).value().newInstance());
                } catch (IllegalAccessException e2) {
                    Log.e(TAG, "fillValueFactoryMap IllegalAccessException, e: " + e2.getMessage());
                } catch (InstantiationException e10) {
                    Log.e(TAG, "fillValueFactoryMap InstantiationException, e: " + e10.getMessage());
                }
            }
        }
    }

    public static CSSValueDecoder getInstance() {
        return instance;
    }

    public CSSValue decode(String str, String str2) {
        CSSValueFactory cSSValueFactory = this.valueFactoryMap.get(str);
        if (cSSValueFactory != null) {
            return cSSValueFactory.create(str2);
        }
        return null;
    }
}
