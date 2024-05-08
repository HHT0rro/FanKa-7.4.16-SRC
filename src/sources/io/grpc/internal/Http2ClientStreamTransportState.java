package io.grpc.internal;

import com.android.internal.midi.MidiConstants;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.common.base.c;
import com.google.common.base.o;
import io.grpc.InternalMetadata;
import io.grpc.InternalStatus;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.internal.AbstractClientStream;
import java.nio.charset.Charset;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public abstract class Http2ClientStreamTransportState extends AbstractClientStream.TransportState {
    private static final Metadata.Key<Integer> HTTP2_STATUS;
    private static final InternalMetadata.TrustedAsciiMarshaller<Integer> HTTP_STATUS_MARSHALLER;
    private Charset errorCharset;
    private boolean headersReceived;
    private Status transportError;
    private Metadata transportErrorMetadata;

    static {
        InternalMetadata.TrustedAsciiMarshaller<Integer> trustedAsciiMarshaller = new InternalMetadata.TrustedAsciiMarshaller<Integer>() { // from class: io.grpc.internal.Http2ClientStreamTransportState.1
            @Override // io.grpc.Metadata.TrustedAsciiMarshaller
            public Integer parseAsciiString(byte[] bArr) {
                if (bArr.length >= 3) {
                    return Integer.valueOf(((bArr[0] + MidiConstants.STATUS_CHANNEL_PRESSURE) * 100) + ((bArr[1] + MidiConstants.STATUS_CHANNEL_PRESSURE) * 10) + bArr[2] + MidiConstants.STATUS_CHANNEL_PRESSURE);
                }
                throw new NumberFormatException("Malformed status code " + new String(bArr, InternalMetadata.US_ASCII));
            }

            @Override // io.grpc.Metadata.TrustedAsciiMarshaller
            public byte[] toAsciiString(Integer num) {
                throw new UnsupportedOperationException();
            }
        };
        HTTP_STATUS_MARSHALLER = trustedAsciiMarshaller;
        HTTP2_STATUS = InternalMetadata.keyOf(":status", trustedAsciiMarshaller);
    }

    public Http2ClientStreamTransportState(int i10, StatsTraceContext statsTraceContext, TransportTracer transportTracer) {
        super(i10, statsTraceContext, transportTracer);
        this.errorCharset = c.f25961c;
    }

    private static Charset extractCharset(Metadata metadata) {
        String str = (String) metadata.get(GrpcUtil.CONTENT_TYPE_KEY);
        if (str != null) {
            try {
                return Charset.forName(str.split("charset=", 2)[r2.length - 1].trim());
            } catch (Exception unused) {
            }
        }
        return c.f25961c;
    }

    private Status statusFromTrailers(Metadata metadata) {
        Status withDescription;
        Status status = (Status) metadata.get(InternalStatus.CODE_KEY);
        if (status != null) {
            return status.withDescription((String) metadata.get(InternalStatus.MESSAGE_KEY));
        }
        if (this.headersReceived) {
            return Status.UNKNOWN.withDescription("missing GRPC status in response");
        }
        Integer num = (Integer) metadata.get(HTTP2_STATUS);
        if (num != null) {
            withDescription = GrpcUtil.httpStatusToGrpcStatus(num.intValue());
        } else {
            withDescription = Status.INTERNAL.withDescription("missing HTTP status code");
        }
        return withDescription.augmentDescription("missing GRPC status, inferred error from HTTP status code");
    }

    private static void stripTransportDetails(Metadata metadata) {
        metadata.discardAll(HTTP2_STATUS);
        metadata.discardAll(InternalStatus.CODE_KEY);
        metadata.discardAll(InternalStatus.MESSAGE_KEY);
    }

    private Status validateInitialMetadata(Metadata metadata) {
        Integer num = (Integer) metadata.get(HTTP2_STATUS);
        if (num == null) {
            return Status.INTERNAL.withDescription("Missing HTTP status code");
        }
        String str = (String) metadata.get(GrpcUtil.CONTENT_TYPE_KEY);
        if (GrpcUtil.isGrpcContentType(str)) {
            return null;
        }
        return GrpcUtil.httpStatusToGrpcStatus(num.intValue()).augmentDescription("invalid content-type: " + str);
    }

    @Override // io.grpc.internal.AbstractClientStream.TransportState, io.grpc.internal.MessageDeframer.Listener
    public /* bridge */ /* synthetic */ void deframerClosed(boolean z10) {
        super.deframerClosed(z10);
    }

    public abstract void http2ProcessingFailed(Status status, boolean z10, Metadata metadata);

    public void transportDataReceived(ReadableBuffer readableBuffer, boolean z10) {
        Status status = this.transportError;
        if (status != null) {
            this.transportError = status.augmentDescription("DATA-----------------------------\n" + ReadableBuffers.readAsString(readableBuffer, this.errorCharset));
            readableBuffer.close();
            if (this.transportError.getDescription().length() > 1000 || z10) {
                http2ProcessingFailed(this.transportError, false, this.transportErrorMetadata);
                return;
            }
            return;
        }
        if (!this.headersReceived) {
            http2ProcessingFailed(Status.INTERNAL.withDescription("headers not received before payload"), false, new Metadata());
            return;
        }
        int readableBytes = readableBuffer.readableBytes();
        inboundDataReceived(readableBuffer);
        if (z10) {
            if (readableBytes > 0) {
                this.transportError = Status.INTERNAL.withDescription("Received unexpected EOS on non-empty DATA frame from server");
            } else {
                this.transportError = Status.INTERNAL.withDescription("Received unexpected EOS on empty DATA frame from server");
            }
            Metadata metadata = new Metadata();
            this.transportErrorMetadata = metadata;
            transportReportStatus(this.transportError, false, metadata);
        }
    }

    /* JADX WARN: Finally extract failed */
    public void transportHeadersReceived(Metadata metadata) {
        o.s(metadata, TTDownloadField.TT_HEADERS);
        Status status = this.transportError;
        if (status != null) {
            this.transportError = status.augmentDescription("headers: " + ((Object) metadata));
            return;
        }
        try {
            if (this.headersReceived) {
                Status withDescription = Status.INTERNAL.withDescription("Received headers twice");
                this.transportError = withDescription;
                if (withDescription != null) {
                    this.transportError = withDescription.augmentDescription("headers: " + ((Object) metadata));
                    this.transportErrorMetadata = metadata;
                    this.errorCharset = extractCharset(metadata);
                    return;
                }
                return;
            }
            Integer num = (Integer) metadata.get(HTTP2_STATUS);
            if (num != null && num.intValue() >= 100 && num.intValue() < 200) {
                Status status2 = this.transportError;
                if (status2 != null) {
                    this.transportError = status2.augmentDescription("headers: " + ((Object) metadata));
                    this.transportErrorMetadata = metadata;
                    this.errorCharset = extractCharset(metadata);
                    return;
                }
                return;
            }
            this.headersReceived = true;
            Status validateInitialMetadata = validateInitialMetadata(metadata);
            this.transportError = validateInitialMetadata;
            if (validateInitialMetadata != null) {
                if (validateInitialMetadata != null) {
                    this.transportError = validateInitialMetadata.augmentDescription("headers: " + ((Object) metadata));
                    this.transportErrorMetadata = metadata;
                    this.errorCharset = extractCharset(metadata);
                    return;
                }
                return;
            }
            stripTransportDetails(metadata);
            inboundHeadersReceived(metadata);
            Status status3 = this.transportError;
            if (status3 != null) {
                this.transportError = status3.augmentDescription("headers: " + ((Object) metadata));
                this.transportErrorMetadata = metadata;
                this.errorCharset = extractCharset(metadata);
            }
        } catch (Throwable th) {
            Status status4 = this.transportError;
            if (status4 != null) {
                this.transportError = status4.augmentDescription("headers: " + ((Object) metadata));
                this.transportErrorMetadata = metadata;
                this.errorCharset = extractCharset(metadata);
            }
            throw th;
        }
    }

    public void transportTrailersReceived(Metadata metadata) {
        o.s(metadata, GrpcUtil.TE_TRAILERS);
        if (this.transportError == null && !this.headersReceived) {
            Status validateInitialMetadata = validateInitialMetadata(metadata);
            this.transportError = validateInitialMetadata;
            if (validateInitialMetadata != null) {
                this.transportErrorMetadata = metadata;
            }
        }
        Status status = this.transportError;
        if (status != null) {
            Status augmentDescription = status.augmentDescription("trailers: " + ((Object) metadata));
            this.transportError = augmentDescription;
            http2ProcessingFailed(augmentDescription, false, this.transportErrorMetadata);
            return;
        }
        Status statusFromTrailers = statusFromTrailers(metadata);
        stripTransportDetails(metadata);
        inboundTrailersReceived(metadata, statusFromTrailers);
    }
}
