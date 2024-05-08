package kotlin.collections.builders;

import java.io.Externalizable;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.l0;
import kotlin.collections.r;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: ListBuilder.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class SerializedCollection implements Externalizable {

    @NotNull
    public static final a Companion = new a(null);
    private static final long serialVersionUID = 0;
    public static final int tagList = 0;
    public static final int tagSet = 1;

    @NotNull
    private Collection<?> collection;
    private final int tag;

    /* compiled from: ListBuilder.kt */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public SerializedCollection(@NotNull Collection<?> collection, int i10) {
        s.i(collection, "collection");
        this.collection = collection;
        this.tag = i10;
    }

    private final Object readResolve() {
        return this.collection;
    }

    @Override // java.io.Externalizable
    public void readExternal(@NotNull ObjectInput input) {
        Collection<?> a10;
        s.i(input, "input");
        byte readByte = input.readByte();
        int i10 = readByte & 1;
        if ((readByte & (-2)) == 0) {
            int readInt = input.readInt();
            if (readInt >= 0) {
                int i11 = 0;
                if (i10 == 0) {
                    List d10 = r.d(readInt);
                    while (i11 < readInt) {
                        d10.add(input.readObject());
                        i11++;
                    }
                    a10 = r.a(d10);
                } else if (i10 == 1) {
                    Set b4 = l0.b(readInt);
                    while (i11 < readInt) {
                        b4.add(input.readObject());
                        i11++;
                    }
                    a10 = l0.a(b4);
                } else {
                    throw new InvalidObjectException("Unsupported collection type tag: " + i10 + '.');
                }
                this.collection = a10;
                return;
            }
            throw new InvalidObjectException("Illegal size value: " + readInt + '.');
        }
        throw new InvalidObjectException("Unsupported flags value: " + ((int) readByte) + '.');
    }

    @Override // java.io.Externalizable
    public void writeExternal(@NotNull ObjectOutput output) {
        s.i(output, "output");
        output.writeByte(this.tag);
        output.writeInt(this.collection.size());
        Iterator<?> iterator2 = this.collection.iterator2();
        while (iterator2.hasNext()) {
            output.writeObject(iterator2.next());
        }
    }

    public SerializedCollection() {
        this(kotlin.collections.s.j(), 0);
    }
}
