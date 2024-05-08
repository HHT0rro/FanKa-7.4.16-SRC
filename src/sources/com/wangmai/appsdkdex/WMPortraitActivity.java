package com.wangmai.appsdkdex;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.wangmai.common.WMAdActListener;
import zc.b;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class WMPortraitActivity extends Activity {

    /* renamed from: b, reason: collision with root package name */
    public FrameLayout f46917b;

    /* renamed from: c, reason: collision with root package name */
    public String f46918c;

    /* renamed from: d, reason: collision with root package name */
    public WMAdActListener f46919d;

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        WMAdActListener wMAdActListener = this.f46919d;
        if (wMAdActListener != null) {
            if (wMAdActListener.getAdResources() != null) {
                return this.f46919d.getAdResources();
            }
            return super.getResources();
        }
        return super.getResources();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme newTheme = getResources().newTheme();
        newTheme.setTo(super.getTheme());
        return newTheme;
    }

    @Override // android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        WMAdActListener wMAdActListener = this.f46919d;
        if (wMAdActListener != null) {
            wMAdActListener.adOnActivityResult(i10, i11, intent);
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        WMAdActListener wMAdActListener = this.f46919d;
        if (wMAdActListener != null) {
            wMAdActListener.adOnConfigurationChanged(configuration);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(R$layout.wm_view_act);
        try {
            this.f46918c = getIntent().getStringExtra(b.a("nbq`lfz"));
            this.f46917b = (FrameLayout) findViewById(R$id.wm_reward_main);
            ViewGroup viewGroup = WMDexAdHelper.loadViewGroupMap.get(this.f46918c);
            this.f46917b.removeAllViews();
            this.f46917b.addView(viewGroup);
            WMDexAdHelper.activityMap.put(this.f46918c, this);
            if (viewGroup instanceof WMAdActListener) {
                WMAdActListener wMAdActListener = (WMAdActListener) viewGroup;
                this.f46919d = wMAdActListener;
                wMAdActListener.onAdCreate(bundle);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        WMAdActListener wMAdActListener = this.f46919d;
        if (wMAdActListener != null) {
            wMAdActListener.onAdDestroy();
        }
        WMDexAdHelper.activityMap.remove(this.f46918c);
        WMDexAdHelper.loadViewGroupMap.remove(this.f46918c);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        boolean onKeyDown = super.onKeyDown(i10, keyEvent);
        return this.f46919d != null ? !r1.adOnKeyDown(i10, keyEvent) : onKeyDown;
    }

    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        WMAdActListener wMAdActListener = this.f46919d;
        if (wMAdActListener != null) {
            wMAdActListener.onAdPause();
        }
    }

    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
        WMAdActListener wMAdActListener = this.f46919d;
        if (wMAdActListener != null) {
            wMAdActListener.onAdRestart();
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        WMAdActListener wMAdActListener = this.f46919d;
        if (wMAdActListener != null) {
            wMAdActListener.onAdResume();
        }
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        WMAdActListener wMAdActListener = this.f46919d;
        if (wMAdActListener != null) {
            wMAdActListener.onAdStart();
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        WMAdActListener wMAdActListener = this.f46919d;
        if (wMAdActListener != null) {
            wMAdActListener.onAdStop();
        }
    }
}
