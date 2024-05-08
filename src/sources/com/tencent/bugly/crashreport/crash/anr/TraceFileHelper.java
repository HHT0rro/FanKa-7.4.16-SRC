package com.tencent.bugly.crashreport.crash.anr;

import com.alimm.tanx.core.web.cache.utils.TimeUtils;
import com.tencent.bugly.proguard.x;
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

/* compiled from: BUGLY */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class TraceFileHelper {

    /* compiled from: BUGLY */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public long f39197a;

        /* renamed from: b, reason: collision with root package name */
        public String f39198b;

        /* renamed from: c, reason: collision with root package name */
        public long f39199c;

        /* renamed from: d, reason: collision with root package name */
        public Map<String, String[]> f39200d;
    }

    /* compiled from: BUGLY */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface b {
        boolean a(long j10);

        boolean a(long j10, long j11, String str);

        boolean a(String str, int i10, String str2, String str3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001b, code lost:
    
        if (r5.matcher(r1).matches() == false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0026, code lost:
    
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0025, code lost:
    
        return new java.lang.Object[]{r5, r1};
     */
    /* JADX WARN: Code restructure failed: missing block: B:3:0x0003, code lost:
    
        if (r8 != null) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0006, code lost:
    
        r1 = r7.readLine();
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x000a, code lost:
    
        if (r1 == null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x000c, code lost:
    
        r2 = r8.length;
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x000f, code lost:
    
        if (r4 >= r2) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0011, code lost:
    
        r5 = r8[r4];
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.Object[] a(java.io.BufferedReader r7, java.util.regex.Pattern... r8) throws java.io.IOException {
        /*
            r0 = 0
            if (r7 == 0) goto L29
            if (r8 != 0) goto L6
            goto L29
        L6:
            java.lang.String r1 = r7.readLine()
            if (r1 == 0) goto L29
            int r2 = r8.length
            r3 = 0
            r4 = 0
        Lf:
            if (r4 >= r2) goto L6
            r5 = r8[r4]
            java.util.regex.Matcher r6 = r5.matcher(r1)
            boolean r6 = r6.matches()
            if (r6 == 0) goto L26
            r7 = 2
            java.lang.Object[] r7 = new java.lang.Object[r7]
            r7[r3] = r5
            r8 = 1
            r7[r8] = r1
            return r7
        L26:
            int r4 = r4 + 1
            goto Lf
        L29:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.a(java.io.BufferedReader, java.util.regex.Pattern[]):java.lang.Object[]");
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
            x.e("path:%s", str);
            return null;
        }
        final a aVar = new a();
        readTraceFile(str, new b() { // from class: com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.2
            @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
            public final boolean a(String str2, int i10, String str3, String str4) {
                x.c("new thread %s", str2);
                a aVar2 = a.this;
                if (aVar2.f39200d == null) {
                    aVar2.f39200d = new HashMap();
                }
                Map<String, String[]> map = a.this.f39200d;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(i10);
                map.put(str2, new String[]{str3, str4, sb2.toString()});
                return true;
            }

            @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
            public final boolean a(long j10, long j11, String str2) {
                x.c("new process %s", str2);
                a aVar2 = a.this;
                aVar2.f39197a = j10;
                aVar2.f39198b = str2;
                aVar2.f39199c = j11;
                return z10;
            }

            @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
            public final boolean a(long j10) {
                x.c("process end %d", Long.valueOf(j10));
                return false;
            }
        });
        if (aVar.f39197a > 0 && aVar.f39199c > 0 && aVar.f39198b != null) {
            return aVar;
        }
        x.e("first dump error %s", aVar.f39197a + " " + aVar.f39199c + " " + aVar.f39198b);
        return null;
    }

    public static a readTargetDumpInfo(final String str, String str2, final boolean z10) {
        if (str != null && str2 != null) {
            final a aVar = new a();
            readTraceFile(str2, new b() { // from class: com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.1
                @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
                public final boolean a(String str3, int i10, String str4, String str5) {
                    x.c("new thread %s", str3);
                    a aVar2 = a.this;
                    if (aVar2.f39197a > 0 && aVar2.f39199c > 0 && aVar2.f39198b != null) {
                        if (aVar2.f39200d == null) {
                            aVar2.f39200d = new HashMap();
                        }
                        Map<String, String[]> map = a.this.f39200d;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(i10);
                        map.put(str3, new String[]{str4, str5, sb2.toString()});
                    }
                    return true;
                }

                @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
                public final boolean a(long j10, long j11, String str3) {
                    x.c("new process %s", str3);
                    if (!str3.equals(str)) {
                        return true;
                    }
                    a aVar2 = a.this;
                    aVar2.f39197a = j10;
                    aVar2.f39198b = str3;
                    aVar2.f39199c = j11;
                    return z10;
                }

                @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
                public final boolean a(long j10) {
                    x.c("process end %d", Long.valueOf(j10));
                    a aVar2 = a.this;
                    return aVar2.f39197a <= 0 || aVar2.f39199c <= 0 || aVar2.f39198b == null;
                }
            });
            if (aVar.f39197a > 0 && aVar.f39199c > 0 && aVar.f39198b != null) {
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
                        Object[] a10 = a(bufferedReader2, compile);
                        if (a10 != null) {
                            String[] split = a10[1].toString().split("\\s");
                            long parseLong = Long.parseLong(split[2]);
                            long time = simpleDateFormat.parse(split[4] + " " + split[5]).getTime();
                            Object[] a11 = a(bufferedReader2, compile3);
                            if (a11 == null) {
                                try {
                                    bufferedReader2.close();
                                    return;
                                } catch (IOException e2) {
                                    if (x.a(e2)) {
                                        return;
                                    }
                                    e2.printStackTrace();
                                    return;
                                }
                            }
                            Matcher matcher = compile3.matcher(a11[1].toString());
                            matcher.find();
                            matcher.group(1);
                            SimpleDateFormat simpleDateFormat2 = simpleDateFormat;
                            if (!bVar.a(parseLong, time, matcher.group(1))) {
                                try {
                                    bufferedReader2.close();
                                    return;
                                } catch (IOException e10) {
                                    if (x.a(e10)) {
                                        return;
                                    }
                                    e10.printStackTrace();
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
                                    } catch (IOException e11) {
                                        if (x.a(e11)) {
                                            return;
                                        }
                                        e11.printStackTrace();
                                        return;
                                    }
                                }
                            }
                            simpleDateFormat = simpleDateFormat2;
                        } else {
                            try {
                                bufferedReader2.close();
                                return;
                            } catch (IOException e12) {
                                if (x.a(e12)) {
                                    return;
                                }
                                e12.printStackTrace();
                                return;
                            }
                        }
                    }
                } catch (Exception e13) {
                    e = e13;
                    bufferedReader = bufferedReader2;
                    if (!x.a(e)) {
                        e.printStackTrace();
                    }
                    x.d("trace open fail:%s : %s", e.getClass().getName(), e.getMessage());
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e14) {
                            if (x.a(e14)) {
                                return;
                            }
                            e14.printStackTrace();
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                            throw th;
                        } catch (IOException e15) {
                            if (!x.a(e15)) {
                                e15.printStackTrace();
                                throw th;
                            }
                            throw th;
                        }
                    }
                    throw th;
                }
            } catch (Exception e16) {
                e = e16;
            }
        } catch (Throwable th3) {
            th = th3;
        }
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
}
