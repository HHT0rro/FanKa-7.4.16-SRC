package android.view.inputmethod;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.MetaKeyKeyListener;
import android.util.Log;
import android.util.LogPrinter;
import android.view.ContentInfo;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.View;
import com.android.internal.util.Preconditions;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class BaseInputConnection implements InputConnection {
    private static final String TAG = "BaseInputConnection";
    private Object[] mDefaultComposingSpans;
    Editable mEditable;
    final boolean mFallbackMode;
    protected final InputMethodManager mIMM;
    KeyCharacterMap mKeyCharacterMap;
    final View mTargetView;
    private static boolean DEBUG = false;
    static final Object COMPOSING = new ComposingText();
    private static int INVALID_INDEX = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseInputConnection(InputMethodManager mgr, boolean fullEditor) {
        this.mIMM = mgr;
        this.mTargetView = null;
        this.mFallbackMode = !fullEditor;
    }

    public BaseInputConnection(View targetView, boolean fullEditor) {
        this.mIMM = (InputMethodManager) targetView.getContext().getSystemService("input_method");
        this.mTargetView = targetView;
        this.mFallbackMode = !fullEditor;
    }

    public static final void removeComposingSpans(Spannable text) {
        text.removeSpan(COMPOSING);
        Object[] sps = text.getSpans(0, text.length(), Object.class);
        if (sps != null) {
            for (int i10 = sps.length - 1; i10 >= 0; i10--) {
                Object o10 = sps[i10];
                if ((text.getSpanFlags(o10) & 256) != 0) {
                    text.removeSpan(o10);
                }
            }
        }
    }

    public static void setComposingSpans(Spannable text) {
        setComposingSpans(text, 0, text.length());
    }

    public static void setComposingSpans(Spannable text, int start, int end) {
        Object[] sps = text.getSpans(start, end, Object.class);
        if (sps != null) {
            for (int i10 = sps.length - 1; i10 >= 0; i10--) {
                Object o10 = sps[i10];
                if (o10 == COMPOSING) {
                    text.removeSpan(o10);
                } else {
                    int fl = text.getSpanFlags(o10);
                    if ((fl & 307) != 289) {
                        text.setSpan(o10, text.getSpanStart(o10), text.getSpanEnd(o10), (fl & (-52)) | 256 | 33);
                    }
                }
            }
        }
        text.setSpan(COMPOSING, start, end, 289);
    }

    public static int getComposingSpanStart(Spannable text) {
        return text.getSpanStart(COMPOSING);
    }

    public static int getComposingSpanEnd(Spannable text) {
        return text.getSpanEnd(COMPOSING);
    }

    public Editable getEditable() {
        if (this.mEditable == null) {
            Editable newEditable = Editable.Factory.getInstance().newEditable("");
            this.mEditable = newEditable;
            Selection.setSelection(newEditable, 0);
        }
        return this.mEditable;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean beginBatchEdit() {
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean endBatchEdit() {
        return false;
    }

    public void endComposingRegionEditInternal() {
    }

    @Override // android.view.inputmethod.InputConnection
    public void closeConnection() {
        finishComposingText();
        setImeConsumesInput(false);
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean clearMetaKeyStates(int states) {
        Editable content = getEditable();
        if (content == null) {
            return false;
        }
        MetaKeyKeyListener.clearMetaKeyState(content, states);
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitCompletion(CompletionInfo text) {
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitCorrection(CorrectionInfo correctionInfo) {
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitText(CharSequence text, int newCursorPosition) {
        if (DEBUG) {
            Log.v(TAG, "commitText(" + ((Object) text) + ", " + newCursorPosition + ")");
        }
        replaceText(text, newCursorPosition, false);
        sendCurrentText();
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean deleteSurroundingText(int beforeLength, int afterLength) {
        if (DEBUG) {
            Log.v(TAG, "deleteSurroundingText(" + beforeLength + ", " + afterLength + ")");
        }
        Editable content = getEditable();
        if (content == null) {
            return false;
        }
        beginBatchEdit();
        int a10 = Selection.getSelectionStart(content);
        int b4 = Selection.getSelectionEnd(content);
        if (a10 > b4) {
            a10 = b4;
            b4 = a10;
        }
        if (a10 == -1 || b4 == -1) {
            endBatchEdit();
            return false;
        }
        int ca2 = getComposingSpanStart(content);
        int cb2 = getComposingSpanEnd(content);
        if (cb2 < ca2) {
            ca2 = cb2;
            cb2 = ca2;
        }
        if (ca2 != -1 && cb2 != -1) {
            if (ca2 < a10) {
                a10 = ca2;
            }
            if (cb2 > b4) {
                b4 = cb2;
            }
        }
        int deleted = 0;
        if (beforeLength > 0) {
            int start = a10 - beforeLength;
            if (start < 0) {
                start = 0;
            }
            int numDeleteBefore = a10 - start;
            if (a10 >= 0 && numDeleteBefore > 0) {
                content.delete(start, a10);
                deleted = numDeleteBefore;
            }
        }
        if (afterLength > 0) {
            int b10 = b4 - deleted;
            int end = b10 + afterLength;
            if (end > content.length()) {
                end = content.length();
            }
            int numDeleteAfter = end - b10;
            if (b10 >= 0 && numDeleteAfter > 0) {
                content.delete(b10, end);
            }
        }
        endBatchEdit();
        return true;
    }

    private static int findIndexBackward(CharSequence cs, int from, int numCodePoints) {
        int currentIndex = from;
        boolean waitingHighSurrogate = false;
        int N = cs.length();
        if (currentIndex < 0 || N < currentIndex) {
            int remainingCodePoints = INVALID_INDEX;
            return remainingCodePoints;
        }
        if (numCodePoints < 0) {
            return INVALID_INDEX;
        }
        int remainingCodePoints2 = numCodePoints;
        while (remainingCodePoints2 != 0) {
            currentIndex--;
            if (currentIndex < 0) {
                if (waitingHighSurrogate) {
                    return INVALID_INDEX;
                }
                return 0;
            }
            char c4 = cs.charAt(currentIndex);
            if (waitingHighSurrogate) {
                if (!Character.isHighSurrogate(c4)) {
                    return INVALID_INDEX;
                }
                waitingHighSurrogate = false;
                remainingCodePoints2--;
            } else if (!Character.isSurrogate(c4)) {
                remainingCodePoints2--;
            } else {
                if (Character.isHighSurrogate(c4)) {
                    return INVALID_INDEX;
                }
                waitingHighSurrogate = true;
            }
        }
        return currentIndex;
    }

    private static int findIndexForward(CharSequence cs, int from, int numCodePoints) {
        int currentIndex = from;
        boolean waitingLowSurrogate = false;
        int N = cs.length();
        if (currentIndex < 0 || N < currentIndex) {
            int remainingCodePoints = INVALID_INDEX;
            return remainingCodePoints;
        }
        if (numCodePoints < 0) {
            return INVALID_INDEX;
        }
        int remainingCodePoints2 = numCodePoints;
        while (remainingCodePoints2 != 0) {
            if (currentIndex >= N) {
                if (waitingLowSurrogate) {
                    return INVALID_INDEX;
                }
                return N;
            }
            char c4 = cs.charAt(currentIndex);
            if (waitingLowSurrogate) {
                if (!Character.isLowSurrogate(c4)) {
                    return INVALID_INDEX;
                }
                remainingCodePoints2--;
                waitingLowSurrogate = false;
                currentIndex++;
            } else if (!Character.isSurrogate(c4)) {
                remainingCodePoints2--;
                currentIndex++;
            } else {
                if (Character.isLowSurrogate(c4)) {
                    return INVALID_INDEX;
                }
                waitingLowSurrogate = true;
                currentIndex++;
            }
        }
        return currentIndex;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean deleteSurroundingTextInCodePoints(int beforeLength, int afterLength) {
        int start;
        int end;
        if (DEBUG) {
            Log.v(TAG, "deleteSurroundingText " + beforeLength + " / " + afterLength);
        }
        Editable content = getEditable();
        if (content == null) {
            return false;
        }
        beginBatchEdit();
        int a10 = Selection.getSelectionStart(content);
        int b4 = Selection.getSelectionEnd(content);
        if (a10 > b4) {
            a10 = b4;
            b4 = a10;
        }
        int ca2 = getComposingSpanStart(content);
        int cb2 = getComposingSpanEnd(content);
        if (cb2 < ca2) {
            ca2 = cb2;
            cb2 = ca2;
        }
        if (ca2 != -1 && cb2 != -1) {
            if (ca2 < a10) {
                a10 = ca2;
            }
            if (cb2 > b4) {
                b4 = cb2;
            }
        }
        if (a10 >= 0 && b4 >= 0 && (start = findIndexBackward(content, a10, Math.max(beforeLength, 0))) != INVALID_INDEX && (end = findIndexForward(content, b4, Math.max(afterLength, 0))) != INVALID_INDEX) {
            int numDeleteBefore = a10 - start;
            if (numDeleteBefore > 0) {
                content.delete(start, a10);
            }
            int numDeleteAfter = end - b4;
            if (numDeleteAfter > 0) {
                content.delete(b4 - numDeleteBefore, end - numDeleteBefore);
            }
        }
        endBatchEdit();
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean finishComposingText() {
        if (DEBUG) {
            Log.v(TAG, "finishComposingText");
        }
        Editable content = getEditable();
        if (content != null) {
            beginBatchEdit();
            removeComposingSpans(content);
            sendCurrentText();
            endBatchEdit();
            endComposingRegionEditInternal();
            return true;
        }
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public int getCursorCapsMode(int reqModes) {
        Editable content;
        if (this.mFallbackMode || (content = getEditable()) == null) {
            return 0;
        }
        int a10 = Selection.getSelectionStart(content);
        int b4 = Selection.getSelectionEnd(content);
        if (a10 > b4) {
            a10 = b4;
        }
        int tmp = TextUtils.getCapsMode(content, a10, reqModes);
        return tmp;
    }

    @Override // android.view.inputmethod.InputConnection
    public ExtractedText getExtractedText(ExtractedTextRequest request, int flags) {
        return null;
    }

    @Override // android.view.inputmethod.InputConnection
    public CharSequence getTextBeforeCursor(int length, int flags) {
        Preconditions.checkArgumentNonnegative(length);
        Editable content = getEditable();
        if (content == null) {
            return null;
        }
        int a10 = Selection.getSelectionStart(content);
        int b4 = Selection.getSelectionEnd(content);
        if (a10 > b4) {
            a10 = b4;
        }
        if (a10 <= 0) {
            return "";
        }
        if (length > a10) {
            length = a10;
        }
        if ((flags & 1) != 0) {
            return content.subSequence(a10 - length, a10);
        }
        return TextUtils.substring(content, a10 - length, a10);
    }

    @Override // android.view.inputmethod.InputConnection
    public CharSequence getSelectedText(int flags) {
        Editable content = getEditable();
        if (content == null) {
            return null;
        }
        int a10 = Selection.getSelectionStart(content);
        int b4 = Selection.getSelectionEnd(content);
        if (a10 > b4) {
            a10 = b4;
            b4 = a10;
        }
        if (a10 == b4 || a10 < 0) {
            return null;
        }
        if ((flags & 1) != 0) {
            return content.subSequence(a10, b4);
        }
        return TextUtils.substring(content, a10, b4);
    }

    @Override // android.view.inputmethod.InputConnection
    public CharSequence getTextAfterCursor(int length, int flags) {
        Preconditions.checkArgumentNonnegative(length);
        Editable content = getEditable();
        if (content == null) {
            return null;
        }
        int a10 = Selection.getSelectionStart(content);
        int b4 = Selection.getSelectionEnd(content);
        if (a10 > b4) {
            b4 = a10;
        }
        if (b4 < 0) {
            b4 = 0;
        }
        int end = (int) Math.min(b4 + length, content.length());
        if ((flags & 1) != 0) {
            return content.subSequence(b4, end);
        }
        return TextUtils.substring(content, b4, end);
    }

    @Override // android.view.inputmethod.InputConnection
    public SurroundingText getSurroundingText(int beforeLength, int afterLength, int flags) {
        CharSequence surroundingText;
        Preconditions.checkArgumentNonnegative(beforeLength);
        Preconditions.checkArgumentNonnegative(afterLength);
        Editable content = getEditable();
        if (content == null || this.mEditable == content) {
            return super.getSurroundingText(beforeLength, afterLength, flags);
        }
        int selStart = Selection.getSelectionStart(content);
        int selEnd = Selection.getSelectionEnd(content);
        if (selStart < 0 || selEnd < 0) {
            return null;
        }
        if (selStart > selEnd) {
            selStart = selEnd;
            selEnd = selStart;
        }
        int startPos = Math.max(0, selStart - beforeLength);
        int endPos = (int) Math.min(selEnd + afterLength, content.length());
        if ((flags & 1) != 0) {
            surroundingText = content.subSequence(startPos, endPos);
        } else {
            surroundingText = TextUtils.substring(content, startPos, endPos);
        }
        return new SurroundingText(surroundingText, selStart - startPos, selEnd - startPos, startPos);
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean performEditorAction(int actionCode) {
        long eventTime = SystemClock.uptimeMillis();
        sendKeyEvent(new KeyEvent(eventTime, eventTime, 0, 66, 0, 0, -1, 0, 22));
        sendKeyEvent(new KeyEvent(SystemClock.uptimeMillis(), eventTime, 1, 66, 0, 0, -1, 0, 22));
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean performContextMenuAction(int id2) {
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean performPrivateCommand(String action, Bundle data) {
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean requestCursorUpdates(int cursorUpdateMode) {
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public Handler getHandler() {
        return null;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean setComposingText(CharSequence text, int newCursorPosition) {
        if (DEBUG) {
            Log.v(TAG, "setComposingText(" + ((Object) text) + ", " + newCursorPosition + ")");
        }
        replaceText(text, newCursorPosition, true);
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean setComposingRegion(int start, int end) {
        if (DEBUG) {
            Log.v(TAG, "setComposingRegion(" + start + ", " + end + ")");
        }
        Editable content = getEditable();
        if (content != null) {
            beginBatchEdit();
            removeComposingSpans(content);
            int a10 = start;
            int b4 = end;
            if (a10 > b4) {
                a10 = b4;
                b4 = a10;
            }
            int length = content.length();
            if (a10 < 0) {
                a10 = 0;
            }
            if (b4 < 0) {
                b4 = 0;
            }
            if (a10 > length) {
                a10 = length;
            }
            if (b4 > length) {
                b4 = length;
            }
            ensureDefaultComposingSpans();
            if (this.mDefaultComposingSpans != null) {
                int i10 = 0;
                while (true) {
                    Object[] objArr = this.mDefaultComposingSpans;
                    if (i10 >= objArr.length) {
                        break;
                    }
                    content.setSpan(objArr[i10], a10, b4, 289);
                    i10++;
                }
            }
            content.setSpan(COMPOSING, a10, b4, 289);
            sendCurrentText();
            endBatchEdit();
            endComposingRegionEditInternal();
            return true;
        }
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean setSelection(int start, int end) {
        if (DEBUG) {
            Log.v(TAG, "setSelection(" + start + ", " + end + ")");
        }
        Editable content = getEditable();
        if (content == null) {
            return false;
        }
        int len = content.length();
        if (start > len || end > len || start < 0 || end < 0) {
            return true;
        }
        if (start == end && MetaKeyKeyListener.getMetaState(content, 2048) != 0) {
            Selection.extendSelection(content, start);
        } else {
            Selection.setSelection(content, start, end);
        }
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean sendKeyEvent(KeyEvent event) {
        this.mIMM.dispatchKeyEventFromInputMethod(this.mTargetView, event);
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean reportFullscreenMode(boolean enabled) {
        return true;
    }

    private void sendCurrentText() {
        Editable content;
        int N;
        if (!this.mFallbackMode || (content = getEditable()) == null || (N = content.length()) == 0) {
            return;
        }
        if (N == 1) {
            if (this.mKeyCharacterMap == null) {
                this.mKeyCharacterMap = KeyCharacterMap.load(-1);
            }
            char[] chars = new char[1];
            content.getChars(0, 1, chars, 0);
            KeyEvent[] events = this.mKeyCharacterMap.getEvents(chars);
            if (events != null) {
                for (int i10 = 0; i10 < events.length; i10++) {
                    if (DEBUG) {
                        Log.v(TAG, "Sending: " + ((Object) events[i10]));
                    }
                    sendKeyEvent(events[i10]);
                }
                content.clear();
                return;
            }
        }
        KeyEvent event = new KeyEvent(SystemClock.uptimeMillis(), content.toString(), -1, 0);
        sendKeyEvent(event);
        content.clear();
    }

    private void ensureDefaultComposingSpans() {
        Context context;
        if (this.mDefaultComposingSpans == null) {
            View view = this.mTargetView;
            if (view != null) {
                context = view.getContext();
            } else {
                context = this.mIMM.getFallbackContextFromServedView();
            }
            if (context != null) {
                TypedArray ta2 = context.getTheme().obtainStyledAttributes(new int[]{16843312});
                CharSequence style = ta2.getText(0);
                ta2.recycle();
                if (style != null && (style instanceof Spanned)) {
                    this.mDefaultComposingSpans = ((Spanned) style).getSpans(0, style.length(), Object.class);
                }
            }
        }
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean replaceText(int start, int end, CharSequence text, int newCursorPosition, TextAttribute textAttribute) {
        Preconditions.checkArgumentNonnegative(start);
        Preconditions.checkArgumentNonnegative(end);
        if (DEBUG) {
            Log.v(TAG, "replaceText " + start + ", " + end + ", " + ((Object) text) + ", " + newCursorPosition);
        }
        Editable content = getEditable();
        if (content == null) {
            return false;
        }
        beginBatchEdit();
        removeComposingSpans(content);
        int len = content.length();
        int start2 = Math.min(start, len);
        int end2 = Math.min(end, len);
        if (end2 < start2) {
            start2 = end2;
            end2 = start2;
        }
        replaceTextInternal(start2, end2, text, newCursorPosition, false);
        endBatchEdit();
        return true;
    }

    private void replaceText(CharSequence text, int newCursorPosition, boolean composing) {
        Editable content = getEditable();
        if (content == null || text == null) {
            return;
        }
        beginBatchEdit();
        int a10 = getComposingSpanStart(content);
        int b4 = getComposingSpanEnd(content);
        if (DEBUG) {
            Log.v(TAG, "Composing span: " + a10 + " to " + b4);
        }
        if (b4 < a10) {
            a10 = b4;
            b4 = a10;
        }
        if (a10 != -1 && b4 != -1) {
            removeComposingSpans(content);
        } else {
            a10 = Selection.getSelectionStart(content);
            b4 = Selection.getSelectionEnd(content);
            if (a10 < 0) {
                a10 = 0;
            }
            if (b4 < 0) {
                b4 = 0;
            }
            if (b4 < a10) {
                int tmp = a10;
                a10 = b4;
                b4 = tmp;
            }
        }
        replaceTextInternal(a10, b4, text, newCursorPosition, composing);
        endBatchEdit();
    }

    private void replaceTextInternal(int a10, int b4, CharSequence text, int newCursorPosition, boolean composing) {
        int newCursorPosition2;
        Spannable sp;
        Editable content = getEditable();
        if (content == null) {
            return;
        }
        if (composing) {
            if (!(text instanceof Spannable)) {
                sp = new SpannableStringBuilder(text);
                text = sp;
                ensureDefaultComposingSpans();
                if (this.mDefaultComposingSpans != null) {
                    int i10 = 0;
                    while (true) {
                        Object[] objArr = this.mDefaultComposingSpans;
                        if (i10 >= objArr.length) {
                            break;
                        }
                        sp.setSpan(objArr[i10], 0, sp.length(), 289);
                        i10++;
                    }
                }
            } else {
                sp = (Spannable) text;
            }
            setComposingSpans(sp);
        }
        if (DEBUG) {
            Log.v(TAG, "Replacing from " + a10 + " to " + b4 + " with \"" + ((Object) text) + "\", composing=" + composing + ", newCursorPosition=" + newCursorPosition + ", type=" + text.getClass().getCanonicalName());
            LogPrinter lp = new LogPrinter(2, TAG);
            lp.println("Current text:");
            TextUtils.dumpSpans(content, lp, "  ");
            lp.println("Composing text:");
            TextUtils.dumpSpans(text, lp, "  ");
        }
        if (newCursorPosition > 0) {
            newCursorPosition2 = newCursorPosition + (b4 - 1);
        } else {
            newCursorPosition2 = newCursorPosition + a10;
        }
        if (newCursorPosition2 < 0) {
            newCursorPosition2 = 0;
        }
        if (newCursorPosition2 > content.length()) {
            newCursorPosition2 = content.length();
        }
        Selection.setSelection(content, newCursorPosition2);
        content.replace(a10, b4, text);
        if (newCursorPosition == 0 && a10 == b4) {
            Selection.setSelection(content, newCursorPosition2);
        }
        if (DEBUG) {
            LogPrinter lp2 = new LogPrinter(2, TAG);
            lp2.println("Final text:");
            TextUtils.dumpSpans(content, lp2, "  ");
        }
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitContent(InputContentInfo inputContentInfo, int flags, Bundle opts) {
        if (this.mTargetView == null) {
            return false;
        }
        ClipDescription description = inputContentInfo.getDescription();
        if (this.mTargetView.getReceiveContentMimeTypes() == null) {
            if (DEBUG) {
                Log.d(TAG, "Can't insert content from IME: content=" + ((Object) description));
            }
            return false;
        }
        if ((flags & 1) != 0) {
            try {
                inputContentInfo.requestPermission();
            } catch (Exception e2) {
                Log.w(TAG, "Can't insert content from IME; requestPermission() failed", e2);
                return false;
            }
        }
        ClipData clip = new ClipData(inputContentInfo.getDescription(), new ClipData.Item(inputContentInfo.getContentUri()));
        ContentInfo payload = new ContentInfo.Builder(clip, 2).setLinkUri(inputContentInfo.getLinkUri()).setExtras(opts).setInputContentInfo(inputContentInfo).build();
        return this.mTargetView.performReceiveContent(payload) == null;
    }

    @Override // android.view.inputmethod.InputConnection
    public TextSnapshot takeSnapshot() {
        Editable content = getEditable();
        if (content == null) {
            return null;
        }
        int composingStart = getComposingSpanStart(content);
        int composingEnd = getComposingSpanEnd(content);
        if (composingEnd < composingStart) {
            composingStart = composingEnd;
            composingEnd = composingStart;
        }
        SurroundingText surroundingText = getSurroundingText(1024, 1024, 1);
        if (surroundingText == null) {
            return null;
        }
        int cursorCapsMode = getCursorCapsMode(KeyEvent.META_CTRL_MASK);
        return new TextSnapshot(surroundingText, composingStart, composingEnd, cursorCapsMode);
    }
}
