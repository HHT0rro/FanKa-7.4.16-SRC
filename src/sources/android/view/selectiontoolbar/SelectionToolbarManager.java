package android.view.selectiontoolbar;

import android.content.Context;
import android.os.RemoteException;
import android.provider.DeviceConfig;
import java.util.Objects;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class SelectionToolbarManager {
    public static final int ERROR_DO_NOT_ALLOW_MULTIPLE_TOOL_BAR = 1;
    public static final String LOG_TAG = "SelectionToolbar";
    public static final long NO_TOOLBAR_ID = 0;
    private static final String REMOTE_SELECTION_TOOLBAR_ENABLED = "remote_selection_toolbar_enabled";
    private static final String TAG = "SelectionToolbar";
    private final Context mContext;
    private final ISelectionToolbarManager mService;

    public SelectionToolbarManager(Context context, ISelectionToolbarManager service) {
        this.mContext = (Context) Objects.requireNonNull(context);
        this.mService = service;
    }

    public void showToolbar(ShowInfo showInfo, ISelectionToolbarCallback callback) {
        try {
            Objects.requireNonNull(showInfo);
            Objects.requireNonNull(callback);
            this.mService.showToolbar(showInfo, callback, this.mContext.getUserId());
        } catch (RemoteException e2) {
            throw e2.rethrowFromSystemServer();
        }
    }

    public void hideToolbar(long widgetToken) {
        try {
            this.mService.hideToolbar(widgetToken, this.mContext.getUserId());
        } catch (RemoteException e2) {
            throw e2.rethrowFromSystemServer();
        }
    }

    public void dismissToolbar(long widgetToken) {
        try {
            this.mService.dismissToolbar(widgetToken, this.mContext.getUserId());
        } catch (RemoteException e2) {
            throw e2.rethrowFromSystemServer();
        }
    }

    private boolean isRemoteSelectionToolbarEnabled() {
        return DeviceConfig.getBoolean("selection_toolbar", REMOTE_SELECTION_TOOLBAR_ENABLED, false);
    }

    public static boolean isRemoteSelectionToolbarEnabled(Context context) {
        SelectionToolbarManager manager = (SelectionToolbarManager) context.getSystemService(SelectionToolbarManager.class);
        if (manager != null) {
            return manager.isRemoteSelectionToolbarEnabled();
        }
        return false;
    }
}
