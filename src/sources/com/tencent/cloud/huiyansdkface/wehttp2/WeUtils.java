package com.tencent.cloud.huiyansdkface.wehttp2;

import com.tencent.cloud.huiyansdkface.okio.ByteString;
import com.tencent.cloud.huiyansdkface.wehttp2.WeReq;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class WeUtils {
    private static <T> Class<T> a(Type type) {
        if (type instanceof ParameterizedType) {
            type = ((ParameterizedType) type).getRawType();
        } else if (!(type instanceof Class)) {
            return null;
        }
        return (Class) type;
    }

    public static <T> boolean a(WeReq.Callback<T> callback) {
        return !callback.getClass().getMethod("onSuccess", WeReq.class, Object.class).isAnnotationPresent(OnNetThread.class);
    }

    public static <T> boolean b(WeReq.Callback<T> callback) {
        return !callback.getClass().getMethod("onFailed", WeReq.class, WeReq.ErrType.class, Integer.TYPE, String.class, IOException.class).isAnnotationPresent(OnNetThread.class);
    }

    public static <T> boolean c(WeReq.Callback<T> callback) {
        try {
            return !callback.getClass().getMethod("onFinish", new Class[0]).isAnnotationPresent(OnNetThread.class);
        } catch (NoSuchMethodException unused) {
            return true;
        }
    }

    public static <T> Class<T> getClassOfReturn(WeReq.Callback<T> callback) {
        return a(getTypeOfReturn(callback));
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0047, code lost:
    
        r1 = r9.getGenericSuperclass();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x004f, code lost:
    
        if ((r1 instanceof java.lang.Class) == false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0051, code lost:
    
        r1 = ((java.lang.Class) r1).getGenericSuperclass();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static <T> java.lang.reflect.Type getTypeOfReturn(com.tencent.cloud.huiyansdkface.wehttp2.WeReq.Callback<T> r9) {
        /*
            java.lang.Class<com.tencent.cloud.huiyansdkface.wehttp2.WeReq$Callback> r0 = com.tencent.cloud.huiyansdkface.wehttp2.WeReq.Callback.class
            java.lang.Class r9 = r9.getClass()
            r1 = 0
            r2 = r9
        L8:
            java.lang.reflect.Type[] r3 = r2.getGenericInterfaces()
            r4 = 0
            if (r3 == 0) goto L47
            int r5 = r3.length
            if (r5 != 0) goto L13
            goto L47
        L13:
            int r5 = r3.length
            r6 = 0
        L15:
            if (r6 >= r5) goto L3f
            r7 = r3[r6]
            boolean r8 = r7 instanceof java.lang.Class
            if (r8 == 0) goto L26
            boolean r8 = r7.equals(r0)
            if (r8 == 0) goto L26
            java.lang.Class<java.lang.Object> r9 = java.lang.Object.class
            return r9
        L26:
            boolean r8 = r7 instanceof java.lang.reflect.ParameterizedType
            if (r8 != 0) goto L2b
            goto L3c
        L2b:
            r8 = r7
            java.lang.reflect.ParameterizedType r8 = (java.lang.reflect.ParameterizedType) r8
            java.lang.reflect.Type r8 = r8.getRawType()
            java.lang.Class r8 = (java.lang.Class) r8
            boolean r8 = r0.isAssignableFrom(r8)
            if (r8 != 0) goto L3b
            goto L3c
        L3b:
            r1 = r7
        L3c:
            int r6 = r6 + 1
            goto L15
        L3f:
            if (r1 == 0) goto L42
            goto L58
        L42:
            java.lang.Class r2 = r2.getSuperclass()
            goto L8
        L47:
            java.lang.reflect.Type r9 = r9.getGenericSuperclass()
            r1 = r9
        L4c:
            boolean r9 = r1 instanceof java.lang.Class
            if (r9 == 0) goto L58
            java.lang.Class r1 = (java.lang.Class) r1
            java.lang.reflect.Type r1 = r1.getGenericSuperclass()
            goto L4c
        L58:
            java.lang.reflect.ParameterizedType r1 = (java.lang.reflect.ParameterizedType) r1
            java.lang.reflect.Type[] r9 = r1.getActualTypeArguments()
            r9 = r9[r4]
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.cloud.huiyansdkface.wehttp2.WeUtils.getTypeOfReturn(com.tencent.cloud.huiyansdkface.wehttp2.WeReq$Callback):java.lang.reflect.Type");
    }

    public static String sha1hex2pin(String str) {
        return "sha1/" + ByteString.decodeHex(str.replaceAll("\\s+", "")).base64();
    }

    public static String sha256hex2pin(String str) {
        return "sha256/" + ByteString.decodeHex(str.replaceAll("\\s+", "")).base64();
    }
}
