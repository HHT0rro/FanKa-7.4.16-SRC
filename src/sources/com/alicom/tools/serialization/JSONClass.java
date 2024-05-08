package com.alicom.tools.serialization;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
class JSONClass {
    private ConcurrentHashMap<String, JSONField> mJsonFields = new ConcurrentHashMap<>();
    private List<Field> mFields = new ArrayList();

    public JSONClass(Class cls) {
        while (!Object.class.equals(cls)) {
            Collections.addAll(this.mFields, cls.getDeclaredFields());
            cls = cls.getSuperclass();
        }
        Iterator<Field> iterator2 = this.mFields.iterator2();
        while (iterator2.hasNext()) {
            if (Modifier.isFinal(iterator2.next().getModifiers())) {
                iterator2.remove();
            }
        }
    }

    public List<Field> getFields() {
        return this.mFields;
    }

    public JSONField getJsonField(String str) {
        return this.mJsonFields.get(str);
    }

    public void putJsonField(String str, JSONField jSONField) {
        this.mJsonFields.put(str, jSONField);
    }
}
