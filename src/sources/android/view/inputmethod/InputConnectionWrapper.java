package android.view.inputmethod;

import android.graphics.RectF;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import com.android.internal.util.Preconditions;
import java.util.concurrent.Executor;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class InputConnectionWrapper implements InputConnection {
    final boolean mMutable;
    private InputConnection mTarget;

    public InputConnectionWrapper(InputConnection target, boolean mutable) {
        this.mMutable = mutable;
        this.mTarget = target;
    }

    public void setTarget(InputConnection target) {
        if (this.mTarget != null && !this.mMutable) {
            throw new SecurityException("not mutable");
        }
        this.mTarget = target;
    }

    @Override // android.view.inputmethod.InputConnection
    public CharSequence getTextBeforeCursor(int n10, int flags) {
        Preconditions.checkArgumentNonnegative(n10);
        return this.mTarget.getTextBeforeCursor(n10, flags);
    }

    @Override // android.view.inputmethod.InputConnection
    public CharSequence getTextAfterCursor(int n10, int flags) {
        Preconditions.checkArgumentNonnegative(n10);
        return this.mTarget.getTextAfterCursor(n10, flags);
    }

    @Override // android.view.inputmethod.InputConnection
    public CharSequence getSelectedText(int flags) {
        return this.mTarget.getSelectedText(flags);
    }

    @Override // android.view.inputmethod.InputConnection
    public SurroundingText getSurroundingText(int beforeLength, int afterLength, int flags) {
        Preconditions.checkArgumentNonnegative(beforeLength);
        Preconditions.checkArgumentNonnegative(afterLength);
        return this.mTarget.getSurroundingText(beforeLength, afterLength, flags);
    }

    @Override // android.view.inputmethod.InputConnection
    public int getCursorCapsMode(int reqModes) {
        return this.mTarget.getCursorCapsMode(reqModes);
    }

    @Override // android.view.inputmethod.InputConnection
    public ExtractedText getExtractedText(ExtractedTextRequest request, int flags) {
        return this.mTarget.getExtractedText(request, flags);
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean deleteSurroundingTextInCodePoints(int beforeLength, int afterLength) {
        return this.mTarget.deleteSurroundingTextInCodePoints(beforeLength, afterLength);
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean deleteSurroundingText(int beforeLength, int afterLength) {
        return this.mTarget.deleteSurroundingText(beforeLength, afterLength);
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean setComposingText(CharSequence text, int newCursorPosition) {
        return this.mTarget.setComposingText(text, newCursorPosition);
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean setComposingText(CharSequence text, int newCursorPosition, TextAttribute textAttribute) {
        return this.mTarget.setComposingText(text, newCursorPosition, textAttribute);
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean setComposingRegion(int start, int end) {
        return this.mTarget.setComposingRegion(start, end);
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean setComposingRegion(int start, int end, TextAttribute textAttribute) {
        return this.mTarget.setComposingRegion(start, end, textAttribute);
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean finishComposingText() {
        return this.mTarget.finishComposingText();
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitText(CharSequence text, int newCursorPosition) {
        return this.mTarget.commitText(text, newCursorPosition);
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitText(CharSequence text, int newCursorPosition, TextAttribute textAttribute) {
        return this.mTarget.commitText(text, newCursorPosition, textAttribute);
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitCompletion(CompletionInfo text) {
        return this.mTarget.commitCompletion(text);
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitCorrection(CorrectionInfo correctionInfo) {
        return this.mTarget.commitCorrection(correctionInfo);
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean setSelection(int start, int end) {
        return this.mTarget.setSelection(start, end);
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean performEditorAction(int editorAction) {
        return this.mTarget.performEditorAction(editorAction);
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean performContextMenuAction(int id2) {
        return this.mTarget.performContextMenuAction(id2);
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean beginBatchEdit() {
        return this.mTarget.beginBatchEdit();
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean endBatchEdit() {
        return this.mTarget.endBatchEdit();
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean sendKeyEvent(KeyEvent event) {
        return this.mTarget.sendKeyEvent(event);
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean clearMetaKeyStates(int states) {
        return this.mTarget.clearMetaKeyStates(states);
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean reportFullscreenMode(boolean enabled) {
        return this.mTarget.reportFullscreenMode(enabled);
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean performSpellCheck() {
        return this.mTarget.performSpellCheck();
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean performPrivateCommand(String action, Bundle data) {
        return this.mTarget.performPrivateCommand(action, data);
    }

    @Override // android.view.inputmethod.InputConnection
    public void performHandwritingGesture(HandwritingGesture gesture, Executor executor, IntConsumer consumer) {
        this.mTarget.performHandwritingGesture(gesture, executor, consumer);
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean previewHandwritingGesture(PreviewableHandwritingGesture gesture, CancellationSignal cancellationSignal) {
        return this.mTarget.previewHandwritingGesture(gesture, cancellationSignal);
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean requestCursorUpdates(int cursorUpdateMode) {
        return this.mTarget.requestCursorUpdates(cursorUpdateMode);
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean requestCursorUpdates(int cursorUpdateMode, int cursorUpdateFilter) {
        return this.mTarget.requestCursorUpdates(cursorUpdateMode, cursorUpdateFilter);
    }

    @Override // android.view.inputmethod.InputConnection
    public void requestTextBoundsInfo(RectF bounds, Executor executor, Consumer<TextBoundsInfoResult> consumer) {
        this.mTarget.requestTextBoundsInfo(bounds, executor, consumer);
    }

    @Override // android.view.inputmethod.InputConnection
    public Handler getHandler() {
        InputConnection inputConnection = this.mTarget;
        if (inputConnection == null) {
            Log.w("InputConnectionWrapper", "getHandler:target inputconcection not init.");
            return null;
        }
        return inputConnection.getHandler();
    }

    @Override // android.view.inputmethod.InputConnection
    public void closeConnection() {
        InputConnection inputConnection = this.mTarget;
        if (inputConnection == null) {
            Log.w("InputConnectionWrapper", "closeConnection:target inputconcection not init.");
        } else {
            inputConnection.closeConnection();
        }
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitContent(InputContentInfo inputContentInfo, int flags, Bundle opts) {
        return this.mTarget.commitContent(inputContentInfo, flags, opts);
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean setImeConsumesInput(boolean imeConsumesInput) {
        return this.mTarget.setImeConsumesInput(imeConsumesInput);
    }

    @Override // android.view.inputmethod.InputConnection
    public TextSnapshot takeSnapshot() {
        return this.mTarget.takeSnapshot();
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean replaceText(int start, int end, CharSequence text, int newCursorPosition, TextAttribute textAttribute) {
        return this.mTarget.replaceText(start, end, text, newCursorPosition, textAttribute);
    }
}
