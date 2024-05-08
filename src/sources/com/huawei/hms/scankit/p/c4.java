package com.huawei.hms.scankit.p;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

/* compiled from: HighLevelEncoder.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class c4 {

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f30798b = {"UPPER", "LOWER", "DIGIT", "MIXED", "PUNCT"};

    /* renamed from: c, reason: collision with root package name */
    public static final int[][] f30799c = {new int[]{0, 327708, 327710, 327709, 656318}, new int[]{590318, 0, 327710, 327709, 656318}, new int[]{262158, 590300, 0, 590301, 932798}, new int[]{327709, 327708, 656318, 0, 327710}, new int[]{327711, 656380, 656382, 656381, 0}};

    /* renamed from: d, reason: collision with root package name */
    private static final int[][] f30800d;

    /* renamed from: e, reason: collision with root package name */
    public static final int[][] f30801e;

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f30802a;

    /* compiled from: HighLevelEncoder.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a<State> implements Comparator<b7> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(b7 b7Var, b7 b7Var2) {
            return b7Var.b() - b7Var2.b();
        }
    }

    static {
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) int.class, 5, 256);
        f30800d = iArr;
        iArr[0][32] = 1;
        for (int i10 = 65; i10 <= 90; i10++) {
            f30800d[0][i10] = (i10 - 65) + 2;
        }
        f30800d[1][32] = 1;
        for (int i11 = 97; i11 <= 122; i11++) {
            f30800d[1][i11] = (i11 - 97) + 2;
        }
        f30800d[2][32] = 1;
        for (int i12 = 48; i12 <= 57; i12++) {
            f30800d[2][i12] = (i12 - 48) + 2;
        }
        int[][] iArr2 = f30800d;
        iArr2[2][44] = 12;
        iArr2[2][46] = 13;
        int[] iArr3 = {0, 32, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 27, 28, 29, 30, 31, 64, 92, 94, 95, 96, 124, 126, 127};
        for (int i13 = 0; i13 < 28; i13++) {
            f30800d[3][iArr3[i13]] = i13;
        }
        int[] iArr4 = {0, 13, 0, 0, 0, 0, 33, 39, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 58, 59, 60, 61, 62, 63, 91, 93, 123, 125};
        for (int i14 = 0; i14 < 31; i14++) {
            if (iArr4[i14] > 0) {
                f30800d[4][iArr4[i14]] = i14;
            }
        }
        int[][] iArr5 = (int[][]) Array.newInstance((Class<?>) int.class, 6, 6);
        f30801e = iArr5;
        for (int[] iArr6 : iArr5) {
            Arrays.fill(iArr6, -1);
        }
        try {
            int[][] iArr7 = f30801e;
            if (w7.a(iArr7, 0) && w7.a(iArr7[0], 4)) {
                iArr7[0][4] = 0;
            }
            if (w7.a(iArr7, 1) && w7.a(iArr7[1], 4)) {
                iArr7[1][4] = 0;
            }
            if (w7.a(iArr7, 1) && w7.a(iArr7[1], 0)) {
                iArr7[1][0] = 28;
            }
            if (w7.a(iArr7, 3) && w7.a(iArr7[3], 4)) {
                iArr7[3][4] = 0;
            }
            if (w7.a(iArr7, 2) && w7.a(iArr7[2], 4)) {
                iArr7[2][4] = 0;
            }
            if (w7.a(iArr7, 2) && w7.a(iArr7[2], 0)) {
                iArr7[2][0] = 15;
            }
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw e2;
        }
    }

    public c4(byte[] bArr) {
        this.f30802a = bArr;
    }

    public r a() {
        int i10;
        Collection<b7> singletonList = Collections.singletonList(b7.f30758e);
        int i11 = 0;
        while (true) {
            byte[] bArr = this.f30802a;
            if (i11 < bArr.length) {
                int i12 = i11 + 1;
                byte b4 = i12 < bArr.length ? bArr[i12] : (byte) 0;
                byte b10 = bArr[i11];
                if (b10 == 13) {
                    if (b4 == 10) {
                        i10 = 2;
                    }
                    i10 = 0;
                } else if (b10 == 44) {
                    if (b4 == 32) {
                        i10 = 4;
                    }
                    i10 = 0;
                } else if (b10 != 46) {
                    if (b10 == 58 && b4 == 32) {
                        i10 = 5;
                    }
                    i10 = 0;
                } else {
                    if (b4 == 32) {
                        i10 = 3;
                    }
                    i10 = 0;
                }
                if (i10 > 0) {
                    singletonList = a(singletonList, i11, i10);
                    i11 = i12;
                } else {
                    singletonList = a(singletonList, i11);
                }
                i11++;
            } else {
                return ((b7) Collections.min(singletonList, new a())).a(this.f30802a);
            }
        }
    }

    private Collection<b7> a(Iterable<b7> iterable, int i10) {
        LinkedList linkedList = new LinkedList();
        Iterator<b7> iterator2 = iterable.iterator2();
        while (iterator2.hasNext()) {
            a(iterator2.next(), i10, linkedList);
        }
        return a(linkedList);
    }

    private void a(b7 b7Var, int i10, Collection<b7> collection) {
        if (w7.a(this.f30802a, i10)) {
            char c4 = (char) (this.f30802a[i10] & 255);
            int[][] iArr = f30800d;
            boolean z10 = w7.a(iArr, b7Var.c()) && w7.a(iArr[b7Var.c()], (int) c4) && iArr[b7Var.c()][c4] > 0;
            b7 b7Var2 = null;
            for (int i11 = 0; i11 <= 4; i11++) {
                int[][] iArr2 = f30800d;
                int i12 = (w7.a(iArr2, i11) && w7.a(iArr2[i11], (int) c4)) ? iArr2[i11][c4] : 0;
                if (i12 > 0) {
                    if (b7Var2 == null) {
                        b7Var2 = b7Var.b(i10);
                    }
                    if (!z10 || i11 == b7Var.c() || i11 == 2) {
                        collection.add(b7Var2.a(i11, i12));
                    }
                    if (!z10 && f30801e[b7Var.c()][i11] >= 0) {
                        collection.add(b7Var2.b(i11, i12));
                    }
                }
            }
            int[][] iArr3 = f30800d;
            if (w7.a(iArr3, b7Var.c()) && w7.a(iArr3[b7Var.c()], (int) c4)) {
                if (b7Var.a() > 0 || iArr3[b7Var.c()][c4] == 0) {
                    collection.add(b7Var.a(i10));
                }
            }
        }
    }

    private static Collection<b7> a(Iterable<b7> iterable, int i10, int i11) {
        LinkedList linkedList = new LinkedList();
        Iterator<b7> iterator2 = iterable.iterator2();
        while (iterator2.hasNext()) {
            a(iterator2.next(), i10, i11, linkedList);
        }
        return a(linkedList);
    }

    private static void a(b7 b7Var, int i10, int i11, Collection<b7> collection) {
        b7 b4 = b7Var.b(i10);
        collection.add(b4.a(4, i11));
        if (b7Var.c() != 4) {
            collection.add(b4.b(4, i11));
        }
        if (i11 == 3 || i11 == 4) {
            collection.add(b4.a(2, 16 - i11).a(2, 1));
        }
        if (b7Var.a() > 0) {
            collection.add(b7Var.a(i10).a(i10 + 1));
        }
    }

    private static Collection<b7> a(Iterable<b7> iterable) {
        LinkedList linkedList = new LinkedList();
        for (b7 b7Var : iterable) {
            boolean z10 = true;
            Iterator<E> iterator2 = linkedList.iterator2();
            while (true) {
                if (!iterator2.hasNext()) {
                    break;
                }
                b7 b7Var2 = (b7) iterator2.next();
                if (b7Var2.a(b7Var)) {
                    z10 = false;
                    break;
                }
                if (b7Var.a(b7Var2)) {
                    iterator2.remove();
                }
            }
            if (z10) {
                linkedList.add(b7Var);
            }
        }
        return linkedList;
    }
}
