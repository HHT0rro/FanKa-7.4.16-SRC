package com.tencent.turingface.sdk.mfa;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class d5HOq {

    /* renamed from: a, reason: collision with root package name */
    public ByteBuffer f45755a;

    /* renamed from: b, reason: collision with root package name */
    public String f45756b = "GBK";

    public d5HOq(int i10) {
        this.f45755a = ByteBuffer.allocate(i10);
    }

    public final void a(int i10) {
        if (this.f45755a.remaining() < i10) {
            ByteBuffer allocate = ByteBuffer.allocate((this.f45755a.capacity() + i10) * 2);
            allocate.put(this.f45755a.array(), 0, this.f45755a.position());
            this.f45755a = allocate;
        }
    }

    public final void b(byte b4, int i10) {
        if (i10 < 15) {
            this.f45755a.put((byte) (b4 | (i10 << 4)));
        } else if (i10 < 256) {
            this.f45755a.put((byte) (b4 | 240));
            this.f45755a.put((byte) i10);
        } else {
            throw new yiZAu("tag is too large: " + i10);
        }
    }

    public final void a(byte b4, int i10) {
        a(3);
        if (b4 == 0) {
            b((byte) 12, i10);
        } else {
            b((byte) 0, i10);
            this.f45755a.put(b4);
        }
    }

    public final void a(short s2, int i10) {
        a(4);
        if (s2 >= -128 && s2 <= 127) {
            a((byte) s2, i10);
        } else {
            b((byte) 1, i10);
            this.f45755a.putShort(s2);
        }
    }

    public final void a(int i10, int i11) {
        a(6);
        if (i10 >= -32768 && i10 <= 32767) {
            a((short) i10, i11);
        } else {
            b((byte) 2, i11);
            this.f45755a.putInt(i10);
        }
    }

    public final void a(long j10, int i10) {
        a(10);
        if (j10 >= -2147483648L && j10 <= ZipUtils.UPPER_UNIXTIME_BOUND) {
            a((int) j10, i10);
        } else {
            b((byte) 3, i10);
            this.f45755a.putLong(j10);
        }
    }

    public final void a(float f10, int i10) {
        a(6);
        b((byte) 4, i10);
        this.f45755a.putFloat(f10);
    }

    public final void a(String str, int i10) {
        byte[] bytes;
        try {
            bytes = str.getBytes(this.f45756b);
        } catch (UnsupportedEncodingException unused) {
            bytes = str.getBytes();
        }
        a(bytes.length + 10);
        if (bytes.length > 255) {
            b((byte) 7, i10);
            this.f45755a.putInt(bytes.length);
            this.f45755a.put(bytes);
        } else {
            b((byte) 6, i10);
            this.f45755a.put((byte) bytes.length);
            this.f45755a.put(bytes);
        }
    }

    public final <K, V> void a(Map<K, V> map, int i10) {
        a(8);
        b((byte) 8, i10);
        a(map == null ? 0 : map.size(), 0);
        if (map != null) {
            for (Map.Entry<K, V> entry : map.entrySet()) {
                a(entry.getKey(), 0);
                a(entry.getValue(), 1);
            }
        }
    }

    public final void a(byte[] bArr, int i10) {
        a(bArr.length + 8);
        b((byte) 13, i10);
        b((byte) 0, 0);
        a(bArr.length, 0);
        this.f45755a.put(bArr);
    }

    public final <T> void a(Collection<T> collection, int i10) {
        a(8);
        b((byte) 9, i10);
        a(collection == null ? 0 : collection.size(), 0);
        if (collection != null) {
            Iterator<T> iterator2 = collection.iterator2();
            while (iterator2.hasNext()) {
                a(iterator2.next(), 0);
            }
        }
    }

    public final void a(ucT3w uct3w, int i10) {
        a(2);
        b((byte) 10, i10);
        uct3w.a(this);
        a(2);
        b((byte) 11, 0);
    }

    public final void a(Object obj, int i10) {
        if (obj instanceof Byte) {
            a(((Byte) obj).byteValue(), i10);
            return;
        }
        if (obj instanceof Boolean) {
            a(((Boolean) obj).booleanValue() ? (byte) 1 : (byte) 0, i10);
            return;
        }
        if (obj instanceof Short) {
            a(((Short) obj).shortValue(), i10);
            return;
        }
        if (obj instanceof Integer) {
            a(((Integer) obj).intValue(), i10);
            return;
        }
        if (obj instanceof Long) {
            a(((Long) obj).longValue(), i10);
            return;
        }
        if (obj instanceof Float) {
            a(((Float) obj).floatValue(), i10);
            return;
        }
        if (obj instanceof Double) {
            double doubleValue = ((Double) obj).doubleValue();
            a(10);
            b((byte) 5, i10);
            this.f45755a.putDouble(doubleValue);
            return;
        }
        if (obj instanceof String) {
            a((String) obj, i10);
            return;
        }
        if (obj instanceof Map) {
            a((Map) obj, i10);
            return;
        }
        if (obj instanceof List) {
            a((Collection) obj, i10);
            return;
        }
        if (obj instanceof ucT3w) {
            a((ucT3w) obj, i10);
            return;
        }
        if (obj instanceof byte[]) {
            a((byte[]) obj, i10);
            return;
        }
        if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            a(8);
            b((byte) 9, i10);
            a(zArr.length, 0);
            for (boolean z10 : zArr) {
                a(z10 ? (byte) 1 : (byte) 0, 0);
            }
            return;
        }
        if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            a(8);
            b((byte) 9, i10);
            a(sArr.length, 0);
            for (short s2 : sArr) {
                a(s2, 0);
            }
            return;
        }
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            a(8);
            b((byte) 9, i10);
            a(iArr.length, 0);
            for (int i11 : iArr) {
                a(i11, 0);
            }
            return;
        }
        if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            a(8);
            b((byte) 9, i10);
            a(jArr.length, 0);
            for (long j10 : jArr) {
                a(j10, 0);
            }
            return;
        }
        if (obj instanceof float[]) {
            float[] fArr = (float[]) obj;
            a(8);
            b((byte) 9, i10);
            a(fArr.length, 0);
            for (float f10 : fArr) {
                a(f10, 0);
            }
            return;
        }
        if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            a(8);
            b((byte) 9, i10);
            a(dArr.length, 0);
            for (double d10 : dArr) {
                a(10);
                b((byte) 5, 0);
                this.f45755a.putDouble(d10);
            }
            return;
        }
        if (obj.getClass().isArray()) {
            Object[] objArr = (Object[]) obj;
            a(8);
            b((byte) 9, i10);
            a(objArr.length, 0);
            for (Object obj2 : objArr) {
                a(obj2, 0);
            }
            return;
        }
        if (obj instanceof Collection) {
            a((Collection) obj, i10);
        } else {
            StringBuilder b4 = com.tencent.turingcam.oqKCa.b("write object error: unsupport type. ");
            b4.append((Object) obj.getClass());
            throw new yiZAu(b4.toString());
        }
    }
}