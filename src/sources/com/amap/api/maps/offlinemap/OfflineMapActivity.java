package com.amap.api.maps.offlinemap;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import com.amap.api.col.p0003l.ew;
import com.amap.api.col.p0003l.ex;
import com.amap.api.col.p0003l.ez;
import com.amap.api.offlineservice.AMapPermissionActivity;
import com.amap.api.offlineservice.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class OfflineMapActivity extends AMapPermissionActivity implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    private static int f8271a;

    /* renamed from: b, reason: collision with root package name */
    private a f8272b;

    /* renamed from: c, reason: collision with root package name */
    private ew f8273c;

    /* renamed from: d, reason: collision with root package name */
    private ew[] f8274d = new ew[32];

    /* renamed from: e, reason: collision with root package name */
    private int f8275e = -1;

    /* renamed from: f, reason: collision with root package name */
    private ex f8276f;

    private void a(ew ewVar) {
        try {
            a aVar = this.f8272b;
            if (aVar != null) {
                aVar.e();
                this.f8272b = null;
            }
            a c4 = c(ewVar);
            this.f8272b = c4;
            if (c4 != null) {
                this.f8273c = ewVar;
                c4.a(this);
                this.f8272b.a();
                this.f8272b.b();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void b(ew ewVar) {
        try {
            f8271a++;
            a(ewVar);
            int i10 = (this.f8275e + 1) % 32;
            this.f8275e = i10;
            this.f8274d[i10] = ewVar;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private a c(ew ewVar) {
        try {
            if (ewVar.f5637a != 1) {
                return null;
            }
            if (this.f8276f == null) {
                this.f8276f = new ex();
            }
            return this.f8276f;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public void closeScr() {
        try {
            if (a((Bundle) null)) {
                return;
            }
            a aVar = this.f8272b;
            if (aVar != null) {
                aVar.e();
            }
            finish();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        try {
            a aVar = this.f8272b;
            if (aVar != null) {
                aVar.a(view);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        try {
            super.onConfigurationChanged(configuration);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
            getWindow().setSoftInputMode(32);
            getWindow().setFormat(-3);
            requestWindowFeature(1);
            ez.a(getApplicationContext());
            this.f8275e = -1;
            f8271a = 0;
            b(new ew());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        try {
            super.onDestroy();
            a aVar = this.f8272b;
            if (aVar != null) {
                aVar.e();
                this.f8272b = null;
            }
            this.f8273c = null;
            this.f8274d = null;
            ex exVar = this.f8276f;
            if (exVar != null) {
                exVar.e();
                this.f8276f = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (i10 == 4) {
            try {
                a aVar = this.f8272b;
                if (aVar != null && !aVar.c()) {
                    return true;
                }
                if (a((Bundle) null)) {
                    return false;
                }
                if (keyEvent == null) {
                    if (f8271a == 1) {
                        finish();
                    }
                    return false;
                }
                this.f8275e = -1;
                f8271a = 0;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return super.onKeyDown(i10, keyEvent);
    }

    @Override // android.app.Activity
    public void onPause() {
        try {
            super.onPause();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.offlineservice.AMapPermissionActivity, android.app.Activity
    public void onResume() {
        try {
            super.onResume();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Activity
    public void onStart() {
        try {
            super.onStart();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        try {
            super.onStop();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void showScr() {
        try {
            setContentView(this.f8272b.d());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void closeScr(Bundle bundle) {
        try {
            if (a(bundle)) {
                return;
            }
            a aVar = this.f8272b;
            if (aVar != null) {
                aVar.e();
            }
            finish();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private boolean a(Bundle bundle) {
        try {
            int i10 = f8271a;
            if ((i10 != 1 || this.f8272b == null) && i10 > 1) {
                f8271a = i10 - 1;
                int i11 = ((this.f8275e - 1) + 32) % 32;
                this.f8275e = i11;
                ew ewVar = this.f8274d[i11];
                ewVar.f5638b = bundle;
                a(ewVar);
                return true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }
}
