package com.xiaomi.push.providers;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import com.xiaomi.push.y5;
import jc.a;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class TrafficProvider extends ContentProvider {

    /* renamed from: c, reason: collision with root package name */
    public static final Uri f48084c = Uri.parse("content://com.xiaomi.push.providers.TrafficProvider/traffic");

    /* renamed from: d, reason: collision with root package name */
    public static final UriMatcher f48085d;

    /* renamed from: b, reason: collision with root package name */
    public SQLiteOpenHelper f48086b;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        f48085d = uriMatcher;
        uriMatcher.addURI("com.xiaomi.push.providers.TrafficProvider", "traffic", 1);
        uriMatcher.addURI("com.xiaomi.push.providers.TrafficProvider", "update_imsi", 2);
    }

    @Override // android.content.ContentProvider
    public int bulkInsert(Uri uri, ContentValues[] contentValuesArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        if (f48085d.match(uri) == 1) {
            return "vnd.android.cursor.dir/vnd.xiaomi.push.traffic";
        }
        throw new IllegalArgumentException("Unknown URI " + ((Object) uri));
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        this.f48086b = new a(getContext());
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Cursor query;
        synchronized (a.f50558c) {
            if (f48085d.match(uri) != 1) {
                throw new IllegalArgumentException("Unknown URI " + ((Object) uri));
            }
            query = this.f48086b.getReadableDatabase().query("traffic", strArr, str, strArr2, null, null, str2);
        }
        return query;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        if (f48085d.match(uri) != 2 || contentValues == null || !contentValues.containsKey("imsi")) {
            return 0;
        }
        y5.m(contentValues.getAsString("imsi"));
        return 0;
    }
}
