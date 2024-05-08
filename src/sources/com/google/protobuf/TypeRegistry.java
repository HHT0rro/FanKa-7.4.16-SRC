package com.google.protobuf;

import com.google.protobuf.Descriptors;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class TypeRegistry {
    private static final Logger logger = Logger.getLogger(TypeRegistry.class.getName());
    private final Map<String, Descriptors.Descriptor> types;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class Builder {
        private final Set<String> files;
        private Map<String, Descriptors.Descriptor> types;

        private void addFile(Descriptors.FileDescriptor fileDescriptor) {
            if (this.files.add(fileDescriptor.getFullName())) {
                Iterator<Descriptors.FileDescriptor> iterator2 = fileDescriptor.getDependencies().iterator2();
                while (iterator2.hasNext()) {
                    addFile(iterator2.next());
                }
                Iterator<Descriptors.Descriptor> iterator22 = fileDescriptor.getMessageTypes().iterator2();
                while (iterator22.hasNext()) {
                    addMessage(iterator22.next());
                }
            }
        }

        private void addMessage(Descriptors.Descriptor descriptor) {
            Iterator<Descriptors.Descriptor> iterator2 = descriptor.getNestedTypes().iterator2();
            while (iterator2.hasNext()) {
                addMessage(iterator2.next());
            }
            if (this.types.containsKey(descriptor.getFullName())) {
                TypeRegistry.logger.warning("Type " + descriptor.getFullName() + " is added multiple times.");
                return;
            }
            this.types.put(descriptor.getFullName(), descriptor);
        }

        public Builder add(Descriptors.Descriptor descriptor) {
            if (this.types != null) {
                addFile(descriptor.getFile());
                return this;
            }
            throw new IllegalStateException("A TypeRegistry.Builder can only be used once.");
        }

        public TypeRegistry build() {
            TypeRegistry typeRegistry = new TypeRegistry(this.types);
            this.types = null;
            return typeRegistry;
        }

        private Builder() {
            this.files = new HashSet();
            this.types = new HashMap();
        }

        public Builder add(Iterable<Descriptors.Descriptor> iterable) {
            if (this.types != null) {
                Iterator<Descriptors.Descriptor> iterator2 = iterable.iterator2();
                while (iterator2.hasNext()) {
                    addFile(iterator2.next().getFile());
                }
                return this;
            }
            throw new IllegalStateException("A TypeRegistry.Builder can only be used once.");
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class EmptyTypeRegistryHolder {
        private static final TypeRegistry EMPTY = new TypeRegistry(Collections.emptyMap());

        private EmptyTypeRegistryHolder() {
        }
    }

    public TypeRegistry(Map<String, Descriptors.Descriptor> map) {
        this.types = map;
    }

    public static TypeRegistry getEmptyTypeRegistry() {
        return EmptyTypeRegistryHolder.EMPTY;
    }

    private static String getTypeName(String str) throws InvalidProtocolBufferException {
        String[] split = str.split("/");
        if (split.length != 1) {
            return split[split.length - 1];
        }
        throw new InvalidProtocolBufferException("Invalid type url found: " + str);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Descriptors.Descriptor find(String str) {
        return this.types.get(str);
    }

    public final Descriptors.Descriptor getDescriptorForTypeUrl(String str) throws InvalidProtocolBufferException {
        return find(getTypeName(str));
    }
}
