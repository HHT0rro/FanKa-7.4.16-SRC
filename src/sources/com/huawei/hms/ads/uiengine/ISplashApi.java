package com.huawei.hms.ads.uiengine;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface ISplashApi extends IInterface {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class a implements ISplashApi {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.huawei.hms.ads.uiengine.ISplashApi
        public boolean isDestroyed() {
            return false;
        }

        @Override // com.huawei.hms.ads.uiengine.ISplashApi
        public boolean isFinishing() {
            return false;
        }

        @Override // com.huawei.hms.ads.uiengine.ISplashApi
        public void notifyAdDismissed() {
        }

        @Override // com.huawei.hms.ads.uiengine.ISplashApi
        public void notifyAdFailedToLoad(int i10) {
        }

        @Override // com.huawei.hms.ads.uiengine.ISplashApi
        public String notifyAdLoaded() {
            return null;
        }

        @Override // com.huawei.hms.ads.uiengine.ISplashApi
        public void onAdFailToDisplay() {
        }

        @Override // com.huawei.hms.ads.uiengine.ISplashApi
        public void onAdShowEnd(long j10, int i10) {
        }

        @Override // com.huawei.hms.ads.uiengine.ISplashApi
        public void onDisplayTimeUp() {
        }

        @Override // com.huawei.hms.ads.uiengine.ISplashApi
        public void onEasterEggPrepare() {
        }

        @Override // com.huawei.hms.ads.uiengine.ISplashApi
        public void onFeedback(int i10) {
        }

        @Override // com.huawei.hms.ads.uiengine.ISplashApi
        public void onMaterialLoadFailed() {
        }

        @Override // com.huawei.hms.ads.uiengine.ISplashApi
        public void onMaterialLoaded() {
        }

        @Override // com.huawei.hms.ads.uiengine.ISplashApi
        public void onSkipAd(int i10, int i11) {
        }

        @Override // com.huawei.hms.ads.uiengine.ISplashApi
        public void onStartEasterEggFailed(Bundle bundle) {
        }

        @Override // com.huawei.hms.ads.uiengine.ISplashApi
        public boolean onTouch(int i10, int i11, long j10, String str, int i12) {
            return false;
        }

        @Override // com.huawei.hms.ads.uiengine.ISplashApi
        public void removeExSplashBlock() {
        }

        @Override // com.huawei.hms.ads.uiengine.ISplashApi
        public void reportEvents(String str, Bundle bundle) {
        }

        @Override // com.huawei.hms.ads.uiengine.ISplashApi
        public void reportShowStartEvent() {
        }

        @Override // com.huawei.hms.ads.uiengine.ISplashApi
        public void toShowSpare(int i10) {
        }

        @Override // com.huawei.hms.ads.uiengine.ISplashApi
        public void updatePhyShowStart(long j10) {
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static abstract class b extends Binder implements ISplashApi {
        public static final int B = 5;
        public static final int C = 6;
        public static final int Code = 1;
        public static final int D = 9;
        public static final int F = 8;
        public static final int I = 3;
        public static final int L = 10;
        public static final int S = 7;
        public static final int V = 2;
        public static final int Z = 4;

        /* renamed from: a, reason: collision with root package name */
        public static final int f29397a = 11;

        /* renamed from: b, reason: collision with root package name */
        public static final int f29398b = 12;

        /* renamed from: c, reason: collision with root package name */
        public static final int f29399c = 13;

        /* renamed from: d, reason: collision with root package name */
        public static final int f29400d = 14;

        /* renamed from: e, reason: collision with root package name */
        public static final int f29401e = 15;

        /* renamed from: f, reason: collision with root package name */
        public static final int f29402f = 16;

        /* renamed from: g, reason: collision with root package name */
        public static final int f29403g = 17;

        /* renamed from: h, reason: collision with root package name */
        public static final int f29404h = 18;

        /* renamed from: i, reason: collision with root package name */
        public static final int f29405i = 19;

        /* renamed from: j, reason: collision with root package name */
        public static final int f29406j = 20;

        /* renamed from: k, reason: collision with root package name */
        private static final String f29407k = "com.huawei.hms.ads.uiengine.ISplashApi";

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
        public static class a implements ISplashApi {
            public static ISplashApi Code;
            private IBinder V;

            public a(IBinder iBinder) {
                this.V = iBinder;
            }

            public String Code() {
                return b.f29407k;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.V;
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public boolean isDestroyed() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f29407k);
                    if (!this.V.transact(19, obtain, obtain2, 0) && b.Code() != null) {
                        return b.Code().isDestroyed();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public boolean isFinishing() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f29407k);
                    if (!this.V.transact(18, obtain, obtain2, 0) && b.Code() != null) {
                        return b.Code().isFinishing();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public void notifyAdDismissed() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f29407k);
                    if (this.V.transact(7, obtain, obtain2, 0) || b.Code() == null) {
                        obtain2.readException();
                    } else {
                        b.Code().notifyAdDismissed();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public void notifyAdFailedToLoad(int i10) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f29407k);
                    obtain.writeInt(i10);
                    if (this.V.transact(9, obtain, obtain2, 0) || b.Code() == null) {
                        obtain2.readException();
                    } else {
                        b.Code().notifyAdFailedToLoad(i10);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public String notifyAdLoaded() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f29407k);
                    if (!this.V.transact(2, obtain, obtain2, 0) && b.Code() != null) {
                        return b.Code().notifyAdLoaded();
                    }
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public void onAdFailToDisplay() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f29407k);
                    if (this.V.transact(6, obtain, obtain2, 0) || b.Code() == null) {
                        obtain2.readException();
                    } else {
                        b.Code().onAdFailToDisplay();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public void onAdShowEnd(long j10, int i10) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f29407k);
                    obtain.writeLong(j10);
                    obtain.writeInt(i10);
                    if (this.V.transact(15, obtain, obtain2, 0) || b.Code() == null) {
                        obtain2.readException();
                    } else {
                        b.Code().onAdShowEnd(j10, i10);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public void onDisplayTimeUp() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f29407k);
                    if (this.V.transact(12, obtain, obtain2, 0) || b.Code() == null) {
                        obtain2.readException();
                    } else {
                        b.Code().onDisplayTimeUp();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public void onEasterEggPrepare() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f29407k);
                    if (this.V.transact(20, obtain, obtain2, 0) || b.Code() == null) {
                        obtain2.readException();
                    } else {
                        b.Code().onEasterEggPrepare();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public void onFeedback(int i10) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f29407k);
                    obtain.writeInt(i10);
                    if (this.V.transact(14, obtain, obtain2, 0) || b.Code() == null) {
                        obtain2.readException();
                    } else {
                        b.Code().onFeedback(i10);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public void onMaterialLoadFailed() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f29407k);
                    if (this.V.transact(11, obtain, obtain2, 0) || b.Code() == null) {
                        obtain2.readException();
                    } else {
                        b.Code().onMaterialLoadFailed();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public void onMaterialLoaded() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f29407k);
                    if (this.V.transact(5, obtain, obtain2, 0) || b.Code() == null) {
                        obtain2.readException();
                    } else {
                        b.Code().onMaterialLoaded();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public void onSkipAd(int i10, int i11) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f29407k);
                    obtain.writeInt(i10);
                    obtain.writeInt(i11);
                    if (this.V.transact(13, obtain, obtain2, 0) || b.Code() == null) {
                        obtain2.readException();
                    } else {
                        b.Code().onSkipAd(i10, i11);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public void onStartEasterEggFailed(Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f29407k);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.V.transact(17, obtain, obtain2, 0) || b.Code() == null) {
                        obtain2.readException();
                    } else {
                        b.Code().onStartEasterEggFailed(bundle);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public boolean onTouch(int i10, int i11, long j10, String str, int i12) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f29407k);
                    obtain.writeInt(i10);
                    obtain.writeInt(i11);
                    obtain.writeLong(j10);
                    obtain.writeString(str);
                    obtain.writeInt(i12);
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    if (!this.V.transact(1, obtain, obtain2, 0) && b.Code() != null) {
                        boolean onTouch = b.Code().onTouch(i10, i11, j10, str, i12);
                        obtain2.recycle();
                        obtain.recycle();
                        return onTouch;
                    }
                    obtain2.readException();
                    boolean z10 = obtain2.readInt() != 0;
                    obtain2.recycle();
                    obtain.recycle();
                    return z10;
                } catch (Throwable th2) {
                    th = th2;
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public void removeExSplashBlock() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f29407k);
                    if (this.V.transact(10, obtain, obtain2, 0) || b.Code() == null) {
                        obtain2.readException();
                    } else {
                        b.Code().removeExSplashBlock();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public void reportEvents(String str, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f29407k);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.V.transact(16, obtain, obtain2, 0) || b.Code() == null) {
                        obtain2.readException();
                    } else {
                        b.Code().reportEvents(str, bundle);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public void reportShowStartEvent() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f29407k);
                    if (this.V.transact(3, obtain, obtain2, 0) || b.Code() == null) {
                        obtain2.readException();
                    } else {
                        b.Code().reportShowStartEvent();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public void toShowSpare(int i10) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f29407k);
                    obtain.writeInt(i10);
                    if (this.V.transact(8, obtain, obtain2, 0) || b.Code() == null) {
                        obtain2.readException();
                    } else {
                        b.Code().toShowSpare(i10);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.hms.ads.uiengine.ISplashApi
            public void updatePhyShowStart(long j10) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.f29407k);
                    obtain.writeLong(j10);
                    if (this.V.transact(4, obtain, obtain2, 0) || b.Code() == null) {
                        obtain2.readException();
                    } else {
                        b.Code().updatePhyShowStart(j10);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public b() {
            attachInterface(this, f29407k);
        }

        public static ISplashApi Code() {
            return a.Code;
        }

        public static ISplashApi Code(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(f29407k);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ISplashApi)) ? new a(iBinder) : (ISplashApi) queryLocalInterface;
        }

        public static boolean Code(ISplashApi iSplashApi) {
            if (a.Code != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iSplashApi == null) {
                return false;
            }
            a.Code = iSplashApi;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            if (i10 == 1598968902) {
                parcel2.writeString(f29407k);
                return true;
            }
            switch (i10) {
                case 1:
                    parcel.enforceInterface(f29407k);
                    boolean onTouch = onTouch(parcel.readInt(), parcel.readInt(), parcel.readLong(), parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(onTouch ? 1 : 0);
                    return true;
                case 2:
                    parcel.enforceInterface(f29407k);
                    String notifyAdLoaded = notifyAdLoaded();
                    parcel2.writeNoException();
                    parcel2.writeString(notifyAdLoaded);
                    return true;
                case 3:
                    parcel.enforceInterface(f29407k);
                    reportShowStartEvent();
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface(f29407k);
                    updatePhyShowStart(parcel.readLong());
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface(f29407k);
                    onMaterialLoaded();
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface(f29407k);
                    onAdFailToDisplay();
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface(f29407k);
                    notifyAdDismissed();
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface(f29407k);
                    toShowSpare(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface(f29407k);
                    notifyAdFailedToLoad(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface(f29407k);
                    removeExSplashBlock();
                    parcel2.writeNoException();
                    return true;
                case 11:
                    parcel.enforceInterface(f29407k);
                    onMaterialLoadFailed();
                    parcel2.writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface(f29407k);
                    onDisplayTimeUp();
                    parcel2.writeNoException();
                    return true;
                case 13:
                    parcel.enforceInterface(f29407k);
                    onSkipAd(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 14:
                    parcel.enforceInterface(f29407k);
                    onFeedback(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 15:
                    parcel.enforceInterface(f29407k);
                    onAdShowEnd(parcel.readLong(), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 16:
                    parcel.enforceInterface(f29407k);
                    reportEvents(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 17:
                    parcel.enforceInterface(f29407k);
                    onStartEasterEggFailed(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    return true;
                case 18:
                    parcel.enforceInterface(f29407k);
                    boolean isFinishing = isFinishing();
                    parcel2.writeNoException();
                    parcel2.writeInt(isFinishing ? 1 : 0);
                    return true;
                case 19:
                    parcel.enforceInterface(f29407k);
                    boolean isDestroyed = isDestroyed();
                    parcel2.writeNoException();
                    parcel2.writeInt(isDestroyed ? 1 : 0);
                    return true;
                case 20:
                    parcel.enforceInterface(f29407k);
                    onEasterEggPrepare();
                    parcel2.writeNoException();
                    return true;
                default:
                    return super.onTransact(i10, parcel, parcel2, i11);
            }
        }
    }

    boolean isDestroyed();

    boolean isFinishing();

    void notifyAdDismissed();

    void notifyAdFailedToLoad(int i10);

    String notifyAdLoaded();

    void onAdFailToDisplay();

    void onAdShowEnd(long j10, int i10);

    void onDisplayTimeUp();

    void onEasterEggPrepare();

    void onFeedback(int i10);

    void onMaterialLoadFailed();

    void onMaterialLoaded();

    void onSkipAd(int i10, int i11);

    void onStartEasterEggFailed(Bundle bundle);

    boolean onTouch(int i10, int i11, long j10, String str, int i12);

    void removeExSplashBlock();

    void reportEvents(String str, Bundle bundle);

    void reportShowStartEvent();

    void toShowSpare(int i10);

    void updatePhyShowStart(long j10);
}
