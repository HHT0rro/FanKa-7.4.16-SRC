package com.tencent.vasdolly.common;

import com.kuaishou.weapon.p0.t;
import com.tencent.vasdolly.common.apk.ApkSigningBlockUtils;
import com.tencent.vasdolly.common.apk.SignatureNotFoundException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.zip.ZipUtils;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class V2SchemeUtil {
    public static final int APK_SIGNATURE_SCHEME_V2_BLOCK_ID = 1896449818;

    public static boolean containV2Signature(File file) {
        try {
            return getAllIdValue(getApkSigningBlock(file)).containsKey(Integer.valueOf(APK_SIGNATURE_SCHEME_V2_BLOCK_ID));
        } catch (SignatureNotFoundException unused) {
            System.out.println("APK : " + file.getAbsolutePath() + " not have apk v2 signature block");
            return false;
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static Pair<ByteBuffer, Long> findCentralDir(RandomAccessFile randomAccessFile, long j10, int i10) throws IOException {
        return Pair.create(getByteBuffer(randomAccessFile, j10, i10), Long.valueOf(j10));
    }

    public static Pair<ByteBuffer, Long> findContentEntry(RandomAccessFile randomAccessFile, int i10) throws IOException {
        return Pair.create(getByteBuffer(randomAccessFile, 0L, i10), 0L);
    }

    public static ByteBuffer generateApkSigningBlock(Map<Integer, ByteBuffer> map) {
        if (map != null && !map.isEmpty()) {
            long j10 = 24;
            while (map.entrySet().iterator2().hasNext()) {
                j10 += r2.next().getValue().remaining() + 12;
            }
            boolean containsKey = map.containsKey(Integer.valueOf(ApkSigningBlockUtils.VERITY_PADDING_BLOCK_ID));
            System.out.println("generateApkSigningBlock , needPadding = " + containsKey);
            if (containsKey) {
                j10 -= map.get(Integer.valueOf(ApkSigningBlockUtils.VERITY_PADDING_BLOCK_ID)).remaining() + 12;
                map.remove(Integer.valueOf(ApkSigningBlockUtils.VERITY_PADDING_BLOCK_ID));
                int i10 = (int) ((j10 + 8) % 4096);
                if (i10 != 0) {
                    int i11 = 4096 - i10;
                    if (i11 < 12) {
                        i11 += 4096;
                    }
                    j10 += i11;
                    int i12 = (i11 - 8) - 4;
                    map.put(Integer.valueOf(ApkSigningBlockUtils.VERITY_PADDING_BLOCK_ID), ByteBuffer.allocate(i12).order(ByteOrder.LITTLE_ENDIAN));
                    System.out.println("generateApkSigningBlock , final length = " + j10 + " padding = " + i11 + " bufferSize = " + i12);
                }
            }
            ByteBuffer allocate = ByteBuffer.allocate((int) (8 + j10));
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            allocate.putLong(j10);
            for (Map.Entry<Integer, ByteBuffer> entry : map.entrySet()) {
                ByteBuffer value = entry.getValue();
                allocate.putLong(value.remaining() + 4);
                allocate.putInt(entry.getKey().intValue());
                allocate.put(value.array(), value.arrayOffset() + value.position(), value.remaining());
            }
            allocate.putLong(j10);
            allocate.putLong(ApkSigningBlockUtils.APK_SIG_BLOCK_MAGIC_LO);
            allocate.putLong(ApkSigningBlockUtils.APK_SIG_BLOCK_MAGIC_HI);
            if (allocate.remaining() <= 0) {
                allocate.flip();
                return allocate;
            }
            throw new RuntimeException("generateNewApkV2SchemeBlock error");
        }
        throw new RuntimeException("getNewApkV2SchemeBlock , id value pair is empty");
    }

    public static Map<Integer, ByteBuffer> getAllIdValue(ByteBuffer byteBuffer) throws SignatureNotFoundException {
        ApkSigningBlockUtils.checkByteOrderLittleEndian(byteBuffer);
        ByteBuffer sliceFromTo = ApkSigningBlockUtils.sliceFromTo(byteBuffer, 8, byteBuffer.capacity() - 24);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i10 = 0;
        while (sliceFromTo.hasRemaining()) {
            i10++;
            if (sliceFromTo.remaining() >= 8) {
                long j10 = sliceFromTo.getLong();
                if (j10 >= 4 && j10 <= ZipUtils.UPPER_UNIXTIME_BOUND) {
                    int i11 = (int) j10;
                    int position = sliceFromTo.position() + i11;
                    if (i11 <= sliceFromTo.remaining()) {
                        linkedHashMap.put(Integer.valueOf(sliceFromTo.getInt()), ApkSigningBlockUtils.getByteBuffer(sliceFromTo, i11 - 4));
                        sliceFromTo.position(position);
                    } else {
                        throw new SignatureNotFoundException("APK Signing Block entry #" + i10 + " size out of range: " + i11 + ", available: " + sliceFromTo.remaining());
                    }
                } else {
                    throw new SignatureNotFoundException("APK Signing Block entry #" + i10 + " size out of range: " + j10);
                }
            } else {
                throw new SignatureNotFoundException("Insufficient data to read size of APK Signing Block entry #" + i10);
            }
        }
        if (!linkedHashMap.isEmpty()) {
            return linkedHashMap;
        }
        throw new SignatureNotFoundException("not have Id-Value Pair in APK Signing Block entry #" + i10);
    }

    public static ApkSectionInfo getApkSectionInfo(File file, boolean z10) throws IOException, SignatureNotFoundException {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2 = null;
        try {
            randomAccessFile = new RandomAccessFile(file, t.f36226k);
        } catch (Throwable th) {
            th = th;
        }
        try {
            Pair<ByteBuffer, Long> eocd = ApkSigningBlockUtils.getEocd(randomAccessFile);
            ByteBuffer first = eocd.getFirst();
            long longValue = eocd.getSecond().longValue();
            if (!com.tencent.vasdolly.common.apk.ZipUtils.isZip64EndOfCentralDirectoryLocatorPresent(randomAccessFile, longValue)) {
                long centralDirOffset = ApkSigningBlockUtils.getCentralDirOffset(first, longValue);
                Pair<ByteBuffer, Long> findApkSigningBlock = ApkSigningBlockUtils.findApkSigningBlock(randomAccessFile, centralDirOffset);
                Pair<ByteBuffer, Long> findCentralDir = findCentralDir(randomAccessFile, centralDirOffset, (int) (longValue - centralDirOffset));
                ApkSectionInfo apkSectionInfo = new ApkSectionInfo();
                long length = file.length();
                apkSectionInfo.apkSize = length;
                apkSectionInfo.lowMemory = z10;
                if (length > ApkSectionInfo.COPY_CONTENT_MAX_SIZE) {
                    apkSectionInfo.lowMemory = true;
                }
                if (!apkSectionInfo.lowMemory) {
                    apkSectionInfo.contentEntry = findContentEntry(randomAccessFile, (int) findApkSigningBlock.getSecond().longValue());
                }
                apkSectionInfo.apkSigningBlock = findApkSigningBlock;
                apkSectionInfo.centralDir = findCentralDir;
                apkSectionInfo.eocd = eocd;
                apkSectionInfo.checkParamters();
                System.out.println("baseApk : " + file.getAbsolutePath() + "\nApkSectionInfo = " + ((Object) apkSectionInfo));
                randomAccessFile.close();
                return apkSectionInfo;
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

    public static ByteBuffer getApkSigningBlock(File file) throws SignatureNotFoundException, IOException {
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
            ByteBuffer first = eocd.getFirst();
            long longValue = eocd.getSecond().longValue();
            if (!com.tencent.vasdolly.common.apk.ZipUtils.isZip64EndOfCentralDirectoryLocatorPresent(randomAccessFile, longValue)) {
                ByteBuffer first2 = ApkSigningBlockUtils.findApkSigningBlock(randomAccessFile, ApkSigningBlockUtils.getCentralDirOffset(first, longValue)).getFirst();
                randomAccessFile.close();
                return first2;
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

    private static ByteBuffer getByteBuffer(RandomAccessFile randomAccessFile, long j10, int i10) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(i10);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        randomAccessFile.seek(j10);
        randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
        return allocate;
    }
}
