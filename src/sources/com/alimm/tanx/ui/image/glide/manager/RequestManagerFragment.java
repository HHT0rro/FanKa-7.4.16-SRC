package com.alimm.tanx.ui.image.glide.manager;

import android.app.Activity;
import android.app.Fragment;
import android.util.Log;
import com.alimm.tanx.ui.image.glide.RequestManager;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class RequestManagerFragment extends Fragment {
    public static final String TAG = "RMFragment";
    public final HashSet<RequestManagerFragment> childRequestManagerFragments;
    public final ActivityFragmentLifecycle lifecycle;
    public RequestManager requestManager;
    public final RequestManagerTreeNode requestManagerTreeNode;
    public RequestManagerFragment rootRequestManagerFragment;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class FragmentRequestManagerTreeNode implements RequestManagerTreeNode {
        public FragmentRequestManagerTreeNode() {
        }

        @Override // com.alimm.tanx.ui.image.glide.manager.RequestManagerTreeNode
        public Set<RequestManager> getDescendants() {
            Set<RequestManagerFragment> descendantRequestManagerFragments = RequestManagerFragment.this.getDescendantRequestManagerFragments();
            HashSet hashSet = new HashSet(descendantRequestManagerFragments.size());
            for (RequestManagerFragment requestManagerFragment : descendantRequestManagerFragments) {
                if (requestManagerFragment.getRequestManager() != null) {
                    hashSet.add(requestManagerFragment.getRequestManager());
                }
            }
            return hashSet;
        }

        public /* synthetic */ FragmentRequestManagerTreeNode(AnonymousClass1 anonymousClass1) {
        }
    }

    public RequestManagerFragment() {
        this(new ActivityFragmentLifecycle());
    }

    private void addChildRequestManagerFragment(RequestManagerFragment requestManagerFragment) {
        this.childRequestManagerFragments.add(requestManagerFragment);
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

    private void removeChildRequestManagerFragment(RequestManagerFragment requestManagerFragment) {
        this.childRequestManagerFragments.remove(requestManagerFragment);
    }

    public Set<RequestManagerFragment> getDescendantRequestManagerFragments() {
        RequestManagerFragment requestManagerFragment = this.rootRequestManagerFragment;
        if (requestManagerFragment == this) {
            return Collections.unmodifiableSet(this.childRequestManagerFragments);
        }
        if (requestManagerFragment != null) {
            HashSet hashSet = new HashSet();
            for (RequestManagerFragment requestManagerFragment2 : this.rootRequestManagerFragment.getDescendantRequestManagerFragments()) {
                if (isDescendant(requestManagerFragment2.getParentFragment())) {
                    hashSet.add(requestManagerFragment2);
                }
            }
            return Collections.unmodifiableSet(hashSet);
        }
        return Collections.emptySet();
    }

    public ActivityFragmentLifecycle getLifecycle() {
        return this.lifecycle;
    }

    public RequestManager getRequestManager() {
        return this.requestManager;
    }

    public RequestManagerTreeNode getRequestManagerTreeNode() {
        return this.requestManagerTreeNode;
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            RequestManagerFragment requestManagerFragment = RequestManagerRetriever.get().getRequestManagerFragment(getActivity().getFragmentManager());
            this.rootRequestManagerFragment = requestManagerFragment;
            if (requestManagerFragment != this) {
                requestManagerFragment.childRequestManagerFragments.add(this);
            }
        } catch (IllegalStateException unused) {
            Log.isLoggable(TAG, 5);
        }
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.lifecycle.onDestroy();
    }

    @Override // android.app.Fragment
    public void onDetach() {
        super.onDetach();
        RequestManagerFragment requestManagerFragment = this.rootRequestManagerFragment;
        if (requestManagerFragment != null) {
            requestManagerFragment.childRequestManagerFragments.remove(this);
            this.rootRequestManagerFragment = null;
        }
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onLowMemory() {
        RequestManager requestManager = this.requestManager;
        if (requestManager != null) {
            requestManager.onLowMemory();
        }
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        this.lifecycle.onStart();
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        this.lifecycle.onStop();
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks2
    public void onTrimMemory(int i10) {
        RequestManager requestManager = this.requestManager;
        if (requestManager != null) {
            requestManager.onTrimMemory(i10);
        }
    }

    public void setRequestManager(RequestManager requestManager) {
        this.requestManager = requestManager;
    }

    public RequestManagerFragment(ActivityFragmentLifecycle activityFragmentLifecycle) {
        this.requestManagerTreeNode = new FragmentRequestManagerTreeNode(null);
        this.childRequestManagerFragments = new HashSet<>();
        this.lifecycle = activityFragmentLifecycle;
    }
}
