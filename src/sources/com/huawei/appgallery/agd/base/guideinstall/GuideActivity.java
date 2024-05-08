package com.huawei.appgallery.agd.base.guideinstall;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.huawei.appgallery.agd.base.api.AgdManager;
import com.huawei.openalliance.ad.download.app.d;
import com.huawei.secure.android.common.intent.SafeIntent;
import j9.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class GuideActivity extends Activity {

    /* renamed from: b, reason: collision with root package name */
    public boolean f27334b;

    /* renamed from: c, reason: collision with root package name */
    public PendingIntent f27335c;

    public static void c(Context context, @NonNull PendingIntent pendingIntent, boolean z10) {
        if (context == null) {
            a.f50348d.e("GuideActivity", "context null");
            return;
        }
        Intent intent = new Intent(context, (Class<?>) GuideActivity.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        } else {
            Activity activity = (Activity) context;
            if (activity.isFinishing() || activity.isDestroyed()) {
                a.f50348d.e("GuideActivity", "activity destroy return");
                return;
            }
        }
        intent.putExtra(d.f32414d, pendingIntent);
        intent.putExtra("guideConnect", z10);
        try {
            context.startActivity(intent);
        } catch (Exception unused) {
            a.f50348d.e("GuideActivity", "guide install unable to startActivity");
        }
    }

    public final void a(@NonNull Intent intent) {
        this.f27334b = intent.getBooleanExtra("guideConnect", false);
        Parcelable parcelableExtra = intent.getParcelableExtra(d.f32414d);
        if (parcelableExtra instanceof PendingIntent) {
            this.f27335c = (PendingIntent) parcelableExtra;
        }
    }

    public final void b(int i10) {
        try {
            startIntentSenderForResult(this.f27335c.getIntentSender(), i10, null, 0, 0, 0);
        } catch (IntentSender.SendIntentException e2) {
            a.f50348d.e("GuideActivity", "resolutionPendingIntent failed with " + e2.getMessage());
            finish();
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        a aVar = a.f50348d;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onActivityResult ");
        sb2.append(i10 == 4 ? "CONNECT" : "AGD_CALLBACK");
        sb2.append(", resultCode ");
        sb2.append(i11);
        aVar.i("GuideActivity", sb2.toString());
        if (i10 == 4) {
            AgdManager.reconnect();
        } else if (i10 != 5) {
            aVar.w("GuideActivity", "unknown request code " + i10);
        } else {
            AgdManager.reSendToAgd();
        }
        finish();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        a(new SafeIntent(getIntent()));
        if (this.f27335c == null) {
            a.f50348d.e("GuideActivity", "invalid param");
            finish();
            return;
        }
        a.f50348d.i("GuideActivity", "onCreate guideConnect " + this.f27334b);
        b(this.f27334b ? 4 : 5);
    }
}
