package com.bytedance.pangle.dex;

import com.bytedance.pangle.d.c;
import com.bytedance.pangle.e.b;
import com.bytedance.pangle.e.g;
import com.bytedance.pangle.util.FieldUtils;
import com.huawei.openalliance.ad.constant.u;
import dalvik.system.DexFile;
import io.flutter.plugins.imagepicker.ImagePickerCache;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile int f10691a;

    /* renamed from: b, reason: collision with root package name */
    private static volatile Constructor<?> f10692b;

    public static void a(ClassLoader classLoader, String str, int i10) {
        Object obj = FieldUtils.getField(classLoader.getClass(), ImagePickerCache.MAP_KEY_PATH_LIST).get(classLoader);
        ArrayList arrayList = new ArrayList();
        String[] split = g.a(str, i10).split(u.bD);
        String c4 = c.c(str, i10);
        for (String str2 : split) {
            Object native_load_direct_dex = DirectDex.native_load_direct_dex(str2);
            if (native_load_direct_dex == null) {
                native_load_direct_dex = DexFile.loadDex(str2, c4 + File.separator + b.a(str2), 0);
            }
            arrayList.add(a(new File(str2), native_load_direct_dex));
        }
        Object[] array = arrayList.toArray();
        Field field = FieldUtils.getField(obj.getClass(), "dexElements");
        Object[] objArr = (Object[]) field.get(obj);
        Object[] objArr2 = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), objArr.length + array.length);
        System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
        System.arraycopy(array, 0, objArr2, objArr.length, array.length);
        field.set(obj, objArr2);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0051 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0037 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0018 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.Object a(java.io.File r11, java.lang.Object r12) {
        /*
            int r0 = com.bytedance.pangle.dex.a.f10691a
            java.lang.reflect.Constructor<?> r1 = com.bytedance.pangle.dex.a.f10692b
            r2 = 0
            if (r1 != 0) goto Le
            java.lang.String r3 = "dalvik.system.DexPathList$Element"
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch: java.lang.Exception -> Le
            goto Lf
        Le:
            r3 = r2
        Lf:
            r4 = 8
            r5 = 4
            r6 = 0
            r7 = 3
            r8 = 2
            r9 = 1
            if (r1 != 0) goto L35
            java.lang.Class[] r1 = new java.lang.Class[r5]     // Catch: java.lang.Exception -> L34
            java.lang.Class<java.io.File> r10 = java.io.File.class
            r1[r6] = r10     // Catch: java.lang.Exception -> L34
            java.lang.Class<java.lang.Boolean> r10 = java.lang.Boolean.TYPE     // Catch: java.lang.Exception -> L34
            r1[r9] = r10     // Catch: java.lang.Exception -> L34
            java.lang.Class<java.io.File> r10 = java.io.File.class
            r1[r8] = r10     // Catch: java.lang.Exception -> L34
            java.lang.Class<dalvik.system.DexFile> r10 = dalvik.system.DexFile.class
            r1[r7] = r10     // Catch: java.lang.Exception -> L34
            java.lang.reflect.Constructor r1 = r3.getConstructor(r1)     // Catch: java.lang.Exception -> L34
            r1.setAccessible(r9)     // Catch: java.lang.Exception -> L34
            r0 = 8
            goto L35
        L34:
            r1 = r2
        L35:
            if (r1 != 0) goto L4f
            java.lang.Class[] r1 = new java.lang.Class[r7]     // Catch: java.lang.Exception -> L4e
            java.lang.Class<java.io.File> r10 = java.io.File.class
            r1[r6] = r10     // Catch: java.lang.Exception -> L4e
            java.lang.Class<java.util.zip.ZipFile> r10 = java.util.zip.ZipFile.class
            r1[r9] = r10     // Catch: java.lang.Exception -> L4e
            java.lang.Class<dalvik.system.DexFile> r10 = dalvik.system.DexFile.class
            r1[r8] = r10     // Catch: java.lang.Exception -> L4e
            java.lang.reflect.Constructor r1 = r3.getConstructor(r1)     // Catch: java.lang.Exception -> L4e
            r1.setAccessible(r9)     // Catch: java.lang.Exception -> L4e
            r0 = 4
            goto L4f
        L4e:
            r1 = r2
        L4f:
            if (r1 != 0) goto L69
            java.lang.Class[] r1 = new java.lang.Class[r7]     // Catch: java.lang.Exception -> L68
            java.lang.Class<java.io.File> r10 = java.io.File.class
            r1[r6] = r10     // Catch: java.lang.Exception -> L68
            java.lang.Class<java.io.File> r10 = java.io.File.class
            r1[r9] = r10     // Catch: java.lang.Exception -> L68
            java.lang.Class<dalvik.system.DexFile> r10 = dalvik.system.DexFile.class
            r1[r8] = r10     // Catch: java.lang.Exception -> L68
            java.lang.reflect.Constructor r1 = r3.getConstructor(r1)     // Catch: java.lang.Exception -> L68
            r1.setAccessible(r9)     // Catch: java.lang.Exception -> L68
            r0 = 2
            goto L69
        L68:
            r1 = r2
        L69:
            if (r1 != 0) goto L87
            java.lang.Class[] r1 = new java.lang.Class[r5]     // Catch: java.lang.Exception -> L86
            java.lang.Class<java.io.File> r10 = java.io.File.class
            r1[r6] = r10     // Catch: java.lang.Exception -> L86
            java.lang.Class<java.lang.Boolean> r10 = java.lang.Boolean.TYPE     // Catch: java.lang.Exception -> L86
            r1[r9] = r10     // Catch: java.lang.Exception -> L86
            java.lang.Class<java.io.File> r10 = java.io.File.class
            r1[r8] = r10     // Catch: java.lang.Exception -> L86
            java.lang.Class<dalvik.system.DexFile> r10 = dalvik.system.DexFile.class
            r1[r7] = r10     // Catch: java.lang.Exception -> L86
            java.lang.reflect.Constructor r1 = r3.getConstructor(r1)     // Catch: java.lang.Exception -> L86
            r1.setAccessible(r9)     // Catch: java.lang.Exception -> L86
            r0 = 1
            goto L87
        L86:
            r1 = r2
        L87:
            com.bytedance.pangle.dex.a.f10692b = r1
            com.bytedance.pangle.dex.a.f10691a = r0
            if (r0 == r9) goto La1
            if (r0 == r8) goto L94
            if (r0 == r5) goto L94
            if (r0 == r4) goto La1
            goto Lb1
        L94:
            java.lang.Object[] r0 = new java.lang.Object[r7]
            r0[r6] = r11
            r0[r9] = r2
            r0[r8] = r12
            java.lang.Object r2 = a(r1, r0)
            goto Lb1
        La1:
            java.lang.Object[] r0 = new java.lang.Object[r5]
            r0[r6] = r11
            java.lang.Boolean r11 = java.lang.Boolean.FALSE
            r0[r9] = r11
            r0[r8] = r2
            r0[r7] = r12
            java.lang.Object r2 = a(r1, r0)
        Lb1:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.dex.a.a(java.io.File, java.lang.Object):java.lang.Object");
    }

    private static Object a(Constructor<?> constructor, Object... objArr) {
        try {
            return constructor.newInstance(objArr);
        } catch (Exception unused) {
            return null;
        }
    }
}
