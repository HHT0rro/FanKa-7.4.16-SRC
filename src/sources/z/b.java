package z;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class b {
    public static String a(String str, String str2) {
        File file;
        StringBuilder sb2 = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            try {
                file = new File(str, str2);
            } catch (IOException unused) {
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable unused2) {
        }
        if (!file.exists()) {
            return null;
        }
        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
        while (true) {
            try {
                String readLine = bufferedReader2.readLine();
                if (readLine == null) {
                    break;
                }
                sb2.append(readLine);
            } catch (IOException unused3) {
                bufferedReader = bufferedReader2;
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                return sb2.toString();
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = bufferedReader2;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable unused4) {
                    }
                }
                throw th;
            }
        }
        bufferedReader2.close();
        return sb2.toString();
    }
}
