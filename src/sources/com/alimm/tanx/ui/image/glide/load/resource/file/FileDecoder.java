package com.alimm.tanx.ui.image.glide.load.resource.file;

import com.alimm.tanx.ui.image.glide.load.ResourceDecoder;
import com.alimm.tanx.ui.image.glide.load.engine.Resource;
import java.io.File;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class FileDecoder implements ResourceDecoder<File, File> {
    @Override // com.alimm.tanx.ui.image.glide.load.ResourceDecoder
    public String getId() {
        return "";
    }

    @Override // com.alimm.tanx.ui.image.glide.load.ResourceDecoder
    public Resource<File> decode(File file, int i10, int i11) {
        return new FileResource(file);
    }
}
