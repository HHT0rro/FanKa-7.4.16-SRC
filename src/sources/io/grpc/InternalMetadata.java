package io.grpc;

import com.google.common.io.BaseEncoding;
import io.grpc.Metadata;
import java.nio.charset.Charset;
import org.apache.commons.lang3.CharEncoding;

@Internal
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class InternalMetadata {

    @Internal
    public static final Charset US_ASCII = Charset.forName(CharEncoding.US_ASCII);

    @Internal
    public static final BaseEncoding BASE64_ENCODING_OMIT_PADDING = Metadata.BASE64_ENCODING_OMIT_PADDING;

    @Internal
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public interface TrustedAsciiMarshaller<T> extends Metadata.TrustedAsciiMarshaller<T> {
    }

    @Internal
    public static int headerCount(Metadata metadata) {
        return metadata.headerCount();
    }

    @Internal
    public static <T> Metadata.Key<T> keyOf(String str, TrustedAsciiMarshaller<T> trustedAsciiMarshaller) {
        boolean z10 = false;
        if (str != null && !str.isEmpty() && str.charAt(0) == ':') {
            z10 = true;
        }
        return Metadata.Key.of(str, z10, trustedAsciiMarshaller);
    }

    @Internal
    public static Metadata newMetadata(byte[]... bArr) {
        return new Metadata(bArr);
    }

    @Internal
    public static Metadata newMetadataWithParsedValues(int i10, Object[] objArr) {
        return new Metadata(i10, objArr);
    }

    @Internal
    public static <T> Object parsedValue(Metadata.BinaryStreamMarshaller<T> binaryStreamMarshaller, T t2) {
        return new Metadata.LazyValue(binaryStreamMarshaller, t2);
    }

    @Internal
    public static byte[][] serialize(Metadata metadata) {
        return metadata.serialize();
    }

    @Internal
    public static Object[] serializePartial(Metadata metadata) {
        return metadata.serializePartial();
    }

    @Internal
    public static Metadata newMetadata(int i10, byte[]... bArr) {
        return new Metadata(i10, bArr);
    }

    @Internal
    public static <T> Metadata.Key<T> keyOf(String str, Metadata.AsciiMarshaller<T> asciiMarshaller) {
        boolean z10 = false;
        if (str != null && !str.isEmpty() && str.charAt(0) == ':') {
            z10 = true;
        }
        return Metadata.Key.of(str, z10, asciiMarshaller);
    }
}
