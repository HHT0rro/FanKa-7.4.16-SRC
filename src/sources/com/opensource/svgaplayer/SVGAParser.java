package com.opensource.svgaplayer;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.http.HttpResponseCache;
import android.os.Handler;
import android.os.Looper;
import com.opensource.svgaplayer.proto.MovieEntity;
import com.wangmai.okhttp.model.HttpHeaders;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.Inflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.s;
import kotlin.p;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: SVGAParser.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class SVGAParser {

    /* renamed from: a, reason: collision with root package name */
    public Context f37906a;

    /* renamed from: b, reason: collision with root package name */
    public volatile int f37907b;

    /* renamed from: c, reason: collision with root package name */
    public volatile int f37908c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public FileDownloader f37909d;

    /* renamed from: h, reason: collision with root package name */
    public static final b f37905h = new b(null);

    /* renamed from: e, reason: collision with root package name */
    public static final AtomicInteger f37902e = new AtomicInteger(0);

    /* renamed from: f, reason: collision with root package name */
    public static SVGAParser f37903f = new SVGAParser(null);

    /* renamed from: g, reason: collision with root package name */
    public static ExecutorService f37904g = Executors.newCachedThreadPool(a.f37916b);

    /* compiled from: SVGAParser.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class FileDownloader {

        /* renamed from: a, reason: collision with root package name */
        public boolean f37910a;

        /* compiled from: SVGAParser.kt */
        @kotlin.d
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
        public static final class a implements Runnable {

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ URL f37912c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ Ref$BooleanRef f37913d;

            /* renamed from: e, reason: collision with root package name */
            public final /* synthetic */ Function1 f37914e;

            /* renamed from: f, reason: collision with root package name */
            public final /* synthetic */ Function1 f37915f;

            public a(URL url, Ref$BooleanRef ref$BooleanRef, Function1 function1, Function1 function12) {
                this.f37912c = url;
                this.f37913d = ref$BooleanRef;
                this.f37914e = function1;
                this.f37915f = function12;
            }

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    ub.c cVar = ub.c.f54010a;
                    cVar.e("SVGAParser", "================ svga file download start ================");
                    if (HttpResponseCache.getInstalled() == null && !FileDownloader.this.a()) {
                        cVar.b("SVGAParser", "SVGAParser can not handle cache before install HttpResponseCache. see https://github.com/yyued/SVGAPlayer-Android#cache");
                        cVar.b("SVGAParser", "在配置 HttpResponseCache 前 SVGAParser 无法缓存. 查看 https://github.com/yyued/SVGAPlayer-Android#cache ");
                    }
                    URLConnection openConnection = this.f37912c.openConnection();
                    if (!(openConnection instanceof HttpURLConnection)) {
                        openConnection = null;
                    }
                    HttpURLConnection httpURLConnection = (HttpURLConnection) openConnection;
                    if (httpURLConnection == null) {
                        return;
                    }
                    httpURLConnection.setConnectTimeout(20000);
                    httpURLConnection.setRequestMethod("GET");
                    httpURLConnection.setRequestProperty(HttpHeaders.HEAD_KEY_CONNECTION, "close");
                    httpURLConnection.connect();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    try {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        try {
                            byte[] bArr = new byte[4096];
                            while (true) {
                                if (this.f37913d.element) {
                                    ub.c.f54010a.f("SVGAParser", "================ svga file download canceled ================");
                                    break;
                                }
                                int read = inputStream.read(bArr, 0, 4096);
                                if (read == -1) {
                                    break;
                                } else {
                                    byteArrayOutputStream.write(bArr, 0, read);
                                }
                            }
                            if (this.f37913d.element) {
                                ub.c.f54010a.f("SVGAParser", "================ svga file download canceled ================");
                                kotlin.io.b.a(byteArrayOutputStream, null);
                                kotlin.io.b.a(inputStream, null);
                                return;
                            }
                            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                            try {
                                ub.c.f54010a.e("SVGAParser", "================ svga file download complete ================");
                                this.f37914e.invoke(byteArrayInputStream);
                                p pVar = p.f51048a;
                                kotlin.io.b.a(byteArrayInputStream, null);
                                kotlin.io.b.a(byteArrayOutputStream, null);
                                kotlin.io.b.a(inputStream, null);
                            } finally {
                            }
                        } finally {
                        }
                    } finally {
                    }
                } catch (Exception e2) {
                    ub.c cVar2 = ub.c.f54010a;
                    cVar2.b("SVGAParser", "================ svga file download fail ================");
                    cVar2.b("SVGAParser", "error: " + e2.getMessage());
                    e2.printStackTrace();
                    this.f37915f.invoke(e2);
                }
            }
        }

        public final boolean a() {
            return this.f37910a;
        }

        @NotNull
        public Function0<p> b(@NotNull URL url, @NotNull Function1<? super InputStream, p> complete, @NotNull Function1<? super Exception, p> failure) {
            s.j(url, "url");
            s.j(complete, "complete");
            s.j(failure, "failure");
            final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
            ref$BooleanRef.element = false;
            Function0<p> function0 = new Function0<p>() { // from class: com.opensource.svgaplayer.SVGAParser$FileDownloader$resume$cancelBlock$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ p invoke() {
                    invoke2();
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Ref$BooleanRef.this.element = true;
                }
            };
            SVGAParser.f37905h.a().execute(new a(url, ref$BooleanRef, complete, failure));
            return function0;
        }
    }

    /* compiled from: SVGAParser.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class a implements ThreadFactory {

        /* renamed from: b, reason: collision with root package name */
        public static final a f37916b = new a();

        @Override // java.util.concurrent.ThreadFactory
        @NotNull
        public final Thread newThread(Runnable runnable) {
            return new Thread(runnable, "SVGAParser-Thread-" + SVGAParser.f37902e.getAndIncrement());
        }
    }

    /* compiled from: SVGAParser.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class b {
        public b() {
        }

        public final ExecutorService a() {
            return SVGAParser.f37904g;
        }

        @NotNull
        public final SVGAParser b() {
            return SVGAParser.f37903f;
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: SVGAParser.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface c {
        void a(@NotNull SVGAVideoEntity sVGAVideoEntity);

        void onError();
    }

    /* compiled from: SVGAParser.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface d {
        void a(@NotNull List<? extends File> list);
    }

    /* compiled from: SVGAParser.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class e implements Runnable {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f37932c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ c f37933d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ d f37934e;

        public e(String str, c cVar, d dVar) {
            this.f37932c = str;
            this.f37933d = cVar;
            this.f37934e = dVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            AssetManager assets;
            InputStream open;
            try {
                Context context = SVGAParser.this.f37906a;
                if (context == null || (assets = context.getAssets()) == null || (open = assets.open(this.f37932c)) == null) {
                    return;
                }
                SVGAParser.this.q(open, SVGACache.f37881c.c("file:///assets/" + this.f37932c), this.f37933d, true, this.f37934e, this.f37932c);
            } catch (Exception e2) {
                SVGAParser.this.z(e2, this.f37933d, this.f37932c);
            }
        }
    }

    /* compiled from: SVGAParser.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class f implements Runnable {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f37936c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ c f37937d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f37938e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ d f37939f;

        public f(String str, c cVar, String str2, d dVar) {
            this.f37936c = str;
            this.f37937d = cVar;
            this.f37938e = str2;
            this.f37939f = dVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (SVGACache.f37881c.i()) {
                SVGAParser.this.p(this.f37936c, this.f37937d, this.f37938e);
            } else {
                SVGAParser.this.s(this.f37936c, this.f37937d, this.f37939f, this.f37938e);
            }
        }
    }

    /* compiled from: SVGAParser.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class g implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f37940b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ c f37941c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ SVGAVideoEntity f37942d;

        public g(String str, c cVar, SVGAVideoEntity sVGAVideoEntity) {
            this.f37940b = str;
            this.f37941c = cVar;
            this.f37942d = sVGAVideoEntity;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ub.c.f54010a.e("SVGAParser", "================ " + this.f37940b + " parser complete ================");
            c cVar = this.f37941c;
            if (cVar != null) {
                cVar.a(this.f37942d);
            }
        }
    }

    /* compiled from: SVGAParser.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class h implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f37943b;

        public h(c cVar) {
            this.f37943b = cVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            c cVar = this.f37943b;
            if (cVar != null) {
                cVar.onError();
            }
        }
    }

    public SVGAParser(@Nullable Context context) {
        this.f37906a = context != null ? context.getApplicationContext() : null;
        SVGACache.f37881c.k(context);
        this.f37909d = new FileDownloader();
    }

    public static /* synthetic */ void o(SVGAParser sVGAParser, String str, c cVar, d dVar, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            dVar = null;
        }
        sVGAParser.n(str, cVar, dVar);
    }

    public static /* synthetic */ Function0 u(SVGAParser sVGAParser, URL url, c cVar, d dVar, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            dVar = null;
        }
        return sVGAParser.t(url, cVar, dVar);
    }

    public final boolean A(byte[] bArr) {
        return bArr.length > 4 && bArr[0] == 80 && bArr[1] == 75 && bArr[2] == 3 && bArr[3] == 4;
    }

    public final byte[] B(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bArr = new byte[2048];
            while (true) {
                int read = inputStream.read(bArr, 0, 2048);
                if (read <= 0) {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    kotlin.io.b.a(byteArrayOutputStream, null);
                    return byteArray;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } finally {
        }
    }

    public final void C(InputStream inputStream, String str) {
        ub.c.f54010a.e("SVGAParser", "================ unzip prepare ================");
        File b4 = SVGACache.f37881c.b(str);
        b4.mkdirs();
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            try {
                ZipInputStream zipInputStream = new ZipInputStream(bufferedInputStream);
                while (true) {
                    try {
                        ZipEntry nextEntry = zipInputStream.getNextEntry();
                        if (nextEntry != null) {
                            String name = nextEntry.getName();
                            s.e(name, "zipItem.name");
                            if (!StringsKt__StringsKt.K(name, "../", false, 2, null)) {
                                String name2 = nextEntry.getName();
                                s.e(name2, "zipItem.name");
                                if (!StringsKt__StringsKt.K(name2, "/", false, 2, null)) {
                                    File file = new File(b4, nextEntry.getName());
                                    String absolutePath = b4.getAbsolutePath();
                                    s.e(absolutePath, "cacheDir.absolutePath");
                                    v(file, absolutePath);
                                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                                    try {
                                        byte[] bArr = new byte[2048];
                                        while (true) {
                                            int read = zipInputStream.read(bArr);
                                            if (read <= 0) {
                                                break;
                                            } else {
                                                fileOutputStream.write(bArr, 0, read);
                                            }
                                        }
                                        p pVar = p.f51048a;
                                        kotlin.io.b.a(fileOutputStream, null);
                                        ub.c.f54010a.b("SVGAParser", "================ unzip complete ================");
                                        zipInputStream.closeEntry();
                                    } finally {
                                    }
                                }
                            }
                        } else {
                            p pVar2 = p.f51048a;
                            kotlin.io.b.a(zipInputStream, null);
                            kotlin.io.b.a(bufferedInputStream, null);
                            return;
                        }
                    } finally {
                    }
                }
            } finally {
            }
        } catch (Exception e2) {
            ub.c cVar = ub.c.f54010a;
            cVar.b("SVGAParser", "================ unzip error ================");
            cVar.c("SVGAParser", "error", e2);
            SVGACache sVGACache = SVGACache.f37881c;
            String absolutePath2 = b4.getAbsolutePath();
            s.e(absolutePath2, "cacheDir.absolutePath");
            sVGACache.f(absolutePath2);
            b4.delete();
            throw e2;
        }
    }

    public final void n(@NotNull String name, @Nullable c cVar, @Nullable d dVar) {
        s.j(name, "name");
        if (this.f37906a == null) {
            ub.c.f54010a.b("SVGAParser", "在配置 SVGAParser context 前, 无法解析 SVGA 文件。");
            return;
        }
        ub.c.f54010a.e("SVGAParser", "================ decode " + name + " from assets ================");
        f37904g.execute(new e(name, cVar, dVar));
    }

    public final void p(String str, c cVar, String str2) {
        FileInputStream fileInputStream;
        ub.c cVar2 = ub.c.f54010a;
        cVar2.e("SVGAParser", "================ decode " + str2 + " from cache ================");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("decodeFromCacheKey called with cacheKey : ");
        sb2.append(str);
        cVar2.a("SVGAParser", sb2.toString());
        if (this.f37906a == null) {
            cVar2.b("SVGAParser", "在配置 SVGAParser context 前, 无法解析 SVGA 文件。");
            return;
        }
        try {
            File b4 = SVGACache.f37881c.b(str);
            File file = new File(b4, "movie.binary");
            if (!file.isFile()) {
                file = null;
            }
            if (file != null) {
                try {
                    cVar2.e("SVGAParser", "binary change to entity");
                    fileInputStream = new FileInputStream(file);
                    try {
                        cVar2.e("SVGAParser", "binary change to entity success");
                        MovieEntity decode = MovieEntity.ADAPTER.decode(fileInputStream);
                        s.e(decode, "MovieEntity.ADAPTER.decode(it)");
                        y(new SVGAVideoEntity(decode, b4, this.f37907b, this.f37908c), cVar, str2);
                        p pVar = p.f51048a;
                        kotlin.io.b.a(fileInputStream, null);
                    } finally {
                    }
                } catch (Exception e2) {
                    ub.c.f54010a.c("SVGAParser", "binary change to entity fail", e2);
                    b4.delete();
                    file.delete();
                    throw e2;
                }
            }
            File file2 = new File(b4, "movie.spec");
            if (!file2.isFile()) {
                file2 = null;
            }
            if (file2 == null) {
                return;
            }
            try {
                cVar2.e("SVGAParser", "spec change to entity");
                fileInputStream = new FileInputStream(file2);
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        byte[] bArr = new byte[2048];
                        while (true) {
                            int read = fileInputStream.read(bArr, 0, 2048);
                            if (read == -1) {
                                JSONObject jSONObject = new JSONObject(byteArrayOutputStream.toString());
                                ub.c.f54010a.e("SVGAParser", "spec change to entity success");
                                y(new SVGAVideoEntity(jSONObject, b4, this.f37907b, this.f37908c), cVar, str2);
                                p pVar2 = p.f51048a;
                                kotlin.io.b.a(byteArrayOutputStream, null);
                                kotlin.io.b.a(fileInputStream, null);
                                return;
                            }
                            byteArrayOutputStream.write(bArr, 0, read);
                        }
                    } finally {
                    }
                } finally {
                    try {
                        throw th;
                    } finally {
                    }
                }
            } catch (Exception e10) {
                ub.c.f54010a.c("SVGAParser", str2 + " movie.spec change to entity fail", e10);
                b4.delete();
                file2.delete();
                throw e10;
            }
        } catch (Exception e11) {
            z(e11, cVar, str2);
        }
    }

    public final void q(@NotNull InputStream inputStream, @NotNull String cacheKey, @Nullable c cVar, boolean z10, @Nullable d dVar, @Nullable String str) {
        s.j(inputStream, "inputStream");
        s.j(cacheKey, "cacheKey");
        if (this.f37906a == null) {
            ub.c.f54010a.b("SVGAParser", "在配置 SVGAParser context 前, 无法解析 SVGA 文件。");
            return;
        }
        ub.c.f54010a.e("SVGAParser", "================ decode " + str + " from input stream ================");
        f37904g.execute(new SVGAParser$decodeFromInputStream$1(this, inputStream, cacheKey, cVar, str, dVar, z10));
    }

    public final void s(@NotNull String cacheKey, @Nullable c cVar, @Nullable d dVar, @Nullable String str) {
        s.j(cacheKey, "cacheKey");
        f37904g.execute(new SVGAParser$decodeFromSVGAFileCacheKey$1(this, str, cacheKey, cVar, dVar));
    }

    @Nullable
    public final Function0<p> t(@NotNull final URL url, @Nullable final c cVar, @Nullable final d dVar) {
        s.j(url, "url");
        if (this.f37906a == null) {
            ub.c.f54010a.b("SVGAParser", "在配置 SVGAParser context 前, 无法解析 SVGA 文件。");
            return null;
        }
        final String url2 = url.toString();
        s.e(url2, "url.toString()");
        ub.c cVar2 = ub.c.f54010a;
        cVar2.e("SVGAParser", "================ decode from url: " + url2 + " ================");
        SVGACache sVGACache = SVGACache.f37881c;
        final String d10 = sVGACache.d(url);
        if (sVGACache.h(d10)) {
            cVar2.e("SVGAParser", "this url cached");
            f37904g.execute(new f(d10, cVar, url2, dVar));
            return null;
        }
        cVar2.e("SVGAParser", "no cached, prepare to download");
        return this.f37909d.b(url, new Function1<InputStream, p>() { // from class: com.opensource.svgaplayer.SVGAParser$decodeFromURL$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(InputStream inputStream) {
                invoke2(inputStream);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull InputStream it) {
                s.j(it, "it");
                SVGAParser.this.q(it, d10, cVar, false, dVar, url2);
            }
        }, new Function1<Exception, p>() { // from class: com.opensource.svgaplayer.SVGAParser$decodeFromURL$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Exception exc) {
                invoke2(exc);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Exception it) {
                s.j(it, "it");
                ub.c.f54010a.b("SVGAParser", "================ svga file: " + ((Object) url) + " download fail ================");
                SVGAParser.this.z(it, cVar, url2);
            }
        });
    }

    public final void v(File file, String str) {
        String dstDirCanonicalPath = new File(str).getCanonicalPath();
        String outputFileCanonicalPath = file.getCanonicalPath();
        s.e(outputFileCanonicalPath, "outputFileCanonicalPath");
        s.e(dstDirCanonicalPath, "dstDirCanonicalPath");
        if (kotlin.text.p.F(outputFileCanonicalPath, dstDirCanonicalPath, false, 2, null)) {
            return;
        }
        throw new IOException("Found Zip Path Traversal Vulnerability with " + dstDirCanonicalPath);
    }

    public final byte[] w(byte[] bArr) {
        Inflater inflater = new Inflater();
        inflater.setInput(bArr, 0, bArr.length);
        byte[] bArr2 = new byte[2048];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            try {
                int inflate = inflater.inflate(bArr2, 0, 2048);
                if (inflate <= 0) {
                    inflater.end();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    kotlin.io.b.a(byteArrayOutputStream, null);
                    return byteArray;
                }
                byteArrayOutputStream.write(bArr2, 0, inflate);
            } finally {
            }
        }
    }

    public final void x(@NotNull Context context) {
        s.j(context, "context");
        Context applicationContext = context.getApplicationContext();
        this.f37906a = applicationContext;
        SVGACache.f37881c.k(applicationContext);
    }

    public final void y(SVGAVideoEntity sVGAVideoEntity, c cVar, String str) {
        new Handler(Looper.getMainLooper()).post(new g(str, cVar, sVGAVideoEntity));
    }

    public final void z(Exception exc, c cVar, String str) {
        exc.printStackTrace();
        ub.c cVar2 = ub.c.f54010a;
        cVar2.b("SVGAParser", "================ " + str + " parser error ================");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(" parse error");
        cVar2.c("SVGAParser", sb2.toString(), exc);
        new Handler(Looper.getMainLooper()).post(new h(cVar));
    }
}
