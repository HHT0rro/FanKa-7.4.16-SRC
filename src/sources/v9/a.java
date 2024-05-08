package v9;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.appgallery.agd.common.application.ApplicationWrapper;
import com.huawei.appgallery.agd.pageframe.PageFrameLog;
import com.huawei.appgallery.agd.pageframe.api.CardConstants;
import com.huawei.appgallery.agd.pageframe.api.FLFragment;
import com.huawei.flexiblelayout.data.FLDataGroup;
import com.huawei.flexiblelayout.data.FLDataSource;
import com.huawei.flexiblelayout.data.FLNodeData;
import com.huawei.flexiblelayout.data.primitive.FLMap;
import com.huawei.flexiblelayout.parser.DataItem;
import com.huawei.flexiblelayout.parser.FLDataDelegate;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CardDataDelegateImpl.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class a implements FLDataDelegate {

    /* renamed from: a, reason: collision with root package name */
    public final FLFragment.Callback f54059a;

    public a(FLFragment.Callback callback) {
        this.f54059a = callback;
    }

    public final String a(@NonNull DataItem dataItem) {
        FLMap optMap = dataItem.getData().optMap(CardConstants.KEY_REFS_APP);
        if (optMap != null) {
            String optString = optMap.optString("detailId");
            if (!TextUtils.isEmpty(optString)) {
                PageFrameLog.LOG.i("CardDataDelegateImpl", "return refs_app detailId");
                return optString;
            }
        }
        PageFrameLog.LOG.i("CardDataDelegateImpl", "refs_app is null or refs_app detailId is empty, return node detailId");
        return dataItem.getData().optString("detailId");
    }

    @Override // com.huawei.flexiblelayout.parser.FLDataDelegate
    @Nullable
    public FLDataGroup onApplyGroup(FLDataSource fLDataSource, FLDataGroup fLDataGroup, DataItem dataItem) {
        return fLDataGroup;
    }

    @Override // com.huawei.flexiblelayout.parser.FLDataDelegate
    @Nullable
    public FLNodeData onApplyNode(FLDataGroup fLDataGroup, FLNodeData fLNodeData, DataItem dataItem) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onApplyNode, ");
        sb2.append((Object) fLNodeData);
        sb2.append(" - ");
        sb2.append(fLDataGroup.getData().optString(CardConstants.KEY_LAYOUT_ID));
        sb2.append(", ");
        sb2.append(dataItem.getData().optString("nextPage"));
        return fLNodeData;
    }

    @Override // com.huawei.flexiblelayout.parser.FLDataDelegate
    @Nullable
    public DataItem onParseGroup(@NonNull DataItem dataItem, @NonNull DataItem dataItem2) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onParseGroup, ");
        sb2.append(dataItem2.getData().optString(CardConstants.KEY_LAYOUT_ID));
        return dataItem2;
    }

    @Override // com.huawei.flexiblelayout.parser.FLDataDelegate
    @Nullable
    public DataItem onParseNode(@NonNull DataItem dataItem, @NonNull DataItem dataItem2) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onParseNode, ");
        sb2.append((Object) dataItem2);
        sb2.append(" - ");
        sb2.append(dataItem2.getData().optString(CardConstants.KEY_LAYOUT_ID));
        sb2.append(", ");
        sb2.append(dataItem2.getData().optString("nextPage"));
        String optString = (dataItem.getData() == null || dataItem.getData().isEmpty()) ? "" : dataItem.getData().optString("layoutName");
        String optString2 = dataItem.getData().optString(CardConstants.KEY_QUICK_URI);
        if (!TextUtils.isEmpty(optString2) && optString2.startsWith(CardConstants.KEY_FAST_VIEW)) {
            dataItem2.getData().put("quickCard", optString2);
            dataItem2.getData().put("layoutName", CardConstants.VALUE_QLAYOUT);
        }
        FLFragment.Callback callback = this.f54059a;
        if (callback != null) {
            callback.onParseNode(optString, dataItem2.getData());
        }
        dataItem2.getData().put("detailId", a(dataItem2));
        dataItem2.getData().put(CardConstants.KEY_LAYOUT_ID, Integer.valueOf(dataItem.getId()));
        dataItem2.getData().put(CardConstants.KEY_MEDIA_ID, ApplicationWrapper.getInstance().getContext().getPackageName());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("width", "inherit");
            jSONObject.put("height", "inherit");
            dataItem2.setStyle(jSONObject);
        } catch (JSONException unused) {
        }
        return dataItem2;
    }
}
