package com.tencent.cloud.huiyansdkface.wehttp2;

import com.android.internal.os.PowerProfile;
import com.huawei.quickcard.base.Attributes;
import com.tencent.cloud.huiyansdkface.okhttp3.Headers;
import com.tencent.cloud.huiyansdkface.okhttp3.HttpUrl;
import com.tencent.cloud.huiyansdkface.okhttp3.Interceptor;
import com.tencent.cloud.huiyansdkface.okhttp3.MediaType;
import com.tencent.cloud.huiyansdkface.okhttp3.MultipartBody;
import com.tencent.cloud.huiyansdkface.okhttp3.RequestBody;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.platform.Platform;
import com.tencent.cloud.huiyansdkface.okio.Buffer;
import java.io.EOFException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class WeLog implements Interceptor {

    /* renamed from: b, reason: collision with root package name */
    public boolean f42385b;

    /* renamed from: c, reason: collision with root package name */
    public InnerLogger f42386c;

    /* renamed from: d, reason: collision with root package name */
    public volatile Level f42387d;

    /* renamed from: f, reason: collision with root package name */
    private boolean f42388f;

    /* renamed from: g, reason: collision with root package name */
    private Logger f42389g;

    /* renamed from: h, reason: collision with root package name */
    private volatile Set<String> f42390h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f42391i;

    /* renamed from: j, reason: collision with root package name */
    private int f42392j;

    /* renamed from: e, reason: collision with root package name */
    private static final Charset f42384e = Charset.forName("UTF-8");

    /* renamed from: a, reason: collision with root package name */
    public static final Logger f42383a = new Logger() { // from class: com.tencent.cloud.huiyansdkface.wehttp2.WeLog.1
        @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeLog.Logger
        public void log(String str) {
            Platform.get().log(4, str, null);
        }
    };

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        public boolean f42394a = false;

        /* renamed from: b, reason: collision with root package name */
        public boolean f42395b = false;

        /* renamed from: c, reason: collision with root package name */
        public boolean f42396c = false;

        /* renamed from: d, reason: collision with root package name */
        public int f42397d = 3072;

        /* renamed from: e, reason: collision with root package name */
        public Level f42398e = Level.NONE;

        /* renamed from: f, reason: collision with root package name */
        public ILogTag f42399f = null;

        /* renamed from: g, reason: collision with root package name */
        public Logger f42400g = null;

        public WeLog build() {
            WeLog weLog = new WeLog();
            weLog.prettyLog(this.f42394a);
            weLog.logTag(this.f42395b);
            weLog.cutLongStr(this.f42396c);
            weLog.longStrLength(this.f42397d);
            weLog.setLevel(this.f42398e);
            weLog.setLogger(this.f42400g);
            return weLog;
        }

        public Builder setCutLongStr(boolean z10) {
            this.f42396c = z10;
            return this;
        }

        public Builder setLevel(Level level) {
            this.f42398e = level;
            return this;
        }

        public Builder setLogTag(ILogTag iLogTag) {
            this.f42399f = iLogTag;
            return this;
        }

        public Builder setLogWithTag(boolean z10) {
            this.f42395b = z10;
            return this;
        }

        public Builder setLogger(Logger logger) {
            this.f42400g = logger;
            return this;
        }

        public Builder setLongStrLength(int i10) {
            this.f42397d = i10;
            return this;
        }

        public Builder setPrettyLog(boolean z10) {
            this.f42394a = z10;
            return this;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface ILogTag {
        String tag(HttpUrl httpUrl, Object obj);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static abstract class InnerLogger {
        public abstract void log(String str);

        public void print(String str) {
            int min;
            int length = str.length();
            int i10 = 0;
            while (i10 < length) {
                int indexOf = str.indexOf(10, i10);
                if (indexOf == -1) {
                    indexOf = length;
                }
                while (true) {
                    min = Math.min(indexOf, i10 + 4000);
                    log(str.substring(i10, min));
                    if (min >= indexOf) {
                        break;
                    } else {
                        i10 = min;
                    }
                }
                i10 = min + 1;
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum Level {
        NONE,
        BASIC,
        HEADERS,
        BODY
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface Logger {
        void log(String str);
    }

    public WeLog() {
        this(f42383a);
    }

    public WeLog(Logger logger) {
        this.f42388f = false;
        this.f42385b = false;
        this.f42386c = new InnerLogger() { // from class: com.tencent.cloud.huiyansdkface.wehttp2.WeLog.2
            @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeLog.InnerLogger
            public void log(String str) {
                if (WeLog.this.f42389g != null) {
                    WeLog.this.f42389g.log(str);
                }
            }
        };
        this.f42390h = Collections.emptySet();
        this.f42387d = Level.NONE;
        this.f42391i = false;
        this.f42392j = 3072;
        setLogger(logger);
    }

    private void a(String str, Headers headers) {
        int size = headers.size();
        for (int i10 = 0; i10 < size; i10++) {
            String name = headers.name(i10);
            if (!"Content-Type".equalsIgnoreCase(name) && !"Content-Length".equalsIgnoreCase(name)) {
                a(str, headers, i10);
            }
        }
    }

    private void a(String str, Headers headers, int i10) {
        String value = this.f42390h.contains(headers.name(i10)) ? "██" : headers.value(i10);
        this.f42386c.print(str + headers.name(i10) + ": " + value);
    }

    private void a(String str, String str2) {
        InnerLogger innerLogger;
        StringBuilder sb2;
        if (!this.f42391i || str2 == null) {
            innerLogger = this.f42386c;
            sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(str2);
        } else {
            innerLogger = this.f42386c;
            sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(WeLogUtils.getShortString(str2, this.f42392j));
        }
        innerLogger.print(sb2.toString());
    }

    private static boolean a(Headers headers) {
        String str = headers.get("Content-Encoding");
        return (str == null || str.equalsIgnoreCase("identity") || str.equalsIgnoreCase("gzip")) ? false : true;
    }

    private boolean a(MediaType mediaType) {
        return mediaType != null && "json".equals(mediaType.subtype());
    }

    private boolean a(RequestBody requestBody) {
        return requestBody instanceof MultipartBody;
    }

    public static boolean a(Buffer buffer) {
        try {
            Buffer buffer2 = new Buffer();
            buffer.copyTo(buffer2, 0L, buffer.size() < 64 ? buffer.size() : 64L);
            for (int i10 = 0; i10 < 16; i10++) {
                if (buffer2.exhausted()) {
                    return true;
                }
                int readUtf8CodePoint = buffer2.readUtf8CodePoint();
                if (Character.isISOControl(readUtf8CodePoint) && !Character.isWhitespace(readUtf8CodePoint)) {
                    return false;
                }
            }
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    private boolean b(MediaType mediaType) {
        return mediaType != null && ("video".equals(mediaType.type()) || Attributes.Component.IMAGE.equals(mediaType.type()) || PowerProfile.POWER_AUDIO.equals(mediaType.type()) || MediaType.f41439j.equals(mediaType));
    }

    public void cutLongStr(boolean z10) {
        this.f42391i = z10;
    }

    public Level getLevel() {
        return this.f42387d;
    }

    /* JADX WARN: Removed duplicated region for block: B:121:0x04c3  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0475  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x044c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x043a  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0470  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x04ac  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x04d6  */
    @Override // com.tencent.cloud.huiyansdkface.okhttp3.Interceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.tencent.cloud.huiyansdkface.okhttp3.Response intercept(com.tencent.cloud.huiyansdkface.okhttp3.Interceptor.Chain r25) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 1766
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.cloud.huiyansdkface.wehttp2.WeLog.intercept(com.tencent.cloud.huiyansdkface.okhttp3.Interceptor$Chain):com.tencent.cloud.huiyansdkface.okhttp3.Response");
    }

    public WeLog logTag(boolean z10) {
        this.f42385b = z10;
        return this;
    }

    public void longStrLength(int i10) {
        this.f42392j = i10;
    }

    public WeLog prettyLog(boolean z10) {
        this.f42388f = z10;
        return this;
    }

    public void redactHeader(String str) {
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        treeSet.addAll(this.f42390h);
        treeSet.add(str);
        this.f42390h = treeSet;
    }

    public WeLog setLevel(Level level) {
        Objects.requireNonNull(level, "level == null. Use Level.NONE instead.");
        this.f42387d = level;
        return this;
    }

    public void setLogger(Logger logger) {
        if (logger != null) {
            this.f42389g = logger;
        }
    }
}
