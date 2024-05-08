package java.util;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class ComparableTimSort {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int INITIAL_TMP_STORAGE_LENGTH = 256;
    private static final int MIN_GALLOP = 7;
    private static final int MIN_MERGE = 32;

    /* renamed from: a, reason: collision with root package name */
    private final Object[] f50455a;
    private final int[] runBase;
    private final int[] runLen;
    private Object[] tmp;
    private int tmpBase;
    private int tmpLen;
    private int minGallop = 7;
    private int stackSize = 0;

    private ComparableTimSort(Object[] a10, Object[] work, int workBase, int workLen) {
        int stackLen;
        this.f50455a = a10;
        int len = a10.length;
        int tlen = len < 512 ? len >>> 1 : 256;
        if (work == null || workLen < tlen || workBase + tlen > work.length) {
            this.tmp = new Object[tlen];
            this.tmpBase = 0;
            this.tmpLen = tlen;
        } else {
            this.tmp = work;
            this.tmpBase = workBase;
            this.tmpLen = workLen;
        }
        if (len < 120) {
            stackLen = 5;
        } else if (len < 1542) {
            stackLen = 10;
        } else {
            stackLen = len < 119151 ? 24 : 49;
        }
        this.runBase = new int[stackLen];
        this.runLen = new int[stackLen];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void sort(Object[] a10, int lo, int hi, Object[] work, int workBase, int workLen) {
        int nRemaining = hi - lo;
        if (nRemaining < 2) {
            return;
        }
        if (nRemaining < 32) {
            int initRunLen = countRunAndMakeAscending(a10, lo, hi);
            binarySort(a10, lo, hi, lo + initRunLen);
            return;
        }
        ComparableTimSort ts = new ComparableTimSort(a10, work, workBase, workLen);
        int minRun = minRunLength(nRemaining);
        do {
            int runLen = countRunAndMakeAscending(a10, lo, hi);
            if (runLen < minRun) {
                int force = nRemaining <= minRun ? nRemaining : minRun;
                binarySort(a10, lo, lo + force, lo + runLen);
                runLen = force;
            }
            ts.pushRun(lo, runLen);
            ts.mergeCollapse();
            lo += runLen;
            nRemaining -= runLen;
        } while (nRemaining != 0);
        ts.mergeForceCollapse();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:18:0x0024. Please report as an issue. */
    private static void binarySort(Object[] a10, int lo, int hi, int start) {
        if (start == lo) {
            start++;
        }
        while (start < hi) {
            Comparable pivot = (Comparable) a10[start];
            int left = lo;
            int right = start;
            while (left < right) {
                int mid = (left + right) >>> 1;
                if (pivot.compareTo(a10[mid]) < 0) {
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

    private static int countRunAndMakeAscending(Object[] a10, int lo, int hi) {
        int runHi = lo + 1;
        if (runHi == hi) {
            return 1;
        }
        int runHi2 = runHi + 1;
        if (((Comparable) a10[runHi]).compareTo(a10[lo]) < 0) {
            while (runHi2 < hi && ((Comparable) a10[runHi2]).compareTo(a10[runHi2 - 1]) < 0) {
                runHi2++;
            }
            reverseRange(a10, lo, runHi2);
        } else {
            while (runHi2 < hi && ((Comparable) a10[runHi2]).compareTo(a10[runHi2 - 1]) >= 0) {
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
        throw new UnsupportedOperationException("Method not decompiled: java.util.ComparableTimSort.mergeCollapse():void");
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
        Object[] objArr = this.f50455a;
        int k10 = gallopRight((Comparable) objArr[base2], objArr, base1, len1, 0);
        int base12 = base1 + k10;
        int len12 = len1 - k10;
        if (len12 == 0) {
            return;
        }
        Object[] objArr2 = this.f50455a;
        int len22 = gallopLeft((Comparable) objArr2[(base12 + len12) - 1], objArr2, base2, len2, len2 - 1);
        if (len22 == 0) {
            return;
        }
        if (len12 <= len22) {
            mergeLo(base12, len12, base2, len22);
        } else {
            mergeHi(base12, len12, base2, len22);
        }
    }

    private static int gallopLeft(Comparable<Object> key, Object[] a10, int base, int len, int hint) {
        int lastOfs;
        int ofs;
        int lastOfs2 = 0;
        int ofs2 = 1;
        if (key.compareTo(a10[base + hint]) > 0) {
            int maxOfs = len - hint;
            while (ofs2 < maxOfs && key.compareTo(a10[base + hint + ofs2]) > 0) {
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
            while (ofs2 < maxOfs2 && key.compareTo(a10[(base + hint) - ofs2]) <= 0) {
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
            if (key.compareTo(a10[base + m10]) > 0) {
                lastOfs3 = m10 + 1;
            } else {
                ofs = m10;
            }
        }
        return ofs;
    }

    private static int gallopRight(Comparable<Object> key, Object[] a10, int base, int len, int hint) {
        int lastOfs;
        int ofs;
        int ofs2 = 1;
        int lastOfs2 = 0;
        if (key.compareTo(a10[base + hint]) < 0) {
            int maxOfs = hint + 1;
            while (ofs2 < maxOfs && key.compareTo(a10[(base + hint) - ofs2]) < 0) {
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
            while (ofs2 < maxOfs2 && key.compareTo(a10[base + hint + ofs2]) >= 0) {
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
            if (key.compareTo(a10[base + m10]) < 0) {
                ofs = m10;
            } else {
                lastOfs3 = m10 + 1;
            }
        }
        return ofs;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0072, code lost:
    
        r14 = false;
        r11 = gallopRight((java.lang.Comparable) r2[r9], r3, r4, r1, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x007b, code lost:
    
        if (r11 == 0) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x007d, code lost:
    
        java.lang.System.arraycopy(r3, r4, r2, r8, r11);
        r13 = r8 + r11;
        r4 = r4 + r11;
        r1 = r1 - r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0084, code lost:
    
        if (r1 > 1) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0087, code lost:
    
        r8 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0088, code lost:
    
        r13 = r8 + 1;
        r15 = r9 + 1;
        r2[r8] = r2[r9];
        r5 = r5 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0092, code lost:
    
        if (r5 != 0) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0096, code lost:
    
        r12 = gallopLeft((java.lang.Comparable) r3[r4], r2, r15, r5, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x009e, code lost:
    
        if (r12 == 0) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00a0, code lost:
    
        java.lang.System.arraycopy(r2, r15, r2, r13, r12);
        r13 = r13 + r12;
        r9 = r15 + r12;
        r5 = r5 - r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00a7, code lost:
    
        if (r5 != 0) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00ab, code lost:
    
        r8 = r13 + 1;
        r15 = r4 + 1;
        r2[r13] = r3[r4];
        r1 = r1 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00b5, code lost:
    
        if (r1 != 1) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00dd, code lost:
    
        r10 = r10 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00e0, code lost:
    
        if (r11 < 7) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00e2, code lost:
    
        r13 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00e5, code lost:
    
        if (r12 < 7) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00e7, code lost:
    
        r14 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00ea, code lost:
    
        if ((r13 | r14) != false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00f5, code lost:
    
        r4 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00ec, code lost:
    
        if (r10 >= 0) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00ee, code lost:
    
        r10 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00e4, code lost:
    
        r13 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00b7, code lost:
    
        r13 = r8;
        r4 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00aa, code lost:
    
        r9 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0094, code lost:
    
        r9 = r15;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0072 A[EDGE_INSN: B:19:0x0072->B:20:0x0072 BREAK  A[LOOP:1: B:12:0x0036->B:67:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:? A[LOOP:1: B:12:0x0036->B:67:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void mergeLo(int r17, int r18, int r19, int r20) {
        /*
            Method dump skipped, instructions count: 248
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.ComparableTimSort.mergeLo(int, int, int, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0083, code lost:
    
        r13 = r7 - gallopRight((java.lang.Comparable) r5[r9], r4, r18, r7, r7 - 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x008f, code lost:
    
        if (r13 == 0) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0091, code lost:
    
        r8 = r11 - r13;
        r12 = r12 - r13;
        r7 = r7 - r13;
        java.lang.System.arraycopy(r4, r12 + 1, r4, r8 + 1, r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x009c, code lost:
    
        if (r7 != 0) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x009f, code lost:
    
        r11 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00a0, code lost:
    
        r8 = r11 - 1;
        r15 = r9 - 1;
        r4[r11] = r5[r9];
        r3 = r3 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00ab, code lost:
    
        if (r3 != 1) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00af, code lost:
    
        r14 = r3 - gallopLeft((java.lang.Comparable) r4[r12], r5, r6, r3, r3 - 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00bb, code lost:
    
        if (r14 == 0) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00bd, code lost:
    
        r8 = r8 - r14;
        r9 = r15 - r14;
        r3 = r3 - r14;
        java.lang.System.arraycopy(r5, r9 + 1, r4, r8 + 1, r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00c9, code lost:
    
        if (r3 > 1) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00cd, code lost:
    
        r11 = r8 - 1;
        r15 = r12 - 1;
        r4[r8] = r4[r12];
        r7 = r7 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00d7, code lost:
    
        if (r7 != 0) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0108, code lost:
    
        r10 = r10 - 1;
        r12 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x010d, code lost:
    
        if (r13 < 7) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x010f, code lost:
    
        r16 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0114, code lost:
    
        if (r14 < 7) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0116, code lost:
    
        r12 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0119, code lost:
    
        if ((r16 | r12) != false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0125, code lost:
    
        r12 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x011b, code lost:
    
        if (r10 >= 0) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x011d, code lost:
    
        r10 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0112, code lost:
    
        r16 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00d9, code lost:
    
        r8 = r11;
        r12 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00cc, code lost:
    
        r9 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00ad, code lost:
    
        r9 = r15;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0128 A[LOOP:1: B:11:0x0045->B:18:0x0128, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0083 A[EDGE_INSN: B:19:0x0083->B:20:0x0083 BREAK  A[LOOP:1: B:11:0x0045->B:18:0x0128], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void mergeHi(int r18, int r19, int r20, int r21) {
        /*
            Method dump skipped, instructions count: 299
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.util.ComparableTimSort.mergeHi(int, int, int, int):void");
    }

    private Object[] ensureCapacity(int minCapacity) {
        int newSize;
        if (this.tmpLen < minCapacity) {
            int newSize2 = ((-1) >>> Integer.numberOfLeadingZeros(minCapacity)) + 1;
            if (newSize2 < 0) {
                newSize = minCapacity;
            } else {
                newSize = Math.min(newSize2, this.f50455a.length >>> 1);
            }
            Object[] newArray = new Object[newSize];
            this.tmp = newArray;
            this.tmpLen = newSize;
            this.tmpBase = 0;
        }
        return this.tmp;
    }
}
