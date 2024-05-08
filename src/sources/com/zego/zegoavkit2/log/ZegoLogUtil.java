package com.zego.zegoavkit2.log;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import java.io.File;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class ZegoLogUtil {
    public static void createIfNotExist(Context context, String str, String str2) {
        if (str == null || str.isEmpty()) {
            return;
        }
        if (str2 == null || str2.isEmpty()) {
            str2 = "application/octet-stream";
        }
        try {
            Uri parse = Uri.parse(str);
            File file = new File(DocumentsContract.getDocumentId(parse));
            String parent = file.getParent();
            String name = file.getName();
            Uri buildDocumentUriUsingTree = DocumentsContract.buildDocumentUriUsingTree(parse, parent);
            if (find(context, buildDocumentUriUsingTree, name) != null) {
                return;
            }
            DocumentsContract.createDocument(context.getContentResolver(), buildDocumentUriUsingTree, str2, name);
        } catch (Exception unused) {
        }
    }

    public static void delete(Context context, String str) {
        try {
            Uri parse = Uri.parse(str);
            File file = new File(DocumentsContract.getDocumentId(parse));
            String parent = file.getParent();
            if (find(context, DocumentsContract.buildDocumentUriUsingTree(parse, parent), file.getName()) == null) {
                return;
            }
            DocumentsContract.deleteDocument(context.getContentResolver(), parse);
        } catch (Exception unused) {
        }
    }

    public static Uri find(Context context, Uri uri, String str) {
        Cursor query = context.getContentResolver().query(DocumentsContract.buildChildDocumentsUriUsingTree(uri, DocumentsContract.getDocumentId(uri)), new String[]{"document_id", "_display_name"}, null, null, null);
        Uri uri2 = null;
        if (query == null) {
            return null;
        }
        while (true) {
            if (!query.moveToNext()) {
                break;
            }
            if (query.getString(query.getColumnIndex("_display_name")).equalsIgnoreCase(str)) {
                uri2 = DocumentsContract.buildDocumentUriUsingTree(uri, query.getString(query.getColumnIndex("document_id")));
                break;
            }
        }
        query.close();
        return uri2;
    }

    public static int getFD(Context context, String str, String str2) {
        try {
            return context.getContentResolver().openFileDescriptor(Uri.parse(str), str2).detachFd();
        } catch (Exception unused) {
            return 0;
        }
    }

    public static long getFileSize(Context context, Uri uri, String str) {
        Cursor query = context.getContentResolver().query(DocumentsContract.buildChildDocumentsUriUsingTree(uri, DocumentsContract.getDocumentId(uri)), new String[]{"_size", "_display_name"}, null, null, null);
        long j10 = 0;
        if (query == null) {
            return 0L;
        }
        while (true) {
            if (!query.moveToNext()) {
                break;
            }
            if (query.getString(query.getColumnIndex("_display_name")).equalsIgnoreCase(str)) {
                j10 = query.getLong(query.getColumnIndex("_size"));
                break;
            }
        }
        query.close();
        return j10;
    }

    public static String withAppendedPath(String str, String str2) {
        try {
            Uri parse = Uri.parse(str);
            return DocumentsContract.buildDocumentUriUsingTree(parse, DocumentsContract.getDocumentId(parse) + "/" + str2).toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public static long getFileSize(Context context, String str, String str2) {
        if (str == null || str.isEmpty() || str2 == null || str2.isEmpty()) {
            return 0L;
        }
        return getFileSize(context, Uri.parse(str), str2);
    }

    public static long getFileSize(Context context, String str) {
        Uri parse;
        File file;
        String parent;
        if (str == null) {
            return 0L;
        }
        if (!str.isEmpty()) {
            try {
                parse = Uri.parse(str);
                file = new File(DocumentsContract.getDocumentId(parse));
                parent = file.getParent();
            } catch (Exception unused) {
                return 0L;
            }
        }
        return getFileSize(context, DocumentsContract.buildDocumentUriUsingTree(parse, parent), file.getName());
    }
}
