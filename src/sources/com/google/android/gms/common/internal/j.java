package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class j implements DialogInterface.OnClickListener {
    public static j a(Activity activity, @Nullable Intent intent, int i10) {
        return new l(intent, activity, i10);
    }

    public abstract void b();

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i10) {
        try {
            b();
        } catch (ActivityNotFoundException unused) {
            if (Build.FINGERPRINT.contains("generic")) {
                "Failed to start resolution intent.".concat(" This may occur when resolving Google Play services connection issues on emulators with Google APIs but not Google Play Store.");
            }
        } finally {
            dialogInterface.dismiss();
        }
    }
}
