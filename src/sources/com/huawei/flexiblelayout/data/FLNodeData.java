package com.huawei.flexiblelayout.data;

import com.huawei.flexiblelayout.css.CSSLink;
import com.huawei.flexiblelayout.css.CSSRule;
import com.huawei.flexiblelayout.parser.csslink.CSSLinkManager;
import com.huawei.flexiblelayout.services.task.TaskHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class FLNodeData extends FLCardData {

    /* renamed from: j, reason: collision with root package name */
    private final List<FLCardData> f28068j;

    /* renamed from: k, reason: collision with root package name */
    private String f28069k;

    /* renamed from: l, reason: collision with root package name */
    private String f28070l;

    /* renamed from: m, reason: collision with root package name */
    private TaskHandler f28071m;

    public FLNodeData(String str) {
        super(str);
        this.f28068j = new ArrayList();
        this.f28069k = null;
        this.f28070l = null;
    }

    public void a(TaskHandler taskHandler) {
        this.f28071m = taskHandler;
    }

    public void addChild(FLCardData fLCardData) {
        fLCardData.a(this);
        this.f28068j.add(fLCardData);
    }

    public void b(FLCardData fLCardData) {
        this.f28068j.remove(fLCardData);
    }

    public List<FLCardData> c() {
        return this.f28068j;
    }

    public FLCardData getChild(int i10) {
        return this.f28068j.get(i10);
    }

    @Override // com.huawei.flexiblelayout.data.FLCardData
    public String getReuseIdentifier() {
        String str = this.f28069k;
        if (str != null) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder(getType());
        if (this.f28070l != null) {
            sb2.append("@");
            sb2.append(this.f28070l);
        }
        CSSRule cssRule = getCssRule();
        if (cssRule != null) {
            sb2.append("@");
            sb2.append(cssRule.hashCode());
            CSSLink parent = cssRule.getParent();
            if (parent == null) {
                parent = CSSLinkManager.getInstance().findCssLink(this);
            }
            if (parent != null) {
                sb2.append("@");
                sb2.append(parent.getName());
            }
        }
        sb2.append("@");
        for (int i10 = 0; i10 < getSize(); i10++) {
            FLCardData child = getChild(i10);
            sb2.append(child.getReuseIdentifier());
            sb2.append("@");
            CSSRule cssRule2 = child.getCssRule();
            if (cssRule2 != null) {
                sb2.append(cssRule2.hashCode());
                sb2.append("-");
            }
        }
        String sb3 = sb2.toString();
        this.f28069k = sb3;
        return sb3;
    }

    public int getSize() {
        return this.f28068j.size();
    }

    public TaskHandler getTaskHandler() {
        return this.f28071m;
    }

    public int indexOf(FLCardData fLCardData) {
        return this.f28068j.indexOf(fLCardData);
    }

    @Override // com.huawei.flexiblelayout.data.FLCardData
    public boolean isVisible() {
        if (!super.isVisible()) {
            return false;
        }
        Iterator<FLCardData> iterator2 = this.f28068j.iterator2();
        while (iterator2.hasNext()) {
            if (iterator2.next().isVisible()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.huawei.flexiblelayout.data.FLCardData
    public void a() {
        super.a();
        Iterator<FLCardData> iterator2 = this.f28068j.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().a();
        }
    }

    @Override // com.huawei.flexiblelayout.data.FLCardData
    public void b(String str) {
        this.f28070l = str;
        this.f28069k = null;
    }

    @Override // com.huawei.flexiblelayout.data.FLCardData
    public boolean b() {
        if (super.b()) {
            return true;
        }
        Iterator<FLCardData> iterator2 = this.f28068j.iterator2();
        while (iterator2.hasNext()) {
            if (iterator2.next().b()) {
                return true;
            }
        }
        return false;
    }
}
