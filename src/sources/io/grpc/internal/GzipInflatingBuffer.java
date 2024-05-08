package io.grpc.internal;

import com.google.common.base.o;
import java.io.Closeable;
import java.util.zip.CRC32;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import java.util.zip.ZipException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class GzipInflatingBuffer implements Closeable {
    private static final int GZIP_HEADER_MIN_SIZE = 10;
    private static final int GZIP_MAGIC = 35615;
    private static final int GZIP_TRAILER_SIZE = 8;
    private static final int HEADER_COMMENT_FLAG = 16;
    private static final int HEADER_CRC_FLAG = 2;
    private static final int HEADER_EXTRA_FLAG = 4;
    private static final int HEADER_NAME_FLAG = 8;
    private static final int INFLATE_BUFFER_SIZE = 512;
    private static final int UNSIGNED_SHORT_SIZE = 2;
    private long expectedGzipTrailerIsize;
    private int gzipHeaderFlag;
    private int headerExtraToRead;
    private Inflater inflater;
    private int inflaterInputEnd;
    private int inflaterInputStart;
    private final CompositeReadableBuffer gzippedData = new CompositeReadableBuffer();
    private final CRC32 crc = new CRC32();
    private final GzipMetadataReader gzipMetadataReader = new GzipMetadataReader(this, null);
    private final byte[] inflaterInput = new byte[512];
    private State state = State.HEADER;
    private boolean closed = false;
    private int bytesConsumed = 0;
    private int deflatedBytesConsumed = 0;
    private boolean isStalled = true;

    /* renamed from: io.grpc.internal.GzipInflatingBuffer$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$io$grpc$internal$GzipInflatingBuffer$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$io$grpc$internal$GzipInflatingBuffer$State = iArr;
            try {
                iArr[State.HEADER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$grpc$internal$GzipInflatingBuffer$State[State.HEADER_EXTRA_LEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$grpc$internal$GzipInflatingBuffer$State[State.HEADER_EXTRA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$grpc$internal$GzipInflatingBuffer$State[State.HEADER_NAME.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$grpc$internal$GzipInflatingBuffer$State[State.HEADER_COMMENT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$grpc$internal$GzipInflatingBuffer$State[State.HEADER_CRC.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$io$grpc$internal$GzipInflatingBuffer$State[State.INITIALIZE_INFLATER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$io$grpc$internal$GzipInflatingBuffer$State[State.INFLATING.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$io$grpc$internal$GzipInflatingBuffer$State[State.INFLATER_NEEDS_INPUT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$io$grpc$internal$GzipInflatingBuffer$State[State.TRAILER.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class GzipMetadataReader {
        private GzipMetadataReader() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean readBytesUntilZero() {
            while (readableBytes() > 0) {
                if (readUnsignedByte() == 0) {
                    return true;
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int readUnsignedByte() {
            int readUnsignedByte;
            if (GzipInflatingBuffer.this.inflaterInputEnd - GzipInflatingBuffer.this.inflaterInputStart > 0) {
                readUnsignedByte = GzipInflatingBuffer.this.inflaterInput[GzipInflatingBuffer.this.inflaterInputStart] & 255;
                GzipInflatingBuffer.access$112(GzipInflatingBuffer.this, 1);
            } else {
                readUnsignedByte = GzipInflatingBuffer.this.gzippedData.readUnsignedByte();
            }
            GzipInflatingBuffer.this.crc.update(readUnsignedByte);
            GzipInflatingBuffer.access$512(GzipInflatingBuffer.this, 1);
            return readUnsignedByte;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long readUnsignedInt() {
            return readUnsignedShort() | (readUnsignedShort() << 16);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int readUnsignedShort() {
            return readUnsignedByte() | (readUnsignedByte() << 8);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int readableBytes() {
            return (GzipInflatingBuffer.this.inflaterInputEnd - GzipInflatingBuffer.this.inflaterInputStart) + GzipInflatingBuffer.this.gzippedData.readableBytes();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void skipBytes(int i10) {
            int i11;
            int i12 = GzipInflatingBuffer.this.inflaterInputEnd - GzipInflatingBuffer.this.inflaterInputStart;
            if (i12 > 0) {
                int min = Math.min(i12, i10);
                GzipInflatingBuffer.this.crc.update(GzipInflatingBuffer.this.inflaterInput, GzipInflatingBuffer.this.inflaterInputStart, min);
                GzipInflatingBuffer.access$112(GzipInflatingBuffer.this, min);
                i11 = i10 - min;
            } else {
                i11 = i10;
            }
            if (i11 > 0) {
                byte[] bArr = new byte[512];
                int i13 = 0;
                while (i13 < i11) {
                    int min2 = Math.min(i11 - i13, 512);
                    GzipInflatingBuffer.this.gzippedData.readBytes(bArr, 0, min2);
                    GzipInflatingBuffer.this.crc.update(bArr, 0, min2);
                    i13 += min2;
                }
            }
            GzipInflatingBuffer.access$512(GzipInflatingBuffer.this, i10);
        }

        public /* synthetic */ GzipMetadataReader(GzipInflatingBuffer gzipInflatingBuffer, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public enum State {
        HEADER,
        HEADER_EXTRA_LEN,
        HEADER_EXTRA,
        HEADER_NAME,
        HEADER_COMMENT,
        HEADER_CRC,
        INITIALIZE_INFLATER,
        INFLATING,
        INFLATER_NEEDS_INPUT,
        TRAILER
    }

    public static /* synthetic */ int access$112(GzipInflatingBuffer gzipInflatingBuffer, int i10) {
        int i11 = gzipInflatingBuffer.inflaterInputStart + i10;
        gzipInflatingBuffer.inflaterInputStart = i11;
        return i11;
    }

    public static /* synthetic */ int access$512(GzipInflatingBuffer gzipInflatingBuffer, int i10) {
        int i11 = gzipInflatingBuffer.bytesConsumed + i10;
        gzipInflatingBuffer.bytesConsumed = i11;
        return i11;
    }

    private boolean fill() {
        o.y(this.inflater != null, "inflater is null");
        o.y(this.inflaterInputStart == this.inflaterInputEnd, "inflaterInput has unconsumed bytes");
        int min = Math.min(this.gzippedData.readableBytes(), 512);
        if (min == 0) {
            return false;
        }
        this.inflaterInputStart = 0;
        this.inflaterInputEnd = min;
        this.gzippedData.readBytes(this.inflaterInput, 0, min);
        this.inflater.setInput(this.inflaterInput, this.inflaterInputStart, min);
        this.state = State.INFLATING;
        return true;
    }

    private int inflate(byte[] bArr, int i10, int i11) throws DataFormatException, ZipException {
        o.y(this.inflater != null, "inflater is null");
        try {
            int totalIn = this.inflater.getTotalIn();
            int inflate = this.inflater.inflate(bArr, i10, i11);
            int totalIn2 = this.inflater.getTotalIn() - totalIn;
            this.bytesConsumed += totalIn2;
            this.deflatedBytesConsumed += totalIn2;
            this.inflaterInputStart += totalIn2;
            this.crc.update(bArr, i10, inflate);
            if (this.inflater.finished()) {
                this.expectedGzipTrailerIsize = this.inflater.getBytesWritten() & 4294967295L;
                this.state = State.TRAILER;
            } else if (this.inflater.needsInput()) {
                this.state = State.INFLATER_NEEDS_INPUT;
            }
            return inflate;
        } catch (DataFormatException e2) {
            throw new DataFormatException("Inflater data format exception: " + e2.getMessage());
        }
    }

    private boolean initializeInflater() {
        Inflater inflater = this.inflater;
        if (inflater == null) {
            this.inflater = new Inflater(true);
        } else {
            inflater.reset();
        }
        this.crc.reset();
        int i10 = this.inflaterInputEnd;
        int i11 = this.inflaterInputStart;
        int i12 = i10 - i11;
        if (i12 > 0) {
            this.inflater.setInput(this.inflaterInput, i11, i12);
            this.state = State.INFLATING;
        } else {
            this.state = State.INFLATER_NEEDS_INPUT;
        }
        return true;
    }

    private boolean processHeader() throws ZipException {
        if (this.gzipMetadataReader.readableBytes() < 10) {
            return false;
        }
        if (this.gzipMetadataReader.readUnsignedShort() == 35615) {
            if (this.gzipMetadataReader.readUnsignedByte() == 8) {
                this.gzipHeaderFlag = this.gzipMetadataReader.readUnsignedByte();
                this.gzipMetadataReader.skipBytes(6);
                this.state = State.HEADER_EXTRA_LEN;
                return true;
            }
            throw new ZipException("Unsupported compression method");
        }
        throw new ZipException("Not in GZIP format");
    }

    private boolean processHeaderComment() {
        if ((this.gzipHeaderFlag & 16) != 16) {
            this.state = State.HEADER_CRC;
            return true;
        }
        if (!this.gzipMetadataReader.readBytesUntilZero()) {
            return false;
        }
        this.state = State.HEADER_CRC;
        return true;
    }

    private boolean processHeaderCrc() throws ZipException {
        if ((this.gzipHeaderFlag & 2) != 2) {
            this.state = State.INITIALIZE_INFLATER;
            return true;
        }
        if (this.gzipMetadataReader.readableBytes() < 2) {
            return false;
        }
        if ((65535 & ((int) this.crc.getValue())) == this.gzipMetadataReader.readUnsignedShort()) {
            this.state = State.INITIALIZE_INFLATER;
            return true;
        }
        throw new ZipException("Corrupt GZIP header");
    }

    private boolean processHeaderExtra() {
        int readableBytes = this.gzipMetadataReader.readableBytes();
        int i10 = this.headerExtraToRead;
        if (readableBytes < i10) {
            return false;
        }
        this.gzipMetadataReader.skipBytes(i10);
        this.state = State.HEADER_NAME;
        return true;
    }

    private boolean processHeaderExtraLen() {
        if ((this.gzipHeaderFlag & 4) != 4) {
            this.state = State.HEADER_NAME;
            return true;
        }
        if (this.gzipMetadataReader.readableBytes() < 2) {
            return false;
        }
        this.headerExtraToRead = this.gzipMetadataReader.readUnsignedShort();
        this.state = State.HEADER_EXTRA;
        return true;
    }

    private boolean processHeaderName() {
        if ((this.gzipHeaderFlag & 8) != 8) {
            this.state = State.HEADER_COMMENT;
            return true;
        }
        if (!this.gzipMetadataReader.readBytesUntilZero()) {
            return false;
        }
        this.state = State.HEADER_COMMENT;
        return true;
    }

    private boolean processTrailer() throws ZipException {
        if (this.inflater != null && this.gzipMetadataReader.readableBytes() <= 18) {
            this.inflater.end();
            this.inflater = null;
        }
        if (this.gzipMetadataReader.readableBytes() < 8) {
            return false;
        }
        if (this.crc.getValue() == this.gzipMetadataReader.readUnsignedInt() && this.expectedGzipTrailerIsize == this.gzipMetadataReader.readUnsignedInt()) {
            this.crc.reset();
            this.state = State.HEADER;
            return true;
        }
        throw new ZipException("Corrupt GZIP trailer");
    }

    public void addGzippedBytes(ReadableBuffer readableBuffer) {
        o.y(!this.closed, "GzipInflatingBuffer is closed");
        this.gzippedData.addBuffer(readableBuffer);
        this.isStalled = false;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.closed) {
            return;
        }
        this.closed = true;
        this.gzippedData.close();
        Inflater inflater = this.inflater;
        if (inflater != null) {
            inflater.end();
            this.inflater = null;
        }
    }

    public int getAndResetBytesConsumed() {
        int i10 = this.bytesConsumed;
        this.bytesConsumed = 0;
        return i10;
    }

    public int getAndResetDeflatedBytesConsumed() {
        int i10 = this.deflatedBytesConsumed;
        this.deflatedBytesConsumed = 0;
        return i10;
    }

    public boolean hasPartialData() {
        o.y(!this.closed, "GzipInflatingBuffer is closed");
        return (this.gzipMetadataReader.readableBytes() == 0 && this.state == State.HEADER) ? false : true;
    }

    public int inflateBytes(byte[] bArr, int i10, int i11) throws DataFormatException, ZipException {
        boolean z10 = true;
        o.y(!this.closed, "GzipInflatingBuffer is closed");
        boolean z11 = true;
        int i12 = 0;
        while (z11) {
            int i13 = i11 - i12;
            if (i13 > 0) {
                switch (AnonymousClass1.$SwitchMap$io$grpc$internal$GzipInflatingBuffer$State[this.state.ordinal()]) {
                    case 1:
                        z11 = processHeader();
                        break;
                    case 2:
                        z11 = processHeaderExtraLen();
                        break;
                    case 3:
                        z11 = processHeaderExtra();
                        break;
                    case 4:
                        z11 = processHeaderName();
                        break;
                    case 5:
                        z11 = processHeaderComment();
                        break;
                    case 6:
                        z11 = processHeaderCrc();
                        break;
                    case 7:
                        z11 = initializeInflater();
                        break;
                    case 8:
                        i12 += inflate(bArr, i10 + i12, i13);
                        if (this.state != State.TRAILER) {
                            z11 = true;
                            break;
                        } else {
                            z11 = processTrailer();
                            break;
                        }
                    case 9:
                        z11 = fill();
                        break;
                    case 10:
                        z11 = processTrailer();
                        break;
                    default:
                        throw new AssertionError((Object) ("Invalid state: " + ((Object) this.state)));
                }
            } else {
                if (z11 && (this.state != State.HEADER || this.gzipMetadataReader.readableBytes() >= 10)) {
                    z10 = false;
                }
                this.isStalled = z10;
                return i12;
            }
        }
        if (z11) {
            z10 = false;
        }
        this.isStalled = z10;
        return i12;
    }

    public boolean isStalled() {
        o.y(!this.closed, "GzipInflatingBuffer is closed");
        return this.isStalled;
    }
}
