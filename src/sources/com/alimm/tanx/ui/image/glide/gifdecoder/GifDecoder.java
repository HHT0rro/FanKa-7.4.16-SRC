package com.alimm.tanx.ui.image.glide.gifdecoder;

import android.graphics.Bitmap;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;
import nd.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class GifDecoder {
    public static final Bitmap.Config BITMAP_CONFIG = Bitmap.Config.ARGB_8888;
    public static final int DISPOSAL_BACKGROUND = 2;
    public static final int DISPOSAL_NONE = 1;
    public static final int DISPOSAL_PREVIOUS = 3;
    public static final int DISPOSAL_UNSPECIFIED = 0;
    public static final int INITIAL_FRAME_POINTER = -1;
    public static final int MAX_STACK_SIZE = 4096;
    public static final int NULL_CODE = -1;
    public static final int STATUS_FORMAT_ERROR = 1;
    public static final int STATUS_OK = 0;
    public static final int STATUS_OPEN_ERROR = 2;
    public static final int STATUS_PARTIAL_DECODE = 3;
    public static final String TAG = "GifDecoder";
    public static final int TOTAL_ITERATION_COUNT_FOREVER = 0;
    public int[] act;
    public BitmapProvider bitmapProvider;
    public byte[] data;
    public int framePointer;
    public byte[] mainPixels;
    public int[] mainScratch;
    public GifHeaderParser parser;
    public byte[] pixelStack;
    public short[] prefix;
    public Bitmap previousImage;
    public ByteBuffer rawData;
    public boolean savePrevious;
    public int status;
    public byte[] suffix;
    public final int[] pct = new int[256];
    public final byte[] block = new byte[256];
    public GifHeader header = new GifHeader();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface BitmapProvider {
        Bitmap obtain(int i10, int i11, Bitmap.Config config);

        void release(Bitmap bitmap);
    }

    public GifDecoder(BitmapProvider bitmapProvider) {
        this.bitmapProvider = bitmapProvider;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v16, types: [short] */
    /* JADX WARN: Type inference failed for: r3v18 */
    private void decodeBitmapData(GifFrame gifFrame) {
        int i10;
        int i11;
        int i12;
        short s2;
        if (gifFrame != null) {
            this.rawData.position(gifFrame.bufferFrameStart);
        }
        if (gifFrame == null) {
            GifHeader gifHeader = this.header;
            i10 = gifHeader.width;
            i11 = gifHeader.height;
        } else {
            i10 = gifFrame.iw;
            i11 = gifFrame.ih;
        }
        int i13 = i10 * i11;
        byte[] bArr = this.mainPixels;
        if (bArr == null || bArr.length < i13) {
            this.mainPixels = new byte[i13];
        }
        if (this.prefix == null) {
            this.prefix = new short[4096];
        }
        if (this.suffix == null) {
            this.suffix = new byte[4096];
        }
        if (this.pixelStack == null) {
            this.pixelStack = new byte[4097];
        }
        int read = read();
        int i14 = 1;
        int i15 = 1 << read;
        int i16 = i15 + 1;
        int i17 = i15 + 2;
        int i18 = read + 1;
        int i19 = (1 << i18) - 1;
        for (int i20 = 0; i20 < i15; i20++) {
            this.prefix[i20] = 0;
            this.suffix[i20] = (byte) i20;
        }
        int i21 = -1;
        int i22 = i18;
        int i23 = i17;
        int i24 = i19;
        int i25 = 0;
        int i26 = 0;
        int i27 = 0;
        int i28 = 0;
        int i29 = 0;
        int i30 = 0;
        int i31 = 0;
        int i32 = 0;
        int i33 = -1;
        while (true) {
            if (i25 >= i13) {
                break;
            }
            if (i26 == 0) {
                i26 = readBlock();
                if (i26 <= 0) {
                    this.status = 3;
                    break;
                }
                i27 = 0;
            }
            i29 += (this.block[i27] & 255) << i28;
            i28 += 8;
            i27 += i14;
            i26 += i21;
            int i34 = i31;
            int i35 = i23;
            int i36 = i22;
            int i37 = i33;
            while (i28 >= i36) {
                int i38 = i29 & i24;
                i29 >>= i36;
                i28 -= i36;
                if (i38 != i15) {
                    if (i38 > i35) {
                        i12 = i18;
                        this.status = 3;
                    } else {
                        i12 = i18;
                        if (i38 != i16) {
                            int i39 = i16;
                            int i40 = i37;
                            if (i40 == -1) {
                                this.pixelStack[i32] = this.suffix[i38];
                                i32++;
                                i34 = i38;
                                i37 = i34;
                                i16 = i39;
                                i18 = i12;
                            } else {
                                if (i38 >= i35) {
                                    this.pixelStack[i32] = (byte) i34;
                                    s2 = i40;
                                    i32++;
                                } else {
                                    s2 = i38;
                                }
                                while (s2 >= i15) {
                                    this.pixelStack[i32] = this.suffix[s2];
                                    s2 = this.prefix[s2];
                                    i32++;
                                    i15 = i15;
                                }
                                int i41 = i15;
                                byte[] bArr2 = this.suffix;
                                i34 = bArr2[s2] & 255;
                                int i42 = i32 + 1;
                                int i43 = i17;
                                byte b4 = (byte) i34;
                                this.pixelStack[i32] = b4;
                                if (i35 < 4096) {
                                    this.prefix[i35] = (short) i40;
                                    bArr2[i35] = b4;
                                    i35++;
                                    if ((i35 & i24) == 0 && i35 < 4096) {
                                        i36++;
                                        i24 += i35;
                                    }
                                }
                                i32 = i42;
                                while (i32 > 0) {
                                    i32--;
                                    this.mainPixels[i30] = this.pixelStack[i32];
                                    i25++;
                                    i30++;
                                }
                                i37 = i38;
                                i16 = i39;
                                i18 = i12;
                                i15 = i41;
                                i17 = i43;
                            }
                        }
                    }
                    i31 = i34;
                    i23 = i35;
                    i22 = i36;
                    i18 = i12;
                    i33 = i37;
                    i14 = 1;
                    i21 = -1;
                    break;
                }
                i36 = i18;
                i35 = i17;
                i24 = i19;
                i37 = -1;
            }
            i31 = i34;
            i23 = i35;
            i22 = i36;
            i14 = 1;
            i21 = -1;
            i33 = i37;
            i18 = i18;
        }
        for (int i44 = i30; i44 < i13; i44++) {
            this.mainPixels[i44] = 0;
        }
    }

    private GifHeaderParser getHeaderParser() {
        if (this.parser == null) {
            this.parser = new GifHeaderParser();
        }
        return this.parser;
    }

    private Bitmap getNextBitmap() {
        BitmapProvider bitmapProvider = this.bitmapProvider;
        GifHeader gifHeader = this.header;
        int i10 = gifHeader.width;
        int i11 = gifHeader.height;
        Bitmap.Config config = BITMAP_CONFIG;
        Bitmap obtain = bitmapProvider.obtain(i10, i11, config);
        if (obtain == null) {
            GifHeader gifHeader2 = this.header;
            obtain = Bitmap.createBitmap(gifHeader2.width, gifHeader2.height, config);
        }
        setAlpha(obtain);
        return obtain;
    }

    private int readBlock() {
        int read = read();
        int i10 = 0;
        if (read > 0) {
            while (i10 < read) {
                int i11 = read - i10;
                try {
                    this.rawData.get(this.block, i10, i11);
                    i10 += i11;
                } catch (Exception unused) {
                    this.status = 1;
                }
            }
        }
        return i10;
    }

    public static void setAlpha(Bitmap bitmap) {
        bitmap.setHasAlpha(true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002e, code lost:
    
        if (r4.bgIndex == r17.transIndex) goto L16;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00bc A[EDGE_INSN: B:60:0x00bc->B:61:0x00bc BREAK  A[LOOP:2: B:29:0x0067->B:57:0x00b7], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.graphics.Bitmap setPixels(com.alimm.tanx.ui.image.glide.gifdecoder.GifFrame r17, com.alimm.tanx.ui.image.glide.gifdecoder.GifFrame r18) {
        /*
            Method dump skipped, instructions count: 236
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alimm.tanx.ui.image.glide.gifdecoder.GifDecoder.setPixels(com.alimm.tanx.ui.image.glide.gifdecoder.GifFrame, com.alimm.tanx.ui.image.glide.gifdecoder.GifFrame):android.graphics.Bitmap");
    }

    public void advance() {
        this.framePointer = (this.framePointer + 1) % this.header.frameCount;
    }

    public void clear() {
        this.header = null;
        this.data = null;
        this.mainPixels = null;
        this.mainScratch = null;
        Bitmap bitmap = this.previousImage;
        if (bitmap != null) {
            this.bitmapProvider.release(bitmap);
        }
        this.previousImage = null;
        this.rawData = null;
    }

    public int getCurrentFrameIndex() {
        return this.framePointer;
    }

    public byte[] getData() {
        return this.data;
    }

    public int getDelay(int i10) {
        if (i10 >= 0) {
            GifHeader gifHeader = this.header;
            if (i10 < gifHeader.frameCount) {
                return gifHeader.frames.get(i10).delay;
            }
        }
        return -1;
    }

    public int getFrameCount() {
        return this.header.frameCount;
    }

    public int getHeight() {
        return this.header.height;
    }

    @Deprecated
    public int getLoopCount() {
        int i10 = this.header.loopCount;
        if (i10 == -1) {
            return 1;
        }
        return i10;
    }

    public int getNetscapeLoopCount() {
        return this.header.loopCount;
    }

    public int getNextDelay() {
        int i10;
        if (this.header.frameCount <= 0 || (i10 = this.framePointer) < 0) {
            return -1;
        }
        return getDelay(i10);
    }

    public synchronized Bitmap getNextFrame() {
        if (this.header.frameCount <= 0 || this.framePointer < 0) {
            if (Log.isLoggable(TAG, 3)) {
                StringBuilder a10 = a.a("unable to decode frame, frameCount=");
                a10.append(this.header.frameCount);
                a10.append(" framePointer=");
                a10.append(this.framePointer);
            }
            this.status = 1;
        }
        int i10 = this.status;
        if (i10 != 1 && i10 != 2) {
            this.status = 0;
            GifFrame gifFrame = this.header.frames.get(this.framePointer);
            int i11 = this.framePointer - 1;
            GifFrame gifFrame2 = i11 >= 0 ? this.header.frames.get(i11) : null;
            int[] iArr = gifFrame.lct;
            if (iArr == null) {
                iArr = this.header.gct;
            }
            this.act = iArr;
            if (iArr == null) {
                Log.isLoggable(TAG, 3);
                this.status = 1;
                return null;
            }
            if (gifFrame.transparency) {
                System.arraycopy((Object) iArr, 0, (Object) this.pct, 0, iArr.length);
                int[] iArr2 = this.pct;
                this.act = iArr2;
                iArr2[gifFrame.transIndex] = 0;
            }
            return setPixels(gifFrame, gifFrame2);
        }
        if (Log.isLoggable(TAG, 3)) {
            a.a("Unable to decode frame, status=").append(this.status);
        }
        return null;
    }

    public int getStatus() {
        return this.status;
    }

    public int getTotalIterationCount() {
        int i10 = this.header.loopCount;
        if (i10 == -1) {
            return 1;
        }
        if (i10 == 0) {
            return 0;
        }
        return i10 + 1;
    }

    public int getWidth() {
        return this.header.width;
    }

    public int read(InputStream inputStream, int i10) {
        if (inputStream != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i10 > 0 ? i10 + 4096 : 16384);
                byte[] bArr = new byte[16384];
                while (true) {
                    int read = inputStream.read(bArr, 0, 16384);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                byteArrayOutputStream.flush();
                read(byteArrayOutputStream.toByteArray());
            } catch (IOException unused) {
            }
        } else {
            this.status = 2;
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused2) {
            }
        }
        return this.status;
    }

    public void resetFrameIndex() {
        this.framePointer = -1;
    }

    public void setData(GifHeader gifHeader, byte[] bArr) {
        this.header = gifHeader;
        this.data = bArr;
        this.status = 0;
        this.framePointer = -1;
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        this.rawData = wrap;
        wrap.rewind();
        this.rawData.order(ByteOrder.LITTLE_ENDIAN);
        this.savePrevious = false;
        Iterator<GifFrame> iterator2 = gifHeader.frames.iterator2();
        while (true) {
            if (!iterator2.hasNext()) {
                break;
            } else if (iterator2.next().dispose == 3) {
                this.savePrevious = true;
                break;
            }
        }
        int i10 = gifHeader.width * gifHeader.height;
        this.mainPixels = new byte[i10];
        this.mainScratch = new int[i10];
    }

    public int read(byte[] bArr) {
        this.data = bArr;
        this.header = getHeaderParser().setData(bArr).parseHeader();
        if (bArr != null) {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            this.rawData = wrap;
            wrap.rewind();
            this.rawData.order(ByteOrder.LITTLE_ENDIAN);
            GifHeader gifHeader = this.header;
            int i10 = gifHeader.width * gifHeader.height;
            this.mainPixels = new byte[i10];
            this.mainScratch = new int[i10];
            this.savePrevious = false;
            Iterator<GifFrame> iterator2 = gifHeader.frames.iterator2();
            while (true) {
                if (!iterator2.hasNext()) {
                    break;
                }
                if (iterator2.next().dispose == 3) {
                    this.savePrevious = true;
                    break;
                }
            }
        }
        return this.status;
    }

    private int read() {
        try {
            return this.rawData.get() & 255;
        } catch (Exception unused) {
            this.status = 1;
            return 0;
        }
    }
}
