package android.view.inputmethod;

import android.app.PendingIntent$;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.CancellationSignalBeamer;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.ResultReceiver;
import android.os.Trace;
import android.util.Log;
import android.util.proto.ProtoOutputStream;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewRootImpl;
import android.view.inputmethod.RemoteInputConnectionImpl;
import com.alipay.sdk.util.i;
import com.android.internal.infra.AndroidFuture;
import com.android.internal.inputmethod.IRemoteAccessibilityInputConnection;
import com.android.internal.inputmethod.IRemoteInputConnection;
import com.android.internal.inputmethod.ImeTracing;
import com.android.internal.inputmethod.InputConnectionCommandHeader;
import com.android.internal.inputmethod.InputConnectionProtoDumper;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.Supplier;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class RemoteInputConnectionImpl extends IRemoteInputConnection.Stub {
    private static final boolean DEBUG = false;
    private static final int MAX_END_BATCH_EDIT_RETRY = 16;
    private static final String TAG = "RemoteInputConnectionImpl";
    private CancellationSignalBeamer.Receiver mBeamer;
    private final Handler mH;
    private InputConnection mInputConnection;
    private final Looper mLooper;
    private final InputMethodManager mParentInputMethodManager;
    private final WeakReference<View> mServedView;
    private final Object mLock = new Object();
    private boolean mFinished = false;
    private final AtomicInteger mCurrentSessionId = new AtomicInteger(0);
    private final AtomicBoolean mHasPendingInvalidation = new AtomicBoolean();
    private final AtomicBoolean mIsCursorAnchorInfoMonitoring = new AtomicBoolean(false);
    private final AtomicBoolean mHasPendingImmediateCursorAnchorInfoUpdate = new AtomicBoolean(false);
    private final IRemoteAccessibilityInputConnection mAccessibilityInputConnection = new AnonymousClass1();

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    private @interface Dispatching {
        boolean cancellable();
    }

    /* renamed from: -$$Nest$smuseImeTracing, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m782$$Nest$smuseImeTracing() {
        return useImeTracing();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static final class KnownAlwaysTrueEndBatchEditCache {
        private static volatile Class<?>[] sArray;
        private static volatile Class<?> sElement;

        private KnownAlwaysTrueEndBatchEditCache() {
        }

        static boolean contains(Class<? extends InputConnection> klass) {
            if (klass == sElement) {
                return true;
            }
            Class<?>[] array = sArray;
            if (array == null) {
                return false;
            }
            for (Class<?> item : array) {
                if (item == klass) {
                    return true;
                }
            }
            return false;
        }

        static void add(Class<? extends InputConnection> klass) {
            if (sElement == null) {
                sElement = klass;
                return;
            }
            Class<?>[] array = sArray;
            int arraySize = array != null ? array.length : 0;
            Class<?>[] newArray = new Class[arraySize + 1];
            for (int i10 = 0; i10 < arraySize; i10++) {
                newArray[i10] = array[i10];
            }
            newArray[arraySize] = klass;
            sArray = newArray;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RemoteInputConnectionImpl(Looper looper, InputConnection inputConnection, InputMethodManager inputMethodManager, View servedView) {
        this.mInputConnection = inputConnection;
        this.mLooper = looper;
        this.mH = new Handler(looper);
        this.mParentInputMethodManager = inputMethodManager;
        this.mServedView = new WeakReference<>(servedView);
    }

    public InputConnection getInputConnection() {
        InputConnection inputConnection;
        synchronized (this.mLock) {
            inputConnection = this.mInputConnection;
        }
        return inputConnection;
    }

    public boolean hasPendingInvalidation() {
        return this.mHasPendingInvalidation.get();
    }

    private boolean isFinished() {
        boolean z10;
        synchronized (this.mLock) {
            z10 = this.mFinished;
        }
        return z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isActive() {
        return this.mParentInputMethodManager.isActive() && !isFinished();
    }

    private View getServedView() {
        return this.mServedView.get();
    }

    public boolean isAssociatedWith(View view) {
        if (view == null) {
            return false;
        }
        return this.mServedView.refersTo(view);
    }

    public boolean resetHasPendingImmediateCursorAnchorInfoUpdate() {
        return this.mHasPendingImmediateCursorAnchorInfoUpdate.getAndSet(false);
    }

    public boolean isCursorAnchorInfoMonitoring() {
        return this.mIsCursorAnchorInfoMonitoring.get();
    }

    public void scheduleInvalidateInput() {
        if (this.mHasPendingInvalidation.compareAndSet(false, true)) {
            final int nextSessionId = this.mCurrentSessionId.incrementAndGet();
            this.mH.post(new Runnable() { // from class: android.view.inputmethod.RemoteInputConnectionImpl$$ExternalSyntheticLambda25
                @Override // java.lang.Runnable
                public final void run() {
                    RemoteInputConnectionImpl.this.lambda$scheduleInvalidateInput$0(nextSessionId);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$scheduleInvalidateInput$0(int nextSessionId) {
        TextSnapshot textSnapshot;
        try {
            if (isFinished()) {
                return;
            }
            InputConnection ic2 = getInputConnection();
            if (ic2 == null) {
                return;
            }
            View view = getServedView();
            if (view == null) {
                return;
            }
            Class<?> cls = ic2.getClass();
            boolean alwaysTrueEndBatchEditDetected = KnownAlwaysTrueEndBatchEditCache.contains(cls);
            if (!alwaysTrueEndBatchEditDetected) {
                boolean supportsBatchEdit = ic2.beginBatchEdit();
                ic2.finishComposingText();
                if (supportsBatchEdit) {
                    int retryCount = 0;
                    while (true) {
                        if (!ic2.endBatchEdit()) {
                            break;
                        }
                        retryCount++;
                        if (retryCount > 16) {
                            Log.e(TAG, cls.getTypeName() + "#endBatchEdit() still returns true even after retrying 16 times.  Falling back to InputMethodManager#restartInput(View)");
                            alwaysTrueEndBatchEditDetected = true;
                            KnownAlwaysTrueEndBatchEditCache.add(cls);
                            break;
                        }
                    }
                }
            }
            if (alwaysTrueEndBatchEditDetected || (textSnapshot = ic2.takeSnapshot()) == null || !this.mParentInputMethodManager.doInvalidateInput(this, textSnapshot, nextSessionId)) {
                this.mParentInputMethodManager.restartInput(view);
            }
        } finally {
            this.mHasPendingInvalidation.set(false);
        }
    }

    public void deactivate() {
        if (isFinished()) {
            return;
        }
        dispatch(new Runnable() { // from class: android.view.inputmethod.RemoteInputConnectionImpl$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                RemoteInputConnectionImpl.this.lambda$deactivate$1();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$deactivate$1() {
        if (isFinished()) {
            return;
        }
        Trace.traceBegin(4L, "InputConnection#closeConnection");
        try {
            InputConnection ic2 = getInputConnection();
            if (ic2 == null) {
                synchronized (this.mLock) {
                    this.mInputConnection = null;
                    this.mFinished = true;
                }
                Trace.traceEnd(4L);
                return;
            }
            try {
                ic2.closeConnection();
            } catch (AbstractMethodError e2) {
            }
            synchronized (this.mLock) {
                this.mInputConnection = null;
                this.mFinished = true;
            }
            Trace.traceEnd(4L);
            final View servedView = this.mServedView.get();
            if (servedView != null) {
                Handler handler = servedView.getHandler();
                if (handler != null) {
                    if (handler.getLooper().isCurrentThread()) {
                        servedView.onInputConnectionClosedInternal();
                    } else {
                        Objects.requireNonNull(servedView);
                        handler.post(new Runnable() { // from class: android.view.inputmethod.RemoteInputConnectionImpl$$ExternalSyntheticLambda32
                            @Override // java.lang.Runnable
                            public final void run() {
                                View.this.onInputConnectionClosedInternal();
                            }
                        });
                    }
                }
                ViewRootImpl viewRoot = servedView.getViewRootImpl();
                if (viewRoot != null) {
                    viewRoot.getHandwritingInitiator().onInputConnectionClosed(servedView);
                }
            }
        } catch (Throwable th) {
            synchronized (this.mLock) {
                this.mInputConnection = null;
                this.mFinished = true;
                Trace.traceEnd(4L);
                throw th;
            }
        }
    }

    @Override // com.android.internal.inputmethod.IRemoteInputConnection
    public void cancelCancellationSignal(final IBinder token) {
        if (this.mBeamer == null) {
            return;
        }
        dispatch(new Runnable() { // from class: android.view.inputmethod.RemoteInputConnectionImpl$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                RemoteInputConnectionImpl.this.lambda$cancelCancellationSignal$2(token);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$cancelCancellationSignal$2(IBinder token) {
        this.mBeamer.cancel(token);
    }

    @Override // com.android.internal.inputmethod.IRemoteInputConnection
    public void forgetCancellationSignal(IBinder token) {
        CancellationSignalBeamer.Receiver receiver = this.mBeamer;
        if (receiver == null) {
            return;
        }
        receiver.forget(token);
    }

    public String toString() {
        return "RemoteInputConnectionImpl{connection=" + ((Object) getInputConnection()) + " finished=" + isFinished() + " mParentInputMethodManager.isActive()=" + this.mParentInputMethodManager.isActive() + " mServedView=" + ((Object) this.mServedView.get()) + i.f4738d;
    }

    public void dumpDebug(ProtoOutputStream proto, long fieldId) {
        synchronized (this.mLock) {
            if ((this.mInputConnection instanceof DumpableInputConnection) && this.mLooper.isCurrentThread()) {
                ((DumpableInputConnection) this.mInputConnection).dumpDebug(proto, fieldId);
            }
        }
    }

    public void dispatchReportFullscreenMode(final boolean enabled) {
        dispatch(new Runnable() { // from class: android.view.inputmethod.RemoteInputConnectionImpl$$ExternalSyntheticLambda24
            @Override // java.lang.Runnable
            public final void run() {
                RemoteInputConnectionImpl.this.lambda$dispatchReportFullscreenMode$3(enabled);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$dispatchReportFullscreenMode$3(boolean enabled) {
        InputConnection ic2 = getInputConnection();
        if (ic2 == null || !isActive()) {
            return;
        }
        ic2.reportFullscreenMode(enabled);
    }

    @Override // com.android.internal.inputmethod.IRemoteInputConnection
    public void getTextAfterCursor(final InputConnectionCommandHeader header, final int length, final int flags, AndroidFuture future) {
        dispatchWithTracing("getTextAfterCursor", future, new Supplier() { // from class: android.view.inputmethod.RemoteInputConnectionImpl$$ExternalSyntheticLambda13
            @Override // java.util.function.Supplier
            public final Object get() {
                CharSequence lambda$getTextAfterCursor$4;
                lambda$getTextAfterCursor$4 = RemoteInputConnectionImpl.this.lambda$getTextAfterCursor$4(header, length, flags);
                return lambda$getTextAfterCursor$4;
            }
        }, useImeTracing() ? new Function() { // from class: android.view.inputmethod.RemoteInputConnectionImpl$$ExternalSyntheticLambda14
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                byte[] buildGetTextAfterCursorProto;
                buildGetTextAfterCursorProto = InputConnectionProtoDumper.buildGetTextAfterCursorProto(length, flags, (CharSequence) obj);
                return buildGetTextAfterCursorProto;
            }
        } : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ CharSequence lambda$getTextAfterCursor$4(InputConnectionCommandHeader header, int length, int flags) {
        if (header.mSessionId != this.mCurrentSessionId.get()) {
            return null;
        }
        InputConnection ic2 = getInputConnection();
        if (ic2 == null || !isActive()) {
            Log.w(TAG, "getTextAfterCursor on inactive InputConnection");
            return null;
        }
        if (length < 0) {
            Log.i(TAG, "Returning null to getTextAfterCursor due to an invalid length=" + length);
            return null;
        }
        return ic2.getTextAfterCursor(length, flags);
    }

    @Override // com.android.internal.inputmethod.IRemoteInputConnection
    public void getTextBeforeCursor(final InputConnectionCommandHeader header, final int length, final int flags, AndroidFuture future) {
        dispatchWithTracing("getTextBeforeCursor", future, new Supplier() { // from class: android.view.inputmethod.RemoteInputConnectionImpl$$ExternalSyntheticLambda30
            @Override // java.util.function.Supplier
            public final Object get() {
                CharSequence lambda$getTextBeforeCursor$6;
                lambda$getTextBeforeCursor$6 = RemoteInputConnectionImpl.this.lambda$getTextBeforeCursor$6(header, length, flags);
                return lambda$getTextBeforeCursor$6;
            }
        }, useImeTracing() ? new Function() { // from class: android.view.inputmethod.RemoteInputConnectionImpl$$ExternalSyntheticLambda31
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                byte[] buildGetTextBeforeCursorProto;
                buildGetTextBeforeCursorProto = InputConnectionProtoDumper.buildGetTextBeforeCursorProto(length, flags, (CharSequence) obj);
                return buildGetTextBeforeCursorProto;
            }
        } : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ CharSequence lambda$getTextBeforeCursor$6(InputConnectionCommandHeader header, int length, int flags) {
        if (header.mSessionId != this.mCurrentSessionId.get()) {
            return null;
        }
        InputConnection ic2 = getInputConnection();
        if (ic2 == null || !isActive()) {
            Log.w(TAG, "getTextBeforeCursor on inactive InputConnection");
            return null;
        }
        if (length < 0) {
            Log.i(TAG, "Returning null to getTextBeforeCursor due to an invalid length=" + length);
            return null;
        }
        return ic2.getTextBeforeCursor(length, flags);
    }

    @Override // com.android.internal.inputmethod.IRemoteInputConnection
    public void getSelectedText(final InputConnectionCommandHeader header, final int flags, AndroidFuture future) {
        dispatchWithTracing("getSelectedText", future, new Supplier() { // from class: android.view.inputmethod.RemoteInputConnectionImpl$$ExternalSyntheticLambda26
            @Override // java.util.function.Supplier
            public final Object get() {
                CharSequence lambda$getSelectedText$8;
                lambda$getSelectedText$8 = RemoteInputConnectionImpl.this.lambda$getSelectedText$8(header, flags);
                return lambda$getSelectedText$8;
            }
        }, useImeTracing() ? new Function() { // from class: android.view.inputmethod.RemoteInputConnectionImpl$$ExternalSyntheticLambda27
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                byte[] buildGetSelectedTextProto;
                buildGetSelectedTextProto = InputConnectionProtoDumper.buildGetSelectedTextProto(flags, (CharSequence) obj);
                return buildGetSelectedTextProto;
            }
        } : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ CharSequence lambda$getSelectedText$8(InputConnectionCommandHeader header, int flags) {
        if (header.mSessionId != this.mCurrentSessionId.get()) {
            return null;
        }
        InputConnection ic2 = getInputConnection();
        if (ic2 == null || !isActive()) {
            Log.w(TAG, "getSelectedText on inactive InputConnection");
            return null;
        }
        try {
            return ic2.getSelectedText(flags);
        } catch (AbstractMethodError e2) {
            return null;
        }
    }

    @Override // com.android.internal.inputmethod.IRemoteInputConnection
    public void getSurroundingText(final InputConnectionCommandHeader header, final int beforeLength, final int afterLength, final int flags, AndroidFuture future) {
        dispatchWithTracing("getSurroundingText", future, new Supplier() { // from class: android.view.inputmethod.RemoteInputConnectionImpl$$ExternalSyntheticLambda28
            @Override // java.util.function.Supplier
            public final Object get() {
                SurroundingText lambda$getSurroundingText$10;
                lambda$getSurroundingText$10 = RemoteInputConnectionImpl.this.lambda$getSurroundingText$10(header, beforeLength, afterLength, flags);
                return lambda$getSurroundingText$10;
            }
        }, useImeTracing() ? new Function() { // from class: android.view.inputmethod.RemoteInputConnectionImpl$$ExternalSyntheticLambda29
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                byte[] buildGetSurroundingTextProto;
                buildGetSurroundingTextProto = InputConnectionProtoDumper.buildGetSurroundingTextProto(beforeLength, afterLength, flags, (SurroundingText) obj);
                return buildGetSurroundingTextProto;
            }
        } : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ SurroundingText lambda$getSurroundingText$10(InputConnectionCommandHeader header, int beforeLength, int afterLength, int flags) {
        if (header.mSessionId != this.mCurrentSessionId.get()) {
            return null;
        }
        InputConnection ic2 = getInputConnection();
        if (ic2 == null || !isActive()) {
            Log.w(TAG, "getSurroundingText on inactive InputConnection");
            return null;
        }
        if (beforeLength < 0) {
            Log.i(TAG, "Returning null to getSurroundingText due to an invalid beforeLength=" + beforeLength);
            return null;
        }
        if (afterLength < 0) {
            Log.i(TAG, "Returning null to getSurroundingText due to an invalid afterLength=" + afterLength);
            return null;
        }
        return ic2.getSurroundingText(beforeLength, afterLength, flags);
    }

    @Override // com.android.internal.inputmethod.IRemoteInputConnection
    public void getCursorCapsMode(final InputConnectionCommandHeader header, final int reqModes, AndroidFuture future) {
        dispatchWithTracing("getCursorCapsMode", future, new Supplier() { // from class: android.view.inputmethod.RemoteInputConnectionImpl$$ExternalSyntheticLambda45
            @Override // java.util.function.Supplier
            public final Object get() {
                Integer lambda$getCursorCapsMode$12;
                lambda$getCursorCapsMode$12 = RemoteInputConnectionImpl.this.lambda$getCursorCapsMode$12(header, reqModes);
                return lambda$getCursorCapsMode$12;
            }
        }, useImeTracing() ? new Function() { // from class: android.view.inputmethod.RemoteInputConnectionImpl$$ExternalSyntheticLambda46
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                byte[] buildGetCursorCapsModeProto;
                buildGetCursorCapsModeProto = InputConnectionProtoDumper.buildGetCursorCapsModeProto(reqModes, ((Integer) obj).intValue());
                return buildGetCursorCapsModeProto;
            }
        } : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Integer lambda$getCursorCapsMode$12(InputConnectionCommandHeader header, int reqModes) {
        if (header.mSessionId != this.mCurrentSessionId.get()) {
            return 0;
        }
        InputConnection ic2 = getInputConnection();
        if (ic2 == null || !isActive()) {
            Log.w(TAG, "getCursorCapsMode on inactive InputConnection");
            return 0;
        }
        return Integer.valueOf(ic2.getCursorCapsMode(reqModes));
    }

    @Override // com.android.internal.inputmethod.IRemoteInputConnection
    public void getExtractedText(final InputConnectionCommandHeader header, final ExtractedTextRequest request, final int flags, AndroidFuture future) {
        dispatchWithTracing("getExtractedText", future, new Supplier() { // from class: android.view.inputmethod.RemoteInputConnectionImpl$$ExternalSyntheticLambda3
            @Override // java.util.function.Supplier
            public final Object get() {
                ExtractedText lambda$getExtractedText$14;
                lambda$getExtractedText$14 = RemoteInputConnectionImpl.this.lambda$getExtractedText$14(header, request, flags);
                return lambda$getExtractedText$14;
            }
        }, useImeTracing() ? new Function() { // from class: android.view.inputmethod.RemoteInputConnectionImpl$$ExternalSyntheticLambda4
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                byte[] buildGetExtractedTextProto;
                buildGetExtractedTextProto = InputConnectionProtoDumper.buildGetExtractedTextProto(ExtractedTextRequest.this, flags, (ExtractedText) obj);
                return buildGetExtractedTextProto;
            }
        } : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ExtractedText lambda$getExtractedText$14(InputConnectionCommandHeader header, ExtractedTextRequest request, int flags) {
        if (header.mSessionId != this.mCurrentSessionId.get()) {
            return null;
        }
        InputConnection ic2 = getInputConnection();
        if (ic2 == null || !isActive()) {
            Log.w(TAG, "getExtractedText on inactive InputConnection");
            return null;
        }
        return ic2.getExtractedText(request, flags);
    }

    @Override // com.android.internal.inputmethod.IRemoteInputConnection
    public void commitText(final InputConnectionCommandHeader header, final CharSequence text, final int newCursorPosition) {
        dispatchWithTracing("commitText", new Runnable() { // from class: android.view.inputmethod.RemoteInputConnectionImpl$$ExternalSyntheticLambda15
            @Override // java.lang.Runnable
            public final void run() {
                RemoteInputConnectionImpl.this.lambda$commitText$16(header, text, newCursorPosition);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$commitText$16(InputConnectionCommandHeader header, CharSequence text, int newCursorPosition) {
        if (header.mSessionId != this.mCurrentSessionId.get() && header.mSessionId != -1) {
            return;
        }
        InputConnection ic2 = getInputConnection();
        if (ic2 == null || !isActive()) {
            Log.w(TAG, "commitText on inactive InputConnection");
        } else {
            ic2.commitText(text, newCursorPosition);
        }
    }

    @Override // com.android.internal.inputmethod.IRemoteInputConnection
    public void commitTextWithTextAttribute(final InputConnectionCommandHeader header, final CharSequence text, final int newCursorPosition, final TextAttribute textAttribute) {
        dispatchWithTracing("commitTextWithTextAttribute", new Runnable() { // from class: android.view.inputmethod.RemoteInputConnectionImpl$$ExternalSyntheticLambda47
            @Override // java.lang.Runnable
            public final void run() {
                RemoteInputConnectionImpl.this.lambda$commitTextWithTextAttribute$17(header, text, newCursorPosition, textAttribute);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$commitTextWithTextAttribute$17(InputConnectionCommandHeader header, CharSequence text, int newCursorPosition, TextAttribute textAttribute) {
        if (header.mSessionId != this.mCurrentSessionId.get()) {
            return;
        }
        InputConnection ic2 = getInputConnection();
        if (ic2 == null || !isActive()) {
            Log.w(TAG, "commitText on inactive InputConnection");
        } else {
            ic2.commitText(text, newCursorPosition, textAttribute);
        }
    }

    @Override // com.android.internal.inputmethod.IRemoteInputConnection
    public void commitCompletion(final InputConnectionCommandHeader header, final CompletionInfo text) {
        dispatchWithTracing("commitCompletion", new Runnable() { // from class: android.view.inputmethod.RemoteInputConnectionImpl$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                RemoteInputConnectionImpl.this.lambda$commitCompletion$18(header, text);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$commitCompletion$18(InputConnectionCommandHeader header, CompletionInfo text) {
        if (header.mSessionId != this.mCurrentSessionId.get()) {
            return;
        }
        InputConnection ic2 = getInputConnection();
        if (ic2 == null || !isActive()) {
            Log.w(TAG, "commitCompletion on inactive InputConnection");
        } else {
            ic2.commitCompletion(text);
        }
    }

    @Override // com.android.internal.inputmethod.IRemoteInputConnection
    public void commitCorrection(final InputConnectionCommandHeader header, final CorrectionInfo info) {
        dispatchWithTracing("commitCorrection", new Runnable() { // from class: android.view.inputmethod.RemoteInputConnectionImpl$$ExternalSyntheticLambda17
            @Override // java.lang.Runnable
            public final void run() {
                RemoteInputConnectionImpl.this.lambda$commitCorrection$19(header, info);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$commitCorrection$19(InputConnectionCommandHeader header, CorrectionInfo info) {
        if (header.mSessionId != this.mCurrentSessionId.get()) {
            return;
        }
        InputConnection ic2 = getInputConnection();
        if (ic2 == null || !isActive()) {
            Log.w(TAG, "commitCorrection on inactive InputConnection");
        } else {
            try {
                ic2.commitCorrection(info);
            } catch (AbstractMethodError e2) {
            }
        }
    }

    @Override // com.android.internal.inputmethod.IRemoteInputConnection
    public void setSelection(final InputConnectionCommandHeader header, final int start, final int end) {
        dispatchWithTracing("setSelection", new Runnable() { // from class: android.view.inputmethod.RemoteInputConnectionImpl$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                RemoteInputConnectionImpl.this.lambda$setSelection$20(header, start, end);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setSelection$20(InputConnectionCommandHeader header, int start, int end) {
        if (header.mSessionId != this.mCurrentSessionId.get()) {
            return;
        }
        InputConnection ic2 = getInputConnection();
        if (ic2 == null || !isActive()) {
            Log.w(TAG, "setSelection on inactive InputConnection");
        } else {
            ic2.setSelection(start, end);
        }
    }

    @Override // com.android.internal.inputmethod.IRemoteInputConnection
    public void performEditorAction(final InputConnectionCommandHeader header, final int id2) {
        dispatchWithTracing("performEditorAction", new Runnable() { // from class: android.view.inputmethod.RemoteInputConnectionImpl$$ExternalSyntheticLambda16
            @Override // java.lang.Runnable
            public final void run() {
                RemoteInputConnectionImpl.this.lambda$performEditorAction$21(header, id2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$performEditorAction$21(InputConnectionCommandHeader header, int id2) {
        if (header.mSessionId != this.mCurrentSessionId.get()) {
            return;
        }
        InputConnection ic2 = getInputConnection();
        if (ic2 == null || !isActive()) {
            Log.w(TAG, "performEditorAction on inactive InputConnection");
        } else {
            ic2.performEditorAction(id2);
        }
    }

    @Override // com.android.internal.inputmethod.IRemoteInputConnection
    public void performContextMenuAction(final InputConnectionCommandHeader header, final int id2) {
        dispatchWithTracing("performContextMenuAction", new Runnable() { // from class: android.view.inputmethod.RemoteInputConnectionImpl$$ExternalSyntheticLambda19
            @Override // java.lang.Runnable
            public final void run() {
                RemoteInputConnectionImpl.this.lambda$performContextMenuAction$22(header, id2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$performContextMenuAction$22(InputConnectionCommandHeader header, int id2) {
        if (header.mSessionId != this.mCurrentSessionId.get()) {
            return;
        }
        InputConnection ic2 = getInputConnection();
        if (ic2 == null || !isActive()) {
            Log.w(TAG, "performContextMenuAction on inactive InputConnection");
        } else {
            ic2.performContextMenuAction(id2);
        }
    }

    @Override // com.android.internal.inputmethod.IRemoteInputConnection
    public void setComposingRegion(final InputConnectionCommandHeader header, final int start, final int end) {
        dispatchWithTracing("setComposingRegion", new Runnable() { // from class: android.view.inputmethod.RemoteInputConnectionImpl$$ExternalSyntheticLambda44
            @Override // java.lang.Runnable
            public final void run() {
                RemoteInputConnectionImpl.this.lambda$setComposingRegion$23(header, start, end);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setComposingRegion$23(InputConnectionCommandHeader header, int start, int end) {
        if (header.mSessionId != this.mCurrentSessionId.get()) {
            return;
        }
        InputConnection ic2 = getInputConnection();
        if (ic2 == null || !isActive()) {
            Log.w(TAG, "setComposingRegion on inactive InputConnection");
        } else {
            try {
                ic2.setComposingRegion(start, end);
            } catch (AbstractMethodError e2) {
            }
        }
    }

    @Override // com.android.internal.inputmethod.IRemoteInputConnection
    public void setComposingRegionWithTextAttribute(final InputConnectionCommandHeader header, final int start, final int end, final TextAttribute textAttribute) {
        dispatchWithTracing("setComposingRegionWithTextAttribute", new Runnable() { // from class: android.view.inputmethod.RemoteInputConnectionImpl$$ExternalSyntheticLambda41
            @Override // java.lang.Runnable
            public final void run() {
                RemoteInputConnectionImpl.this.lambda$setComposingRegionWithTextAttribute$24(header, start, end, textAttribute);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setComposingRegionWithTextAttribute$24(InputConnectionCommandHeader header, int start, int end, TextAttribute textAttribute) {
        if (header.mSessionId != this.mCurrentSessionId.get()) {
            return;
        }
        InputConnection ic2 = getInputConnection();
        if (ic2 == null || !isActive()) {
            Log.w(TAG, "setComposingRegion on inactive InputConnection");
        } else {
            ic2.setComposingRegion(start, end, textAttribute);
        }
    }

    @Override // com.android.internal.inputmethod.IRemoteInputConnection
    public void setComposingText(final InputConnectionCommandHeader header, final CharSequence text, final int newCursorPosition) {
        dispatchWithTracing("setComposingText", new Runnable() { // from class: android.view.inputmethod.RemoteInputConnectionImpl$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                RemoteInputConnectionImpl.this.lambda$setComposingText$25(header, text, newCursorPosition);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setComposingText$25(InputConnectionCommandHeader header, CharSequence text, int newCursorPosition) {
        if (header.mSessionId != this.mCurrentSessionId.get()) {
            return;
        }
        InputConnection ic2 = getInputConnection();
        if (ic2 == null || !isActive()) {
            Log.w(TAG, "setComposingText on inactive InputConnection");
        } else {
            ic2.setComposingText(text, newCursorPosition);
        }
    }

    @Override // com.android.internal.inputmethod.IRemoteInputConnection
    public void setComposingTextWithTextAttribute(final InputConnectionCommandHeader header, final CharSequence text, final int newCursorPosition, final TextAttribute textAttribute) {
        dispatchWithTracing("setComposingTextWithTextAttribute", new Runnable() { // from class: android.view.inputmethod.RemoteInputConnectionImpl$$ExternalSyntheticLambda21
            @Override // java.lang.Runnable
            public final void run() {
                RemoteInputConnectionImpl.this.lambda$setComposingTextWithTextAttribute$26(header, text, newCursorPosition, textAttribute);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setComposingTextWithTextAttribute$26(InputConnectionCommandHeader header, CharSequence text, int newCursorPosition, TextAttribute textAttribute) {
        if (header.mSessionId != this.mCurrentSessionId.get()) {
            return;
        }
        InputConnection ic2 = getInputConnection();
        if (ic2 == null || !isActive()) {
            Log.w(TAG, "setComposingText on inactive InputConnection");
        } else {
            ic2.setComposingText(text, newCursorPosition, textAttribute);
        }
    }

    public void finishComposingTextFromImm() {
        final int currentSessionId = this.mCurrentSessionId.get();
        dispatchWithTracing("finishComposingTextFromImm", new Runnable() { // from class: android.view.inputmethod.RemoteInputConnectionImpl$$ExternalSyntheticLambda36
            @Override // java.lang.Runnable
            public final void run() {
                RemoteInputConnectionImpl.this.lambda$finishComposingTextFromImm$27(currentSessionId);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$finishComposingTextFromImm$27(int currentSessionId) {
        if (isFinished() || currentSessionId != this.mCurrentSessionId.get()) {
            return;
        }
        InputConnection ic2 = getInputConnection();
        if (ic2 == null) {
            Log.w(TAG, "finishComposingTextFromImm on inactive InputConnection");
        } else {
            ic2.finishComposingText();
        }
    }

    @Override // com.android.internal.inputmethod.IRemoteInputConnection
    public void finishComposingText(final InputConnectionCommandHeader header) {
        dispatchWithTracing("finishComposingText", new Runnable() { // from class: android.view.inputmethod.RemoteInputConnectionImpl$$ExternalSyntheticLambda39
            @Override // java.lang.Runnable
            public final void run() {
                RemoteInputConnectionImpl.this.lambda$finishComposingText$28(header);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$finishComposingText$28(InputConnectionCommandHeader header) {
        if (isFinished() || header.mSessionId != this.mCurrentSessionId.get()) {
            return;
        }
        InputConnection ic2 = getInputConnection();
        if (ic2 == null) {
            Log.w(TAG, "finishComposingText on inactive InputConnection");
        } else {
            ic2.finishComposingText();
        }
    }

    @Override // com.android.internal.inputmethod.IRemoteInputConnection
    public void sendKeyEvent(final InputConnectionCommandHeader header, final KeyEvent event) {
        dispatchWithTracing("sendKeyEvent", new Runnable() { // from class: android.view.inputmethod.RemoteInputConnectionImpl$$ExternalSyntheticLambda22
            @Override // java.lang.Runnable
            public final void run() {
                RemoteInputConnectionImpl.this.lambda$sendKeyEvent$29(header, event);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendKeyEvent$29(InputConnectionCommandHeader header, KeyEvent event) {
        if (header.mSessionId != this.mCurrentSessionId.get()) {
            return;
        }
        InputConnection ic2 = getInputConnection();
        if (ic2 == null || !isActive()) {
            Log.w(TAG, "sendKeyEvent on inactive InputConnection");
        } else {
            ic2.sendKeyEvent(event);
        }
    }

    @Override // com.android.internal.inputmethod.IRemoteInputConnection
    public void clearMetaKeyStates(final InputConnectionCommandHeader header, final int states) {
        dispatchWithTracing("clearMetaKeyStates", new Runnable() { // from class: android.view.inputmethod.RemoteInputConnectionImpl$$ExternalSyntheticLambda33
            @Override // java.lang.Runnable
            public final void run() {
                RemoteInputConnectionImpl.this.lambda$clearMetaKeyStates$30(header, states);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$clearMetaKeyStates$30(InputConnectionCommandHeader header, int states) {
        if (header.mSessionId != this.mCurrentSessionId.get()) {
            return;
        }
        InputConnection ic2 = getInputConnection();
        if (ic2 == null || !isActive()) {
            Log.w(TAG, "clearMetaKeyStates on inactive InputConnection");
        } else {
            ic2.clearMetaKeyStates(states);
        }
    }

    @Override // com.android.internal.inputmethod.IRemoteInputConnection
    public void deleteSurroundingText(final InputConnectionCommandHeader header, final int beforeLength, final int afterLength) {
        dispatchWithTracing("deleteSurroundingText", new Runnable() { // from class: android.view.inputmethod.RemoteInputConnectionImpl$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                RemoteInputConnectionImpl.this.lambda$deleteSurroundingText$31(header, beforeLength, afterLength);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$deleteSurroundingText$31(InputConnectionCommandHeader header, int beforeLength, int afterLength) {
        if (header.mSessionId != this.mCurrentSessionId.get()) {
            return;
        }
        InputConnection ic2 = getInputConnection();
        if (ic2 == null || !isActive()) {
            Log.w(TAG, "deleteSurroundingText on inactive InputConnection");
        } else {
            ic2.deleteSurroundingText(beforeLength, afterLength);
        }
    }

    @Override // com.android.internal.inputmethod.IRemoteInputConnection
    public void deleteSurroundingTextInCodePoints(final InputConnectionCommandHeader header, final int beforeLength, final int afterLength) {
        dispatchWithTracing("deleteSurroundingTextInCodePoints", new Runnable() { // from class: android.view.inputmethod.RemoteInputConnectionImpl$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                RemoteInputConnectionImpl.this.lambda$deleteSurroundingTextInCodePoints$32(header, beforeLength, afterLength);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$deleteSurroundingTextInCodePoints$32(InputConnectionCommandHeader header, int beforeLength, int afterLength) {
        if (header.mSessionId != this.mCurrentSessionId.get()) {
            return;
        }
        InputConnection ic2 = getInputConnection();
        if (ic2 == null || !isActive()) {
            Log.w(TAG, "deleteSurroundingTextInCodePoints on inactive InputConnection");
        } else {
            try {
                ic2.deleteSurroundingTextInCodePoints(beforeLength, afterLength);
            } catch (AbstractMethodError e2) {
            }
        }
    }

    @Override // com.android.internal.inputmethod.IRemoteInputConnection
    public void beginBatchEdit(final InputConnectionCommandHeader header) {
        dispatchWithTracing("beginBatchEdit", new Runnable() { // from class: android.view.inputmethod.RemoteInputConnectionImpl$$ExternalSyntheticLambda48
            @Override // java.lang.Runnable
            public final void run() {
                RemoteInputConnectionImpl.this.lambda$beginBatchEdit$33(header);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$beginBatchEdit$33(InputConnectionCommandHeader header) {
        if (header.mSessionId != this.mCurrentSessionId.get()) {
            return;
        }
        InputConnection ic2 = getInputConnection();
        if (ic2 == null || !isActive()) {
            Log.w(TAG, "beginBatchEdit on inactive InputConnection");
        } else {
            ic2.beginBatchEdit();
        }
    }

    @Override // com.android.internal.inputmethod.IRemoteInputConnection
    public void endBatchEdit(final InputConnectionCommandHeader header) {
        dispatchWithTracing("endBatchEdit", new Runnable() { // from class: android.view.inputmethod.RemoteInputConnectionImpl$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                RemoteInputConnectionImpl.this.lambda$endBatchEdit$34(header);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$endBatchEdit$34(InputConnectionCommandHeader header) {
        if (header.mSessionId != this.mCurrentSessionId.get()) {
            return;
        }
        InputConnection ic2 = getInputConnection();
        if (ic2 == null || !isActive()) {
            Log.w(TAG, "endBatchEdit on inactive InputConnection");
        } else {
            ic2.endBatchEdit();
        }
    }

    @Override // com.android.internal.inputmethod.IRemoteInputConnection
    public void performSpellCheck(final InputConnectionCommandHeader header) {
        dispatchWithTracing("performSpellCheck", new Runnable() { // from class: android.view.inputmethod.RemoteInputConnectionImpl$$ExternalSyntheticLambda49
            @Override // java.lang.Runnable
            public final void run() {
                RemoteInputConnectionImpl.this.lambda$performSpellCheck$35(header);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$performSpellCheck$35(InputConnectionCommandHeader header) {
        if (header.mSessionId != this.mCurrentSessionId.get()) {
            return;
        }
        InputConnection ic2 = getInputConnection();
        if (ic2 == null || !isActive()) {
            Log.w(TAG, "performSpellCheck on inactive InputConnection");
        } else {
            ic2.performSpellCheck();
        }
    }

    @Override // com.android.internal.inputmethod.IRemoteInputConnection
    public void performPrivateCommand(final InputConnectionCommandHeader header, final String action, final Bundle data) {
        dispatchWithTracing("performPrivateCommand", new Runnable() { // from class: android.view.inputmethod.RemoteInputConnectionImpl$$ExternalSyntheticLambda23
            @Override // java.lang.Runnable
            public final void run() {
                RemoteInputConnectionImpl.this.lambda$performPrivateCommand$36(header, action, data);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$performPrivateCommand$36(InputConnectionCommandHeader header, String action, Bundle data) {
        if (header.mSessionId != this.mCurrentSessionId.get()) {
            return;
        }
        InputConnection ic2 = getInputConnection();
        if (ic2 == null || !isActive()) {
            Log.w(TAG, "performPrivateCommand on inactive InputConnection");
        } else {
            ic2.performPrivateCommand(action, data);
        }
    }

    @Override // com.android.internal.inputmethod.IRemoteInputConnection
    public void performHandwritingGesture(final InputConnectionCommandHeader header, ParcelableHandwritingGesture gestureContainer, final ResultReceiver resultReceiver) {
        final HandwritingGesture gesture = gestureContainer.get();
        if (gesture instanceof CancellableHandwritingGesture) {
            CancellableHandwritingGesture cancellableGesture = (CancellableHandwritingGesture) gesture;
            cancellableGesture.unbeamCancellationSignal(getCancellationSignalBeamer());
            if (cancellableGesture.getCancellationSignal() != null && cancellableGesture.getCancellationSignal().isCanceled()) {
                if (resultReceiver != null) {
                    resultReceiver.send(4, null);
                    return;
                }
                return;
            }
        }
        dispatchWithTracing("performHandwritingGesture", new Runnable() { // from class: android.view.inputmethod.RemoteInputConnectionImpl$$ExternalSyntheticLambda20
            @Override // java.lang.Runnable
            public final void run() {
                RemoteInputConnectionImpl.this.lambda$performHandwritingGesture$38(header, resultReceiver, gesture);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$performHandwritingGesture$38(InputConnectionCommandHeader header, final ResultReceiver resultReceiver, HandwritingGesture gesture) {
        if (header.mSessionId != this.mCurrentSessionId.get()) {
            if (resultReceiver != null) {
                resultReceiver.send(4, null);
                return;
            }
            return;
        }
        InputConnection ic2 = getInputConnection();
        if (ic2 == null || !isActive()) {
            Log.w(TAG, "performHandwritingGesture on inactive InputConnection");
            if (resultReceiver != null) {
                resultReceiver.send(4, null);
                return;
            }
            return;
        }
        ic2.performHandwritingGesture(gesture, resultReceiver != null ? new PendingIntent$.ExternalSyntheticLambda1() : null, resultReceiver != null ? new IntConsumer() { // from class: android.view.inputmethod.RemoteInputConnectionImpl$$ExternalSyntheticLambda38
            @Override // java.util.function.IntConsumer
            public final void accept(int i10) {
                resultReceiver.send(i10, null);
            }
        } : null);
    }

    @Override // com.android.internal.inputmethod.IRemoteInputConnection
    public void previewHandwritingGesture(final InputConnectionCommandHeader header, ParcelableHandwritingGesture gestureContainer, IBinder cancellationSignalToken) {
        final CancellationSignal cancellationSignal = cancellationSignalToken != null ? getCancellationSignalBeamer().unbeam(cancellationSignalToken) : null;
        final PreviewableHandwritingGesture gesture = (PreviewableHandwritingGesture) gestureContainer.get();
        dispatchWithTracing("previewHandwritingGesture", new Runnable() { // from class: android.view.inputmethod.RemoteInputConnectionImpl$$ExternalSyntheticLambda35
            @Override // java.lang.Runnable
            public final void run() {
                RemoteInputConnectionImpl.this.lambda$previewHandwritingGesture$39(header, cancellationSignal, gesture);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$previewHandwritingGesture$39(InputConnectionCommandHeader header, CancellationSignal cancellationSignal, PreviewableHandwritingGesture gesture) {
        if (header.mSessionId == this.mCurrentSessionId.get()) {
            if (cancellationSignal != null && cancellationSignal.isCanceled()) {
                return;
            }
            InputConnection ic2 = getInputConnection();
            if (ic2 == null || !isActive()) {
                Log.w(TAG, "previewHandwritingGesture on inactive InputConnection");
            } else {
                ic2.previewHandwritingGesture(gesture, cancellationSignal);
            }
        }
    }

    private CancellationSignalBeamer.Receiver getCancellationSignalBeamer() {
        CancellationSignalBeamer.Receiver receiver = this.mBeamer;
        if (receiver != null) {
            return receiver;
        }
        CancellationSignalBeamer.Receiver receiver2 = new CancellationSignalBeamer.Receiver(true);
        this.mBeamer = receiver2;
        return receiver2;
    }

    @Override // com.android.internal.inputmethod.IRemoteInputConnection
    public void requestCursorUpdates(final InputConnectionCommandHeader header, final int cursorUpdateMode, final int imeDisplayId, AndroidFuture future) {
        dispatchWithTracing("requestCursorUpdates", future, new Supplier() { // from class: android.view.inputmethod.RemoteInputConnectionImpl$$ExternalSyntheticLambda42
            @Override // java.util.function.Supplier
            public final Object get() {
                Boolean lambda$requestCursorUpdates$40;
                lambda$requestCursorUpdates$40 = RemoteInputConnectionImpl.this.lambda$requestCursorUpdates$40(header, cursorUpdateMode, imeDisplayId);
                return lambda$requestCursorUpdates$40;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean lambda$requestCursorUpdates$40(InputConnectionCommandHeader header, int cursorUpdateMode, int imeDisplayId) {
        if (header.mSessionId != this.mCurrentSessionId.get()) {
            return false;
        }
        return Boolean.valueOf(requestCursorUpdatesInternal(cursorUpdateMode, 0, imeDisplayId));
    }

    @Override // com.android.internal.inputmethod.IRemoteInputConnection
    public void requestCursorUpdatesWithFilter(final InputConnectionCommandHeader header, final int cursorUpdateMode, final int cursorUpdateFilter, final int imeDisplayId, AndroidFuture future) {
        dispatchWithTracing("requestCursorUpdates", future, new Supplier() { // from class: android.view.inputmethod.RemoteInputConnectionImpl$$ExternalSyntheticLambda0
            @Override // java.util.function.Supplier
            public final Object get() {
                Boolean lambda$requestCursorUpdatesWithFilter$41;
                lambda$requestCursorUpdatesWithFilter$41 = RemoteInputConnectionImpl.this.lambda$requestCursorUpdatesWithFilter$41(header, cursorUpdateMode, cursorUpdateFilter, imeDisplayId);
                return lambda$requestCursorUpdatesWithFilter$41;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean lambda$requestCursorUpdatesWithFilter$41(InputConnectionCommandHeader header, int cursorUpdateMode, int cursorUpdateFilter, int imeDisplayId) {
        if (header.mSessionId != this.mCurrentSessionId.get()) {
            return false;
        }
        return Boolean.valueOf(requestCursorUpdatesInternal(cursorUpdateMode, cursorUpdateFilter, imeDisplayId));
    }

    private boolean requestCursorUpdatesInternal(int cursorUpdateMode, int cursorUpdateFilter, int imeDisplayId) {
        InputConnection ic2 = getInputConnection();
        boolean z10 = false;
        if (ic2 == null || !isActive()) {
            Log.w(TAG, "requestCursorAnchorInfo on inactive InputConnection");
            return false;
        }
        if (this.mParentInputMethodManager.mRequestCursorUpdateDisplayIdCheck.get() && this.mParentInputMethodManager.getDisplayId() != imeDisplayId && !this.mParentInputMethodManager.hasVirtualDisplayToScreenMatrix()) {
            return false;
        }
        boolean hasImmediate = (cursorUpdateMode & 1) != 0;
        boolean hasMonitoring = (cursorUpdateMode & 2) != 0;
        try {
            boolean result = ic2.requestCursorUpdates(cursorUpdateMode, cursorUpdateFilter);
            this.mHasPendingImmediateCursorAnchorInfoUpdate.set(result && hasImmediate);
            AtomicBoolean atomicBoolean = this.mIsCursorAnchorInfoMonitoring;
            if (result && hasMonitoring) {
                z10 = true;
            }
            atomicBoolean.set(z10);
            return result;
        } catch (AbstractMethodError e2) {
            this.mHasPendingImmediateCursorAnchorInfoUpdate.set(0 != 0 && hasImmediate);
            this.mIsCursorAnchorInfoMonitoring.set(0 != 0 && hasMonitoring);
            return false;
        } catch (Throwable th) {
            this.mHasPendingImmediateCursorAnchorInfoUpdate.set(0 != 0 && hasImmediate);
            AtomicBoolean atomicBoolean2 = this.mIsCursorAnchorInfoMonitoring;
            if (0 != 0 && hasMonitoring) {
                z10 = true;
            }
            atomicBoolean2.set(z10);
            throw th;
        }
    }

    @Override // com.android.internal.inputmethod.IRemoteInputConnection
    public void requestTextBoundsInfo(final InputConnectionCommandHeader header, final RectF bounds, final ResultReceiver resultReceiver) {
        dispatchWithTracing("requestTextBoundsInfo", new Runnable() { // from class: android.view.inputmethod.RemoteInputConnectionImpl$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                RemoteInputConnectionImpl.this.lambda$requestTextBoundsInfo$43(header, resultReceiver, bounds);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestTextBoundsInfo$43(InputConnectionCommandHeader header, final ResultReceiver resultReceiver, RectF bounds) {
        if (header.mSessionId != this.mCurrentSessionId.get()) {
            resultReceiver.send(3, null);
            return;
        }
        InputConnection ic2 = getInputConnection();
        if (ic2 == null || !isActive()) {
            Log.w(TAG, "requestTextBoundsInfo on inactive InputConnection");
            resultReceiver.send(3, null);
        } else {
            ic2.requestTextBoundsInfo(bounds, new PendingIntent$.ExternalSyntheticLambda1(), new Consumer() { // from class: android.view.inputmethod.RemoteInputConnectionImpl$$ExternalSyntheticLambda43
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    RemoteInputConnectionImpl.lambda$requestTextBoundsInfo$42(resultReceiver, (TextBoundsInfoResult) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$requestTextBoundsInfo$42(ResultReceiver resultReceiver, TextBoundsInfoResult textBoundsInfoResult) {
        int resultCode = textBoundsInfoResult.getResultCode();
        TextBoundsInfo textBoundsInfo = textBoundsInfoResult.getTextBoundsInfo();
        resultReceiver.send(resultCode, textBoundsInfo == null ? null : textBoundsInfo.toBundle());
    }

    @Override // com.android.internal.inputmethod.IRemoteInputConnection
    public void commitContent(final InputConnectionCommandHeader header, final InputContentInfo inputContentInfo, final int flags, final Bundle opts, AndroidFuture future) {
        dispatchWithTracing("commitContent", future, new Supplier() { // from class: android.view.inputmethod.RemoteInputConnectionImpl$$ExternalSyntheticLambda37
            @Override // java.util.function.Supplier
            public final Object get() {
                Boolean lambda$commitContent$44;
                lambda$commitContent$44 = RemoteInputConnectionImpl.this.lambda$commitContent$44(header, inputContentInfo, flags, opts);
                return lambda$commitContent$44;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean lambda$commitContent$44(InputConnectionCommandHeader header, InputContentInfo inputContentInfo, int flags, Bundle opts) {
        if (header.mSessionId != this.mCurrentSessionId.get()) {
            return false;
        }
        InputConnection ic2 = getInputConnection();
        if (ic2 == null || !isActive()) {
            Log.w(TAG, "commitContent on inactive InputConnection");
            return false;
        }
        if (inputContentInfo == null || !inputContentInfo.validate()) {
            Log.w(TAG, "commitContent with invalid inputContentInfo=" + ((Object) inputContentInfo));
            return false;
        }
        try {
            return Boolean.valueOf(ic2.commitContent(inputContentInfo, flags, opts));
        } catch (AbstractMethodError e2) {
            return false;
        }
    }

    @Override // com.android.internal.inputmethod.IRemoteInputConnection
    public void setImeConsumesInput(final InputConnectionCommandHeader header, final boolean imeConsumesInput) {
        dispatchWithTracing("setImeConsumesInput", new Runnable() { // from class: android.view.inputmethod.RemoteInputConnectionImpl$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                RemoteInputConnectionImpl.this.lambda$setImeConsumesInput$45(header, imeConsumesInput);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setImeConsumesInput$45(InputConnectionCommandHeader header, boolean imeConsumesInput) {
        if (header.mSessionId != this.mCurrentSessionId.get()) {
            return;
        }
        InputConnection ic2 = getInputConnection();
        if (ic2 == null || !isActive()) {
            Log.w(TAG, "setImeConsumesInput on inactive InputConnection");
        } else {
            ic2.setImeConsumesInput(imeConsumesInput);
        }
    }

    @Override // com.android.internal.inputmethod.IRemoteInputConnection
    public void replaceText(final InputConnectionCommandHeader header, final int start, final int end, final CharSequence text, final int newCursorPosition, final TextAttribute textAttribute) {
        dispatchWithTracing("replaceText", new Runnable() { // from class: android.view.inputmethod.RemoteInputConnectionImpl$$ExternalSyntheticLambda34
            @Override // java.lang.Runnable
            public final void run() {
                RemoteInputConnectionImpl.this.lambda$replaceText$46(header, start, end, text, newCursorPosition, textAttribute);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$replaceText$46(InputConnectionCommandHeader header, int start, int end, CharSequence text, int newCursorPosition, TextAttribute textAttribute) {
        if (header.mSessionId != this.mCurrentSessionId.get()) {
            return;
        }
        InputConnection ic2 = getInputConnection();
        if (ic2 == null || !isActive()) {
            Log.w(TAG, "replaceText on inactive InputConnection");
        } else {
            ic2.replaceText(start, end, text, newCursorPosition, textAttribute);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* renamed from: android.view.inputmethod.RemoteInputConnectionImpl$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public class AnonymousClass1 extends IRemoteAccessibilityInputConnection.Stub {
        AnonymousClass1() {
        }

        @Override // com.android.internal.inputmethod.IRemoteAccessibilityInputConnection
        public void commitText(final InputConnectionCommandHeader header, final CharSequence text, final int newCursorPosition, final TextAttribute textAttribute) {
            RemoteInputConnectionImpl.this.dispatchWithTracing("commitTextFromA11yIme", new Runnable() { // from class: android.view.inputmethod.RemoteInputConnectionImpl$1$$ExternalSyntheticLambda7
                @Override // java.lang.Runnable
                public final void run() {
                    RemoteInputConnectionImpl.AnonymousClass1.this.lambda$commitText$0(header, text, newCursorPosition, textAttribute);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$commitText$0(InputConnectionCommandHeader header, CharSequence text, int newCursorPosition, TextAttribute textAttribute) {
            if (header.mSessionId != RemoteInputConnectionImpl.this.mCurrentSessionId.get()) {
                return;
            }
            InputConnection ic2 = RemoteInputConnectionImpl.this.getInputConnection();
            if (ic2 == null || !RemoteInputConnectionImpl.this.isActive()) {
                Log.w(RemoteInputConnectionImpl.TAG, "commitText on inactive InputConnection");
                return;
            }
            ic2.beginBatchEdit();
            ic2.finishComposingText();
            ic2.commitText(text, newCursorPosition, textAttribute);
            ic2.endBatchEdit();
        }

        @Override // com.android.internal.inputmethod.IRemoteAccessibilityInputConnection
        public void setSelection(final InputConnectionCommandHeader header, final int start, final int end) {
            RemoteInputConnectionImpl.this.dispatchWithTracing("setSelectionFromA11yIme", new Runnable() { // from class: android.view.inputmethod.RemoteInputConnectionImpl$1$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    RemoteInputConnectionImpl.AnonymousClass1.this.lambda$setSelection$1(header, start, end);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$setSelection$1(InputConnectionCommandHeader header, int start, int end) {
            if (header.mSessionId != RemoteInputConnectionImpl.this.mCurrentSessionId.get()) {
                return;
            }
            InputConnection ic2 = RemoteInputConnectionImpl.this.getInputConnection();
            if (ic2 == null || !RemoteInputConnectionImpl.this.isActive()) {
                Log.w(RemoteInputConnectionImpl.TAG, "setSelection on inactive InputConnection");
            } else {
                ic2.setSelection(start, end);
            }
        }

        @Override // com.android.internal.inputmethod.IRemoteAccessibilityInputConnection
        public void getSurroundingText(final InputConnectionCommandHeader header, final int beforeLength, final int afterLength, final int flags, AndroidFuture future) {
            RemoteInputConnectionImpl.this.dispatchWithTracing("getSurroundingTextFromA11yIme", future, new Supplier() { // from class: android.view.inputmethod.RemoteInputConnectionImpl$1$$ExternalSyntheticLambda3
                @Override // java.util.function.Supplier
                public final Object get() {
                    SurroundingText lambda$getSurroundingText$2;
                    lambda$getSurroundingText$2 = RemoteInputConnectionImpl.AnonymousClass1.this.lambda$getSurroundingText$2(header, beforeLength, afterLength, flags);
                    return lambda$getSurroundingText$2;
                }
            }, RemoteInputConnectionImpl.m782$$Nest$smuseImeTracing() ? new Function() { // from class: android.view.inputmethod.RemoteInputConnectionImpl$1$$ExternalSyntheticLambda4
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    byte[] buildGetSurroundingTextProto;
                    buildGetSurroundingTextProto = InputConnectionProtoDumper.buildGetSurroundingTextProto(beforeLength, afterLength, flags, (SurroundingText) obj);
                    return buildGetSurroundingTextProto;
                }
            } : null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ SurroundingText lambda$getSurroundingText$2(InputConnectionCommandHeader header, int beforeLength, int afterLength, int flags) {
            if (header.mSessionId != RemoteInputConnectionImpl.this.mCurrentSessionId.get()) {
                return null;
            }
            InputConnection ic2 = RemoteInputConnectionImpl.this.getInputConnection();
            if (ic2 == null || !RemoteInputConnectionImpl.this.isActive()) {
                Log.w(RemoteInputConnectionImpl.TAG, "getSurroundingText on inactive InputConnection");
                return null;
            }
            if (beforeLength < 0) {
                Log.i(RemoteInputConnectionImpl.TAG, "Returning null to getSurroundingText due to an invalid beforeLength=" + beforeLength);
                return null;
            }
            if (afterLength < 0) {
                Log.i(RemoteInputConnectionImpl.TAG, "Returning null to getSurroundingText due to an invalid afterLength=" + afterLength);
                return null;
            }
            return ic2.getSurroundingText(beforeLength, afterLength, flags);
        }

        @Override // com.android.internal.inputmethod.IRemoteAccessibilityInputConnection
        public void deleteSurroundingText(final InputConnectionCommandHeader header, final int beforeLength, final int afterLength) {
            RemoteInputConnectionImpl.this.dispatchWithTracing("deleteSurroundingTextFromA11yIme", new Runnable() { // from class: android.view.inputmethod.RemoteInputConnectionImpl$1$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    RemoteInputConnectionImpl.AnonymousClass1.this.lambda$deleteSurroundingText$4(header, beforeLength, afterLength);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$deleteSurroundingText$4(InputConnectionCommandHeader header, int beforeLength, int afterLength) {
            if (header.mSessionId != RemoteInputConnectionImpl.this.mCurrentSessionId.get()) {
                return;
            }
            InputConnection ic2 = RemoteInputConnectionImpl.this.getInputConnection();
            if (ic2 == null || !RemoteInputConnectionImpl.this.isActive()) {
                Log.w(RemoteInputConnectionImpl.TAG, "deleteSurroundingText on inactive InputConnection");
            } else {
                ic2.deleteSurroundingText(beforeLength, afterLength);
            }
        }

        @Override // com.android.internal.inputmethod.IRemoteAccessibilityInputConnection
        public void sendKeyEvent(final InputConnectionCommandHeader header, final KeyEvent event) {
            RemoteInputConnectionImpl.this.dispatchWithTracing("sendKeyEventFromA11yIme", new Runnable() { // from class: android.view.inputmethod.RemoteInputConnectionImpl$1$$ExternalSyntheticLambda8
                @Override // java.lang.Runnable
                public final void run() {
                    RemoteInputConnectionImpl.AnonymousClass1.this.lambda$sendKeyEvent$5(header, event);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$sendKeyEvent$5(InputConnectionCommandHeader header, KeyEvent event) {
            if (header.mSessionId != RemoteInputConnectionImpl.this.mCurrentSessionId.get()) {
                return;
            }
            InputConnection ic2 = RemoteInputConnectionImpl.this.getInputConnection();
            if (ic2 == null || !RemoteInputConnectionImpl.this.isActive()) {
                Log.w(RemoteInputConnectionImpl.TAG, "sendKeyEvent on inactive InputConnection");
            } else {
                ic2.sendKeyEvent(event);
            }
        }

        @Override // com.android.internal.inputmethod.IRemoteAccessibilityInputConnection
        public void performEditorAction(final InputConnectionCommandHeader header, final int id2) {
            RemoteInputConnectionImpl.this.dispatchWithTracing("performEditorActionFromA11yIme", new Runnable() { // from class: android.view.inputmethod.RemoteInputConnectionImpl$1$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    RemoteInputConnectionImpl.AnonymousClass1.this.lambda$performEditorAction$6(header, id2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$performEditorAction$6(InputConnectionCommandHeader header, int id2) {
            if (header.mSessionId != RemoteInputConnectionImpl.this.mCurrentSessionId.get()) {
                return;
            }
            InputConnection ic2 = RemoteInputConnectionImpl.this.getInputConnection();
            if (ic2 == null || !RemoteInputConnectionImpl.this.isActive()) {
                Log.w(RemoteInputConnectionImpl.TAG, "performEditorAction on inactive InputConnection");
            } else {
                ic2.performEditorAction(id2);
            }
        }

        @Override // com.android.internal.inputmethod.IRemoteAccessibilityInputConnection
        public void performContextMenuAction(final InputConnectionCommandHeader header, final int id2) {
            RemoteInputConnectionImpl.this.dispatchWithTracing("performContextMenuActionFromA11yIme", new Runnable() { // from class: android.view.inputmethod.RemoteInputConnectionImpl$1$$ExternalSyntheticLambda9
                @Override // java.lang.Runnable
                public final void run() {
                    RemoteInputConnectionImpl.AnonymousClass1.this.lambda$performContextMenuAction$7(header, id2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$performContextMenuAction$7(InputConnectionCommandHeader header, int id2) {
            if (header.mSessionId != RemoteInputConnectionImpl.this.mCurrentSessionId.get()) {
                return;
            }
            InputConnection ic2 = RemoteInputConnectionImpl.this.getInputConnection();
            if (ic2 == null || !RemoteInputConnectionImpl.this.isActive()) {
                Log.w(RemoteInputConnectionImpl.TAG, "performContextMenuAction on inactive InputConnection");
            } else {
                ic2.performContextMenuAction(id2);
            }
        }

        @Override // com.android.internal.inputmethod.IRemoteAccessibilityInputConnection
        public void getCursorCapsMode(final InputConnectionCommandHeader header, final int reqModes, AndroidFuture future) {
            RemoteInputConnectionImpl.this.dispatchWithTracing("getCursorCapsModeFromA11yIme", future, new Supplier() { // from class: android.view.inputmethod.RemoteInputConnectionImpl$1$$ExternalSyntheticLambda0
                @Override // java.util.function.Supplier
                public final Object get() {
                    Integer lambda$getCursorCapsMode$8;
                    lambda$getCursorCapsMode$8 = RemoteInputConnectionImpl.AnonymousClass1.this.lambda$getCursorCapsMode$8(header, reqModes);
                    return lambda$getCursorCapsMode$8;
                }
            }, RemoteInputConnectionImpl.m782$$Nest$smuseImeTracing() ? new Function() { // from class: android.view.inputmethod.RemoteInputConnectionImpl$1$$ExternalSyntheticLambda1
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    byte[] buildGetCursorCapsModeProto;
                    buildGetCursorCapsModeProto = InputConnectionProtoDumper.buildGetCursorCapsModeProto(reqModes, ((Integer) obj).intValue());
                    return buildGetCursorCapsModeProto;
                }
            } : null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Integer lambda$getCursorCapsMode$8(InputConnectionCommandHeader header, int reqModes) {
            if (header.mSessionId != RemoteInputConnectionImpl.this.mCurrentSessionId.get()) {
                return 0;
            }
            InputConnection ic2 = RemoteInputConnectionImpl.this.getInputConnection();
            if (ic2 == null || !RemoteInputConnectionImpl.this.isActive()) {
                Log.w(RemoteInputConnectionImpl.TAG, "getCursorCapsMode on inactive InputConnection");
                return 0;
            }
            return Integer.valueOf(ic2.getCursorCapsMode(reqModes));
        }

        @Override // com.android.internal.inputmethod.IRemoteAccessibilityInputConnection
        public void clearMetaKeyStates(final InputConnectionCommandHeader header, final int states) {
            RemoteInputConnectionImpl.this.dispatchWithTracing("clearMetaKeyStatesFromA11yIme", new Runnable() { // from class: android.view.inputmethod.RemoteInputConnectionImpl$1$$ExternalSyntheticLambda10
                @Override // java.lang.Runnable
                public final void run() {
                    RemoteInputConnectionImpl.AnonymousClass1.this.lambda$clearMetaKeyStates$10(header, states);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$clearMetaKeyStates$10(InputConnectionCommandHeader header, int states) {
            if (header.mSessionId != RemoteInputConnectionImpl.this.mCurrentSessionId.get()) {
                return;
            }
            InputConnection ic2 = RemoteInputConnectionImpl.this.getInputConnection();
            if (ic2 == null || !RemoteInputConnectionImpl.this.isActive()) {
                Log.w(RemoteInputConnectionImpl.TAG, "clearMetaKeyStates on inactive InputConnection");
            } else {
                ic2.clearMetaKeyStates(states);
            }
        }
    }

    public IRemoteAccessibilityInputConnection asIRemoteAccessibilityInputConnection() {
        return this.mAccessibilityInputConnection;
    }

    private void dispatch(Runnable runnable) {
        if (this.mLooper.isCurrentThread()) {
            runnable.run();
        } else {
            this.mH.post(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchWithTracing(final String methodName, final Runnable runnable) {
        Runnable actualRunnable;
        if (Trace.isTagEnabled(4L)) {
            actualRunnable = new Runnable() { // from class: android.view.inputmethod.RemoteInputConnectionImpl$$ExternalSyntheticLambda40
                @Override // java.lang.Runnable
                public final void run() {
                    RemoteInputConnectionImpl.lambda$dispatchWithTracing$47(String.this, runnable);
                }
            };
        } else {
            actualRunnable = runnable;
        }
        dispatch(actualRunnable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$dispatchWithTracing$47(String methodName, Runnable runnable) {
        Trace.traceBegin(4L, "InputConnection#" + methodName);
        try {
            runnable.run();
        } finally {
            Trace.traceEnd(4L);
        }
    }

    private <T> void dispatchWithTracing(String methodName, AndroidFuture untypedFuture, Supplier<T> supplier) {
        dispatchWithTracing(methodName, untypedFuture, supplier, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T> void dispatchWithTracing(final String methodName, final AndroidFuture untypedFuture, final Supplier<T> supplier, final Function<T, byte[]> dumpProtoProvider) {
        dispatchWithTracing(methodName, new Runnable() { // from class: android.view.inputmethod.RemoteInputConnectionImpl$$ExternalSyntheticLambda18
            @Override // java.lang.Runnable
            public final void run() {
                RemoteInputConnectionImpl.this.lambda$dispatchWithTracing$48(supplier, untypedFuture, dumpProtoProvider, methodName);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$dispatchWithTracing$48(Supplier supplier, AndroidFuture future, Function dumpProtoProvider, String methodName) {
        try {
            Object obj = supplier.get();
            future.complete(obj);
            if (dumpProtoProvider != null) {
                byte[] icProto = (byte[]) dumpProtoProvider.apply(obj);
                ImeTracing.getInstance().triggerClientDump("RemoteInputConnectionImpl#" + methodName, this.mParentInputMethodManager, icProto);
            }
        } catch (Throwable throwable) {
            future.completeExceptionally(throwable);
            throw throwable;
        }
    }

    private static boolean useImeTracing() {
        return ImeTracing.getInstance().isEnabled();
    }
}
