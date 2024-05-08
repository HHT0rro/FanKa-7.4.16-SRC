package android.view.inputmethod;

import android.graphics.RectF;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.android.internal.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface InputConnection {
    public static final int CURSOR_UPDATE_FILTER_CHARACTER_BOUNDS = 8;
    public static final int CURSOR_UPDATE_FILTER_EDITOR_BOUNDS = 4;
    public static final int CURSOR_UPDATE_FILTER_INSERTION_MARKER = 16;
    public static final int CURSOR_UPDATE_FILTER_TEXT_APPEARANCE = 64;
    public static final int CURSOR_UPDATE_FILTER_VISIBLE_LINE_BOUNDS = 32;
    public static final int CURSOR_UPDATE_IMMEDIATE = 1;
    public static final int CURSOR_UPDATE_MONITOR = 2;
    public static final int GET_EXTRACTED_TEXT_MONITOR = 1;
    public static final int GET_TEXT_WITH_STYLES = 1;
    public static final int HANDWRITING_GESTURE_RESULT_CANCELLED = 4;
    public static final int HANDWRITING_GESTURE_RESULT_FAILED = 3;
    public static final int HANDWRITING_GESTURE_RESULT_FALLBACK = 5;
    public static final int HANDWRITING_GESTURE_RESULT_SUCCESS = 1;
    public static final int HANDWRITING_GESTURE_RESULT_UNKNOWN = 0;
    public static final int HANDWRITING_GESTURE_RESULT_UNSUPPORTED = 2;
    public static final int INPUT_CONTENT_GRANT_READ_URI_PERMISSION = 1;

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public @interface CursorUpdateFilter {
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public @interface CursorUpdateMode {
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public @interface GetTextType {
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public @interface HandwritingGestureResult {
    }

    boolean beginBatchEdit();

    boolean clearMetaKeyStates(int i10);

    void closeConnection();

    boolean commitCompletion(CompletionInfo completionInfo);

    boolean commitContent(InputContentInfo inputContentInfo, int i10, Bundle bundle);

    boolean commitCorrection(CorrectionInfo correctionInfo);

    boolean commitText(CharSequence charSequence, int i10);

    boolean deleteSurroundingText(int i10, int i11);

    boolean deleteSurroundingTextInCodePoints(int i10, int i11);

    boolean endBatchEdit();

    boolean finishComposingText();

    int getCursorCapsMode(int i10);

    ExtractedText getExtractedText(ExtractedTextRequest extractedTextRequest, int i10);

    Handler getHandler();

    CharSequence getSelectedText(int i10);

    CharSequence getTextAfterCursor(int i10, int i11);

    CharSequence getTextBeforeCursor(int i10, int i11);

    boolean performContextMenuAction(int i10);

    boolean performEditorAction(int i10);

    boolean performPrivateCommand(String str, Bundle bundle);

    boolean reportFullscreenMode(boolean z10);

    boolean requestCursorUpdates(int i10);

    boolean sendKeyEvent(KeyEvent keyEvent);

    boolean setComposingRegion(int i10, int i11);

    boolean setComposingText(CharSequence charSequence, int i10);

    boolean setSelection(int i10, int i11);

    default SurroundingText getSurroundingText(int beforeLength, int afterLength, int flags) {
        CharSequence textAfterCursor;
        Preconditions.checkArgumentNonnegative(beforeLength);
        Preconditions.checkArgumentNonnegative(afterLength);
        CharSequence textBeforeCursor = getTextBeforeCursor(beforeLength, flags);
        if (textBeforeCursor == null || (textAfterCursor = getTextAfterCursor(afterLength, flags)) == null) {
            return null;
        }
        CharSequence selectedText = getSelectedText(flags);
        if (selectedText == null) {
            selectedText = "";
        }
        CharSequence surroundingText = TextUtils.concat(textBeforeCursor, selectedText, textAfterCursor);
        return new SurroundingText(surroundingText, textBeforeCursor.length(), textBeforeCursor.length() + selectedText.length(), -1);
    }

    default boolean setComposingText(CharSequence text, int newCursorPosition, TextAttribute textAttribute) {
        return setComposingText(text, newCursorPosition);
    }

    default boolean setComposingRegion(int start, int end, TextAttribute textAttribute) {
        return setComposingRegion(start, end);
    }

    default boolean commitText(CharSequence text, int newCursorPosition, TextAttribute textAttribute) {
        return commitText(text, newCursorPosition);
    }

    default boolean performSpellCheck() {
        return false;
    }

    default void performHandwritingGesture(HandwritingGesture gesture, Executor executor, final IntConsumer consumer) {
        if (executor != null && consumer != null) {
            executor.execute(new Runnable() { // from class: android.view.inputmethod.InputConnection$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    IntConsumer.this.accept(2);
                }
            });
        }
    }

    default boolean previewHandwritingGesture(PreviewableHandwritingGesture gesture, CancellationSignal cancellationSignal) {
        return false;
    }

    default boolean requestCursorUpdates(int cursorUpdateMode, int cursorUpdateFilter) {
        if (cursorUpdateFilter == 0) {
            return requestCursorUpdates(cursorUpdateMode);
        }
        return false;
    }

    default void requestTextBoundsInfo(RectF bounds, Executor executor, final Consumer<TextBoundsInfoResult> consumer) {
        Objects.requireNonNull(executor);
        Objects.requireNonNull(consumer);
        executor.execute(new Runnable() { // from class: android.view.inputmethod.InputConnection$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                Consumer.this.accept(new TextBoundsInfoResult(0));
            }
        });
    }

    default boolean setImeConsumesInput(boolean imeConsumesInput) {
        return false;
    }

    default TextSnapshot takeSnapshot() {
        return null;
    }

    default boolean replaceText(int start, int end, CharSequence text, int newCursorPosition, TextAttribute textAttribute) {
        Preconditions.checkArgumentNonnegative(start);
        Preconditions.checkArgumentNonnegative(end);
        beginBatchEdit();
        finishComposingText();
        setSelection(start, end);
        commitText(text, newCursorPosition, textAttribute);
        endBatchEdit();
        return true;
    }
}
