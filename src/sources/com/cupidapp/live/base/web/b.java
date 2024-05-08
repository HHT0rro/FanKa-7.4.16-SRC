package com.cupidapp.live.base.web;

import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import android.view.Window;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.cupidapp.live.base.view.FKAlertLayout;
import java.util.ArrayList;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKChromeClient.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class b extends WebChromeClient {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public final Activity f13054a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public a f13055b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public ValueCallback<Uri[]> f13056c;

    /* renamed from: d, reason: collision with root package name */
    public final int f13057d;

    /* compiled from: FKChromeClient.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface a {

        /* compiled from: FKChromeClient.kt */
        @kotlin.d
        /* renamed from: com.cupidapp.live.base.web.b$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
        public static final class C0148a {
            public static void a(@NotNull a aVar, @Nullable WebView webView, int i10, boolean z10) {
            }

            public static void b(@NotNull a aVar, @NotNull String title) {
                s.i(title, "title");
            }
        }

        void a(@Nullable WebView webView, int i10, boolean z10);

        void b(int i10);

        void c(@NotNull String str);
    }

    public /* synthetic */ b(Activity activity, a aVar, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(activity, (i10 & 2) != 0 ? null : aVar);
    }

    public static final void c(b this$0, String str, String str2, String str3, String str4, long j10) {
        s.i(this$0, "this$0");
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        this$0.f13054a.startActivity(intent);
    }

    public final void b(@NotNull WebView webView) {
        s.i(webView, "webView");
        webView.setDownloadListener(new DownloadListener() { // from class: com.cupidapp.live.base.web.a
            @Override // android.webkit.DownloadListener
            public final void onDownloadStart(String str, String str2, String str3, String str4, long j10) {
                b.c(b.this, str, str2, str3, str4, j10);
            }
        });
    }

    @Nullable
    public final a d() {
        return this.f13055b;
    }

    public final void e(int i10, int i11, @Nullable Intent intent) {
        if (i10 != this.f13057d || this.f13056c == null) {
            return;
        }
        if (intent != null && intent.getData() != null) {
            g(i10, i11, intent);
            return;
        }
        ValueCallback<Uri[]> valueCallback = this.f13056c;
        if (valueCallback != null) {
            valueCallback.onReceiveValue(null);
        }
        this.f13056c = null;
    }

    public final void f() {
        FKAlertLayout.f12456d.d(this.f13054a.getWindow());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void g(int i10, int i11, Intent intent) {
        if (i10 != this.f13057d || this.f13056c == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (i11 == -1 && intent != null) {
            String dataString = intent.getDataString();
            ClipData clipData = intent.getClipData();
            if (clipData != null) {
                int itemCount = clipData.getItemCount();
                for (int i12 = 0; i12 < itemCount; i12++) {
                    Uri uri = clipData.getItemAt(i12).getUri();
                    s.h(uri, "clipData.getItemAt(i).uri");
                    arrayList.set(i12, uri);
                }
            }
            if (dataString != null) {
                Uri parse = Uri.parse(dataString);
                s.h(parse, "parse(dataString)");
                arrayList.add(parse);
            }
        }
        ValueCallback<Uri[]> valueCallback = this.f13056c;
        if (valueCallback != 0) {
            valueCallback.onReceiveValue(arrayList.toArray(new Uri[0]));
        }
        this.f13056c = null;
    }

    public final void h(@Nullable a aVar) {
        this.f13055b = aVar;
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(@Nullable WebView webView, int i10) {
        a aVar = this.f13055b;
        if (aVar == null) {
            FKAlertLayout.a aVar2 = FKAlertLayout.f12456d;
            Window window = this.f13054a.getWindow();
            s.h(window, "activity.window");
            aVar2.b(window).e();
            if (i10 > 80) {
                aVar2.d(this.f13054a.getWindow());
                return;
            }
            return;
        }
        if (aVar != null) {
            aVar.a(webView, i10, true);
        }
        a aVar3 = this.f13055b;
        if (aVar3 != null) {
            aVar3.b(i10);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0010, code lost:
    
        if ((r5.length() > 0) == true) goto L11;
     */
    @Override // android.webkit.WebChromeClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onReceivedTitle(@org.jetbrains.annotations.Nullable android.webkit.WebView r4, @org.jetbrains.annotations.Nullable java.lang.String r5) {
        /*
            r3 = this;
            super.onReceivedTitle(r4, r5)
            r0 = 1
            r1 = 0
            if (r5 == 0) goto L13
            int r2 = r5.length()
            if (r2 <= 0) goto Lf
            r2 = 1
            goto L10
        Lf:
            r2 = 0
        L10:
            if (r2 != r0) goto L13
            goto L14
        L13:
            r0 = 0
        L14:
            if (r0 == 0) goto L2b
            if (r4 == 0) goto L1d
            java.lang.String r4 = r4.getUrl()
            goto L1e
        L1d:
            r4 = 0
        L1e:
            boolean r4 = kotlin.jvm.internal.s.d(r5, r4)
            if (r4 != 0) goto L2b
            com.cupidapp.live.base.web.b$a r4 = r3.f13055b
            if (r4 == 0) goto L2b
            r4.c(r5)
        L2b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.base.web.b.onReceivedTitle(android.webkit.WebView, java.lang.String):void");
    }

    @Override // android.webkit.WebChromeClient
    public boolean onShowFileChooser(@Nullable WebView webView, @Nullable ValueCallback<Uri[]> valueCallback, @Nullable WebChromeClient.FileChooserParams fileChooserParams) {
        this.f13056c = valueCallback;
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("*/*");
        this.f13054a.startActivityForResult(Intent.createChooser(intent, "Image Choose"), this.f13057d);
        return true;
    }

    public b(@NotNull Activity activity, @Nullable a aVar) {
        s.i(activity, "activity");
        this.f13054a = activity;
        this.f13055b = aVar;
        this.f13057d = 2;
    }
}
