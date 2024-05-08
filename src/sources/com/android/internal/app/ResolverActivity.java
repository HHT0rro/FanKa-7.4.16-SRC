package com.android.internal.app;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityThread;
import android.app.VoiceInteractor;
import android.app.admin.DevicePolicyEventLogger;
import android.app.admin.DevicePolicyManager;
import android.app.admin.DevicePolicyResourcesManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.PermissionChecker;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.UserInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Insets;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.os.Trace;
import android.os.UserHandle;
import android.os.UserManager;
import android.text.TextUtils;
import android.util.Log;
import android.util.Slog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Space;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;
import android.widget.Toast;
import com.android.internal.R;
import com.android.internal.app.AbstractMultiProfilePagerAdapter;
import com.android.internal.app.AbstractResolverComparator;
import com.android.internal.app.NoCrossProfileEmptyStateProvider;
import com.android.internal.app.ResolverListAdapter;
import com.android.internal.app.chooser.ChooserTargetInfo;
import com.android.internal.app.chooser.DisplayResolveInfo;
import com.android.internal.app.chooser.TargetInfo;
import com.android.internal.content.PackageMonitor;
import com.android.internal.logging.MetricsLogger;
import com.android.internal.logging.nano.MetricsProto;
import com.android.internal.util.LatencyTracker;
import com.android.internal.widget.ResolverDrawerLayout;
import com.android.internal.widget.ViewPager;
import com.cupidapp.live.liveshow.beauty.databeauty.UserData;
import com.huawei.openalliance.ad.constant.u;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.function.Supplier;
import system.ext.loader.core.ExtLoader;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class ResolverActivity extends Activity implements ResolverListAdapter.ResolverListCommunicator {
    private static final boolean DEBUG = false;
    public static boolean ENABLE_TABBED_VIEW = true;
    static final String EXTRA_CALLING_USER = "com.android.internal.app.ResolverActivity.EXTRA_CALLING_USER";
    private static final String EXTRA_FRAGMENT_ARG_KEY = ":settings:fragment_args_key";
    public static final String EXTRA_IS_AUDIO_CAPTURE_DEVICE = "is_audio_capture_device";
    protected static final String EXTRA_SELECTED_PROFILE = "com.android.internal.app.ResolverActivity.EXTRA_SELECTED_PROFILE";
    private static final String EXTRA_SHOW_FRAGMENT_ARGS = ":settings:show_fragment_args";
    private static final String LAST_SHOWN_TAB_KEY = "last_shown_tab_key";
    protected static final String METRICS_CATEGORY_CHOOSER = "intent_chooser";
    protected static final String METRICS_CATEGORY_RESOLVER = "intent_resolver";
    private static final String OPEN_LINKS_COMPONENT_KEY = "app_link_state";
    protected static final int PROFILE_PERSONAL = 0;
    protected static final int PROFILE_WORK = 1;
    private static final String TAB_TAG_PERSONAL = "personal";
    private static final String TAB_TAG_WORK = "work";
    private static final String TAG = "ResolverActivity";
    private Button mAlwaysButton;
    protected Bundle mBundle;
    private UserHandle mCloneProfileUserHandle;
    private int mDefaultTitleResId;
    private Space mFooterSpacer;
    private UserHandle mHeaderCreatorUser;
    protected final ArrayList<Intent> mIntents;
    private final boolean mIsIntentPicker;
    private int mLastSelected;
    protected final LatencyTracker mLatencyTracker;
    protected int mLaunchedFromUid;
    private UserHandle mLaunchedFromUserHandle;
    private int mLayoutId;
    protected AbstractMultiProfilePagerAdapter mMultiProfilePagerAdapter;
    private AbstractMultiProfilePagerAdapter.OnSwitchOnWorkSelectedListener mOnSwitchOnWorkSelectedListener;
    private Button mOnceButton;
    private PackageMonitor mPersonalPackageMonitor;
    private UserHandle mPersonalProfileUserHandle;
    private PickTargetOptionRequest mPickOptionRequest;
    protected PackageManager mPm;
    private String mProfileSwitchMessage;
    protected View mProfileView;
    protected AbstractMultiProfilePagerAdapter.QuietModeManager mQuietModeManager;
    private String mReferrerPackage;
    private boolean mRegistered;
    private final IResolverActivityExt mResolverActivityExt;
    protected ResolverDrawerLayout mResolverDrawerLayout;
    private final IResolverActivityWrapper mResolverWrapper;
    private boolean mResolvingHome;
    private boolean mRetainInOnStop;
    private boolean mSafeForwardingMode;
    protected boolean mSupportsAlwaysUseOption;
    protected Insets mSystemWindowInsets;
    private UserHandle mTabOwnerUserHandleForLaunch;
    private CharSequence mTitle;
    private PackageMonitor mWorkPackageMonitor;
    private boolean mWorkProfileHasBeenEnabled;
    private BroadcastReceiver mWorkProfileStateReceiver;
    private UserHandle mWorkProfileUserHandle;

    public ResolverActivity() {
        this.mLastSelected = -1;
        this.mResolvingHome = false;
        this.mIntents = new ArrayList<>();
        this.mSystemWindowInsets = null;
        this.mFooterSpacer = null;
        this.mWorkProfileHasBeenEnabled = false;
        this.mLatencyTracker = getLatencyTracker();
        this.mResolverWrapper = new ResolverActivityWrapper();
        this.mResolverActivityExt = (IResolverActivityExt) ExtLoader.type(IResolverActivityExt.class).base(this).create();
        this.mIsIntentPicker = getClass().equals(ResolverActivity.class);
    }

    protected ResolverActivity(boolean isIntentPicker) {
        this.mLastSelected = -1;
        this.mResolvingHome = false;
        this.mIntents = new ArrayList<>();
        this.mSystemWindowInsets = null;
        this.mFooterSpacer = null;
        this.mWorkProfileHasBeenEnabled = false;
        this.mLatencyTracker = getLatencyTracker();
        this.mResolverWrapper = new ResolverActivityWrapper();
        this.mResolverActivityExt = (IResolverActivityExt) ExtLoader.type(IResolverActivityExt.class).base(this).create();
        this.mIsIntentPicker = isIntentPicker;
    }

    private LatencyTracker getLatencyTracker() {
        return LatencyTracker.getInstance(this);
    }

    public static int getLabelRes(String action) {
        return ActionTitle.forAction(action).labelRes;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public enum ActionTitle {
        VIEW("android.intent.action.VIEW", R.string.whichViewApplication, R.string.whichViewApplicationNamed, R.string.whichViewApplicationLabel),
        EDIT("android.intent.action.EDIT", R.string.whichEditApplication, R.string.whichEditApplicationNamed, R.string.whichEditApplicationLabel),
        SEND("android.intent.action.SEND", R.string.whichSendApplication, R.string.whichSendApplicationNamed, R.string.whichSendApplicationLabel),
        SENDTO("android.intent.action.SENDTO", R.string.whichSendToApplication, R.string.whichSendToApplicationNamed, R.string.whichSendToApplicationLabel),
        SEND_MULTIPLE("android.intent.action.SEND_MULTIPLE", R.string.whichSendApplication, R.string.whichSendApplicationNamed, R.string.whichSendApplicationLabel),
        CAPTURE_IMAGE("android.media.action.IMAGE_CAPTURE", R.string.whichImageCaptureApplication, R.string.whichImageCaptureApplicationNamed, R.string.whichImageCaptureApplicationLabel),
        DEFAULT(null, R.string.whichApplication, R.string.whichApplicationNamed, R.string.whichApplicationLabel),
        HOME("android.intent.action.MAIN", R.string.whichHomeApplication, R.string.whichHomeApplicationNamed, R.string.whichHomeApplicationLabel);

        public static final int BROWSABLE_APP_TITLE_RES = 17041893;
        public static final int BROWSABLE_HOST_APP_TITLE_RES = 17041891;
        public static final int BROWSABLE_HOST_TITLE_RES = 17041890;
        public static final int BROWSABLE_TITLE_RES = 17041892;
        public final String action;
        public final int labelRes;
        public final int namedTitleRes;
        public final int titleRes;

        ActionTitle(String action, int titleRes, int namedTitleRes, int labelRes) {
            this.action = action;
            this.titleRes = titleRes;
            this.namedTitleRes = namedTitleRes;
            this.labelRes = labelRes;
        }

        public static ActionTitle forAction(String action) {
            for (ActionTitle title : values()) {
                if (title != HOME && action != null && action.equals(title.action)) {
                    return title;
                }
            }
            return DEFAULT;
        }
    }

    protected PackageMonitor createPackageMonitor(final ResolverListAdapter listAdapter) {
        return new PackageMonitor() { // from class: com.android.internal.app.ResolverActivity.1
            @Override // com.android.internal.content.PackageMonitor
            public void onSomePackagesChanged() {
                listAdapter.handlePackagesChanged();
                ResolverActivity.this.updateProfileViewButton();
            }

            @Override // com.android.internal.content.PackageMonitor
            public boolean onPackageChanged(String packageName, int uid, String[] components) {
                return true;
            }
        };
    }

    private Intent makeMyIntent() {
        Intent intent = new Intent(getIntent());
        intent.setComponent(null);
        intent.setFlags(intent.getFlags() & (-8388609));
        return intent;
    }

    protected void super_onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        Intent intent = makeMyIntent();
        Set<String> categories = intent.getCategories();
        if ("android.intent.action.MAIN".equals(intent.getAction()) && categories != null && categories.size() == 1 && categories.contains("android.intent.category.HOME")) {
            this.mResolvingHome = true;
        }
        setSafeForwardingMode(true);
        onCreate(savedInstanceState, intent, null, 0, null, null, true);
    }

    protected void onCreate(Bundle savedInstanceState, Intent intent, CharSequence title, Intent[] initialIntents, List<ResolveInfo> rList, boolean supportsAlwaysUseOption) {
        onCreate(savedInstanceState, intent, title, 0, initialIntents, rList, supportsAlwaysUseOption);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState, Intent intent, CharSequence title, int defaultTitleRes, Intent[] initialIntents, List<ResolveInfo> rList, boolean supportsAlwaysUseOption) {
        int i10;
        ResolverDrawerLayout rdl;
        if (!this.mResolverWrapper.getResolverActivityExt().isOriginUi()) {
            setTheme(appliedThemeResId());
        }
        this.mResolverWrapper.getResolverActivityExt().hookonCreate(savedInstanceState);
        super.onCreate(savedInstanceState);
        this.mQuietModeManager = createQuietModeManager();
        setProfileSwitchMessage(intent.getContentUserHint());
        int launchedFromUid = getLaunchedFromUid();
        this.mLaunchedFromUid = launchedFromUid;
        this.mLaunchedFromUserHandle = UserHandle.getUserHandleForUid(launchedFromUid);
        int i11 = this.mLaunchedFromUid;
        if (i11 < 0 || UserHandle.isIsolated(i11)) {
            finish();
            return;
        }
        this.mPm = getPackageManager();
        this.mReferrerPackage = getReferrerPackageName();
        this.mIntents.add(0, new Intent(intent));
        this.mTitle = title;
        this.mDefaultTitleResId = defaultTitleRes;
        this.mSupportsAlwaysUseOption = supportsAlwaysUseOption;
        this.mPersonalProfileUserHandle = fetchPersonalProfileUserHandle();
        this.mWorkProfileUserHandle = fetchWorkProfileUserProfile();
        this.mCloneProfileUserHandle = fetchCloneProfileUserHandle();
        this.mTabOwnerUserHandleForLaunch = fetchTabOwnerUserHandleForLaunch();
        boolean filterLastUsed = (!this.mSupportsAlwaysUseOption || isVoiceInteraction() || shouldShowTabs() || hasCloneProfile()) ? false : true;
        this.mMultiProfilePagerAdapter = createMultiProfilePagerAdapter(initialIntents, rList, filterLastUsed);
        this.mResolverWrapper.getResolverActivityExt().setMultiProfilePagerAdapter(this.mMultiProfilePagerAdapter);
        if (configureContentView()) {
            return;
        }
        PackageMonitor createPackageMonitor = createPackageMonitor(this.mMultiProfilePagerAdapter.getPersonalListAdapter());
        this.mPersonalPackageMonitor = createPackageMonitor;
        createPackageMonitor.register((Context) this, getMainLooper(), getPersonalProfileUserHandle(), false);
        if (shouldShowTabs()) {
            PackageMonitor createPackageMonitor2 = createPackageMonitor(this.mMultiProfilePagerAdapter.getWorkListAdapter());
            this.mWorkPackageMonitor = createPackageMonitor2;
            createPackageMonitor2.register((Context) this, getMainLooper(), getWorkProfileUserHandle(), false);
        }
        this.mRegistered = true;
        if (this.mResolverWrapper.getResolverActivityExt().initPreferenceAndPinList() && (rdl = findViewById(16908905)) != null) {
            rdl.setOnDismissedListener(new ResolverDrawerLayout.OnDismissedListener() { // from class: com.android.internal.app.ResolverActivity.2
                public void onDismissed() {
                    ResolverActivity.this.finish();
                }
            });
            boolean hasTouchScreen = getPackageManager().hasSystemFeature("android.hardware.touchscreen");
            if (isVoiceInteraction() || !hasTouchScreen) {
                rdl.setCollapsed(false);
            }
            rdl.setSystemUiVisibility(768);
            rdl.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: com.android.internal.app.ResolverActivity$$ExternalSyntheticLambda3
                @Override // android.view.View.OnApplyWindowInsetsListener
                public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    return ResolverActivity.this.onApplyWindowInsets(view, windowInsets);
                }
            });
            this.mResolverDrawerLayout = rdl;
        }
        View findViewById = findViewById(16909398);
        this.mProfileView = findViewById;
        if (findViewById != null) {
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.android.internal.app.ResolverActivity$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ResolverActivity.this.onProfileClick(view);
                }
            });
            updateProfileViewButton();
        }
        Set<String> categories = intent.getCategories();
        if (this.mMultiProfilePagerAdapter.getActiveListAdapter().hasFilteredItem()) {
            i10 = MetricsProto.MetricsEvent.ACTION_SHOW_APP_DISAMBIG_APP_FEATURED;
        } else {
            i10 = MetricsProto.MetricsEvent.ACTION_SHOW_APP_DISAMBIG_NONE_FEATURED;
        }
        MetricsLogger.action(this, i10, intent.getAction() + u.bD + intent.getType() + u.bD + (categories != null ? Arrays.toString(categories.toArray()) : ""));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractMultiProfilePagerAdapter createMultiProfilePagerAdapter(Intent[] initialIntents, List<ResolveInfo> rList, boolean filterLastUsed) {
        if (shouldShowTabs()) {
            AbstractMultiProfilePagerAdapter resolverMultiProfilePagerAdapter = createResolverMultiProfilePagerAdapterForTwoProfiles(initialIntents, rList, filterLastUsed);
            return resolverMultiProfilePagerAdapter;
        }
        AbstractMultiProfilePagerAdapter resolverMultiProfilePagerAdapter2 = createResolverMultiProfilePagerAdapterForOneProfile(initialIntents, rList, filterLastUsed);
        return resolverMultiProfilePagerAdapter2;
    }

    protected AbstractMultiProfilePagerAdapter.MyUserIdProvider createMyUserIdProvider() {
        return new AbstractMultiProfilePagerAdapter.MyUserIdProvider();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractMultiProfilePagerAdapter.CrossProfileIntentsChecker createCrossProfileIntentsChecker() {
        return new AbstractMultiProfilePagerAdapter.CrossProfileIntentsChecker(getContentResolver());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* renamed from: com.android.internal.app.ResolverActivity$3, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public class AnonymousClass3 implements AbstractMultiProfilePagerAdapter.QuietModeManager {
        private boolean mIsWaitingToEnableWorkProfile = false;
        final /* synthetic */ UserManager val$userManager;

        AnonymousClass3(UserManager userManager) {
            this.val$userManager = userManager;
        }

        @Override // com.android.internal.app.AbstractMultiProfilePagerAdapter.QuietModeManager
        public boolean isQuietModeEnabled(UserHandle workProfileUserHandle) {
            return this.val$userManager.isQuietModeEnabled(workProfileUserHandle);
        }

        @Override // com.android.internal.app.AbstractMultiProfilePagerAdapter.QuietModeManager
        public void requestQuietModeEnabled(final boolean enabled, final UserHandle workProfileUserHandle) {
            Executor executor = AsyncTask.THREAD_POOL_EXECUTOR;
            final UserManager userManager = this.val$userManager;
            executor.execute(new Runnable() { // from class: com.android.internal.app.ResolverActivity$3$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    userManager.requestQuietModeEnabled(enabled, workProfileUserHandle);
                }
            });
            this.mIsWaitingToEnableWorkProfile = true;
        }

        @Override // com.android.internal.app.AbstractMultiProfilePagerAdapter.QuietModeManager
        public void markWorkProfileEnabledBroadcastReceived() {
            this.mIsWaitingToEnableWorkProfile = false;
        }

        @Override // com.android.internal.app.AbstractMultiProfilePagerAdapter.QuietModeManager
        public boolean isWaitingToEnableWorkProfile() {
            return this.mIsWaitingToEnableWorkProfile;
        }
    }

    protected AbstractMultiProfilePagerAdapter.QuietModeManager createQuietModeManager() {
        UserManager userManager = (UserManager) getSystemService(UserManager.class);
        return new AnonymousClass3(userManager);
    }

    protected AbstractMultiProfilePagerAdapter.EmptyStateProvider createBlockerEmptyStateProvider() {
        boolean shouldShowNoCrossProfileIntentsEmptyState = getUser().equals(getIntentUser());
        if (!shouldShowNoCrossProfileIntentsEmptyState) {
            return new AbstractMultiProfilePagerAdapter.EmptyStateProvider() { // from class: com.android.internal.app.ResolverActivity.4
            };
        }
        AbstractMultiProfilePagerAdapter.EmptyState noWorkToPersonalEmptyState = new NoCrossProfileEmptyStateProvider.DevicePolicyBlockerEmptyState(this, "Core.RESOLVER_CROSS_PROFILE_BLOCKED_TITLE", 17041509, "Core.RESOLVER_CANT_ACCESS_PERSONAL", 17041505, 158, METRICS_CATEGORY_RESOLVER);
        AbstractMultiProfilePagerAdapter.EmptyState noPersonalToWorkEmptyState = new NoCrossProfileEmptyStateProvider.DevicePolicyBlockerEmptyState(this, "Core.RESOLVER_CROSS_PROFILE_BLOCKED_TITLE", 17041509, "Core.RESOLVER_CANT_ACCESS_WORK", 17041506, 159, METRICS_CATEGORY_RESOLVER);
        return new NoCrossProfileEmptyStateProvider(getPersonalProfileUserHandle(), noWorkToPersonalEmptyState, noPersonalToWorkEmptyState, createCrossProfileIntentsChecker(), getTabOwnerUserHandleForLaunch());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractMultiProfilePagerAdapter.EmptyStateProvider createEmptyStateProvider(UserHandle workProfileUserHandle) {
        AbstractMultiProfilePagerAdapter.EmptyStateProvider blockerEmptyStateProvider = createBlockerEmptyStateProvider();
        AbstractMultiProfilePagerAdapter.EmptyStateProvider workProfileOffEmptyStateProvider = new WorkProfilePausedEmptyStateProvider(this, workProfileUserHandle, this.mQuietModeManager, new AbstractMultiProfilePagerAdapter.OnSwitchOnWorkSelectedListener() { // from class: com.android.internal.app.ResolverActivity$$ExternalSyntheticLambda2
            @Override // com.android.internal.app.AbstractMultiProfilePagerAdapter.OnSwitchOnWorkSelectedListener
            public final void onSwitchOnWorkSelected() {
                ResolverActivity.this.lambda$createEmptyStateProvider$0();
            }
        }, getMetricsCategory());
        AbstractMultiProfilePagerAdapter.EmptyStateProvider noAppsEmptyStateProvider = new NoAppsAvailableEmptyStateProvider(this, workProfileUserHandle, getPersonalProfileUserHandle(), getMetricsCategory(), getTabOwnerUserHandleForLaunch());
        return new AbstractMultiProfilePagerAdapter.CompositeEmptyStateProvider(blockerEmptyStateProvider, workProfileOffEmptyStateProvider, noAppsEmptyStateProvider);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createEmptyStateProvider$0() {
        AbstractMultiProfilePagerAdapter.OnSwitchOnWorkSelectedListener onSwitchOnWorkSelectedListener = this.mOnSwitchOnWorkSelectedListener;
        if (onSwitchOnWorkSelectedListener != null) {
            onSwitchOnWorkSelectedListener.onSwitchOnWorkSelected();
        }
    }

    private ResolverMultiProfilePagerAdapter createResolverMultiProfilePagerAdapterForOneProfile(Intent[] initialIntents, List<ResolveInfo> rList, boolean filterLastUsed) {
        ResolverListAdapter adapter = createResolverListAdapter(this, this.mIntents, initialIntents, rList, filterLastUsed, getPersonalProfileUserHandle());
        AbstractMultiProfilePagerAdapter.QuietModeManager quietModeManager = createQuietModeManager();
        return new ResolverMultiProfilePagerAdapter(this, adapter, createEmptyStateProvider(null), quietModeManager, null, getCloneProfileUserHandle());
    }

    private UserHandle getIntentUser() {
        if (getIntent().hasExtra(EXTRA_CALLING_USER)) {
            return (UserHandle) getIntent().getParcelableExtra(EXTRA_CALLING_USER, UserHandle.class);
        }
        return getUser();
    }

    private ResolverMultiProfilePagerAdapter createResolverMultiProfilePagerAdapterForTwoProfiles(Intent[] initialIntents, List<ResolveInfo> rList, boolean filterLastUsed) {
        int selectedProfile;
        int selectedProfile2 = getCurrentProfile();
        UserHandle intentUser = getIntentUser();
        if (!getTabOwnerUserHandleForLaunch().equals(intentUser)) {
            if (getPersonalProfileUserHandle().equals(intentUser)) {
                selectedProfile = 0;
            } else {
                if (getWorkProfileUserHandle().equals(intentUser)) {
                    selectedProfile = 1;
                }
                selectedProfile = selectedProfile2;
            }
        } else {
            int selectedProfileExtra = getSelectedProfileExtra();
            if (selectedProfileExtra != -1) {
                selectedProfile = selectedProfileExtra;
            }
            selectedProfile = selectedProfile2;
        }
        ResolverListAdapter personalAdapter = createResolverListAdapter(this, this.mIntents, selectedProfile == 0 ? initialIntents : null, rList, filterLastUsed && UserHandle.myUserId() == getPersonalProfileUserHandle().getIdentifier(), getPersonalProfileUserHandle());
        UserHandle workProfileUserHandle = getWorkProfileUserHandle();
        ResolverListAdapter workAdapter = createResolverListAdapter(this, this.mIntents, selectedProfile == 1 ? initialIntents : null, rList, filterLastUsed && UserHandle.myUserId() == workProfileUserHandle.getIdentifier(), workProfileUserHandle);
        AbstractMultiProfilePagerAdapter.QuietModeManager quietModeManager = createQuietModeManager();
        return new ResolverMultiProfilePagerAdapter(this, personalAdapter, workAdapter, createEmptyStateProvider(getWorkProfileUserHandle()), quietModeManager, selectedProfile, getWorkProfileUserHandle(), getCloneProfileUserHandle());
    }

    protected int appliedThemeResId() {
        return 16974828;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSelectedProfileExtra() {
        int selectedProfile = -1;
        if (getIntent().hasExtra(EXTRA_SELECTED_PROFILE) && (selectedProfile = getIntent().getIntExtra(EXTRA_SELECTED_PROFILE, -1)) != 0 && selectedProfile != 1) {
            throw new IllegalArgumentException("com.android.internal.app.ResolverActivity.EXTRA_SELECTED_PROFILE has invalid value " + selectedProfile + ". Must be either ResolverActivity.PROFILE_PERSONAL or ResolverActivity.PROFILE_WORK.");
        }
        return selectedProfile;
    }

    protected int getCurrentProfile() {
        return UserHandle.myUserId() == getPersonalProfileUserHandle().getIdentifier() ? 0 : 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public UserHandle getPersonalProfileUserHandle() {
        return this.mPersonalProfileUserHandle;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public UserHandle getWorkProfileUserHandle() {
        return this.mWorkProfileUserHandle;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public UserHandle getCloneProfileUserHandle() {
        return this.mCloneProfileUserHandle;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public UserHandle getTabOwnerUserHandleForLaunch() {
        return this.mTabOwnerUserHandleForLaunch;
    }

    protected UserHandle fetchPersonalProfileUserHandle() {
        UserHandle of = UserHandle.of(ActivityManager.getCurrentUser());
        this.mPersonalProfileUserHandle = of;
        return of;
    }

    protected UserHandle fetchWorkProfileUserProfile() {
        this.mWorkProfileUserHandle = null;
        UserManager userManager = (UserManager) getSystemService(UserManager.class);
        for (UserInfo userInfo : userManager.getProfiles(this.mPersonalProfileUserHandle.getIdentifier())) {
            if (userInfo.isManagedProfile()) {
                this.mWorkProfileUserHandle = userInfo.getUserHandle();
            }
        }
        return this.mWorkProfileUserHandle;
    }

    protected UserHandle fetchCloneProfileUserHandle() {
        this.mCloneProfileUserHandle = null;
        UserManager userManager = (UserManager) getSystemService(UserManager.class);
        for (UserInfo userInfo : userManager.getProfiles(this.mPersonalProfileUserHandle.getIdentifier())) {
            if (userInfo.isCloneProfile()) {
                this.mCloneProfileUserHandle = userInfo.getUserHandle();
            }
        }
        return this.mCloneProfileUserHandle;
    }

    private UserHandle fetchTabOwnerUserHandleForLaunch() {
        if (UserHandle.of(UserHandle.myUserId()).equals(getWorkProfileUserHandle())) {
            return getWorkProfileUserHandle();
        }
        return getPersonalProfileUserHandle();
    }

    private boolean hasWorkProfile() {
        return getWorkProfileUserHandle() != null;
    }

    private boolean hasCloneProfile() {
        return getCloneProfileUserHandle() != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean isLaunchedAsCloneProfile() {
        return hasCloneProfile() && UserHandle.myUserId() == getCloneProfileUserHandle().getIdentifier();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean shouldShowTabs() {
        return hasWorkProfile() && ENABLE_TABBED_VIEW;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onProfileClick(View v2) {
        DisplayResolveInfo dri = this.mMultiProfilePagerAdapter.getActiveListAdapter().getOtherProfile();
        if (dri == null) {
            return;
        }
        this.mProfileSwitchMessage = null;
        onTargetSelected(dri, false);
        finish();
    }

    protected boolean shouldAddFooterView() {
        View buttonBar;
        return useLayoutWithDefault() || (buttonBar = findViewById(16908847)) == null || buttonBar.getVisibility() == 8;
    }

    protected void applyFooterView(int height) {
        if (this.mFooterSpacer == null) {
            this.mFooterSpacer = new Space(getApplicationContext());
        } else {
            ((ResolverMultiProfilePagerAdapter) this.mMultiProfilePagerAdapter).getActiveAdapterView().removeFooterView(this.mFooterSpacer);
        }
        this.mFooterSpacer.setLayoutParams(new AbsListView.LayoutParams(-1, this.mSystemWindowInsets.bottom));
        ((ResolverMultiProfilePagerAdapter) this.mMultiProfilePagerAdapter).getActiveAdapterView().addFooterView(this.mFooterSpacer);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public WindowInsets onApplyWindowInsets(View v2, WindowInsets insets) {
        Insets systemWindowInsets = insets.getSystemWindowInsets();
        this.mSystemWindowInsets = systemWindowInsets;
        this.mResolverDrawerLayout.setPadding(systemWindowInsets.left, this.mSystemWindowInsets.top, this.mSystemWindowInsets.right, 0);
        resetButtonBar();
        if (shouldUseMiniResolver()) {
            View buttonContainer = findViewById(16908848);
            buttonContainer.setPadding(0, 0, 0, this.mSystemWindowInsets.bottom + getResources().getDimensionPixelOffset(17105516));
        }
        if (shouldAddFooterView()) {
            applyFooterView(this.mSystemWindowInsets.bottom);
        }
        return insets.consumeSystemWindowInsets();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        this.mMultiProfilePagerAdapter.getActiveListAdapter().handlePackagesChanged();
        if (this.mIsIntentPicker && shouldShowTabs() && !useLayoutWithDefault() && !shouldUseMiniResolver()) {
            updateIntentPickerPaddings();
        }
        Insets insets = this.mSystemWindowInsets;
        if (insets != null) {
            this.mResolverDrawerLayout.setPadding(insets.left, this.mSystemWindowInsets.top, this.mSystemWindowInsets.right, 0);
        }
        this.mResolverWrapper.getResolverActivityExt().hookonConfigurationChanged(newConfig);
    }

    private void updateIntentPickerPaddings() {
        View titleCont = findViewById(16909647);
        titleCont.setPadding(titleCont.getPaddingLeft(), titleCont.getPaddingTop(), titleCont.getPaddingRight(), getResources().getDimensionPixelSize(17105533));
        View buttonBar = findViewById(16908847);
        buttonBar.setPadding(buttonBar.getPaddingLeft(), getResources().getDimensionPixelSize(17105516), buttonBar.getPaddingRight(), getResources().getDimensionPixelSize(17105516));
    }

    @Override // com.android.internal.app.ResolverListAdapter.ResolverListCommunicator
    public void sendVoiceChoicesIfNeeded() {
        if (!isVoiceInteraction()) {
            return;
        }
        int count = this.mMultiProfilePagerAdapter.getActiveListAdapter().getCount();
        VoiceInteractor.PickOptionRequest.Option[] options = new VoiceInteractor.PickOptionRequest.Option[count];
        int N = options.length;
        for (int i10 = 0; i10 < N; i10++) {
            TargetInfo target = this.mMultiProfilePagerAdapter.getActiveListAdapter().getItem(i10);
            if (target == null) {
                return;
            }
            options[i10] = optionForChooserTarget(target, i10);
        }
        this.mPickOptionRequest = new PickTargetOptionRequest(new VoiceInteractor.Prompt(getTitle()), options, null);
        getVoiceInteractor().submitRequest(this.mPickOptionRequest);
    }

    VoiceInteractor.PickOptionRequest.Option optionForChooserTarget(TargetInfo target, int index) {
        return new VoiceInteractor.PickOptionRequest.Option(target.getDisplayLabel(), index);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setAdditionalTargets(Intent[] intents) {
        if (intents != null) {
            for (Intent intent : intents) {
                this.mIntents.add(intent);
            }
        }
    }

    @Override // com.android.internal.app.ResolverListAdapter.ResolverListCommunicator
    public Intent getTargetIntent() {
        if (this.mIntents.isEmpty()) {
            return null;
        }
        return this.mIntents.get(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getReferrerPackageName() {
        Uri referrer = getReferrer();
        if (referrer != null && "android-app".equals(referrer.getScheme())) {
            return referrer.getHost();
        }
        return null;
    }

    public int getLayoutResource() {
        return 17367298;
    }

    @Override // com.android.internal.app.ResolverListAdapter.ResolverListCommunicator
    public void updateProfileViewButton() {
        if (this.mProfileView == null) {
            return;
        }
        DisplayResolveInfo dri = this.mMultiProfilePagerAdapter.getActiveListAdapter().getOtherProfile();
        if (dri != null && !shouldShowTabs()) {
            this.mProfileView.setVisibility(0);
            View text = this.mProfileView.findViewById(16909398);
            if (!(text instanceof TextView)) {
                text = this.mProfileView.findViewById(16908308);
            }
            ((TextView) text).setText(dri.getDisplayLabel());
            return;
        }
        this.mProfileView.setVisibility(8);
    }

    private void setProfileSwitchMessage(int contentUserHint) {
        if (contentUserHint != -2 && contentUserHint != UserHandle.myUserId()) {
            UserManager userManager = (UserManager) getSystemService(UserData.NAME);
            UserInfo originUserInfo = userManager.getUserInfo(contentUserHint);
            boolean originIsManaged = originUserInfo != null ? originUserInfo.isManagedProfile() : false;
            boolean targetIsManaged = userManager.isManagedProfile();
            if (originIsManaged && !targetIsManaged) {
                this.mProfileSwitchMessage = getForwardToPersonalMsg();
            } else if (!originIsManaged && targetIsManaged) {
                this.mProfileSwitchMessage = getForwardToWorkMsg();
            }
        }
    }

    private String getForwardToPersonalMsg() {
        return ((DevicePolicyManager) getSystemService(DevicePolicyManager.class)).getResources().getString("Core.FORWARD_INTENT_TO_PERSONAL", new Supplier() { // from class: com.android.internal.app.ResolverActivity$$ExternalSyntheticLambda6
            @Override // java.util.function.Supplier
            public final Object get() {
                String lambda$getForwardToPersonalMsg$1;
                lambda$getForwardToPersonalMsg$1 = ResolverActivity.this.lambda$getForwardToPersonalMsg$1();
                return lambda$getForwardToPersonalMsg$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$getForwardToPersonalMsg$1() {
        return getString(17040428);
    }

    private String getForwardToWorkMsg() {
        return ((DevicePolicyManager) getSystemService(DevicePolicyManager.class)).getResources().getString("Core.FORWARD_INTENT_TO_WORK", new Supplier() { // from class: com.android.internal.app.ResolverActivity$$ExternalSyntheticLambda8
            @Override // java.util.function.Supplier
            public final Object get() {
                String lambda$getForwardToWorkMsg$2;
                lambda$getForwardToWorkMsg$2 = ResolverActivity.this.lambda$getForwardToWorkMsg$2();
                return lambda$getForwardToWorkMsg$2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$getForwardToWorkMsg$2() {
        return getString(17040429);
    }

    public void setSafeForwardingMode(boolean safeForwarding) {
        this.mSafeForwardingMode = safeForwarding;
    }

    protected CharSequence getTitleForAction(Intent intent, int defaultTitleRes) {
        ActionTitle title;
        if (this.mResolvingHome) {
            title = ActionTitle.HOME;
        } else {
            title = ActionTitle.forAction(intent.getAction());
        }
        boolean named = this.mMultiProfilePagerAdapter.getActiveListAdapter().getFilteredPosition() >= 0;
        if (title == ActionTitle.DEFAULT && defaultTitleRes != 0) {
            return getString(defaultTitleRes);
        }
        if (named) {
            return getString(title.namedTitleRes, new Object[]{this.mMultiProfilePagerAdapter.getActiveListAdapter().getFilteredItem().getDisplayLabel()});
        }
        return getString(title.titleRes);
    }

    void dismiss() {
        if (!isFinishing()) {
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        if (!this.mRegistered) {
            this.mPersonalPackageMonitor.register((Context) this, getMainLooper(), getPersonalProfileUserHandle(), false);
            if (shouldShowTabs()) {
                if (this.mWorkPackageMonitor == null) {
                    this.mWorkPackageMonitor = createPackageMonitor(this.mMultiProfilePagerAdapter.getWorkListAdapter());
                }
                this.mWorkPackageMonitor.register((Context) this, getMainLooper(), getWorkProfileUserHandle(), false);
            }
            this.mRegistered = true;
        }
        if (shouldShowTabs() && this.mQuietModeManager.isWaitingToEnableWorkProfile() && this.mQuietModeManager.isQuietModeEnabled(getWorkProfileUserHandle())) {
            this.mQuietModeManager.markWorkProfileEnabledBroadcastReceived();
        }
        this.mMultiProfilePagerAdapter.getActiveListAdapter().handlePackagesChanged();
        updateProfileViewButton();
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        getWindow().addSystemFlags(524288);
        if (shouldShowTabs()) {
            this.mWorkProfileStateReceiver = createWorkProfileStateReceiver();
            registerWorkProfileStateReceiver();
            this.mWorkProfileHasBeenEnabled = isWorkProfileEnabled();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isWorkProfileEnabled() {
        UserHandle workUserHandle = getWorkProfileUserHandle();
        UserManager userManager = (UserManager) getSystemService(UserManager.class);
        return !userManager.isQuietModeEnabled(workUserHandle) && userManager.isUserUnlocked(workUserHandle);
    }

    private void registerWorkProfileStateReceiver() {
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.USER_UNLOCKED");
        filter.addAction("android.intent.action.MANAGED_PROFILE_AVAILABLE");
        filter.addAction("android.intent.action.MANAGED_PROFILE_UNAVAILABLE");
        registerReceiverAsUser(this.mWorkProfileStateReceiver, UserHandle.ALL, filter, null, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        Window window = getWindow();
        WindowManager.LayoutParams attrs = window.getAttributes();
        attrs.privateFlags &= -524289;
        window.setAttributes(attrs);
        if (this.mRegistered) {
            this.mPersonalPackageMonitor.unregister();
            PackageMonitor packageMonitor = this.mWorkPackageMonitor;
            if (packageMonitor != null) {
                packageMonitor.unregister();
            }
            this.mRegistered = false;
        }
        Intent intent = getIntent();
        if ((intent.getFlags() & 268435456) != 0 && !isVoiceInteraction() && !this.mResolvingHome && !this.mRetainInOnStop && !isChangingConfigurations()) {
            finish();
        }
        if (this.mWorkPackageMonitor != null) {
            unregisterReceiver(this.mWorkProfileStateReceiver);
            this.mWorkPackageMonitor = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onDestroy() {
        PickTargetOptionRequest pickTargetOptionRequest;
        super.onDestroy();
        if (!isChangingConfigurations() && (pickTargetOptionRequest = this.mPickOptionRequest) != null) {
            pickTargetOptionRequest.cancel();
        }
        AbstractMultiProfilePagerAdapter abstractMultiProfilePagerAdapter = this.mMultiProfilePagerAdapter;
        if (abstractMultiProfilePagerAdapter != null && abstractMultiProfilePagerAdapter.getActiveListAdapter() != null) {
            this.mMultiProfilePagerAdapter.getActiveListAdapter().onDestroy();
        }
        this.mResolverWrapper.getResolverActivityExt().hookonDestroy();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        ViewPager viewPager;
        super.onSaveInstanceState(outState);
        if (!this.mResolverWrapper.getResolverActivityExt().hookonSaveInstanceState(outState, LAST_SHOWN_TAB_KEY) && (viewPager = findViewById(16909399)) != null) {
            outState.putInt(LAST_SHOWN_TAB_KEY, viewPager.getCurrentItem());
        }
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        resetButtonBar();
        if (this.mResolverWrapper.getResolverActivityExt().hookonRestoreInstanceState(savedInstanceState, LAST_SHOWN_TAB_KEY)) {
            return;
        }
        ViewPager viewPager = findViewById(16909399);
        if (viewPager != null) {
            viewPager.setCurrentItem(savedInstanceState.getInt(LAST_SHOWN_TAB_KEY));
        }
        this.mMultiProfilePagerAdapter.clearInactiveProfileCache();
    }

    private boolean hasManagedProfile() {
        UserManager userManager = (UserManager) getSystemService(UserData.NAME);
        if (userManager == null) {
            return false;
        }
        try {
            List<UserInfo> profiles = userManager.getProfiles(getUserId());
            for (UserInfo userInfo : profiles) {
                if (userInfo != null && userInfo.isManagedProfile()) {
                    return true;
                }
            }
            return false;
        } catch (SecurityException e2) {
            return false;
        }
    }

    private boolean supportsManagedProfiles(ResolveInfo resolveInfo) {
        try {
            ApplicationInfo appInfo = getPackageManager().getApplicationInfo(resolveInfo.activityInfo.packageName, 0);
            return appInfo.targetSdkVersion >= 21;
        } catch (PackageManager.NameNotFoundException e2) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAlwaysButtonEnabled(boolean hasValidSelection, int checkedPos, boolean filtered) {
        if (!this.mMultiProfilePagerAdapter.getCurrentUserHandle().equals(getUser())) {
            this.mAlwaysButton.setEnabled(false);
            return;
        }
        if (hasCloneProfile() && !this.mMultiProfilePagerAdapter.getCurrentUserHandle().equals(this.mWorkProfileUserHandle)) {
            this.mAlwaysButton.setEnabled(false);
            return;
        }
        boolean enabled = false;
        ResolveInfo ri = null;
        if (hasValidSelection) {
            ri = this.mMultiProfilePagerAdapter.getActiveListAdapter().resolveInfoForPosition(checkedPos, filtered);
            if (ri == null) {
                Log.e(TAG, "Invalid position supplied to setAlwaysButtonEnabled");
                return;
            } else if (ri.targetUserId != -2) {
                Log.e(TAG, "Attempted to set selection to resolve info for another user");
                return;
            } else {
                enabled = true;
                this.mAlwaysButton.setText(getResources().getString(17039637));
            }
        }
        if (ri != null) {
            ActivityInfo activityInfo = ri.activityInfo;
            boolean hasRecordPermission = this.mPm.checkPermission("android.permission.RECORD_AUDIO", activityInfo.packageName) == 0;
            if (!hasRecordPermission) {
                boolean hasAudioCapture = getIntent().getBooleanExtra(EXTRA_IS_AUDIO_CAPTURE_DEVICE, false);
                enabled = !hasAudioCapture;
            }
        }
        this.mAlwaysButton.setEnabled(enabled);
    }

    public void onButtonClick(View v2) {
        int which;
        int id2 = v2.getId();
        ListView listView = (ListView) this.mMultiProfilePagerAdapter.getActiveAdapterView();
        ResolverListAdapter currentListAdapter = this.mMultiProfilePagerAdapter.getActiveListAdapter();
        if (currentListAdapter.hasFilteredItem()) {
            which = currentListAdapter.getFilteredPosition();
        } else {
            which = listView.getCheckedItemPosition();
        }
        boolean hasIndexBeenFiltered = !currentListAdapter.hasFilteredItem();
        startSelected(which, id2 == 16908846, hasIndexBeenFiltered);
    }

    public void startSelected(int which, boolean always, boolean hasIndexBeenFiltered) {
        int i10;
        if (isFinishing() || which < 0) {
            return;
        }
        ResolveInfo ri = this.mMultiProfilePagerAdapter.getActiveListAdapter().resolveInfoForPosition(which, hasIndexBeenFiltered);
        if (this.mResolvingHome && hasManagedProfile() && !supportsManagedProfiles(ri)) {
            Toast.makeText(this, getWorkProfileNotSupportedMsg(ri.activityInfo.loadLabel(getPackageManager()).toString()), 1).show();
            return;
        }
        TargetInfo target = this.mMultiProfilePagerAdapter.getActiveListAdapter().targetInfoForPosition(which, hasIndexBeenFiltered);
        if (target == null) {
            return;
        }
        this.mResolverWrapper.getResolverActivityExt().statisticsData(ri, which);
        if (onTargetSelected(target, always)) {
            if (always && this.mSupportsAlwaysUseOption) {
                MetricsLogger.action(this, MetricsProto.MetricsEvent.ACTION_APP_DISAMBIG_ALWAYS);
            } else if (this.mSupportsAlwaysUseOption) {
                MetricsLogger.action(this, MetricsProto.MetricsEvent.ACTION_APP_DISAMBIG_JUST_ONCE);
            } else {
                MetricsLogger.action(this, MetricsProto.MetricsEvent.ACTION_APP_DISAMBIG_TAP);
            }
            if (this.mMultiProfilePagerAdapter.getActiveListAdapter().hasFilteredItem()) {
                i10 = MetricsProto.MetricsEvent.ACTION_HIDE_APP_DISAMBIG_APP_FEATURED;
            } else {
                i10 = MetricsProto.MetricsEvent.ACTION_HIDE_APP_DISAMBIG_NONE_FEATURED;
            }
            MetricsLogger.action(this, i10);
            finish();
        }
    }

    private String getWorkProfileNotSupportedMsg(final String launcherName) {
        return ((DevicePolicyManager) getSystemService(DevicePolicyManager.class)).getResources().getString("Core.RESOLVER_WORK_PROFILE_NOT_SUPPORTED", new Supplier() { // from class: com.android.internal.app.ResolverActivity$$ExternalSyntheticLambda9
            @Override // java.util.function.Supplier
            public final Object get() {
                String lambda$getWorkProfileNotSupportedMsg$3;
                lambda$getWorkProfileNotSupportedMsg$3 = ResolverActivity.this.lambda$getWorkProfileNotSupportedMsg$3(launcherName);
                return lambda$getWorkProfileNotSupportedMsg$3;
            }
        }, launcherName);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$getWorkProfileNotSupportedMsg$3(String launcherName) {
        return getString(17039639, new Object[]{launcherName});
    }

    public Intent getReplacementIntent(ActivityInfo aInfo, Intent defIntent) {
        return defIntent;
    }

    @Override // com.android.internal.app.ResolverListAdapter.ResolverListCommunicator
    public final void onPostListReady(ResolverListAdapter listAdapter, boolean doPostProcessing, boolean rebuildCompleted) {
        if (isDestroyed() || isAutolaunching()) {
            return;
        }
        if (this.mIsIntentPicker) {
            ((ResolverMultiProfilePagerAdapter) this.mMultiProfilePagerAdapter).setUseLayoutWithDefault(useLayoutWithDefault());
        }
        if (this.mMultiProfilePagerAdapter.shouldShowEmptyStateScreen(listAdapter)) {
            this.mMultiProfilePagerAdapter.showEmptyResolverListEmptyState(listAdapter);
        } else {
            this.mMultiProfilePagerAdapter.showListView(listAdapter);
        }
        if ((!rebuildCompleted || !maybeAutolaunchActivity()) && doPostProcessing) {
            maybeCreateHeader(listAdapter);
            resetButtonBar();
            onListRebuilt(listAdapter, rebuildCompleted);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onListRebuilt(ResolverListAdapter listAdapter, boolean rebuildCompleted) {
        ResolverDrawerLayout rdl;
        int i10;
        if (!this.mResolverWrapper.getResolverActivityExt().hookonListRebuilt()) {
            ItemClickListener listener = new ItemClickListener();
            setupAdapterListView((ListView) this.mMultiProfilePagerAdapter.getActiveAdapterView(), listener);
        }
        if (shouldShowTabs() && this.mIsIntentPicker && (rdl = findViewById(16908905)) != null) {
            Resources resources = getResources();
            if (useLayoutWithDefault()) {
                i10 = 17105527;
            } else {
                i10 = 17105528;
            }
            rdl.setMaxCollapsedHeight(resources.getDimensionPixelSize(i10));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00e7, code lost:
    
        if (r3 != null) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00ed, code lost:
    
        if (r3.hasNext() == false) goto L127;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00ef, code lost:
    
        r6 = r3.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00f9, code lost:
    
        if (r6.match(r12) < 0) goto L128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00fb, code lost:
    
        r14 = r6.getPort();
        r15 = r6.getHost();
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0103, code lost:
    
        if (r14 < 0) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0105, code lost:
    
        r5 = java.lang.Integer.toString(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x010d, code lost:
    
        r7.addDataAuthority(r15, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x010c, code lost:
    
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0112, code lost:
    
        r0 = r2.filter.pathsIterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0118, code lost:
    
        if (r0 == null) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x011a, code lost:
    
        r5 = r12.getPath();
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x011e, code lost:
    
        if (r5 == null) goto L131;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0124, code lost:
    
        if (r0.hasNext() == false) goto L130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0126, code lost:
    
        r6 = r0.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0130, code lost:
    
        if (r6.match(r5) == false) goto L132;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0132, code lost:
    
        r7.addDataPath(r6.getPath(), r6.getType());
     */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01fb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTargetSelected(com.android.internal.app.chooser.TargetInfo r20, boolean r21) {
        /*
            Method dump skipped, instructions count: 585
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.internal.app.ResolverActivity.onTargetSelected(com.android.internal.app.chooser.TargetInfo, boolean):boolean");
    }

    public final void safelyStartActivity(TargetInfo cti) {
        UserHandle activityUserHandle = getResolveInfoUserHandle(cti.getResolveInfo(), this.mMultiProfilePagerAdapter.getCurrentUserHandle());
        safelyStartActivityAsUser(cti, activityUserHandle, null);
    }

    public final void safelyStartActivityAsUser(TargetInfo cti, UserHandle user) {
        safelyStartActivityAsUser(cti, user, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void safelyStartActivityAsUser(TargetInfo cti, UserHandle user, Bundle options) {
        StrictMode.disableDeathOnFileUriExposure();
        try {
            safelyStartActivityInternal(cti, user, options);
        } finally {
            StrictMode.enableDeathOnFileUriExposure();
        }
    }

    protected void safelyStartActivityInternal(TargetInfo cti, UserHandle user, Bundle options) {
        if (!cti.isSuspended() && this.mRegistered) {
            PackageMonitor packageMonitor = this.mPersonalPackageMonitor;
            if (packageMonitor != null) {
                packageMonitor.unregister();
            }
            PackageMonitor packageMonitor2 = this.mWorkPackageMonitor;
            if (packageMonitor2 != null) {
                packageMonitor2.unregister();
            }
            this.mRegistered = false;
        }
        String str = this.mProfileSwitchMessage;
        if (str != null) {
            Toast.makeText(this, str, 1).show();
        }
        if (!this.mSafeForwardingMode) {
            if (cti.startAsUser(this, options, user)) {
                onActivityStarted(cti);
                maybeLogCrossProfileTargetLaunch(cti, user);
                return;
            }
            return;
        }
        try {
            if (cti.startAsCaller(this, options, user.getIdentifier())) {
                onActivityStarted(cti);
                maybeLogCrossProfileTargetLaunch(cti, user);
            }
        } catch (RuntimeException e2) {
            Slog.wtf(TAG, "Unable to launch as uid " + this.mLaunchedFromUid + " package " + getLaunchedFromPackage() + ", while running in " + ActivityThread.currentProcessName(), e2);
        }
    }

    private void maybeLogCrossProfileTargetLaunch(TargetInfo cti, UserHandle currentUserHandle) {
        if (!hasWorkProfile() || currentUserHandle.equals(getUser())) {
            return;
        }
        DevicePolicyEventLogger devicePolicyEventLogger = DevicePolicyEventLogger.createEvent(155).setBoolean(currentUserHandle.equals(getPersonalProfileUserHandle()));
        String[] strArr = new String[2];
        strArr[0] = getMetricsCategory();
        strArr[1] = cti instanceof ChooserTargetInfo ? ChooserActivity.LAUNCH_LOCATION_DIRECT_SHARE : "other_target";
        devicePolicyEventLogger.setStrings(strArr).write();
    }

    public void onActivityStarted(TargetInfo cti) {
    }

    public boolean shouldGetActivityMetadata() {
        return false;
    }

    public boolean shouldAutoLaunchSingleChoice(TargetInfo target) {
        return !target.isSuspended();
    }

    void showTargetDetails(ResolveInfo ri) {
        Intent in = new Intent().setAction("android.settings.APPLICATION_DETAILS_SETTINGS").setData(Uri.fromParts("package", ri.activityInfo.packageName, null)).addFlags(524288);
        startActivityAsUser(in, this.mMultiProfilePagerAdapter.getCurrentUserHandle());
        this.mResolverWrapper.getResolverActivityExt().performAnimation();
    }

    protected ResolverListAdapter createResolverListAdapter(Context context, List<Intent> payloadIntents, Intent[] initialIntents, List<ResolveInfo> rList, boolean filterLastUsed, UserHandle userHandle) {
        UserHandle initialIntentsUserSpace;
        Intent startIntent = getIntent();
        boolean isAudioCaptureDevice = startIntent.getBooleanExtra(EXTRA_IS_AUDIO_CAPTURE_DEVICE, false);
        if (!isLaunchedAsCloneProfile() || !userHandle.equals(getPersonalProfileUserHandle())) {
            initialIntentsUserSpace = userHandle;
        } else {
            initialIntentsUserSpace = getCloneProfileUserHandle();
        }
        return new ResolverListAdapter(context, payloadIntents, initialIntents, rList, filterLastUsed, createListController(userHandle), this, isAudioCaptureDevice, initialIntentsUserSpace);
    }

    protected ResolverListController createListController(UserHandle userHandle) {
        UserHandle queryIntentsUser = getQueryIntentsUser(userHandle);
        ResolverRankerServiceResolverComparator resolverComparator = new ResolverRankerServiceResolverComparator(this, getTargetIntent(), getReferrerPackageName(), (AbstractResolverComparator.AfterCompute) null, (ChooserActivityLogger) null, getResolverRankerServiceUserHandleList(userHandle));
        return new ResolverListController(this, this.mPm, getTargetIntent(), getReferrerPackageName(), this.mLaunchedFromUid, userHandle, resolverComparator, queryIntentsUser);
    }

    private boolean configureContentView() {
        if (this.mMultiProfilePagerAdapter.getActiveListAdapter() == null) {
            throw new IllegalStateException("mMultiProfilePagerAdapter.getCurrentListAdapter() cannot be null.");
        }
        Trace.beginSection("configureContentView");
        boolean rebuildCompleted = this.mMultiProfilePagerAdapter.rebuildActiveTab(true) || this.mMultiProfilePagerAdapter.getActiveListAdapter().isTabLoaded();
        if (shouldShowTabs()) {
            boolean rebuildInactiveCompleted = this.mMultiProfilePagerAdapter.rebuildInactiveTab(false) || this.mMultiProfilePagerAdapter.getInactiveListAdapter().isTabLoaded();
            rebuildCompleted = rebuildCompleted && rebuildInactiveCompleted;
        }
        if (shouldUseMiniResolver()) {
            configureMiniResolverContent();
            Trace.endSection();
            return false;
        }
        if (useLayoutWithDefault()) {
            this.mLayoutId = 17367300;
        } else {
            this.mLayoutId = getLayoutResource();
        }
        if (this.mResolverWrapper.getResolverActivityExt().isOriginUi()) {
            setContentView(this.mLayoutId);
            this.mMultiProfilePagerAdapter.setupViewPager((ViewPager) findViewById(16909399));
        }
        boolean result = postRebuildList(rebuildCompleted);
        if (!result) {
            this.mResolverWrapper.getResolverActivityExt().hookconfigureContentView(this.mSafeForwardingMode, this.mSupportsAlwaysUseOption, this.mLayoutId);
        }
        Trace.endSection();
        return result;
    }

    /* JADX WARN: Type inference failed for: r12v0, types: [com.android.internal.app.ResolverActivity$5] */
    private void configureMiniResolverContent() {
        this.mLayoutId = 17367212;
        if (this.mResolverWrapper.getResolverActivityExt().isOriginUi()) {
            setContentView(this.mLayoutId);
        } else {
            this.mResolverWrapper.getResolverActivityExt().hookeConfigureMiniResolverContent();
        }
        final DisplayResolveInfo sameProfileResolveInfo = this.mMultiProfilePagerAdapter.getActiveListAdapter().mDisplayList.get(0);
        boolean inWorkProfile = getCurrentProfile() == 1;
        final ResolverListAdapter inactiveAdapter = this.mMultiProfilePagerAdapter.getInactiveListAdapter();
        final DisplayResolveInfo otherProfileResolveInfo = inactiveAdapter.mDisplayList.get(0);
        ImageView icon = (ImageView) findViewById(16908294);
        Objects.requireNonNull(inactiveAdapter);
        new ResolverListAdapter.LoadIconTask(inactiveAdapter, otherProfileResolveInfo, otherProfileResolveInfo, icon) { // from class: com.android.internal.app.ResolverActivity.5
            final /* synthetic */ ImageView val$icon;
            final /* synthetic */ DisplayResolveInfo val$otherProfileResolveInfo;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(otherProfileResolveInfo);
                this.val$otherProfileResolveInfo = otherProfileResolveInfo;
                this.val$icon = icon;
                Objects.requireNonNull(inactiveAdapter);
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.android.internal.app.ResolverListAdapter.LoadIconTask, android.os.AsyncTask
            public void onPostExecute(Drawable drawable) {
                if (!ResolverActivity.this.isDestroyed()) {
                    this.val$otherProfileResolveInfo.setDisplayIcon(drawable);
                    new ResolverListAdapter.ViewHolder(this.val$icon).bindIcon(this.val$otherProfileResolveInfo);
                }
            }
        }.execute(new Void[0]);
        final CharSequence targetDisplayLabel = otherProfileResolveInfo.getDisplayLabel();
        DevicePolicyResourcesManager devicePolicyResourcesManager = ((DevicePolicyManager) getSystemService(DevicePolicyManager.class)).getResources();
        if (inWorkProfile) {
            ((TextView) findViewById(16909332)).setText(devicePolicyResourcesManager.getString("Core.MINIRESOLVER_OPEN_IN_PERSONAL", new Supplier() { // from class: com.android.internal.app.ResolverActivity$$ExternalSyntheticLambda12
                @Override // java.util.function.Supplier
                public final Object get() {
                    String lambda$configureMiniResolverContent$4;
                    lambda$configureMiniResolverContent$4 = ResolverActivity.this.lambda$configureMiniResolverContent$4(targetDisplayLabel);
                    return lambda$configureMiniResolverContent$4;
                }
            }, targetDisplayLabel));
            ((Button) findViewById(R.id.use_same_profile_browser)).setText(devicePolicyResourcesManager.getString("Core.MINIRESOLVER_OPEN_IN_PERSONAL", new Supplier() { // from class: com.android.internal.app.ResolverActivity$$ExternalSyntheticLambda13
                @Override // java.util.function.Supplier
                public final Object get() {
                    String lambda$configureMiniResolverContent$5;
                    lambda$configureMiniResolverContent$5 = ResolverActivity.this.lambda$configureMiniResolverContent$5();
                    return lambda$configureMiniResolverContent$5;
                }
            }));
        } else {
            ((TextView) findViewById(16909332)).setText(devicePolicyResourcesManager.getString("Core.MINIRESOLVER_OPEN_IN_WORK", new Supplier() { // from class: com.android.internal.app.ResolverActivity$$ExternalSyntheticLambda14
                @Override // java.util.function.Supplier
                public final Object get() {
                    String lambda$configureMiniResolverContent$6;
                    lambda$configureMiniResolverContent$6 = ResolverActivity.this.lambda$configureMiniResolverContent$6(targetDisplayLabel);
                    return lambda$configureMiniResolverContent$6;
                }
            }, targetDisplayLabel));
            ((Button) findViewById(R.id.use_same_profile_browser)).setText(devicePolicyResourcesManager.getString("Core.MINIRESOLVER_OPEN_IN_PERSONAL", new Supplier() { // from class: com.android.internal.app.ResolverActivity$$ExternalSyntheticLambda15
                @Override // java.util.function.Supplier
                public final Object get() {
                    String lambda$configureMiniResolverContent$7;
                    lambda$configureMiniResolverContent$7 = ResolverActivity.this.lambda$configureMiniResolverContent$7();
                    return lambda$configureMiniResolverContent$7;
                }
            }));
        }
        findViewById(R.id.use_same_profile_browser).setOnClickListener(new View.OnClickListener() { // from class: com.android.internal.app.ResolverActivity$$ExternalSyntheticLambda16
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ResolverActivity.this.lambda$configureMiniResolverContent$8(sameProfileResolveInfo, view);
            }
        });
        findViewById(16908850).setOnClickListener(new View.OnClickListener() { // from class: com.android.internal.app.ResolverActivity$$ExternalSyntheticLambda17
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ResolverActivity.this.lambda$configureMiniResolverContent$9(otherProfileResolveInfo, inactiveAdapter, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$configureMiniResolverContent$4(CharSequence targetDisplayLabel) {
        return getString(17040864, new Object[]{targetDisplayLabel});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$configureMiniResolverContent$5() {
        return getString(17040871);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$configureMiniResolverContent$6(CharSequence targetDisplayLabel) {
        return getString(17040865, new Object[]{targetDisplayLabel});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$configureMiniResolverContent$7() {
        return getString(17040870);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$configureMiniResolverContent$8(DisplayResolveInfo sameProfileResolveInfo, View v2) {
        safelyStartActivity(sameProfileResolveInfo);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$configureMiniResolverContent$9(DisplayResolveInfo otherProfileResolveInfo, ResolverListAdapter inactiveAdapter, View v2) {
        otherProfileResolveInfo.getResolvedIntent();
        safelyStartActivityAsUser(otherProfileResolveInfo, inactiveAdapter.mResolverListController.getUserHandle());
        finish();
    }

    private boolean shouldUseMiniResolver() {
        if (!this.mIsIntentPicker || this.mMultiProfilePagerAdapter.getActiveListAdapter() == null || this.mMultiProfilePagerAdapter.getInactiveListAdapter() == null) {
            return false;
        }
        List<DisplayResolveInfo> sameProfileList = this.mMultiProfilePagerAdapter.getActiveListAdapter().mDisplayList;
        List<DisplayResolveInfo> otherProfileList = this.mMultiProfilePagerAdapter.getInactiveListAdapter().mDisplayList;
        if (sameProfileList.isEmpty()) {
            Log.d(TAG, "No targets in the current profile");
            return false;
        }
        if (otherProfileList.size() != 1) {
            Log.d(TAG, "Found " + otherProfileList.size() + " resolvers in the other profile");
            return false;
        }
        if (otherProfileList.get(0).getResolveInfo().handleAllWebDataURI) {
            Log.d(TAG, "Other profile is a web browser");
            return false;
        }
        for (DisplayResolveInfo info : sameProfileList) {
            if (!info.getResolveInfo().handleAllWebDataURI) {
                Log.d(TAG, "Non-browser found in this profile");
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean postRebuildList(boolean rebuildCompleted) {
        return postRebuildListInternal(rebuildCompleted);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean postRebuildListInternal(boolean rebuildCompleted) {
        this.mMultiProfilePagerAdapter.getActiveListAdapter().getUnfilteredCount();
        if (rebuildCompleted && maybeAutolaunchActivity()) {
            return true;
        }
        if (!this.mResolverWrapper.getResolverActivityExt().isOriginUi()) {
            return false;
        }
        setupViewVisibilities();
        if (shouldShowTabs()) {
            setupProfileTabs();
        }
        return false;
    }

    private int isPermissionGranted(String permission, int uid) {
        return ActivityManager.checkComponentPermission(permission, uid, -1, true);
    }

    private boolean maybeAutolaunchActivity() {
        if (!this.mResolverWrapper.getResolverActivityExt().addExtraOneAppFinish()) {
            return false;
        }
        int numberOfProfiles = this.mMultiProfilePagerAdapter.getItemCount();
        if (numberOfProfiles == 1 && maybeAutolaunchIfSingleTarget()) {
            return true;
        }
        return numberOfProfiles == 2 && this.mMultiProfilePagerAdapter.getActiveListAdapter().isTabLoaded() && this.mMultiProfilePagerAdapter.getInactiveListAdapter().isTabLoaded() && (maybeAutolaunchIfNoAppsOnInactiveTab() || maybeAutolaunchIfCrossProfileSupported());
    }

    private boolean maybeAutolaunchIfSingleTarget() {
        int count = this.mMultiProfilePagerAdapter.getActiveListAdapter().getUnfilteredCount();
        if (count != 1 || this.mMultiProfilePagerAdapter.getActiveListAdapter().getOtherProfile() != null) {
            return false;
        }
        TargetInfo target = this.mMultiProfilePagerAdapter.getActiveListAdapter().targetInfoForPosition(0, false);
        if (!shouldAutoLaunchSingleChoice(target)) {
            return false;
        }
        safelyStartActivity(target);
        finish();
        return true;
    }

    private boolean maybeAutolaunchIfNoAppsOnInactiveTab() {
        int count = this.mMultiProfilePagerAdapter.getActiveListAdapter().getUnfilteredCount();
        if (count != 1) {
            return false;
        }
        ResolverListAdapter inactiveListAdapter = this.mMultiProfilePagerAdapter.getInactiveListAdapter();
        if (inactiveListAdapter.getUnfilteredCount() != 0) {
            return false;
        }
        TargetInfo target = this.mMultiProfilePagerAdapter.getActiveListAdapter().targetInfoForPosition(0, false);
        safelyStartActivity(target);
        finish();
        return true;
    }

    private boolean maybeAutolaunchIfCrossProfileSupported() {
        ResolverListAdapter activeListAdapter = this.mMultiProfilePagerAdapter.getActiveListAdapter();
        int count = activeListAdapter.getUnfilteredCount();
        if (count != 1) {
            return false;
        }
        ResolverListAdapter inactiveListAdapter = this.mMultiProfilePagerAdapter.getInactiveListAdapter();
        if (inactiveListAdapter.getUnfilteredCount() != 1) {
            return false;
        }
        TargetInfo activeProfileTarget = activeListAdapter.targetInfoForPosition(0, false);
        TargetInfo inactiveProfileTarget = inactiveListAdapter.targetInfoForPosition(0, false);
        if (!Objects.equals(activeProfileTarget.getResolvedComponentName(), inactiveProfileTarget.getResolvedComponentName()) || !shouldAutoLaunchSingleChoice(activeProfileTarget)) {
            return false;
        }
        String packageName = activeProfileTarget.getResolvedComponentName().getPackageName();
        if (!canAppInteractCrossProfiles(packageName)) {
            return false;
        }
        DevicePolicyEventLogger.createEvent(161).setBoolean(activeListAdapter.getUserHandle().equals(getPersonalProfileUserHandle())).setStrings(new String[]{getMetricsCategory()}).write();
        safelyStartActivity(activeProfileTarget);
        finish();
        return true;
    }

    private boolean canAppInteractCrossProfiles(String packageName) {
        try {
            ApplicationInfo applicationInfo = getPackageManager().getApplicationInfo(packageName, 0);
            if (!applicationInfo.crossProfile) {
                return false;
            }
            int packageUid = applicationInfo.uid;
            return isPermissionGranted("android.permission.INTERACT_ACROSS_USERS_FULL", packageUid) == 0 || isPermissionGranted("android.permission.INTERACT_ACROSS_USERS", packageUid) == 0 || PermissionChecker.checkPermissionForPreflight(this, "android.permission.INTERACT_ACROSS_PROFILES", -1, packageUid, packageName) == 0;
        } catch (PackageManager.NameNotFoundException e2) {
            Log.e(TAG, "Package " + packageName + " does not exist on current user.");
            return false;
        }
    }

    private boolean isAutolaunching() {
        return !this.mRegistered && isFinishing();
    }

    private void setupProfileTabs() {
        maybeHideDivider();
        final TabHost tabHost = (TabHost) findViewById(16909400);
        tabHost.setup();
        final ViewPager viewPager = findViewById(16909399);
        viewPager.setSaveEnabled(false);
        Button personalButton = (Button) getLayoutInflater().inflate(17367301, (ViewGroup) tabHost.getTabWidget(), false);
        personalButton.setText(getPersonalTabLabel());
        personalButton.setContentDescription(getPersonalTabAccessibilityLabel());
        TabHost.TabSpec tabSpec = tabHost.newTabSpec(TAB_TAG_PERSONAL).setContent(16909399).setIndicator(personalButton);
        tabHost.addTab(tabSpec);
        Button workButton = (Button) getLayoutInflater().inflate(17367301, (ViewGroup) tabHost.getTabWidget(), false);
        workButton.setText(getWorkTabLabel());
        workButton.setContentDescription(getWorkTabAccessibilityLabel());
        TabHost.TabSpec tabSpec2 = tabHost.newTabSpec(TAB_TAG_WORK).setContent(16909399).setIndicator(workButton);
        tabHost.addTab(tabSpec2);
        TabWidget tabWidget = tabHost.getTabWidget();
        tabWidget.setVisibility(0);
        updateActiveTabStyle(tabHost);
        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() { // from class: com.android.internal.app.ResolverActivity$$ExternalSyntheticLambda10
            @Override // android.widget.TabHost.OnTabChangeListener
            public final void onTabChanged(String str) {
                ResolverActivity.this.lambda$setupProfileTabs$10(tabHost, viewPager, str);
            }
        });
        viewPager.setVisibility(0);
        tabHost.setCurrentTab(this.mMultiProfilePagerAdapter.getCurrentPage());
        this.mMultiProfilePagerAdapter.setOnProfileSelectedListener(new AbstractMultiProfilePagerAdapter.OnProfileSelectedListener() { // from class: com.android.internal.app.ResolverActivity.6
            @Override // com.android.internal.app.AbstractMultiProfilePagerAdapter.OnProfileSelectedListener
            public void onProfileSelected(int index) {
                tabHost.setCurrentTab(index);
                ResolverActivity.this.resetButtonBar();
                ResolverActivity.this.resetCheckedItem();
            }

            @Override // com.android.internal.app.AbstractMultiProfilePagerAdapter.OnProfileSelectedListener
            public void onProfilePageStateChanged(int state) {
                ResolverActivity.this.onHorizontalSwipeStateChanged(state);
            }
        });
        this.mOnSwitchOnWorkSelectedListener = new AbstractMultiProfilePagerAdapter.OnSwitchOnWorkSelectedListener() { // from class: com.android.internal.app.ResolverActivity$$ExternalSyntheticLambda11
            @Override // com.android.internal.app.AbstractMultiProfilePagerAdapter.OnSwitchOnWorkSelectedListener
            public final void onSwitchOnWorkSelected() {
                ResolverActivity.lambda$setupProfileTabs$11(TabHost.this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setupProfileTabs$10(TabHost tabHost, ViewPager viewPager, String tabId) {
        updateActiveTabStyle(tabHost);
        if (TAB_TAG_PERSONAL.equals(tabId)) {
            viewPager.setCurrentItem(0);
        } else {
            viewPager.setCurrentItem(1);
        }
        setupViewVisibilities();
        maybeLogProfileChange();
        onProfileTabSelected();
        DevicePolicyEventLogger.createEvent(156).setInt(viewPager.getCurrentItem()).setStrings(new String[]{getMetricsCategory()}).write();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$setupProfileTabs$11(TabHost tabHost) {
        View workTab = tabHost.getTabWidget().getChildAt(1);
        workTab.setFocusable(true);
        workTab.setFocusableInTouchMode(true);
        workTab.requestFocus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getPersonalTabLabel() {
        return ((DevicePolicyManager) getSystemService(DevicePolicyManager.class)).getResources().getString("Core.RESOLVER_PERSONAL_TAB", new Supplier() { // from class: com.android.internal.app.ResolverActivity$$ExternalSyntheticLambda0
            @Override // java.util.function.Supplier
            public final Object get() {
                String lambda$getPersonalTabLabel$12;
                lambda$getPersonalTabLabel$12 = ResolverActivity.this.lambda$getPersonalTabLabel$12();
                return lambda$getPersonalTabLabel$12;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$getPersonalTabLabel$12() {
        return getString(17041512);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getWorkTabLabel() {
        return ((DevicePolicyManager) getSystemService(DevicePolicyManager.class)).getResources().getString("Core.RESOLVER_WORK_TAB", new Supplier() { // from class: com.android.internal.app.ResolverActivity$$ExternalSyntheticLambda7
            @Override // java.util.function.Supplier
            public final Object get() {
                String lambda$getWorkTabLabel$13;
                lambda$getWorkTabLabel$13 = ResolverActivity.this.lambda$getWorkTabLabel$13();
                return lambda$getWorkTabLabel$13;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$getWorkTabLabel$13() {
        return getString(17041516);
    }

    void onHorizontalSwipeStateChanged(int state) {
    }

    private void maybeHideDivider() {
        View divider;
        if (!this.mIsIntentPicker || (divider = findViewById(16908974)) == null) {
            return;
        }
        divider.setVisibility(8);
    }

    protected void onProfileTabSelected() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetCheckedItem() {
        if (!this.mIsIntentPicker) {
            return;
        }
        this.mLastSelected = -1;
        ListView inactiveListView = (ListView) this.mMultiProfilePagerAdapter.getInactiveAdapterView();
        if (inactiveListView.getCheckedItemCount() > 0) {
            inactiveListView.setItemChecked(inactiveListView.getCheckedItemPosition(), false);
        }
    }

    private String getPersonalTabAccessibilityLabel() {
        return ((DevicePolicyManager) getSystemService(DevicePolicyManager.class)).getResources().getString("Core.RESOLVER_PERSONAL_TAB_ACCESSIBILITY", new Supplier() { // from class: com.android.internal.app.ResolverActivity$$ExternalSyntheticLambda1
            @Override // java.util.function.Supplier
            public final Object get() {
                String lambda$getPersonalTabAccessibilityLabel$14;
                lambda$getPersonalTabAccessibilityLabel$14 = ResolverActivity.this.lambda$getPersonalTabAccessibilityLabel$14();
                return lambda$getPersonalTabAccessibilityLabel$14;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$getPersonalTabAccessibilityLabel$14() {
        return getString(17041513);
    }

    private String getWorkTabAccessibilityLabel() {
        return ((DevicePolicyManager) getSystemService(DevicePolicyManager.class)).getResources().getString("Core.RESOLVER_WORK_TAB_ACCESSIBILITY", new Supplier() { // from class: com.android.internal.app.ResolverActivity$$ExternalSyntheticLambda5
            @Override // java.util.function.Supplier
            public final Object get() {
                String lambda$getWorkTabAccessibilityLabel$15;
                lambda$getWorkTabAccessibilityLabel$15 = ResolverActivity.this.lambda$getWorkTabAccessibilityLabel$15();
                return lambda$getWorkTabAccessibilityLabel$15;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$getWorkTabAccessibilityLabel$15() {
        return getString(17041517);
    }

    private static int getAttrColor(Context context, int attr) {
        TypedArray ta2 = context.obtainStyledAttributes(new int[]{attr});
        int colorAccent = ta2.getColor(0, 0);
        ta2.recycle();
        return colorAccent;
    }

    private void updateActiveTabStyle(TabHost tabHost) {
        int currentTab = tabHost.getCurrentTab();
        TextView selected = (TextView) tabHost.getTabWidget().getChildAt(currentTab);
        TextView unselected = (TextView) tabHost.getTabWidget().getChildAt(1 - currentTab);
        selected.setSelected(true);
        unselected.setSelected(false);
    }

    private void setupViewVisibilities() {
        ResolverListAdapter activeListAdapter = this.mMultiProfilePagerAdapter.getActiveListAdapter();
        if (!this.mMultiProfilePagerAdapter.shouldShowEmptyStateScreen(activeListAdapter)) {
            addUseDifferentAppLabelIfNecessary(activeListAdapter);
        }
    }

    public void addUseDifferentAppLabelIfNecessary(ResolverListAdapter adapter) {
        boolean useHeader = adapter.hasFilteredItem();
        if (useHeader) {
            FrameLayout stub = (FrameLayout) findViewById(16909576);
            stub.setVisibility(0);
            TextView textView = (TextView) LayoutInflater.from(this).inflate(17367296, (ViewGroup) null, false);
            if (shouldShowTabs()) {
                textView.setGravity(17);
            }
            stub.addView(textView);
        }
    }

    private void setupAdapterListView(ListView listView, ItemClickListener listener) {
        listView.setOnItemClickListener(listener);
        listView.setOnItemLongClickListener(listener);
        if (this.mSupportsAlwaysUseOption) {
            listView.setChoiceMode(1);
        }
    }

    private void maybeCreateHeader(ResolverListAdapter listAdapter) {
        TextView titleView;
        if (!this.mResolverWrapper.getResolverActivityExt().isOriginUi()) {
            return;
        }
        if (this.mHeaderCreatorUser != null && !listAdapter.getUserHandle().equals(this.mHeaderCreatorUser)) {
            return;
        }
        if (!shouldShowTabs() && listAdapter.getCount() == 0 && listAdapter.getPlaceholderCount() == 0 && (titleView = (TextView) findViewById(16908310)) != null) {
            titleView.setVisibility(8);
        }
        CharSequence title = this.mTitle;
        if (title == null) {
            title = getTitleForAction(getTargetIntent(), this.mDefaultTitleResId);
        }
        if (!TextUtils.isEmpty(title)) {
            TextView titleView2 = (TextView) findViewById(16908310);
            if (titleView2 != null) {
                titleView2.setText(title);
            }
            setTitle(title);
        }
        ImageView iconView = (ImageView) findViewById(16908294);
        if (iconView != null) {
            listAdapter.loadFilteredItemIconTaskAsync(iconView);
        }
        this.mHeaderCreatorUser = listAdapter.getUserHandle();
    }

    protected void resetButtonBar() {
        if (!this.mResolverWrapper.getResolverActivityExt().isOriginUi() || !this.mSupportsAlwaysUseOption) {
            return;
        }
        ViewGroup buttonLayout = (ViewGroup) findViewById(16908847);
        if (buttonLayout == null) {
            Log.e(TAG, "Layout unexpectedly does not have a button bar");
            return;
        }
        ResolverListAdapter activeListAdapter = this.mMultiProfilePagerAdapter.getActiveListAdapter();
        View buttonBarDivider = findViewById(16909434);
        if (!useLayoutWithDefault()) {
            Insets insets = this.mSystemWindowInsets;
            int inset = insets != null ? insets.bottom : 0;
            buttonLayout.setPadding(buttonLayout.getPaddingLeft(), buttonLayout.getPaddingTop(), buttonLayout.getPaddingRight(), getResources().getDimensionPixelSize(17105516) + inset);
        }
        if (activeListAdapter.isTabLoaded() && this.mMultiProfilePagerAdapter.shouldShowEmptyStateScreen(activeListAdapter) && !useLayoutWithDefault()) {
            buttonLayout.setVisibility(4);
            if (buttonBarDivider != null) {
                buttonBarDivider.setVisibility(4);
            }
            setButtonBarIgnoreOffset(false);
            return;
        }
        if (buttonBarDivider != null) {
            buttonBarDivider.setVisibility(0);
        }
        buttonLayout.setVisibility(0);
        setButtonBarIgnoreOffset(true);
        this.mOnceButton = (Button) buttonLayout.findViewById(16908849);
        this.mAlwaysButton = (Button) buttonLayout.findViewById(16908846);
        resetAlwaysOrOnceButtonBar();
    }

    private void setButtonBarIgnoreOffset(boolean ignoreOffset) {
        View buttonBarContainer = findViewById(16908848);
        if (buttonBarContainer != null) {
            ResolverDrawerLayout.LayoutParams layoutParams = buttonBarContainer.getLayoutParams();
            layoutParams.ignoreOffset = ignoreOffset;
            buttonBarContainer.setLayoutParams(layoutParams);
        }
    }

    private void resetAlwaysOrOnceButtonBar() {
        setAlwaysButtonEnabled(false, -1, false);
        this.mOnceButton.setEnabled(false);
        int filteredPosition = this.mMultiProfilePagerAdapter.getActiveListAdapter().getFilteredPosition();
        if (useLayoutWithDefault() && filteredPosition != -1) {
            setAlwaysButtonEnabled(true, filteredPosition, false);
            this.mOnceButton.setEnabled(true);
            this.mOnceButton.requestFocus();
        } else {
            ListView currentAdapterView = (ListView) this.mMultiProfilePagerAdapter.getActiveAdapterView();
            if (currentAdapterView != null && currentAdapterView.getCheckedItemPosition() != -1) {
                setAlwaysButtonEnabled(true, currentAdapterView.getCheckedItemPosition(), true);
                this.mOnceButton.setEnabled(true);
            }
        }
    }

    @Override // com.android.internal.app.ResolverListAdapter.ResolverListCommunicator
    public boolean useLayoutWithDefault() {
        boolean adapterForCurrentUserHasFilteredItem = this.mMultiProfilePagerAdapter.getListAdapterForUserHandle(getTabOwnerUserHandleForLaunch()).hasFilteredItem();
        return this.mSupportsAlwaysUseOption && adapterForCurrentUserHasFilteredItem;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setRetainInOnStop(boolean retainInOnStop) {
        this.mRetainInOnStop = retainInOnStop;
    }

    @Override // com.android.internal.app.ResolverListAdapter.ResolverListCommunicator
    public boolean resolveInfoMatch(ResolveInfo lhs, ResolveInfo rhs) {
        return lhs == null ? rhs == null : lhs.activityInfo == null ? rhs.activityInfo == null : Objects.equals(lhs.activityInfo.name, rhs.activityInfo.name) && Objects.equals(lhs.activityInfo.packageName, rhs.activityInfo.packageName) && Objects.equals(getResolveInfoUserHandle(lhs, this.mMultiProfilePagerAdapter.getActiveListAdapter().getUserHandle()), getResolveInfoUserHandle(rhs, this.mMultiProfilePagerAdapter.getActiveListAdapter().getUserHandle()));
    }

    protected String getMetricsCategory() {
        return METRICS_CATEGORY_RESOLVER;
    }

    public void onHandlePackagesChanged(ResolverListAdapter listAdapter) {
        if (listAdapter == this.mMultiProfilePagerAdapter.getActiveListAdapter()) {
            if (listAdapter.getUserHandle().equals(getWorkProfileUserHandle()) && this.mQuietModeManager.isWaitingToEnableWorkProfile()) {
                return;
            }
            boolean listRebuilt = this.mMultiProfilePagerAdapter.rebuildActiveTab(true);
            if (listRebuilt) {
                ResolverListAdapter activeListAdapter = this.mMultiProfilePagerAdapter.getActiveListAdapter();
                activeListAdapter.notifyDataSetChanged();
                if (activeListAdapter.getCount() == 0 && !inactiveListAdapterHasItems()) {
                    finish();
                    return;
                }
                return;
            }
            return;
        }
        this.mMultiProfilePagerAdapter.clearInactiveProfileCache();
    }

    private boolean inactiveListAdapterHasItems() {
        return shouldShowTabs() && this.mMultiProfilePagerAdapter.getInactiveListAdapter().getCount() > 0;
    }

    private BroadcastReceiver createWorkProfileStateReceiver() {
        return new BroadcastReceiver() { // from class: com.android.internal.app.ResolverActivity.7
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                if (!TextUtils.equals(action, "android.intent.action.USER_UNLOCKED") && !TextUtils.equals(action, "android.intent.action.MANAGED_PROFILE_UNAVAILABLE") && !TextUtils.equals(action, "android.intent.action.MANAGED_PROFILE_AVAILABLE")) {
                    return;
                }
                int userId = intent.getIntExtra("android.intent.extra.user_handle", -1);
                if (userId != ResolverActivity.this.getWorkProfileUserHandle().getIdentifier()) {
                    return;
                }
                if (ResolverActivity.this.isWorkProfileEnabled()) {
                    if (ResolverActivity.this.mWorkProfileHasBeenEnabled) {
                        return;
                    }
                    ResolverActivity.this.mWorkProfileHasBeenEnabled = true;
                    ResolverActivity.this.mQuietModeManager.markWorkProfileEnabledBroadcastReceived();
                } else {
                    ResolverActivity.this.mWorkProfileHasBeenEnabled = false;
                }
                if (ResolverActivity.this.mMultiProfilePagerAdapter.getCurrentUserHandle().equals(ResolverActivity.this.getWorkProfileUserHandle())) {
                    ResolverActivity.this.mMultiProfilePagerAdapter.rebuildActiveTab(true);
                } else {
                    ResolverActivity.this.mMultiProfilePagerAdapter.clearInactiveProfileCache();
                }
            }
        };
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static final class ResolvedComponentInfo {
        private boolean mFixedAtTop;
        private boolean mPinned;
        public final ComponentName name;
        private final List<Intent> mIntents = new ArrayList();
        private final List<ResolveInfo> mResolveInfos = new ArrayList();

        public ResolvedComponentInfo(ComponentName name, Intent intent, ResolveInfo info) {
            this.name = name;
            add(intent, info);
        }

        public void add(Intent intent, ResolveInfo info) {
            this.mIntents.add(intent);
            this.mResolveInfos.add(info);
        }

        public int getCount() {
            return this.mIntents.size();
        }

        public Intent getIntentAt(int index) {
            if (index >= 0) {
                return this.mIntents.get(index);
            }
            return null;
        }

        public ResolveInfo getResolveInfoAt(int index) {
            if (index >= 0) {
                return this.mResolveInfos.get(index);
            }
            return null;
        }

        public int findIntent(Intent intent) {
            int N = this.mIntents.size();
            for (int i10 = 0; i10 < N; i10++) {
                if (intent.equals(this.mIntents.get(i10))) {
                    return i10;
                }
            }
            return -1;
        }

        public int findResolveInfo(ResolveInfo info) {
            int N = this.mResolveInfos.size();
            for (int i10 = 0; i10 < N; i10++) {
                if (info.equals(this.mResolveInfos.get(i10))) {
                    return i10;
                }
            }
            return -1;
        }

        public boolean isPinned() {
            return this.mPinned;
        }

        public void setPinned(boolean pinned) {
            this.mPinned = pinned;
        }

        public boolean isFixedAtTop() {
            return this.mFixedAtTop;
        }

        public void setFixedAtTop(boolean isFixedAtTop) {
            this.mFixedAtTop = isFixedAtTop;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public class ItemClickListener implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {
        ItemClickListener() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> parent, View view, int position, long id2) {
            ListView listView = parent instanceof ListView ? (ListView) parent : null;
            if (listView != null) {
                position -= listView.getHeaderViewsCount();
            }
            if (position < 0 || ResolverActivity.this.mMultiProfilePagerAdapter.getActiveListAdapter().resolveInfoForPosition(position, true) == null) {
                return;
            }
            ListView currentAdapterView = (ListView) ResolverActivity.this.mMultiProfilePagerAdapter.getActiveAdapterView();
            int checkedPos = currentAdapterView.getCheckedItemPosition();
            boolean hasValidSelection = checkedPos != -1;
            if (ResolverActivity.this.useLayoutWithDefault() || ((hasValidSelection && ResolverActivity.this.mLastSelected == checkedPos) || ResolverActivity.this.mAlwaysButton == null)) {
                ResolverActivity.this.startSelected(position, false, true);
                return;
            }
            ResolverActivity.this.setAlwaysButtonEnabled(hasValidSelection, checkedPos, true);
            ResolverActivity.this.mOnceButton.setEnabled(hasValidSelection);
            if (hasValidSelection) {
                currentAdapterView.smoothScrollToPosition(checkedPos);
                ResolverActivity.this.mOnceButton.requestFocus();
            }
            ResolverActivity.this.mLastSelected = checkedPos;
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id2) {
            ResolveInfo ri;
            ListView listView = parent instanceof ListView ? (ListView) parent : null;
            if (listView != null) {
                position -= listView.getHeaderViewsCount();
            }
            if (position < 0 || (ri = ResolverActivity.this.mMultiProfilePagerAdapter.getActiveListAdapter().resolveInfoForPosition(position, true)) == null) {
                return false;
            }
            ResolverActivity.this.showTargetDetails(ri);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean isSpecificUriMatch(int match) {
        int match2 = match & 268369920;
        return match2 >= 3145728 && match2 <= 5242880;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    static class PickTargetOptionRequest extends VoiceInteractor.PickOptionRequest {
        public PickTargetOptionRequest(VoiceInteractor.Prompt prompt, VoiceInteractor.PickOptionRequest.Option[] options, Bundle extras) {
            super(prompt, options, extras);
        }

        @Override // android.app.VoiceInteractor.Request
        public void onCancel() {
            super.onCancel();
            ResolverActivity ra2 = (ResolverActivity) getActivity();
            if (ra2 != null) {
                ra2.mPickOptionRequest = null;
                ra2.finish();
            }
        }

        @Override // android.app.VoiceInteractor.PickOptionRequest
        public void onPickOptionResult(boolean finished, VoiceInteractor.PickOptionRequest.Option[] selections, Bundle result) {
            ResolverActivity ra2;
            super.onPickOptionResult(finished, selections, result);
            if (selections.length == 1 && (ra2 = (ResolverActivity) getActivity()) != null) {
                TargetInfo ti = ra2.mMultiProfilePagerAdapter.getActiveListAdapter().getItem(selections[0].getIndex());
                if (ra2.onTargetSelected(ti, false)) {
                    ra2.mPickOptionRequest = null;
                    ra2.finish();
                }
            }
        }
    }

    protected void maybeLogProfileChange() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final UserHandle getQueryIntentsUser(UserHandle userHandle) {
        if (!isLaunchedAsCloneProfile() || !userHandle.equals(getPersonalProfileUserHandle())) {
            return userHandle;
        }
        UserHandle queryIntentsUser = getCloneProfileUserHandle();
        return queryIntentsUser;
    }

    public final List<UserHandle> getResolverRankerServiceUserHandleList(UserHandle userHandle) {
        return getResolverRankerServiceUserHandleListInternal(userHandle);
    }

    protected List<UserHandle> getResolverRankerServiceUserHandleListInternal(UserHandle userHandle) {
        List<UserHandle> userList = new ArrayList<>();
        userList.add(userHandle);
        if (userHandle.equals(getPersonalProfileUserHandle()) && getCloneProfileUserHandle() != null) {
            userList.add(getCloneProfileUserHandle());
        }
        return userList;
    }

    public static UserHandle getResolveInfoUserHandle(ResolveInfo resolveInfo, UserHandle predictedHandle) {
        if (resolveInfo.userHandle == null) {
            Log.e(TAG, "ResolveInfo with null UserHandle found: " + ((Object) resolveInfo));
        }
        return resolveInfo.userHandle;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.mResolverWrapper.getResolverActivityExt().hookonResume();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mResolverWrapper.getResolverActivityExt().hookonPause();
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        synchronized (this.mResolverWrapper) {
            this.mResolverWrapper.getResolverActivityExt().hookFinish();
        }
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean isInMultiWindowMode, Configuration newConfig) {
        super.onMultiWindowModeChanged(isInMultiWindowMode, newConfig);
        this.mResolverWrapper.getResolverActivityExt().hookonMultiWindowModeChanged(isInMultiWindowMode, newConfig);
    }

    public IResolverActivityWrapper getResolverWrapper() {
        return this.mResolverWrapper;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    private class ResolverActivityWrapper implements IResolverActivityWrapper {
        private ResolverActivityWrapper() {
        }

        @Override // com.android.internal.app.IResolverActivityWrapper
        public String getPersonalTabLabel() {
            return ResolverActivity.this.getPersonalTabLabel();
        }

        @Override // com.android.internal.app.IResolverActivityWrapper
        public String getWorkTabLabel() {
            return ResolverActivity.this.getWorkTabLabel();
        }

        @Override // com.android.internal.app.IResolverActivityWrapper
        public IResolverActivityExt getResolverActivityExt() {
            if (ResolverActivity.this.mResolverActivityExt == null) {
                return IResolverActivityExt.DEFAULT;
            }
            return ResolverActivity.this.mResolverActivityExt;
        }

        @Override // com.android.internal.app.IResolverActivityWrapper
        public int getLaunchedFromUid() {
            return ResolverActivity.this.getLaunchedFromUid();
        }
    }
}
