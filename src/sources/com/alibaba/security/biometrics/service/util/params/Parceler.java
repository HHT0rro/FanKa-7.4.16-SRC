package com.alibaba.security.biometrics.service.util.params;

import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.security.common.log.RPLogging;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class Parceler<T> {
    private static final String TAG = "Parceler";
    private Class<T> cls;
    private T object;
    private Bundle bundle = new Bundle();
    private BundleConverter normalBundleConverter = new BundleConverter();
    private Map<String, Parceler<T>.BundleSerializerBean> fieldBundleKeyMap = new HashMap();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class BundleSerializerBean {
        public BundleConverter bundleConverter;
        public Field field;

        public BundleSerializerBean(Field field, BundleKey bundleKey) {
            this.field = field;
            if (bundleKey != null) {
                Class<? extends BundleConverter> converter = bundleKey.converter();
                if (TextUtils.equals(converter.getSimpleName(), BundleConverter.class.getSimpleName())) {
                    this.bundleConverter = Parceler.this.normalBundleConverter;
                }
                if (TextUtils.equals(converter.getSimpleName(), JsonBundleConverter.class.getSimpleName())) {
                    this.bundleConverter = converter.newInstance();
                }
            } else {
                this.bundleConverter = Parceler.this.normalBundleConverter;
            }
            this.bundleConverter.setType(field.getType());
        }
    }

    private Field[] getAllFields(Class cls) {
        ArrayList arrayList = new ArrayList();
        while (cls != null) {
            arrayList.addAll(new ArrayList(Arrays.asList(cls.getDeclaredFields())));
            cls = cls.getSuperclass();
        }
        Field[] fieldArr = new Field[arrayList.size()];
        arrayList.toArray(fieldArr);
        return fieldArr;
    }

    public Parceler<T> addAll(Bundle bundle) {
        this.bundle = bundle;
        for (String str : bundle.keySet()) {
            put(str, bundle.get(str));
        }
        return this;
    }

    public Parceler<T> createParceler(Class<T> cls) {
        try {
            this.cls = cls;
            this.object = cls.newInstance();
            for (Field field : getAllFields(cls)) {
                field.setAccessible(true);
                BundleKey bundleKey = (BundleKey) field.getAnnotation(BundleKey.class);
                this.fieldBundleKeyMap.put(bundleKey == null ? field.getName() : bundleKey.key(), new BundleSerializerBean(field, bundleKey));
            }
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (InstantiationException e10) {
            e10.printStackTrace();
        }
        return this;
    }

    public Object get(String str) {
        Parceler<T>.BundleSerializerBean bundleSerializerBean;
        Map<String, Parceler<T>.BundleSerializerBean> map = this.fieldBundleKeyMap;
        if (map != null && map.containsKey(str) && (bundleSerializerBean = this.fieldBundleKeyMap.get(str)) != null) {
            T t2 = this.object;
            if (t2 == null) {
                RPLogging.e(TAG, "check your createParceler before get");
                return this;
            }
            try {
                return bundleSerializerBean.field.get(t2);
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public T getParamsObject() {
        T t2;
        Class<T> cls = this.cls;
        if (cls == null || (t2 = this.object) == null || !cls.isInstance(t2)) {
            return null;
        }
        return this.object;
    }

    public Parceler<T> put(String str, Object obj) {
        Parceler<T>.BundleSerializerBean bundleSerializerBean;
        Map<String, Parceler<T>.BundleSerializerBean> map = this.fieldBundleKeyMap;
        if (map != null && map.containsKey(str) && (bundleSerializerBean = this.fieldBundleKeyMap.get(str)) != null) {
            Object deserialize = bundleSerializerBean.bundleConverter.deserialize(obj);
            Field field = bundleSerializerBean.field;
            try {
                T t2 = this.object;
                if (t2 == null) {
                    RPLogging.e(TAG, "check your createParceler before put");
                    return this;
                }
                field.set(t2, deserialize);
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            }
        }
        return this;
    }

    public Parceler<T> setByObject(Object obj) {
        if (obj == null) {
            return this;
        }
        try {
            for (Field field : obj.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                BundleKey bundleKey = (BundleKey) field.getAnnotation(BundleKey.class);
                put(bundleKey == null ? field.getName() : bundleKey.key(), field.get(obj));
            }
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        }
        return this;
    }
}
