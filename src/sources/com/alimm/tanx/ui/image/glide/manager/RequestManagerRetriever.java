package com.alimm.tanx.ui.image.glide.manager;

import android.app.Activity;
import android.app.Application;
import android.app.FragmentManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.alimm.tanx.ui.image.glide.RequestManager;
import com.alimm.tanx.ui.image.glide.util.Util;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class RequestManagerRetriever implements Handler.Callback {
    public static final String FRAGMENT_TAG = "com.alimm.tanx.ui.image.glide.manager";
    public static final int ID_REMOVE_FRAGMENT_MANAGER = 1;
    public static final int ID_REMOVE_SUPPORT_FRAGMENT_MANAGER = 2;
    public static final RequestManagerRetriever INSTANCE = new RequestManagerRetriever();
    public static final String TAG = "RMRetriever";
    public volatile RequestManager applicationManager;
    public final Map<FragmentManager, RequestManagerFragment> pendingRequestManagerFragments = new HashMap();
    public final Map<androidx.fragment.app.FragmentManager, SupportRequestManagerFragment> pendingSupportRequestManagerFragments = new HashMap();
    public final Handler handler = new Handler(Looper.getMainLooper(), this);

    public static void assertNotDestroyed(Activity activity) {
        if (activity.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    public static RequestManagerRetriever get() {
        return INSTANCE;
    }

    private RequestManager getApplicationManager(Context context) {
        if (this.applicationManager == null) {
            synchronized (this) {
                if (this.applicationManager == null) {
                    this.applicationManager = new RequestManager(context.getApplicationContext(), new ApplicationLifecycle(), new EmptyRequestManagerTreeNode());
                }
            }
        }
        return this.applicationManager;
    }

    public RequestManager fragmentGet(Context context, FragmentManager fragmentManager) {
        RequestManagerFragment requestManagerFragment = getRequestManagerFragment(fragmentManager);
        RequestManager requestManager = requestManagerFragment.getRequestManager();
        if (requestManager != null) {
            return requestManager;
        }
        RequestManager requestManager2 = new RequestManager(context, requestManagerFragment.getLifecycle(), requestManagerFragment.getRequestManagerTreeNode());
        requestManagerFragment.setRequestManager(requestManager2);
        return requestManager2;
    }

    public RequestManagerFragment getRequestManagerFragment(FragmentManager fragmentManager) {
        RequestManagerFragment requestManagerFragment = (RequestManagerFragment) fragmentManager.findFragmentByTag(FRAGMENT_TAG);
        if (requestManagerFragment != null) {
            return requestManagerFragment;
        }
        RequestManagerFragment requestManagerFragment2 = this.pendingRequestManagerFragments.get(fragmentManager);
        if (requestManagerFragment2 != null) {
            return requestManagerFragment2;
        }
        RequestManagerFragment requestManagerFragment3 = new RequestManagerFragment();
        this.pendingRequestManagerFragments.put(fragmentManager, requestManagerFragment3);
        fragmentManager.beginTransaction().add(requestManagerFragment3, FRAGMENT_TAG).commitAllowingStateLoss();
        this.handler.obtainMessage(1, fragmentManager).sendToTarget();
        return requestManagerFragment3;
    }

    public SupportRequestManagerFragment getSupportRequestManagerFragment(androidx.fragment.app.FragmentManager fragmentManager) {
        SupportRequestManagerFragment supportRequestManagerFragment = (SupportRequestManagerFragment) fragmentManager.findFragmentByTag(FRAGMENT_TAG);
        if (supportRequestManagerFragment != null) {
            return supportRequestManagerFragment;
        }
        SupportRequestManagerFragment supportRequestManagerFragment2 = this.pendingSupportRequestManagerFragments.get(fragmentManager);
        if (supportRequestManagerFragment2 != null) {
            return supportRequestManagerFragment2;
        }
        SupportRequestManagerFragment supportRequestManagerFragment3 = new SupportRequestManagerFragment();
        this.pendingSupportRequestManagerFragments.put(fragmentManager, supportRequestManagerFragment3);
        fragmentManager.beginTransaction().add(supportRequestManagerFragment3, FRAGMENT_TAG).commitAllowingStateLoss();
        this.handler.obtainMessage(2, fragmentManager).sendToTarget();
        return supportRequestManagerFragment3;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Object obj;
        Object remove;
        Object obj2;
        int i10 = message.what;
        Object obj3 = null;
        boolean z10 = true;
        if (i10 == 1) {
            obj = (FragmentManager) message.obj;
            remove = this.pendingRequestManagerFragments.remove(obj);
        } else if (i10 == 2) {
            obj = (androidx.fragment.app.FragmentManager) message.obj;
            remove = this.pendingSupportRequestManagerFragments.remove(obj);
        } else {
            z10 = false;
            obj2 = null;
            if (z10 && obj3 == null && Log.isLoggable(TAG, 5)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Failed to remove expected request manager fragment, manager: ");
                sb2.append(obj2);
            }
            return z10;
        }
        Object obj4 = obj;
        obj3 = remove;
        obj2 = obj4;
        if (z10) {
            StringBuilder sb22 = new StringBuilder();
            sb22.append("Failed to remove expected request manager fragment, manager: ");
            sb22.append(obj2);
        }
        return z10;
    }

    public RequestManager supportFragmentGet(Context context, androidx.fragment.app.FragmentManager fragmentManager) {
        SupportRequestManagerFragment supportRequestManagerFragment = getSupportRequestManagerFragment(fragmentManager);
        RequestManager requestManager = supportRequestManagerFragment.getRequestManager();
        if (requestManager != null) {
            return requestManager;
        }
        RequestManager requestManager2 = new RequestManager(context, supportRequestManagerFragment.getTanxLifecycle(), supportRequestManagerFragment.getRequestManagerTreeNode());
        supportRequestManagerFragment.setRequestManager(requestManager2);
        return requestManager2;
    }

    public RequestManager get(Context context) {
        if (context != null) {
            if (Util.isOnMainThread() && !(context instanceof Application)) {
                if (context instanceof FragmentActivity) {
                    return get((FragmentActivity) context);
                }
                if (context instanceof Activity) {
                    return get((Activity) context);
                }
                if (context instanceof ContextWrapper) {
                    return get(((ContextWrapper) context).getBaseContext());
                }
            }
            return getApplicationManager(context);
        }
        throw new IllegalArgumentException("You cannot start a load on a null Context");
    }

    public RequestManager get(FragmentActivity fragmentActivity) {
        if (Util.isOnBackgroundThread()) {
            return get(fragmentActivity.getApplicationContext());
        }
        assertNotDestroyed(fragmentActivity);
        return supportFragmentGet(fragmentActivity, fragmentActivity.getSupportFragmentManager());
    }

    public RequestManager get(Fragment fragment) {
        if (fragment.getActivity() != null) {
            if (Util.isOnBackgroundThread()) {
                return get(fragment.getActivity().getApplicationContext());
            }
            return supportFragmentGet(fragment.getActivity(), fragment.getChildFragmentManager());
        }
        throw new IllegalArgumentException("You cannot start a load on a fragment before it is attached");
    }

    public RequestManager get(Activity activity) {
        if (!Util.isOnBackgroundThread()) {
            assertNotDestroyed(activity);
            return fragmentGet(activity, activity.getFragmentManager());
        }
        return get(activity.getApplicationContext());
    }

    public RequestManager get(android.app.Fragment fragment) {
        if (fragment.getActivity() != null) {
            if (!Util.isOnBackgroundThread()) {
                return fragmentGet(fragment.getActivity(), fragment.getChildFragmentManager());
            }
            return get(fragment.getActivity().getApplicationContext());
        }
        throw new IllegalArgumentException("You cannot start a load on a fragment before it is attached");
    }
}
