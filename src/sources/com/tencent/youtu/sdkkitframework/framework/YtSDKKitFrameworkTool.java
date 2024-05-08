package com.tencent.youtu.sdkkitframework.framework;

import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.u;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class YtSDKKitFrameworkTool {

    /* renamed from: e, reason: collision with root package name */
    private static char[] f46004e = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a, reason: collision with root package name */
    private final String f46005a = "files_md5";

    /* renamed from: b, reason: collision with root package name */
    private final String f46006b = "face-tracker-v001";

    /* renamed from: c, reason: collision with root package name */
    private final Map<String, String> f46007c = new ConcurrentHashMap();

    /* renamed from: d, reason: collision with root package name */
    private final String f46008d = YtSDKKitFrameworkTool.class.getSimpleName();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum a {
        VALIDITY_OK,
        NOT_FOUND_MODEL_DIR,
        NOT_FOUND_MODEL_MD5,
        READ_MD5_ERROR,
        VALIDITY_ERROR,
        TARGET_MD5_NOT_FOUND,
        CREATE_MD5_ERROR,
        MODEL_FILE_MISS
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v5, types: [java.io.BufferedReader] */
    private int a(File file) {
        InputStreamReader inputStreamReader;
        Throwable th;
        Exception e2;
        BufferedReader bufferedReader;
        String str;
        StringBuilder sb2;
        String str2;
        StringBuilder sb3;
        try {
            try {
                inputStreamReader = new InputStreamReader(new FileInputStream((File) file));
                try {
                    bufferedReader = new BufferedReader(inputStreamReader);
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                try {
                                    bufferedReader.close();
                                    try {
                                        inputStreamReader.close();
                                        return 0;
                                    } catch (IOException e10) {
                                        e = e10;
                                        str2 = this.f46008d;
                                        sb3 = new StringBuilder();
                                        sb3.append("get modle md5 to map close io  error:");
                                        sb3.append(e.toString());
                                        WLogger.e(str2, sb3.toString());
                                        e.printStackTrace();
                                        return -1;
                                    }
                                } catch (IOException e11) {
                                    e = e11;
                                    str = this.f46008d;
                                    sb2 = new StringBuilder();
                                    sb2.append("get modle md5 to map close io error:");
                                    sb2.append(e.toString());
                                    WLogger.e(str, sb2.toString());
                                    e.printStackTrace();
                                    return -1;
                                }
                            }
                            String[] split = readLine.split(u.bD);
                            if (split.length >= 2) {
                                if (TextUtils.isEmpty(split[0]) || TextUtils.isEmpty(split[1])) {
                                    break;
                                }
                                this.f46007c.put(split[0].trim(), split[1].trim());
                            } else {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e12) {
                                    e = e12;
                                    str = this.f46008d;
                                    sb2 = new StringBuilder();
                                    sb2.append("get modle md5 to map close io error:");
                                    sb2.append(e.toString());
                                    WLogger.e(str, sb2.toString());
                                    e.printStackTrace();
                                    return -1;
                                }
                                try {
                                    inputStreamReader.close();
                                    return -2;
                                } catch (IOException e13) {
                                    e = e13;
                                    str2 = this.f46008d;
                                    sb3 = new StringBuilder();
                                    sb3.append("get modle md5 to map close io  error:");
                                    sb3.append(e.toString());
                                    WLogger.e(str2, sb3.toString());
                                    e.printStackTrace();
                                    return -1;
                                }
                            }
                        } catch (Exception e14) {
                            e2 = e14;
                            WLogger.e(this.f46008d, "get modle md5 to map error:" + e2.toString());
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e15) {
                                    e = e15;
                                    str = this.f46008d;
                                    sb2 = new StringBuilder();
                                    sb2.append("get modle md5 to map close io error:");
                                    sb2.append(e.toString());
                                    WLogger.e(str, sb2.toString());
                                    e.printStackTrace();
                                    return -1;
                                }
                            }
                            if (inputStreamReader != null) {
                                try {
                                    inputStreamReader.close();
                                } catch (IOException e16) {
                                    e = e16;
                                    str2 = this.f46008d;
                                    sb3 = new StringBuilder();
                                    sb3.append("get modle md5 to map close io  error:");
                                    sb3.append(e.toString());
                                    WLogger.e(str2, sb3.toString());
                                    e.printStackTrace();
                                    return -1;
                                }
                            }
                            return -1;
                        }
                    }
                    try {
                        bufferedReader.close();
                        try {
                            inputStreamReader.close();
                            return -3;
                        } catch (IOException e17) {
                            e = e17;
                            str2 = this.f46008d;
                            sb3 = new StringBuilder();
                            sb3.append("get modle md5 to map close io  error:");
                            sb3.append(e.toString());
                            WLogger.e(str2, sb3.toString());
                            e.printStackTrace();
                            return -1;
                        }
                    } catch (IOException e18) {
                        e = e18;
                        str = this.f46008d;
                        sb2 = new StringBuilder();
                        sb2.append("get modle md5 to map close io error:");
                        sb2.append(e.toString());
                        WLogger.e(str, sb2.toString());
                        e.printStackTrace();
                        return -1;
                    }
                } catch (Exception e19) {
                    e2 = e19;
                    bufferedReader = null;
                } catch (Throwable th2) {
                    th = th2;
                    file = 0;
                    if (file != 0) {
                        try {
                            file.close();
                        } catch (IOException e20) {
                            e = e20;
                            str = this.f46008d;
                            sb2 = new StringBuilder();
                            sb2.append("get modle md5 to map close io error:");
                            sb2.append(e.toString());
                            WLogger.e(str, sb2.toString());
                            e.printStackTrace();
                            return -1;
                        }
                    }
                    if (inputStreamReader != null) {
                        try {
                            inputStreamReader.close();
                        } catch (IOException e21) {
                            e = e21;
                            str2 = this.f46008d;
                            sb3 = new StringBuilder();
                            sb3.append("get modle md5 to map close io  error:");
                            sb3.append(e.toString());
                            WLogger.e(str2, sb3.toString());
                            e.printStackTrace();
                            return -1;
                        }
                    }
                    throw th;
                }
            } catch (Exception e22) {
                inputStreamReader = null;
                e2 = e22;
                bufferedReader = null;
            } catch (Throwable th3) {
                inputStreamReader = null;
                th = th3;
                file = 0;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    private String a(InputStream inputStream) {
        String str;
        StringBuilder sb2;
        String noSuchAlgorithmException;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] bArr = new byte[4196];
            int i10 = 0;
            while (true) {
                int read = inputStream.read(bArr, 0, 4196);
                if (read == -1) {
                    break;
                }
                if (read > 0) {
                    messageDigest.update(bArr, 0, read);
                    i10 += read;
                }
            }
            return i10 == 0 ? "" : a(messageDigest.digest());
        } catch (IOException e2) {
            e2.printStackTrace();
            str = this.f46008d;
            sb2 = new StringBuilder();
            sb2.append("get input stream  md5 error ");
            noSuchAlgorithmException = e2.toString();
            sb2.append(noSuchAlgorithmException);
            WLogger.e(str, sb2.toString());
            return "";
        } catch (NoSuchAlgorithmException e10) {
            e10.printStackTrace();
            str = this.f46008d;
            sb2 = new StringBuilder();
            sb2.append("get input stream  md5 error ");
            noSuchAlgorithmException = e10.toString();
            sb2.append(noSuchAlgorithmException);
            WLogger.e(str, sb2.toString());
            return "";
        }
    }

    private String a(byte[] bArr) {
        if (bArr == null || bArr.length != 16) {
            return "";
        }
        char[] cArr = new char[32];
        int i10 = 0;
        for (int i11 = 0; i11 < 16; i11++) {
            byte b4 = bArr[i11];
            int i12 = i10 + 1;
            char[] cArr2 = f46004e;
            cArr[i10] = cArr2[(b4 >>> 4) & 15];
            i10 = i12 + 1;
            cArr[i12] = cArr2[b4 & 15];
        }
        return new String(cArr);
    }

    private void a(File file, List<String> list) {
        File[] listFiles = file.listFiles();
        if (listFiles == null || listFiles.length == 0) {
            WLogger.e(this.f46008d, "dir is empty");
            return;
        }
        for (File file2 : listFiles) {
            if (file2.isDirectory()) {
                a(file2, list);
            } else {
                String path = file2.getPath();
                if (!file2.getName().equalsIgnoreCase("files_md5")) {
                    list.add(path);
                }
            }
        }
    }

    private int b(File file) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        a(file, copyOnWriteArrayList);
        if (copyOnWriteArrayList.size() == 0) {
            WLogger.e(this.f46008d, "dir is empty");
            return -1;
        }
        for (String str : copyOnWriteArrayList) {
            String substring = str.substring(str.indexOf("face-tracker-v001") + 17 + 1);
            if (!this.f46007c.containsKey(substring)) {
                WLogger.e(this.f46008d, "the file name not found md5 with md5 map");
                return -3;
            }
            String c4 = c(new File(str));
            if (TextUtils.isEmpty(c4)) {
                WLogger.e(this.f46008d, "create md5 by file is error,md5 is null");
                return -4;
            }
            if (!c4.equalsIgnoreCase(this.f46007c.get(substring))) {
                WLogger.e(this.f46008d, "md5 validity by dir error,file name is " + substring + "   target md5 is " + this.f46007c.get(substring) + " cur md5 is " + c4);
                return -2;
            }
            this.f46007c.remove(substring);
        }
        if (this.f46007c.size() == 0) {
            return 0;
        }
        for (String str2 : this.f46007c.h()) {
            WLogger.e(this.f46008d, "module file miss:" + str2 + " md5:" + this.f46007c.get(str2));
        }
        return -5;
    }

    private String c(File file) {
        String str;
        StringBuilder sb2;
        if (file != null && file.exists() && file.length() > 0) {
            BufferedInputStream bufferedInputStream = null;
            try {
                try {
                    BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
                    try {
                        String a10 = a(bufferedInputStream2);
                        try {
                            bufferedInputStream2.close();
                            return a10;
                        } catch (IOException e2) {
                            WLogger.e(this.f46008d, "get file  md5 close io error:" + e2.toString());
                            e2.printStackTrace();
                            return a10;
                        }
                    } catch (FileNotFoundException e10) {
                        e = e10;
                        bufferedInputStream = bufferedInputStream2;
                        e.printStackTrace();
                        WLogger.e(this.f46008d, "get file  md5 error " + e.toString());
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e11) {
                                e = e11;
                                str = this.f46008d;
                                sb2 = new StringBuilder();
                                sb2.append("get file  md5 close io error:");
                                sb2.append(e.toString());
                                WLogger.e(str, sb2.toString());
                                e.printStackTrace();
                                return "";
                            }
                        }
                        return "";
                    } catch (OutOfMemoryError unused) {
                        bufferedInputStream = bufferedInputStream2;
                        WLogger.e(this.f46008d, "get file  md5 error oom");
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e12) {
                                e = e12;
                                str = this.f46008d;
                                sb2 = new StringBuilder();
                                sb2.append("get file  md5 close io error:");
                                sb2.append(e.toString());
                                WLogger.e(str, sb2.toString());
                                e.printStackTrace();
                                return "";
                            }
                        }
                        return "";
                    } catch (Throwable th) {
                        th = th;
                        bufferedInputStream = bufferedInputStream2;
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e13) {
                                WLogger.e(this.f46008d, "get file  md5 close io error:" + e13.toString());
                                e13.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (FileNotFoundException e14) {
                    e = e14;
                } catch (OutOfMemoryError unused2) {
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return "";
    }

    public static native String getFrameworkVersion();

    public a a(String str) {
        String str2;
        StringBuilder sb2;
        a aVar;
        WLogger.i(this.f46008d, "module path :" + str);
        File file = new File(str);
        if (file.exists()) {
            File file2 = new File(str + "files_md5");
            if (!file2.exists()) {
                str2 = this.f46008d;
                sb2 = new StringBuilder();
                sb2.append("md5 validity by dir error:");
                aVar = a.NOT_FOUND_MODEL_MD5;
            } else if (a(file2) != 0) {
                str2 = this.f46008d;
                sb2 = new StringBuilder();
                sb2.append("md5 validity by dir error:");
                aVar = a.READ_MD5_ERROR;
            } else {
                int b4 = b(file);
                if (b4 == -1) {
                    str2 = this.f46008d;
                    sb2 = new StringBuilder();
                } else if (b4 == -2) {
                    str2 = this.f46008d;
                    sb2 = new StringBuilder();
                    sb2.append("md5 validity by dir error:");
                    aVar = a.VALIDITY_ERROR;
                } else if (b4 == -3) {
                    str2 = this.f46008d;
                    sb2 = new StringBuilder();
                    sb2.append("md5 validity by dir error:");
                    aVar = a.TARGET_MD5_NOT_FOUND;
                } else if (b4 == -4) {
                    str2 = this.f46008d;
                    sb2 = new StringBuilder();
                    sb2.append("md5 validity by dir error:");
                    aVar = a.CREATE_MD5_ERROR;
                } else {
                    if (b4 != -5) {
                        WLogger.d(this.f46008d, "md5 validity by dir ok");
                        return a.VALIDITY_OK;
                    }
                    str2 = this.f46008d;
                    sb2 = new StringBuilder();
                    sb2.append("md5 validity by dir error:");
                    aVar = a.MODEL_FILE_MISS;
                }
            }
            sb2.append(aVar.name());
            WLogger.e(str2, sb2.toString());
            return aVar;
        }
        str2 = this.f46008d;
        sb2 = new StringBuilder();
        sb2.append("md5 validity by dir error:");
        aVar = a.NOT_FOUND_MODEL_DIR;
        sb2.append(aVar.name());
        WLogger.e(str2, sb2.toString());
        return aVar;
    }
}
