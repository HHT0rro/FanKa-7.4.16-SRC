package com.alimm.tanx.ui.image.glide.load.model;

import android.util.Log;
import com.alimm.tanx.ui.image.glide.load.Encoder;
import com.alimm.tanx.ui.image.glide.util.ByteArrayPool;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class StreamEncoder implements Encoder<InputStream> {
    public static final String TAG = "StreamEncoder";

    @Override // com.alimm.tanx.ui.image.glide.load.Encoder
    public String getId() {
        return "";
    }

    @Override // com.alimm.tanx.ui.image.glide.load.Encoder
    public boolean encode(InputStream inputStream, OutputStream outputStream) {
        byte[] bytes = ByteArrayPool.get().getBytes();
        while (true) {
            try {
                try {
                    int read = inputStream.read(bytes);
                    if (read != -1) {
                        outputStream.write(bytes, 0, read);
                    } else {
                        ByteArrayPool.get().releaseBytes(bytes);
                        return true;
                    }
                } catch (IOException unused) {
                    Log.isLoggable(TAG, 3);
                    ByteArrayPool.get().releaseBytes(bytes);
                    return false;
                }
            } catch (Throwable th) {
                ByteArrayPool.get().releaseBytes(bytes);
                throw th;
            }
        }
    }
}
