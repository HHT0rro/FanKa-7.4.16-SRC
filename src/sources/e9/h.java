package e9;

import com.huawei.flexiblelayout.FLContext;
import com.huawei.flexiblelayout.FLayoutDelegate;
import com.huawei.flexiblelayout.card.FLCell;
import com.huawei.flexiblelayout.data.FLCardData;
import com.huawei.flexiblelayout.data.primitive.FLArray;
import com.huawei.flexiblelayout.data.primitive.FLImmutableMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class h implements FLayoutDelegate {
    @Override // com.huawei.flexiblelayout.FLayoutDelegate
    public void onCardBind(FLContext fLContext, FLCell fLCell, FLCardData fLCardData) {
        if (fLCardData != null && fLCardData.getData() != null) {
            FLArray optArray = fLCardData.getData().optArray("list");
            if (optArray == null) {
                e.f48945d.e("FlexCardFLayoutDelegate", "list is null");
                return;
            }
            for (int i10 = 0; i10 < optArray.size(); i10++) {
                FLImmutableMap optMap = optArray.optMap(i10);
                String optString = optMap.optString("detailId");
                String optString2 = optMap.optString("packageName");
                e.f48945d.d("FlexCardFLayoutDelegate", "packageName is: " + optString2 + ", detailId: " + optString);
            }
            return;
        }
        e.f48945d.e("FlexCardFLayoutDelegate", "flCardData is null");
    }
}
