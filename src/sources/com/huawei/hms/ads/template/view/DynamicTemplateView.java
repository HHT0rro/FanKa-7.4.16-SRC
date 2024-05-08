package com.huawei.hms.ads.template.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.huawei.hms.ads.annotation.GlobalApi;
import com.huawei.hms.ads.template.R;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

@GlobalApi
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class DynamicTemplateView extends DTFrameLayout {
    private DTRelativeLayout B;
    private DTTextView C;
    private List<View> Code;
    private DTAppDownloadButton I;
    private DTNativeVideoView V;
    private static final int S = com.huawei.hms.ads.template.util.a.Code(-608895943);
    private static final int F = com.huawei.hms.ads.template.util.a.Code(-1152660984);

    @GlobalApi
    public DynamicTemplateView(Context context) {
        super(context);
        this.Code = new ArrayList();
    }

    @GlobalApi
    public DynamicTemplateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Code = new ArrayList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void Code(ViewGroup viewGroup, JSONObject jSONObject) {
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = viewGroup.getChildAt(i10);
            if (childAt.getTag(R.id.hiad_pps_view_store_click_event) instanceof String) {
                this.Code.add(childAt);
            }
            if (childAt instanceof DTNativeVideoView) {
                this.V = (DTNativeVideoView) childAt;
            }
            if (childAt instanceof DTAppDownloadButton) {
                this.I = (DTAppDownloadButton) childAt;
            }
            if (childAt instanceof a) {
                ((a) childAt).Code(jSONObject);
            }
            if ((childAt instanceof DTRelativeLayout) && childAt.getId() == S) {
                this.B = (DTRelativeLayout) childAt;
            }
            if ((childAt instanceof DTTextView) && childAt.getId() == F) {
                this.C = (DTTextView) childAt;
            }
            if (childAt instanceof ViewGroup) {
                Code((ViewGroup) childAt, jSONObject);
            }
        }
    }

    @Override // com.huawei.hms.ads.template.view.DTFrameLayout, com.huawei.hms.ads.template.view.a
    public void Code(JSONObject jSONObject) {
        Code(this, jSONObject);
    }

    public DTTextView getAdSignTextView() {
        return this.C;
    }

    public List<View> getClickableViews() {
        return this.Code;
    }

    public DTAppDownloadButton getNativeButton() {
        return this.I;
    }

    public DTNativeVideoView getNativeVideoView() {
        return this.V;
    }

    public DTRelativeLayout getRelativeLayout() {
        return this.B;
    }
}
