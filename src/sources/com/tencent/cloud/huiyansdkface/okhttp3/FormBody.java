package com.tencent.cloud.huiyansdkface.okhttp3;

import com.tencent.cloud.huiyansdkface.okhttp3.internal.Util;
import com.tencent.cloud.huiyansdkface.okio.Buffer;
import com.tencent.cloud.huiyansdkface.okio.BufferedSink;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class FormBody extends RequestBody {

    /* renamed from: a, reason: collision with root package name */
    private static final MediaType f41400a = MediaType.get("application/x-www-form-urlencoded");

    /* renamed from: b, reason: collision with root package name */
    private final List<String> f41401b;

    /* renamed from: c, reason: collision with root package name */
    private final List<String> f41402c;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        private final List<String> f41403a;

        /* renamed from: b, reason: collision with root package name */
        private final List<String> f41404b;

        /* renamed from: c, reason: collision with root package name */
        private final Charset f41405c;

        public Builder() {
            this(null);
        }

        public Builder(Charset charset) {
            this.f41403a = new ArrayList();
            this.f41404b = new ArrayList();
            this.f41405c = charset;
        }

        public Builder add(String str, String str2) {
            Objects.requireNonNull(str, "name == null");
            Objects.requireNonNull(str2, "value == null");
            this.f41403a.add(HttpUrl.a(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.f41405c));
            this.f41404b.add(HttpUrl.a(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true, this.f41405c));
            return this;
        }

        public Builder addEncoded(String str, String str2) {
            Objects.requireNonNull(str, "name == null");
            Objects.requireNonNull(str2, "value == null");
            this.f41403a.add(HttpUrl.a(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true, this.f41405c));
            this.f41404b.add(HttpUrl.a(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true, this.f41405c));
            return this;
        }

        public FormBody build() {
            return new FormBody(this.f41403a, this.f41404b);
        }
    }

    public FormBody(List<String> list, List<String> list2) {
        this.f41401b = Util.immutableList(list);
        this.f41402c = Util.immutableList(list2);
    }

    private long a(BufferedSink bufferedSink, boolean z10) {
        Buffer buffer = z10 ? new Buffer() : bufferedSink.buffer();
        int size = this.f41401b.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (i10 > 0) {
                buffer.writeByte(38);
            }
            buffer.writeUtf8(this.f41401b.get(i10));
            buffer.writeByte(61);
            buffer.writeUtf8(this.f41402c.get(i10));
        }
        if (!z10) {
            return 0L;
        }
        long size2 = buffer.size();
        buffer.clear();
        return size2;
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.RequestBody
    public long contentLength() {
        return a(null, true);
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.RequestBody
    public MediaType contentType() {
        return f41400a;
    }

    public String encodedName(int i10) {
        return this.f41401b.get(i10);
    }

    public String encodedValue(int i10) {
        return this.f41402c.get(i10);
    }

    public String name(int i10) {
        return HttpUrl.a(encodedName(i10), true);
    }

    public int size() {
        return this.f41401b.size();
    }

    public String value(int i10) {
        return HttpUrl.a(encodedValue(i10), true);
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.RequestBody
    public void writeTo(BufferedSink bufferedSink) throws IOException {
        a(bufferedSink, false);
    }
}
