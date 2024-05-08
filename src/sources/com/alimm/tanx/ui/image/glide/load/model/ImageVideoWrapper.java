package com.alimm.tanx.ui.image.glide.load.model;

import android.os.ParcelFileDescriptor;
import java.io.InputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ImageVideoWrapper {
    public final ParcelFileDescriptor fileDescriptor;
    public final InputStream streamData;

    public ImageVideoWrapper(InputStream inputStream, ParcelFileDescriptor parcelFileDescriptor) {
        this.streamData = inputStream;
        this.fileDescriptor = parcelFileDescriptor;
    }

    public ParcelFileDescriptor getFileDescriptor() {
        return this.fileDescriptor;
    }

    public InputStream getStream() {
        return this.streamData;
    }
}
