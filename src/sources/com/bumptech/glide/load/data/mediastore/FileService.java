package com.bumptech.glide.load.data.mediastore;

import java.io.File;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
class FileService {
    public boolean exists(File file) {
        return file.exists();
    }

    public File get(String str) {
        return new File(str);
    }

    public long length(File file) {
        return file.length();
    }
}
