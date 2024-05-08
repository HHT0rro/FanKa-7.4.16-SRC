package com.google.protobuf;

import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage.Builder;
import com.google.protobuf.MessageOrBuilder;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class RepeatedFieldBuilder<MType extends GeneratedMessage, BType extends GeneratedMessage.Builder, IType extends MessageOrBuilder> implements GeneratedMessage.BuilderParent {
    private List<SingleFieldBuilder<MType, BType, IType>> builders;
    private BuilderExternalList<MType, BType, IType> externalBuilderList;
    private MessageExternalList<MType, BType, IType> externalMessageList;
    private MessageOrBuilderExternalList<MType, BType, IType> externalMessageOrBuilderList;
    private boolean isClean;
    private boolean isMessagesListMutable;
    private List<MType> messages;
    private GeneratedMessage.BuilderParent parent;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class BuilderExternalList<MType extends GeneratedMessage, BType extends GeneratedMessage.Builder, IType extends MessageOrBuilder> extends AbstractList<BType> implements RandomAccess {
        public RepeatedFieldBuilder<MType, BType, IType> builder;

        public BuilderExternalList(RepeatedFieldBuilder<MType, BType, IType> repeatedFieldBuilder) {
            this.builder = repeatedFieldBuilder;
        }

        public void incrementModCount() {
            this.modCount++;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.builder.getCount();
        }

        @Override // java.util.AbstractList, java.util.List
        public BType get(int i10) {
            return this.builder.getBuilder(i10);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class MessageExternalList<MType extends GeneratedMessage, BType extends GeneratedMessage.Builder, IType extends MessageOrBuilder> extends AbstractList<MType> implements RandomAccess {
        public RepeatedFieldBuilder<MType, BType, IType> builder;

        public MessageExternalList(RepeatedFieldBuilder<MType, BType, IType> repeatedFieldBuilder) {
            this.builder = repeatedFieldBuilder;
        }

        public void incrementModCount() {
            this.modCount++;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.builder.getCount();
        }

        @Override // java.util.AbstractList, java.util.List
        public MType get(int i10) {
            return this.builder.getMessage(i10);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class MessageOrBuilderExternalList<MType extends GeneratedMessage, BType extends GeneratedMessage.Builder, IType extends MessageOrBuilder> extends AbstractList<IType> implements RandomAccess {
        public RepeatedFieldBuilder<MType, BType, IType> builder;

        public MessageOrBuilderExternalList(RepeatedFieldBuilder<MType, BType, IType> repeatedFieldBuilder) {
            this.builder = repeatedFieldBuilder;
        }

        public void incrementModCount() {
            this.modCount++;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.builder.getCount();
        }

        @Override // java.util.AbstractList, java.util.List
        public IType get(int i10) {
            return this.builder.getMessageOrBuilder(i10);
        }
    }

    public RepeatedFieldBuilder(List<MType> list, boolean z10, GeneratedMessage.BuilderParent builderParent, boolean z11) {
        this.messages = list;
        this.isMessagesListMutable = z10;
        this.parent = builderParent;
        this.isClean = z11;
    }

    private void ensureBuilders() {
        if (this.builders == null) {
            this.builders = new ArrayList(this.messages.size());
            for (int i10 = 0; i10 < this.messages.size(); i10++) {
                this.builders.add(null);
            }
        }
    }

    private void ensureMutableMessageList() {
        if (this.isMessagesListMutable) {
            return;
        }
        this.messages = new ArrayList(this.messages);
        this.isMessagesListMutable = true;
    }

    private void incrementModCounts() {
        MessageExternalList<MType, BType, IType> messageExternalList = this.externalMessageList;
        if (messageExternalList != null) {
            messageExternalList.incrementModCount();
        }
        BuilderExternalList<MType, BType, IType> builderExternalList = this.externalBuilderList;
        if (builderExternalList != null) {
            builderExternalList.incrementModCount();
        }
        MessageOrBuilderExternalList<MType, BType, IType> messageOrBuilderExternalList = this.externalMessageOrBuilderList;
        if (messageOrBuilderExternalList != null) {
            messageOrBuilderExternalList.incrementModCount();
        }
    }

    private void onChanged() {
        GeneratedMessage.BuilderParent builderParent;
        if (!this.isClean || (builderParent = this.parent) == null) {
            return;
        }
        builderParent.markDirty();
        this.isClean = false;
    }

    public RepeatedFieldBuilder<MType, BType, IType> addAllMessages(Iterable<? extends MType> iterable) {
        Iterator<? extends MType> iterator2 = iterable.iterator2();
        while (iterator2.hasNext()) {
            Internal.checkNotNull(iterator2.next());
        }
        int i10 = -1;
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            if (collection.isEmpty()) {
                return this;
            }
            i10 = collection.size();
        }
        ensureMutableMessageList();
        if (i10 >= 0) {
            List<MType> list = this.messages;
            if (list instanceof ArrayList) {
                ((ArrayList) list).ensureCapacity(list.size() + i10);
            }
        }
        Iterator<? extends MType> iterator22 = iterable.iterator2();
        while (iterator22.hasNext()) {
            addMessage(iterator22.next());
        }
        onChanged();
        incrementModCounts();
        return this;
    }

    public BType addBuilder(MType mtype) {
        ensureMutableMessageList();
        ensureBuilders();
        SingleFieldBuilder<MType, BType, IType> singleFieldBuilder = new SingleFieldBuilder<>(mtype, this, this.isClean);
        this.messages.add(null);
        this.builders.add(singleFieldBuilder);
        onChanged();
        incrementModCounts();
        return singleFieldBuilder.getBuilder();
    }

    public RepeatedFieldBuilder<MType, BType, IType> addMessage(MType mtype) {
        Internal.checkNotNull(mtype);
        ensureMutableMessageList();
        this.messages.add(mtype);
        List<SingleFieldBuilder<MType, BType, IType>> list = this.builders;
        if (list != null) {
            list.add(null);
        }
        onChanged();
        incrementModCounts();
        return this;
    }

    public List<MType> build() {
        boolean z10;
        this.isClean = true;
        boolean z11 = this.isMessagesListMutable;
        if (!z11 && this.builders == null) {
            return this.messages;
        }
        if (!z11) {
            int i10 = 0;
            while (true) {
                if (i10 >= this.messages.size()) {
                    z10 = true;
                    break;
                }
                MType mtype = this.messages.get(i10);
                SingleFieldBuilder<MType, BType, IType> singleFieldBuilder = this.builders.get(i10);
                if (singleFieldBuilder != null && singleFieldBuilder.build() != mtype) {
                    z10 = false;
                    break;
                }
                i10++;
            }
            if (z10) {
                return this.messages;
            }
        }
        ensureMutableMessageList();
        for (int i11 = 0; i11 < this.messages.size(); i11++) {
            this.messages.set(i11, getMessage(i11, true));
        }
        List<MType> unmodifiableList = Collections.unmodifiableList(this.messages);
        this.messages = unmodifiableList;
        this.isMessagesListMutable = false;
        return unmodifiableList;
    }

    public void clear() {
        this.messages = Collections.emptyList();
        this.isMessagesListMutable = false;
        List<SingleFieldBuilder<MType, BType, IType>> list = this.builders;
        if (list != null) {
            for (SingleFieldBuilder<MType, BType, IType> singleFieldBuilder : list) {
                if (singleFieldBuilder != null) {
                    singleFieldBuilder.dispose();
                }
            }
            this.builders = null;
        }
        onChanged();
        incrementModCounts();
    }

    public void dispose() {
        this.parent = null;
    }

    public BType getBuilder(int i10) {
        ensureBuilders();
        SingleFieldBuilder<MType, BType, IType> singleFieldBuilder = this.builders.get(i10);
        if (singleFieldBuilder == null) {
            SingleFieldBuilder<MType, BType, IType> singleFieldBuilder2 = new SingleFieldBuilder<>(this.messages.get(i10), this, this.isClean);
            this.builders.set(i10, singleFieldBuilder2);
            singleFieldBuilder = singleFieldBuilder2;
        }
        return singleFieldBuilder.getBuilder();
    }

    public List<BType> getBuilderList() {
        if (this.externalBuilderList == null) {
            this.externalBuilderList = new BuilderExternalList<>(this);
        }
        return this.externalBuilderList;
    }

    public int getCount() {
        return this.messages.size();
    }

    public MType getMessage(int i10) {
        return getMessage(i10, false);
    }

    public List<MType> getMessageList() {
        if (this.externalMessageList == null) {
            this.externalMessageList = new MessageExternalList<>(this);
        }
        return this.externalMessageList;
    }

    public IType getMessageOrBuilder(int i10) {
        List<SingleFieldBuilder<MType, BType, IType>> list = this.builders;
        if (list == null) {
            return this.messages.get(i10);
        }
        SingleFieldBuilder<MType, BType, IType> singleFieldBuilder = list.get(i10);
        if (singleFieldBuilder == null) {
            return this.messages.get(i10);
        }
        return singleFieldBuilder.getMessageOrBuilder();
    }

    public List<IType> getMessageOrBuilderList() {
        if (this.externalMessageOrBuilderList == null) {
            this.externalMessageOrBuilderList = new MessageOrBuilderExternalList<>(this);
        }
        return this.externalMessageOrBuilderList;
    }

    public boolean isEmpty() {
        return this.messages.isEmpty();
    }

    @Override // com.google.protobuf.AbstractMessage.BuilderParent
    public void markDirty() {
        onChanged();
    }

    public void remove(int i10) {
        SingleFieldBuilder<MType, BType, IType> remove;
        ensureMutableMessageList();
        this.messages.remove(i10);
        List<SingleFieldBuilder<MType, BType, IType>> list = this.builders;
        if (list != null && (remove = list.remove(i10)) != null) {
            remove.dispose();
        }
        onChanged();
        incrementModCounts();
    }

    public RepeatedFieldBuilder<MType, BType, IType> setMessage(int i10, MType mtype) {
        SingleFieldBuilder<MType, BType, IType> singleFieldBuilder;
        Internal.checkNotNull(mtype);
        ensureMutableMessageList();
        this.messages.set(i10, mtype);
        List<SingleFieldBuilder<MType, BType, IType>> list = this.builders;
        if (list != null && (singleFieldBuilder = list.set(i10, null)) != null) {
            singleFieldBuilder.dispose();
        }
        onChanged();
        incrementModCounts();
        return this;
    }

    private MType getMessage(int i10, boolean z10) {
        List<SingleFieldBuilder<MType, BType, IType>> list = this.builders;
        if (list == null) {
            return this.messages.get(i10);
        }
        SingleFieldBuilder<MType, BType, IType> singleFieldBuilder = list.get(i10);
        if (singleFieldBuilder == null) {
            return this.messages.get(i10);
        }
        return z10 ? singleFieldBuilder.build() : singleFieldBuilder.getMessage();
    }

    public RepeatedFieldBuilder<MType, BType, IType> addMessage(int i10, MType mtype) {
        Internal.checkNotNull(mtype);
        ensureMutableMessageList();
        this.messages.add(i10, mtype);
        List<SingleFieldBuilder<MType, BType, IType>> list = this.builders;
        if (list != null) {
            list.add(i10, null);
        }
        onChanged();
        incrementModCounts();
        return this;
    }

    public BType addBuilder(int i10, MType mtype) {
        ensureMutableMessageList();
        ensureBuilders();
        SingleFieldBuilder<MType, BType, IType> singleFieldBuilder = new SingleFieldBuilder<>(mtype, this, this.isClean);
        this.messages.add(i10, null);
        this.builders.add(i10, singleFieldBuilder);
        onChanged();
        incrementModCounts();
        return singleFieldBuilder.getBuilder();
    }
}