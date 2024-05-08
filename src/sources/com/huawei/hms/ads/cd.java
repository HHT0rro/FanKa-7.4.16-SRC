package com.huawei.hms.ads;

import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class cd {
    private ArrayList<cq> V = new ArrayList<>();
    private Map<String, cx> I = new HashMap();

    public cd(View view) {
        Code(view);
    }

    private void Code(View view) {
        Code((cx) new ck(view));
        Code((cx) new cg(view));
        Code((cx) new de(view));
        Code((cx) new cw(view));
        Code((cq) new ch(view));
        Code((cq) new cs(view));
    }

    public void Code(AttributeSet attributeSet) {
        if (attributeSet == null) {
            gl.I("AttrHandlerHarbor", "parse - attrs is null");
            return;
        }
        int attributeCount = attributeSet.getAttributeCount();
        for (int i10 = 0; i10 < attributeCount; i10++) {
            String attributeName = attributeSet.getAttributeName(i10);
            String attributeValue = attributeSet.getAttributeValue(i10);
            cx cxVar = this.I.get(attributeName);
            if (cxVar != null) {
                try {
                    cxVar.Code(attributeName, attributeValue);
                } catch (Exception e2) {
                    gl.I("AttrHandlerHarbor", "parse exception: " + e2.getClass().getSimpleName());
                }
            }
        }
        int size = this.V.size();
        for (int i11 = 0; i11 < size; i11++) {
            try {
                this.V.get(i11).Code(attributeSet);
            } catch (Exception e10) {
                gl.I("AttrHandlerHarbor", "parse exception: " + e10.getClass().getSimpleName());
            }
        }
    }

    public void Code(cj cjVar) {
        if (cjVar == null) {
            return;
        }
        if (cjVar instanceof cx) {
            Code((cx) cjVar);
        } else if (cjVar instanceof cq) {
            Code((cq) cjVar);
        }
    }

    public void Code(cq cqVar) {
        if (cqVar == null) {
            return;
        }
        this.V.add(cqVar);
    }

    public void Code(cx cxVar) {
        if (cxVar == null) {
            return;
        }
        this.I.put(cxVar.Code(), cxVar);
    }

    public void Code(JSONObject jSONObject) {
        Iterator<cx> iterator2 = this.I.values().iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().Code(jSONObject);
        }
        int size = this.V.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.V.get(i10).Code(jSONObject);
        }
    }
}
