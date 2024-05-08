package com.android.internal.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityOptions;
import android.app.prediction.AppPredictionContext;
import android.app.prediction.AppPredictionManager;
import android.app.prediction.AppPredictor;
import android.app.prediction.AppTarget;
import android.app.prediction.AppTargetEvent;
import android.app.prediction.AppTargetId;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Insets;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.metrics.LogMaker;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.os.UserHandle;
import android.os.UserManager;
import android.os.storage.StorageManager;
import android.provider.DeviceConfig;
import android.provider.Settings;
import android.service.chooser.ChooserTarget;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.HashedStringCache;
import android.util.Log;
import android.util.PluralsMessageFormatter;
import android.util.Size;
import android.util.Slog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.textclassifier.TextClassifier;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Space;
import android.widget.TextView;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.content.pm.ShortcutManagerCompat;
import com.android.internal.R;
import com.android.internal.app.AbstractMultiProfilePagerAdapter;
import com.android.internal.app.AbstractResolverComparator;
import com.android.internal.app.ChooserActivity;
import com.android.internal.app.ChooserListAdapter;
import com.android.internal.app.NoCrossProfileEmptyStateProvider;
import com.android.internal.app.ResolverListAdapter;
import com.android.internal.app.chooser.ChooserTargetInfo;
import com.android.internal.app.chooser.DisplayResolveInfo;
import com.android.internal.app.chooser.MultiDisplayResolveInfo;
import com.android.internal.app.chooser.NotSelectableTargetInfo;
import com.android.internal.app.chooser.SelectableTargetInfo;
import com.android.internal.app.chooser.TargetInfo;
import com.android.internal.config.sysui.SystemUiDeviceConfigFlags;
import com.android.internal.content.PackageMonitor;
import com.android.internal.logging.MetricsLogger;
import com.android.internal.logging.nano.MetricsProto;
import com.android.internal.widget.RecyclerView;
import com.android.internal.widget.ViewPager;
import com.google.android.collect.Lists;
import com.google.android.material.badge.BadgeDrawable;
import java.io.File;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class ChooserActivity extends ResolverActivity implements ChooserListAdapter.ChooserListCommunicator, SelectableTargetInfo.SelectableTargetInfoCommunicator {
    public static final String APP_PREDICTION_INTENT_FILTER_KEY = "intent_filter";
    private static final int APP_PREDICTION_SHARE_TARGET_QUERY_PACKAGE_LIMIT = 20;
    private static final String APP_PREDICTION_SHARE_UI_SURFACE = "share";
    private static final String CHIP_ICON_METADATA_KEY = "android.service.chooser.chip_icon";
    private static final String CHIP_LABEL_METADATA_KEY = "android.service.chooser.chip_label";
    public static final String CHOOSER_TARGET = "chooser_target";
    protected static final int CONTENT_PREVIEW_FILE = 2;
    protected static final int CONTENT_PREVIEW_IMAGE = 1;
    protected static final int CONTENT_PREVIEW_TEXT = 3;
    private static final boolean DEBUG = true;
    private static final boolean DEFAULT_IS_NEARBY_SHARE_FIRST_TARGET_IN_RANKED_APP = false;
    private static final int DEFAULT_LIST_VIEW_UPDATE_DELAY_MS = 0;
    private static final int DEFAULT_SALT_EXPIRATION_DAYS = 7;
    private static final float DIRECT_SHARE_EXPANSION_RATE = 0.78f;
    public static final String EXTRA_PRIVATE_RETAIN_IN_ON_STOP = "com.android.internal.app.ChooserActivity.EXTRA_PRIVATE_RETAIN_IN_ON_STOP";
    public static final String FIRST_IMAGE_PREVIEW_TRANSITION_NAME = "screenshot_preview_image";
    private static final String IMAGE_EDITOR_SHARED_ELEMENT = "screenshot_preview_image";
    public static final String LAUNCH_LOCATION_DIRECT_SHARE = "direct_share";
    private static final int MAX_EXTRA_CHOOSER_TARGETS = 2;
    private static final int MAX_EXTRA_INITIAL_INTENTS = 2;
    private static final int MAX_LOG_RANK_POSITION = 12;
    private static final int NO_DIRECT_SHARE_ANIM_IN_MILLIS = 200;
    private static final String PINNED_SHARED_PREFS_NAME = "chooser_pin_settings";
    private static final String PLURALS_COUNT = "count";
    private static final String PLURALS_FILE_NAME = "file_name";
    private static final String PREF_NUM_SHEET_EXPANSIONS = "pref_num_sheet_expansions";
    private static final int SCROLL_STATUS_IDLE = 0;
    private static final int SCROLL_STATUS_SCROLLING_HORIZONTAL = 2;
    private static final int SCROLL_STATUS_SCROLLING_VERTICAL = 1;
    public static final int SELECTION_TYPE_APP = 2;
    public static final int SELECTION_TYPE_COPY = 4;
    public static final int SELECTION_TYPE_EDIT = 6;
    public static final int SELECTION_TYPE_NEARBY = 5;
    public static final int SELECTION_TYPE_SERVICE = 1;
    public static final int SELECTION_TYPE_STANDARD = 3;
    private static final String SHARED_TEXT_KEY = "shared_text";
    private static final String SHORTCUT_TARGET = "shortcut_target";
    private static final String TAG = "ChooserActivity";
    private static final String TARGET_DETAILS_FRAGMENT_TAG = "targetDetailsFragment";
    public static final int TARGET_TYPE_CHOOSER_TARGET = 1;
    public static final int TARGET_TYPE_DEFAULT = 0;
    public static final int TARGET_TYPE_SHORTCUTS_FROM_PREDICTION_SERVICE = 3;
    public static final int TARGET_TYPE_SHORTCUTS_FROM_SHORTCUT_MANAGER = 2;
    private static final int URI_PERMISSION_INTENT_FLAGS = 195;
    private static final boolean USE_PREDICTION_MANAGER_FOR_SHARE_ACTIVITIES = true;
    private ChooserTarget[] mCallerChooserTargets;
    protected ChooserActivityLogger mChooserActivityLogger;
    protected ChooserMultiProfilePagerAdapter mChooserMultiProfilePagerAdapter;
    private long mChooserShownTime;
    private IntentSender mChosenComponentSender;
    private Map<ChooserTarget, AppTarget> mDirectShareAppTargetCache;
    private Map<ChooserTarget, ShortcutInfo> mDirectShareShortcutInfoCache;
    private ComponentName[] mFilteredComponentNames;
    private boolean mIsAppPredictorComponentAvailable;
    protected boolean mIsSuccessfullySelected;
    protected MetricsLogger mMetricsLogger;
    private AppPredictor mPersonalAppPredictor;
    private SharedPreferences mPinnedSharedPrefs;
    private ContentPreviewCoordinator mPreviewCoord;
    private long mQueriedSharingShortcutsTimeMs;
    private Intent mReferrerFillInIntent;
    private IntentSender mRefinementIntentSender;
    private RefinementResultReceiver mRefinementResultReceiver;
    private Bundle mReplacementExtras;
    private boolean mShouldDisplayLandscape;
    private AppPredictor mWorkAppPredictor;
    private int mMaxHashSaltDays = DeviceConfig.getInt("systemui", SystemUiDeviceConfigFlags.HASH_SALT_MAX_DAYS, 7);
    private boolean mIsNearbyShareFirstTargetInRankedApp = DeviceConfig.getBoolean("systemui", SystemUiDeviceConfigFlags.IS_NEARBY_SHARE_FIRST_TARGET_IN_RANKED_APP, false);
    int mListViewUpdateDelayMs = DeviceConfig.getInt("systemui", SystemUiDeviceConfigFlags.SHARESHEET_LIST_VIEW_UPDATE_DELAY, 0);
    private int mCurrAvailableWidth = 0;
    private Insets mLastAppliedInsets = null;
    private int mLastNumberOfChildren = -1;
    private int mMaxTargetsPerRow = 1;
    private int mScrollStatus = 0;
    private final EnterTransitionAnimationDelegate mEnterTransitionAnimationDelegate = new EnterTransitionAnimationDelegate();
    private boolean mRemoveSharedElements = false;
    private View mContentView = null;
    private final ChooserHandler mChooserHandler = new ChooserHandler();
    private IChooserActivityWrapper mChooserWrapper = new ChooserActivityWrapper();

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    private @interface ContentPreviewType {
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public @interface ShareTargetType {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public class ContentPreviewCoordinator {
        private static final int IMAGE_FADE_IN_MILLIS = 150;
        private static final int IMAGE_LOAD_INTO_VIEW = 2;
        private static final int IMAGE_LOAD_TIMEOUT = 1;
        private boolean mAtLeastOneLoaded = false;
        private final Handler mHandler = new Handler() { // from class: com.android.internal.app.ChooserActivity.ContentPreviewCoordinator.1
            @Override // android.os.Handler
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case 1:
                        ContentPreviewCoordinator.this.maybeHideContentPreview();
                        return;
                    case 2:
                        if (!ChooserActivity.this.isFinishing()) {
                            LoadUriTask task = (LoadUriTask) msg.obj;
                            RoundedRectImageView imageView = (RoundedRectImageView) ContentPreviewCoordinator.this.mParentView.findViewById(task.mImageResourceId);
                            if (task.mBmp == null) {
                                imageView.setVisibility(8);
                                ContentPreviewCoordinator.this.maybeHideContentPreview();
                                return;
                            }
                            ContentPreviewCoordinator.this.mAtLeastOneLoaded = true;
                            imageView.setVisibility(0);
                            imageView.setAlpha(0.0f);
                            imageView.setImageBitmap(task.mBmp);
                            ValueAnimator fadeAnim = ObjectAnimator.ofFloat(imageView, Key.ALPHA, 0.0f, 1.0f);
                            fadeAnim.setInterpolator(new DecelerateInterpolator(1.0f));
                            fadeAnim.setDuration(150L);
                            fadeAnim.start();
                            if (task.mExtraCount > 0) {
                                imageView.setExtraImageCount(task.mExtraCount);
                            }
                            ContentPreviewCoordinator.this.setupPreDrawForSharedElementTransition(imageView);
                            imageView.setRadius(ChooserActivity.this.getResolverWrapper().getResolverActivityExt().getCornerRadius(ChooserActivity.this.getApplicationContext()));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        private boolean mHideParentOnFail;
        private final int mImageLoadTimeoutMillis;
        private final View mParentView;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
        public class LoadUriTask {
            public final Bitmap mBmp;
            public final int mExtraCount;
            public final int mImageResourceId;
            public final Uri mUri;

            LoadUriTask(int imageResourceId, Uri uri, int extraCount, Bitmap bmp) {
                this.mImageResourceId = imageResourceId;
                this.mUri = uri;
                this.mExtraCount = extraCount;
                this.mBmp = bmp;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setupPreDrawForSharedElementTransition(final View v2) {
            v2.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: com.android.internal.app.ChooserActivity.ContentPreviewCoordinator.2
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    v2.getViewTreeObserver().removeOnPreDrawListener(this);
                    if (!ChooserActivity.this.mRemoveSharedElements && ChooserActivity.this.isActivityTransitionRunning()) {
                        ChooserActivity.this.getWindow().setWindowAnimations(0);
                    }
                    ChooserActivity.this.mEnterTransitionAnimationDelegate.markImagePreviewReady();
                    return true;
                }
            });
        }

        ContentPreviewCoordinator(View parentView, boolean hideParentOnFail) {
            this.mImageLoadTimeoutMillis = ChooserActivity.this.getResources().getInteger(17694720);
            this.mParentView = parentView;
            this.mHideParentOnFail = hideParentOnFail;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void loadUriIntoView(final int imageResourceId, final Uri uri, final int extraImages) {
            this.mHandler.sendEmptyMessageDelayed(1, this.mImageLoadTimeoutMillis);
            AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() { // from class: com.android.internal.app.ChooserActivity$ContentPreviewCoordinator$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    ChooserActivity.ContentPreviewCoordinator.this.lambda$loadUriIntoView$0(uri, imageResourceId, extraImages);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$loadUriIntoView$0(Uri uri, int imageResourceId, int extraImages) {
            int size = ChooserActivity.this.getResources().getDimensionPixelSize(17105060);
            Bitmap bmp = ChooserActivity.this.loadThumbnail(uri, new Size(size, size));
            Message msg = Message.obtain();
            msg.what = 2;
            msg.obj = new LoadUriTask(imageResourceId, uri, extraImages, bmp);
            this.mHandler.sendMessage(msg);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cancelLoads() {
            this.mHandler.removeMessages(2);
            this.mHandler.removeMessages(1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void maybeHideContentPreview() {
            if (!this.mAtLeastOneLoaded) {
                if (this.mHideParentOnFail) {
                    Log.i(ChooserActivity.TAG, "Hiding image preview area. Timed out waiting for preview to load within " + this.mImageLoadTimeoutMillis + "ms.");
                    collapseParentView();
                    ChooserActivity.this.getResolverWrapper().getResolverActivityExt().hookmaybeHideContentPreview();
                    if (ChooserActivity.this.shouldShowTabs()) {
                        ChooserActivity.this.hideStickyContentPreview();
                    } else if (ChooserActivity.this.mChooserMultiProfilePagerAdapter.getCurrentRootAdapter() != null) {
                        ChooserActivity.this.mChooserMultiProfilePagerAdapter.getCurrentRootAdapter().hideContentPreview();
                    }
                    this.mHideParentOnFail = false;
                }
                ChooserActivity.this.mRemoveSharedElements = true;
                ChooserActivity.this.mEnterTransitionAnimationDelegate.markImagePreviewReady();
            }
        }

        private void collapseParentView() {
            View v2 = this.mParentView;
            int widthSpec = View.MeasureSpec.makeMeasureSpec(v2.getWidth(), 1073741824);
            int heightSpec = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
            v2.measure(widthSpec, heightSpec);
            v2.getLayoutParams().height = 0;
            v2.layout(v2.getLeft(), v2.getTop(), v2.getRight(), v2.getTop());
            v2.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public class ChooserHandler extends Handler {
        private static final int LIST_VIEW_UPDATE_MESSAGE = 6;
        private static final int SHORTCUT_MANAGER_ALL_SHARE_TARGET_RESULTS = 7;

        private ChooserHandler() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeAllMessages() {
            removeMessages(6);
            removeMessages(7);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            ChooserListAdapter adapterForUserHandle;
            if (ChooserActivity.this.mChooserMultiProfilePagerAdapter.getActiveListAdapter() == null || ChooserActivity.this.isDestroyed()) {
                return;
            }
            switch (msg.what) {
                case 6:
                    Log.d(ChooserActivity.TAG, "LIST_VIEW_UPDATE_MESSAGE; ");
                    UserHandle userHandle = (UserHandle) msg.obj;
                    ChooserActivity.this.mChooserMultiProfilePagerAdapter.getListAdapterForUserHandle(userHandle).refreshListView();
                    return;
                case 7:
                    Log.d(ChooserActivity.TAG, "SHORTCUT_MANAGER_ALL_SHARE_TARGET_RESULTS");
                    ServiceResultInfo[] resultInfos = (ServiceResultInfo[]) msg.obj;
                    for (ServiceResultInfo resultInfo : resultInfos) {
                        if (resultInfo.resultTargets != null && (adapterForUserHandle = ChooserActivity.this.mChooserMultiProfilePagerAdapter.getListAdapterForUserHandle(resultInfo.userHandle)) != null) {
                            adapterForUserHandle.addServiceResults(resultInfo.originalTarget, resultInfo.resultTargets, msg.arg1, ChooserActivity.this.mDirectShareShortcutInfoCache);
                        }
                    }
                    ChooserActivity.this.logDirectShareTargetReceived(MetricsProto.MetricsEvent.ACTION_DIRECT_SHARE_TARGETS_LOADED_SHORTCUT_MANAGER);
                    ChooserActivity.this.sendVoiceChoicesIfNeeded();
                    ChooserActivity.this.getChooserActivityLogger().logSharesheetDirectLoadComplete();
                    ChooserActivity.this.mChooserMultiProfilePagerAdapter.getActiveListAdapter().completeServiceTargetLoading();
                    return;
                default:
                    super.handleMessage(msg);
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:101:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x02e2  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0333  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x033b  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x033e  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0336  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0309  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x029f  */
    @Override // com.android.internal.app.ResolverActivity, android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCreate(android.os.Bundle r36) {
        /*
            Method dump skipped, instructions count: 877
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.internal.app.ChooserActivity.onCreate(android.os.Bundle):void");
    }

    @Override // com.android.internal.app.ResolverActivity
    protected int appliedThemeResId() {
        return 16974812;
    }

    private AppPredictor setupAppPredictorForUser(UserHandle userHandle, AppPredictor.Callback appPredictorCallback) {
        AppPredictor appPredictor = getAppPredictorForDirectShareIfEnabled(userHandle);
        if (appPredictor == null) {
            return null;
        }
        this.mDirectShareAppTargetCache = new HashMap();
        appPredictor.registerPredictionUpdates(getMainExecutor(), appPredictorCallback);
        return appPredictor;
    }

    private AppPredictor.Callback createAppPredictorCallback(final ChooserListAdapter chooserListAdapter) {
        return new AppPredictor.Callback() { // from class: com.android.internal.app.ChooserActivity$$ExternalSyntheticLambda1
            public final void onTargetsAvailable(List list) {
                ChooserActivity.this.lambda$createAppPredictorCallback$0(chooserListAdapter, list);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createAppPredictorCallback$0(ChooserListAdapter chooserListAdapter, List resultList) {
        if (isFinishing() || isDestroyed() || chooserListAdapter.getCount() == 0) {
            return;
        }
        if (resultList.isEmpty() && shouldQueryShortcutManager(chooserListAdapter.getUserHandle())) {
            queryDirectShareTargets(chooserListAdapter, true);
            return;
        }
        List<ShortcutManager.ShareShortcutInfo> shareShortcutInfos = new ArrayList<>();
        List<AppTarget> shortcutResults = new ArrayList<>();
        Iterator iterator2 = resultList.iterator2();
        while (iterator2.hasNext()) {
            AppTarget appTarget = (AppTarget) iterator2.next();
            if (appTarget.getShortcutInfo() != null) {
                shortcutResults.add(appTarget);
            }
        }
        for (AppTarget appTarget2 : shortcutResults) {
            shareShortcutInfos.add(new ShortcutManager.ShareShortcutInfo(appTarget2.getShortcutInfo(), new ComponentName(appTarget2.getPackageName(), appTarget2.getClassName())));
        }
        sendShareShortcutInfoList(shareShortcutInfos, chooserListAdapter, shortcutResults, chooserListAdapter.getUserHandle());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SharedPreferences getPinnedSharedPrefs(Context context) {
        File prefsFile = new File(new File(Environment.getDataUserCePackageDirectory(StorageManager.UUID_PRIVATE_INTERNAL, context.getUserId(), context.getPackageName()), "shared_prefs"), "chooser_pin_settings.xml");
        return context.getSharedPreferences(prefsFile, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.android.internal.app.ResolverActivity
    public AbstractMultiProfilePagerAdapter createMultiProfilePagerAdapter(Intent[] initialIntents, List<ResolveInfo> rList, boolean filterLastUsed) {
        if (shouldShowTabs()) {
            this.mChooserMultiProfilePagerAdapter = createChooserMultiProfilePagerAdapterForTwoProfiles(initialIntents, rList, filterLastUsed);
        } else {
            this.mChooserMultiProfilePagerAdapter = createChooserMultiProfilePagerAdapterForOneProfile(initialIntents, rList, filterLastUsed);
        }
        return !getResolverWrapper().getResolverActivityExt().isOriginUi() ? super.createMultiProfilePagerAdapter(initialIntents, rList, filterLastUsed) : this.mChooserMultiProfilePagerAdapter;
    }

    @Override // com.android.internal.app.ResolverActivity
    protected AbstractMultiProfilePagerAdapter.EmptyStateProvider createBlockerEmptyStateProvider() {
        boolean isSendAction = isSendAction(getTargetIntent());
        AbstractMultiProfilePagerAdapter.EmptyState noWorkToPersonalEmptyState = new NoCrossProfileEmptyStateProvider.DevicePolicyBlockerEmptyState(this, "Core.RESOLVER_CROSS_PROFILE_BLOCKED_TITLE", 17041509, isSendAction ? "Core.RESOLVER_CANT_SHARE_WITH_PERSONAL" : "Core.RESOLVER_CANT_ACCESS_PERSONAL", isSendAction ? 17041507 : 17041505, 158, "intent_chooser");
        AbstractMultiProfilePagerAdapter.EmptyState noPersonalToWorkEmptyState = new NoCrossProfileEmptyStateProvider.DevicePolicyBlockerEmptyState(this, "Core.RESOLVER_CROSS_PROFILE_BLOCKED_TITLE", 17041509, isSendAction ? "Core.RESOLVER_CANT_SHARE_WITH_WORK" : "Core.RESOLVER_CANT_ACCESS_WORK", isSendAction ? 17041508 : 17041506, 159, "intent_chooser");
        return new NoCrossProfileEmptyStateProvider(getPersonalProfileUserHandle(), noWorkToPersonalEmptyState, noPersonalToWorkEmptyState, createCrossProfileIntentsChecker(), getTabOwnerUserHandleForLaunch());
    }

    private ChooserMultiProfilePagerAdapter createChooserMultiProfilePagerAdapterForOneProfile(Intent[] initialIntents, List<ResolveInfo> rList, boolean filterLastUsed) {
        ChooserGridAdapter adapter = createChooserGridAdapter(this, this.mIntents, initialIntents, rList, filterLastUsed, getPersonalProfileUserHandle());
        return new ChooserMultiProfilePagerAdapter(this, adapter, createEmptyStateProvider(null), this.mQuietModeManager, null, getCloneProfileUserHandle(), this.mMaxTargetsPerRow);
    }

    private ChooserMultiProfilePagerAdapter createChooserMultiProfilePagerAdapterForTwoProfiles(Intent[] initialIntents, List<ResolveInfo> rList, boolean filterLastUsed) {
        int selectedProfile = findSelectedProfile();
        ChooserGridAdapter personalAdapter = createChooserGridAdapter(this, this.mIntents, selectedProfile == 0 ? initialIntents : null, rList, filterLastUsed, getPersonalProfileUserHandle());
        ChooserGridAdapter workAdapter = createChooserGridAdapter(this, this.mIntents, selectedProfile == 1 ? initialIntents : null, rList, filterLastUsed, getWorkProfileUserHandle());
        return new ChooserMultiProfilePagerAdapter(this, personalAdapter, workAdapter, createEmptyStateProvider(getWorkProfileUserHandle()), this.mQuietModeManager, selectedProfile, getWorkProfileUserHandle(), getCloneProfileUserHandle(), this.mMaxTargetsPerRow);
    }

    private int findSelectedProfile() {
        int selectedProfile = getSelectedProfileExtra();
        if (selectedProfile == -1) {
            return getProfileForUser(getTabOwnerUserHandleForLaunch());
        }
        return selectedProfile;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.android.internal.app.ResolverActivity
    public boolean postRebuildList(boolean rebuildCompleted) {
        if (!getResolverWrapper().getResolverActivityExt().isOriginUi()) {
            return super.postRebuildList(rebuildCompleted);
        }
        updateStickyContentPreview();
        if (shouldShowStickyContentPreview() || this.mChooserMultiProfilePagerAdapter.getCurrentRootAdapter().getSystemRowCount() != 0) {
            logActionShareWithPreview();
        }
        return postRebuildListInternal(rebuildCompleted);
    }

    private boolean isAppPredictionServiceAvailable() {
        return getPackageManager().getAppPredictionServicePackageName() != null;
    }

    protected boolean isWorkProfile() {
        return ((UserManager) getSystemService(UserManager.class)).getUserInfo(UserHandle.myUserId()).isManagedProfile();
    }

    @Override // com.android.internal.app.ResolverActivity
    protected PackageMonitor createPackageMonitor(final ResolverListAdapter listAdapter) {
        return new PackageMonitor() { // from class: com.android.internal.app.ChooserActivity.3
            @Override // com.android.internal.content.PackageMonitor
            public void onSomePackagesChanged() {
                ChooserActivity.this.handlePackagesChanged(listAdapter);
            }
        };
    }

    public void handlePackagesChanged() {
        handlePackagesChanged(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlePackagesChanged(ResolverListAdapter listAdapter) {
        this.mPinnedSharedPrefs = getPinnedSharedPrefs(this);
        if (listAdapter == null) {
            this.mChooserMultiProfilePagerAdapter.getActiveListAdapter().handlePackagesChanged();
            if (this.mChooserMultiProfilePagerAdapter.getCount() > 1) {
                this.mChooserMultiProfilePagerAdapter.getInactiveListAdapter().handlePackagesChanged();
            }
        } else {
            listAdapter.handlePackagesChanged();
        }
        updateProfileViewButton();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCopyButtonClicked(View v2) {
        ClipData clipData;
        Intent targetIntent = getTargetIntent();
        if (targetIntent == null) {
            finish();
            return;
        }
        String action = targetIntent.getAction();
        if ("android.intent.action.SEND".equals(action)) {
            String extraText = targetIntent.getStringExtra("android.intent.extra.TEXT");
            Uri extraStream = (Uri) targetIntent.getParcelableExtra("android.intent.extra.STREAM", Uri.class);
            if (extraText != null) {
                clipData = ClipData.newPlainText(null, extraText);
            } else if (extraStream != null) {
                clipData = ClipData.newUri(getContentResolver(), null, extraStream);
            } else {
                Log.w(TAG, "No data available to copy to clipboard");
                return;
            }
        } else if ("android.intent.action.SEND_MULTIPLE".equals(action)) {
            ArrayList<Uri> streams = targetIntent.getParcelableArrayListExtra("android.intent.extra.STREAM", Uri.class);
            if (!getResolverWrapper().getResolverActivityExt().hookonCopyButtonClicked(streams)) {
                clipData = ClipData.newUri(getContentResolver(), null, streams.get(0));
                for (int i10 = 1; i10 < streams.size(); i10++) {
                    clipData.addItem(getContentResolver(), new ClipData.Item(streams.get(i10)));
                }
            } else {
                ClipData clipData2 = getResolverWrapper().getResolverActivityExt().getclipData(targetIntent);
                clipData = clipData2;
                if (clipData2 == null) {
                    return;
                }
            }
        } else {
            Log.w(TAG, "Action (" + action + ") not supported for copying to clipboard");
            return;
        }
        ClipboardManager clipboardManager = (ClipboardManager) getSystemService(TextClassifier.WIDGET_TYPE_CLIPBOARD);
        clipboardManager.setPrimaryClipAsPackage(clipData, getReferrerPackageName());
        LogMaker targetLogMaker = new LogMaker(MetricsProto.MetricsEvent.ACTION_ACTIVITY_CHOOSER_PICKED_SYSTEM_TARGET).setSubtype(1);
        getMetricsLogger().write(targetLogMaker);
        getChooserActivityLogger().logShareTargetSelected(4, "", -1, false);
        setResult(-1);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.android.internal.app.ResolverActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: " + getComponentName().flattenToShortString());
        maybeCancelFinishAnimation();
    }

    @Override // com.android.internal.app.ResolverActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (!getResolverWrapper().getResolverActivityExt().isOriginUi()) {
            return;
        }
        ViewPager viewPager = findViewById(16909399);
        if (viewPager.isLayoutRtl()) {
            this.mMultiProfilePagerAdapter.setupViewPager(viewPager);
        }
        this.mShouldDisplayLandscape = shouldDisplayLandscape(newConfig.orientation);
        int integer = getResources().getInteger(17694780);
        this.mMaxTargetsPerRow = integer;
        this.mChooserMultiProfilePagerAdapter.setMaxTargetsPerRow(integer);
        adjustPreviewWidth(newConfig.orientation, null);
        updateStickyContentPreview();
        updateTabPadding();
    }

    private boolean shouldDisplayLandscape(int orientation) {
        return orientation == 2 && !isInMultiWindowMode();
    }

    private void adjustPreviewWidth(int orientation, View parent) {
        if (!getResolverWrapper().getResolverActivityExt().isOriginUi()) {
            return;
        }
        int width = -1;
        if (this.mShouldDisplayLandscape) {
            width = getResources().getDimensionPixelSize(17105061);
        }
        View parent2 = parent == null ? getWindow().getDecorView() : parent;
        updateLayoutWidth(16908919, width, parent2);
        updateLayoutWidth(16908922, width, parent2);
        updateLayoutWidth(16908909, width, parent2);
    }

    private void updateTabPadding() {
        if (shouldShowTabs()) {
            View tabs = findViewById(16908307);
            float iconSize = getResources().getDimension(17105056);
            float width = tabs.getWidth();
            int i10 = this.mMaxTargetsPerRow;
            float padding = (((width - (i10 * iconSize)) / i10) / 2.0f) - getResources().getDimension(17105530);
            tabs.setPadding((int) padding, 0, (int) padding, 0);
        }
    }

    private void updateLayoutWidth(int layoutResourceId, int width, View parent) {
        View view = parent.findViewById(layoutResourceId);
        if (view != null && view.getLayoutParams() != null) {
            ViewGroup.LayoutParams params = view.getLayoutParams();
            params.width = width;
            view.setLayoutParams(params);
        }
    }

    protected ViewGroup createContentPreviewView(ViewGroup parent) {
        Intent targetIntent = getTargetIntent();
        int previewType = findPreferredContentPreview(targetIntent, getContentResolver());
        return displayContentPreview(previewType, targetIntent, getLayoutInflater(), parent);
    }

    protected ComponentName getNearbySharingComponent() {
        if (getResolverWrapper().getResolverActivityExt().hookgetNearbySharingComponent()) {
            return null;
        }
        String nearbyComponent = Settings.Secure.getString(getContentResolver(), "nearby_sharing_component");
        if (TextUtils.isEmpty(nearbyComponent)) {
            nearbyComponent = getString(17039929);
        }
        if (TextUtils.isEmpty(nearbyComponent)) {
            return null;
        }
        return ComponentName.unflattenFromString(nearbyComponent);
    }

    protected ComponentName getEditSharingComponent() {
        String editorPackage = getApplicationContext().getString(17040058);
        if (editorPackage == null || TextUtils.isEmpty(editorPackage)) {
            return null;
        }
        return ComponentName.unflattenFromString(editorPackage);
    }

    protected TargetInfo getEditSharingTarget(Intent originalIntent) {
        Uri uri;
        ComponentName cn2 = getEditSharingComponent();
        Intent resolveIntent = new Intent(originalIntent);
        resolveIntent.setFlags(originalIntent.getFlags() & 195);
        resolveIntent.setComponent(cn2);
        resolveIntent.setAction("android.intent.action.EDIT");
        String originalAction = originalIntent.getAction();
        if ("android.intent.action.SEND".equals(originalAction)) {
            if (resolveIntent.getData() == null && (uri = (Uri) resolveIntent.getParcelableExtra("android.intent.extra.STREAM", Uri.class)) != null) {
                String mimeType = getContentResolver().getType(uri);
                resolveIntent.setDataAndType(uri, mimeType);
            }
            ResolveInfo ri = getPackageManager().resolveActivity(resolveIntent, 128);
            if (ri == null || ri.activityInfo == null) {
                Log.e(TAG, "Device-specified image edit component (" + ((Object) cn2) + ") not available");
                return null;
            }
            DisplayResolveInfo dri = new DisplayResolveInfo(originalIntent, ri, getString(R.string.screenshot_edit), "", resolveIntent, null);
            dri.setDisplayIcon(getDrawable(17302855));
            return dri;
        }
        Log.e(TAG, originalAction + " is not supported.");
        return null;
    }

    protected TargetInfo getNearbySharingTarget(Intent originalIntent) {
        Drawable icon;
        ComponentName cn2 = getNearbySharingComponent();
        if (cn2 == null) {
            return null;
        }
        Intent resolveIntent = new Intent(originalIntent);
        resolveIntent.setComponent(cn2);
        ResolveInfo ri = getPackageManager().resolveActivity(resolveIntent, 128);
        if (ri == null || ri.activityInfo == null) {
            Log.e(TAG, "Device-specified nearby sharing component (" + ((Object) cn2) + ") not available");
            return null;
        }
        CharSequence name = null;
        Drawable icon2 = null;
        Bundle metaData = ri.activityInfo.metaData;
        if (metaData != null) {
            try {
                Resources pkgRes = getPackageManager().getResourcesForActivity(cn2);
                int nameResId = metaData.getInt(CHIP_LABEL_METADATA_KEY);
                name = pkgRes.getString(nameResId);
                int resId = metaData.getInt(CHIP_ICON_METADATA_KEY);
                icon2 = pkgRes.getDrawable(resId);
            } catch (PackageManager.NameNotFoundException e2) {
            } catch (Resources.NotFoundException e10) {
            }
        }
        if (TextUtils.isEmpty(name)) {
            name = ri.loadLabel(getPackageManager());
        }
        if (icon2 != null) {
            icon = icon2;
        } else {
            icon = ri.loadIcon(getPackageManager());
        }
        DisplayResolveInfo dri = new DisplayResolveInfo(originalIntent, ri, name, "", resolveIntent, null);
        dri.setDisplayIcon(icon);
        return dri;
    }

    private Button createActionButton(Drawable icon, CharSequence title, View.OnClickListener r10) {
        Button b4 = (Button) LayoutInflater.from(this).inflate(17367129, (ViewGroup) null);
        if (icon != null) {
            int size = getResources().getDimensionPixelSize(17105048);
            icon.setBounds(0, 0, size, size);
            b4.setCompoundDrawablesRelative(icon, null, null, null);
        }
        b4.setText(title);
        b4.setOnClickListener(r10);
        return b4;
    }

    private Button createCopyButton() {
        Button b4 = createActionButton(getDrawable(17302737), getString(17039361), new ChooserActivity$$ExternalSyntheticLambda5(this));
        b4.setId(16908876);
        return b4;
    }

    private Button createNearbyButton(Intent originalIntent) {
        final TargetInfo ti = getNearbySharingTarget(originalIntent);
        if (ti == null) {
            return null;
        }
        Button b4 = createActionButton(ti.getDisplayIcon(this), ti.getDisplayLabel(), new View.OnClickListener() { // from class: com.android.internal.app.ChooserActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChooserActivity.this.lambda$createNearbyButton$1(ti, view);
            }
        });
        b4.setId(16908879);
        return b4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createNearbyButton$1(TargetInfo ti, View unused) {
        getChooserActivityLogger().logShareTargetSelected(5, "", -1, false);
        safelyStartActivityAsUser(ti, getPersonalProfileUserHandle());
        finish();
    }

    private Button createEditButton(Intent originalIntent) {
        final TargetInfo ti = getEditSharingTarget(originalIntent);
        if (ti == null) {
            return null;
        }
        Button b4 = createActionButton(ti.getDisplayIcon(this), ti.getDisplayLabel(), new View.OnClickListener() { // from class: com.android.internal.app.ChooserActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChooserActivity.this.lambda$createEditButton$2(ti, view);
            }
        });
        b4.setId(16908877);
        return b4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createEditButton$2(TargetInfo ti, View unused) {
        getChooserActivityLogger().logShareTargetSelected(6, "", -1, false);
        View firstImgView = getFirstVisibleImgPreviewView();
        if (firstImgView == null) {
            safelyStartActivityAsUser(ti, getPersonalProfileUserHandle());
            finish();
        } else {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this, firstImgView, "screenshot_preview_image");
            safelyStartActivityAsUser(ti, getPersonalProfileUserHandle(), options.toBundle());
            startFinishAnimation();
        }
    }

    private View getFirstVisibleImgPreviewView() {
        View firstImage = findViewById(16908912);
        if (firstImage == null || !firstImage.isVisibleToUser()) {
            return null;
        }
        return firstImage;
    }

    private void addActionButton(ViewGroup parent, Button b4) {
        if (b4 == null) {
            return;
        }
        ViewGroup.MarginLayoutParams lp = new ViewGroup.MarginLayoutParams(-2, -2);
        int gap = getResources().getDimensionPixelSize(17105523) / 2;
        lp.setMarginsRelative(gap, 0, gap, 0);
        parent.addView(b4, lp);
    }

    private ViewGroup displayContentPreview(int previewType, Intent targetIntent, LayoutInflater layoutInflater, ViewGroup parent) {
        ViewGroup layout = null;
        switch (previewType) {
            case 1:
                if (getResolverWrapper().getResolverActivityExt().isOriginUi()) {
                    layout = displayImageContentPreview(targetIntent, layoutInflater, parent);
                    break;
                } else {
                    layout = displayFileContentPreview(targetIntent, layoutInflater, parent);
                    break;
                }
            case 2:
                layout = displayFileContentPreview(targetIntent, layoutInflater, parent);
                break;
            case 3:
                layout = displayTextContentPreview(targetIntent, layoutInflater, parent);
                break;
            default:
                Log.e(TAG, "Unexpected content preview type: " + previewType);
                break;
        }
        if (layout != null) {
            adjustPreviewWidth(getResources().getConfiguration().orientation, layout);
        }
        if (previewType != 1) {
            this.mEnterTransitionAnimationDelegate.markImagePreviewReady();
        }
        return layout;
    }

    private ViewGroup displayTextContentPreview(Intent targetIntent, LayoutInflater layoutInflater, ViewGroup parent) {
        ViewGroup contentPreviewLayout = (ViewGroup) layoutInflater.inflate(17367137, parent, false);
        if (getResolverWrapper().getResolverActivityExt().isOriginUi()) {
            ViewGroup actionRow = (ViewGroup) contentPreviewLayout.findViewById(16908875);
            addActionButton(actionRow, createCopyButton());
            if (shouldNearbyShareBeIncludedAsActionButton()) {
                addActionButton(actionRow, createNearbyButton(targetIntent));
            }
        } else if (!getResolverWrapper().getResolverActivityExt().isOriginUi()) {
            contentPreviewLayout = getResolverWrapper().getResolverActivityExt().hookdisplayTextContentPreview(targetIntent, layoutInflater, parent, new ChooserActivity$$ExternalSyntheticLambda5(this));
        }
        CharSequence sharingText = targetIntent.getCharSequenceExtra("android.intent.extra.TEXT");
        if (sharingText == null) {
            contentPreviewLayout.findViewById(16908919).setVisibility(8);
        } else {
            TextView textView = (TextView) contentPreviewLayout.findViewById(16908917);
            textView.setText(sharingText);
        }
        String previewTitle = targetIntent.getStringExtra("android.intent.extra.TITLE");
        if (TextUtils.isEmpty(previewTitle)) {
            contentPreviewLayout.findViewById(16908922).setVisibility(8);
        } else {
            TextView previewTitleView = (TextView) contentPreviewLayout.findViewById(16908921);
            previewTitleView.setText(previewTitle);
            ClipData previewData = targetIntent.getClipData();
            Uri previewThumbnail = null;
            if (previewData != null && previewData.getItemCount() > 0) {
                ClipData.Item previewDataItem = previewData.getItemAt(0);
                previewThumbnail = previewDataItem.getUri();
            }
            ImageView previewThumbnailView = (ImageView) contentPreviewLayout.findViewById(16908920);
            if (!validForContentPreview(previewThumbnail)) {
                previewThumbnailView.setVisibility(8);
            } else {
                ContentPreviewCoordinator contentPreviewCoordinator = new ContentPreviewCoordinator(contentPreviewLayout, false);
                this.mPreviewCoord = contentPreviewCoordinator;
                contentPreviewCoordinator.loadUriIntoView(16908920, previewThumbnail, 0);
            }
        }
        return contentPreviewLayout;
    }

    private ViewGroup displayImageContentPreview(Intent targetIntent, LayoutInflater layoutInflater, ViewGroup parent) {
        ViewGroup contentPreviewLayout;
        if (getResolverWrapper().getResolverActivityExt().isOriginUi()) {
            contentPreviewLayout = (ViewGroup) layoutInflater.inflate(17367136, parent, false);
        } else {
            contentPreviewLayout = getResolverWrapper().getResolverActivityExt().getDisplayImageContentPreview(layoutInflater, parent);
        }
        ViewGroup imagePreview = (ViewGroup) contentPreviewLayout.findViewById(16908916);
        ViewGroup actionRow = (ViewGroup) contentPreviewLayout.findViewById(16908875);
        if (shouldNearbyShareBeIncludedAsActionButton()) {
            addActionButton(actionRow, createNearbyButton(targetIntent));
        }
        addActionButton(actionRow, createEditButton(targetIntent));
        this.mPreviewCoord = new ContentPreviewCoordinator(contentPreviewLayout, false);
        String action = targetIntent.getAction();
        if ("android.intent.action.SEND".equals(action)) {
            Uri uri = (Uri) targetIntent.getParcelableExtra("android.intent.extra.STREAM", Uri.class);
            if (!validForContentPreview(uri)) {
                contentPreviewLayout.setVisibility(8);
                return contentPreviewLayout;
            }
            imagePreview.findViewById(16908912).setTransitionName("screenshot_preview_image");
            this.mPreviewCoord.loadUriIntoView(16908912, uri, 0);
        } else {
            ContentResolver resolver = getContentResolver();
            List<Uri> uris = targetIntent.getParcelableArrayListExtra("android.intent.extra.STREAM", Uri.class);
            List<Uri> imageUris = new ArrayList<>();
            for (Uri uri2 : uris) {
                if (validForContentPreview(uri2) && isImageType(resolver.getType(uri2))) {
                    imageUris.add(uri2);
                }
            }
            if (imageUris.size() == 0) {
                Log.i(TAG, "Attempted to display image preview area with zero available images detected in EXTRA_STREAM list");
                imagePreview.setVisibility(8);
                return contentPreviewLayout;
            }
            imagePreview.findViewById(16908912).setTransitionName("screenshot_preview_image");
            this.mPreviewCoord.loadUriIntoView(16908912, imageUris.get(0), 0);
            if (imageUris.size() == 2) {
                this.mPreviewCoord.loadUriIntoView(16908913, imageUris.get(1), 0);
            } else if (imageUris.size() > 2) {
                this.mPreviewCoord.loadUriIntoView(16908914, imageUris.get(1), 0);
                this.mPreviewCoord.loadUriIntoView(16908915, imageUris.get(2), imageUris.size() - 3);
            }
        }
        return contentPreviewLayout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class FileInfo {
        public final boolean hasThumbnail;
        public final String name;

        FileInfo(String name, boolean hasThumbnail) {
            this.name = name;
            this.hasThumbnail = hasThumbnail;
        }
    }

    public Cursor queryResolver(ContentResolver resolver, Uri uri) {
        return resolver.query(uri, null, null, null, null);
    }

    private FileInfo extractFileInfo(Uri uri, ContentResolver resolver) {
        int index;
        String fileName = null;
        boolean hasThumbnail = false;
        try {
            Cursor cursor = queryResolver(resolver, uri);
            if (cursor != null) {
                try {
                    if (cursor.getCount() > 0) {
                        int nameIndex = cursor.getColumnIndex("_display_name");
                        int titleIndex = cursor.getColumnIndex("title");
                        int flagsIndex = cursor.getColumnIndex("flags");
                        cursor.moveToFirst();
                        if (nameIndex != -1) {
                            fileName = cursor.getString(nameIndex);
                        } else if (titleIndex != -1) {
                            fileName = cursor.getString(titleIndex);
                        }
                        if (flagsIndex != -1) {
                            hasThumbnail = (cursor.getInt(flagsIndex) & 1) != 0;
                        }
                    }
                } catch (Throwable th) {
                    if (cursor != null) {
                        try {
                            cursor.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (NullPointerException | SecurityException e2) {
            logContentPreviewWarning(uri);
        }
        if (TextUtils.isEmpty(fileName) && (index = (fileName = uri.getPath()).lastIndexOf(47)) != -1) {
            fileName = fileName.substring(index + 1);
        }
        return new FileInfo(fileName, hasThumbnail);
    }

    private void logContentPreviewWarning(Uri uri) {
        Log.w(TAG, "Could not load (" + uri.toString() + ") thumbnail/name for preview. If desired, consider using Intent#createChooser to launch the ChooserActivity, and set your Intent's clipData and flags in accordance with that method's documentation");
    }

    private ViewGroup displayFileContentPreview(Intent targetIntent, LayoutInflater layoutInflater, ViewGroup parent) {
        ViewGroup contentPreviewLayout;
        if (getResolverWrapper().getResolverActivityExt().isOriginUi()) {
            contentPreviewLayout = (ViewGroup) layoutInflater.inflate(17367135, parent, false);
        } else {
            contentPreviewLayout = getResolverWrapper().getResolverActivityExt().getDisplayFileContentPreview(layoutInflater, parent);
        }
        ViewGroup actionRow = (ViewGroup) contentPreviewLayout.findViewById(16908875);
        if (shouldNearbyShareBeIncludedAsActionButton()) {
            addActionButton(actionRow, createNearbyButton(targetIntent));
        }
        String action = targetIntent.getAction();
        if ("android.intent.action.SEND".equals(action)) {
            Uri uri = (Uri) targetIntent.getParcelableExtra("android.intent.extra.STREAM", Uri.class);
            if (!validForContentPreview(uri)) {
                contentPreviewLayout.setVisibility(8);
                return contentPreviewLayout;
            }
            loadFileUriIntoView(uri, contentPreviewLayout);
        } else {
            List<Uri> uris = (List) targetIntent.getParcelableArrayListExtra("android.intent.extra.STREAM", Uri.class).stream().filter(new Predicate() { // from class: com.android.internal.app.ChooserActivity$$ExternalSyntheticLambda2
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    boolean validForContentPreview;
                    validForContentPreview = ChooserActivity.validForContentPreview((Uri) obj);
                    return validForContentPreview;
                }
            }).collect(Collectors.toList());
            int uriCount = uris.size();
            if (uriCount == 0) {
                contentPreviewLayout.setVisibility(8);
                Log.i(TAG, "Appears to be no uris available in EXTRA_STREAM, removing preview area");
                return contentPreviewLayout;
            }
            if (uriCount == 1) {
                loadFileUriIntoView(uris.get(0), contentPreviewLayout);
            } else {
                FileInfo fileInfo = extractFileInfo(uris.get(0), getContentResolver());
                int remUriCount = uriCount - 1;
                Map<String, Object> arguments = new HashMap<>();
                arguments.put(PLURALS_COUNT, Integer.valueOf(remUriCount));
                arguments.put(PLURALS_FILE_NAME, fileInfo.name);
                String fileName = PluralsMessageFormatter.format(getResources(), arguments, 17040365);
                if (!getResolverWrapper().getResolverActivityExt().isOriginUi()) {
                    fileName = getResolverWrapper().getResolverActivityExt().getChooserPreFileName(getApplicationContext(), uriCount, fileInfo.name);
                }
                TextView fileNameView = (TextView) contentPreviewLayout.findViewById(16908911);
                fileNameView.setText(fileName);
                getResolverWrapper().getResolverActivityExt().adaptFontSize(fileNameView);
                View thumbnailView = contentPreviewLayout.findViewById(16908910);
                thumbnailView.setVisibility(8);
                ImageView fileIconView = (ImageView) contentPreviewLayout.findViewById(16908908);
                fileIconView.setVisibility(0);
                getResolverWrapper().getResolverActivityExt().setChooserPreFileSingleIconView(17302467, fileIconView, false, null, false, null, null);
            }
        }
        return contentPreviewLayout;
    }

    private void loadFileUriIntoView(Uri uri, View parent) {
        FileInfo fileInfo = extractFileInfo(uri, getContentResolver());
        TextView fileNameView = (TextView) parent.findViewById(16908911);
        fileNameView.setText(fileInfo.name);
        if (!getResolverWrapper().getResolverActivityExt().isOriginUi() && findPreferredContentPreview(uri, getContentResolver()) != 2) {
            fileNameView.setVisibility(8);
        }
        if (fileInfo.hasThumbnail) {
            ContentPreviewCoordinator contentPreviewCoordinator = new ContentPreviewCoordinator(parent, false);
            this.mPreviewCoord = contentPreviewCoordinator;
            contentPreviewCoordinator.loadUriIntoView(16908910, uri, 0);
        } else if (!getResolverWrapper().getResolverActivityExt().isOriginUi() && findPreferredContentPreview(uri, getContentResolver()) != 2) {
            ContentPreviewCoordinator contentPreviewCoordinator2 = new ContentPreviewCoordinator(parent, false);
            this.mPreviewCoord = contentPreviewCoordinator2;
            contentPreviewCoordinator2.loadUriIntoView(16908910, uri, 0);
        } else {
            View thumbnailView = parent.findViewById(16908910);
            thumbnailView.setVisibility(8);
            ImageView fileIconView = (ImageView) parent.findViewById(16908908);
            fileIconView.setVisibility(0);
            getResolverWrapper().getResolverActivityExt().setChooserPreFileSingleIconView(17302122, fileIconView, true, fileNameView, true, fileInfo.name, uri);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean validForContentPreview(Uri uri) throws SecurityException {
        if (uri == null) {
            return false;
        }
        int userId = ContentProvider.getUserIdFromUri(uri, -2);
        if (userId != -2 && userId != UserHandle.myUserId()) {
            Log.e(TAG, "dropped invalid content URI belonging to user " + userId);
            return false;
        }
        return true;
    }

    protected boolean isImageType(String mimeType) {
        return mimeType != null && mimeType.startsWith("image/");
    }

    private int findPreferredContentPreview(Uri uri, ContentResolver resolver) {
        if (uri == null) {
            return 3;
        }
        String mimeType = resolver.getType(uri);
        return isImageType(mimeType) ? 1 : 2;
    }

    private int findPreferredContentPreview(Intent targetIntent, ContentResolver resolver) {
        List<Uri> uris;
        String action = targetIntent.getAction();
        if ("android.intent.action.SEND".equals(action)) {
            Uri uri = (Uri) targetIntent.getParcelableExtra("android.intent.extra.STREAM", Uri.class);
            return findPreferredContentPreview(uri, resolver);
        }
        if (!"android.intent.action.SEND_MULTIPLE".equals(action) || (uris = targetIntent.getParcelableArrayListExtra("android.intent.extra.STREAM", Uri.class)) == null || uris.isEmpty()) {
            return 3;
        }
        for (Uri uri2 : uris) {
            if (findPreferredContentPreview(uri2, resolver) == 2) {
                return 2;
            }
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getNumSheetExpansions() {
        return getPreferences(0).getInt(PREF_NUM_SHEET_EXPANSIONS, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void incrementNumSheetExpansions() {
        getPreferences(0).edit().putInt(PREF_NUM_SHEET_EXPANSIONS, getNumSheetExpansions() + 1).apply();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.android.internal.app.ResolverActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        if (maybeCancelFinishAnimation()) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.android.internal.app.ResolverActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (isFinishing()) {
            this.mLatencyTracker.onActionCancel(16);
        }
        RefinementResultReceiver refinementResultReceiver = this.mRefinementResultReceiver;
        if (refinementResultReceiver != null) {
            refinementResultReceiver.destroy();
            this.mRefinementResultReceiver = null;
        }
        this.mChooserHandler.removeAllMessages();
        ContentPreviewCoordinator contentPreviewCoordinator = this.mPreviewCoord;
        if (contentPreviewCoordinator != null) {
            contentPreviewCoordinator.cancelLoads();
        }
        this.mChooserMultiProfilePagerAdapter.getActiveListAdapter().destroyAppPredictor();
        if (this.mChooserMultiProfilePagerAdapter.getInactiveListAdapter() != null) {
            this.mChooserMultiProfilePagerAdapter.getInactiveListAdapter().destroyAppPredictor();
        }
        this.mPersonalAppPredictor = null;
        this.mWorkAppPredictor = null;
    }

    @Override // com.android.internal.app.ResolverActivity, com.android.internal.app.ResolverListAdapter.ResolverListCommunicator
    public Intent getReplacementIntent(ActivityInfo aInfo, Intent defIntent) {
        Bundle replExtras;
        Intent result = defIntent;
        Bundle bundle = this.mReplacementExtras;
        if (bundle != null && (replExtras = bundle.getBundle(aInfo.packageName)) != null) {
            result = new Intent(defIntent);
            result.putExtras(replExtras);
        }
        if (aInfo.name.equals(IntentForwarderActivity.FORWARD_INTENT_TO_PARENT) || aInfo.name.equals(IntentForwarderActivity.FORWARD_INTENT_TO_MANAGED_PROFILE)) {
            Intent result2 = Intent.createChooser(result, getIntent().getCharSequenceExtra("android.intent.extra.TITLE"));
            result2.putExtra("android.intent.extra.AUTO_LAUNCH_SINGLE_CHOICE", false);
            return result2;
        }
        return result;
    }

    @Override // com.android.internal.app.ResolverActivity
    public void onActivityStarted(TargetInfo cti) {
        ComponentName target;
        if (this.mChosenComponentSender != null && (target = cti.getResolvedComponentName()) != null) {
            Intent fillIn = new Intent().putExtra("android.intent.extra.CHOSEN_COMPONENT", target);
            try {
                this.mChosenComponentSender.sendIntent(this, -1, fillIn, null, null);
            } catch (IntentSender.SendIntentException e2) {
                Slog.e(TAG, "Unable to launch supplied IntentSender to report the chosen component: " + ((Object) e2));
            }
        }
    }

    @Override // com.android.internal.app.ResolverActivity
    public void addUseDifferentAppLabelIfNecessary(ResolverListAdapter adapter) {
        ChooserTarget[] chooserTargetArr = this.mCallerChooserTargets;
        if (chooserTargetArr != null && chooserTargetArr.length > 0) {
            this.mChooserMultiProfilePagerAdapter.getActiveListAdapter().addServiceResults(null, Lists.newArrayList(this.mCallerChooserTargets), 0, null);
        }
    }

    @Override // com.android.internal.app.ResolverActivity
    public int getLayoutResource() {
        return 17367134;
    }

    @Override // com.android.internal.app.ResolverActivity, com.android.internal.app.ResolverListAdapter.ResolverListCommunicator
    public boolean shouldGetActivityMetadata() {
        return true;
    }

    @Override // com.android.internal.app.ResolverActivity
    public boolean shouldAutoLaunchSingleChoice(TargetInfo target) {
        if (!super.shouldAutoLaunchSingleChoice(target)) {
            return false;
        }
        return getIntent().getBooleanExtra("android.intent.extra.AUTO_LAUNCH_SINGLE_CHOICE", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showTargetDetails(TargetInfo targetInfo) {
        ArrayList<DisplayResolveInfo> targetList;
        if (targetInfo == null) {
            return;
        }
        ChooserTargetActionsDialogFragment fragment = new ChooserTargetActionsDialogFragment();
        Bundle bundle = new Bundle();
        if (targetInfo instanceof SelectableTargetInfo) {
            SelectableTargetInfo selectableTargetInfo = (SelectableTargetInfo) targetInfo;
            if (selectableTargetInfo.getDisplayResolveInfo() == null || selectableTargetInfo.getChooserTarget() == null) {
                Log.e(TAG, "displayResolveInfo or chooserTarget in selectableTargetInfo are null");
                return;
            }
            targetList = new ArrayList<>();
            targetList.add(selectableTargetInfo.getDisplayResolveInfo());
            bundle.putString(ChooserTargetActionsDialogFragment.SHORTCUT_ID_KEY, selectableTargetInfo.getChooserTarget().getIntentExtras().getString(ShortcutManagerCompat.EXTRA_SHORTCUT_ID));
            bundle.putBoolean(ChooserTargetActionsDialogFragment.IS_SHORTCUT_PINNED_KEY, selectableTargetInfo.isPinned());
            bundle.putParcelable("intent_filter", getTargetIntentFilter());
            if (selectableTargetInfo.getDisplayLabel() != null) {
                bundle.putString(ChooserTargetActionsDialogFragment.SHORTCUT_TITLE_KEY, selectableTargetInfo.getDisplayLabel().toString());
            }
        } else if (targetInfo instanceof MultiDisplayResolveInfo) {
            MultiDisplayResolveInfo mti = (MultiDisplayResolveInfo) targetInfo;
            targetList = mti.getTargets();
        } else {
            targetList = new ArrayList<>();
            targetList.add((DisplayResolveInfo) targetInfo);
        }
        bundle.putParcelable(ChooserTargetActionsDialogFragment.USER_HANDLE_KEY, getResolveInfoUserHandle(targetInfo.getResolveInfo(), this.mChooserMultiProfilePagerAdapter.getCurrentUserHandle()));
        bundle.putParcelableArrayList(ChooserTargetActionsDialogFragment.TARGET_INFOS_KEY, targetList);
        fragment.setArguments(bundle);
        fragment.show(getFragmentManager(), TARGET_DETAILS_FRAGMENT_TAG);
    }

    private void modifyTargetIntent(Intent in) {
        if (isSendAction(in)) {
            in.addFlags(134742016);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.android.internal.app.ResolverActivity
    public boolean onTargetSelected(TargetInfo target, boolean alwaysCheck) {
        if (this.mRefinementIntentSender != null) {
            Intent fillIn = new Intent();
            List<Intent> sourceIntents = target.getAllSourceIntents();
            if (!sourceIntents.isEmpty()) {
                fillIn.putExtra("android.intent.extra.INTENT", sourceIntents.get(0));
                if (sourceIntents.size() > 1) {
                    Intent[] alts = new Intent[sourceIntents.size() - 1];
                    int N = sourceIntents.size();
                    for (int i10 = 1; i10 < N; i10++) {
                        alts[i10 - 1] = sourceIntents.get(i10);
                    }
                    fillIn.putExtra("android.intent.extra.ALTERNATE_INTENTS", alts);
                }
                RefinementResultReceiver refinementResultReceiver = this.mRefinementResultReceiver;
                if (refinementResultReceiver != null) {
                    refinementResultReceiver.destroy();
                }
                RefinementResultReceiver refinementResultReceiver2 = new RefinementResultReceiver(this, target, null);
                this.mRefinementResultReceiver = refinementResultReceiver2;
                fillIn.putExtra("android.intent.extra.RESULT_RECEIVER", refinementResultReceiver2);
                try {
                    this.mRefinementIntentSender.sendIntent(this, 0, fillIn, null, null);
                    return false;
                } catch (IntentSender.SendIntentException e2) {
                    Log.e(TAG, "Refinement IntentSender failed to send", e2);
                }
            }
        }
        updateModelAndChooserCounts(target);
        return super.onTargetSelected(target, alwaysCheck);
    }

    @Override // com.android.internal.app.ResolverActivity
    public void startSelected(int which, boolean always, boolean filtered) {
        if (!getResolverWrapper().getResolverActivityExt().isOriginUi()) {
            super.startSelected(which, always, filtered);
            return;
        }
        ChooserListAdapter currentListAdapter = this.mChooserMultiProfilePagerAdapter.getActiveListAdapter();
        TargetInfo targetInfo = currentListAdapter.targetInfoForPosition(which, filtered);
        if (targetInfo == null) {
            return;
        }
        if (targetInfo == null || !(targetInfo instanceof NotSelectableTargetInfo)) {
            long selectionCost = System.currentTimeMillis() - this.mChooserShownTime;
            if (targetInfo instanceof MultiDisplayResolveInfo) {
                MultiDisplayResolveInfo mti = (MultiDisplayResolveInfo) targetInfo;
                if (!mti.hasSelected()) {
                    ChooserStackedAppDialogFragment f10 = new ChooserStackedAppDialogFragment();
                    Bundle b4 = new Bundle();
                    b4.putParcelable(ChooserTargetActionsDialogFragment.USER_HANDLE_KEY, getResolveInfoUserHandle(targetInfo.getResolveInfo(), this.mChooserMultiProfilePagerAdapter.getCurrentUserHandle()));
                    b4.putObject("multi_dri_key", mti);
                    b4.putInt("which_key", which);
                    f10.setArguments(b4);
                    f10.show(getFragmentManager(), TARGET_DETAILS_FRAGMENT_TAG);
                    return;
                }
            }
            super.startSelected(which, always, filtered);
            if (currentListAdapter.getCount() > 0) {
                int cat = 0;
                int value = which;
                int directTargetAlsoRanked = -1;
                int numCallerProvided = 0;
                HashedStringCache.HashResult directTargetHashed = null;
                switch (currentListAdapter.getPositionTargetType(which)) {
                    case 0:
                    case 2:
                        cat = 215;
                        value -= currentListAdapter.getSurfacedTargetInfo().size();
                        numCallerProvided = currentListAdapter.getCallerTargetCount();
                        getChooserActivityLogger().logShareTargetSelected(2, targetInfo.getResolveInfo().activityInfo.processName, value, targetInfo.isPinned());
                        break;
                    case 1:
                        cat = 216;
                        ChooserTarget target = currentListAdapter.getChooserTargetForValue(value);
                        directTargetHashed = HashedStringCache.getInstance().hashString(this, TAG, target.getComponentName().getPackageName() + target.getTitle().toString(), this.mMaxHashSaltDays);
                        SelectableTargetInfo selectableTargetInfo = (SelectableTargetInfo) targetInfo;
                        directTargetAlsoRanked = getRankedPosition(selectableTargetInfo);
                        ChooserTarget[] chooserTargetArr = this.mCallerChooserTargets;
                        if (chooserTargetArr != null) {
                            numCallerProvided = chooserTargetArr.length;
                        }
                        getChooserActivityLogger().logShareTargetSelected(1, targetInfo.getResolveInfo().activityInfo.processName, value, selectableTargetInfo.isPinned());
                        break;
                    case 3:
                        value = -1;
                        cat = 217;
                        getChooserActivityLogger().logShareTargetSelected(3, targetInfo.getResolveInfo().activityInfo.processName, -1, false);
                        break;
                }
                if (cat != 0) {
                    LogMaker targetLogMaker = new LogMaker(cat).setSubtype(value);
                    if (directTargetHashed != null) {
                        targetLogMaker.addTaggedData(MetricsProto.MetricsEvent.FIELD_HASHED_TARGET_NAME, directTargetHashed.hashedString);
                        targetLogMaker.addTaggedData(MetricsProto.MetricsEvent.FIELD_HASHED_TARGET_SALT_GEN, Integer.valueOf(directTargetHashed.saltGeneration));
                        targetLogMaker.addTaggedData(MetricsProto.MetricsEvent.FIELD_RANKED_POSITION, Integer.valueOf(directTargetAlsoRanked));
                    }
                    targetLogMaker.addTaggedData(MetricsProto.MetricsEvent.FIELD_IS_CATEGORY_USED, Integer.valueOf(numCallerProvided));
                    getMetricsLogger().write(targetLogMaker);
                }
                if (this.mIsSuccessfullySelected) {
                    Log.d(TAG, "User Selection Time Cost is " + selectionCost);
                    Log.d(TAG, "position of selected app/service/caller is " + Integer.toString(value));
                    MetricsLogger.histogram(null, "user_selection_cost_for_smart_sharing", (int) selectionCost);
                    MetricsLogger.histogram(null, "app_position_for_smart_sharing", value);
                }
            }
        }
    }

    private int getRankedPosition(SelectableTargetInfo targetInfo) {
        String targetPackageName = targetInfo.getChooserTarget().getComponentName().getPackageName();
        ChooserListAdapter currentListAdapter = this.mChooserMultiProfilePagerAdapter.getActiveListAdapter();
        int maxRankedResults = Math.min(currentListAdapter.mDisplayList.size(), 12);
        for (int i10 = 0; i10 < maxRankedResults; i10++) {
            if (currentListAdapter.mDisplayList.get(i10).getResolveInfo().activityInfo.packageName.equals(targetPackageName)) {
                return i10;
            }
        }
        return -1;
    }

    @Override // com.android.internal.app.ResolverActivity
    protected boolean shouldAddFooterView() {
        return true;
    }

    @Override // com.android.internal.app.ResolverActivity
    protected void applyFooterView(int height) {
        int count = this.mChooserMultiProfilePagerAdapter.getItemCount();
        for (int i10 = 0; i10 < count; i10++) {
            this.mChooserMultiProfilePagerAdapter.getAdapterForIndex(i10).setFooterHeight(height);
        }
    }

    private IntentFilter getTargetIntentFilter() {
        try {
            Intent intent = getTargetIntent();
            String dataString = intent.getDataString();
            if (intent.getType() == null) {
                if (TextUtils.isEmpty(dataString)) {
                    Log.e(TAG, "Failed to get target intent filter: intent data and type are null");
                    return null;
                }
                return new IntentFilter(intent.getAction(), dataString);
            }
            IntentFilter intentFilter = new IntentFilter(intent.getAction(), intent.getType());
            List<Uri> contentUris = new ArrayList<>();
            if ("android.intent.action.SEND".equals(intent.getAction())) {
                Uri uri = (Uri) intent.getParcelableExtra("android.intent.extra.STREAM", Uri.class);
                if (uri != null) {
                    contentUris.add(uri);
                }
            } else {
                List<Uri> uris = intent.getParcelableArrayListExtra("android.intent.extra.STREAM", Uri.class);
                if (uris != null) {
                    contentUris.addAll(uris);
                }
            }
            for (Uri uri2 : contentUris) {
                intentFilter.addDataScheme(uri2.getScheme());
                intentFilter.addDataAuthority(uri2.getAuthority(), null);
                intentFilter.addDataPath(uri2.getPath(), 0);
            }
            return intentFilter;
        } catch (Exception e2) {
            Log.e(TAG, "Failed to get target intent filter", e2);
            return null;
        }
    }

    protected void queryDirectShareTargets(final ChooserListAdapter adapter, boolean skipAppPredictionService) {
        AppPredictor appPredictor;
        this.mQueriedSharingShortcutsTimeMs = System.currentTimeMillis();
        final UserHandle userHandle = adapter.getUserHandle();
        if (!skipAppPredictionService && (appPredictor = getAppPredictorForDirectShareIfEnabled(userHandle)) != null) {
            appPredictor.requestPredictionUpdate();
            return;
        }
        final IntentFilter filter = getTargetIntentFilter();
        if (filter == null) {
            return;
        }
        AsyncTask.execute(new Runnable() { // from class: com.android.internal.app.ChooserActivity$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                ChooserActivity.this.lambda$queryDirectShareTargets$3(userHandle, filter, adapter);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$queryDirectShareTargets$3(UserHandle userHandle, IntentFilter filter, ChooserListAdapter adapter) {
        Context selectedProfileContext = createContextAsUser(userHandle, 0);
        ShortcutManager sm = (ShortcutManager) selectedProfileContext.getSystemService("shortcut");
        List<ShortcutManager.ShareShortcutInfo> resultList = sm.getShareTargets(filter);
        sendShareShortcutInfoList(resultList, adapter, null, userHandle);
    }

    private boolean shouldQueryShortcutManager(UserHandle userHandle) {
        if (shouldShowTabs() && getWorkProfileUserHandle().equals(userHandle)) {
            return isUserRunning(userHandle) && isUserUnlocked(userHandle) && !isQuietModeEnabled(userHandle);
        }
        return true;
    }

    private void sendShareShortcutInfoList(List<ShortcutManager.ShareShortcutInfo> resultList, ChooserListAdapter chooserListAdapter, List<AppTarget> appTargets, UserHandle userHandle) {
        if (appTargets != null && appTargets.size() != resultList.size()) {
            throw new RuntimeException("resultList and appTargets must have the same size. resultList.size()=" + resultList.size() + " appTargets.size()=" + appTargets.size());
        }
        Context selectedProfileContext = createContextAsUser(userHandle, 0);
        for (int i10 = resultList.size() - 1; i10 >= 0; i10--) {
            String packageName = resultList.get(i10).getTargetComponent().getPackageName();
            if (!isPackageEnabled(selectedProfileContext, packageName)) {
                resultList.remove(i10);
                if (appTargets != null) {
                    appTargets.remove(i10);
                }
            }
        }
        int shortcutType = appTargets == null ? 2 : 3;
        List<ServiceResultInfo> resultRecords = new ArrayList<>();
        for (int i11 = 0; i11 < chooserListAdapter.getDisplayResolveInfoCount(); i11++) {
            DisplayResolveInfo displayResolveInfo = chooserListAdapter.getDisplayResolveInfo(i11);
            List<ShortcutManager.ShareShortcutInfo> matchingShortcuts = filterShortcutsByTargetComponentName(resultList, displayResolveInfo.getResolvedComponentName());
            if (!matchingShortcuts.isEmpty()) {
                List<ChooserTarget> chooserTargets = convertToChooserTarget(matchingShortcuts, resultList, appTargets, shortcutType);
                ServiceResultInfo resultRecord = new ServiceResultInfo(displayResolveInfo, chooserTargets, userHandle);
                resultRecords.add(resultRecord);
            }
        }
        sendShortcutManagerShareTargetResults(shortcutType, (ServiceResultInfo[]) resultRecords.toArray(new ServiceResultInfo[0]));
    }

    private List<ShortcutManager.ShareShortcutInfo> filterShortcutsByTargetComponentName(List<ShortcutManager.ShareShortcutInfo> allShortcuts, ComponentName requiredTarget) {
        List<ShortcutManager.ShareShortcutInfo> matchingShortcuts = new ArrayList<>();
        for (ShortcutManager.ShareShortcutInfo shortcut : allShortcuts) {
            if (requiredTarget.equals(shortcut.getTargetComponent())) {
                matchingShortcuts.add(shortcut);
            }
        }
        return matchingShortcuts;
    }

    protected void sendShortcutManagerShareTargetResults(int shortcutType, ServiceResultInfo[] results) {
        Message msg = Message.obtain();
        msg.what = 7;
        msg.obj = results;
        msg.arg1 = shortcutType;
        this.mChooserHandler.sendMessage(msg);
    }

    private boolean isPackageEnabled(Context context, String packageName) {
        if (TextUtils.isEmpty(packageName)) {
            return false;
        }
        try {
            ApplicationInfo appInfo = context.getPackageManager().getApplicationInfo(packageName, 0);
            return appInfo != null && appInfo.enabled && (appInfo.flags & 1073741824) == 0;
        } catch (PackageManager.NameNotFoundException e2) {
            return false;
        }
    }

    public List<ChooserTarget> convertToChooserTarget(List<ShortcutManager.ShareShortcutInfo> matchingShortcuts, List<ShortcutManager.ShareShortcutInfo> allShortcuts, List<AppTarget> allAppTargets, int shortcutType) {
        float score;
        List<Integer> scoreList = new ArrayList<>();
        if (shortcutType == 2) {
            for (int i10 = 0; i10 < matchingShortcuts.size(); i10++) {
                int shortcutRank = matchingShortcuts.get(i10).getShortcutInfo().getRank();
                if (!scoreList.contains(Integer.valueOf(shortcutRank))) {
                    scoreList.add(Integer.valueOf(shortcutRank));
                }
            }
            Collections.sort(scoreList);
        }
        List<ChooserTarget> chooserTargetList = new ArrayList<>(matchingShortcuts.size());
        for (int i11 = 0; i11 < matchingShortcuts.size(); i11++) {
            ShortcutInfo shortcutInfo = matchingShortcuts.get(i11).getShortcutInfo();
            int indexInAllShortcuts = allShortcuts.indexOf(matchingShortcuts.get(i11));
            if (shortcutType == 3) {
                score = Math.max(1.0f - (indexInAllShortcuts * 0.01f), 0.0f);
            } else {
                int rankIndex = scoreList.indexOf(Integer.valueOf(shortcutInfo.getRank()));
                score = Math.max(1.0f - (rankIndex * 0.01f), 0.0f);
            }
            Bundle extras = new Bundle();
            extras.putString(ShortcutManagerCompat.EXTRA_SHORTCUT_ID, shortcutInfo.getId());
            ChooserTarget chooserTarget = new ChooserTarget(shortcutInfo.getLabel(), null, score, matchingShortcuts.get(i11).getTargetComponent().clone(), extras);
            chooserTargetList.add(chooserTarget);
            Map<ChooserTarget, AppTarget> map = this.mDirectShareAppTargetCache;
            if (map != null && allAppTargets != null) {
                map.put(chooserTarget, allAppTargets.get(indexInAllShortcuts));
            }
            Map<ChooserTarget, ShortcutInfo> map2 = this.mDirectShareShortcutInfoCache;
            if (map2 != null) {
                map2.put(chooserTarget, shortcutInfo);
            }
        }
        Comparator<ChooserTarget> byScore = new Comparator() { // from class: com.android.internal.app.ChooserActivity$$ExternalSyntheticLambda3
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ChooserActivity.lambda$convertToChooserTarget$4((ChooserTarget) obj, (ChooserTarget) obj2);
            }
        };
        Collections.sort(chooserTargetList, byScore);
        return chooserTargetList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int lambda$convertToChooserTarget$4(ChooserTarget a10, ChooserTarget b4) {
        return -Float.compare(a10.getScore(), b4.getScore());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logDirectShareTargetReceived(int logCategory) {
        int apiLatency = (int) (System.currentTimeMillis() - this.mQueriedSharingShortcutsTimeMs);
        getMetricsLogger().write(new LogMaker(logCategory).setSubtype(apiLatency));
    }

    void updateModelAndChooserCounts(TargetInfo info) {
        if (info != null && (info instanceof MultiDisplayResolveInfo)) {
            info = ((MultiDisplayResolveInfo) info).getSelectedTarget();
        }
        if (info != null) {
            sendClickToAppPredictor(info);
            ResolveInfo ri = info.getResolveInfo();
            Intent targetIntent = getTargetIntent();
            if (ri == null || ri.activityInfo == null || targetIntent == null) {
                Log.d(TAG, "Can not log Chooser Counts of null ResovleInfo");
            } else {
                ChooserListAdapter currentListAdapter = this.mChooserMultiProfilePagerAdapter.getActiveListAdapter();
                if (currentListAdapter != null) {
                    sendImpressionToAppPredictor(info, currentListAdapter);
                    currentListAdapter.updateModel(info);
                    currentListAdapter.updateChooserCounts(ri.activityInfo.packageName, targetIntent.getAction(), ri.userHandle);
                }
                Log.d(TAG, "ResolveInfo Package is " + ri.activityInfo.packageName);
                Log.d(TAG, "Action to be updated is " + targetIntent.getAction());
            }
        }
        this.mIsSuccessfullySelected = true;
    }

    private void sendImpressionToAppPredictor(TargetInfo targetInfo, ChooserListAdapter adapter) {
        AppPredictor directShareAppPredictor = getAppPredictorForDirectShareIfEnabled(this.mChooserMultiProfilePagerAdapter.getCurrentUserHandle());
        if (directShareAppPredictor == null || (targetInfo instanceof ChooserTargetInfo)) {
            return;
        }
        List<ChooserTargetInfo> surfacedTargetInfo = adapter.getSurfacedTargetInfo();
        List<AppTargetId> targetIds = new ArrayList<>();
        for (ChooserTargetInfo chooserTargetInfo : surfacedTargetInfo) {
            ChooserTarget chooserTarget = chooserTargetInfo.getChooserTarget();
            ComponentName componentName = chooserTarget.getComponentName();
            if (this.mDirectShareShortcutInfoCache.containsKey(chooserTarget)) {
                String shortcutId = this.mDirectShareShortcutInfoCache.get(chooserTarget).getId();
                targetIds.add(new AppTargetId(String.format("%s/%s/%s", shortcutId, componentName.flattenToString(), SHORTCUT_TARGET)));
            }
        }
        directShareAppPredictor.notifyLaunchLocationShown(LAUNCH_LOCATION_DIRECT_SHARE, targetIds);
    }

    private void sendClickToAppPredictor(TargetInfo targetInfo) {
        AppPredictor directShareAppPredictor = getAppPredictorForDirectShareIfEnabled(this.mChooserMultiProfilePagerAdapter.getCurrentUserHandle());
        if (directShareAppPredictor == null || !(targetInfo instanceof ChooserTargetInfo)) {
            return;
        }
        ChooserTarget chooserTarget = ((ChooserTargetInfo) targetInfo).getChooserTarget();
        AppTarget appTarget = null;
        Map<ChooserTarget, AppTarget> map = this.mDirectShareAppTargetCache;
        if (map != null) {
            AppTarget appTarget2 = map.get(chooserTarget);
            appTarget = appTarget2;
        }
        if (appTarget != null) {
            directShareAppPredictor.notifyAppTargetEvent(new AppTargetEvent.Builder(appTarget, 1).setLaunchLocation(LAUNCH_LOCATION_DIRECT_SHARE).build());
        }
    }

    private AppPredictor createAppPredictor(UserHandle userHandle) {
        if (!this.mIsAppPredictorComponentAvailable) {
            return null;
        }
        if (getPersonalProfileUserHandle().equals(userHandle)) {
            AppPredictor appPredictor = this.mPersonalAppPredictor;
            if (appPredictor != null) {
                return appPredictor;
            }
        } else {
            AppPredictor appPredictor2 = this.mWorkAppPredictor;
            if (appPredictor2 != null) {
                return appPredictor2;
            }
        }
        Context contextAsUser = createContextAsUser(userHandle, 0);
        IntentFilter filter = getTargetIntentFilter();
        Bundle extras = new Bundle();
        extras.putParcelable("intent_filter", filter);
        populateTextContent(extras);
        AppPredictionContext appPredictionContext = new AppPredictionContext.Builder(contextAsUser).setUiSurface(APP_PREDICTION_SHARE_UI_SURFACE).setPredictedTargetCount(20).setExtras(extras).build();
        AppPredictionManager appPredictionManager = (AppPredictionManager) contextAsUser.getSystemService(AppPredictionManager.class);
        AppPredictor appPredictionSession = appPredictionManager.createAppPredictionSession(appPredictionContext);
        if (getPersonalProfileUserHandle().equals(userHandle)) {
            this.mPersonalAppPredictor = appPredictionSession;
        } else {
            this.mWorkAppPredictor = appPredictionSession;
        }
        return appPredictionSession;
    }

    private void populateTextContent(Bundle extras) {
        Intent intent = getTargetIntent();
        String sharedText = intent.getStringExtra("android.intent.extra.TEXT");
        extras.putString(SHARED_TEXT_KEY, sharedText);
    }

    private AppPredictor getAppPredictorForDirectShareIfEnabled(UserHandle userHandle) {
        if (ActivityManager.isLowRamDeviceStatic()) {
            return null;
        }
        return createAppPredictor(userHandle);
    }

    private AppPredictor getAppPredictorForShareActivitiesIfEnabled(UserHandle userHandle) {
        if (getCloneProfileUserHandle() == null) {
            return createAppPredictor(userHandle);
        }
        return null;
    }

    void onRefinementResult(TargetInfo selectedTarget, Intent matchingIntent) {
        RefinementResultReceiver refinementResultReceiver = this.mRefinementResultReceiver;
        if (refinementResultReceiver != null) {
            refinementResultReceiver.destroy();
            this.mRefinementResultReceiver = null;
        }
        if (selectedTarget == null) {
            Log.e(TAG, "Refinement result intent did not match any known targets; canceling");
        } else if (!checkTargetSourceIntent(selectedTarget, matchingIntent)) {
            Log.e(TAG, "onRefinementResult: Selected target " + ((Object) selectedTarget) + " cannot match refined source intent " + ((Object) matchingIntent));
        } else {
            TargetInfo clonedTarget = selectedTarget.cloneFilledIn(matchingIntent, 0);
            if (super.onTargetSelected(clonedTarget, false)) {
                updateModelAndChooserCounts(clonedTarget);
                finish();
                return;
            }
        }
        onRefinementCanceled();
    }

    void onRefinementCanceled() {
        RefinementResultReceiver refinementResultReceiver = this.mRefinementResultReceiver;
        if (refinementResultReceiver != null) {
            refinementResultReceiver.destroy();
            this.mRefinementResultReceiver = null;
        }
        finish();
    }

    boolean checkTargetSourceIntent(TargetInfo target, Intent matchingIntent) {
        List<Intent> targetIntents = target.getAllSourceIntents();
        int N = targetIntents.size();
        for (int i10 = 0; i10 < N; i10++) {
            Intent targetIntent = targetIntents.get(i10);
            if (targetIntent.filterEquals(matchingIntent)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    static class AzInfoComparator implements Comparator<DisplayResolveInfo> {
        Comparator<DisplayResolveInfo> mComparator;

        /* JADX INFO: Access modifiers changed from: package-private */
        public AzInfoComparator(Context context) {
            Collator collator = Collator.getInstance(context.getResources().getConfiguration().locale);
            this.mComparator = Comparator.comparing(new Function() { // from class: com.android.internal.app.ChooserActivity$AzInfoComparator$$ExternalSyntheticLambda0
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    return ((DisplayResolveInfo) obj).getDisplayLabel();
                }
            }, collator).thenComparingInt(new ToIntFunction() { // from class: com.android.internal.app.ChooserActivity$AzInfoComparator$$ExternalSyntheticLambda1
                @Override // java.util.function.ToIntFunction
                public final int applyAsInt(Object obj) {
                    int identifier;
                    identifier = ResolverActivity.getResolveInfoUserHandle(((DisplayResolveInfo) obj).getResolveInfo(), UserHandle.SYSTEM).getIdentifier();
                    return identifier;
                }
            });
        }

        @Override // java.util.Comparator
        public int compare(DisplayResolveInfo lhsp, DisplayResolveInfo rhsp) {
            return this.mComparator.compare(lhsp, rhsp);
        }
    }

    protected MetricsLogger getMetricsLogger() {
        if (this.mMetricsLogger == null) {
            this.mMetricsLogger = new MetricsLogger();
        }
        return this.mMetricsLogger;
    }

    protected ChooserActivityLogger getChooserActivityLogger() {
        if (this.mChooserActivityLogger == null) {
            this.mChooserActivityLogger = new ChooserActivityLoggerImpl();
        }
        return this.mChooserActivityLogger;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public class ChooserListController extends ResolverListController {
        public ChooserListController(Context context, PackageManager pm, Intent targetIntent, String referrerPackageName, int launchedFromUid, UserHandle userId, AbstractResolverComparator resolverComparator, UserHandle queryIntentsAsUser) {
            super(context, pm, targetIntent, referrerPackageName, launchedFromUid, userId, resolverComparator, queryIntentsAsUser);
        }

        @Override // com.android.internal.app.ResolverListController
        boolean isComponentFiltered(ComponentName name) {
            if (ChooserActivity.this.mFilteredComponentNames == null) {
                return false;
            }
            for (ComponentName filteredComponentName : ChooserActivity.this.mFilteredComponentNames) {
                if (name.equals(filteredComponentName)) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.android.internal.app.ResolverListController
        public boolean isComponentPinned(ComponentName name) {
            return ChooserActivity.this.mPinnedSharedPrefs.getBoolean(name.flattenToString(), false);
        }

        @Override // com.android.internal.app.ResolverListController
        public boolean isFixedAtTop(ComponentName name) {
            return name != null && name.equals(ChooserActivity.this.getNearbySharingComponent()) && ChooserActivity.this.shouldNearbyShareBeFirstInRankedRow();
        }
    }

    public ChooserGridAdapter createChooserGridAdapter(Context context, List<Intent> payloadIntents, Intent[] initialIntents, List<ResolveInfo> rList, boolean filterLastUsed, UserHandle userHandle) {
        ChooserListAdapter chooserListAdapter = createChooserListAdapter(context, payloadIntents, initialIntents, rList, filterLastUsed, userHandle);
        AppPredictor.Callback appPredictorCallback = createAppPredictorCallback(chooserListAdapter);
        AppPredictor appPredictor = setupAppPredictorForUser(userHandle, appPredictorCallback);
        chooserListAdapter.setAppPredictor(appPredictor);
        chooserListAdapter.setAppPredictorCallback(appPredictorCallback);
        return new ChooserGridAdapter(chooserListAdapter);
    }

    public ChooserListAdapter createChooserListAdapter(Context context, List<Intent> payloadIntents, Intent[] initialIntents, List<ResolveInfo> rList, boolean filterLastUsed, UserHandle userHandle) {
        UserHandle initialIntentsUserSpace;
        if (!isLaunchedAsCloneProfile() || !userHandle.equals(getPersonalProfileUserHandle())) {
            initialIntentsUserSpace = userHandle;
        } else {
            initialIntentsUserSpace = getCloneProfileUserHandle();
        }
        return new ChooserListAdapter(context, payloadIntents, initialIntents, rList, filterLastUsed, createListController(userHandle), this, this, context.getPackageManager(), getChooserActivityLogger(), initialIntentsUserSpace);
    }

    @Override // com.android.internal.app.ResolverActivity
    protected ResolverListController createListController(UserHandle userHandle) {
        AbstractResolverComparator resolverComparator;
        AppPredictor appPredictor = getAppPredictorForShareActivitiesIfEnabled(userHandle);
        if (appPredictor != null) {
            resolverComparator = new AppPredictionServiceResolverComparator(this, getTargetIntent(), getReferrerPackageName(), appPredictor, userHandle, getChooserActivityLogger());
        } else {
            resolverComparator = new ResolverRankerServiceResolverComparator(this, getTargetIntent(), getReferrerPackageName(), (AbstractResolverComparator.AfterCompute) null, getChooserActivityLogger(), getResolverRankerServiceUserHandleList(userHandle));
        }
        UserHandle queryIntentsUser = getQueryIntentsUser(userHandle);
        return new ChooserListController(this, this.mPm, getTargetIntent(), getReferrerPackageName(), this.mLaunchedFromUid, userHandle, resolverComparator, queryIntentsUser == null ? userHandle : queryIntentsUser);
    }

    protected Bitmap loadThumbnail(Uri uri, Size size) {
        if (uri == null || size == null) {
            return null;
        }
        try {
            if (!getResolverWrapper().getResolverActivityExt().isOriginUi()) {
                Bitmap bitmap = getContentResolver().loadThumbnail(uri, size, null);
                return getResolverWrapper().getResolverActivityExt().orientationThumbnailBitmap(getContentResolver(), uri, bitmap);
            }
            return getContentResolver().loadThumbnail(uri, size, null);
        } catch (IOException | NullPointerException | SecurityException e2) {
            logContentPreviewWarning(uri);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static final class PlaceHolderTargetInfo extends NotSelectableTargetInfo {
        @Override // com.android.internal.app.chooser.TargetInfo
        public Drawable getDisplayIcon(Context context) {
            AnimatedVectorDrawable avd = (AnimatedVectorDrawable) context.getDrawable(17302120);
            avd.start();
            return avd;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static final class EmptyTargetInfo extends NotSelectableTargetInfo {
        @Override // com.android.internal.app.chooser.TargetInfo
        public Drawable getDisplayIcon(Context context) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleScroll(View view, int x10, int y10, int oldx, int oldy) {
        if (this.mChooserMultiProfilePagerAdapter.getCurrentRootAdapter() != null) {
            this.mChooserMultiProfilePagerAdapter.getCurrentRootAdapter().handleScroll(view, y10, oldy);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleLayoutChange(View v2, int left, final int top, int right, final int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
        ChooserMultiProfilePagerAdapter chooserMultiProfilePagerAdapter = this.mChooserMultiProfilePagerAdapter;
        if (chooserMultiProfilePagerAdapter == null) {
            return;
        }
        final RecyclerView recyclerView = chooserMultiProfilePagerAdapter.getActiveAdapterView();
        final ChooserGridAdapter gridAdapter = this.mChooserMultiProfilePagerAdapter.getCurrentRootAdapter();
        if (gridAdapter == null || recyclerView == null || recyclerView.computeVerticalScrollOffset() != 0) {
            return;
        }
        int availableWidth = ((right - left) - v2.getPaddingLeft()) - v2.getPaddingRight();
        boolean isLayoutUpdated = gridAdapter.consumeLayoutRequest() || gridAdapter.calculateChooserTargetWidth(availableWidth) || recyclerView.getAdapter() == null || availableWidth != this.mCurrAvailableWidth;
        boolean insetsChanged = !Objects.equals(this.mLastAppliedInsets, this.mSystemWindowInsets);
        if (isLayoutUpdated || insetsChanged || this.mLastNumberOfChildren != recyclerView.getChildCount()) {
            this.mCurrAvailableWidth = availableWidth;
            if (isLayoutUpdated) {
                recyclerView.setAdapter(gridAdapter);
                recyclerView.getLayoutManager().setSpanCount(this.mMaxTargetsPerRow);
                updateTabPadding();
            }
            UserHandle currentUserHandle = this.mChooserMultiProfilePagerAdapter.getCurrentUserHandle();
            int currentProfile = getProfileForUser(currentUserHandle);
            int initialProfile = findSelectedProfile();
            if (currentProfile != initialProfile) {
                return;
            }
            if (this.mLastNumberOfChildren == recyclerView.getChildCount() && !insetsChanged) {
                return;
            }
            getMainThreadHandler().post(new Runnable() { // from class: com.android.internal.app.ChooserActivity$$ExternalSyntheticLambda9
                @Override // java.lang.Runnable
                public final void run() {
                    ChooserActivity.this.lambda$handleLayoutChange$5(gridAdapter, top, bottom, recyclerView);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleLayoutChange$5(ChooserGridAdapter gridAdapter, int top, int bottom, RecyclerView recyclerView) {
        if (this.mResolverDrawerLayout == null || gridAdapter == null) {
            return;
        }
        int offset = calculateDrawerOffset(top, bottom, recyclerView, gridAdapter);
        this.mResolverDrawerLayout.setCollapsibleHeightReserved(offset);
        this.mEnterTransitionAnimationDelegate.markOffsetCalculated();
        this.mLastAppliedInsets = this.mSystemWindowInsets;
    }

    private int calculateDrawerOffset(int top, int bottom, RecyclerView recyclerView, ChooserGridAdapter gridAdapter) {
        int bottomInset = this.mSystemWindowInsets != null ? this.mSystemWindowInsets.bottom : 0;
        int offset = bottomInset;
        int rowsToShow = gridAdapter.getSystemRowCount() + gridAdapter.getProfileRowCount() + gridAdapter.getServiceTargetRowCount() + gridAdapter.getCallerAndRankedTargetRowCount();
        if (rowsToShow == 0) {
            rowsToShow = gridAdapter.getRowCount();
        }
        if (rowsToShow != 0 || shouldShowStickyContentPreview()) {
            View stickyContentPreview = findViewById(16908906);
            if (shouldShowStickyContentPreview() && isStickyContentPreviewShowing()) {
                offset += stickyContentPreview.getHeight();
            }
            if (shouldShowTabs()) {
                offset += findViewById(16908307).getHeight();
            }
            if (recyclerView.getVisibility() == 0) {
                int directShareHeight = 0;
                int rowsToShow2 = Math.min(4, rowsToShow);
                boolean shouldShowExtraRow = shouldShowExtraRow(rowsToShow2);
                this.mLastNumberOfChildren = recyclerView.getChildCount();
                int i10 = 0;
                int childCount = recyclerView.getChildCount();
                while (true) {
                    if (i10 >= childCount || rowsToShow2 <= 0) {
                        break;
                    }
                    View child = recyclerView.getChildAt(i10);
                    if (child.getLayoutParams().getSpanIndex() == 0) {
                        int height = child.getHeight();
                        offset += height;
                        if (shouldShowExtraRow) {
                            offset += height;
                        }
                        if (gridAdapter.getTargetType(recyclerView.getChildAdapterPosition(child)) == 1) {
                            directShareHeight = height;
                        }
                        rowsToShow2--;
                    }
                    i10++;
                }
                boolean isExpandable = getResources().getConfiguration().orientation == 1 && !isInMultiWindowMode();
                if (directShareHeight != 0 && shouldShowContentPreview() && isExpandable) {
                    int requiredExpansionHeight = (int) (directShareHeight / DIRECT_SHARE_EXPANSION_RATE);
                    int topInset = this.mSystemWindowInsets != null ? this.mSystemWindowInsets.top : 0;
                    int minHeight = ((((bottom - top) - this.mResolverDrawerLayout.getAlwaysShowHeight()) - requiredExpansionHeight) - topInset) - bottomInset;
                    offset = Math.min(offset, minHeight);
                }
            } else {
                ViewGroup currentEmptyStateView = getActiveEmptyStateView();
                if (currentEmptyStateView.getVisibility() == 0) {
                    offset += currentEmptyStateView.getHeight();
                }
            }
            return Math.min(offset, bottom - top);
        }
        return offset + getResources().getDimensionPixelSize(17105057);
    }

    private boolean shouldShowExtraRow(int rowsToShow) {
        if (shouldShowTabs() && rowsToShow == 1) {
            ChooserMultiProfilePagerAdapter chooserMultiProfilePagerAdapter = this.mChooserMultiProfilePagerAdapter;
            if (chooserMultiProfilePagerAdapter.shouldShowEmptyStateScreen(chooserMultiProfilePagerAdapter.getInactiveListAdapter())) {
                return true;
            }
        }
        return false;
    }

    private int getProfileForUser(UserHandle currentUserHandle) {
        if (currentUserHandle.equals(getWorkProfileUserHandle())) {
            return 1;
        }
        return 0;
    }

    private ViewGroup getActiveEmptyStateView() {
        int currentPage = this.mChooserMultiProfilePagerAdapter.getCurrentPage();
        return this.mChooserMultiProfilePagerAdapter.getItem(currentPage).getEmptyStateView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class BaseChooserTargetComparator implements Comparator<ChooserTarget> {
        @Override // java.util.Comparator
        public int compare(ChooserTarget lhs, ChooserTarget rhs) {
            return (int) Math.signum(rhs.getScore() - lhs.getScore());
        }
    }

    @Override // com.android.internal.app.ResolverActivity, com.android.internal.app.ResolverListAdapter.ResolverListCommunicator
    public void onHandlePackagesChanged(ResolverListAdapter listAdapter) {
        this.mChooserMultiProfilePagerAdapter.getActiveListAdapter().notifyDataSetChanged();
        super.onHandlePackagesChanged(listAdapter);
    }

    @Override // com.android.internal.app.chooser.SelectableTargetInfo.SelectableTargetInfoCommunicator
    public ResolverListAdapter.ActivityInfoPresentationGetter makePresentationGetter(ActivityInfo info) {
        return this.mChooserMultiProfilePagerAdapter.getActiveListAdapter().makePresentationGetter(info);
    }

    @Override // com.android.internal.app.chooser.SelectableTargetInfo.SelectableTargetInfoCommunicator
    public Intent getReferrerFillInIntent() {
        return this.mReferrerFillInIntent;
    }

    @Override // com.android.internal.app.ChooserListAdapter.ChooserListCommunicator
    public int getMaxRankedTargets() {
        return this.mMaxTargetsPerRow;
    }

    @Override // com.android.internal.app.ChooserListAdapter.ChooserListCommunicator
    public void sendListViewUpdateMessage(UserHandle userHandle) {
        Message msg = Message.obtain();
        msg.what = 6;
        msg.obj = userHandle;
        this.mChooserHandler.sendMessageDelayed(msg, this.mListViewUpdateDelayMs);
    }

    @Override // com.android.internal.app.ResolverActivity
    public void onListRebuilt(ResolverListAdapter listAdapter, boolean rebuildComplete) {
        if (!getResolverWrapper().getResolverActivityExt().isOriginUi()) {
            super.onListRebuilt(listAdapter, rebuildComplete);
            return;
        }
        setupScrollListener();
        maybeSetupGlobalLayoutListener();
        ChooserListAdapter chooserListAdapter = (ChooserListAdapter) listAdapter;
        if (chooserListAdapter.getUserHandle().equals(this.mChooserMultiProfilePagerAdapter.getCurrentUserHandle())) {
            this.mChooserMultiProfilePagerAdapter.getActiveAdapterView().setAdapter(this.mChooserMultiProfilePagerAdapter.getCurrentRootAdapter());
            ChooserMultiProfilePagerAdapter chooserMultiProfilePagerAdapter = this.mChooserMultiProfilePagerAdapter;
            chooserMultiProfilePagerAdapter.setupListAdapter(chooserMultiProfilePagerAdapter.getCurrentPage());
        }
        if (chooserListAdapter.mDisplayList == null || chooserListAdapter.mDisplayList.isEmpty()) {
            chooserListAdapter.notifyDataSetChanged();
        } else {
            chooserListAdapter.updateAlphabeticalList();
        }
        if (rebuildComplete) {
            getChooserActivityLogger().logSharesheetAppLoadComplete();
            maybeQueryAdditionalPostProcessingTargets(chooserListAdapter);
            this.mLatencyTracker.onActionEnd(16);
        }
    }

    private void maybeQueryAdditionalPostProcessingTargets(ChooserListAdapter chooserListAdapter) {
        if (ActivityManager.isLowRamDeviceStatic() || !shouldQueryShortcutManager(chooserListAdapter.getUserHandle())) {
            return;
        }
        Log.d(TAG, "querying direct share targets from ShortcutManager");
        queryDirectShareTargets(chooserListAdapter, false);
    }

    protected boolean isUserRunning(UserHandle userHandle) {
        UserManager userManager = (UserManager) getSystemService(UserManager.class);
        return userManager.isUserRunning(userHandle);
    }

    protected boolean isUserUnlocked(UserHandle userHandle) {
        UserManager userManager = (UserManager) getSystemService(UserManager.class);
        return userManager.isUserUnlocked(userHandle);
    }

    protected boolean isQuietModeEnabled(UserHandle userHandle) {
        UserManager userManager = (UserManager) getSystemService(UserManager.class);
        return userManager.isQuietModeEnabled(userHandle);
    }

    private void setupScrollListener() {
        if (this.mResolverDrawerLayout == null) {
            return;
        }
        int elevatedViewResId = shouldShowTabs() ? 16908307 : 16908878;
        final View elevatedView = this.mResolverDrawerLayout.findViewById(elevatedViewResId);
        final float defaultElevation = elevatedView.getElevation();
        final float chooserHeaderScrollElevation = getResources().getDimensionPixelSize(17105055);
        this.mChooserMultiProfilePagerAdapter.getActiveAdapterView().addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.android.internal.app.ChooserActivity.4
            public void onScrollStateChanged(RecyclerView view, int scrollState) {
                if (scrollState == 0) {
                    if (ChooserActivity.this.mScrollStatus == 1) {
                        ChooserActivity.this.mScrollStatus = 0;
                        ChooserActivity.this.setHorizontalScrollingEnabled(true);
                        return;
                    }
                    return;
                }
                if (scrollState == 1 && ChooserActivity.this.mScrollStatus == 0) {
                    ChooserActivity.this.mScrollStatus = 1;
                    ChooserActivity.this.setHorizontalScrollingEnabled(false);
                }
            }

            public void onScrolled(RecyclerView view, int dx, int dy) {
                View child;
                if (view.getChildCount() > 0 && ((child = view.getLayoutManager().findViewByPosition(0)) == null || child.getTop() < 0)) {
                    elevatedView.setElevation(chooserHeaderScrollElevation);
                } else {
                    elevatedView.setElevation(defaultElevation);
                }
            }
        });
    }

    private void maybeSetupGlobalLayoutListener() {
        if (shouldShowTabs()) {
            return;
        }
        final RecyclerView activeAdapterView = this.mChooserMultiProfilePagerAdapter.getActiveAdapterView();
        activeAdapterView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.android.internal.app.ChooserActivity.5
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                activeAdapterView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                TextView titleView = (TextView) ChooserActivity.this.findViewById(16908310);
                if (titleView != null) {
                    titleView.setFocusable(true);
                    titleView.setFocusableInTouchMode(true);
                    titleView.requestFocus();
                    titleView.requestAccessibilityFocus();
                }
            }
        });
    }

    @Override // com.android.internal.app.ChooserListAdapter.ChooserListCommunicator
    public boolean isSendAction(Intent targetIntent) {
        String action;
        if (targetIntent == null || (action = targetIntent.getAction()) == null) {
            return false;
        }
        if (!"android.intent.action.SEND".equals(action) && !"android.intent.action.SEND_MULTIPLE".equals(action)) {
            return false;
        }
        return true;
    }

    private boolean shouldShowStickyContentPreview() {
        return shouldShowStickyContentPreviewNoOrientationCheck() && !getResources().getBoolean(R.bool.resolver_landscape_phone);
    }

    private boolean shouldShowStickyContentPreviewNoOrientationCheck() {
        return shouldShowTabs() && (this.mMultiProfilePagerAdapter.getListAdapterForUserHandle(UserHandle.of(UserHandle.myUserId())).getCount() > 0 || shouldShowContentPreviewWhenEmpty()) && shouldShowContentPreview();
    }

    protected boolean shouldShowContentPreviewWhenEmpty() {
        return false;
    }

    protected boolean shouldShowContentPreview() {
        return isSendAction(getTargetIntent());
    }

    private void updateStickyContentPreview() {
        if (shouldShowStickyContentPreviewNoOrientationCheck()) {
            ViewGroup contentPreviewContainer = (ViewGroup) findViewById(16908906);
            if (contentPreviewContainer.getChildCount() == 0) {
                ViewGroup contentPreviewView = createContentPreviewView(contentPreviewContainer);
                contentPreviewContainer.addView(contentPreviewView);
            }
        }
        if (shouldShowStickyContentPreview()) {
            showStickyContentPreview();
        } else {
            hideStickyContentPreview();
        }
    }

    private void showStickyContentPreview() {
        if (isStickyContentPreviewShowing()) {
            return;
        }
        ViewGroup contentPreviewContainer = (ViewGroup) findViewById(16908906);
        contentPreviewContainer.setVisibility(0);
    }

    private boolean isStickyContentPreviewShowing() {
        ViewGroup contentPreviewContainer = (ViewGroup) findViewById(16908906);
        return contentPreviewContainer.getVisibility() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideStickyContentPreview() {
        if (!isStickyContentPreviewShowing()) {
            return;
        }
        ViewGroup contentPreviewContainer = (ViewGroup) findViewById(16908906);
        contentPreviewContainer.setVisibility(8);
    }

    private void logActionShareWithPreview() {
        Intent targetIntent = getTargetIntent();
        int previewType = findPreferredContentPreview(targetIntent, getContentResolver());
        getMetricsLogger().write(new LogMaker(MetricsProto.MetricsEvent.ACTION_SHARE_WITH_PREVIEW).setSubtype(previewType));
    }

    private void startFinishAnimation() {
        View rootView = findRootView();
        if (rootView != null) {
            rootView.startAnimation(new FinishAnimation(this, rootView));
        }
    }

    private boolean maybeCancelFinishAnimation() {
        View rootView = findRootView();
        Animation animation = rootView == null ? null : rootView.getAnimation();
        if (animation instanceof FinishAnimation) {
            boolean hasEnded = animation.hasEnded();
            animation.cancel();
            rootView.clearAnimation();
            return !hasEnded;
        }
        return false;
    }

    private View findRootView() {
        if (this.mContentView == null) {
            this.mContentView = findViewById(16908290);
        }
        return this.mContentView;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    static abstract class ViewHolderBase extends RecyclerView.ViewHolder {
        private int mViewType;

        ViewHolderBase(View itemView, int viewType) {
            super(itemView);
            this.mViewType = viewType;
        }

        int getViewType() {
            return this.mViewType;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public final class ItemViewHolder extends ViewHolderBase {
        int mListPosition;
        ResolverListAdapter.ViewHolder mWrappedViewHolder;

        ItemViewHolder(View itemView, boolean isClickable, int viewType) {
            super(itemView, viewType);
            this.mListPosition = -1;
            this.mWrappedViewHolder = new ResolverListAdapter.ViewHolder(itemView);
            if (isClickable) {
                itemView.setOnClickListener(new View.OnClickListener() { // from class: com.android.internal.app.ChooserActivity$ItemViewHolder$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ChooserActivity.ItemViewHolder.this.lambda$new$0(view);
                    }
                });
                itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.android.internal.app.ChooserActivity$ItemViewHolder$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnLongClickListener
                    public final boolean onLongClick(View view) {
                        boolean lambda$new$1;
                        lambda$new$1 = ChooserActivity.ItemViewHolder.this.lambda$new$1(view);
                        return lambda$new$1;
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$0(View v2) {
            ChooserActivity.this.startSelected(this.mListPosition, false, true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ boolean lambda$new$1(View v2) {
            TargetInfo ti = ChooserActivity.this.mChooserMultiProfilePagerAdapter.getActiveListAdapter().targetInfoForPosition(this.mListPosition, true);
            if ((ti instanceof DisplayResolveInfo) && ChooserActivity.this.shouldShowTargetDetails(ti)) {
                ChooserActivity.this.showTargetDetails((DisplayResolveInfo) ti);
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean shouldShowTargetDetails(TargetInfo ti) {
        ComponentName nearbyShare = getNearbySharingComponent();
        boolean isNearbyShare = nearbyShare != null && nearbyShare.equals(ti.getResolvedComponentName()) && shouldNearbyShareBeFirstInRankedRow();
        if (ti instanceof SelectableTargetInfo) {
            return true;
        }
        return (ti instanceof DisplayResolveInfo) && !isNearbyShare;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    static final class FooterViewHolder extends ViewHolderBase {
        FooterViewHolder(View itemView, int viewType) {
            super(itemView, viewType);
        }
    }

    @Override // com.android.internal.app.ResolverActivity
    public void onButtonClick(View v2) {
    }

    @Override // com.android.internal.app.ResolverActivity
    protected void resetButtonBar() {
    }

    @Override // com.android.internal.app.ResolverActivity
    protected String getMetricsCategory() {
        return "intent_chooser";
    }

    @Override // com.android.internal.app.ResolverActivity
    protected void onProfileTabSelected() {
        ChooserGridAdapter currentRootAdapter = this.mChooserMultiProfilePagerAdapter.getCurrentRootAdapter();
        currentRootAdapter.updateDirectShareExpansion();
        setVerticalScrollEnabled(true);
        if (this.mResolverDrawerLayout != null) {
            this.mResolverDrawerLayout.scrollNestedScrollableChildBackToTop();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.android.internal.app.ResolverActivity
    public WindowInsets onApplyWindowInsets(View v2, WindowInsets insets) {
        if (shouldShowTabs()) {
            this.mChooserMultiProfilePagerAdapter.setEmptyStateBottomOffset(insets.getSystemWindowInsetBottom());
            this.mChooserMultiProfilePagerAdapter.setupContainerPadding(getActiveEmptyStateView().findViewById(16909437));
        }
        WindowInsets result = super.onApplyWindowInsets(v2, insets);
        if (this.mResolverDrawerLayout != null) {
            this.mResolverDrawerLayout.requestLayout();
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setHorizontalScrollingEnabled(boolean enabled) {
        ResolverViewPager viewPager = (ResolverViewPager) findViewById(16909399);
        viewPager.setSwipingEnabled(enabled);
    }

    private void setVerticalScrollEnabled(boolean enabled) {
        ChooserGridLayoutManager layoutManager = this.mChooserMultiProfilePagerAdapter.getActiveAdapterView().getLayoutManager();
        layoutManager.setVerticalScrollEnabled(enabled);
    }

    @Override // com.android.internal.app.ResolverActivity
    void onHorizontalSwipeStateChanged(int state) {
        if (state == 1) {
            if (this.mScrollStatus == 0) {
                this.mScrollStatus = 2;
                setVerticalScrollEnabled(false);
                return;
            }
            return;
        }
        if (state == 0 && this.mScrollStatus == 2) {
            this.mScrollStatus = 0;
            setVerticalScrollEnabled(true);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public final class ChooserGridAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private static final int NUM_EXPANSIONS_TO_HIDE_AZ_LABEL = 20;
        private static final int VIEW_TYPE_AZ_LABEL = 4;
        private static final int VIEW_TYPE_CALLER_AND_RANK = 5;
        private static final int VIEW_TYPE_CONTENT_PREVIEW = 2;
        private static final int VIEW_TYPE_DIRECT_SHARE = 0;
        private static final int VIEW_TYPE_FOOTER = 6;
        private static final int VIEW_TYPE_NORMAL = 1;
        private static final int VIEW_TYPE_PROFILE = 3;
        private ChooserListAdapter mChooserListAdapter;
        private DirectShareViewHolder mDirectShareViewHolder;
        private final LayoutInflater mLayoutInflater;
        private boolean mShowAzLabelIfPoss;
        private int mChooserTargetWidth = 0;
        private boolean mLayoutRequested = false;
        private int mFooterHeight = 0;

        ChooserGridAdapter(ChooserListAdapter wrappedAdapter) {
            this.mChooserListAdapter = wrappedAdapter;
            this.mLayoutInflater = LayoutInflater.from(ChooserActivity.this);
            this.mShowAzLabelIfPoss = ChooserActivity.this.getNumSheetExpansions() < 20;
            wrappedAdapter.registerDataSetObserver(new DataSetObserver() { // from class: com.android.internal.app.ChooserActivity.ChooserGridAdapter.1
                @Override // android.database.DataSetObserver
                public void onChanged() {
                    super.onChanged();
                    ChooserGridAdapter.this.notifyDataSetChanged();
                }

                @Override // android.database.DataSetObserver
                public void onInvalidated() {
                    super.onInvalidated();
                    ChooserGridAdapter.this.notifyDataSetChanged();
                }
            });
        }

        public void setFooterHeight(int height) {
            this.mFooterHeight = height;
        }

        public boolean calculateChooserTargetWidth(int width) {
            if (width == 0) {
                return false;
            }
            int maxWidth = ChooserActivity.this.getResources().getDimensionPixelSize(17105064);
            int newWidth = Math.min(maxWidth, width) / ChooserActivity.this.mMaxTargetsPerRow;
            if (newWidth == this.mChooserTargetWidth) {
                return false;
            }
            this.mChooserTargetWidth = newWidth;
            return true;
        }

        public void hideContentPreview() {
            this.mLayoutRequested = true;
            notifyDataSetChanged();
        }

        public boolean consumeLayoutRequest() {
            boolean oldValue = this.mLayoutRequested;
            this.mLayoutRequested = false;
            return oldValue;
        }

        public int getRowCount() {
            return (int) (getSystemRowCount() + getProfileRowCount() + getServiceTargetRowCount() + getCallerAndRankedTargetRowCount() + getAzLabelRowCount() + Math.ceil(this.mChooserListAdapter.getAlphaTargetCount() / ChooserActivity.this.mMaxTargetsPerRow));
        }

        public int getSystemRowCount() {
            ChooserListAdapter chooserListAdapter;
            return (ChooserActivity.this.shouldShowTabs() || !ChooserActivity.this.shouldShowContentPreview() || (chooserListAdapter = this.mChooserListAdapter) == null || chooserListAdapter.getCount() == 0) ? 0 : 1;
        }

        public int getProfileRowCount() {
            return (ChooserActivity.this.shouldShowTabs() || this.mChooserListAdapter.getOtherProfile() == null) ? 0 : 1;
        }

        public int getFooterRowCount() {
            return 1;
        }

        public int getCallerAndRankedTargetRowCount() {
            return (int) Math.ceil((this.mChooserListAdapter.getCallerTargetCount() + this.mChooserListAdapter.getRankedTargetCount()) / ChooserActivity.this.mMaxTargetsPerRow);
        }

        public int getServiceTargetRowCount() {
            if (ChooserActivity.this.shouldShowContentPreview() && !ActivityManager.isLowRamDeviceStatic()) {
                return 1;
            }
            return 0;
        }

        public int getAzLabelRowCount() {
            return (!this.mShowAzLabelIfPoss || this.mChooserListAdapter.getAlphaTargetCount() <= 0) ? 0 : 1;
        }

        public int getItemCount() {
            return getSystemRowCount() + getProfileRowCount() + getServiceTargetRowCount() + getCallerAndRankedTargetRowCount() + getAzLabelRowCount() + this.mChooserListAdapter.getAlphaTargetCount() + getFooterRowCount();
        }

        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            switch (viewType) {
                case 0:
                case 5:
                    return createItemGroupViewHolder(viewType, parent);
                case 1:
                    return new ItemViewHolder(this.mChooserListAdapter.createView(parent), true, viewType);
                case 2:
                    ChooserActivity chooserActivity = ChooserActivity.this;
                    return new ItemViewHolder(chooserActivity.createContentPreviewView(parent), false, viewType);
                case 3:
                    return new ItemViewHolder(createProfileView(parent), false, viewType);
                case 4:
                    return new ItemViewHolder(createAzLabelView(parent), false, viewType);
                case 6:
                    Space sp = new Space(parent.getContext());
                    sp.setLayoutParams(new RecyclerView.LayoutParams(-1, this.mFooterHeight));
                    return new FooterViewHolder(sp, viewType);
                default:
                    return null;
            }
        }

        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            int viewType = ((ViewHolderBase) holder).getViewType();
            switch (viewType) {
                case 0:
                case 5:
                    bindItemGroupViewHolder(position, (ItemGroupViewHolder) holder);
                    return;
                case 1:
                    bindItemViewHolder(position, (ItemViewHolder) holder);
                    return;
                default:
                    return;
            }
        }

        public int getItemViewType(int position) {
            int countSum = getSystemRowCount();
            if (countSum > 0 && position < countSum) {
                return 2;
            }
            int count = getProfileRowCount();
            int countSum2 = countSum + count;
            if (count > 0 && position < countSum2) {
                return 3;
            }
            int count2 = getServiceTargetRowCount();
            int countSum3 = countSum2 + count2;
            if (count2 > 0 && position < countSum3) {
                return 0;
            }
            int count3 = getCallerAndRankedTargetRowCount();
            int countSum4 = countSum3 + count3;
            if (count3 > 0 && position < countSum4) {
                return 5;
            }
            int count4 = getAzLabelRowCount();
            int countSum5 = countSum4 + count4;
            if (count4 <= 0 || position >= countSum5) {
                return position == getItemCount() - 1 ? 6 : 1;
            }
            return 4;
        }

        public int getTargetType(int position) {
            return this.mChooserListAdapter.getPositionTargetType(getListPosition(position));
        }

        private View createProfileView(ViewGroup parent) {
            View profileRow = this.mLayoutInflater.inflate(17367139, parent, false);
            ChooserActivity.this.mProfileView = profileRow.findViewById(16909398);
            View view = ChooserActivity.this.mProfileView;
            final ChooserActivity chooserActivity = ChooserActivity.this;
            view.setOnClickListener(new View.OnClickListener() { // from class: com.android.internal.app.ChooserActivity$ChooserGridAdapter$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ChooserActivity.this.onProfileClick(view2);
                }
            });
            ChooserActivity.this.updateProfileViewButton();
            return profileRow;
        }

        private View createAzLabelView(ViewGroup parent) {
            return this.mLayoutInflater.inflate(17367131, parent, false);
        }

        private ItemGroupViewHolder loadViewsIntoGroup(final ItemGroupViewHolder holder) {
            int spec = View.MeasureSpec.makeMeasureSpec(0, 0);
            int exactSpec = View.MeasureSpec.makeMeasureSpec(this.mChooserTargetWidth, 1073741824);
            int columnCount = holder.getColumnCount();
            boolean isDirectShare = holder instanceof DirectShareViewHolder;
            for (int i10 = 0; i10 < columnCount; i10++) {
                View v2 = this.mChooserListAdapter.createView(holder.getRowByIndex(i10));
                final int column = i10;
                v2.setOnClickListener(new View.OnClickListener() { // from class: com.android.internal.app.ChooserActivity.ChooserGridAdapter.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View v10) {
                        ChooserActivity.this.startSelected(holder.getItemIndex(column), false, true);
                    }
                });
                v2.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.android.internal.app.ChooserActivity$ChooserGridAdapter$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnLongClickListener
                    public final boolean onLongClick(View view) {
                        boolean lambda$loadViewsIntoGroup$0;
                        lambda$loadViewsIntoGroup$0 = ChooserActivity.ChooserGridAdapter.this.lambda$loadViewsIntoGroup$0(holder, column, view);
                        return lambda$loadViewsIntoGroup$0;
                    }
                });
                holder.addView(i10, v2);
                if (isDirectShare) {
                    ResolverListAdapter.ViewHolder vh = (ResolverListAdapter.ViewHolder) v2.getTag();
                    vh.text.setLines(2);
                    vh.text.setHorizontallyScrolling(false);
                    vh.text2.setVisibility(8);
                }
                v2.measure(exactSpec, spec);
                setViewBounds(v2, v2.getMeasuredWidth(), v2.getMeasuredHeight());
            }
            ViewGroup viewGroup = holder.getViewGroup();
            holder.measure();
            setViewBounds(viewGroup, -1, holder.getMeasuredRowHeight());
            if (isDirectShare) {
                DirectShareViewHolder dsvh = (DirectShareViewHolder) holder;
                setViewBounds(dsvh.getRow(0), -1, dsvh.getMinRowHeight());
                setViewBounds(dsvh.getRow(1), -1, dsvh.getMinRowHeight());
            }
            viewGroup.setTag(holder);
            return holder;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ boolean lambda$loadViewsIntoGroup$0(ItemGroupViewHolder holder, int column, View v12) {
            TargetInfo ti = this.mChooserListAdapter.targetInfoForPosition(holder.getItemIndex(column), true);
            if (ChooserActivity.this.shouldShowTargetDetails(ti)) {
                ChooserActivity.this.showTargetDetails(ti);
            }
            return true;
        }

        private void setViewBounds(View view, int widthPx, int heightPx) {
            ViewGroup.LayoutParams lp = view.getLayoutParams();
            if (lp == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(widthPx, heightPx));
            } else {
                lp.height = heightPx;
                lp.width = widthPx;
            }
        }

        ItemGroupViewHolder createItemGroupViewHolder(int viewType, ViewGroup parent) {
            if (viewType != 0) {
                ViewGroup row = (ViewGroup) this.mLayoutInflater.inflate(17367140, parent, false);
                ItemGroupViewHolder holder = new SingleRowViewHolder(row, ChooserActivity.this.mMaxTargetsPerRow, viewType);
                loadViewsIntoGroup(holder);
                return holder;
            }
            ViewGroup parentGroup = (ViewGroup) this.mLayoutInflater.inflate(17367141, parent, false);
            ViewGroup row1 = (ViewGroup) this.mLayoutInflater.inflate(17367140, parentGroup, false);
            ViewGroup row2 = (ViewGroup) this.mLayoutInflater.inflate(17367140, parentGroup, false);
            parentGroup.addView(row1);
            parentGroup.addView(row2);
            ArrayList newArrayList = Lists.newArrayList(new ViewGroup[]{row1, row2});
            int i10 = ChooserActivity.this.mMaxTargetsPerRow;
            final ChooserMultiProfilePagerAdapter chooserMultiProfilePagerAdapter = ChooserActivity.this.mChooserMultiProfilePagerAdapter;
            Objects.requireNonNull(chooserMultiProfilePagerAdapter);
            DirectShareViewHolder directShareViewHolder = new DirectShareViewHolder(parentGroup, newArrayList, i10, viewType, new Supplier() { // from class: com.android.internal.app.ChooserActivity$ChooserGridAdapter$$ExternalSyntheticLambda0
                @Override // java.util.function.Supplier
                public final Object get() {
                    return ChooserMultiProfilePagerAdapter.this.getActiveListAdapter();
                }
            });
            this.mDirectShareViewHolder = directShareViewHolder;
            loadViewsIntoGroup(directShareViewHolder);
            return this.mDirectShareViewHolder;
        }

        int getRowType(int rowPosition) {
            int positionType = this.mChooserListAdapter.getPositionTargetType(rowPosition);
            if (positionType == 0) {
                return 2;
            }
            if (getAzLabelRowCount() > 0 && positionType == 3) {
                return 2;
            }
            return positionType;
        }

        void bindItemViewHolder(int position, ItemViewHolder holder) {
            View v2 = holder.itemView;
            int listPosition = getListPosition(position);
            holder.mListPosition = listPosition;
            this.mChooserListAdapter.bindView(listPosition, v2);
        }

        void bindItemGroupViewHolder(int position, ItemGroupViewHolder holder) {
            ViewGroup viewGroup = (ViewGroup) holder.itemView;
            int start = getListPosition(position);
            int startType = getRowType(start);
            int columnCount = holder.getColumnCount();
            int end = (start + columnCount) - 1;
            while (getRowType(end) != startType && end >= start) {
                end--;
            }
            if (end == start && (this.mChooserListAdapter.getItem(start) instanceof EmptyTargetInfo)) {
                TextView textView = (TextView) viewGroup.findViewById(16908880);
                if (textView.getVisibility() != 0) {
                    textView.setAlpha(0.0f);
                    textView.setVisibility(0);
                    textView.setText(17039845);
                    ValueAnimator fadeAnim = ObjectAnimator.ofFloat(textView, Key.ALPHA, 0.0f, 1.0f);
                    fadeAnim.setInterpolator(new DecelerateInterpolator(1.0f));
                    float translationInPx = ChooserActivity.this.getResources().getDimensionPixelSize(17105062);
                    textView.setTranslationY(translationInPx);
                    ValueAnimator translateAnim = ObjectAnimator.ofFloat(textView, Key.TRANSLATION_Y, 0.0f);
                    translateAnim.setInterpolator(new DecelerateInterpolator(1.0f));
                    AnimatorSet animSet = new AnimatorSet();
                    animSet.setDuration(200L);
                    animSet.setStartDelay(200L);
                    animSet.playTogether(fadeAnim, translateAnim);
                    animSet.start();
                }
            }
            for (int i10 = 0; i10 < columnCount; i10++) {
                View v2 = holder.getView(i10);
                if (start + i10 <= end) {
                    holder.setViewVisibility(i10, 0);
                    holder.setItemIndex(i10, start + i10);
                    this.mChooserListAdapter.bindView(holder.getItemIndex(i10), v2);
                } else {
                    holder.setViewVisibility(i10, 4);
                }
            }
        }

        int getListPosition(int position) {
            int position2 = position - (getSystemRowCount() + getProfileRowCount());
            int serviceCount = this.mChooserListAdapter.getServiceTargetCount();
            int serviceRows = (int) Math.ceil(serviceCount / ChooserActivity.this.getMaxRankedTargets());
            if (position2 < serviceRows) {
                return ChooserActivity.this.mMaxTargetsPerRow * position2;
            }
            int position3 = position2 - serviceRows;
            int callerAndRankedCount = this.mChooserListAdapter.getCallerTargetCount() + this.mChooserListAdapter.getRankedTargetCount();
            int callerAndRankedRows = getCallerAndRankedTargetRowCount();
            if (position3 < callerAndRankedRows) {
                return (ChooserActivity.this.mMaxTargetsPerRow * position3) + serviceCount;
            }
            return callerAndRankedCount + serviceCount + (position3 - (getAzLabelRowCount() + callerAndRankedRows));
        }

        public void handleScroll(View v2, int y10, int oldy) {
            boolean canExpandDirectShare = canExpandDirectShare();
            DirectShareViewHolder directShareViewHolder = this.mDirectShareViewHolder;
            if (directShareViewHolder != null && canExpandDirectShare) {
                directShareViewHolder.handleScroll(ChooserActivity.this.mChooserMultiProfilePagerAdapter.getActiveAdapterView(), y10, oldy, ChooserActivity.this.mMaxTargetsPerRow);
            }
        }

        private boolean canExpandDirectShare() {
            return false;
        }

        public ChooserListAdapter getListAdapter() {
            return this.mChooserListAdapter;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean shouldCellSpan(int position) {
            return getItemViewType(position) == 1;
        }

        void updateDirectShareExpansion() {
            if (this.mDirectShareViewHolder == null || !canExpandDirectShare()) {
                return;
            }
            RecyclerView activeAdapterView = ChooserActivity.this.mChooserMultiProfilePagerAdapter.getActiveAdapterView();
            if (ChooserActivity.this.mResolverDrawerLayout.isCollapsed()) {
                this.mDirectShareViewHolder.collapse(activeAdapterView);
            } else {
                this.mDirectShareViewHolder.expand(activeAdapterView);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static abstract class ItemGroupViewHolder extends ViewHolderBase {
        protected final View[] mCells;
        private final int mColumnCount;
        private int[] mItemIndices;
        protected int mMeasuredRowHeight;

        abstract ViewGroup addView(int i10, View view);

        abstract ViewGroup getRow(int i10);

        abstract ViewGroup getRowByIndex(int i10);

        abstract ViewGroup getViewGroup();

        abstract void setViewVisibility(int i10, int i11);

        ItemGroupViewHolder(int cellCount, View itemView, int viewType) {
            super(itemView, viewType);
            this.mCells = new View[cellCount];
            this.mItemIndices = new int[cellCount];
            this.mColumnCount = cellCount;
        }

        public int getColumnCount() {
            return this.mColumnCount;
        }

        public void measure() {
            int spec = View.MeasureSpec.makeMeasureSpec(0, 0);
            getViewGroup().measure(spec, spec);
            this.mMeasuredRowHeight = getViewGroup().getMeasuredHeight();
        }

        public int getMeasuredRowHeight() {
            return this.mMeasuredRowHeight;
        }

        public void setItemIndex(int itemIndex, int listIndex) {
            this.mItemIndices[itemIndex] = listIndex;
        }

        public int getItemIndex(int itemIndex) {
            return this.mItemIndices[itemIndex];
        }

        public View getView(int index) {
            return this.mCells[index];
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class SingleRowViewHolder extends ItemGroupViewHolder {
        private final ViewGroup mRow;

        SingleRowViewHolder(ViewGroup row, int cellCount, int viewType) {
            super(cellCount, row, viewType);
            this.mRow = row;
        }

        @Override // com.android.internal.app.ChooserActivity.ItemGroupViewHolder
        public ViewGroup getViewGroup() {
            return this.mRow;
        }

        @Override // com.android.internal.app.ChooserActivity.ItemGroupViewHolder
        public ViewGroup getRowByIndex(int index) {
            return this.mRow;
        }

        @Override // com.android.internal.app.ChooserActivity.ItemGroupViewHolder
        public ViewGroup getRow(int rowNumber) {
            if (rowNumber == 0) {
                return this.mRow;
            }
            return null;
        }

        @Override // com.android.internal.app.ChooserActivity.ItemGroupViewHolder
        public ViewGroup addView(int index, View v2) {
            this.mRow.addView(v2);
            this.mCells[index] = v2;
            return this.mRow;
        }

        @Override // com.android.internal.app.ChooserActivity.ItemGroupViewHolder
        public void setViewVisibility(int i10, int visibility) {
            getView(i10).setVisibility(visibility);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class DirectShareViewHolder extends ItemGroupViewHolder {
        private int mCellCountPerRow;
        private final boolean[] mCellVisibility;
        private int mDirectShareCurrHeight;
        private int mDirectShareMaxHeight;
        private int mDirectShareMinHeight;
        private boolean mHideDirectShareExpansion;
        private final Supplier<ChooserListAdapter> mListAdapterSupplier;
        private final ViewGroup mParent;
        private final List<ViewGroup> mRows;

        DirectShareViewHolder(ViewGroup parent, List<ViewGroup> rows, int cellCountPerRow, int viewType, Supplier<ChooserListAdapter> listAdapterSupplier) {
            super(rows.size() * cellCountPerRow, parent, viewType);
            this.mHideDirectShareExpansion = false;
            this.mDirectShareMinHeight = 0;
            this.mDirectShareCurrHeight = 0;
            this.mDirectShareMaxHeight = 0;
            this.mParent = parent;
            this.mRows = rows;
            this.mCellCountPerRow = cellCountPerRow;
            boolean[] zArr = new boolean[rows.size() * cellCountPerRow];
            this.mCellVisibility = zArr;
            Arrays.fill(zArr, true);
            this.mListAdapterSupplier = listAdapterSupplier;
        }

        @Override // com.android.internal.app.ChooserActivity.ItemGroupViewHolder
        public ViewGroup addView(int index, View v2) {
            ViewGroup row = getRowByIndex(index);
            row.addView(v2);
            this.mCells[index] = v2;
            return row;
        }

        @Override // com.android.internal.app.ChooserActivity.ItemGroupViewHolder
        public ViewGroup getViewGroup() {
            return this.mParent;
        }

        @Override // com.android.internal.app.ChooserActivity.ItemGroupViewHolder
        public ViewGroup getRowByIndex(int index) {
            return this.mRows.get(index / this.mCellCountPerRow);
        }

        @Override // com.android.internal.app.ChooserActivity.ItemGroupViewHolder
        public ViewGroup getRow(int rowNumber) {
            return this.mRows.get(rowNumber);
        }

        @Override // com.android.internal.app.ChooserActivity.ItemGroupViewHolder
        public void measure() {
            int spec = View.MeasureSpec.makeMeasureSpec(0, 0);
            getRow(0).measure(spec, spec);
            getRow(1).measure(spec, spec);
            int measuredHeight = getRow(0).getMeasuredHeight();
            this.mDirectShareMinHeight = measuredHeight;
            int i10 = this.mDirectShareCurrHeight;
            if (i10 <= 0) {
                i10 = measuredHeight;
            }
            this.mDirectShareCurrHeight = i10;
            this.mDirectShareMaxHeight = measuredHeight * 2;
        }

        @Override // com.android.internal.app.ChooserActivity.ItemGroupViewHolder
        public int getMeasuredRowHeight() {
            return this.mDirectShareCurrHeight;
        }

        public int getMinRowHeight() {
            return this.mDirectShareMinHeight;
        }

        @Override // com.android.internal.app.ChooserActivity.ItemGroupViewHolder
        public void setViewVisibility(int i10, int visibility) {
            final View v2 = getView(i10);
            if (visibility == 0) {
                this.mCellVisibility[i10] = true;
                v2.setVisibility(visibility);
                v2.setAlpha(1.0f);
            } else if (visibility == 4) {
                boolean[] zArr = this.mCellVisibility;
                if (zArr[i10]) {
                    zArr[i10] = false;
                    ValueAnimator fadeAnim = ObjectAnimator.ofFloat(v2, Key.ALPHA, 1.0f, 0.0f);
                    fadeAnim.setDuration(200L);
                    fadeAnim.setInterpolator(new AccelerateInterpolator(1.0f));
                    fadeAnim.addListener(new AnimatorListenerAdapter() { // from class: com.android.internal.app.ChooserActivity.DirectShareViewHolder.1
                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animation) {
                            v2.setVisibility(4);
                        }
                    });
                    fadeAnim.start();
                }
            }
        }

        public void handleScroll(RecyclerView view, int y10, int oldy, int maxTargetsPerRow) {
            boolean notExpanded = this.mDirectShareCurrHeight == this.mDirectShareMinHeight;
            if (notExpanded) {
                if (this.mHideDirectShareExpansion) {
                    return;
                }
                ChooserListAdapter adapter = this.mListAdapterSupplier.get();
                int validTargets = adapter.getSelectableServiceTargetCount();
                if (validTargets <= maxTargetsPerRow) {
                    this.mHideDirectShareExpansion = true;
                    return;
                }
            }
            int yDiff = (int) ((oldy - y10) * ChooserActivity.DIRECT_SHARE_EXPANSION_RATE);
            int prevHeight = this.mDirectShareCurrHeight;
            int newHeight = Math.max(Math.min(prevHeight + yDiff, this.mDirectShareMaxHeight), this.mDirectShareMinHeight);
            int yDiff2 = newHeight - prevHeight;
            updateDirectShareRowHeight(view, yDiff2, newHeight);
        }

        void expand(RecyclerView view) {
            int i10 = this.mDirectShareMaxHeight;
            updateDirectShareRowHeight(view, i10 - this.mDirectShareCurrHeight, i10);
        }

        void collapse(RecyclerView view) {
            int i10 = this.mDirectShareMinHeight;
            updateDirectShareRowHeight(view, i10 - this.mDirectShareCurrHeight, i10);
        }

        private void updateDirectShareRowHeight(RecyclerView view, int yDiff, int newHeight) {
            if (view == null || view.getChildCount() == 0 || yDiff == 0) {
                return;
            }
            boolean foundExpansion = false;
            for (int i10 = 0; i10 < view.getChildCount(); i10++) {
                View child = view.getChildAt(i10);
                if (foundExpansion) {
                    child.offsetTopAndBottom(yDiff);
                } else if (child.getTag() != null && (child.getTag() instanceof DirectShareViewHolder)) {
                    int widthSpec = View.MeasureSpec.makeMeasureSpec(child.getWidth(), 1073741824);
                    int heightSpec = View.MeasureSpec.makeMeasureSpec(newHeight, 1073741824);
                    child.measure(widthSpec, heightSpec);
                    child.getLayoutParams().height = child.getMeasuredHeight();
                    child.layout(child.getLeft(), child.getTop(), child.getRight(), child.getTop() + child.getMeasuredHeight());
                    foundExpansion = true;
                }
            }
            if (foundExpansion) {
                this.mDirectShareCurrHeight = newHeight;
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class ServiceResultInfo {
        public final DisplayResolveInfo originalTarget;
        public final List<ChooserTarget> resultTargets;
        public final UserHandle userHandle;

        public ServiceResultInfo(DisplayResolveInfo ot, List<ChooserTarget> rt, UserHandle userHandle) {
            this.originalTarget = ot;
            this.resultTargets = rt;
            this.userHandle = userHandle;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    static class ChooserTargetRankingInfo {
        public final List<AppTarget> scores;
        public final UserHandle userHandle;

        ChooserTargetRankingInfo(List<AppTarget> chooserTargetScores, UserHandle userHandle) {
            this.scores = chooserTargetScores;
            this.userHandle = userHandle;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class RefinementResultReceiver extends ResultReceiver {
        private ChooserActivity mChooserActivity;
        private TargetInfo mSelectedTarget;

        public RefinementResultReceiver(ChooserActivity host, TargetInfo target, Handler handler) {
            super(handler);
            this.mChooserActivity = host;
            this.mSelectedTarget = target;
        }

        @Override // android.os.ResultReceiver
        protected void onReceiveResult(int resultCode, Bundle resultData) {
            ChooserActivity chooserActivity = this.mChooserActivity;
            if (chooserActivity == null) {
                Log.e(ChooserActivity.TAG, "Destroyed RefinementResultReceiver received a result");
                return;
            }
            if (resultData == null) {
                Log.e(ChooserActivity.TAG, "RefinementResultReceiver received null resultData");
                return;
            }
            switch (resultCode) {
                case -1:
                    Parcelable intentParcelable = resultData.getParcelable("android.intent.extra.INTENT");
                    if (intentParcelable instanceof Intent) {
                        this.mChooserActivity.onRefinementResult(this.mSelectedTarget, (Intent) intentParcelable);
                        return;
                    } else {
                        Log.e(ChooserActivity.TAG, "RefinementResultReceiver received RESULT_OK but no Intent in resultData with key Intent.EXTRA_INTENT");
                        return;
                    }
                case 0:
                    chooserActivity.onRefinementCanceled();
                    return;
                default:
                    Log.w(ChooserActivity.TAG, "Unknown result code " + resultCode + " sent to RefinementResultReceiver");
                    return;
            }
        }

        public void destroy() {
            this.mChooserActivity = null;
            this.mSelectedTarget = null;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class RoundedRectImageView extends ImageView {
        private String mExtraImageCount;
        private Paint mOverlayPaint;
        private Path mPath;
        private int mRadius;
        private Paint mRoundRectPaint;
        private Paint mTextPaint;

        public RoundedRectImageView(Context context) {
            super(context);
            this.mRadius = 0;
            this.mPath = new Path();
            this.mOverlayPaint = new Paint(0);
            this.mRoundRectPaint = new Paint(0);
            this.mTextPaint = new Paint(1);
            this.mExtraImageCount = null;
        }

        public RoundedRectImageView(Context context, AttributeSet attrs) {
            this(context, attrs, 0);
        }

        public RoundedRectImageView(Context context, AttributeSet attrs, int defStyleAttr) {
            this(context, attrs, defStyleAttr, 0);
        }

        public RoundedRectImageView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
            super(context, attrs, defStyleAttr, defStyleRes);
            this.mRadius = 0;
            this.mPath = new Path();
            this.mOverlayPaint = new Paint(0);
            this.mRoundRectPaint = new Paint(0);
            this.mTextPaint = new Paint(1);
            this.mExtraImageCount = null;
            this.mRadius = context.getResources().getDimensionPixelSize(17105050);
            this.mOverlayPaint.setColor(-1728053248);
            this.mOverlayPaint.setStyle(Paint.Style.FILL);
            this.mRoundRectPaint.setColor(context.getResources().getColor(17170916));
            this.mRoundRectPaint.setStyle(Paint.Style.STROKE);
            this.mRoundRectPaint.setStrokeWidth(context.getResources().getDimensionPixelSize(17105058));
            this.mTextPaint.setColor(-1);
            this.mTextPaint.setTextSize(context.getResources().getDimensionPixelSize(17105059));
            if (this.mContext instanceof ChooserActivity) {
                ((ChooserActivity) this.mContext).getResolverWrapper().getResolverActivityExt().setCustomRoundImage(this.mRoundRectPaint, this.mTextPaint, this.mOverlayPaint);
            }
            this.mRoundRectPaint.setAntiAlias(true);
            this.mTextPaint.setTextAlign(Paint.Align.CENTER);
        }

        private void updatePath(int width, int height) {
            this.mPath.reset();
            int imageWidth = (width - getPaddingRight()) - getPaddingLeft();
            int imageHeight = (height - getPaddingBottom()) - getPaddingTop();
            int i10 = this.mRadius;
            this.mPath.addRoundRect(getPaddingLeft(), getPaddingTop(), imageWidth, imageHeight, i10, i10, Path.Direction.CW);
        }

        public void setRadius(int radius) {
            this.mRadius = radius;
            updatePath(getWidth(), getHeight());
        }

        public void setExtraImageCount(int count) {
            if (count > 0) {
                if ((this.mContext instanceof ChooserActivity) && ((ChooserActivity) this.mContext).getResolverWrapper().getResolverActivityExt().isOriginUi()) {
                    this.mExtraImageCount = " + " + count;
                    return;
                } else {
                    this.mExtraImageCount = BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX + count;
                    return;
                }
            }
            this.mExtraImageCount = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.view.View
        public void onSizeChanged(int width, int height, int oldWidth, int oldHeight) {
            super.onSizeChanged(width, height, oldWidth, oldHeight);
            updatePath(width, height);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.widget.ImageView, android.view.View
        public void onDraw(Canvas canvas) {
            if (this.mRadius != 0) {
                canvas.clipPath(this.mPath);
            }
            super.onDraw(canvas);
            int x10 = getPaddingLeft();
            int y10 = getPaddingRight();
            int width = (getWidth() - getPaddingRight()) - getPaddingLeft();
            int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
            if (this.mExtraImageCount != null) {
                canvas.drawRect(x10, y10, width, height, this.mOverlayPaint);
                int xPos = canvas.getWidth() / 2;
                int yPos = (int) ((canvas.getHeight() / 2.0f) - ((this.mTextPaint.descent() + this.mTextPaint.ascent()) / 2.0f));
                canvas.drawText(this.mExtraImageCount, xPos, yPos, this.mTextPaint);
            }
            int i10 = this.mRadius;
            canvas.drawRoundRect(x10, y10, width, height, i10, i10, this.mRoundRectPaint);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public class EnterTransitionAnimationDelegate implements View.OnLayoutChangeListener {
        private boolean mOffsetCalculated;
        private boolean mPreviewReady;

        private EnterTransitionAnimationDelegate() {
            this.mPreviewReady = false;
            this.mOffsetCalculated = false;
        }

        void postponeTransition() {
            ChooserActivity.this.postponeEnterTransition();
        }

        void markImagePreviewReady() {
            if (!this.mPreviewReady) {
                this.mPreviewReady = true;
                maybeStartListenForLayout();
            }
        }

        void markOffsetCalculated() {
            if (!this.mOffsetCalculated) {
                this.mOffsetCalculated = true;
                maybeStartListenForLayout();
            }
        }

        private void maybeStartListenForLayout() {
            if (this.mPreviewReady && this.mOffsetCalculated && ChooserActivity.this.mResolverDrawerLayout != null) {
                if (ChooserActivity.this.mResolverDrawerLayout.isInLayout()) {
                    ChooserActivity.this.startPostponedEnterTransition();
                } else {
                    ChooserActivity.this.mResolverDrawerLayout.addOnLayoutChangeListener(this);
                    ChooserActivity.this.mResolverDrawerLayout.requestLayout();
                }
            }
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View v2, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
            v2.removeOnLayoutChangeListener(this);
            ChooserActivity.this.startPostponedEnterTransition();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class FinishAnimation extends AlphaAnimation implements Animation.AnimationListener {
        private Activity mActivity;
        private final float mFromAlpha;
        private View mRootView;

        FinishAnimation(Activity activity, View rootView) {
            super(rootView.getAlpha(), 0.0f);
            this.mActivity = activity;
            this.mRootView = rootView;
            this.mFromAlpha = rootView.getAlpha();
            setInterpolator(new LinearInterpolator());
            long duration = activity.getWindow().getTransitionBackgroundFadeDuration();
            setDuration(duration);
            setStartOffset(duration);
            super.setAnimationListener(this);
        }

        @Override // android.view.animation.Animation
        public void setAnimationListener(Animation.AnimationListener listener) {
            throw new UnsupportedOperationException();
        }

        @Override // android.view.animation.Animation
        public void cancel() {
            View view = this.mRootView;
            if (view != null) {
                view.setAlpha(this.mFromAlpha);
            }
            cleanup();
            super.cancel();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Activity activity = this.mActivity;
            cleanup();
            if (activity != null) {
                activity.finish();
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        private void cleanup() {
            this.mActivity = null;
            this.mRootView = null;
        }
    }

    @Override // com.android.internal.app.ResolverActivity
    protected void maybeLogProfileChange() {
        getChooserActivityLogger().logShareheetProfileChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean shouldNearbyShareBeFirstInRankedRow() {
        if (getResolverWrapper().getResolverActivityExt().isOriginUi()) {
            return ActivityManager.isLowRamDeviceStatic() && this.mIsNearbyShareFirstTargetInRankedApp;
        }
        return true;
    }

    private boolean shouldNearbyShareBeIncludedAsActionButton() {
        return !shouldNearbyShareBeFirstInRankedRow();
    }

    public IChooserActivityWrapper getChooserWrapper() {
        return this.mChooserWrapper;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    private class ChooserActivityWrapper implements IChooserActivityWrapper {
        private ChooserActivityWrapper() {
        }

        @Override // com.android.internal.app.IChooserActivityWrapper
        public ViewGroup getCreateContentPreviewView(ViewGroup parent) {
            return ChooserActivity.this.createContentPreviewView(parent);
        }

        @Override // com.android.internal.app.IChooserActivityWrapper
        public void hideStickyContentPreview() {
            ChooserActivity.this.hideStickyContentPreview();
        }

        @Override // com.android.internal.app.IChooserActivityWrapper
        public TargetInfo getNearbySharingTarget(Intent originalIntent) {
            return ChooserActivity.this.getNearbySharingTarget(originalIntent);
        }

        @Override // com.android.internal.app.IChooserActivityWrapper
        public boolean shouldNearbyShareBeFirstInRankedRow() {
            return ChooserActivity.this.shouldNearbyShareBeFirstInRankedRow();
        }
    }
}
