package java.util.zip;

import com.huawei.quickcard.base.Attributes;
import java.nio.ByteBuffer;
import java.nio.file.attribute.FileTime;
import java.time.DateTimeException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import jdk.internal.misc.Unsafe;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class ZipUtils {
    static final long END_MAXLEN = 65557;
    static final int FILE_ATTRIBUTES_UNIX = 3;
    static final int READBLOCKSZ = 128;
    public static final long UPPER_UNIXTIME_BOUND = 2147483647L;
    static final int VERSION_MADE_BY_BASE_UNIX = 768;
    private static final long WINDOWS_EPOCH_IN_MICROSECONDS = -11644473600000000L;
    public static final long WINDOWS_TIME_NOT_AVAILABLE = Long.MIN_VALUE;
    private static final long byteBufferArrayOffset;
    private static final long byteBufferOffsetOffset;
    static final ByteBuffer defaultBuf = ByteBuffer.allocate(0);
    private static final Unsafe unsafe;

    ZipUtils() {
    }

    static {
        Unsafe unsafe2 = Unsafe.getUnsafe();
        unsafe = unsafe2;
        byteBufferArrayOffset = unsafe2.objectFieldOffset(ByteBuffer.class, "hb");
        byteBufferOffsetOffset = unsafe2.objectFieldOffset(ByteBuffer.class, Attributes.Style.OFFSET);
    }

    public static final FileTime winTimeToFileTime(long wtime) {
        return FileTime.from((wtime / 10) + WINDOWS_EPOCH_IN_MICROSECONDS, TimeUnit.MICROSECONDS);
    }

    public static final long fileTimeToWinTime(FileTime ftime) {
        return (ftime.to(TimeUnit.MICROSECONDS) - WINDOWS_EPOCH_IN_MICROSECONDS) * 10;
    }

    public static final FileTime unixTimeToFileTime(long utime) {
        return FileTime.from(utime, TimeUnit.SECONDS);
    }

    public static final long fileTimeToUnixTime(FileTime ftime) {
        return ftime.to(TimeUnit.SECONDS);
    }

    public static long dosToJavaTime(long dtime) {
        int year = (int) (((dtime >> 25) & 127) + 1980);
        int month = (int) ((dtime >> 21) & 15);
        int day = (int) ((dtime >> 16) & 31);
        int hour = (int) ((dtime >> 11) & 31);
        int minute = (int) ((dtime >> 5) & 63);
        int second = (int) ((dtime << 1) & 62);
        if (month > 0 && month < 13 && day > 0 && hour < 24 && minute < 60 && second < 60) {
            try {
                LocalDateTime ldt = LocalDateTime.of(year, month, day, hour, minute, second);
                return TimeUnit.MILLISECONDS.convert(ldt.toEpochSecond(ZoneId.systemDefault().getRules().getOffset(ldt)), TimeUnit.SECONDS);
            } catch (DateTimeException e2) {
            }
        }
        return overflowDosToJavaTime(year, month, day, hour, minute, second);
    }

    private static long overflowDosToJavaTime(int year, int month, int day, int hour, int minute, int second) {
        return new Date(year - 1900, month - 1, day, hour, minute, second).getTime();
    }

    public static long extendedDosToJavaTime(long xdostime) {
        long time = dosToJavaTime(xdostime);
        return (xdostime >> 32) + time;
    }

    private static long javaToDosTime(LocalDateTime ldt) {
        int year = ldt.getYear() - 1980;
        return ((year << 25) | (ldt.getMonthValue() << 21) | (ldt.getDayOfMonth() << 16) | (ldt.getHour() << 11) | (ldt.getMinute() << 5) | (ldt.getSecond() >> 1)) & 4294967295L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long javaToExtendedDosTime(long time) {
        LocalDateTime ldt = javaEpochToLocalDateTime(time);
        if (ldt.getYear() >= 1980) {
            return javaToDosTime(ldt) + ((time % 2000) << 32);
        }
        return 2162688L;
    }

    static LocalDateTime javaEpochToLocalDateTime(long time) {
        Instant instant = Instant.ofEpochMilli(time);
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
    }

    public static final int get16(byte[] b4, int off) {
        return (b4[off] & 255) | ((b4[off + 1] & 255) << 8);
    }

    public static final long get32(byte[] b4, int off) {
        return (get16(b4, off) | (get16(b4, off + 2) << 16)) & 4294967295L;
    }

    public static final long get64(byte[] b4, int off) {
        return get32(b4, off) | (get32(b4, off + 4) << 32);
    }

    public static final int get32S(byte[] b4, int off) {
        return get16(b4, off) | (get16(b4, off + 2) << 16);
    }

    static final int CH(byte[] b4, int n10) {
        return b4[n10] & 255;
    }

    static final int SH(byte[] b4, int n10) {
        return (b4[n10] & 255) | ((b4[n10 + 1] & 255) << 8);
    }

    static final long LG(byte[] b4, int n10) {
        return (SH(b4, n10) | (SH(b4, n10 + 2) << 16)) & 4294967295L;
    }

    static final long LL(byte[] b4, int n10) {
        return LG(b4, n10) | (LG(b4, n10 + 4) << 32);
    }

    static final long GETSIG(byte[] b4) {
        return LG(b4, 0);
    }

    static final long LOCSIG(byte[] b4) {
        return LG(b4, 0);
    }

    static final int LOCVER(byte[] b4) {
        return SH(b4, 4);
    }

    static final int LOCFLG(byte[] b4) {
        return SH(b4, 6);
    }

    static final int LOCHOW(byte[] b4) {
        return SH(b4, 8);
    }

    static final long LOCTIM(byte[] b4) {
        return LG(b4, 10);
    }

    static final long LOCCRC(byte[] b4) {
        return LG(b4, 14);
    }

    static final long LOCSIZ(byte[] b4) {
        return LG(b4, 18);
    }

    static final long LOCLEN(byte[] b4) {
        return LG(b4, 22);
    }

    static final int LOCNAM(byte[] b4) {
        return SH(b4, 26);
    }

    static final int LOCEXT(byte[] b4) {
        return SH(b4, 28);
    }

    static final long EXTCRC(byte[] b4) {
        return LG(b4, 4);
    }

    static final long EXTSIZ(byte[] b4) {
        return LG(b4, 8);
    }

    static final long EXTLEN(byte[] b4) {
        return LG(b4, 12);
    }

    static final int ENDSUB(byte[] b4) {
        return SH(b4, 8);
    }

    static final int ENDTOT(byte[] b4) {
        return SH(b4, 10);
    }

    static final long ENDSIZ(byte[] b4) {
        return LG(b4, 12);
    }

    static final long ENDOFF(byte[] b4) {
        return LG(b4, 16);
    }

    static final int ENDCOM(byte[] b4) {
        return SH(b4, 20);
    }

    static final int ENDCOM(byte[] b4, int off) {
        return SH(b4, off + 20);
    }

    static final long ZIP64_ENDTOD(byte[] b4) {
        return LL(b4, 24);
    }

    static final long ZIP64_ENDTOT(byte[] b4) {
        return LL(b4, 32);
    }

    static final long ZIP64_ENDSIZ(byte[] b4) {
        return LL(b4, 40);
    }

    static final long ZIP64_ENDOFF(byte[] b4) {
        return LL(b4, 48);
    }

    static final long ZIP64_LOCOFF(byte[] b4) {
        return LL(b4, 8);
    }

    static final long CENSIG(byte[] b4, int pos) {
        return LG(b4, pos + 0);
    }

    static final int CENVEM(byte[] b4, int pos) {
        return SH(b4, pos + 4);
    }

    static final int CENVEM_FA(byte[] b4, int pos) {
        return CH(b4, pos + 5);
    }

    static final int CENVER(byte[] b4, int pos) {
        return SH(b4, pos + 6);
    }

    static final int CENFLG(byte[] b4, int pos) {
        return SH(b4, pos + 8);
    }

    static final int CENHOW(byte[] b4, int pos) {
        return SH(b4, pos + 10);
    }

    static final long CENTIM(byte[] b4, int pos) {
        return LG(b4, pos + 12);
    }

    static final long CENCRC(byte[] b4, int pos) {
        return LG(b4, pos + 16);
    }

    static final long CENSIZ(byte[] b4, int pos) {
        return LG(b4, pos + 20);
    }

    static final long CENLEN(byte[] b4, int pos) {
        return LG(b4, pos + 24);
    }

    static final int CENNAM(byte[] b4, int pos) {
        return SH(b4, pos + 28);
    }

    static final int CENEXT(byte[] b4, int pos) {
        return SH(b4, pos + 30);
    }

    static final int CENCOM(byte[] b4, int pos) {
        return SH(b4, pos + 32);
    }

    static final int CENDSK(byte[] b4, int pos) {
        return SH(b4, pos + 34);
    }

    static final int CENATT(byte[] b4, int pos) {
        return SH(b4, pos + 36);
    }

    static final long CENATX(byte[] b4, int pos) {
        return LG(b4, pos + 38);
    }

    static final int CENATX_PERMS(byte[] b4, int pos) {
        return SH(b4, pos + 40);
    }

    static final long CENOFF(byte[] b4, int pos) {
        return LG(b4, pos + 42);
    }

    static byte[] getBufferArray(ByteBuffer byteBuffer) {
        return (byte[]) unsafe.getReference(byteBuffer, byteBufferArrayOffset);
    }

    static int getBufferOffset(ByteBuffer byteBuffer) {
        return unsafe.getInt(byteBuffer, byteBufferOffsetOffset);
    }
}
