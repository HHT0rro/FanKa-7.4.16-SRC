package com.cupidapp.live.base.fragment;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: CloseAllDialogHelper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f11807a = new b();

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final ArrayList<d> f11808b = new ArrayList<>();

    public final void a(@NotNull d listener) {
        s.i(listener, "listener");
        ArrayList<d> arrayList = f11808b;
        if (arrayList.contains(listener)) {
            return;
        }
        arrayList.add(listener);
    }

    public final void b() {
        Iterator<d> iterator2 = f11808b.iterator2();
        s.h(iterator2, "mICloseDialogListenerList.iterator()");
        while (iterator2.hasNext()) {
            iterator2.next().L();
        }
    }

    public final boolean c() {
        return !f11808b.isEmpty();
    }

    public final void d(@NotNull d listener) {
        s.i(listener, "listener");
        Iterator<d> iterator2 = f11808b.iterator2();
        s.h(iterator2, "mICloseDialogListenerList.iterator()");
        while (iterator2.hasNext()) {
            d next = iterator2.next();
            s.h(next, "iterator.next()");
            if (s.d(next, listener)) {
                iterator2.remove();
                return;
            }
        }
    }
}
