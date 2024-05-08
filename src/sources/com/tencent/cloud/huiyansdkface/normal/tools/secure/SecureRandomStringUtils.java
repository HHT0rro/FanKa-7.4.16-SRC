package com.tencent.cloud.huiyansdkface.normal.tools.secure;

import java.security.SecureRandom;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class SecureRandomStringUtils {
    public static String randomAlphabetic(int i10) {
        try {
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            StringBuffer stringBuffer = new StringBuffer();
            for (int i11 = 0; i11 < i10; i11++) {
                int abs = Math.abs(secureRandom.nextInt() % 52);
                if (abs > 26) {
                    stringBuffer.append((char) ((abs - 26) + 97));
                } else {
                    stringBuffer.append((char) (abs + 65));
                }
            }
            return stringBuffer.toString();
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static int randomNum(int i10) {
        try {
            return SecureRandom.getInstance("SHA1PRNG").nextInt(i10);
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static String randomNumeric(int i10) {
        String str = "";
        try {
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            for (int i11 = 0; i11 < i10; i11++) {
                str = str + new Integer(secureRandom.nextInt(i10)).toString();
                if (str.length() >= i10) {
                    break;
                }
            }
            return str.substring(0, i10);
        } catch (Exception e2) {
            e2.printStackTrace();
            return str;
        }
    }
}
