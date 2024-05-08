package com.xiaomi.push;

import android.content.Context;
import android.os.Build;
import com.alimm.tanx.core.web.cache.utils.TimeUtils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class d2 {

    /* renamed from: h, reason: collision with root package name */
    public static String f47170h = "/MiPushLog";

    /* renamed from: b, reason: collision with root package name */
    public String f47172b;

    /* renamed from: c, reason: collision with root package name */
    public String f47173c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f47174d;

    /* renamed from: e, reason: collision with root package name */
    public int f47175e;

    /* renamed from: a, reason: collision with root package name */
    public final SimpleDateFormat f47171a = new SimpleDateFormat(TimeUtils.STARD_FROMAT);

    /* renamed from: f, reason: collision with root package name */
    public int f47176f = 2097152;

    /* renamed from: g, reason: collision with root package name */
    public ArrayList<File> f47177g = new ArrayList<>();

    public d2 a(File file) {
        if (file.exists()) {
            this.f47177g.add(file);
        }
        return this;
    }

    public d2 b(Date date, Date date2) {
        String format;
        if (date.after(date2)) {
            this.f47172b = this.f47171a.format(date2);
            format = this.f47171a.format(date);
        } else {
            this.f47172b = this.f47171a.format(date);
            format = this.f47171a.format(date2);
        }
        this.f47173c = format;
        return this;
    }

    public File c(Context context, Date date, Date date2, File file) {
        File file2;
        if ("com.xiaomi.xmsf".equalsIgnoreCase(context.getPackageName())) {
            file2 = context.getFilesDir();
            a(new File(file2, "xmsf.log.1"));
            a(new File(file2, "xmsf.log"));
        } else {
            File file3 = new File(((Object) context.getExternalFilesDir(null)) + f47170h);
            a(new File(file3, "log0.txt"));
            a(new File(file3, "log1.txt"));
            file2 = file3;
        }
        if (!file2.isDirectory()) {
            return null;
        }
        File file4 = new File(file, date.getTime() + "-" + date2.getTime() + ".zip");
        if (file4.exists()) {
            return null;
        }
        b(date, date2);
        long currentTimeMillis = System.currentTimeMillis();
        File file5 = new File(file, "log.txt");
        f(file5);
        fc.c.m("LOG: filter cost = " + (System.currentTimeMillis() - currentTimeMillis));
        if (file5.exists()) {
            long currentTimeMillis2 = System.currentTimeMillis();
            s7.d(file4, file5);
            fc.c.m("LOG: zip cost = " + (System.currentTimeMillis() - currentTimeMillis2));
            file5.delete();
            if (file4.exists()) {
                return file4;
            }
        }
        return null;
    }

    public void d(int i10) {
        if (i10 != 0) {
            this.f47176f = i10;
        }
    }

    public final void e(BufferedReader bufferedReader, BufferedWriter bufferedWriter, Pattern pattern) {
        char[] cArr = new char[4096];
        int read = bufferedReader.read(cArr);
        boolean z10 = false;
        while (read != -1 && !z10) {
            String str = new String(cArr, 0, read);
            Matcher matcher = pattern.matcher(str);
            int i10 = 0;
            int i11 = 0;
            while (true) {
                if (i10 >= read || !matcher.find(i10)) {
                    break;
                }
                int start = matcher.start();
                String substring = str.substring(start, this.f47172b.length() + start);
                if (this.f47174d) {
                    if (substring.compareTo(this.f47173c) > 0) {
                        read = start;
                        z10 = true;
                        break;
                    }
                } else if (substring.compareTo(this.f47172b) >= 0) {
                    this.f47174d = true;
                    i11 = start;
                }
                int indexOf = str.indexOf(10, start);
                if (indexOf == -1) {
                    indexOf = this.f47172b.length();
                }
                i10 = start + indexOf;
            }
            if (this.f47174d) {
                int i12 = read - i11;
                this.f47175e += i12;
                bufferedWriter.write(cArr, i11, i12);
                if (z10 || this.f47175e > this.f47176f) {
                    return;
                }
            }
            read = bufferedReader.read(cArr);
        }
    }

    public final void f(File file) {
        BufferedReader bufferedReader;
        String str;
        Pattern compile = Pattern.compile("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}");
        BufferedReader bufferedReader2 = null;
        try {
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
                try {
                    bufferedWriter.write("model :" + Build.MODEL + "; os :" + Build.VERSION.INCREMENTAL + "; uid :" + kc.x.f() + "; lng :" + Locale.getDefault().toString() + "; sdk :39; andver :" + Build.VERSION.SDK_INT + "\n");
                    this.f47175e = 0;
                    Iterator<File> iterator2 = this.f47177g.iterator2();
                    while (iterator2.hasNext()) {
                        bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(iterator2.next())));
                        try {
                            e(bufferedReader, bufferedWriter, compile);
                            bufferedReader.close();
                            bufferedReader2 = bufferedReader;
                        } catch (FileNotFoundException e2) {
                            e = e2;
                            bufferedReader2 = bufferedWriter;
                            str = "LOG: filter error = " + e.getMessage();
                            fc.c.m(str);
                            s7.b(bufferedReader2);
                            s7.b(bufferedReader);
                            return;
                        } catch (IOException e10) {
                            e = e10;
                            bufferedReader2 = bufferedWriter;
                            str = "LOG: filter error = " + e.getMessage();
                            fc.c.m(str);
                            s7.b(bufferedReader2);
                            s7.b(bufferedReader);
                            return;
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader2 = bufferedWriter;
                            s7.b(bufferedReader2);
                            s7.b(bufferedReader);
                            throw th;
                        }
                    }
                    bufferedWriter.write(v1.c().u());
                    s7.b(bufferedWriter);
                    s7.b(bufferedReader2);
                } catch (FileNotFoundException e11) {
                    e = e11;
                    bufferedReader = bufferedReader2;
                } catch (IOException e12) {
                    e = e12;
                    bufferedReader = bufferedReader2;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = bufferedReader2;
                }
            } catch (FileNotFoundException e13) {
                e = e13;
                bufferedReader = null;
            } catch (IOException e14) {
                e = e14;
                bufferedReader = null;
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }
}
