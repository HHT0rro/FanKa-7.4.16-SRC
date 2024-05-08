package com.huawei.quickcard.views.list;

import androidx.annotation.NonNull;
import com.huawei.quickcard.base.Attributes;
import com.huawei.quickcard.base.utils.Utils;
import com.huawei.quickcard.framework.parser.ParserHelper;
import com.huawei.quickcard.framework.processor.PropertyProcessor;
import com.huawei.quickcard.framework.value.QuickCardValue;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ListAttrProcessor implements PropertyProcessor<QRecyclerView> {

    /* renamed from: a, reason: collision with root package name */
    private static final int f34564a = 1;

    /* renamed from: b, reason: collision with root package name */
    private static final int f34565b = -1;

    @NonNull
    private QuickCardValue a(Object obj, int i10) {
        if (obj instanceof Number) {
            return new QuickCardValue.NumberValue(Integer.valueOf(((Number) obj).intValue()));
        }
        if ((obj instanceof String) && Utils.isIntNum((String) obj)) {
            return new QuickCardValue.NumberValue(Integer.valueOf(Attributes.getInt(obj, i10)));
        }
        return new QuickCardValue.NumberValue(Integer.valueOf(i10));
    }

    @Override // com.huawei.quickcard.framework.processor.PropertyProcessor
    public boolean isImmediate() {
        return true;
    }

    @Override // com.huawei.quickcard.framework.processor.PropertyProcessor
    public /* synthetic */ boolean needRefresh() {
        return com.huawei.quickcard.framework.processor.b.b(this);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.huawei.quickcard.framework.parser.ValueParser
    @NonNull
    public QuickCardValue parseToValue(String str, Object obj) {
        char c4;
        str.hashCode();
        switch (str.hashCode()) {
            case -1955263676:
                if (str.equals(Attributes.Style.LIST_SNAP_GRAVITY)) {
                    c4 = 0;
                    break;
                }
                c4 = 65535;
                break;
            case -1552865608:
                if (str.equals(Attributes.Style.TABMODE)) {
                    c4 = 1;
                    break;
                }
                c4 = 65535;
                break;
            case -1383205240:
                if (str.equals(Attributes.Style.LIST_BOUNCE)) {
                    c4 = 2;
                    break;
                }
                c4 = 65535;
                break;
            case -1230449443:
                if (str.equals(Attributes.Style.LIST_SNAP_OFFSET)) {
                    c4 = 3;
                    break;
                }
                c4 = 65535;
                break;
            case -975171706:
                if (str.equals("flexDirection")) {
                    c4 = 4;
                    break;
                }
                c4 = 65535;
                break;
            case 100346066:
                if (str.equals(Attributes.Style.INDEX)) {
                    c4 = 5;
                    break;
                }
                c4 = 65535;
                break;
            case 284701805:
                if (str.equals(Attributes.Style.LIST_SNAP_MODE)) {
                    c4 = 6;
                    break;
                }
                c4 = 65535;
                break;
            case 341662084:
                if (str.equals(Attributes.Style.LIST_LAYOUT_TYPE)) {
                    c4 = 7;
                    break;
                }
                c4 = 65535;
                break;
            case 949721053:
                if (str.equals("columns")) {
                    c4 = '\b';
                    break;
                }
                c4 = 65535;
                break;
            default:
                c4 = 65535;
                break;
        }
        switch (c4) {
            case 0:
            case 6:
                return ParserHelper.parseToString(obj, null);
            case 1:
                return ParserHelper.parseToBool(obj, false);
            case 2:
                if (obj instanceof Boolean) {
                    return new QuickCardValue.BooleanValue(((Boolean) obj).booleanValue());
                }
                return new QuickCardValue.BooleanValue("true".equals(obj));
            case 3:
                return ParserHelper.parseToDP(obj, 0.0f);
            case 4:
                if (obj != null) {
                    return new QuickCardValue.StringValue(obj.toString());
                }
                return new QuickCardValue.StringValue("column");
            case 5:
                return a(obj, -1);
            case 7:
                if (obj != null && obj.equals("stagger")) {
                    return new QuickCardValue.StringValue("stagger");
                }
                return new QuickCardValue.StringValue("grid");
            case '\b':
                return a(obj, 1);
            default:
                return QuickCardValue.EMPTY;
        }
    }

    @Override // com.huawei.quickcard.framework.processor.PropertyProcessor
    public void setProperty(@NonNull QRecyclerView qRecyclerView, String str, QuickCardValue quickCardValue) {
        str.hashCode();
        char c4 = 65535;
        switch (str.hashCode()) {
            case -1955263676:
                if (str.equals(Attributes.Style.LIST_SNAP_GRAVITY)) {
                    c4 = 0;
                    break;
                }
                break;
            case -1552865608:
                if (str.equals(Attributes.Style.TABMODE)) {
                    c4 = 1;
                    break;
                }
                break;
            case -1383205240:
                if (str.equals(Attributes.Style.LIST_BOUNCE)) {
                    c4 = 2;
                    break;
                }
                break;
            case -1230449443:
                if (str.equals(Attributes.Style.LIST_SNAP_OFFSET)) {
                    c4 = 3;
                    break;
                }
                break;
            case -975171706:
                if (str.equals("flexDirection")) {
                    c4 = 4;
                    break;
                }
                break;
            case 100346066:
                if (str.equals(Attributes.Style.INDEX)) {
                    c4 = 5;
                    break;
                }
                break;
            case 284701805:
                if (str.equals(Attributes.Style.LIST_SNAP_MODE)) {
                    c4 = 6;
                    break;
                }
                break;
            case 341662084:
                if (str.equals(Attributes.Style.LIST_LAYOUT_TYPE)) {
                    c4 = 7;
                    break;
                }
                break;
            case 949721053:
                if (str.equals("columns")) {
                    c4 = '\b';
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                qRecyclerView.setSnapGravity(quickCardValue.getString());
                return;
            case 1:
                qRecyclerView.setTabMode(quickCardValue.getBoolean());
                return;
            case 2:
                qRecyclerView.setEnableBounce(quickCardValue.getBoolean());
                return;
            case 3:
                if (quickCardValue != null && quickCardValue != QuickCardValue.EMPTY) {
                    qRecyclerView.setSnapOffset(quickCardValue.getDp());
                    return;
                } else {
                    qRecyclerView.setSnapOffset(0.0f);
                    return;
                }
            case 4:
                String string = quickCardValue.getString();
                if (string == null) {
                    string = "column";
                }
                qRecyclerView.setFlexDirection(string);
                return;
            case 5:
                a(quickCardValue, qRecyclerView);
                return;
            case 6:
                qRecyclerView.setSnapMode(quickCardValue.getString());
                return;
            case 7:
                String string2 = quickCardValue.getString();
                if (string2 == null) {
                    string2 = "grid";
                }
                qRecyclerView.setLayoutType(string2);
                return;
            case '\b':
                Number number = quickCardValue.getNumber();
                if (number == null) {
                    number = 1;
                }
                qRecyclerView.setColumns(number.intValue());
                return;
            default:
                return;
        }
    }

    private void a(@NonNull QuickCardValue quickCardValue, @NonNull QRecyclerView qRecyclerView) {
        int intValue;
        if (!quickCardValue.isNumber() || (intValue = quickCardValue.getNumber().intValue()) < 0) {
            return;
        }
        qRecyclerView.setInitPos(intValue);
    }
}
