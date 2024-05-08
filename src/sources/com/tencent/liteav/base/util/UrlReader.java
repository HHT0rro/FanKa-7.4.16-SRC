package com.tencent.liteav.base.util;

import android.net.Uri;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.Log;
import com.tencent.liteav.base.annotations.CalledByNative;
import com.tencent.liteav.base.annotations.JNINamespace;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

@JNINamespace("liteav")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class UrlReader {
    private static final int AVSEEK_SIZE = 65536;
    private static final int SEEK_CUR = 1;
    private static final int SEEK_END = 2;
    private static final int SEEK_SET = 0;
    private static final String TAG = "UrlReader";
    private int mFileSize;
    private long mOffset;
    private InputStream mStream;
    private Uri mUri;

    @CalledByNative
    public UrlReader(String str) {
        this.mUri = Uri.parse(str);
        open();
    }

    private void open() {
        try {
            InputStream openInputStream = ContextUtils.getApplicationContext().getContentResolver().openInputStream(this.mUri);
            this.mStream = openInputStream;
            this.mFileSize = openInputStream.available();
        } catch (FileNotFoundException unused) {
            Log.e(TAG, "Fail to open uri " + this.mUri.toString(), new Object[0]);
            this.mStream = null;
        } catch (IOException e2) {
            Log.e(TAG, "Fail to get file size " + e2.getMessage(), new Object[0]);
            this.mStream = null;
        }
    }

    private long seekFromBegin(long j10) {
        if (j10 < 0) {
            return -1L;
        }
        close();
        open();
        InputStream inputStream = this.mStream;
        if (inputStream == null) {
            return -1L;
        }
        try {
            long skip = inputStream.skip(j10);
            this.mOffset = skip;
            return skip;
        } catch (IOException e2) {
            Log.e(TAG, "Fail to seek " + j10 + " exception " + e2.getMessage(), new Object[0]);
            return -1L;
        }
    }

    private long seekFromCurrent(long j10) {
        if (j10 < 0) {
            return seekFromBegin(this.mOffset + j10);
        }
        try {
            long skip = this.mOffset + this.mStream.skip(j10);
            this.mOffset = skip;
            return skip;
        } catch (IOException e2) {
            Log.e(TAG, "Fail to seek " + j10 + " exception " + e2.getMessage(), new Object[0]);
            return -1L;
        }
    }

    private long seekFromEnd(long j10) {
        if (j10 > 0) {
            return -1L;
        }
        long j11 = this.mFileSize + j10;
        if (j11 < 0) {
            return -1L;
        }
        long j12 = this.mOffset;
        if (j11 < j12) {
            return seekFromBegin(j11);
        }
        try {
            long skip = j12 + this.mStream.skip(j11 - j12);
            this.mOffset = skip;
            return skip;
        } catch (IOException e2) {
            Log.e(TAG, "Fail to seek " + j10 + " exception " + e2.getMessage(), new Object[0]);
            return -1L;
        }
    }

    @CalledByNative
    public void close() {
        InputStream inputStream = this.mStream;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e2) {
                Log.e(TAG, "Close exception " + e2.getMessage(), new Object[0]);
            }
        }
        this.mStream = null;
        this.mOffset = 0L;
        this.mFileSize = 0;
    }

    @CalledByNative
    public int read(byte[] bArr, int i10) {
        InputStream inputStream = this.mStream;
        int i11 = -1;
        if (inputStream == null) {
            return -1;
        }
        try {
            i11 = inputStream.read(bArr, 0, i10);
            this.mOffset += i11;
            return i11;
        } catch (IOException e2) {
            Log.e(TAG, "Read exception " + e2.getMessage(), new Object[0]);
            return i11;
        }
    }

    @CalledByNative
    public long seek(long j10, int i10) {
        if (this.mStream == null) {
            return -1L;
        }
        if (i10 == 0) {
            return seekFromBegin(j10);
        }
        if (i10 == 1) {
            return seekFromCurrent(j10);
        }
        if (i10 == 2) {
            return seekFromEnd(j10);
        }
        if (i10 != 65536) {
            return -1L;
        }
        return this.mFileSize;
    }
}
