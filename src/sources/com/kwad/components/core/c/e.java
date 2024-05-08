package com.kwad.components.core.c;

import android.content.ContentValues;
import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.huawei.quickcard.base.Attributes;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class e implements i {
    private static volatile e IY;

    @Nullable
    private String IZ;
    private int Ja = 0;
    private int Jb = 1;
    private long Jc = 1800;
    private boolean Jd = false;

    private e() {
    }

    public static synchronized List<e> a(Cursor cursor) {
        synchronized (e.class) {
            if (cursor == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            while (cursor.moveToNext()) {
                try {
                    arrayList.add(b(cursor));
                } catch (Exception e2) {
                    com.kwad.sdk.core.e.c.printStackTrace(e2);
                }
            }
            return arrayList;
        }
    }

    public static e aj(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return null;
        }
        long j10 = adTemplate.posId;
        AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(adTemplate);
        e eVar = new e(j10);
        AdInfo.AdBaseInfo adBaseInfo = dQ.adBaseInfo;
        eVar.Ja = adBaseInfo.adCacheStrategy;
        eVar.Jc = adBaseInfo.adCacheSecond;
        eVar.Jb = adBaseInfo.adCacheSize;
        eVar.Jd = adBaseInfo.adCacheSwitch == 1;
        return eVar;
    }

    private static synchronized e b(Cursor cursor) {
        e eVar;
        synchronized (e.class) {
            String string = cursor.getString(cursor.getColumnIndex("posId"));
            int i10 = cursor.getInt(cursor.getColumnIndex("strategyCode"));
            int i11 = cursor.getInt(cursor.getColumnIndex("cacheSize"));
            long j10 = cursor.getLong(cursor.getColumnIndex("cacheSecond"));
            boolean z10 = true;
            if (cursor.getInt(cursor.getColumnIndex(Attributes.Style.ENABLE)) != 1) {
                z10 = false;
            }
            eVar = new e();
            eVar.IZ = string;
            eVar.Ja = i10;
            eVar.Jb = i11;
            eVar.Jc = j10;
            eVar.Jd = z10;
        }
        return eVar;
    }

    @NonNull
    private static e mz() {
        if (IY == null) {
            synchronized (e.class) {
                if (IY == null) {
                    IY = new e();
                }
            }
        }
        return IY;
    }

    @NonNull
    @WorkerThread
    public static e s(long j10) {
        e X;
        return (a.mu() == null || (X = a.mu().X(String.valueOf(j10))) == null) ? mz() : X;
    }

    public final boolean isDefault() {
        return equals(mz());
    }

    public final boolean isEnable() {
        return this.Jd;
    }

    public final int mA() {
        return this.Ja;
    }

    public final int mB() {
        return this.Jb;
    }

    public final long mC() {
        return this.Jc;
    }

    @Override // com.kwad.components.core.c.i
    public final ContentValues mD() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("posId", this.IZ);
        contentValues.put("strategyCode", Integer.valueOf(this.Ja));
        contentValues.put("cacheSize", Integer.valueOf(this.Jb));
        contentValues.put("cacheSecond", Long.valueOf(this.Jc));
        contentValues.put(Attributes.Style.ENABLE, Integer.valueOf(this.Jd ? 1 : 0));
        return contentValues;
    }

    private e(long j10) {
        this.IZ = String.valueOf(j10);
    }
}
