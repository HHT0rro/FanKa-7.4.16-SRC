package com.alibaba.fastjson.asm;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import okio.Utf8;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ClassReader {

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f2140b;
    public final int header;
    private final int[] items;
    private final int maxStringLength;
    private boolean readAnnotations;
    private final String[] strings;

    public ClassReader(InputStream inputStream, boolean z10) throws IOException {
        int i10;
        this.readAnnotations = z10;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            i10 = 0;
            if (read == -1) {
                break;
            } else if (read > 0) {
                byteArrayOutputStream.write(bArr, 0, read);
            }
        }
        inputStream.close();
        this.f2140b = byteArrayOutputStream.toByteArray();
        int[] iArr = new int[readUnsignedShort(8)];
        this.items = iArr;
        int length = iArr.length;
        this.strings = new String[length];
        int i11 = 10;
        int i12 = 1;
        while (i12 < length) {
            int i13 = i11 + 1;
            this.items[i12] = i13;
            byte b4 = this.f2140b[i11];
            int i14 = 5;
            if (b4 == 1) {
                i14 = readUnsignedShort(i13) + 3;
                if (i14 > i10) {
                    i10 = i14;
                }
            } else if (b4 == 15) {
                i14 = 4;
            } else if (b4 != 18 && b4 != 3 && b4 != 4) {
                if (b4 != 5 && b4 != 6) {
                    switch (b4) {
                        case 9:
                        case 10:
                        case 11:
                        case 12:
                            break;
                        default:
                            i14 = 3;
                            break;
                    }
                } else {
                    i14 = 9;
                    i12++;
                }
            }
            i11 += i14;
            i12++;
        }
        this.maxStringLength = i10;
        this.header = i11;
    }

    private int getAttributes() {
        int i10 = this.header;
        int readUnsignedShort = i10 + 8 + (readUnsignedShort(i10 + 6) * 2);
        for (int readUnsignedShort2 = readUnsignedShort(readUnsignedShort); readUnsignedShort2 > 0; readUnsignedShort2--) {
            for (int readUnsignedShort3 = readUnsignedShort(readUnsignedShort + 8); readUnsignedShort3 > 0; readUnsignedShort3--) {
                readUnsignedShort += readInt(readUnsignedShort + 12) + 6;
            }
            readUnsignedShort += 8;
        }
        int i11 = readUnsignedShort + 2;
        for (int readUnsignedShort4 = readUnsignedShort(i11); readUnsignedShort4 > 0; readUnsignedShort4--) {
            for (int readUnsignedShort5 = readUnsignedShort(i11 + 8); readUnsignedShort5 > 0; readUnsignedShort5--) {
                i11 += readInt(i11 + 12) + 6;
            }
            i11 += 8;
        }
        return i11 + 2;
    }

    private int readInt(int i10) {
        byte[] bArr = this.f2140b;
        return (bArr[i10 + 3] & 255) | ((bArr[i10] & 255) << 24) | ((bArr[i10 + 1] & 255) << 16) | ((bArr[i10 + 2] & 255) << 8);
    }

    private int readMethod(TypeCollector typeCollector, char[] cArr, int i10) {
        int readUnsignedShort = readUnsignedShort(i10);
        String readUTF8 = readUTF8(i10 + 2, cArr);
        String readUTF82 = readUTF8(i10 + 4, cArr);
        int i11 = i10 + 8;
        int i12 = 0;
        int i13 = 0;
        for (int readUnsignedShort2 = readUnsignedShort(i10 + 6); readUnsignedShort2 > 0; readUnsignedShort2--) {
            String readUTF83 = readUTF8(i11, cArr);
            int readInt = readInt(i11 + 2);
            int i14 = i11 + 6;
            if (readUTF83.equals("Code")) {
                i13 = i14;
            }
            i11 = i14 + readInt;
        }
        MethodCollector visitMethod = typeCollector.visitMethod(readUnsignedShort, readUTF8, readUTF82);
        if (visitMethod != null && i13 != 0) {
            int readInt2 = i13 + 8 + readInt(i13 + 4);
            int i15 = readInt2 + 2;
            for (int readUnsignedShort3 = readUnsignedShort(readInt2); readUnsignedShort3 > 0; readUnsignedShort3--) {
                i15 += 8;
            }
            int i16 = i15 + 2;
            int i17 = 0;
            for (int readUnsignedShort4 = readUnsignedShort(i15); readUnsignedShort4 > 0; readUnsignedShort4--) {
                String readUTF84 = readUTF8(i16, cArr);
                if (readUTF84.equals("LocalVariableTable")) {
                    i12 = i16 + 6;
                } else if (readUTF84.equals("LocalVariableTypeTable")) {
                    i17 = i16 + 6;
                }
                i16 += readInt(i16 + 2) + 6;
            }
            if (i12 != 0) {
                if (i17 != 0) {
                    int readUnsignedShort5 = readUnsignedShort(i17) * 3;
                    int i18 = i17 + 2;
                    int[] iArr = new int[readUnsignedShort5];
                    while (readUnsignedShort5 > 0) {
                        int i19 = readUnsignedShort5 - 1;
                        iArr[i19] = i18 + 6;
                        int i20 = i19 - 1;
                        iArr[i20] = readUnsignedShort(i18 + 8);
                        readUnsignedShort5 = i20 - 1;
                        iArr[readUnsignedShort5] = readUnsignedShort(i18);
                        i18 += 10;
                    }
                }
                int i21 = i12 + 2;
                for (int readUnsignedShort6 = readUnsignedShort(i12); readUnsignedShort6 > 0; readUnsignedShort6--) {
                    visitMethod.visitLocalVariable(readUTF8(i21 + 4, cArr), readUnsignedShort(i21 + 8));
                    i21 += 10;
                }
            }
        }
        return i11;
    }

    private String readUTF(int i10, int i11, char[] cArr) {
        int i12;
        int i13 = i11 + i10;
        byte[] bArr = this.f2140b;
        int i14 = 0;
        char c4 = 0;
        char c10 = 0;
        while (i10 < i13) {
            int i15 = i10 + 1;
            byte b4 = bArr[i10];
            if (c4 != 0) {
                if (c4 == 1) {
                    cArr[i14] = (char) ((b4 & Utf8.REPLACEMENT_BYTE) | (c10 << 6));
                    i14++;
                    c4 = 0;
                } else if (c4 == 2) {
                    i12 = (b4 & Utf8.REPLACEMENT_BYTE) | (c10 << 6);
                    c10 = (char) i12;
                    c4 = 1;
                }
                i10 = i15;
            } else {
                int i16 = b4 & 255;
                if (i16 < 128) {
                    cArr[i14] = (char) i16;
                    i14++;
                } else if (i16 >= 224 || i16 <= 191) {
                    c10 = (char) (i16 & 15);
                    c4 = 2;
                } else {
                    i12 = i16 & 31;
                    c10 = (char) i12;
                    c4 = 1;
                }
                i10 = i15;
            }
        }
        return new String(cArr, 0, i14);
    }

    private String readUTF8(int i10, char[] cArr) {
        int readUnsignedShort = readUnsignedShort(i10);
        String[] strArr = this.strings;
        String str = strArr[readUnsignedShort];
        if (str != null) {
            return str;
        }
        int i11 = this.items[readUnsignedShort];
        String readUTF = readUTF(i11 + 2, readUnsignedShort(i11), cArr);
        strArr[readUnsignedShort] = readUTF;
        return readUTF;
    }

    private int readUnsignedShort(int i10) {
        byte[] bArr = this.f2140b;
        return (bArr[i10 + 1] & 255) | ((bArr[i10] & 255) << 8);
    }

    public void accept(TypeCollector typeCollector) {
        int i10;
        char[] cArr = new char[this.maxStringLength];
        if (this.readAnnotations) {
            int attributes = getAttributes();
            for (int readUnsignedShort = readUnsignedShort(attributes); readUnsignedShort > 0; readUnsignedShort--) {
                if ("RuntimeVisibleAnnotations".equals(readUTF8(attributes + 2, cArr))) {
                    i10 = attributes + 8;
                    break;
                }
                attributes += readInt(attributes + 4) + 6;
            }
        }
        i10 = 0;
        int i11 = this.header;
        int i12 = this.items[readUnsignedShort(i11 + 4)];
        int readUnsignedShort2 = readUnsignedShort(i11 + 6);
        int i13 = i11 + 8;
        for (int i14 = 0; i14 < readUnsignedShort2; i14++) {
            i13 += 2;
        }
        int i15 = i13 + 2;
        int i16 = i15;
        for (int readUnsignedShort3 = readUnsignedShort(i13); readUnsignedShort3 > 0; readUnsignedShort3--) {
            i16 += 8;
            for (int readUnsignedShort4 = readUnsignedShort(i16 + 6); readUnsignedShort4 > 0; readUnsignedShort4--) {
                i16 += readInt(i16 + 2) + 6;
            }
        }
        int i17 = i16 + 2;
        for (int readUnsignedShort5 = readUnsignedShort(i16); readUnsignedShort5 > 0; readUnsignedShort5--) {
            i17 += 8;
            for (int readUnsignedShort6 = readUnsignedShort(i17 + 6); readUnsignedShort6 > 0; readUnsignedShort6--) {
                i17 += readInt(i17 + 2) + 6;
            }
        }
        int i18 = i17 + 2;
        for (int readUnsignedShort7 = readUnsignedShort(i17); readUnsignedShort7 > 0; readUnsignedShort7--) {
            i18 += readInt(i18 + 2) + 6;
        }
        if (i10 != 0) {
            int i19 = i10 + 2;
            for (int readUnsignedShort8 = readUnsignedShort(i10); readUnsignedShort8 > 0; readUnsignedShort8--) {
                typeCollector.visitAnnotation(readUTF8(i19, cArr));
            }
        }
        for (int readUnsignedShort9 = readUnsignedShort(i13); readUnsignedShort9 > 0; readUnsignedShort9--) {
            i15 += 8;
            for (int readUnsignedShort10 = readUnsignedShort(i15 + 6); readUnsignedShort10 > 0; readUnsignedShort10--) {
                i15 += readInt(i15 + 2) + 6;
            }
        }
        int i20 = i15 + 2;
        for (int readUnsignedShort11 = readUnsignedShort(i15); readUnsignedShort11 > 0; readUnsignedShort11--) {
            i20 = readMethod(typeCollector, cArr, i20);
        }
    }
}
