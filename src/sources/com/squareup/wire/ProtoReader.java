package com.squareup.wire;

import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import okio.BufferedSource;
import okio.ByteString;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class ProtoReader {
    private static final int FIELD_ENCODING_MASK = 7;
    private static final int RECURSION_LIMIT = 65;
    private static final int STATE_END_GROUP = 4;
    private static final int STATE_FIXED32 = 5;
    private static final int STATE_FIXED64 = 1;
    private static final int STATE_LENGTH_DELIMITED = 2;
    private static final int STATE_PACKED_TAG = 7;
    private static final int STATE_START_GROUP = 3;
    private static final int STATE_TAG = 6;
    private static final int STATE_VARINT = 0;
    public static final int TAG_FIELD_ENCODING_BITS = 3;
    private FieldEncoding nextFieldEncoding;
    private int recursionDepth;
    private final BufferedSource source;
    private long pos = 0;
    private long limit = Long.MAX_VALUE;
    private int state = 2;
    private int tag = -1;
    private long pushedLimit = -1;

    public ProtoReader(BufferedSource bufferedSource) {
        this.source = bufferedSource;
    }

    private void afterPackableScalar(int i10) throws IOException {
        if (this.state == i10) {
            this.state = 6;
            return;
        }
        long j10 = this.pos;
        long j11 = this.limit;
        if (j10 > j11) {
            throw new IOException("Expected to end at " + this.limit + " but was " + this.pos);
        }
        if (j10 == j11) {
            this.limit = this.pushedLimit;
            this.pushedLimit = -1L;
            this.state = 6;
            return;
        }
        this.state = 7;
    }

    private long beforeLengthDelimitedScalar() throws IOException {
        if (this.state == 2) {
            long j10 = this.limit - this.pos;
            this.source.require(j10);
            this.state = 6;
            this.pos = this.limit;
            this.limit = this.pushedLimit;
            this.pushedLimit = -1L;
            return j10;
        }
        throw new ProtocolException("Expected LENGTH_DELIMITED but was " + this.state);
    }

    private int internalReadVarint32() throws IOException {
        int i10;
        this.source.require(1L);
        this.pos++;
        byte readByte = this.source.readByte();
        if (readByte >= 0) {
            return readByte;
        }
        int i11 = readByte & Byte.MAX_VALUE;
        this.source.require(1L);
        this.pos++;
        byte readByte2 = this.source.readByte();
        if (readByte2 >= 0) {
            i10 = readByte2 << 7;
        } else {
            i11 |= (readByte2 & Byte.MAX_VALUE) << 7;
            this.source.require(1L);
            this.pos++;
            byte readByte3 = this.source.readByte();
            if (readByte3 >= 0) {
                i10 = readByte3 << 14;
            } else {
                i11 |= (readByte3 & Byte.MAX_VALUE) << 14;
                this.source.require(1L);
                this.pos++;
                byte readByte4 = this.source.readByte();
                if (readByte4 < 0) {
                    int i12 = i11 | ((readByte4 & Byte.MAX_VALUE) << 21);
                    this.source.require(1L);
                    this.pos++;
                    byte readByte5 = this.source.readByte();
                    int i13 = i12 | (readByte5 << 28);
                    if (readByte5 >= 0) {
                        return i13;
                    }
                    for (int i14 = 0; i14 < 5; i14++) {
                        this.source.require(1L);
                        this.pos++;
                        if (this.source.readByte() >= 0) {
                            return i13;
                        }
                    }
                    throw new ProtocolException("Malformed VARINT");
                }
                i10 = readByte4 << 21;
            }
        }
        return i11 | i10;
    }

    private void skipGroup(int i10) throws IOException {
        while (this.pos < this.limit && !this.source.exhausted()) {
            int internalReadVarint32 = internalReadVarint32();
            if (internalReadVarint32 == 0) {
                throw new ProtocolException("Unexpected tag 0");
            }
            int i11 = internalReadVarint32 >> 3;
            int i12 = internalReadVarint32 & 7;
            if (i12 == 0) {
                this.state = 0;
                readVarint64();
            } else if (i12 == 1) {
                this.state = 1;
                readFixed64();
            } else if (i12 == 2) {
                long internalReadVarint322 = internalReadVarint32();
                this.pos += internalReadVarint322;
                this.source.skip(internalReadVarint322);
            } else if (i12 == 3) {
                skipGroup(i11);
            } else if (i12 == 4) {
                if (i11 != i10) {
                    throw new ProtocolException("Unexpected end group");
                }
                return;
            } else if (i12 == 5) {
                this.state = 5;
                readFixed32();
            } else {
                throw new ProtocolException("Unexpected field encoding: " + i12);
            }
        }
        throw new EOFException();
    }

    public long beginMessage() throws IOException {
        if (this.state == 2) {
            int i10 = this.recursionDepth + 1;
            this.recursionDepth = i10;
            if (i10 <= 65) {
                long j10 = this.pushedLimit;
                this.pushedLimit = -1L;
                this.state = 6;
                return j10;
            }
            throw new IOException("Wire recursion limit exceeded");
        }
        throw new IllegalStateException("Unexpected call to beginMessage()");
    }

    public void endMessage(long j10) throws IOException {
        if (this.state == 6) {
            int i10 = this.recursionDepth - 1;
            this.recursionDepth = i10;
            if (i10 < 0 || this.pushedLimit != -1) {
                throw new IllegalStateException("No corresponding call to beginMessage()");
            }
            if (this.pos != this.limit && i10 != 0) {
                throw new IOException("Expected to end at " + this.limit + " but was " + this.pos);
            }
            this.limit = j10;
            return;
        }
        throw new IllegalStateException("Unexpected call to endMessage()");
    }

    public int nextTag() throws IOException {
        int i10 = this.state;
        if (i10 == 7) {
            this.state = 2;
            return this.tag;
        }
        if (i10 != 6) {
            throw new IllegalStateException("Unexpected call to nextTag()");
        }
        while (this.pos < this.limit && !this.source.exhausted()) {
            int internalReadVarint32 = internalReadVarint32();
            if (internalReadVarint32 != 0) {
                int i11 = internalReadVarint32 >> 3;
                this.tag = i11;
                int i12 = internalReadVarint32 & 7;
                if (i12 == 0) {
                    this.nextFieldEncoding = FieldEncoding.VARINT;
                    this.state = 0;
                    return i11;
                }
                if (i12 == 1) {
                    this.nextFieldEncoding = FieldEncoding.FIXED64;
                    this.state = 1;
                    return i11;
                }
                if (i12 == 2) {
                    this.nextFieldEncoding = FieldEncoding.LENGTH_DELIMITED;
                    this.state = 2;
                    int internalReadVarint322 = internalReadVarint32();
                    if (internalReadVarint322 < 0) {
                        throw new ProtocolException("Negative length: " + internalReadVarint322);
                    }
                    if (this.pushedLimit == -1) {
                        long j10 = this.limit;
                        this.pushedLimit = j10;
                        long j11 = this.pos + internalReadVarint322;
                        this.limit = j11;
                        if (j11 <= j10) {
                            return this.tag;
                        }
                        throw new EOFException();
                    }
                    throw new IllegalStateException();
                }
                if (i12 != 3) {
                    if (i12 == 4) {
                        throw new ProtocolException("Unexpected end group");
                    }
                    if (i12 == 5) {
                        this.nextFieldEncoding = FieldEncoding.FIXED32;
                        this.state = 5;
                        return i11;
                    }
                    throw new ProtocolException("Unexpected field encoding: " + i12);
                }
                skipGroup(i11);
            } else {
                throw new ProtocolException("Unexpected tag 0");
            }
        }
        return -1;
    }

    public FieldEncoding peekFieldEncoding() {
        return this.nextFieldEncoding;
    }

    public ByteString readBytes() throws IOException {
        long beforeLengthDelimitedScalar = beforeLengthDelimitedScalar();
        this.source.require(beforeLengthDelimitedScalar);
        return this.source.readByteString(beforeLengthDelimitedScalar);
    }

    public int readFixed32() throws IOException {
        int i10 = this.state;
        if (i10 != 5 && i10 != 2) {
            throw new ProtocolException("Expected FIXED32 or LENGTH_DELIMITED but was " + this.state);
        }
        this.source.require(4L);
        this.pos += 4;
        int readIntLe = this.source.readIntLe();
        afterPackableScalar(5);
        return readIntLe;
    }

    public long readFixed64() throws IOException {
        int i10 = this.state;
        if (i10 != 1 && i10 != 2) {
            throw new ProtocolException("Expected FIXED64 or LENGTH_DELIMITED but was " + this.state);
        }
        this.source.require(8L);
        this.pos += 8;
        long readLongLe = this.source.readLongLe();
        afterPackableScalar(1);
        return readLongLe;
    }

    public String readString() throws IOException {
        long beforeLengthDelimitedScalar = beforeLengthDelimitedScalar();
        this.source.require(beforeLengthDelimitedScalar);
        return this.source.readUtf8(beforeLengthDelimitedScalar);
    }

    public int readVarint32() throws IOException {
        int i10 = this.state;
        if (i10 != 0 && i10 != 2) {
            throw new ProtocolException("Expected VARINT or LENGTH_DELIMITED but was " + this.state);
        }
        int internalReadVarint32 = internalReadVarint32();
        afterPackableScalar(0);
        return internalReadVarint32;
    }

    public long readVarint64() throws IOException {
        int i10 = this.state;
        if (i10 != 0 && i10 != 2) {
            throw new ProtocolException("Expected VARINT or LENGTH_DELIMITED but was " + this.state);
        }
        long j10 = 0;
        for (int i11 = 0; i11 < 64; i11 += 7) {
            this.source.require(1L);
            this.pos++;
            j10 |= (r4 & Byte.MAX_VALUE) << i11;
            if ((this.source.readByte() & 128) == 0) {
                afterPackableScalar(0);
                return j10;
            }
        }
        throw new ProtocolException("WireInput encountered a malformed varint");
    }

    public void skip() throws IOException {
        int i10 = this.state;
        if (i10 == 0) {
            readVarint64();
            return;
        }
        if (i10 == 1) {
            readFixed64();
            return;
        }
        if (i10 == 2) {
            this.source.skip(beforeLengthDelimitedScalar());
        } else {
            if (i10 == 5) {
                readFixed32();
                return;
            }
            throw new IllegalStateException("Unexpected call to skip()");
        }
    }
}
