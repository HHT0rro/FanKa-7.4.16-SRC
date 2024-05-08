package com.android.internal.inputmethod;

import android.os.RemoteException;
import android.view.KeyEvent;
import android.view.inputmethod.SurroundingText;
import android.view.inputmethod.TextAttribute;
import com.android.internal.infra.AndroidFuture;
import java.util.Objects;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
final class IRemoteAccessibilityInputConnectionInvoker {
    private final IRemoteAccessibilityInputConnection mConnection;
    private final int mSessionId;

    private IRemoteAccessibilityInputConnectionInvoker(IRemoteAccessibilityInputConnection inputContext, int sessionId) {
        this.mConnection = inputContext;
        this.mSessionId = sessionId;
    }

    public static IRemoteAccessibilityInputConnectionInvoker create(IRemoteAccessibilityInputConnection connection) {
        Objects.requireNonNull(connection);
        return new IRemoteAccessibilityInputConnectionInvoker(connection, 0);
    }

    public IRemoteAccessibilityInputConnectionInvoker cloneWithSessionId(int sessionId) {
        return new IRemoteAccessibilityInputConnectionInvoker(this.mConnection, sessionId);
    }

    public boolean isSameConnection(IRemoteAccessibilityInputConnection connection) {
        return connection != null && this.mConnection.asBinder() == connection.asBinder();
    }

    InputConnectionCommandHeader createHeader() {
        return new InputConnectionCommandHeader(this.mSessionId);
    }

    public void commitText(CharSequence text, int newCursorPosition, TextAttribute textAttribute) {
        try {
            this.mConnection.commitText(createHeader(), text, newCursorPosition, textAttribute);
        } catch (RemoteException e2) {
        }
    }

    public void setSelection(int start, int end) {
        try {
            this.mConnection.setSelection(createHeader(), start, end);
        } catch (RemoteException e2) {
        }
    }

    public AndroidFuture<SurroundingText> getSurroundingText(int beforeLength, int afterLength, int flags) {
        AndroidFuture<SurroundingText> future = new AndroidFuture<>();
        try {
            this.mConnection.getSurroundingText(createHeader(), beforeLength, afterLength, flags, future);
        } catch (RemoteException e2) {
            future.completeExceptionally(e2);
        }
        return future;
    }

    public void deleteSurroundingText(int beforeLength, int afterLength) {
        try {
            this.mConnection.deleteSurroundingText(createHeader(), beforeLength, afterLength);
        } catch (RemoteException e2) {
        }
    }

    public void sendKeyEvent(KeyEvent event) {
        try {
            this.mConnection.sendKeyEvent(createHeader(), event);
        } catch (RemoteException e2) {
        }
    }

    public void performEditorAction(int actionCode) {
        try {
            this.mConnection.performEditorAction(createHeader(), actionCode);
        } catch (RemoteException e2) {
        }
    }

    public void performContextMenuAction(int id2) {
        try {
            this.mConnection.performContextMenuAction(createHeader(), id2);
        } catch (RemoteException e2) {
        }
    }

    public AndroidFuture<Integer> getCursorCapsMode(int reqModes) {
        AndroidFuture<Integer> future = new AndroidFuture<>();
        try {
            this.mConnection.getCursorCapsMode(createHeader(), reqModes, future);
        } catch (RemoteException e2) {
            future.completeExceptionally(e2);
        }
        return future;
    }

    public void clearMetaKeyStates(int states) {
        try {
            this.mConnection.clearMetaKeyStates(createHeader(), states);
        } catch (RemoteException e2) {
        }
    }
}
