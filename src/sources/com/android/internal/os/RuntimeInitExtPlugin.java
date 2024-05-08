package com.android.internal.os;

import com.oplus.reflect.MethodParams;
import com.oplus.reflect.RefClass;
import com.oplus.reflect.RefConstructor;
import com.oplus.reflect.RefStaticMethod;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class RuntimeInitExtPlugin {
    public static Class<?> TYPE = RefClass.load(RuntimeInitExtPlugin.class, "com.android.internal.os.RuntimeInitExtImpl");
    public static RefConstructor<IRuntimeInitExt> constructor;

    @MethodParams({ClassLoader.class})
    public static RefStaticMethod<Void> preload;
}
