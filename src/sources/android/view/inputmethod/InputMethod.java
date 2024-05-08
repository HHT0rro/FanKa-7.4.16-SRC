package android.view.inputmethod;

import android.os.IBinder;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.util.Log;
import android.view.InputChannel;
import android.view.MotionEvent;
import android.view.inputmethod.ImeTracker;
import com.android.internal.inputmethod.IInlineSuggestionsRequestCallback;
import com.android.internal.inputmethod.IInputMethod;
import com.android.internal.inputmethod.InlineSuggestionsRequestInfo;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface InputMethod {
    public static final String SERVICE_INTERFACE = "android.view.InputMethod";
    public static final String SERVICE_META_DATA = "android.view.im";
    public static final int SHOW_EXPLICIT = 1;
    public static final int SHOW_FORCED = 2;
    public static final String TAG = "InputMethod";

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public interface SessionCallback {
        void sessionCreated(InputMethodSession inputMethodSession);
    }

    void attachToken(IBinder iBinder);

    void bindInput(InputBinding inputBinding);

    void changeInputMethodSubtype(InputMethodSubtype inputMethodSubtype);

    void createSession(SessionCallback sessionCallback);

    void hideSoftInput(int i10, ResultReceiver resultReceiver);

    void restartInput(InputConnection inputConnection, EditorInfo editorInfo);

    void revokeSession(InputMethodSession inputMethodSession);

    void setSessionEnabled(InputMethodSession inputMethodSession, boolean z10);

    void showSoftInput(int i10, ResultReceiver resultReceiver);

    void startInput(InputConnection inputConnection, EditorInfo editorInfo);

    void unbindInput();

    default void initializeInternal(IInputMethod.InitParams params) {
        attachToken(params.token);
    }

    default void onCreateInlineSuggestionsRequest(InlineSuggestionsRequestInfo requestInfo, IInlineSuggestionsRequestCallback cb2) {
        try {
            cb2.onInlineSuggestionsUnsupported();
        } catch (RemoteException e2) {
            Log.w(TAG, "Failed to call onInlineSuggestionsUnsupported.", e2);
        }
    }

    default void dispatchStartInput(InputConnection inputConnection, IInputMethod.StartInputParams params) {
        if (params.restarting) {
            restartInput(inputConnection, params.editorInfo);
        } else {
            startInput(inputConnection, params.editorInfo);
        }
    }

    default void onNavButtonFlagsChanged(int navButtonFlags) {
    }

    default void showSoftInputWithToken(int flags, ResultReceiver resultReceiver, IBinder showInputToken, ImeTracker.Token statsToken) {
        showSoftInput(flags, resultReceiver);
    }

    default void hideSoftInputWithToken(int flags, ResultReceiver resultReceiver, IBinder hideInputToken, ImeTracker.Token statsToken) {
        hideSoftInput(flags, resultReceiver);
    }

    default void canStartStylusHandwriting(int requestId) {
    }

    default void updateEditorToolType(int toolType) {
    }

    default void startStylusHandwriting(int requestId, InputChannel channel, List<MotionEvent> events) {
    }

    default void initInkWindow() {
    }

    default void finishStylusHandwriting() {
    }

    default void removeStylusHandwritingWindow() {
    }

    default void setStylusWindowIdleTimeoutForTest(long timeout) {
    }
}
