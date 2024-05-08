package com.nirvana.tools.logger.cache;

import android.content.Context;
import com.nirvana.tools.logger.cache.db.ACMLogDatabase;
import com.nirvana.tools.logger.executor.ReentrantSingleThreadExecutor;
import com.nirvana.tools.logger.model.ACMLoggerRecord;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class ACMLogCacheManager extends ACMCacheManager<ACMLoggerRecord, ACMLogDatabase> {
    public ACMLogCacheManager(Context context, ReentrantSingleThreadExecutor reentrantSingleThreadExecutor, String str, String str2) {
        super(new ACMLogDatabase(context, str, str2), reentrantSingleThreadExecutor);
    }

    public List<ACMLoggerRecord> getLoggerRecords(long j10, long j11, int i10, int i11, int i12) {
        return ((ACMLogDatabase) this.mDatabase).queryLog(j10, j11, i10, i11, i12);
    }
}
