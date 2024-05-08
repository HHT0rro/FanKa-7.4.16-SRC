package com.irisdt.util;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.okhttp.OkHttpChannelBuilder;
import io.grpc.okhttp.internal.CipherSuite;
import io.grpc.okhttp.internal.ConnectionSpec;
import io.grpc.okhttp.internal.TlsVersion;
import io.grpc.stub.AbstractStub;
import io.grpc.stub.MetadataUtils;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public final class Utils {
    private static Handler mainHandler = new Handler(Looper.getMainLooper());

    public static Metadata addHeader(ConcurrentHashMap<String, String> concurrentHashMap, Metadata metadata, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return metadata;
        }
        if (str2 == null) {
            str2 = "";
        }
        boolean containsKey = concurrentHashMap.containsKey(str);
        if (containsKey && concurrentHashMap.get(str).equals(str2)) {
            return metadata;
        }
        concurrentHashMap.put(str, str2);
        if (containsKey) {
            metadata = new Metadata();
            for (Map.Entry<String, String> entry : concurrentHashMap.entrySet()) {
                String value = entry.getValue();
                if (!TextUtils.isEmpty(value)) {
                    metadata.put(getCustomHeaderKey(entry.getKey()), value);
                }
            }
        } else if (str2.length() > 0) {
            metadata.put(getCustomHeaderKey(str), str2);
        }
        return metadata;
    }

    public static <T extends AbstractStub<T>> T attachHeaders(T t2, Metadata metadata) {
        return (metadata == null || metadata.keys().size() <= 0) ? t2 : (T) MetadataUtils.attachHeaders(t2, metadata);
    }

    public static String[] cipherSuites(List<CipherSuite> list) {
        String[] strArr = new String[list.size()];
        for (int i10 = 0; i10 < list.size(); i10++) {
            strArr[i10] = list.get(i10).name();
        }
        return strArr;
    }

    public static Metadata.Key<String> getCustomHeaderKey(String str) {
        return Metadata.Key.of(str, Metadata.ASCII_STRING_MARSHALLER);
    }

    public static String getExceptionValue(Throwable th) {
        if (th == null) {
            return "";
        }
        Status fromThrowable = Status.fromThrowable(th);
        if (fromThrowable.getCode() == Status.Code.UNKNOWN) {
            return th.toString();
        }
        Throwable cause = fromThrowable.getCause();
        String description = fromThrowable.getDescription();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("code=");
        stringBuffer.append((Object) fromThrowable.getCode());
        stringBuffer.append(", description=");
        if (description == null) {
            description = "";
        }
        stringBuffer.append(description);
        stringBuffer.append(", cause=");
        stringBuffer.append(cause != null ? cause.toString() : "");
        return stringBuffer.toString();
    }

    public static String getStringValue(String str) {
        return str == null ? "" : str;
    }

    public static OkHttpChannelBuilder newOkHttpChannelBuilder(String str, int i10) {
        OkHttpChannelBuilder forAddress = OkHttpChannelBuilder.forAddress(str, i10);
        ConnectionSpec connectionSpec = ConnectionSpec.COMPATIBLE_TLS;
        OkHttpChannelBuilder okHttpChannelBuilder = (OkHttpChannelBuilder) forAddress.tlsConnectionSpec(tlsVersions(connectionSpec.tlsVersions()), cipherSuites(connectionSpec.cipherSuites())).directExecutor();
        String property = System.getProperty("http.agent");
        if (!TextUtils.isEmpty(property)) {
            okHttpChannelBuilder.userAgent(property);
        }
        return okHttpChannelBuilder;
    }

    public static void postUIRunnable(Runnable runnable) {
        mainHandler.post(runnable);
    }

    public static void removeAllUIRunnable() {
        mainHandler.removeCallbacksAndMessages(null);
    }

    public static void removeUIRunnable(Runnable runnable) {
        mainHandler.removeCallbacks(runnable);
    }

    public static String[] tlsVersions(List<TlsVersion> list) {
        String[] strArr = new String[list.size()];
        for (int i10 = 0; i10 < list.size(); i10++) {
            strArr[i10] = list.get(i10).javaName();
        }
        return strArr;
    }

    public static void postUIRunnable(Runnable runnable, long j10) {
        mainHandler.postDelayed(runnable, j10);
    }
}
