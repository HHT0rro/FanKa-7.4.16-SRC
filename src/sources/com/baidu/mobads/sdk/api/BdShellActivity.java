package com.baidu.mobads.sdk.api;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.baidu.mobads.proxy.R;
import com.baidu.mobads.sdk.internal.as;
import com.baidu.mobads.sdk.internal.br;
import com.baidu.mobads.sdk.internal.bs;
import com.huawei.quickcard.framework.bean.QuickCardBean;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class BdShellActivity extends Activity {
    private static boolean canShowWhenLock;
    private static ActionBarColorTheme mSActionBarColorTheme = ActionBarColorTheme.ACTION_BAR_WHITE_THEME;
    private bs mAdLogger = bs.a();
    private ClassLoader mLoader;
    private IActivityImpl mProxyActivity;

    public static void canLpShowWhenLocked(boolean z10) {
        canShowWhenLock = z10;
    }

    public static ActionBarColorTheme getActionBarColorTheme() {
        return mSActionBarColorTheme;
    }

    public static Class<?> getActivityClass() {
        return BdShellActivity.class;
    }

    public static boolean getLpShowWhenLocked() {
        return canShowWhenLock;
    }

    public static void setActionBarColor(int i10, int i11, int i12, int i13) {
        mSActionBarColorTheme = new ActionBarColorTheme(i10, i11, i12, i13);
    }

    public static void setActionBarColorTheme(ActionBarColorTheme actionBarColorTheme) {
        if (actionBarColorTheme != null) {
            mSActionBarColorTheme = new ActionBarColorTheme(actionBarColorTheme);
        }
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
        super.onCreate(bundle);
        Intent intent = getIntent();
        try {
            ClassLoader a11 = br.a(this);
            this.mLoader = a11;
            if (intent != null) {
                intent.setExtrasClassLoader(a11);
            }
            String str = "";
            if (intent != null) {
                str = intent.getStringExtra("activityImplName");
                if ("Dialog".equals(intent.getStringExtra(QuickCardBean.Field.THEME))) {
                    setTheme(R.style.bd_activity_dialog_theme);
                }
            }
            Object obj = null;
            if (!TextUtils.isEmpty(str) && (a10 = as.a(str, this.mLoader)) != null) {
                try {
                    obj = a10.getConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Throwable th) {
                    bs.a().d(th);
                }
            }
            if (obj != null) {
                this.mProxyActivity = (IActivityImpl) obj;
            }
            if (this.mProxyActivity != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("bar_close_color", mSActionBarColorTheme.closeColor);
                    jSONObject.put("bar_pro_color", mSActionBarColorTheme.progressColor);
                    jSONObject.put("bar_title_color", mSActionBarColorTheme.titleColor);
                    jSONObject.put("bar_bg_color", mSActionBarColorTheme.backgroundColor);
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

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class ActionBarColorTheme implements Serializable {
        public int backgroundColor;
        public int closeColor;
        public int progressColor;
        public int titleColor;
        public static final ActionBarColorTheme ACTION_BAR_WHITE_THEME = new ActionBarColorTheme(-5987164, -6842473, -11113262, -328966);
        public static final ActionBarColorTheme ACTION_BAR_RED_THEME = new ActionBarColorTheme(-1, -1, -12510, -1294276);
        public static final ActionBarColorTheme ACTION_BAR_GREEN_THEME = new ActionBarColorTheme(-1, -1, -11113262, -14303071);
        public static final ActionBarColorTheme ACTION_BAR_NAVYBLUE_THEME = new ActionBarColorTheme(-1, -1, 16764706, -14210226);
        public static final ActionBarColorTheme ACTION_BAR_BLUE_THEME = new ActionBarColorTheme(-1, -1, -12510, -13870424);
        public static final ActionBarColorTheme ACTION_BAR_COFFEE_THEME = new ActionBarColorTheme(-1, -1, -12510, -11255230);
        public static final ActionBarColorTheme ACTION_BAR_BLACK_THEME = new ActionBarColorTheme(-1, -1, -12510, -13749450);

        public ActionBarColorTheme(int i10, int i11, int i12, int i13) {
            this.closeColor = i10;
            this.titleColor = i11;
            this.progressColor = i12;
            this.backgroundColor = i13;
        }

        public boolean equals(Object obj) {
            ActionBarColorTheme actionBarColorTheme = (ActionBarColorTheme) obj;
            return this.backgroundColor == actionBarColorTheme.backgroundColor && this.titleColor == actionBarColorTheme.titleColor && this.closeColor == actionBarColorTheme.closeColor && this.progressColor == actionBarColorTheme.progressColor;
        }

        public int getBackgroundColor() {
            return this.backgroundColor;
        }

        public int getCloseColor() {
            return this.closeColor;
        }

        public int getProgressColor() {
            return this.progressColor;
        }

        public int getTitleColor() {
            return this.titleColor;
        }

        public void setBackgroundColor(int i10) {
            this.backgroundColor = i10;
        }

        public void setCloseColor(int i10) {
            this.closeColor = i10;
        }

        public void setProgressColor(int i10) {
            this.progressColor = i10;
        }

        public void setTitleColor(int i10) {
            this.titleColor = i10;
        }

        public ActionBarColorTheme(ActionBarColorTheme actionBarColorTheme) {
            this.closeColor = actionBarColorTheme.closeColor;
            this.titleColor = actionBarColorTheme.titleColor;
            this.progressColor = actionBarColorTheme.progressColor;
            this.backgroundColor = actionBarColorTheme.backgroundColor;
        }
    }
}
