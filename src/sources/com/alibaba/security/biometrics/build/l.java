package com.alibaba.security.biometrics.build;

import android.app.Activity;
import android.view.KeyEvent;
import com.alibaba.security.biometrics.ALBiometricsEventListener;
import com.alibaba.security.biometrics.component.AudioSettingComponent;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsParams;
import com.alibaba.security.biometrics.theme.ALBiometricsConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: PageComponentHolder.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    private static final String f2313a = "l";

    /* renamed from: b, reason: collision with root package name */
    private static LinkedHashMap<Class<? extends j>, j> f2314b = new LinkedHashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private static List<Class<? extends j>> f2315c = new ArrayList();

    /* compiled from: PageComponentHolder.java */
    /* renamed from: com.alibaba.security.biometrics.build.l$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class AnonymousClass1 implements Comparator<Class<? extends j>> {
        private static int a(Class<? extends j> cls, Class<? extends j> cls2) {
            if (cls == null || cls2 == null) {
                return 0;
            }
            m mVar = (m) cls.getAnnotation(m.class);
            m mVar2 = (m) cls2.getAnnotation(m.class);
            if (mVar == null && mVar2 == null) {
                return 0;
            }
            if (mVar != null && mVar2 == null) {
                return -1;
            }
            if (mVar == null && mVar2 != null) {
                return 1;
            }
            if (mVar.a() == mVar2.a()) {
                return 0;
            }
            return mVar.a() > mVar2.a() ? -1 : 1;
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(Class<? extends j> cls, Class<? extends j> cls2) {
            Class<? extends j> cls3 = cls;
            Class<? extends j> cls4 = cls2;
            if (cls3 == null || cls4 == null) {
                return 0;
            }
            m mVar = (m) cls3.getAnnotation(m.class);
            m mVar2 = (m) cls4.getAnnotation(m.class);
            if (mVar == null && mVar2 == null) {
                return 0;
            }
            if (mVar != null && mVar2 == null) {
                return -1;
            }
            if (mVar == null && mVar2 != null) {
                return 1;
            }
            if (mVar.a() == mVar2.a()) {
                return 0;
            }
            return mVar.a() > mVar2.a() ? -1 : 1;
        }
    }

    public static <T extends j> T a(Class<T> cls) {
        T t2 = f2314b.containsKey(cls) ? (T) f2314b.get(cls) : null;
        if (t2 != null) {
            return t2;
        }
        T t10 = (T) b(cls);
        f2314b.put(cls, t10);
        return t10;
    }

    public static void b() {
        List<Class<? extends j>> list = f2315c;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<Class<? extends j>> iterator2 = f2315c.iterator2();
        while (iterator2.hasNext()) {
            j jVar = f2314b.get(iterator2.next());
            if (jVar != null && jVar.b()) {
                return;
            }
        }
    }

    public static void c() {
        List<Class<? extends j>> list = f2315c;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<Class<? extends j>> iterator2 = f2315c.iterator2();
        while (iterator2.hasNext()) {
            j jVar = f2314b.get(iterator2.next());
            if (jVar != null && jVar.c()) {
                break;
            }
        }
        f2314b.clear();
    }

    private static void d() {
        f2314b.clear();
        f2315c.clear();
        f2314b.put(AudioSettingComponent.class, null);
        f2314b.put(i.class, null);
        f2314b.put(k.class, null);
        f2314b.put(n.class, null);
        f2314b.put(p.class, null);
        Iterator<Map.Entry<Class<? extends j>, j>> iterator2 = f2314b.entrySet().iterator2();
        while (iterator2.hasNext()) {
            f2315c.add(iterator2.next().getKey());
        }
        Collections.sort(f2315c, new AnonymousClass1());
    }

    private static void e() {
        f2314b.clear();
        f2315c.clear();
        f2314b.put(AudioSettingComponent.class, null);
        f2314b.put(i.class, null);
        f2314b.put(k.class, null);
        f2314b.put(n.class, null);
        f2314b.put(p.class, null);
        Iterator<Map.Entry<Class<? extends j>, j>> iterator2 = f2314b.entrySet().iterator2();
        while (iterator2.hasNext()) {
            f2315c.add(iterator2.next().getKey());
        }
        Collections.sort(f2315c, new AnonymousClass1());
        for (Map.Entry<Class<? extends j>, j> entry : f2314b.entrySet()) {
            Class<? extends j> key = entry.getKey();
            j value = entry.getValue();
            if (value == null) {
                value = b(key);
            }
            f2314b.put(key, value);
        }
    }

    private static void f() {
        f2314b.clear();
    }

    public static void a() {
        List<Class<? extends j>> list = f2315c;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<Class<? extends j>> iterator2 = f2315c.iterator2();
        while (iterator2.hasNext()) {
            j jVar = f2314b.get(iterator2.next());
            if (jVar != null && jVar.a()) {
                return;
            }
        }
    }

    private static <T extends j> T b(Class<? extends j> cls) {
        try {
            return (T) cls.newInstance();
        } catch (IllegalAccessException | InstantiationException unused) {
            return null;
        }
    }

    public static boolean a(int i10, KeyEvent keyEvent) {
        List<Class<? extends j>> list = f2315c;
        if (list == null || list.isEmpty()) {
            return true;
        }
        Iterator<Class<? extends j>> iterator2 = f2315c.iterator2();
        while (iterator2.hasNext()) {
            j jVar = f2314b.get(iterator2.next());
            if (jVar != null && !jVar.a(i10, keyEvent)) {
                break;
            }
        }
        return false;
    }

    public static void a(Activity activity, ALBiometricsParams aLBiometricsParams, ALBiometricsConfig aLBiometricsConfig, ALBiometricsEventListener aLBiometricsEventListener) {
        f2314b.clear();
        f2315c.clear();
        f2314b.put(AudioSettingComponent.class, null);
        f2314b.put(i.class, null);
        f2314b.put(k.class, null);
        f2314b.put(n.class, null);
        f2314b.put(p.class, null);
        Iterator<Map.Entry<Class<? extends j>, j>> iterator2 = f2314b.entrySet().iterator2();
        while (iterator2.hasNext()) {
            f2315c.add(iterator2.next().getKey());
        }
        Collections.sort(f2315c, new AnonymousClass1());
        for (Map.Entry<Class<? extends j>, j> entry : f2314b.entrySet()) {
            Class<? extends j> key = entry.getKey();
            j value = entry.getValue();
            if (value == null) {
                value = b(key);
            }
            f2314b.put(key, value);
        }
        List<Class<? extends j>> list = f2315c;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<Class<? extends j>> iterator22 = f2315c.iterator2();
        while (iterator22.hasNext()) {
            j jVar = f2314b.get(iterator22.next());
            if (jVar != null && jVar.a(activity, aLBiometricsParams, aLBiometricsConfig, aLBiometricsEventListener)) {
                return;
            }
        }
    }
}
