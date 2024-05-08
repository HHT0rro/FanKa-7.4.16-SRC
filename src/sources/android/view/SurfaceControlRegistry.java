package android.view;

import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import android.view.SurfaceControlRegistry;
import com.android.internal.util.GcUtils;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class SurfaceControlRegistry {
    private static final int DUMP_LIMIT = 256;
    private static final int MAX_LAYERS_REPORTING_THRESHOLD = 1024;
    private static final int RESET_REPORTING_THRESHOLD = 256;
    private static final String TAG = "SurfaceControlRegistry";
    private static volatile SurfaceControlRegistry sProcessRegistry;
    private static final Object sLock = new Object();
    private static final DefaultReporter sDefaultReporter = new DefaultReporter();
    private int mMaxLayersReportingThreshold = 1024;
    private int mResetReportingThreshold = 256;
    private boolean mHasReportedExceedingMaxThreshold = false;
    private Reporter mReporter = sDefaultReporter;
    private final WeakHashMap<SurfaceControl, Long> mSurfaceControls = new WeakHashMap<>(256);

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public interface Reporter {
        void onMaxLayersExceeded(WeakHashMap<SurfaceControl, Long> weakHashMap, int i10, PrintWriter printWriter);
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    private static class DefaultReporter implements Reporter {
        private DefaultReporter() {
        }

        @Override // android.view.SurfaceControlRegistry.Reporter
        public void onMaxLayersExceeded(WeakHashMap<SurfaceControl, Long> surfaceControls, int limit, PrintWriter pw) {
            long now = SystemClock.elapsedRealtime();
            ArrayList<Map.Entry<SurfaceControl, Long>> entries = new ArrayList<>();
            Iterator<Map.Entry<SurfaceControl, Long>> iterator2 = surfaceControls.entrySet().iterator2();
            while (iterator2.hasNext()) {
                entries.add(iterator2.next());
            }
            entries.sort(new Comparator() { // from class: android.view.SurfaceControlRegistry$DefaultReporter$$ExternalSyntheticLambda0
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return SurfaceControlRegistry.DefaultReporter.lambda$onMaxLayersExceeded$0((Map.Entry) obj, (Map.Entry) obj2);
                }
            });
            int size = Math.min(entries.size(), limit);
            pw.println(SurfaceControlRegistry.TAG);
            pw.println("----------------------");
            pw.println("Listing oldest " + size + " of " + surfaceControls.size());
            for (int i10 = 0; i10 < size; i10++) {
                Map.Entry<SurfaceControl, Long> entry = entries.get(i10);
                SurfaceControl sc2 = entry.getKey();
                long timeRegistered = entry.getValue().longValue();
                pw.print("  ");
                pw.print(sc2.getName());
                pw.print(" (" + sc2.getCallsite() + ")");
                pw.println(" [" + ((now - timeRegistered) / 1000) + "s ago]");
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ int lambda$onMaxLayersExceeded$0(Map.Entry o12, Map.Entry o22) {
            return (int) (((Long) o12.getValue()).longValue() - ((Long) o22.getValue()).longValue());
        }
    }

    private SurfaceControlRegistry() {
    }

    public void setReportingThresholds(int maxLayersReportingThreshold, int resetReportingThreshold, Reporter reporter) {
        synchronized (sLock) {
            if (maxLayersReportingThreshold <= 0 || resetReportingThreshold >= maxLayersReportingThreshold) {
                throw new IllegalArgumentException("Expected maxLayersReportingThreshold (" + maxLayersReportingThreshold + ") to be > 0 and resetReportingThreshold (" + resetReportingThreshold + ") to be < maxLayersReportingThreshold");
            }
            if (reporter == null) {
                throw new IllegalArgumentException("Expected non-null reporter");
            }
            this.mMaxLayersReportingThreshold = maxLayersReportingThreshold;
            this.mResetReportingThreshold = resetReportingThreshold;
            this.mHasReportedExceedingMaxThreshold = false;
            this.mReporter = reporter;
        }
    }

    public static void createProcessInstance(Context context) {
        if (context.checkSelfPermission("android.permission.READ_FRAME_BUFFER") != 0) {
            throw new SecurityException("Expected caller to hold READ_FRAME_BUFFER");
        }
        synchronized (sLock) {
            if (sProcessRegistry == null) {
                sProcessRegistry = new SurfaceControlRegistry();
            }
        }
    }

    public static void destroyProcessInstance() {
        synchronized (sLock) {
            if (sProcessRegistry == null) {
                return;
            }
            sProcessRegistry = null;
        }
    }

    public static SurfaceControlRegistry getProcessInstance() {
        SurfaceControlRegistry surfaceControlRegistry;
        synchronized (sLock) {
            surfaceControlRegistry = sProcessRegistry;
        }
        return surfaceControlRegistry;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void add(SurfaceControl sc2) {
        synchronized (sLock) {
            this.mSurfaceControls.put(sc2, Long.valueOf(SystemClock.elapsedRealtime()));
            if (!this.mHasReportedExceedingMaxThreshold && this.mSurfaceControls.size() >= this.mMaxLayersReportingThreshold) {
                PrintWriter pw = new PrintWriter((OutputStream) System.out, true);
                this.mReporter.onMaxLayersExceeded(this.mSurfaceControls, 256, pw);
                this.mHasReportedExceedingMaxThreshold = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void remove(SurfaceControl sc2) {
        synchronized (sLock) {
            this.mSurfaceControls.remove(sc2);
            if (this.mHasReportedExceedingMaxThreshold && this.mSurfaceControls.size() <= this.mResetReportingThreshold) {
                this.mHasReportedExceedingMaxThreshold = false;
            }
        }
    }

    public int hashCode() {
        int hashCode;
        synchronized (sLock) {
            hashCode = this.mSurfaceControls.h().hashCode();
        }
        return hashCode;
    }

    private static void runGcAndFinalizers() {
        long t2 = SystemClock.elapsedRealtime();
        GcUtils.runGcAndFinalizersSync();
        Log.i(TAG, "Ran gc and finalizers (" + (SystemClock.elapsedRealtime() - t2) + "ms)");
    }

    public static void dump(int limit, boolean runGc, PrintWriter pw) {
        if (runGc) {
            runGcAndFinalizers();
        }
        synchronized (sLock) {
            if (sProcessRegistry != null) {
                sDefaultReporter.onMaxLayersExceeded(sProcessRegistry.mSurfaceControls, limit, pw);
            }
        }
    }
}
