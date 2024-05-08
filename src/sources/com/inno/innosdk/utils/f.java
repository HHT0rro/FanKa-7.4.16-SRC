package com.inno.innosdk.utils;

import android.util.Base64;
import androidx.exifinterface.media.ExifInterface;
import com.android.internal.midi.MidiConstants;
import java.io.ObjectStreamConstants;
import okio.Utf8;
import sun.security.util.DerValue;

/* compiled from: Cuid.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f35590a = {0, -43, Byte.MAX_VALUE, -86, -2, 43, -127, 84, 41, -4, 86, -125, -41, 2, -88, ObjectStreamConstants.TC_PROXYCLASSDESC, 82, -121, 45, -8, -84, ObjectStreamConstants.TC_RESET, -45, 6, ObjectStreamConstants.TC_EXCEPTION, -82, 4, -47, -123, 80, -6, 47, -92, ObjectStreamConstants.TC_REFERENCE, -37, 14, 90, -113, 37, -16, -115, 88, MidiConstants.STATUS_SONG_POSITION, 39, ObjectStreamConstants.TC_OBJECT, -90, 12, ExifInterface.MARKER_EOI, -10, 35, -119, 92, 8, -35, ObjectStreamConstants.TC_BLOCKDATA, -94, -33, 10, MidiConstants.STATUS_POLYPHONIC_AFTERTOUCH, ObjectStreamConstants.TC_ARRAY, 33, -12, 94, -117, -99, 72, -30, 55, 99, -74, 28, -55, -76, 97, -53, 30, 74, -97, 53, MidiConstants.STATUS_PITCH_BEND, -49, Character.CURRENCY_SYMBOL, MidiConstants.STATUS_CONTROL_CHANGE, 101, 49, -28, 78, -101, -26, 51, -103, 76, 24, -51, 103, -78, 57, -20, 70, -109, -57, 18, -72, 109, 16, -59, 111, -70, -18, 59, -111, 68, 107, -66, 20, -63, -107, DerValue.TAG_APPLICATION, -22, Utf8.REPLACEMENT_BYTE, 66, -105, 61, -24, -68, 105, -61, 22, -17, 58, MidiConstants.STATUS_NOTE_ON, 69, 17, -60, 110, -69, -58, 19, -71, 108, 56, -19, 71, -110, -67, 104, -62, 23, 67, -106, 60, -23, -108, 65, -21, 62, 106, -65, 21, -64, 75, -98, 52, ExifInterface.MARKER_APP1, -75, 96, -54, 31, 98, -73, Character.INITIAL_QUOTE_PUNCTUATION, -56, -100, 73, -29, 54, Character.MATH_SYMBOL, -52, 102, -77, -25, 50, -104, 77, 48, -27, 79, -102, -50, 27, -79, 100, ObjectStreamConstants.TC_CLASSDESC, -89, 13, -40, -116, 89, MidiConstants.STATUS_SONG_SELECT, 38, 91, -114, 36, MidiConstants.STATUS_MIDI_TIME_CODE, -91, 112, -38, 15, 32, -11, 95, -118, -34, 11, -95, ObjectStreamConstants.TC_STRING, 9, -36, ObjectStreamConstants.TC_CLASS, -93, -9, 34, -120, 93, -42, 3, -87, ObjectStreamConstants.TC_LONGSTRING, 40, -3, 87, -126, -1, ExifInterface.START_CODE, Byte.MIN_VALUE, 85, 1, -44, 126, -85, -124, 81, -5, 46, ObjectStreamConstants.TC_BLOCKDATALONG, -81, 5, MidiConstants.STATUS_CHANNEL_PRESSURE, -83, ObjectStreamConstants.TC_ENDBLOCKDATA, -46, 7, 83, -122, 44, -7};

    public static String a() {
        try {
            byte[] a10 = a(q.a());
            byte[] bArr = new byte[18];
            bArr[0] = 68;
            System.arraycopy((Object) a10, 0, (Object) bArr, 1, 16);
            bArr[17] = (byte) a(a10, 16);
            return Base64.encodeToString(bArr, 11);
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
            return "-1";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] a(java.lang.String r8) {
        /*
            r0 = 16
            byte[] r0 = new byte[r0]
            byte[] r1 = r8.getBytes()
            r2 = 0
            r3 = 1
            r3 = 0
            r4 = 0
            r5 = 1
        Ld:
            int r6 = r8.length()
            if (r2 >= r6) goto L4d
            r6 = r1[r2]
            r7 = 45
            if (r6 != r7) goto L1a
            goto L4a
        L1a:
            r7 = 48
            if (r6 < r7) goto L26
            r7 = 57
            if (r6 > r7) goto L26
            int r6 = r6 + (-48)
        L24:
            byte r6 = (byte) r6
            goto L3c
        L26:
            r7 = 97
            if (r6 < r7) goto L31
            r7 = 102(0x66, float:1.43E-43)
            if (r6 > r7) goto L31
            int r6 = r6 + (-87)
            goto L24
        L31:
            r7 = 65
            if (r6 < r7) goto L3c
            r7 = 70
            if (r6 > r7) goto L3c
            int r6 = r6 + (-55)
            goto L24
        L3c:
            if (r5 == 0) goto L42
            int r3 = r6 << 4
            byte r3 = (byte) r3
            goto L48
        L42:
            int r6 = r6 + r3
            byte r6 = (byte) r6
            r0[r4] = r6
            int r4 = r4 + 1
        L48:
            r5 = r5 ^ 1
        L4a:
            int r2 = r2 + 1
            goto Ld
        L4d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inno.innosdk.utils.f.a(java.lang.String):byte[]");
    }

    public static int a(byte[] bArr, int i10) {
        byte b4 = 0;
        for (int i11 = 0; i11 < i10; i11++) {
            b4 = f35590a[(b4 ^ bArr[i11]) & 255];
        }
        return b4;
    }
}
