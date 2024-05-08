package com.android.internal.os;

import android.os.Process;
import com.android.internal.os.KernelSingleProcessCpuThreadReader;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class SelectedProcessCpuThreadReader {
    private final String[] mCmdline;
    private KernelSingleProcessCpuThreadReader mKernelCpuThreadReader;
    private int mPid;

    public SelectedProcessCpuThreadReader(String cmdline) {
        this.mCmdline = new String[]{cmdline};
    }

    public KernelSingleProcessCpuThreadReader.ProcessCpuUsage readAbsolute() {
        int[] pids = Process.getPidsForCommands(this.mCmdline);
        if (pids == null || pids.length != 1) {
            return null;
        }
        int pid = pids[0];
        if (this.mPid == pid) {
            return this.mKernelCpuThreadReader.getProcessCpuUsage();
        }
        this.mPid = pid;
        KernelSingleProcessCpuThreadReader create = KernelSingleProcessCpuThreadReader.create(pid);
        this.mKernelCpuThreadReader = create;
        create.startTrackingThreadCpuTimes();
        return null;
    }
}
