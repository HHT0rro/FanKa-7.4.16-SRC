package com.huawei.flexiblelayout.css.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class RenderAdapterRegister {
    private static Map<Class<? extends View>, RenderAdapterFactory> factories;

    static {
        HashMap hashMap = new HashMap();
        factories = hashMap;
        hashMap.put(ViewGroup.class, ViewAdapter.FACTORY);
        factories.put(TextView.class, TextViewAdapter.FACTORY);
        factories.put(ImageView.class, ImageViewAdapter.FACTORY);
    }

    public static RenderAdapterFactory get(Class cls) {
        while (cls != View.class) {
            RenderAdapterFactory renderAdapterFactory = factories.get(cls);
            if (renderAdapterFactory != null) {
                return renderAdapterFactory;
            }
            cls = cls.getSuperclass();
        }
        return ViewAdapter.FACTORY;
    }

    public static void register(Class<? extends View> cls, RenderAdapterFactory renderAdapterFactory) {
        factories.put(cls, renderAdapterFactory);
    }
}
