package com.google.android.gms.common.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.internal.base.zaj;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ImageManager {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f23550a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static HashSet<Uri> f23551b = new HashSet<>();

    /* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
    @KeepName
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public final class ImageReceiver extends ResultReceiver {

        /* renamed from: b, reason: collision with root package name */
        public final Uri f23552b;

        /* renamed from: c, reason: collision with root package name */
        public final ArrayList<com.google.android.gms.common.images.a> f23553c;

        @Override // android.os.ResultReceiver
        public final void onReceiveResult(int i10, Bundle bundle) {
            ImageManager.h(null).execute(new a(null, this.f23552b, (ParcelFileDescriptor) bundle.getParcelable("com.google.android.gms.extra.fileDescriptor")));
        }
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public final class a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final Uri f23554b;

        /* renamed from: c, reason: collision with root package name */
        @Nullable
        public final ParcelFileDescriptor f23555c;

        public a(ImageManager imageManager, @Nullable Uri uri, ParcelFileDescriptor parcelFileDescriptor) {
            this.f23554b = uri;
            this.f23555c = parcelFileDescriptor;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Bitmap bitmap;
            Bitmap bitmap2;
            boolean z10;
            com.google.android.gms.common.internal.a.b("LoadBitmapFromDiskRunnable can't be executed in the main thread");
            ParcelFileDescriptor parcelFileDescriptor = this.f23555c;
            boolean z11 = false;
            if (parcelFileDescriptor != null) {
                try {
                    bitmap = BitmapFactory.decodeFileDescriptor(parcelFileDescriptor.getFileDescriptor());
                } catch (OutOfMemoryError unused) {
                    String valueOf = String.valueOf(this.f23554b);
                    StringBuilder sb2 = new StringBuilder(valueOf.length() + 34);
                    sb2.append("OOM while loading bitmap for uri: ");
                    sb2.append(valueOf);
                    bitmap = null;
                    z11 = true;
                }
                try {
                    this.f23555c.close();
                } catch (IOException unused2) {
                }
                bitmap2 = bitmap;
                z10 = z11;
            } else {
                bitmap2 = null;
                z10 = false;
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            ImageManager.i(null).post(new b(null, this.f23554b, bitmap2, z10, countDownLatch));
            try {
                countDownLatch.await();
            } catch (InterruptedException unused3) {
                String valueOf2 = String.valueOf(this.f23554b);
                StringBuilder sb3 = new StringBuilder(valueOf2.length() + 32);
                sb3.append("Latch interrupted while posting ");
                sb3.append(valueOf2);
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public final class b implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final Uri f23556b;

        /* renamed from: c, reason: collision with root package name */
        @Nullable
        public final Bitmap f23557c;

        /* renamed from: d, reason: collision with root package name */
        public final CountDownLatch f23558d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f23559e;

        public b(ImageManager imageManager, @Nullable Uri uri, Bitmap bitmap, boolean z10, CountDownLatch countDownLatch) {
            this.f23556b = uri;
            this.f23557c = bitmap;
            this.f23559e = z10;
            this.f23558d = countDownLatch;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.google.android.gms.common.internal.a.a("OnBitmapLoadedRunnable must be executed in the main thread");
            boolean z10 = this.f23557c != null;
            ImageReceiver imageReceiver = (ImageReceiver) ImageManager.g(null).remove(this.f23556b);
            if (imageReceiver != null) {
                ArrayList arrayList = imageReceiver.f23553c;
                int size = arrayList.size();
                for (int i10 = 0; i10 < size; i10++) {
                    com.google.android.gms.common.images.a aVar = (com.google.android.gms.common.images.a) arrayList.get(i10);
                    if (this.f23557c != null && z10) {
                        aVar.a(ImageManager.c(null), this.f23557c, false);
                    } else {
                        ImageManager.f(null).put(this.f23556b, Long.valueOf(SystemClock.elapsedRealtime()));
                        aVar.b(ImageManager.c(null), ImageManager.e(null), false);
                    }
                    ImageManager.b(null).remove(aVar);
                }
            }
            this.f23558d.countDown();
            synchronized (ImageManager.f23550a) {
                ImageManager.f23551b.remove(this.f23556b);
            }
        }
    }

    public static /* synthetic */ Map b(ImageManager imageManager) {
        throw null;
    }

    public static /* synthetic */ Context c(ImageManager imageManager) {
        throw null;
    }

    public static /* synthetic */ zaj e(ImageManager imageManager) {
        throw null;
    }

    public static /* synthetic */ Map f(ImageManager imageManager) {
        throw null;
    }

    public static /* synthetic */ Map g(ImageManager imageManager) {
        throw null;
    }

    public static /* synthetic */ ExecutorService h(ImageManager imageManager) {
        throw null;
    }

    public static /* synthetic */ Handler i(ImageManager imageManager) {
        throw null;
    }
}
