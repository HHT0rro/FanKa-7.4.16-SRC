package com.wangmai.restrictionbypass.hiddenapibypass;

import com.wangmai.restrictionbypass.hiddenapibypass.Helper;
import com.wangmai.restrictionbypass.support.RequiresApi;
import dalvik.system.VMRuntime;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandleInfo;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Executable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import sun.misc.Unsafe;

@RequiresApi(28)
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class HiddenApiBypass {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String TAG = "HiddenApiBypass";
    public static final long artOffset;
    public static final long bias;
    public static final long infoOffset;
    public static final long memberOffset;
    public static final long methodsOffset;
    public static final Set<String> signaturePrefixes = new HashSet();
    public static final long size;
    public static final Unsafe unsafe;

    static {
        try {
            Unsafe unsafe2 = (Unsafe) Unsafe.class.getDeclaredMethod("getUnsafe", new Class[0]).invoke(null, new Object[0]);
            unsafe = unsafe2;
            long objectFieldOffset = unsafe2.objectFieldOffset(Helper.MethodHandle.class.getDeclaredField("artFieldOrMethod"));
            artOffset = objectFieldOffset;
            infoOffset = unsafe2.objectFieldOffset(Helper.MethodHandleImpl.class.getDeclaredField("info"));
            long objectFieldOffset2 = unsafe2.objectFieldOffset(Helper.Class.class.getDeclaredField("methods"));
            methodsOffset = objectFieldOffset2;
            memberOffset = unsafe2.objectFieldOffset(Helper.HandleInfo.class.getDeclaredField("member"));
            MethodHandle unreflect = MethodHandles.lookup().unreflect(Helper.NeverCall.class.getDeclaredMethod("a", new Class[0]));
            MethodHandle unreflect2 = MethodHandles.lookup().unreflect(Helper.NeverCall.class.getDeclaredMethod("b", new Class[0]));
            long j10 = unsafe2.getLong(unreflect, objectFieldOffset);
            long j11 = unsafe2.getLong(unreflect2, objectFieldOffset);
            long j12 = unsafe2.getLong(Helper.NeverCall.class, objectFieldOffset2);
            long j13 = j11 - j10;
            size = j13;
            bias = (j10 - j12) - j13;
        } catch (ReflectiveOperationException e2) {
            throw new ExceptionInInitializerError(e2);
        }
    }

    public static boolean addHiddenApiExemptions(String... strArr) {
        Set<String> set = signaturePrefixes;
        set.addAll(Arrays.asList(strArr));
        String[] strArr2 = new String[set.size()];
        set.toArray(strArr2);
        return setHiddenApiExemptions(strArr2);
    }

    public static boolean clearHiddenApiExemptions() {
        signaturePrefixes.clear();
        return setHiddenApiExemptions(new String[0]);
    }

    public static List<Executable> getDeclaredMethods(Class<?> cls) {
        ArrayList arrayList = new ArrayList();
        if (!cls.isPrimitive() && !cls.isArray()) {
            try {
                MethodHandle unreflect = MethodHandles.lookup().unreflect(Helper.NeverCall.class.getDeclaredMethod("a", new Class[0]));
                Unsafe unsafe2 = unsafe;
                long j10 = unsafe2.getLong(cls, methodsOffset);
                int i10 = unsafe2.getInt(j10);
                for (int i11 = 0; i11 < i10; i11++) {
                    long j11 = (i11 * size) + j10 + bias;
                    Unsafe unsafe3 = unsafe;
                    unsafe3.putLong(unreflect, artOffset, j11);
                    unsafe3.putObject(unreflect, infoOffset, null);
                    try {
                        MethodHandles.lookup().revealDirect(unreflect);
                    } catch (Throwable unused) {
                    }
                    Unsafe unsafe4 = unsafe;
                    arrayList.add((Executable) unsafe4.getObject((MethodHandleInfo) unsafe4.getObject(unreflect, infoOffset), memberOffset));
                }
            } catch (IllegalAccessException | NoSuchMethodException unused2) {
            }
        }
        return arrayList;
    }

    public static boolean setHiddenApiExemptions(String... strArr) {
        List<Executable> declaredMethods = getDeclaredMethods(VMRuntime.class);
        int size2 = declaredMethods.size();
        Executable executable = null;
        Executable executable2 = null;
        for (int i10 = 0; i10 < size2; i10++) {
            Executable executable3 = declaredMethods.get(i10);
            if (executable3.getName().equals("getRuntime") && executable2 == null) {
                executable2 = executable3;
            }
            if (executable3.getName().equals("setHiddenApiExemptions") && executable == null) {
                executable = executable3;
            }
            if (executable2 != null && executable != null) {
                break;
            }
        }
        if (executable2 != null && executable != null) {
            executable2.setAccessible(true);
            try {
                Object invoke = ((Method) executable2).invoke(null, new Object[0]);
                executable.setAccessible(true);
                ((Method) executable).invoke(invoke, strArr);
                return true;
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
        return false;
    }
}
