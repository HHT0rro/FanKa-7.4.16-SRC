package com.cupidapp.live.base.network;

import android.content.Context;
import android.os.Build;
import com.cupidapp.live.base.network.model.Result;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Locale;
import java.util.UUID;
import kotlin.collections.i0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.k;

/* compiled from: GuidHelper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class GuidHelper {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GuidHelper f11866a = new GuidHelper();

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static UserInstallAppState f11867b = UserInstallAppState.Unknown;

    /* compiled from: GuidHelper.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public enum UserInstallAppState {
        NeverInstalled,
        Unknown
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String a(final Context context) {
        String uuid = UUID.randomUUID().toString();
        s.h(uuid, "randomUUID().toString()");
        Locale ENGLISH = Locale.ENGLISH;
        s.h(ENGLISH, "ENGLISH");
        String upperCase = uuid.toUpperCase(ENGLISH);
        s.h(upperCase, "this as java.lang.String).toUpperCase(locale)");
        Observable<Result<Object>> e2 = NetworkClient.f11868a.i().e(upperCase);
        Function1<Throwable, Boolean> function1 = new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.base.network.GuidHelper$createNewGUID$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull Throwable it) {
                s.i(it, "it");
                j jVar = j.f12008a;
                final Context context2 = context;
                j.f(jVar, it, null, i0.h(kotlin.f.a(200529, new Function1<String, p>() { // from class: com.cupidapp.live.base.network.GuidHelper$createNewGUID$2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ p invoke(String str) {
                        invoke2(str);
                        return p.f51048a;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable String str) {
                        GuidHelper.f11866a.e(context2);
                    }
                })), null, 10, null);
                return Boolean.TRUE;
            }
        };
        g gVar = context instanceof g ? (g) context : null;
        Disposable disposed = e2.flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(new Function1<Object, p>() { // from class: com.cupidapp.live.base.network.GuidHelper$createNewGUID$$inlined$handleByContext$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ p invoke(Object obj) {
                invoke2(obj);
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
            }
        }), new e(new ObservableExtensionKt$handle$disposed$2(function1, gVar)));
        if (disposed != null) {
            s.h(disposed, "disposed");
            if (gVar != null) {
                gVar.H(disposed);
            }
        }
        s.h(disposed, "disposed");
        p1.g.f52734a.U1(upperCase);
        return upperCase;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0050 A[Catch: IOException -> 0x0054, TRY_LEAVE, TryCatch #3 {IOException -> 0x0054, blocks: (B:28:0x004b, B:30:0x0050), top: B:27:0x004b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String b(android.content.Context r4, java.lang.String r5) {
        /*
            r3 = this;
            if (r4 == 0) goto L63
            int r0 = r5.length()
            if (r0 != 0) goto La
            r0 = 1
            goto Lb
        La:
            r0 = 0
        Lb:
            if (r0 == 0) goto Le
            goto L63
        Le:
            r0 = 0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.io.InputStream r4 = z0.f.q(r4, r5)
            if (r4 == 0) goto L59
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L3a
            r5.<init>(r4)     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L3a
            com.cupidapp.live.base.network.GuidHelper$getFileInfo$1 r0 = new com.cupidapp.live.base.network.GuidHelper$getFileInfo$1     // Catch: java.io.IOException -> L33 java.lang.Throwable -> L4a
            r0.<init>()     // Catch: java.io.IOException -> L33 java.lang.Throwable -> L4a
            kotlin.io.k.a(r5, r0)     // Catch: java.io.IOException -> L33 java.lang.Throwable -> L4a
            z0.f.e(r4)     // Catch: java.io.IOException -> L2e
            r5.close()     // Catch: java.io.IOException -> L2e
            goto L59
        L2e:
            r4 = move-exception
            r4.printStackTrace()
            goto L59
        L33:
            r0 = move-exception
            goto L3e
        L35:
            r5 = move-exception
            r2 = r0
            r0 = r5
            r5 = r2
            goto L4b
        L3a:
            r5 = move-exception
            r2 = r0
            r0 = r5
            r5 = r2
        L3e:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L4a
            z0.f.e(r4)     // Catch: java.io.IOException -> L2e
            if (r5 == 0) goto L59
            r5.close()     // Catch: java.io.IOException -> L2e
            goto L59
        L4a:
            r0 = move-exception
        L4b:
            z0.f.e(r4)     // Catch: java.io.IOException -> L54
            if (r5 == 0) goto L58
            r5.close()     // Catch: java.io.IOException -> L54
            goto L58
        L54:
            r4 = move-exception
            r4.printStackTrace()
        L58:
            throw r0
        L59:
            java.lang.String r4 = r1.toString()
            java.lang.String r5 = "builder.toString()"
            kotlin.jvm.internal.s.h(r4, r5)
            return r4
        L63:
            java.lang.String r4 = ""
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.base.network.GuidHelper.b(android.content.Context, java.lang.String):java.lang.String");
    }

    public final String c(Context context) {
        if (Build.VERSION.SDK_INT < 29) {
            String b4 = b(context, "/storage/emulated/0/finka2020/.guid.txt");
            return b4.length() == 0 ? b(context, "/storage/emulated/0/wealoha.com/.guid.txt") : b4;
        }
        return d(context);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0066, code lost:
    
        r4 = r4.toString();
        kotlin.jvm.internal.s.h(r4, "fileUri.toString()");
        r0 = b(r15, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0077, code lost:
    
        if (r0.length() != 0) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0079, code lost:
    
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x007c, code lost:
    
        if (r4 == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x007e, code lost:
    
        r15.getContentResolver().delete(r1, "_id=?", new java.lang.String[]{java.lang.String.valueOf(r12)});
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x007b, code lost:
    
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00a7, code lost:
    
        if (r11.isClosed() == false) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String d(android.content.Context r15) {
        /*
            r14 = this;
            java.lang.String r0 = ""
            if (r15 != 0) goto L5
            return r0
        L5:
            java.lang.String r1 = "external"
            android.net.Uri r1 = android.provider.MediaStore.Files.getContentUri(r1)
            java.lang.String r8 = "_id"
            java.lang.String r9 = "mime_type"
            java.lang.String r10 = "_display_name"
            java.lang.String[] r4 = new java.lang.String[]{r8, r9, r10}
            java.lang.String r5 = "media_type=? AND mime_type=?"
            java.lang.String r2 = "2"
            java.lang.String r3 = "audio/mpeg"
            java.lang.String[] r6 = new java.lang.String[]{r2, r3}
            r11 = 0
            android.content.ContentResolver r2 = r15.getContentResolver()     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            r7 = 0
            r3 = r1
            android.database.Cursor r11 = r2.query(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
        L2a:
            r2 = 1
            r3 = 0
            if (r11 == 0) goto L36
            boolean r4 = r11.moveToNext()     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            if (r4 != r2) goto L36
            r4 = 1
            goto L37
        L36:
            r4 = 0
        L37:
            if (r4 == 0) goto L8f
            int r4 = r11.getColumnIndex(r8)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            int r5 = r11.getColumnIndex(r9)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            int r6 = r11.getColumnIndex(r10)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            r7 = -1
            if (r4 == r7) goto L2a
            if (r5 == r7) goto L2a
            if (r6 == r7) goto L2a
            long r12 = r11.getLong(r4)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            java.lang.String r4 = r11.getString(r5)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            z0.w r5 = z0.w.f54826a     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            android.net.Uri r4 = r5.c(r12, r4)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            java.lang.String r5 = r11.getString(r6)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            java.lang.String r6 = "wealoha_guid.mp3"
            boolean r5 = kotlin.jvm.internal.s.d(r5, r6)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            if (r5 == 0) goto L2a
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            java.lang.String r5 = "fileUri.toString()"
            kotlin.jvm.internal.s.h(r4, r5)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            java.lang.String r0 = r14.b(r15, r4)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            int r4 = r0.length()     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            if (r4 != 0) goto L7b
            r4 = 1
            goto L7c
        L7b:
            r4 = 0
        L7c:
            if (r4 == 0) goto L8f
            java.lang.String r4 = "_id=?"
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            java.lang.String r5 = java.lang.String.valueOf(r12)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            r2[r3] = r5     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            android.content.ContentResolver r15 = r15.getContentResolver()     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
            r15.delete(r1, r4, r2)     // Catch: java.lang.Throwable -> L9b java.lang.Exception -> L9d
        L8f:
            if (r11 == 0) goto Laa
            boolean r15 = r11.isClosed()
            if (r15 != 0) goto Laa
        L97:
            r11.close()
            goto Laa
        L9b:
            r15 = move-exception
            goto Lab
        L9d:
            r15 = move-exception
            r15.printStackTrace()     // Catch: java.lang.Throwable -> L9b
            if (r11 == 0) goto Laa
            boolean r15 = r11.isClosed()
            if (r15 != 0) goto Laa
            goto L97
        Laa:
            return r0
        Lab:
            if (r11 == 0) goto Lb6
            boolean r0 = r11.isClosed()
            if (r0 != 0) goto Lb6
            r11.close()
        Lb6:
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.base.network.GuidHelper.d(android.content.Context):java.lang.String");
    }

    public final void e(@Nullable Context context) {
        if (z0.h.b(context, com.kuaishou.weapon.p0.g.f36123i) && z0.h.b(context, com.kuaishou.weapon.p0.g.f36124j)) {
            p1.g gVar = p1.g.f52734a;
            String g3 = gVar.g();
            if (g3 == null) {
                g3 = "";
            }
            String c4 = ((g3.length() == 0) || gVar.s0().c() == null || s.d(gVar.s0().c(), Boolean.TRUE)) ? c(context) : "";
            if (g3.length() == 0) {
                if (c4.length() == 0) {
                    f11867b = UserInstallAppState.NeverInstalled;
                    String a10 = a(context);
                    if (Build.VERSION.SDK_INT >= 29) {
                        gVar.L1().d(Boolean.TRUE);
                    }
                    g(context, a10);
                    gVar.s0().d(Boolean.FALSE);
                    return;
                }
            }
            if (!s.d(g3, c4)) {
                if (c4.length() > 0) {
                    gVar.U1(c4);
                    if (Build.VERSION.SDK_INT >= 29) {
                        gVar.L1().d(Boolean.TRUE);
                    }
                    gVar.s0().d(Boolean.FALSE);
                    return;
                }
            }
            if (g3.length() > 0) {
                if (Build.VERSION.SDK_INT < 29) {
                    g(context, g3);
                } else if (s.d(gVar.L1().c(), Boolean.FALSE)) {
                    gVar.L1().d(Boolean.TRUE);
                    g(context, g3);
                }
                gVar.s0().d(Boolean.FALSE);
                return;
            }
            return;
        }
        String g10 = p1.g.f52734a.g();
        if ((g10 != null ? g10 : "").length() == 0) {
            a(context);
        }
    }

    public final void f(File file, String str) {
        FileOutputStream fileOutputStream;
        OutputStreamWriter outputStreamWriter = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file);
                try {
                    try {
                        OutputStreamWriter outputStreamWriter2 = new OutputStreamWriter(fileOutputStream);
                        try {
                            outputStreamWriter2.write(str);
                            fileOutputStream.flush();
                            outputStreamWriter2.close();
                            fileOutputStream.close();
                        } catch (IOException e2) {
                            e = e2;
                            outputStreamWriter = outputStreamWriter2;
                            e.printStackTrace();
                            if (outputStreamWriter != null) {
                                outputStreamWriter.close();
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                        } catch (Throwable th) {
                            th = th;
                            outputStreamWriter = outputStreamWriter2;
                            if (outputStreamWriter != null) {
                                try {
                                    outputStreamWriter.close();
                                } catch (IOException e10) {
                                    e10.printStackTrace();
                                    throw th;
                                }
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (IOException e11) {
                    e = e11;
                }
            } catch (IOException e12) {
                e = e12;
                fileOutputStream = null;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = null;
            }
        } catch (IOException e13) {
            e13.printStackTrace();
        }
    }

    public final void g(Context context, String str) {
        if (Build.VERSION.SDK_INT < 29) {
            try {
                File f10 = k.f54819a.f(new File("/storage/emulated/0/finka2020"), ".guid.txt");
                if (f10 != null) {
                    f11866a.f(f10, str);
                    return;
                }
                return;
            } catch (IOException e2) {
                e2.printStackTrace();
                return;
            }
        }
        h(context, str);
    }

    public final void h(Context context, String str) {
        k.a aVar;
        File g3;
        if (context == null || (g3 = (aVar = k.f54819a).g(context, "wealoha_guid.mp3")) == null) {
            return;
        }
        f(g3, str);
        aVar.E(context, g3, "wealoha_guid.mp3", "audio/mpeg");
    }
}
