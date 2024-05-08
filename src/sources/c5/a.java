package c5;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.r0;
import com.google.android.exoplayer2.upstream.DataSourceException;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.util.j0;
import com.google.common.base.p;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import o6.f;
import o6.v;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* compiled from: OkHttpDataSource.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class a extends f implements HttpDataSource {

    /* renamed from: e, reason: collision with root package name */
    public final Call.Factory f1514e;

    /* renamed from: f, reason: collision with root package name */
    public final HttpDataSource.b f1515f;

    /* renamed from: g, reason: collision with root package name */
    @Nullable
    public final String f1516g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public final CacheControl f1517h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public final HttpDataSource.b f1518i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    public p<String> f1519j;

    /* renamed from: k, reason: collision with root package name */
    @Nullable
    public com.google.android.exoplayer2.upstream.b f1520k;

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    public Response f1521l;

    /* renamed from: m, reason: collision with root package name */
    @Nullable
    public InputStream f1522m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f1523n;

    /* renamed from: o, reason: collision with root package name */
    public long f1524o;

    /* renamed from: p, reason: collision with root package name */
    public long f1525p;

    /* compiled from: OkHttpDataSource.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b implements HttpDataSource.a {

        /* renamed from: a, reason: collision with root package name */
        public final HttpDataSource.b f1526a = new HttpDataSource.b();

        /* renamed from: b, reason: collision with root package name */
        public final Call.Factory f1527b;

        /* renamed from: c, reason: collision with root package name */
        @Nullable
        public String f1528c;

        /* renamed from: d, reason: collision with root package name */
        @Nullable
        public v f1529d;

        /* renamed from: e, reason: collision with root package name */
        @Nullable
        public CacheControl f1530e;

        /* renamed from: f, reason: collision with root package name */
        @Nullable
        public p<String> f1531f;

        public b(Call.Factory factory) {
            this.f1527b = factory;
        }

        @Override // com.google.android.exoplayer2.upstream.a.InterfaceC0208a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public a a() {
            a aVar = new a(this.f1527b, this.f1528c, this.f1530e, this.f1526a, this.f1531f);
            v vVar = this.f1529d;
            if (vVar != null) {
                aVar.d(vVar);
            }
            return aVar;
        }
    }

    static {
        r0.a("goog.exo.okhttp");
    }

    public final void A(long j10, com.google.android.exoplayer2.upstream.b bVar) throws HttpDataSource.HttpDataSourceException {
        if (j10 == 0) {
            return;
        }
        byte[] bArr = new byte[4096];
        while (j10 > 0) {
            try {
                int read = ((InputStream) j0.j(this.f1522m)).read(bArr, 0, (int) Math.min(j10, 4096));
                if (Thread.currentThread().isInterrupted()) {
                    throw new InterruptedIOException();
                }
                if (read != -1) {
                    j10 -= read;
                    t(read);
                } else {
                    throw new HttpDataSource.HttpDataSourceException(bVar, 2008, 1);
                }
            } catch (IOException e2) {
                if (e2 instanceof HttpDataSource.HttpDataSourceException) {
                    throw ((HttpDataSource.HttpDataSourceException) e2);
                }
                throw new HttpDataSource.HttpDataSourceException(bVar, 2000, 1);
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public long a(com.google.android.exoplayer2.upstream.b bVar) throws HttpDataSource.HttpDataSourceException {
        byte[] bArr;
        this.f1520k = bVar;
        long j10 = 0;
        this.f1525p = 0L;
        this.f1524o = 0L;
        v(bVar);
        try {
            Response execute = this.f1514e.newCall(y(bVar)).execute();
            this.f1521l = execute;
            ResponseBody responseBody = (ResponseBody) com.google.android.exoplayer2.util.a.e(execute.body());
            this.f1522m = responseBody.byteStream();
            int code = execute.code();
            if (!execute.isSuccessful()) {
                if (code == 416) {
                    if (bVar.f22773g == o6.p.c(execute.headers().get("Content-Range"))) {
                        this.f1523n = true;
                        w(bVar);
                        long j11 = bVar.f22774h;
                        if (j11 != -1) {
                            return j11;
                        }
                        return 0L;
                    }
                }
                try {
                    bArr = j0.S0((InputStream) com.google.android.exoplayer2.util.a.e(this.f1522m));
                } catch (IOException unused) {
                    bArr = j0.f22995f;
                }
                byte[] bArr2 = bArr;
                Map<String, List<String>> multimap = execute.headers().toMultimap();
                x();
                throw new HttpDataSource.InvalidResponseCodeException(code, execute.message(), code == 416 ? new DataSourceException(2008) : null, multimap, bVar, bArr2);
            }
            MediaType contentType = responseBody.contentType();
            String mediaType = contentType != null ? contentType.toString() : "";
            p<String> pVar = this.f1519j;
            if (pVar != null && !pVar.apply(mediaType)) {
                x();
                throw new HttpDataSource.InvalidContentTypeException(mediaType, bVar);
            }
            if (code == 200) {
                long j12 = bVar.f22773g;
                if (j12 != 0) {
                    j10 = j12;
                }
            }
            long j13 = bVar.f22774h;
            if (j13 != -1) {
                this.f1524o = j13;
            } else {
                long contentLength = responseBody.contentLength();
                this.f1524o = contentLength != -1 ? contentLength - j10 : -1L;
            }
            this.f1523n = true;
            w(bVar);
            try {
                A(j10, bVar);
                return this.f1524o;
            } catch (HttpDataSource.HttpDataSourceException e2) {
                x();
                throw e2;
            }
        } catch (IOException e10) {
            throw HttpDataSource.HttpDataSourceException.createForIOException(e10, bVar, 1);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void close() {
        if (this.f1523n) {
            this.f1523n = false;
            u();
            x();
        }
    }

    @Override // o6.f, com.google.android.exoplayer2.upstream.a
    public Map<String, List<String>> e() {
        Response response = this.f1521l;
        return response == null ? Collections.emptyMap() : response.headers().toMultimap();
    }

    @Override // com.google.android.exoplayer2.upstream.a
    @Nullable
    public Uri i() {
        Response response = this.f1521l;
        if (response == null) {
            return null;
        }
        return Uri.parse(response.request().url().toString());
    }

    @Override // o6.g
    public int read(byte[] bArr, int i10, int i11) throws HttpDataSource.HttpDataSourceException {
        try {
            return z(bArr, i10, i11);
        } catch (IOException e2) {
            throw HttpDataSource.HttpDataSourceException.createForIOException(e2, (com.google.android.exoplayer2.upstream.b) j0.j(this.f1520k), 2);
        }
    }

    public final void x() {
        Response response = this.f1521l;
        if (response != null) {
            ((ResponseBody) com.google.android.exoplayer2.util.a.e(response.body())).close();
            this.f1521l = null;
        }
        this.f1522m = null;
    }

    public final Request y(com.google.android.exoplayer2.upstream.b bVar) throws HttpDataSource.HttpDataSourceException {
        long j10 = bVar.f22773g;
        long j11 = bVar.f22774h;
        HttpUrl parse = HttpUrl.parse(bVar.f22767a.toString());
        if (parse != null) {
            Request.Builder url = new Request.Builder().url(parse);
            CacheControl cacheControl = this.f1517h;
            if (cacheControl != null) {
                url.cacheControl(cacheControl);
            }
            HashMap hashMap = new HashMap();
            HttpDataSource.b bVar2 = this.f1518i;
            if (bVar2 != null) {
                hashMap.putAll(bVar2.b());
            }
            hashMap.putAll(this.f1515f.b());
            hashMap.putAll(bVar.f22771e);
            for (Map.Entry entry : hashMap.entrySet()) {
                url.header((String) entry.getKey(), (String) entry.getValue());
            }
            String a10 = o6.p.a(j10, j11);
            if (a10 != null) {
                url.addHeader("Range", a10);
            }
            String str = this.f1516g;
            if (str != null) {
                url.addHeader("User-Agent", str);
            }
            if (!bVar.d(1)) {
                url.addHeader("Accept-Encoding", "identity");
            }
            byte[] bArr = bVar.f22770d;
            RequestBody requestBody = null;
            if (bArr != null) {
                requestBody = RequestBody.create((MediaType) null, bArr);
            } else if (bVar.f22769c == 2) {
                requestBody = RequestBody.create((MediaType) null, j0.f22995f);
            }
            url.method(bVar.b(), requestBody);
            return url.build();
        }
        throw new HttpDataSource.HttpDataSourceException("Malformed URL", bVar, 1004, 1);
    }

    public final int z(byte[] bArr, int i10, int i11) throws IOException {
        if (i11 == 0) {
            return 0;
        }
        long j10 = this.f1524o;
        if (j10 != -1) {
            long j11 = j10 - this.f1525p;
            if (j11 == 0) {
                return -1;
            }
            i11 = (int) Math.min(i11, j11);
        }
        int read = ((InputStream) j0.j(this.f1522m)).read(bArr, i10, i11);
        if (read == -1) {
            return -1;
        }
        this.f1525p += read;
        t(read);
        return read;
    }

    public a(Call.Factory factory, @Nullable String str, @Nullable CacheControl cacheControl, @Nullable HttpDataSource.b bVar, @Nullable p<String> pVar) {
        super(true);
        this.f1514e = (Call.Factory) com.google.android.exoplayer2.util.a.e(factory);
        this.f1516g = str;
        this.f1517h = cacheControl;
        this.f1518i = bVar;
        this.f1519j = pVar;
        this.f1515f = new HttpDataSource.b();
    }
}
