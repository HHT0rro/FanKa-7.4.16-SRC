package com.android.internal.app;

import android.app.AppGlobals;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.IPackageManager;
import android.os.Trace;
import android.os.UserHandle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.android.internal.app.AbstractMultiProfilePagerAdapter;
import com.android.internal.widget.PagerAdapter;
import com.android.internal.widget.ViewPager;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;
import system.ext.loader.core.ExtLoader;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public abstract class AbstractMultiProfilePagerAdapter extends PagerAdapter {
    static final int PROFILE_PERSONAL = 0;
    static final int PROFILE_WORK = 1;
    private static final String TAG = "AbstractMultiProfilePagerAdapter";
    private final UserHandle mCloneUserHandle;
    private final Context mContext;
    private int mCurrentPage;
    private final EmptyStateProvider mEmptyStateProvider;
    private OnProfileSelectedListener mOnProfileSelectedListener;
    private final QuietModeManager mQuietModeManager;
    private final UserHandle mWorkProfileUserHandle;
    private AbstractMultiProfilePagerAdapterWrapper mPagerAdapterWrapper = new AbstractMultiProfilePagerAdapterWrapper();
    private IAbstractMultiProfilePagerAdapterExt multiProfilePagerAdapterExt = (IAbstractMultiProfilePagerAdapterExt) ExtLoader.type(IAbstractMultiProfilePagerAdapterExt.class).base(this).create();
    private Set<Integer> mLoadedPages = new HashSet();

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public interface OnProfileSelectedListener {
        void onProfilePageStateChanged(int i10);

        void onProfileSelected(int i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public interface OnSwitchOnWorkSelectedListener {
        void onSwitchOnWorkSelected();
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    @interface Profile {
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public interface QuietModeManager {
        boolean isQuietModeEnabled(UserHandle userHandle);

        boolean isWaitingToEnableWorkProfile();

        void markWorkProfileEnabledBroadcastReceived();

        void requestQuietModeEnabled(boolean z10, UserHandle userHandle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract ViewGroup getActiveAdapterView();

    public abstract ResolverListAdapter getActiveListAdapter();

    public abstract Object getAdapterForIndex(int i10);

    abstract Object getCurrentRootAdapter();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract ViewGroup getInactiveAdapterView();

    public abstract ResolverListAdapter getInactiveListAdapter();

    abstract ProfileDescriptor getItem(int i10);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int getItemCount();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract ResolverListAdapter getListAdapterForUserHandle(UserHandle userHandle);

    public abstract ResolverListAdapter getPersonalListAdapter();

    public abstract ResolverListAdapter getWorkListAdapter();

    abstract void setupListAdapter(int i10);

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractMultiProfilePagerAdapter(Context context, int currentPage, EmptyStateProvider emptyStateProvider, QuietModeManager quietModeManager, UserHandle workProfileUserHandle, UserHandle cloneUserHandle) {
        this.mContext = (Context) Objects.requireNonNull(context);
        this.mCurrentPage = currentPage;
        this.mWorkProfileUserHandle = workProfileUserHandle;
        this.mCloneUserHandle = cloneUserHandle;
        this.mEmptyStateProvider = emptyStateProvider;
        this.mQuietModeManager = quietModeManager;
        this.multiProfilePagerAdapterExt.init(context);
    }

    private boolean isQuietModeEnabled(UserHandle workProfileUserHandle) {
        return this.mQuietModeManager.isQuietModeEnabled(workProfileUserHandle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOnProfileSelectedListener(OnProfileSelectedListener listener) {
        this.mOnProfileSelectedListener = listener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Context getContext() {
        return this.mContext;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setupViewPager(ViewPager viewPager) {
        viewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() { // from class: com.android.internal.app.AbstractMultiProfilePagerAdapter.1
            public void onPageSelected(int position) {
                AbstractMultiProfilePagerAdapter.this.mCurrentPage = position;
                if (!AbstractMultiProfilePagerAdapter.this.mLoadedPages.contains(Integer.valueOf(position))) {
                    AbstractMultiProfilePagerAdapter.this.rebuildActiveTab(true);
                    AbstractMultiProfilePagerAdapter.this.mLoadedPages.add(Integer.valueOf(position));
                }
                if (AbstractMultiProfilePagerAdapter.this.mOnProfileSelectedListener != null) {
                    AbstractMultiProfilePagerAdapter.this.mOnProfileSelectedListener.onProfileSelected(position);
                }
            }

            public void onPageScrollStateChanged(int state) {
                if (AbstractMultiProfilePagerAdapter.this.mOnProfileSelectedListener != null) {
                    AbstractMultiProfilePagerAdapter.this.mOnProfileSelectedListener.onProfilePageStateChanged(state);
                }
            }
        });
        viewPager.setAdapter(this);
        viewPager.setCurrentItem(this.mCurrentPage);
        this.mLoadedPages.add(Integer.valueOf(this.mCurrentPage));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearInactiveProfileCache() {
        if (this.mLoadedPages.size() == 1) {
            return;
        }
        this.mLoadedPages.remove(Integer.valueOf(1 - this.mCurrentPage));
        Context context = this.mContext;
        if ((context instanceof ResolverActivity) && ((ResolverActivity) context).getResolverWrapper().getResolverActivityExt() != null) {
            ((ResolverActivity) this.mContext).getResolverWrapper().getResolverActivityExt().clearInactiveProfileCache(this.mCurrentPage);
        }
    }

    @Override // 
    /* renamed from: instantiateItem, reason: merged with bridge method [inline-methods] */
    public ViewGroup mo2022instantiateItem(ViewGroup container, int position) {
        ProfileDescriptor profileDescriptor = getItem(position);
        container.addView(profileDescriptor.rootView);
        return profileDescriptor.rootView;
    }

    public void destroyItem(ViewGroup container, int position, Object view) {
        container.removeView((View) view);
    }

    public int getCount() {
        return getItemCount();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getCurrentPage() {
        return this.mCurrentPage;
    }

    public UserHandle getCurrentUserHandle() {
        return getActiveListAdapter().mResolverListController.getUserHandle();
    }

    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    public CharSequence getPageTitle(int position) {
        return null;
    }

    public UserHandle getCloneUserHandle() {
        return this.mCloneUserHandle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean rebuildActiveTab(boolean doPostProcessing) {
        Trace.beginSection("MultiProfilePagerAdapter#rebuildActiveTab");
        boolean result = rebuildTab(getActiveListAdapter(), doPostProcessing);
        Trace.endSection();
        return result;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean rebuildInactiveTab(boolean doPostProcessing) {
        Trace.beginSection("MultiProfilePagerAdapter#rebuildInactiveTab");
        if (getItemCount() == 1) {
            Trace.endSection();
            return false;
        }
        boolean result = rebuildTab(getInactiveListAdapter(), doPostProcessing);
        Trace.endSection();
        return result;
    }

    private int userHandleToPageIndex(UserHandle userHandle) {
        if (userHandle.equals(getPersonalListAdapter().mResolverListController.getUserHandle())) {
            return 0;
        }
        return 1;
    }

    private boolean rebuildTab(ResolverListAdapter activeListAdapter, boolean doPostProcessing) {
        if (shouldSkipRebuild(activeListAdapter)) {
            activeListAdapter.postListReadyRunnable(doPostProcessing, true);
            return false;
        }
        return activeListAdapter.rebuildList(doPostProcessing);
    }

    private boolean shouldSkipRebuild(ResolverListAdapter activeListAdapter) {
        EmptyState emptyState = this.mEmptyStateProvider.getEmptyState(activeListAdapter);
        return emptyState != null && emptyState.shouldSkipDataRebuild();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void showEmptyResolverListEmptyState(final ResolverListAdapter listAdapter) {
        final EmptyState emptyState = this.mEmptyStateProvider.getEmptyState(listAdapter);
        if (emptyState == null) {
            return;
        }
        emptyState.onEmptyStateShown();
        View.OnClickListener clickListener = null;
        if (emptyState.getButtonClickListener() != null) {
            clickListener = new View.OnClickListener() { // from class: com.android.internal.app.AbstractMultiProfilePagerAdapter$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AbstractMultiProfilePagerAdapter.this.lambda$showEmptyResolverListEmptyState$1(emptyState, listAdapter, view);
                }
            };
        }
        showEmptyState(listAdapter, emptyState, clickListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showEmptyResolverListEmptyState$1(EmptyState emptyState, final ResolverListAdapter listAdapter, View v2) {
        emptyState.getButtonClickListener().onClick(new EmptyState.TabControl() { // from class: com.android.internal.app.AbstractMultiProfilePagerAdapter$$ExternalSyntheticLambda1
            @Override // com.android.internal.app.AbstractMultiProfilePagerAdapter.EmptyState.TabControl
            public final void showSpinner() {
                AbstractMultiProfilePagerAdapter.this.lambda$showEmptyResolverListEmptyState$0(listAdapter);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showEmptyResolverListEmptyState$0(ResolverListAdapter listAdapter) {
        ProfileDescriptor descriptor = getItem(userHandleToPageIndex(listAdapter.getUserHandle()));
        showSpinner(descriptor.getEmptyStateView());
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class MyUserIdProvider {
        public int getMyUserId() {
            return UserHandle.myUserId();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class CrossProfileIntentsChecker {
        private final ContentResolver mContentResolver;

        public CrossProfileIntentsChecker(ContentResolver contentResolver) {
            this.mContentResolver = contentResolver;
        }

        public boolean hasCrossProfileIntents(List<Intent> intents, final int source, final int target) {
            final IPackageManager packageManager = AppGlobals.getPackageManager();
            return intents.stream().anyMatch(new Predicate() { // from class: com.android.internal.app.AbstractMultiProfilePagerAdapter$CrossProfileIntentsChecker$$ExternalSyntheticLambda0
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    boolean lambda$hasCrossProfileIntents$0;
                    lambda$hasCrossProfileIntents$0 = AbstractMultiProfilePagerAdapter.CrossProfileIntentsChecker.this.lambda$hasCrossProfileIntents$0(source, target, packageManager, (Intent) obj);
                    return lambda$hasCrossProfileIntents$0;
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ boolean lambda$hasCrossProfileIntents$0(int source, int target, IPackageManager packageManager, Intent intent) {
            return IntentForwarderActivity.canForward(intent, source, target, packageManager, this.mContentResolver) != null;
        }
    }

    protected void showEmptyState(ResolverListAdapter activeListAdapter, EmptyState emptyState, View.OnClickListener buttonOnClick) {
        ProfileDescriptor descriptor = getItem(userHandleToPageIndex(activeListAdapter.getUserHandle()));
        descriptor.rootView.findViewById(16909442).setVisibility(8);
        ViewGroup emptyStateView = descriptor.getEmptyStateView();
        resetViewVisibilitiesForEmptyState(emptyStateView);
        emptyStateView.setVisibility(0);
        View container = emptyStateView.findViewById(16909437);
        setupContainerPadding(container);
        TextView titleView = (TextView) emptyStateView.findViewById(16909441);
        String title = emptyState.getTitle();
        if (title != null) {
            titleView.setVisibility(0);
            titleView.setText(title);
        } else {
            titleView.setVisibility(8);
        }
        TextView subtitleView = (TextView) emptyStateView.findViewById(16909440);
        String subtitle = emptyState.getSubtitle();
        if (subtitle != null) {
            subtitleView.setVisibility(0);
            subtitleView.setText(subtitle);
        } else {
            subtitleView.setVisibility(8);
        }
        View defaultEmptyText = emptyStateView.findViewById(16908292);
        defaultEmptyText.setVisibility(emptyState.useDefaultEmptyView() ? 0 : 8);
        Button button = (Button) emptyStateView.findViewById(16909436);
        button.setVisibility(buttonOnClick != null ? 0 : 8);
        button.setOnClickListener(buttonOnClick);
        activeListAdapter.markTabLoaded();
        this.multiProfilePagerAdapterExt.showActiveEmptyViewState();
    }

    protected void setupContainerPadding(View container) {
    }

    private void showSpinner(View emptyStateView) {
        emptyStateView.findViewById(16909441).setVisibility(4);
        emptyStateView.findViewById(16909436).setVisibility(4);
        emptyStateView.findViewById(16909439).setVisibility(0);
        emptyStateView.findViewById(16908292).setVisibility(8);
    }

    private void resetViewVisibilitiesForEmptyState(View emptyStateView) {
        emptyStateView.findViewById(16909441).setVisibility(0);
        emptyStateView.findViewById(16909440).setVisibility(0);
        emptyStateView.findViewById(16909436).setVisibility(4);
        emptyStateView.findViewById(16909439).setVisibility(8);
        emptyStateView.findViewById(16908292).setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void showListView(ResolverListAdapter activeListAdapter) {
        ProfileDescriptor descriptor = getItem(userHandleToPageIndex(activeListAdapter.getUserHandle()));
        descriptor.rootView.findViewById(16909442).setVisibility(0);
        View emptyStateView = descriptor.rootView.findViewById(16909435);
        emptyStateView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean shouldShowEmptyStateScreen(ResolverListAdapter listAdapter) {
        int count = listAdapter.getUnfilteredCount();
        return (count == 0 && listAdapter.getPlaceholderCount() == 0) || (listAdapter.getUserHandle().equals(this.mWorkProfileUserHandle) && isQuietModeEnabled(this.mWorkProfileUserHandle));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public class ProfileDescriptor {
        private final ViewGroup mEmptyStateView;
        final ViewGroup rootView;

        /* JADX INFO: Access modifiers changed from: package-private */
        public ProfileDescriptor(ViewGroup rootView) {
            this.rootView = rootView;
            this.mEmptyStateView = (ViewGroup) rootView.findViewById(16909435);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public ViewGroup getEmptyStateView() {
            return this.mEmptyStateView;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public interface EmptyStateProvider {
        default EmptyState getEmptyState(ResolverListAdapter resolverListAdapter) {
            return null;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static class CompositeEmptyStateProvider implements EmptyStateProvider {
        private final EmptyStateProvider[] mProviders;

        public CompositeEmptyStateProvider(EmptyStateProvider... providers) {
            this.mProviders = providers;
        }

        @Override // com.android.internal.app.AbstractMultiProfilePagerAdapter.EmptyStateProvider
        public EmptyState getEmptyState(ResolverListAdapter resolverListAdapter) {
            for (EmptyStateProvider provider : this.mProviders) {
                EmptyState emptyState = provider.getEmptyState(resolverListAdapter);
                if (emptyState != null) {
                    return emptyState;
                }
            }
            return null;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public interface EmptyState {

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
        public interface ClickListener {
            void onClick(TabControl tabControl);
        }

        /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
        public interface TabControl {
            void showSpinner();
        }

        default String getTitle() {
            return null;
        }

        default String getSubtitle() {
            return null;
        }

        default ClickListener getButtonClickListener() {
            return null;
        }

        default boolean useDefaultEmptyView() {
            return false;
        }

        default boolean shouldSkipDataRebuild() {
            return false;
        }

        default void onEmptyStateShown() {
        }
    }

    public IAbstractMultiProfilePagerAdapterWrapper getWrapper() {
        return this.mPagerAdapterWrapper;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    private class AbstractMultiProfilePagerAdapterWrapper implements IAbstractMultiProfilePagerAdapterWrapper {
        private AbstractMultiProfilePagerAdapterWrapper() {
        }

        @Override // com.android.internal.app.IAbstractMultiProfilePagerAdapterWrapper
        public void setCurrentPage(int position) {
            AbstractMultiProfilePagerAdapter.this.mCurrentPage = position;
        }
    }
}
