package com.alibaba.fastjson.asm;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
final class Item {
    public int hashCode;
    public int index;
    public int intVal;
    public long longVal;
    public Item next;
    public String strVal1;
    public String strVal2;
    public String strVal3;
    public int type;

    public Item() {
    }

    public boolean isEqualTo(Item item) {
        int i10 = this.type;
        if (i10 != 1) {
            if (i10 != 15) {
                if (i10 == 12) {
                    return item.strVal1.equals(this.strVal1) && item.strVal2.equals(this.strVal2);
                }
                if (i10 != 13) {
                    switch (i10) {
                        case 3:
                        case 4:
                            return item.intVal == this.intVal;
                        case 5:
                        case 6:
                            break;
                        case 7:
                        case 8:
                            break;
                        default:
                            return item.strVal1.equals(this.strVal1) && item.strVal2.equals(this.strVal2) && item.strVal3.equals(this.strVal3);
                    }
                }
            }
            return item.longVal == this.longVal;
        }
        return item.strVal1.equals(this.strVal1);
    }

    public void set(int i10, String str, String str2, String str3) {
        this.type = i10;
        this.strVal1 = str;
        this.strVal2 = str2;
        this.strVal3 = str3;
        if (i10 != 1 && i10 != 7 && i10 != 8) {
            if (i10 == 12) {
                this.hashCode = (i10 + (str.hashCode() * str2.hashCode())) & Integer.MAX_VALUE;
                return;
            } else if (i10 != 13) {
                this.hashCode = (i10 + (str.hashCode() * str2.hashCode() * str3.hashCode())) & Integer.MAX_VALUE;
                return;
            }
        }
        this.hashCode = (i10 + str.hashCode()) & Integer.MAX_VALUE;
    }

    public Item(int i10, Item item) {
        this.index = i10;
        this.type = item.type;
        this.intVal = item.intVal;
        this.longVal = item.longVal;
        this.strVal1 = item.strVal1;
        this.strVal2 = item.strVal2;
        this.strVal3 = item.strVal3;
        this.hashCode = item.hashCode;
    }

    public void set(int i10) {
        this.type = 3;
        this.intVal = i10;
        this.hashCode = Integer.MAX_VALUE & (3 + i10);
    }
}
