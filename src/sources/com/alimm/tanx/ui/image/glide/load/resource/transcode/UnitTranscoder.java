package com.alimm.tanx.ui.image.glide.load.resource.transcode;

import com.alimm.tanx.ui.image.glide.load.engine.Resource;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class UnitTranscoder<Z> implements ResourceTranscoder<Z, Z> {
    public static final UnitTranscoder<?> UNIT_TRANSCODER = new UnitTranscoder<>();

    public static <Z> ResourceTranscoder<Z, Z> get() {
        return UNIT_TRANSCODER;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder
    public String getId() {
        return "";
    }

    @Override // com.alimm.tanx.ui.image.glide.load.resource.transcode.ResourceTranscoder
    public Resource<Z> transcode(Resource<Z> resource) {
        return resource;
    }
}
