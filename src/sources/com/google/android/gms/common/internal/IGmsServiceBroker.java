package com.google.android.gms.common.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;

/* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface IGmsServiceBroker extends IInterface {

    /* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static abstract class Stub extends Binder implements IGmsServiceBroker {

        /* compiled from: com.google.android.gms:play-services-basement@@17.4.0 */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
        public static class zza implements IGmsServiceBroker {
            private final IBinder zza;

            public zza(IBinder iBinder) {
                this.zza = iBinder;
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.zza;
            }

            @Override // com.google.android.gms.common.internal.IGmsServiceBroker
            public final void getService(IGmsCallbacks iGmsCallbacks, @Nullable GetServiceRequest getServiceRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
                    obtain.writeStrongBinder(iGmsCallbacks != null ? iGmsCallbacks.asBinder() : null);
                    if (getServiceRequest != null) {
                        obtain.writeInt(1);
                        getServiceRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zza.transact(46, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.google.android.gms.common.internal.IGmsServiceBroker");
        }

        @Override // android.os.IInterface
        @RecentlyNonNull
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        @RecentlyNonNull
        public boolean onTransact(@RecentlyNonNull int i10, @RecentlyNonNull Parcel parcel, @Nullable Parcel parcel2, @RecentlyNonNull int i11) throws RemoteException {
            IGmsCallbacks zzpVar;
            if (i10 > 16777215) {
                return super.onTransact(i10, parcel, parcel2, i11);
            }
            parcel.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
            IBinder readStrongBinder = parcel.readStrongBinder();
            if (readStrongBinder == null) {
                zzpVar = null;
            } else {
                IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsCallbacks");
                if (queryLocalInterface instanceof IGmsCallbacks) {
                    zzpVar = (IGmsCallbacks) queryLocalInterface;
                } else {
                    zzpVar = new zzp(readStrongBinder);
                }
            }
            if (i10 == 46) {
                getService(zzpVar, parcel.readInt() != 0 ? GetServiceRequest.CREATOR.createFromParcel(parcel) : null);
                ((Parcel) h.h(parcel2)).writeNoException();
                return true;
            }
            if (i10 == 47) {
                if (parcel.readInt() != 0) {
                    zzx.CREATOR.createFromParcel(parcel);
                }
                throw new UnsupportedOperationException();
            }
            parcel.readInt();
            if (i10 != 4) {
                parcel.readString();
            }
            if (i10 != 1) {
                if (i10 != 2 && i10 != 23 && i10 != 25 && i10 != 27) {
                    if (i10 != 30) {
                        if (i10 == 34) {
                            parcel.readString();
                        } else if (i10 != 41 && i10 != 43 && i10 != 37 && i10 != 38) {
                            switch (i10) {
                                case 9:
                                    parcel.readString();
                                    parcel.createStringArray();
                                    parcel.readString();
                                    parcel.readStrongBinder();
                                    parcel.readString();
                                    if (parcel.readInt() != 0) {
                                        break;
                                    }
                                    break;
                                case 10:
                                    parcel.readString();
                                    parcel.createStringArray();
                                    break;
                                case 19:
                                    parcel.readStrongBinder();
                                    if (parcel.readInt() != 0) {
                                        break;
                                    }
                                    break;
                            }
                        }
                    }
                    parcel.createStringArray();
                    parcel.readString();
                    if (parcel.readInt() != 0) {
                    }
                }
                if (parcel.readInt() != 0) {
                }
            } else {
                parcel.readString();
                parcel.createStringArray();
                parcel.readString();
                if (parcel.readInt() != 0) {
                }
            }
            throw new UnsupportedOperationException();
        }
    }

    void getService(@RecentlyNonNull IGmsCallbacks iGmsCallbacks, @Nullable GetServiceRequest getServiceRequest) throws RemoteException;
}
