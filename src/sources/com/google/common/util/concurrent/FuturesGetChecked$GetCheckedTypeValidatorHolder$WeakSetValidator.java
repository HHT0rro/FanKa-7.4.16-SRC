package com.google.common.util.concurrent;

import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
enum FuturesGetChecked$GetCheckedTypeValidatorHolder$WeakSetValidator {
    INSTANCE;

    private static final Set<WeakReference<Class<? extends Exception>>> validClasses = new CopyOnWriteArraySet();

    public void validateClass(Class<? extends Exception> cls) {
        Iterator<WeakReference<Class<? extends Exception>>> iterator2 = validClasses.iterator2();
        while (iterator2.hasNext()) {
            if (cls.equals(iterator2.next().get())) {
                return;
            }
        }
        j.a(cls);
        Set<WeakReference<Class<? extends Exception>>> set = validClasses;
        if (set.size() > 1000) {
            set.clear();
        }
        set.add(new WeakReference<>(cls));
    }
}
