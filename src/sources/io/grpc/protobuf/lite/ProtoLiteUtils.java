package io.grpc.protobuf.lite;

import com.google.common.base.o;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import io.grpc.ExperimentalApi;
import io.grpc.KnownLength;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

@ExperimentalApi("Experimental until Lite is stable in protobuf")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class ProtoLiteUtils {
    private static final int BUF_SIZE = 8192;
    public static final int DEFAULT_MAX_MESSAGE_SIZE = 4194304;
    public static volatile ExtensionRegistryLite globalRegistry = ExtensionRegistryLite.getEmptyRegistry();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class MessageMarshaller<T extends MessageLite> implements MethodDescriptor.PrototypeMarshaller<T> {
        private static final ThreadLocal<Reference<byte[]>> bufs = new ThreadLocal<>();
        private final T defaultInstance;
        private final Parser<T> parser;

        public MessageMarshaller(T t2) {
            this.defaultInstance = t2;
            this.parser = (Parser<T>) t2.getParserForType();
        }

        private T parseFrom(CodedInputStream codedInputStream) throws InvalidProtocolBufferException {
            T parseFrom = this.parser.parseFrom(codedInputStream, ProtoLiteUtils.globalRegistry);
            try {
                codedInputStream.checkLastTagWas(0);
                return parseFrom;
            } catch (InvalidProtocolBufferException e2) {
                e2.setUnfinishedMessage(parseFrom);
                throw e2;
            }
        }

        @Override // io.grpc.MethodDescriptor.ReflectableMarshaller
        public Class<T> getMessageClass() {
            return (Class<T>) this.defaultInstance.getClass();
        }

        @Override // io.grpc.MethodDescriptor.PrototypeMarshaller
        public T getMessagePrototype() {
            return this.defaultInstance;
        }

        @Override // io.grpc.MethodDescriptor.Marshaller
        public T parse(InputStream inputStream) {
            byte[] bArr;
            if ((inputStream instanceof ProtoInputStream) && ((ProtoInputStream) inputStream).parser() == this.parser) {
                try {
                    return (T) ((ProtoInputStream) inputStream).message();
                } catch (IllegalStateException unused) {
                }
            }
            CodedInputStream codedInputStream = null;
            try {
                if (inputStream instanceof KnownLength) {
                    int available = inputStream.available();
                    if (available > 0 && available <= 4194304) {
                        ThreadLocal<Reference<byte[]>> threadLocal = bufs;
                        Reference<byte[]> reference = threadLocal.get();
                        if (reference == null || (bArr = reference.get()) == null || bArr.length < available) {
                            bArr = new byte[available];
                            threadLocal.set(new WeakReference(bArr));
                        }
                        int i10 = available;
                        while (i10 > 0) {
                            int read = inputStream.read(bArr, available - i10, i10);
                            if (read == -1) {
                                break;
                            }
                            i10 -= read;
                        }
                        if (i10 == 0) {
                            codedInputStream = CodedInputStream.newInstance(bArr, 0, available);
                        } else {
                            throw new RuntimeException("size inaccurate: " + available + " != " + (available - i10));
                        }
                    } else if (available == 0) {
                        return this.defaultInstance;
                    }
                }
                if (codedInputStream == null) {
                    codedInputStream = CodedInputStream.newInstance(inputStream);
                }
                codedInputStream.setSizeLimit(Integer.MAX_VALUE);
                try {
                    return parseFrom(codedInputStream);
                } catch (InvalidProtocolBufferException e2) {
                    throw Status.INTERNAL.withDescription("Invalid protobuf byte sequence").withCause(e2).asRuntimeException();
                }
            } catch (IOException e10) {
                throw new RuntimeException(e10);
            }
        }

        @Override // io.grpc.MethodDescriptor.Marshaller
        public InputStream stream(T t2) {
            return new ProtoInputStream(t2, this.parser);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class MetadataMarshaller<T extends MessageLite> implements Metadata.BinaryMarshaller<T> {
        private final T defaultInstance;

        public MetadataMarshaller(T t2) {
            this.defaultInstance = t2;
        }

        @Override // io.grpc.Metadata.BinaryMarshaller
        public T parseBytes(byte[] bArr) {
            try {
                return (T) this.defaultInstance.getParserForType().parseFrom(bArr, ProtoLiteUtils.globalRegistry);
            } catch (InvalidProtocolBufferException e2) {
                throw new IllegalArgumentException(e2);
            }
        }

        @Override // io.grpc.Metadata.BinaryMarshaller
        public byte[] toBytes(T t2) {
            return t2.toByteArray();
        }
    }

    private ProtoLiteUtils() {
    }

    public static long copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        o.s(inputStream, "inputStream cannot be null!");
        o.s(outputStream, "outputStream cannot be null!");
        byte[] bArr = new byte[8192];
        long j10 = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return j10;
            }
            outputStream.write(bArr, 0, read);
            j10 += read;
        }
    }

    public static <T extends MessageLite> MethodDescriptor.Marshaller<T> marshaller(T t2) {
        return new MessageMarshaller(t2);
    }

    public static <T extends MessageLite> Metadata.BinaryMarshaller<T> metadataMarshaller(T t2) {
        return new MetadataMarshaller(t2);
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1787")
    public static void setExtensionRegistry(ExtensionRegistryLite extensionRegistryLite) {
        globalRegistry = (ExtensionRegistryLite) o.s(extensionRegistryLite, "newRegistry");
    }
}
