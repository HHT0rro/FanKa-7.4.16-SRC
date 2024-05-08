package io.grpc;

import com.google.common.base.j;
import com.google.common.base.o;
import io.grpc.ClientStreamTracer;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class CallOptions {
    public static final CallOptions DEFAULT;
    private final String authority;
    private final String compressorName;
    private final CallCredentials credentials;
    private final Object[][] customOptions;
    private final Deadline deadline;
    private final Executor executor;
    private final Integer maxInboundMessageSize;
    private final Integer maxOutboundMessageSize;
    private final List<ClientStreamTracer.Factory> streamTracerFactories;
    private final Boolean waitForReady;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class Builder {
        public String authority;
        public String compressorName;
        public CallCredentials credentials;
        public Object[][] customOptions;
        public Deadline deadline;
        public Executor executor;
        public Integer maxInboundMessageSize;
        public Integer maxOutboundMessageSize;
        public List<ClientStreamTracer.Factory> streamTracerFactories;
        public Boolean waitForReady;

        /* JADX INFO: Access modifiers changed from: private */
        public CallOptions build() {
            return new CallOptions(this);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class Key<T> {
        private final String debugString;
        private final T defaultValue;

        private Key(String str, T t2) {
            this.debugString = str;
            this.defaultValue = t2;
        }

        public static <T> Key<T> create(String str) {
            o.s(str, "debugString");
            return new Key<>(str, null);
        }

        public static <T> Key<T> createWithDefault(String str, T t2) {
            o.s(str, "debugString");
            return new Key<>(str, t2);
        }

        @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1869")
        @Deprecated
        public static <T> Key<T> of(String str, T t2) {
            o.s(str, "debugString");
            return new Key<>(str, t2);
        }

        public T getDefault() {
            return this.defaultValue;
        }

        public String toString() {
            return this.debugString;
        }
    }

    static {
        Builder builder = new Builder();
        builder.customOptions = (Object[][]) Array.newInstance((Class<?>) Object.class, 0, 2);
        builder.streamTracerFactories = Collections.emptyList();
        DEFAULT = builder.build();
    }

    private static Builder toBuilder(CallOptions callOptions) {
        Builder builder = new Builder();
        builder.deadline = callOptions.deadline;
        builder.executor = callOptions.executor;
        builder.authority = callOptions.authority;
        builder.credentials = callOptions.credentials;
        builder.compressorName = callOptions.compressorName;
        builder.customOptions = callOptions.customOptions;
        builder.streamTracerFactories = callOptions.streamTracerFactories;
        builder.waitForReady = callOptions.waitForReady;
        builder.maxInboundMessageSize = callOptions.maxInboundMessageSize;
        builder.maxOutboundMessageSize = callOptions.maxOutboundMessageSize;
        return builder;
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1767")
    public String getAuthority() {
        return this.authority;
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1704")
    public String getCompressor() {
        return this.compressorName;
    }

    public CallCredentials getCredentials() {
        return this.credentials;
    }

    public Deadline getDeadline() {
        return this.deadline;
    }

    public Executor getExecutor() {
        return this.executor;
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/2563")
    public Integer getMaxInboundMessageSize() {
        return this.maxInboundMessageSize;
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/2563")
    public Integer getMaxOutboundMessageSize() {
        return this.maxOutboundMessageSize;
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1869")
    public <T> T getOption(Key<T> key) {
        o.s(key, "key");
        int i10 = 0;
        while (true) {
            Object[][] objArr = this.customOptions;
            if (i10 < objArr.length) {
                if (key.equals(objArr[i10][0])) {
                    return (T) this.customOptions[i10][1];
                }
                i10++;
            } else {
                return (T) ((Key) key).defaultValue;
            }
        }
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/2861")
    public List<ClientStreamTracer.Factory> getStreamTracerFactories() {
        return this.streamTracerFactories;
    }

    public Boolean getWaitForReady() {
        return this.waitForReady;
    }

    public boolean isWaitForReady() {
        return Boolean.TRUE.equals(this.waitForReady);
    }

    public String toString() {
        j.b d10 = j.c(this).d("deadline", this.deadline).d("authority", this.authority).d("callCredentials", this.credentials);
        Executor executor = this.executor;
        return d10.d("executor", executor != null ? executor.getClass() : null).d("compressorName", this.compressorName).d("customOptions", Arrays.deepToString(this.customOptions)).e("waitForReady", isWaitForReady()).d("maxInboundMessageSize", this.maxInboundMessageSize).d("maxOutboundMessageSize", this.maxOutboundMessageSize).d("streamTracerFactories", this.streamTracerFactories).toString();
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1767")
    public CallOptions withAuthority(String str) {
        Builder builder = toBuilder(this);
        builder.authority = str;
        return builder.build();
    }

    public CallOptions withCallCredentials(CallCredentials callCredentials) {
        Builder builder = toBuilder(this);
        builder.credentials = callCredentials;
        return builder.build();
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1704")
    public CallOptions withCompression(String str) {
        Builder builder = toBuilder(this);
        builder.compressorName = str;
        return builder.build();
    }

    public CallOptions withDeadline(Deadline deadline) {
        Builder builder = toBuilder(this);
        builder.deadline = deadline;
        return builder.build();
    }

    public CallOptions withDeadlineAfter(long j10, TimeUnit timeUnit) {
        return withDeadline(Deadline.after(j10, timeUnit));
    }

    public CallOptions withExecutor(Executor executor) {
        Builder builder = toBuilder(this);
        builder.executor = executor;
        return builder.build();
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/2563")
    public CallOptions withMaxInboundMessageSize(int i10) {
        o.h(i10 >= 0, "invalid maxsize %s", i10);
        Builder builder = toBuilder(this);
        builder.maxInboundMessageSize = Integer.valueOf(i10);
        return builder.build();
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/2563")
    public CallOptions withMaxOutboundMessageSize(int i10) {
        o.h(i10 >= 0, "invalid maxsize %s", i10);
        Builder builder = toBuilder(this);
        builder.maxOutboundMessageSize = Integer.valueOf(i10);
        return builder.build();
    }

    public <T> CallOptions withOption(Key<T> key, T t2) {
        o.s(key, "key");
        o.s(t2, "value");
        Builder builder = toBuilder(this);
        int i10 = 0;
        while (true) {
            Object[][] objArr = this.customOptions;
            if (i10 >= objArr.length) {
                i10 = -1;
                break;
            }
            if (key.equals(objArr[i10][0])) {
                break;
            }
            i10++;
        }
        Object[][] objArr2 = (Object[][]) Array.newInstance((Class<?>) Object.class, this.customOptions.length + (i10 == -1 ? 1 : 0), 2);
        builder.customOptions = objArr2;
        Object[][] objArr3 = this.customOptions;
        System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
        if (i10 == -1) {
            Object[][] objArr4 = builder.customOptions;
            int length = this.customOptions.length;
            Object[] objArr5 = new Object[2];
            objArr5[0] = key;
            objArr5[1] = t2;
            objArr4[length] = objArr5;
        } else {
            Object[][] objArr6 = builder.customOptions;
            Object[] objArr7 = new Object[2];
            objArr7[0] = key;
            objArr7[1] = t2;
            objArr6[i10] = objArr7;
        }
        return builder.build();
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/2861")
    public CallOptions withStreamTracerFactory(ClientStreamTracer.Factory factory) {
        ArrayList arrayList = new ArrayList(this.streamTracerFactories.size() + 1);
        arrayList.addAll(this.streamTracerFactories);
        arrayList.add(factory);
        Builder builder = toBuilder(this);
        builder.streamTracerFactories = Collections.unmodifiableList(arrayList);
        return builder.build();
    }

    public CallOptions withWaitForReady() {
        Builder builder = toBuilder(this);
        builder.waitForReady = Boolean.TRUE;
        return builder.build();
    }

    public CallOptions withoutWaitForReady() {
        Builder builder = toBuilder(this);
        builder.waitForReady = Boolean.FALSE;
        return builder.build();
    }

    private CallOptions(Builder builder) {
        this.deadline = builder.deadline;
        this.executor = builder.executor;
        this.authority = builder.authority;
        this.credentials = builder.credentials;
        this.compressorName = builder.compressorName;
        this.customOptions = builder.customOptions;
        this.streamTracerFactories = builder.streamTracerFactories;
        this.waitForReady = builder.waitForReady;
        this.maxInboundMessageSize = builder.maxInboundMessageSize;
        this.maxOutboundMessageSize = builder.maxOutboundMessageSize;
    }
}
