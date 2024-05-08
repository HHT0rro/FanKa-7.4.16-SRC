package com.alimm.tanx.ui.image.glide.load.model;

import android.os.ParcelFileDescriptor;
import com.alimm.tanx.ui.image.glide.load.Encoder;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ImageVideoWrapperEncoder implements Encoder<ImageVideoWrapper> {
    public final Encoder<ParcelFileDescriptor> fileDescriptorEncoder;

    /* renamed from: id, reason: collision with root package name */
    public String f4194id;
    public final Encoder<InputStream> streamEncoder;

    public ImageVideoWrapperEncoder(Encoder<InputStream> encoder, Encoder<ParcelFileDescriptor> encoder2) {
        this.streamEncoder = encoder;
        this.fileDescriptorEncoder = encoder2;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Encoder
    public String getId() {
        if (this.f4194id == null) {
            this.f4194id = this.streamEncoder.getId() + this.fileDescriptorEncoder.getId();
        }
        return this.f4194id;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Encoder
    public boolean encode(ImageVideoWrapper imageVideoWrapper, OutputStream outputStream) {
        if (imageVideoWrapper.getStream() != null) {
            return this.streamEncoder.encode(imageVideoWrapper.getStream(), outputStream);
        }
        return this.fileDescriptorEncoder.encode(imageVideoWrapper.getFileDescriptor(), outputStream);
    }
}
