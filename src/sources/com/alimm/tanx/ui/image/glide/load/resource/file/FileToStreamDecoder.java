package com.alimm.tanx.ui.image.glide.load.resource.file;

import com.alimm.tanx.ui.image.glide.load.ResourceDecoder;
import com.alimm.tanx.ui.image.glide.load.engine.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class FileToStreamDecoder<T> implements ResourceDecoder<File, T> {
    public static final FileOpener DEFAULT_FILE_OPENER = new FileOpener();
    public final FileOpener fileOpener;
    public ResourceDecoder<InputStream, T> streamDecoder;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public static class FileOpener {
        public InputStream open(File file) throws FileNotFoundException {
            return new FileInputStream(file);
        }
    }

    public FileToStreamDecoder(ResourceDecoder<InputStream, T> resourceDecoder) {
        FileOpener fileOpener = DEFAULT_FILE_OPENER;
        this.streamDecoder = resourceDecoder;
        this.fileOpener = fileOpener;
    }

    @Override // com.alimm.tanx.ui.image.glide.load.ResourceDecoder
    public String getId() {
        return "";
    }

    @Override // com.alimm.tanx.ui.image.glide.load.ResourceDecoder
    public Resource<T> decode(File file, int i10, int i11) throws IOException {
        InputStream inputStream = null;
        try {
            inputStream = this.fileOpener.open(file);
            Resource<T> decode = this.streamDecoder.decode(inputStream, i10, i11);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused) {
                }
            }
            return decode;
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
    }

    public FileToStreamDecoder(ResourceDecoder<InputStream, T> resourceDecoder, FileOpener fileOpener) {
        this.streamDecoder = resourceDecoder;
        this.fileOpener = fileOpener;
    }
}
