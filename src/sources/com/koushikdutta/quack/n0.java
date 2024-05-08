package com.koushikdutta.quack;

/* compiled from: QuackReadonlyObject.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final /* synthetic */ class n0 {
    public static boolean a(QuackReadonlyObject quackReadonlyObject, int i10, Object obj) {
        return quackReadonlyObject.set(Integer.valueOf(i10), obj);
    }

    public static boolean b(QuackReadonlyObject quackReadonlyObject, Object obj, Object obj2) {
        throw new UnsupportedOperationException("can not set property on a JavaObject");
    }

    public static boolean c(QuackReadonlyObject quackReadonlyObject, String str, Object obj) {
        return quackReadonlyObject.set((Object) str, obj);
    }
}
