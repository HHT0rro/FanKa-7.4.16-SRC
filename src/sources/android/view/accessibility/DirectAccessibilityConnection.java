package android.view.accessibility;

import android.accessibilityservice.IAccessibilityServiceConnection;
import android.graphics.Region;
import android.os.Bundle;
import android.os.Process;
import android.os.RemoteException;
import android.view.accessibility.IAccessibilityManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class DirectAccessibilityConnection extends IAccessibilityServiceConnection.Default {
    private static final int FETCH_FLAGS = 384;
    private static final Region INTERACTIVE_REGION = null;
    private final IAccessibilityInteractionConnection mAccessibilityInteractionConnection;
    private final AccessibilityManager mAccessibilityManager;
    private final int mMyProcessId = Process.myPid();

    /* JADX INFO: Access modifiers changed from: package-private */
    public DirectAccessibilityConnection(IAccessibilityInteractionConnection accessibilityInteractionConnection, AccessibilityManager accessibilityManager) {
        this.mAccessibilityInteractionConnection = accessibilityInteractionConnection;
        this.mAccessibilityManager = accessibilityManager;
    }

    public String[] findAccessibilityNodeInfoByAccessibilityId(int accessibilityWindowId, long accessibilityNodeId, int interactionId, IAccessibilityInteractionConnectionCallback callback, int flags, long threadId, Bundle arguments) throws RemoteException {
        IAccessibilityManager.WindowTransformationSpec spec = this.mAccessibilityManager.getWindowTransformationSpec(accessibilityWindowId);
        this.mAccessibilityInteractionConnection.findAccessibilityNodeInfoByAccessibilityId(accessibilityNodeId, INTERACTIVE_REGION, interactionId, callback, 384, this.mMyProcessId, threadId, spec.magnificationSpec, spec.transformationMatrix, arguments);
        return new String[0];
    }

    public String[] findAccessibilityNodeInfosByText(int accessibilityWindowId, long accessibilityNodeId, String text, int interactionId, IAccessibilityInteractionConnectionCallback callback, long threadId) throws RemoteException {
        IAccessibilityManager.WindowTransformationSpec spec = this.mAccessibilityManager.getWindowTransformationSpec(accessibilityWindowId);
        this.mAccessibilityInteractionConnection.findAccessibilityNodeInfosByText(accessibilityNodeId, text, INTERACTIVE_REGION, interactionId, callback, 384, this.mMyProcessId, threadId, spec.magnificationSpec, spec.transformationMatrix);
        return new String[0];
    }

    public String[] findAccessibilityNodeInfosByViewId(int accessibilityWindowId, long accessibilityNodeId, String viewId, int interactionId, IAccessibilityInteractionConnectionCallback callback, long threadId) throws RemoteException {
        IAccessibilityManager.WindowTransformationSpec spec = this.mAccessibilityManager.getWindowTransformationSpec(accessibilityWindowId);
        this.mAccessibilityInteractionConnection.findAccessibilityNodeInfosByViewId(accessibilityNodeId, viewId, INTERACTIVE_REGION, interactionId, callback, 384, this.mMyProcessId, threadId, spec.magnificationSpec, spec.transformationMatrix);
        return new String[0];
    }

    public String[] findFocus(int accessibilityWindowId, long accessibilityNodeId, int focusType, int interactionId, IAccessibilityInteractionConnectionCallback callback, long threadId) throws RemoteException {
        IAccessibilityManager.WindowTransformationSpec spec = this.mAccessibilityManager.getWindowTransformationSpec(accessibilityWindowId);
        this.mAccessibilityInteractionConnection.findFocus(accessibilityNodeId, focusType, INTERACTIVE_REGION, interactionId, callback, 384, this.mMyProcessId, threadId, spec.magnificationSpec, spec.transformationMatrix);
        return new String[0];
    }

    public String[] focusSearch(int accessibilityWindowId, long accessibilityNodeId, int direction, int interactionId, IAccessibilityInteractionConnectionCallback callback, long threadId) throws RemoteException {
        IAccessibilityManager.WindowTransformationSpec spec = this.mAccessibilityManager.getWindowTransformationSpec(accessibilityWindowId);
        this.mAccessibilityInteractionConnection.focusSearch(accessibilityNodeId, direction, INTERACTIVE_REGION, interactionId, callback, 384, this.mMyProcessId, threadId, spec.magnificationSpec, spec.transformationMatrix);
        return new String[0];
    }

    public boolean performAccessibilityAction(int accessibilityWindowId, long accessibilityNodeId, int action, Bundle arguments, int interactionId, IAccessibilityInteractionConnectionCallback callback, long threadId) throws RemoteException {
        this.mAccessibilityInteractionConnection.performAccessibilityAction(accessibilityNodeId, action, arguments, interactionId, callback, 384, this.mMyProcessId, threadId);
        return true;
    }
}
