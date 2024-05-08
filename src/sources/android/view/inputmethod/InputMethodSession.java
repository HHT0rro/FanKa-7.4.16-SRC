package android.view.inputmethod;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.android.internal.inputmethod.IRemoteInputConnection;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface InputMethodSession {

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public interface EventCallback {
        void finishedEvent(int i10, boolean z10);
    }

    void appPrivateCommand(String str, Bundle bundle);

    void dispatchGenericMotionEvent(int i10, MotionEvent motionEvent, EventCallback eventCallback);

    void dispatchKeyEvent(int i10, KeyEvent keyEvent, EventCallback eventCallback);

    void dispatchTrackballEvent(int i10, MotionEvent motionEvent, EventCallback eventCallback);

    void displayCompletions(CompletionInfo[] completionInfoArr);

    void finishInput();

    void removeImeSurface();

    @Deprecated
    void toggleSoftInput(int i10, int i11);

    void updateCursor(Rect rect);

    void updateCursorAnchorInfo(CursorAnchorInfo cursorAnchorInfo);

    void updateExtractedText(int i10, ExtractedText extractedText);

    void updateSelection(int i10, int i11, int i12, int i13, int i14, int i15);

    void viewClicked(boolean z10);

    default void invalidateInputInternal(EditorInfo editorInfo, IRemoteInputConnection inputConnection, int sessionId) {
    }
}
