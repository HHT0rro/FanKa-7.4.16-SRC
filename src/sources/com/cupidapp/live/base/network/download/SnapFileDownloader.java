package com.cupidapp.live.base.network.download;

import android.graphics.Bitmap;
import android.os.Handler;
import com.cupidapp.live.AppApplication;
import com.cupidapp.live.base.network.download.SnapFileDownloader;
import com.cupidapp.live.base.network.download.b;
import com.cupidapp.live.base.utils.b0;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SnapFileDownloader.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class SnapFileDownloader {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public com.cupidapp.live.base.network.download.a f11949a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public File f11950b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final Map<String, c> f11951c = new LinkedHashMap();

    /* compiled from: SnapFileDownloader.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a implements b.a {
        public a() {
        }

        public static final void c(SnapFileDownloader this$0, String url) {
            s.i(this$0, "this$0");
            s.i(url, "$url");
            this$0.f11951c.remove(url);
        }

        public static final void d(SnapFileDownloader this$0, String url) {
            s.i(this$0, "this$0");
            s.i(url, "$url");
            c cVar = (c) this$0.f11951c.get(url);
            if (cVar != null) {
                cVar.a(url);
            }
            this$0.f11951c.remove(url);
        }

        @Override // com.cupidapp.live.base.network.download.b.a
        public void onFailure(@NotNull final String url) {
            s.i(url, "url");
            Handler j10 = AppApplication.f11612d.h().j();
            final SnapFileDownloader snapFileDownloader = SnapFileDownloader.this;
            j10.post(new Runnable() { // from class: com.cupidapp.live.base.network.download.n
                @Override // java.lang.Runnable
                public final void run() {
                    SnapFileDownloader.a.c(SnapFileDownloader.this, url);
                }
            });
        }

        @Override // com.cupidapp.live.base.network.download.b.a
        public void onSuccess(@NotNull final String url, @NotNull String localPath) {
            s.i(url, "url");
            s.i(localPath, "localPath");
            Handler j10 = AppApplication.f11612d.h().j();
            final SnapFileDownloader snapFileDownloader = SnapFileDownloader.this;
            j10.post(new Runnable() { // from class: com.cupidapp.live.base.network.download.m
                @Override // java.lang.Runnable
                public final void run() {
                    SnapFileDownloader.a.d(SnapFileDownloader.this, url);
                }
            });
        }
    }

    /* compiled from: SnapFileDownloader.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class b implements b.InterfaceC0140b {
        @Override // com.cupidapp.live.base.network.download.b.InterfaceC0140b
        public void a(@NotNull String url, int i10) {
            s.i(url, "url");
        }
    }

    /* compiled from: SnapFileDownloader.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface c {
        void a(@NotNull String str);
    }

    public SnapFileDownloader() {
        File A = z0.k.f54819a.A(AppApplication.f11612d.c());
        this.f11950b = A;
        if (A != null) {
            this.f11949a = new com.cupidapp.live.base.network.download.a(A).g(new a()).h(new b());
        }
    }

    public static final Bitmap h(String url, String password, SnapFileDownloader this$0) {
        s.i(url, "$url");
        s.i(password, "$password");
        s.i(this$0, "this$0");
        File A = z0.k.f54819a.A(AppApplication.f11612d.c());
        byte[] c4 = com.cupidapp.live.base.network.download.b.c(url, A != null ? A.getAbsolutePath() : null);
        byte[] b4 = c4 != null ? l1.a.b(c4, password) : null;
        if (b4 != null) {
            return b0.f12284a.b(b4, z0.h.l(this$0), z0.h.k(this$0));
        }
        return null;
    }

    public static final void i(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void j(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void e(@Nullable String str) {
        File file = this.f11950b;
        com.cupidapp.live.base.network.download.b.a(str, file != null ? file.getAbsolutePath() : null);
    }

    public final void f(@Nullable String str, @NotNull c callback) {
        s.i(callback, "callback");
        if (str == null || str.length() == 0) {
            return;
        }
        com.cupidapp.live.base.network.download.a aVar = this.f11949a;
        if (aVar != null) {
            aVar.d(null, str);
        }
        this.f11951c.put(str, callback);
    }

    public final void g(@NotNull final String url, @NotNull final String password, @Nullable final Function1<? super Bitmap, p> function1) {
        s.i(url, "url");
        s.i(password, "password");
        Single observeOn = Single.fromCallable(new Callable() { // from class: com.cupidapp.live.base.network.download.l
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Bitmap h10;
                h10 = SnapFileDownloader.h(String.this, password, this);
                return h10;
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final Function1<Bitmap, p> function12 = new Function1<Bitmap, p>() { // from class: com.cupidapp.live.base.network.download.SnapFileDownloader$loadDecryptedBitmap$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Bitmap bitmap) {
                invoke2(bitmap);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Bitmap bitmap) {
                Function1<Bitmap, p> function13 = function1;
                if (function13 != null) {
                    function13.invoke(bitmap);
                }
            }
        };
        Consumer consumer = new Consumer() { // from class: com.cupidapp.live.base.network.download.j
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SnapFileDownloader.i(Function1.this, obj);
            }
        };
        final SnapFileDownloader$loadDecryptedBitmap$3 snapFileDownloader$loadDecryptedBitmap$3 = new Function1<Throwable, p>() { // from class: com.cupidapp.live.base.network.download.SnapFileDownloader$loadDecryptedBitmap$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Throwable th) {
                invoke2(th);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
            }
        };
        observeOn.subscribe(consumer, new Consumer() { // from class: com.cupidapp.live.base.network.download.k
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                SnapFileDownloader.j(Function1.this, obj);
            }
        });
    }
}
