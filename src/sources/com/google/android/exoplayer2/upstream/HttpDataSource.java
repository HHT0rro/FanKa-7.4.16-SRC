package com.google.android.exoplayer2.upstream;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.a;
import com.google.android.exoplayer2.util.j0;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public interface HttpDataSource extends com.google.android.exoplayer2.upstream.a {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class CleartextNotPermittedException extends HttpDataSourceException {
        public CleartextNotPermittedException(IOException iOException, com.google.android.exoplayer2.upstream.b bVar) {
            super("Cleartext HTTP traffic not permitted. See https://exoplayer.dev/issues/cleartext-not-permitted", iOException, bVar, 2007, 1);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class HttpDataSourceException extends DataSourceException {
        public static final int TYPE_CLOSE = 3;
        public static final int TYPE_OPEN = 1;
        public static final int TYPE_READ = 2;
        public final com.google.android.exoplayer2.upstream.b dataSpec;
        public final int type;

        @Deprecated
        public HttpDataSourceException(com.google.android.exoplayer2.upstream.b bVar, int i10) {
            this(bVar, 2000, i10);
        }

        private static int assignErrorCode(int i10, int i11) {
            if (i10 == 2000 && i11 == 1) {
                return 2001;
            }
            return i10;
        }

        public static HttpDataSourceException createForIOException(IOException iOException, com.google.android.exoplayer2.upstream.b bVar, int i10) {
            int i11;
            String message = iOException.getMessage();
            if (iOException instanceof SocketTimeoutException) {
                i11 = 2002;
            } else if (iOException instanceof InterruptedIOException) {
                i11 = 1004;
            } else {
                i11 = (message == null || !com.google.common.base.a.e(message).matches("cleartext.*not permitted.*")) ? 2001 : 2007;
            }
            if (i11 == 2007) {
                return new CleartextNotPermittedException(iOException, bVar);
            }
            return new HttpDataSourceException(iOException, bVar, i11, i10);
        }

        public HttpDataSourceException(com.google.android.exoplayer2.upstream.b bVar, int i10, int i11) {
            super(assignErrorCode(i10, i11));
            this.dataSpec = bVar;
            this.type = i11;
        }

        @Deprecated
        public HttpDataSourceException(String str, com.google.android.exoplayer2.upstream.b bVar, int i10) {
            this(str, bVar, 2000, i10);
        }

        public HttpDataSourceException(String str, com.google.android.exoplayer2.upstream.b bVar, int i10, int i11) {
            super(str, assignErrorCode(i10, i11));
            this.dataSpec = bVar;
            this.type = i11;
        }

        @Deprecated
        public HttpDataSourceException(IOException iOException, com.google.android.exoplayer2.upstream.b bVar, int i10) {
            this(iOException, bVar, 2000, i10);
        }

        public HttpDataSourceException(IOException iOException, com.google.android.exoplayer2.upstream.b bVar, int i10, int i11) {
            super(iOException, assignErrorCode(i10, i11));
            this.dataSpec = bVar;
            this.type = i11;
        }

        @Deprecated
        public HttpDataSourceException(String str, IOException iOException, com.google.android.exoplayer2.upstream.b bVar, int i10) {
            this(str, iOException, bVar, 2000, i10);
        }

        public HttpDataSourceException(String str, @Nullable IOException iOException, com.google.android.exoplayer2.upstream.b bVar, int i10, int i11) {
            super(str, iOException, assignErrorCode(i10, i11));
            this.dataSpec = bVar;
            this.type = i11;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class InvalidContentTypeException extends HttpDataSourceException {
        public final String contentType;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public InvalidContentTypeException(java.lang.String r4, com.google.android.exoplayer2.upstream.b r5) {
            /*
                r3 = this;
                java.lang.String r0 = java.lang.String.valueOf(r4)
                int r1 = r0.length()
                java.lang.String r2 = "Invalid content type: "
                if (r1 == 0) goto L11
                java.lang.String r0 = r2.concat(r0)
                goto L16
            L11:
                java.lang.String r0 = new java.lang.String
                r0.<init>(r2)
            L16:
                r1 = 2003(0x7d3, float:2.807E-42)
                r2 = 1
                r3.<init>(r0, r5, r1, r2)
                r3.contentType = r4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.upstream.HttpDataSource.InvalidContentTypeException.<init>(java.lang.String, com.google.android.exoplayer2.upstream.b):void");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class InvalidResponseCodeException extends HttpDataSourceException {
        public final Map<String, List<String>> headerFields;
        public final byte[] responseBody;
        public final int responseCode;

        @Nullable
        public final String responseMessage;

        @Deprecated
        public InvalidResponseCodeException(int i10, Map<String, List<String>> map, com.google.android.exoplayer2.upstream.b bVar) {
            this(i10, null, null, map, bVar, j0.f22995f);
        }

        @Deprecated
        public InvalidResponseCodeException(int i10, @Nullable String str, Map<String, List<String>> map, com.google.android.exoplayer2.upstream.b bVar) {
            this(i10, str, null, map, bVar, j0.f22995f);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public InvalidResponseCodeException(int r9, @androidx.annotation.Nullable java.lang.String r10, @androidx.annotation.Nullable java.io.IOException r11, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r12, com.google.android.exoplayer2.upstream.b r13, byte[] r14) {
            /*
                r8 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r1 = 26
                r0.<init>(r1)
                java.lang.String r1 = "Response code: "
                r0.append(r1)
                r0.append(r9)
                java.lang.String r3 = r0.toString()
                r6 = 2004(0x7d4, float:2.808E-42)
                r7 = 1
                r2 = r8
                r4 = r11
                r5 = r13
                r2.<init>(r3, r4, r5, r6, r7)
                r8.responseCode = r9
                r8.responseMessage = r10
                r8.headerFields = r12
                r8.responseBody = r14
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.upstream.HttpDataSource.InvalidResponseCodeException.<init>(int, java.lang.String, java.io.IOException, java.util.Map, com.google.android.exoplayer2.upstream.b, byte[]):void");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface a extends a.InterfaceC0208a {
        @Override // com.google.android.exoplayer2.upstream.a.InterfaceC0208a
        HttpDataSource a();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final Map<String, String> f22728a = new HashMap();

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        public Map<String, String> f22729b;

        public synchronized void a(Map<String, String> map) {
            this.f22729b = null;
            this.f22728a.clear();
            this.f22728a.putAll(map);
        }

        public synchronized Map<String, String> b() {
            if (this.f22729b == null) {
                this.f22729b = Collections.unmodifiableMap(new HashMap(this.f22728a));
            }
            return this.f22729b;
        }
    }
}
