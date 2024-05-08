package com.tencent.turingface.sdk.mfa;

import android.view.autofill.ParcelableMap;
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
public final class nyvKz {

    /* renamed from: a, reason: collision with root package name */
    public ByteBuffer f45893a;

    /* renamed from: b, reason: collision with root package name */
    public String f45894b = "GBK";

    public nyvKz() {
    }

    public final void a() {
        ByteBuffer byteBuffer = this.f45893a;
        byte b4 = byteBuffer.get();
        byte b10 = (byte) (b4 & 15);
        if (((b4 & 240) >> 4) == 15) {
            byteBuffer.get();
        }
        a(b10);
    }

    public final boolean b(int i10) {
        int i11;
        int i12;
        while (true) {
            try {
                ByteBuffer duplicate = this.f45893a.duplicate();
                byte b4 = duplicate.get();
                byte b10 = (byte) (b4 & 15);
                i11 = (b4 & 240) >> 4;
                if (i11 == 15) {
                    i11 = duplicate.get() & 255;
                    i12 = 2;
                } else {
                    i12 = 1;
                }
                if (i10 <= i11 || b10 == 11) {
                    break;
                }
                a(i12);
                a(b10);
            } catch (s7Dnc | BufferUnderflowException unused) {
                return false;
            }
        }
        return i10 == i11;
    }

    public nyvKz(byte[] bArr) {
        this.f45893a = ByteBuffer.wrap(bArr);
    }

    public final void a(int i10) {
        ByteBuffer byteBuffer = this.f45893a;
        byteBuffer.position(byteBuffer.position() + i10);
    }

    public nyvKz(byte[] bArr, int i10) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        this.f45893a = wrap;
        wrap.position(4);
    }

    public final void a(byte b4) {
        int i10 = 0;
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
                int i11 = this.f45893a.get();
                if (i11 < 0) {
                    i11 += 256;
                }
                a(i11);
                return;
            case 7:
                a(this.f45893a.getInt());
                return;
            case 8:
                int a10 = a(0, 0, true);
                while (i10 < a10 * 2) {
                    a();
                    i10++;
                }
                return;
            case 9:
                int a11 = a(0, 0, true);
                while (i10 < a11) {
                    a();
                    i10++;
                }
                return;
            case 10:
                b();
                return;
            case 11:
            case 12:
                return;
            case 13:
                ByteBuffer byteBuffer = this.f45893a;
                byte b10 = byteBuffer.get();
                byte b11 = (byte) (b10 & 15);
                if (((b10 & 240) >> 4) == 15) {
                    byteBuffer.get();
                }
                if (b11 == 0) {
                    a(a(0, 0, true));
                    return;
                }
                throw new s7Dnc("skipField with invalid type, type value: " + ((int) b4) + ", " + ((int) b11));
            default:
                throw new s7Dnc("invalid type.");
        }
    }

    public final void b() {
        while (this.f45893a.remaining() != 0) {
            ByteBuffer byteBuffer = this.f45893a;
            byte b4 = byteBuffer.get();
            byte b10 = (byte) (b4 & 15);
            if (((b4 & 240) >> 4) == 15) {
                byteBuffer.get();
            }
            a(b10);
            if (b10 == 11) {
                return;
            }
        }
    }

    public final String b(int i10, boolean z10) {
        if (b(i10)) {
            ByteBuffer byteBuffer = this.f45893a;
            byte b4 = byteBuffer.get();
            byte b10 = (byte) (b4 & 15);
            if (((b4 & 240) >> 4) == 15) {
                byteBuffer.get();
            }
            if (b10 == 6) {
                int i11 = this.f45893a.get();
                if (i11 < 0) {
                    i11 += 256;
                }
                byte[] bArr = new byte[i11];
                this.f45893a.get(bArr);
                try {
                    return new String(bArr, this.f45894b);
                } catch (UnsupportedEncodingException unused) {
                    return new String(bArr);
                }
            }
            if (b10 == 7) {
                int i12 = this.f45893a.getInt();
                if (i12 <= 104857600 && i12 >= 0) {
                    byte[] bArr2 = new byte[i12];
                    this.f45893a.get(bArr2);
                    try {
                        return new String(bArr2, this.f45894b);
                    } catch (UnsupportedEncodingException unused2) {
                        return new String(bArr2);
                    }
                }
                throw new s7Dnc("String too long: " + i12);
            }
            if (b10 != 11) {
                throw new s7Dnc("type mismatch.");
            }
        } else if (z10) {
            throw new s7Dnc("require field not exist.");
        }
        return null;
    }

    public final boolean a(boolean z10, int i10, boolean z11) {
        return a(z10 ? (byte) 1 : (byte) 0, i10, z11) != 0;
    }

    public final byte a(byte b4, int i10, boolean z10) {
        if (!b(i10)) {
            if (z10) {
                throw new s7Dnc("require field not exist.");
            }
            return b4;
        }
        ByteBuffer byteBuffer = this.f45893a;
        byte b10 = byteBuffer.get();
        byte b11 = (byte) (b10 & 15);
        if (((b10 & 240) >> 4) == 15) {
            byteBuffer.get();
        }
        if (b11 == 0) {
            return this.f45893a.get();
        }
        if (b11 == 11) {
            return b4;
        }
        if (b11 == 12) {
            return (byte) 0;
        }
        throw new s7Dnc("type mismatch.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> T[] b(T t2, int i10, boolean z10) {
        if (!b(i10)) {
            if (z10) {
                throw new s7Dnc("require field not exist.");
            }
            return null;
        }
        ByteBuffer byteBuffer = this.f45893a;
        byte b4 = byteBuffer.get();
        byte b10 = (byte) (b4 & 15);
        if (((b4 & 240) >> 4) == 15) {
            byteBuffer.get();
        }
        if (b10 != 9) {
            if (b10 == 11) {
                return null;
            }
            throw new s7Dnc("type mismatch.");
        }
        int a10 = a(0, 0, true);
        if (a10 >= 0) {
            T[] tArr = (T[]) ((Object[]) Array.newInstance(t2.getClass(), a10));
            for (int i11 = 0; i11 < a10; i11++) {
                tArr[i11] = a((nyvKz) t2, 0, true);
            }
            return tArr;
        }
        throw new s7Dnc("size invalid: " + a10);
    }

    public final short a(short s2, int i10, boolean z10) {
        if (!b(i10)) {
            if (z10) {
                throw new s7Dnc("require field not exist.");
            }
            return s2;
        }
        ByteBuffer byteBuffer = this.f45893a;
        byte b4 = byteBuffer.get();
        byte b10 = (byte) (b4 & 15);
        if (((b4 & 240) >> 4) == 15) {
            byteBuffer.get();
        }
        if (b10 == 0) {
            return this.f45893a.get();
        }
        if (b10 == 1) {
            return this.f45893a.getShort();
        }
        if (b10 == 11) {
            return s2;
        }
        if (b10 == 12) {
            return (short) 0;
        }
        throw new s7Dnc("type mismatch.");
    }

    public final int a(int i10, int i11, boolean z10) {
        if (!b(i11)) {
            if (z10) {
                throw new s7Dnc("require field not exist.");
            }
            return i10;
        }
        ByteBuffer byteBuffer = this.f45893a;
        byte b4 = byteBuffer.get();
        byte b10 = (byte) (b4 & 15);
        if (((b4 & 240) >> 4) == 15) {
            byteBuffer.get();
        }
        if (b10 == 0) {
            return this.f45893a.get();
        }
        if (b10 == 1) {
            return this.f45893a.getShort();
        }
        if (b10 == 2) {
            return this.f45893a.getInt();
        }
        if (b10 == 11) {
            return i10;
        }
        if (b10 == 12) {
            return 0;
        }
        throw new s7Dnc("type mismatch.");
    }

    public final long a(long j10, int i10, boolean z10) {
        int i11;
        if (!b(i10)) {
            if (z10) {
                throw new s7Dnc("require field not exist.");
            }
            return j10;
        }
        ByteBuffer byteBuffer = this.f45893a;
        byte b4 = byteBuffer.get();
        byte b10 = (byte) (b4 & 15);
        if (((b4 & 240) >> 4) == 15) {
            byteBuffer.get();
        }
        if (b10 == 11) {
            return j10;
        }
        if (b10 == 12) {
            return 0L;
        }
        if (b10 == 0) {
            i11 = this.f45893a.get();
        } else if (b10 == 1) {
            i11 = this.f45893a.getShort();
        } else {
            if (b10 != 2) {
                if (b10 == 3) {
                    return this.f45893a.getLong();
                }
                throw new s7Dnc("type mismatch.");
            }
            i11 = this.f45893a.getInt();
        }
        return i11;
    }

    public final float a(float f10, int i10, boolean z10) {
        if (!b(i10)) {
            if (z10) {
                throw new s7Dnc("require field not exist.");
            }
            return f10;
        }
        ByteBuffer byteBuffer = this.f45893a;
        byte b4 = byteBuffer.get();
        byte b10 = (byte) (b4 & 15);
        if (((b4 & 240) >> 4) == 15) {
            byteBuffer.get();
        }
        if (b10 == 4) {
            return this.f45893a.getFloat();
        }
        if (b10 == 11) {
            return f10;
        }
        if (b10 == 12) {
            return 0.0f;
        }
        throw new s7Dnc("type mismatch.");
    }

    public final double a(double d10, int i10, boolean z10) {
        if (!b(i10)) {
            if (z10) {
                throw new s7Dnc("require field not exist.");
            }
            return d10;
        }
        ByteBuffer byteBuffer = this.f45893a;
        byte b4 = byteBuffer.get();
        byte b10 = (byte) (b4 & 15);
        if (((b4 & 240) >> 4) == 15) {
            byteBuffer.get();
        }
        if (b10 == 4) {
            return this.f45893a.getFloat();
        }
        if (b10 == 5) {
            return this.f45893a.getDouble();
        }
        if (b10 == 11) {
            return d10;
        }
        if (b10 == 12) {
            return ShadowDrawableWrapper.COS_45;
        }
        throw new s7Dnc("type mismatch.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <K, V> HashMap<K, V> a(Map<K, V> map, int i10, boolean z10) {
        ParcelableMap parcelableMap = (HashMap<K, V>) new HashMap();
        if (map != null && !map.isEmpty()) {
            Map.Entry<K, V> next = map.entrySet().iterator2().next();
            K key = next.getKey();
            V value = next.getValue();
            if (!b(i10)) {
                if (z10) {
                    throw new s7Dnc("require field not exist.");
                }
                return parcelableMap;
            }
            ByteBuffer byteBuffer = this.f45893a;
            byte b4 = byteBuffer.get();
            byte b10 = (byte) (b4 & 15);
            if (((b4 & 240) >> 4) == 15) {
                byteBuffer.get();
            }
            if (b10 != 8) {
                if (b10 == 11) {
                    return parcelableMap;
                }
                throw new s7Dnc("type mismatch.");
            }
            int a10 = a(0, 0, true);
            if (a10 < 0) {
                throw new s7Dnc("size invalid: " + a10);
            }
            for (int i11 = 0; i11 < a10; i11++) {
                parcelableMap.put(a((nyvKz) key, 0, true), a((nyvKz) value, 1, true));
            }
            return parcelableMap;
        }
        return new HashMap<>();
    }

    public final byte[] a(int i10, boolean z10) {
        if (b(i10)) {
            ByteBuffer byteBuffer = this.f45893a;
            byte b4 = byteBuffer.get();
            byte b10 = (byte) (b4 & 15);
            if (((b4 & 240) >> 4) == 15) {
                byteBuffer.get();
            }
            if (b10 == 9) {
                int a10 = a(0, 0, true);
                if (a10 >= 0) {
                    byte[] bArr = new byte[a10];
                    for (int i11 = 0; i11 < a10; i11++) {
                        bArr[i11] = a(bArr[0], 0, true);
                    }
                    return bArr;
                }
                throw new s7Dnc("size invalid: " + a10);
            }
            if (b10 != 11) {
                if (b10 == 13) {
                    ByteBuffer byteBuffer2 = this.f45893a;
                    byte b11 = byteBuffer2.get();
                    byte b12 = (byte) (b11 & 15);
                    if (((b11 & 240) >> 4) == 15) {
                        byteBuffer2.get();
                    }
                    if (b12 == 0) {
                        int a11 = a(0, 0, true);
                        if (a11 >= 0) {
                            byte[] bArr2 = new byte[a11];
                            this.f45893a.get(bArr2);
                            return bArr2;
                        }
                        throw new s7Dnc("invalid size, tag: " + i10 + ", type: " + ((int) b10) + ", " + ((int) b12) + ", size: " + a11);
                    }
                    throw new s7Dnc("type mismatch, tag: " + i10 + ", type: " + ((int) b10) + ", " + ((int) b12));
                }
                throw new s7Dnc("type mismatch.");
            }
        } else if (z10) {
            throw new s7Dnc("require field not exist.");
        }
        return null;
    }

    public final ucT3w a(ucT3w uct3w, int i10, boolean z10) {
        if (!b(i10)) {
            if (z10) {
                throw new s7Dnc("require field not exist.");
            }
            return null;
        }
        try {
            ucT3w uct3w2 = (ucT3w) uct3w.getClass().newInstance();
            ByteBuffer byteBuffer = this.f45893a;
            byte b4 = byteBuffer.get();
            byte b10 = (byte) (b4 & 15);
            if (((b4 & 240) >> 4) == 15) {
                byteBuffer.get();
            }
            if (b10 == 10) {
                uct3w2.a(this);
                b();
                return uct3w2;
            }
            throw new s7Dnc("type mismatch.");
        } catch (Exception e2) {
            throw new s7Dnc(e2.getMessage());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> Object a(T t2, int i10, boolean z10) {
        if (t2 instanceof Byte) {
            return Byte.valueOf(a((byte) 0, i10, z10));
        }
        if (t2 instanceof Boolean) {
            return Boolean.valueOf(a(false, i10, z10));
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
            return b(i10, z10);
        }
        if (t2 instanceof Map) {
            return a((Map) t2, i10, z10);
        }
        double[] dArr = null;
        r2 = null;
        boolean[] zArr = null;
        r2 = null;
        short[] sArr = null;
        r2 = null;
        int[] iArr = null;
        r2 = null;
        long[] jArr = null;
        r2 = null;
        float[] fArr = null;
        dArr = null;
        if (t2 instanceof List) {
            List list = (List) t2;
            if (list != null && !list.isEmpty()) {
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
            return new ArrayList();
        }
        if (t2 instanceof ucT3w) {
            return a((ucT3w) t2, i10, z10);
        }
        if (t2.getClass().isArray()) {
            if (!(t2 instanceof byte[]) && !(t2 instanceof Byte[])) {
                if (t2 instanceof boolean[]) {
                    if (b(i10)) {
                        ByteBuffer byteBuffer = this.f45893a;
                        byte b10 = byteBuffer.get();
                        byte b11 = (byte) (b10 & 15);
                        if (((b10 & 240) >> 4) == 15) {
                            byteBuffer.get();
                        }
                        if (b11 == 9) {
                            int a10 = a(0, 0, true);
                            if (a10 >= 0) {
                                zArr = new boolean[a10];
                                for (int i11 = 0; i11 < a10; i11++) {
                                    zArr[i11] = a(zArr[0], 0, true);
                                }
                            } else {
                                throw new s7Dnc("size invalid: " + a10);
                            }
                        } else if (b11 != 11) {
                            throw new s7Dnc("type mismatch.");
                        }
                    } else if (z10) {
                        throw new s7Dnc("require field not exist.");
                    }
                    return zArr;
                }
                if (t2 instanceof short[]) {
                    if (b(i10)) {
                        ByteBuffer byteBuffer2 = this.f45893a;
                        byte b12 = byteBuffer2.get();
                        byte b13 = (byte) (b12 & 15);
                        if (((b12 & 240) >> 4) == 15) {
                            byteBuffer2.get();
                        }
                        if (b13 == 9) {
                            int a11 = a(0, 0, true);
                            if (a11 >= 0) {
                                sArr = new short[a11];
                                for (int i12 = 0; i12 < a11; i12++) {
                                    sArr[i12] = a(sArr[0], 0, true);
                                }
                            } else {
                                throw new s7Dnc("size invalid: " + a11);
                            }
                        } else if (b13 != 11) {
                            throw new s7Dnc("type mismatch.");
                        }
                    } else if (z10) {
                        throw new s7Dnc("require field not exist.");
                    }
                    return sArr;
                }
                if (t2 instanceof int[]) {
                    if (b(i10)) {
                        ByteBuffer byteBuffer3 = this.f45893a;
                        byte b14 = byteBuffer3.get();
                        byte b15 = (byte) (b14 & 15);
                        if (((b14 & 240) >> 4) == 15) {
                            byteBuffer3.get();
                        }
                        if (b15 == 9) {
                            int a12 = a(0, 0, true);
                            if (a12 >= 0) {
                                iArr = new int[a12];
                                for (int i13 = 0; i13 < a12; i13++) {
                                    iArr[i13] = a(iArr[0], 0, true);
                                }
                            } else {
                                throw new s7Dnc("size invalid: " + a12);
                            }
                        } else if (b15 != 11) {
                            throw new s7Dnc("type mismatch.");
                        }
                    } else if (z10) {
                        throw new s7Dnc("require field not exist.");
                    }
                    return iArr;
                }
                if (t2 instanceof long[]) {
                    if (b(i10)) {
                        ByteBuffer byteBuffer4 = this.f45893a;
                        byte b16 = byteBuffer4.get();
                        byte b17 = (byte) (b16 & 15);
                        if (((b16 & 240) >> 4) == 15) {
                            byteBuffer4.get();
                        }
                        if (b17 == 9) {
                            int a13 = a(0, 0, true);
                            if (a13 >= 0) {
                                jArr = new long[a13];
                                for (int i14 = 0; i14 < a13; i14++) {
                                    jArr[i14] = a(jArr[0], 0, true);
                                }
                            } else {
                                throw new s7Dnc("size invalid: " + a13);
                            }
                        } else if (b17 != 11) {
                            throw new s7Dnc("type mismatch.");
                        }
                    } else if (z10) {
                        throw new s7Dnc("require field not exist.");
                    }
                    return jArr;
                }
                if (t2 instanceof float[]) {
                    if (b(i10)) {
                        ByteBuffer byteBuffer5 = this.f45893a;
                        byte b18 = byteBuffer5.get();
                        byte b19 = (byte) (b18 & 15);
                        if (((b18 & 240) >> 4) == 15) {
                            byteBuffer5.get();
                        }
                        if (b19 == 9) {
                            int a14 = a(0, 0, true);
                            if (a14 >= 0) {
                                fArr = new float[a14];
                                for (int i15 = 0; i15 < a14; i15++) {
                                    fArr[i15] = a(fArr[0], 0, true);
                                }
                            } else {
                                throw new s7Dnc("size invalid: " + a14);
                            }
                        } else if (b19 != 11) {
                            throw new s7Dnc("type mismatch.");
                        }
                    } else if (z10) {
                        throw new s7Dnc("require field not exist.");
                    }
                    return fArr;
                }
                if (t2 instanceof double[]) {
                    if (b(i10)) {
                        ByteBuffer byteBuffer6 = this.f45893a;
                        byte b20 = byteBuffer6.get();
                        byte b21 = (byte) (b20 & 15);
                        if (((b20 & 240) >> 4) == 15) {
                            byteBuffer6.get();
                        }
                        if (b21 == 9) {
                            int a15 = a(0, 0, true);
                            if (a15 >= 0) {
                                dArr = new double[a15];
                                for (int i16 = 0; i16 < a15; i16++) {
                                    dArr[i16] = a(dArr[0], 0, true);
                                }
                            } else {
                                throw new s7Dnc("size invalid: " + a15);
                            }
                        } else if (b21 != 11) {
                            throw new s7Dnc("type mismatch.");
                        }
                    } else if (z10) {
                        throw new s7Dnc("require field not exist.");
                    }
                    return dArr;
                }
                Object[] objArr = (Object[]) t2;
                if (objArr.length != 0) {
                    return b(objArr[0], i10, z10);
                }
                throw new s7Dnc("unable to get type of key and value.");
            }
            return a(i10, z10);
        }
        throw new s7Dnc("read object error: unsupport type.");
    }
}
