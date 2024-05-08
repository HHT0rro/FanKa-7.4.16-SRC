package com.wangmai.restrictionbypass.hiddenapibypass;

import java.lang.invoke.MethodHandleInfo;
import java.lang.invoke.MethodType;
import java.lang.reflect.Member;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class Helper {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class Class {
        public transient int accessFlags;
        public transient int classFlags;
        public transient ClassLoader classLoader;
        public transient int classSize;
        public transient int clinitThreadId;
        public transient java.lang.Class<?> componentType;
        public transient short copiedMethodsOffset;
        public transient Object dexCache;
        public transient int dexClassDefIndex;
        public volatile transient int dexTypeIndex;
        public transient Object extData;
        public transient long iFields;
        public transient Object[] ifTable;
        public transient long methods;
        public transient String name;
        public transient int numReferenceInstanceFields;
        public transient int numReferenceStaticFields;
        public transient int objectSize;
        public transient int objectSizeAllocFastPath;
        public transient int primitiveType;
        public transient int referenceInstanceOffsets;
        public transient long sFields;
        public transient int status;
        public transient java.lang.Class<?> superClass;
        public transient short virtualMethodsOffset;
        public transient Object vtable;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class HandleInfo {
        public final Member member = null;
        public final MethodHandle handle = null;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class MethodHandle {
        public MethodHandle cachedSpreadInvoker;
        public MethodType nominalType;
        public final MethodType type = null;
        public final int handleKind = 0;
        public final long artFieldOrMethod = 0;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class MethodHandleImpl extends MethodHandle {
        public final MethodHandleInfo info = null;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class NeverCall {
        public static void a() {
        }

        public static void b() {
        }
    }
}
