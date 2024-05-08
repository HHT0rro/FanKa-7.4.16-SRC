package io.grpc;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.common.base.o;
import io.grpc.CallCredentials;
import java.util.concurrent.Executor;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/1914")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class CompositeCallCredentials extends CallCredentials {
    private final CallCredentials credentials1;
    private final CallCredentials credentials2;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class CombiningMetadataApplier extends CallCredentials.MetadataApplier {
        private final CallCredentials.MetadataApplier delegate;
        private final Metadata firstHeaders;

        public CombiningMetadataApplier(CallCredentials.MetadataApplier metadataApplier, Metadata metadata) {
            this.delegate = metadataApplier;
            this.firstHeaders = metadata;
        }

        @Override // io.grpc.CallCredentials.MetadataApplier
        public void apply(Metadata metadata) {
            o.s(metadata, TTDownloadField.TT_HEADERS);
            Metadata metadata2 = new Metadata();
            metadata2.merge(this.firstHeaders);
            metadata2.merge(metadata);
            this.delegate.apply(metadata2);
        }

        @Override // io.grpc.CallCredentials.MetadataApplier
        public void fail(Status status) {
            this.delegate.fail(status);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public final class WrappingMetadataApplier extends CallCredentials.MetadataApplier {
        private final Executor appExecutor;
        private final Context context;
        private final CallCredentials.MetadataApplier delegate;
        private final CallCredentials.RequestInfo requestInfo;

        public WrappingMetadataApplier(CallCredentials.RequestInfo requestInfo, Executor executor, CallCredentials.MetadataApplier metadataApplier, Context context) {
            this.requestInfo = requestInfo;
            this.appExecutor = executor;
            this.delegate = (CallCredentials.MetadataApplier) o.s(metadataApplier, "delegate");
            this.context = (Context) o.s(context, "context");
        }

        @Override // io.grpc.CallCredentials.MetadataApplier
        public void apply(Metadata metadata) {
            o.s(metadata, TTDownloadField.TT_HEADERS);
            Context attach = this.context.attach();
            try {
                CompositeCallCredentials.this.credentials2.applyRequestMetadata(this.requestInfo, this.appExecutor, new CombiningMetadataApplier(this.delegate, metadata));
            } finally {
                this.context.detach(attach);
            }
        }

        @Override // io.grpc.CallCredentials.MetadataApplier
        public void fail(Status status) {
            this.delegate.fail(status);
        }
    }

    public CompositeCallCredentials(CallCredentials callCredentials, CallCredentials callCredentials2) {
        this.credentials1 = (CallCredentials) o.s(callCredentials, "creds1");
        this.credentials2 = (CallCredentials) o.s(callCredentials2, "creds2");
    }

    @Override // io.grpc.CallCredentials
    public void applyRequestMetadata(CallCredentials.RequestInfo requestInfo, Executor executor, CallCredentials.MetadataApplier metadataApplier) {
        this.credentials1.applyRequestMetadata(requestInfo, executor, new WrappingMetadataApplier(requestInfo, executor, metadataApplier, Context.current()));
    }

    @Override // io.grpc.CallCredentials
    public void thisUsesUnstableApi() {
    }
}
