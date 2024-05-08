package com.kuaishou.weapon.p0;

import android.os.Process;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class af {

    /* renamed from: a, reason: collision with root package name */
    private String[] f35760a = {"/sbin/.magisk/", "/sbin/.core/mirror", "/sbin/.core/img", "/sbin/.core/db-0/magisk.db"};

    public int a() {
        File file = new File(String.format("/proc/%d/mounts", Integer.valueOf(Process.myPid())));
        try {
            HashSet hashSet = new HashSet();
            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    String[] strArr = this.f35760a;
                    int length = strArr.length;
                    int i10 = 0;
                    while (true) {
                        if (i10 >= length) {
                            break;
                        }
                        if (readLine.contains(strArr[i10])) {
                            hashSet.add(readLine);
                            break;
                        }
                        i10++;
                    }
                } else {
                    bufferedReader.close();
                    fileInputStream.close();
                    return hashSet.size();
                }
            }
        } catch (Exception unused) {
            return 0;
        }
    }
}
