package io.grpc;

import com.google.common.base.i;
import com.google.common.base.o;
import io.grpc.Codec;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang3.CharEncoding;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/1704")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class DecompressorRegistry {
    public static final i ACCEPT_ENCODING_JOINER = i.g(',');
    private static final DecompressorRegistry DEFAULT_INSTANCE = emptyInstance().with(new Codec.Gzip(), true).with(Codec.Identity.NONE, false);
    private final byte[] advertisedDecompressors;
    private final Map<String, DecompressorInfo> decompressors;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class DecompressorInfo {
        public final boolean advertised;
        public final Decompressor decompressor;

        public DecompressorInfo(Decompressor decompressor, boolean z10) {
            this.decompressor = (Decompressor) o.s(decompressor, "decompressor");
            this.advertised = z10;
        }
    }

    private DecompressorRegistry(Decompressor decompressor, boolean z10, DecompressorRegistry decompressorRegistry) {
        String messageEncoding = decompressor.getMessageEncoding();
        o.e(!messageEncoding.contains(","), "Comma is currently not allowed in message encoding");
        int size = decompressorRegistry.decompressors.size();
        LinkedHashMap linkedHashMap = new LinkedHashMap(decompressorRegistry.decompressors.containsKey(decompressor.getMessageEncoding()) ? size : size + 1);
        for (DecompressorInfo decompressorInfo : decompressorRegistry.decompressors.values()) {
            String messageEncoding2 = decompressorInfo.decompressor.getMessageEncoding();
            if (!messageEncoding2.equals(messageEncoding)) {
                linkedHashMap.put(messageEncoding2, new DecompressorInfo(decompressorInfo.decompressor, decompressorInfo.advertised));
            }
        }
        linkedHashMap.put(messageEncoding, new DecompressorInfo(decompressor, z10));
        this.decompressors = Collections.unmodifiableMap(linkedHashMap);
        this.advertisedDecompressors = ACCEPT_ENCODING_JOINER.d(getAdvertisedMessageEncodings()).getBytes(Charset.forName(CharEncoding.US_ASCII));
    }

    public static DecompressorRegistry emptyInstance() {
        return new DecompressorRegistry();
    }

    public static DecompressorRegistry getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/1704")
    public Set<String> getAdvertisedMessageEncodings() {
        HashSet hashSet = new HashSet(this.decompressors.size());
        for (Map.Entry<String, DecompressorInfo> entry : this.decompressors.entrySet()) {
            if (entry.getValue().advertised) {
                hashSet.add(entry.getKey());
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    public Set<String> getKnownMessageEncodings() {
        return this.decompressors.keySet();
    }

    public byte[] getRawAdvertisedMessageEncodings() {
        return this.advertisedDecompressors;
    }

    public Decompressor lookupDecompressor(String str) {
        DecompressorInfo decompressorInfo = this.decompressors.get(str);
        if (decompressorInfo != null) {
            return decompressorInfo.decompressor;
        }
        return null;
    }

    public DecompressorRegistry with(Decompressor decompressor, boolean z10) {
        return new DecompressorRegistry(decompressor, z10, this);
    }

    private DecompressorRegistry() {
        this.decompressors = new LinkedHashMap(0);
        this.advertisedDecompressors = new byte[0];
    }
}
