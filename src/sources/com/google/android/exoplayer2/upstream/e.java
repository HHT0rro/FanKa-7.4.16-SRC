package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.util.j0;
import com.google.android.exoplayer2.util.m;
import com.google.common.base.p;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import o6.v;

/* compiled from: DefaultHttpDataSource.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class e extends o6.f implements HttpDataSource {

    /* renamed from: e, reason: collision with root package name */
    public final boolean f22860e;

    /* renamed from: f, reason: collision with root package name */
    public final int f22861f;

    /* renamed from: g, reason: collision with root package name */
    public final int f22862g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    public final String f22863h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public final HttpDataSource.b f22864i;

    /* renamed from: j, reason: collision with root package name */
    public final HttpDataSource.b f22865j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f22866k;

    /* renamed from: l, reason: collision with root package name */
    @Nullable
    public p<String> f22867l;

    /* renamed from: m, reason: collision with root package name */
    @Nullable
    public com.google.android.exoplayer2.upstream.b f22868m;

    /* renamed from: n, reason: collision with root package name */
    @Nullable
    public HttpURLConnection f22869n;

    /* renamed from: o, reason: collision with root package name */
    @Nullable
    public InputStream f22870o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f22871p;

    /* renamed from: q, reason: collision with root package name */
    public int f22872q;

    /* renamed from: r, reason: collision with root package name */
    public long f22873r;

    /* renamed from: s, reason: collision with root package name */
    public long f22874s;

    /* compiled from: DefaultHttpDataSource.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b implements HttpDataSource.a {

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        public v f22876b;

        /* renamed from: c, reason: collision with root package name */
        @Nullable
        public p<String> f22877c;

        /* renamed from: d, reason: collision with root package name */
        @Nullable
        public String f22878d;

        /* renamed from: g, reason: collision with root package name */
        public boolean f22881g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f22882h;

        /* renamed from: a, reason: collision with root package name */
        public final HttpDataSource.b f22875a = new HttpDataSource.b();

        /* renamed from: e, reason: collision with root package name */
        public int f22879e = 8000;

        /* renamed from: f, reason: collision with root package name */
        public int f22880f = 8000;

        @Override // com.google.android.exoplayer2.upstream.a.InterfaceC0208a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public e a() {
            e eVar = new e(this.f22878d, this.f22879e, this.f22880f, this.f22881g, this.f22875a, this.f22877c, this.f22882h);
            v vVar = this.f22876b;
            if (vVar != null) {
                eVar.d(vVar);
            }
            return eVar;
        }

        public b c(boolean z10) {
            this.f22881g = z10;
            return this;
        }

        public final b d(Map<String, String> map) {
            this.f22875a.a(map);
            return this;
        }

        public b e(@Nullable String str) {
            this.f22878d = str;
            return this;
        }
    }

    public static void C(@Nullable HttpURLConnection httpURLConnection, long j10) {
        int i10;
        if (httpURLConnection != null && (i10 = j0.f22990a) >= 19 && i10 <= 20) {
            try {
                InputStream inputStream = httpURLConnection.getInputStream();
                if (j10 == -1) {
                    if (inputStream.read() == -1) {
                        return;
                    }
                } else if (j10 <= 2048) {
                    return;
                }
                String name = inputStream.getClass().getName();
                if (!"com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream".equals(name) && !"com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream".equals(name)) {
                    return;
                }
                Method declaredMethod = ((Class) com.google.android.exoplayer2.util.a.e(inputStream.getClass().getSuperclass())).getDeclaredMethod("unexpectedEndOfInput", new Class[0]);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(inputStream, new Object[0]);
            } catch (Exception unused) {
            }
        }
    }

    public static boolean z(HttpURLConnection httpURLConnection) {
        return "gzip".equalsIgnoreCase(httpURLConnection.getHeaderField("Content-Encoding"));
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x00b1, code lost:
    
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.net.HttpURLConnection A(com.google.android.exoplayer2.upstream.b r27) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 229
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.upstream.e.A(com.google.android.exoplayer2.upstream.b):java.net.HttpURLConnection");
    }

    public final HttpURLConnection B(URL url, int i10, @Nullable byte[] bArr, long j10, long j11, boolean z10, boolean z11, Map<String, String> map) throws IOException {
        HttpURLConnection D = D(url);
        D.setConnectTimeout(this.f22861f);
        D.setReadTimeout(this.f22862g);
        HashMap hashMap = new HashMap();
        HttpDataSource.b bVar = this.f22864i;
        if (bVar != null) {
            hashMap.putAll(bVar.b());
        }
        hashMap.putAll(this.f22865j.b());
        hashMap.putAll(map);
        for (Map.Entry entry : hashMap.entrySet()) {
            D.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
        }
        String a10 = o6.p.a(j10, j11);
        if (a10 != null) {
            D.setRequestProperty("Range", a10);
        }
        String str = this.f22863h;
        if (str != null) {
            D.setRequestProperty("User-Agent", str);
        }
        D.setRequestProperty("Accept-Encoding", z10 ? "gzip" : "identity");
        D.setInstanceFollowRedirects(z11);
        D.setDoOutput(bArr != null);
        D.setRequestMethod(com.google.android.exoplayer2.upstream.b.c(i10));
        if (bArr != null) {
            D.setFixedLengthStreamingMode(bArr.length);
            D.connect();
            OutputStream outputStream = D.getOutputStream();
            outputStream.write(bArr);
            outputStream.close();
        } else {
            D.connect();
        }
        return D;
    }

    @VisibleForTesting
    public HttpURLConnection D(URL url) throws IOException {
        return (HttpURLConnection) url.openConnection();
    }

    public final int E(byte[] bArr, int i10, int i11) throws IOException {
        if (i11 == 0) {
            return 0;
        }
        long j10 = this.f22873r;
        if (j10 != -1) {
            long j11 = j10 - this.f22874s;
            if (j11 == 0) {
                return -1;
            }
            i11 = (int) Math.min(i11, j11);
        }
        int read = ((InputStream) j0.j(this.f22870o)).read(bArr, i10, i11);
        if (read == -1) {
            return -1;
        }
        this.f22874s += read;
        t(read);
        return read;
    }

    public final void F(long j10, com.google.android.exoplayer2.upstream.b bVar) throws IOException {
        if (j10 == 0) {
            return;
        }
        byte[] bArr = new byte[4096];
        while (j10 > 0) {
            int read = ((InputStream) j0.j(this.f22870o)).read(bArr, 0, (int) Math.min(j10, 4096));
            if (Thread.currentThread().isInterrupted()) {
                throw new HttpDataSource.HttpDataSourceException(new InterruptedIOException(), bVar, 2000, 1);
            }
            if (read != -1) {
                j10 -= read;
                t(read);
            } else {
                throw new HttpDataSource.HttpDataSourceException(bVar, 2008, 1);
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public long a(com.google.android.exoplayer2.upstream.b bVar) throws HttpDataSource.HttpDataSourceException {
        byte[] bArr;
        this.f22868m = bVar;
        long j10 = 0;
        this.f22874s = 0L;
        this.f22873r = 0L;
        v(bVar);
        try {
            HttpURLConnection A = A(bVar);
            this.f22869n = A;
            this.f22872q = A.getResponseCode();
            String responseMessage = A.getResponseMessage();
            int i10 = this.f22872q;
            if (i10 >= 200 && i10 <= 299) {
                String contentType = A.getContentType();
                p<String> pVar = this.f22867l;
                if (pVar != null && !pVar.apply(contentType)) {
                    x();
                    throw new HttpDataSource.InvalidContentTypeException(contentType, bVar);
                }
                if (this.f22872q == 200) {
                    long j11 = bVar.f22773g;
                    if (j11 != 0) {
                        j10 = j11;
                    }
                }
                boolean z10 = z(A);
                if (!z10) {
                    long j12 = bVar.f22774h;
                    if (j12 != -1) {
                        this.f22873r = j12;
                    } else {
                        long b4 = o6.p.b(A.getHeaderField("Content-Length"), A.getHeaderField("Content-Range"));
                        this.f22873r = b4 != -1 ? b4 - j10 : -1L;
                    }
                } else {
                    this.f22873r = bVar.f22774h;
                }
                try {
                    this.f22870o = A.getInputStream();
                    if (z10) {
                        this.f22870o = new GZIPInputStream(this.f22870o);
                    }
                    this.f22871p = true;
                    w(bVar);
                    try {
                        F(j10, bVar);
                        return this.f22873r;
                    } catch (IOException e2) {
                        x();
                        if (e2 instanceof HttpDataSource.HttpDataSourceException) {
                            throw ((HttpDataSource.HttpDataSourceException) e2);
                        }
                        throw new HttpDataSource.HttpDataSourceException(e2, bVar, 2000, 1);
                    }
                } catch (IOException e10) {
                    x();
                    throw new HttpDataSource.HttpDataSourceException(e10, bVar, 2000, 1);
                }
            }
            Map<String, List<String>> headerFields = A.getHeaderFields();
            if (this.f22872q == 416) {
                if (bVar.f22773g == o6.p.c(A.getHeaderField("Content-Range"))) {
                    this.f22871p = true;
                    w(bVar);
                    long j13 = bVar.f22774h;
                    if (j13 != -1) {
                        return j13;
                    }
                    return 0L;
                }
            }
            InputStream errorStream = A.getErrorStream();
            try {
                bArr = errorStream != null ? j0.S0(errorStream) : j0.f22995f;
            } catch (IOException unused) {
                bArr = j0.f22995f;
            }
            byte[] bArr2 = bArr;
            x();
            throw new HttpDataSource.InvalidResponseCodeException(this.f22872q, responseMessage, this.f22872q == 416 ? new DataSourceException(2008) : null, headerFields, bVar, bArr2);
        } catch (IOException e11) {
            x();
            throw HttpDataSource.HttpDataSourceException.createForIOException(e11, bVar, 1);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void close() throws HttpDataSource.HttpDataSourceException {
        try {
            InputStream inputStream = this.f22870o;
            if (inputStream != null) {
                long j10 = this.f22873r;
                long j11 = -1;
                if (j10 != -1) {
                    j11 = j10 - this.f22874s;
                }
                C(this.f22869n, j11);
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    throw new HttpDataSource.HttpDataSourceException(e2, (com.google.android.exoplayer2.upstream.b) j0.j(this.f22868m), 2000, 3);
                }
            }
        } finally {
            this.f22870o = null;
            x();
            if (this.f22871p) {
                this.f22871p = false;
                u();
            }
        }
    }

    @Override // o6.f, com.google.android.exoplayer2.upstream.a
    public Map<String, List<String>> e() {
        HttpURLConnection httpURLConnection = this.f22869n;
        return httpURLConnection == null ? Collections.emptyMap() : httpURLConnection.getHeaderFields();
    }

    @Override // com.google.android.exoplayer2.upstream.a
    @Nullable
    public Uri i() {
        HttpURLConnection httpURLConnection = this.f22869n;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    @Override // o6.g
    public int read(byte[] bArr, int i10, int i11) throws HttpDataSource.HttpDataSourceException {
        try {
            return E(bArr, i10, i11);
        } catch (IOException e2) {
            throw HttpDataSource.HttpDataSourceException.createForIOException(e2, (com.google.android.exoplayer2.upstream.b) j0.j(this.f22868m), 2);
        }
    }

    public final void x() {
        HttpURLConnection httpURLConnection = this.f22869n;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e2) {
                m.d("DefaultHttpDataSource", "Unexpected error while disconnecting", e2);
            }
            this.f22869n = null;
        }
    }

    public final URL y(URL url, @Nullable String str, com.google.android.exoplayer2.upstream.b bVar) throws HttpDataSource.HttpDataSourceException {
        if (str != null) {
            try {
                URL url2 = new URL(url, str);
                String protocol = url2.getProtocol();
                if (!"https".equals(protocol) && !"http".equals(protocol)) {
                    String valueOf = String.valueOf(protocol);
                    throw new HttpDataSource.HttpDataSourceException(valueOf.length() != 0 ? "Unsupported protocol redirect: ".concat(valueOf) : new String("Unsupported protocol redirect: "), bVar, 2001, 1);
                }
                if (this.f22860e || protocol.equals(url.getProtocol())) {
                    return url2;
                }
                String protocol2 = url.getProtocol();
                StringBuilder sb2 = new StringBuilder(String.valueOf(protocol2).length() + 41 + protocol.length());
                sb2.append("Disallowed cross-protocol redirect (");
                sb2.append(protocol2);
                sb2.append(" to ");
                sb2.append(protocol);
                sb2.append(")");
                throw new HttpDataSource.HttpDataSourceException(sb2.toString(), bVar, 2001, 1);
            } catch (MalformedURLException e2) {
                throw new HttpDataSource.HttpDataSourceException(e2, bVar, 2001, 1);
            }
        }
        throw new HttpDataSource.HttpDataSourceException("Null location redirect", bVar, 2001, 1);
    }

    public e(@Nullable String str, int i10, int i11, boolean z10, @Nullable HttpDataSource.b bVar, @Nullable p<String> pVar, boolean z11) {
        super(true);
        this.f22863h = str;
        this.f22861f = i10;
        this.f22862g = i11;
        this.f22860e = z10;
        this.f22864i = bVar;
        this.f22867l = pVar;
        this.f22865j = new HttpDataSource.b();
        this.f22866k = z11;
    }
}
