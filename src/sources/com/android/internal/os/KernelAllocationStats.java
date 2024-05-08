package com.android.internal.os;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class KernelAllocationStats {
    public static native ProcessDmabuf[] getDmabufAllocations();

    public static native ProcessGpuMem[] getGpuAllocations();

    private KernelAllocationStats() {
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static final class ProcessDmabuf {
        public final int oomScore;
        public final String processName;
        public final int retainedBuffersCount;
        public final int retainedSizeKb;
        public final int surfaceFlingerCount;
        public final int surfaceFlingerSizeKb;
        public final int uid;

        ProcessDmabuf(int uid, String processName, int oomScore, int retainedSizeKb, int retainedBuffersCount, int surfaceFlingerSizeKb, int surfaceFlingerCount) {
            this.uid = uid;
            this.processName = processName;
            this.oomScore = oomScore;
            this.retainedSizeKb = retainedSizeKb;
            this.retainedBuffersCount = retainedBuffersCount;
            this.surfaceFlingerSizeKb = surfaceFlingerSizeKb;
            this.surfaceFlingerCount = surfaceFlingerCount;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static final class ProcessGpuMem {
        public final int gpuMemoryKb;
        public final int pid;

        ProcessGpuMem(int pid, int gpuMemoryKb) {
            this.pid = pid;
            this.gpuMemoryKb = gpuMemoryKb;
        }
    }
}
