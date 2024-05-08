package com.tencent.bugly.proguard;

import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    private StringBuilder f40138a;

    /* renamed from: b, reason: collision with root package name */
    private int f40139b;

    public h(StringBuilder sb2, int i10) {
        this.f40138a = sb2;
        this.f40139b = i10;
    }

    private void a(String str) {
        for (int i10 = 0; i10 < this.f40139b; i10++) {
            this.f40138a.append('\t');
        }
        if (str != null) {
            StringBuilder sb2 = this.f40138a;
            sb2.append(str);
            sb2.append(": ");
        }
    }

    public final h a(boolean z10, String str) {
        a(str);
        StringBuilder sb2 = this.f40138a;
        sb2.append(z10 ? 'T' : 'F');
        sb2.append('\n');
        return this;
    }

    public final h a(byte b4, String str) {
        a(str);
        StringBuilder sb2 = this.f40138a;
        sb2.append((int) b4);
        sb2.append('\n');
        return this;
    }

    public final h a(short s2, String str) {
        a(str);
        StringBuilder sb2 = this.f40138a;
        sb2.append((int) s2);
        sb2.append('\n');
        return this;
    }

    public final h a(int i10, String str) {
        a(str);
        StringBuilder sb2 = this.f40138a;
        sb2.append(i10);
        sb2.append('\n');
        return this;
    }

    public final h a(long j10, String str) {
        a(str);
        StringBuilder sb2 = this.f40138a;
        sb2.append(j10);
        sb2.append('\n');
        return this;
    }

    public final h a(String str, String str2) {
        a(str2);
        if (str == null) {
            this.f40138a.append("null\n");
        } else {
            StringBuilder sb2 = this.f40138a;
            sb2.append(str);
            sb2.append('\n');
        }
        return this;
    }

    public final h a(byte[] bArr, String str) {
        a(str);
        if (bArr == null) {
            this.f40138a.append("null\n");
            return this;
        }
        if (bArr.length == 0) {
            StringBuilder sb2 = this.f40138a;
            sb2.append(bArr.length);
            sb2.append(", []\n");
            return this;
        }
        StringBuilder sb3 = this.f40138a;
        sb3.append(bArr.length);
        sb3.append(", [\n");
        h hVar = new h(this.f40138a, this.f40139b + 1);
        for (byte b4 : bArr) {
            hVar.a(null);
            StringBuilder sb4 = hVar.f40138a;
            sb4.append((int) b4);
            sb4.append('\n');
        }
        a(null);
        StringBuilder sb5 = this.f40138a;
        sb5.append(']');
        sb5.append('\n');
        return this;
    }

    public final <K, V> h a(Map<K, V> map, String str) {
        a(str);
        if (map == null) {
            this.f40138a.append("null\n");
            return this;
        }
        if (map.isEmpty()) {
            StringBuilder sb2 = this.f40138a;
            sb2.append(map.size());
            sb2.append(", {}\n");
            return this;
        }
        StringBuilder sb3 = this.f40138a;
        sb3.append(map.size());
        sb3.append(", {\n");
        h hVar = new h(this.f40138a, this.f40139b + 1);
        h hVar2 = new h(this.f40138a, this.f40139b + 2);
        for (Map.Entry<K, V> entry : map.entrySet()) {
            hVar.a(null);
            StringBuilder sb4 = hVar.f40138a;
            sb4.append('(');
            sb4.append('\n');
            hVar2.a((h) entry.getKey(), (String) null);
            hVar2.a((h) entry.getValue(), (String) null);
            hVar.a(null);
            StringBuilder sb5 = hVar.f40138a;
            sb5.append(')');
            sb5.append('\n');
        }
        a(null);
        StringBuilder sb6 = this.f40138a;
        sb6.append('}');
        sb6.append('\n');
        return this;
    }

    private <T> h a(T[] tArr, String str) {
        a(str);
        if (tArr == null) {
            this.f40138a.append("null\n");
            return this;
        }
        if (tArr.length == 0) {
            StringBuilder sb2 = this.f40138a;
            sb2.append(tArr.length);
            sb2.append(", []\n");
            return this;
        }
        StringBuilder sb3 = this.f40138a;
        sb3.append(tArr.length);
        sb3.append(", [\n");
        h hVar = new h(this.f40138a, this.f40139b + 1);
        for (T t2 : tArr) {
            hVar.a((h) t2, (String) null);
        }
        a(null);
        StringBuilder sb4 = this.f40138a;
        sb4.append(']');
        sb4.append('\n');
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> h a(T t2, String str) {
        if (t2 == 0) {
            this.f40138a.append("null\n");
        } else if (t2 instanceof Byte) {
            byte byteValue = ((Byte) t2).byteValue();
            a(str);
            StringBuilder sb2 = this.f40138a;
            sb2.append((int) byteValue);
            sb2.append('\n');
        } else if (t2 instanceof Boolean) {
            boolean booleanValue = ((Boolean) t2).booleanValue();
            a(str);
            StringBuilder sb3 = this.f40138a;
            sb3.append(booleanValue ? 'T' : 'F');
            sb3.append('\n');
        } else if (t2 instanceof Short) {
            short shortValue = ((Short) t2).shortValue();
            a(str);
            StringBuilder sb4 = this.f40138a;
            sb4.append((int) shortValue);
            sb4.append('\n');
        } else if (t2 instanceof Integer) {
            int intValue = ((Integer) t2).intValue();
            a(str);
            StringBuilder sb5 = this.f40138a;
            sb5.append(intValue);
            sb5.append('\n');
        } else if (t2 instanceof Long) {
            long longValue = ((Long) t2).longValue();
            a(str);
            StringBuilder sb6 = this.f40138a;
            sb6.append(longValue);
            sb6.append('\n');
        } else if (t2 instanceof Float) {
            float floatValue = ((Float) t2).floatValue();
            a(str);
            StringBuilder sb7 = this.f40138a;
            sb7.append(floatValue);
            sb7.append('\n');
        } else if (t2 instanceof Double) {
            double doubleValue = ((Double) t2).doubleValue();
            a(str);
            StringBuilder sb8 = this.f40138a;
            sb8.append(doubleValue);
            sb8.append('\n');
        } else if (t2 instanceof String) {
            a((String) t2, str);
        } else if (t2 instanceof Map) {
            a((Map) t2, str);
        } else if (t2 instanceof List) {
            a(((List) t2).toArray(), str);
        } else if (t2 instanceof k) {
            a((k) t2, str);
        } else if (t2 instanceof byte[]) {
            a((byte[]) t2, str);
        } else if (t2 instanceof boolean[]) {
            a((h) t2, str);
        } else {
            int i10 = 0;
            if (t2 instanceof short[]) {
                short[] sArr = (short[]) t2;
                a(str);
                if (sArr.length == 0) {
                    StringBuilder sb9 = this.f40138a;
                    sb9.append(sArr.length);
                    sb9.append(", []\n");
                } else {
                    StringBuilder sb10 = this.f40138a;
                    sb10.append(sArr.length);
                    sb10.append(", [\n");
                    h hVar = new h(this.f40138a, this.f40139b + 1);
                    int length = sArr.length;
                    while (i10 < length) {
                        short s2 = sArr[i10];
                        hVar.a(null);
                        StringBuilder sb11 = hVar.f40138a;
                        sb11.append((int) s2);
                        sb11.append('\n');
                        i10++;
                    }
                    a(null);
                    StringBuilder sb12 = this.f40138a;
                    sb12.append(']');
                    sb12.append('\n');
                }
            } else if (t2 instanceof int[]) {
                int[] iArr = (int[]) t2;
                a(str);
                if (iArr.length == 0) {
                    StringBuilder sb13 = this.f40138a;
                    sb13.append(iArr.length);
                    sb13.append(", []\n");
                } else {
                    StringBuilder sb14 = this.f40138a;
                    sb14.append(iArr.length);
                    sb14.append(", [\n");
                    h hVar2 = new h(this.f40138a, this.f40139b + 1);
                    int length2 = iArr.length;
                    while (i10 < length2) {
                        int i11 = iArr[i10];
                        hVar2.a(null);
                        StringBuilder sb15 = hVar2.f40138a;
                        sb15.append(i11);
                        sb15.append('\n');
                        i10++;
                    }
                    a(null);
                    StringBuilder sb16 = this.f40138a;
                    sb16.append(']');
                    sb16.append('\n');
                }
            } else if (t2 instanceof long[]) {
                long[] jArr = (long[]) t2;
                a(str);
                if (jArr.length == 0) {
                    StringBuilder sb17 = this.f40138a;
                    sb17.append(jArr.length);
                    sb17.append(", []\n");
                } else {
                    StringBuilder sb18 = this.f40138a;
                    sb18.append(jArr.length);
                    sb18.append(", [\n");
                    h hVar3 = new h(this.f40138a, this.f40139b + 1);
                    int length3 = jArr.length;
                    while (i10 < length3) {
                        long j10 = jArr[i10];
                        hVar3.a(null);
                        StringBuilder sb19 = hVar3.f40138a;
                        sb19.append(j10);
                        sb19.append('\n');
                        i10++;
                    }
                    a(null);
                    StringBuilder sb20 = this.f40138a;
                    sb20.append(']');
                    sb20.append('\n');
                }
            } else if (t2 instanceof float[]) {
                float[] fArr = (float[]) t2;
                a(str);
                if (fArr.length == 0) {
                    StringBuilder sb21 = this.f40138a;
                    sb21.append(fArr.length);
                    sb21.append(", []\n");
                } else {
                    StringBuilder sb22 = this.f40138a;
                    sb22.append(fArr.length);
                    sb22.append(", [\n");
                    h hVar4 = new h(this.f40138a, this.f40139b + 1);
                    int length4 = fArr.length;
                    while (i10 < length4) {
                        float f10 = fArr[i10];
                        hVar4.a(null);
                        StringBuilder sb23 = hVar4.f40138a;
                        sb23.append(f10);
                        sb23.append('\n');
                        i10++;
                    }
                    a(null);
                    StringBuilder sb24 = this.f40138a;
                    sb24.append(']');
                    sb24.append('\n');
                }
            } else if (t2 instanceof double[]) {
                double[] dArr = (double[]) t2;
                a(str);
                if (dArr.length == 0) {
                    StringBuilder sb25 = this.f40138a;
                    sb25.append(dArr.length);
                    sb25.append(", []\n");
                } else {
                    StringBuilder sb26 = this.f40138a;
                    sb26.append(dArr.length);
                    sb26.append(", [\n");
                    h hVar5 = new h(this.f40138a, this.f40139b + 1);
                    int length5 = dArr.length;
                    while (i10 < length5) {
                        double d10 = dArr[i10];
                        hVar5.a(null);
                        StringBuilder sb27 = hVar5.f40138a;
                        sb27.append(d10);
                        sb27.append('\n');
                        i10++;
                    }
                    a(null);
                    StringBuilder sb28 = this.f40138a;
                    sb28.append(']');
                    sb28.append('\n');
                }
            } else if (t2.getClass().isArray()) {
                a((Object[]) t2, str);
            } else {
                throw new b("write object error: unsupport type.");
            }
        }
        return this;
    }

    public final h a(k kVar, String str) {
        a(str);
        StringBuilder sb2 = this.f40138a;
        sb2.append('{');
        sb2.append('\n');
        if (kVar == null) {
            StringBuilder sb3 = this.f40138a;
            sb3.append('\t');
            sb3.append("null");
        } else {
            kVar.a(this.f40138a, this.f40139b + 1);
        }
        a(null);
        StringBuilder sb4 = this.f40138a;
        sb4.append('}');
        sb4.append('\n');
        return this;
    }
}
