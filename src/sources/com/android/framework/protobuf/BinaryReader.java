package com.android.framework.protobuf;

import com.android.framework.protobuf.InvalidProtocolBufferException;
import com.android.framework.protobuf.MapEntryLite;
import com.android.framework.protobuf.WireFormat;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
@CheckReturnValue
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
abstract class BinaryReader implements Reader {
    private static final int FIXED32_MULTIPLE_MASK = 3;
    private static final int FIXED64_MULTIPLE_MASK = 7;

    public abstract int getTotalBytesRead();

    /* synthetic */ BinaryReader(AnonymousClass1 x02) {
        this();
    }

    public static BinaryReader newInstance(ByteBuffer buffer, boolean bufferIsImmutable) {
        if (buffer.hasArray()) {
            return new SafeHeapReader(buffer, bufferIsImmutable);
        }
        throw new IllegalArgumentException("Direct buffers not yet supported");
    }

    private BinaryReader() {
    }

    @Override // com.android.framework.protobuf.Reader
    public boolean shouldDiscardUnknownFields() {
        return false;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    private static final class SafeHeapReader extends BinaryReader {
        private final byte[] buffer;
        private final boolean bufferIsImmutable;
        private int endGroupTag;
        private final int initialPos;
        private int limit;
        private int pos;
        private int tag;

        public SafeHeapReader(ByteBuffer bytebuf, boolean bufferIsImmutable) {
            super(null);
            this.bufferIsImmutable = bufferIsImmutable;
            this.buffer = bytebuf.array();
            int arrayOffset = bytebuf.arrayOffset() + bytebuf.position();
            this.pos = arrayOffset;
            this.initialPos = arrayOffset;
            this.limit = bytebuf.arrayOffset() + bytebuf.limit();
        }

        private boolean isAtEnd() {
            return this.pos == this.limit;
        }

        @Override // com.android.framework.protobuf.BinaryReader
        public int getTotalBytesRead() {
            return this.pos - this.initialPos;
        }

        @Override // com.android.framework.protobuf.Reader
        public int getFieldNumber() throws IOException {
            if (isAtEnd()) {
                return Integer.MAX_VALUE;
            }
            int readVarint32 = readVarint32();
            this.tag = readVarint32;
            if (readVarint32 == this.endGroupTag) {
                return Integer.MAX_VALUE;
            }
            return WireFormat.getTagFieldNumber(readVarint32);
        }

        @Override // com.android.framework.protobuf.Reader
        public int getTag() {
            return this.tag;
        }

        @Override // com.android.framework.protobuf.Reader
        public boolean skipField() throws IOException {
            int i10;
            if (isAtEnd() || (i10 = this.tag) == this.endGroupTag) {
                return false;
            }
            switch (WireFormat.getTagWireType(i10)) {
                case 0:
                    skipVarint();
                    return true;
                case 1:
                    skipBytes(8);
                    return true;
                case 2:
                    skipBytes(readVarint32());
                    return true;
                case 3:
                    skipGroup();
                    return true;
                case 4:
                default:
                    throw InvalidProtocolBufferException.invalidWireType();
                case 5:
                    skipBytes(4);
                    return true;
            }
        }

        @Override // com.android.framework.protobuf.Reader
        public double readDouble() throws IOException {
            requireWireType(1);
            return Double.longBitsToDouble(readLittleEndian64());
        }

        @Override // com.android.framework.protobuf.Reader
        public float readFloat() throws IOException {
            requireWireType(5);
            return Float.intBitsToFloat(readLittleEndian32());
        }

        @Override // com.android.framework.protobuf.Reader
        public long readUInt64() throws IOException {
            requireWireType(0);
            return readVarint64();
        }

        @Override // com.android.framework.protobuf.Reader
        public long readInt64() throws IOException {
            requireWireType(0);
            return readVarint64();
        }

        @Override // com.android.framework.protobuf.Reader
        public int readInt32() throws IOException {
            requireWireType(0);
            return readVarint32();
        }

        @Override // com.android.framework.protobuf.Reader
        public long readFixed64() throws IOException {
            requireWireType(1);
            return readLittleEndian64();
        }

        @Override // com.android.framework.protobuf.Reader
        public int readFixed32() throws IOException {
            requireWireType(5);
            return readLittleEndian32();
        }

        @Override // com.android.framework.protobuf.Reader
        public boolean readBool() throws IOException {
            requireWireType(0);
            return readVarint32() != 0;
        }

        @Override // com.android.framework.protobuf.Reader
        public String readString() throws IOException {
            return readStringInternal(false);
        }

        @Override // com.android.framework.protobuf.Reader
        public String readStringRequireUtf8() throws IOException {
            return readStringInternal(true);
        }

        public String readStringInternal(boolean requireUtf8) throws IOException {
            requireWireType(2);
            int size = readVarint32();
            if (size == 0) {
                return "";
            }
            requireBytes(size);
            if (requireUtf8) {
                byte[] bArr = this.buffer;
                int i10 = this.pos;
                if (!Utf8.isValidUtf8(bArr, i10, i10 + size)) {
                    throw InvalidProtocolBufferException.invalidUtf8();
                }
            }
            String result = new String(this.buffer, this.pos, size, Internal.UTF_8);
            this.pos += size;
            return result;
        }

        @Override // com.android.framework.protobuf.Reader
        public <T> T readMessage(Class<T> cls, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            requireWireType(2);
            return (T) readMessage(Protobuf.getInstance().schemaFor((Class) cls), extensionRegistryLite);
        }

        @Override // com.android.framework.protobuf.Reader
        public <T> T readMessageBySchemaWithCheck(Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            requireWireType(2);
            return (T) readMessage(schema, extensionRegistryLite);
        }

        private <T> T readMessage(Schema<T> schema, ExtensionRegistryLite extensionRegistry) throws IOException {
            T newInstance = schema.newInstance();
            mergeMessageField(newInstance, schema, extensionRegistry);
            schema.makeImmutable(newInstance);
            return newInstance;
        }

        @Override // com.android.framework.protobuf.Reader
        public <T> void mergeMessageField(T target, Schema<T> schema, ExtensionRegistryLite extensionRegistry) throws IOException {
            int size = readVarint32();
            requireBytes(size);
            int prevLimit = this.limit;
            int newLimit = this.pos + size;
            this.limit = newLimit;
            try {
                schema.mergeFrom(target, this, extensionRegistry);
                if (this.pos != newLimit) {
                    throw InvalidProtocolBufferException.parseFailure();
                }
            } finally {
                this.limit = prevLimit;
            }
        }

        @Override // com.android.framework.protobuf.Reader
        @Deprecated
        public <T> T readGroup(Class<T> cls, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            requireWireType(3);
            return (T) readGroup(Protobuf.getInstance().schemaFor((Class) cls), extensionRegistryLite);
        }

        @Override // com.android.framework.protobuf.Reader
        @Deprecated
        public <T> T readGroupBySchemaWithCheck(Schema<T> schema, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            requireWireType(3);
            return (T) readGroup(schema, extensionRegistryLite);
        }

        private <T> T readGroup(Schema<T> schema, ExtensionRegistryLite extensionRegistry) throws IOException {
            T newInstance = schema.newInstance();
            mergeGroupField(newInstance, schema, extensionRegistry);
            schema.makeImmutable(newInstance);
            return newInstance;
        }

        @Override // com.android.framework.protobuf.Reader
        public <T> void mergeGroupField(T target, Schema<T> schema, ExtensionRegistryLite extensionRegistry) throws IOException {
            int prevEndGroupTag = this.endGroupTag;
            this.endGroupTag = WireFormat.makeTag(WireFormat.getTagFieldNumber(this.tag), 4);
            try {
                schema.mergeFrom(target, this, extensionRegistry);
                if (this.tag != this.endGroupTag) {
                    throw InvalidProtocolBufferException.parseFailure();
                }
            } finally {
                this.endGroupTag = prevEndGroupTag;
            }
        }

        @Override // com.android.framework.protobuf.Reader
        public ByteString readBytes() throws IOException {
            ByteString bytes;
            requireWireType(2);
            int size = readVarint32();
            if (size == 0) {
                return ByteString.EMPTY;
            }
            requireBytes(size);
            if (this.bufferIsImmutable) {
                bytes = ByteString.wrap(this.buffer, this.pos, size);
            } else {
                bytes = ByteString.copyFrom(this.buffer, this.pos, size);
            }
            this.pos += size;
            return bytes;
        }

        @Override // com.android.framework.protobuf.Reader
        public int readUInt32() throws IOException {
            requireWireType(0);
            return readVarint32();
        }

        @Override // com.android.framework.protobuf.Reader
        public int readEnum() throws IOException {
            requireWireType(0);
            return readVarint32();
        }

        @Override // com.android.framework.protobuf.Reader
        public int readSFixed32() throws IOException {
            requireWireType(5);
            return readLittleEndian32();
        }

        @Override // com.android.framework.protobuf.Reader
        public long readSFixed64() throws IOException {
            requireWireType(1);
            return readLittleEndian64();
        }

        @Override // com.android.framework.protobuf.Reader
        public int readSInt32() throws IOException {
            requireWireType(0);
            return CodedInputStream.decodeZigZag32(readVarint32());
        }

        @Override // com.android.framework.protobuf.Reader
        public long readSInt64() throws IOException {
            requireWireType(0);
            return CodedInputStream.decodeZigZag64(readVarint64());
        }

        @Override // com.android.framework.protobuf.Reader
        public void readDoubleList(List<Double> target) throws IOException {
            int prevPos;
            int nextTag;
            int prevPos2;
            int nextTag2;
            if (target instanceof DoubleArrayList) {
                DoubleArrayList plist = (DoubleArrayList) target;
                switch (WireFormat.getTagWireType(this.tag)) {
                    case 1:
                        break;
                    case 2:
                        int bytes = readVarint32();
                        verifyPackedFixed64Length(bytes);
                        int fieldEndPos = this.pos + bytes;
                        while (this.pos < fieldEndPos) {
                            plist.addDouble(Double.longBitsToDouble(readLittleEndian64_NoCheck()));
                        }
                        return;
                    default:
                        throw InvalidProtocolBufferException.invalidWireType();
                }
                do {
                    plist.addDouble(readDouble());
                    if (isAtEnd()) {
                        return;
                    }
                    prevPos2 = this.pos;
                    nextTag2 = readVarint32();
                } while (nextTag2 == this.tag);
                this.pos = prevPos2;
                return;
            }
            switch (WireFormat.getTagWireType(this.tag)) {
                case 1:
                    break;
                case 2:
                    int bytes2 = readVarint32();
                    verifyPackedFixed64Length(bytes2);
                    int fieldEndPos2 = this.pos + bytes2;
                    while (this.pos < fieldEndPos2) {
                        target.add(Double.valueOf(Double.longBitsToDouble(readLittleEndian64_NoCheck())));
                    }
                    return;
                default:
                    throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                target.add(Double.valueOf(readDouble()));
                if (isAtEnd()) {
                    return;
                }
                prevPos = this.pos;
                nextTag = readVarint32();
            } while (nextTag == this.tag);
            this.pos = prevPos;
        }

        @Override // com.android.framework.protobuf.Reader
        public void readFloatList(List<Float> target) throws IOException {
            int prevPos;
            int nextTag;
            int prevPos2;
            int nextTag2;
            if (target instanceof FloatArrayList) {
                FloatArrayList plist = (FloatArrayList) target;
                switch (WireFormat.getTagWireType(this.tag)) {
                    case 2:
                        int bytes = readVarint32();
                        verifyPackedFixed32Length(bytes);
                        int fieldEndPos = this.pos + bytes;
                        while (this.pos < fieldEndPos) {
                            plist.addFloat(Float.intBitsToFloat(readLittleEndian32_NoCheck()));
                        }
                        return;
                    case 5:
                        break;
                    default:
                        throw InvalidProtocolBufferException.invalidWireType();
                }
                do {
                    plist.addFloat(readFloat());
                    if (isAtEnd()) {
                        return;
                    }
                    prevPos2 = this.pos;
                    nextTag2 = readVarint32();
                } while (nextTag2 == this.tag);
                this.pos = prevPos2;
                return;
            }
            switch (WireFormat.getTagWireType(this.tag)) {
                case 2:
                    int bytes2 = readVarint32();
                    verifyPackedFixed32Length(bytes2);
                    int fieldEndPos2 = this.pos + bytes2;
                    while (this.pos < fieldEndPos2) {
                        target.add(Float.valueOf(Float.intBitsToFloat(readLittleEndian32_NoCheck())));
                    }
                    return;
                case 5:
                    break;
                default:
                    throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                target.add(Float.valueOf(readFloat()));
                if (isAtEnd()) {
                    return;
                }
                prevPos = this.pos;
                nextTag = readVarint32();
            } while (nextTag == this.tag);
            this.pos = prevPos;
        }

        @Override // com.android.framework.protobuf.Reader
        public void readUInt64List(List<Long> target) throws IOException {
            int prevPos;
            int nextTag;
            int prevPos2;
            int nextTag2;
            if (target instanceof LongArrayList) {
                LongArrayList plist = (LongArrayList) target;
                switch (WireFormat.getTagWireType(this.tag)) {
                    case 0:
                        break;
                    case 1:
                    default:
                        throw InvalidProtocolBufferException.invalidWireType();
                    case 2:
                        int bytes = readVarint32();
                        int fieldEndPos = this.pos + bytes;
                        while (this.pos < fieldEndPos) {
                            plist.addLong(readVarint64());
                        }
                        requirePosition(fieldEndPos);
                        return;
                }
                do {
                    plist.addLong(readUInt64());
                    if (isAtEnd()) {
                        return;
                    }
                    prevPos2 = this.pos;
                    nextTag2 = readVarint32();
                } while (nextTag2 == this.tag);
                this.pos = prevPos2;
                return;
            }
            switch (WireFormat.getTagWireType(this.tag)) {
                case 0:
                    break;
                case 1:
                default:
                    throw InvalidProtocolBufferException.invalidWireType();
                case 2:
                    int bytes2 = readVarint32();
                    int fieldEndPos2 = this.pos + bytes2;
                    while (this.pos < fieldEndPos2) {
                        target.add(Long.valueOf(readVarint64()));
                    }
                    requirePosition(fieldEndPos2);
                    return;
            }
            do {
                target.add(Long.valueOf(readUInt64()));
                if (isAtEnd()) {
                    return;
                }
                prevPos = this.pos;
                nextTag = readVarint32();
            } while (nextTag == this.tag);
            this.pos = prevPos;
        }

        @Override // com.android.framework.protobuf.Reader
        public void readInt64List(List<Long> target) throws IOException {
            int prevPos;
            int nextTag;
            int prevPos2;
            int nextTag2;
            if (target instanceof LongArrayList) {
                LongArrayList plist = (LongArrayList) target;
                switch (WireFormat.getTagWireType(this.tag)) {
                    case 0:
                        break;
                    case 1:
                    default:
                        throw InvalidProtocolBufferException.invalidWireType();
                    case 2:
                        int bytes = readVarint32();
                        int fieldEndPos = this.pos + bytes;
                        while (this.pos < fieldEndPos) {
                            plist.addLong(readVarint64());
                        }
                        requirePosition(fieldEndPos);
                        return;
                }
                do {
                    plist.addLong(readInt64());
                    if (isAtEnd()) {
                        return;
                    }
                    prevPos2 = this.pos;
                    nextTag2 = readVarint32();
                } while (nextTag2 == this.tag);
                this.pos = prevPos2;
                return;
            }
            switch (WireFormat.getTagWireType(this.tag)) {
                case 0:
                    break;
                case 1:
                default:
                    throw InvalidProtocolBufferException.invalidWireType();
                case 2:
                    int bytes2 = readVarint32();
                    int fieldEndPos2 = this.pos + bytes2;
                    while (this.pos < fieldEndPos2) {
                        target.add(Long.valueOf(readVarint64()));
                    }
                    requirePosition(fieldEndPos2);
                    return;
            }
            do {
                target.add(Long.valueOf(readInt64()));
                if (isAtEnd()) {
                    return;
                }
                prevPos = this.pos;
                nextTag = readVarint32();
            } while (nextTag == this.tag);
            this.pos = prevPos;
        }

        @Override // com.android.framework.protobuf.Reader
        public void readInt32List(List<Integer> target) throws IOException {
            int prevPos;
            int nextTag;
            int prevPos2;
            int nextTag2;
            if (target instanceof IntArrayList) {
                IntArrayList plist = (IntArrayList) target;
                switch (WireFormat.getTagWireType(this.tag)) {
                    case 0:
                        break;
                    case 1:
                    default:
                        throw InvalidProtocolBufferException.invalidWireType();
                    case 2:
                        int bytes = readVarint32();
                        int fieldEndPos = this.pos + bytes;
                        while (this.pos < fieldEndPos) {
                            plist.addInt(readVarint32());
                        }
                        requirePosition(fieldEndPos);
                        return;
                }
                do {
                    plist.addInt(readInt32());
                    if (isAtEnd()) {
                        return;
                    }
                    prevPos2 = this.pos;
                    nextTag2 = readVarint32();
                } while (nextTag2 == this.tag);
                this.pos = prevPos2;
                return;
            }
            switch (WireFormat.getTagWireType(this.tag)) {
                case 0:
                    break;
                case 1:
                default:
                    throw InvalidProtocolBufferException.invalidWireType();
                case 2:
                    int bytes2 = readVarint32();
                    int fieldEndPos2 = this.pos + bytes2;
                    while (this.pos < fieldEndPos2) {
                        target.add(Integer.valueOf(readVarint32()));
                    }
                    requirePosition(fieldEndPos2);
                    return;
            }
            do {
                target.add(Integer.valueOf(readInt32()));
                if (isAtEnd()) {
                    return;
                }
                prevPos = this.pos;
                nextTag = readVarint32();
            } while (nextTag == this.tag);
            this.pos = prevPos;
        }

        @Override // com.android.framework.protobuf.Reader
        public void readFixed64List(List<Long> target) throws IOException {
            int prevPos;
            int nextTag;
            int prevPos2;
            int nextTag2;
            if (target instanceof LongArrayList) {
                LongArrayList plist = (LongArrayList) target;
                switch (WireFormat.getTagWireType(this.tag)) {
                    case 1:
                        break;
                    case 2:
                        int bytes = readVarint32();
                        verifyPackedFixed64Length(bytes);
                        int fieldEndPos = this.pos + bytes;
                        while (this.pos < fieldEndPos) {
                            plist.addLong(readLittleEndian64_NoCheck());
                        }
                        return;
                    default:
                        throw InvalidProtocolBufferException.invalidWireType();
                }
                do {
                    plist.addLong(readFixed64());
                    if (isAtEnd()) {
                        return;
                    }
                    prevPos2 = this.pos;
                    nextTag2 = readVarint32();
                } while (nextTag2 == this.tag);
                this.pos = prevPos2;
                return;
            }
            switch (WireFormat.getTagWireType(this.tag)) {
                case 1:
                    break;
                case 2:
                    int bytes2 = readVarint32();
                    verifyPackedFixed64Length(bytes2);
                    int fieldEndPos2 = this.pos + bytes2;
                    while (this.pos < fieldEndPos2) {
                        target.add(Long.valueOf(readLittleEndian64_NoCheck()));
                    }
                    return;
                default:
                    throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                target.add(Long.valueOf(readFixed64()));
                if (isAtEnd()) {
                    return;
                }
                prevPos = this.pos;
                nextTag = readVarint32();
            } while (nextTag == this.tag);
            this.pos = prevPos;
        }

        @Override // com.android.framework.protobuf.Reader
        public void readFixed32List(List<Integer> target) throws IOException {
            int prevPos;
            int nextTag;
            int prevPos2;
            int nextTag2;
            if (target instanceof IntArrayList) {
                IntArrayList plist = (IntArrayList) target;
                switch (WireFormat.getTagWireType(this.tag)) {
                    case 2:
                        int bytes = readVarint32();
                        verifyPackedFixed32Length(bytes);
                        int fieldEndPos = this.pos + bytes;
                        while (this.pos < fieldEndPos) {
                            plist.addInt(readLittleEndian32_NoCheck());
                        }
                        return;
                    case 5:
                        break;
                    default:
                        throw InvalidProtocolBufferException.invalidWireType();
                }
                do {
                    plist.addInt(readFixed32());
                    if (isAtEnd()) {
                        return;
                    }
                    prevPos2 = this.pos;
                    nextTag2 = readVarint32();
                } while (nextTag2 == this.tag);
                this.pos = prevPos2;
                return;
            }
            switch (WireFormat.getTagWireType(this.tag)) {
                case 2:
                    int bytes2 = readVarint32();
                    verifyPackedFixed32Length(bytes2);
                    int fieldEndPos2 = this.pos + bytes2;
                    while (this.pos < fieldEndPos2) {
                        target.add(Integer.valueOf(readLittleEndian32_NoCheck()));
                    }
                    return;
                case 5:
                    break;
                default:
                    throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                target.add(Integer.valueOf(readFixed32()));
                if (isAtEnd()) {
                    return;
                }
                prevPos = this.pos;
                nextTag = readVarint32();
            } while (nextTag == this.tag);
            this.pos = prevPos;
        }

        @Override // com.android.framework.protobuf.Reader
        public void readBoolList(List<Boolean> target) throws IOException {
            int prevPos;
            int nextTag;
            int prevPos2;
            int nextTag2;
            if (target instanceof BooleanArrayList) {
                BooleanArrayList plist = (BooleanArrayList) target;
                switch (WireFormat.getTagWireType(this.tag)) {
                    case 0:
                        break;
                    case 1:
                    default:
                        throw InvalidProtocolBufferException.invalidWireType();
                    case 2:
                        int bytes = readVarint32();
                        int fieldEndPos = this.pos + bytes;
                        while (this.pos < fieldEndPos) {
                            plist.addBoolean(readVarint32() != 0);
                        }
                        requirePosition(fieldEndPos);
                        return;
                }
                do {
                    plist.addBoolean(readBool());
                    if (isAtEnd()) {
                        return;
                    }
                    prevPos2 = this.pos;
                    nextTag2 = readVarint32();
                } while (nextTag2 == this.tag);
                this.pos = prevPos2;
                return;
            }
            switch (WireFormat.getTagWireType(this.tag)) {
                case 0:
                    break;
                case 1:
                default:
                    throw InvalidProtocolBufferException.invalidWireType();
                case 2:
                    int bytes2 = readVarint32();
                    int fieldEndPos2 = this.pos + bytes2;
                    while (this.pos < fieldEndPos2) {
                        target.add(Boolean.valueOf(readVarint32() != 0));
                    }
                    requirePosition(fieldEndPos2);
                    return;
            }
            do {
                target.add(Boolean.valueOf(readBool()));
                if (isAtEnd()) {
                    return;
                }
                prevPos = this.pos;
                nextTag = readVarint32();
            } while (nextTag == this.tag);
            this.pos = prevPos;
        }

        @Override // com.android.framework.protobuf.Reader
        public void readStringList(List<String> target) throws IOException {
            readStringListInternal(target, false);
        }

        @Override // com.android.framework.protobuf.Reader
        public void readStringListRequireUtf8(List<String> target) throws IOException {
            readStringListInternal(target, true);
        }

        public void readStringListInternal(List<String> target, boolean requireUtf8) throws IOException {
            int prevPos;
            int nextTag;
            int prevPos2;
            int nextTag2;
            if (WireFormat.getTagWireType(this.tag) != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            if ((target instanceof LazyStringList) && !requireUtf8) {
                LazyStringList lazyList = (LazyStringList) target;
                do {
                    lazyList.add(readBytes());
                    if (isAtEnd()) {
                        return;
                    }
                    prevPos2 = this.pos;
                    nextTag2 = readVarint32();
                } while (nextTag2 == this.tag);
                this.pos = prevPos2;
                return;
            }
            do {
                target.add(readStringInternal(requireUtf8));
                if (isAtEnd()) {
                    return;
                }
                prevPos = this.pos;
                nextTag = readVarint32();
            } while (nextTag == this.tag);
            this.pos = prevPos;
        }

        @Override // com.android.framework.protobuf.Reader
        public <T> void readMessageList(List<T> target, Class<T> targetType, ExtensionRegistryLite extensionRegistry) throws IOException {
            Schema<T> schema = Protobuf.getInstance().schemaFor((Class) targetType);
            readMessageList(target, schema, extensionRegistry);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.android.framework.protobuf.Reader
        public <T> void readMessageList(List<T> list, Schema<T> schema, ExtensionRegistryLite extensionRegistry) throws IOException {
            int prevPos;
            int nextTag;
            if (WireFormat.getTagWireType(this.tag) != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int listTag = this.tag;
            do {
                list.add(readMessage(schema, extensionRegistry));
                if (isAtEnd()) {
                    return;
                }
                prevPos = this.pos;
                nextTag = readVarint32();
            } while (nextTag == listTag);
            this.pos = prevPos;
        }

        @Override // com.android.framework.protobuf.Reader
        @Deprecated
        public <T> void readGroupList(List<T> target, Class<T> targetType, ExtensionRegistryLite extensionRegistry) throws IOException {
            Schema<T> schema = Protobuf.getInstance().schemaFor((Class) targetType);
            readGroupList(target, schema, extensionRegistry);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.android.framework.protobuf.Reader
        @Deprecated
        public <T> void readGroupList(List<T> list, Schema<T> schema, ExtensionRegistryLite extensionRegistry) throws IOException {
            int prevPos;
            int nextTag;
            if (WireFormat.getTagWireType(this.tag) != 3) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int listTag = this.tag;
            do {
                list.add(readGroup(schema, extensionRegistry));
                if (isAtEnd()) {
                    return;
                }
                prevPos = this.pos;
                nextTag = readVarint32();
            } while (nextTag == listTag);
            this.pos = prevPos;
        }

        @Override // com.android.framework.protobuf.Reader
        public void readBytesList(List<ByteString> target) throws IOException {
            int prevPos;
            int nextTag;
            if (WireFormat.getTagWireType(this.tag) != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                target.add(readBytes());
                if (isAtEnd()) {
                    return;
                }
                prevPos = this.pos;
                nextTag = readVarint32();
            } while (nextTag == this.tag);
            this.pos = prevPos;
        }

        @Override // com.android.framework.protobuf.Reader
        public void readUInt32List(List<Integer> target) throws IOException {
            int prevPos;
            int nextTag;
            int prevPos2;
            int nextTag2;
            if (target instanceof IntArrayList) {
                IntArrayList plist = (IntArrayList) target;
                switch (WireFormat.getTagWireType(this.tag)) {
                    case 0:
                        break;
                    case 1:
                    default:
                        throw InvalidProtocolBufferException.invalidWireType();
                    case 2:
                        int bytes = readVarint32();
                        int fieldEndPos = this.pos + bytes;
                        while (this.pos < fieldEndPos) {
                            plist.addInt(readVarint32());
                        }
                        return;
                }
                do {
                    plist.addInt(readUInt32());
                    if (isAtEnd()) {
                        return;
                    }
                    prevPos2 = this.pos;
                    nextTag2 = readVarint32();
                } while (nextTag2 == this.tag);
                this.pos = prevPos2;
                return;
            }
            switch (WireFormat.getTagWireType(this.tag)) {
                case 0:
                    break;
                case 1:
                default:
                    throw InvalidProtocolBufferException.invalidWireType();
                case 2:
                    int bytes2 = readVarint32();
                    int fieldEndPos2 = this.pos + bytes2;
                    while (this.pos < fieldEndPos2) {
                        target.add(Integer.valueOf(readVarint32()));
                    }
                    return;
            }
            do {
                target.add(Integer.valueOf(readUInt32()));
                if (isAtEnd()) {
                    return;
                }
                prevPos = this.pos;
                nextTag = readVarint32();
            } while (nextTag == this.tag);
            this.pos = prevPos;
        }

        @Override // com.android.framework.protobuf.Reader
        public void readEnumList(List<Integer> target) throws IOException {
            int prevPos;
            int nextTag;
            int prevPos2;
            int nextTag2;
            if (target instanceof IntArrayList) {
                IntArrayList plist = (IntArrayList) target;
                switch (WireFormat.getTagWireType(this.tag)) {
                    case 0:
                        break;
                    case 1:
                    default:
                        throw InvalidProtocolBufferException.invalidWireType();
                    case 2:
                        int bytes = readVarint32();
                        int fieldEndPos = this.pos + bytes;
                        while (this.pos < fieldEndPos) {
                            plist.addInt(readVarint32());
                        }
                        return;
                }
                do {
                    plist.addInt(readEnum());
                    if (isAtEnd()) {
                        return;
                    }
                    prevPos2 = this.pos;
                    nextTag2 = readVarint32();
                } while (nextTag2 == this.tag);
                this.pos = prevPos2;
                return;
            }
            switch (WireFormat.getTagWireType(this.tag)) {
                case 0:
                    break;
                case 1:
                default:
                    throw InvalidProtocolBufferException.invalidWireType();
                case 2:
                    int bytes2 = readVarint32();
                    int fieldEndPos2 = this.pos + bytes2;
                    while (this.pos < fieldEndPos2) {
                        target.add(Integer.valueOf(readVarint32()));
                    }
                    return;
            }
            do {
                target.add(Integer.valueOf(readEnum()));
                if (isAtEnd()) {
                    return;
                }
                prevPos = this.pos;
                nextTag = readVarint32();
            } while (nextTag == this.tag);
            this.pos = prevPos;
        }

        @Override // com.android.framework.protobuf.Reader
        public void readSFixed32List(List<Integer> target) throws IOException {
            int prevPos;
            int nextTag;
            int prevPos2;
            int nextTag2;
            if (target instanceof IntArrayList) {
                IntArrayList plist = (IntArrayList) target;
                switch (WireFormat.getTagWireType(this.tag)) {
                    case 2:
                        int bytes = readVarint32();
                        verifyPackedFixed32Length(bytes);
                        int fieldEndPos = this.pos + bytes;
                        while (this.pos < fieldEndPos) {
                            plist.addInt(readLittleEndian32_NoCheck());
                        }
                        return;
                    case 5:
                        break;
                    default:
                        throw InvalidProtocolBufferException.invalidWireType();
                }
                do {
                    plist.addInt(readSFixed32());
                    if (isAtEnd()) {
                        return;
                    }
                    prevPos2 = this.pos;
                    nextTag2 = readVarint32();
                } while (nextTag2 == this.tag);
                this.pos = prevPos2;
                return;
            }
            switch (WireFormat.getTagWireType(this.tag)) {
                case 2:
                    int bytes2 = readVarint32();
                    verifyPackedFixed32Length(bytes2);
                    int fieldEndPos2 = this.pos + bytes2;
                    while (this.pos < fieldEndPos2) {
                        target.add(Integer.valueOf(readLittleEndian32_NoCheck()));
                    }
                    return;
                case 5:
                    break;
                default:
                    throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                target.add(Integer.valueOf(readSFixed32()));
                if (isAtEnd()) {
                    return;
                }
                prevPos = this.pos;
                nextTag = readVarint32();
            } while (nextTag == this.tag);
            this.pos = prevPos;
        }

        @Override // com.android.framework.protobuf.Reader
        public void readSFixed64List(List<Long> target) throws IOException {
            int prevPos;
            int nextTag;
            int prevPos2;
            int nextTag2;
            if (target instanceof LongArrayList) {
                LongArrayList plist = (LongArrayList) target;
                switch (WireFormat.getTagWireType(this.tag)) {
                    case 1:
                        break;
                    case 2:
                        int bytes = readVarint32();
                        verifyPackedFixed64Length(bytes);
                        int fieldEndPos = this.pos + bytes;
                        while (this.pos < fieldEndPos) {
                            plist.addLong(readLittleEndian64_NoCheck());
                        }
                        return;
                    default:
                        throw InvalidProtocolBufferException.invalidWireType();
                }
                do {
                    plist.addLong(readSFixed64());
                    if (isAtEnd()) {
                        return;
                    }
                    prevPos2 = this.pos;
                    nextTag2 = readVarint32();
                } while (nextTag2 == this.tag);
                this.pos = prevPos2;
                return;
            }
            switch (WireFormat.getTagWireType(this.tag)) {
                case 1:
                    break;
                case 2:
                    int bytes2 = readVarint32();
                    verifyPackedFixed64Length(bytes2);
                    int fieldEndPos2 = this.pos + bytes2;
                    while (this.pos < fieldEndPos2) {
                        target.add(Long.valueOf(readLittleEndian64_NoCheck()));
                    }
                    return;
                default:
                    throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                target.add(Long.valueOf(readSFixed64()));
                if (isAtEnd()) {
                    return;
                }
                prevPos = this.pos;
                nextTag = readVarint32();
            } while (nextTag == this.tag);
            this.pos = prevPos;
        }

        @Override // com.android.framework.protobuf.Reader
        public void readSInt32List(List<Integer> target) throws IOException {
            int prevPos;
            int nextTag;
            int prevPos2;
            int nextTag2;
            if (target instanceof IntArrayList) {
                IntArrayList plist = (IntArrayList) target;
                switch (WireFormat.getTagWireType(this.tag)) {
                    case 0:
                        break;
                    case 1:
                    default:
                        throw InvalidProtocolBufferException.invalidWireType();
                    case 2:
                        int bytes = readVarint32();
                        int fieldEndPos = this.pos + bytes;
                        while (this.pos < fieldEndPos) {
                            plist.addInt(CodedInputStream.decodeZigZag32(readVarint32()));
                        }
                        return;
                }
                do {
                    plist.addInt(readSInt32());
                    if (isAtEnd()) {
                        return;
                    }
                    prevPos2 = this.pos;
                    nextTag2 = readVarint32();
                } while (nextTag2 == this.tag);
                this.pos = prevPos2;
                return;
            }
            switch (WireFormat.getTagWireType(this.tag)) {
                case 0:
                    break;
                case 1:
                default:
                    throw InvalidProtocolBufferException.invalidWireType();
                case 2:
                    int bytes2 = readVarint32();
                    int fieldEndPos2 = this.pos + bytes2;
                    while (this.pos < fieldEndPos2) {
                        target.add(Integer.valueOf(CodedInputStream.decodeZigZag32(readVarint32())));
                    }
                    return;
            }
            do {
                target.add(Integer.valueOf(readSInt32()));
                if (isAtEnd()) {
                    return;
                }
                prevPos = this.pos;
                nextTag = readVarint32();
            } while (nextTag == this.tag);
            this.pos = prevPos;
        }

        @Override // com.android.framework.protobuf.Reader
        public void readSInt64List(List<Long> target) throws IOException {
            int prevPos;
            int nextTag;
            int prevPos2;
            int nextTag2;
            if (target instanceof LongArrayList) {
                LongArrayList plist = (LongArrayList) target;
                switch (WireFormat.getTagWireType(this.tag)) {
                    case 0:
                        break;
                    case 1:
                    default:
                        throw InvalidProtocolBufferException.invalidWireType();
                    case 2:
                        int bytes = readVarint32();
                        int fieldEndPos = this.pos + bytes;
                        while (this.pos < fieldEndPos) {
                            plist.addLong(CodedInputStream.decodeZigZag64(readVarint64()));
                        }
                        return;
                }
                do {
                    plist.addLong(readSInt64());
                    if (isAtEnd()) {
                        return;
                    }
                    prevPos2 = this.pos;
                    nextTag2 = readVarint32();
                } while (nextTag2 == this.tag);
                this.pos = prevPos2;
                return;
            }
            switch (WireFormat.getTagWireType(this.tag)) {
                case 0:
                    break;
                case 1:
                default:
                    throw InvalidProtocolBufferException.invalidWireType();
                case 2:
                    int bytes2 = readVarint32();
                    int fieldEndPos2 = this.pos + bytes2;
                    while (this.pos < fieldEndPos2) {
                        target.add(Long.valueOf(CodedInputStream.decodeZigZag64(readVarint64())));
                    }
                    return;
            }
            do {
                target.add(Long.valueOf(readSInt64()));
                if (isAtEnd()) {
                    return;
                }
                prevPos = this.pos;
                nextTag = readVarint32();
            } while (nextTag == this.tag);
            this.pos = prevPos;
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:7:0x002a. Please report as an issue. */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.android.framework.protobuf.Reader
        public <K, V> void readMap(Map<K, V> map, MapEntryLite.Metadata<K, V> metadata, ExtensionRegistryLite extensionRegistry) throws IOException {
            requireWireType(2);
            int size = readVarint32();
            requireBytes(size);
            int prevLimit = this.limit;
            int newLimit = this.pos + size;
            this.limit = newLimit;
            try {
                Object obj = metadata.defaultKey;
                Object obj2 = metadata.defaultValue;
                while (true) {
                    int number = getFieldNumber();
                    if (number != Integer.MAX_VALUE) {
                        switch (number) {
                            case 1:
                                obj = readField(metadata.keyType, null, null);
                            case 2:
                                obj2 = readField(metadata.valueType, metadata.defaultValue.getClass(), extensionRegistry);
                            default:
                                try {
                                    if (!skipField()) {
                                        throw new InvalidProtocolBufferException("Unable to parse map entry.");
                                        break;
                                    }
                                } catch (InvalidProtocolBufferException.InvalidWireTypeException e2) {
                                    if (!skipField()) {
                                        throw new InvalidProtocolBufferException("Unable to parse map entry.");
                                    }
                                }
                        }
                    } else {
                        map.put(obj, obj2);
                        return;
                    }
                }
            } finally {
                this.limit = prevLimit;
            }
        }

        private Object readField(WireFormat.FieldType fieldType, Class<?> messageType, ExtensionRegistryLite extensionRegistry) throws IOException {
            switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldType.ordinal()]) {
                case 1:
                    return Boolean.valueOf(readBool());
                case 2:
                    return readBytes();
                case 3:
                    return Double.valueOf(readDouble());
                case 4:
                    return Integer.valueOf(readEnum());
                case 5:
                    return Integer.valueOf(readFixed32());
                case 6:
                    return Long.valueOf(readFixed64());
                case 7:
                    return Float.valueOf(readFloat());
                case 8:
                    return Integer.valueOf(readInt32());
                case 9:
                    return Long.valueOf(readInt64());
                case 10:
                    return readMessage(messageType, extensionRegistry);
                case 11:
                    return Integer.valueOf(readSFixed32());
                case 12:
                    return Long.valueOf(readSFixed64());
                case 13:
                    return Integer.valueOf(readSInt32());
                case 14:
                    return Long.valueOf(readSInt64());
                case 15:
                    return readStringRequireUtf8();
                case 16:
                    return Integer.valueOf(readUInt32());
                case 17:
                    return Long.valueOf(readUInt64());
                default:
                    throw new RuntimeException("unsupported field type.");
            }
        }

        private int readVarint32() throws IOException {
            int i10;
            int i11 = this.pos;
            int i12 = this.limit;
            if (i12 == this.pos) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            byte[] bArr = this.buffer;
            int i13 = i11 + 1;
            int x10 = bArr[i11];
            if (x10 >= 0) {
                this.pos = i13;
                return x10;
            }
            if (i12 - i13 < 9) {
                return (int) readVarint64SlowPath();
            }
            int i14 = i13 + 1;
            int x11 = (bArr[i13] << 7) ^ x10;
            if (x11 < 0) {
                i10 = x11 ^ (-128);
            } else {
                int x12 = i14 + 1;
                int x13 = (bArr[i14] << 14) ^ x11;
                if (x13 >= 0) {
                    i10 = x13 ^ 16256;
                    i14 = x12;
                } else {
                    i14 = x12 + 1;
                    int x14 = (bArr[x12] << 21) ^ x13;
                    if (x14 < 0) {
                        i10 = (-2080896) ^ x14;
                    } else {
                        int i15 = i14 + 1;
                        int y10 = bArr[i14];
                        int x15 = (x14 ^ (y10 << 28)) ^ 266354560;
                        if (y10 < 0) {
                            int i16 = i15 + 1;
                            if (bArr[i15] < 0) {
                                i15 = i16 + 1;
                                if (bArr[i16] < 0) {
                                    i16 = i15 + 1;
                                    if (bArr[i15] < 0) {
                                        i15 = i16 + 1;
                                        if (bArr[i16] < 0) {
                                            i16 = i15 + 1;
                                            if (bArr[i15] < 0) {
                                                throw InvalidProtocolBufferException.malformedVarint();
                                            }
                                        }
                                    }
                                }
                            }
                            i10 = x15;
                            i14 = i16;
                        }
                        i14 = i15;
                        i10 = x15;
                    }
                }
            }
            this.pos = i14;
            return i10;
        }

        public long readVarint64() throws IOException {
            long x10;
            int i10 = this.pos;
            int i11 = this.limit;
            if (i11 == i10) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            byte[] buffer = this.buffer;
            int i12 = i10 + 1;
            int y10 = buffer[i10];
            if (y10 >= 0) {
                this.pos = i12;
                return y10;
            }
            if (i11 - i12 < 9) {
                return readVarint64SlowPath();
            }
            int i13 = i12 + 1;
            int y11 = (buffer[i12] << 7) ^ y10;
            if (y11 < 0) {
                x10 = y11 ^ (-128);
            } else {
                int i14 = i13 + 1;
                int y12 = (buffer[i13] << 14) ^ y11;
                if (y12 >= 0) {
                    x10 = y12 ^ 16256;
                    i13 = i14;
                } else {
                    i13 = i14 + 1;
                    int y13 = (buffer[i14] << 21) ^ y12;
                    if (y13 < 0) {
                        x10 = (-2080896) ^ y13;
                    } else {
                        long x11 = y13;
                        int i15 = i13 + 1;
                        long x12 = x11 ^ (buffer[i13] << 28);
                        if (x12 >= 0) {
                            x10 = 266354560 ^ x12;
                            i13 = i15;
                        } else {
                            i13 = i15 + 1;
                            long x13 = (buffer[i15] << 35) ^ x12;
                            if (x13 < 0) {
                                x10 = (-34093383808L) ^ x13;
                            } else {
                                int i16 = i13 + 1;
                                long x14 = (buffer[i13] << 42) ^ x13;
                                if (x14 >= 0) {
                                    x10 = 4363953127296L ^ x14;
                                    i13 = i16;
                                } else {
                                    i13 = i16 + 1;
                                    long x15 = (buffer[i16] << 49) ^ x14;
                                    if (x15 < 0) {
                                        x10 = (-558586000294016L) ^ x15;
                                    } else {
                                        int i17 = i13 + 1;
                                        x10 = ((buffer[i13] << 56) ^ x15) ^ 71499008037633920L;
                                        if (x10 >= 0) {
                                            i13 = i17;
                                        } else {
                                            i13 = i17 + 1;
                                            if (buffer[i17] < 0) {
                                                throw InvalidProtocolBufferException.malformedVarint();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            this.pos = i13;
            return x10;
        }

        private long readVarint64SlowPath() throws IOException {
            long result = 0;
            for (int shift = 0; shift < 64; shift += 7) {
                byte b4 = readByte();
                result |= (b4 & Byte.MAX_VALUE) << shift;
                if ((b4 & 128) == 0) {
                    return result;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private byte readByte() throws IOException {
            int i10 = this.pos;
            if (i10 == this.limit) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            byte[] bArr = this.buffer;
            this.pos = i10 + 1;
            return bArr[i10];
        }

        private int readLittleEndian32() throws IOException {
            requireBytes(4);
            return readLittleEndian32_NoCheck();
        }

        private long readLittleEndian64() throws IOException {
            requireBytes(8);
            return readLittleEndian64_NoCheck();
        }

        private int readLittleEndian32_NoCheck() {
            int p10 = this.pos;
            byte[] buffer = this.buffer;
            this.pos = p10 + 4;
            return (buffer[p10] & 255) | ((buffer[p10 + 1] & 255) << 8) | ((buffer[p10 + 2] & 255) << 16) | ((buffer[p10 + 3] & 255) << 24);
        }

        private long readLittleEndian64_NoCheck() {
            int p10 = this.pos;
            byte[] buffer = this.buffer;
            this.pos = p10 + 8;
            return (buffer[p10] & 255) | ((buffer[p10 + 1] & 255) << 8) | ((buffer[p10 + 2] & 255) << 16) | ((buffer[p10 + 3] & 255) << 24) | ((buffer[p10 + 4] & 255) << 32) | ((buffer[p10 + 5] & 255) << 40) | ((buffer[p10 + 6] & 255) << 48) | ((255 & buffer[p10 + 7]) << 56);
        }

        private void skipVarint() throws IOException {
            if (this.limit - this.pos >= 10) {
                byte[] buffer = this.buffer;
                int p10 = this.pos;
                int i10 = 0;
                while (i10 < 10) {
                    int p11 = p10 + 1;
                    if (buffer[p10] < 0) {
                        i10++;
                        p10 = p11;
                    } else {
                        this.pos = p11;
                        return;
                    }
                }
            }
            skipVarintSlowPath();
        }

        private void skipVarintSlowPath() throws IOException {
            for (int i10 = 0; i10 < 10; i10++) {
                if (readByte() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void skipBytes(int size) throws IOException {
            requireBytes(size);
            this.pos += size;
        }

        private void skipGroup() throws IOException {
            int prevEndGroupTag = this.endGroupTag;
            this.endGroupTag = WireFormat.makeTag(WireFormat.getTagFieldNumber(this.tag), 4);
            while (getFieldNumber() != Integer.MAX_VALUE && skipField()) {
            }
            if (this.tag != this.endGroupTag) {
                throw InvalidProtocolBufferException.parseFailure();
            }
            this.endGroupTag = prevEndGroupTag;
        }

        private void requireBytes(int size) throws IOException {
            if (size < 0 || size > this.limit - this.pos) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }

        private void requireWireType(int requiredWireType) throws IOException {
            if (WireFormat.getTagWireType(this.tag) != requiredWireType) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }

        private void verifyPackedFixed64Length(int bytes) throws IOException {
            requireBytes(bytes);
            if ((bytes & 7) != 0) {
                throw InvalidProtocolBufferException.parseFailure();
            }
        }

        private void verifyPackedFixed32Length(int bytes) throws IOException {
            requireBytes(bytes);
            if ((bytes & 3) != 0) {
                throw InvalidProtocolBufferException.parseFailure();
            }
        }

        private void requirePosition(int expectedPosition) throws IOException {
            if (this.pos != expectedPosition) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
    /* renamed from: com.android.framework.protobuf.BinaryReader$1, reason: invalid class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = iArr;
            try {
                iArr[WireFormat.FieldType.BOOL.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.BYTES.ordinal()] = 2;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.DOUBLE.ordinal()] = 3;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.ENUM.ordinal()] = 4;
            } catch (NoSuchFieldError e12) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED32.ordinal()] = 5;
            } catch (NoSuchFieldError e13) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError e14) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FLOAT.ordinal()] = 7;
            } catch (NoSuchFieldError e15) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT32.ordinal()] = 8;
            } catch (NoSuchFieldError e16) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT64.ordinal()] = 9;
            } catch (NoSuchFieldError e17) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.MESSAGE.ordinal()] = 10;
            } catch (NoSuchFieldError e18) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 11;
            } catch (NoSuchFieldError e19) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 12;
            } catch (NoSuchFieldError e20) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT32.ordinal()] = 13;
            } catch (NoSuchFieldError e21) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT64.ordinal()] = 14;
            } catch (NoSuchFieldError e22) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.STRING.ordinal()] = 15;
            } catch (NoSuchFieldError e23) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT32.ordinal()] = 16;
            } catch (NoSuchFieldError e24) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT64.ordinal()] = 17;
            } catch (NoSuchFieldError e25) {
            }
        }
    }
}
