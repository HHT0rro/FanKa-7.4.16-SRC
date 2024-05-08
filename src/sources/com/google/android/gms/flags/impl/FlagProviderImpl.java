package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.flags.zzd;
import g7.b;
import g7.d;
import g7.f;
import g7.h;
import g7.j;

@DynamiteApi
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class FlagProviderImpl extends zzd {
    private boolean zzu = false;
    private SharedPreferences zzv;

    @Override // com.google.android.gms.flags.zzc
    public boolean getBooleanFlagValue(String str, boolean z10, int i10) {
        return !this.zzu ? z10 : b.a(this.zzv, str, Boolean.valueOf(z10)).booleanValue();
    }

    @Override // com.google.android.gms.flags.zzc
    public int getIntFlagValue(String str, int i10, int i11) {
        return !this.zzu ? i10 : d.a(this.zzv, str, Integer.valueOf(i10)).intValue();
    }

    @Override // com.google.android.gms.flags.zzc
    public long getLongFlagValue(String str, long j10, int i10) {
        return !this.zzu ? j10 : f.a(this.zzv, str, Long.valueOf(j10)).longValue();
    }

    @Override // com.google.android.gms.flags.zzc
    public String getStringFlagValue(String str, String str2, int i10) {
        return !this.zzu ? str2 : h.a(this.zzv, str, str2);
    }

    @Override // com.google.android.gms.flags.zzc
    public void init(IObjectWrapper iObjectWrapper) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        if (this.zzu) {
            return;
        }
        try {
            this.zzv = j.a(context.createPackageContext("com.google.android.gms", 0));
            this.zzu = true;
        } catch (PackageManager.NameNotFoundException unused) {
        } catch (Exception e2) {
            String valueOf = String.valueOf(e2.getMessage());
            if (valueOf.length() != 0) {
                "Could not retrieve sdk flags, continuing with defaults: ".concat(valueOf);
            }
        }
    }
}
