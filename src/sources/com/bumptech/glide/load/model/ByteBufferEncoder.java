package com.bumptech.glide.load.model;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.util.ByteBufferUtil;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class ByteBufferEncoder implements Encoder<ByteBuffer> {
    private static final String TAG = "ByteBufferEncoder";

    @Override // com.bumptech.glide.load.Encoder
    public boolean encode(@NonNull ByteBuffer byteBuffer, @NonNull File file, @NonNull Options options) {
        try {
            ByteBufferUtil.toFile(byteBuffer, file);
            return true;
        } catch (IOException unused) {
            Log.isLoggable(TAG, 3);
            return false;
        }
    }
}
