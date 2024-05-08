package android.window;

import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Singleton;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class TransitionMetrics {
    private static final Singleton<TransitionMetrics> sTransitionMetrics = new Singleton<TransitionMetrics>() { // from class: android.window.TransitionMetrics.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: create, reason: merged with bridge method [inline-methods] */
        public TransitionMetrics m1698create() {
            return new TransitionMetrics(WindowOrganizer.getTransitionMetricsReporter());
        }
    };
    private final ITransitionMetricsReporter mTransitionMetricsReporter;

    private TransitionMetrics(ITransitionMetricsReporter reporter) {
        this.mTransitionMetricsReporter = reporter;
    }

    public void reportAnimationStart(IBinder transitionToken) {
        try {
            this.mTransitionMetricsReporter.reportAnimationStart(transitionToken, SystemClock.elapsedRealtime());
        } catch (RemoteException e2) {
            e2.rethrowFromSystemServer();
        }
    }

    public static TransitionMetrics getInstance() {
        return (TransitionMetrics) sTransitionMetrics.get();
    }
}
