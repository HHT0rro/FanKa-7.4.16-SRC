package com.tencent.bugly.idasc.proguard;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    private StringBuilder f39895a;

    /* renamed from: b, reason: collision with root package name */
    private int f39896b;

    public i(StringBuilder sb2, int i10) {
        this.f39895a = sb2;
        this.f39896b = i10;
    }

    private i a(char c4, String str) {
        a(str);
        StringBuilder sb2 = this.f39895a;
        sb2.append(c4);
        sb2.append('\n');
        return this;
    }

    private i a(double d10, String str) {
        a(str);
        StringBuilder sb2 = this.f39895a;
        sb2.append(d10);
        sb2.append('\n');
        return this;
    }

    private i a(float f10, String str) {
        a(str);
        StringBuilder sb2 = this.f39895a;
        sb2.append(f10);
        sb2.append('\n');
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> i a(T t2, String str) {
        if (t2 == 0) {
            this.f39895a.append("null\n");
        } else if (t2 instanceof Byte) {
            a(((Byte) t2).byteValue(), str);
        } else if (t2 instanceof Boolean) {
            a(((Boolean) t2).booleanValue(), str);
        } else if (t2 instanceof Short) {
            a(((Short) t2).shortValue(), str);
        } else if (t2 instanceof Integer) {
            a(((Integer) t2).intValue(), str);
        } else if (t2 instanceof Long) {
            a(((Long) t2).longValue(), str);
        } else if (t2 instanceof Float) {
            a(((Float) t2).floatValue(), str);
        } else if (t2 instanceof Double) {
            a(((Double) t2).doubleValue(), str);
        } else if (t2 instanceof String) {
            a((String) t2, str);
        } else if (t2 instanceof Map) {
            a((Map) t2, str);
        } else if (t2 instanceof List) {
            a((Collection) t2, str);
        } else if (t2 instanceof m) {
            a((m) t2, str);
        } else if (t2 instanceof byte[]) {
            a((byte[]) t2, str);
        } else if (t2 instanceof boolean[]) {
            a((i) t2, str);
        } else if (t2 instanceof short[]) {
            a((short[]) t2, str);
        } else if (t2 instanceof int[]) {
            a((int[]) t2, str);
        } else if (t2 instanceof long[]) {
            a((long[]) t2, str);
        } else if (t2 instanceof float[]) {
            a((float[]) t2, str);
        } else if (t2 instanceof double[]) {
            a((double[]) t2, str);
        } else {
            if (!t2.getClass().isArray()) {
                throw new j("write object error: unsupport type.");
            }
            a((Object[]) t2, str);
        }
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> i a(Collection<T> collection, String str) {
        if (collection != null) {
            return a(collection.toArray(), str);
        }
        a(str);
        this.f39895a.append("null\t");
        return this;
    }

    private i a(double[] dArr, String str) {
        a(str);
        if (dArr == null) {
            this.f39895a.append("null\n");
            return this;
        }
        if (dArr.length == 0) {
            StringBuilder sb2 = this.f39895a;
            sb2.append(dArr.length);
            sb2.append(", []\n");
            return this;
        }
        StringBuilder sb3 = this.f39895a;
        sb3.append(dArr.length);
        sb3.append(", [\n");
        i iVar = new i(this.f39895a, this.f39896b + 1);
        for (double d10 : dArr) {
            iVar.a(d10, (String) null);
        }
        a(']', (String) null);
        return this;
    }

    private i a(float[] fArr, String str) {
        a(str);
        if (fArr == null) {
            this.f39895a.append("null\n");
            return this;
        }
        if (fArr.length == 0) {
            StringBuilder sb2 = this.f39895a;
            sb2.append(fArr.length);
            sb2.append(", []\n");
            return this;
        }
        StringBuilder sb3 = this.f39895a;
        sb3.append(fArr.length);
        sb3.append(", [\n");
        i iVar = new i(this.f39895a, this.f39896b + 1);
        for (float f10 : fArr) {
            iVar.a(f10, (String) null);
        }
        a(']', (String) null);
        return this;
    }

    private i a(int[] iArr, String str) {
        a(str);
        if (iArr == null) {
            this.f39895a.append("null\n");
            return this;
        }
        if (iArr.length == 0) {
            StringBuilder sb2 = this.f39895a;
            sb2.append(iArr.length);
            sb2.append(", []\n");
            return this;
        }
        StringBuilder sb3 = this.f39895a;
        sb3.append(iArr.length);
        sb3.append(", [\n");
        i iVar = new i(this.f39895a, this.f39896b + 1);
        for (int i10 : iArr) {
            iVar.a(i10, (String) null);
        }
        a(']', (String) null);
        return this;
    }

    private i a(long[] jArr, String str) {
        a(str);
        if (jArr == null) {
            this.f39895a.append("null\n");
            return this;
        }
        if (jArr.length == 0) {
            StringBuilder sb2 = this.f39895a;
            sb2.append(jArr.length);
            sb2.append(", []\n");
            return this;
        }
        StringBuilder sb3 = this.f39895a;
        sb3.append(jArr.length);
        sb3.append(", [\n");
        i iVar = new i(this.f39895a, this.f39896b + 1);
        for (long j10 : jArr) {
            iVar.a(j10, (String) null);
        }
        a(']', (String) null);
        return this;
    }

    private <T> i a(T[] tArr, String str) {
        a(str);
        if (tArr == null) {
            this.f39895a.append("null\n");
            return this;
        }
        if (tArr.length == 0) {
            StringBuilder sb2 = this.f39895a;
            sb2.append(tArr.length);
            sb2.append(", []\n");
            return this;
        }
        StringBuilder sb3 = this.f39895a;
        sb3.append(tArr.length);
        sb3.append(", [\n");
        i iVar = new i(this.f39895a, this.f39896b + 1);
        for (T t2 : tArr) {
            iVar.a((i) t2, (String) null);
        }
        a(']', (String) null);
        return this;
    }

    private i a(short[] sArr, String str) {
        a(str);
        if (sArr == null) {
            this.f39895a.append("null\n");
            return this;
        }
        if (sArr.length == 0) {
            StringBuilder sb2 = this.f39895a;
            sb2.append(sArr.length);
            sb2.append(", []\n");
            return this;
        }
        StringBuilder sb3 = this.f39895a;
        sb3.append(sArr.length);
        sb3.append(", [\n");
        i iVar = new i(this.f39895a, this.f39896b + 1);
        for (short s2 : sArr) {
            iVar.a(s2, (String) null);
        }
        a(']', (String) null);
        return this;
    }

    private void a(String str) {
        for (int i10 = 0; i10 < this.f39896b; i10++) {
            this.f39895a.append('\t');
        }
        if (str != null) {
            StringBuilder sb2 = this.f39895a;
            sb2.append(str);
            sb2.append(": ");
        }
    }

    public final i a(byte b4, String str) {
        a(str);
        StringBuilder sb2 = this.f39895a;
        sb2.append((int) b4);
        sb2.append('\n');
        return this;
    }

    public final i a(int i10, String str) {
        a(str);
        StringBuilder sb2 = this.f39895a;
        sb2.append(i10);
        sb2.append('\n');
        return this;
    }

    public final i a(long j10, String str) {
        a(str);
        StringBuilder sb2 = this.f39895a;
        sb2.append(j10);
        sb2.append('\n');
        return this;
    }

    public final i a(m mVar, String str) {
        a('{', str);
        if (mVar == null) {
            StringBuilder sb2 = this.f39895a;
            sb2.append('\t');
            sb2.append("null");
        } else {
            mVar.a(this.f39895a, this.f39896b + 1);
        }
        a('}', (String) null);
        return this;
    }

    public final i a(String str, String str2) {
        a(str2);
        if (str == null) {
            this.f39895a.append("null\n");
        } else {
            StringBuilder sb2 = this.f39895a;
            sb2.append(str);
            sb2.append('\n');
        }
        return this;
    }

    public final <K, V> i a(Map<K, V> map, String str) {
        a(str);
        if (map == null) {
            this.f39895a.append("null\n");
            return this;
        }
        if (map.isEmpty()) {
            StringBuilder sb2 = this.f39895a;
            sb2.append(map.size());
            sb2.append(", {}\n");
            return this;
        }
        StringBuilder sb3 = this.f39895a;
        sb3.append(map.size());
        sb3.append(", {\n");
        i iVar = new i(this.f39895a, this.f39896b + 1);
        i iVar2 = new i(this.f39895a, this.f39896b + 2);
        for (Map.Entry<K, V> entry : map.entrySet()) {
            iVar.a('(', (String) null);
            iVar2.a((i) entry.getKey(), (String) null);
            iVar2.a((i) entry.getValue(), (String) null);
            iVar.a(')', (String) null);
        }
        a('}', (String) null);
        return this;
    }

    public final i a(short s2, String str) {
        a(str);
        StringBuilder sb2 = this.f39895a;
        sb2.append((int) s2);
        sb2.append('\n');
        return this;
    }

    public final i a(boolean z10, String str) {
        a(str);
        StringBuilder sb2 = this.f39895a;
        sb2.append(z10 ? 'T' : 'F');
        sb2.append('\n');
        return this;
    }

    public final i a(byte[] bArr, String str) {
        a(str);
        if (bArr == null) {
            this.f39895a.append("null\n");
            return this;
        }
        if (bArr.length == 0) {
            StringBuilder sb2 = this.f39895a;
            sb2.append(bArr.length);
            sb2.append(", []\n");
            return this;
        }
        StringBuilder sb3 = this.f39895a;
        sb3.append(bArr.length);
        sb3.append(", [\n");
        i iVar = new i(this.f39895a, this.f39896b + 1);
        for (byte b4 : bArr) {
            iVar.a(b4, (String) null);
        }
        a(']', (String) null);
        return this;
    }
}
