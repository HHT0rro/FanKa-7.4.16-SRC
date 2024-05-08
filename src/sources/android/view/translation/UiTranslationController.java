package android.view.translation;

import android.app.Activity;
import android.app.assist.ActivityId;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Dumpable;
import android.util.IntArray;
import android.util.Log;
import android.util.LongSparseArray;
import android.util.Pair;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewRootImpl;
import android.view.WindowManagerGlobal;
import android.view.autofill.AutofillId;
import android.view.translation.TranslationContext;
import android.view.translation.TranslationRequest;
import android.widget.TextView;
import android.widget.TextViewTranslationCallback;
import com.alipay.sdk.util.i;
import com.android.internal.util.function.QuadConsumer;
import com.android.internal.util.function.TriConsumer;
import com.android.internal.util.function.pooled.PooledLambda;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class UiTranslationController implements Dumpable {
    public static final boolean DEBUG = Log.isLoggable(UiTranslationManager.LOG_TAG, 3);
    public static final String DUMPABLE_NAME = "UiTranslationController";
    private static final String TAG = "UiTranslationController";
    private final Activity mActivity;
    private final Context mContext;
    private int mCurrentState;
    private ArraySet<AutofillId> mLastRequestAutofillIds;
    private final Handler mWorkerHandler;
    private final HandlerThread mWorkerThread;
    private final Object mLock = new Object();
    private final ArrayMap<AutofillId, WeakReference<View>> mViews = new ArrayMap<>();
    private final ArrayMap<Pair<TranslationSpec, TranslationSpec>, Translator> mTranslators = new ArrayMap<>();
    private final ArraySet<AutofillId> mViewsToPadContent = new ArraySet<>();

    public UiTranslationController(Activity activity, Context context) {
        this.mActivity = activity;
        this.mContext = context;
        HandlerThread handlerThread = new HandlerThread("UiTranslationController_" + ((Object) activity.getComponentName()), -2);
        this.mWorkerThread = handlerThread;
        handlerThread.start();
        this.mWorkerHandler = handlerThread.getThreadHandler();
        activity.addDumpable(this);
    }

    public void updateUiTranslationState(int state, TranslationSpec sourceSpec, TranslationSpec targetSpec, List<AutofillId> views, UiTranslationSpec uiTranslationSpec) {
        if (this.mActivity.isDestroyed()) {
            Log.i("UiTranslationController", "Cannot update " + stateToString(state) + " for destroyed " + ((Object) this.mActivity));
            return;
        }
        boolean isLoggable = Log.isLoggable(UiTranslationManager.LOG_TAG, 3);
        Log.i("UiTranslationController", "updateUiTranslationState state: " + stateToString(state) + (isLoggable ? ", views: " + ((Object) views) + ", spec: " + ((Object) uiTranslationSpec) : ""));
        synchronized (this.mLock) {
            this.mCurrentState = state;
            if (views != null) {
                setLastRequestAutofillIdsLocked(views);
            }
        }
        switch (state) {
            case 0:
                if (uiTranslationSpec != null && uiTranslationSpec.shouldPadContentForCompat()) {
                    synchronized (this.mLock) {
                        this.mViewsToPadContent.addAll(views);
                    }
                }
                Pair<TranslationSpec, TranslationSpec> specs = new Pair<>(sourceSpec, targetSpec);
                if (!this.mTranslators.containsKey(specs)) {
                    this.mWorkerHandler.sendMessage(PooledLambda.obtainMessage(new QuadConsumer() { // from class: android.view.translation.UiTranslationController$$ExternalSyntheticLambda3
                        public final void accept(Object obj, Object obj2, Object obj3, Object obj4) {
                            ((UiTranslationController) obj).createTranslatorAndStart((TranslationSpec) obj2, (TranslationSpec) obj3, (List) obj4);
                        }
                    }, this, sourceSpec, targetSpec, views));
                    return;
                } else {
                    onUiTranslationStarted(this.mTranslators.get(specs), views);
                    return;
                }
            case 1:
                runForEachView(new BiConsumer() { // from class: android.view.translation.UiTranslationController$$ExternalSyntheticLambda4
                    @Override // java.util.function.BiConsumer
                    public final void accept(Object obj, Object obj2) {
                        ((ViewTranslationCallback) obj2).onHideTranslation((View) obj);
                    }
                });
                return;
            case 2:
                runForEachView(new BiConsumer() { // from class: android.view.translation.UiTranslationController$$ExternalSyntheticLambda5
                    @Override // java.util.function.BiConsumer
                    public final void accept(Object obj, Object obj2) {
                        ((ViewTranslationCallback) obj2).onShowTranslation((View) obj);
                    }
                });
                return;
            case 3:
                destroyTranslators();
                runForEachView(new BiConsumer() { // from class: android.view.translation.UiTranslationController$$ExternalSyntheticLambda6
                    @Override // java.util.function.BiConsumer
                    public final void accept(Object obj, Object obj2) {
                        ((View) obj).clearTranslationState();
                    }
                });
                notifyTranslationFinished(false);
                synchronized (this.mLock) {
                    this.mViews.clear();
                }
                return;
            default:
                Log.w("UiTranslationController", "onAutoTranslationStateChange(): unknown state: " + state);
                return;
        }
    }

    public void onActivityDestroyed() {
        synchronized (this.mLock) {
            Log.i("UiTranslationController", "onActivityDestroyed(): mCurrentState is " + stateToString(this.mCurrentState));
            if (this.mCurrentState != 3) {
                notifyTranslationFinished(true);
            }
            this.mViews.clear();
            destroyTranslators();
            this.mWorkerThread.quitSafely();
        }
    }

    private void notifyTranslationFinished(boolean activityDestroyed) {
        UiTranslationManager manager = (UiTranslationManager) this.mContext.getSystemService(UiTranslationManager.class);
        if (manager != null) {
            manager.onTranslationFinished(activityDestroyed, new ActivityId(this.mActivity.getTaskId(), this.mActivity.getShareableActivityToken()), this.mActivity.getComponentName());
        }
    }

    private void setLastRequestAutofillIdsLocked(List<AutofillId> views) {
        if (this.mLastRequestAutofillIds == null) {
            this.mLastRequestAutofillIds = new ArraySet<>();
        }
        if (this.mLastRequestAutofillIds.size() > 0) {
            this.mLastRequestAutofillIds.clear();
        }
        this.mLastRequestAutofillIds.addAll(views);
    }

    @Override // android.util.Dumpable
    public String getDumpableName() {
        return "UiTranslationController";
    }

    @Override // android.util.Dumpable
    public void dump(PrintWriter pw, String[] args) {
        pw.print("");
        pw.println("UiTranslationController:");
        String pfx = "  ";
        pw.print(pfx);
        pw.print("activity: ");
        pw.print(this.mActivity);
        pw.print(pfx);
        pw.print("resumed: ");
        pw.println(this.mActivity.isResumed());
        pw.print(pfx);
        pw.print("current state: ");
        pw.println(this.mCurrentState);
        int translatorSize = this.mTranslators.size();
        pw.print("");
        pw.print("number translator: ");
        pw.println(translatorSize);
        for (int i10 = 0; i10 < translatorSize; i10++) {
            pw.print("");
            pw.print("#");
            pw.println(i10);
            Translator translator = this.mTranslators.valueAt(i10);
            translator.dump("", pw);
            pw.println();
        }
        synchronized (this.mLock) {
            int viewSize = this.mViews.size();
            pw.print("");
            pw.print("number views: ");
            pw.println(viewSize);
            for (int i11 = 0; i11 < viewSize; i11++) {
                pw.print("");
                pw.print("#");
                pw.println(i11);
                AutofillId autofillId = this.mViews.keyAt(i11);
                View view = this.mViews.valueAt(i11).get();
                pw.print(pfx);
                pw.print("autofillId: ");
                pw.println(autofillId);
                pw.print(pfx);
                pw.print("view:");
                pw.println(view);
            }
            pw.print("");
            pw.print("padded views: ");
            pw.println(this.mViewsToPadContent);
        }
        if (Log.isLoggable(UiTranslationManager.LOG_TAG, 3)) {
            dumpViewByTraversal("", pw);
        }
    }

    private void dumpViewByTraversal(String outerPrefix, PrintWriter pw) {
        ArrayList<ViewRootImpl> roots = WindowManagerGlobal.getInstance().getRootViews(this.mActivity.getActivityToken());
        pw.print(outerPrefix);
        pw.println("Dump views:");
        for (int rootNum = 0; rootNum < roots.size(); rootNum++) {
            View rootView = roots.get(rootNum).getView();
            if (rootView instanceof ViewGroup) {
                dumpChildren((ViewGroup) rootView, outerPrefix, pw);
            } else {
                dumpViewInfo(rootView, outerPrefix, pw);
            }
        }
    }

    private void dumpChildren(ViewGroup viewGroup, String outerPrefix, PrintWriter pw) {
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View child = viewGroup.getChildAt(i10);
            if (child instanceof ViewGroup) {
                pw.print(outerPrefix);
                pw.println("Children: ");
                pw.print(outerPrefix);
                pw.print(outerPrefix);
                pw.println(child);
                dumpChildren((ViewGroup) child, outerPrefix, pw);
            } else {
                pw.print(outerPrefix);
                pw.println("End Children: ");
                pw.print(outerPrefix);
                pw.print(outerPrefix);
                pw.print(child);
                dumpViewInfo(child, outerPrefix, pw);
            }
        }
    }

    private void dumpViewInfo(View view, String outerPrefix, PrintWriter pw) {
        AutofillId autofillId = view.getAutofillId();
        pw.print(outerPrefix);
        pw.print("autofillId: ");
        pw.print(autofillId);
        boolean isContainsView = false;
        boolean isRequestedView = false;
        synchronized (this.mLock) {
            if (this.mLastRequestAutofillIds.contains(autofillId)) {
                isRequestedView = true;
            }
            WeakReference<View> viewRef = this.mViews.get(autofillId);
            if (viewRef != null && viewRef.get() != null) {
                isContainsView = true;
            }
        }
        pw.print(outerPrefix);
        pw.print("isContainsView: ");
        pw.print(isContainsView);
        pw.print(outerPrefix);
        pw.print("isRequestedView: ");
        pw.println(isRequestedView);
    }

    public void onTranslationCompleted(TranslationResponse response) {
        Object valueOf;
        if (response == null || response.getTranslationStatus() != 0) {
            StringBuilder append = new StringBuilder().append("Fail result from TranslationService, status=");
            if (response == null) {
                valueOf = "null";
            } else {
                valueOf = Integer.valueOf(response.getTranslationStatus());
            }
            Log.w("UiTranslationController", append.append(valueOf).toString());
            return;
        }
        SparseArray<ViewTranslationResponse> translatedResult = response.getViewTranslationResponses();
        SparseArray<ViewTranslationResponse> viewsResult = new SparseArray<>();
        SparseArray<LongSparseArray<ViewTranslationResponse>> virtualViewsResult = new SparseArray<>();
        IntArray viewIds = new IntArray(1);
        for (int i10 = 0; i10 < translatedResult.size(); i10++) {
            ViewTranslationResponse result = translatedResult.valueAt(i10);
            AutofillId autofillId = result.getAutofillId();
            if (viewIds.indexOf(autofillId.getViewId()) < 0) {
                viewIds.add(autofillId.getViewId());
            }
            if (autofillId.isNonVirtual()) {
                viewsResult.put(translatedResult.keyAt(i10), result);
            } else {
                boolean isVirtualViewAdded = virtualViewsResult.indexOfKey(autofillId.getViewId()) >= 0;
                LongSparseArray<ViewTranslationResponse> childIds = isVirtualViewAdded ? virtualViewsResult.get(autofillId.getViewId()) : new LongSparseArray<>();
                childIds.put(autofillId.getVirtualChildLongId(), result);
                if (!isVirtualViewAdded) {
                    virtualViewsResult.put(autofillId.getViewId(), childIds);
                }
            }
        }
        findViewsTraversalByAutofillIds(viewIds);
        if (viewsResult.size() > 0) {
            onTranslationCompleted(viewsResult);
        }
        if (virtualViewsResult.size() > 0) {
            onVirtualViewTranslationCompleted(virtualViewsResult);
        }
    }

    private void onVirtualViewTranslationCompleted(SparseArray<LongSparseArray<ViewTranslationResponse>> translatedResult) {
        final boolean isLoggable = Log.isLoggable(UiTranslationManager.LOG_TAG, 3);
        if (this.mActivity.isDestroyed()) {
            Log.v("UiTranslationController", "onTranslationCompleted:" + ((Object) this.mActivity) + "is destroyed.");
            return;
        }
        synchronized (this.mLock) {
            if (this.mCurrentState == 3) {
                Log.w("UiTranslationController", "onTranslationCompleted: the translation state is finished now. Skip to show the translated text.");
                return;
            }
            for (int i10 = 0; i10 < translatedResult.size(); i10++) {
                AutofillId autofillId = new AutofillId(translatedResult.keyAt(i10));
                WeakReference<View> viewRef = this.mViews.get(autofillId);
                if (viewRef != null) {
                    final View view = viewRef.get();
                    if (view == null) {
                        Log.w("UiTranslationController", "onTranslationCompleted: the view for autofill id " + ((Object) autofillId) + " may be gone.");
                    } else {
                        LongSparseArray<ViewTranslationResponse> virtualChildResponse = translatedResult.valueAt(i10);
                        if (isLoggable) {
                            Log.v("UiTranslationController", "onVirtualViewTranslationCompleted: received response for AutofillId " + ((Object) autofillId));
                        }
                        view.onVirtualViewTranslationResponses(virtualChildResponse);
                        if (this.mCurrentState == 1) {
                            return;
                        } else {
                            this.mActivity.runOnUiThread(new Runnable() { // from class: android.view.translation.UiTranslationController$$ExternalSyntheticLambda8
                                @Override // java.lang.Runnable
                                public final void run() {
                                    UiTranslationController.lambda$onVirtualViewTranslationCompleted$3(View.this, isLoggable);
                                }
                            });
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$onVirtualViewTranslationCompleted$3(View view, boolean isLoggable) {
        if (view.getViewTranslationCallback() == null) {
            if (isLoggable) {
                Log.d("UiTranslationController", ((Object) view) + " doesn't support showing translation because of null ViewTranslationCallback.");
            }
        } else if (view.getViewTranslationCallback() != null) {
            view.getViewTranslationCallback().onShowTranslation(view);
        }
    }

    private void onTranslationCompleted(SparseArray<ViewTranslationResponse> translatedResult) {
        boolean isLoggable;
        UiTranslationController uiTranslationController = this;
        boolean isLoggable2 = Log.isLoggable(UiTranslationManager.LOG_TAG, 3);
        if (uiTranslationController.mActivity.isDestroyed()) {
            Log.v("UiTranslationController", "onTranslationCompleted:" + ((Object) uiTranslationController.mActivity) + "is destroyed.");
            return;
        }
        int resultCount = translatedResult.size();
        if (isLoggable2) {
            Log.v("UiTranslationController", "onTranslationCompleted: receive " + resultCount + " responses.");
        }
        synchronized (uiTranslationController.mLock) {
            try {
                try {
                    if (uiTranslationController.mCurrentState != 3) {
                        int i10 = 0;
                        while (i10 < resultCount) {
                            try {
                                final ViewTranslationResponse response = translatedResult.valueAt(i10);
                                if (isLoggable2) {
                                    try {
                                        Log.v("UiTranslationController", "onTranslationCompleted: " + sanitizedViewTranslationResponse(response));
                                    } catch (Throwable th) {
                                        th = th;
                                    }
                                }
                                final AutofillId autofillId = response.getAutofillId();
                                if (autofillId == null) {
                                    Log.w("UiTranslationController", "No AutofillId is set in ViewTranslationResponse");
                                    isLoggable = isLoggable2;
                                } else {
                                    WeakReference<View> viewRef = uiTranslationController.mViews.get(autofillId);
                                    if (viewRef == null) {
                                        isLoggable = isLoggable2;
                                    } else {
                                        final View view = viewRef.get();
                                        if (view == null) {
                                            Log.w("UiTranslationController", "onTranslationCompleted: the view for autofill id " + ((Object) autofillId) + " may be gone.");
                                            isLoggable = isLoggable2;
                                        } else {
                                            final int currentState = uiTranslationController.mCurrentState;
                                            final boolean z10 = isLoggable2;
                                            isLoggable = isLoggable2;
                                            uiTranslationController.mActivity.runOnUiThread(new Runnable() { // from class: android.view.translation.UiTranslationController$$ExternalSyntheticLambda2
                                                @Override // java.lang.Runnable
                                                public final void run() {
                                                    UiTranslationController.this.lambda$onTranslationCompleted$4(view, response, z10, autofillId, currentState);
                                                }
                                            });
                                        }
                                    }
                                }
                                i10++;
                                uiTranslationController = this;
                                isLoggable2 = isLoggable;
                            } catch (Throwable th2) {
                                th = th2;
                                throw th;
                            }
                        }
                        return;
                    }
                    try {
                        Log.w("UiTranslationController", "onTranslationCompleted: the translation state is finished now. Skip to show the translated text.");
                        return;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (Throwable th4) {
                    th = th4;
                }
            } catch (Throwable th5) {
                th = th5;
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onTranslationCompleted$4(View view, ViewTranslationResponse response, boolean isLoggable, AutofillId autofillId, int currentState) {
        ViewTranslationCallback callback = view.getViewTranslationCallback();
        if (view.getViewTranslationResponse() != null && view.getViewTranslationResponse().equals(response) && (callback instanceof TextViewTranslationCallback)) {
            TextViewTranslationCallback textViewCallback = (TextViewTranslationCallback) callback;
            if (textViewCallback.isShowingTranslation() || textViewCallback.isAnimationRunning()) {
                if (isLoggable) {
                    Log.d("UiTranslationController", "Duplicate ViewTranslationResponse for " + ((Object) autofillId) + ". Ignoring.");
                    return;
                }
                return;
            }
        }
        if (callback == null) {
            if (view instanceof TextView) {
                callback = new TextViewTranslationCallback();
                view.setViewTranslationCallback(callback);
            } else {
                if (isLoggable) {
                    Log.d("UiTranslationController", ((Object) view) + " doesn't support showing translation because of null ViewTranslationCallback.");
                    return;
                }
                return;
            }
        }
        callback.setAnimationDurationMillis(250);
        if (this.mViewsToPadContent.contains(autofillId)) {
            callback.enableContentPadding();
        }
        view.onViewTranslationResponse(response);
        if (currentState == 1) {
            return;
        }
        callback.onShowTranslation(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createTranslatorAndStart(TranslationSpec sourceSpec, TranslationSpec targetSpec, List<AutofillId> views) {
        Translator translator = createTranslatorIfNeeded(sourceSpec, targetSpec);
        if (translator == null) {
            Log.w("UiTranslationController", "Can not create Translator for sourceSpec:" + ((Object) sourceSpec) + " targetSpec:" + ((Object) targetSpec));
        } else {
            onUiTranslationStarted(translator, views);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendTranslationRequest(Translator translator, List<ViewTranslationRequest> requests) {
        if (requests.size() == 0) {
            Log.w("UiTranslationController", "No ViewTranslationRequest was collected.");
            return;
        }
        TranslationRequest request = new TranslationRequest.Builder().setViewTranslationRequests(requests).build();
        if (Log.isLoggable(UiTranslationManager.LOG_TAG, 3)) {
            StringBuilder msg = new StringBuilder("sendTranslationRequest:{requests=[");
            for (ViewTranslationRequest viewRequest : requests) {
                msg.append("{request=").append(sanitizedViewTranslationRequest(viewRequest)).append("}, ");
            }
            Log.d("UiTranslationController", "sendTranslationRequest: " + msg.toString());
        }
        translator.requestUiTranslate(request, new Executor() { // from class: android.view.translation.UiTranslationController$$ExternalSyntheticLambda9
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                runnable.run();
            }
        }, new Consumer() { // from class: android.view.translation.UiTranslationController$$ExternalSyntheticLambda10
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                UiTranslationController.this.onTranslationCompleted((TranslationResponse) obj);
            }
        });
    }

    private void onUiTranslationStarted(final Translator translator, List<AutofillId> views) {
        long[] childs;
        synchronized (this.mLock) {
            SparseIntArray virtualViewChildCount = getRequestVirtualViewChildCount(views);
            final Map<AutofillId, long[]> viewIds = new ArrayMap<>();
            Map<AutofillId, Integer> unusedIndices = null;
            for (int i10 = 0; i10 < views.size(); i10++) {
                AutofillId autofillId = views.get(i10);
                if (autofillId.isNonVirtual()) {
                    viewIds.put(autofillId, null);
                } else {
                    if (unusedIndices == null) {
                        unusedIndices = new ArrayMap<>();
                    }
                    AutofillId virtualViewAutofillId = new AutofillId(autofillId.getViewId());
                    int end = 0;
                    if (viewIds.containsKey(virtualViewAutofillId)) {
                        childs = viewIds.get(virtualViewAutofillId);
                        end = unusedIndices.get(virtualViewAutofillId).intValue();
                    } else {
                        int childCount = virtualViewChildCount.get(autofillId.getViewId());
                        long[] childs2 = new long[childCount];
                        viewIds.put(virtualViewAutofillId, childs2);
                        childs = childs2;
                    }
                    unusedIndices.put(virtualViewAutofillId, Integer.valueOf(end + 1));
                    childs[end] = autofillId.getVirtualChildLongId();
                }
            }
            final ArrayList<ViewTranslationRequest> requests = new ArrayList<>();
            final int[] supportedFormats = getSupportedFormatsLocked();
            final ArrayList<ViewRootImpl> roots = WindowManagerGlobal.getInstance().getRootViews(this.mActivity.getActivityToken());
            final TranslationCapability capability = getTranslationCapability(translator.getTranslationContext());
            this.mActivity.runOnUiThread(new Runnable() { // from class: android.view.translation.UiTranslationController$$ExternalSyntheticLambda7
                @Override // java.lang.Runnable
                public final void run() {
                    UiTranslationController.this.lambda$onUiTranslationStarted$6(roots, viewIds, supportedFormats, capability, requests, translator);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onUiTranslationStarted$6(ArrayList roots, Map viewIds, int[] supportedFormats, TranslationCapability capability, ArrayList requests, Translator translator) {
        for (int rootNum = 0; rootNum < roots.size(); rootNum++) {
            View rootView = ((ViewRootImpl) roots.get(rootNum)).getView();
            rootView.dispatchCreateViewTranslationRequest(viewIds, supportedFormats, capability, requests);
        }
        this.mWorkerHandler.sendMessage(PooledLambda.obtainMessage(new TriConsumer() { // from class: android.view.translation.UiTranslationController$$ExternalSyntheticLambda0
            public final void accept(Object obj, Object obj2, Object obj3) {
                ((UiTranslationController) obj).sendTranslationRequest((Translator) obj2, (ArrayList) obj3);
            }
        }, this, translator, requests));
    }

    private SparseIntArray getRequestVirtualViewChildCount(List<AutofillId> views) {
        SparseIntArray virtualViewCount = new SparseIntArray();
        for (int i10 = 0; i10 < views.size(); i10++) {
            AutofillId autofillId = views.get(i10);
            if (!autofillId.isNonVirtual()) {
                int virtualViewId = autofillId.getViewId();
                if (virtualViewCount.indexOfKey(virtualViewId) < 0) {
                    virtualViewCount.put(virtualViewId, 1);
                } else {
                    virtualViewCount.put(virtualViewId, virtualViewCount.get(virtualViewId) + 1);
                }
            }
        }
        return virtualViewCount;
    }

    private int[] getSupportedFormatsLocked() {
        return new int[]{1};
    }

    private TranslationCapability getTranslationCapability(TranslationContext translationContext) {
        return new TranslationCapability(3, translationContext.getSourceSpec(), translationContext.getTargetSpec(), true, 0);
    }

    private void findViewsTraversalByAutofillIds(IntArray sourceViewIds) {
        ArrayList<ViewRootImpl> roots = WindowManagerGlobal.getInstance().getRootViews(this.mActivity.getActivityToken());
        for (int rootNum = 0; rootNum < roots.size(); rootNum++) {
            View rootView = roots.get(rootNum).getView();
            if (rootView instanceof ViewGroup) {
                findViewsTraversalByAutofillIds((ViewGroup) rootView, sourceViewIds);
            }
            addViewIfNeeded(sourceViewIds, rootView);
        }
    }

    private void findViewsTraversalByAutofillIds(ViewGroup viewGroup, IntArray sourceViewIds) {
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View child = viewGroup.getChildAt(i10);
            if (child instanceof ViewGroup) {
                findViewsTraversalByAutofillIds((ViewGroup) child, sourceViewIds);
            }
            addViewIfNeeded(sourceViewIds, child);
        }
    }

    private void addViewIfNeeded(IntArray sourceViewIds, View view) {
        AutofillId autofillId = view.getAutofillId();
        if (autofillId != null && sourceViewIds.indexOf(autofillId.getViewId()) >= 0 && !this.mViews.containsKey(autofillId)) {
            this.mViews.put(autofillId, new WeakReference<>(view));
        }
    }

    private void runForEachView(final BiConsumer<View, ViewTranslationCallback> action) {
        synchronized (this.mLock) {
            final boolean isLoggable = Log.isLoggable(UiTranslationManager.LOG_TAG, 3);
            final ArrayMap<AutofillId, WeakReference<View>> views = new ArrayMap<>(this.mViews);
            if (views.size() == 0) {
                Log.w("UiTranslationController", "No views can be excuted for runForEachView.");
            }
            this.mActivity.runOnUiThread(new Runnable() { // from class: android.view.translation.UiTranslationController$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    UiTranslationController.lambda$runForEachView$7(views, isLoggable, action);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void lambda$runForEachView$7(ArrayMap views, boolean isLoggable, BiConsumer action) {
        int viewCounts = views.size();
        for (int i10 = 0; i10 < viewCounts; i10++) {
            View view = (View) ((WeakReference) views.valueAt(i10)).get();
            if (isLoggable) {
                Log.d("UiTranslationController", "runForEachView for autofillId = " + (view != null ? view.getAutofillId() : " null"));
            }
            if (view == null || view.getViewTranslationCallback() == null) {
                if (isLoggable) {
                    Log.d("UiTranslationController", "View was gone or ViewTranslationCallback for autofillId = " + views.keyAt(i10));
                }
            } else {
                action.accept(view, view.getViewTranslationCallback());
            }
        }
    }

    private Translator createTranslatorIfNeeded(TranslationSpec sourceSpec, TranslationSpec targetSpec) {
        TranslationManager tm = (TranslationManager) this.mContext.getSystemService(TranslationManager.class);
        if (tm == null) {
            Log.e("UiTranslationController", "Can not find TranslationManager when trying to create translator.");
            return null;
        }
        TranslationContext translationContext = new TranslationContext.Builder(sourceSpec, targetSpec).setActivityId(new ActivityId(this.mActivity.getTaskId(), this.mActivity.getShareableActivityToken())).build();
        Translator translator = tm.createTranslator(translationContext);
        if (translator != null) {
            Pair<TranslationSpec, TranslationSpec> specs = new Pair<>(sourceSpec, targetSpec);
            this.mTranslators.put(specs, translator);
        }
        return translator;
    }

    private void destroyTranslators() {
        synchronized (this.mLock) {
            int count = this.mTranslators.size();
            for (int i10 = 0; i10 < count; i10++) {
                Translator translator = this.mTranslators.valueAt(i10);
                translator.destroy();
            }
            this.mTranslators.clear();
        }
    }

    public static String stateToString(int state) {
        switch (state) {
            case 0:
                return "UI_TRANSLATION_STARTED";
            case 1:
                return "UI_TRANSLATION_PAUSED";
            case 2:
                return "UI_TRANSLATION_RESUMED";
            case 3:
                return "UI_TRANSLATION_FINISHED";
            default:
                return "Unknown state (" + state + ")";
        }
    }

    private static String sanitizedViewTranslationRequest(ViewTranslationRequest request) {
        String str;
        StringBuilder msg = new StringBuilder("ViewTranslationRequest:{values=[");
        for (String key : request.getKeys()) {
            TranslationRequestValue value = request.getValue(key);
            StringBuilder append = msg.append("{text=");
            if (value.getText() == null) {
                str = "null";
            } else {
                str = "string[" + value.getText().length() + "]}, ";
            }
            append.append(str);
        }
        return msg.toString();
    }

    private static String sanitizedViewTranslationResponse(ViewTranslationResponse response) {
        String str;
        Iterator<String> it;
        Iterator<String> it2;
        String str2;
        StringBuilder msg = new StringBuilder("ViewTranslationResponse:{values=[");
        Iterator<String> iterator2 = response.getKeys().iterator2();
        while (iterator2.hasNext()) {
            String key = iterator2.next();
            TranslationResponseValue value = response.getValue(key);
            msg.append("{status=").append(value.getStatusCode()).append(", ");
            StringBuilder append = msg.append("text=");
            String str3 = "null";
            if (value.getText() == null) {
                str = "null";
            } else {
                str = "string[" + value.getText().length() + "], ";
            }
            append.append(str);
            Bundle definitions = (Bundle) value.getExtras().get(TranslationResponseValue.EXTRA_DEFINITIONS);
            if (definitions == null) {
                it = iterator2;
            } else {
                msg.append("definitions={");
                for (String partOfSpeech : definitions.keySet()) {
                    msg.append(partOfSpeech).append(":[");
                    CharSequence[] charSequenceArray = definitions.getCharSequenceArray(partOfSpeech);
                    int length = charSequenceArray.length;
                    int i10 = 0;
                    while (i10 < length) {
                        CharSequence definition = charSequenceArray[i10];
                        if (definition == null) {
                            str2 = "null, ";
                            it2 = iterator2;
                        } else {
                            it2 = iterator2;
                            str2 = "string[" + definition.length() + "], ";
                        }
                        msg.append(str2);
                        i10++;
                        iterator2 = it2;
                    }
                    msg.append("], ");
                }
                it = iterator2;
                msg.append(i.f4738d);
            }
            StringBuilder append2 = msg.append("transliteration=");
            if (value.getTransliteration() != null) {
                str3 = "string[" + value.getTransliteration().length() + "]}, ";
            }
            append2.append(str3);
            iterator2 = it;
        }
        return msg.toString();
    }
}
