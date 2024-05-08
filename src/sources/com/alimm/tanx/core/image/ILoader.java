package com.alimm.tanx.core.image;

import com.alimm.tanx.core.image.util.GifConfig;
import com.alimm.tanx.core.image.util.ImageConfig;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface ILoader {
    void load(ImageConfig imageConfig, ImageConfig.ImageBitmapCallback imageBitmapCallback);

    void loadGif(GifConfig gifConfig, ImageConfig.GifCallback gifCallback);
}
