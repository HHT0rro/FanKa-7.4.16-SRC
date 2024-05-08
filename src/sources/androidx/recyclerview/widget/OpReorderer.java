package androidx.recyclerview.widget;

import androidx.recyclerview.widget.AdapterHelper;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class OpReorderer {
    public final Callback mCallback;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface Callback {
        AdapterHelper.UpdateOp obtainUpdateOp(int i10, int i11, int i12, Object obj);

        void recycleUpdateOp(AdapterHelper.UpdateOp updateOp);
    }

    public OpReorderer(Callback callback) {
        this.mCallback = callback;
    }

    private int getLastMoveOutOfOrder(List<AdapterHelper.UpdateOp> list) {
        boolean z10 = false;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (list.get(size).cmd != 8) {
                z10 = true;
            } else if (z10) {
                return size;
            }
        }
        return -1;
    }

    private void swapMoveAdd(List<AdapterHelper.UpdateOp> list, int i10, AdapterHelper.UpdateOp updateOp, int i11, AdapterHelper.UpdateOp updateOp2) {
        int i12 = updateOp.itemCount;
        int i13 = updateOp2.positionStart;
        int i14 = i12 < i13 ? -1 : 0;
        int i15 = updateOp.positionStart;
        if (i15 < i13) {
            i14++;
        }
        if (i13 <= i15) {
            updateOp.positionStart = i15 + updateOp2.itemCount;
        }
        int i16 = updateOp2.positionStart;
        if (i16 <= i12) {
            updateOp.itemCount = i12 + updateOp2.itemCount;
        }
        updateOp2.positionStart = i16 + i14;
        list.set(i10, updateOp2);
        list.set(i11, updateOp);
    }

    private void swapMoveOp(List<AdapterHelper.UpdateOp> list, int i10, int i11) {
        AdapterHelper.UpdateOp updateOp = list.get(i10);
        AdapterHelper.UpdateOp updateOp2 = list.get(i11);
        int i12 = updateOp2.cmd;
        if (i12 == 1) {
            swapMoveAdd(list, i10, updateOp, i11, updateOp2);
        } else if (i12 == 2) {
            swapMoveRemove(list, i10, updateOp, i11, updateOp2);
        } else {
            if (i12 != 4) {
                return;
            }
            swapMoveUpdate(list, i10, updateOp, i11, updateOp2);
        }
    }

    public void reorderOps(List<AdapterHelper.UpdateOp> list) {
        while (true) {
            int lastMoveOutOfOrder = getLastMoveOutOfOrder(list);
            if (lastMoveOutOfOrder == -1) {
                return;
            } else {
                swapMoveOp(list, lastMoveOutOfOrder, lastMoveOutOfOrder + 1);
            }
        }
    }

    public void swapMoveRemove(List<AdapterHelper.UpdateOp> list, int i10, AdapterHelper.UpdateOp updateOp, int i11, AdapterHelper.UpdateOp updateOp2) {
        boolean z10;
        int i12 = updateOp.positionStart;
        int i13 = updateOp.itemCount;
        boolean z11 = false;
        if (i12 < i13) {
            if (updateOp2.positionStart == i12 && updateOp2.itemCount == i13 - i12) {
                z10 = false;
                z11 = true;
            } else {
                z10 = false;
            }
        } else if (updateOp2.positionStart == i13 + 1 && updateOp2.itemCount == i12 - i13) {
            z10 = true;
            z11 = true;
        } else {
            z10 = true;
        }
        int i14 = updateOp2.positionStart;
        if (i13 < i14) {
            updateOp2.positionStart = i14 - 1;
        } else {
            int i15 = updateOp2.itemCount;
            if (i13 < i14 + i15) {
                updateOp2.itemCount = i15 - 1;
                updateOp.cmd = 2;
                updateOp.itemCount = 1;
                if (updateOp2.itemCount == 0) {
                    list.remove(i11);
                    this.mCallback.recycleUpdateOp(updateOp2);
                    return;
                }
                return;
            }
        }
        int i16 = updateOp.positionStart;
        int i17 = updateOp2.positionStart;
        AdapterHelper.UpdateOp updateOp3 = null;
        if (i16 <= i17) {
            updateOp2.positionStart = i17 + 1;
        } else {
            int i18 = updateOp2.itemCount;
            if (i16 < i17 + i18) {
                updateOp3 = this.mCallback.obtainUpdateOp(2, i16 + 1, (i17 + i18) - i16, null);
                updateOp2.itemCount = updateOp.positionStart - updateOp2.positionStart;
            }
        }
        if (z11) {
            list.set(i10, updateOp2);
            list.remove(i11);
            this.mCallback.recycleUpdateOp(updateOp);
            return;
        }
        if (z10) {
            if (updateOp3 != null) {
                int i19 = updateOp.positionStart;
                if (i19 > updateOp3.positionStart) {
                    updateOp.positionStart = i19 - updateOp3.itemCount;
                }
                int i20 = updateOp.itemCount;
                if (i20 > updateOp3.positionStart) {
                    updateOp.itemCount = i20 - updateOp3.itemCount;
                }
            }
            int i21 = updateOp.positionStart;
            if (i21 > updateOp2.positionStart) {
                updateOp.positionStart = i21 - updateOp2.itemCount;
            }
            int i22 = updateOp.itemCount;
            if (i22 > updateOp2.positionStart) {
                updateOp.itemCount = i22 - updateOp2.itemCount;
            }
        } else {
            if (updateOp3 != null) {
                int i23 = updateOp.positionStart;
                if (i23 >= updateOp3.positionStart) {
                    updateOp.positionStart = i23 - updateOp3.itemCount;
                }
                int i24 = updateOp.itemCount;
                if (i24 >= updateOp3.positionStart) {
                    updateOp.itemCount = i24 - updateOp3.itemCount;
                }
            }
            int i25 = updateOp.positionStart;
            if (i25 >= updateOp2.positionStart) {
                updateOp.positionStart = i25 - updateOp2.itemCount;
            }
            int i26 = updateOp.itemCount;
            if (i26 >= updateOp2.positionStart) {
                updateOp.itemCount = i26 - updateOp2.itemCount;
            }
        }
        list.set(i10, updateOp2);
        if (updateOp.positionStart != updateOp.itemCount) {
            list.set(i11, updateOp);
        } else {
            list.remove(i11);
        }
        if (updateOp3 != null) {
            list.add(i10, updateOp3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void swapMoveUpdate(java.util.List<androidx.recyclerview.widget.AdapterHelper.UpdateOp> r9, int r10, androidx.recyclerview.widget.AdapterHelper.UpdateOp r11, int r12, androidx.recyclerview.widget.AdapterHelper.UpdateOp r13) {
        /*
            r8 = this;
            int r0 = r11.itemCount
            int r1 = r13.positionStart
            r2 = 4
            r3 = 0
            r4 = 1
            if (r0 >= r1) goto Ld
            int r1 = r1 - r4
            r13.positionStart = r1
            goto L20
        Ld:
            int r5 = r13.itemCount
            int r1 = r1 + r5
            if (r0 >= r1) goto L20
            int r5 = r5 - r4
            r13.itemCount = r5
            androidx.recyclerview.widget.OpReorderer$Callback r0 = r8.mCallback
            int r1 = r11.positionStart
            java.lang.Object r5 = r13.payload
            androidx.recyclerview.widget.AdapterHelper$UpdateOp r0 = r0.obtainUpdateOp(r2, r1, r4, r5)
            goto L21
        L20:
            r0 = r3
        L21:
            int r1 = r11.positionStart
            int r5 = r13.positionStart
            if (r1 > r5) goto L2b
            int r5 = r5 + r4
            r13.positionStart = r5
            goto L41
        L2b:
            int r6 = r13.itemCount
            int r7 = r5 + r6
            if (r1 >= r7) goto L41
            int r5 = r5 + r6
            int r5 = r5 - r1
            androidx.recyclerview.widget.OpReorderer$Callback r3 = r8.mCallback
            int r1 = r1 + r4
            java.lang.Object r4 = r13.payload
            androidx.recyclerview.widget.AdapterHelper$UpdateOp r3 = r3.obtainUpdateOp(r2, r1, r5, r4)
            int r1 = r13.itemCount
            int r1 = r1 - r5
            r13.itemCount = r1
        L41:
            r9.set(r12, r11)
            int r11 = r13.itemCount
            if (r11 <= 0) goto L4c
            r9.set(r10, r13)
            goto L54
        L4c:
            r9.remove(r10)
            androidx.recyclerview.widget.OpReorderer$Callback r11 = r8.mCallback
            r11.recycleUpdateOp(r13)
        L54:
            if (r0 == 0) goto L59
            r9.add(r10, r0)
        L59:
            if (r3 == 0) goto L5e
            r9.add(r10, r3)
        L5e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.OpReorderer.swapMoveUpdate(java.util.List, int, androidx.recyclerview.widget.AdapterHelper$UpdateOp, int, androidx.recyclerview.widget.AdapterHelper$UpdateOp):void");
    }
}
