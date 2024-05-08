package com.hailiang.advlib.ui.front;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import androidx.appcompat.app.AppCompatActivity;
import com.hailiang.advlib.common.b;
import com.hailiang.advlib.core.IADBrowser;
import ed.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ADBrowser extends AppCompatActivity {
    public IADBrowser adBrowserImp;

    private void loadInstance() {
        IADBrowser iADBrowser = (IADBrowser) b.c().a(IADBrowser.class, new Object[0]);
        this.adBrowserImp = iADBrowser;
        if (iADBrowser == null) {
            a.a(getApplicationContext());
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        IADBrowser iADBrowser = this.adBrowserImp;
        if (iADBrowser != null) {
            iADBrowser.onActivityResultRef(i10, i11, intent);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
            loadInstance();
            IADBrowser iADBrowser = this.adBrowserImp;
            if (iADBrowser != null) {
                iADBrowser.doWhenReflect(this, bundle);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            finish();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        IADBrowser iADBrowser = this.adBrowserImp;
        if (iADBrowser == null || !Boolean.valueOf(iADBrowser.onKeyEvent(i10, keyEvent)).booleanValue()) {
            return super.onKeyDown(i10, keyEvent);
        }
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        IADBrowser iADBrowser = this.adBrowserImp;
        if (iADBrowser != null) {
            iADBrowser.whenPermDialogReturns(i10, strArr, iArr);
        }
    }
}
