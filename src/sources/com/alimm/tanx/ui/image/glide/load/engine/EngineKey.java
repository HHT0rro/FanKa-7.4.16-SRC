package com.alimm.tanx.ui.image.glide.load.engine;

import com.alimm.tanx.ui.image.glide.load.Encoder;
import com.alimm.tanx.ui.image.glide.load.Key;
import com.alimm.tanx.ui.image.glide.load.ResourceDecoder;
import com.alimm.tanx.ui.image.glide.load.ResourceEncoder;
import com.alimm.tanx.ui.image.glide.load.Transformation;
import com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.Locale;
import nd.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class EngineKey implements Key {
    public static final String EMPTY_LOG_STRING = "";
    public final ResourceDecoder cacheDecoder;
    public final ResourceDecoder decoder;
    public final ResourceEncoder encoder;
    public int hashCode;
    public final int height;

    /* renamed from: id, reason: collision with root package name */
    public final String f4192id;
    public Key originalKey;
    public final Key signature;
    public final Encoder sourceEncoder;
    public String stringKey;
    public final ResourceTranscoder transcoder;
    public final Transformation transformation;
    public final int width;

    public EngineKey(String str, Key key, int i10, int i11, ResourceDecoder resourceDecoder, ResourceDecoder resourceDecoder2, Transformation transformation, ResourceEncoder resourceEncoder, ResourceTranscoder resourceTranscoder, Encoder encoder) {
        this.f4192id = str;
        this.signature = key;
        this.width = i10;
        this.height = i11;
        this.cacheDecoder = resourceDecoder;
        this.decoder = resourceDecoder2;
        this.transformation = transformation;
        this.encoder = resourceEncoder;
        this.transcoder = resourceTranscoder;
        this.sourceEncoder = encoder;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Key
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || EngineKey.class != obj.getClass()) {
            return false;
        }
        EngineKey engineKey = (EngineKey) obj;
        if (!this.f4192id.equals(engineKey.f4192id) || !this.signature.equals(engineKey.signature) || this.height != engineKey.height || this.width != engineKey.width) {
            return false;
        }
        Transformation transformation = this.transformation;
        if ((transformation == null) ^ (engineKey.transformation == null)) {
            return false;
        }
        if (transformation != null && !transformation.getId().equals(engineKey.transformation.getId())) {
            return false;
        }
        ResourceDecoder resourceDecoder = this.decoder;
        if ((resourceDecoder == null) ^ (engineKey.decoder == null)) {
            return false;
        }
        if (resourceDecoder != null && !resourceDecoder.getId().equals(engineKey.decoder.getId())) {
            return false;
        }
        ResourceDecoder resourceDecoder2 = this.cacheDecoder;
        if ((resourceDecoder2 == null) ^ (engineKey.cacheDecoder == null)) {
            return false;
        }
        if (resourceDecoder2 != null && !resourceDecoder2.getId().equals(engineKey.cacheDecoder.getId())) {
            return false;
        }
        ResourceEncoder resourceEncoder = this.encoder;
        if ((resourceEncoder == null) ^ (engineKey.encoder == null)) {
            return false;
        }
        if (resourceEncoder != null && !resourceEncoder.getId().equals(engineKey.encoder.getId())) {
            return false;
        }
        ResourceTranscoder resourceTranscoder = this.transcoder;
        if ((resourceTranscoder == null) ^ (engineKey.transcoder == null)) {
            return false;
        }
        if (resourceTranscoder != null && !resourceTranscoder.getId().equals(engineKey.transcoder.getId())) {
            return false;
        }
        Encoder encoder = this.sourceEncoder;
        if ((encoder == null) ^ (engineKey.sourceEncoder == null)) {
            return false;
        }
        return encoder == null || encoder.getId().equals(engineKey.sourceEncoder.getId());
    }

    public Key getOriginalKey() {
        if (this.originalKey == null) {
            this.originalKey = new OriginalKey(this.f4192id, this.signature);
        }
        return this.originalKey;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Key
    public int hashCode() {
        if (this.hashCode == 0) {
            int hashCode = this.f4192id.hashCode();
            this.hashCode = hashCode;
            int hashCode2 = ((((this.signature.hashCode() + (hashCode * 31)) * 31) + this.width) * 31) + this.height;
            this.hashCode = hashCode2;
            int i10 = hashCode2 * 31;
            ResourceDecoder resourceDecoder = this.cacheDecoder;
            int hashCode3 = i10 + (resourceDecoder != null ? resourceDecoder.getId().hashCode() : 0);
            this.hashCode = hashCode3;
            int i11 = hashCode3 * 31;
            ResourceDecoder resourceDecoder2 = this.decoder;
            int hashCode4 = i11 + (resourceDecoder2 != null ? resourceDecoder2.getId().hashCode() : 0);
            this.hashCode = hashCode4;
            int i12 = hashCode4 * 31;
            Transformation transformation = this.transformation;
            int hashCode5 = i12 + (transformation != null ? transformation.getId().hashCode() : 0);
            this.hashCode = hashCode5;
            int i13 = hashCode5 * 31;
            ResourceEncoder resourceEncoder = this.encoder;
            int hashCode6 = i13 + (resourceEncoder != null ? resourceEncoder.getId().hashCode() : 0);
            this.hashCode = hashCode6;
            int i14 = hashCode6 * 31;
            ResourceTranscoder resourceTranscoder = this.transcoder;
            int hashCode7 = i14 + (resourceTranscoder != null ? resourceTranscoder.getId().hashCode() : 0);
            this.hashCode = hashCode7;
            int i15 = hashCode7 * 31;
            Encoder encoder = this.sourceEncoder;
            this.hashCode = i15 + (encoder != null ? encoder.getId().hashCode() : 0);
        }
        return this.hashCode;
    }

    public String toString() {
        if (this.stringKey == null) {
            StringBuilder a10 = a.a("EngineKey{");
            a10.append(this.f4192id);
            a10.append('+');
            a10.append((Object) this.signature);
            a10.append("+[");
            a10.append(this.width);
            a10.append(Locale.PRIVATE_USE_EXTENSION);
            a10.append(this.height);
            a10.append("]+");
            a10.append('\'');
            ResourceDecoder resourceDecoder = this.cacheDecoder;
            a10.append(resourceDecoder != null ? resourceDecoder.getId() : EMPTY_LOG_STRING);
            a10.append('\'');
            a10.append('+');
            a10.append('\'');
            ResourceDecoder resourceDecoder2 = this.decoder;
            a10.append(resourceDecoder2 != null ? resourceDecoder2.getId() : EMPTY_LOG_STRING);
            a10.append('\'');
            a10.append('+');
            a10.append('\'');
            Transformation transformation = this.transformation;
            a10.append(transformation != null ? transformation.getId() : EMPTY_LOG_STRING);
            a10.append('\'');
            a10.append('+');
            a10.append('\'');
            ResourceEncoder resourceEncoder = this.encoder;
            a10.append(resourceEncoder != null ? resourceEncoder.getId() : EMPTY_LOG_STRING);
            a10.append('\'');
            a10.append('+');
            a10.append('\'');
            ResourceTranscoder resourceTranscoder = this.transcoder;
            a10.append(resourceTranscoder != null ? resourceTranscoder.getId() : EMPTY_LOG_STRING);
            a10.append('\'');
            a10.append('+');
            a10.append('\'');
            Encoder encoder = this.sourceEncoder;
            a10.append(encoder != null ? encoder.getId() : EMPTY_LOG_STRING);
            a10.append('\'');
            a10.append('}');
            this.stringKey = a10.toString();
        }
        return this.stringKey;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Key
    public void updateDiskCacheKey(MessageDigest messageDigest) throws UnsupportedEncodingException {
        byte[] array = ByteBuffer.allocate(8).putInt(this.width).putInt(this.height).array();
        this.signature.updateDiskCacheKey(messageDigest);
        messageDigest.update(this.f4192id.getBytes("UTF-8"));
        messageDigest.update(array);
        ResourceDecoder resourceDecoder = this.cacheDecoder;
        messageDigest.update((resourceDecoder != null ? resourceDecoder.getId() : "").getBytes("UTF-8"));
        ResourceDecoder resourceDecoder2 = this.decoder;
        messageDigest.update((resourceDecoder2 != null ? resourceDecoder2.getId() : "").getBytes("UTF-8"));
        Transformation transformation = this.transformation;
        messageDigest.update((transformation != null ? transformation.getId() : "").getBytes("UTF-8"));
        ResourceEncoder resourceEncoder = this.encoder;
        messageDigest.update((resourceEncoder != null ? resourceEncoder.getId() : "").getBytes("UTF-8"));
        Encoder encoder = this.sourceEncoder;
        messageDigest.update((encoder != null ? encoder.getId() : "").getBytes("UTF-8"));
    }
}
