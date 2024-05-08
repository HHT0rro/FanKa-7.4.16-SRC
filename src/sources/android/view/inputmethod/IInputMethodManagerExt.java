package android.view.inputmethod;

import android.view.InsetsState;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewRootImpl;
import com.android.internal.inputmethod.IRemoteInputConnection;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface IInputMethodManagerExt {
    default void logDebug(String msg) {
    }

    default void logDebugIme(String msg) {
    }

    default void logMethodCallers(String msg) {
    }

    default int adjustForceFlag(int flags) {
        return flags;
    }

    default boolean configDebug(String[] args) {
        return false;
    }

    default void updateCursorAnchorInfoToSynergy(CursorAnchorInfo cursorAnchorInfo) {
    }

    default void invalidateInputToSynergy(EditorInfo editorInfo, IRemoteInputConnection inputConnection, int sessionId) {
    }

    default void updateCurrentRootView(ViewRootImpl rootView) {
    }

    default void attachInfoToEditorInfo(EditorInfo editorInfo) {
    }

    default void onStartInputResult(int resultCode) {
    }

    default void onViewRootTouchEvent(ViewRootImpl rootView, MotionEvent event) {
    }

    default void onCallShowBeforeCheckFocus(View view) {
    }

    default int adjustStartInputFlags(int flags) {
        return flags;
    }

    default boolean needForceNewFocus() {
        return false;
    }

    default boolean ignoreFinishInput(int displayId) {
        return false;
    }

    default void updateNavInsets(int windowType, InsetsState insetsState) {
    }
}
