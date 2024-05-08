package com.kwad.sdk.api.proxy;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.core.KsAdSdkDynamicApi;

@KsAdSdkDynamicApi
@Keep
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class IActivityProxy implements IComponentProxy {
    private Activity mActivity;

    @KsAdSdkDynamicApi
    @Keep
    public <T extends View> T findViewById(int i10) {
        return (T) this.mActivity.findViewById(i10);
    }

    @KsAdSdkDynamicApi
    @Keep
    public void finish() {
        this.mActivity.finish();
    }

    @KsAdSdkDynamicApi
    @Keep
    @Deprecated
    public Activity getActivity() {
        return this.mActivity;
    }

    @KsAdSdkDynamicApi
    @Keep
    public Intent getIntent() {
        return this.mActivity.getIntent();
    }

    @KsAdSdkDynamicApi
    @Keep
    public Window getWindow() {
        return this.mActivity.getWindow();
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onActivityResult(int i10, int i11, Intent intent) {
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onApplyThemeResource(Resources.Theme theme, int i10, boolean z10) {
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onBackPressed() {
        Activity activity = this.mActivity;
        if (activity instanceof BaseProxyActivity) {
            try {
                ((BaseProxyActivity) activity).superOnBackPressed();
            } catch (Exception unused) {
            }
        } else if (activity instanceof BaseProxyFragmentActivity) {
            try {
                ((BaseProxyFragmentActivity) activity).superOnBackPressed();
            } catch (Exception unused2) {
            }
        } else {
            throw new RuntimeException(((Object) this.mActivity) + " must be BaseProxyActivity or BaseProxyFragmentActivity");
        }
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onChildTitleChanged(Activity activity, CharSequence charSequence) {
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onConfigurationChanged(Configuration configuration) {
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onCreate(@Nullable Bundle bundle) {
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onDestroy() {
    }

    @KsAdSdkDynamicApi
    @Keep
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        Activity activity = this.mActivity;
        if (activity instanceof BaseProxyActivity) {
            return ((BaseProxyActivity) activity).superOnKeyDown(i10, keyEvent);
        }
        if (activity instanceof BaseProxyFragmentActivity) {
            return ((BaseProxyFragmentActivity) activity).superOnKeyDown(i10, keyEvent);
        }
        throw new RuntimeException(((Object) this.mActivity) + " must be BaseProxyActivity or BaseProxyFragmentActivity");
    }

    @KsAdSdkDynamicApi
    @Keep
    public boolean onKeyLongPress(int i10, KeyEvent keyEvent) {
        Activity activity = this.mActivity;
        if (activity instanceof BaseProxyActivity) {
            return ((BaseProxyActivity) activity).superOnKeyLongPress(i10, keyEvent);
        }
        if (activity instanceof BaseProxyFragmentActivity) {
            return ((BaseProxyFragmentActivity) activity).superOnKeyLongPress(i10, keyEvent);
        }
        throw new RuntimeException(((Object) this.mActivity) + " must be BaseProxyActivity or BaseProxyFragmentActivity");
    }

    @KsAdSdkDynamicApi
    @Keep
    public boolean onKeyUp(int i10, KeyEvent keyEvent) {
        Activity activity = this.mActivity;
        if (activity instanceof BaseProxyActivity) {
            return ((BaseProxyActivity) activity).superOnKeyUp(i10, keyEvent);
        }
        if (activity instanceof BaseProxyFragmentActivity) {
            return ((BaseProxyFragmentActivity) activity).superOnKeyUp(i10, keyEvent);
        }
        throw new RuntimeException(((Object) this.mActivity) + " must be BaseProxyActivity or BaseProxyFragmentActivity");
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onNewIntent(Intent intent) {
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onPause() {
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onPostCreate(@Nullable Bundle bundle) {
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onPostResume() {
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onPreCreate(@Nullable Bundle bundle) {
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onPreDestroy() {
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onPrePause() {
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onPreResume() {
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onPreSaveInstanceState(@NonNull Bundle bundle) {
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onPreStart() {
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onPreStop() {
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onRestart() {
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onRestoreInstanceState(Bundle bundle) {
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onResume() {
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onSaveInstanceState(Bundle bundle) {
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onStart() {
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onStop() {
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onTitleChanged(CharSequence charSequence, int i10) {
    }

    @KsAdSdkDynamicApi
    @Keep
    public void onUserLeaveHint() {
    }

    @KsAdSdkDynamicApi
    @Keep
    public void overridePendingTransition(int i10, int i11) {
        this.mActivity.overridePendingTransition(i10, i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setActivity(Activity activity) {
        this.mActivity = activity;
    }

    @KsAdSdkDynamicApi
    @Keep
    public void setContentView(int i10) {
        this.mActivity.setContentView(i10);
    }

    @KsAdSdkDynamicApi
    @Keep
    public void setContentView(View view) {
        this.mActivity.setContentView(view);
    }

    @KsAdSdkDynamicApi
    @Keep
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        this.mActivity.setContentView(view, layoutParams);
    }
}
