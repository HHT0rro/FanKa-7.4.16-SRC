package com.facebook.soloader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MinElf {
    public static final int DT_NEEDED = 1;
    public static final int DT_NULL = 0;
    public static final int DT_STRTAB = 5;
    public static final int ELF_MAGIC = 1179403647;
    public static final int PN_XNUM = 65535;
    public static final int PT_DYNAMIC = 2;
    public static final int PT_LOAD = 1;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class ElfError extends RuntimeException {
        public ElfError(String str) {
            super(str);
        }
    }

    public static String[] extract_DT_NEEDED(File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            return extract_DT_NEEDED(fileInputStream.getChannel());
        } finally {
            fileInputStream.close();
        }
    }

    private static long get64(FileChannel fileChannel, ByteBuffer byteBuffer, long j10) throws IOException {
        read(fileChannel, byteBuffer, 8, j10);
        return byteBuffer.getLong();
    }

    private static String getSz(FileChannel fileChannel, ByteBuffer byteBuffer, long j10) throws IOException {
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            long j11 = 1 + j10;
            short u8Var = getu8(fileChannel, byteBuffer, j10);
            if (u8Var != 0) {
                sb2.append((char) u8Var);
                j10 = j11;
            } else {
                return sb2.toString();
            }
        }
    }

    private static int getu16(FileChannel fileChannel, ByteBuffer byteBuffer, long j10) throws IOException {
        read(fileChannel, byteBuffer, 2, j10);
        return byteBuffer.getShort() & 65535;
    }

    private static long getu32(FileChannel fileChannel, ByteBuffer byteBuffer, long j10) throws IOException {
        read(fileChannel, byteBuffer, 4, j10);
        return byteBuffer.getInt() & 4294967295L;
    }

    private static short getu8(FileChannel fileChannel, ByteBuffer byteBuffer, long j10) throws IOException {
        read(fileChannel, byteBuffer, 1, j10);
        return (short) (byteBuffer.get() & 255);
    }

    private static void read(FileChannel fileChannel, ByteBuffer byteBuffer, int i10, long j10) throws IOException {
        int read;
        byteBuffer.position(0);
        byteBuffer.limit(i10);
        while (byteBuffer.remaining() > 0 && (read = fileChannel.read(byteBuffer, j10)) != -1) {
            j10 += read;
        }
        if (byteBuffer.remaining() <= 0) {
            byteBuffer.position(0);
            return;
        }
        throw new ElfError("ELF file truncated");
    }

    public static String[] extract_DT_NEEDED(FileChannel fileChannel) throws IOException {
        long j10;
        long j11;
        int i10;
        long j12;
        boolean z10;
        long j13;
        long j14;
        long j15;
        long j16;
        long j17;
        long j18;
        long j19;
        long j20;
        long j21;
        long j22;
        long j23;
        long j24;
        long j25;
        long j26;
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        if (getu32(fileChannel, allocate, 0L) == 1179403647) {
            boolean z11 = getu8(fileChannel, allocate, 4L) == 1;
            if (getu8(fileChannel, allocate, 5L) == 2) {
                allocate.order(ByteOrder.BIG_ENDIAN);
            }
            if (z11) {
                j10 = getu32(fileChannel, allocate, 28L);
            } else {
                j10 = get64(fileChannel, allocate, 32L);
            }
            if (z11) {
                j11 = getu16(fileChannel, allocate, 44L);
            } else {
                j11 = getu16(fileChannel, allocate, 56L);
            }
            if (z11) {
                i10 = getu16(fileChannel, allocate, 42L);
            } else {
                i10 = getu16(fileChannel, allocate, 54L);
            }
            if (j11 == 65535) {
                if (z11) {
                    j25 = getu32(fileChannel, allocate, 32L);
                } else {
                    j25 = get64(fileChannel, allocate, 40L);
                }
                if (z11) {
                    j26 = getu32(fileChannel, allocate, j25 + 28);
                } else {
                    j26 = getu32(fileChannel, allocate, j25 + 44);
                }
                j11 = j26;
            }
            long j27 = j10;
            long j28 = 0;
            while (true) {
                if (j28 >= j11) {
                    j12 = 0;
                    break;
                }
                if (z11) {
                    j24 = getu32(fileChannel, allocate, j27 + 0);
                } else {
                    j24 = getu32(fileChannel, allocate, j27 + 0);
                }
                if (j24 != 2) {
                    j27 += i10;
                    j28++;
                } else if (z11) {
                    j12 = getu32(fileChannel, allocate, j27 + 4);
                } else {
                    j12 = get64(fileChannel, allocate, j27 + 8);
                }
            }
            long j29 = 0;
            if (j12 == 0) {
                throw new ElfError("ELF file does not contain dynamic linking information");
            }
            long j30 = j12;
            long j31 = 0;
            int i11 = 0;
            while (true) {
                if (z11) {
                    z10 = z11;
                    j13 = getu32(fileChannel, allocate, j30 + j29);
                } else {
                    z10 = z11;
                    j13 = get64(fileChannel, allocate, j30 + j29);
                }
                if (j13 == 1) {
                    j14 = j12;
                    if (i11 == Integer.MAX_VALUE) {
                        throw new ElfError("malformed DT_NEEDED section");
                    }
                    i11++;
                } else {
                    j14 = j12;
                    if (j13 == 5) {
                        if (z10) {
                            j15 = getu32(fileChannel, allocate, j30 + 4);
                        } else {
                            j15 = get64(fileChannel, allocate, j30 + 8);
                        }
                        j31 = j15;
                    }
                }
                long j32 = 16;
                j30 += z10 ? 8L : 16L;
                j29 = 0;
                if (j13 != 0) {
                    z11 = z10;
                    j12 = j14;
                } else {
                    if (j31 == 0) {
                        throw new ElfError("Dynamic section string-table not found");
                    }
                    int i12 = 0;
                    while (true) {
                        if (i12 >= j11) {
                            j16 = 0;
                            break;
                        }
                        if (z10) {
                            j19 = getu32(fileChannel, allocate, j10 + j29);
                        } else {
                            j19 = getu32(fileChannel, allocate, j10 + j29);
                        }
                        if (j19 == 1) {
                            if (z10) {
                                j21 = getu32(fileChannel, allocate, j10 + 8);
                            } else {
                                j21 = get64(fileChannel, allocate, j10 + j32);
                            }
                            if (z10) {
                                j20 = j11;
                                j22 = getu32(fileChannel, allocate, j10 + 20);
                            } else {
                                j20 = j11;
                                j22 = get64(fileChannel, allocate, j10 + 40);
                            }
                            if (j21 <= j31 && j31 < j22 + j21) {
                                if (z10) {
                                    j23 = getu32(fileChannel, allocate, j10 + 4);
                                } else {
                                    j23 = get64(fileChannel, allocate, j10 + 8);
                                }
                                j16 = j23 + (j31 - j21);
                            }
                        } else {
                            j20 = j11;
                        }
                        j10 += i10;
                        i12++;
                        j11 = j20;
                        j32 = 16;
                        j29 = 0;
                    }
                    long j33 = 0;
                    if (j16 != 0) {
                        String[] strArr = new String[i11];
                        int i13 = 0;
                        while (true) {
                            if (z10) {
                                j17 = getu32(fileChannel, allocate, j14 + j33);
                            } else {
                                j17 = get64(fileChannel, allocate, j14 + j33);
                            }
                            if (j17 == 1) {
                                if (z10) {
                                    j18 = getu32(fileChannel, allocate, j14 + 4);
                                } else {
                                    j18 = get64(fileChannel, allocate, j14 + 8);
                                }
                                strArr[i13] = getSz(fileChannel, allocate, j18 + j16);
                                if (i13 == Integer.MAX_VALUE) {
                                    throw new ElfError("malformed DT_NEEDED section");
                                }
                                i13++;
                            }
                            j14 += z10 ? 8L : 16L;
                            if (j17 == 0) {
                                if (i13 == i11) {
                                    return strArr;
                                }
                                throw new ElfError("malformed DT_NEEDED section");
                            }
                            j33 = 0;
                        }
                    } else {
                        throw new ElfError("did not find file offset of DT_STRTAB table");
                    }
                }
            }
        } else {
            throw new ElfError("file is not ELF");
        }
    }
}
