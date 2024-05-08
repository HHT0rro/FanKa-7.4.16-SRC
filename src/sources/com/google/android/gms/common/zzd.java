package com.google.android.gms.common;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.zzm;
import com.google.android.gms.common.internal.zzo;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import org.apache.commons.lang3.CharEncoding;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public abstract class zzd extends zzo {
    private int zza;

    public zzd(byte[] bArr) {
        com.google.android.gms.common.internal.h.a(bArr.length == 25);
        this.zza = Arrays.hashCode(bArr);
    }

    public static byte[] zza(String str) {
        try {
            return str.getBytes(CharEncoding.ISO_8859_1);
        } catch (UnsupportedEncodingException e2) {
            throw new AssertionError(e2);
        }
    }

    public boolean equals(@Nullable Object obj) {
        IObjectWrapper zzb;
        if (obj != null && (obj instanceof zzm)) {
            try {
                zzm zzmVar = (zzm) obj;
                if (zzmVar.zzc() == hashCode() && (zzb = zzmVar.zzb()) != null) {
                    return Arrays.equals(zza(), (byte[]) ObjectWrapper.unwrap(zzb));
                }
                return false;
            } catch (RemoteException unused) {
            }
        }
        return false;
    }

    public int hashCode() {
        return this.zza;
    }

    public abstract byte[] zza();

    @Override // com.google.android.gms.common.internal.zzm
    public final IObjectWrapper zzb() {
        return ObjectWrapper.wrap(zza());
    }

    @Override // com.google.android.gms.common.internal.zzm
    public final int zzc() {
        return hashCode();
    }
}
