package com.danlan.android.cognition.collector;

import android.content.Context;
import com.danlan.android.cognition.NativeLib;
import com.danlan.android.cognition.StringFog;
import com.danlan.android.cognition.collector.base.SubCollector;
import com.danlan.android.cognition.collector.util.SafeJSONObject;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.regex.Pattern;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class CpuCollector extends SubCollector {
    private static final int EI_CLASS = 4;
    private static final int ELFCLASS32 = 1;
    private static final int ELFCLASS64 = 2;
    private Context mcontext;
    private static final String CPU_ARCHITECTURE_KEY_64 = StringFog.decrypt("U0wKU1NMQFRCVwpAUVYKQENKSEpSVxIV");
    private static final String CPU_ARCHITECTURE_TYPE_32 = StringFog.decrypt("EhE=");
    private static final String CPU_ARCHITECTURE_TYPE_64 = StringFog.decrypt("Fxc=");
    private static final String PROC_CPU_INFO_PATH = StringFog.decrypt("DlNWTEIMR1FUSkpFTg==");
    private static final String SYSTEM_LIB_C_PATH = StringFog.decrypt("DlBdUFVGSQ5NSkYMTUpGQg9QSw==");
    private static final String SYSTEM_LIB_C_PATH_64 = StringFog.decrypt("DlBdUFVGSQ5NSkYVFQxISENAClBO");
    private static String vendor_id = StringFog.decrypt("VE1PTU5USg==");
    private static String cpuHardware = StringFog.decrypt("VE1PTU5USg==");
    private static String features = StringFog.decrypt("VE1PTU5USg==");

    public CpuCollector(Context context, SafeJSONObject safeJSONObject) {
        super(context, safeJSONObject);
        this.mcontext = context;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0082 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0078 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.io.BufferedReader] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void collectOtherCpuInfo() {
        /*
            r6 = this;
            java.lang.String r0 = com.danlan.android.cognition.collector.CpuCollector.PROC_CPU_INFO_PATH
            r1 = 0
            java.io.FileReader r2 = new java.io.FileReader     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L56
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L56
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
            r0.<init>(r2)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4c
        Ld:
            java.lang.String r1 = r0.readLine()     // Catch: java.lang.Exception -> L48 java.lang.Throwable -> L72
            if (r1 == 0) goto L3f
            java.lang.String r3 = "Gw=="
            java.lang.String r3 = com.danlan.android.cognition.StringFog.decrypt(r3)     // Catch: java.lang.Exception -> L48 java.lang.Throwable -> L72
            java.lang.String[] r1 = r1.split(r3)     // Catch: java.lang.Exception -> L48 java.lang.Throwable -> L72
            int r3 = r1.length     // Catch: java.lang.Exception -> L48 java.lang.Throwable -> L72
            r4 = 2
            if (r3 != r4) goto Ld
            r3 = 0
            r3 = r1[r3]     // Catch: java.lang.Exception -> L48 java.lang.Throwable -> L72
            java.lang.String r3 = r3.trim()     // Catch: java.lang.Exception -> L48 java.lang.Throwable -> L72
            r4 = 1
            r1 = r1[r4]     // Catch: java.lang.Exception -> L48 java.lang.Throwable -> L72
            java.lang.String r1 = r1.trim()     // Catch: java.lang.Exception -> L48 java.lang.Throwable -> L72
            int r4 = r3.length()     // Catch: java.lang.Exception -> L48 java.lang.Throwable -> L72
            if (r4 <= 0) goto Ld
            int r4 = r1.length()     // Catch: java.lang.Exception -> L48 java.lang.Throwable -> L72
            if (r4 <= 0) goto Ld
            r6.filterKey(r3, r1)     // Catch: java.lang.Exception -> L48 java.lang.Throwable -> L72
            goto Ld
        L3f:
            r0.close()     // Catch: java.io.IOException -> L43
            goto L69
        L43:
            r0 = move-exception
            r0.printStackTrace()
            goto L69
        L48:
            r1 = move-exception
            goto L5a
        L4a:
            r0 = move-exception
            goto L76
        L4c:
            r0 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto L5a
        L51:
            r0 = move-exception
            r2 = r1
            r1 = r0
            r0 = r2
            goto L73
        L56:
            r0 = move-exception
            r2 = r1
            r1 = r0
            r0 = r2
        L5a:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L72
            if (r0 == 0) goto L67
            r0.close()     // Catch: java.io.IOException -> L63
            goto L67
        L63:
            r0 = move-exception
            r0.printStackTrace()
        L67:
            if (r2 == 0) goto L71
        L69:
            r2.close()     // Catch: java.io.IOException -> L6d
            goto L71
        L6d:
            r0 = move-exception
            r0.printStackTrace()
        L71:
            return
        L72:
            r1 = move-exception
        L73:
            r5 = r1
            r1 = r0
            r0 = r5
        L76:
            if (r1 == 0) goto L80
            r1.close()     // Catch: java.io.IOException -> L7c
            goto L80
        L7c:
            r1 = move-exception
            r1.printStackTrace()
        L80:
            if (r2 == 0) goto L8a
            r2.close()     // Catch: java.io.IOException -> L86
            goto L8a
        L86:
            r1 = move-exception
            r1.printStackTrace()
        L8a:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.danlan.android.cognition.collector.CpuCollector.collectOtherCpuInfo():void");
    }

    private void filterKey(String str, String str2) {
        if (str.equalsIgnoreCase(StringFog.decrypt("aUJWR1ZCVkQ="))) {
            cpuHardware = str2;
        } else if (str.equalsIgnoreCase(StringFog.decrypt("V0ZKR05Re0hF"))) {
            vendor_id = str2;
        } else if (str.equalsIgnoreCase(StringFog.decrypt("Z0ZFV1RRQVI="))) {
            features = str2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0067 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x005d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.io.Reader] */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.io.FileReader, java.io.Reader] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String getCpuDriver() {
        /*
            r5 = this;
            java.lang.String r0 = ""
            java.lang.String r1 = "DlBdUA5HQVdIQEFQDlBdUlVGSQxCU1EOQlNRSkVPQQ5CVlZRRE1QfkVRTVVEUQ=="
            java.lang.String r1 = com.danlan.android.cognition.StringFog.decrypt(r1)
            r2 = 0
            java.io.FileReader r3 = new java.io.FileReader     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L36
            r3.<init>(r1)     // Catch: java.lang.Throwable -> L34 java.lang.Exception -> L36
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L2f
            r1.<init>(r3)     // Catch: java.lang.Throwable -> L2d java.lang.Exception -> L2f
            java.lang.String r2 = r1.readLine()     // Catch: java.lang.Exception -> L2b java.lang.Throwable -> L5a
            if (r2 == 0) goto L1a
            r0 = r2
        L1a:
            r1.close()     // Catch: java.io.IOException -> L1e
            goto L22
        L1e:
            r1 = move-exception
            r1.printStackTrace()
        L22:
            r3.close()     // Catch: java.io.IOException -> L26
            goto L2a
        L26:
            r1 = move-exception
            r1.printStackTrace()
        L2a:
            return r0
        L2b:
            r2 = move-exception
            goto L3a
        L2d:
            goto L5b
        L2f:
            r1 = move-exception
            r4 = r2
            r2 = r1
            r1 = r4
            goto L3a
        L34:
            r1 = r2
            goto L59
        L36:
            r1 = move-exception
            r3 = r2
            r2 = r1
            r1 = r3
        L3a:
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L58
            java.lang.String r2 = "RFFWTFM="
            java.lang.String r0 = com.danlan.android.cognition.StringFog.decrypt(r2)     // Catch: java.lang.Throwable -> L58
            if (r1 == 0) goto L4d
            r1.close()     // Catch: java.io.IOException -> L49
            goto L4d
        L49:
            r1 = move-exception
            r1.printStackTrace()
        L4d:
            if (r3 == 0) goto L57
            r3.close()     // Catch: java.io.IOException -> L53
            goto L57
        L53:
            r1 = move-exception
            r1.printStackTrace()
        L57:
            return r0
        L58:
            r2 = r3
        L59:
            r3 = r2
        L5a:
            r2 = r1
        L5b:
            if (r2 == 0) goto L65
            r2.close()     // Catch: java.io.IOException -> L61
            goto L65
        L61:
            r1 = move-exception
            r1.printStackTrace()
        L65:
            if (r3 == 0) goto L6f
            r3.close()     // Catch: java.io.IOException -> L6b
            goto L6f
        L6b:
            r1 = move-exception
            r1.printStackTrace()
        L6f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.danlan.android.cognition.collector.CpuCollector.getCpuDriver():java.lang.String");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:54:0x008b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0081 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.Reader] */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.io.FileReader, java.io.Reader] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String getCpuType() {
        /*
            r6 = this;
            java.lang.String r0 = "DQ=="
            java.lang.String r1 = ""
            java.lang.String r2 = "DlBdUA5HQVdIQEFQDlBdUlVGSQxCU1EOTExAQk1KRVI="
            java.lang.String r2 = com.danlan.android.cognition.StringFog.decrypt(r2)
            r3 = 0
            java.io.FileReader r4 = new java.io.FileReader     // Catch: java.lang.Throwable -> L5f java.lang.Exception -> L61
            r4.<init>(r2)     // Catch: java.lang.Throwable -> L5f java.lang.Exception -> L61
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5d
            r2.<init>(r4)     // Catch: java.lang.Throwable -> L5b java.lang.Exception -> L5d
        L15:
            java.lang.String r3 = r2.readLine()     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
            if (r3 == 0) goto L45
            java.lang.String r5 = "Gw=="
            java.lang.String r5 = com.danlan.android.cognition.StringFog.decrypt(r5)     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
            java.lang.String[] r3 = r3.split(r5)     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
            r5 = 2
            r3 = r3[r5]     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
            if (r5 != 0) goto L15
            java.lang.String r5 = com.danlan.android.cognition.StringFog.decrypt(r0)     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
            boolean r5 = r3.contains(r5)     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
            if (r5 == 0) goto L44
            java.lang.String r0 = com.danlan.android.cognition.StringFog.decrypt(r0)     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
            java.lang.String[] r0 = r3.split(r0)     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
            r3 = 0
            r1 = r0[r3]     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L58
            goto L45
        L44:
            r1 = r3
        L45:
            r2.close()     // Catch: java.io.IOException -> L49
            goto L4d
        L49:
            r0 = move-exception
            r0.printStackTrace()
        L4d:
            r4.close()     // Catch: java.io.IOException -> L51
            goto L55
        L51:
            r0 = move-exception
            r0.printStackTrace()
        L55:
            return r1
        L56:
            r3 = r2
            goto L7f
        L58:
            r0 = move-exception
            r3 = r2
            goto L63
        L5b:
            goto L7f
        L5d:
            r0 = move-exception
            goto L63
        L5f:
            r0 = r3
            goto L7d
        L61:
            r0 = move-exception
            r4 = r3
        L63:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L7b
            if (r3 == 0) goto L70
            r3.close()     // Catch: java.io.IOException -> L6c
            goto L70
        L6c:
            r0 = move-exception
            r0.printStackTrace()
        L70:
            if (r4 == 0) goto L7a
            r4.close()     // Catch: java.io.IOException -> L76
            goto L7a
        L76:
            r0 = move-exception
            r0.printStackTrace()
        L7a:
            return r1
        L7b:
            r0 = r3
            r3 = r4
        L7d:
            r4 = r3
            r3 = r0
        L7f:
            if (r3 == 0) goto L89
            r3.close()     // Catch: java.io.IOException -> L85
            goto L89
        L85:
            r0 = move-exception
            r0.printStackTrace()
        L89:
            if (r4 == 0) goto L93
            r4.close()     // Catch: java.io.IOException -> L8f
            goto L93
        L8f:
            r0 = move-exception
            r0.printStackTrace()
        L93:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.danlan.android.cognition.collector.CpuCollector.getCpuType():java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x005a, code lost:
    
        if (r2 == null) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0049, code lost:
    
        if (r2 == null) goto L41;
     */
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x005f: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:58:0x005f */
    /* JADX WARN: Removed duplicated region for block: B:40:0x006b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0064 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String getCurCpuFreq() {
        /*
            r5 = this;
            java.lang.String r0 = "bwxl"
            java.lang.String r0 = com.danlan.android.cognition.StringFog.decrypt(r0)
            r1 = 0
            java.io.FileReader r2 = new java.io.FileReader     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L3b java.io.FileNotFoundException -> L4c
            java.lang.String r3 = "DlBdUA5HQVdIQEFQDlBdUlVGSQxCU1EOQlNREw5AVFRHUUFSDlBHQE1KSkR+QFFTfkVWRlA="
            java.lang.String r3 = com.danlan.android.cognition.StringFog.decrypt(r3)     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L3b java.io.FileNotFoundException -> L4c
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L38 java.io.IOException -> L3b java.io.FileNotFoundException -> L4c
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L2c java.io.IOException -> L2e java.io.FileNotFoundException -> L33
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L2c java.io.IOException -> L2e java.io.FileNotFoundException -> L33
            java.lang.String r1 = r3.readLine()     // Catch: java.lang.Throwable -> L26 java.io.IOException -> L28 java.io.FileNotFoundException -> L2a
            java.lang.String r0 = r1.trim()     // Catch: java.lang.Throwable -> L26 java.io.IOException -> L28 java.io.FileNotFoundException -> L2a
            r3.close()     // Catch: java.io.IOException -> L22
        L22:
            r2.close()     // Catch: java.io.IOException -> L5d
            goto L5d
        L26:
            r0 = move-exception
            goto L61
        L28:
            r1 = move-exception
            goto L3f
        L2a:
            r1 = move-exception
            goto L50
        L2c:
            r0 = move-exception
            goto L62
        L2e:
            r3 = move-exception
            r4 = r3
            r3 = r1
            r1 = r4
            goto L3f
        L33:
            r3 = move-exception
            r4 = r3
            r3 = r1
            r1 = r4
            goto L50
        L38:
            r0 = move-exception
            r3 = r1
            goto L60
        L3b:
            r2 = move-exception
            r3 = r1
            r1 = r2
            r2 = r3
        L3f:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L5e
            if (r3 == 0) goto L49
            r3.close()     // Catch: java.io.IOException -> L48
            goto L49
        L48:
        L49:
            if (r2 == 0) goto L5d
            goto L5c
        L4c:
            r2 = move-exception
            r3 = r1
            r1 = r2
            r2 = r3
        L50:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L5e
            if (r3 == 0) goto L5a
            r3.close()     // Catch: java.io.IOException -> L59
            goto L5a
        L59:
        L5a:
            if (r2 == 0) goto L5d
        L5c:
            goto L22
        L5d:
            return r0
        L5e:
            r0 = move-exception
            r1 = r2
        L60:
            r2 = r1
        L61:
            r1 = r3
        L62:
            if (r1 == 0) goto L69
            r1.close()     // Catch: java.io.IOException -> L68
            goto L69
        L68:
        L69:
            if (r2 == 0) goto L6e
            r2.close()     // Catch: java.io.IOException -> L6e
        L6e:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.danlan.android.cognition.collector.CpuCollector.getCurCpuFreq():java.lang.String");
    }

    private boolean isCPUInfo64() {
        FileInputStream fileInputStream;
        BufferedReader bufferedReader;
        File file = new File(PROC_CPU_INFO_PATH);
        if (!file.exists()) {
            return false;
        }
        BufferedReader bufferedReader2 = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream), 512);
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            fileInputStream = null;
        }
        try {
            String readLine = bufferedReader.readLine();
            if (readLine != null && readLine.length() > 0) {
                if (readLine.toLowerCase(Locale.US).contains(StringFog.decrypt("QFFHSxcX"))) {
                    try {
                        bufferedReader.close();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    try {
                        fileInputStream.close();
                    } catch (Exception e10) {
                        e10.printStackTrace();
                    }
                    return true;
                }
            }
            try {
                bufferedReader.close();
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        } catch (Throwable unused3) {
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (Exception e12) {
                    e12.printStackTrace();
                }
            }
            if (fileInputStream == null) {
                return false;
            }
            fileInputStream.close();
            return false;
        }
        try {
            fileInputStream.close();
            return false;
        } catch (Exception e13) {
            e13.printStackTrace();
            return false;
        }
    }

    private boolean isLibc64() {
        byte[] readELFHeadrIndentArray;
        byte[] readELFHeadrIndentArray2;
        File file = new File(SYSTEM_LIB_C_PATH);
        if (file.exists() && (readELFHeadrIndentArray2 = readELFHeadrIndentArray(file)) != null && readELFHeadrIndentArray2[4] == 2) {
            return true;
        }
        File file2 = new File(SYSTEM_LIB_C_PATH_64);
        return file2.exists() && (readELFHeadrIndentArray = readELFHeadrIndentArray(file2)) != null && readELFHeadrIndentArray[4] == 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x002b, code lost:
    
        if (r1 == null) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private byte[] readELFHeadrIndentArray(java.io.File r5) {
        /*
            r4 = this;
            r0 = 0
            if (r5 == 0) goto L35
            boolean r1 = r5.exists()
            if (r1 == 0) goto L35
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L2a
            r1.<init>(r5)     // Catch: java.lang.Throwable -> L2a
            int r5 = r1.available()     // Catch: java.lang.Throwable -> L28
            if (r5 <= 0) goto L2d
            r5 = 16
            byte[] r2 = new byte[r5]     // Catch: java.lang.Throwable -> L28
            r3 = 0
            int r3 = r1.read(r2, r3, r5)     // Catch: java.lang.Throwable -> L28
            if (r3 != r5) goto L2d
            r1.close()     // Catch: java.lang.Exception -> L23
            goto L27
        L23:
            r5 = move-exception
            r5.printStackTrace()
        L27:
            return r2
        L28:
            goto L2b
        L2a:
            r1 = r0
        L2b:
            if (r1 == 0) goto L35
        L2d:
            r1.close()     // Catch: java.lang.Exception -> L31
            goto L35
        L31:
            r5 = move-exception
            r5.printStackTrace()
        L35:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.danlan.android.cognition.collector.CpuCollector.readELFHeadrIndentArray(java.io.File):byte[]");
    }

    @Override // com.danlan.android.cognition.collector.base.SubCollector
    public void doCollectAutomatically() {
        SafeJSONObject safeJSONObject = new SafeJSONObject();
        try {
            collectOtherCpuInfo();
            safeJSONObject.put(StringFog.decrypt("QlNRa0BRQFZAUUE="), cpuHardware);
            safeJSONObject.put(StringFog.decrypt("V0ZKR05Re0hF"), vendor_id);
            safeJSONObject.put(StringFog.decrypt("QlNRYlNATA=="), getArchType());
            safeJSONObject.put(StringFog.decrypt("UlZUU05RUERFYkZKUg=="), getSupportAbi());
            safeJSONObject.put(StringFog.decrypt("QkxWRm9WSUNEUQ=="), getCoreNumber());
            safeJSONObject.put(StringFog.decrypt("TEJcZVNGVQ=="), getMaxCpuFreq());
            safeJSONObject.put(StringFog.decrypt("TEpKZVNGVQ=="), getMinCpuFreq());
            safeJSONObject.put(StringFog.decrypt("QlZWUURNUGdTRlU="), getCurCpuFreq());
            safeJSONObject.put(StringFog.decrypt("R0ZFV1RRQVI="), features);
            safeJSONObject.put(StringFog.decrypt("VVpURg=="), getCpuType());
            safeJSONObject.put(StringFog.decrypt("RVFNVURR"), getCpuDriver());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        put(StringFog.decrypt("QlNR"), safeJSONObject);
        collectDone();
    }

    public final String getArchType() {
        if ((NativeLib.checkLoadSo() ? NativeLib.pg(CPU_ARCHITECTURE_KEY_64, "") : "").isEmpty() && !isCPUInfo64() && !isLibc64()) {
            return CPU_ARCHITECTURE_TYPE_32;
        }
        return CPU_ARCHITECTURE_TYPE_64;
    }

    public final int getCoreNumber() {
        try {
            return new File(StringFog.decrypt("DlBdUA5HQVdIQEFQDlBdUlVGSQxCU1EO")).listFiles(new FileFilter() { // from class: com.danlan.android.cognition.collector.CpuCollector.1CpuFilter
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    return Pattern.matches(StringFog.decrypt("QlNReBEOHXw="), file.getName());
                }
            }).length;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0047, code lost:
    
        if (r1 != null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0054, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0052, code lost:
    
        if (r1 == null) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String getMaxCpuFreq() {
        /*
            r5 = this;
            r0 = 2
            r1 = 0
            java.lang.String[] r0 = new java.lang.String[r0]     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L4c
            r2 = 0
            java.lang.String r3 = "DlBdUFVGSQ5DSkoMQkJQ"
            java.lang.String r3 = com.danlan.android.cognition.StringFog.decrypt(r3)     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L4c
            r0[r2] = r3     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L4c
            r2 = 1
            java.lang.String r3 = "DlBdUA5HQVdIQEFQDlBdUlVGSQxCU1EOQlNREw5AVFRHUUFSDkBUVEhNQkx+TkVZfkVWRlA="
            java.lang.String r3 = com.danlan.android.cognition.StringFog.decrypt(r3)     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L4c
            r0[r2] = r3     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L4c
            java.lang.ProcessBuilder r2 = new java.lang.ProcessBuilder     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L4c
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L4c
            java.lang.Process r0 = r2.start()     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L4c
            java.io.InputStream r1 = r0.getInputStream()     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L4c
            r0 = 24
            byte[] r0 = new byte[r0]     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L4c
            java.lang.String r2 = ""
            if (r1 == 0) goto L47
        L2b:
            int r3 = r1.read(r0)     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L4c
            r4 = -1
            if (r3 == r4) goto L47
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L4c
            r3.<init>()     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L4c
            r3.append(r2)     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L4c
            java.lang.String r2 = new java.lang.String     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L4c
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L4c
            r3.append(r2)     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L4c
            java.lang.String r2 = r3.toString()     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L4c
            goto L2b
        L47:
            if (r1 == 0) goto L57
            goto L54
        L4a:
            r0 = move-exception
            goto L5c
        L4c:
            java.lang.String r0 = "bwxl"
            java.lang.String r2 = com.danlan.android.cognition.StringFog.decrypt(r0)     // Catch: java.lang.Throwable -> L4a
            if (r1 == 0) goto L57
        L54:
            r1.close()     // Catch: java.io.IOException -> L57
        L57:
            java.lang.String r0 = r2.trim()
            return r0
        L5c:
            if (r1 == 0) goto L61
            r1.close()     // Catch: java.io.IOException -> L61
        L61:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.danlan.android.cognition.collector.CpuCollector.getMaxCpuFreq():java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0047, code lost:
    
        if (r1 != null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0054, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0052, code lost:
    
        if (r1 == null) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String getMinCpuFreq() {
        /*
            r5 = this;
            r0 = 2
            r1 = 0
            java.lang.String[] r0 = new java.lang.String[r0]     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L4c
            r2 = 0
            java.lang.String r3 = "DlBdUFVGSQ5DSkoMQkJQ"
            java.lang.String r3 = com.danlan.android.cognition.StringFog.decrypt(r3)     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L4c
            r0[r2] = r3     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L4c
            r2 = 1
            java.lang.String r3 = "DlBdUA5HQVdIQEFQDlBdUlVGSQxCU1EOQlNREw5AVFRHUUFSDkBUVEhNQkx+Tk1PfkVWRlA="
            java.lang.String r3 = com.danlan.android.cognition.StringFog.decrypt(r3)     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L4c
            r0[r2] = r3     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L4c
            java.lang.ProcessBuilder r2 = new java.lang.ProcessBuilder     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L4c
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L4c
            java.lang.Process r0 = r2.start()     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L4c
            java.io.InputStream r1 = r0.getInputStream()     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L4c
            r0 = 24
            byte[] r0 = new byte[r0]     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L4c
            java.lang.String r2 = ""
            if (r1 == 0) goto L47
        L2b:
            int r3 = r1.read(r0)     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L4c
            r4 = -1
            if (r3 == r4) goto L47
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L4c
            r3.<init>()     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L4c
            r3.append(r2)     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L4c
            java.lang.String r2 = new java.lang.String     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L4c
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L4c
            r3.append(r2)     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L4c
            java.lang.String r2 = r3.toString()     // Catch: java.lang.Throwable -> L4a java.io.IOException -> L4c
            goto L2b
        L47:
            if (r1 == 0) goto L57
            goto L54
        L4a:
            r0 = move-exception
            goto L5c
        L4c:
            java.lang.String r0 = "bwxl"
            java.lang.String r2 = com.danlan.android.cognition.StringFog.decrypt(r0)     // Catch: java.lang.Throwable -> L4a
            if (r1 == 0) goto L57
        L54:
            r1.close()     // Catch: java.io.IOException -> L57
        L57:
            java.lang.String r0 = r2.trim()
            return r0
        L5c:
            if (r1 == 0) goto L61
            r1.close()     // Catch: java.io.IOException -> L61
        L61:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.danlan.android.cognition.collector.CpuCollector.getMinCpuFreq():java.lang.String");
    }

    public final String getSupportAbi() {
        String decrypt = StringFog.decrypt("VE1PTU5USg==");
        if (!NativeLib.checkLoadSo()) {
            return decrypt;
        }
        String pg = NativeLib.pg(StringFog.decrypt("U0wKU1NMQFRCVwpAUVYKQENKSEpSVw=="), StringFog.decrypt("VE1PTU5USg=="));
        return pg.equals(StringFog.decrypt("VE1PTU5USg==")) ? NativeLib.pg(StringFog.decrypt("U0wKUFhQUERMDVRRTkdRQlUNR1NUDUVDSE9NUFU="), StringFog.decrypt("VE1PTU5USg==")) : pg;
    }
}
