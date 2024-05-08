package com.xiaomi.push;

import java.nio.ByteBuffer;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class p6 {

    /* renamed from: a, reason: collision with root package name */
    public static final Comparator f48080a = new a();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class a implements Comparator {
        public a() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            if (obj == null && obj2 == null) {
                return 0;
            }
            if (obj == null) {
                return -1;
            }
            if (obj2 == null) {
                return 1;
            }
            return obj instanceof List ? p6.g((List) obj, (List) obj2) : obj instanceof Set ? p6.i((Set) obj, (Set) obj2) : obj instanceof Map ? p6.h((Map) obj, (Map) obj2) : obj instanceof byte[] ? p6.l((byte[]) obj, (byte[]) obj2) : p6.d((Comparable) obj, (Comparable) obj2);
        }
    }

    public static int a(byte b4, byte b10) {
        if (b4 < b10) {
            return -1;
        }
        return b10 < b4 ? 1 : 0;
    }

    public static int b(int i10, int i11) {
        if (i10 < i11) {
            return -1;
        }
        return i11 < i10 ? 1 : 0;
    }

    public static int c(long j10, long j11) {
        if (j10 < j11) {
            return -1;
        }
        return j11 < j10 ? 1 : 0;
    }

    public static int d(Comparable comparable, Comparable comparable2) {
        return comparable.compareTo(comparable2);
    }

    public static int e(String str, String str2) {
        return str.compareTo(str2);
    }

    public static int f(ByteBuffer byteBuffer, byte[] bArr, int i10) {
        int remaining = byteBuffer.remaining();
        System.arraycopy((Object) byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), (Object) bArr, i10, remaining);
        return remaining;
    }

    public static int g(List list, List list2) {
        int b4 = b(list.size(), list2.size());
        if (b4 != 0) {
            return b4;
        }
        for (int i10 = 0; i10 < list.size(); i10++) {
            int compare = f48080a.compare(list.get(i10), list2.get(i10));
            if (compare != 0) {
                return compare;
            }
        }
        return 0;
    }

    public static int h(Map map, Map map2) {
        int b4 = b(map.size(), map2.size());
        if (b4 != 0) {
            return b4;
        }
        Comparator comparator = f48080a;
        TreeMap treeMap = new TreeMap(comparator);
        treeMap.putAll(map);
        Iterator iterator2 = treeMap.entrySet().iterator2();
        TreeMap treeMap2 = new TreeMap(comparator);
        treeMap2.putAll(map2);
        Iterator iterator22 = treeMap2.entrySet().iterator2();
        while (iterator2.hasNext() && iterator22.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator2.next();
            Map.Entry entry2 = (Map.Entry) iterator22.next();
            Comparator comparator2 = f48080a;
            int compare = comparator2.compare(entry.getKey(), entry2.getKey());
            if (compare != 0) {
                return compare;
            }
            int compare2 = comparator2.compare(entry.getValue(), entry2.getValue());
            if (compare2 != 0) {
                return compare2;
            }
        }
        return 0;
    }

    public static int i(Set set, Set set2) {
        int b4 = b(set.size(), set2.size());
        if (b4 != 0) {
            return b4;
        }
        Comparator comparator = f48080a;
        TreeSet treeSet = new TreeSet(comparator);
        treeSet.addAll(set);
        TreeSet treeSet2 = new TreeSet(comparator);
        treeSet2.addAll(set2);
        Iterator<E> it = treeSet.iterator2();
        Iterator<E> it2 = treeSet2.iterator2();
        while (it.hasNext() && it2.hasNext()) {
            int compare = f48080a.compare(it.next(), it2.next());
            if (compare != 0) {
                return compare;
            }
        }
        return 0;
    }

    public static int j(short s2, short s10) {
        if (s2 < s10) {
            return -1;
        }
        return s10 < s2 ? 1 : 0;
    }

    public static int k(boolean z10, boolean z11) {
        return Boolean.valueOf(z10).compareTo(Boolean.valueOf(z11));
    }

    public static int l(byte[] bArr, byte[] bArr2) {
        int b4 = b(bArr.length, bArr2.length);
        if (b4 != 0) {
            return b4;
        }
        for (int i10 = 0; i10 < bArr.length; i10++) {
            int a10 = a(bArr[i10], bArr2[i10]);
            if (a10 != 0) {
                return a10;
            }
        }
        return 0;
    }

    public static String m(byte b4) {
        return Integer.toHexString((b4 | 256) & 511).toUpperCase().substring(1);
    }

    public static ByteBuffer n(ByteBuffer byteBuffer) {
        return p(byteBuffer) ? byteBuffer : ByteBuffer.wrap(q(byteBuffer));
    }

    public static void o(ByteBuffer byteBuffer, StringBuilder sb2) {
        byte[] array = byteBuffer.array();
        int arrayOffset = byteBuffer.arrayOffset();
        int limit = byteBuffer.limit();
        int i10 = limit - arrayOffset > 128 ? arrayOffset + 128 : limit;
        for (int i11 = arrayOffset; i11 < i10; i11++) {
            if (i11 > arrayOffset) {
                sb2.append(" ");
            }
            sb2.append(m(array[i11]));
        }
        if (limit != i10) {
            sb2.append("...");
        }
    }

    public static boolean p(ByteBuffer byteBuffer) {
        return byteBuffer.hasArray() && byteBuffer.position() == 0 && byteBuffer.arrayOffset() == 0 && byteBuffer.remaining() == byteBuffer.capacity();
    }

    public static byte[] q(ByteBuffer byteBuffer) {
        if (p(byteBuffer)) {
            return byteBuffer.array();
        }
        byte[] bArr = new byte[byteBuffer.remaining()];
        f(byteBuffer, bArr, 0);
        return bArr;
    }
}
