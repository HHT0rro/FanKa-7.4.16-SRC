package com.nirvana.tools.crash;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.nirvana.tools.core.UTSharedPreferencesHelper;
import com.wangmai.okhttp.model.HttpHeaders;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import org.apache.commons.io.IOUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class CrashUploadUtils {
    public static final String CRASH_SDK_INFO = "CRASH_SDK_INFO";
    private static final String KEY_UNIQUE_ID = "uniqueId";

    public static String apkInDebugRelease(Context context) {
        return (context.getApplicationInfo().flags & 2) != 0 ? "debug" : "release";
    }

    private static byte[] getBytesByInputStream(InputStream inputStream) {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(byteArrayOutputStream);
        byte[] bArr = new byte[8192];
        while (true) {
            try {
                try {
                    int read = bufferedInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    bufferedOutputStream.write(bArr, 0, read);
                } catch (IOException e2) {
                    e2.printStackTrace();
                    try {
                        bufferedOutputStream.close();
                    } catch (IOException e10) {
                        e10.printStackTrace();
                    }
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e11) {
                        e11.printStackTrace();
                    }
                    return null;
                }
            } catch (Throwable th) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e12) {
                    e12.printStackTrace();
                }
                try {
                    bufferedInputStream.close();
                    throw th;
                } catch (IOException e13) {
                    e13.printStackTrace();
                    throw th;
                }
            }
        }
        bufferedOutputStream.flush();
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            bufferedOutputStream.close();
        } catch (IOException e14) {
            e14.printStackTrace();
        }
        try {
            bufferedInputStream.close();
            return byteArray;
        } catch (IOException e15) {
            e15.printStackTrace();
            return byteArray;
        }
    }

    public static String getCurProcessName(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (Build.VERSION.SDK_INT >= 28) {
            return Application.getProcessName();
        }
        try {
            return (String) Class.forName("android.app.ActivityThread").getDeclaredMethod("currentProcessName", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            int myPid = Process.myPid();
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
                return "";
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.pid == myPid) {
                    return runningAppProcessInfo.processName;
                }
            }
            return "";
        }
    }

    public static String getFieldFromCpuinfo(String str) throws IOException {
        String readLine;
        Matcher matcher;
        BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/cpuinfo"));
        Pattern compile = Pattern.compile(str + "\\s*:\\s*(.*)");
        do {
            try {
                readLine = bufferedReader.readLine();
            } catch (Exception unused) {
            } catch (Throwable th) {
                bufferedReader.close();
                throw th;
            }
            if (readLine == null) {
                bufferedReader.close();
                return "";
            }
            matcher = compile.matcher(readLine);
        } while (!matcher.matches());
        String group = matcher.group(1);
        bufferedReader.close();
        return group;
    }

    public static String getMeminfo() {
        try {
            StringBuilder sb2 = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/meminfo")));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    bufferedReader.close();
                    return sb2.toString();
                }
                sb2.append(readLine);
                sb2.append("\n");
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    private static String getStringByBytes(byte[] bArr, String str) {
        try {
            return new String(bArr, str);
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String getUniqueId(Context context) {
        String str = (String) UTSharedPreferencesHelper.get(context, CRASH_SDK_INFO, "uniqueId", "");
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String uuid = UUID.randomUUID().toString();
        UTSharedPreferencesHelper.put(context, CRASH_SDK_INFO, "uniqueId", uuid);
        return uuid;
    }

    public static String getVersion(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e2) {
            e2.printStackTrace();
            return "-1";
        }
    }

    public static boolean isGzip(byte[] bArr) {
        return ((bArr[1] & 255) | (bArr[0] << 8)) == 8075;
    }

    public static boolean post(String str, Map<String, String> map, Map<String, File> map2) throws Exception {
        String uuid = UUID.randomUUID().toString();
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setReadTimeout(5000);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("connection", HttpHeaders.HEAD_VALUE_CONNECTION_KEEP_ALIVE);
        httpURLConnection.setRequestProperty("Charsert", "UTF-8");
        httpURLConnection.setRequestProperty("Accept-Encoding", HttpHeaders.HEAD_VALUE_ACCEPT_ENCODING);
        httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
        httpURLConnection.setRequestProperty("http.protocol.content-charset", "UTF-8");
        httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + uuid);
        StringBuilder sb2 = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb2.append("--");
            sb2.append(uuid);
            sb2.append(IOUtils.LINE_SEPARATOR_WINDOWS);
            sb2.append("Content-Disposition: form-data; name=\"" + entry.getKey() + "\"" + IOUtils.LINE_SEPARATOR_WINDOWS);
            StringBuilder sb3 = new StringBuilder("Content-Type: text/plain; charset=");
            sb3.append("UTF-8");
            sb3.append(IOUtils.LINE_SEPARATOR_WINDOWS);
            sb2.append(sb3.toString());
            sb2.append(IOUtils.LINE_SEPARATOR_WINDOWS);
            sb2.append(entry.getValue());
            sb2.append(IOUtils.LINE_SEPARATOR_WINDOWS);
        }
        DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
        dataOutputStream.write(sb2.toString().getBytes());
        if (map2 != null) {
            for (Map.Entry<String, File> entry2 : map2.entrySet()) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("--");
                sb4.append(uuid);
                sb4.append(IOUtils.LINE_SEPARATOR_WINDOWS);
                sb4.append("Content-Disposition: form-data; name=\"file\"; filename=\"" + entry2.getKey() + "\"" + IOUtils.LINE_SEPARATOR_WINDOWS);
                sb4.append(IOUtils.LINE_SEPARATOR_WINDOWS);
                dataOutputStream.write(sb4.toString().getBytes());
                FileInputStream fileInputStream = new FileInputStream(entry2.getValue());
                GZIPInputStream gZIPInputStream = new GZIPInputStream(new BufferedInputStream(fileInputStream));
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = gZIPInputStream.read(bArr);
                    if (read != -1) {
                        dataOutputStream.write(bArr, 0, read);
                    }
                }
                fileInputStream.close();
                dataOutputStream.write(IOUtils.LINE_SEPARATOR_WINDOWS.getBytes());
            }
        }
        dataOutputStream.write(("--" + uuid + "--" + IOUtils.LINE_SEPARATOR_WINDOWS).getBytes());
        dataOutputStream.flush();
        dataOutputStream.close();
        httpURLConnection.getResponseCode();
        byte[] bytesByInputStream = getBytesByInputStream(httpURLConnection.getInputStream());
        boolean contains = (isGzip(bytesByInputStream) ? uncompressToString(bytesByInputStream, "UTF-8") : getStringByBytes(bytesByInputStream, "UTF-8")).contains("200");
        httpURLConnection.disconnect();
        return contains;
    }

    public static String uncompressToString(byte[] bArr, String str) {
        String str2 = null;
        if (bArr != null && bArr.length != 0) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            try {
                try {
                    GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                    byte[] bArr2 = new byte[256];
                    while (true) {
                        int read = gZIPInputStream.read(bArr2);
                        if (read < 0) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr2, 0, read);
                    }
                    str2 = byteArrayOutputStream.toString(str);
                    byteArrayInputStream.close();
                    byteArrayOutputStream.close();
                } catch (IOException unused) {
                    byteArrayInputStream.close();
                    byteArrayOutputStream.close();
                } catch (Throwable th) {
                    try {
                        byteArrayInputStream.close();
                        byteArrayOutputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    throw th;
                }
            } catch (IOException e10) {
                e10.printStackTrace();
            }
        }
        return str2;
    }
}
