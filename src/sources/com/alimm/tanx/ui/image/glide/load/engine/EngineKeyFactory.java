package com.alimm.tanx.ui.image.glide.load.engine;

import com.alimm.tanx.ui.image.glide.load.Encoder;
import com.alimm.tanx.ui.image.glide.load.Key;
import com.alimm.tanx.ui.image.glide.load.ResourceDecoder;
import com.alimm.tanx.ui.image.glide.load.ResourceEncoder;
import com.alimm.tanx.ui.image.glide.load.Transformation;
import com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class EngineKeyFactory {
    public EngineKey buildKey(String str, Key key, int i10, int i11, ResourceDecoder resourceDecoder, ResourceDecoder resourceDecoder2, Transformation transformation, ResourceEncoder resourceEncoder, ResourceTranscoder resourceTranscoder, Encoder encoder) {
        return new EngineKey(str, key, i10, i11, resourceDecoder, resourceDecoder2, transformation, resourceEncoder, resourceTranscoder, encoder);
    }
}
