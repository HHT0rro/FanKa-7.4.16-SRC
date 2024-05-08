package android.view.autofill;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.annotation.SystemApi;
import android.app.assist.AssistStructure;
import android.content.AutofillOptions;
import android.content.ClipData;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.ResolveInfo;
import android.graphics.Rect;
import android.metrics.LogMaker;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.SystemClock;
import android.service.autofill.FillEventHistory;
import android.service.autofill.UserData;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.DebugUtils;
import android.util.Log;
import android.util.Slog;
import android.util.SparseArray;
import android.view.Choreographer;
import android.view.ContentInfo;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewRootImpl;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.autofill.AutofillManager;
import android.view.autofill.IAugmentedAutofillManagerClient;
import android.view.autofill.IAutoFillManagerClient;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import com.android.internal.logging.MetricsLogger;
import com.android.internal.logging.nano.MetricsProto;
import com.android.internal.os.IResultReceiver;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.SyncResultReceiver;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.openalliance.ad.constant.u;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.xmlpull.v1.XmlPullParserException;
import sun.misc.Cleaner;
import system.ext.loader.core.ExtLoader;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final class AutofillManager {
    public static final int ACTION_RESPONSE_EXPIRED = 5;
    public static final int ACTION_START_SESSION = 1;
    public static final int ACTION_VALUE_CHANGED = 4;
    public static final int ACTION_VIEW_ENTERED = 2;
    public static final int ACTION_VIEW_EXITED = 3;
    public static final String ANY_HINT = "any";
    private static final int AUTHENTICATION_ID_DATASET_ID_MASK = 65535;
    private static final int AUTHENTICATION_ID_DATASET_ID_SHIFT = 16;
    public static final int AUTHENTICATION_ID_DATASET_ID_UNDEFINED = 65535;
    public static final int COMMIT_REASON_ACTIVITY_FINISHED = 1;
    public static final int COMMIT_REASON_SESSION_DESTROYED = 5;
    public static final int COMMIT_REASON_UNKNOWN = 0;
    public static final int COMMIT_REASON_VIEW_CHANGED = 4;
    public static final int COMMIT_REASON_VIEW_CLICKED = 3;
    public static final int COMMIT_REASON_VIEW_COMMITTED = 2;
    public static final int DEFAULT_LOGGING_LEVEL = 4;
    public static final int DEFAULT_MAX_PARTITIONS_SIZE = 10;
    public static final String EXTRA_ASSIST_STRUCTURE = "android.view.autofill.extra.ASSIST_STRUCTURE";
    public static final String EXTRA_AUGMENTED_AUTOFILL_CLIENT = "android.view.autofill.extra.AUGMENTED_AUTOFILL_CLIENT";
    public static final String EXTRA_AUTHENTICATION_RESULT = "android.view.autofill.extra.AUTHENTICATION_RESULT";
    public static final String EXTRA_AUTHENTICATION_RESULT_EPHEMERAL_DATASET = "android.view.autofill.extra.AUTHENTICATION_RESULT_EPHEMERAL_DATASET";
    public static final String EXTRA_CLIENT_STATE = "android.view.autofill.extra.CLIENT_STATE";
    public static final String EXTRA_INLINE_SUGGESTIONS_REQUEST = "android.view.autofill.extra.INLINE_SUGGESTIONS_REQUEST";
    public static final String EXTRA_RESTORE_CROSS_ACTIVITY = "android.view.autofill.extra.RESTORE_CROSS_ACTIVITY";
    public static final String EXTRA_RESTORE_SESSION_TOKEN = "android.view.autofill.extra.RESTORE_SESSION_TOKEN";
    public static final int FC_SERVICE_TIMEOUT = 5000;
    public static final int FLAG_ADD_CLIENT_DEBUG = 2;
    public static final int FLAG_ADD_CLIENT_ENABLED = 1;
    public static final int FLAG_ADD_CLIENT_ENABLED_FOR_AUGMENTED_AUTOFILL_ONLY = 8;
    public static final int FLAG_ADD_CLIENT_VERBOSE = 4;
    public static final int FLAG_SMART_SUGGESTION_OFF = 0;
    public static final int FLAG_SMART_SUGGESTION_SYSTEM = 1;
    private static final String LAST_AUTOFILLED_DATA_TAG = "android:lastAutoFilledData";
    public static final int MAX_TEMP_AUGMENTED_SERVICE_DURATION_MS = 120000;
    public static final int NO_LOGGING = 0;
    public static final int NO_SESSION = Integer.MAX_VALUE;
    public static final int PENDING_UI_OPERATION_CANCEL = 1;
    public static final int PENDING_UI_OPERATION_RESTORE = 2;
    public static final int RECEIVER_FLAG_SESSION_FOR_AUGMENTED_AUTOFILL_ONLY = 1;
    public static final int RESULT_CODE_NOT_SERVICE = -1;
    public static final int RESULT_OK = 0;
    private static final String SESSION_ID_TAG = "android:sessionId";
    public static final int SET_STATE_FLAG_DEBUG = 8;
    public static final int SET_STATE_FLAG_ENABLED = 1;
    public static final int SET_STATE_FLAG_FOR_AUTOFILL_ONLY = 32;
    public static final int SET_STATE_FLAG_RESET_CLIENT = 4;
    public static final int SET_STATE_FLAG_RESET_SESSION = 2;
    public static final int SET_STATE_FLAG_VERBOSE = 16;
    public static final int STATE_ACTIVE = 1;
    public static final int STATE_DISABLED_BY_SERVICE = 4;
    public static final int STATE_FINISHED = 2;
    public static final int STATE_SHOWING_SAVE_UI = 3;
    private static final String STATE_TAG = "android:state";
    public static final int STATE_UNKNOWN = 0;
    public static final int STATE_UNKNOWN_COMPAT_MODE = 5;
    public static final int STATE_UNKNOWN_FAILED = 6;
    private static final int SYNC_CALLS_TIMEOUT_MS = 5000;
    private static final String TAG = "AutofillManager";
    private Set<String> mAllowedActivitySet;
    private IAugmentedAutofillManagerClient mAugmentedAutofillServiceClient;
    private AutofillCallback mCallback;
    private CompatibilityBridge mCompatibilityBridge;
    private final Context mContext;
    private Set<String> mDeniedActivitySet;
    private boolean mEnabled;
    private boolean mEnabledForAugmentedAutofillOnly;
    private Set<AutofillId> mEnteredForAugmentedAutofillIds;
    private ArraySet<AutofillId> mEnteredIds;
    private final String[] mFillDialogEnabledHints;
    private List<AutofillId> mFillDialogTriggerIds;
    private ArraySet<AutofillId> mFillableIds;
    private boolean mForAugmentedAutofillOnly;
    private boolean mHasCredentialField;
    private AutofillId mIdShownFillUi;
    private final boolean mIsFillAndSaveDialogDisabledForCredentialManager;
    private final boolean mIsFillDialogEnabled;
    private AtomicBoolean mIsFillRequested;
    private boolean mIsPackageFullyAllowedForAutofill;
    private boolean mIsPackageFullyDeniedForAutofill;
    private boolean mIsPackagePartiallyAllowedForAutofill;
    private boolean mIsPackagePartiallyDeniedForAutofill;
    private boolean mIsTriggerFillRequestOnFilteredImportantViewsEnabled;
    private boolean mIsTriggerFillRequestOnUnimportantViewEnabled;
    private ParcelableMap mLastAutofilledData;
    private Set<String> mNonAutofillableImeActionIdSet;
    private boolean mOnInvisibleCalled;
    private final AutofillOptions mOptions;
    private boolean mSaveOnFinish;
    private AutofillId mSaveTriggerId;
    private final IAutoFillManager mService;
    private IAutoFillManagerClient mServiceClient;
    private Cleaner mServiceClientCleaner;
    private boolean mShouldEnableAutofillOnAllViewTypes;
    private boolean mShouldEnableMultilineFilter;
    private boolean mShouldIncludeAllChildrenViewInAssistStructure;
    private boolean mShouldIncludeAllViewsWithAutofillTypeNotNoneInAssistStructure;
    private TrackedViews mTrackedViews;
    private final MetricsLogger mMetricsLogger = new MetricsLogger();
    private final Object mLock = new Object();
    private int mSessionId = Integer.MAX_VALUE;
    private int mState = 0;
    private boolean mShowAutofillDialogCalled = false;
    private final ArraySet<AutofillId> mAllTrackedViews = new ArraySet<>();
    private IAutofillManagerExt mAutofillManagerExt = (IAutofillManagerExt) ExtLoader.type(IAutofillManagerExt.class).base(this).create();

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public interface AutofillClient {
        void autofillClientAuthenticate(int i10, IntentSender intentSender, Intent intent, boolean z10);

        void autofillClientDispatchUnhandledKey(View view, KeyEvent keyEvent);

        View autofillClientFindViewByAccessibilityIdTraversal(int i10, int i11);

        View autofillClientFindViewByAutofillIdTraversal(AutofillId autofillId);

        View[] autofillClientFindViewsByAutofillIdTraversal(AutofillId[] autofillIdArr);

        IBinder autofillClientGetActivityToken();

        ComponentName autofillClientGetComponentName();

        AutofillId autofillClientGetNextAutofillId();

        boolean[] autofillClientGetViewVisibility(AutofillId[] autofillIdArr);

        boolean autofillClientIsCompatibilityModeEnabled();

        boolean autofillClientIsFillUiShowing();

        boolean autofillClientIsVisibleForAutofill();

        boolean autofillClientRequestHideFillUi();

        boolean autofillClientRequestShowFillUi(View view, int i10, int i11, Rect rect, IAutofillWindowPresenter iAutofillWindowPresenter);

        void autofillClientResetableStateAvailable();

        void autofillClientRunOnUiThread(Runnable runnable);

        boolean isDisablingEnterExitEventForAutofill();
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public @interface AutofillCommitReason {
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public @interface SmartSuggestionMode {
    }

    public static int makeAuthenticationId(int requestId, int datasetId) {
        return (requestId << 16) | (65535 & datasetId);
    }

    public static int getRequestIdFromAuthenticationId(int authRequestId) {
        return authRequestId >> 16;
    }

    public static int getDatasetIdFromAuthenticationId(int authRequestId) {
        return 65535 & authRequestId;
    }

    public AutofillManager(Context context, IAutoFillManager service) {
        this.mIsTriggerFillRequestOnUnimportantViewEnabled = false;
        this.mNonAutofillableImeActionIdSet = new ArraySet();
        this.mIsPackageFullyDeniedForAutofill = false;
        this.mIsPackagePartiallyDeniedForAutofill = false;
        this.mDeniedActivitySet = new ArraySet();
        this.mIsPackageFullyAllowedForAutofill = false;
        this.mIsPackagePartiallyAllowedForAutofill = false;
        this.mAllowedActivitySet = new ArraySet();
        Context context2 = (Context) Objects.requireNonNull(context, "context cannot be null");
        this.mContext = context2;
        this.mService = service;
        AutofillOptions autofillOptions = context.getAutofillOptions();
        this.mOptions = autofillOptions;
        this.mIsFillRequested = new AtomicBoolean(false);
        boolean isFillDialogEnabled = AutofillFeatureFlags.isFillDialogEnabled();
        this.mIsFillDialogEnabled = isFillDialogEnabled;
        String[] fillDialogEnabledHints = AutofillFeatureFlags.getFillDialogEnabledHints();
        this.mFillDialogEnabledHints = fillDialogEnabledHints;
        this.mIsFillAndSaveDialogDisabledForCredentialManager = AutofillFeatureFlags.isFillAndSaveDialogDisabledForCredentialManager();
        if (Helper.sDebug) {
            Log.d("AutofillManager", "Fill dialog is enabled:" + isFillDialogEnabled + ", hints=" + Arrays.toString(fillDialogEnabledHints));
        }
        if (autofillOptions != null) {
            Helper.sDebug = (autofillOptions.loggingLevel & 2) != 0;
            Helper.sVerbose = (autofillOptions.loggingLevel & 4) != 0;
        }
        this.mIsTriggerFillRequestOnUnimportantViewEnabled = AutofillFeatureFlags.isTriggerFillRequestOnUnimportantViewEnabled();
        this.mIsTriggerFillRequestOnFilteredImportantViewsEnabled = AutofillFeatureFlags.isTriggerFillRequestOnFilteredImportantViewsEnabled();
        this.mShouldEnableAutofillOnAllViewTypes = AutofillFeatureFlags.shouldEnableAutofillOnAllViewTypes();
        this.mNonAutofillableImeActionIdSet = AutofillFeatureFlags.getNonAutofillableImeActionIdSetFromFlag();
        this.mShouldEnableMultilineFilter = AutofillFeatureFlags.shouldEnableMultilineFilter();
        String denyListString = AutofillFeatureFlags.getDenylistStringFromFlag();
        String allowlistString = AutofillFeatureFlags.getAllowlistStringFromFlag();
        String packageName = context2.getPackageName();
        this.mIsPackageFullyDeniedForAutofill = isPackageFullyAllowedOrDeniedForAutofill(denyListString, packageName);
        this.mIsPackageFullyAllowedForAutofill = isPackageFullyAllowedOrDeniedForAutofill(allowlistString, packageName);
        if (!this.mIsPackageFullyDeniedForAutofill) {
            this.mIsPackagePartiallyDeniedForAutofill = isPackagePartiallyDeniedOrAllowedForAutofill(denyListString, packageName);
        }
        if (!this.mIsPackageFullyAllowedForAutofill) {
            this.mIsPackagePartiallyAllowedForAutofill = isPackagePartiallyDeniedOrAllowedForAutofill(allowlistString, packageName);
        }
        if (this.mIsPackagePartiallyDeniedForAutofill) {
            this.mDeniedActivitySet = getDeniedOrAllowedActivitySetFromString(denyListString, packageName);
        }
        if (this.mIsPackagePartiallyAllowedForAutofill) {
            this.mAllowedActivitySet = getDeniedOrAllowedActivitySetFromString(allowlistString, packageName);
        }
        this.mShouldIncludeAllViewsWithAutofillTypeNotNoneInAssistStructure = AutofillFeatureFlags.shouldIncludeAllViewsAutofillTypeNotNoneInAssistStructrue();
        this.mShouldIncludeAllChildrenViewInAssistStructure = AutofillFeatureFlags.shouldIncludeAllChildrenViewInAssistStructure();
    }

    public boolean isTriggerFillRequestOnFilteredImportantViewsEnabled() {
        return this.mIsTriggerFillRequestOnFilteredImportantViewsEnabled;
    }

    public boolean isTriggerFillRequestOnUnimportantViewEnabled() {
        return this.mIsTriggerFillRequestOnUnimportantViewEnabled;
    }

    private boolean isPassingImeActionCheck(EditText editText) {
        int actionId = editText.getImeOptions();
        if (this.mNonAutofillableImeActionIdSet.contains(String.valueOf(actionId))) {
            Log.d("AutofillManager", "view not autofillable - not passing ime action check");
            return false;
        }
        return true;
    }

    private boolean isPassingMultilineCheck(EditText editText) {
        if (editText.getMinLines() <= 1) {
            return true;
        }
        Log.d("AutofillManager", "view not autofillable - has multiline input type");
        return false;
    }

    private boolean isPackageFullyAllowedOrDeniedForAutofill(String listString, String packageName) {
        return listString.indexOf(new StringBuilder().append(packageName).append(":;").toString()) != -1;
    }

    private boolean isPackagePartiallyDeniedOrAllowedForAutofill(String listString, String packageName) {
        return listString.indexOf(new StringBuilder().append(packageName).append(u.bD).toString()) != -1;
    }

    public boolean shouldIncludeAllChildrenViewsWithAutofillTypeNotNoneInAssistStructure() {
        return this.mShouldIncludeAllViewsWithAutofillTypeNotNoneInAssistStructure;
    }

    public boolean shouldIncludeAllChildrenViewInAssistStructure() {
        return this.mShouldIncludeAllChildrenViewInAssistStructure;
    }

    private Set<String> getDeniedOrAllowedActivitySetFromString(String listString, String packageName) {
        int packageInStringIndex = listString.indexOf(packageName + u.bD);
        int firstNextSemicolonIndex = listString.indexOf(";", packageInStringIndex);
        int activityStringStartIndex = packageName.length() + packageInStringIndex + 1;
        if (activityStringStartIndex >= firstNextSemicolonIndex) {
            Log.e("AutofillManager", "Failed to get denied activity names from list because it's wrongly formatted");
            return new ArraySet();
        }
        String activitySubstring = listString.substring(activityStringStartIndex, firstNextSemicolonIndex);
        String[] activityStringArray = activitySubstring.split(",");
        return new ArraySet(Arrays.asList(activityStringArray));
    }

    public boolean isActivityDeniedForAutofill() {
        AutofillClient client;
        if (this.mIsPackageFullyDeniedForAutofill) {
            return true;
        }
        if (!this.mIsPackagePartiallyDeniedForAutofill || (client = getClient()) == null) {
            return false;
        }
        ComponentName clientActivity = client.autofillClientGetComponentName();
        return this.mDeniedActivitySet.contains(clientActivity.flattenToShortString());
    }

    public boolean isActivityAllowedForAutofill() {
        AutofillClient client;
        if (this.mIsPackageFullyAllowedForAutofill) {
            return true;
        }
        if (!this.mIsPackagePartiallyAllowedForAutofill || (client = getClient()) == null) {
            return false;
        }
        ComponentName clientActivity = client.autofillClientGetComponentName();
        return this.mAllowedActivitySet.contains(clientActivity.flattenToShortString());
    }

    public boolean isAutofillable(View view) {
        if (view.getAutofillType() == 0) {
            return false;
        }
        if (!view.isImportantForAutofill() && isActivityDeniedForAutofill()) {
            Log.d("AutofillManager", "view is not autofillable - activity denied for autofill");
            return false;
        }
        if (isActivityAllowedForAutofill()) {
            Log.d("AutofillManager", "view is autofillable - activity allowed for autofill");
            return true;
        }
        if (view instanceof EditText) {
            if (!this.mShouldEnableMultilineFilter || isPassingMultilineCheck((EditText) view)) {
                return isPassingImeActionCheck((EditText) view);
            }
            return false;
        }
        if (view.isImportantForAutofill() || this.mShouldEnableAutofillOnAllViewTypes || (view instanceof CheckBox) || (view instanceof Spinner) || (view instanceof DatePicker) || (view instanceof TimePicker) || (view instanceof RadioGroup)) {
            return true;
        }
        Log.d("AutofillManager", "view is not autofillable - not important and filtered by view type check");
        return false;
    }

    public void enableCompatibilityMode() {
        synchronized (this.mLock) {
            if (Helper.sDebug) {
                Slog.d("AutofillManager", "creating CompatibilityBridge for " + ((Object) this.mContext));
            }
            this.mCompatibilityBridge = new CompatibilityBridge();
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        if (!hasAutofillFeature()) {
            return;
        }
        synchronized (this.mLock) {
            this.mLastAutofilledData = (ParcelableMap) savedInstanceState.getParcelable(LAST_AUTOFILLED_DATA_TAG, ParcelableMap.class);
            if (isActiveLocked()) {
                Log.w("AutofillManager", "New session was started before onCreate()");
                return;
            }
            this.mSessionId = savedInstanceState.getInt(SESSION_ID_TAG, Integer.MAX_VALUE);
            this.mState = savedInstanceState.getInt(STATE_TAG, 0);
            if (this.mSessionId != Integer.MAX_VALUE) {
                boolean clientAdded = tryAddServiceClientIfNeededLocked();
                AutofillClient client = getClient();
                if (client != null) {
                    IResultReceiver syncResultReceiver = new SyncResultReceiver(5000);
                    boolean sessionWasRestored = false;
                    try {
                        if (clientAdded) {
                            this.mService.restoreSession(this.mSessionId, client.autofillClientGetActivityToken(), this.mServiceClient.asBinder(), syncResultReceiver);
                            boolean z10 = true;
                            if (syncResultReceiver.getIntResult() != 1) {
                                z10 = false;
                            }
                            sessionWasRestored = z10;
                        } else {
                            Log.w("AutofillManager", "No service client for session " + this.mSessionId);
                        }
                        if (!sessionWasRestored) {
                            Log.w("AutofillManager", "Session " + this.mSessionId + " could not be restored");
                            this.mSessionId = Integer.MAX_VALUE;
                            this.mState = 0;
                        } else {
                            if (Helper.sDebug) {
                                Log.d("AutofillManager", "session " + this.mSessionId + " was restored");
                            }
                            client.autofillClientResetableStateAvailable();
                        }
                    } catch (RemoteException e2) {
                        Log.e("AutofillManager", "Could not figure out if there was an autofill session", e2);
                    } catch (SyncResultReceiver.TimeoutException e10) {
                        Log.e("AutofillManager", "Fail to get session restore status: " + ((Object) e10));
                    }
                }
            }
        }
    }

    public void onVisibleForAutofill() {
        Choreographer.getInstance().postCallback(4, new Runnable() { // from class: android.view.autofill.AutofillManager$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                AutofillManager.this.lambda$onVisibleForAutofill$0();
            }
        }, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onVisibleForAutofill$0() {
        TrackedViews trackedViews;
        synchronized (this.mLock) {
            if (this.mEnabled && isActiveLocked() && (trackedViews = this.mTrackedViews) != null) {
                trackedViews.onVisibleForAutofillChangedLocked();
            }
        }
    }

    public void onInvisibleForAutofill(boolean isExpiredResponse) {
        synchronized (this.mLock) {
            this.mOnInvisibleCalled = true;
            if (isExpiredResponse) {
                updateSessionLocked(null, null, null, 5, 0);
            }
        }
    }

    public void onSaveInstanceState(Bundle outState) {
        if (!hasAutofillFeature()) {
            return;
        }
        synchronized (this.mLock) {
            int i10 = this.mSessionId;
            if (i10 != Integer.MAX_VALUE) {
                outState.putInt(SESSION_ID_TAG, i10);
            }
            int i11 = this.mState;
            if (i11 != 0) {
                outState.putInt(STATE_TAG, i11);
            }
            ParcelableMap parcelableMap = this.mLastAutofilledData;
            if (parcelableMap != null) {
                outState.putParcelable(LAST_AUTOFILLED_DATA_TAG, parcelableMap);
            }
        }
    }

    public boolean isCompatibilityModeEnabledLocked() {
        return this.mCompatibilityBridge != null;
    }

    public boolean isEnabled() {
        if (!hasAutofillFeature()) {
            return false;
        }
        synchronized (this.mLock) {
            if (isDisabledByServiceLocked()) {
                return false;
            }
            boolean clientAdded = tryAddServiceClientIfNeededLocked();
            return clientAdded ? this.mEnabled : false;
        }
    }

    public FillEventHistory getFillEventHistory() {
        try {
            IResultReceiver syncResultReceiver = new SyncResultReceiver(5000);
            this.mService.getFillEventHistory(syncResultReceiver);
            return (FillEventHistory) syncResultReceiver.getParcelableResult();
        } catch (RemoteException e2) {
            throw e2.rethrowFromSystemServer();
        } catch (SyncResultReceiver.TimeoutException e10) {
            Log.e("AutofillManager", "Fail to get fill event history: " + ((Object) e10));
            return null;
        }
    }

    public void requestAutofill(View view) {
        int flags = 1;
        if (!view.isFocused()) {
            flags = 1 | 16;
        }
        notifyViewEntered(view, flags);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void requestAutofillFromNewSession(View view) {
        cancel();
        notifyViewEntered(view);
    }

    public void requestAutofill(View view, int virtualId, Rect absBounds) {
        int flags = 1;
        if (!view.isFocused()) {
            flags = 1 | 16;
        }
        notifyViewEntered(view, virtualId, absBounds, flags);
    }

    public void notifyViewEntered(View view) {
        notifyViewEntered(view, 0);
    }

    public void notifyVirtualViewsReady(View view, SparseArray<VirtualViewFillInfo> infos) {
        Objects.requireNonNull(infos);
        if (infos.size() == 0) {
            throw new IllegalArgumentException("No VirtualViewInfo found");
        }
        if (view.isCredential() && this.mIsFillAndSaveDialogDisabledForCredentialManager) {
            if (Helper.sDebug) {
                Log.d("AutofillManager", "Ignoring Fill Dialog request since important for credMan:" + view.getAutofillId().toString());
            }
            this.mHasCredentialField = true;
        } else {
            for (int i10 = 0; i10 < infos.size(); i10++) {
                VirtualViewFillInfo info = infos.valueAt(i10);
                int virtualId = infos.indexOfKey(i10);
                notifyViewReadyInner(getAutofillId(view, virtualId), info == null ? null : info.getAutofillHints());
            }
        }
    }

    public void notifyViewEnteredForFillDialog(View v2) {
        if (Helper.sDebug) {
            Log.d("AutofillManager", "notifyViewEnteredForFillDialog:" + ((Object) v2.getAutofillId()));
        }
        if (v2.isCredential() && this.mIsFillAndSaveDialogDisabledForCredentialManager) {
            if (Helper.sDebug) {
                Log.d("AutofillManager", "Ignoring Fill Dialog request since important for credMan:" + ((Object) v2.getAutofillId()));
            }
            this.mHasCredentialField = true;
            return;
        }
        notifyViewReadyInner(v2.getAutofillId(), v2.getAutofillHints());
    }

    private void notifyViewReadyInner(AutofillId id2, String[] autofillHints) {
        if (!hasAutofillFeature()) {
            return;
        }
        synchronized (this.mLock) {
            if (this.mAllTrackedViews.contains(id2)) {
                return;
            }
            this.mAllTrackedViews.add(id2);
            TrackedViews trackedViews = this.mTrackedViews;
            if (trackedViews != null) {
                trackedViews.checkViewState(id2);
            }
            if (this.mIsFillRequested.get()) {
                return;
            }
            if (AutofillFeatureFlags.isAutofillPccClassificationEnabled()) {
                synchronized (this.mLock) {
                    if (!isActiveLocked()) {
                        boolean clientAdded = tryAddServiceClientIfNeededLocked();
                        if (clientAdded) {
                            startSessionLocked(AutofillId.NO_AUTOFILL_ID, null, null, 512);
                        } else if (Helper.sVerbose) {
                            Log.v("AutofillManager", "not starting session: no service client");
                        }
                    }
                }
            }
            if (this.mIsFillDialogEnabled || ArrayUtils.containsAny(autofillHints, this.mFillDialogEnabledHints)) {
                if (Helper.sDebug) {
                    Log.d("AutofillManager", "Triggering pre-emptive request for fill dialog.");
                }
                int flags = 64 | 16;
                synchronized (this.mLock) {
                    notifyViewEnteredLocked(null, AutofillId.NO_AUTOFILL_ID, null, null, flags);
                }
            }
        }
    }

    private boolean hasFillDialogUiFeature() {
        return this.mIsFillDialogEnabled || !ArrayUtils.isEmpty(this.mFillDialogEnabledHints);
    }

    private int getImeStateFlag(View v2) {
        WindowInsets rootWindowInsets;
        if (v2 == null || (rootWindowInsets = v2.getRootWindowInsets()) == null || !rootWindowInsets.isVisible(WindowInsets.Type.ime())) {
            return 0;
        }
        return 128;
    }

    private boolean shouldIgnoreViewEnteredLocked(AutofillId id2, int flags) {
        ArraySet<AutofillId> arraySet;
        if (isDisabledByServiceLocked()) {
            if (Helper.sVerbose) {
                Log.v("AutofillManager", "ignoring notifyViewEntered(flags=" + flags + ", view=" + ((Object) id2) + ") on state " + getStateAsStringLocked() + " because disabled by svc");
            }
            return true;
        }
        if (isFinishedLocked() && (flags & 1) == 0 && (arraySet = this.mEnteredIds) != null && arraySet.contains(id2)) {
            if (Helper.sVerbose) {
                Log.v("AutofillManager", "ignoring notifyViewEntered(flags=" + flags + ", view=" + ((Object) id2) + ") on state " + getStateAsStringLocked() + " because view was already entered: " + ((Object) this.mEnteredIds));
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isClientVisibleForAutofillLocked() {
        AutofillClient client = getClient();
        return client != null && client.autofillClientIsVisibleForAutofill();
    }

    private boolean isClientDisablingEnterExitEvent() {
        AutofillClient client = getClient();
        return client != null && client.isDisablingEnterExitEventForAutofill();
    }

    private void notifyViewEntered(View view, int flags) {
        AutofillCallback callback;
        if (!hasAutofillFeature()) {
            return;
        }
        synchronized (this.mLock) {
            callback = notifyViewEnteredLocked(view, view.getAutofillId(), null, view.getAutofillValue(), flags);
        }
        if (callback != null) {
            this.mCallback.onAutofillEvent(view, 3);
        }
    }

    public void notifyViewExited(View view) {
        if (!hasAutofillFeature()) {
            return;
        }
        synchronized (this.mLock) {
            notifyViewExitedLocked(view);
        }
    }

    void notifyViewExitedLocked(View view) {
        boolean clientAdded = tryAddServiceClientIfNeededLocked();
        if (clientAdded) {
            if ((this.mEnabled || this.mEnabledForAugmentedAutofillOnly) && isActiveLocked() && !isClientDisablingEnterExitEvent()) {
                AutofillId id2 = view.getAutofillId();
                updateSessionLocked(id2, null, null, 3, 0);
            }
        }
    }

    public void notifyViewVisibilityChanged(View view, boolean isVisible) {
        notifyViewVisibilityChangedInternal(view, 0, isVisible, false);
    }

    public void notifyViewVisibilityChanged(View view, int virtualId, boolean isVisible) {
        notifyViewVisibilityChangedInternal(view, virtualId, isVisible, true);
    }

    private void notifyViewVisibilityChangedInternal(View view, int virtualId, boolean isVisible, boolean virtual) {
        ArraySet<AutofillId> arraySet;
        synchronized (this.mLock) {
            if (this.mForAugmentedAutofillOnly) {
                if (Helper.sVerbose) {
                    Log.v("AutofillManager", "notifyViewVisibilityChanged(): ignoring on augmented only mode");
                }
                return;
            }
            if (this.mEnabled && isActiveLocked()) {
                AutofillId id2 = virtual ? getAutofillId(view, virtualId) : view.getAutofillId();
                if (Helper.sVerbose) {
                    Log.v("AutofillManager", "visibility changed for " + ((Object) id2) + ": " + isVisible);
                }
                if (!isVisible && (arraySet = this.mFillableIds) != null && arraySet.contains(id2)) {
                    if (Helper.sDebug) {
                        Log.d("AutofillManager", "Hidding UI when view " + ((Object) id2) + " became invisible");
                    }
                    requestHideFillUi(id2, view);
                }
                TrackedViews trackedViews = this.mTrackedViews;
                if (trackedViews != null) {
                    trackedViews.notifyViewVisibilityChangedLocked(id2, isVisible);
                } else if (Helper.sVerbose) {
                    Log.v("AutofillManager", "Ignoring visibility change on " + ((Object) id2) + ": no tracked views");
                }
            } else if (!virtual && isVisible) {
                startAutofillIfNeededLocked(view);
            }
        }
    }

    public void notifyViewEntered(View view, int virtualId, Rect absBounds) {
        notifyViewEntered(view, virtualId, absBounds, 0);
    }

    private void notifyViewEntered(View view, int virtualId, Rect bounds, int flags) {
        AutofillCallback callback;
        if (!hasAutofillFeature()) {
            return;
        }
        synchronized (this.mLock) {
            callback = notifyViewEnteredLocked(view, getAutofillId(view, virtualId), bounds, null, flags);
        }
        if (callback != null) {
            callback.onAutofillEvent(view, virtualId, 3);
        }
    }

    private AutofillCallback notifyViewEnteredLocked(View view, AutofillId id2, Rect bounds, AutofillValue value, int flags) {
        if (shouldIgnoreViewEnteredLocked(id2, flags)) {
            return null;
        }
        boolean clientAdded = tryAddServiceClientIfNeededLocked();
        if (!clientAdded) {
            if (Helper.sVerbose) {
                Log.v("AutofillManager", "ignoring notifyViewEntered(" + ((Object) id2) + "): no service client");
            }
            return null;
        }
        if (!this.mEnabled && !this.mEnabledForAugmentedAutofillOnly) {
            if (Helper.sVerbose) {
                Log.v("AutofillManager", "ignoring notifyViewEntered(" + ((Object) id2) + "): disabled");
            }
            return this.mCallback;
        }
        this.mIsFillRequested.set(true);
        if (!isClientDisablingEnterExitEvent()) {
            if ((view instanceof TextView) && ((TextView) view).isAnyPasswordInputType()) {
                flags |= 4;
            }
            if (AutofillFeatureFlags.isFillAndSaveDialogDisabledForCredentialManager() && this.mHasCredentialField) {
                flags |= 1024;
                if (Helper.sVerbose) {
                    Log.v("AutofillManager", "updating session with flag screen has credman view");
                }
            }
            int flags2 = flags | getImeStateFlag(view);
            if (!isActiveLocked()) {
                startSessionLocked(id2, bounds, value, flags2);
            } else {
                if (this.mForAugmentedAutofillOnly && (flags2 & 1) != 0) {
                    if (Helper.sDebug) {
                        Log.d("AutofillManager", "notifyViewEntered(" + ((Object) id2) + "): resetting mForAugmentedAutofillOnly on manual request");
                    }
                    this.mForAugmentedAutofillOnly = false;
                }
                if ((flags2 & 64) != 0) {
                    flags2 |= 256;
                }
                updateSessionLocked(id2, bounds, value, 2, flags2);
            }
            addEnteredIdLocked(id2);
        }
        return null;
    }

    private void addEnteredIdLocked(AutofillId id2) {
        if (this.mEnteredIds == null) {
            this.mEnteredIds = new ArraySet<>(1);
        }
        id2.resetSessionId();
        this.mEnteredIds.add(id2);
    }

    public void notifyViewExited(View view, int virtualId) {
        if (Helper.sVerbose) {
            Log.v("AutofillManager", "notifyViewExited(" + ((Object) view.getAutofillId()) + ", " + virtualId);
        }
        if (!hasAutofillFeature()) {
            return;
        }
        synchronized (this.mLock) {
            notifyViewExitedLocked(view, virtualId);
        }
    }

    private void notifyViewExitedLocked(View view, int virtualId) {
        boolean clientAdded = tryAddServiceClientIfNeededLocked();
        if (clientAdded) {
            if ((this.mEnabled || this.mEnabledForAugmentedAutofillOnly) && isActiveLocked() && !isClientDisablingEnterExitEvent()) {
                AutofillId id2 = getAutofillId(view, virtualId);
                updateSessionLocked(id2, null, null, 3, 0);
            }
        }
    }

    public void notifyValueChanged(View view) {
        if (!hasAutofillFeature()) {
            return;
        }
        AutofillId id2 = null;
        boolean valueWasRead = false;
        AutofillValue value = null;
        synchronized (this.mLock) {
            if (this.mLastAutofilledData == null) {
                view.setAutofilled(false, false);
            } else {
                id2 = view.getAutofillId();
                if (this.mLastAutofilledData.containsKey(id2)) {
                    value = view.getAutofillValue();
                    valueWasRead = true;
                    boolean hideHighlight = this.mLastAutofilledData.h().size() == 1;
                    if (Objects.equals(this.mLastAutofilledData.get(id2), value)) {
                        view.setAutofilled(true, hideHighlight);
                    } else {
                        view.setAutofilled(false, false);
                        this.mLastAutofilledData.remove(id2);
                    }
                } else {
                    view.setAutofilled(false, false);
                }
            }
            if (this.mEnabled && isActiveLocked()) {
                if (id2 == null) {
                    id2 = view.getAutofillId();
                }
                if (!valueWasRead) {
                    value = view.getAutofillValue();
                }
                updateSessionLocked(id2, null, value, 4, getImeStateFlag(view));
                return;
            }
            if (!startAutofillIfNeededLocked(view) && Helper.sVerbose) {
                Log.v("AutofillManager", "notifyValueChanged(" + ((Object) view.getAutofillId()) + "): ignoring on state " + getStateAsStringLocked());
            }
        }
    }

    public void notifyValueChanged(View view, int virtualId, AutofillValue value) {
        if (!hasAutofillFeature()) {
            return;
        }
        synchronized (this.mLock) {
            if (this.mEnabled && isActiveLocked()) {
                AutofillId id2 = getAutofillId(view, virtualId);
                updateSessionLocked(id2, null, value, 4, getImeStateFlag(view));
                return;
            }
            if (Helper.sVerbose) {
                Log.v("AutofillManager", "notifyValueChanged(" + ((Object) view.getAutofillId()) + u.bD + virtualId + "): ignoring on state " + getStateAsStringLocked());
            }
        }
    }

    public void notifyViewClicked(View view) {
        notifyViewClicked(view.getAutofillId());
    }

    public void notifyViewClicked(View view, int virtualId) {
        notifyViewClicked(getAutofillId(view, virtualId));
    }

    private void notifyViewClicked(AutofillId id2) {
        if (!hasAutofillFeature()) {
            return;
        }
        if (Helper.sVerbose) {
            Log.v("AutofillManager", "notifyViewClicked(): id=" + ((Object) id2) + ", trigger=" + ((Object) this.mSaveTriggerId));
        }
        synchronized (this.mLock) {
            if (this.mEnabled && isActiveLocked()) {
                AutofillId autofillId = this.mSaveTriggerId;
                if (autofillId != null && autofillId.equals(id2)) {
                    if (Helper.sDebug) {
                        Log.d("AutofillManager", "triggering commit by click of " + ((Object) id2));
                    }
                    commitLocked(3);
                    this.mMetricsLogger.write(newLog(MetricsProto.MetricsEvent.AUTOFILL_SAVE_EXPLICITLY_TRIGGERED));
                }
            }
        }
    }

    public void onActivityFinishing() {
        if (!hasAutofillFeature()) {
            return;
        }
        synchronized (this.mLock) {
            if (this.mAutofillManagerExt.hookSaveOnFinish(getAutofillServiceComponentName(), this.mSaveOnFinish)) {
                if (Helper.sDebug) {
                    Log.d("AutofillManager", "onActivityFinishing(): calling commitLocked()");
                }
                commitLocked(this.mAutofillManagerExt.hookActivityFinishingCommitReason(1, this.mSaveOnFinish));
            } else {
                if (Helper.sDebug) {
                    Log.d("AutofillManager", "onActivityFinishing(): calling cancelLocked()");
                }
                cancelLocked();
            }
        }
    }

    public void commit() {
        if (!hasAutofillFeature()) {
            return;
        }
        if (Helper.sVerbose) {
            Log.v("AutofillManager", "commit() called by app");
        }
        synchronized (this.mLock) {
            commitLocked(2);
        }
    }

    private void commitLocked(int commitReason) {
        if (!this.mEnabled && !isActiveLocked()) {
            return;
        }
        finishSessionLocked(commitReason);
    }

    public void cancel() {
        if (Helper.sVerbose) {
            Log.v("AutofillManager", "cancel() called by app or augmented autofill service");
        }
        if (!hasAutofillFeature()) {
            return;
        }
        synchronized (this.mLock) {
            cancelLocked();
        }
    }

    private void cancelLocked() {
        if (!this.mEnabled && !isActiveLocked()) {
            return;
        }
        cancelSessionLocked();
    }

    public void disableOwnedAutofillServices() {
        disableAutofillServices();
    }

    public void disableAutofillServices() {
        if (!hasAutofillFeature()) {
            return;
        }
        try {
            this.mService.disableOwnedAutofillServices(this.mContext.getUserId());
        } catch (RemoteException e2) {
            throw e2.rethrowFromSystemServer();
        }
    }

    public boolean hasEnabledAutofillServices() {
        if (this.mService == null) {
            return false;
        }
        IResultReceiver syncResultReceiver = new SyncResultReceiver(5000);
        try {
            this.mService.isServiceEnabled(this.mContext.getUserId(), this.mContext.getPackageName(), syncResultReceiver);
            return syncResultReceiver.getIntResult() == 1;
        } catch (RemoteException e2) {
            throw e2.rethrowFromSystemServer();
        } catch (SyncResultReceiver.TimeoutException e10) {
            throw new RuntimeException("Fail to get enabled autofill services status. " + ((Object) e10));
        }
    }

    public ComponentName getAutofillServiceComponentName() {
        if (this.mService == null) {
            return null;
        }
        IResultReceiver syncResultReceiver = new SyncResultReceiver(5000);
        try {
            this.mService.getAutofillServiceComponentName(syncResultReceiver);
            return (ComponentName) syncResultReceiver.getParcelableResult();
        } catch (RemoteException e2) {
            throw e2.rethrowFromSystemServer();
        } catch (SyncResultReceiver.TimeoutException e10) {
            throw new RuntimeException("Fail to get autofill services component name. " + ((Object) e10));
        }
    }

    public String getUserDataId() {
        try {
            IResultReceiver syncResultReceiver = new SyncResultReceiver(5000);
            this.mService.getUserDataId(syncResultReceiver);
            return syncResultReceiver.getStringResult();
        } catch (SyncResultReceiver.TimeoutException e2) {
            throw new RuntimeException("Fail to get user data id for field classification. " + ((Object) e2));
        } catch (RemoteException e10) {
            throw e10.rethrowFromSystemServer();
        }
    }

    public UserData getUserData() {
        try {
            IResultReceiver syncResultReceiver = new SyncResultReceiver(5000);
            this.mService.getUserData(syncResultReceiver);
            return (UserData) syncResultReceiver.getParcelableResult();
        } catch (RemoteException e2) {
            throw e2.rethrowFromSystemServer();
        } catch (SyncResultReceiver.TimeoutException e10) {
            throw new RuntimeException("Fail to get user data for field classification. " + ((Object) e10));
        }
    }

    public void setUserData(UserData userData) {
        try {
            this.mService.setUserData(userData);
        } catch (RemoteException e2) {
            throw e2.rethrowFromSystemServer();
        }
    }

    public boolean isFieldClassificationEnabled() {
        IResultReceiver syncResultReceiver = new SyncResultReceiver(5000);
        try {
            this.mService.isFieldClassificationEnabled(syncResultReceiver);
            return syncResultReceiver.getIntResult() == 1;
        } catch (RemoteException e2) {
            throw e2.rethrowFromSystemServer();
        } catch (SyncResultReceiver.TimeoutException e10) {
            throw new RuntimeException("Fail to get field classification enabled status. " + ((Object) e10));
        }
    }

    public String getDefaultFieldClassificationAlgorithm() {
        IResultReceiver syncResultReceiver = new SyncResultReceiver(5000);
        try {
            this.mService.getDefaultFieldClassificationAlgorithm(syncResultReceiver);
            return syncResultReceiver.getStringResult();
        } catch (SyncResultReceiver.TimeoutException e2) {
            throw new RuntimeException("Fail to get default field classification algorithm. " + ((Object) e2));
        } catch (RemoteException e10) {
            throw e10.rethrowFromSystemServer();
        }
    }

    public List<String> getAvailableFieldClassificationAlgorithms() {
        IResultReceiver syncResultReceiver = new SyncResultReceiver(5000);
        try {
            this.mService.getAvailableFieldClassificationAlgorithms(syncResultReceiver);
            String[] algorithms = syncResultReceiver.getStringArrayResult();
            return algorithms != null ? Arrays.asList(algorithms) : Collections.emptyList();
        } catch (SyncResultReceiver.TimeoutException e2) {
            throw new RuntimeException("Fail to get available field classification algorithms. " + ((Object) e2));
        } catch (RemoteException e10) {
            throw e10.rethrowFromSystemServer();
        }
    }

    public boolean isAutofillSupported() {
        if (this.mService == null) {
            return false;
        }
        IResultReceiver syncResultReceiver = new SyncResultReceiver(5000);
        try {
            this.mService.isServiceSupported(this.mContext.getUserId(), syncResultReceiver);
            return syncResultReceiver.getIntResult() == 1;
        } catch (SyncResultReceiver.TimeoutException e2) {
            throw new RuntimeException("Fail to get autofill supported status. " + ((Object) e2));
        } catch (RemoteException e10) {
            throw e10.rethrowFromSystemServer();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AutofillClient getClient() {
        AutofillClient client = this.mContext.getAutofillClient();
        if (client == null && Helper.sVerbose) {
            Log.v("AutofillManager", "No AutofillClient for " + this.mContext.getPackageName() + " on context " + ((Object) this.mContext));
        }
        return client;
    }

    public boolean isAutofillUiShowing() {
        AutofillClient client = this.mContext.getAutofillClient();
        return client != null && client.autofillClientIsFillUiShowing();
    }

    public void onAuthenticationResult(int authenticationId, Intent data, View focusView) {
        if (!hasAutofillFeature()) {
            return;
        }
        if (Helper.sDebug) {
            Log.d("AutofillManager", "onAuthenticationResult(): id= " + authenticationId + ", data=" + ((Object) data));
        }
        synchronized (this.mLock) {
            if (isActiveLocked()) {
                if (!this.mOnInvisibleCalled && focusView != null && focusView.canNotifyAutofillEnterExitEvent()) {
                    notifyViewExitedLocked(focusView);
                    notifyViewEnteredLocked(focusView, focusView.getAutofillId(), null, focusView.getAutofillValue(), 0);
                }
                if (data == null) {
                    return;
                }
                Parcelable result = data.getParcelableExtra(EXTRA_AUTHENTICATION_RESULT);
                Bundle responseData = new Bundle();
                responseData.putParcelable(EXTRA_AUTHENTICATION_RESULT, result);
                Bundle newClientState = data.getBundleExtra(EXTRA_CLIENT_STATE);
                if (newClientState != null) {
                    responseData.putBundle(EXTRA_CLIENT_STATE, newClientState);
                }
                if (data.hasExtra(EXTRA_AUTHENTICATION_RESULT_EPHEMERAL_DATASET)) {
                    responseData.putBoolean(EXTRA_AUTHENTICATION_RESULT_EPHEMERAL_DATASET, data.getBooleanExtra(EXTRA_AUTHENTICATION_RESULT_EPHEMERAL_DATASET, false));
                }
                try {
                    this.mService.setAuthenticationResult(responseData, this.mSessionId, authenticationId, this.mContext.getUserId());
                } catch (RemoteException e2) {
                    Log.e("AutofillManager", "Error delivering authentication result", e2);
                }
            }
        }
    }

    public AutofillId getNextAutofillId() {
        AutofillClient client = getClient();
        if (client == null) {
            return null;
        }
        AutofillId id2 = client.autofillClientGetNextAutofillId();
        if (id2 == null && Helper.sDebug) {
            Log.d("AutofillManager", "getNextAutofillId(): client " + ((Object) client) + " returned null");
        }
        return id2;
    }

    private static AutofillId getAutofillId(View parent, int virtualId) {
        return new AutofillId(parent.getAutofillViewId(), virtualId);
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01e3 A[Catch: TimeoutException -> 0x021e, RemoteException -> 0x0222, TryCatch #4 {TimeoutException -> 0x021e, RemoteException -> 0x0222, blocks: (B:54:0x019c, B:57:0x01b8, B:59:0x01e3, B:60:0x01e5, B:62:0x01f0, B:64:0x01f4, B:65:0x0215, B:66:0x021a), top: B:53:0x019c }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01f0 A[Catch: TimeoutException -> 0x021e, RemoteException -> 0x0222, TryCatch #4 {TimeoutException -> 0x021e, RemoteException -> 0x0222, blocks: (B:54:0x019c, B:57:0x01b8, B:59:0x01e3, B:60:0x01e5, B:62:0x01f0, B:64:0x01f4, B:65:0x0215, B:66:0x021a), top: B:53:0x019c }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void startSessionLocked(android.view.autofill.AutofillId r22, android.graphics.Rect r23, android.view.autofill.AutofillValue r24, int r25) {
        /*
            Method dump skipped, instructions count: 582
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.view.autofill.AutofillManager.startSessionLocked(android.view.autofill.AutofillId, android.graphics.Rect, android.view.autofill.AutofillValue, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishSessionLocked(int commitReason) {
        if (Helper.sVerbose) {
            Log.v("AutofillManager", "finishSessionLocked(): " + getStateAsStringLocked());
        }
        if (isActiveLocked()) {
            try {
                this.mService.finishSession(this.mSessionId, this.mContext.getUserId(), commitReason);
                resetSessionLocked(true);
            } catch (RemoteException e2) {
                throw e2.rethrowFromSystemServer();
            }
        }
    }

    private void cancelSessionLocked() {
        if (Helper.sVerbose) {
            Log.v("AutofillManager", "cancelSessionLocked(): " + getStateAsStringLocked());
        }
        if (isActiveLocked()) {
            try {
                this.mService.cancelSession(this.mSessionId, this.mContext.getUserId());
                resetSessionLocked(true);
            } catch (RemoteException e2) {
                throw e2.rethrowFromSystemServer();
            }
        }
    }

    private void resetSessionLocked(boolean resetEnteredIds) {
        this.mSessionId = Integer.MAX_VALUE;
        this.mState = 0;
        this.mTrackedViews = null;
        this.mFillableIds = null;
        this.mSaveTriggerId = null;
        this.mIdShownFillUi = null;
        this.mIsFillRequested.set(false);
        this.mShowAutofillDialogCalled = false;
        this.mFillDialogTriggerIds = null;
        this.mHasCredentialField = false;
        this.mAllTrackedViews.clear();
        if (resetEnteredIds) {
            this.mEnteredIds = null;
        }
    }

    private void updateSessionLocked(AutofillId id2, Rect bounds, AutofillValue value, int action, int flags) {
        if (Helper.sVerbose) {
            Log.v("AutofillManager", "updateSessionLocked(): id=" + ((Object) id2) + ", bounds=" + ((Object) bounds) + ", value=" + ((Object) value) + ", action=" + action + ", flags=" + flags);
        }
        try {
            this.mService.updateSession(this.mSessionId, id2, bounds, value, action, flags, this.mContext.getUserId());
        } catch (RemoteException e2) {
            throw e2.rethrowFromSystemServer();
        }
    }

    private boolean tryAddServiceClientIfNeededLocked() {
        AutofillClient client = getClient();
        if (client == null) {
            return false;
        }
        if (this.mService == null) {
            Log.w("AutofillManager", "Autofill service is null!");
            return false;
        }
        if (this.mServiceClient == null) {
            this.mServiceClient = new AutofillManagerClient();
            try {
                final int userId = this.mContext.getUserId();
                IResultReceiver syncResultReceiver = new SyncResultReceiver(5000);
                this.mService.addClient(this.mServiceClient, client.autofillClientGetComponentName(), userId, syncResultReceiver);
                try {
                    int flags = syncResultReceiver.getIntResult();
                    this.mEnabled = (flags & 1) != 0;
                    Helper.sDebug = (flags & 2) != 0;
                    Helper.sVerbose = (flags & 4) != 0;
                    this.mEnabledForAugmentedAutofillOnly = (flags & 8) != 0;
                    if (Helper.sVerbose) {
                        Log.v("AutofillManager", "receiver results: flags=" + flags + " enabled=" + this.mEnabled + ", enabledForAugmentedOnly: " + this.mEnabledForAugmentedAutofillOnly);
                    }
                    final IAutoFillManager service = this.mService;
                    final IAutoFillManagerClient serviceClient = this.mServiceClient;
                    this.mServiceClientCleaner = Cleaner.create(this, new Runnable() { // from class: android.view.autofill.AutofillManager$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            IAutoFillManager.this.removeClient(serviceClient, userId);
                        }
                    });
                } catch (SyncResultReceiver.TimeoutException e2) {
                    Log.w("AutofillManager", "Failed to initialize autofill: " + ((Object) e2));
                    this.mService.removeClient(this.mServiceClient, userId);
                    this.mServiceClient = null;
                    return false;
                }
            } catch (RemoteException e10) {
                throw e10.rethrowFromSystemServer();
            }
        }
        return true;
    }

    private boolean startAutofillIfNeededLocked(View view) {
        if (this.mState == 0 && this.mSessionId == Integer.MAX_VALUE && (view instanceof EditText) && !TextUtils.isEmpty(((EditText) view).getText()) && !view.isFocused() && view.isImportantForAutofill() && view.isLaidOut() && view.isVisibleToUser()) {
            boolean clientAdded = tryAddServiceClientIfNeededLocked();
            if (Helper.sVerbose) {
                Log.v("AutofillManager", "startAutofillIfNeededLocked(): enabled=" + this.mEnabled + " mServiceClient=" + ((Object) this.mServiceClient));
            }
            if (clientAdded && this.mEnabled && !isClientDisablingEnterExitEvent()) {
                AutofillId id2 = view.getAutofillId();
                AutofillValue value = view.getAutofillValue();
                startSessionLocked(id2, null, null, 0);
                updateSessionLocked(id2, null, value, 4, 0);
                addEnteredIdLocked(id2);
                return true;
            }
        }
        return false;
    }

    public void registerCallback(AutofillCallback callback) {
        if (!hasAutofillFeature()) {
            return;
        }
        synchronized (this.mLock) {
            if (callback == null) {
                return;
            }
            boolean hadCallback = this.mCallback != null;
            this.mCallback = callback;
            if (!hadCallback) {
                try {
                    this.mService.setHasCallback(this.mSessionId, this.mContext.getUserId(), true);
                } catch (RemoteException e2) {
                    throw e2.rethrowFromSystemServer();
                }
            }
        }
    }

    public void unregisterCallback(AutofillCallback callback) {
        if (!hasAutofillFeature()) {
            return;
        }
        synchronized (this.mLock) {
            if (callback != null) {
                AutofillCallback autofillCallback = this.mCallback;
                if (autofillCallback != null && callback == autofillCallback) {
                    this.mCallback = null;
                    try {
                        this.mService.setHasCallback(this.mSessionId, this.mContext.getUserId(), false);
                    } catch (RemoteException e2) {
                        throw e2.rethrowFromSystemServer();
                    }
                }
            }
        }
    }

    @SystemApi
    public void setAugmentedAutofillWhitelist(Set<String> packages, Set<ComponentName> activities) {
        if (!hasAutofillFeature()) {
            return;
        }
        IResultReceiver syncResultReceiver = new SyncResultReceiver(5000);
        try {
            this.mService.setAugmentedAutofillWhitelist(Helper.toList(packages), Helper.toList(activities), syncResultReceiver);
            int resultCode = syncResultReceiver.getIntResult();
            switch (resultCode) {
                case -1:
                    throw new SecurityException("caller is not user's Augmented Autofill Service");
                case 0:
                    return;
                default:
                    Log.wtf("AutofillManager", "setAugmentedAutofillWhitelist(): received invalid result: " + resultCode);
                    return;
            }
        } catch (RemoteException e2) {
            throw e2.rethrowFromSystemServer();
        } catch (SyncResultReceiver.TimeoutException e10) {
            Log.e("AutofillManager", "Fail to get the result of set AugmentedAutofill whitelist. " + ((Object) e10));
        }
    }

    public void notifyViewEnteredForAugmentedAutofill(View view) {
        AutofillId id2 = view.getAutofillId();
        synchronized (this.mLock) {
            if (this.mEnteredForAugmentedAutofillIds == null) {
                this.mEnteredForAugmentedAutofillIds = new ArraySet(1);
            }
            this.mEnteredForAugmentedAutofillIds.add(id2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestShowFillUi(int sessionId, AutofillId id2, int width, int height, Rect anchorBounds, IAutofillWindowPresenter presenter) {
        AutofillClient client;
        View anchor = findView(id2);
        if (anchor == null) {
            return;
        }
        AutofillCallback callback = null;
        synchronized (this.mLock) {
            try {
            } catch (Throwable th) {
                th = th;
            }
            try {
                if (this.mSessionId == sessionId && (client = getClient()) != null && client.autofillClientRequestShowFillUi(anchor, width, height, anchorBounds, presenter)) {
                    callback = this.mCallback;
                    this.mIdShownFillUi = id2;
                }
                if (callback != null) {
                    if (id2.isVirtualInt()) {
                        callback.onAutofillEvent(anchor, id2.getVirtualChildIntId(), 1);
                    } else {
                        callback.onAutofillEvent(anchor, 1);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void authenticate(int sessionId, int authenticationId, IntentSender intent, Intent fillInIntent, boolean authenticateInline) {
        AutofillClient client;
        synchronized (this.mLock) {
            if (sessionId == this.mSessionId && (client = getClient()) != null) {
                this.mOnInvisibleCalled = false;
                client.autofillClientAuthenticate(authenticationId, intent, fillInIntent, authenticateInline);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchUnhandledKey(int sessionId, AutofillId id2, KeyEvent keyEvent) {
        AutofillClient client;
        View anchor = findView(id2);
        if (anchor == null) {
            return;
        }
        synchronized (this.mLock) {
            if (this.mSessionId == sessionId && (client = getClient()) != null) {
                client.autofillClientDispatchUnhandledKey(anchor, keyEvent);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setState(int flags) {
        if (Helper.sVerbose) {
            Log.v("AutofillManager", "setState(" + flags + ": " + DebugUtils.flagsToString(AutofillManager.class, "SET_STATE_FLAG_", flags) + ")");
        }
        synchronized (this.mLock) {
            try {
                if ((flags & 32) != 0) {
                    this.mForAugmentedAutofillOnly = true;
                    return;
                }
                boolean z10 = (flags & 1) != 0;
                this.mEnabled = z10;
                if (!z10 || (flags & 2) != 0) {
                    resetSessionLocked(true);
                }
                if ((flags & 4) != 0) {
                    this.mServiceClient = null;
                    this.mAugmentedAutofillServiceClient = null;
                    Cleaner cleaner = this.mServiceClientCleaner;
                    if (cleaner != null) {
                        cleaner.clean();
                        this.mServiceClientCleaner = null;
                    }
                    notifyReenableAutofill();
                }
                Helper.sDebug = (flags & 8) != 0;
                Helper.sVerbose = (flags & 16) != 0;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void setAutofilledIfValuesIs(View view, AutofillValue targetValue, boolean hideHighlight) {
        AutofillValue currentValue = view.getAutofillValue();
        if (Objects.equals(currentValue, targetValue)) {
            synchronized (this.mLock) {
                if (this.mLastAutofilledData == null) {
                    this.mLastAutofilledData = new ParcelableMap(1);
                }
                this.mLastAutofilledData.put(view.getAutofillId(), targetValue);
            }
            view.setAutofilled(true, hideHighlight);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void autofill(int sessionId, List<AutofillId> ids, List<AutofillValue> values, boolean hideHighlight) {
        AutofillClient client;
        synchronized (this.mLock) {
            try {
                if (sessionId != this.mSessionId) {
                    return;
                }
                AutofillClient client2 = getClient();
                if (client2 == null) {
                    return;
                }
                int itemCount = ids.size();
                View[] views = client2.autofillClientFindViewsByAutofillIdTraversal(Helper.toArray(ids));
                int numApplied = 0;
                int numApplied2 = 0;
                ArrayList<AutofillId> failedIds = null;
                ArrayMap<View, SparseArray<AutofillValue>> virtualValues = null;
                while (numApplied2 < itemCount) {
                    try {
                        AutofillId id2 = ids.get(numApplied2);
                        try {
                            AutofillValue value = values.get(numApplied2);
                            View view = views[numApplied2];
                            if (view == null) {
                                client = client2;
                                Log.d("AutofillManager", "autofill(): no View with id " + ((Object) id2));
                                if (failedIds == null) {
                                    failedIds = new ArrayList<>();
                                }
                                failedIds.add(id2);
                            } else {
                                client = client2;
                                if (id2.isVirtualInt()) {
                                    if (virtualValues == null) {
                                        virtualValues = new ArrayMap<>(1);
                                    }
                                    SparseArray<AutofillValue> valuesByParent = virtualValues.get(view);
                                    if (valuesByParent == null) {
                                        valuesByParent = new SparseArray<>(5);
                                        virtualValues.put(view, valuesByParent);
                                    }
                                    valuesByParent.put(id2.getVirtualChildIntId(), value);
                                } else {
                                    if (this.mLastAutofilledData == null) {
                                        this.mLastAutofilledData = new ParcelableMap(itemCount - numApplied2);
                                    }
                                    this.mLastAutofilledData.put(id2, value);
                                    view.autofill(value);
                                    try {
                                        setAutofilledIfValuesIs(view, value, hideHighlight);
                                        numApplied++;
                                    } catch (Throwable th) {
                                        th = th;
                                        throw th;
                                    }
                                }
                            }
                            numApplied2++;
                            client2 = client;
                        } catch (Throwable th2) {
                            th = th2;
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        throw th;
                    }
                }
                if (failedIds != null) {
                    if (Helper.sVerbose) {
                        Log.v("AutofillManager", "autofill(): total failed views: " + ((Object) failedIds));
                    }
                    try {
                        this.mService.setAutofillFailure(this.mSessionId, failedIds, this.mContext.getUserId());
                    } catch (RemoteException e2) {
                        throw e2.rethrowFromSystemServer();
                    }
                }
                if (virtualValues != null) {
                    for (int i10 = 0; i10 < virtualValues.size(); i10++) {
                        View parent = virtualValues.keyAt(i10);
                        SparseArray<AutofillValue> childrenValues = virtualValues.valueAt(i10);
                        parent.autofill(childrenValues);
                        numApplied += childrenValues.size();
                    }
                }
                this.mMetricsLogger.write(newLog(913).addTaggedData(914, Integer.valueOf(itemCount)).addTaggedData(MetricsProto.MetricsEvent.FIELD_AUTOFILL_NUM_VIEWS_FILLED, Integer.valueOf(numApplied)));
            } catch (Throwable th4) {
                th = th4;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void autofillContent(int sessionId, AutofillId id2, ClipData clip) {
        synchronized (this.mLock) {
            if (sessionId != this.mSessionId) {
                return;
            }
            AutofillClient client = getClient();
            if (client == null) {
                return;
            }
            View view = client.autofillClientFindViewByAutofillIdTraversal(id2);
            if (view == null) {
                Log.d("AutofillManager", "autofillContent(): no view with id " + ((Object) id2));
                reportAutofillContentFailure(id2);
                return;
            }
            ContentInfo payload = new ContentInfo.Builder(clip, 4).build();
            ContentInfo result = view.performReceiveContent(payload);
            if (result != null) {
                Log.w("AutofillManager", "autofillContent(): receiver could not insert content: id=" + ((Object) id2) + ", view=" + ((Object) view) + ", clip=" + ((Object) clip));
                reportAutofillContentFailure(id2);
            } else {
                this.mMetricsLogger.write(newLog(913).addTaggedData(914, 1).addTaggedData(MetricsProto.MetricsEvent.FIELD_AUTOFILL_NUM_VIEWS_FILLED, 1));
            }
        }
    }

    private void reportAutofillContentFailure(AutofillId id2) {
        try {
            this.mService.setAutofillFailure(this.mSessionId, Collections.singletonList(id2), this.mContext.getUserId());
        } catch (RemoteException e2) {
            throw e2.rethrowFromSystemServer();
        }
    }

    private LogMaker newLog(int category) {
        LogMaker log = new LogMaker(category).addTaggedData(MetricsProto.MetricsEvent.FIELD_AUTOFILL_SESSION_ID, Integer.valueOf(this.mSessionId));
        if (isCompatibilityModeEnabledLocked()) {
            log.addTaggedData(1414, 1);
        }
        AutofillClient client = getClient();
        if (client == null) {
            log.setPackageName(this.mContext.getPackageName());
        } else {
            ComponentName sanitizedComponentName = new ComponentName(client.autofillClientGetComponentName().getPackageName(), "");
            log.setComponentName(sanitizedComponentName);
        }
        return log;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTrackedViews(int sessionId, AutofillId[] trackedIds, boolean saveOnAllViewsInvisible, boolean saveOnFinish, AutofillId[] fillableIds, AutofillId saveTriggerId) {
        if (saveTriggerId != null) {
            saveTriggerId.resetSessionId();
        }
        synchronized (this.mLock) {
            if (Helper.sVerbose) {
                Log.v("AutofillManager", "setTrackedViews(): sessionId=" + sessionId + ", trackedIds=" + Arrays.toString(trackedIds) + ", saveOnAllViewsInvisible=" + saveOnAllViewsInvisible + ", saveOnFinish=" + saveOnFinish + ", fillableIds=" + Arrays.toString(fillableIds) + ", saveTrigerId=" + ((Object) saveTriggerId) + ", mFillableIds=" + ((Object) this.mFillableIds) + ", mEnabled=" + this.mEnabled + ", mSessionId=" + this.mSessionId);
            }
            if (this.mEnabled && this.mSessionId == sessionId) {
                this.mSaveOnFinish = saveOnFinish;
                if (fillableIds != null) {
                    if (this.mFillableIds == null) {
                        this.mFillableIds = new ArraySet<>(fillableIds.length);
                    }
                    for (AutofillId id2 : fillableIds) {
                        if (id2 != null) {
                            id2.resetSessionId();
                            this.mFillableIds.add(id2);
                        }
                    }
                }
                AutofillId autofillId = this.mSaveTriggerId;
                if (autofillId != null && !autofillId.equals(saveTriggerId)) {
                    setNotifyOnClickLocked(this.mSaveTriggerId, false);
                }
                if (saveTriggerId != null && !saveTriggerId.equals(this.mSaveTriggerId)) {
                    this.mSaveTriggerId = saveTriggerId;
                    setNotifyOnClickLocked(saveTriggerId, true);
                }
                if (!saveOnAllViewsInvisible) {
                    trackedIds = null;
                }
                ArraySet<AutofillId> allFillableIds = new ArraySet<>();
                ArraySet<? extends AutofillId> arraySet = this.mFillableIds;
                if (arraySet != null) {
                    allFillableIds.addAll(arraySet);
                }
                if (trackedIds != null) {
                    for (AutofillId id3 : trackedIds) {
                        if (id3 != null) {
                            id3.resetSessionId();
                            allFillableIds.add(id3);
                        }
                    }
                }
                if (!allFillableIds.isEmpty()) {
                    this.mTrackedViews = new TrackedViews(trackedIds, Helper.toArray(allFillableIds));
                } else {
                    this.mTrackedViews = null;
                }
            }
        }
    }

    private void setNotifyOnClickLocked(AutofillId id2, boolean notify) {
        View view = findView(id2);
        if (view == null) {
            Log.w("AutofillManager", "setNotifyOnClick(): invalid id: " + ((Object) id2));
        } else {
            view.setNotifyAutofillManagerOnClick(notify);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSaveUiState(int sessionId, boolean shown) {
        if (Helper.sDebug) {
            Log.d("AutofillManager", "setSaveUiState(" + sessionId + "): " + shown);
        }
        synchronized (this.mLock) {
            if (this.mSessionId != Integer.MAX_VALUE) {
                Log.w("AutofillManager", "setSaveUiState(" + sessionId + ", " + shown + ") called on existing session " + this.mSessionId + "; cancelling it");
                cancelSessionLocked();
            }
            if (shown) {
                this.mSessionId = sessionId;
                this.mState = 3;
            } else {
                this.mSessionId = Integer.MAX_VALUE;
                this.mState = 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSessionFinished(int newState, List<AutofillId> autofillableIds) {
        if (autofillableIds != null) {
            for (int i10 = 0; i10 < autofillableIds.size(); i10++) {
                autofillableIds.get(i10).resetSessionId();
            }
        }
        synchronized (this.mLock) {
            if (Helper.sVerbose) {
                Log.v("AutofillManager", "setSessionFinished(): from " + getStateAsStringLocked() + " to " + getStateAsString(newState) + "; autofillableIds=" + ((Object) autofillableIds));
            }
            if (autofillableIds != null) {
                this.mEnteredIds = new ArraySet<>(autofillableIds);
            }
            if (newState != 5 && newState != 6) {
                resetSessionLocked(false);
                this.mState = newState;
            }
            resetSessionLocked(true);
            this.mState = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getAugmentedAutofillClient(IResultReceiver result) {
        synchronized (this.mLock) {
            if (this.mAugmentedAutofillServiceClient == null) {
                this.mAugmentedAutofillServiceClient = new AugmentedAutofillManagerClient();
            }
            Bundle resultData = new Bundle();
            resultData.putBinder(EXTRA_AUGMENTED_AUTOFILL_CLIENT, this.mAugmentedAutofillServiceClient.asBinder());
            try {
                result.send(0, resultData);
            } catch (RemoteException e2) {
                Log.w("AutofillManager", "Could not send AugmentedAutofillClient back: " + ((Object) e2));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestShowSoftInput(AutofillId id2) {
        if (Helper.sVerbose) {
            Log.v("AutofillManager", "requestShowSoftInput(" + ((Object) id2) + ")");
        }
        AutofillClient client = getClient();
        if (client == null) {
            return;
        }
        final View view = client.autofillClientFindViewByAutofillIdTraversal(id2);
        if (view == null) {
            if (Helper.sVerbose) {
                Log.v("AutofillManager", "View is not found");
                return;
            }
            return;
        }
        Handler handler = view.getHandler();
        if (handler == null) {
            if (Helper.sVerbose) {
                Log.v("AutofillManager", "Ignoring requestShowSoftInput due to no handler in view");
            }
        } else {
            if (handler.getLooper() != Looper.myLooper()) {
                if (Helper.sVerbose) {
                    Log.v("AutofillManager", "Scheduling showSoftInput() on the view UI thread");
                }
                handler.post(new Runnable() { // from class: android.view.autofill.AutofillManager$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        AutofillManager.requestShowSoftInputInViewThread(View.this);
                    }
                });
                return;
            }
            requestShowSoftInputInViewThread(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void requestShowSoftInputInViewThread(View view) {
        if (!view.isFocused()) {
            Log.w("AutofillManager", "Ignoring requestShowSoftInput() due to non-focused view");
            return;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService(InputMethodManager.class);
        boolean ret = inputMethodManager.showSoftInput(view, 0);
        if (Helper.sVerbose) {
            Log.v("AutofillManager", " InputMethodManager.showSoftInput returns " + ret);
        }
    }

    public void requestHideFillUi() {
        requestHideFillUi(this.mIdShownFillUi, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestHideFillUi(AutofillId id2, boolean force) {
        AutofillClient client;
        View anchor = id2 == null ? null : findView(id2);
        if (Helper.sVerbose) {
            Log.v("AutofillManager", "requestHideFillUi(" + ((Object) id2) + "): anchor = " + ((Object) anchor));
        }
        if (anchor == null) {
            if (force && (client = getClient()) != null) {
                client.autofillClientRequestHideFillUi();
                return;
            }
            return;
        }
        requestHideFillUi(id2, anchor);
    }

    private void requestHideFillUi(AutofillId id2, View anchor) {
        AutofillCallback callback = null;
        synchronized (this.mLock) {
            AutofillClient client = getClient();
            if (client != null && client.autofillClientRequestHideFillUi()) {
                this.mIdShownFillUi = null;
                callback = this.mCallback;
            }
        }
        if (callback != null) {
            if (id2.isVirtualInt()) {
                callback.onAutofillEvent(anchor, id2.getVirtualChildIntId(), 2);
            } else {
                callback.onAutofillEvent(anchor, 2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyDisableAutofill(long disableDuration, ComponentName componentName) {
        synchronized (this.mLock) {
            if (this.mOptions == null) {
                return;
            }
            long expiration = SystemClock.elapsedRealtime() + disableDuration;
            if (expiration < 0) {
                expiration = Long.MAX_VALUE;
            }
            if (componentName != null) {
                if (this.mOptions.disabledActivities == null) {
                    this.mOptions.disabledActivities = new ArrayMap();
                }
                this.mOptions.disabledActivities.put(componentName.flattenToString(), Long.valueOf(expiration));
            } else {
                this.mOptions.appDisabledExpiration = expiration;
            }
        }
    }

    void notifyReenableAutofill() {
        synchronized (this.mLock) {
            AutofillOptions autofillOptions = this.mOptions;
            if (autofillOptions == null) {
                return;
            }
            autofillOptions.appDisabledExpiration = 0L;
            this.mOptions.disabledActivities = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyNoFillUi(int sessionId, AutofillId id2, int sessionFinishedState) {
        if (Helper.sVerbose) {
            Log.v("AutofillManager", "notifyNoFillUi(): sessionFinishedState=" + sessionFinishedState);
        }
        View anchor = findView(id2);
        if (anchor == null) {
            return;
        }
        notifyCallback(sessionId, id2, 3);
        if (sessionFinishedState != 0) {
            setSessionFinished(sessionFinishedState, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyCallback(int sessionId, AutofillId id2, int event) {
        if (Helper.sVerbose) {
            Log.v("AutofillManager", "notifyCallback(): sessionId=" + sessionId + ", autofillId=" + ((Object) id2) + ", event=" + event);
        }
        View anchor = findView(id2);
        if (anchor == null) {
            return;
        }
        AutofillCallback callback = null;
        synchronized (this.mLock) {
            if (this.mSessionId == sessionId && getClient() != null) {
                callback = this.mCallback;
            }
        }
        if (callback != null) {
            if (id2.isVirtualInt()) {
                callback.onAutofillEvent(anchor, id2.getVirtualChildIntId(), event);
            } else {
                callback.onAutofillEvent(anchor, event);
            }
        }
    }

    private View findView(AutofillId autofillId) {
        AutofillClient client = getClient();
        if (client != null) {
            return client.autofillClientFindViewByAutofillIdTraversal(autofillId);
        }
        return null;
    }

    public boolean hasAutofillFeature() {
        return this.mService != null;
    }

    public void onPendingSaveUi(int operation, IBinder token) {
        if (Helper.sVerbose) {
            Log.v("AutofillManager", "onPendingSaveUi(" + operation + "): " + ((Object) token));
        }
        synchronized (this.mLock) {
            try {
                this.mService.onPendingSaveUi(operation, token);
            } catch (RemoteException e2) {
                Log.e("AutofillManager", "Error in onPendingSaveUi: ", e2);
            }
        }
    }

    public void dump(String outerPrefix, PrintWriter pw) {
        pw.print(outerPrefix);
        pw.println("AutofillManager:");
        String pfx = outerPrefix + "  ";
        pw.print(pfx);
        pw.print("sessionId: ");
        pw.println(this.mSessionId);
        pw.print(pfx);
        pw.print("state: ");
        pw.println(getStateAsStringLocked());
        pw.print(pfx);
        pw.print("context: ");
        pw.println(this.mContext);
        pw.print(pfx);
        pw.print("service client: ");
        pw.println(this.mServiceClient);
        AutofillClient client = getClient();
        if (client != null) {
            pw.print(pfx);
            pw.print("client: ");
            pw.print(client);
            pw.print(" (");
            pw.print(client.autofillClientGetActivityToken());
            pw.println(')');
        }
        pw.print(pfx);
        pw.print("enabled: ");
        pw.println(this.mEnabled);
        pw.print(pfx);
        pw.print("enabledAugmentedOnly: ");
        pw.println(this.mForAugmentedAutofillOnly);
        pw.print(pfx);
        pw.print("hasService: ");
        pw.println(this.mService != null);
        pw.print(pfx);
        pw.print("hasCallback: ");
        pw.println(this.mCallback != null);
        pw.print(pfx);
        pw.print("onInvisibleCalled ");
        pw.println(this.mOnInvisibleCalled);
        pw.print(pfx);
        pw.print("last autofilled data: ");
        pw.println(this.mLastAutofilledData);
        pw.print(pfx);
        pw.print("id of last fill UI shown: ");
        pw.println(this.mIdShownFillUi);
        pw.print(pfx);
        pw.print("tracked views: ");
        if (this.mTrackedViews == null) {
            pw.println("null");
        } else {
            String pfx2 = pfx + "  ";
            pw.println();
            pw.print(pfx2);
            pw.print("visible:");
            pw.println(this.mTrackedViews.mVisibleTrackedIds);
            pw.print(pfx2);
            pw.print("invisible:");
            pw.println(this.mTrackedViews.mInvisibleTrackedIds);
        }
        pw.print(pfx);
        pw.print("fillable ids: ");
        pw.println(this.mFillableIds);
        pw.print(pfx);
        pw.print("entered ids: ");
        pw.println(this.mEnteredIds);
        if (this.mEnteredForAugmentedAutofillIds != null) {
            pw.print(pfx);
            pw.print("entered ids for augmented autofill: ");
            pw.println(this.mEnteredForAugmentedAutofillIds);
        }
        if (this.mForAugmentedAutofillOnly) {
            pw.print(pfx);
            pw.println("For Augmented Autofill Only");
        }
        pw.print(pfx);
        pw.print("save trigger id: ");
        pw.println(this.mSaveTriggerId);
        pw.print(pfx);
        pw.print("save on finish(): ");
        pw.println(this.mSaveOnFinish);
        if (this.mOptions != null) {
            pw.print(pfx);
            pw.print("options: ");
            this.mOptions.dumpShort(pw);
            pw.println();
        }
        pw.print(pfx);
        pw.print("compat mode enabled: ");
        synchronized (this.mLock) {
            pw.print(pfx);
            pw.print("fill dialog enabled: ");
            pw.println(this.mIsFillDialogEnabled);
            pw.print(pfx);
            pw.print("fill dialog enabled hints: ");
            pw.println(Arrays.toString(this.mFillDialogEnabledHints));
            if (this.mCompatibilityBridge != null) {
                String pfx22 = pfx + "  ";
                pw.println("true");
                pw.print(pfx22);
                pw.print("windowId: ");
                pw.println(this.mCompatibilityBridge.mFocusedWindowId);
                pw.print(pfx22);
                pw.print("nodeId: ");
                pw.println(this.mCompatibilityBridge.mFocusedNodeId);
                pw.print(pfx22);
                pw.print("virtualId: ");
                pw.println(AccessibilityNodeInfo.getVirtualDescendantId(this.mCompatibilityBridge.mFocusedNodeId));
                pw.print(pfx22);
                pw.print("focusedBounds: ");
                pw.println(this.mCompatibilityBridge.mFocusedBounds);
            } else {
                pw.println("false");
            }
        }
        pw.print(pfx);
        pw.print("debug: ");
        pw.print(Helper.sDebug);
        pw.print(" verbose: ");
        pw.println(Helper.sVerbose);
    }

    private String getStateAsStringLocked() {
        return getStateAsString(this.mState);
    }

    private static String getStateAsString(int state) {
        switch (state) {
            case 0:
                return GrsBaseInfo.CountryCodeSource.UNKNOWN;
            case 1:
                return "ACTIVE";
            case 2:
                return "FINISHED";
            case 3:
                return "SHOWING_SAVE_UI";
            case 4:
                return "DISABLED_BY_SERVICE";
            case 5:
                return "UNKNOWN_COMPAT_MODE";
            case 6:
                return "UNKNOWN_FAILED";
            default:
                return "INVALID:" + state;
        }
    }

    public static String getSmartSuggestionModeToString(int flags) {
        switch (flags) {
            case 0:
                return "OFF";
            case 1:
                return "SYSTEM";
            default:
                return "INVALID:" + flags;
        }
    }

    private boolean isActiveLocked() {
        return this.mState == 1;
    }

    private boolean isDisabledByServiceLocked() {
        return this.mState == 4;
    }

    private boolean isFinishedLocked() {
        return this.mState == 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void post(Runnable runnable) {
        AutofillClient client = getClient();
        if (client == null) {
            if (Helper.sVerbose) {
                Log.v("AutofillManager", "ignoring post() because client is null");
                return;
            }
            return;
        }
        client.autofillClientRunOnUiThread(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFillDialogTriggerIds(List<AutofillId> ids) {
        this.mFillDialogTriggerIds = ids;
    }

    public boolean showAutofillDialog(View view) {
        Objects.requireNonNull(view);
        if (shouldShowAutofillDialog(view, view.getAutofillId())) {
            this.mShowAutofillDialogCalled = true;
            final WeakReference<View> wrView = new WeakReference<>(view);
            post(new Runnable() { // from class: android.view.autofill.AutofillManager$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    AutofillManager.this.lambda$showAutofillDialog$3(wrView);
                }
            });
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$showAutofillDialog$3(WeakReference wrView) {
        View v2 = (View) wrView.get();
        if (v2 != null) {
            notifyViewEntered(v2);
        }
    }

    public boolean showAutofillDialog(View view, final int virtualId) {
        Objects.requireNonNull(view);
        if (shouldShowAutofillDialog(view, getAutofillId(view, virtualId))) {
            this.mShowAutofillDialogCalled = true;
            final WeakReference<View> wrView = new WeakReference<>(view);
            post(new Runnable() { // from class: android.view.autofill.AutofillManager$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    AutofillManager.this.lambda$showAutofillDialog$4(wrView, virtualId);
                }
            });
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ void lambda$showAutofillDialog$4(WeakReference wrView, int virtualId) {
        View v2 = (View) wrView.get();
        if (v2 != null) {
            notifyViewEntered(v2, virtualId, null, 0);
        }
    }

    private boolean shouldShowAutofillDialog(View view, AutofillId id2) {
        if (!hasFillDialogUiFeature() || this.mShowAutofillDialogCalled || this.mFillDialogTriggerIds == null || this.mHasCredentialField || getImeStateFlag(view) == 128) {
            return false;
        }
        int size = this.mFillDialogTriggerIds.size();
        for (int i10 = 0; i10 < size; i10++) {
            AutofillId fillId = this.mFillDialogTriggerIds.get(i10);
            if (fillId.equalsIgnoreSession(id2)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public final class CompatibilityBridge implements AccessibilityManager.AccessibilityPolicy {
        AccessibilityServiceInfo mCompatServiceInfo;
        private final Rect mFocusedBounds = new Rect();
        private final Rect mTempBounds = new Rect();
        private int mFocusedWindowId = -1;
        private long mFocusedNodeId = AccessibilityNodeInfo.UNDEFINED_NODE_ID;

        CompatibilityBridge() {
            AccessibilityManager am = AccessibilityManager.getInstance(AutofillManager.this.mContext);
            am.setAccessibilityPolicy(this);
        }

        private AccessibilityServiceInfo getCompatServiceInfo() {
            synchronized (AutofillManager.this.mLock) {
                AccessibilityServiceInfo accessibilityServiceInfo = this.mCompatServiceInfo;
                if (accessibilityServiceInfo != null) {
                    return accessibilityServiceInfo;
                }
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("android", "com.android.server.autofill.AutofillCompatAccessibilityService"));
                ResolveInfo resolveInfo = AutofillManager.this.mContext.getPackageManager().resolveService(intent, 1048704);
                try {
                    AccessibilityServiceInfo accessibilityServiceInfo2 = new AccessibilityServiceInfo(resolveInfo, AutofillManager.this.mContext);
                    this.mCompatServiceInfo = accessibilityServiceInfo2;
                    return accessibilityServiceInfo2;
                } catch (IOException | XmlPullParserException e2) {
                    Log.e("AutofillManager", "Cannot find compat autofill service:" + ((Object) intent));
                    throw new IllegalStateException("Cannot find compat autofill service");
                }
            }
        }

        @Override // android.view.accessibility.AccessibilityManager.AccessibilityPolicy
        public boolean isEnabled(boolean accessibilityEnabled) {
            return true;
        }

        @Override // android.view.accessibility.AccessibilityManager.AccessibilityPolicy
        public int getRelevantEventTypes(int relevantEventTypes) {
            return relevantEventTypes | 8 | 16 | 1 | 2048;
        }

        @Override // android.view.accessibility.AccessibilityManager.AccessibilityPolicy
        public List<AccessibilityServiceInfo> getInstalledAccessibilityServiceList(List<AccessibilityServiceInfo> installedServices) {
            if (installedServices == null) {
                installedServices = new ArrayList();
            }
            installedServices.add(getCompatServiceInfo());
            return installedServices;
        }

        @Override // android.view.accessibility.AccessibilityManager.AccessibilityPolicy
        public List<AccessibilityServiceInfo> getEnabledAccessibilityServiceList(int feedbackTypeFlags, List<AccessibilityServiceInfo> enabledService) {
            if (enabledService == null) {
                enabledService = new ArrayList();
            }
            enabledService.add(getCompatServiceInfo());
            return enabledService;
        }

        @Override // android.view.accessibility.AccessibilityManager.AccessibilityPolicy
        public AccessibilityEvent onAccessibilityEvent(AccessibilityEvent event, boolean accessibilityEnabled, int relevantEventTypes) {
            int type = event.getEventType();
            if (Helper.sVerbose) {
                Log.v("AutofillManager", "onAccessibilityEvent(" + AccessibilityEvent.eventTypeToString(type) + "): virtualId=" + AccessibilityNodeInfo.getVirtualDescendantId(event.getSourceNodeId()) + ", client=" + ((Object) AutofillManager.this.getClient()));
            }
            switch (type) {
                case 1:
                    synchronized (AutofillManager.this.mLock) {
                        notifyViewClicked(event.getWindowId(), event.getSourceNodeId());
                    }
                    break;
                case 8:
                    synchronized (AutofillManager.this.mLock) {
                        if (this.mFocusedWindowId != event.getWindowId() || this.mFocusedNodeId != event.getSourceNodeId()) {
                            if (this.mFocusedWindowId != -1 && this.mFocusedNodeId != AccessibilityNodeInfo.UNDEFINED_NODE_ID) {
                                notifyViewExited(this.mFocusedWindowId, this.mFocusedNodeId);
                                this.mFocusedWindowId = -1;
                                this.mFocusedNodeId = AccessibilityNodeInfo.UNDEFINED_NODE_ID;
                                this.mFocusedBounds.set(0, 0, 0, 0);
                            }
                            int windowId = event.getWindowId();
                            long nodeId = event.getSourceNodeId();
                            if (notifyViewEntered(windowId, nodeId, this.mFocusedBounds)) {
                                this.mFocusedWindowId = windowId;
                                this.mFocusedNodeId = nodeId;
                            }
                            break;
                        } else {
                            return event;
                        }
                    }
                    break;
                case 16:
                    synchronized (AutofillManager.this.mLock) {
                        if (this.mFocusedWindowId == event.getWindowId() && this.mFocusedNodeId == event.getSourceNodeId()) {
                            notifyValueChanged(event.getWindowId(), event.getSourceNodeId());
                        }
                    }
                    break;
                case 2048:
                    AutofillClient client = AutofillManager.this.getClient();
                    if (client != null) {
                        synchronized (AutofillManager.this.mLock) {
                            if (client.autofillClientIsFillUiShowing()) {
                                notifyViewEntered(this.mFocusedWindowId, this.mFocusedNodeId, this.mFocusedBounds);
                            }
                            updateTrackedViewsLocked();
                        }
                        break;
                    }
                    break;
            }
            if (accessibilityEnabled) {
                return event;
            }
            return null;
        }

        private boolean notifyViewEntered(int windowId, long nodeId, Rect focusedBounds) {
            View view;
            AccessibilityNodeInfo node;
            int virtualId = AccessibilityNodeInfo.getVirtualDescendantId(nodeId);
            if (!isVirtualNode(virtualId) || (view = findViewByAccessibilityId(windowId, nodeId)) == null || (node = findVirtualNodeByAccessibilityId(view, virtualId)) == null || !node.isEditable()) {
                return false;
            }
            Rect newBounds = this.mTempBounds;
            node.getBoundsInScreen(newBounds);
            if (newBounds.equals(focusedBounds)) {
                return false;
            }
            focusedBounds.set(newBounds);
            AutofillManager.this.notifyViewEntered(view, virtualId, newBounds);
            return true;
        }

        private void notifyViewExited(int windowId, long nodeId) {
            View view;
            int virtualId = AccessibilityNodeInfo.getVirtualDescendantId(nodeId);
            if (!isVirtualNode(virtualId) || (view = findViewByAccessibilityId(windowId, nodeId)) == null) {
                return;
            }
            AutofillManager.this.notifyViewExited(view, virtualId);
        }

        private void notifyValueChanged(int windowId, long nodeId) {
            View view;
            AccessibilityNodeInfo node;
            int virtualId = AccessibilityNodeInfo.getVirtualDescendantId(nodeId);
            if (!isVirtualNode(virtualId) || (view = findViewByAccessibilityId(windowId, nodeId)) == null || (node = findVirtualNodeByAccessibilityId(view, virtualId)) == null) {
                return;
            }
            AutofillManager.this.notifyValueChanged(view, virtualId, AutofillValue.forText(node.getText()));
        }

        private void notifyViewClicked(int windowId, long nodeId) {
            View view;
            int virtualId = AccessibilityNodeInfo.getVirtualDescendantId(nodeId);
            if (!isVirtualNode(virtualId) || (view = findViewByAccessibilityId(windowId, nodeId)) == null) {
                return;
            }
            AccessibilityNodeInfo node = findVirtualNodeByAccessibilityId(view, virtualId);
            if (node == null) {
                return;
            }
            AutofillManager.this.notifyViewClicked(view, virtualId);
        }

        private void updateTrackedViewsLocked() {
            if (AutofillManager.this.mTrackedViews != null) {
                AutofillManager.this.mTrackedViews.onVisibleForAutofillChangedLocked();
            }
        }

        private View findViewByAccessibilityId(int windowId, long nodeId) {
            AutofillClient client = AutofillManager.this.getClient();
            if (client == null) {
                return null;
            }
            int viewId = AccessibilityNodeInfo.getAccessibilityViewId(nodeId);
            return client.autofillClientFindViewByAccessibilityIdTraversal(viewId, windowId);
        }

        private AccessibilityNodeInfo findVirtualNodeByAccessibilityId(View view, int virtualId) {
            AccessibilityNodeProvider provider = view.getAccessibilityNodeProvider();
            if (provider == null) {
                return null;
            }
            return provider.createAccessibilityNodeInfo(virtualId);
        }

        private boolean isVirtualNode(int nodeId) {
            return (nodeId == -1 || nodeId == Integer.MAX_VALUE) ? false : true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public class TrackedViews {
        boolean mHasNewTrackedView;
        private final ArraySet<AutofillId> mInvisibleDialogTrackedIds;
        private final ArraySet<AutofillId> mInvisibleTrackedIds;
        boolean mIsTrackedSaveView;
        private final ArraySet<AutofillId> mVisibleDialogTrackedIds;
        private final ArraySet<AutofillId> mVisibleTrackedIds;

        private <T> boolean isInSet(ArraySet<T> set, T value) {
            return set != null && set.contains(value);
        }

        private <T> ArraySet<T> addToSet(ArraySet<T> set, T valueToAdd) {
            if (set == null) {
                set = new ArraySet<>(1);
            }
            set.add(valueToAdd);
            return set;
        }

        private <T> ArraySet<T> removeFromSet(ArraySet<T> set, T valueToRemove) {
            if (set == null) {
                return null;
            }
            set.remove(valueToRemove);
            if (set.isEmpty()) {
                return null;
            }
            return set;
        }

        TrackedViews(AutofillId[] trackedIds, AutofillId[] allTrackedIds) {
            ArraySet<AutofillId> arraySet = new ArraySet<>();
            this.mVisibleTrackedIds = arraySet;
            ArraySet<AutofillId> arraySet2 = new ArraySet<>();
            this.mInvisibleTrackedIds = arraySet2;
            if (!ArrayUtils.isEmpty(trackedIds)) {
                this.mIsTrackedSaveView = true;
                initialTrackedViews(trackedIds, arraySet, arraySet2);
            }
            ArraySet<AutofillId> arraySet3 = new ArraySet<>();
            this.mVisibleDialogTrackedIds = arraySet3;
            ArraySet<AutofillId> arraySet4 = new ArraySet<>();
            this.mInvisibleDialogTrackedIds = arraySet4;
            if (!ArrayUtils.isEmpty(allTrackedIds)) {
                initialTrackedViews(allTrackedIds, arraySet3, arraySet4);
                AutofillManager.this.mAllTrackedViews.addAll(Arrays.asList(allTrackedIds));
            }
            if (Helper.sVerbose) {
                Log.v("AutofillManager", "TrackedViews(trackedIds=" + Arrays.toString(trackedIds) + "):  mVisibleTrackedIds=" + ((Object) arraySet) + " mInvisibleTrackedIds=" + ((Object) arraySet2) + " allTrackedIds=" + Arrays.toString(allTrackedIds) + " mVisibleDialogTrackedIds=" + ((Object) arraySet3) + " mInvisibleDialogTrackedIds=" + ((Object) arraySet4));
            }
            if (this.mIsTrackedSaveView && arraySet.isEmpty()) {
                AutofillManager.this.finishSessionLocked(4);
            }
        }

        private void initialTrackedViews(AutofillId[] trackedIds, ArraySet<AutofillId> visibleSet, ArraySet<AutofillId> invisibleSet) {
            boolean[] isVisible;
            AutofillClient client = AutofillManager.this.getClient();
            if (ArrayUtils.isEmpty(trackedIds) || client == null) {
                return;
            }
            if (client.autofillClientIsVisibleForAutofill()) {
                if (Helper.sVerbose) {
                    Log.v("AutofillManager", "client is visible, check tracked ids");
                }
                isVisible = client.autofillClientGetViewVisibility(trackedIds);
            } else {
                isVisible = new boolean[trackedIds.length];
            }
            int numIds = trackedIds.length;
            for (int i10 = 0; i10 < numIds; i10++) {
                AutofillId id2 = trackedIds[i10];
                id2.resetSessionId();
                if (isVisible[i10]) {
                    addToSet(visibleSet, id2);
                } else {
                    addToSet(invisibleSet, id2);
                }
            }
        }

        void notifyViewVisibilityChangedLocked(AutofillId id2, boolean isVisible) {
            if (Helper.sDebug) {
                Log.d("AutofillManager", "notifyViewVisibilityChangedLocked(): id=" + ((Object) id2) + " isVisible=" + isVisible);
            }
            if (AutofillManager.this.isClientVisibleForAutofillLocked()) {
                if (isVisible) {
                    if (isInSet(this.mInvisibleTrackedIds, id2)) {
                        removeFromSet(this.mInvisibleTrackedIds, id2);
                        addToSet(this.mVisibleTrackedIds, id2);
                    }
                    if (isInSet(this.mInvisibleDialogTrackedIds, id2)) {
                        removeFromSet(this.mInvisibleDialogTrackedIds, id2);
                        addToSet(this.mVisibleDialogTrackedIds, id2);
                    }
                } else {
                    if (isInSet(this.mVisibleTrackedIds, id2)) {
                        removeFromSet(this.mVisibleTrackedIds, id2);
                        addToSet(this.mInvisibleTrackedIds, id2);
                    }
                    if (isInSet(this.mVisibleDialogTrackedIds, id2)) {
                        removeFromSet(this.mVisibleDialogTrackedIds, id2);
                        addToSet(this.mInvisibleDialogTrackedIds, id2);
                    }
                }
            }
            if (this.mIsTrackedSaveView && this.mVisibleTrackedIds.isEmpty()) {
                if (Helper.sVerbose) {
                    Log.v("AutofillManager", "No more visible ids. Invisible = " + ((Object) this.mInvisibleTrackedIds));
                }
                AutofillManager.this.finishSessionLocked(4);
            }
            if (this.mVisibleDialogTrackedIds.isEmpty()) {
                if (Helper.sVerbose) {
                    Log.v("AutofillManager", "No more visible ids. Invisible = " + ((Object) this.mInvisibleDialogTrackedIds));
                }
                processNoVisibleTrackedAllViews();
            }
        }

        void onVisibleForAutofillChangedLocked() {
            AutofillClient client = AutofillManager.this.getClient();
            if (client != null) {
                if (Helper.sVerbose) {
                    Log.v("AutofillManager", "onVisibleForAutofillChangedLocked(): inv= " + ((Object) this.mInvisibleTrackedIds) + " vis=" + ((Object) this.mVisibleTrackedIds));
                }
                onVisibleForAutofillChangedInternalLocked(this.mVisibleTrackedIds, this.mInvisibleTrackedIds);
                onVisibleForAutofillChangedInternalLocked(this.mVisibleDialogTrackedIds, this.mInvisibleDialogTrackedIds);
            }
            if (this.mIsTrackedSaveView && this.mVisibleTrackedIds.isEmpty()) {
                if (Helper.sVerbose) {
                    Log.v("AutofillManager", "onVisibleForAutofillChangedLocked(): no more visible ids");
                }
                AutofillManager.this.finishSessionLocked(4);
            }
            if (this.mVisibleDialogTrackedIds.isEmpty()) {
                if (Helper.sVerbose) {
                    Log.v("AutofillManager", "onVisibleForAutofillChangedLocked(): no more visible ids");
                }
                processNoVisibleTrackedAllViews();
            }
        }

        void onVisibleForAutofillChangedInternalLocked(ArraySet<AutofillId> visibleSet, ArraySet<AutofillId> invisibleSet) {
            if (Helper.sVerbose) {
                Log.v("AutofillManager", "onVisibleForAutofillChangedLocked(): inv= " + ((Object) invisibleSet) + " vis=" + ((Object) visibleSet));
            }
            ArraySet<AutofillId> allTrackedIds = new ArraySet<>();
            allTrackedIds.addAll((ArraySet<? extends AutofillId>) visibleSet);
            allTrackedIds.addAll((ArraySet<? extends AutofillId>) invisibleSet);
            if (!allTrackedIds.isEmpty()) {
                visibleSet.clear();
                invisibleSet.clear();
                initialTrackedViews(Helper.toArray(allTrackedIds), visibleSet, invisibleSet);
            }
        }

        private void processNoVisibleTrackedAllViews() {
            AutofillManager.this.mShowAutofillDialogCalled = false;
        }

        void checkViewState(AutofillId id2) {
            if (this.mHasNewTrackedView) {
                return;
            }
            AutofillManager.this.mIsFillRequested.set(false);
            this.mHasNewTrackedView = true;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static abstract class AutofillCallback {
        public static final int EVENT_INPUT_HIDDEN = 2;
        public static final int EVENT_INPUT_SHOWN = 1;
        public static final int EVENT_INPUT_UNAVAILABLE = 3;

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
        public @interface AutofillEventType {
        }

        public void onAutofillEvent(View view, int event) {
        }

        public void onAutofillEvent(View view, int virtualId, int event) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static final class AutofillManagerClient extends IAutoFillManagerClient.Stub {
        private final WeakReference<AutofillManager> mAfm;

        private AutofillManagerClient(AutofillManager autofillManager) {
            this.mAfm = new WeakReference<>(autofillManager);
        }

        @Override // android.view.autofill.IAutoFillManagerClient
        public void setState(final int flags) {
            final AutofillManager afm = this.mAfm.get();
            if (afm != null) {
                afm.post(new Runnable() { // from class: android.view.autofill.AutofillManager$AutofillManagerClient$$ExternalSyntheticLambda13
                    @Override // java.lang.Runnable
                    public final void run() {
                        AutofillManager.this.setState(flags);
                    }
                });
            }
        }

        @Override // android.view.autofill.IAutoFillManagerClient
        public void autofill(final int sessionId, final List<AutofillId> ids, final List<AutofillValue> values, final boolean hideHighlight) {
            final AutofillManager afm = this.mAfm.get();
            if (afm != null) {
                afm.post(new Runnable() { // from class: android.view.autofill.AutofillManager$AutofillManagerClient$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        AutofillManager.this.autofill(sessionId, ids, values, hideHighlight);
                    }
                });
            }
        }

        @Override // android.view.autofill.IAutoFillManagerClient
        public void autofillContent(final int sessionId, final AutofillId id2, final ClipData content) {
            final AutofillManager afm = this.mAfm.get();
            if (afm != null) {
                afm.post(new Runnable() { // from class: android.view.autofill.AutofillManager$AutofillManagerClient$$ExternalSyntheticLambda8
                    @Override // java.lang.Runnable
                    public final void run() {
                        AutofillManager.this.autofillContent(sessionId, id2, content);
                    }
                });
            }
        }

        @Override // android.view.autofill.IAutoFillManagerClient
        public void authenticate(final int sessionId, final int authenticationId, final IntentSender intent, final Intent fillInIntent, final boolean authenticateInline) {
            final AutofillManager afm = this.mAfm.get();
            if (afm != null) {
                afm.post(new Runnable() { // from class: android.view.autofill.AutofillManager$AutofillManagerClient$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        AutofillManager.this.authenticate(sessionId, authenticationId, intent, fillInIntent, authenticateInline);
                    }
                });
            }
        }

        @Override // android.view.autofill.IAutoFillManagerClient
        public void requestShowFillUi(final int sessionId, final AutofillId id2, final int width, final int height, final Rect anchorBounds, final IAutofillWindowPresenter presenter) {
            final AutofillManager afm = this.mAfm.get();
            if (afm != null) {
                afm.post(new Runnable() { // from class: android.view.autofill.AutofillManager$AutofillManagerClient$$ExternalSyntheticLambda14
                    @Override // java.lang.Runnable
                    public final void run() {
                        AutofillManager.this.requestShowFillUi(sessionId, id2, width, height, anchorBounds, presenter);
                    }
                });
            }
        }

        @Override // android.view.autofill.IAutoFillManagerClient
        public void requestHideFillUi(int sessionId, final AutofillId id2) {
            final AutofillManager afm = this.mAfm.get();
            if (afm != null) {
                afm.post(new Runnable() { // from class: android.view.autofill.AutofillManager$AutofillManagerClient$$ExternalSyntheticLambda11
                    @Override // java.lang.Runnable
                    public final void run() {
                        AutofillManager.this.requestHideFillUi(id2, false);
                    }
                });
            }
        }

        @Override // android.view.autofill.IAutoFillManagerClient
        public void notifyNoFillUi(final int sessionId, final AutofillId id2, final int sessionFinishedState) {
            final AutofillManager afm = this.mAfm.get();
            if (afm != null) {
                afm.post(new Runnable() { // from class: android.view.autofill.AutofillManager$AutofillManagerClient$$ExternalSyntheticLambda12
                    @Override // java.lang.Runnable
                    public final void run() {
                        AutofillManager.this.notifyNoFillUi(sessionId, id2, sessionFinishedState);
                    }
                });
            }
        }

        @Override // android.view.autofill.IAutoFillManagerClient
        public void notifyFillUiShown(final int sessionId, final AutofillId id2) {
            final AutofillManager afm = this.mAfm.get();
            if (afm != null) {
                afm.post(new Runnable() { // from class: android.view.autofill.AutofillManager$AutofillManagerClient$$ExternalSyntheticLambda17
                    @Override // java.lang.Runnable
                    public final void run() {
                        AutofillManager.this.notifyCallback(sessionId, id2, 1);
                    }
                });
            }
        }

        @Override // android.view.autofill.IAutoFillManagerClient
        public void notifyFillUiHidden(final int sessionId, final AutofillId id2) {
            final AutofillManager afm = this.mAfm.get();
            if (afm != null) {
                afm.post(new Runnable() { // from class: android.view.autofill.AutofillManager$AutofillManagerClient$$ExternalSyntheticLambda15
                    @Override // java.lang.Runnable
                    public final void run() {
                        AutofillManager.this.notifyCallback(sessionId, id2, 2);
                    }
                });
            }
        }

        @Override // android.view.autofill.IAutoFillManagerClient
        public void notifyDisableAutofill(final long disableDuration, final ComponentName componentName) throws RemoteException {
            final AutofillManager afm = this.mAfm.get();
            if (afm != null) {
                afm.post(new Runnable() { // from class: android.view.autofill.AutofillManager$AutofillManagerClient$$ExternalSyntheticLambda9
                    @Override // java.lang.Runnable
                    public final void run() {
                        AutofillManager.this.notifyDisableAutofill(disableDuration, componentName);
                    }
                });
            }
        }

        @Override // android.view.autofill.IAutoFillManagerClient
        public void dispatchUnhandledKey(final int sessionId, final AutofillId id2, final KeyEvent fullScreen) {
            final AutofillManager afm = this.mAfm.get();
            if (afm != null) {
                afm.post(new Runnable() { // from class: android.view.autofill.AutofillManager$AutofillManagerClient$$ExternalSyntheticLambda6
                    @Override // java.lang.Runnable
                    public final void run() {
                        AutofillManager.this.dispatchUnhandledKey(sessionId, id2, fullScreen);
                    }
                });
            }
        }

        @Override // android.view.autofill.IAutoFillManagerClient
        public void startIntentSender(final IntentSender intentSender, final Intent intent) {
            final AutofillManager afm = this.mAfm.get();
            if (afm != null) {
                afm.post(new Runnable() { // from class: android.view.autofill.AutofillManager$AutofillManagerClient$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        AutofillManager.AutofillManagerClient.lambda$startIntentSender$11(AutofillManager.this, intentSender, intent);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ void lambda$startIntentSender$11(AutofillManager afm, IntentSender intentSender, Intent intent) {
            try {
                afm.mContext.startIntentSender(intentSender, intent, 0, 0, 0);
            } catch (IntentSender.SendIntentException e2) {
                Log.e("AutofillManager", "startIntentSender() failed for intent:" + ((Object) intentSender), e2);
            }
        }

        @Override // android.view.autofill.IAutoFillManagerClient
        public void setTrackedViews(final int sessionId, final AutofillId[] ids, final boolean saveOnAllViewsInvisible, final boolean saveOnFinish, final AutofillId[] fillableIds, final AutofillId saveTriggerId) {
            final AutofillManager afm = this.mAfm.get();
            if (afm != null) {
                afm.post(new Runnable() { // from class: android.view.autofill.AutofillManager$AutofillManagerClient$$ExternalSyntheticLambda5
                    @Override // java.lang.Runnable
                    public final void run() {
                        AutofillManager.this.setTrackedViews(sessionId, ids, saveOnAllViewsInvisible, saveOnFinish, fillableIds, saveTriggerId);
                    }
                });
            }
        }

        @Override // android.view.autofill.IAutoFillManagerClient
        public void setSaveUiState(final int sessionId, final boolean shown) {
            final AutofillManager afm = this.mAfm.get();
            if (afm != null) {
                afm.post(new Runnable() { // from class: android.view.autofill.AutofillManager$AutofillManagerClient$$ExternalSyntheticLambda16
                    @Override // java.lang.Runnable
                    public final void run() {
                        AutofillManager.this.setSaveUiState(sessionId, shown);
                    }
                });
            }
        }

        @Override // android.view.autofill.IAutoFillManagerClient
        public void setSessionFinished(final int newState, final List<AutofillId> autofillableIds) {
            final AutofillManager afm = this.mAfm.get();
            if (afm != null) {
                afm.post(new Runnable() { // from class: android.view.autofill.AutofillManager$AutofillManagerClient$$ExternalSyntheticLambda7
                    @Override // java.lang.Runnable
                    public final void run() {
                        AutofillManager.this.setSessionFinished(newState, autofillableIds);
                    }
                });
            }
        }

        @Override // android.view.autofill.IAutoFillManagerClient
        public void getAugmentedAutofillClient(final IResultReceiver result) {
            final AutofillManager afm = this.mAfm.get();
            if (afm != null) {
                afm.post(new Runnable() { // from class: android.view.autofill.AutofillManager$AutofillManagerClient$$ExternalSyntheticLambda10
                    @Override // java.lang.Runnable
                    public final void run() {
                        AutofillManager.this.getAugmentedAutofillClient(result);
                    }
                });
            }
        }

        @Override // android.view.autofill.IAutoFillManagerClient
        public void requestShowSoftInput(final AutofillId id2) {
            final AutofillManager afm = this.mAfm.get();
            if (afm != null) {
                afm.post(new Runnable() { // from class: android.view.autofill.AutofillManager$AutofillManagerClient$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        AutofillManager.this.requestShowSoftInput(id2);
                    }
                });
            }
        }

        @Override // android.view.autofill.IAutoFillManagerClient
        public void notifyFillDialogTriggerIds(final List<AutofillId> ids) {
            final AutofillManager afm = this.mAfm.get();
            if (afm != null) {
                afm.post(new Runnable() { // from class: android.view.autofill.AutofillManager$AutofillManagerClient$$ExternalSyntheticLambda4
                    @Override // java.lang.Runnable
                    public final void run() {
                        AutofillManager.this.setFillDialogTriggerIds(ids);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static final class AugmentedAutofillManagerClient extends IAugmentedAutofillManagerClient.Stub {
        private final WeakReference<AutofillManager> mAfm;

        private AugmentedAutofillManagerClient(AutofillManager autofillManager) {
            this.mAfm = new WeakReference<>(autofillManager);
        }

        @Override // android.view.autofill.IAugmentedAutofillManagerClient
        public AssistStructure.ViewNodeParcelable getViewNodeParcelable(AutofillId id2) {
            AutofillManager afm = this.mAfm.get();
            if (afm == null) {
                return null;
            }
            View view = getView(afm, id2);
            if (view == null) {
                Log.w("AutofillManager", "getViewNodeParcelable(" + ((Object) id2) + "): could not find view");
                return null;
            }
            ViewRootImpl root = view.getViewRootImpl();
            if (root != null && (root.getWindowFlags() & 8192) == 0) {
                AssistStructure.ViewNodeBuilder viewStructure = new AssistStructure.ViewNodeBuilder();
                viewStructure.setAutofillId(view.getAutofillId());
                view.onProvideAutofillStructure(viewStructure, 0);
                AssistStructure.ViewNode viewNode = viewStructure.getViewNode();
                if (viewNode != null && id2.equals(viewNode.getAutofillId())) {
                    return new AssistStructure.ViewNodeParcelable(viewNode);
                }
            }
            return null;
        }

        @Override // android.view.autofill.IAugmentedAutofillManagerClient
        public Rect getViewCoordinates(AutofillId id2) {
            View view;
            AutofillManager afm = this.mAfm.get();
            if (afm == null || (view = getView(afm, id2)) == null) {
                return null;
            }
            Rect windowVisibleDisplayFrame = new Rect();
            view.getWindowVisibleDisplayFrame(windowVisibleDisplayFrame);
            int[] location = new int[2];
            view.getLocationOnScreen(location);
            Rect rect = new Rect(location[0], location[1] - windowVisibleDisplayFrame.top, location[0] + view.getWidth(), (location[1] - windowVisibleDisplayFrame.top) + view.getHeight());
            if (Helper.sVerbose) {
                Log.v("AutofillManager", "Coordinates for " + ((Object) id2) + ": " + ((Object) rect));
            }
            return rect;
        }

        @Override // android.view.autofill.IAugmentedAutofillManagerClient
        public void autofill(final int sessionId, final List<AutofillId> ids, final List<AutofillValue> values, final boolean hideHighlight) {
            final AutofillManager afm = this.mAfm.get();
            if (afm != null) {
                afm.post(new Runnable() { // from class: android.view.autofill.AutofillManager$AugmentedAutofillManagerClient$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        AutofillManager.this.autofill(sessionId, ids, values, hideHighlight);
                    }
                });
            }
        }

        @Override // android.view.autofill.IAugmentedAutofillManagerClient
        public void requestShowFillUi(final int sessionId, final AutofillId id2, final int width, final int height, final Rect anchorBounds, final IAutofillWindowPresenter presenter) {
            final AutofillManager afm = this.mAfm.get();
            if (afm != null) {
                afm.post(new Runnable() { // from class: android.view.autofill.AutofillManager$AugmentedAutofillManagerClient$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        AutofillManager.this.requestShowFillUi(sessionId, id2, width, height, anchorBounds, presenter);
                    }
                });
            }
        }

        @Override // android.view.autofill.IAugmentedAutofillManagerClient
        public void requestHideFillUi(int sessionId, final AutofillId id2) {
            final AutofillManager afm = this.mAfm.get();
            if (afm != null) {
                afm.post(new Runnable() { // from class: android.view.autofill.AutofillManager$AugmentedAutofillManagerClient$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        AutofillManager.this.requestHideFillUi(id2, false);
                    }
                });
            }
        }

        @Override // android.view.autofill.IAugmentedAutofillManagerClient
        public boolean requestAutofill(int sessionId, AutofillId id2) {
            final AutofillManager afm = this.mAfm.get();
            if (afm == null || afm.mSessionId != sessionId) {
                if (Helper.sDebug) {
                    Slog.d("AutofillManager", "Autofill not available or sessionId doesn't match");
                }
                return false;
            }
            final View view = getView(afm, id2);
            if (view == null || !view.isFocused()) {
                if (Helper.sDebug) {
                    Slog.d("AutofillManager", "View not available or is not on focus");
                }
                return false;
            }
            if (Helper.sVerbose) {
                Log.v("AutofillManager", "requestAutofill() by AugmentedAutofillService.");
            }
            afm.post(new Runnable() { // from class: android.view.autofill.AutofillManager$AugmentedAutofillManagerClient$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    AutofillManager.this.requestAutofillFromNewSession(view);
                }
            });
            return true;
        }

        private View getView(AutofillManager afm, AutofillId id2) {
            AutofillClient client = afm.getClient();
            if (client == null) {
                Log.w("AutofillManager", "getView(" + ((Object) id2) + "): no autofill client");
                return null;
            }
            View view = client.autofillClientFindViewByAutofillIdTraversal(id2);
            if (view == null) {
                Log.w("AutofillManager", "getView(" + ((Object) id2) + "): could not find view");
            }
            return view;
        }
    }
}
