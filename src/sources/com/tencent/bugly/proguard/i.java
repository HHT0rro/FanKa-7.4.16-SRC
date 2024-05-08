package com.tencent.bugly.proguard;

import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    private ByteBuffer f40140a;

    /* renamed from: b, reason: collision with root package name */
    private String f40141b = "GBK";

    /* compiled from: BUGLY */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public byte f40142a;

        /* renamed from: b, reason: collision with root package name */
        public int f40143b;
    }

    public i() {
    }

    private boolean[] d(int i10, boolean z10) {
        if (!a(i10)) {
            if (z10) {
                throw new g("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar, this.f40140a);
        if (aVar.f40142a == 9) {
            int a10 = a(0, 0, true);
            if (a10 >= 0) {
                boolean[] zArr = new boolean[a10];
                for (int i11 = 0; i11 < a10; i11++) {
                    zArr[i11] = a((byte) 0, 0, true) != 0;
                }
                return zArr;
            }
            throw new g("size invalid: " + a10);
        }
        throw new g("type mismatch.");
    }

    private short[] e(int i10, boolean z10) {
        if (!a(i10)) {
            if (z10) {
                throw new g("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar, this.f40140a);
        if (aVar.f40142a == 9) {
            int a10 = a(0, 0, true);
            if (a10 >= 0) {
                short[] sArr = new short[a10];
                for (int i11 = 0; i11 < a10; i11++) {
                    sArr[i11] = a(sArr[0], 0, true);
                }
                return sArr;
            }
            throw new g("size invalid: " + a10);
        }
        throw new g("type mismatch.");
    }

    private int[] f(int i10, boolean z10) {
        if (!a(i10)) {
            if (z10) {
                throw new g("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar, this.f40140a);
        if (aVar.f40142a == 9) {
            int a10 = a(0, 0, true);
            if (a10 >= 0) {
                int[] iArr = new int[a10];
                for (int i11 = 0; i11 < a10; i11++) {
                    iArr[i11] = a(iArr[0], 0, true);
                }
                return iArr;
            }
            throw new g("size invalid: " + a10);
        }
        throw new g("type mismatch.");
    }

    private long[] g(int i10, boolean z10) {
        if (!a(i10)) {
            if (z10) {
                throw new g("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar, this.f40140a);
        if (aVar.f40142a == 9) {
            int a10 = a(0, 0, true);
            if (a10 >= 0) {
                long[] jArr = new long[a10];
                for (int i11 = 0; i11 < a10; i11++) {
                    jArr[i11] = a(jArr[0], 0, true);
                }
                return jArr;
            }
            throw new g("size invalid: " + a10);
        }
        throw new g("type mismatch.");
    }

    private float[] h(int i10, boolean z10) {
        if (!a(i10)) {
            if (z10) {
                throw new g("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar, this.f40140a);
        if (aVar.f40142a == 9) {
            int a10 = a(0, 0, true);
            if (a10 >= 0) {
                float[] fArr = new float[a10];
                for (int i11 = 0; i11 < a10; i11++) {
                    fArr[i11] = a(fArr[0], 0, true);
                }
                return fArr;
            }
            throw new g("size invalid: " + a10);
        }
        throw new g("type mismatch.");
    }

    private double[] i(int i10, boolean z10) {
        if (!a(i10)) {
            if (z10) {
                throw new g("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar, this.f40140a);
        if (aVar.f40142a == 9) {
            int a10 = a(0, 0, true);
            if (a10 >= 0) {
                double[] dArr = new double[a10];
                for (int i11 = 0; i11 < a10; i11++) {
                    dArr[i11] = a(dArr[0], 0, true);
                }
                return dArr;
            }
            throw new g("size invalid: " + a10);
        }
        throw new g("type mismatch.");
    }

    public final void a(byte[] bArr) {
        ByteBuffer byteBuffer = this.f40140a;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        this.f40140a = ByteBuffer.wrap(bArr);
    }

    public final String b(int i10, boolean z10) {
        if (!a(i10)) {
            if (z10) {
                throw new g("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar, this.f40140a);
        byte b4 = aVar.f40142a;
        if (b4 == 6) {
            int i11 = this.f40140a.get();
            if (i11 < 0) {
                i11 += 256;
            }
            byte[] bArr = new byte[i11];
            this.f40140a.get(bArr);
            try {
                return new String(bArr, this.f40141b);
            } catch (UnsupportedEncodingException unused) {
                return new String(bArr);
            }
        }
        if (b4 == 7) {
            int i12 = this.f40140a.getInt();
            if (i12 <= 104857600 && i12 >= 0) {
                byte[] bArr2 = new byte[i12];
                this.f40140a.get(bArr2);
                try {
                    return new String(bArr2, this.f40141b);
                } catch (UnsupportedEncodingException unused2) {
                    return new String(bArr2);
                }
            }
            throw new g("String too long: " + i12);
        }
        throw new g("type mismatch.");
    }

    public final byte[] c(int i10, boolean z10) {
        if (!a(i10)) {
            if (z10) {
                throw new g("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar, this.f40140a);
        byte b4 = aVar.f40142a;
        if (b4 == 9) {
            int a10 = a(0, 0, true);
            if (a10 >= 0) {
                byte[] bArr = new byte[a10];
                for (int i11 = 0; i11 < a10; i11++) {
                    bArr[i11] = a(bArr[0], 0, true);
                }
                return bArr;
            }
            throw new g("size invalid: " + a10);
        }
        if (b4 == 13) {
            a aVar2 = new a();
            a(aVar2, this.f40140a);
            if (aVar2.f40142a == 0) {
                int a11 = a(0, 0, true);
                if (a11 >= 0) {
                    byte[] bArr2 = new byte[a11];
                    this.f40140a.get(bArr2);
                    return bArr2;
                }
                throw new g("invalid size, tag: " + i10 + ", type: " + ((int) aVar.f40142a) + ", " + ((int) aVar2.f40142a) + ", size: " + a11);
            }
            throw new g("type mismatch, tag: " + i10 + ", type: " + ((int) aVar.f40142a) + ", " + ((int) aVar2.f40142a));
        }
        throw new g("type mismatch.");
    }

    public i(byte[] bArr) {
        this.f40140a = ByteBuffer.wrap(bArr);
    }

    private static int a(a aVar, ByteBuffer byteBuffer) {
        byte b4 = byteBuffer.get();
        aVar.f40142a = (byte) (b4 & 15);
        int i10 = (b4 & 240) >> 4;
        aVar.f40143b = i10;
        if (i10 != 15) {
            return 1;
        }
        aVar.f40143b = byteBuffer.get();
        return 2;
    }

    public i(byte[] bArr, int i10) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        this.f40140a = wrap;
        wrap.position(4);
    }

    private boolean a(int i10) {
        int i11;
        try {
            a aVar = new a();
            while (true) {
                int a10 = a(aVar, this.f40140a.duplicate());
                i11 = aVar.f40143b;
                if (i10 <= i11 || aVar.f40142a == 11) {
                    break;
                }
                ByteBuffer byteBuffer = this.f40140a;
                byteBuffer.position(byteBuffer.position() + a10);
                a(aVar.f40142a);
            }
        } catch (g | BufferUnderflowException unused) {
        }
        return i10 == i11;
    }

    private void a() {
        a aVar = new a();
        do {
            a(aVar, this.f40140a);
            a(aVar.f40142a);
        } while (aVar.f40142a != 11);
    }

    private void a(byte b4) {
        int i10 = 0;
        switch (b4) {
            case 0:
                ByteBuffer byteBuffer = this.f40140a;
                byteBuffer.position(byteBuffer.position() + 1);
                return;
            case 1:
                ByteBuffer byteBuffer2 = this.f40140a;
                byteBuffer2.position(byteBuffer2.position() + 2);
                return;
            case 2:
                ByteBuffer byteBuffer3 = this.f40140a;
                byteBuffer3.position(byteBuffer3.position() + 4);
                return;
            case 3:
                ByteBuffer byteBuffer4 = this.f40140a;
                byteBuffer4.position(byteBuffer4.position() + 8);
                return;
            case 4:
                ByteBuffer byteBuffer5 = this.f40140a;
                byteBuffer5.position(byteBuffer5.position() + 4);
                return;
            case 5:
                ByteBuffer byteBuffer6 = this.f40140a;
                byteBuffer6.position(byteBuffer6.position() + 8);
                return;
            case 6:
                int i11 = this.f40140a.get();
                if (i11 < 0) {
                    i11 += 256;
                }
                ByteBuffer byteBuffer7 = this.f40140a;
                byteBuffer7.position(byteBuffer7.position() + i11);
                return;
            case 7:
                int i12 = this.f40140a.getInt();
                ByteBuffer byteBuffer8 = this.f40140a;
                byteBuffer8.position(byteBuffer8.position() + i12);
                return;
            case 8:
                int a10 = a(0, 0, true);
                while (i10 < (a10 << 1)) {
                    a aVar = new a();
                    a(aVar, this.f40140a);
                    a(aVar.f40142a);
                    i10++;
                }
                return;
            case 9:
                int a11 = a(0, 0, true);
                while (i10 < a11) {
                    a aVar2 = new a();
                    a(aVar2, this.f40140a);
                    a(aVar2.f40142a);
                    i10++;
                }
                return;
            case 10:
                a();
                return;
            case 11:
            case 12:
                return;
            case 13:
                a aVar3 = new a();
                a(aVar3, this.f40140a);
                if (aVar3.f40142a == 0) {
                    int a12 = a(0, 0, true);
                    ByteBuffer byteBuffer9 = this.f40140a;
                    byteBuffer9.position(byteBuffer9.position() + a12);
                    return;
                } else {
                    throw new g("skipField with invalid type, type value: " + ((int) b4) + ", " + ((int) aVar3.f40142a));
                }
            default:
                throw new g("invalid type.");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> T[] b(T t2, int i10, boolean z10) {
        if (!a(i10)) {
            if (z10) {
                throw new g("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar, this.f40140a);
        if (aVar.f40142a == 9) {
            int a10 = a(0, 0, true);
            if (a10 >= 0) {
                T[] tArr = (T[]) ((Object[]) Array.newInstance(t2.getClass(), a10));
                for (int i11 = 0; i11 < a10; i11++) {
                    tArr[i11] = a((i) t2, 0, true);
                }
                return tArr;
            }
            throw new g("size invalid: " + a10);
        }
        throw new g("type mismatch.");
    }

    public final boolean a(int i10, boolean z10) {
        return a((byte) 0, i10, z10) != 0;
    }

    public final byte a(byte b4, int i10, boolean z10) {
        if (!a(i10)) {
            if (z10) {
                throw new g("require field not exist.");
            }
            return b4;
        }
        a aVar = new a();
        a(aVar, this.f40140a);
        byte b10 = aVar.f40142a;
        if (b10 == 0) {
            return this.f40140a.get();
        }
        if (b10 == 12) {
            return (byte) 0;
        }
        throw new g("type mismatch.");
    }

    public final short a(short s2, int i10, boolean z10) {
        if (!a(i10)) {
            if (z10) {
                throw new g("require field not exist.");
            }
            return s2;
        }
        a aVar = new a();
        a(aVar, this.f40140a);
        byte b4 = aVar.f40142a;
        if (b4 == 0) {
            return this.f40140a.get();
        }
        if (b4 == 1) {
            return this.f40140a.getShort();
        }
        if (b4 == 12) {
            return (short) 0;
        }
        throw new g("type mismatch.");
    }

    public final int a(int i10, int i11, boolean z10) {
        if (!a(i11)) {
            if (z10) {
                throw new g("require field not exist.");
            }
            return i10;
        }
        a aVar = new a();
        a(aVar, this.f40140a);
        byte b4 = aVar.f40142a;
        if (b4 == 0) {
            return this.f40140a.get();
        }
        if (b4 == 1) {
            return this.f40140a.getShort();
        }
        if (b4 == 2) {
            return this.f40140a.getInt();
        }
        if (b4 == 12) {
            return 0;
        }
        throw new g("type mismatch.");
    }

    public final long a(long j10, int i10, boolean z10) {
        int i11;
        if (!a(i10)) {
            if (z10) {
                throw new g("require field not exist.");
            }
            return j10;
        }
        a aVar = new a();
        a(aVar, this.f40140a);
        byte b4 = aVar.f40142a;
        if (b4 == 0) {
            i11 = this.f40140a.get();
        } else if (b4 == 1) {
            i11 = this.f40140a.getShort();
        } else {
            if (b4 != 2) {
                if (b4 == 3) {
                    return this.f40140a.getLong();
                }
                if (b4 == 12) {
                    return 0L;
                }
                throw new g("type mismatch.");
            }
            i11 = this.f40140a.getInt();
        }
        return i11;
    }

    private float a(float f10, int i10, boolean z10) {
        if (!a(i10)) {
            if (z10) {
                throw new g("require field not exist.");
            }
            return f10;
        }
        a aVar = new a();
        a(aVar, this.f40140a);
        byte b4 = aVar.f40142a;
        if (b4 == 4) {
            return this.f40140a.getFloat();
        }
        if (b4 == 12) {
            return 0.0f;
        }
        throw new g("type mismatch.");
    }

    private double a(double d10, int i10, boolean z10) {
        if (!a(i10)) {
            if (z10) {
                throw new g("require field not exist.");
            }
            return d10;
        }
        a aVar = new a();
        a(aVar, this.f40140a);
        byte b4 = aVar.f40142a;
        if (b4 == 4) {
            return this.f40140a.getFloat();
        }
        if (b4 == 5) {
            return this.f40140a.getDouble();
        }
        if (b4 == 12) {
            return ShadowDrawableWrapper.COS_45;
        }
        throw new g("type mismatch.");
    }

    public final <K, V> HashMap<K, V> a(Map<K, V> map, int i10, boolean z10) {
        return (HashMap) a(new HashMap(), map, i10, z10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <K, V> Map<K, V> a(Map<K, V> map, Map<K, V> map2, int i10, boolean z10) {
        if (map2 != null && !map2.isEmpty()) {
            Map.Entry<K, V> next = map2.entrySet().iterator2().next();
            K key = next.getKey();
            V value = next.getValue();
            if (a(i10)) {
                a aVar = new a();
                a(aVar, this.f40140a);
                if (aVar.f40142a == 8) {
                    int a10 = a(0, 0, true);
                    if (a10 < 0) {
                        throw new g("size invalid: " + a10);
                    }
                    for (int i11 = 0; i11 < a10; i11++) {
                        map.put(a((i) key, 0, true), a((i) value, 1, true));
                    }
                } else {
                    throw new g("type mismatch.");
                }
            } else if (z10) {
                throw new g("require field not exist.");
            }
            return map;
        }
        return new HashMap();
    }

    private <T> T[] a(T[] tArr, int i10, boolean z10) {
        if (tArr != null && tArr.length != 0) {
            return (T[]) b(tArr[0], i10, z10);
        }
        throw new g("unable to get type of key and value.");
    }

    public final k a(k kVar, int i10, boolean z10) {
        if (!a(i10)) {
            if (z10) {
                throw new g("require field not exist.");
            }
            return null;
        }
        try {
            k kVar2 = (k) kVar.getClass().newInstance();
            a aVar = new a();
            a(aVar, this.f40140a);
            if (aVar.f40142a == 10) {
                kVar2.a(this);
                a();
                return kVar2;
            }
            throw new g("type mismatch.");
        } catch (Exception e2) {
            throw new g(e2.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> Object a(T t2, int i10, boolean z10) {
        if (t2 instanceof Byte) {
            return Byte.valueOf(a((byte) 0, i10, z10));
        }
        if (t2 instanceof Boolean) {
            return Boolean.valueOf(a((byte) 0, i10, z10) != 0);
        }
        if (t2 instanceof Short) {
            return Short.valueOf(a((short) 0, i10, z10));
        }
        if (t2 instanceof Integer) {
            return Integer.valueOf(a(0, i10, z10));
        }
        if (t2 instanceof Long) {
            return Long.valueOf(a(0L, i10, z10));
        }
        if (t2 instanceof Float) {
            return Float.valueOf(a(0.0f, i10, z10));
        }
        if (t2 instanceof Double) {
            return Double.valueOf(a(ShadowDrawableWrapper.COS_45, i10, z10));
        }
        if (t2 instanceof String) {
            return String.valueOf(b(i10, z10));
        }
        if (t2 instanceof Map) {
            return (HashMap) a(new HashMap(), (Map) t2, i10, z10);
        }
        if (t2 instanceof List) {
            List list = (List) t2;
            if (list == null || list.isEmpty()) {
                return new ArrayList();
            }
            Object[] b4 = b(list.get(0), i10, z10);
            if (b4 == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Object obj : b4) {
                arrayList.add(obj);
            }
            return arrayList;
        }
        if (t2 instanceof k) {
            return a((k) t2, i10, z10);
        }
        if (t2.getClass().isArray()) {
            if (!(t2 instanceof byte[]) && !(t2 instanceof Byte[])) {
                if (t2 instanceof boolean[]) {
                    return d(i10, z10);
                }
                if (t2 instanceof short[]) {
                    return e(i10, z10);
                }
                if (t2 instanceof int[]) {
                    return f(i10, z10);
                }
                if (t2 instanceof long[]) {
                    return g(i10, z10);
                }
                if (t2 instanceof float[]) {
                    return h(i10, z10);
                }
                if (t2 instanceof double[]) {
                    return i(i10, z10);
                }
                return a((Object[]) t2, i10, z10);
            }
            return c(i10, z10);
        }
        throw new g("read object error: unsupport type.");
    }

    public final int a(String str) {
        this.f40141b = str;
        return 0;
    }
}
