package com.nirvana.tools.jsoner;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap<String, b> f37688b = new ConcurrentHashMap<>();

    /* renamed from: a, reason: collision with root package name */
    public List<Field> f37687a = new ArrayList();

    public a(Class cls) {
        while (!Object.class.equals(cls)) {
            Collections.addAll(this.f37687a, cls.getDeclaredFields());
            cls = cls.getSuperclass();
        }
        Iterator<Field> iterator2 = this.f37687a.iterator2();
        while (iterator2.hasNext()) {
            if (Modifier.isFinal(iterator2.next().getModifiers())) {
                iterator2.remove();
            }
        }
    }

    public final b a(String str) {
        return this.f37688b.get(str);
    }

    public final void a(String str, b bVar) {
        this.f37688b.put(str, bVar);
    }
}
