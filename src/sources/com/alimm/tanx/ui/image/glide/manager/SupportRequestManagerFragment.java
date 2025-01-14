package com.alimm.tanx.ui.image.glide.manager;

import android.app.Activity;
import android.util.Log;
import androidx.fragment.app.Fragment;
import com.alimm.tanx.ui.image.glide.RequestManager;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class SupportRequestManagerFragment extends Fragment {
    public static final String TAG = "SupportRMFragment";
    public final HashSet<SupportRequestManagerFragment> childRequestManagerFragments;
    public RequestManager requestManager;
    public final RequestManagerTreeNode requestManagerTreeNode;
    public SupportRequestManagerFragment rootRequestManagerFragment;
    public final ActivityFragmentLifecycle tanxLifecycle;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class SupportFragmentRequestManagerTreeNode implements RequestManagerTreeNode {
        public SupportFragmentRequestManagerTreeNode() {
        }

        @Override // com.alimm.tanx.ui.image.glide.manager.RequestManagerTreeNode
        public Set<RequestManager> getDescendants() {
            Set<SupportRequestManagerFragment> descendantRequestManagerFragments = SupportRequestManagerFragment.this.getDescendantRequestManagerFragments();
            HashSet hashSet = new HashSet(descendantRequestManagerFragments.size());
            for (SupportRequestManagerFragment supportRequestManagerFragment : descendantRequestManagerFragments) {
                if (supportRequestManagerFragment.getRequestManager() != null) {
                    hashSet.add(supportRequestManagerFragment.getRequestManager());
                }
            }
            return hashSet;
        }

        public /* synthetic */ SupportFragmentRequestManagerTreeNode(AnonymousClass1 anonymousClass1) {
        }
    }

    public SupportRequestManagerFragment() {
        this(new ActivityFragmentLifecycle());
    }

    private void addChildRequestManagerFragment(SupportRequestManagerFragment supportRequestManagerFragment) {
        this.childRequestManagerFragments.add(supportRequestManagerFragment);
    }

    private boolean isDescendant(Fragment fragment) {
        Fragment parentFragment = getParentFragment();
        while (fragment.getParentFragment() != null) {
            if (fragment.getParentFragment() == parentFragment) {
                return true;
            }
            fragment = fragment.getParentFragment();
        }
        return false;
    }

    private void removeChildRequestManagerFragment(SupportRequestManagerFragment supportRequestManagerFragment) {
        this.childRequestManagerFragments.remove(supportRequestManagerFragment);
    }

    public Set<SupportRequestManagerFragment> getDescendantRequestManagerFragments() {
        SupportRequestManagerFragment supportRequestManagerFragment = this.rootRequestManagerFragment;
        if (supportRequestManagerFragment == null) {
            return Collections.emptySet();
        }
        if (supportRequestManagerFragment == this) {
            return Collections.unmodifiableSet(this.childRequestManagerFragments);
        }
        HashSet hashSet = new HashSet();
        for (SupportRequestManagerFragment supportRequestManagerFragment2 : this.rootRequestManagerFragment.getDescendantRequestManagerFragments()) {
            if (isDescendant(supportRequestManagerFragment2.getParentFragment())) {
                hashSet.add(supportRequestManagerFragment2);
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    public RequestManager getRequestManager() {
        return this.requestManager;
    }

    public RequestManagerTreeNode getRequestManagerTreeNode() {
        return this.requestManagerTreeNode;
    }

    public ActivityFragmentLifecycle getTanxLifecycle() {
        return this.tanxLifecycle;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            SupportRequestManagerFragment supportRequestManagerFragment = RequestManagerRetriever.get().getSupportRequestManagerFragment(getActivity().getSupportFragmentManager());
            this.rootRequestManagerFragment = supportRequestManagerFragment;
            if (supportRequestManagerFragment != this) {
                supportRequestManagerFragment.childRequestManagerFragments.add(this);
            }
        } catch (IllegalStateException unused) {
            Log.isLoggable(TAG, 5);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.tanxLifecycle.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        SupportRequestManagerFragment supportRequestManagerFragment = this.rootRequestManagerFragment;
        if (supportRequestManagerFragment != null) {
            supportRequestManagerFragment.childRequestManagerFragments.remove(this);
            this.rootRequestManagerFragment = null;
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        RequestManager requestManager = this.requestManager;
        if (requestManager != null) {
            requestManager.onLowMemory();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.tanxLifecycle.onStart();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.tanxLifecycle.onStop();
    }

    public void setRequestManager(RequestManager requestManager) {
        this.requestManager = requestManager;
    }

    public SupportRequestManagerFragment(ActivityFragmentLifecycle activityFragmentLifecycle) {
        this.requestManagerTreeNode = new SupportFragmentRequestManagerTreeNode(null);
        this.childRequestManagerFragments = new HashSet<>();
        this.tanxLifecycle = activityFragmentLifecycle;
    }
}
