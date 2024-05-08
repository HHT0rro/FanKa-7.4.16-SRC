package com.tencent.cloud.huiyansdkface.okhttp3.internal.http2;

import com.alibaba.security.realidentity.build.cg;
import com.alipay.sdk.packet.e;
import com.baidu.mobads.sdk.internal.cj;
import com.huawei.flexiblelayout.parser.cardmanager.d;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.quickcard.base.Attributes;
import com.ss.android.socialbase.downloader.constants.SpJsonConstants;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.Util;
import com.tencent.cloud.huiyansdkface.okio.Buffer;
import com.tencent.cloud.huiyansdkface.okio.BufferedSource;
import com.tencent.cloud.huiyansdkface.okio.ByteString;
import com.tencent.cloud.huiyansdkface.okio.Okio;
import com.tencent.cloud.huiyansdkface.okio.Source;
import com.wangmai.okhttp.model.HttpHeaders;
import io.grpc.internal.GrpcUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import sun.security.util.SecurityConstants;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class Hpack {

    /* renamed from: a, reason: collision with root package name */
    public static final Header[] f41834a;

    /* renamed from: b, reason: collision with root package name */
    public static final Map<ByteString, Integer> f41835b;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class Reader {

        /* renamed from: a, reason: collision with root package name */
        public Header[] f41836a;

        /* renamed from: b, reason: collision with root package name */
        public int f41837b;

        /* renamed from: c, reason: collision with root package name */
        public int f41838c;

        /* renamed from: d, reason: collision with root package name */
        public int f41839d;

        /* renamed from: e, reason: collision with root package name */
        private final List<Header> f41840e;

        /* renamed from: f, reason: collision with root package name */
        private final BufferedSource f41841f;

        /* renamed from: g, reason: collision with root package name */
        private final int f41842g;

        /* renamed from: h, reason: collision with root package name */
        private int f41843h;

        public Reader(int i10, int i11, Source source) {
            this.f41840e = new ArrayList();
            this.f41836a = new Header[8];
            this.f41837b = r0.length - 1;
            this.f41838c = 0;
            this.f41839d = 0;
            this.f41842g = i10;
            this.f41843h = i11;
            this.f41841f = Okio.buffer(source);
        }

        public Reader(int i10, Source source) {
            this(i10, i10, source);
        }

        private int a(int i10) {
            int i11;
            int i12 = 0;
            if (i10 > 0) {
                int length = this.f41836a.length;
                while (true) {
                    length--;
                    i11 = this.f41837b;
                    if (length < i11 || i10 <= 0) {
                        break;
                    }
                    Header[] headerArr = this.f41836a;
                    i10 -= headerArr[length].f41833i;
                    this.f41839d -= headerArr[length].f41833i;
                    this.f41838c--;
                    i12++;
                }
                Header[] headerArr2 = this.f41836a;
                System.arraycopy(headerArr2, i11 + 1, headerArr2, i11 + 1 + i12, this.f41838c);
                this.f41837b += i12;
            }
            return i12;
        }

        private void a(int i10, Header header) {
            this.f41840e.add(header);
            int i11 = header.f41833i;
            if (i10 != -1) {
                i11 -= this.f41836a[c(i10)].f41833i;
            }
            int i12 = this.f41843h;
            if (i11 > i12) {
                d();
                return;
            }
            int a10 = a((this.f41839d + i11) - i12);
            if (i10 == -1) {
                int i13 = this.f41838c + 1;
                Header[] headerArr = this.f41836a;
                if (i13 > headerArr.length) {
                    Header[] headerArr2 = new Header[headerArr.length * 2];
                    System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                    this.f41837b = this.f41836a.length - 1;
                    this.f41836a = headerArr2;
                }
                int i14 = this.f41837b;
                this.f41837b = i14 - 1;
                this.f41836a[i14] = header;
                this.f41838c++;
            } else {
                this.f41836a[i10 + c(i10) + a10] = header;
            }
            this.f41839d += i11;
        }

        private void b(int i10) throws IOException {
            if (g(i10)) {
                this.f41840e.add(Hpack.f41834a[i10]);
                return;
            }
            int c4 = c(i10 - Hpack.f41834a.length);
            if (c4 >= 0) {
                Header[] headerArr = this.f41836a;
                if (c4 < headerArr.length) {
                    this.f41840e.add(headerArr[c4]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i10 + 1));
        }

        private int c(int i10) {
            return this.f41837b + 1 + i10;
        }

        private void c() {
            int i10 = this.f41843h;
            int i11 = this.f41839d;
            if (i10 < i11) {
                if (i10 == 0) {
                    d();
                } else {
                    a(i11 - i10);
                }
            }
        }

        private void d() {
            Arrays.fill(this.f41836a, (Object) null);
            this.f41837b = this.f41836a.length - 1;
            this.f41838c = 0;
            this.f41839d = 0;
        }

        private void d(int i10) throws IOException {
            this.f41840e.add(new Header(f(i10), b()));
        }

        private void e() throws IOException {
            this.f41840e.add(new Header(Hpack.a(b()), b()));
        }

        private void e(int i10) throws IOException {
            a(-1, new Header(f(i10), b()));
        }

        private ByteString f(int i10) throws IOException {
            Header header;
            if (!g(i10)) {
                int c4 = c(i10 - Hpack.f41834a.length);
                if (c4 >= 0) {
                    Header[] headerArr = this.f41836a;
                    if (c4 < headerArr.length) {
                        header = headerArr[c4];
                    }
                }
                throw new IOException("Header index too large " + (i10 + 1));
            }
            header = Hpack.f41834a[i10];
            return header.f41831g;
        }

        private void f() throws IOException {
            a(-1, new Header(Hpack.a(b()), b()));
        }

        private int g() throws IOException {
            return this.f41841f.readByte() & 255;
        }

        private boolean g(int i10) {
            return i10 >= 0 && i10 <= Hpack.f41834a.length - 1;
        }

        public int a(int i10, int i11) throws IOException {
            int i12 = i10 & i11;
            if (i12 < i11) {
                return i12;
            }
            int i13 = 0;
            while (true) {
                int g3 = g();
                if ((g3 & 128) == 0) {
                    return i11 + (g3 << i13);
                }
                i11 += (g3 & 127) << i13;
                i13 += 7;
            }
        }

        public void a() throws IOException {
            while (!this.f41841f.exhausted()) {
                int readByte = this.f41841f.readByte() & 255;
                if (readByte == 128) {
                    throw new IOException("index == 0");
                }
                if ((readByte & 128) == 128) {
                    b(a(readByte, 127) - 1);
                } else if (readByte == 64) {
                    f();
                } else if ((readByte & 64) == 64) {
                    e(a(readByte, 63) - 1);
                } else if ((readByte & 32) == 32) {
                    int a10 = a(readByte, 31);
                    this.f41843h = a10;
                    if (a10 < 0 || a10 > this.f41842g) {
                        throw new IOException("Invalid dynamic table size update " + this.f41843h);
                    }
                    c();
                } else if (readByte == 16 || readByte == 0) {
                    e();
                } else {
                    d(a(readByte, 15) - 1);
                }
            }
        }

        public ByteString b() throws IOException {
            int g3 = g();
            boolean z10 = (g3 & 128) == 128;
            int a10 = a(g3, 127);
            return z10 ? ByteString.of(Huffman.get().a(this.f41841f.readByteArray(a10))) : this.f41841f.readByteString(a10);
        }

        public List<Header> getAndResetHeaderList() {
            ArrayList arrayList = new ArrayList(this.f41840e);
            this.f41840e.clear();
            return arrayList;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class Writer {

        /* renamed from: a, reason: collision with root package name */
        public int f41844a;

        /* renamed from: b, reason: collision with root package name */
        public int f41845b;

        /* renamed from: c, reason: collision with root package name */
        public Header[] f41846c;

        /* renamed from: d, reason: collision with root package name */
        public int f41847d;

        /* renamed from: e, reason: collision with root package name */
        public int f41848e;

        /* renamed from: f, reason: collision with root package name */
        public int f41849f;

        /* renamed from: g, reason: collision with root package name */
        private final Buffer f41850g;

        /* renamed from: h, reason: collision with root package name */
        private final boolean f41851h;

        /* renamed from: i, reason: collision with root package name */
        private int f41852i;

        /* renamed from: j, reason: collision with root package name */
        private boolean f41853j;

        public Writer(int i10, boolean z10, Buffer buffer) {
            this.f41852i = Integer.MAX_VALUE;
            this.f41846c = new Header[8];
            this.f41847d = r0.length - 1;
            this.f41848e = 0;
            this.f41849f = 0;
            this.f41844a = i10;
            this.f41845b = i10;
            this.f41851h = z10;
            this.f41850g = buffer;
        }

        public Writer(Buffer buffer) {
            this(4096, true, buffer);
        }

        private void a() {
            Arrays.fill(this.f41846c, (Object) null);
            this.f41847d = this.f41846c.length - 1;
            this.f41848e = 0;
            this.f41849f = 0;
        }

        private void a(Header header) {
            int i10 = header.f41833i;
            int i11 = this.f41845b;
            if (i10 > i11) {
                a();
                return;
            }
            b((this.f41849f + i10) - i11);
            int i12 = this.f41848e + 1;
            Header[] headerArr = this.f41846c;
            if (i12 > headerArr.length) {
                Header[] headerArr2 = new Header[headerArr.length * 2];
                System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                this.f41847d = this.f41846c.length - 1;
                this.f41846c = headerArr2;
            }
            int i13 = this.f41847d;
            this.f41847d = i13 - 1;
            this.f41846c[i13] = header;
            this.f41848e++;
            this.f41849f += i10;
        }

        private int b(int i10) {
            int i11;
            int i12 = 0;
            if (i10 > 0) {
                int length = this.f41846c.length;
                while (true) {
                    length--;
                    i11 = this.f41847d;
                    if (length < i11 || i10 <= 0) {
                        break;
                    }
                    Header[] headerArr = this.f41846c;
                    i10 -= headerArr[length].f41833i;
                    this.f41849f -= headerArr[length].f41833i;
                    this.f41848e--;
                    i12++;
                }
                Header[] headerArr2 = this.f41846c;
                System.arraycopy(headerArr2, i11 + 1, headerArr2, i11 + 1 + i12, this.f41848e);
                Header[] headerArr3 = this.f41846c;
                int i13 = this.f41847d;
                Arrays.fill(headerArr3, i13 + 1, i13 + 1 + i12, (Object) null);
                this.f41847d += i12;
            }
            return i12;
        }

        private void b() {
            int i10 = this.f41845b;
            int i11 = this.f41849f;
            if (i10 < i11) {
                if (i10 == 0) {
                    a();
                } else {
                    b(i11 - i10);
                }
            }
        }

        public void a(int i10) {
            this.f41844a = i10;
            int min = Math.min(i10, 16384);
            int i11 = this.f41845b;
            if (i11 == min) {
                return;
            }
            if (min < i11) {
                this.f41852i = Math.min(this.f41852i, min);
            }
            this.f41853j = true;
            this.f41845b = min;
            b();
        }

        public void a(int i10, int i11, int i12) {
            int i13;
            Buffer buffer;
            if (i10 < i11) {
                buffer = this.f41850g;
                i13 = i10 | i12;
            } else {
                this.f41850g.writeByte(i12 | i11);
                i13 = i10 - i11;
                while (i13 >= 128) {
                    this.f41850g.writeByte(128 | (i13 & 127));
                    i13 >>>= 7;
                }
                buffer = this.f41850g;
            }
            buffer.writeByte(i13);
        }

        public void a(ByteString byteString) throws IOException {
            int size;
            int i10;
            if (!this.f41851h || Huffman.get().a(byteString) >= byteString.size()) {
                size = byteString.size();
                i10 = 0;
            } else {
                Buffer buffer = new Buffer();
                Huffman.get().a(byteString, buffer);
                byteString = buffer.readByteString();
                size = byteString.size();
                i10 = 128;
            }
            a(size, 127, i10);
            this.f41850g.write(byteString);
        }

        public void a(List<Header> list) throws IOException {
            int i10;
            int i11;
            if (this.f41853j) {
                int i12 = this.f41852i;
                if (i12 < this.f41845b) {
                    a(i12, 31, 32);
                }
                this.f41853j = false;
                this.f41852i = Integer.MAX_VALUE;
                a(this.f41845b, 31, 32);
            }
            int size = list.size();
            for (int i13 = 0; i13 < size; i13++) {
                Header header = list.get(i13);
                ByteString asciiLowercase = header.f41831g.toAsciiLowercase();
                ByteString byteString = header.f41832h;
                Integer num = Hpack.f41835b.get(asciiLowercase);
                if (num != null) {
                    i10 = num.intValue() + 1;
                    if (i10 > 1 && i10 < 8) {
                        Header[] headerArr = Hpack.f41834a;
                        if (Util.equal(headerArr[i10 - 1].f41832h, byteString)) {
                            i11 = i10;
                        } else if (Util.equal(headerArr[i10].f41832h, byteString)) {
                            i11 = i10;
                            i10++;
                        }
                    }
                    i11 = i10;
                    i10 = -1;
                } else {
                    i10 = -1;
                    i11 = -1;
                }
                if (i10 == -1) {
                    int i14 = this.f41847d + 1;
                    int length = this.f41846c.length;
                    while (true) {
                        if (i14 >= length) {
                            break;
                        }
                        if (Util.equal(this.f41846c[i14].f41831g, asciiLowercase)) {
                            if (Util.equal(this.f41846c[i14].f41832h, byteString)) {
                                i10 = Hpack.f41834a.length + (i14 - this.f41847d);
                                break;
                            } else if (i11 == -1) {
                                i11 = (i14 - this.f41847d) + Hpack.f41834a.length;
                            }
                        }
                        i14++;
                    }
                }
                if (i10 != -1) {
                    a(i10, 127, 128);
                } else {
                    if (i11 == -1) {
                        this.f41850g.writeByte(64);
                        a(asciiLowercase);
                    } else if (!asciiLowercase.startsWith(Header.f41825a) || Header.f41830f.equals(asciiLowercase)) {
                        a(i11, 63, 64);
                    } else {
                        a(i11, 15, 0);
                        a(byteString);
                    }
                    a(byteString);
                    a(header);
                }
            }
        }
    }

    static {
        ByteString byteString = Header.f41827c;
        ByteString byteString2 = Header.f41828d;
        ByteString byteString3 = Header.f41829e;
        ByteString byteString4 = Header.f41826b;
        f41834a = new Header[]{new Header(Header.f41830f, ""), new Header(byteString, "GET"), new Header(byteString, "POST"), new Header(byteString2, "/"), new Header(byteString2, "/index.html"), new Header(byteString3, "http"), new Header(byteString3, "https"), new Header(byteString4, "200"), new Header(byteString4, "204"), new Header(byteString4, "206"), new Header(byteString4, "304"), new Header(byteString4, "400"), new Header(byteString4, cj.f10033b), new Header(byteString4, "500"), new Header("accept-charset", ""), new Header(GrpcUtil.CONTENT_ACCEPT_ENCODING, HttpHeaders.HEAD_VALUE_ACCEPT_ENCODING), new Header("accept-language", ""), new Header("accept-ranges", ""), new Header(SecurityConstants.SOCKET_ACCEPT_ACTION, ""), new Header("access-control-allow-origin", ""), new Header("age", ""), new Header("allow", ""), new Header("authorization", ""), new Header(SpJsonConstants.CACHE_CONTROL, ""), new Header("content-disposition", ""), new Header(GrpcUtil.CONTENT_ENCODING, ""), new Header("content-language", ""), new Header("content-length", ""), new Header("content-location", ""), new Header("content-range", ""), new Header(e.f4632d, ""), new Header("cookie", ""), new Header("date", ""), new Header("etag", ""), new Header("expect", ""), new Header("expires", ""), new Header(RemoteMessageConst.FROM, ""), new Header("host", ""), new Header("if-match", ""), new Header(DownloadUtils.IF_MODIFIED_SINCE, ""), new Header("if-none-match", ""), new Header("if-range", ""), new Header("if-unmodified-since", ""), new Header("last-modified", ""), new Header(d.f28337g, ""), new Header("location", ""), new Header("max-forwards", ""), new Header("proxy-authenticate", ""), new Header("proxy-authorization", ""), new Header(Attributes.Style.RANGE, ""), new Header(cg.f3313c, ""), new Header("refresh", ""), new Header("retry-after", ""), new Header("server", ""), new Header("set-cookie", ""), new Header("strict-transport-security", ""), new Header("transfer-encoding", ""), new Header("user-agent", ""), new Header("vary", ""), new Header("via", ""), new Header("www-authenticate", "")};
        f41835b = a();
    }

    private Hpack() {
    }

    public static ByteString a(ByteString byteString) throws IOException {
        int size = byteString.size();
        for (int i10 = 0; i10 < size; i10++) {
            byte b4 = byteString.getByte(i10);
            if (b4 >= 65 && b4 <= 90) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + byteString.utf8());
            }
        }
        return byteString;
    }

    private static Map<ByteString, Integer> a() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(f41834a.length);
        int i10 = 0;
        while (true) {
            Header[] headerArr = f41834a;
            if (i10 >= headerArr.length) {
                return Collections.unmodifiableMap(linkedHashMap);
            }
            if (!linkedHashMap.containsKey(headerArr[i10].f41831g)) {
                linkedHashMap.put(headerArr[i10].f41831g, Integer.valueOf(i10));
            }
            i10++;
        }
    }
}
