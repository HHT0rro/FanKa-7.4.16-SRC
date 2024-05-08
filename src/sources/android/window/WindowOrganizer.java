package android.window;

import android.app.ActivityTaskManager;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Singleton;
import android.view.RemoteAnimationAdapter;
import android.view.SurfaceControl;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class WindowOrganizer {
    private static final Singleton<IWindowOrganizerController> IWindowOrganizerControllerSingleton = new Singleton<IWindowOrganizerController>() { // from class: android.window.WindowOrganizer.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: create, reason: merged with bridge method [inline-methods] */
        public IWindowOrganizerController m1740create() {
            try {
                return ActivityTaskManager.getService().getWindowOrganizerController();
            } catch (RemoteException e2) {
                return null;
            }
        }
    };

    public void applyTransaction(WindowContainerTransaction t2) {
        try {
            if (!t2.isEmpty()) {
                getWindowOrganizerController().applyTransaction(t2);
            }
        } catch (RemoteException e2) {
            throw e2.rethrowFromSystemServer();
        }
    }

    public int applySyncTransaction(WindowContainerTransaction t2, WindowContainerTransactionCallback callback) {
        try {
            return getWindowOrganizerController().applySyncTransaction(t2, callback.mInterface);
        } catch (RemoteException e2) {
            throw e2.rethrowFromSystemServer();
        }
    }

    public IBinder startNewTransition(int type, WindowContainerTransaction t2) {
        try {
            return getWindowOrganizerController().startNewTransition(type, t2);
        } catch (RemoteException e2) {
            throw e2.rethrowFromSystemServer();
        }
    }

    public void startTransition(IBinder transitionToken, WindowContainerTransaction t2) {
        try {
            getWindowOrganizerController().startTransition(transitionToken, t2);
        } catch (RemoteException e2) {
            throw e2.rethrowFromSystemServer();
        }
    }

    public int finishTransition(IBinder transitionToken, WindowContainerTransaction t2, WindowContainerTransactionCallback callback) {
        try {
            return getWindowOrganizerController().finishTransition(transitionToken, t2, callback != null ? callback.mInterface : null);
        } catch (RemoteException e2) {
            throw e2.rethrowFromSystemServer();
        }
    }

    public int startLegacyTransition(int type, RemoteAnimationAdapter adapter, WindowContainerTransactionCallback syncCallback, WindowContainerTransaction t2) {
        try {
            return getWindowOrganizerController().startLegacyTransition(type, adapter, syncCallback.mInterface, t2);
        } catch (RemoteException e2) {
            throw e2.rethrowFromSystemServer();
        }
    }

    public void registerTransitionPlayer(ITransitionPlayer player) {
        try {
            getWindowOrganizerController().registerTransitionPlayer(player);
        } catch (RemoteException e2) {
            throw e2.rethrowFromSystemServer();
        }
    }

    public static ITransitionMetricsReporter getTransitionMetricsReporter() {
        try {
            return getWindowOrganizerController().getTransitionMetricsReporter();
        } catch (RemoteException e2) {
            throw e2.rethrowFromSystemServer();
        }
    }

    public boolean shareTransactionQueue() {
        try {
            IBinder wmApplyToken = getWindowOrganizerController().getApplyToken();
            if (wmApplyToken == null) {
                return false;
            }
            SurfaceControl.Transaction.setDefaultApplyToken(wmApplyToken);
            return true;
        } catch (RemoteException e2) {
            throw e2.rethrowFromSystemServer();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IWindowOrganizerController getWindowOrganizerController() {
        return (IWindowOrganizerController) IWindowOrganizerControllerSingleton.get();
    }
}
