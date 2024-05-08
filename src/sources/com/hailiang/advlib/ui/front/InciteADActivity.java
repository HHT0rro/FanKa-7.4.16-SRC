package com.hailiang.advlib.ui.front;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import androidx.appcompat.app.AppCompatActivity;
import com.hailiang.advlib.common.b;
import com.hailiang.advlib.core.IInciteAd;
import ed.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class InciteADActivity extends AppCompatActivity {

    /* renamed from: b, reason: collision with root package name */
    public static final int f27199b = 64222;

    /* renamed from: a, reason: collision with root package name */
    public IInciteAd f27200a;

    private void a() {
        if (b.c().b(IInciteAd.class) == null) {
            a.a(getApplicationContext());
        }
        this.f27200a = (IInciteAd) b.c().a(IInciteAd.class, new Object[0]);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        IInciteAd iInciteAd = this.f27200a;
        if (iInciteAd != null) {
            iInciteAd.onActivityResultRef(i10, i11, intent);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            a();
            IInciteAd iInciteAd = this.f27200a;
            if (iInciteAd != null) {
                iInciteAd.doWhenReflect(this);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            finish();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        IInciteAd iInciteAd = this.f27200a;
        if (iInciteAd != null) {
            iInciteAd.onDestroyRef(this);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        IInciteAd iInciteAd = this.f27200a;
        if (iInciteAd == null || !Boolean.valueOf(iInciteAd.onKeyEvent(i10, keyEvent)).booleanValue()) {
            return super.onKeyDown(i10, keyEvent);
        }
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        IInciteAd iInciteAd = this.f27200a;
        if (iInciteAd != null) {
            iInciteAd.onPauseRef(this);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        IInciteAd iInciteAd = this.f27200a;
        if (iInciteAd != null) {
            iInciteAd.whenPermDialogReturns(i10, strArr, iArr);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        IInciteAd iInciteAd = this.f27200a;
        if (iInciteAd != null) {
            iInciteAd.onResumeRef(this);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        IInciteAd iInciteAd = this.f27200a;
        if (iInciteAd != null) {
            iInciteAd.onStartRef(this);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        IInciteAd iInciteAd = this.f27200a;
        if (iInciteAd != null) {
            iInciteAd.onStopRef(this);
        }
    }
}
