package com.cupidapp.live.chat2.helper;

import android.content.Context;
import com.cupidapp.live.AppApplication;
import com.cupidapp.live.base.network.download.b;
import com.cupidapp.live.base.utils.j;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.k;

/* compiled from: ChatBubbleHelper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ChatBubbleHelper {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ChatBubbleHelper f13339a = new ChatBubbleHelper();

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final ConcurrentHashMap<String, String> f13340b = new ConcurrentHashMap<>();

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final List<String> f13341c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public static boolean f13342d;

    /* compiled from: ChatBubbleHelper.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a implements b.a {
        @Override // com.cupidapp.live.base.network.download.b.a
        public void onFailure(@NotNull String url) {
            s.i(url, "url");
        }

        @Override // com.cupidapp.live.base.network.download.b.a
        public void onSuccess(@NotNull String url, @NotNull String localPath) {
            s.i(url, "url");
            s.i(localPath, "localPath");
            ChatBubbleHelper.f13339a.p("下载成功", url, localPath);
        }
    }

    public static final p g(List list, File file) {
        ChatBubbleHelper chatBubbleHelper = f13339a;
        String absolutePath = file.getAbsolutePath();
        s.h(absolutePath, "hideResourceDir.absolutePath");
        chatBubbleHelper.m(list, absolutePath);
        chatBubbleHelper.o(file);
        return p.f51048a;
    }

    public static final void h(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void i(Function1 tmp0, Object obj) {
        s.i(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void q(String url, String tag, String localPath) {
        s.i(url, "$url");
        s.i(tag, "$tag");
        s.i(localPath, "$localPath");
        if (url.length() > 0) {
            f13339a.l("tag:" + tag + "  write: " + url + " -> " + localPath);
            f13340b.put(url, localPath);
            List<String> list = f13341c;
            if (list.contains(url)) {
                list.remove(url);
            }
        }
    }

    public final void f(@NotNull Context context, @Nullable final List<String> list) {
        s.i(context, "context");
        final File u10 = k.f54819a.u(context);
        if ((list == null || list.isEmpty()) || u10 == null) {
            return;
        }
        Single observeOn = Single.fromCallable(new Callable() { // from class: com.cupidapp.live.chat2.helper.d
            @Override // java.util.concurrent.Callable
            public final Object call() {
                p g3;
                g3 = ChatBubbleHelper.g(List.this, u10);
                return g3;
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final ChatBubbleHelper$checkDownloadResources$2 chatBubbleHelper$checkDownloadResources$2 = new Function1<p, p>() { // from class: com.cupidapp.live.chat2.helper.ChatBubbleHelper$checkDownloadResources$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(p pVar) {
                invoke2(pVar);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(p pVar) {
            }
        };
        Consumer consumer = new Consumer() { // from class: com.cupidapp.live.chat2.helper.b
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ChatBubbleHelper.h(Function1.this, obj);
            }
        };
        final ChatBubbleHelper$checkDownloadResources$3 chatBubbleHelper$checkDownloadResources$3 = new Function1<Throwable, p>() { // from class: com.cupidapp.live.chat2.helper.ChatBubbleHelper$checkDownloadResources$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Throwable th) {
                invoke2(th);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
            }
        };
        observeOn.subscribe(consumer, new Consumer() { // from class: com.cupidapp.live.chat2.helper.a
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ChatBubbleHelper.i(Function1.this, obj);
            }
        });
    }

    public final File j(String str, String str2) {
        if (str == null || str.length() == 0) {
            return null;
        }
        if (str2 == null || str2.length() == 0) {
            return null;
        }
        return new File(str2, k(str));
    }

    public final String k(String str) {
        return l1.a.e(str) + ".png";
    }

    public final void l(String str) {
        j.f12332a.a("ChatBubbleHelper", str);
    }

    public final void m(List<String> list, String str) {
        l("readDownloadedResources in " + Thread.currentThread().getName());
        for (String str2 : list) {
            ChatBubbleHelper chatBubbleHelper = f13339a;
            File j10 = chatBubbleHelper.j(str2, str);
            if (j10 != null && j10.exists()) {
                String absolutePath = j10.getAbsolutePath();
                s.h(absolutePath, "localFile.absolutePath");
                chatBubbleHelper.p("已存在", str2, absolutePath);
            } else {
                f13341c.add(str2);
                chatBubbleHelper.l("readDownloadedResources needDownloadUrlList + 1 url:" + str2);
            }
        }
    }

    @Nullable
    public final String n(@NotNull String url) {
        s.i(url, "url");
        return f13340b.get(url);
    }

    public final void o(File file) {
        l("startDownloadResources in " + Thread.currentThread().getName());
        boolean z10 = f13342d;
        List<String> list = f13341c;
        l("startDownloadResources mIsStartedDownload:" + z10 + "  mNeedDownloadUrlList:" + list.isEmpty());
        if (f13342d || list.isEmpty()) {
            return;
        }
        f13342d = true;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (String str : list) {
            linkedHashMap.put(f13339a.k(str), str);
        }
        new com.cupidapp.live.base.network.download.a(linkedHashMap, file).g(new a()).i();
    }

    public final void p(final String str, final String str2, final String str3) {
        AppApplication.f11612d.h().j().post(new Runnable() { // from class: com.cupidapp.live.chat2.helper.c
            @Override // java.lang.Runnable
            public final void run() {
                ChatBubbleHelper.q(String.this, str, str3);
            }
        });
    }
}
