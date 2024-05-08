package com.jd.ad.sdk.jad_fq;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import org.apache.commons.lang3.CharEncoding;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class jad_cp {
    public static final Charset jad_an = Charset.forName(CharEncoding.US_ASCII);

    static {
        Charset.forName("UTF-8");
    }

    public static void jad_an(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            throw new IOException("not a readable directory: " + ((Object) file));
        }
        for (File file2 : listFiles) {
            if (file2.isDirectory()) {
                jad_an(file2);
            }
            if (!file2.delete()) {
                throw new IOException("failed to delete file: " + ((Object) file2));
            }
        }
    }
}
