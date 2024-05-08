package com.android.framework.protobuf.nano;

import java.io.IOException;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public abstract class MessageNano {
    protected volatile int cachedSize = -1;

    public abstract MessageNano mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException;

    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public int getSerializedSize() {
        int size = computeSerializedSize();
        this.cachedSize = size;
        return size;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int computeSerializedSize() {
        return 0;
    }

    public void writeTo(CodedOutputByteBufferNano output) throws IOException {
    }

    public static final byte[] toByteArray(MessageNano msg) {
        byte[] result = new byte[msg.getSerializedSize()];
        toByteArray(msg, result, 0, result.length);
        return result;
    }

    public static final void toByteArray(MessageNano msg, byte[] data, int offset, int length) {
        try {
            CodedOutputByteBufferNano output = CodedOutputByteBufferNano.newInstance(data, offset, length);
            msg.writeTo(output);
            output.checkNoSpaceLeft();
        } catch (IOException e2) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e2);
        }
    }

    public static final <T extends MessageNano> T mergeFrom(T t2, byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (T) mergeFrom(t2, bArr, 0, bArr.length);
    }

    public static final <T extends MessageNano> T mergeFrom(T msg, byte[] data, int off, int len) throws InvalidProtocolBufferNanoException {
        try {
            CodedInputByteBufferNano input = CodedInputByteBufferNano.newInstance(data, off, len);
            msg.mergeFrom(input);
            input.checkLastTagWas(0);
            return msg;
        } catch (InvalidProtocolBufferNanoException e2) {
            throw e2;
        } catch (IOException e10) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
    }

    public static final boolean messageNanoEquals(MessageNano a10, MessageNano b4) {
        int serializedSize;
        if (a10 == b4) {
            return true;
        }
        if (a10 == null || b4 == null || a10.getClass() != b4.getClass() || b4.getSerializedSize() != (serializedSize = a10.getSerializedSize())) {
            return false;
        }
        byte[] aByteArray = new byte[serializedSize];
        byte[] bByteArray = new byte[serializedSize];
        toByteArray(a10, aByteArray, 0, serializedSize);
        toByteArray(b4, bByteArray, 0, serializedSize);
        return Arrays.equals(aByteArray, bByteArray);
    }

    public String toString() {
        return MessageNanoPrinter.print(this);
    }

    @Override // 
    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public MessageNano mo1998clone() throws CloneNotSupportedException {
        return (MessageNano) super.clone();
    }
}
