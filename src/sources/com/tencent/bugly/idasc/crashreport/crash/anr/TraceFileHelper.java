package com.tencent.bugly.idasc.crashreport.crash.anr;

import com.alimm.tanx.core.web.cache.utils.TimeUtils;
import com.tencent.bugly.idasc.proguard.al;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class TraceFileHelper {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public long f39440a;

        /* renamed from: b, reason: collision with root package name */
        public String f39441b;

        /* renamed from: c, reason: collision with root package name */
        public long f39442c;

        /* renamed from: d, reason: collision with root package name */
        public Map<String, String[]> f39443d;
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface b {
        boolean a(long j10);

        boolean a(long j10, long j11, String str);

        boolean a(String str, int i10, String str2, String str3);
    }

    private static String a(BufferedReader bufferedReader) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i10 = 0; i10 < 3; i10++) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return null;
            }
            stringBuffer.append(readLine + "\n");
        }
        return stringBuffer.toString();
    }

    private static Object[] a(BufferedReader bufferedReader, Pattern... patternArr) throws IOException {
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return null;
            }
            for (Pattern pattern : patternArr) {
                if (pattern.matcher(readLine).matches()) {
                    return new Object[]{pattern, readLine};
                }
            }
        }
    }

    private static String b(BufferedReader bufferedReader) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null || readLine.trim().length() <= 0) {
                break;
            }
            stringBuffer.append(readLine + "\n");
        }
        return stringBuffer.toString();
    }

    public static a readFirstDumpInfo(String str, final boolean z10) {
        if (str == null) {
            al.e("path:%s", str);
            return null;
        }
        final a aVar = new a();
        readTraceFile(str, new b() { // from class: com.tencent.bugly.idasc.crashreport.crash.anr.TraceFileHelper.2
            @Override // com.tencent.bugly.idasc.crashreport.crash.anr.TraceFileHelper.b
            public final boolean a(long j10) {
                al.c("process end %d", Long.valueOf(j10));
                return false;
            }

            @Override // com.tencent.bugly.idasc.crashreport.crash.anr.TraceFileHelper.b
            public final boolean a(long j10, long j11, String str2) {
                al.c("new process %s", str2);
                a aVar2 = a.this;
                aVar2.f39440a = j10;
                aVar2.f39441b = str2;
                aVar2.f39442c = j11;
                return z10;
            }

            @Override // com.tencent.bugly.idasc.crashreport.crash.anr.TraceFileHelper.b
            public final boolean a(String str2, int i10, String str3, String str4) {
                al.c("new thread %s", str2);
                a aVar2 = a.this;
                if (aVar2.f39443d == null) {
                    aVar2.f39443d = new HashMap();
                }
                a.this.f39443d.put(str2, new String[]{str3, str4, String.valueOf(i10)});
                return true;
            }
        });
        if (aVar.f39440a > 0 && aVar.f39442c > 0 && aVar.f39441b != null) {
            return aVar;
        }
        al.e("first dump error %s", aVar.f39440a + " " + aVar.f39442c + " " + aVar.f39441b);
        return null;
    }

    public static a readTargetDumpInfo(final String str, String str2, final boolean z10) {
        if (str != null && str2 != null) {
            final a aVar = new a();
            readTraceFile(str2, new b() { // from class: com.tencent.bugly.idasc.crashreport.crash.anr.TraceFileHelper.1
                @Override // com.tencent.bugly.idasc.crashreport.crash.anr.TraceFileHelper.b
                public final boolean a(long j10) {
                    al.c("process end %d", Long.valueOf(j10));
                    a aVar2 = a.this;
                    return aVar2.f39440a <= 0 || aVar2.f39442c <= 0 || aVar2.f39441b == null;
                }

                @Override // com.tencent.bugly.idasc.crashreport.crash.anr.TraceFileHelper.b
                public final boolean a(long j10, long j11, String str3) {
                    al.c("new process %s", str3);
                    if (!str3.equals(str)) {
                        return true;
                    }
                    a aVar2 = a.this;
                    aVar2.f39440a = j10;
                    aVar2.f39441b = str3;
                    aVar2.f39442c = j11;
                    return z10;
                }

                @Override // com.tencent.bugly.idasc.crashreport.crash.anr.TraceFileHelper.b
                public final boolean a(String str3, int i10, String str4, String str5) {
                    al.c("new thread %s", str3);
                    a aVar2 = a.this;
                    if (aVar2.f39440a > 0 && aVar2.f39442c > 0 && aVar2.f39441b != null) {
                        if (aVar2.f39443d == null) {
                            aVar2.f39443d = new HashMap();
                        }
                        a.this.f39443d.put(str3, new String[]{str4, str5, String.valueOf(i10)});
                    }
                    return true;
                }
            });
            if (aVar.f39440a > 0 && aVar.f39442c > 0 && aVar.f39441b != null) {
                return aVar;
            }
        }
        return null;
    }

    public static void readTraceFile(String str, b bVar) {
        Throwable th;
        if (str == null || bVar == null) {
            return;
        }
        File file = new File(str);
        if (!file.exists()) {
            return;
        }
        file.lastModified();
        file.length();
        BufferedReader bufferedReader = null;
        int i10 = 0;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
                try {
                    Pattern compile = Pattern.compile("-{5}\\spid\\s\\d+\\sat\\s\\d+-\\d+-\\d+\\s\\d{2}:\\d{2}:\\d{2}\\s-{5}");
                    Pattern compile2 = Pattern.compile("-{5}\\send\\s\\d+\\s-{5}");
                    Pattern compile3 = Pattern.compile("Cmd\\sline:\\s(\\S+)");
                    Pattern compile4 = Pattern.compile("\".+\"\\s(daemon\\s){0,1}prio=\\d+\\stid=\\d+\\s.*");
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TimeUtils.STARD_FROMAT, Locale.US);
                    while (true) {
                        Pattern[] patternArr = new Pattern[1];
                        patternArr[i10] = compile;
                        Object[] a10 = a(bufferedReader2, patternArr);
                        if (a10 == null) {
                            try {
                                bufferedReader2.close();
                                return;
                            } catch (IOException e2) {
                                if (al.a(e2)) {
                                    return;
                                }
                                e2.printStackTrace();
                                return;
                            }
                        }
                        Pattern[] patternArr2 = new Pattern[1];
                        patternArr2[i10] = compile3;
                        Object[] a11 = a(bufferedReader2, patternArr2);
                        if (a11 == null) {
                            al.d("Failed to find process name.", new Object[i10]);
                            try {
                                bufferedReader2.close();
                                return;
                            } catch (IOException e10) {
                                if (al.a(e10)) {
                                    return;
                                }
                                e10.printStackTrace();
                                return;
                            }
                        }
                        String[] split = a10[1].toString().split("\\s");
                        long parseLong = Long.parseLong(split[2]);
                        long time = simpleDateFormat.parse(split[4] + " " + split[5]).getTime();
                        Matcher matcher = compile3.matcher(a11[1].toString());
                        matcher.find();
                        matcher.group(1);
                        SimpleDateFormat simpleDateFormat2 = simpleDateFormat;
                        if (!bVar.a(parseLong, time, matcher.group(1))) {
                            try {
                                bufferedReader2.close();
                                return;
                            } catch (IOException e11) {
                                if (al.a(e11)) {
                                    return;
                                }
                                e11.printStackTrace();
                                return;
                            }
                        }
                        while (true) {
                            Object[] a12 = a(bufferedReader2, compile4, compile2);
                            if (a12 == null) {
                                break;
                            }
                            if (a12[0] == compile4) {
                                String obj = a12[1].toString();
                                Matcher matcher2 = Pattern.compile("\".+\"").matcher(obj);
                                matcher2.find();
                                String group = matcher2.group();
                                String substring = group.substring(1, group.length() - 1);
                                obj.contains("NATIVE");
                                Matcher matcher3 = Pattern.compile("tid=\\d+").matcher(obj);
                                matcher3.find();
                                String group2 = matcher3.group();
                                bVar.a(substring, Integer.parseInt(group2.substring(group2.indexOf("=") + 1)), a(bufferedReader2), b(bufferedReader2));
                            } else if (!bVar.a(Long.parseLong(a12[1].toString().split("\\s")[2]))) {
                                try {
                                    bufferedReader2.close();
                                    return;
                                } catch (IOException e12) {
                                    if (al.a(e12)) {
                                        return;
                                    }
                                    e12.printStackTrace();
                                    return;
                                }
                            }
                        }
                        simpleDateFormat = simpleDateFormat2;
                        i10 = 0;
                    }
                } catch (Exception e13) {
                    e = e13;
                    bufferedReader = bufferedReader2;
                    if (!al.a(e)) {
                        e.printStackTrace();
                    }
                    al.d("trace open fail:%s : %s", e.getClass().getName(), e.getMessage());
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e14) {
                            if (al.a(e14)) {
                                return;
                            }
                            e14.printStackTrace();
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = bufferedReader2;
                    if (bufferedReader == null) {
                        throw th;
                    }
                    try {
                        bufferedReader.close();
                        throw th;
                    } catch (IOException e15) {
                        if (al.a(e15)) {
                            throw th;
                        }
                        e15.printStackTrace();
                        throw th;
                    }
                }
            } catch (Exception e16) {
                e = e16;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
