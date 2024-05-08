package com.amap.api.col.s;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: AdvertisingId.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class cp {

    /* compiled from: AdvertisingId.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final String f7571a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f7572b;

        public a(String str, boolean z10) {
            this.f7571a = str;
            this.f7572b = z10;
        }

        public final boolean a() {
            return this.f7572b;
        }
    }

    /* compiled from: AdvertisingId.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class c implements IInterface {

        /* renamed from: a, reason: collision with root package name */
        private IBinder f7575a;

        public c(IBinder iBinder) {
            this.f7575a = iBinder;
        }

        public final String a() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.f7575a.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.f7575a;
        }

        public final boolean b() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                obtain.writeInt(1);
                this.f7575a.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readInt() != 0;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    public static String a(Context context) {
        try {
            a b4 = b(context);
            if (b4 != null && !b4.a()) {
                return b4.f7571a;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    private static a b(Context context) throws Exception {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return null;
        }
        try {
            byte b4 = 0;
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            b bVar = new b(b4);
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            if (context.bindService(intent, bVar, 1)) {
                try {
                    try {
                        c cVar = new c(bVar.a());
                        boolean b10 = cVar.b();
                        return new a(b10 ? "" : cVar.a(), b10);
                    } finally {
                        context.unbindService(bVar);
                    }
                } catch (Exception e2) {
                    throw e2;
                }
            }
            throw new IOException("Google Play connection failed");
        } catch (Exception e10) {
            throw e10;
        }
    }

    /* compiled from: AdvertisingId.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static final class b implements ServiceConnection {

        /* renamed from: a, reason: collision with root package name */
        public boolean f7573a;

        /* renamed from: b, reason: collision with root package name */
        private final LinkedBlockingQueue<IBinder> f7574b;

        private b() {
            this.f7573a = false;
            this.f7574b = new LinkedBlockingQueue<>(1);
        }

        public final IBinder a() throws InterruptedException {
            if (!this.f7573a) {
                this.f7573a = true;
                return this.f7574b.take();
            }
            throw new IllegalStateException();
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.f7574b.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }

        public /* synthetic */ b(byte b4) {
            this();
        }
    }
}
