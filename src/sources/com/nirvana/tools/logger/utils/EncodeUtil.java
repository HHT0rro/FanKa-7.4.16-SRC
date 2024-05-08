package com.nirvana.tools.logger.utils;

import android.text.TextUtils;
import java.nio.ByteBuffer;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class EncodeUtil {
    public static String decode(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            StringBuffer stringBuffer = new StringBuffer(str);
            ByteBuffer allocate = ByteBuffer.allocate(str.length() / 2);
            int i10 = 0;
            while (i10 < str.length()) {
                int i11 = i10 + 1;
                int parseInt = Integer.parseInt(stringBuffer.substring(i10, i11), 16) << 4;
                i10 += 2;
                allocate.put((byte) (Integer.parseInt(stringBuffer.substring(i11, i10), 16) | parseInt));
            }
            byte[] array = allocate.array();
            for (int i12 = 0; i12 < array.length; i12++) {
                if (i12 == array.length - 1) {
                    int length = array.length - 1;
                    array[length] = (byte) (array[length] ^ 98);
                } else {
                    int i13 = i12 + 1;
                    if (array[i12] != array[i13]) {
                        array[i12] = (byte) (array[i12] ^ array[i13]);
                    }
                }
            }
            for (int length2 = array.length - 1; length2 >= 0; length2--) {
                if (length2 == 0) {
                    array[0] = (byte) (array[0] ^ 69);
                } else {
                    int i14 = length2 - 1;
                    if (array[length2] != array[i14]) {
                        array[length2] = (byte) (array[length2] ^ array[i14]);
                    }
                }
            }
            return new String(array, "UTF-8");
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String encode(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        byte[] bytes = str.getBytes();
        int length = bytes.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (i10 == 0) {
                bytes[0] = (byte) (bytes[0] ^ 69);
            } else {
                int i11 = i10 - 1;
                if (bytes[i10] != bytes[i11]) {
                    bytes[i10] = (byte) (bytes[i10] ^ bytes[i11]);
                }
            }
        }
        int i12 = length - 1;
        for (int i13 = i12; i13 >= 0; i13--) {
            if (i13 == i12) {
                bytes[i13] = (byte) (bytes[i13] ^ 98);
            } else {
                int i14 = i13 + 1;
                if (bytes[i13] != bytes[i14]) {
                    bytes[i13] = (byte) (bytes[i13] ^ bytes[i14]);
                }
            }
        }
        String str2 = "";
        for (byte b4 : bytes) {
            str2 = str2 + Integer.toHexString((b4 & 255) | (-256)).substring(6);
        }
        return str2;
    }
}
