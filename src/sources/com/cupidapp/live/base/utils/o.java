package com.cupidapp.live.base.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import com.cupidapp.live.AppApplication;
import com.cupidapp.live.base.extension.ImageAttributeModel;
import com.cupidapp.live.base.utils.o;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKScreenShotListener.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class o {

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public static final a f12354i = new a(null);

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    public static final List<String> f12355j = kotlin.collections.s.o("_id", "mime_type", "datetaken", "width", "height", "_display_name");

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    public static final String[] f12356k = {"screenshot", "screen_shot", "screen-shot", "screen shot", "screencapture", "screen_capture", "screen-capture", "screen capture", "screencap", "screen_cap", "screen-cap", "screen cap"};

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public final WeakReference<Context> f12357a;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public c f12359c;

    /* renamed from: d, reason: collision with root package name */
    public long f12360d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public b f12361e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public b f12362f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public b f12363g;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final ArrayList<String> f12358b = new ArrayList<>();

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public final Handler f12364h = new Handler(Looper.getMainLooper());

    /* compiled from: FKScreenShotListener.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void b() {
            if (kotlin.jvm.internal.s.d(Looper.myLooper(), Looper.getMainLooper())) {
                return;
            }
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            throw new IllegalStateException("Call the method must be in main thread: " + (stackTrace.length >= 4 ? stackTrace[3].toString() : null));
        }

        @NotNull
        public final o c(@NotNull Context context) {
            kotlin.jvm.internal.s.i(context, "context");
            b();
            return new o(new WeakReference(context));
        }
    }

    /* compiled from: FKScreenShotListener.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public final class b extends ContentObserver {

        /* renamed from: a, reason: collision with root package name */
        @NotNull
        public final Uri f12365a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ o f12366b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull o oVar, @NotNull Uri mContentUri, Handler handler) {
            super(handler);
            kotlin.jvm.internal.s.i(mContentUri, "mContentUri");
            kotlin.jvm.internal.s.i(handler, "handler");
            this.f12366b = oVar;
            this.f12365a = mContentUri;
        }

        public static final kotlin.p b(o this$0, b this$1) {
            kotlin.jvm.internal.s.i(this$0, "this$0");
            kotlin.jvm.internal.s.i(this$1, "this$1");
            this$0.g(this$1.f12365a);
            return kotlin.p.f51048a;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10) {
            super.onChange(z10);
            final o oVar = this.f12366b;
            Observable.fromCallable(new Callable() { // from class: com.cupidapp.live.base.utils.p
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    kotlin.p b4;
                    b4 = o.b.b(o.this, this);
                    return b4;
                }
            }).subscribeOn(Schedulers.io()).subscribe();
        }
    }

    /* compiled from: FKScreenShotListener.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface c {

        /* compiled from: FKScreenShotListener.kt */
        @kotlin.d
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
        public static final class a {
            public static void a(@NotNull c cVar, long j10) {
            }
        }

        void a(long j10);

        void b(@NotNull String str, boolean z10);
    }

    public o(@Nullable WeakReference<Context> weakReference) {
        this.f12357a = weakReference;
        if (weakReference == null) {
            throw new IllegalArgumentException("The context must not be null.".toString());
        }
    }

    public static final void i(o this$0, String uriString, int i10) {
        int a10;
        kotlin.jvm.internal.s.i(this$0, "this$0");
        kotlin.jvm.internal.s.i(uriString, "$uriString");
        z0.s sVar = z0.s.f54824a;
        if (sVar.a() == 0) {
            a10 = z0.h.k(this$0);
        } else {
            a10 = sVar.a();
        }
        c cVar = this$0.f12359c;
        if (cVar != null) {
            cVar.b(uriString, i10 > a10);
        }
    }

    public static final void k(o this$0, String uriString, long j10) {
        c cVar;
        kotlin.jvm.internal.s.i(this$0, "this$0");
        kotlin.jvm.internal.s.i(uriString, "$uriString");
        if (this$0.f12359c == null || this$0.d(uriString) || (cVar = this$0.f12359c) == null) {
            return;
        }
        cVar.a(j10);
    }

    public final boolean d(String str) {
        if (this.f12358b.contains(str)) {
            return true;
        }
        if (this.f12358b.size() >= 20) {
            for (int i10 = 0; i10 < 5; i10++) {
                this.f12358b.remove(0);
            }
        }
        this.f12358b.add(str);
        return false;
    }

    public final boolean e(String str, long j10, long j11) {
        if (j10 >= this.f12360d && System.currentTimeMillis() - j10 <= 15000) {
            if (!(str.length() == 0) && j11 > 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean f(String str, long j10, int i10, String str2) {
        if (j10 < this.f12360d || System.currentTimeMillis() - j10 > 15000 || (i10 > z0.h.l(this) && i10 > z0.h.k(this))) {
            return false;
        }
        if (str.length() == 0) {
            return false;
        }
        for (String str3 : f12356k) {
            Locale locale = Locale.getDefault();
            kotlin.jvm.internal.s.h(locale, "getDefault()");
            String lowerCase = str2.toLowerCase(locale);
            kotlin.jvm.internal.s.h(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            if (StringsKt__StringsKt.K(lowerCase, str3, false, 2, null)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x008b A[Catch: all -> 0x0151, Exception -> 0x0153, TRY_ENTER, TryCatch #1 {Exception -> 0x0153, blocks: (B:6:0x001f, B:8:0x0026, B:10:0x0045, B:12:0x004d, B:14:0x0053, B:18:0x008b, B:21:0x0093, B:23:0x0099, B:29:0x00aa, B:37:0x00e1, B:40:0x0112, B:41:0x0119, B:43:0x0120, B:49:0x0130, B:51:0x0136, B:58:0x0060, B:60:0x0064, B:62:0x006c, B:64:0x0072), top: B:5:0x001f, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0093 A[Catch: all -> 0x0151, Exception -> 0x0153, TryCatch #1 {Exception -> 0x0153, blocks: (B:6:0x001f, B:8:0x0026, B:10:0x0045, B:12:0x004d, B:14:0x0053, B:18:0x008b, B:21:0x0093, B:23:0x0099, B:29:0x00aa, B:37:0x00e1, B:40:0x0112, B:41:0x0119, B:43:0x0120, B:49:0x0130, B:51:0x0136, B:58:0x0060, B:60:0x0064, B:62:0x006c, B:64:0x0072), top: B:5:0x001f, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void g(android.net.Uri r17) {
        /*
            Method dump skipped, instructions count: 365
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.base.utils.o.g(android.net.Uri):void");
    }

    public final void h(final String str, long j10, int i10, final int i11, String str2) {
        WeakReference<Context> weakReference;
        Context context;
        if (f(str, j10, i10, str2)) {
            if (d(str) || (weakReference = this.f12357a) == null || (context = weakReference.get()) == null) {
                return;
            }
            ImageAttributeModel l10 = z0.f.l(context, str);
            if (l10.getHeight() > i11) {
                i11 = l10.getHeight();
            }
            AppApplication.f11612d.h().j().post(new Runnable() { // from class: com.cupidapp.live.base.utils.m
                @Override // java.lang.Runnable
                public final void run() {
                    o.i(o.this, str, i11);
                }
            });
            return;
        }
        j.f12332a.a("ScreenShotManager", "Media content changed, but not screenshot: uriString:" + str + "  size:" + i10 + " " + i11 + "  date:" + j10 + "  displayName:" + str2);
    }

    public final void j(final String str, long j10, final long j11) {
        if (e(str, j10, j11)) {
            AppApplication.f11612d.h().j().post(new Runnable() { // from class: com.cupidapp.live.base.utils.n
                @Override // java.lang.Runnable
                public final void run() {
                    o.k(o.this, str, j11);
                }
            });
            return;
        }
        j.f12332a.a("ScreenShotManager", "Media content changed, but not screenrecord. uriString: " + str + " dateTaken: " + j10 + " duration: " + j11);
    }

    public final void l(@NotNull c listener) {
        kotlin.jvm.internal.s.i(listener, "listener");
        this.f12359c = listener;
    }

    public final void m() {
        Context context;
        ContentResolver contentResolver;
        Context context2;
        ContentResolver contentResolver2;
        Context context3;
        ContentResolver contentResolver3;
        f12354i.b();
        this.f12358b.clear();
        this.f12360d = System.currentTimeMillis();
        Uri internalImageUri = MediaStore.Images.Media.INTERNAL_CONTENT_URI;
        kotlin.jvm.internal.s.h(internalImageUri, "internalImageUri");
        b bVar = new b(this, internalImageUri, this.f12364h);
        WeakReference<Context> weakReference = this.f12357a;
        if (weakReference != null && (context3 = weakReference.get()) != null && (contentResolver3 = context3.getContentResolver()) != null) {
            contentResolver3.registerContentObserver(internalImageUri, false, bVar);
        }
        this.f12361e = bVar;
        Uri externalImageUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        kotlin.jvm.internal.s.h(externalImageUri, "externalImageUri");
        b bVar2 = new b(this, externalImageUri, this.f12364h);
        WeakReference<Context> weakReference2 = this.f12357a;
        if (weakReference2 != null && (context2 = weakReference2.get()) != null && (contentResolver2 = context2.getContentResolver()) != null) {
            contentResolver2.registerContentObserver(externalImageUri, true, bVar2);
        }
        this.f12362f = bVar2;
        Uri externalVideoUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        kotlin.jvm.internal.s.h(externalVideoUri, "externalVideoUri");
        b bVar3 = new b(this, externalVideoUri, this.f12364h);
        WeakReference<Context> weakReference3 = this.f12357a;
        if (weakReference3 != null && (context = weakReference3.get()) != null && (contentResolver = context.getContentResolver()) != null) {
            contentResolver.registerContentObserver(externalVideoUri, true, bVar3);
        }
        this.f12363g = bVar3;
    }

    public final void n() {
        Context context;
        ContentResolver contentResolver;
        Context context2;
        ContentResolver contentResolver2;
        Context context3;
        ContentResolver contentResolver3;
        f12354i.b();
        if (this.f12361e != null) {
            try {
                WeakReference<Context> weakReference = this.f12357a;
                if (weakReference != null && (context = weakReference.get()) != null && (contentResolver = context.getContentResolver()) != null) {
                    b bVar = this.f12361e;
                    kotlin.jvm.internal.s.f(bVar);
                    contentResolver.unregisterContentObserver(bVar);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.f12361e = null;
        }
        if (this.f12362f != null) {
            try {
                WeakReference<Context> weakReference2 = this.f12357a;
                if (weakReference2 != null && (context2 = weakReference2.get()) != null && (contentResolver2 = context2.getContentResolver()) != null) {
                    b bVar2 = this.f12362f;
                    kotlin.jvm.internal.s.f(bVar2);
                    contentResolver2.unregisterContentObserver(bVar2);
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            this.f12362f = null;
        }
        if (this.f12363g != null) {
            try {
                WeakReference<Context> weakReference3 = this.f12357a;
                if (weakReference3 != null && (context3 = weakReference3.get()) != null && (contentResolver3 = context3.getContentResolver()) != null) {
                    b bVar3 = this.f12363g;
                    kotlin.jvm.internal.s.f(bVar3);
                    contentResolver3.unregisterContentObserver(bVar3);
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        this.f12360d = 0L;
        this.f12358b.clear();
    }
}
