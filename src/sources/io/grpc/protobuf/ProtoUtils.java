package io.grpc.protobuf;

import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.Message;
import io.grpc.ExperimentalApi;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.protobuf.lite.ProtoLiteUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class ProtoUtils {
    private ProtoUtils() {
    }

    public static <T extends Message> Metadata.Key<T> keyForProto(T t2) {
        return Metadata.Key.of(t2.getDescriptorForType().getFullName() + Metadata.BINARY_HEADER_SUFFIX, metadataMarshaller(t2));
    }

    public static <T extends Message> MethodDescriptor.Marshaller<T> marshaller(T t2) {
        return ProtoLiteUtils.marshaller(t2);
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/4477")
    public static <T extends Message> Metadata.BinaryMarshaller<T> metadataMarshaller(T t2) {
        return ProtoLiteUtils.metadataMarshaller(t2);
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1787")
    public static void setExtensionRegistry(ExtensionRegistry extensionRegistry) {
        ProtoLiteUtils.setExtensionRegistry(extensionRegistry);
    }
}
