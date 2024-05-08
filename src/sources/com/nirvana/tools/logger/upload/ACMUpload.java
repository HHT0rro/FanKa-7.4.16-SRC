package com.nirvana.tools.logger.upload;

import com.nirvana.tools.logger.model.ACMRecord;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface ACMUpload<T extends ACMRecord> {
    boolean upload(List<T> list);
}
