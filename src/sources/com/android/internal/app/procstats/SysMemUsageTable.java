package com.android.internal.app.procstats;

import android.util.DebugUtils;
import com.android.internal.app.procstats.SparseMappingTable;
import java.io.PrintWriter;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class SysMemUsageTable extends SparseMappingTable.Table {
    public SysMemUsageTable(SparseMappingTable tableData) {
        super(tableData);
    }

    public void mergeStats(SysMemUsageTable that) {
        int N = that.getKeyCount();
        for (int i10 = 0; i10 < N; i10++) {
            int key = that.getKeyAt(i10);
            int state = SparseMappingTable.getIdFromKey(key);
            long[] addData = that.getArrayForKey(key);
            int addOff = SparseMappingTable.getIndexFromKey(key);
            mergeStats(state, addData, addOff);
        }
    }

    public void mergeStats(int state, long[] addData, int addOff) {
        int key = getOrAddKey((byte) state, 16);
        long[] dstData = getArrayForKey(key);
        int dstOff = SparseMappingTable.getIndexFromKey(key);
        mergeSysMemUsage(dstData, dstOff, addData, addOff);
    }

    public long[] getTotalMemUsage() {
        long[] total = new long[16];
        int N = getKeyCount();
        for (int i10 = 0; i10 < N; i10++) {
            int key = getKeyAt(i10);
            long[] addData = getArrayForKey(key);
            int addOff = SparseMappingTable.getIndexFromKey(key);
            mergeSysMemUsage(total, 0, addData, addOff);
        }
        return total;
    }

    public static void mergeSysMemUsage(long[] dstData, int dstOff, long[] addData, int addOff) {
        long dstCount = dstData[dstOff + 0];
        long addCount = addData[addOff + 0];
        if (dstCount == 0) {
            dstData[dstOff + 0] = addCount;
            for (int i10 = 1; i10 < 16; i10++) {
                dstData[dstOff + i10] = addData[addOff + i10];
            }
            return;
        }
        if (addCount > 0) {
            dstData[dstOff + 0] = dstCount + addCount;
            for (int i11 = 1; i11 < 16; i11 += 3) {
                if (dstData[dstOff + i11] > addData[addOff + i11]) {
                    dstData[dstOff + i11] = addData[addOff + i11];
                }
                dstData[dstOff + i11 + 1] = (long) (((dstData[(dstOff + i11) + 1] * dstCount) + (addData[(addOff + i11) + 1] * addCount)) / (dstCount + addCount));
                if (dstData[dstOff + i11 + 2] < addData[addOff + i11 + 2]) {
                    dstData[dstOff + i11 + 2] = addData[addOff + i11 + 2];
                }
            }
        }
    }

    public void dump(PrintWriter pw, String prefix, int[] screenStates, int[] memStates) {
        int printedScreen;
        int printedMem;
        int printedScreen2 = -1;
        for (int is = 0; is < screenStates.length; is++) {
            int printedMem2 = -1;
            for (int im2 = 0; im2 < memStates.length; im2++) {
                int iscreen = screenStates[is];
                int imem = memStates[im2];
                int bucket = (iscreen + imem) * 16;
                long count = getValueForId((byte) bucket, 0);
                if (count > 0) {
                    pw.print(prefix);
                    if (screenStates.length <= 1) {
                        printedScreen = printedScreen2;
                    } else {
                        DumpUtils.printScreenLabel(pw, printedScreen2 != iscreen ? iscreen : -1);
                        printedScreen = iscreen;
                    }
                    int printedScreen3 = memStates.length;
                    if (printedScreen3 <= 1) {
                        printedMem = printedMem2;
                    } else {
                        DumpUtils.printMemLabel(pw, printedMem2 != imem ? imem : -1, (char) 0);
                        printedMem = imem;
                    }
                    pw.print(": ");
                    pw.print(count);
                    pw.println(" samples:");
                    dumpCategory(pw, prefix, "  Cached", bucket, 1);
                    dumpCategory(pw, prefix, "  Free", bucket, 4);
                    dumpCategory(pw, prefix, "  ZRam", bucket, 7);
                    dumpCategory(pw, prefix, "  Kernel", bucket, 10);
                    dumpCategory(pw, prefix, "  Native", bucket, 13);
                    printedMem2 = printedMem;
                    printedScreen2 = printedScreen;
                }
            }
        }
    }

    private void dumpCategory(PrintWriter pw, String prefix, String label, int bucket, int index) {
        pw.print(prefix);
        pw.print(label);
        pw.print(": ");
        DebugUtils.printSizeValue(pw, getValueForId((byte) bucket, index) * 1024);
        pw.print(" min, ");
        DebugUtils.printSizeValue(pw, getValueForId((byte) bucket, index + 1) * 1024);
        pw.print(" avg, ");
        DebugUtils.printSizeValue(pw, getValueForId((byte) bucket, index + 2) * 1024);
        pw.println(" max");
    }
}
