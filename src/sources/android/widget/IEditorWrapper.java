package android.widget;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface IEditorWrapper {

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public interface ISelectionModifierCursorControllerWrapper {
        default void setMinTouchOffset(int offset) {
        }

        default void setMaxTouchOffset(int offset) {
        }
    }

    default IEditorExt getEditorExt() {
        return null;
    }

    default TextView getTextView() {
        return null;
    }

    default long getShowCursor() {
        return 0L;
    }

    default void setShowCursor(long showCursor) {
    }

    default void suspendBlink() {
    }

    default void resumeBlink() {
    }
}
