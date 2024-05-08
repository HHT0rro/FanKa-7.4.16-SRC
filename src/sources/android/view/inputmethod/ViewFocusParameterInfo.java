package android.view.inputmethod;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
final class ViewFocusParameterInfo {
    final EditorInfo mPreviousEditorInfo;
    final int mPreviousSoftInputMode;
    final int mPreviousStartInputFlags;
    final int mPreviousStartInputReason;
    final int mPreviousWindowFlags;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewFocusParameterInfo(EditorInfo previousEditorInfo, int previousStartInputFlags, int previousStartInputReason, int previousSoftInputMode, int previousWindowFlags) {
        this.mPreviousEditorInfo = previousEditorInfo;
        this.mPreviousStartInputFlags = previousStartInputFlags;
        this.mPreviousStartInputReason = previousStartInputReason;
        this.mPreviousSoftInputMode = previousSoftInputMode;
        this.mPreviousWindowFlags = previousWindowFlags;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean sameAs(EditorInfo currentEditorInfo, int startInputFlags, int startInputReason, int softInputMode, int windowFlags) {
        EditorInfo editorInfo;
        return this.mPreviousStartInputFlags == startInputFlags && this.mPreviousStartInputReason == startInputReason && this.mPreviousSoftInputMode == softInputMode && this.mPreviousWindowFlags == windowFlags && ((editorInfo = this.mPreviousEditorInfo) == currentEditorInfo || (editorInfo != null && editorInfo.kindofEquals(currentEditorInfo)));
    }
}
