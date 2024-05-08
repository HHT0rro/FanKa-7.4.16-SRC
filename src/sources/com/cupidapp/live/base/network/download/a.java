package com.cupidapp.live.base.network.download;

import com.cupidapp.live.base.network.download.b;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DownloadManager.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public final File f11953a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public final ConcurrentLinkedDeque<FKDownloadModel> f11954b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public C0138a f11955c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public volatile b.a f11956d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public volatile b.InterfaceC0140b f11957e;

    /* compiled from: DownloadManager.kt */
    @kotlin.d
    /* renamed from: com.cupidapp.live.base.network.download.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public final class C0138a extends Thread {

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        public final AtomicBoolean f11958b = new AtomicBoolean(false);

        /* compiled from: DownloadManager.kt */
        @kotlin.d
        /* renamed from: com.cupidapp.live.base.network.download.a$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
        public static final class C0139a implements b.a {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f11960a;

            public C0139a(a aVar) {
                this.f11960a = aVar;
            }

            @Override // com.cupidapp.live.base.network.download.b.a
            public void onFailure(@NotNull String url) {
                s.i(url, "url");
                com.cupidapp.live.base.utils.j.f12332a.a("DownTest", "notifyFailureOnUI  url=" + url);
                b.a aVar = this.f11960a.f11956d;
                if (aVar != null) {
                    aVar.onFailure(url);
                }
            }

            @Override // com.cupidapp.live.base.network.download.b.a
            public void onSuccess(@NotNull String url, @NotNull String localPath) {
                s.i(url, "url");
                s.i(localPath, "localPath");
                com.cupidapp.live.base.utils.j.f12332a.a("DownTest", "notifySuccessOnUI  url=" + url + "  localPath=" + localPath);
                b.a aVar = this.f11960a.f11956d;
                if (aVar != null) {
                    aVar.onSuccess(url, localPath);
                }
            }
        }

        /* compiled from: DownloadManager.kt */
        @kotlin.d
        /* renamed from: com.cupidapp.live.base.network.download.a$a$b */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
        public static final class b implements b.InterfaceC0140b {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f11961a;

            public b(a aVar) {
                this.f11961a = aVar;
            }

            @Override // com.cupidapp.live.base.network.download.b.InterfaceC0140b
            public void a(@NotNull String url, int i10) {
                s.i(url, "url");
                b.InterfaceC0140b interfaceC0140b = this.f11961a.f11957e;
                if (interfaceC0140b != null) {
                    interfaceC0140b.a(url, i10);
                }
            }
        }

        public C0138a() {
        }

        public final boolean a() {
            return this.f11958b.get();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            this.f11958b.set(true);
            while (!a.this.f11954b.isEmpty()) {
                FKDownloadModel fKDownloadModel = (FKDownloadModel) a.this.f11954b.poll();
                if (fKDownloadModel != null) {
                    a aVar = a.this;
                    com.cupidapp.live.base.network.download.b.b(fKDownloadModel.getName(), fKDownloadModel.getUrl(), aVar.f(), new C0139a(aVar), new b(aVar));
                }
            }
            this.f11958b.set(false);
        }
    }

    public a(@Nullable File file) {
        this.f11953a = file;
        this.f11954b = new ConcurrentLinkedDeque<>();
    }

    public final void d(@Nullable String str, @Nullable String str2) {
        if (str2 == null || str2.length() == 0) {
            return;
        }
        this.f11954b.offerFirst(new FKDownloadModel(str, str2));
        i();
    }

    public final void e(@Nullable String str, @Nullable String str2) {
        if (str2 == null || str2.length() == 0) {
            return;
        }
        this.f11954b.offer(new FKDownloadModel(str, str2));
        i();
    }

    @Nullable
    public final File f() {
        return this.f11953a;
    }

    @NotNull
    public final a g(@Nullable b.a aVar) {
        this.f11956d = aVar;
        return this;
    }

    @NotNull
    public final a h(@Nullable b.InterfaceC0140b interfaceC0140b) {
        this.f11957e = interfaceC0140b;
        return this;
    }

    public final void i() {
        if (this.f11954b.isEmpty()) {
            return;
        }
        C0138a c0138a = this.f11955c;
        boolean z10 = false;
        if (c0138a != null && !c0138a.a()) {
            z10 = true;
        }
        if (z10) {
            this.f11955c = null;
        }
        if (this.f11955c == null) {
            C0138a c0138a2 = new C0138a();
            this.f11955c = c0138a2;
            c0138a2.start();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(@NotNull Map<String, String> keyUrlMap, @Nullable File file) {
        this(file);
        s.i(keyUrlMap, "keyUrlMap");
        for (Map.Entry<String, String> entry : keyUrlMap.entrySet()) {
            this.f11954b.offer(new FKDownloadModel(entry.getKey(), entry.getValue()));
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(@NotNull List<String> urls, @Nullable File file) {
        this(file);
        s.i(urls, "urls");
        Iterator<String> iterator2 = urls.iterator2();
        while (iterator2.hasNext()) {
            this.f11954b.offer(new FKDownloadModel(null, iterator2.next()));
        }
    }
}
