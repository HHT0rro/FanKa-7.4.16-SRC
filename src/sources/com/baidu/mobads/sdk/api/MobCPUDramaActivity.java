package com.baidu.mobads.sdk.api;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import com.baidu.mobads.sdk.internal.aw;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class MobCPUDramaActivity extends Activity {
    private static IActivityImpl tempActivity;
    private IActivityImpl mDramaActivity;

    public static void setActivityImp(IActivityImpl iActivityImpl) {
        tempActivity = iActivityImpl;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        IActivityImpl iActivityImpl = this.mDramaActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onAttachedToWindow();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        IActivityImpl iActivityImpl = this.mDramaActivity;
        if (iActivityImpl != null ? iActivityImpl.onBackPressed() : false) {
            return;
        }
        super.onBackPressed();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        IActivityImpl iActivityImpl = this.mDramaActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onConfigurationChanged(configuration);
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        IActivityImpl iActivityImpl = tempActivity;
        if (iActivityImpl != null && this.mDramaActivity == null) {
            this.mDramaActivity = iActivityImpl;
            tempActivity = null;
        }
        IActivityImpl iActivityImpl2 = this.mDramaActivity;
        if (iActivityImpl2 != null) {
            iActivityImpl2.setActivity(this);
            this.mDramaActivity.onCreate(bundle);
        }
        super.onCreate(bundle);
    }

    @Override // android.app.Activity
    public void onDestroy() {
        IActivityImpl iActivityImpl = this.mDramaActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onDestroy();
            this.mDramaActivity = null;
        }
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        IActivityImpl iActivityImpl = this.mDramaActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onDetachedFromWindow();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        return super.onKeyDown(i10, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i10, KeyEvent keyEvent) {
        return super.onKeyUp(i10, keyEvent);
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        IActivityImpl iActivityImpl = tempActivity;
        if (iActivityImpl != null && this.mDramaActivity == null) {
            this.mDramaActivity = iActivityImpl;
            tempActivity = null;
        }
        IActivityImpl iActivityImpl2 = this.mDramaActivity;
        if (iActivityImpl2 != null) {
            iActivityImpl2.onNewIntent(intent);
        }
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        IActivityImpl iActivityImpl = this.mDramaActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onPause();
        }
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(@NonNull Bundle bundle) {
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            if (classLoader != null) {
                bundle.setClassLoader(classLoader);
                Bundle bundle2 = bundle.getBundle("android:viewHierarchyState");
                if (bundle2 != null) {
                    bundle2.setClassLoader(classLoader);
                }
            }
            super.onRestoreInstanceState(bundle);
            IActivityImpl iActivityImpl = this.mDramaActivity;
            if (iActivityImpl != null) {
                iActivityImpl.onRestoreInstanceState(bundle);
            }
        } catch (Throwable th) {
            aw.f(th.getMessage());
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        IActivityImpl iActivityImpl = this.mDramaActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onResume();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        IActivityImpl iActivityImpl = this.mDramaActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onSaveInstanceState(bundle);
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        IActivityImpl iActivityImpl = this.mDramaActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onStop();
        }
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IActivityImpl iActivityImpl = this.mDramaActivity;
        if (iActivityImpl != null ? iActivityImpl.onTouchEvent(motionEvent) : false) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        IActivityImpl iActivityImpl = this.mDramaActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onWindowFocusChanged(z10);
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i10, int i11) {
        super.overridePendingTransition(i10, i11);
        IActivityImpl iActivityImpl = this.mDramaActivity;
        if (iActivityImpl != null) {
            iActivityImpl.overridePendingTransition(i10, i11);
        }
    }
}
