package com.cupidapp.live.base.network.download;

import java.io.File;
import java.io.IOException;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.s;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DownloadUtils.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f11962a = new b();

    /* compiled from: DownloadUtils.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface a {
        void onFailure(@NotNull String str);

        void onSuccess(@NotNull String str, @NotNull String str2);
    }

    /* compiled from: DownloadUtils.kt */
    @kotlin.d
    /* renamed from: com.cupidapp.live.base.network.download.b$b, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface InterfaceC0140b {
        void a(@NotNull String str, int i10);
    }

    /* compiled from: DownloadUtils.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class c extends ResponseBody {

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        public final ResponseBody f11963b;

        /* renamed from: c, reason: collision with root package name */
        @NotNull
        public final a f11964c;

        /* renamed from: d, reason: collision with root package name */
        @Nullable
        public BufferedSource f11965d;

        /* compiled from: DownloadUtils.kt */
        @kotlin.d
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
        public interface a {
            void a(long j10);

            void onProgress(int i10);
        }

        /* compiled from: DownloadUtils.kt */
        @kotlin.d
        /* renamed from: com.cupidapp.live.base.network.download.b$c$b, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
        public static final class C0141b extends ForwardingSource {

            /* renamed from: b, reason: collision with root package name */
            public long f11966b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ c f11967c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0141b(Source source, c cVar) {
                super(source);
                this.f11967c = cVar;
            }

            @Override // okio.ForwardingSource, okio.Source
            public long read(@NotNull Buffer sink, long j10) {
                s.i(sink, "sink");
                long read = super.read(sink, j10);
                if (read == -1) {
                    this.f11967c.a().a(this.f11967c.b().contentLength());
                } else {
                    long j11 = this.f11966b + read;
                    this.f11966b = j11;
                    this.f11967c.a().onProgress((int) ((((float) (j11 * 100)) * 1.0f) / ((float) this.f11967c.b().contentLength())));
                }
                return read;
            }
        }

        public c(@NotNull ResponseBody responseBody, @NotNull a progressListener) {
            s.i(responseBody, "responseBody");
            s.i(progressListener, "progressListener");
            this.f11963b = responseBody;
            this.f11964c = progressListener;
        }

        @NotNull
        public final a a() {
            return this.f11964c;
        }

        @NotNull
        public final ResponseBody b() {
            return this.f11963b;
        }

        @Override // okhttp3.ResponseBody
        public long contentLength() {
            return this.f11963b.contentLength();
        }

        @Override // okhttp3.ResponseBody
        @Nullable
        public MediaType contentType() {
            return this.f11963b.contentType();
        }

        public final Source d(Source source) {
            return new C0141b(source, this);
        }

        @Override // okhttp3.ResponseBody
        @NotNull
        public BufferedSource source() {
            if (this.f11965d == null) {
                this.f11965d = Okio.buffer(d(this.f11963b.source()));
            }
            BufferedSource bufferedSource = this.f11965d;
            s.g(bufferedSource, "null cannot be cast to non-null type okio.BufferedSource");
            return bufferedSource;
        }
    }

    /* compiled from: DownloadUtils.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class d implements c.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref$LongRef f11968a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ InterfaceC0140b f11969b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f11970c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Ref$ObjectRef<File> f11971d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Ref$BooleanRef f11972e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Ref$ObjectRef<File> f11973f;

        public d(Ref$LongRef ref$LongRef, InterfaceC0140b interfaceC0140b, String str, Ref$ObjectRef<File> ref$ObjectRef, Ref$BooleanRef ref$BooleanRef, Ref$ObjectRef<File> ref$ObjectRef2) {
            this.f11968a = ref$LongRef;
            this.f11969b = interfaceC0140b;
            this.f11970c = str;
            this.f11971d = ref$ObjectRef;
            this.f11972e = ref$BooleanRef;
            this.f11973f = ref$ObjectRef2;
        }

        @Override // com.cupidapp.live.base.network.download.b.c.a
        public void a(long j10) {
            com.cupidapp.live.base.utils.j.f12332a.a("DownTest", "onComplete  size=" + j10 + "  length=" + this.f11971d.element.length() + "  tempFile=" + this.f11971d.element.getAbsolutePath());
            this.f11972e.element = this.f11971d.element.renameTo(this.f11973f.element);
        }

        @Override // com.cupidapp.live.base.network.download.b.c.a
        public void onProgress(int i10) {
            long currentTimeMillis = System.currentTimeMillis();
            Ref$LongRef ref$LongRef = this.f11968a;
            if (currentTimeMillis > ref$LongRef.element + 2000) {
                ref$LongRef.element = currentTimeMillis;
                com.cupidapp.live.base.utils.j.f12332a.a("DownTest", "onProgress=" + i10);
                InterfaceC0140b interfaceC0140b = this.f11969b;
                if (interfaceC0140b != null) {
                    interfaceC0140b.a(this.f11970c, i10);
                }
            }
        }
    }

    public static final void a(@Nullable String str, @Nullable String str2) {
        File d10 = d(str, str2);
        if (d10 != null && d10.exists()) {
            d10.delete();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0411 A[Catch: all -> 0x0416, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x0416, blocks: (B:127:0x0411, B:218:0x0368), top: B:217:0x0368 }] */
    /* JADX WARN: Removed duplicated region for block: B:132:0x041b  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x049d  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x04a7  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0527  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00b0 A[Catch: all -> 0x03fb, Exception -> 0x0406, TryCatch #6 {Exception -> 0x0406, all -> 0x03fb, blocks: (B:8:0x0083, B:12:0x0097, B:14:0x009d, B:16:0x00a2, B:21:0x00b0, B:22:0x00cc, B:25:0x00de, B:54:0x0176, B:56:0x018a, B:57:0x0191, B:60:0x01a5, B:88:0x0230), top: B:7:0x0083 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0176 A[Catch: all -> 0x03fb, Exception -> 0x0406, TRY_ENTER, TryCatch #6 {Exception -> 0x0406, all -> 0x03fb, blocks: (B:8:0x0083, B:12:0x0097, B:14:0x009d, B:16:0x00a2, B:21:0x00b0, B:22:0x00cc, B:25:0x00de, B:54:0x0176, B:56:0x018a, B:57:0x0191, B:60:0x01a5, B:88:0x0230), top: B:7:0x0083 }] */
    /* JADX WARN: Type inference failed for: r0v20, types: [T, java.io.File] */
    /* JADX WARN: Type inference failed for: r3v16, types: [T, java.io.File] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void b(@org.jetbrains.annotations.Nullable java.lang.String r21, @org.jetbrains.annotations.NotNull java.lang.String r22, @org.jetbrains.annotations.Nullable java.io.File r23, @org.jetbrains.annotations.Nullable com.cupidapp.live.base.network.download.b.a r24, @org.jetbrains.annotations.Nullable com.cupidapp.live.base.network.download.b.InterfaceC0140b r25) {
        /*
            Method dump skipped, instructions count: 1324
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.base.network.download.b.b(java.lang.String, java.lang.String, java.io.File, com.cupidapp.live.base.network.download.b$a, com.cupidapp.live.base.network.download.b$b):void");
    }

    @Nullable
    public static final byte[] c(@Nullable String str, @Nullable String str2) {
        File d10 = d(str, str2);
        if (d10 != null && d10.exists()) {
            try {
                return kotlin.io.h.c(d10);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    public static final File d(String str, String str2) {
        if (str == null || str.length() == 0) {
            return null;
        }
        if (str2 == null || str2.length() == 0) {
            return null;
        }
        return new File(str2, e(str));
    }

    @NotNull
    public static final String e(@NotNull String url) {
        s.i(url, "url");
        return l1.a.e(url) + f(url);
    }

    public static final String f(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        int d02 = StringsKt__StringsKt.d0(str, ".", 0, false, 6, null);
        String separator = File.separator;
        s.h(separator, "separator");
        if (StringsKt__StringsKt.d0(str, separator, 0, false, 6, null) >= d02) {
            return "";
        }
        String substring = str.substring(d02);
        s.h(substring, "this as java.lang.String).substring(startIndex)");
        return substring;
    }
}
