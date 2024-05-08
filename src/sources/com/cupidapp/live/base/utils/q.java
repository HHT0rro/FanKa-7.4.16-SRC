package com.cupidapp.live.base.utils;

import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import androidx.loader.content.CursorLoader;
import com.android.internal.os.PowerProfile;
import com.huawei.quickcard.base.Attributes;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FilePathUtils.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final q f12371a = new q();

    public final String a(Context context, Uri uri, String str, String[] strArr) {
        try {
            Cursor query = context.getContentResolver().query(uri, new String[]{"_data"}, str, strArr, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        String string = query.getString(query.getColumnIndexOrThrow("_data"));
                        kotlin.io.b.a(query, null);
                        return string;
                    }
                } finally {
                }
            }
            kotlin.p pVar = kotlin.p.f51048a;
            kotlin.io.b.a(query, null);
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
        }
        return null;
    }

    public final String b(Context context, Uri uri) {
        String h10 = h(context, uri);
        if (h10 == null) {
            h10 = "";
        }
        Cursor query = context.getContentResolver().query(uri, new String[]{"_display_name"}, null, null, null);
        if (query != null) {
            try {
                if (query.moveToFirst()) {
                    String str = ((Object) h10) + query.getString(query.getColumnIndexOrThrow("_display_name"));
                    kotlin.io.b.a(query, null);
                    return str;
                }
            } finally {
            }
        }
        kotlin.p pVar = kotlin.p.f51048a;
        kotlin.io.b.a(query, null);
        return null;
    }

    public final String c(Context context, Uri uri) {
        if (context == null || uri == null) {
            return null;
        }
        if (kotlin.jvm.internal.s.d("file", uri.getScheme())) {
            return uri.getPath();
        }
        if (l(uri)) {
            return uri.getPath();
        }
        String f10 = f(context, uri);
        if (f10 != null) {
            return f10;
        }
        String d10 = d(context, uri);
        return d10 != null ? d10 : e(context, uri);
    }

    public final String d(Context context, Uri uri) {
        Cursor loadInBackground = new CursorLoader(context, uri, new String[]{"_data"}, null, null, null).loadInBackground();
        if (loadInBackground == null) {
            return null;
        }
        int columnIndexOrThrow = loadInBackground.getColumnIndexOrThrow("_data");
        loadInBackground.moveToFirst();
        String string = loadInBackground.getString(columnIndexOrThrow);
        loadInBackground.close();
        return string;
    }

    public final String e(Context context, Uri uri) {
        Uri uri2;
        if (!kotlin.jvm.internal.s.d("content", uri.getScheme()) || !DocumentsContract.isDocumentUri(context, uri)) {
            return null;
        }
        if (j(uri)) {
            String docId = DocumentsContract.getDocumentId(uri);
            kotlin.jvm.internal.s.h(docId, "docId");
            String[] strArr = (String[]) StringsKt__StringsKt.z0(docId, new String[]{com.huawei.openalliance.ad.constant.u.bD}, false, 0, 6, null).toArray(new String[0]);
            if (!kotlin.text.p.r("primary", strArr[0], true)) {
                return null;
            }
            if (strArr.length > 1) {
                return Environment.getExternalStorageDirectory().toString() + "/" + strArr[1];
            }
            return Environment.getExternalStorageDirectory().toString() + "/";
        }
        if (i(uri)) {
            int applicationEnabledSetting = context.getPackageManager().getApplicationEnabledSetting("com.android.providers.downloads");
            if (applicationEnabledSetting != 0 && applicationEnabledSetting != 1) {
                return null;
            }
            String id2 = DocumentsContract.getDocumentId(uri);
            kotlin.jvm.internal.s.h(id2, "id");
            if (kotlin.text.p.F(id2, "raw:", false, 2, null)) {
                kotlin.jvm.internal.s.h(id2, "id");
                return new Regex("raw:").replaceFirst(id2, "");
            }
            kotlin.jvm.internal.s.h(id2, "id");
            if (StringsKt__StringsKt.K(id2, com.huawei.openalliance.ad.constant.u.bD, false, 2, null)) {
                kotlin.jvm.internal.s.h(id2, "id");
                String[] strArr2 = (String[]) StringsKt__StringsKt.z0(id2, new String[]{com.huawei.openalliance.ad.constant.u.bD}, false, 0, 6, null).toArray(new String[0]);
                if (strArr2.length > 1) {
                    id2 = strArr2[1];
                }
            }
            Uri parse = Uri.parse("content://downloads/public_downloads");
            kotlin.jvm.internal.s.h(parse, "parse(\"content://downloads/public_downloads\")");
            try {
                kotlin.jvm.internal.s.h(id2, "id");
                Uri withAppendedId = ContentUris.withAppendedId(parse, Long.parseLong(id2));
                kotlin.jvm.internal.s.h(withAppendedId, "withAppendedId(contentUri, id.toLong())");
                parse = withAppendedId;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            String a10 = a(context, parse, null, null);
            if (a10 != null) {
                return a10;
            }
            String b4 = b(context, uri);
            if (b4 == null) {
                return null;
            }
            return Environment.getExternalStorageDirectory().toString() + "/Download/" + b4;
        }
        if (!k(uri)) {
            return null;
        }
        String docId2 = DocumentsContract.getDocumentId(uri);
        kotlin.jvm.internal.s.h(docId2, "docId");
        String[] strArr3 = (String[]) StringsKt__StringsKt.z0(docId2, new String[]{com.huawei.openalliance.ad.constant.u.bD}, false, 0, 6, null).toArray(new String[0]);
        String str = strArr3[0];
        int hashCode = str.hashCode();
        if (hashCode == 93166550) {
            if (str.equals(PowerProfile.POWER_AUDIO)) {
                uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
            }
            uri2 = null;
        } else if (hashCode != 100313435) {
            if (hashCode == 112202875 && str.equals("video")) {
                uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
            }
            uri2 = null;
        } else {
            if (str.equals(Attributes.Component.IMAGE)) {
                uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            }
            uri2 = null;
        }
        String[] strArr4 = {strArr3[1]};
        if (uri2 != null) {
            return f12371a.a(context, uri2, "_id=?", strArr4);
        }
        return null;
    }

    public final String f(Context context, Uri uri) {
        int columnIndexOrThrow;
        String str = null;
        if (kotlin.jvm.internal.s.d("content", uri.getScheme())) {
            Cursor query = context.getContentResolver().query(uri, new String[]{"_data"}, null, null, null);
            if (query != null) {
                if (query.moveToFirst() && (columnIndexOrThrow = query.getColumnIndexOrThrow("_data")) > -1) {
                    str = query.getString(columnIndexOrThrow);
                }
                query.close();
            }
        }
        return str;
    }

    @Nullable
    public final String g(@Nullable Context context, @Nullable String str) {
        if (context == null) {
            return null;
        }
        if (str == null || str.length() == 0) {
            return null;
        }
        return c(context, Uri.parse(str));
    }

    public final String h(Context context, Uri uri) {
        if (Build.VERSION.SDK_INT >= 29) {
            Cursor query = context.getContentResolver().query(uri, new String[]{"relative_path"}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        String string = query.getString(query.getColumnIndexOrThrow("relative_path"));
                        kotlin.io.b.a(query, null);
                        return string;
                    }
                } finally {
                }
            }
            kotlin.p pVar = kotlin.p.f51048a;
            kotlin.io.b.a(query, null);
        }
        return null;
    }

    public final boolean i(Uri uri) {
        return kotlin.jvm.internal.s.d("com.android.providers.downloads.documents", uri.getAuthority());
    }

    public final boolean j(Uri uri) {
        return kotlin.jvm.internal.s.d("com.android.externalstorage.documents", uri.getAuthority());
    }

    public final boolean k(Uri uri) {
        return kotlin.jvm.internal.s.d("com.android.providers.media.documents", uri.getAuthority());
    }

    public final boolean l(Uri uri) {
        String path = uri != null ? uri.getPath() : null;
        return !(path == null || path.length() == 0) && (kotlin.text.p.F(path, "/storage", false, 2, null) || kotlin.text.p.F(path, "/external_files", false, 2, null));
    }
}
