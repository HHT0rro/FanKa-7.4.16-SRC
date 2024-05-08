package com.huawei.hmf.orb.dexloader;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import com.huawei.hmf.orb.dexloader.internal.RunningModuleInfo;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ExposedActivityDelegate {
    private static final String TAG = "ExposedActivityDelegate";
    private final Activity mActivity;
    private Resources mResources;
    private Context mTargetContext;
    private Resources.Theme mTheme;
    private boolean isInit = false;
    private LayoutFactory mFactory = new LayoutFactory();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class LayoutFactory implements LayoutInflater.Factory2 {
        private LayoutFactory() {
        }

        @Override // android.view.LayoutInflater.Factory2
        public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
            Class<?> cls;
            try {
                ClassLoader classLoader = ExposedActivityDelegate.this.mActivity.getClass().getClassLoader();
                if (classLoader != null) {
                    cls = classLoader.loadClass(str);
                } else {
                    cls = Class.forName(str);
                }
                return (View) cls.getConstructor(Context.class, AttributeSet.class).newInstance(context, attributeSet);
            } catch (Exception unused) {
                return null;
            }
        }

        @Override // android.view.LayoutInflater.Factory
        public View onCreateView(String str, Context context, AttributeSet attributeSet) {
            return null;
        }
    }

    public ExposedActivityDelegate(Activity activity) {
        this.mActivity = activity;
    }

    public static ExposedActivityDelegate create(Activity activity) {
        if (activity instanceof ExposedUIModule) {
            return new ExposedActivityDelegate(activity);
        }
        throw new IllegalArgumentException(activity.getClass().getName() + " must implements interface ExposedUIModule.");
    }

    public Activity getActivity() {
        return this.mActivity;
    }

    public AssetManager getAssets(AssetManager assetManager) {
        return isHosted() ? this.mTargetContext.getAssets() : assetManager;
    }

    public Context getBaseContext(Context context) {
        return isHosted() ? this.mTargetContext : context;
    }

    public Resources getResources(Resources resources) {
        if (!isHosted()) {
            return resources;
        }
        if (this.mResources == null) {
            this.mResources = this.mTargetContext.getResources();
        }
        return this.mResources;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [android.view.LayoutInflater, java.lang.Object] */
    public Object getSystemService(String str, Object obj) {
        if (!(obj instanceof LayoutInflater)) {
            return obj;
        }
        try {
            obj = ((LayoutInflater) obj).cloneInContext(this.mActivity);
            obj.setFactory2(this.mFactory);
            return obj;
        } catch (Exception e2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("setFactory2 warning:");
            sb2.append(e2.getMessage());
            return obj;
        }
    }

    public Context getTargetContext() {
        return this.mTargetContext;
    }

    public Resources.Theme getTheme(Resources.Theme theme) {
        if (!isHosted()) {
            return theme;
        }
        if (this.mTheme == null) {
            Resources.Theme newTheme = this.mTargetContext.getResources().newTheme();
            this.mTheme = newTheme;
            newTheme.setTo(this.mTargetContext.getTheme());
        }
        return this.mTheme;
    }

    public boolean isHosted() {
        if (!this.isInit && this.mActivity.getIntent() != null) {
            onCreate(null);
        }
        return this.mTargetContext != null;
    }

    public void onCreate(Bundle bundle) {
        RunningModuleInfo from = RunningModuleInfo.from(this.mActivity.getIntent());
        if (from == null || from.isExternalModule()) {
            return;
        }
        this.mTargetContext = from.getTargetContext();
        this.isInit = true;
    }

    public void setTheme(int i10) {
        if (isHosted()) {
            if (this.mTheme == null) {
                Resources.Theme newTheme = this.mTargetContext.getResources().newTheme();
                this.mTheme = newTheme;
                newTheme.setTo(this.mTargetContext.getTheme());
            }
            this.mTheme.applyStyle(i10, true);
        }
    }
}
