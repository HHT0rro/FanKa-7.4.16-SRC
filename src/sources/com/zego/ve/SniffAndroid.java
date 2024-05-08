package com.zego.ve;

import android.app.ActivityManager;
import android.content.Context;
import android.opengl.GLES20;
import android.os.BatteryManager;
import android.os.Build;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.kuaishou.weapon.p0.t;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class SniffAndroid {
    private static final FileFilter CPU_FILTER = new FileFilter() { // from class: com.zego.ve.SniffAndroid.1
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            String name = file.getName();
            if (!name.startsWith(IAdInterListener.AdProdType.PRODUCT_CPU)) {
                return false;
            }
            for (int i10 = 3; i10 < name.length(); i10++) {
                if (!Character.isDigit(name.charAt(i10))) {
                    return false;
                }
            }
            return true;
        }
    };
    private static final List<String> CPU_TEMP_FILE_PATHS = Arrays.asList("/sys/devices/system/cpu/cpu0/cpufreq/cpu_temp", "/sys/devices/system/cpu/cpu0/cpufreq/FakeShmoo_cpu_temp", "/sys/class/thermal/thermal_zone0/temp", "/sys/class/i2c-adapter/i2c-4/4-004c/temperature", "/sys/devices/platform/tegra-i2c.3/i2c-4/4-004c/temperature", "/sys/devices/platform/omap/omap_temp_sensor.0/temperature", "/sys/devices/platform/tegra_tmon/temp1_input", "/sys/kernel/debug/tegra_thermal/temp_tj", "/sys/devices/platform/s5p-tmu/temperature", "/sys/class/thermal/thermal_zone1/temp", "/sys/class/hwmon/hwmon0/device/temp1_input", "/sys/devices/virtual/thermal/thermal_zone1/temp", "/sys/devices/virtual/thermal/thermal_zone0/temp", "/sys/class/thermal/thermal_zone3/temp", "/sys/class/thermal/thermal_zone4/temp", "/sys/class/hwmon/hwmonX/temp1_input", "/sys/devices/platform/s5p-tmu/curr_temp");
    private static final int DEVICEINFO_UNKNOWN = -1;
    private static String TAG = "SniffAndroid";
    private static ArrayList<CoreFreq> mCoresFreq;
    public ProcStat lastProcStat;
    private Context mAppContext = null;
    private String mGpuVendor = "unkown";
    private String mGpuRenderer = "unkown";

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class CoreFreq {
        public int cur;
        public int max;
        public int min;
        public int num;

        public CoreFreq(int i10) {
            this.min = 0;
            this.max = 0;
            this.num = i10;
            this.min = SniffAndroid.getMinCpuFreq(i10);
            this.max = SniffAndroid.getMaxCpuFreq(i10);
        }

        public int getCurUsage() {
            int i10;
            updateCurFreq();
            int i11 = this.max;
            int i12 = this.min;
            if (i11 - i12 <= 0 || i11 <= 0 || (i10 = this.cur) <= 0) {
                return 0;
            }
            return ((i10 - i12) * 100) / (i11 - i12);
        }

        public void updateCurFreq() {
            this.cur = SniffAndroid.getCurCpuFreq(this.num);
            if (this.min == 0) {
                this.min = SniffAndroid.getMinCpuFreq(this.num);
            }
            if (this.max == 0) {
                this.max = SniffAndroid.getMaxCpuFreq(this.num);
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class ProcStat {
        public final long idleTime;
        public final long runTime;

        public ProcStat(long j10, long j11) {
            this.runTime = j10;
            this.idleTime = j11;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.io.IOException] */
    private static String ExecuteTop() {
        Throwable th;
        Process process;
        Process process2;
        String str;
        ?? r02 = 0;
        String str2 = null;
        r0 = null;
        BufferedReader bufferedReader = null;
        r02 = 0;
        try {
            try {
                try {
                    process = Runtime.getRuntime().exec("top -n 1");
                } catch (Throwable th2) {
                    th = th2;
                    process = null;
                    try {
                        r02.close();
                        process.destroy();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    throw th;
                }
            } catch (IOException e10) {
                try {
                    e10.printStackTrace();
                    process = null;
                } catch (IOException e11) {
                    e = e11;
                    process2 = null;
                    str = null;
                    e.printStackTrace();
                    try {
                        bufferedReader.close();
                        process2.destroy();
                    } catch (IOException e12) {
                        e12.printStackTrace();
                    }
                    r02 = str;
                    process = process2;
                    return r02;
                }
            }
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(process.getInputStream()));
                while (true) {
                    if (str2 != null) {
                        try {
                            if (!str2.contentEquals("")) {
                                try {
                                    break;
                                } catch (IOException e13) {
                                    e13.printStackTrace();
                                    r02 = str2;
                                    process = e13;
                                }
                            }
                        } catch (IOException e14) {
                            e = e14;
                            str = str2;
                            bufferedReader = bufferedReader2;
                            process2 = process;
                            e.printStackTrace();
                            bufferedReader.close();
                            process2.destroy();
                            r02 = str;
                            process = process2;
                            return r02;
                        } catch (Throwable th3) {
                            th = th3;
                            r02 = bufferedReader2;
                            r02.close();
                            process.destroy();
                            throw th;
                        }
                    }
                    str2 = bufferedReader2.readLine();
                }
                bufferedReader2.close();
                process.destroy();
                r02 = str2;
                process = process;
            } catch (IOException e15) {
                e = e15;
                str = null;
                process2 = process;
            }
            return r02;
        } catch (Throwable th4) {
            th = th4;
            r02.close();
            process.destroy();
            throw th;
        }
    }

    private static int ExtractValue(byte[] bArr, int i10) {
        while (i10 < bArr.length && bArr[i10] != 10) {
            if (Character.isDigit(bArr[i10])) {
                int i11 = i10 + 1;
                while (i11 < bArr.length && Character.isDigit(bArr[i11])) {
                    i11++;
                }
                return Integer.parseInt(new String(bArr, 0, i10, i11 - i10));
            }
            i10++;
        }
        return -1;
    }

    private void GatherGlInfo() {
        this.mGpuVendor = GLES20.glGetString(7936);
        this.mGpuRenderer = GLES20.glGetString(7937);
    }

    private int GetBatteryLevel() {
        return ((BatteryManager) this.mAppContext.getSystemService("batterymanager")).getIntProperty(4);
    }

    private static int GetCPUMaxFreqKHz() {
        int i10 = -1;
        try {
            int GetNumberOfCPUCores = GetNumberOfCPUCores();
            int i11 = -1;
            for (int i12 = 0; i12 < GetNumberOfCPUCores; i12++) {
                File file = new File("/sys/devices/system/cpu/cpu" + i12 + "/cpufreq/cpuinfo_max_freq");
                if (file.exists() && file.canRead()) {
                    byte[] bArr = new byte[128];
                    FileInputStream fileInputStream = new FileInputStream(file);
                    try {
                        fileInputStream.read(bArr);
                        int i13 = 0;
                        while (Character.isDigit(bArr[i13]) && i13 < 128) {
                            i13++;
                        }
                        Integer valueOf = Integer.valueOf(Integer.parseInt(new String(bArr, 0, i13)));
                        if (valueOf.intValue() > i11) {
                            i11 = valueOf.intValue();
                        }
                    } catch (NumberFormatException unused) {
                    } catch (Throwable th) {
                        fileInputStream.close();
                        throw th;
                    }
                    fileInputStream.close();
                }
            }
            if (i11 == -1) {
                FileInputStream fileInputStream2 = new FileInputStream("/proc/cpuinfo");
                try {
                    int ParseFileForValue = ParseFileForValue("cpu MHz", fileInputStream2) * 1000;
                    if (ParseFileForValue > i11) {
                        i11 = ParseFileForValue;
                    }
                    fileInputStream2.close();
                } catch (Throwable th2) {
                    fileInputStream2.close();
                    throw th2;
                }
            }
            i10 = i11;
        } catch (IOException unused2) {
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("max freq:");
        sb2.append(i10);
        return i10;
    }

    private static int GetCoresFromCPUFileList() {
        return new File("/sys/devices/system/cpu/").listFiles(CPU_FILTER).length;
    }

    private static int GetCoresFromFileInfo(String str) {
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(str);
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream2));
                String readLine = bufferedReader.readLine();
                bufferedReader.close();
                int GetCoresFromFileString = GetCoresFromFileString(readLine);
                try {
                    fileInputStream2.close();
                } catch (IOException unused) {
                }
                return GetCoresFromFileString;
            } catch (IOException unused2) {
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException unused3) {
                    }
                }
                return -1;
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException unused4) {
                    }
                }
                throw th;
            }
        } catch (IOException unused5) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static int GetCoresFromFileString(String str) {
        if (str == null || !str.matches("0-[\\d]+$")) {
            return -1;
        }
        return Integer.valueOf(str.substring(2)).intValue() + 1;
    }

    public static int GetCpuUsage(int[] iArr) {
        int i10 = 0;
        if (iArr.length < 2) {
            return 0;
        }
        for (int i11 = 1; i11 < iArr.length; i11++) {
            if (iArr[i11] > 0) {
                i10 += iArr[i11];
            }
        }
        return i10 / (iArr.length - 1);
    }

    public static int GetCpuUsageBaseTop() {
        try {
            int[] iArr = new int[3];
            for (int i10 = 0; i10 < 3; i10++) {
                int i11 = 0;
                for (int i12 : GetCpuUsageStatistic()) {
                    i11 += i12;
                }
                iArr[i10] = i11;
            }
            int i13 = 0;
            for (int i14 = 0; i14 < 3; i14++) {
                i13 += iArr[i14];
            }
            return i13 / 3;
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    private static int[] GetCpuUsageStatistic() {
        String replaceAll = ExecuteTop().replaceAll(",", "").replaceAll("User", "").replaceAll("System", "").replaceAll("IOW", "").replaceAll("IRQ", "").replaceAll("%", "");
        for (int i10 = 0; i10 < 10; i10++) {
            replaceAll = replaceAll.replaceAll("  ", " ");
        }
        String[] split = replaceAll.trim().split(" ");
        int[] iArr = new int[split.length];
        for (int i11 = 0; i11 < split.length; i11++) {
            split[i11] = split[i11].trim();
            iArr[i11] = Integer.parseInt(split[i11]);
        }
        return iArr;
    }

    public static int GetNbCores() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(new FileFilter() { // from class: com.zego.ve.SniffAndroid.1CpuFilter
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    return Pattern.matches("cpu[0-9]+", file.getName());
                }
            }).length;
        } catch (Exception unused) {
            return 1;
        }
    }

    private static int GetNumberOfCPUCores() {
        int i10 = -1;
        try {
            int GetCoresFromFileInfo = GetCoresFromFileInfo("/sys/devices/system/cpu/possible");
            if (GetCoresFromFileInfo == -1) {
                GetCoresFromFileInfo = GetCoresFromFileInfo("/sys/devices/system/cpu/present");
            }
            i10 = GetCoresFromFileInfo == -1 ? GetCoresFromCPUFileList() : GetCoresFromFileInfo;
        } catch (NullPointerException | SecurityException unused) {
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("cores:");
        sb2.append(i10);
        return i10;
    }

    private static long GetTotalMemory(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("total mem:");
        sb2.append(memoryInfo.totalMem);
        return memoryInfo.totalMem;
    }

    public static void InitCoresFreq() {
        if (mCoresFreq == null) {
            int GetNbCores = GetNbCores();
            mCoresFreq = new ArrayList<>();
            for (byte b4 = 0; b4 < GetNbCores; b4 = (byte) (b4 + 1)) {
                mCoresFreq.add(new CoreFreq(b4));
            }
        }
    }

    private static int ParseFileForValue(String str, FileInputStream fileInputStream) {
        byte[] bArr = new byte[1024];
        try {
            int read = fileInputStream.read(bArr);
            int i10 = 0;
            while (i10 < read) {
                if (bArr[i10] == 10 || i10 == 0) {
                    if (bArr[i10] == 10) {
                        i10++;
                    }
                    for (int i11 = i10; i11 < read; i11++) {
                        int i12 = i11 - i10;
                        if (bArr[i11] != str.charAt(i12)) {
                            break;
                        }
                        if (i12 == str.length() - 1) {
                            return ExtractValue(bArr, i11);
                        }
                    }
                }
                i10++;
            }
            return -1;
        } catch (IOException | NumberFormatException unused) {
            return -1;
        }
    }

    private ProcStat ReadIdleAndRunTime() {
        try {
            FileReader fileReader = new FileReader("/proc/stat");
            try {
                Scanner scanner = new Scanner(new BufferedReader(fileReader));
                scanner.next();
                long nextLong = scanner.nextLong() + scanner.nextLong() + scanner.nextLong();
                long nextLong2 = scanner.nextLong();
                scanner.close();
                return new ProcStat(nextLong, nextLong2);
            } catch (Exception unused) {
                return null;
            } finally {
                fileReader.close();
            }
        } catch (FileNotFoundException | IOException unused2) {
        }
    }

    private static int ReadIntegerFile(String str) {
        int i10 = 0;
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(str, t.f36226k);
            try {
                i10 = Integer.parseInt(randomAccessFile.readLine());
                randomAccessFile.close();
            } catch (Throwable th) {
                randomAccessFile.close();
                throw th;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return i10;
    }

    private double ReadOneLine(File file) {
        String str = "";
        if (!file.exists() || !file.canRead()) {
            return -100000.0d;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            str = bufferedReader.readLine();
            fileInputStream.close();
            inputStreamReader.close();
            bufferedReader.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException unused) {
            return -100000.0d;
        }
    }

    public static synchronized int[] getCoresUsageGuessFromFreq() {
        int[] iArr;
        synchronized (SniffAndroid.class) {
            InitCoresFreq();
            iArr = new int[mCoresFreq.size() + 1];
            iArr[0] = 0;
            byte b4 = 0;
            while (b4 < mCoresFreq.size()) {
                int i10 = b4 + 1;
                iArr[i10] = mCoresFreq.get(b4).getCurUsage();
                iArr[0] = iArr[0] + iArr[i10];
                b4 = (byte) i10;
            }
            if (mCoresFreq.size() > 0) {
                iArr[0] = iArr[0] / mCoresFreq.size();
            }
        }
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getCurCpuFreq(int i10) {
        return ReadIntegerFile("/sys/devices/system/cpu/cpu" + i10 + "/cpufreq/scaling_cur_freq");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getMaxCpuFreq(int i10) {
        return ReadIntegerFile("/sys/devices/system/cpu/cpu" + i10 + "/cpufreq/cpuinfo_max_freq");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getMinCpuFreq(int i10) {
        return ReadIntegerFile("/sys/devices/system/cpu/cpu" + i10 + "/cpufreq/cpuinfo_min_freq");
    }

    private boolean isEGL14SupportedHere() {
        return true;
    }

    private boolean isTemperatureValid(double d10) {
        return d10 >= -30.0d && d10 <= 250.0d;
    }

    public boolean CheckBackground() {
        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
        ActivityManager.getMyMemoryState(runningAppProcessInfo);
        int i10 = runningAppProcessInfo.importance;
        return (i10 == 100 || i10 == 200) ? false : true;
    }

    public int GetBattery() {
        return GetBatteryLevel();
    }

    public int GetCPUClock() {
        return GetCPUMaxFreqKHz();
    }

    public int GetCPUKernel() {
        return GetNumberOfCPUCores();
    }

    public int GetCPUTemperature() {
        double d10;
        int i10 = 0;
        while (true) {
            List<String> list = CPU_TEMP_FILE_PATHS;
            if (i10 >= list.size()) {
                d10 = ShadowDrawableWrapper.COS_45;
                break;
            }
            String str = list.get(i10);
            Double valueOf = Double.valueOf(ReadOneLine(new File(str)));
            if (isTemperatureValid(valueOf.doubleValue())) {
                d10 = valueOf.doubleValue();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("getCpuTemperature valid path:");
                sb2.append(str);
                break;
            }
            if (isTemperatureValid(valueOf.doubleValue() / 1000.0d)) {
                d10 = valueOf.doubleValue() / 1000.0d;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("getCpuTemperature valid path:");
                sb3.append(str);
                break;
            }
            i10++;
        }
        return (int) (d10 * 1000.0d);
    }

    public String GetCPUVendor() {
        return Build.HARDWARE;
    }

    public int GetCPUsage() {
        if (Build.VERSION.SDK_INT < 26) {
            return SampleCpuUtilization();
        }
        return GetCpuUsage(getCoresUsageGuessFromFreq());
    }

    public String GetDeviceName() {
        return Build.MODEL;
    }

    public String GetGPURenderer() {
        return this.mGpuRenderer;
    }

    public String GetGPUVendor() {
        return this.mGpuVendor;
    }

    public int GetOsVersion() {
        return Build.VERSION.SDK_INT;
    }

    public int GetRAM() {
        return (int) (GetTotalMemory(this.mAppContext) / 1024);
    }

    public int SampleCpuUtilization() {
        ProcStat ReadIdleAndRunTime = ReadIdleAndRunTime();
        if (ReadIdleAndRunTime == null) {
            return 0;
        }
        long j10 = ReadIdleAndRunTime.runTime;
        ProcStat procStat = this.lastProcStat;
        long j11 = j10 - procStat.runTime;
        long j12 = ReadIdleAndRunTime.idleTime - procStat.idleTime;
        this.lastProcStat = ReadIdleAndRunTime;
        long j13 = j12 + j11;
        return Math.max(0, Math.min(j13 == 0 ? 0 : Math.round((float) ((j11 * 100) / j13)), 100));
    }

    public int getCPUScore() {
        return 0;
    }

    public boolean initSniff(Context context) {
        this.mAppContext = context;
        this.lastProcStat = new ProcStat(0L, 0L);
        return true;
    }
}
