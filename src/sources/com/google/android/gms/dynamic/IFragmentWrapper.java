package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.common.zzb;
import i7.b;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface IFragmentWrapper extends IInterface {
    @RecentlyNonNull
    IObjectWrapper zza() throws RemoteException;

    void zza(@RecentlyNonNull Intent intent) throws RemoteException;

    void zza(@RecentlyNonNull Intent intent, @RecentlyNonNull int i10) throws RemoteException;

    void zza(@RecentlyNonNull IObjectWrapper iObjectWrapper) throws RemoteException;

    void zza(@RecentlyNonNull boolean z10) throws RemoteException;

    @RecentlyNonNull
    Bundle zzb() throws RemoteException;

    void zzb(@RecentlyNonNull IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzb(@RecentlyNonNull boolean z10) throws RemoteException;

    @RecentlyNonNull
    int zzc() throws RemoteException;

    void zzc(@RecentlyNonNull boolean z10) throws RemoteException;

    @RecentlyNullable
    IFragmentWrapper zzd() throws RemoteException;

    void zzd(@RecentlyNonNull boolean z10) throws RemoteException;

    @RecentlyNonNull
    IObjectWrapper zze() throws RemoteException;

    @RecentlyNonNull
    boolean zzf() throws RemoteException;

    @RecentlyNullable
    String zzg() throws RemoteException;

    @RecentlyNullable
    IFragmentWrapper zzh() throws RemoteException;

    @RecentlyNonNull
    int zzi() throws RemoteException;

    @RecentlyNonNull
    boolean zzj() throws RemoteException;

    @RecentlyNonNull
    IObjectWrapper zzk() throws RemoteException;

    @RecentlyNonNull
    boolean zzl() throws RemoteException;

    @RecentlyNonNull
    boolean zzm() throws RemoteException;

    @RecentlyNonNull
    boolean zzn() throws RemoteException;

    @RecentlyNonNull
    boolean zzo() throws RemoteException;

    @RecentlyNonNull
    boolean zzp() throws RemoteException;

    @RecentlyNonNull
    boolean zzq() throws RemoteException;

    @RecentlyNonNull
    boolean zzr() throws RemoteException;

    /* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static abstract class Stub extends com.google.android.gms.internal.common.zza implements IFragmentWrapper {
        public Stub() {
            super("com.google.android.gms.dynamic.IFragmentWrapper");
        }

        @RecentlyNonNull
        public static IFragmentWrapper asInterface(@RecentlyNonNull IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            if (queryLocalInterface instanceof IFragmentWrapper) {
                return (IFragmentWrapper) queryLocalInterface;
            }
            return new zza(iBinder);
        }

        @Override // com.google.android.gms.internal.common.zza
        @RecentlyNonNull
        public final boolean zza(@RecentlyNonNull int i10, @RecentlyNonNull Parcel parcel, @RecentlyNonNull Parcel parcel2, @RecentlyNonNull int i11) throws RemoteException {
            switch (i10) {
                case 2:
                    IObjectWrapper zza2 = zza();
                    parcel2.writeNoException();
                    b.b(parcel2, zza2);
                    return true;
                case 3:
                    Bundle zzb = zzb();
                    parcel2.writeNoException();
                    b.f(parcel2, zzb);
                    return true;
                case 4:
                    int zzc = zzc();
                    parcel2.writeNoException();
                    parcel2.writeInt(zzc);
                    return true;
                case 5:
                    IFragmentWrapper zzd = zzd();
                    parcel2.writeNoException();
                    b.b(parcel2, zzd);
                    return true;
                case 6:
                    IObjectWrapper zze = zze();
                    parcel2.writeNoException();
                    b.b(parcel2, zze);
                    return true;
                case 7:
                    boolean zzf = zzf();
                    parcel2.writeNoException();
                    b.d(parcel2, zzf);
                    return true;
                case 8:
                    String zzg = zzg();
                    parcel2.writeNoException();
                    parcel2.writeString(zzg);
                    return true;
                case 9:
                    IFragmentWrapper zzh = zzh();
                    parcel2.writeNoException();
                    b.b(parcel2, zzh);
                    return true;
                case 10:
                    int zzi = zzi();
                    parcel2.writeNoException();
                    parcel2.writeInt(zzi);
                    return true;
                case 11:
                    boolean zzj = zzj();
                    parcel2.writeNoException();
                    b.d(parcel2, zzj);
                    return true;
                case 12:
                    IObjectWrapper zzk = zzk();
                    parcel2.writeNoException();
                    b.b(parcel2, zzk);
                    return true;
                case 13:
                    boolean zzl = zzl();
                    parcel2.writeNoException();
                    b.d(parcel2, zzl);
                    return true;
                case 14:
                    boolean zzm = zzm();
                    parcel2.writeNoException();
                    b.d(parcel2, zzm);
                    return true;
                case 15:
                    boolean zzn = zzn();
                    parcel2.writeNoException();
                    b.d(parcel2, zzn);
                    return true;
                case 16:
                    boolean zzo = zzo();
                    parcel2.writeNoException();
                    b.d(parcel2, zzo);
                    return true;
                case 17:
                    boolean zzp = zzp();
                    parcel2.writeNoException();
                    b.d(parcel2, zzp);
                    return true;
                case 18:
                    boolean zzq = zzq();
                    parcel2.writeNoException();
                    b.d(parcel2, zzq);
                    return true;
                case 19:
                    boolean zzr = zzr();
                    parcel2.writeNoException();
                    b.d(parcel2, zzr);
                    return true;
                case 20:
                    zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 21:
                    zza(b.e(parcel));
                    parcel2.writeNoException();
                    return true;
                case 22:
                    zzb(b.e(parcel));
                    parcel2.writeNoException();
                    return true;
                case 23:
                    zzc(b.e(parcel));
                    parcel2.writeNoException();
                    return true;
                case 24:
                    zzd(b.e(parcel));
                    parcel2.writeNoException();
                    return true;
                case 25:
                    zza((Intent) b.a(parcel, Intent.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 26:
                    zza((Intent) b.a(parcel, Intent.CREATOR), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 27:
                    zzb(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                default:
                    return false;
            }
        }

        /* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
        public static class zza extends zzb implements IFragmentWrapper {
            public zza(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.dynamic.IFragmentWrapper");
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final IObjectWrapper zza() throws RemoteException {
                Parcel zza = zza(2, a_());
                IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
                zza.recycle();
                return asInterface;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final Bundle zzb() throws RemoteException {
                Parcel zza = zza(3, a_());
                Bundle bundle = (Bundle) b.a(zza, Bundle.CREATOR);
                zza.recycle();
                return bundle;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final int zzc() throws RemoteException {
                Parcel zza = zza(4, a_());
                int readInt = zza.readInt();
                zza.recycle();
                return readInt;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final IFragmentWrapper zzd() throws RemoteException {
                Parcel zza = zza(5, a_());
                IFragmentWrapper asInterface = Stub.asInterface(zza.readStrongBinder());
                zza.recycle();
                return asInterface;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final IObjectWrapper zze() throws RemoteException {
                Parcel zza = zza(6, a_());
                IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
                zza.recycle();
                return asInterface;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final boolean zzf() throws RemoteException {
                Parcel zza = zza(7, a_());
                boolean e2 = b.e(zza);
                zza.recycle();
                return e2;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final String zzg() throws RemoteException {
                Parcel zza = zza(8, a_());
                String readString = zza.readString();
                zza.recycle();
                return readString;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final IFragmentWrapper zzh() throws RemoteException {
                Parcel zza = zza(9, a_());
                IFragmentWrapper asInterface = Stub.asInterface(zza.readStrongBinder());
                zza.recycle();
                return asInterface;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final int zzi() throws RemoteException {
                Parcel zza = zza(10, a_());
                int readInt = zza.readInt();
                zza.recycle();
                return readInt;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final boolean zzj() throws RemoteException {
                Parcel zza = zza(11, a_());
                boolean e2 = b.e(zza);
                zza.recycle();
                return e2;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final IObjectWrapper zzk() throws RemoteException {
                Parcel zza = zza(12, a_());
                IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zza.readStrongBinder());
                zza.recycle();
                return asInterface;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final boolean zzl() throws RemoteException {
                Parcel zza = zza(13, a_());
                boolean e2 = b.e(zza);
                zza.recycle();
                return e2;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final boolean zzm() throws RemoteException {
                Parcel zza = zza(14, a_());
                boolean e2 = b.e(zza);
                zza.recycle();
                return e2;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final boolean zzn() throws RemoteException {
                Parcel zza = zza(15, a_());
                boolean e2 = b.e(zza);
                zza.recycle();
                return e2;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final boolean zzo() throws RemoteException {
                Parcel zza = zza(16, a_());
                boolean e2 = b.e(zza);
                zza.recycle();
                return e2;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final boolean zzp() throws RemoteException {
                Parcel zza = zza(17, a_());
                boolean e2 = b.e(zza);
                zza.recycle();
                return e2;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final boolean zzq() throws RemoteException {
                Parcel zza = zza(18, a_());
                boolean e2 = b.e(zza);
                zza.recycle();
                return e2;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final boolean zzr() throws RemoteException {
                Parcel zza = zza(19, a_());
                boolean e2 = b.e(zza);
                zza.recycle();
                return e2;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final void zza(IObjectWrapper iObjectWrapper) throws RemoteException {
                Parcel a_ = a_();
                b.b(a_, iObjectWrapper);
                zzb(20, a_);
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final void zzb(boolean z10) throws RemoteException {
                Parcel a_ = a_();
                b.d(a_, z10);
                zzb(22, a_);
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final void zzc(boolean z10) throws RemoteException {
                Parcel a_ = a_();
                b.d(a_, z10);
                zzb(23, a_);
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final void zzd(boolean z10) throws RemoteException {
                Parcel a_ = a_();
                b.d(a_, z10);
                zzb(24, a_);
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final void zza(boolean z10) throws RemoteException {
                Parcel a_ = a_();
                b.d(a_, z10);
                zzb(21, a_);
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final void zzb(IObjectWrapper iObjectWrapper) throws RemoteException {
                Parcel a_ = a_();
                b.b(a_, iObjectWrapper);
                zzb(27, a_);
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final void zza(Intent intent) throws RemoteException {
                Parcel a_ = a_();
                b.c(a_, intent);
                zzb(25, a_);
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final void zza(Intent intent, int i10) throws RemoteException {
                Parcel a_ = a_();
                b.c(a_, intent);
                a_.writeInt(i10);
                zzb(26, a_);
            }
        }
    }
}
