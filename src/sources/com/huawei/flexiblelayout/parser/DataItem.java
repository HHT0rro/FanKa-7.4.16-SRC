package com.huawei.flexiblelayout.parser;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.huawei.flexiblelayout.data.FLayoutSpec;
import com.huawei.flexiblelayout.data.primitive.FLMap;
import com.huawei.flexiblelayout.layoutstrategy.GroupLayoutStrategy;
import com.huawei.flexiblelayout.parser.csslink.LinkProvider;
import com.huawei.flexiblelayout.parser.directive.StyleDirective;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class DataItem {

    /* renamed from: j, reason: collision with root package name */
    private static final int f28282j = 0;

    /* renamed from: k, reason: collision with root package name */
    private static final int f28283k = 1;

    /* renamed from: l, reason: collision with root package name */
    private static final int f28284l = 2;

    /* renamed from: m, reason: collision with root package name */
    private static final int f28285m = 3;

    /* renamed from: n, reason: collision with root package name */
    private static final int f28286n = 4;

    /* renamed from: o, reason: collision with root package name */
    private static final String f28287o = "__GroupLayoutStrategy__";

    /* renamed from: p, reason: collision with root package name */
    private static final String f28288p = "__LinkProvider__";

    /* renamed from: a, reason: collision with root package name */
    private final int f28289a;

    /* renamed from: b, reason: collision with root package name */
    private final List<DataItem> f28290b;

    /* renamed from: c, reason: collision with root package name */
    private final int f28291c;

    /* renamed from: d, reason: collision with root package name */
    private String f28292d;

    /* renamed from: e, reason: collision with root package name */
    private FLMap f28293e;

    /* renamed from: f, reason: collision with root package name */
    private Object f28294f;

    /* renamed from: g, reason: collision with root package name */
    private Map<String, Object> f28295g;

    /* renamed from: h, reason: collision with root package name */
    private DataItem f28296h;

    /* renamed from: i, reason: collision with root package name */
    private DataItem f28297i;

    private DataItem(int i10, int i11, String str) {
        this.f28290b = new ArrayList();
        this.f28289a = i10;
        this.f28291c = i11;
        this.f28292d = str;
    }

    public static StyleDirective a(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (!str.isEmpty()) {
                return new StyleDirective(str);
            }
        }
        if (obj instanceof JSONObject) {
            return new StyleDirective((JSONObject) obj);
        }
        return null;
    }

    public static DataItem cardIt(String str) {
        return new DataItem(3, str);
    }

    public static DataItem comboIt(String str) {
        return new DataItem(4, str);
    }

    public static DataItem groupIt(int i10) {
        return new DataItem(1, i10, "__group__");
    }

    public static DataItem nodeIt(String str) {
        return new DataItem(2, str);
    }

    public static DataItem rootIt() {
        return new DataItem(0, "__root__");
    }

    public DataItem addChild(DataItem dataItem) {
        this.f28290b.add(dataItem);
        dataItem.f28296h = this;
        int i10 = this.f28289a;
        if (i10 == 1) {
            dataItem.f28297i = this;
        } else if (i10 > 1) {
            dataItem.f28297i = this.f28297i;
        }
        return this;
    }

    public FLayoutSpec.FCardSpec cardSpec() {
        if (isCard()) {
            return FLayoutSpec.card(this.f28292d).data(this.f28293e).directive(a(this.f28294f));
        }
        throw new IllegalStateException("mItemType: expected CARD, mType: " + this.f28292d + ".");
    }

    public void clear() {
        this.f28290b.clear();
    }

    public FLayoutSpec.FNodeSpec comboSpec() {
        if (isCombo()) {
            return FLayoutSpec.node(this.f28292d);
        }
        throw new IllegalStateException("mItemType: expected COMBO, mType: " + this.f28292d + ".");
    }

    public DataItem getChildById(int i10) {
        for (DataItem dataItem : this.f28290b) {
            if (dataItem.getId() == i10) {
                return dataItem;
            }
        }
        return null;
    }

    @NonNull
    public List<DataItem> getChildList() {
        return this.f28290b;
    }

    public FLMap getData() {
        return this.f28293e;
    }

    public <T> T getExt(String str, Class<T> cls) {
        Map<String, Object> map = this.f28295g;
        if (map == null) {
            return null;
        }
        T t2 = (T) map.get(str);
        if (cls.isInstance(t2)) {
            return t2;
        }
        return null;
    }

    public DataItem getGroup() {
        return this.f28297i;
    }

    public GroupLayoutStrategy getGroupLayoutStrategy() {
        return (GroupLayoutStrategy) getExt(f28287o, GroupLayoutStrategy.class);
    }

    public int getId() {
        return this.f28291c;
    }

    public LinkProvider getLinkProvider() {
        return (LinkProvider) getExt(f28288p, LinkProvider.class);
    }

    public DataItem getParent() {
        return this.f28296h;
    }

    public Object getStyle() {
        return this.f28294f;
    }

    public String getType() {
        return this.f28292d;
    }

    public boolean isCard() {
        return this.f28289a == 3;
    }

    public boolean isCombo() {
        return this.f28289a == 4;
    }

    public boolean isGroup() {
        return this.f28289a == 1;
    }

    public boolean isNode() {
        return this.f28289a == 2;
    }

    public FLayoutSpec.FNodeSpec nodeSpec() {
        if (isNode()) {
            if (TextUtils.isEmpty(this.f28292d)) {
                return FLayoutSpec.node();
            }
            return FLayoutSpec.node(this.f28292d).directive(a(this.f28294f));
        }
        throw new IllegalStateException("mItemType: expected NODE, mType: " + this.f28292d + ".");
    }

    public DataItem setData(FLMap fLMap) {
        this.f28293e = fLMap;
        return this;
    }

    public DataItem setExt(String str, Object obj) {
        if (this.f28295g == null) {
            this.f28295g = new HashMap();
        }
        this.f28295g.put(str, obj);
        return this;
    }

    public void setGroupLayoutStrategy(GroupLayoutStrategy groupLayoutStrategy) {
        setExt(f28287o, groupLayoutStrategy);
    }

    public void setLinkProvider(LinkProvider linkProvider) {
        setExt(f28288p, linkProvider);
    }

    public DataItem setStyle(Object obj) {
        this.f28294f = obj;
        return this;
    }

    public DataItem setType(String str) {
        this.f28292d = str;
        return this;
    }

    @NonNull
    public String toString() {
        return "mItemType=" + this.f28289a + ", mId=" + this.f28291c + ", mType=" + this.f28292d + ", mChildList.size=" + this.f28290b.size();
    }

    private DataItem(int i10, String str) {
        this(i10, 0, str);
    }
}
