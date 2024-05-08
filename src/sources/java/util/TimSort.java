package java.util;

import java.lang.reflect.Array;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class TimSort<T> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int INITIAL_TMP_STORAGE_LENGTH = 256;
    private static final int MIN_GALLOP = 7;
    private static final int MIN_MERGE = 32;

    /* renamed from: a, reason: collision with root package name */
    private final T[] f50483a;

    /* renamed from: c, reason: collision with root package name */
    private final Comparator<? super T> f50484c;
    private final int[] runBase;
    private final int[] runLen;
    private T[] tmp;
    private int tmpBase;
    private int tmpLen;
    private int minGallop = 7;
    private int stackSize = 0;

    private TimSort(T[] tArr, Comparator<? super T> comparator, T[] tArr2, int i10, int i11) {
        int i12;
        this.f50483a = tArr;
        this.f50484c = comparator;
        int length = tArr.length;
        int i13 = length < 512 ? length >>> 1 : 256;
        if (tArr2 == null || i11 < i13 || i10 + i13 > tArr2.length) {
            this.tmp = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i13));
            this.tmpBase = 0;
            this.tmpLen = i13;
        } else {
            this.tmp = tArr2;
            this.tmpBase = i10;
            this.tmpLen = i11;
        }
        if (length < 120) {
            i12 = 5;
        } else if (length < 1542) {
            i12 = 10;
        } else {
            i12 = length < 119151 ? 24 : 49;
        }
        this.runBase = new int[i12];
        this.runLen = new int[i12];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> void sort(T[] a10, int lo, int hi, Comparator<? super T> c4, T[] work, int workBase, int workLen) {
        int nRemaining = hi - lo;
        if (nRemaining < 2) {
            return;
        }
        if (nRemaining < 32) {
            int initRunLen = countRunAndMakeAscending(a10, lo, hi, c4);
            binarySort(a10, lo, hi, lo + initRunLen, c4);
            return;
        }
        TimSort<T> ts = new TimSort<>(a10, c4, work, workBase, workLen);
        int minRun = minRunLength(nRemaining);
        do {
            int runLen = countRunAndMakeAscending(a10, lo, hi, c4);
            if (runLen < minRun) {
                int force = nRemaining <= minRun ? nRemaining : minRun;
                binarySort(a10, lo, lo + force, lo + runLen, c4);
                runLen = force;
            }
            ts.pushRun(lo, runLen);
            ts.mergeCollapse();
            lo += runLen;
            nRemaining -= runLen;
        } while (nRemaining != 0);
        ts.mergeForceCollapse();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:18:0x0022. Please report as an issue. */
    private static <T> void binarySort(T[] a10, int lo, int hi, int start, Comparator<? super T> c4) {
        if (start == lo) {
            start++;
        }
        while (start < hi) {
            T pivot = a10[start];
            int left = lo;
            int right = start;
            while (left < right) {
                int mid = (left + right) >>> 1;
                if (c4.compare(pivot, a10[mid]) < 0) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            int n10 = start - left;
            switch (n10) {
                case 2:
                    a10[left + 2] = a10[left + 1];
                case 1:
                    a10[left + 1] = a10[left];
                    break;
                default:
                    System.arraycopy(a10, left, a10, left + 1, n10);
                    break;
            }
            a10[left] = pivot;
            start++;
        }
    }

    private static <T> int countRunAndMakeAscending(T[] a10, int lo, int hi, Comparator<? super T> c4) {
        int runHi = lo + 1;
        if (runHi == hi) {
            return 1;
        }
        int runHi2 = runHi + 1;
        if (c4.compare(a10[runHi], a10[lo]) < 0) {
            while (runHi2 < hi && c4.compare(a10[runHi2], a10[runHi2 - 1]) < 0) {
                runHi2++;
            }
            reverseRange(a10, lo, runHi2);
        } else {
            while (runHi2 < hi && c4.compare(a10[runHi2], a10[runHi2 - 1]) >= 0) {
                runHi2++;
            }
        }
        return runHi2 - lo;
    }

    private static void reverseRange(Object[] a10, int hi, int hi2) {
        int hi3 = hi2 - 1;
        while (hi < hi3) {
            Object t2 = a10[hi];
            int lo = hi + 1;
            a10[hi] = a10[hi3];
            a10[hi3] = t2;
            hi3--;
            hi = lo;
        }
    }

    private static int minRunLength(int n10) {
        int r10 = 0;
        while (n10 >= 32) {
            r10 |= n10 & 1;
            n10 >>= 1;
        }
        return n10 + r10;
    }

    private void pushRun(int runBase, int runLen) {
        int[] iArr = this.runBase;
        int i10 = this.stackSize;
        iArr[i10] = runBase;
        this.runLen[i10] = runLen;
        this.stackSize = i10 + 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0028, code lost:
    
        if (r1[r0 - 2] <= (r1[r0] + r1[r0 - 1])) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0017, code lost:
    
        if (r2[r0 - 1] > (r2[r0] + r2[r0 + 1])) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x002a, code lost:
    
        r1 = r6.runLen;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0034, code lost:
    
        if (r1[r0 - 1] >= r1[r0 + 1]) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0036, code lost:
    
        r0 = r0 - 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void mergeCollapse() {
        /*
            r6 = this;
        L1:
            int r0 = r6.stackSize
            r1 = 1
            if (r0 <= r1) goto L4a
            int r0 = r0 + (-2)
            if (r0 <= 0) goto L19
            int[] r2 = r6.runLen
            int r3 = r0 + (-1)
            r3 = r2[r3]
            r4 = r2[r0]
            int r5 = r0 + 1
            r2 = r2[r5]
            int r4 = r4 + r2
            if (r3 <= r4) goto L2a
        L19:
            if (r0 <= r1) goto L39
            int[] r1 = r6.runLen
            int r2 = r0 + (-2)
            r2 = r1[r2]
            r3 = r1[r0]
            int r4 = r0 + (-1)
            r1 = r1[r4]
            int r3 = r3 + r1
            if (r2 > r3) goto L39
        L2a:
            int[] r1 = r6.runLen
            int r2 = r0 + (-1)
            r2 = r1[r2]
            int r3 = r0 + 1
            r1 = r1[r3]
            if (r2 >= r1) goto L46
            int r0 = r0 + (-1)
            goto L46
        L39:
            if (r0 < 0) goto L4a
            int[] r1 = r6.runLen
            r2 = r1[r0]
            int r3 = r0 + 1
            r1 = r1[r3]
            if (r2 <= r1) goto L46
            goto L4a
        L46:
            r6.mergeAt(r0)
            goto L1
        L4a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.TimSort.mergeCollapse():void");
    }

    private void mergeForceCollapse() {
        while (true) {
            int i10 = this.stackSize;
            if (i10 > 1) {
                int n10 = i10 - 2;
                if (n10 > 0) {
                    int[] iArr = this.runLen;
                    if (iArr[n10 - 1] < iArr[n10 + 1]) {
                        n10--;
                    }
                }
                mergeAt(n10);
            } else {
                return;
            }
        }
    }

    private void mergeAt(int i10) {
        int[] iArr = this.runBase;
        int base1 = iArr[i10];
        int[] iArr2 = this.runLen;
        int len1 = iArr2[i10];
        int base2 = iArr[i10 + 1];
        int len2 = iArr2[i10 + 1];
        iArr2[i10] = len1 + len2;
        int i11 = this.stackSize;
        if (i10 == i11 - 3) {
            iArr[i10 + 1] = iArr[i10 + 2];
            iArr2[i10 + 1] = iArr2[i10 + 2];
        }
        this.stackSize = i11 - 1;
        T[] tArr = this.f50483a;
        int k10 = gallopRight(tArr[base2], tArr, base1, len1, 0, this.f50484c);
        int base12 = base1 + k10;
        int len12 = len1 - k10;
        if (len12 == 0) {
            return;
        }
        T[] tArr2 = this.f50483a;
        int len22 = gallopLeft(tArr2[(base12 + len12) - 1], tArr2, base2, len2, len2 - 1, this.f50484c);
        if (len22 == 0) {
            return;
        }
        if (len12 <= len22) {
            mergeLo(base12, len12, base2, len22);
        } else {
            mergeHi(base12, len12, base2, len22);
        }
    }

    private static <T> int gallopLeft(T key, T[] a10, int base, int len, int hint, Comparator<? super T> c4) {
        int lastOfs;
        int ofs;
        int lastOfs2 = 0;
        int ofs2 = 1;
        if (c4.compare(key, a10[base + hint]) > 0) {
            int maxOfs = len - hint;
            while (ofs2 < maxOfs && c4.compare(key, a10[base + hint + ofs2]) > 0) {
                lastOfs2 = ofs2;
                ofs2 = (ofs2 << 1) + 1;
                if (ofs2 <= 0) {
                    ofs2 = maxOfs;
                }
            }
            if (ofs2 > maxOfs) {
                ofs2 = maxOfs;
            }
            lastOfs = lastOfs2 + hint;
            ofs = ofs2 + hint;
        } else {
            int maxOfs2 = hint + 1;
            while (ofs2 < maxOfs2 && c4.compare(key, a10[(base + hint) - ofs2]) <= 0) {
                lastOfs2 = ofs2;
                ofs2 = (ofs2 << 1) + 1;
                if (ofs2 <= 0) {
                    ofs2 = maxOfs2;
                }
            }
            if (ofs2 > maxOfs2) {
                ofs2 = maxOfs2;
            }
            int tmp = lastOfs2;
            lastOfs = hint - ofs2;
            ofs = hint - tmp;
        }
        int lastOfs3 = lastOfs + 1;
        while (lastOfs3 < ofs) {
            int m10 = ((ofs - lastOfs3) >>> 1) + lastOfs3;
            if (c4.compare(key, a10[base + m10]) > 0) {
                lastOfs3 = m10 + 1;
            } else {
                ofs = m10;
            }
        }
        return ofs;
    }

    private static <T> int gallopRight(T key, T[] a10, int base, int len, int hint, Comparator<? super T> c4) {
        int lastOfs;
        int ofs;
        int ofs2 = 1;
        int lastOfs2 = 0;
        if (c4.compare(key, a10[base + hint]) < 0) {
            int maxOfs = hint + 1;
            while (ofs2 < maxOfs && c4.compare(key, a10[(base + hint) - ofs2]) < 0) {
                lastOfs2 = ofs2;
                ofs2 = (ofs2 << 1) + 1;
                if (ofs2 <= 0) {
                    ofs2 = maxOfs;
                }
            }
            if (ofs2 > maxOfs) {
                ofs2 = maxOfs;
            }
            int tmp = lastOfs2;
            lastOfs = hint - ofs2;
            ofs = hint - tmp;
        } else {
            int maxOfs2 = len - hint;
            while (ofs2 < maxOfs2 && c4.compare(key, a10[base + hint + ofs2]) >= 0) {
                lastOfs2 = ofs2;
                ofs2 = (ofs2 << 1) + 1;
                if (ofs2 <= 0) {
                    ofs2 = maxOfs2;
                }
            }
            if (ofs2 > maxOfs2) {
                ofs2 = maxOfs2;
            }
            lastOfs = lastOfs2 + hint;
            ofs = ofs2 + hint;
        }
        int lastOfs3 = lastOfs + 1;
        while (lastOfs3 < ofs) {
            int m10 = ((ofs - lastOfs3) >>> 1) + lastOfs3;
            if (c4.compare(key, a10[base + m10]) < 0) {
                ofs = m10;
            } else {
                lastOfs3 = m10 + 1;
            }
        }
        return ofs;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0074, code lost:
    
        r14 = r3;
        r15 = r4;
        r16 = r6;
        r12 = r1;
        r13 = r2;
        r6 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x007f, code lost:
    
        r10 = r6;
        r6 = gallopRight(r7[r16], r8, r13, r12, 0, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x008c, code lost:
    
        if (r6 == 0) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x008e, code lost:
    
        java.lang.System.arraycopy(r8, r13, r7, r10, r6);
        r1 = r10 + r6;
        r2 = r13 + r6;
        r3 = r12 - r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0098, code lost:
    
        if (r3 > 1) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00a6, code lost:
    
        r13 = r2;
        r12 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00aa, code lost:
    
        r10 = r1 + 1;
        r5 = r16 + 1;
        r7[r1] = r7[r16];
        r14 = r14 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00b4, code lost:
    
        if (r14 != 0) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00be, code lost:
    
        r1 = gallopLeft(r8[r13], r7, r5, r14, 0, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00cf, code lost:
    
        if (r1 == 0) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00d1, code lost:
    
        java.lang.System.arraycopy(r7, r5, r7, r10, r1);
        r2 = r10 + r1;
        r6 = r5 + r1;
        r3 = r14 - r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00da, code lost:
    
        if (r3 != 0) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00e2, code lost:
    
        r10 = r2;
        r14 = r3;
        r16 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00e9, code lost:
    
        r6 = r10 + 1;
        r2 = r13 + 1;
        r7[r10] = r8[r13];
        r12 = r12 - 1;
        r9 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00f4, code lost:
    
        if (r12 != 1) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0120, code lost:
    
        r15 = r15 - 1;
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0126, code lost:
    
        if (r6 < 7) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0128, code lost:
    
        r10 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x012b, code lost:
    
        if (r1 < 7) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x012d, code lost:
    
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0130, code lost:
    
        if ((r10 | r4) != false) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0142, code lost:
    
        r13 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0132, code lost:
    
        if (r15 >= 0) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0134, code lost:
    
        r15 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x012a, code lost:
    
        r10 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00f6, code lost:
    
        r1 = r12;
        r3 = r14;
        r4 = r15;
        r14 = r6;
        r6 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00dc, code lost:
    
        r14 = r2;
        r1 = r12;
        r2 = r13;
        r4 = r15;
        r9 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00e7, code lost:
    
        r16 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00b6, code lost:
    
        r6 = r5;
        r1 = r12;
        r2 = r13;
        r3 = r14;
        r4 = r15;
        r9 = 1;
        r14 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x009a, code lost:
    
        r4 = r15;
        r6 = r16;
        r9 = 1;
        r20 = r14;
        r14 = r1;
        r1 = r3;
        r3 = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00a9, code lost:
    
        r1 = r10;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x014c A[LOOP:1: B:12:0x0038->B:19:0x014c, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0074 A[EDGE_INSN: B:20:0x0074->B:21:0x0074 BREAK  A[LOOP:1: B:12:0x0038->B:19:0x014c], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void mergeLo(int r22, int r23, int r24, int r25) {
        /*
            Method dump skipped, instructions count: 337
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.TimSort.mergeLo(int, int, int, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0080, code lost:
    
        r11 = r2;
        r15 = r5;
        r17 = r6;
        r18 = r7;
        r13 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x008c, code lost:
    
        r14 = r4;
        r7 = r13 - gallopRight(r9[r14], r8, r24, r13, r13 - 1, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x009c, code lost:
    
        if (r7 == 0) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x009e, code lost:
    
        r2 = r17 - r7;
        r3 = r18 - r7;
        r4 = r13 - r7;
        java.lang.System.arraycopy(r8, r3 + 1, r8, r2 + 1, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00ab, code lost:
    
        if (r4 != 0) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00b8, code lost:
    
        r17 = r2;
        r18 = r3;
        r13 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00ad, code lost:
    
        r7 = r3;
        r3 = r4;
        r4 = r14;
        r5 = r15;
        r22 = r11;
        r11 = r2;
        r2 = r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00bd, code lost:
    
        r19 = r17 - 1;
        r21 = r14 - 1;
        r8[r17] = r9[r14];
        r11 = r11 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00c8, code lost:
    
        if (r11 != 1) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00d4, code lost:
    
        r2 = r11 - gallopLeft(r8[r18], r9, r10, r11, r11 - 1, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00e3, code lost:
    
        if (r2 == 0) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00e5, code lost:
    
        r3 = r19 - r2;
        r4 = r21 - r2;
        r5 = r11 - r2;
        java.lang.System.arraycopy(r9, r4 + 1, r8, r3 + 1, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00f3, code lost:
    
        if (r5 > 1) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00fc, code lost:
    
        r19 = r3;
        r11 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0102, code lost:
    
        r17 = r19 - 1;
        r3 = r18 - 1;
        r8[r19] = r8[r18];
        r13 = r13 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x010c, code lost:
    
        if (r13 != 0) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0141, code lost:
    
        r15 = r15 - 1;
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0146, code lost:
    
        if (r7 < 7) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0148, code lost:
    
        r16 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x014d, code lost:
    
        if (r2 < 7) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x014f, code lost:
    
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0152, code lost:
    
        if ((r16 | r5) != false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0162, code lost:
    
        r18 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0154, code lost:
    
        if (r15 >= 0) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0156, code lost:
    
        r15 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x014b, code lost:
    
        r16 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x010e, code lost:
    
        r7 = r3;
        r2 = r11;
        r3 = r13;
        r5 = r15;
        r11 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00f5, code lost:
    
        r11 = r3;
        r2 = r5;
        r3 = r13;
        r5 = r15;
        r7 = r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0100, code lost:
    
        r4 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00ca, code lost:
    
        r2 = r11;
        r3 = r13;
        r5 = r15;
        r7 = r18;
        r11 = r19;
        r4 = r21;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x016b A[LOOP:1: B:11:0x0045->B:18:0x016b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0080 A[EDGE_INSN: B:19:0x0080->B:20:0x0080 BREAK  A[LOOP:1: B:11:0x0045->B:18:0x016b], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void mergeHi(int r24, int r25, int r26, int r27) {
        /*
            Method dump skipped, instructions count: 366
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.TimSort.mergeHi(int, int, int, int):void");
    }

    private T[] ensureCapacity(int i10) {
        int min;
        if (this.tmpLen < i10) {
            int numberOfLeadingZeros = ((-1) >>> Integer.numberOfLeadingZeros(i10)) + 1;
            if (numberOfLeadingZeros < 0) {
                min = i10;
            } else {
                min = Math.min(numberOfLeadingZeros, this.f50483a.length >>> 1);
            }
            this.tmp = (T[]) ((Object[]) Array.newInstance(this.f50483a.getClass().getComponentType(), min));
            this.tmpLen = min;
            this.tmpBase = 0;
        }
        return this.tmp;
    }
}
