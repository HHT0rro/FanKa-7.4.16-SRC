package com.wangmai.adIdUtils.cnadid;

import android.content.Context;
import android.os.Environment;
import android.provider.Settings;
import android.text.TextUtils;
import com.wangmai.adIdUtils.ByteStreams;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class CNAdidHelper {
    public String TAG;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class Inner {
        public static final CNAdidHelper instance = new CNAdidHelper();
    }

    private String getCNAdID1(Context context) {
        try {
            return Settings.System.getString(context.getContentResolver(), "ZHVzY2Lk");
        } catch (Throwable unused) {
            return "";
        }
    }

    private String getCNAdID2(Context context) {
        try {
            String string = context.getSharedPreferences(context.getPackageName() + "_dna", 0).getString("ZHVzY2Lk", "NA");
            try {
                if (string.equals("NA")) {
                    return null;
                }
                return string;
            } catch (Throwable unused) {
                return string;
            }
        } catch (Throwable unused2) {
            return "";
        }
    }

    private String getCNAdID3() {
        String str;
        str = "";
        try {
            File file = new File("/sdcard/Android/ZHVzY2Lk");
            if (!file.isDirectory() && file.isFile()) {
                FileInputStream fileInputStream = new FileInputStream(file);
                String readLine = new BufferedReader(new InputStreamReader(fileInputStream)).readLine();
                str = readLine != null ? readLine : "";
                fileInputStream.close();
                return str;
            }
            return null;
        } catch (Throwable unused) {
            return str;
        }
    }

    private String getCNAdID4() {
        FileInputStream fileInputStream;
        String filePath = getFilePath();
        File file = new File(filePath);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("getCNAdID4--");
        sb2.append(filePath);
        if (file.exists()) {
            FileInputStream fileInputStream2 = null;
            try {
                fileInputStream = new FileInputStream(filePath);
            } catch (Throwable unused) {
            }
            try {
                String str = new String(ByteStreams.toByteArray(fileInputStream));
                StringBuilder sb3 = new StringBuilder();
                sb3.append("getCNAdID4--data--");
                sb3.append(str);
                try {
                    fileInputStream.close();
                } catch (IOException unused2) {
                }
                return str;
            } catch (Throwable unused3) {
                fileInputStream2 = fileInputStream;
                try {
                    String writeToFile = writeToFile();
                    if (fileInputStream2 == null) {
                        return writeToFile;
                    }
                    try {
                        fileInputStream2.close();
                        return writeToFile;
                    } catch (IOException unused4) {
                        return writeToFile;
                    }
                } catch (Throwable th) {
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException unused5) {
                        }
                    }
                    throw th;
                }
            }
        }
        String writeToFile2 = writeToFile();
        StringBuilder sb4 = new StringBuilder();
        sb4.append("getCNAdID4--data--existsfalsedata--");
        sb4.append(writeToFile2);
        return writeToFile2;
    }

    private String getFilePath() {
        String str;
        try {
            if (Environment.getExternalStorageState().equals("mounted")) {
                str = ((Object) Environment.getExternalStorageDirectory()) + File.separator + "ZHVzY2Lk1.txt";
            } else {
                str = ((Object) Environment.getDownloadCacheDirectory()) + File.separator + "ZHVzY2Lk1.txt";
            }
            return str;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static CNAdidHelper getInstance() {
        return Inner.instance;
    }

    public static String getRandomString(int i10) {
        StringBuffer stringBuffer;
        try {
            Random random = new Random();
            stringBuffer = new StringBuffer();
            for (int i11 = 0; i11 < i10; i11++) {
                try {
                    stringBuffer.append("zxcvbnmlkjhgfdsaqwertyuiopQWERTYUIOPASDFGHJKLZXCVBNM1234567890".charAt(random.nextInt(62)));
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable unused2) {
            stringBuffer = null;
        }
        return stringBuffer.toString();
    }

    private String writeToFile() {
        Throwable th;
        FileOutputStream fileOutputStream;
        String randomString = getRandomString(32);
        try {
            try {
                File file = new File(getFilePath());
                if (!file.exists()) {
                    new File(file.getParent()).mkdirs();
                    file.createNewFile();
                }
                fileOutputStream = new FileOutputStream(file);
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
            }
            try {
                fileOutputStream.write(randomString.getBytes());
                fileOutputStream.close();
                fileOutputStream.close();
            } catch (Throwable th3) {
                th = th3;
                try {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("读取失败：");
                    sb2.append(th.getMessage());
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    return randomString;
                } catch (Throwable th4) {
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused) {
                        }
                    }
                    throw th4;
                }
            }
        } catch (IOException unused2) {
        }
        return randomString;
    }

    public String readCNAdid(Context context) {
        try {
            String cNAdID1 = getCNAdID1(context);
            if (!TextUtils.isEmpty(cNAdID1)) {
                return cNAdID1;
            }
            String cNAdID2 = getCNAdID2(context);
            if (!TextUtils.isEmpty(cNAdID2)) {
                return cNAdID2;
            }
            String cNAdID3 = getCNAdID3();
            if (!TextUtils.isEmpty(cNAdID3)) {
                return cNAdID3;
            }
            String cNAdID4 = getCNAdID4();
            return !TextUtils.isEmpty(cNAdID4) ? cNAdID4 : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public CNAdidHelper() {
        this.TAG = "CNAdidHelper";
    }
}
