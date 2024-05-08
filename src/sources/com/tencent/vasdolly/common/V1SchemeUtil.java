package com.tencent.vasdolly.common;

import com.kuaishou.weapon.p0.t;
import com.tencent.vasdolly.common.apk.ApkSigningBlockUtils;
import com.tencent.vasdolly.common.apk.SignatureNotFoundException;
import com.tencent.vasdolly.common.apk.ZipUtils;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class V1SchemeUtil {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class ChannelExistException extends Exception {
        public static final long serialVersionUID = -3387516993124229949L;

        public ChannelExistException() {
        }

        public ChannelExistException(String str) {
            super(str);
        }
    }

    public static boolean containV1Magic(File file) throws IOException {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2 = null;
        try {
            randomAccessFile = new RandomAccessFile(file, t.f36226k);
        } catch (Throwable th) {
            th = th;
        }
        try {
            long length = randomAccessFile.length();
            byte[] bArr = new byte[ChannelConstants.V1_MAGIC.length];
            randomAccessFile.seek(length - r6.length);
            randomAccessFile.readFully(bArr);
            boolean isV1MagicMatch = isV1MagicMatch(bArr);
            randomAccessFile.close();
            return isV1MagicMatch;
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile2 = randomAccessFile;
            if (randomAccessFile2 != null) {
                randomAccessFile2.close();
            }
            throw th;
        }
    }

    public static boolean containV1Signature(File file) {
        try {
            JarFile jarFile = new JarFile(file);
            try {
                JarEntry jarEntry = jarFile.getJarEntry(JarFile.MANIFEST_NAME);
                JarEntry jarEntry2 = null;
                Enumeration<JarEntry> entries = jarFile.entries();
                while (true) {
                    if (!entries.hasMoreElements()) {
                        break;
                    }
                    JarEntry nextElement = entries.nextElement();
                    if (nextElement.getName().matches("META-INF/\\w+\\.SF")) {
                        jarEntry2 = jarFile.getJarEntry(nextElement.getName());
                        break;
                    }
                }
                jarFile.close();
                if (jarEntry == null || jarEntry2 == null) {
                    jarFile.close();
                    return false;
                }
                jarFile.close();
                return true;
            } finally {
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static void copyFile(File file, File file2) throws IOException {
        FileChannel fileChannel;
        if (!file2.exists()) {
            file2.createNewFile();
        }
        FileChannel fileChannel2 = null;
        try {
            FileChannel channel = new FileInputStream(file).getChannel();
            try {
                fileChannel2 = new FileOutputStream(file2).getChannel();
                fileChannel2.transferFrom(channel, 0L, channel.size());
                channel.close();
                fileChannel2.close();
            } catch (Throwable th) {
                th = th;
                FileChannel fileChannel3 = fileChannel2;
                fileChannel2 = channel;
                fileChannel = fileChannel3;
                if (fileChannel2 != null) {
                    fileChannel2.close();
                }
                if (fileChannel != null) {
                    fileChannel.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileChannel = null;
        }
    }

    public static Pair<ByteBuffer, Long> getEocd(File file) throws IOException, SignatureNotFoundException {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2 = null;
        if (file == null || !file.exists() || !file.isFile()) {
            return null;
        }
        try {
            randomAccessFile = new RandomAccessFile(file, t.f36226k);
        } catch (Throwable th) {
            th = th;
        }
        try {
            Pair<ByteBuffer, Long> eocd = ApkSigningBlockUtils.getEocd(randomAccessFile);
            if (!ZipUtils.isZip64EndOfCentralDirectoryLocatorPresent(randomAccessFile, eocd.getSecond().longValue())) {
                randomAccessFile.close();
                return eocd;
            }
            throw new SignatureNotFoundException("ZIP64 APK not supported");
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile2 = randomAccessFile;
            if (randomAccessFile2 != null) {
                randomAccessFile2.close();
            }
            throw th;
        }
    }

    private static boolean isV1MagicMatch(byte[] bArr) {
        if (bArr.length != ChannelConstants.V1_MAGIC.length) {
            return false;
        }
        int i10 = 0;
        while (true) {
            byte[] bArr2 = ChannelConstants.V1_MAGIC;
            if (i10 >= bArr2.length) {
                return true;
            }
            if (bArr[i10] != bArr2[i10]) {
                return false;
            }
            i10++;
        }
    }

    public static String readChannel(File file) throws Exception {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2 = null;
        try {
            randomAccessFile = new RandomAccessFile(file, t.f36226k);
        } catch (Throwable th) {
            th = th;
        }
        try {
            long length = randomAccessFile.length();
            byte[] bArr = new byte[ChannelConstants.V1_MAGIC.length];
            long length2 = length - r6.length;
            randomAccessFile.seek(length2);
            randomAccessFile.readFully(bArr);
            if (isV1MagicMatch(bArr)) {
                long j10 = length2 - 2;
                randomAccessFile.seek(j10);
                int readShort = readShort(randomAccessFile);
                if (readShort > 0) {
                    randomAccessFile.seek(j10 - readShort);
                    byte[] bArr2 = new byte[readShort];
                    randomAccessFile.readFully(bArr2);
                    String trim = new String(bArr2, "UTF-8").trim();
                    randomAccessFile.close();
                    return trim;
                }
                throw new Exception("zip channel info not found");
            }
            throw new Exception("zip v1 magic not found");
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile2 = randomAccessFile;
            if (randomAccessFile2 != null) {
                randomAccessFile2.close();
            }
            throw th;
        }
    }

    private static short readShort(DataInput dataInput) throws IOException {
        byte[] bArr = new byte[2];
        dataInput.readFully(bArr);
        return ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).getShort(0);
    }

    public static void removeChannelByV1(File file) throws Exception {
        RandomAccessFile randomAccessFile;
        if (file != null && file.exists() && file.isFile()) {
            RandomAccessFile randomAccessFile2 = null;
            Pair<ByteBuffer, Long> eocd = getEocd(file);
            if (eocd.getFirst().remaining() == 22) {
                System.out.println("file : " + file.getName() + " , has no comment");
                return;
            }
            System.out.println("file : " + file.getName() + " , has comment");
            int unsignedInt16 = ZipUtils.getUnsignedInt16(eocd.getFirst(), 20);
            try {
                randomAccessFile = new RandomAccessFile(file, "rw");
            } catch (Throwable th) {
                th = th;
            }
            try {
                randomAccessFile.seek((eocd.getSecond().longValue() + 22) - 2);
                writeShort(0, randomAccessFile);
                randomAccessFile.setLength(file.length() - unsignedInt16);
                System.out.println("file : " + file.getName() + " , remove comment success");
                randomAccessFile.close();
                return;
            } catch (Throwable th2) {
                th = th2;
                randomAccessFile2 = randomAccessFile;
                if (randomAccessFile2 != null) {
                    randomAccessFile2.close();
                }
                throw th;
            }
        }
        throw new Exception("param error , file : " + ((Object) file));
    }

    public static void writeChannel(File file, String str) throws Exception {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2;
        if (file != null && file.exists() && file.isFile() && str != null && !str.isEmpty()) {
            RandomAccessFile randomAccessFile3 = null;
            byte[] bytes = str.getBytes("UTF-8");
            Pair<ByteBuffer, Long> eocd = getEocd(file);
            if (eocd.getFirst().remaining() == 22) {
                System.out.println("file : " + file.getAbsolutePath() + " , has no comment");
                try {
                    randomAccessFile2 = new RandomAccessFile(file, "rw");
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    randomAccessFile2.seek(file.length() - 2);
                    int length = bytes.length + 2;
                    byte[] bArr = ChannelConstants.V1_MAGIC;
                    writeShort(length + bArr.length, randomAccessFile2);
                    randomAccessFile2.write(bytes);
                    writeShort(bytes.length, randomAccessFile2);
                    randomAccessFile2.write(bArr);
                    randomAccessFile2.close();
                    return;
                } catch (Throwable th2) {
                    th = th2;
                    randomAccessFile3 = randomAccessFile2;
                    if (randomAccessFile3 != null) {
                        randomAccessFile3.close();
                    }
                    throw th;
                }
            }
            System.out.println("file : " + file.getAbsolutePath() + " , has comment");
            if (containV1Magic(file)) {
                try {
                    String readChannel = readChannel(file);
                    if (readChannel != null) {
                        file.delete();
                        throw new ChannelExistException("file : " + file.getAbsolutePath() + " has a channel : " + readChannel + ", only ignore");
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            int unsignedInt16 = ZipUtils.getUnsignedInt16(eocd.getFirst(), 20);
            int length2 = bytes.length + unsignedInt16 + 2;
            byte[] bArr2 = ChannelConstants.V1_MAGIC;
            int length3 = length2 + bArr2.length;
            try {
                randomAccessFile = new RandomAccessFile(file, "rw");
            } catch (Throwable th3) {
                th = th3;
            }
            try {
                randomAccessFile.seek((eocd.getSecond().longValue() + 22) - 2);
                writeShort(length3, randomAccessFile);
                randomAccessFile.seek(eocd.getSecond().longValue() + 22 + unsignedInt16);
                randomAccessFile.write(bytes);
                writeShort(bytes.length, randomAccessFile);
                randomAccessFile.write(bArr2);
                randomAccessFile.close();
                return;
            } catch (Throwable th4) {
                th = th4;
                randomAccessFile3 = randomAccessFile;
                if (randomAccessFile3 != null) {
                    randomAccessFile3.close();
                }
                throw th;
            }
        }
        throw new Exception("param error , file : " + ((Object) file) + " , channel : " + str);
    }

    private static void writeShort(int i10, DataOutput dataOutput) throws IOException {
        ByteBuffer order = ByteBuffer.allocate(2).order(ByteOrder.LITTLE_ENDIAN);
        order.putShort((short) i10);
        dataOutput.write(order.array());
    }
}
