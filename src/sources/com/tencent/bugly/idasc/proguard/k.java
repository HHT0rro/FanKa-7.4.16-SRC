package com.tencent.bugly.idasc.proguard;

import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public String f39897a = "GBK";

    /* renamed from: b, reason: collision with root package name */
    private ByteBuffer f39898b;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public byte f39899a;

        /* renamed from: b, reason: collision with root package name */
        public int f39900b;
    }

    public k() {
    }

    public k(byte[] bArr) {
        this.f39898b = ByteBuffer.wrap(bArr);
    }

    public k(byte[] bArr, byte b4) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        this.f39898b = wrap;
        wrap.position(4);
    }

    private double a(double d10, int i10, boolean z10) {
        if (!b(i10)) {
            if (z10) {
                throw new h("require field not exist.");
            }
            return d10;
        }
        a aVar = new a();
        a(aVar);
        byte b4 = aVar.f39899a;
        if (b4 == 4) {
            return this.f39898b.getFloat();
        }
        if (b4 == 5) {
            return this.f39898b.getDouble();
        }
        if (b4 == 12) {
            return ShadowDrawableWrapper.COS_45;
        }
        throw new h("type mismatch.");
    }

    private float a(float f10, int i10, boolean z10) {
        if (!b(i10)) {
            if (z10) {
                throw new h("require field not exist.");
            }
            return f10;
        }
        a aVar = new a();
        a(aVar);
        byte b4 = aVar.f39899a;
        if (b4 == 4) {
            return this.f39898b.getFloat();
        }
        if (b4 == 12) {
            return 0.0f;
        }
        throw new h("type mismatch.");
    }

    private static int a(a aVar, ByteBuffer byteBuffer) {
        byte b4 = byteBuffer.get();
        aVar.f39899a = (byte) (b4 & 15);
        int i10 = (b4 & 240) >> 4;
        aVar.f39900b = i10;
        if (i10 != 15) {
            return 1;
        }
        aVar.f39900b = byteBuffer.get();
        return 2;
    }

    private <T> List<T> a(List<T> list, int i10, boolean z10) {
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

    /* JADX WARN: Multi-variable type inference failed */
    private <K, V> Map<K, V> a(Map<K, V> map, Map<K, V> map2, int i10, boolean z10) {
        if (map2 == null || map2.isEmpty()) {
            return new HashMap();
        }
        Map.Entry<K, V> next = map2.entrySet().iterator2().next();
        K key = next.getKey();
        V value = next.getValue();
        if (b(i10)) {
            a aVar = new a();
            a(aVar);
            if (aVar.f39899a != 8) {
                throw new h("type mismatch.");
            }
            int a10 = a(0, 0, true);
            if (a10 < 0) {
                throw new h("size invalid: ".concat(String.valueOf(a10)));
            }
            for (int i11 = 0; i11 < a10; i11++) {
                map.put(a((k) key, 0, true), a((k) value, 1, true));
            }
        } else if (z10) {
            throw new h("require field not exist.");
        }
        return map;
    }

    private void a() {
        a aVar = new a();
        do {
            a(aVar);
            a(aVar.f39899a);
        } while (aVar.f39899a != 11);
    }

    private void a(byte b4) {
        int i10;
        int i11 = 0;
        switch (b4) {
            case 0:
                a(1);
                return;
            case 1:
                a(2);
                return;
            case 2:
                a(4);
                return;
            case 3:
                a(8);
                return;
            case 4:
                a(4);
                return;
            case 5:
                a(8);
                return;
            case 6:
                int i12 = this.f39898b.get();
                if (i12 < 0) {
                    i12 += 256;
                }
                a(i12);
                return;
            case 7:
                i10 = this.f39898b.getInt();
                break;
            case 8:
                int a10 = a(0, 0, true);
                while (i11 < a10 * 2) {
                    b();
                    i11++;
                }
                return;
            case 9:
                int a11 = a(0, 0, true);
                while (i11 < a11) {
                    b();
                    i11++;
                }
                return;
            case 10:
                a();
                return;
            case 11:
            case 12:
                return;
            case 13:
                a aVar = new a();
                a(aVar);
                if (aVar.f39899a != 0) {
                    throw new h("skipField with invalid type, type value: " + ((int) b4) + ", " + ((int) aVar.f39899a));
                }
                i10 = a(0, 0, true);
                break;
            default:
                throw new h("invalid type.");
        }
        a(i10);
    }

    private void a(int i10) {
        ByteBuffer byteBuffer = this.f39898b;
        byteBuffer.position(byteBuffer.position() + i10);
    }

    private void a(a aVar) {
        a(aVar, this.f39898b);
    }

    private <T> T[] a(T[] tArr, int i10, boolean z10) {
        if (tArr == null || tArr.length == 0) {
            throw new h("unable to get type of key and value.");
        }
        return (T[]) b(tArr[0], i10, z10);
    }

    private void b() {
        a aVar = new a();
        a(aVar);
        a(aVar.f39899a);
    }

    private boolean b(int i10) {
        int i11;
        try {
            a aVar = new a();
            while (true) {
                int a10 = a(aVar, this.f39898b.duplicate());
                i11 = aVar.f39900b;
                if (i10 <= i11 || aVar.f39899a == 11) {
                    break;
                }
                a(a10);
                a(aVar.f39899a);
            }
        } catch (h | BufferUnderflowException unused) {
        }
        return i10 == i11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> T[] b(T t2, int i10, boolean z10) {
        if (!b(i10)) {
            if (z10) {
                throw new h("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar);
        if (aVar.f39899a != 9) {
            throw new h("type mismatch.");
        }
        int a10 = a(0, 0, true);
        if (a10 < 0) {
            throw new h("size invalid: ".concat(String.valueOf(a10)));
        }
        T[] tArr = (T[]) ((Object[]) Array.newInstance(t2.getClass(), a10));
        for (int i11 = 0; i11 < a10; i11++) {
            tArr[i11] = a((k) t2, 0, true);
        }
        return tArr;
    }

    private boolean[] d(int i10, boolean z10) {
        if (!b(i10)) {
            if (z10) {
                throw new h("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar);
        if (aVar.f39899a != 9) {
            throw new h("type mismatch.");
        }
        int a10 = a(0, 0, true);
        if (a10 < 0) {
            throw new h("size invalid: ".concat(String.valueOf(a10)));
        }
        boolean[] zArr = new boolean[a10];
        for (int i11 = 0; i11 < a10; i11++) {
            zArr[i11] = a(0, true);
        }
        return zArr;
    }

    private short[] e(int i10, boolean z10) {
        if (!b(i10)) {
            if (z10) {
                throw new h("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar);
        if (aVar.f39899a != 9) {
            throw new h("type mismatch.");
        }
        int a10 = a(0, 0, true);
        if (a10 < 0) {
            throw new h("size invalid: ".concat(String.valueOf(a10)));
        }
        short[] sArr = new short[a10];
        for (int i11 = 0; i11 < a10; i11++) {
            sArr[i11] = a(sArr[0], 0, true);
        }
        return sArr;
    }

    private int[] f(int i10, boolean z10) {
        if (!b(i10)) {
            if (z10) {
                throw new h("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar);
        if (aVar.f39899a != 9) {
            throw new h("type mismatch.");
        }
        int a10 = a(0, 0, true);
        if (a10 < 0) {
            throw new h("size invalid: ".concat(String.valueOf(a10)));
        }
        int[] iArr = new int[a10];
        for (int i11 = 0; i11 < a10; i11++) {
            iArr[i11] = a(iArr[0], 0, true);
        }
        return iArr;
    }

    private long[] g(int i10, boolean z10) {
        if (!b(i10)) {
            if (z10) {
                throw new h("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar);
        if (aVar.f39899a != 9) {
            throw new h("type mismatch.");
        }
        int a10 = a(0, 0, true);
        if (a10 < 0) {
            throw new h("size invalid: ".concat(String.valueOf(a10)));
        }
        long[] jArr = new long[a10];
        for (int i11 = 0; i11 < a10; i11++) {
            jArr[i11] = a(jArr[0], 0, true);
        }
        return jArr;
    }

    private float[] h(int i10, boolean z10) {
        if (!b(i10)) {
            if (z10) {
                throw new h("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar);
        if (aVar.f39899a != 9) {
            throw new h("type mismatch.");
        }
        int a10 = a(0, 0, true);
        if (a10 < 0) {
            throw new h("size invalid: ".concat(String.valueOf(a10)));
        }
        float[] fArr = new float[a10];
        for (int i11 = 0; i11 < a10; i11++) {
            fArr[i11] = a(fArr[0], 0, true);
        }
        return fArr;
    }

    private double[] i(int i10, boolean z10) {
        if (!b(i10)) {
            if (z10) {
                throw new h("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar);
        if (aVar.f39899a != 9) {
            throw new h("type mismatch.");
        }
        int a10 = a(0, 0, true);
        if (a10 < 0) {
            throw new h("size invalid: ".concat(String.valueOf(a10)));
        }
        double[] dArr = new double[a10];
        for (int i11 = 0; i11 < a10; i11++) {
            dArr[i11] = a(dArr[0], 0, true);
        }
        return dArr;
    }

    public final byte a(byte b4, int i10, boolean z10) {
        if (!b(i10)) {
            if (z10) {
                throw new h("require field not exist.");
            }
            return b4;
        }
        a aVar = new a();
        a(aVar);
        byte b10 = aVar.f39899a;
        if (b10 == 0) {
            return this.f39898b.get();
        }
        if (b10 == 12) {
            return (byte) 0;
        }
        throw new h("type mismatch.");
    }

    public final int a(int i10, int i11, boolean z10) {
        if (!b(i11)) {
            if (z10) {
                throw new h("require field not exist.");
            }
            return i10;
        }
        a aVar = new a();
        a(aVar);
        byte b4 = aVar.f39899a;
        if (b4 == 0) {
            return this.f39898b.get();
        }
        if (b4 == 1) {
            return this.f39898b.getShort();
        }
        if (b4 == 2) {
            return this.f39898b.getInt();
        }
        if (b4 == 12) {
            return 0;
        }
        throw new h("type mismatch.");
    }

    public final int a(String str) {
        this.f39897a = str;
        return 0;
    }

    public final long a(long j10, int i10, boolean z10) {
        int i11;
        if (!b(i10)) {
            if (z10) {
                throw new h("require field not exist.");
            }
            return j10;
        }
        a aVar = new a();
        a(aVar);
        byte b4 = aVar.f39899a;
        if (b4 == 0) {
            i11 = this.f39898b.get();
        } else if (b4 == 1) {
            i11 = this.f39898b.getShort();
        } else {
            if (b4 != 2) {
                if (b4 == 3) {
                    return this.f39898b.getLong();
                }
                if (b4 == 12) {
                    return 0L;
                }
                throw new h("type mismatch.");
            }
            i11 = this.f39898b.getInt();
        }
        return i11;
    }

    public final m a(m mVar, int i10, boolean z10) {
        if (!b(i10)) {
            if (z10) {
                throw new h("require field not exist.");
            }
            return null;
        }
        try {
            m mVar2 = (m) mVar.getClass().newInstance();
            a aVar = new a();
            a(aVar);
            if (aVar.f39899a != 10) {
                throw new h("type mismatch.");
            }
            mVar2.a(this);
            a();
            return mVar2;
        } catch (Exception e2) {
            throw new h(e2.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> Object a(T t2, int i10, boolean z10) {
        if (t2 instanceof Byte) {
            return Byte.valueOf(a((byte) 0, i10, z10));
        }
        if (t2 instanceof Boolean) {
            return Boolean.valueOf(a(i10, z10));
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
            return a((Map) t2, i10, z10);
        }
        if (t2 instanceof List) {
            return a((List) t2, i10, z10);
        }
        if (t2 instanceof m) {
            return a((m) t2, i10, z10);
        }
        if (t2.getClass().isArray()) {
            return ((t2 instanceof byte[]) || (t2 instanceof Byte[])) ? c(i10, z10) : t2 instanceof boolean[] ? d(i10, z10) : t2 instanceof short[] ? e(i10, z10) : t2 instanceof int[] ? f(i10, z10) : t2 instanceof long[] ? g(i10, z10) : t2 instanceof float[] ? h(i10, z10) : t2 instanceof double[] ? i(i10, z10) : a((Object[]) t2, i10, z10);
        }
        throw new h("read object error: unsupport type.");
    }

    public final <K, V> HashMap<K, V> a(Map<K, V> map, int i10, boolean z10) {
        return (HashMap) a(new HashMap(), map, i10, z10);
    }

    public final short a(short s2, int i10, boolean z10) {
        if (!b(i10)) {
            if (z10) {
                throw new h("require field not exist.");
            }
            return s2;
        }
        a aVar = new a();
        a(aVar);
        byte b4 = aVar.f39899a;
        if (b4 == 0) {
            return this.f39898b.get();
        }
        if (b4 == 1) {
            return this.f39898b.getShort();
        }
        if (b4 == 12) {
            return (short) 0;
        }
        throw new h("type mismatch.");
    }

    public final void a(byte[] bArr) {
        ByteBuffer byteBuffer = this.f39898b;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        this.f39898b = ByteBuffer.wrap(bArr);
    }

    public final boolean a(int i10, boolean z10) {
        return a((byte) 0, i10, z10) != 0;
    }

    public final String b(int i10, boolean z10) {
        if (!b(i10)) {
            if (z10) {
                throw new h("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar);
        byte b4 = aVar.f39899a;
        if (b4 == 6) {
            int i11 = this.f39898b.get();
            if (i11 < 0) {
                i11 += 256;
            }
            byte[] bArr = new byte[i11];
            this.f39898b.get(bArr);
            try {
                return new String(bArr, this.f39897a);
            } catch (UnsupportedEncodingException unused) {
                return new String(bArr);
            }
        }
        if (b4 != 7) {
            throw new h("type mismatch.");
        }
        int i12 = this.f39898b.getInt();
        if (i12 > 104857600 || i12 < 0) {
            throw new h("String too long: ".concat(String.valueOf(i12)));
        }
        byte[] bArr2 = new byte[i12];
        this.f39898b.get(bArr2);
        try {
            return new String(bArr2, this.f39897a);
        } catch (UnsupportedEncodingException unused2) {
            return new String(bArr2);
        }
    }

    public final byte[] c(int i10, boolean z10) {
        if (!b(i10)) {
            if (z10) {
                throw new h("require field not exist.");
            }
            return null;
        }
        a aVar = new a();
        a(aVar);
        byte b4 = aVar.f39899a;
        if (b4 == 9) {
            int a10 = a(0, 0, true);
            if (a10 < 0) {
                throw new h("size invalid: ".concat(String.valueOf(a10)));
            }
            byte[] bArr = new byte[a10];
            for (int i11 = 0; i11 < a10; i11++) {
                bArr[i11] = a(bArr[0], 0, true);
            }
            return bArr;
        }
        if (b4 != 13) {
            throw new h("type mismatch.");
        }
        a aVar2 = new a();
        a(aVar2);
        if (aVar2.f39899a != 0) {
            throw new h("type mismatch, tag: " + i10 + ", type: " + ((int) aVar.f39899a) + ", " + ((int) aVar2.f39899a));
        }
        int a11 = a(0, 0, true);
        if (a11 >= 0) {
            byte[] bArr2 = new byte[a11];
            this.f39898b.get(bArr2);
            return bArr2;
        }
        throw new h("invalid size, tag: " + i10 + ", type: " + ((int) aVar.f39899a) + ", " + ((int) aVar2.f39899a) + ", size: " + a11);
    }
}
