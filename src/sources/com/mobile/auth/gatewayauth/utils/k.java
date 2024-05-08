package com.mobile.auth.gatewayauth.utils;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import com.mobile.auth.gatewayauth.ExceptionProcessor;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    private static int[] f37394a = {3, 10, 13, 0, 14, 5, 1, 8, 9, 4, 6, 7, -1, 2, 11, 12};

    public static int a(Context context, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            return context.getResources().getIdentifier(str, "drawable", context.getPackageName());
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return -1;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return -1;
            }
        }
    }

    public static Drawable a(Context context, String str, String str2) {
        Drawable drawable;
        int a10;
        int a11;
        try {
            try {
                if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
                    return null;
                }
                drawable = !TextUtils.isEmpty(str) ? (str.contains("/") || (a11 = a(context, str)) == 0) ? f(context, str) : ResourcesCompat.getDrawable(context.getResources(), a11, null) : null;
                if (drawable != null) {
                    return drawable;
                }
                try {
                    return (TextUtils.isEmpty(str2) || (a10 = a(context, str2)) == 0) ? drawable : ResourcesCompat.getDrawable(context.getResources(), a10, null);
                } catch (Exception e2) {
                    e = e2;
                    i.a(e);
                    return drawable;
                }
            } catch (Throwable th) {
                try {
                    ExceptionProcessor.processException(th);
                    return null;
                } catch (Throwable th2) {
                    ExceptionProcessor.processException(th2);
                    return null;
                }
            }
        } catch (Exception e10) {
            e = e10;
            drawable = null;
        }
    }

    public static void a(ViewGroup viewGroup, View view) {
        if (viewGroup == null || view == null) {
            return;
        }
        try {
            if (view.getParent() == null) {
                viewGroup.addView(view);
            }
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public static void a(ViewGroup viewGroup, View view, int i10) {
        if (viewGroup == null || view == null) {
            return;
        }
        try {
            if (view.getParent() != null || i10 < 0) {
                return;
            }
            viewGroup.addView(view, i10);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
            }
        }
    }

    public static boolean a(int i10) {
        int i11 = 0;
        while (true) {
            try {
                int[] iArr = f37394a;
                if (i11 >= iArr.length) {
                    return false;
                }
                if (i10 == iArr[i11]) {
                    return true;
                }
                i11++;
            } catch (Throwable th) {
                try {
                    ExceptionProcessor.processException(th);
                    return false;
                } catch (Throwable th2) {
                    ExceptionProcessor.processException(th2);
                    return false;
                }
            }
        }
    }

    public static boolean a(Context context) {
        try {
            return (context.getApplicationInfo().flags & 2) != 0;
        } catch (Exception unused) {
            return false;
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return false;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return false;
            }
        }
    }

    public static int b(Context context, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            return context.getResources().getIdentifier(str, "id", context.getPackageName());
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return -1;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return -1;
            }
        }
    }

    public static Drawable c(Context context, String str) {
        try {
            return a(context, str, (String) null);
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    public static ColorStateList d(Context context, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return ContextCompat.getColorStateList(context, e(context, str));
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }

    public static int e(Context context, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            return context.getResources().getIdentifier(str, "color", context.getPackageName());
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return -1;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return -1;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0043 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.io.InputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.drawable.Drawable f(android.content.Context r3, java.lang.String r4) {
        /*
            r0 = 0
            android.content.res.AssetManager r1 = r3.getAssets()     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L2a
            java.io.InputStream r4 = r1.open(r4)     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L2a
            android.graphics.Bitmap r1 = android.graphics.BitmapFactory.decodeStream(r4)     // Catch: java.lang.Exception -> L24 java.lang.Throwable -> L40
            android.graphics.drawable.BitmapDrawable r2 = new android.graphics.drawable.BitmapDrawable     // Catch: java.lang.Exception -> L22 java.lang.Throwable -> L40
            android.content.res.Resources r3 = r3.getResources()     // Catch: java.lang.Exception -> L22 java.lang.Throwable -> L40
            r2.<init>(r3, r1)     // Catch: java.lang.Exception -> L22 java.lang.Throwable -> L40
            if (r4 == 0) goto L20
            r4.close()     // Catch: java.io.IOException -> L1c java.lang.Throwable -> L4c
            goto L20
        L1c:
            r3 = move-exception
            com.mobile.auth.gatewayauth.utils.i.a(r3)     // Catch: java.lang.Throwable -> L4c
        L20:
            r0 = r2
            goto L3f
        L22:
            r3 = move-exception
            goto L2d
        L24:
            r3 = move-exception
            r1 = r0
            goto L2d
        L27:
            r3 = move-exception
            r4 = r0
            goto L41
        L2a:
            r3 = move-exception
            r4 = r0
            r1 = r4
        L2d:
            com.mobile.auth.gatewayauth.utils.i.a(r3)     // Catch: java.lang.Throwable -> L40
            if (r1 == 0) goto L35
            r1.recycle()     // Catch: java.lang.Throwable -> L40
        L35:
            if (r4 == 0) goto L3f
            r4.close()     // Catch: java.io.IOException -> L3b java.lang.Throwable -> L4c
            goto L3f
        L3b:
            r3 = move-exception
            com.mobile.auth.gatewayauth.utils.i.a(r3)     // Catch: java.lang.Throwable -> L4c
        L3f:
            return r0
        L40:
            r3 = move-exception
        L41:
            if (r4 == 0) goto L4b
            r4.close()     // Catch: java.io.IOException -> L47 java.lang.Throwable -> L4c
            goto L4b
        L47:
            r4 = move-exception
            com.mobile.auth.gatewayauth.utils.i.a(r4)     // Catch: java.lang.Throwable -> L4c
        L4b:
            throw r3     // Catch: java.lang.Throwable -> L4c
        L4c:
            r3 = move-exception
            com.mobile.auth.gatewayauth.ExceptionProcessor.processException(r3)     // Catch: java.lang.Throwable -> L51
            return r0
        L51:
            r3 = move-exception
            com.mobile.auth.gatewayauth.ExceptionProcessor.processException(r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobile.auth.gatewayauth.utils.k.f(android.content.Context, java.lang.String):android.graphics.drawable.Drawable");
    }

    public static String g(Context context, String str) {
        try {
            try {
                InputStreamReader inputStreamReader = new InputStreamReader(context.getResources().getAssets().open(str), "ISO_8859_1");
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                StringBuilder sb2 = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        inputStreamReader.close();
                        bufferedReader.close();
                        return sb2.toString();
                    }
                    sb2.append(readLine);
                }
            } catch (Exception e2) {
                i.a(e2);
                return null;
            }
        } catch (Throwable th) {
            try {
                ExceptionProcessor.processException(th);
                return null;
            } catch (Throwable th2) {
                ExceptionProcessor.processException(th2);
                return null;
            }
        }
    }
}
