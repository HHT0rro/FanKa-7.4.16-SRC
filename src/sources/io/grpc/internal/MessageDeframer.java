package io.grpc.internal;

import com.google.common.base.o;
import io.grpc.Codec;
import io.grpc.Decompressor;
import io.grpc.Status;
import io.grpc.internal.StreamListener;
import java.io.Closeable;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.zip.DataFormatException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class MessageDeframer implements Closeable, Deframer {
    private static final int COMPRESSED_FLAG_MASK = 1;
    private static final int HEADER_LENGTH = 5;
    private static final int MAX_BUFFER_SIZE = 2097152;
    private static final int RESERVED_MASK = 254;
    private boolean compressedFlag;
    private Decompressor decompressor;
    private GzipInflatingBuffer fullStreamDecompressor;
    private int inboundBodyWireSize;
    private byte[] inflatedBuffer;
    private int inflatedIndex;
    private Listener listener;
    private int maxInboundMessageSize;
    private CompositeReadableBuffer nextFrame;
    private long pendingDeliveries;
    private final StatsTraceContext statsTraceCtx;
    private final TransportTracer transportTracer;
    private State state = State.HEADER;
    private int requiredLength = 5;
    private CompositeReadableBuffer unprocessed = new CompositeReadableBuffer();
    private boolean inDelivery = false;
    private int currentMessageSeqNo = -1;
    private boolean closeWhenComplete = false;
    private volatile boolean stopDelivery = false;

    /* renamed from: io.grpc.internal.MessageDeframer$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$io$grpc$internal$MessageDeframer$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$io$grpc$internal$MessageDeframer$State = iArr;
            try {
                iArr[State.HEADER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$grpc$internal$MessageDeframer$State[State.BODY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface Listener {
        void bytesRead(int i10);

        void deframeFailed(Throwable th);

        void deframerClosed(boolean z10);

        void messagesAvailable(StreamListener.MessageProducer messageProducer);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class SingleMessageProducer implements StreamListener.MessageProducer {
        private InputStream message;

        public /* synthetic */ SingleMessageProducer(InputStream inputStream, AnonymousClass1 anonymousClass1) {
            this(inputStream);
        }

        @Override // io.grpc.internal.StreamListener.MessageProducer
        public InputStream next() {
            InputStream inputStream = this.message;
            this.message = null;
            return inputStream;
        }

        private SingleMessageProducer(InputStream inputStream) {
            this.message = inputStream;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public enum State {
        HEADER,
        BODY
    }

    public MessageDeframer(Listener listener, Decompressor decompressor, int i10, StatsTraceContext statsTraceContext, TransportTracer transportTracer) {
        this.listener = (Listener) o.s(listener, "sink");
        this.decompressor = (Decompressor) o.s(decompressor, "decompressor");
        this.maxInboundMessageSize = i10;
        this.statsTraceCtx = (StatsTraceContext) o.s(statsTraceContext, "statsTraceCtx");
        this.transportTracer = (TransportTracer) o.s(transportTracer, "transportTracer");
    }

    private void deliver() {
        if (this.inDelivery) {
            return;
        }
        this.inDelivery = true;
        while (true) {
            try {
                if (this.stopDelivery || this.pendingDeliveries <= 0 || !readRequiredBytes()) {
                    break;
                }
                int i10 = AnonymousClass1.$SwitchMap$io$grpc$internal$MessageDeframer$State[this.state.ordinal()];
                if (i10 == 1) {
                    processHeader();
                } else if (i10 == 2) {
                    processBody();
                    this.pendingDeliveries--;
                } else {
                    throw new AssertionError((Object) ("Invalid state: " + ((Object) this.state)));
                }
            } finally {
                this.inDelivery = false;
            }
        }
        if (this.stopDelivery) {
            close();
            return;
        }
        if (this.closeWhenComplete && isStalled()) {
            close();
        }
    }

    private InputStream getCompressedBody() {
        Decompressor decompressor = this.decompressor;
        if (decompressor != Codec.Identity.NONE) {
            try {
                return new SizeEnforcingInputStream(decompressor.decompress(ReadableBuffers.openStream(this.nextFrame, true)), this.maxInboundMessageSize, this.statsTraceCtx);
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }
        throw Status.INTERNAL.withDescription("Can't decode compressed gRPC message as compression not configured").asRuntimeException();
    }

    private InputStream getUncompressedBody() {
        this.statsTraceCtx.inboundUncompressedSize(this.nextFrame.readableBytes());
        return ReadableBuffers.openStream(this.nextFrame, true);
    }

    private boolean isClosedOrScheduledToClose() {
        return isClosed() || this.closeWhenComplete;
    }

    private boolean isStalled() {
        GzipInflatingBuffer gzipInflatingBuffer = this.fullStreamDecompressor;
        if (gzipInflatingBuffer != null) {
            return gzipInflatingBuffer.isStalled();
        }
        return this.unprocessed.readableBytes() == 0;
    }

    private void processBody() {
        this.statsTraceCtx.inboundMessageRead(this.currentMessageSeqNo, this.inboundBodyWireSize, -1L);
        this.inboundBodyWireSize = 0;
        InputStream compressedBody = this.compressedFlag ? getCompressedBody() : getUncompressedBody();
        this.nextFrame = null;
        this.listener.messagesAvailable(new SingleMessageProducer(compressedBody, null));
        this.state = State.HEADER;
        this.requiredLength = 5;
    }

    private void processHeader() {
        int readUnsignedByte = this.nextFrame.readUnsignedByte();
        if ((readUnsignedByte & 254) == 0) {
            this.compressedFlag = (readUnsignedByte & 1) != 0;
            int readInt = this.nextFrame.readInt();
            this.requiredLength = readInt;
            if (readInt >= 0 && readInt <= this.maxInboundMessageSize) {
                int i10 = this.currentMessageSeqNo + 1;
                this.currentMessageSeqNo = i10;
                this.statsTraceCtx.inboundMessage(i10);
                this.transportTracer.reportMessageReceived();
                this.state = State.BODY;
                return;
            }
            throw Status.RESOURCE_EXHAUSTED.withDescription(String.format(Locale.US, "gRPC message exceeds maximum size %d: %d", Integer.valueOf(this.maxInboundMessageSize), Integer.valueOf(this.requiredLength))).asRuntimeException();
        }
        throw Status.INTERNAL.withDescription("gRPC frame header malformed: reserved bits not zero").asRuntimeException();
    }

    private boolean readRequiredBytes() {
        int i10;
        int i11 = 0;
        try {
            if (this.nextFrame == null) {
                this.nextFrame = new CompositeReadableBuffer();
            }
            int i12 = 0;
            i10 = 0;
            while (true) {
                try {
                    int readableBytes = this.requiredLength - this.nextFrame.readableBytes();
                    if (readableBytes <= 0) {
                        if (i12 > 0) {
                            this.listener.bytesRead(i12);
                            if (this.state == State.BODY) {
                                if (this.fullStreamDecompressor != null) {
                                    this.statsTraceCtx.inboundWireSize(i10);
                                    this.inboundBodyWireSize += i10;
                                } else {
                                    this.statsTraceCtx.inboundWireSize(i12);
                                    this.inboundBodyWireSize += i12;
                                }
                            }
                        }
                        return true;
                    }
                    if (this.fullStreamDecompressor != null) {
                        try {
                            byte[] bArr = this.inflatedBuffer;
                            if (bArr == null || this.inflatedIndex == bArr.length) {
                                this.inflatedBuffer = new byte[Math.min(readableBytes, 2097152)];
                                this.inflatedIndex = 0;
                            }
                            int inflateBytes = this.fullStreamDecompressor.inflateBytes(this.inflatedBuffer, this.inflatedIndex, Math.min(readableBytes, this.inflatedBuffer.length - this.inflatedIndex));
                            i12 += this.fullStreamDecompressor.getAndResetBytesConsumed();
                            i10 += this.fullStreamDecompressor.getAndResetDeflatedBytesConsumed();
                            if (inflateBytes == 0) {
                                if (i12 > 0) {
                                    this.listener.bytesRead(i12);
                                    if (this.state == State.BODY) {
                                        if (this.fullStreamDecompressor != null) {
                                            this.statsTraceCtx.inboundWireSize(i10);
                                            this.inboundBodyWireSize += i10;
                                        } else {
                                            this.statsTraceCtx.inboundWireSize(i12);
                                            this.inboundBodyWireSize += i12;
                                        }
                                    }
                                }
                                return false;
                            }
                            this.nextFrame.addBuffer(ReadableBuffers.wrap(this.inflatedBuffer, this.inflatedIndex, inflateBytes));
                            this.inflatedIndex += inflateBytes;
                        } catch (IOException e2) {
                            throw new RuntimeException(e2);
                        } catch (DataFormatException e10) {
                            throw new RuntimeException(e10);
                        }
                    } else {
                        if (this.unprocessed.readableBytes() == 0) {
                            if (i12 > 0) {
                                this.listener.bytesRead(i12);
                                if (this.state == State.BODY) {
                                    if (this.fullStreamDecompressor != null) {
                                        this.statsTraceCtx.inboundWireSize(i10);
                                        this.inboundBodyWireSize += i10;
                                    } else {
                                        this.statsTraceCtx.inboundWireSize(i12);
                                        this.inboundBodyWireSize += i12;
                                    }
                                }
                            }
                            return false;
                        }
                        int min = Math.min(readableBytes, this.unprocessed.readableBytes());
                        i12 += min;
                        this.nextFrame.addBuffer(this.unprocessed.readBytes(min));
                    }
                } catch (Throwable th) {
                    int i13 = i12;
                    th = th;
                    i11 = i13;
                    if (i11 > 0) {
                        this.listener.bytesRead(i11);
                        if (this.state == State.BODY) {
                            if (this.fullStreamDecompressor != null) {
                                this.statsTraceCtx.inboundWireSize(i10);
                                this.inboundBodyWireSize += i10;
                            } else {
                                this.statsTraceCtx.inboundWireSize(i11);
                                this.inboundBodyWireSize += i11;
                            }
                        }
                    }
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            i10 = 0;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (isClosed()) {
            return;
        }
        CompositeReadableBuffer compositeReadableBuffer = this.nextFrame;
        boolean z10 = true;
        boolean z11 = compositeReadableBuffer != null && compositeReadableBuffer.readableBytes() > 0;
        try {
            GzipInflatingBuffer gzipInflatingBuffer = this.fullStreamDecompressor;
            if (gzipInflatingBuffer != null) {
                if (!z11 && !gzipInflatingBuffer.hasPartialData()) {
                    z10 = false;
                }
                this.fullStreamDecompressor.close();
                z11 = z10;
            }
            CompositeReadableBuffer compositeReadableBuffer2 = this.unprocessed;
            if (compositeReadableBuffer2 != null) {
                compositeReadableBuffer2.close();
            }
            CompositeReadableBuffer compositeReadableBuffer3 = this.nextFrame;
            if (compositeReadableBuffer3 != null) {
                compositeReadableBuffer3.close();
            }
            this.fullStreamDecompressor = null;
            this.unprocessed = null;
            this.nextFrame = null;
            this.listener.deframerClosed(z11);
        } catch (Throwable th) {
            this.fullStreamDecompressor = null;
            this.unprocessed = null;
            this.nextFrame = null;
            throw th;
        }
    }

    @Override // io.grpc.internal.Deframer
    public void closeWhenComplete() {
        if (isClosed()) {
            return;
        }
        if (isStalled()) {
            close();
        } else {
            this.closeWhenComplete = true;
        }
    }

    @Override // io.grpc.internal.Deframer
    public void deframe(ReadableBuffer readableBuffer) {
        o.s(readableBuffer, "data");
        boolean z10 = true;
        try {
            if (!isClosedOrScheduledToClose()) {
                GzipInflatingBuffer gzipInflatingBuffer = this.fullStreamDecompressor;
                if (gzipInflatingBuffer != null) {
                    gzipInflatingBuffer.addGzippedBytes(readableBuffer);
                } else {
                    this.unprocessed.addBuffer(readableBuffer);
                }
                z10 = false;
                deliver();
            }
        } finally {
            if (z10) {
                readableBuffer.close();
            }
        }
    }

    public boolean hasPendingDeliveries() {
        return this.pendingDeliveries != 0;
    }

    public boolean isClosed() {
        return this.unprocessed == null && this.fullStreamDecompressor == null;
    }

    @Override // io.grpc.internal.Deframer
    public void request(int i10) {
        o.e(i10 > 0, "numMessages must be > 0");
        if (isClosed()) {
            return;
        }
        this.pendingDeliveries += i10;
        deliver();
    }

    @Override // io.grpc.internal.Deframer
    public void setDecompressor(Decompressor decompressor) {
        o.y(this.fullStreamDecompressor == null, "Already set full stream decompressor");
        this.decompressor = (Decompressor) o.s(decompressor, "Can't pass an empty decompressor");
    }

    @Override // io.grpc.internal.Deframer
    public void setFullStreamDecompressor(GzipInflatingBuffer gzipInflatingBuffer) {
        o.y(this.decompressor == Codec.Identity.NONE, "per-message decompressor already set");
        o.y(this.fullStreamDecompressor == null, "full stream decompressor already set");
        this.fullStreamDecompressor = (GzipInflatingBuffer) o.s(gzipInflatingBuffer, "Can't pass a null full stream decompressor");
        this.unprocessed = null;
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    @Override // io.grpc.internal.Deframer
    public void setMaxInboundMessageSize(int i10) {
        this.maxInboundMessageSize = i10;
    }

    public void stopDelivery() {
        this.stopDelivery = true;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class SizeEnforcingInputStream extends FilterInputStream {
        private long count;
        private long mark;
        private long maxCount;
        private final int maxMessageSize;
        private final StatsTraceContext statsTraceCtx;

        public SizeEnforcingInputStream(InputStream inputStream, int i10, StatsTraceContext statsTraceContext) {
            super(inputStream);
            this.mark = -1L;
            this.maxMessageSize = i10;
            this.statsTraceCtx = statsTraceContext;
        }

        private void reportCount() {
            long j10 = this.count;
            long j11 = this.maxCount;
            if (j10 > j11) {
                this.statsTraceCtx.inboundUncompressedSize(j10 - j11);
                this.maxCount = this.count;
            }
        }

        private void verifySize() {
            if (this.count <= this.maxMessageSize) {
                return;
            }
            throw Status.RESOURCE_EXHAUSTED.withDescription("Decompressed gRPC message exceeds maximum size " + this.maxMessageSize).asRuntimeException();
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public synchronized void mark(int i10) {
            this.in.mark(i10);
            this.mark = this.count;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            int read = this.in.read();
            if (read != -1) {
                this.count++;
            }
            verifySize();
            reportCount();
            return read;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public synchronized void reset() throws IOException {
            if (!this.in.markSupported()) {
                throw new IOException("Mark not supported");
            }
            if (this.mark != -1) {
                this.in.reset();
                this.count = this.mark;
            } else {
                throw new IOException("Mark not set");
            }
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public long skip(long j10) throws IOException {
            long skip = this.in.skip(j10);
            this.count += skip;
            verifySize();
            reportCount();
            return skip;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i10, int i11) throws IOException {
            int read = this.in.read(bArr, i10, i11);
            if (read != -1) {
                this.count += read;
            }
            verifySize();
            reportCount();
            return read;
        }
    }
}
