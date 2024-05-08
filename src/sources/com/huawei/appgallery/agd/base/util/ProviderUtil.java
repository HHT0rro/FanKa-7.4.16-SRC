package com.huawei.appgallery.agd.base.util;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ProviderUtil {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public enum Item {
        HOME_COUNTRY(1, null, "homecountry"),
        PROTOCOL(7, null, "isAgree"),
        UD_ID(12, "9", "udid"),
        SIGNATURE(13, null, "signature");

        private final String columnName;

        /* renamed from: id, reason: collision with root package name */
        private final int f27336id;
        private final String selection;

        Item(int i10, String str, String str2) {
            this.f27336id = i10;
            this.selection = str;
            this.columnName = str2;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Item{id=" + this.f27336id + ", selection='" + this.selection + "', columnName='" + this.columnName + "'}";
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x00a8, code lost:
    
        if (r3 == null) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(@androidx.annotation.NonNull android.content.Context r13, @androidx.annotation.NonNull com.huawei.appgallery.agd.base.util.ProviderUtil.Item r14) {
        /*
            java.lang.String r0 = " failed, reason:"
            java.lang.String r1 = "ProviderUtil"
            java.lang.String r2 = ""
            r3 = 0
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63 java.lang.SecurityException -> L87
            r4.<init>()     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63 java.lang.SecurityException -> L87
            java.lang.String r5 = "content://"
            r4.append(r5)     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63 java.lang.SecurityException -> L87
            java.lang.String r5 = com.huawei.appgallery.coreservice.api.CoreServiceApi.getAppGalleryPkg(r13)     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63 java.lang.SecurityException -> L87
            r4.append(r5)     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63 java.lang.SecurityException -> L87
            java.lang.String r5 = ".commondata/item"
            r4.append(r5)     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63 java.lang.SecurityException -> L87
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63 java.lang.SecurityException -> L87
            android.net.Uri r4 = android.net.Uri.parse(r4)     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63 java.lang.SecurityException -> L87
            int r5 = com.huawei.appgallery.agd.base.util.ProviderUtil.Item.access$000(r14)     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63 java.lang.SecurityException -> L87
            long r5 = (long) r5     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63 java.lang.SecurityException -> L87
            android.net.Uri r8 = android.content.ContentUris.withAppendedId(r4, r5)     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63 java.lang.SecurityException -> L87
            android.content.ContentResolver r7 = r13.getContentResolver()     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63 java.lang.SecurityException -> L87
            r9 = 0
            java.lang.String r10 = com.huawei.appgallery.agd.base.util.ProviderUtil.Item.access$100(r14)     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63 java.lang.SecurityException -> L87
            r11 = 0
            r12 = 0
            android.database.Cursor r3 = r7.query(r8, r9, r10, r11, r12)     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63 java.lang.SecurityException -> L87
            if (r3 == 0) goto L52
            boolean r13 = r3.moveToNext()     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63 java.lang.SecurityException -> L87
            if (r13 == 0) goto L52
            java.lang.String r13 = com.huawei.appgallery.agd.base.util.ProviderUtil.Item.access$200(r14)     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63 java.lang.SecurityException -> L87
            int r13 = r3.getColumnIndex(r13)     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63 java.lang.SecurityException -> L87
            java.lang.String r13 = r3.getString(r13)     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63 java.lang.SecurityException -> L87
            r2 = r13
        L52:
            if (r3 != 0) goto L5b
            j9.a r13 = j9.a.f50348d     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63 java.lang.SecurityException -> L87
            java.lang.String r4 = "ProviderUtil# cursor is null!"
            r13.e(r1, r4)     // Catch: java.lang.Throwable -> L61 java.lang.Exception -> L63 java.lang.SecurityException -> L87
        L5b:
            if (r3 == 0) goto Lab
        L5d:
            r3.close()
            goto Lab
        L61:
            r13 = move-exception
            goto Lac
        L63:
            r13 = move-exception
            j9.a r4 = j9.a.f50348d     // Catch: java.lang.Throwable -> L61
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L61
            r5.<init>()     // Catch: java.lang.Throwable -> L61
            java.lang.String r6 = "ProviderUtil# Exception get item "
            r5.append(r6)     // Catch: java.lang.Throwable -> L61
            r5.append(r14)     // Catch: java.lang.Throwable -> L61
            r5.append(r0)     // Catch: java.lang.Throwable -> L61
            java.lang.String r13 = r13.getMessage()     // Catch: java.lang.Throwable -> L61
            r5.append(r13)     // Catch: java.lang.Throwable -> L61
            java.lang.String r13 = r5.toString()     // Catch: java.lang.Throwable -> L61
            r4.e(r1, r13)     // Catch: java.lang.Throwable -> L61
            if (r3 == 0) goto Lab
            goto L5d
        L87:
            r13 = move-exception
            j9.a r4 = j9.a.f50348d     // Catch: java.lang.Throwable -> L61
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L61
            r5.<init>()     // Catch: java.lang.Throwable -> L61
            java.lang.String r6 = "ProviderUtil# SecurityException get item "
            r5.append(r6)     // Catch: java.lang.Throwable -> L61
            r5.append(r14)     // Catch: java.lang.Throwable -> L61
            r5.append(r0)     // Catch: java.lang.Throwable -> L61
            java.lang.String r13 = r13.getMessage()     // Catch: java.lang.Throwable -> L61
            r5.append(r13)     // Catch: java.lang.Throwable -> L61
            java.lang.String r13 = r5.toString()     // Catch: java.lang.Throwable -> L61
            r4.e(r1, r13)     // Catch: java.lang.Throwable -> L61
            if (r3 == 0) goto Lab
            goto L5d
        Lab:
            return r2
        Lac:
            if (r3 == 0) goto Lb1
            r3.close()
        Lb1:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.appgallery.agd.base.util.ProviderUtil.a(android.content.Context, com.huawei.appgallery.agd.base.util.ProviderUtil$Item):java.lang.String");
    }
}
