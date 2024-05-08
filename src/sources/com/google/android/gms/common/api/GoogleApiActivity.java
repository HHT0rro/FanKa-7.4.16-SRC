package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.internal.g;
import com.google.android.gms.common.internal.h;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
@KeepName
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class GoogleApiActivity extends Activity implements DialogInterface.OnCancelListener {

    /* renamed from: b, reason: collision with root package name */
    public int f23374b = 0;

    @RecentlyNonNull
    public static PendingIntent a(@RecentlyNonNull Context context, @RecentlyNonNull PendingIntent pendingIntent, @RecentlyNonNull int i10) {
        return PendingIntent.getActivity(context, 0, b(context, pendingIntent, i10, true), 134217728);
    }

    @RecentlyNonNull
    public static Intent b(@RecentlyNonNull Context context, @RecentlyNonNull PendingIntent pendingIntent, @RecentlyNonNull int i10, @RecentlyNonNull boolean z10) {
        Intent intent = new Intent(context, (Class<?>) GoogleApiActivity.class);
        intent.putExtra("pending_intent", pendingIntent);
        intent.putExtra("failing_client_id", i10);
        intent.putExtra("notify_manager", z10);
        return intent;
    }

    @Override // android.app.Activity
    public void onActivityResult(@RecentlyNonNull int i10, @RecentlyNonNull int i11, @RecentlyNonNull Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i10 == 1) {
            boolean booleanExtra = getIntent().getBooleanExtra("notify_manager", true);
            this.f23374b = 0;
            setResult(i11, intent);
            if (booleanExtra) {
                g c4 = g.c(this);
                if (i11 == -1) {
                    c4.m();
                } else if (i11 == 0) {
                    c4.j(new ConnectionResult(13, null), getIntent().getIntExtra("failing_client_id", -1));
                }
            }
        } else if (i10 == 2) {
            this.f23374b = 0;
            setResult(i11, intent);
        }
        finish();
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(@RecentlyNonNull DialogInterface dialogInterface) {
        this.f23374b = 0;
        setResult(0);
        finish();
    }

    @Override // android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f23374b = bundle.getInt("resolution");
        }
        if (this.f23374b != 1) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                finish();
                return;
            }
            PendingIntent pendingIntent = (PendingIntent) extras.get("pending_intent");
            Integer num = (Integer) extras.get("error_code");
            if (pendingIntent == null && num == null) {
                finish();
                return;
            }
            if (pendingIntent != null) {
                try {
                    startIntentSenderForResult(pendingIntent.getIntentSender(), 1, null, 0, 0, 0);
                    this.f23374b = 1;
                    return;
                } catch (ActivityNotFoundException unused) {
                    if (extras.getBoolean("notify_manager", true)) {
                        g.c(this).j(new ConnectionResult(22, null), getIntent().getIntExtra("failing_client_id", -1));
                    } else {
                        String valueOf = String.valueOf(pendingIntent);
                        StringBuilder sb2 = new StringBuilder(valueOf.length() + 36);
                        sb2.append("Activity not found while launching ");
                        sb2.append(valueOf);
                        sb2.append(".");
                        String sb3 = sb2.toString();
                        if (Build.FINGERPRINT.contains("generic")) {
                            String.valueOf(sb3).concat(" This may occur when resolving Google Play services connection issues on emulators with Google APIs but not Google Play Store.");
                        }
                    }
                    this.f23374b = 1;
                    finish();
                    return;
                } catch (IntentSender.SendIntentException unused2) {
                    finish();
                    return;
                }
            }
            com.google.android.gms.common.a.m().n(this, ((Integer) h.h(num)).intValue(), 2, this);
            this.f23374b = 1;
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(@RecentlyNonNull Bundle bundle) {
        bundle.putInt("resolution", this.f23374b);
        super.onSaveInstanceState(bundle);
    }
}
