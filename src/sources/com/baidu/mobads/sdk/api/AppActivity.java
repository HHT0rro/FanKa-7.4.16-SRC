package com.baidu.mobads.sdk.api;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.baidu.mobads.sdk.internal.as;
import com.baidu.mobads.sdk.internal.br;
import com.baidu.mobads.sdk.internal.bs;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class AppActivity extends Activity {
    private static Activity activity;
    public static String activityName;
    private static boolean canShowWhenLock;
    private ClassLoader mLoader;
    private IActivityImpl mProxyActivity;
    private static ActionBarColorTheme mSActionBarColorTheme = ActionBarColorTheme.ACTION_BAR_WHITE_THEME;
    private static boolean mIsShowActionBarTitle = true;

    public static void canLpShowWhenLocked(boolean z10) {
        canShowWhenLock = z10;
    }

    public static Activity getActivity() {
        return activity;
    }

    public static Class<?> getActivityClass() {
        if (TextUtils.isEmpty(activityName)) {
            return AppActivity.class;
        }
        try {
            return Class.forName(activityName);
        } catch (Exception e2) {
            bs.a().c(e2);
            return AppActivity.class;
        }
    }

    public static boolean getLpShowWhenLocked() {
        return canShowWhenLock;
    }

    public static boolean isAnti() {
        return !TextUtils.isEmpty(activityName);
    }

    public static void setActionBarColorTheme(ActionBarColorTheme actionBarColorTheme) {
        if (actionBarColorTheme != null) {
            mSActionBarColorTheme = actionBarColorTheme;
        }
    }

    public static void setActivityName(String str) {
        activityName = str;
    }

    public static void setIsShowActionBarTitle(boolean z10) {
        mIsShowActionBarTitle = z10;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null ? iActivityImpl.dispatchKeyEvent(keyEvent) : false) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null ? iActivityImpl.dispatchTouchEvent(motionEvent) : false) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onActivityResult(i10, i11, intent);
        }
        super.onActivityResult(i10, i11, intent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onAttachedToWindow();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onBackPressed();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onConfigurationChanged(configuration);
        }
        super.onConfigurationChanged(configuration);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Class<?> a10;
        activity = this;
        super.onCreate(bundle);
        Intent intent = getIntent();
        try {
            ClassLoader a11 = br.a(this);
            this.mLoader = a11;
            if (intent != null) {
                intent.setExtrasClassLoader(a11);
            }
            String stringExtra = intent != null ? intent.getStringExtra("activityImplName") : "";
            Object obj = null;
            if (!TextUtils.isEmpty(stringExtra) && (a10 = as.a(stringExtra, this.mLoader)) != null) {
                try {
                    obj = a10.getConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (obj != null) {
                this.mProxyActivity = (IActivityImpl) obj;
            }
            if (this.mProxyActivity != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("bar_close_color", mSActionBarColorTheme.mCloseColor);
                    jSONObject.put("bar_pro_color", mSActionBarColorTheme.mProgressColor);
                    jSONObject.put("bar_title_color", mSActionBarColorTheme.mTitleColor);
                    jSONObject.put("bar_bg_color", mSActionBarColorTheme.mBackgroundColor);
                    jSONObject.put("showWhenLocked", canShowWhenLock);
                    jSONObject.put("isShowActionBarTit", mIsShowActionBarTitle);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                this.mProxyActivity.setLpBussParam(jSONObject);
                this.mProxyActivity.setActivity(this);
                if (intent != null) {
                    this.mProxyActivity.onCreate(bundle);
                }
            }
        } catch (Exception e10) {
            bs.a().c(e10);
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onDestroy();
        }
        super.onDestroy();
        activity = null;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onDetachedFromWindow();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null ? iActivityImpl.onKeyDown(i10, keyEvent) : false) {
            return true;
        }
        return super.onKeyDown(i10, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i10, KeyEvent keyEvent) {
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null ? iActivityImpl.onKeyUp(i10, keyEvent) : false) {
            return true;
        }
        return super.onKeyUp(i10, keyEvent);
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onNewIntent(intent);
        }
        super.onNewIntent(intent);
    }

    @Override // android.app.Activity
    public void onPause() {
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onPause();
        }
        super.onPause();
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onRestoreInstanceState(bundle);
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onResume();
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onSaveInstanceState(bundle);
        }
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onStart();
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onStop();
        }
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null ? iActivityImpl.onTouchEvent(motionEvent) : false) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.onWindowFocusChanged(z10);
        }
    }

    @Override // android.app.Activity
    public void overridePendingTransition(int i10, int i11) {
        super.overridePendingTransition(i10, i11);
        IActivityImpl iActivityImpl = this.mProxyActivity;
        if (iActivityImpl != null) {
            iActivityImpl.overridePendingTransition(i10, i11);
        }
    }
}
