package com.huawei.flexiblelayout.card;

import androidx.annotation.NonNull;
import com.huawei.flexiblelayout.data.FLCardData;
import com.huawei.flexiblelayout.data.FLDataGroup;
import com.huawei.flexiblelayout.data.FLNodeData;
import com.huawei.flexiblelayout.parser.FLDataParser;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface FLProvider {
    @NonNull
    List<? extends FLCardData> supply(FLDataParser fLDataParser, FLDataGroup fLDataGroup, FLNodeData fLNodeData);
}
