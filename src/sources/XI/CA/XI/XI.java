package XI.CA.XI;

import android.content.Context;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class XI {

    /* renamed from: XI, reason: collision with root package name */
    public Context f640XI;

    public XI(Context context) {
        this.f640XI = context;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:1|(3:3|(2:5|(2:7|(7:9|10|11|(4:18|19|(1:21)|22)|(1:17)|14|15)(1:37))(1:39))(1:41)|40)(1:42)|38|10|11|(0)|(0)|14|15|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0068, code lost:
    
        r9 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0061, code lost:
    
        r10 = th;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0042 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String XI(int r9, java.lang.String r10) {
        /*
            r8 = this;
            r0 = 0
            if (r9 == 0) goto L2b
            r1 = 1
            if (r9 == r1) goto L19
            r1 = 2
            if (r9 == r1) goto L11
            r10 = 4
            if (r9 == r10) goto Le
            r2 = r0
            goto L32
        Le:
            java.lang.String r9 = "content://com.vivo.vms.IdProvider/IdentifierId/OAIDSTATUS"
            goto L2d
        L11:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r1 = "content://com.vivo.vms.IdProvider/IdentifierId/AAID_"
            goto L20
        L19:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r1 = "content://com.vivo.vms.IdProvider/IdentifierId/VAID_"
        L20:
            r9.append(r1)
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            goto L2d
        L2b:
            java.lang.String r9 = "content://com.vivo.vms.IdProvider/IdentifierId/OAID"
        L2d:
            android.net.Uri r9 = android.net.Uri.parse(r9)
            r2 = r9
        L32:
            android.content.Context r9 = r8.f640XI     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L68
            android.content.ContentResolver r1 = r9.getContentResolver()     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L68
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            android.database.Cursor r9 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L68
            if (r9 == 0) goto L5e
            boolean r10 = r9.moveToNext()     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L5a
            if (r10 == 0) goto L53
            java.lang.String r10 = "value"
            int r10 = r9.getColumnIndex(r10)     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L5a
            java.lang.String r10 = r9.getString(r10)     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L5a
            r0 = r10
        L53:
            r9.close()     // Catch: java.lang.Throwable -> L57 java.lang.Exception -> L5a
            goto L5e
        L57:
            r10 = move-exception
            r0 = r9
            goto L62
        L5a:
            r7 = r0
            r0 = r9
            r9 = r7
            goto L69
        L5e:
            if (r9 == 0) goto L73
            goto L6e
        L61:
            r10 = move-exception
        L62:
            if (r0 == 0) goto L67
            r0.close()
        L67:
            throw r10
        L68:
            r9 = r0
        L69:
            if (r0 == 0) goto L72
            r7 = r0
            r0 = r9
            r9 = r7
        L6e:
            r9.close()
            goto L73
        L72:
            r0 = r9
        L73:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: XI.CA.XI.XI.XI(int, java.lang.String):java.lang.String");
    }
}
