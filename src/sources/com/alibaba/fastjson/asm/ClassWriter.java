package com.alibaba.fastjson.asm;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class ClassWriter {
    private int access;
    public FieldWriter firstField;
    public MethodWriter firstMethod;
    public int index;
    private int interfaceCount;
    private int[] interfaces;
    public Item[] items;
    public final Item key;
    public final Item key2;
    public final Item key3;
    public FieldWriter lastField;
    public MethodWriter lastMethod;
    private int name;
    public final ByteVector pool;
    private int superName;
    public String thisName;
    public int threshold;
    public Item[] typeTable;
    public int version;

    public ClassWriter() {
        this(0);
    }

    private Item get(Item item) {
        Item[] itemArr = this.items;
        Item item2 = itemArr[item.hashCode % itemArr.length];
        while (item2 != null && (item2.type != item.type || !item.isEqualTo(item2))) {
            item2 = item2.next;
        }
        return item2;
    }

    private Item newString(String str) {
        this.key2.set(8, str, null, null);
        Item item = get(this.key2);
        if (item != null) {
            return item;
        }
        this.pool.put12(8, newUTF8(str));
        int i10 = this.index;
        this.index = i10 + 1;
        Item item2 = new Item(i10, this.key2);
        put(item2);
        return item2;
    }

    private void put(Item item) {
        if (this.index > this.threshold) {
            int length = this.items.length;
            int i10 = (length * 2) + 1;
            Item[] itemArr = new Item[i10];
            for (int i11 = length - 1; i11 >= 0; i11--) {
                Item item2 = this.items[i11];
                while (item2 != null) {
                    int i12 = item2.hashCode % i10;
                    Item item3 = item2.next;
                    item2.next = itemArr[i12];
                    itemArr[i12] = item2;
                    item2 = item3;
                }
            }
            this.items = itemArr;
            this.threshold = (int) (i10 * 0.75d);
        }
        int i13 = item.hashCode;
        Item[] itemArr2 = this.items;
        int length2 = i13 % itemArr2.length;
        item.next = itemArr2[length2];
        itemArr2[length2] = item;
    }

    public Item newClassItem(String str) {
        this.key2.set(7, str, null, null);
        Item item = get(this.key2);
        if (item != null) {
            return item;
        }
        this.pool.put12(7, newUTF8(str));
        int i10 = this.index;
        this.index = i10 + 1;
        Item item2 = new Item(i10, this.key2);
        put(item2);
        return item2;
    }

    public Item newConstItem(Object obj) {
        if (obj instanceof Integer) {
            int intValue = ((Integer) obj).intValue();
            this.key.set(intValue);
            Item item = get(this.key);
            if (item != null) {
                return item;
            }
            this.pool.putByte(3).putInt(intValue);
            int i10 = this.index;
            this.index = i10 + 1;
            Item item2 = new Item(i10, this.key);
            put(item2);
            return item2;
        }
        if (obj instanceof String) {
            return newString((String) obj);
        }
        if (obj instanceof Type) {
            Type type = (Type) obj;
            return newClassItem(type.sort == 10 ? type.getInternalName() : type.getDescriptor());
        }
        throw new IllegalArgumentException("value " + obj);
    }

    public Item newFieldItem(String str, String str2, String str3) {
        this.key3.set(9, str, str2, str3);
        Item item = get(this.key3);
        if (item != null) {
            return item;
        }
        int i10 = newClassItem(str).index;
        this.pool.put12(9, i10).putShort(newNameTypeItem(str2, str3).index);
        int i11 = this.index;
        this.index = i11 + 1;
        Item item2 = new Item(i11, this.key3);
        put(item2);
        return item2;
    }

    public Item newMethodItem(String str, String str2, String str3, boolean z10) {
        int i10 = z10 ? 11 : 10;
        this.key3.set(i10, str, str2, str3);
        Item item = get(this.key3);
        if (item != null) {
            return item;
        }
        this.pool.put12(i10, newClassItem(str).index).putShort(newNameTypeItem(str2, str3).index);
        int i11 = this.index;
        this.index = i11 + 1;
        Item item2 = new Item(i11, this.key3);
        put(item2);
        return item2;
    }

    public Item newNameTypeItem(String str, String str2) {
        this.key2.set(12, str, str2, null);
        Item item = get(this.key2);
        if (item != null) {
            return item;
        }
        int newUTF8 = newUTF8(str);
        this.pool.put12(12, newUTF8).putShort(newUTF8(str2));
        int i10 = this.index;
        this.index = i10 + 1;
        Item item2 = new Item(i10, this.key2);
        put(item2);
        return item2;
    }

    public int newUTF8(String str) {
        this.key.set(1, str, null, null);
        Item item = get(this.key);
        if (item == null) {
            this.pool.putByte(1).putUTF8(str);
            int i10 = this.index;
            this.index = i10 + 1;
            item = new Item(i10, this.key);
            put(item);
        }
        return item.index;
    }

    public byte[] toByteArray() {
        int i10 = (this.interfaceCount * 2) + 24;
        int i11 = 0;
        for (FieldWriter fieldWriter = this.firstField; fieldWriter != null; fieldWriter = fieldWriter.next) {
            i11++;
            i10 += fieldWriter.getSize();
        }
        int i12 = 0;
        for (MethodWriter methodWriter = this.firstMethod; methodWriter != null; methodWriter = methodWriter.next) {
            i12++;
            i10 += methodWriter.getSize();
        }
        ByteVector byteVector = new ByteVector(i10 + this.pool.length);
        byteVector.putInt(-889275714).putInt(this.version);
        ByteVector putShort = byteVector.putShort(this.index);
        ByteVector byteVector2 = this.pool;
        putShort.putByteArray(byteVector2.data, 0, byteVector2.length);
        byteVector.putShort(this.access & (-393217)).putShort(this.name).putShort(this.superName);
        byteVector.putShort(this.interfaceCount);
        for (int i13 = 0; i13 < this.interfaceCount; i13++) {
            byteVector.putShort(this.interfaces[i13]);
        }
        byteVector.putShort(i11);
        for (FieldWriter fieldWriter2 = this.firstField; fieldWriter2 != null; fieldWriter2 = fieldWriter2.next) {
            fieldWriter2.put(byteVector);
        }
        byteVector.putShort(i12);
        for (MethodWriter methodWriter2 = this.firstMethod; methodWriter2 != null; methodWriter2 = methodWriter2.next) {
            methodWriter2.put(byteVector);
        }
        byteVector.putShort(0);
        return byteVector.data;
    }

    public void visit(int i10, int i11, String str, String str2, String[] strArr) {
        this.version = i10;
        this.access = i11;
        this.name = newClassItem(str).index;
        this.thisName = str;
        this.superName = str2 == null ? 0 : newClassItem(str2).index;
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        int length = strArr.length;
        this.interfaceCount = length;
        this.interfaces = new int[length];
        for (int i12 = 0; i12 < this.interfaceCount; i12++) {
            this.interfaces[i12] = newClassItem(strArr[i12]).index;
        }
    }

    private ClassWriter(int i10) {
        this.index = 1;
        this.pool = new ByteVector();
        this.items = new Item[256];
        this.threshold = (int) (r5.length * 0.75d);
        this.key = new Item();
        this.key2 = new Item();
        this.key3 = new Item();
    }
}
