package com.bytedance.pangle.e;

import com.bytedance.pangle.log.ZeusLogger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class a {
    public static boolean a(String[] strArr) {
        if (strArr.length <= 0) {
            return false;
        }
        try {
            Process exec = Runtime.getRuntime().exec(strArr);
            InputStream errorStream = exec.getErrorStream();
            InputStream inputStream = exec.getInputStream();
            a(errorStream);
            a(inputStream);
            if (exec.waitFor() == 0) {
                return true;
            }
            ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "exec dex2oat failed : " + Arrays.toString(strArr));
            return false;
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        } catch (InterruptedException e10) {
            e10.printStackTrace();
            return false;
        }
    }

    private static void a(final InputStream inputStream) {
        com.bytedance.pangle.d.e.a(new Runnable() { // from class: com.bytedance.pangle.e.a.1
            @Override // java.lang.Runnable
            public final void run() {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(InputStream.this));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            return;
                        } else {
                            ZeusLogger.d(ZeusLogger.TAG_INSTALL, "exec cmd info : ".concat(readLine));
                        }
                    } catch (IOException e2) {
                        ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "execCmd consumeInputStream failed : ".concat(String.valueOf(e2)));
                        return;
                    } finally {
                        com.bytedance.pangle.util.g.a(bufferedReader);
                    }
                }
            }
        });
    }
}
