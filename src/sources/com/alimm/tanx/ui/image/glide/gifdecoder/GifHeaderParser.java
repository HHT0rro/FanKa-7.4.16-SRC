package com.alimm.tanx.ui.image.glide.gifdecoder;

import android.util.Log;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import nd.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class GifHeaderParser {
    public static final int DEFAULT_FRAME_DELAY = 10;
    public static final int MAX_BLOCK_SIZE = 256;
    public static final int MIN_FRAME_DELAY = 3;
    public static final String TAG = "GifHeaderParser";
    public final byte[] block = new byte[256];
    public int blockSize = 0;
    public GifHeader header;
    public ByteBuffer rawData;

    private boolean err() {
        return this.header.status != 0;
    }

    private int read() {
        try {
            return this.rawData.get() & 255;
        } catch (Exception unused) {
            this.header.status = 1;
            return 0;
        }
    }

    private void readBitmap() {
        this.header.currentFrame.ix = readShort();
        this.header.currentFrame.iy = readShort();
        this.header.currentFrame.iw = readShort();
        this.header.currentFrame.ih = readShort();
        int read = read();
        boolean z10 = (read & 128) != 0;
        int pow = (int) Math.pow(2.0d, (read & 7) + 1);
        GifFrame gifFrame = this.header.currentFrame;
        gifFrame.interlace = (read & 64) != 0;
        if (z10) {
            gifFrame.lct = readColorTable(pow);
        } else {
            gifFrame.lct = null;
        }
        this.header.currentFrame.bufferFrameStart = this.rawData.position();
        skipImageData();
        if (err()) {
            return;
        }
        GifHeader gifHeader = this.header;
        gifHeader.frameCount++;
        gifHeader.frames.add(gifHeader.currentFrame);
    }

    private int readBlock() {
        int read = read();
        this.blockSize = read;
        int i10 = 0;
        if (read > 0) {
            int i11 = 0;
            while (true) {
                try {
                    i11 = this.blockSize;
                    if (i10 >= i11) {
                        break;
                    }
                    i11 -= i10;
                    this.rawData.get(this.block, i10, i11);
                    i10 += i11;
                } catch (Exception unused) {
                    if (Log.isLoggable(TAG, 3)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Error Reading Block n: ");
                        sb2.append(i10);
                        sb2.append(" count: ");
                        sb2.append(i11);
                        sb2.append(" blockSize: ");
                        sb2.append(this.blockSize);
                    }
                    this.header.status = 1;
                }
            }
        }
        return i10;
    }

    private int[] readColorTable(int i10) {
        byte[] bArr = new byte[i10 * 3];
        int[] iArr = null;
        try {
            this.rawData.get(bArr);
            iArr = new int[256];
            int i11 = 0;
            int i12 = 0;
            while (i11 < i10) {
                int i13 = i12 + 1;
                int i14 = i13 + 1;
                int i15 = i14 + 1;
                int i16 = i11 + 1;
                iArr[i11] = ((bArr[i12] & 255) << 16) | (-16777216) | ((bArr[i13] & 255) << 8) | (bArr[i14] & 255);
                i12 = i15;
                i11 = i16;
            }
        } catch (BufferUnderflowException unused) {
            Log.isLoggable(TAG, 3);
            this.header.status = 1;
        }
        return iArr;
    }

    private void readContents() {
        boolean z10 = false;
        while (!z10 && !err()) {
            int read = read();
            if (read == 33) {
                int read2 = read();
                if (read2 == 1) {
                    skip();
                } else if (read2 == 249) {
                    this.header.currentFrame = new GifFrame();
                    readGraphicControlExt();
                } else if (read2 == 254) {
                    skip();
                } else if (read2 != 255) {
                    skip();
                } else {
                    readBlock();
                    String str = "";
                    for (int i10 = 0; i10 < 11; i10++) {
                        StringBuilder a10 = a.a(str);
                        a10.append((char) this.block[i10]);
                        str = a10.toString();
                    }
                    if (str.equals("NETSCAPE2.0")) {
                        readNetscapeExt();
                    } else {
                        skip();
                    }
                }
            } else if (read == 44) {
                GifHeader gifHeader = this.header;
                if (gifHeader.currentFrame == null) {
                    gifHeader.currentFrame = new GifFrame();
                }
                readBitmap();
            } else if (read != 59) {
                this.header.status = 1;
            } else {
                z10 = true;
            }
        }
    }

    private void readGraphicControlExt() {
        read();
        int read = read();
        GifFrame gifFrame = this.header.currentFrame;
        int i10 = (read & 28) >> 2;
        gifFrame.dispose = i10;
        if (i10 == 0) {
            gifFrame.dispose = 1;
        }
        gifFrame.transparency = (read & 1) != 0;
        int readShort = readShort();
        if (readShort < 3) {
            readShort = 10;
        }
        GifFrame gifFrame2 = this.header.currentFrame;
        gifFrame2.delay = readShort * 10;
        gifFrame2.transIndex = read();
        read();
    }

    private void readHeader() {
        String str = "";
        for (int i10 = 0; i10 < 6; i10++) {
            StringBuilder a10 = a.a(str);
            a10.append((char) read());
            str = a10.toString();
        }
        if (!str.startsWith("GIF")) {
            this.header.status = 1;
            return;
        }
        readLSD();
        if (!this.header.gctFlag || err()) {
            return;
        }
        GifHeader gifHeader = this.header;
        gifHeader.gct = readColorTable(gifHeader.gctSize);
        GifHeader gifHeader2 = this.header;
        gifHeader2.bgColor = gifHeader2.gct[gifHeader2.bgIndex];
    }

    private void readLSD() {
        this.header.width = readShort();
        this.header.height = readShort();
        int read = read();
        GifHeader gifHeader = this.header;
        gifHeader.gctFlag = (read & 128) != 0;
        gifHeader.gctSize = 2 << (read & 7);
        gifHeader.bgIndex = read();
        this.header.pixelAspect = read();
    }

    private void readNetscapeExt() {
        do {
            readBlock();
            byte[] bArr = this.block;
            if (bArr[0] == 1) {
                this.header.loopCount = ((bArr[2] & 255) << 8) | (bArr[1] & 255);
            }
            if (this.blockSize <= 0) {
                return;
            }
        } while (!err());
    }

    private int readShort() {
        return this.rawData.getShort();
    }

    private void reset() {
        this.rawData = null;
        Arrays.fill(this.block, (byte) 0);
        this.header = new GifHeader();
        this.blockSize = 0;
    }

    private void skip() {
        int read;
        do {
            read = read();
            ByteBuffer byteBuffer = this.rawData;
            byteBuffer.position(byteBuffer.position() + read);
        } while (read > 0);
    }

    private void skipImageData() {
        read();
        skip();
    }

    public void clear() {
        this.rawData = null;
        this.header = null;
    }

    public GifHeader parseHeader() {
        if (this.rawData != null) {
            if (err()) {
                return this.header;
            }
            readHeader();
            if (!err()) {
                readContents();
                GifHeader gifHeader = this.header;
                if (gifHeader.frameCount < 0) {
                    gifHeader.status = 1;
                }
            }
            return this.header;
        }
        throw new IllegalStateException("You must call setData() before parseHeader()");
    }

    public GifHeaderParser setData(byte[] bArr) {
        reset();
        if (bArr != null) {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            this.rawData = wrap;
            wrap.rewind();
            this.rawData.order(ByteOrder.LITTLE_ENDIAN);
        } else {
            this.rawData = null;
            this.header.status = 2;
        }
        return this;
    }
}
