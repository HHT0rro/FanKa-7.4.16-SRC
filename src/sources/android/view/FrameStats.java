package android.view;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public abstract class FrameStats {
    public static final long UNDEFINED_TIME_NANO = -1;
    protected long[] mFramesPresentedTimeNano;
    protected long mRefreshPeriodNano;

    public final long getRefreshPeriodNano() {
        return this.mRefreshPeriodNano;
    }

    public final int getFrameCount() {
        long[] jArr = this.mFramesPresentedTimeNano;
        if (jArr != null) {
            return jArr.length;
        }
        return 0;
    }

    public final long getStartTimeNano() {
        if (getFrameCount() <= 0) {
            return -1L;
        }
        return this.mFramesPresentedTimeNano[0];
    }

    public final long getEndTimeNano() {
        if (getFrameCount() <= 0) {
            return -1L;
        }
        return this.mFramesPresentedTimeNano[r0.length - 1];
    }

    public final long getFramePresentedTimeNano(int index) {
        long[] jArr = this.mFramesPresentedTimeNano;
        if (jArr == null) {
            throw new IndexOutOfBoundsException();
        }
        return jArr[index];
    }
}
