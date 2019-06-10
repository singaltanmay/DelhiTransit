public final class GtfsRealtime {
    private GtfsRealtime() {
    }

    public static void registerAllExtensions(
            com.google.protobuf.ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(
            com.google.protobuf.ExtensionRegistry registry) {
        registerAllExtensions(
                (com.google.protobuf.ExtensionRegistryLite) registry);
    }

    public interface FeedMessageOrBuilder extends
            // @@protoc_insertion_point(interface_extends:transit_realtime.FeedMessage)
            com.google.protobuf.GeneratedMessageV3.
                    ExtendableMessageOrBuilder<FeedMessage> {

        /**
         * <pre>
         * Metadata about this feed and feed message.
         * </pre>
         *
         * <code>required .transit_realtime.FeedHeader header = 1;</code>
         */
        boolean hasHeader();

        /**
         * <pre>
         * Metadata about this feed and feed message.
         * </pre>
         *
         * <code>required .transit_realtime.FeedHeader header = 1;</code>
         */
        GtfsRealtime.FeedHeader getHeader();

        /**
         * <pre>
         * Metadata about this feed and feed message.
         * </pre>
         *
         * <code>required .transit_realtime.FeedHeader header = 1;</code>
         */
        GtfsRealtime.FeedHeaderOrBuilder getHeaderOrBuilder();

        /**
         * <pre>
         * Contents of the feed.
         * </pre>
         *
         * <code>repeated .transit_realtime.FeedEntity entity = 2;</code>
         */
        java.util.List<GtfsRealtime.FeedEntity>
        getEntityList();

        /**
         * <pre>
         * Contents of the feed.
         * </pre>
         *
         * <code>repeated .transit_realtime.FeedEntity entity = 2;</code>
         */
        GtfsRealtime.FeedEntity getEntity(int index);

        /**
         * <pre>
         * Contents of the feed.
         * </pre>
         *
         * <code>repeated .transit_realtime.FeedEntity entity = 2;</code>
         */
        int getEntityCount();

        /**
         * <pre>
         * Contents of the feed.
         * </pre>
         *
         * <code>repeated .transit_realtime.FeedEntity entity = 2;</code>
         */
        java.util.List<? extends GtfsRealtime.FeedEntityOrBuilder>
        getEntityOrBuilderList();

        /**
         * <pre>
         * Contents of the feed.
         * </pre>
         *
         * <code>repeated .transit_realtime.FeedEntity entity = 2;</code>
         */
        GtfsRealtime.FeedEntityOrBuilder getEntityOrBuilder(
                int index);
    }

    /**
     * <pre>
     * The contents of a feed message.
     * A feed is a continuous stream of feed messages. Each message in the stream is
     * obtained as a response to an appropriate HTTP GET request.
     * A realtime feed is always defined with relation to an existing GTFS feed.
     * All the entity ids are resolved with respect to the GTFS feed.
     * Note that "required" and "optional" as stated in this file refer to Protocol
     * Buffer cardinality, not semantic cardinality.  See reference.md at
     * https://github.com/google/transit/tree/master/gtfs-realtime for field
     * semantic cardinality.
     * </pre>
     * <p>
     * Protobuf type {@code transit_realtime.FeedMessage}
     */
    public static final class FeedMessage extends
            com.google.protobuf.GeneratedMessageV3.ExtendableMessage<
                    FeedMessage> implements
            // @@protoc_insertion_point(message_implements:transit_realtime.FeedMessage)
            FeedMessageOrBuilder {
        private static final long serialVersionUID = 0L;

        // Use FeedMessage.newBuilder() to construct.
        private FeedMessage(com.google.protobuf.GeneratedMessageV3.ExtendableBuilder<GtfsRealtime.FeedMessage, ?> builder) {
            super(builder);
        }

        private FeedMessage() {
            entity_ = java.util.Collections.emptyList();
        }

        @java.lang.Override
        @SuppressWarnings({"unused"})
        protected java.lang.Object newInstance(
                UnusedPrivateParameter unused) {
            return new FeedMessage();
        }

        @java.lang.Override
        public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
            return this.unknownFields;
        }

        private FeedMessage(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            if (extensionRegistry == null) {
                throw new java.lang.NullPointerException();
            }
            int mutable_bitField0_ = 0;
            com.google.protobuf.UnknownFieldSet.Builder unknownFields =
                    com.google.protobuf.UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        case 10: {
                            GtfsRealtime.FeedHeader.Builder subBuilder = null;
                            if (((bitField0_ & 0x00000001) != 0)) {
                                subBuilder = header_.toBuilder();
                            }
                            header_ = input.readMessage(GtfsRealtime.FeedHeader.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(header_);
                                header_ = subBuilder.buildPartial();
                            }
                            bitField0_ |= 0x00000001;
                            break;
                        }
                        case 18: {
                            if (!((mutable_bitField0_ & 0x00000002) != 0)) {
                                entity_ = new java.util.ArrayList<GtfsRealtime.FeedEntity>();
                                mutable_bitField0_ |= 0x00000002;
                            }
                            entity_.add(
                                    input.readMessage(GtfsRealtime.FeedEntity.PARSER, extensionRegistry));
                            break;
                        }
                        default: {
                            if (!parseUnknownField(
                                    input, unknownFields, extensionRegistry, tag)) {
                                done = true;
                            }
                            break;
                        }
                    }
                }
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (java.io.IOException e) {
                throw new com.google.protobuf.InvalidProtocolBufferException(
                        e).setUnfinishedMessage(this);
            } finally {
                if (((mutable_bitField0_ & 0x00000002) != 0)) {
                    entity_ = java.util.Collections.unmodifiableList(entity_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return GtfsRealtime.internal_static_transit_realtime_FeedMessage_descriptor;
        }

        @java.lang.Override
        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return GtfsRealtime.internal_static_transit_realtime_FeedMessage_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            GtfsRealtime.FeedMessage.class, GtfsRealtime.FeedMessage.Builder.class);
        }

        private int bitField0_;
        public static final int HEADER_FIELD_NUMBER = 1;
        private GtfsRealtime.FeedHeader header_;

        /**
         * <pre>
         * Metadata about this feed and feed message.
         * </pre>
         *
         * <code>required .transit_realtime.FeedHeader header = 1;</code>
         */
        public boolean hasHeader() {
            return ((bitField0_ & 0x00000001) != 0);
        }

        /**
         * <pre>
         * Metadata about this feed and feed message.
         * </pre>
         *
         * <code>required .transit_realtime.FeedHeader header = 1;</code>
         */
        public GtfsRealtime.FeedHeader getHeader() {
            return header_ == null ? GtfsRealtime.FeedHeader.getDefaultInstance() : header_;
        }

        /**
         * <pre>
         * Metadata about this feed and feed message.
         * </pre>
         *
         * <code>required .transit_realtime.FeedHeader header = 1;</code>
         */
        public GtfsRealtime.FeedHeaderOrBuilder getHeaderOrBuilder() {
            return header_ == null ? GtfsRealtime.FeedHeader.getDefaultInstance() : header_;
        }

        public static final int ENTITY_FIELD_NUMBER = 2;
        private java.util.List<GtfsRealtime.FeedEntity> entity_;

        /**
         * <pre>
         * Contents of the feed.
         * </pre>
         *
         * <code>repeated .transit_realtime.FeedEntity entity = 2;</code>
         */
        public java.util.List<GtfsRealtime.FeedEntity> getEntityList() {
            return entity_;
        }

        /**
         * <pre>
         * Contents of the feed.
         * </pre>
         *
         * <code>repeated .transit_realtime.FeedEntity entity = 2;</code>
         */
        public java.util.List<? extends GtfsRealtime.FeedEntityOrBuilder>
        getEntityOrBuilderList() {
            return entity_;
        }

        /**
         * <pre>
         * Contents of the feed.
         * </pre>
         *
         * <code>repeated .transit_realtime.FeedEntity entity = 2;</code>
         */
        public int getEntityCount() {
            return entity_.size();
        }

        /**
         * <pre>
         * Contents of the feed.
         * </pre>
         *
         * <code>repeated .transit_realtime.FeedEntity entity = 2;</code>
         */
        public GtfsRealtime.FeedEntity getEntity(int index) {
            return entity_.get(index);
        }

        /**
         * <pre>
         * Contents of the feed.
         * </pre>
         *
         * <code>repeated .transit_realtime.FeedEntity entity = 2;</code>
         */
        public GtfsRealtime.FeedEntityOrBuilder getEntityOrBuilder(
                int index) {
            return entity_.get(index);
        }

        private byte memoizedIsInitialized = -1;

        @java.lang.Override
        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            if (!hasHeader()) {
                memoizedIsInitialized = 0;
                return false;
            }
            if (!getHeader().isInitialized()) {
                memoizedIsInitialized = 0;
                return false;
            }
            for (int i = 0; i < getEntityCount(); i++) {
                if (!getEntity(i).isInitialized()) {
                    memoizedIsInitialized = 0;
                    return false;
                }
            }
            if (!extensionsAreInitialized()) {
                memoizedIsInitialized = 0;
                return false;
            }
            memoizedIsInitialized = 1;
            return true;
        }

        @java.lang.Override
        public void writeTo(com.google.protobuf.CodedOutputStream output)
                throws java.io.IOException {
            com.google.protobuf.GeneratedMessageV3
                    .ExtendableMessage<GtfsRealtime.FeedMessage>.ExtensionWriter
                    extensionWriter = newExtensionWriter();
            if (((bitField0_ & 0x00000001) != 0)) {
                output.writeMessage(1, getHeader());
            }
            for (int i = 0; i < entity_.size(); i++) {
                output.writeMessage(2, entity_.get(i));
            }
            extensionWriter.writeUntil(2000, output);
            unknownFields.writeTo(output);
        }

        @java.lang.Override
        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            if (((bitField0_ & 0x00000001) != 0)) {
                size += com.google.protobuf.CodedOutputStream
                        .computeMessageSize(1, getHeader());
            }
            for (int i = 0; i < entity_.size(); i++) {
                size += com.google.protobuf.CodedOutputStream
                        .computeMessageSize(2, entity_.get(i));
            }
            size += extensionsSerializedSize();
            size += unknownFields.getSerializedSize();
            memoizedSize = size;
            return size;
        }

        @java.lang.Override
        public boolean equals(final java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof GtfsRealtime.FeedMessage)) {
                return super.equals(obj);
            }
            GtfsRealtime.FeedMessage other = (GtfsRealtime.FeedMessage) obj;

            if (hasHeader() != other.hasHeader()) return false;
            if (hasHeader()) {
                if (!getHeader()
                        .equals(other.getHeader())) return false;
            }
            if (!getEntityList()
                    .equals(other.getEntityList())) return false;
            if (!unknownFields.equals(other.unknownFields)) return false;
            if (!getExtensionFields().equals(other.getExtensionFields()))
                return false;
            return true;
        }

        @java.lang.Override
        public int hashCode() {
            if (memoizedHashCode != 0) {
                return memoizedHashCode;
            }
            int hash = 41;
            hash = (19 * hash) + getDescriptor().hashCode();
            if (hasHeader()) {
                hash = (37 * hash) + HEADER_FIELD_NUMBER;
                hash = (53 * hash) + getHeader().hashCode();
            }
            if (getEntityCount() > 0) {
                hash = (37 * hash) + ENTITY_FIELD_NUMBER;
                hash = (53 * hash) + getEntityList().hashCode();
            }
            hash = hashFields(hash, getExtensionFields());
            hash = (29 * hash) + unknownFields.hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static GtfsRealtime.FeedMessage parseFrom(
                java.nio.ByteBuffer data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GtfsRealtime.FeedMessage parseFrom(
                java.nio.ByteBuffer data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GtfsRealtime.FeedMessage parseFrom(
                com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GtfsRealtime.FeedMessage parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GtfsRealtime.FeedMessage parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GtfsRealtime.FeedMessage parseFrom(
                byte[] data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GtfsRealtime.FeedMessage parseFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }

        public static GtfsRealtime.FeedMessage parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static GtfsRealtime.FeedMessage parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input);
        }

        public static GtfsRealtime.FeedMessage parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static GtfsRealtime.FeedMessage parseFrom(
                com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }

        public static GtfsRealtime.FeedMessage parseFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        @java.lang.Override
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GtfsRealtime.FeedMessage prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }

        @java.lang.Override
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE
                    ? new Builder() : new Builder().mergeFrom(this);
        }

        @java.lang.Override
        protected Builder newBuilderForType(
                com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        /**
         * <pre>
         * The contents of a feed message.
         * A feed is a continuous stream of feed messages. Each message in the stream is
         * obtained as a response to an appropriate HTTP GET request.
         * A realtime feed is always defined with relation to an existing GTFS feed.
         * All the entity ids are resolved with respect to the GTFS feed.
         * Note that "required" and "optional" as stated in this file refer to Protocol
         * Buffer cardinality, not semantic cardinality.  See reference.md at
         * https://github.com/google/transit/tree/master/gtfs-realtime for field
         * semantic cardinality.
         * </pre>
         * <p>
         * Protobuf type {@code transit_realtime.FeedMessage}
         */
        public static final class Builder extends
                com.google.protobuf.GeneratedMessageV3.ExtendableBuilder<
                        GtfsRealtime.FeedMessage, Builder> implements
                // @@protoc_insertion_point(builder_implements:transit_realtime.FeedMessage)
                GtfsRealtime.FeedMessageOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
                return GtfsRealtime.internal_static_transit_realtime_FeedMessage_descriptor;
            }

            @java.lang.Override
            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internalGetFieldAccessorTable() {
                return GtfsRealtime.internal_static_transit_realtime_FeedMessage_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                GtfsRealtime.FeedMessage.class, GtfsRealtime.FeedMessage.Builder.class);
            }

            // Construct using GtfsRealtime.FeedMessage.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(
                    com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.GeneratedMessageV3
                        .alwaysUseFieldBuilders) {
                    getHeaderFieldBuilder();
                    getEntityFieldBuilder();
                }
            }

            @java.lang.Override
            public Builder clear() {
                super.clear();
                if (headerBuilder_ == null) {
                    header_ = null;
                } else {
                    headerBuilder_.clear();
                }
                bitField0_ = (bitField0_ & ~0x00000001);
                if (entityBuilder_ == null) {
                    entity_ = java.util.Collections.emptyList();
                    bitField0_ = (bitField0_ & ~0x00000002);
                } else {
                    entityBuilder_.clear();
                }
                return this;
            }

            @java.lang.Override
            public com.google.protobuf.Descriptors.Descriptor
            getDescriptorForType() {
                return GtfsRealtime.internal_static_transit_realtime_FeedMessage_descriptor;
            }

            @java.lang.Override
            public GtfsRealtime.FeedMessage getDefaultInstanceForType() {
                return GtfsRealtime.FeedMessage.getDefaultInstance();
            }

            @java.lang.Override
            public GtfsRealtime.FeedMessage build() {
                GtfsRealtime.FeedMessage result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            @java.lang.Override
            public GtfsRealtime.FeedMessage buildPartial() {
                GtfsRealtime.FeedMessage result = new GtfsRealtime.FeedMessage(this);
                int from_bitField0_ = bitField0_;
                int to_bitField0_ = 0;
                if (((from_bitField0_ & 0x00000001) != 0)) {
                    if (headerBuilder_ == null) {
                        result.header_ = header_;
                    } else {
                        result.header_ = headerBuilder_.build();
                    }
                    to_bitField0_ |= 0x00000001;
                }
                if (entityBuilder_ == null) {
                    if (((bitField0_ & 0x00000002) != 0)) {
                        entity_ = java.util.Collections.unmodifiableList(entity_);
                        bitField0_ = (bitField0_ & ~0x00000002);
                    }
                    result.entity_ = entity_;
                } else {
                    result.entity_ = entityBuilder_.build();
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            @java.lang.Override
            public Builder clone() {
                return super.clone();
            }

            @java.lang.Override
            public Builder setField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return super.setField(field, value);
            }

            @java.lang.Override
            public Builder clearField(
                    com.google.protobuf.Descriptors.FieldDescriptor field) {
                return super.clearField(field);
            }

            @java.lang.Override
            public Builder clearOneof(
                    com.google.protobuf.Descriptors.OneofDescriptor oneof) {
                return super.clearOneof(oneof);
            }

            @java.lang.Override
            public Builder setRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    int index, java.lang.Object value) {
                return super.setRepeatedField(field, index, value);
            }

            @java.lang.Override
            public Builder addRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return super.addRepeatedField(field, value);
            }

            @java.lang.Override
            public <Type> Builder setExtension(
                    com.google.protobuf.GeneratedMessage.GeneratedExtension<
                            GtfsRealtime.FeedMessage, Type> extension,
                    Type value) {
                return super.setExtension(extension, value);
            }

            @java.lang.Override
            public <Type> Builder setExtension(
                    com.google.protobuf.GeneratedMessage.GeneratedExtension<
                            GtfsRealtime.FeedMessage, java.util.List<Type>> extension,
                    int index, Type value) {
                return super.setExtension(extension, index, value);
            }

            @java.lang.Override
            public <Type> Builder addExtension(
                    com.google.protobuf.GeneratedMessage.GeneratedExtension<
                            GtfsRealtime.FeedMessage, java.util.List<Type>> extension,
                    Type value) {
                return super.addExtension(extension, value);
            }

            @java.lang.Override
            public <Type> Builder clearExtension(
                    com.google.protobuf.GeneratedMessage.GeneratedExtension<
                            GtfsRealtime.FeedMessage, ?> extension) {
                return super.clearExtension(extension);
            }

            @java.lang.Override
            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof GtfsRealtime.FeedMessage) {
                    return mergeFrom((GtfsRealtime.FeedMessage) other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(GtfsRealtime.FeedMessage other) {
                if (other == GtfsRealtime.FeedMessage.getDefaultInstance()) return this;
                if (other.hasHeader()) {
                    mergeHeader(other.getHeader());
                }
                if (entityBuilder_ == null) {
                    if (!other.entity_.isEmpty()) {
                        if (entity_.isEmpty()) {
                            entity_ = other.entity_;
                            bitField0_ = (bitField0_ & ~0x00000002);
                        } else {
                            ensureEntityIsMutable();
                            entity_.addAll(other.entity_);
                        }
                        onChanged();
                    }
                } else {
                    if (!other.entity_.isEmpty()) {
                        if (entityBuilder_.isEmpty()) {
                            entityBuilder_.dispose();
                            entityBuilder_ = null;
                            entity_ = other.entity_;
                            bitField0_ = (bitField0_ & ~0x00000002);
                            entityBuilder_ =
                                    com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                                            getEntityFieldBuilder() : null;
                        } else {
                            entityBuilder_.addAllMessages(other.entity_);
                        }
                    }
                }
                this.mergeExtensionFields(other);
                this.mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            @java.lang.Override
            public final boolean isInitialized() {
                if (!hasHeader()) {
                    return false;
                }
                if (!getHeader().isInitialized()) {
                    return false;
                }
                for (int i = 0; i < getEntityCount(); i++) {
                    if (!getEntity(i).isInitialized()) {
                        return false;
                    }
                }
                if (!extensionsAreInitialized()) {
                    return false;
                }
                return true;
            }

            @java.lang.Override
            public Builder mergeFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                GtfsRealtime.FeedMessage parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (GtfsRealtime.FeedMessage) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private int bitField0_;

            private GtfsRealtime.FeedHeader header_;
            private com.google.protobuf.SingleFieldBuilderV3<
                    GtfsRealtime.FeedHeader, GtfsRealtime.FeedHeader.Builder, GtfsRealtime.FeedHeaderOrBuilder> headerBuilder_;

            /**
             * <pre>
             * Metadata about this feed and feed message.
             * </pre>
             *
             * <code>required .transit_realtime.FeedHeader header = 1;</code>
             */
            public boolean hasHeader() {
                return ((bitField0_ & 0x00000001) != 0);
            }

            /**
             * <pre>
             * Metadata about this feed and feed message.
             * </pre>
             *
             * <code>required .transit_realtime.FeedHeader header = 1;</code>
             */
            public GtfsRealtime.FeedHeader getHeader() {
                if (headerBuilder_ == null) {
                    return header_ == null ? GtfsRealtime.FeedHeader.getDefaultInstance() : header_;
                } else {
                    return headerBuilder_.getMessage();
                }
            }

            /**
             * <pre>
             * Metadata about this feed and feed message.
             * </pre>
             *
             * <code>required .transit_realtime.FeedHeader header = 1;</code>
             */
            public Builder setHeader(GtfsRealtime.FeedHeader value) {
                if (headerBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    header_ = value;
                    onChanged();
                } else {
                    headerBuilder_.setMessage(value);
                }
                bitField0_ |= 0x00000001;
                return this;
            }

            /**
             * <pre>
             * Metadata about this feed and feed message.
             * </pre>
             *
             * <code>required .transit_realtime.FeedHeader header = 1;</code>
             */
            public Builder setHeader(
                    GtfsRealtime.FeedHeader.Builder builderForValue) {
                if (headerBuilder_ == null) {
                    header_ = builderForValue.build();
                    onChanged();
                } else {
                    headerBuilder_.setMessage(builderForValue.build());
                }
                bitField0_ |= 0x00000001;
                return this;
            }

            /**
             * <pre>
             * Metadata about this feed and feed message.
             * </pre>
             *
             * <code>required .transit_realtime.FeedHeader header = 1;</code>
             */
            public Builder mergeHeader(GtfsRealtime.FeedHeader value) {
                if (headerBuilder_ == null) {
                    if (((bitField0_ & 0x00000001) != 0) &&
                            header_ != null &&
                            header_ != GtfsRealtime.FeedHeader.getDefaultInstance()) {
                        header_ =
                                GtfsRealtime.FeedHeader.newBuilder(header_).mergeFrom(value).buildPartial();
                    } else {
                        header_ = value;
                    }
                    onChanged();
                } else {
                    headerBuilder_.mergeFrom(value);
                }
                bitField0_ |= 0x00000001;
                return this;
            }

            /**
             * <pre>
             * Metadata about this feed and feed message.
             * </pre>
             *
             * <code>required .transit_realtime.FeedHeader header = 1;</code>
             */
            public Builder clearHeader() {
                if (headerBuilder_ == null) {
                    header_ = null;
                    onChanged();
                } else {
                    headerBuilder_.clear();
                }
                bitField0_ = (bitField0_ & ~0x00000001);
                return this;
            }

            /**
             * <pre>
             * Metadata about this feed and feed message.
             * </pre>
             *
             * <code>required .transit_realtime.FeedHeader header = 1;</code>
             */
            public GtfsRealtime.FeedHeader.Builder getHeaderBuilder() {
                bitField0_ |= 0x00000001;
                onChanged();
                return getHeaderFieldBuilder().getBuilder();
            }

            /**
             * <pre>
             * Metadata about this feed and feed message.
             * </pre>
             *
             * <code>required .transit_realtime.FeedHeader header = 1;</code>
             */
            public GtfsRealtime.FeedHeaderOrBuilder getHeaderOrBuilder() {
                if (headerBuilder_ != null) {
                    return headerBuilder_.getMessageOrBuilder();
                } else {
                    return header_ == null ?
                            GtfsRealtime.FeedHeader.getDefaultInstance() : header_;
                }
            }

            /**
             * <pre>
             * Metadata about this feed and feed message.
             * </pre>
             *
             * <code>required .transit_realtime.FeedHeader header = 1;</code>
             */
            private com.google.protobuf.SingleFieldBuilderV3<
                    GtfsRealtime.FeedHeader, GtfsRealtime.FeedHeader.Builder, GtfsRealtime.FeedHeaderOrBuilder>
            getHeaderFieldBuilder() {
                if (headerBuilder_ == null) {
                    headerBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
                            GtfsRealtime.FeedHeader, GtfsRealtime.FeedHeader.Builder, GtfsRealtime.FeedHeaderOrBuilder>(
                            getHeader(),
                            getParentForChildren(),
                            isClean());
                    header_ = null;
                }
                return headerBuilder_;
            }

            private java.util.List<GtfsRealtime.FeedEntity> entity_ =
                    java.util.Collections.emptyList();

            private void ensureEntityIsMutable() {
                if (!((bitField0_ & 0x00000002) != 0)) {
                    entity_ = new java.util.ArrayList<GtfsRealtime.FeedEntity>(entity_);
                    bitField0_ |= 0x00000002;
                }
            }

            private com.google.protobuf.RepeatedFieldBuilderV3<
                    GtfsRealtime.FeedEntity, GtfsRealtime.FeedEntity.Builder, GtfsRealtime.FeedEntityOrBuilder> entityBuilder_;

            /**
             * <pre>
             * Contents of the feed.
             * </pre>
             *
             * <code>repeated .transit_realtime.FeedEntity entity = 2;</code>
             */
            public java.util.List<GtfsRealtime.FeedEntity> getEntityList() {
                if (entityBuilder_ == null) {
                    return java.util.Collections.unmodifiableList(entity_);
                } else {
                    return entityBuilder_.getMessageList();
                }
            }

            /**
             * <pre>
             * Contents of the feed.
             * </pre>
             *
             * <code>repeated .transit_realtime.FeedEntity entity = 2;</code>
             */
            public int getEntityCount() {
                if (entityBuilder_ == null) {
                    return entity_.size();
                } else {
                    return entityBuilder_.getCount();
                }
            }

            /**
             * <pre>
             * Contents of the feed.
             * </pre>
             *
             * <code>repeated .transit_realtime.FeedEntity entity = 2;</code>
             */
            public GtfsRealtime.FeedEntity getEntity(int index) {
                if (entityBuilder_ == null) {
                    return entity_.get(index);
                } else {
                    return entityBuilder_.getMessage(index);
                }
            }

            /**
             * <pre>
             * Contents of the feed.
             * </pre>
             *
             * <code>repeated .transit_realtime.FeedEntity entity = 2;</code>
             */
            public Builder setEntity(
                    int index, GtfsRealtime.FeedEntity value) {
                if (entityBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureEntityIsMutable();
                    entity_.set(index, value);
                    onChanged();
                } else {
                    entityBuilder_.setMessage(index, value);
                }
                return this;
            }

            /**
             * <pre>
             * Contents of the feed.
             * </pre>
             *
             * <code>repeated .transit_realtime.FeedEntity entity = 2;</code>
             */
            public Builder setEntity(
                    int index, GtfsRealtime.FeedEntity.Builder builderForValue) {
                if (entityBuilder_ == null) {
                    ensureEntityIsMutable();
                    entity_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    entityBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            /**
             * <pre>
             * Contents of the feed.
             * </pre>
             *
             * <code>repeated .transit_realtime.FeedEntity entity = 2;</code>
             */
            public Builder addEntity(GtfsRealtime.FeedEntity value) {
                if (entityBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureEntityIsMutable();
                    entity_.add(value);
                    onChanged();
                } else {
                    entityBuilder_.addMessage(value);
                }
                return this;
            }

            /**
             * <pre>
             * Contents of the feed.
             * </pre>
             *
             * <code>repeated .transit_realtime.FeedEntity entity = 2;</code>
             */
            public Builder addEntity(
                    int index, GtfsRealtime.FeedEntity value) {
                if (entityBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureEntityIsMutable();
                    entity_.add(index, value);
                    onChanged();
                } else {
                    entityBuilder_.addMessage(index, value);
                }
                return this;
            }

            /**
             * <pre>
             * Contents of the feed.
             * </pre>
             *
             * <code>repeated .transit_realtime.FeedEntity entity = 2;</code>
             */
            public Builder addEntity(
                    GtfsRealtime.FeedEntity.Builder builderForValue) {
                if (entityBuilder_ == null) {
                    ensureEntityIsMutable();
                    entity_.add(builderForValue.build());
                    onChanged();
                } else {
                    entityBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            /**
             * <pre>
             * Contents of the feed.
             * </pre>
             *
             * <code>repeated .transit_realtime.FeedEntity entity = 2;</code>
             */
            public Builder addEntity(
                    int index, GtfsRealtime.FeedEntity.Builder builderForValue) {
                if (entityBuilder_ == null) {
                    ensureEntityIsMutable();
                    entity_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    entityBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            /**
             * <pre>
             * Contents of the feed.
             * </pre>
             *
             * <code>repeated .transit_realtime.FeedEntity entity = 2;</code>
             */
            public Builder addAllEntity(
                    java.lang.Iterable<? extends GtfsRealtime.FeedEntity> values) {
                if (entityBuilder_ == null) {
                    ensureEntityIsMutable();
                    com.google.protobuf.AbstractMessageLite.Builder.addAll(
                            values, entity_);
                    onChanged();
                } else {
                    entityBuilder_.addAllMessages(values);
                }
                return this;
            }

            /**
             * <pre>
             * Contents of the feed.
             * </pre>
             *
             * <code>repeated .transit_realtime.FeedEntity entity = 2;</code>
             */
            public Builder clearEntity() {
                if (entityBuilder_ == null) {
                    entity_ = java.util.Collections.emptyList();
                    bitField0_ = (bitField0_ & ~0x00000002);
                    onChanged();
                } else {
                    entityBuilder_.clear();
                }
                return this;
            }

            /**
             * <pre>
             * Contents of the feed.
             * </pre>
             *
             * <code>repeated .transit_realtime.FeedEntity entity = 2;</code>
             */
            public Builder removeEntity(int index) {
                if (entityBuilder_ == null) {
                    ensureEntityIsMutable();
                    entity_.remove(index);
                    onChanged();
                } else {
                    entityBuilder_.remove(index);
                }
                return this;
            }

            /**
             * <pre>
             * Contents of the feed.
             * </pre>
             *
             * <code>repeated .transit_realtime.FeedEntity entity = 2;</code>
             */
            public GtfsRealtime.FeedEntity.Builder getEntityBuilder(
                    int index) {
                return getEntityFieldBuilder().getBuilder(index);
            }

            /**
             * <pre>
             * Contents of the feed.
             * </pre>
             *
             * <code>repeated .transit_realtime.FeedEntity entity = 2;</code>
             */
            public GtfsRealtime.FeedEntityOrBuilder getEntityOrBuilder(
                    int index) {
                if (entityBuilder_ == null) {
                    return entity_.get(index);
                } else {
                    return entityBuilder_.getMessageOrBuilder(index);
                }
            }

            /**
             * <pre>
             * Contents of the feed.
             * </pre>
             *
             * <code>repeated .transit_realtime.FeedEntity entity = 2;</code>
             */
            public java.util.List<? extends GtfsRealtime.FeedEntityOrBuilder>
            getEntityOrBuilderList() {
                if (entityBuilder_ != null) {
                    return entityBuilder_.getMessageOrBuilderList();
                } else {
                    return java.util.Collections.unmodifiableList(entity_);
                }
            }

            /**
             * <pre>
             * Contents of the feed.
             * </pre>
             *
             * <code>repeated .transit_realtime.FeedEntity entity = 2;</code>
             */
            public GtfsRealtime.FeedEntity.Builder addEntityBuilder() {
                return getEntityFieldBuilder().addBuilder(
                        GtfsRealtime.FeedEntity.getDefaultInstance());
            }

            /**
             * <pre>
             * Contents of the feed.
             * </pre>
             *
             * <code>repeated .transit_realtime.FeedEntity entity = 2;</code>
             */
            public GtfsRealtime.FeedEntity.Builder addEntityBuilder(
                    int index) {
                return getEntityFieldBuilder().addBuilder(
                        index, GtfsRealtime.FeedEntity.getDefaultInstance());
            }

            /**
             * <pre>
             * Contents of the feed.
             * </pre>
             *
             * <code>repeated .transit_realtime.FeedEntity entity = 2;</code>
             */
            public java.util.List<GtfsRealtime.FeedEntity.Builder>
            getEntityBuilderList() {
                return getEntityFieldBuilder().getBuilderList();
            }

            private com.google.protobuf.RepeatedFieldBuilderV3<
                    GtfsRealtime.FeedEntity, GtfsRealtime.FeedEntity.Builder, GtfsRealtime.FeedEntityOrBuilder>
            getEntityFieldBuilder() {
                if (entityBuilder_ == null) {
                    entityBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
                            GtfsRealtime.FeedEntity, GtfsRealtime.FeedEntity.Builder, GtfsRealtime.FeedEntityOrBuilder>(
                            entity_,
                            ((bitField0_ & 0x00000002) != 0),
                            getParentForChildren(),
                            isClean());
                    entity_ = null;
                }
                return entityBuilder_;
            }

            @java.lang.Override
            public final Builder setUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.setUnknownFields(unknownFields);
            }

            @java.lang.Override
            public final Builder mergeUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.mergeUnknownFields(unknownFields);
            }


            // @@protoc_insertion_point(builder_scope:transit_realtime.FeedMessage)
        }

        // @@protoc_insertion_point(class_scope:transit_realtime.FeedMessage)
        private static final GtfsRealtime.FeedMessage DEFAULT_INSTANCE;

        static {
            DEFAULT_INSTANCE = new GtfsRealtime.FeedMessage();
        }

        public static GtfsRealtime.FeedMessage getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        @java.lang.Deprecated
        public static final com.google.protobuf.Parser<FeedMessage>
                PARSER = new com.google.protobuf.AbstractParser<FeedMessage>() {
            @java.lang.Override
            public FeedMessage parsePartialFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return new FeedMessage(input, extensionRegistry);
            }
        };

        public static com.google.protobuf.Parser<FeedMessage> parser() {
            return PARSER;
        }

        @java.lang.Override
        public com.google.protobuf.Parser<FeedMessage> getParserForType() {
            return PARSER;
        }

        @java.lang.Override
        public GtfsRealtime.FeedMessage getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

    }

    public interface FeedHeaderOrBuilder extends
            // @@protoc_insertion_point(interface_extends:transit_realtime.FeedHeader)
            com.google.protobuf.GeneratedMessageV3.
                    ExtendableMessageOrBuilder<FeedHeader> {

        /**
         * <pre>
         * Version of the feed specification.
         * The current version is 2.0.
         * </pre>
         *
         * <code>required string gtfs_realtime_version = 1;</code>
         */
        boolean hasGtfsRealtimeVersion();

        /**
         * <pre>
         * Version of the feed specification.
         * The current version is 2.0.
         * </pre>
         *
         * <code>required string gtfs_realtime_version = 1;</code>
         */
        java.lang.String getGtfsRealtimeVersion();

        /**
         * <pre>
         * Version of the feed specification.
         * The current version is 2.0.
         * </pre>
         *
         * <code>required string gtfs_realtime_version = 1;</code>
         */
        com.google.protobuf.ByteString
        getGtfsRealtimeVersionBytes();

        /**
         * <code>optional .transit_realtime.FeedHeader.Incrementality incrementality = 2 [default = FULL_DATASET];</code>
         */
        boolean hasIncrementality();

        /**
         * <code>optional .transit_realtime.FeedHeader.Incrementality incrementality = 2 [default = FULL_DATASET];</code>
         */
        GtfsRealtime.FeedHeader.Incrementality getIncrementality();

        /**
         * <pre>
         * This timestamp identifies the moment when the content of this feed has been
         * created (in server time). In POSIX time (i.e., number of seconds since
         * January 1st 1970 00:00:00 UTC).
         * </pre>
         *
         * <code>optional uint64 timestamp = 3;</code>
         */
        boolean hasTimestamp();

        /**
         * <pre>
         * This timestamp identifies the moment when the content of this feed has been
         * created (in server time). In POSIX time (i.e., number of seconds since
         * January 1st 1970 00:00:00 UTC).
         * </pre>
         *
         * <code>optional uint64 timestamp = 3;</code>
         */
        long getTimestamp();
    }

    /**
     * <pre>
     * Metadata about a feed, included in feed messages.
     * </pre>
     * <p>
     * Protobuf type {@code transit_realtime.FeedHeader}
     */
    public static final class FeedHeader extends
            com.google.protobuf.GeneratedMessageV3.ExtendableMessage<
                    FeedHeader> implements
            // @@protoc_insertion_point(message_implements:transit_realtime.FeedHeader)
            FeedHeaderOrBuilder {
        private static final long serialVersionUID = 0L;

        // Use FeedHeader.newBuilder() to construct.
        private FeedHeader(com.google.protobuf.GeneratedMessageV3.ExtendableBuilder<GtfsRealtime.FeedHeader, ?> builder) {
            super(builder);
        }

        private FeedHeader() {
            gtfsRealtimeVersion_ = "";
            incrementality_ = 0;
        }

        @java.lang.Override
        @SuppressWarnings({"unused"})
        protected java.lang.Object newInstance(
                UnusedPrivateParameter unused) {
            return new FeedHeader();
        }

        @java.lang.Override
        public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
            return this.unknownFields;
        }

        private FeedHeader(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            if (extensionRegistry == null) {
                throw new java.lang.NullPointerException();
            }
            int mutable_bitField0_ = 0;
            com.google.protobuf.UnknownFieldSet.Builder unknownFields =
                    com.google.protobuf.UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        case 10: {
                            com.google.protobuf.ByteString bs = input.readBytes();
                            bitField0_ |= 0x00000001;
                            gtfsRealtimeVersion_ = bs;
                            break;
                        }
                        case 16: {
                            int rawValue = input.readEnum();
                            @SuppressWarnings("deprecation")
                            GtfsRealtime.FeedHeader.Incrementality value = GtfsRealtime.FeedHeader.Incrementality.valueOf(rawValue);
                            if (value == null) {
                                unknownFields.mergeVarintField(2, rawValue);
                            } else {
                                bitField0_ |= 0x00000002;
                                incrementality_ = rawValue;
                            }
                            break;
                        }
                        case 24: {
                            bitField0_ |= 0x00000004;
                            timestamp_ = input.readUInt64();
                            break;
                        }
                        default: {
                            if (!parseUnknownField(
                                    input, unknownFields, extensionRegistry, tag)) {
                                done = true;
                            }
                            break;
                        }
                    }
                }
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (java.io.IOException e) {
                throw new com.google.protobuf.InvalidProtocolBufferException(
                        e).setUnfinishedMessage(this);
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return GtfsRealtime.internal_static_transit_realtime_FeedHeader_descriptor;
        }

        @java.lang.Override
        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return GtfsRealtime.internal_static_transit_realtime_FeedHeader_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            GtfsRealtime.FeedHeader.class, GtfsRealtime.FeedHeader.Builder.class);
        }

        /**
         * <pre>
         * Determines whether the current fetch is incremental.  Currently,
         * DIFFERENTIAL mode is unsupported and behavior is unspecified for feeds
         * that use this mode.  There are discussions on the GTFS Realtime mailing
         * list around fully specifying the behavior of DIFFERENTIAL mode and the
         * documentation will be updated when those discussions are finalized.
         * </pre>
         * <p>
         * Protobuf enum {@code transit_realtime.FeedHeader.Incrementality}
         */
        public enum Incrementality
                implements com.google.protobuf.ProtocolMessageEnum {
            /**
             * <code>FULL_DATASET = 0;</code>
             */
            FULL_DATASET(0),
            /**
             * <code>DIFFERENTIAL = 1;</code>
             */
            DIFFERENTIAL(1),
            ;

            /**
             * <code>FULL_DATASET = 0;</code>
             */
            public static final int FULL_DATASET_VALUE = 0;
            /**
             * <code>DIFFERENTIAL = 1;</code>
             */
            public static final int DIFFERENTIAL_VALUE = 1;


            public final int getNumber() {
                return value;
            }

            /**
             * @deprecated Use {@link #forNumber(int)} instead.
             */
            @java.lang.Deprecated
            public static Incrementality valueOf(int value) {
                return forNumber(value);
            }

            public static Incrementality forNumber(int value) {
                switch (value) {
                    case 0:
                        return FULL_DATASET;
                    case 1:
                        return DIFFERENTIAL;
                    default:
                        return null;
                }
            }

            public static com.google.protobuf.Internal.EnumLiteMap<Incrementality>
            internalGetValueMap() {
                return internalValueMap;
            }

            private static final com.google.protobuf.Internal.EnumLiteMap<
                    Incrementality> internalValueMap =
                    new com.google.protobuf.Internal.EnumLiteMap<Incrementality>() {
                        public Incrementality findValueByNumber(int number) {
                            return Incrementality.forNumber(number);
                        }
                    };

            public final com.google.protobuf.Descriptors.EnumValueDescriptor
            getValueDescriptor() {
                return getDescriptor().getValues().get(ordinal());
            }

            public final com.google.protobuf.Descriptors.EnumDescriptor
            getDescriptorForType() {
                return getDescriptor();
            }

            public static final com.google.protobuf.Descriptors.EnumDescriptor
            getDescriptor() {
                return GtfsRealtime.FeedHeader.getDescriptor().getEnumTypes().get(0);
            }

            private static final Incrementality[] VALUES = values();

            public static Incrementality valueOf(
                    com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
                if (desc.getType() != getDescriptor()) {
                    throw new java.lang.IllegalArgumentException(
                            "EnumValueDescriptor is not for this type.");
                }
                return VALUES[desc.getIndex()];
            }

            private final int value;

            private Incrementality(int value) {
                this.value = value;
            }

            // @@protoc_insertion_point(enum_scope:transit_realtime.FeedHeader.Incrementality)
        }

        private int bitField0_;
        public static final int GTFS_REALTIME_VERSION_FIELD_NUMBER = 1;
        private volatile java.lang.Object gtfsRealtimeVersion_;

        /**
         * <pre>
         * Version of the feed specification.
         * The current version is 2.0.
         * </pre>
         *
         * <code>required string gtfs_realtime_version = 1;</code>
         */
        public boolean hasGtfsRealtimeVersion() {
            return ((bitField0_ & 0x00000001) != 0);
        }

        /**
         * <pre>
         * Version of the feed specification.
         * The current version is 2.0.
         * </pre>
         *
         * <code>required string gtfs_realtime_version = 1;</code>
         */
        public java.lang.String getGtfsRealtimeVersion() {
            java.lang.Object ref = gtfsRealtimeVersion_;
            if (ref instanceof java.lang.String) {
                return (java.lang.String) ref;
            } else {
                com.google.protobuf.ByteString bs =
                        (com.google.protobuf.ByteString) ref;
                java.lang.String s = bs.toStringUtf8();
                if (bs.isValidUtf8()) {
                    gtfsRealtimeVersion_ = s;
                }
                return s;
            }
        }

        /**
         * <pre>
         * Version of the feed specification.
         * The current version is 2.0.
         * </pre>
         *
         * <code>required string gtfs_realtime_version = 1;</code>
         */
        public com.google.protobuf.ByteString
        getGtfsRealtimeVersionBytes() {
            java.lang.Object ref = gtfsRealtimeVersion_;
            if (ref instanceof java.lang.String) {
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8(
                                (java.lang.String) ref);
                gtfsRealtimeVersion_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        public static final int INCREMENTALITY_FIELD_NUMBER = 2;
        private int incrementality_;

        /**
         * <code>optional .transit_realtime.FeedHeader.Incrementality incrementality = 2 [default = FULL_DATASET];</code>
         */
        public boolean hasIncrementality() {
            return ((bitField0_ & 0x00000002) != 0);
        }

        /**
         * <code>optional .transit_realtime.FeedHeader.Incrementality incrementality = 2 [default = FULL_DATASET];</code>
         */
        public GtfsRealtime.FeedHeader.Incrementality getIncrementality() {
            @SuppressWarnings("deprecation")
            GtfsRealtime.FeedHeader.Incrementality result = GtfsRealtime.FeedHeader.Incrementality.valueOf(incrementality_);
            return result == null ? GtfsRealtime.FeedHeader.Incrementality.FULL_DATASET : result;
        }

        public static final int TIMESTAMP_FIELD_NUMBER = 3;
        private long timestamp_;

        /**
         * <pre>
         * This timestamp identifies the moment when the content of this feed has been
         * created (in server time). In POSIX time (i.e., number of seconds since
         * January 1st 1970 00:00:00 UTC).
         * </pre>
         *
         * <code>optional uint64 timestamp = 3;</code>
         */
        public boolean hasTimestamp() {
            return ((bitField0_ & 0x00000004) != 0);
        }

        /**
         * <pre>
         * This timestamp identifies the moment when the content of this feed has been
         * created (in server time). In POSIX time (i.e., number of seconds since
         * January 1st 1970 00:00:00 UTC).
         * </pre>
         *
         * <code>optional uint64 timestamp = 3;</code>
         */
        public long getTimestamp() {
            return timestamp_;
        }

        private byte memoizedIsInitialized = -1;

        @java.lang.Override
        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            if (!hasGtfsRealtimeVersion()) {
                memoizedIsInitialized = 0;
                return false;
            }
            if (!extensionsAreInitialized()) {
                memoizedIsInitialized = 0;
                return false;
            }
            memoizedIsInitialized = 1;
            return true;
        }

        @java.lang.Override
        public void writeTo(com.google.protobuf.CodedOutputStream output)
                throws java.io.IOException {
            com.google.protobuf.GeneratedMessageV3
                    .ExtendableMessage<GtfsRealtime.FeedHeader>.ExtensionWriter
                    extensionWriter = newExtensionWriter();
            if (((bitField0_ & 0x00000001) != 0)) {
                com.google.protobuf.GeneratedMessageV3.writeString(output, 1, gtfsRealtimeVersion_);
            }
            if (((bitField0_ & 0x00000002) != 0)) {
                output.writeEnum(2, incrementality_);
            }
            if (((bitField0_ & 0x00000004) != 0)) {
                output.writeUInt64(3, timestamp_);
            }
            extensionWriter.writeUntil(2000, output);
            unknownFields.writeTo(output);
        }

        @java.lang.Override
        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            if (((bitField0_ & 0x00000001) != 0)) {
                size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, gtfsRealtimeVersion_);
            }
            if (((bitField0_ & 0x00000002) != 0)) {
                size += com.google.protobuf.CodedOutputStream
                        .computeEnumSize(2, incrementality_);
            }
            if (((bitField0_ & 0x00000004) != 0)) {
                size += com.google.protobuf.CodedOutputStream
                        .computeUInt64Size(3, timestamp_);
            }
            size += extensionsSerializedSize();
            size += unknownFields.getSerializedSize();
            memoizedSize = size;
            return size;
        }

        @java.lang.Override
        public boolean equals(final java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof GtfsRealtime.FeedHeader)) {
                return super.equals(obj);
            }
            GtfsRealtime.FeedHeader other = (GtfsRealtime.FeedHeader) obj;

            if (hasGtfsRealtimeVersion() != other.hasGtfsRealtimeVersion()) return false;
            if (hasGtfsRealtimeVersion()) {
                if (!getGtfsRealtimeVersion()
                        .equals(other.getGtfsRealtimeVersion())) return false;
            }
            if (hasIncrementality() != other.hasIncrementality()) return false;
            if (hasIncrementality()) {
                if (incrementality_ != other.incrementality_) return false;
            }
            if (hasTimestamp() != other.hasTimestamp()) return false;
            if (hasTimestamp()) {
                if (getTimestamp()
                        != other.getTimestamp()) return false;
            }
            if (!unknownFields.equals(other.unknownFields)) return false;
            if (!getExtensionFields().equals(other.getExtensionFields()))
                return false;
            return true;
        }

        @java.lang.Override
        public int hashCode() {
            if (memoizedHashCode != 0) {
                return memoizedHashCode;
            }
            int hash = 41;
            hash = (19 * hash) + getDescriptor().hashCode();
            if (hasGtfsRealtimeVersion()) {
                hash = (37 * hash) + GTFS_REALTIME_VERSION_FIELD_NUMBER;
                hash = (53 * hash) + getGtfsRealtimeVersion().hashCode();
            }
            if (hasIncrementality()) {
                hash = (37 * hash) + INCREMENTALITY_FIELD_NUMBER;
                hash = (53 * hash) + incrementality_;
            }
            if (hasTimestamp()) {
                hash = (37 * hash) + TIMESTAMP_FIELD_NUMBER;
                hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
                        getTimestamp());
            }
            hash = hashFields(hash, getExtensionFields());
            hash = (29 * hash) + unknownFields.hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static GtfsRealtime.FeedHeader parseFrom(
                java.nio.ByteBuffer data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GtfsRealtime.FeedHeader parseFrom(
                java.nio.ByteBuffer data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GtfsRealtime.FeedHeader parseFrom(
                com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GtfsRealtime.FeedHeader parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GtfsRealtime.FeedHeader parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GtfsRealtime.FeedHeader parseFrom(
                byte[] data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GtfsRealtime.FeedHeader parseFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }

        public static GtfsRealtime.FeedHeader parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static GtfsRealtime.FeedHeader parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input);
        }

        public static GtfsRealtime.FeedHeader parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static GtfsRealtime.FeedHeader parseFrom(
                com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }

        public static GtfsRealtime.FeedHeader parseFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        @java.lang.Override
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GtfsRealtime.FeedHeader prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }

        @java.lang.Override
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE
                    ? new Builder() : new Builder().mergeFrom(this);
        }

        @java.lang.Override
        protected Builder newBuilderForType(
                com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        /**
         * <pre>
         * Metadata about a feed, included in feed messages.
         * </pre>
         * <p>
         * Protobuf type {@code transit_realtime.FeedHeader}
         */
        public static final class Builder extends
                com.google.protobuf.GeneratedMessageV3.ExtendableBuilder<
                        GtfsRealtime.FeedHeader, Builder> implements
                // @@protoc_insertion_point(builder_implements:transit_realtime.FeedHeader)
                GtfsRealtime.FeedHeaderOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
                return GtfsRealtime.internal_static_transit_realtime_FeedHeader_descriptor;
            }

            @java.lang.Override
            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internalGetFieldAccessorTable() {
                return GtfsRealtime.internal_static_transit_realtime_FeedHeader_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                GtfsRealtime.FeedHeader.class, GtfsRealtime.FeedHeader.Builder.class);
            }

            // Construct using GtfsRealtime.FeedHeader.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(
                    com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.GeneratedMessageV3
                        .alwaysUseFieldBuilders) {
                }
            }

            @java.lang.Override
            public Builder clear() {
                super.clear();
                gtfsRealtimeVersion_ = "";
                bitField0_ = (bitField0_ & ~0x00000001);
                incrementality_ = 0;
                bitField0_ = (bitField0_ & ~0x00000002);
                timestamp_ = 0L;
                bitField0_ = (bitField0_ & ~0x00000004);
                return this;
            }

            @java.lang.Override
            public com.google.protobuf.Descriptors.Descriptor
            getDescriptorForType() {
                return GtfsRealtime.internal_static_transit_realtime_FeedHeader_descriptor;
            }

            @java.lang.Override
            public GtfsRealtime.FeedHeader getDefaultInstanceForType() {
                return GtfsRealtime.FeedHeader.getDefaultInstance();
            }

            @java.lang.Override
            public GtfsRealtime.FeedHeader build() {
                GtfsRealtime.FeedHeader result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            @java.lang.Override
            public GtfsRealtime.FeedHeader buildPartial() {
                GtfsRealtime.FeedHeader result = new GtfsRealtime.FeedHeader(this);
                int from_bitField0_ = bitField0_;
                int to_bitField0_ = 0;
                if (((from_bitField0_ & 0x00000001) != 0)) {
                    to_bitField0_ |= 0x00000001;
                }
                result.gtfsRealtimeVersion_ = gtfsRealtimeVersion_;
                if (((from_bitField0_ & 0x00000002) != 0)) {
                    to_bitField0_ |= 0x00000002;
                }
                result.incrementality_ = incrementality_;
                if (((from_bitField0_ & 0x00000004) != 0)) {
                    result.timestamp_ = timestamp_;
                    to_bitField0_ |= 0x00000004;
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            @java.lang.Override
            public Builder clone() {
                return super.clone();
            }

            @java.lang.Override
            public Builder setField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return super.setField(field, value);
            }

            @java.lang.Override
            public Builder clearField(
                    com.google.protobuf.Descriptors.FieldDescriptor field) {
                return super.clearField(field);
            }

            @java.lang.Override
            public Builder clearOneof(
                    com.google.protobuf.Descriptors.OneofDescriptor oneof) {
                return super.clearOneof(oneof);
            }

            @java.lang.Override
            public Builder setRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    int index, java.lang.Object value) {
                return super.setRepeatedField(field, index, value);
            }

            @java.lang.Override
            public Builder addRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return super.addRepeatedField(field, value);
            }

            @java.lang.Override
            public <Type> Builder setExtension(
                    com.google.protobuf.GeneratedMessage.GeneratedExtension<
                            GtfsRealtime.FeedHeader, Type> extension,
                    Type value) {
                return super.setExtension(extension, value);
            }

            @java.lang.Override
            public <Type> Builder setExtension(
                    com.google.protobuf.GeneratedMessage.GeneratedExtension<
                            GtfsRealtime.FeedHeader, java.util.List<Type>> extension,
                    int index, Type value) {
                return super.setExtension(extension, index, value);
            }

            @java.lang.Override
            public <Type> Builder addExtension(
                    com.google.protobuf.GeneratedMessage.GeneratedExtension<
                            GtfsRealtime.FeedHeader, java.util.List<Type>> extension,
                    Type value) {
                return super.addExtension(extension, value);
            }

            @java.lang.Override
            public <Type> Builder clearExtension(
                    com.google.protobuf.GeneratedMessage.GeneratedExtension<
                            GtfsRealtime.FeedHeader, ?> extension) {
                return super.clearExtension(extension);
            }

            @java.lang.Override
            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof GtfsRealtime.FeedHeader) {
                    return mergeFrom((GtfsRealtime.FeedHeader) other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(GtfsRealtime.FeedHeader other) {
                if (other == GtfsRealtime.FeedHeader.getDefaultInstance()) return this;
                if (other.hasGtfsRealtimeVersion()) {
                    bitField0_ |= 0x00000001;
                    gtfsRealtimeVersion_ = other.gtfsRealtimeVersion_;
                    onChanged();
                }
                if (other.hasIncrementality()) {
                    setIncrementality(other.getIncrementality());
                }
                if (other.hasTimestamp()) {
                    setTimestamp(other.getTimestamp());
                }
                this.mergeExtensionFields(other);
                this.mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            @java.lang.Override
            public final boolean isInitialized() {
                if (!hasGtfsRealtimeVersion()) {
                    return false;
                }
                if (!extensionsAreInitialized()) {
                    return false;
                }
                return true;
            }

            @java.lang.Override
            public Builder mergeFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                GtfsRealtime.FeedHeader parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (GtfsRealtime.FeedHeader) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private int bitField0_;

            private java.lang.Object gtfsRealtimeVersion_ = "";

            /**
             * <pre>
             * Version of the feed specification.
             * The current version is 2.0.
             * </pre>
             *
             * <code>required string gtfs_realtime_version = 1;</code>
             */
            public boolean hasGtfsRealtimeVersion() {
                return ((bitField0_ & 0x00000001) != 0);
            }

            /**
             * <pre>
             * Version of the feed specification.
             * The current version is 2.0.
             * </pre>
             *
             * <code>required string gtfs_realtime_version = 1;</code>
             */
            public java.lang.String getGtfsRealtimeVersion() {
                java.lang.Object ref = gtfsRealtimeVersion_;
                if (!(ref instanceof java.lang.String)) {
                    com.google.protobuf.ByteString bs =
                            (com.google.protobuf.ByteString) ref;
                    java.lang.String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        gtfsRealtimeVersion_ = s;
                    }
                    return s;
                } else {
                    return (java.lang.String) ref;
                }
            }

            /**
             * <pre>
             * Version of the feed specification.
             * The current version is 2.0.
             * </pre>
             *
             * <code>required string gtfs_realtime_version = 1;</code>
             */
            public com.google.protobuf.ByteString
            getGtfsRealtimeVersionBytes() {
                java.lang.Object ref = gtfsRealtimeVersion_;
                if (ref instanceof String) {
                    com.google.protobuf.ByteString b =
                            com.google.protobuf.ByteString.copyFromUtf8(
                                    (java.lang.String) ref);
                    gtfsRealtimeVersion_ = b;
                    return b;
                } else {
                    return (com.google.protobuf.ByteString) ref;
                }
            }

            /**
             * <pre>
             * Version of the feed specification.
             * The current version is 2.0.
             * </pre>
             *
             * <code>required string gtfs_realtime_version = 1;</code>
             */
            public Builder setGtfsRealtimeVersion(
                    java.lang.String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000001;
                gtfsRealtimeVersion_ = value;
                onChanged();
                return this;
            }

            /**
             * <pre>
             * Version of the feed specification.
             * The current version is 2.0.
             * </pre>
             *
             * <code>required string gtfs_realtime_version = 1;</code>
             */
            public Builder clearGtfsRealtimeVersion() {
                bitField0_ = (bitField0_ & ~0x00000001);
                gtfsRealtimeVersion_ = getDefaultInstance().getGtfsRealtimeVersion();
                onChanged();
                return this;
            }

            /**
             * <pre>
             * Version of the feed specification.
             * The current version is 2.0.
             * </pre>
             *
             * <code>required string gtfs_realtime_version = 1;</code>
             */
            public Builder setGtfsRealtimeVersionBytes(
                    com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000001;
                gtfsRealtimeVersion_ = value;
                onChanged();
                return this;
            }

            private int incrementality_ = 0;

            /**
             * <code>optional .transit_realtime.FeedHeader.Incrementality incrementality = 2 [default = FULL_DATASET];</code>
             */
            public boolean hasIncrementality() {
                return ((bitField0_ & 0x00000002) != 0);
            }

            /**
             * <code>optional .transit_realtime.FeedHeader.Incrementality incrementality = 2 [default = FULL_DATASET];</code>
             */
            public GtfsRealtime.FeedHeader.Incrementality getIncrementality() {
                @SuppressWarnings("deprecation")
                GtfsRealtime.FeedHeader.Incrementality result = GtfsRealtime.FeedHeader.Incrementality.valueOf(incrementality_);
                return result == null ? GtfsRealtime.FeedHeader.Incrementality.FULL_DATASET : result;
            }

            /**
             * <code>optional .transit_realtime.FeedHeader.Incrementality incrementality = 2 [default = FULL_DATASET];</code>
             */
            public Builder setIncrementality(GtfsRealtime.FeedHeader.Incrementality value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000002;
                incrementality_ = value.getNumber();
                onChanged();
                return this;
            }

            /**
             * <code>optional .transit_realtime.FeedHeader.Incrementality incrementality = 2 [default = FULL_DATASET];</code>
             */
            public Builder clearIncrementality() {
                bitField0_ = (bitField0_ & ~0x00000002);
                incrementality_ = 0;
                onChanged();
                return this;
            }

            private long timestamp_;

            /**
             * <pre>
             * This timestamp identifies the moment when the content of this feed has been
             * created (in server time). In POSIX time (i.e., number of seconds since
             * January 1st 1970 00:00:00 UTC).
             * </pre>
             *
             * <code>optional uint64 timestamp = 3;</code>
             */
            public boolean hasTimestamp() {
                return ((bitField0_ & 0x00000004) != 0);
            }

            /**
             * <pre>
             * This timestamp identifies the moment when the content of this feed has been
             * created (in server time). In POSIX time (i.e., number of seconds since
             * January 1st 1970 00:00:00 UTC).
             * </pre>
             *
             * <code>optional uint64 timestamp = 3;</code>
             */
            public long getTimestamp() {
                return timestamp_;
            }

            /**
             * <pre>
             * This timestamp identifies the moment when the content of this feed has been
             * created (in server time). In POSIX time (i.e., number of seconds since
             * January 1st 1970 00:00:00 UTC).
             * </pre>
             *
             * <code>optional uint64 timestamp = 3;</code>
             */
            public Builder setTimestamp(long value) {
                bitField0_ |= 0x00000004;
                timestamp_ = value;
                onChanged();
                return this;
            }

            /**
             * <pre>
             * This timestamp identifies the moment when the content of this feed has been
             * created (in server time). In POSIX time (i.e., number of seconds since
             * January 1st 1970 00:00:00 UTC).
             * </pre>
             *
             * <code>optional uint64 timestamp = 3;</code>
             */
            public Builder clearTimestamp() {
                bitField0_ = (bitField0_ & ~0x00000004);
                timestamp_ = 0L;
                onChanged();
                return this;
            }

            @java.lang.Override
            public final Builder setUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.setUnknownFields(unknownFields);
            }

            @java.lang.Override
            public final Builder mergeUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.mergeUnknownFields(unknownFields);
            }


            // @@protoc_insertion_point(builder_scope:transit_realtime.FeedHeader)
        }

        // @@protoc_insertion_point(class_scope:transit_realtime.FeedHeader)
        private static final GtfsRealtime.FeedHeader DEFAULT_INSTANCE;

        static {
            DEFAULT_INSTANCE = new GtfsRealtime.FeedHeader();
        }

        public static GtfsRealtime.FeedHeader getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        @java.lang.Deprecated
        public static final com.google.protobuf.Parser<FeedHeader>
                PARSER = new com.google.protobuf.AbstractParser<FeedHeader>() {
            @java.lang.Override
            public FeedHeader parsePartialFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return new FeedHeader(input, extensionRegistry);
            }
        };

        public static com.google.protobuf.Parser<FeedHeader> parser() {
            return PARSER;
        }

        @java.lang.Override
        public com.google.protobuf.Parser<FeedHeader> getParserForType() {
            return PARSER;
        }

        @java.lang.Override
        public GtfsRealtime.FeedHeader getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

    }

    public interface FeedEntityOrBuilder extends
            // @@protoc_insertion_point(interface_extends:transit_realtime.FeedEntity)
            com.google.protobuf.GeneratedMessageV3.
                    ExtendableMessageOrBuilder<FeedEntity> {

        /**
         * <pre>
         * The ids are used only to provide incrementality support. The id should be
         * unique within a FeedMessage. Consequent FeedMessages may contain
         * FeedEntities with the same id. In case of a DIFFERENTIAL update the new
         * FeedEntity with some id will replace the old FeedEntity with the same id
         * (or delete it - see is_deleted below).
         * The actual GTFS entities (e.g. stations, routes, trips) referenced by the
         * feed must be specified by explicit selectors (see EntitySelector below for
         * more info).
         * </pre>
         *
         * <code>required string id = 1;</code>
         */
        boolean hasId();

        /**
         * <pre>
         * The ids are used only to provide incrementality support. The id should be
         * unique within a FeedMessage. Consequent FeedMessages may contain
         * FeedEntities with the same id. In case of a DIFFERENTIAL update the new
         * FeedEntity with some id will replace the old FeedEntity with the same id
         * (or delete it - see is_deleted below).
         * The actual GTFS entities (e.g. stations, routes, trips) referenced by the
         * feed must be specified by explicit selectors (see EntitySelector below for
         * more info).
         * </pre>
         *
         * <code>required string id = 1;</code>
         */
        java.lang.String getId();

        /**
         * <pre>
         * The ids are used only to provide incrementality support. The id should be
         * unique within a FeedMessage. Consequent FeedMessages may contain
         * FeedEntities with the same id. In case of a DIFFERENTIAL update the new
         * FeedEntity with some id will replace the old FeedEntity with the same id
         * (or delete it - see is_deleted below).
         * The actual GTFS entities (e.g. stations, routes, trips) referenced by the
         * feed must be specified by explicit selectors (see EntitySelector below for
         * more info).
         * </pre>
         *
         * <code>required string id = 1;</code>
         */
        com.google.protobuf.ByteString
        getIdBytes();

        /**
         * <pre>
         * Whether this entity is to be deleted. Relevant only for incremental
         * fetches.
         * </pre>
         *
         * <code>optional bool is_deleted = 2 [default = false];</code>
         */
        boolean hasIsDeleted();

        /**
         * <pre>
         * Whether this entity is to be deleted. Relevant only for incremental
         * fetches.
         * </pre>
         *
         * <code>optional bool is_deleted = 2 [default = false];</code>
         */
        boolean getIsDeleted();

        /**
         * <pre>
         * Data about the entity itself. Exactly one of the following fields must be
         * present (unless the entity is being deleted).
         * </pre>
         *
         * <code>optional .transit_realtime.TripUpdate trip_update = 3;</code>
         */
        boolean hasTripUpdate();

        /**
         * <pre>
         * Data about the entity itself. Exactly one of the following fields must be
         * present (unless the entity is being deleted).
         * </pre>
         *
         * <code>optional .transit_realtime.TripUpdate trip_update = 3;</code>
         */
        GtfsRealtime.TripUpdate getTripUpdate();

        /**
         * <pre>
         * Data about the entity itself. Exactly one of the following fields must be
         * present (unless the entity is being deleted).
         * </pre>
         *
         * <code>optional .transit_realtime.TripUpdate trip_update = 3;</code>
         */
        GtfsRealtime.TripUpdateOrBuilder getTripUpdateOrBuilder();

        /**
         * <code>optional .transit_realtime.VehiclePosition vehicle = 4;</code>
         */
        boolean hasVehicle();

        /**
         * <code>optional .transit_realtime.VehiclePosition vehicle = 4;</code>
         */
        GtfsRealtime.VehiclePosition getVehicle();

        /**
         * <code>optional .transit_realtime.VehiclePosition vehicle = 4;</code>
         */
        GtfsRealtime.VehiclePositionOrBuilder getVehicleOrBuilder();

        /**
         * <code>optional .transit_realtime.Alert alert = 5;</code>
         */
        boolean hasAlert();

        /**
         * <code>optional .transit_realtime.Alert alert = 5;</code>
         */
        GtfsRealtime.Alert getAlert();

        /**
         * <code>optional .transit_realtime.Alert alert = 5;</code>
         */
        GtfsRealtime.AlertOrBuilder getAlertOrBuilder();
    }

    /**
     * <pre>
     * A definition (or update) of an entity in the transit feed.
     * </pre>
     * <p>
     * Protobuf type {@code transit_realtime.FeedEntity}
     */
    public static final class FeedEntity extends
            com.google.protobuf.GeneratedMessageV3.ExtendableMessage<
                    FeedEntity> implements
            // @@protoc_insertion_point(message_implements:transit_realtime.FeedEntity)
            FeedEntityOrBuilder {
        private static final long serialVersionUID = 0L;

        // Use FeedEntity.newBuilder() to construct.
        private FeedEntity(com.google.protobuf.GeneratedMessageV3.ExtendableBuilder<GtfsRealtime.FeedEntity, ?> builder) {
            super(builder);
        }

        private FeedEntity() {
            id_ = "";
        }

        @java.lang.Override
        @SuppressWarnings({"unused"})
        protected java.lang.Object newInstance(
                UnusedPrivateParameter unused) {
            return new FeedEntity();
        }

        @java.lang.Override
        public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
            return this.unknownFields;
        }

        private FeedEntity(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            if (extensionRegistry == null) {
                throw new java.lang.NullPointerException();
            }
            int mutable_bitField0_ = 0;
            com.google.protobuf.UnknownFieldSet.Builder unknownFields =
                    com.google.protobuf.UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        case 10: {
                            com.google.protobuf.ByteString bs = input.readBytes();
                            bitField0_ |= 0x00000001;
                            id_ = bs;
                            break;
                        }
                        case 16: {
                            bitField0_ |= 0x00000002;
                            isDeleted_ = input.readBool();
                            break;
                        }
                        case 26: {
                            GtfsRealtime.TripUpdate.Builder subBuilder = null;
                            if (((bitField0_ & 0x00000004) != 0)) {
                                subBuilder = tripUpdate_.toBuilder();
                            }
                            tripUpdate_ = input.readMessage(GtfsRealtime.TripUpdate.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(tripUpdate_);
                                tripUpdate_ = subBuilder.buildPartial();
                            }
                            bitField0_ |= 0x00000004;
                            break;
                        }
                        case 34: {
                            GtfsRealtime.VehiclePosition.Builder subBuilder = null;
                            if (((bitField0_ & 0x00000008) != 0)) {
                                subBuilder = vehicle_.toBuilder();
                            }
                            vehicle_ = input.readMessage(GtfsRealtime.VehiclePosition.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(vehicle_);
                                vehicle_ = subBuilder.buildPartial();
                            }
                            bitField0_ |= 0x00000008;
                            break;
                        }
                        case 42: {
                            GtfsRealtime.Alert.Builder subBuilder = null;
                            if (((bitField0_ & 0x00000010) != 0)) {
                                subBuilder = alert_.toBuilder();
                            }
                            alert_ = input.readMessage(GtfsRealtime.Alert.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(alert_);
                                alert_ = subBuilder.buildPartial();
                            }
                            bitField0_ |= 0x00000010;
                            break;
                        }
                        default: {
                            if (!parseUnknownField(
                                    input, unknownFields, extensionRegistry, tag)) {
                                done = true;
                            }
                            break;
                        }
                    }
                }
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (java.io.IOException e) {
                throw new com.google.protobuf.InvalidProtocolBufferException(
                        e).setUnfinishedMessage(this);
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return GtfsRealtime.internal_static_transit_realtime_FeedEntity_descriptor;
        }

        @java.lang.Override
        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return GtfsRealtime.internal_static_transit_realtime_FeedEntity_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            GtfsRealtime.FeedEntity.class, GtfsRealtime.FeedEntity.Builder.class);
        }

        private int bitField0_;
        public static final int ID_FIELD_NUMBER = 1;
        private volatile java.lang.Object id_;

        /**
         * <pre>
         * The ids are used only to provide incrementality support. The id should be
         * unique within a FeedMessage. Consequent FeedMessages may contain
         * FeedEntities with the same id. In case of a DIFFERENTIAL update the new
         * FeedEntity with some id will replace the old FeedEntity with the same id
         * (or delete it - see is_deleted below).
         * The actual GTFS entities (e.g. stations, routes, trips) referenced by the
         * feed must be specified by explicit selectors (see EntitySelector below for
         * more info).
         * </pre>
         *
         * <code>required string id = 1;</code>
         */
        public boolean hasId() {
            return ((bitField0_ & 0x00000001) != 0);
        }

        /**
         * <pre>
         * The ids are used only to provide incrementality support. The id should be
         * unique within a FeedMessage. Consequent FeedMessages may contain
         * FeedEntities with the same id. In case of a DIFFERENTIAL update the new
         * FeedEntity with some id will replace the old FeedEntity with the same id
         * (or delete it - see is_deleted below).
         * The actual GTFS entities (e.g. stations, routes, trips) referenced by the
         * feed must be specified by explicit selectors (see EntitySelector below for
         * more info).
         * </pre>
         *
         * <code>required string id = 1;</code>
         */
        public java.lang.String getId() {
            java.lang.Object ref = id_;
            if (ref instanceof java.lang.String) {
                return (java.lang.String) ref;
            } else {
                com.google.protobuf.ByteString bs =
                        (com.google.protobuf.ByteString) ref;
                java.lang.String s = bs.toStringUtf8();
                if (bs.isValidUtf8()) {
                    id_ = s;
                }
                return s;
            }
        }

        /**
         * <pre>
         * The ids are used only to provide incrementality support. The id should be
         * unique within a FeedMessage. Consequent FeedMessages may contain
         * FeedEntities with the same id. In case of a DIFFERENTIAL update the new
         * FeedEntity with some id will replace the old FeedEntity with the same id
         * (or delete it - see is_deleted below).
         * The actual GTFS entities (e.g. stations, routes, trips) referenced by the
         * feed must be specified by explicit selectors (see EntitySelector below for
         * more info).
         * </pre>
         *
         * <code>required string id = 1;</code>
         */
        public com.google.protobuf.ByteString
        getIdBytes() {
            java.lang.Object ref = id_;
            if (ref instanceof java.lang.String) {
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8(
                                (java.lang.String) ref);
                id_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        public static final int IS_DELETED_FIELD_NUMBER = 2;
        private boolean isDeleted_;

        /**
         * <pre>
         * Whether this entity is to be deleted. Relevant only for incremental
         * fetches.
         * </pre>
         *
         * <code>optional bool is_deleted = 2 [default = false];</code>
         */
        public boolean hasIsDeleted() {
            return ((bitField0_ & 0x00000002) != 0);
        }

        /**
         * <pre>
         * Whether this entity is to be deleted. Relevant only for incremental
         * fetches.
         * </pre>
         *
         * <code>optional bool is_deleted = 2 [default = false];</code>
         */
        public boolean getIsDeleted() {
            return isDeleted_;
        }

        public static final int TRIP_UPDATE_FIELD_NUMBER = 3;
        private GtfsRealtime.TripUpdate tripUpdate_;

        /**
         * <pre>
         * Data about the entity itself. Exactly one of the following fields must be
         * present (unless the entity is being deleted).
         * </pre>
         *
         * <code>optional .transit_realtime.TripUpdate trip_update = 3;</code>
         */
        public boolean hasTripUpdate() {
            return ((bitField0_ & 0x00000004) != 0);
        }

        /**
         * <pre>
         * Data about the entity itself. Exactly one of the following fields must be
         * present (unless the entity is being deleted).
         * </pre>
         *
         * <code>optional .transit_realtime.TripUpdate trip_update = 3;</code>
         */
        public GtfsRealtime.TripUpdate getTripUpdate() {
            return tripUpdate_ == null ? GtfsRealtime.TripUpdate.getDefaultInstance() : tripUpdate_;
        }

        /**
         * <pre>
         * Data about the entity itself. Exactly one of the following fields must be
         * present (unless the entity is being deleted).
         * </pre>
         *
         * <code>optional .transit_realtime.TripUpdate trip_update = 3;</code>
         */
        public GtfsRealtime.TripUpdateOrBuilder getTripUpdateOrBuilder() {
            return tripUpdate_ == null ? GtfsRealtime.TripUpdate.getDefaultInstance() : tripUpdate_;
        }

        public static final int VEHICLE_FIELD_NUMBER = 4;
        private GtfsRealtime.VehiclePosition vehicle_;

        /**
         * <code>optional .transit_realtime.VehiclePosition vehicle = 4;</code>
         */
        public boolean hasVehicle() {
            return ((bitField0_ & 0x00000008) != 0);
        }

        /**
         * <code>optional .transit_realtime.VehiclePosition vehicle = 4;</code>
         */
        public GtfsRealtime.VehiclePosition getVehicle() {
            return vehicle_ == null ? GtfsRealtime.VehiclePosition.getDefaultInstance() : vehicle_;
        }

        /**
         * <code>optional .transit_realtime.VehiclePosition vehicle = 4;</code>
         */
        public GtfsRealtime.VehiclePositionOrBuilder getVehicleOrBuilder() {
            return vehicle_ == null ? GtfsRealtime.VehiclePosition.getDefaultInstance() : vehicle_;
        }

        public static final int ALERT_FIELD_NUMBER = 5;
        private GtfsRealtime.Alert alert_;

        /**
         * <code>optional .transit_realtime.Alert alert = 5;</code>
         */
        public boolean hasAlert() {
            return ((bitField0_ & 0x00000010) != 0);
        }

        /**
         * <code>optional .transit_realtime.Alert alert = 5;</code>
         */
        public GtfsRealtime.Alert getAlert() {
            return alert_ == null ? GtfsRealtime.Alert.getDefaultInstance() : alert_;
        }

        /**
         * <code>optional .transit_realtime.Alert alert = 5;</code>
         */
        public GtfsRealtime.AlertOrBuilder getAlertOrBuilder() {
            return alert_ == null ? GtfsRealtime.Alert.getDefaultInstance() : alert_;
        }

        private byte memoizedIsInitialized = -1;

        @java.lang.Override
        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            if (!hasId()) {
                memoizedIsInitialized = 0;
                return false;
            }
            if (hasTripUpdate()) {
                if (!getTripUpdate().isInitialized()) {
                    memoizedIsInitialized = 0;
                    return false;
                }
            }
            if (hasVehicle()) {
                if (!getVehicle().isInitialized()) {
                    memoizedIsInitialized = 0;
                    return false;
                }
            }
            if (hasAlert()) {
                if (!getAlert().isInitialized()) {
                    memoizedIsInitialized = 0;
                    return false;
                }
            }
            if (!extensionsAreInitialized()) {
                memoizedIsInitialized = 0;
                return false;
            }
            memoizedIsInitialized = 1;
            return true;
        }

        @java.lang.Override
        public void writeTo(com.google.protobuf.CodedOutputStream output)
                throws java.io.IOException {
            com.google.protobuf.GeneratedMessageV3
                    .ExtendableMessage<GtfsRealtime.FeedEntity>.ExtensionWriter
                    extensionWriter = newExtensionWriter();
            if (((bitField0_ & 0x00000001) != 0)) {
                com.google.protobuf.GeneratedMessageV3.writeString(output, 1, id_);
            }
            if (((bitField0_ & 0x00000002) != 0)) {
                output.writeBool(2, isDeleted_);
            }
            if (((bitField0_ & 0x00000004) != 0)) {
                output.writeMessage(3, getTripUpdate());
            }
            if (((bitField0_ & 0x00000008) != 0)) {
                output.writeMessage(4, getVehicle());
            }
            if (((bitField0_ & 0x00000010) != 0)) {
                output.writeMessage(5, getAlert());
            }
            extensionWriter.writeUntil(2000, output);
            unknownFields.writeTo(output);
        }

        @java.lang.Override
        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            if (((bitField0_ & 0x00000001) != 0)) {
                size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, id_);
            }
            if (((bitField0_ & 0x00000002) != 0)) {
                size += com.google.protobuf.CodedOutputStream
                        .computeBoolSize(2, isDeleted_);
            }
            if (((bitField0_ & 0x00000004) != 0)) {
                size += com.google.protobuf.CodedOutputStream
                        .computeMessageSize(3, getTripUpdate());
            }
            if (((bitField0_ & 0x00000008) != 0)) {
                size += com.google.protobuf.CodedOutputStream
                        .computeMessageSize(4, getVehicle());
            }
            if (((bitField0_ & 0x00000010) != 0)) {
                size += com.google.protobuf.CodedOutputStream
                        .computeMessageSize(5, getAlert());
            }
            size += extensionsSerializedSize();
            size += unknownFields.getSerializedSize();
            memoizedSize = size;
            return size;
        }

        @java.lang.Override
        public boolean equals(final java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof GtfsRealtime.FeedEntity)) {
                return super.equals(obj);
            }
            GtfsRealtime.FeedEntity other = (GtfsRealtime.FeedEntity) obj;

            if (hasId() != other.hasId()) return false;
            if (hasId()) {
                if (!getId()
                        .equals(other.getId())) return false;
            }
            if (hasIsDeleted() != other.hasIsDeleted()) return false;
            if (hasIsDeleted()) {
                if (getIsDeleted()
                        != other.getIsDeleted()) return false;
            }
            if (hasTripUpdate() != other.hasTripUpdate()) return false;
            if (hasTripUpdate()) {
                if (!getTripUpdate()
                        .equals(other.getTripUpdate())) return false;
            }
            if (hasVehicle() != other.hasVehicle()) return false;
            if (hasVehicle()) {
                if (!getVehicle()
                        .equals(other.getVehicle())) return false;
            }
            if (hasAlert() != other.hasAlert()) return false;
            if (hasAlert()) {
                if (!getAlert()
                        .equals(other.getAlert())) return false;
            }
            if (!unknownFields.equals(other.unknownFields)) return false;
            if (!getExtensionFields().equals(other.getExtensionFields()))
                return false;
            return true;
        }

        @java.lang.Override
        public int hashCode() {
            if (memoizedHashCode != 0) {
                return memoizedHashCode;
            }
            int hash = 41;
            hash = (19 * hash) + getDescriptor().hashCode();
            if (hasId()) {
                hash = (37 * hash) + ID_FIELD_NUMBER;
                hash = (53 * hash) + getId().hashCode();
            }
            if (hasIsDeleted()) {
                hash = (37 * hash) + IS_DELETED_FIELD_NUMBER;
                hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
                        getIsDeleted());
            }
            if (hasTripUpdate()) {
                hash = (37 * hash) + TRIP_UPDATE_FIELD_NUMBER;
                hash = (53 * hash) + getTripUpdate().hashCode();
            }
            if (hasVehicle()) {
                hash = (37 * hash) + VEHICLE_FIELD_NUMBER;
                hash = (53 * hash) + getVehicle().hashCode();
            }
            if (hasAlert()) {
                hash = (37 * hash) + ALERT_FIELD_NUMBER;
                hash = (53 * hash) + getAlert().hashCode();
            }
            hash = hashFields(hash, getExtensionFields());
            hash = (29 * hash) + unknownFields.hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static GtfsRealtime.FeedEntity parseFrom(
                java.nio.ByteBuffer data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GtfsRealtime.FeedEntity parseFrom(
                java.nio.ByteBuffer data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GtfsRealtime.FeedEntity parseFrom(
                com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GtfsRealtime.FeedEntity parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GtfsRealtime.FeedEntity parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GtfsRealtime.FeedEntity parseFrom(
                byte[] data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GtfsRealtime.FeedEntity parseFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }

        public static GtfsRealtime.FeedEntity parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static GtfsRealtime.FeedEntity parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input);
        }

        public static GtfsRealtime.FeedEntity parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static GtfsRealtime.FeedEntity parseFrom(
                com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }

        public static GtfsRealtime.FeedEntity parseFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        @java.lang.Override
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GtfsRealtime.FeedEntity prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }

        @java.lang.Override
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE
                    ? new Builder() : new Builder().mergeFrom(this);
        }

        @java.lang.Override
        protected Builder newBuilderForType(
                com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        /**
         * <pre>
         * A definition (or update) of an entity in the transit feed.
         * </pre>
         * <p>
         * Protobuf type {@code transit_realtime.FeedEntity}
         */
        public static final class Builder extends
                com.google.protobuf.GeneratedMessageV3.ExtendableBuilder<
                        GtfsRealtime.FeedEntity, Builder> implements
                // @@protoc_insertion_point(builder_implements:transit_realtime.FeedEntity)
                GtfsRealtime.FeedEntityOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
                return GtfsRealtime.internal_static_transit_realtime_FeedEntity_descriptor;
            }

            @java.lang.Override
            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internalGetFieldAccessorTable() {
                return GtfsRealtime.internal_static_transit_realtime_FeedEntity_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                GtfsRealtime.FeedEntity.class, GtfsRealtime.FeedEntity.Builder.class);
            }

            // Construct using GtfsRealtime.FeedEntity.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(
                    com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.GeneratedMessageV3
                        .alwaysUseFieldBuilders) {
                    getTripUpdateFieldBuilder();
                    getVehicleFieldBuilder();
                    getAlertFieldBuilder();
                }
            }

            @java.lang.Override
            public Builder clear() {
                super.clear();
                id_ = "";
                bitField0_ = (bitField0_ & ~0x00000001);
                isDeleted_ = false;
                bitField0_ = (bitField0_ & ~0x00000002);
                if (tripUpdateBuilder_ == null) {
                    tripUpdate_ = null;
                } else {
                    tripUpdateBuilder_.clear();
                }
                bitField0_ = (bitField0_ & ~0x00000004);
                if (vehicleBuilder_ == null) {
                    vehicle_ = null;
                } else {
                    vehicleBuilder_.clear();
                }
                bitField0_ = (bitField0_ & ~0x00000008);
                if (alertBuilder_ == null) {
                    alert_ = null;
                } else {
                    alertBuilder_.clear();
                }
                bitField0_ = (bitField0_ & ~0x00000010);
                return this;
            }

            @java.lang.Override
            public com.google.protobuf.Descriptors.Descriptor
            getDescriptorForType() {
                return GtfsRealtime.internal_static_transit_realtime_FeedEntity_descriptor;
            }

            @java.lang.Override
            public GtfsRealtime.FeedEntity getDefaultInstanceForType() {
                return GtfsRealtime.FeedEntity.getDefaultInstance();
            }

            @java.lang.Override
            public GtfsRealtime.FeedEntity build() {
                GtfsRealtime.FeedEntity result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            @java.lang.Override
            public GtfsRealtime.FeedEntity buildPartial() {
                GtfsRealtime.FeedEntity result = new GtfsRealtime.FeedEntity(this);
                int from_bitField0_ = bitField0_;
                int to_bitField0_ = 0;
                if (((from_bitField0_ & 0x00000001) != 0)) {
                    to_bitField0_ |= 0x00000001;
                }
                result.id_ = id_;
                if (((from_bitField0_ & 0x00000002) != 0)) {
                    result.isDeleted_ = isDeleted_;
                    to_bitField0_ |= 0x00000002;
                }
                if (((from_bitField0_ & 0x00000004) != 0)) {
                    if (tripUpdateBuilder_ == null) {
                        result.tripUpdate_ = tripUpdate_;
                    } else {
                        result.tripUpdate_ = tripUpdateBuilder_.build();
                    }
                    to_bitField0_ |= 0x00000004;
                }
                if (((from_bitField0_ & 0x00000008) != 0)) {
                    if (vehicleBuilder_ == null) {
                        result.vehicle_ = vehicle_;
                    } else {
                        result.vehicle_ = vehicleBuilder_.build();
                    }
                    to_bitField0_ |= 0x00000008;
                }
                if (((from_bitField0_ & 0x00000010) != 0)) {
                    if (alertBuilder_ == null) {
                        result.alert_ = alert_;
                    } else {
                        result.alert_ = alertBuilder_.build();
                    }
                    to_bitField0_ |= 0x00000010;
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            @java.lang.Override
            public Builder clone() {
                return super.clone();
            }

            @java.lang.Override
            public Builder setField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return super.setField(field, value);
            }

            @java.lang.Override
            public Builder clearField(
                    com.google.protobuf.Descriptors.FieldDescriptor field) {
                return super.clearField(field);
            }

            @java.lang.Override
            public Builder clearOneof(
                    com.google.protobuf.Descriptors.OneofDescriptor oneof) {
                return super.clearOneof(oneof);
            }

            @java.lang.Override
            public Builder setRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    int index, java.lang.Object value) {
                return super.setRepeatedField(field, index, value);
            }

            @java.lang.Override
            public Builder addRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return super.addRepeatedField(field, value);
            }

            @java.lang.Override
            public <Type> Builder setExtension(
                    com.google.protobuf.GeneratedMessage.GeneratedExtension<
                            GtfsRealtime.FeedEntity, Type> extension,
                    Type value) {
                return super.setExtension(extension, value);
            }

            @java.lang.Override
            public <Type> Builder setExtension(
                    com.google.protobuf.GeneratedMessage.GeneratedExtension<
                            GtfsRealtime.FeedEntity, java.util.List<Type>> extension,
                    int index, Type value) {
                return super.setExtension(extension, index, value);
            }

            @java.lang.Override
            public <Type> Builder addExtension(
                    com.google.protobuf.GeneratedMessage.GeneratedExtension<
                            GtfsRealtime.FeedEntity, java.util.List<Type>> extension,
                    Type value) {
                return super.addExtension(extension, value);
            }

            @java.lang.Override
            public <Type> Builder clearExtension(
                    com.google.protobuf.GeneratedMessage.GeneratedExtension<
                            GtfsRealtime.FeedEntity, ?> extension) {
                return super.clearExtension(extension);
            }

            @java.lang.Override
            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof GtfsRealtime.FeedEntity) {
                    return mergeFrom((GtfsRealtime.FeedEntity) other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(GtfsRealtime.FeedEntity other) {
                if (other == GtfsRealtime.FeedEntity.getDefaultInstance()) return this;
                if (other.hasId()) {
                    bitField0_ |= 0x00000001;
                    id_ = other.id_;
                    onChanged();
                }
                if (other.hasIsDeleted()) {
                    setIsDeleted(other.getIsDeleted());
                }
                if (other.hasTripUpdate()) {
                    mergeTripUpdate(other.getTripUpdate());
                }
                if (other.hasVehicle()) {
                    mergeVehicle(other.getVehicle());
                }
                if (other.hasAlert()) {
                    mergeAlert(other.getAlert());
                }
                this.mergeExtensionFields(other);
                this.mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            @java.lang.Override
            public final boolean isInitialized() {
                if (!hasId()) {
                    return false;
                }
                if (hasTripUpdate()) {
                    if (!getTripUpdate().isInitialized()) {
                        return false;
                    }
                }
                if (hasVehicle()) {
                    if (!getVehicle().isInitialized()) {
                        return false;
                    }
                }
                if (hasAlert()) {
                    if (!getAlert().isInitialized()) {
                        return false;
                    }
                }
                if (!extensionsAreInitialized()) {
                    return false;
                }
                return true;
            }

            @java.lang.Override
            public Builder mergeFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                GtfsRealtime.FeedEntity parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (GtfsRealtime.FeedEntity) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private int bitField0_;

            private java.lang.Object id_ = "";

            /**
             * <pre>
             * The ids are used only to provide incrementality support. The id should be
             * unique within a FeedMessage. Consequent FeedMessages may contain
             * FeedEntities with the same id. In case of a DIFFERENTIAL update the new
             * FeedEntity with some id will replace the old FeedEntity with the same id
             * (or delete it - see is_deleted below).
             * The actual GTFS entities (e.g. stations, routes, trips) referenced by the
             * feed must be specified by explicit selectors (see EntitySelector below for
             * more info).
             * </pre>
             *
             * <code>required string id = 1;</code>
             */
            public boolean hasId() {
                return ((bitField0_ & 0x00000001) != 0);
            }

            /**
             * <pre>
             * The ids are used only to provide incrementality support. The id should be
             * unique within a FeedMessage. Consequent FeedMessages may contain
             * FeedEntities with the same id. In case of a DIFFERENTIAL update the new
             * FeedEntity with some id will replace the old FeedEntity with the same id
             * (or delete it - see is_deleted below).
             * The actual GTFS entities (e.g. stations, routes, trips) referenced by the
             * feed must be specified by explicit selectors (see EntitySelector below for
             * more info).
             * </pre>
             *
             * <code>required string id = 1;</code>
             */
            public java.lang.String getId() {
                java.lang.Object ref = id_;
                if (!(ref instanceof java.lang.String)) {
                    com.google.protobuf.ByteString bs =
                            (com.google.protobuf.ByteString) ref;
                    java.lang.String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        id_ = s;
                    }
                    return s;
                } else {
                    return (java.lang.String) ref;
                }
            }

            /**
             * <pre>
             * The ids are used only to provide incrementality support. The id should be
             * unique within a FeedMessage. Consequent FeedMessages may contain
             * FeedEntities with the same id. In case of a DIFFERENTIAL update the new
             * FeedEntity with some id will replace the old FeedEntity with the same id
             * (or delete it - see is_deleted below).
             * The actual GTFS entities (e.g. stations, routes, trips) referenced by the
             * feed must be specified by explicit selectors (see EntitySelector below for
             * more info).
             * </pre>
             *
             * <code>required string id = 1;</code>
             */
            public com.google.protobuf.ByteString
            getIdBytes() {
                java.lang.Object ref = id_;
                if (ref instanceof String) {
                    com.google.protobuf.ByteString b =
                            com.google.protobuf.ByteString.copyFromUtf8(
                                    (java.lang.String) ref);
                    id_ = b;
                    return b;
                } else {
                    return (com.google.protobuf.ByteString) ref;
                }
            }

            /**
             * <pre>
             * The ids are used only to provide incrementality support. The id should be
             * unique within a FeedMessage. Consequent FeedMessages may contain
             * FeedEntities with the same id. In case of a DIFFERENTIAL update the new
             * FeedEntity with some id will replace the old FeedEntity with the same id
             * (or delete it - see is_deleted below).
             * The actual GTFS entities (e.g. stations, routes, trips) referenced by the
             * feed must be specified by explicit selectors (see EntitySelector below for
             * more info).
             * </pre>
             *
             * <code>required string id = 1;</code>
             */
            public Builder setId(
                    java.lang.String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000001;
                id_ = value;
                onChanged();
                return this;
            }

            /**
             * <pre>
             * The ids are used only to provide incrementality support. The id should be
             * unique within a FeedMessage. Consequent FeedMessages may contain
             * FeedEntities with the same id. In case of a DIFFERENTIAL update the new
             * FeedEntity with some id will replace the old FeedEntity with the same id
             * (or delete it - see is_deleted below).
             * The actual GTFS entities (e.g. stations, routes, trips) referenced by the
             * feed must be specified by explicit selectors (see EntitySelector below for
             * more info).
             * </pre>
             *
             * <code>required string id = 1;</code>
             */
            public Builder clearId() {
                bitField0_ = (bitField0_ & ~0x00000001);
                id_ = getDefaultInstance().getId();
                onChanged();
                return this;
            }

            /**
             * <pre>
             * The ids are used only to provide incrementality support. The id should be
             * unique within a FeedMessage. Consequent FeedMessages may contain
             * FeedEntities with the same id. In case of a DIFFERENTIAL update the new
             * FeedEntity with some id will replace the old FeedEntity with the same id
             * (or delete it - see is_deleted below).
             * The actual GTFS entities (e.g. stations, routes, trips) referenced by the
             * feed must be specified by explicit selectors (see EntitySelector below for
             * more info).
             * </pre>
             *
             * <code>required string id = 1;</code>
             */
            public Builder setIdBytes(
                    com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000001;
                id_ = value;
                onChanged();
                return this;
            }

            private boolean isDeleted_;

            /**
             * <pre>
             * Whether this entity is to be deleted. Relevant only for incremental
             * fetches.
             * </pre>
             *
             * <code>optional bool is_deleted = 2 [default = false];</code>
             */
            public boolean hasIsDeleted() {
                return ((bitField0_ & 0x00000002) != 0);
            }

            /**
             * <pre>
             * Whether this entity is to be deleted. Relevant only for incremental
             * fetches.
             * </pre>
             *
             * <code>optional bool is_deleted = 2 [default = false];</code>
             */
            public boolean getIsDeleted() {
                return isDeleted_;
            }

            /**
             * <pre>
             * Whether this entity is to be deleted. Relevant only for incremental
             * fetches.
             * </pre>
             *
             * <code>optional bool is_deleted = 2 [default = false];</code>
             */
            public Builder setIsDeleted(boolean value) {
                bitField0_ |= 0x00000002;
                isDeleted_ = value;
                onChanged();
                return this;
            }

            /**
             * <pre>
             * Whether this entity is to be deleted. Relevant only for incremental
             * fetches.
             * </pre>
             *
             * <code>optional bool is_deleted = 2 [default = false];</code>
             */
            public Builder clearIsDeleted() {
                bitField0_ = (bitField0_ & ~0x00000002);
                isDeleted_ = false;
                onChanged();
                return this;
            }

            private GtfsRealtime.TripUpdate tripUpdate_;
            private com.google.protobuf.SingleFieldBuilderV3<
                    GtfsRealtime.TripUpdate, GtfsRealtime.TripUpdate.Builder, GtfsRealtime.TripUpdateOrBuilder> tripUpdateBuilder_;

            /**
             * <pre>
             * Data about the entity itself. Exactly one of the following fields must be
             * present (unless the entity is being deleted).
             * </pre>
             *
             * <code>optional .transit_realtime.TripUpdate trip_update = 3;</code>
             */
            public boolean hasTripUpdate() {
                return ((bitField0_ & 0x00000004) != 0);
            }

            /**
             * <pre>
             * Data about the entity itself. Exactly one of the following fields must be
             * present (unless the entity is being deleted).
             * </pre>
             *
             * <code>optional .transit_realtime.TripUpdate trip_update = 3;</code>
             */
            public GtfsRealtime.TripUpdate getTripUpdate() {
                if (tripUpdateBuilder_ == null) {
                    return tripUpdate_ == null ? GtfsRealtime.TripUpdate.getDefaultInstance() : tripUpdate_;
                } else {
                    return tripUpdateBuilder_.getMessage();
                }
            }

            /**
             * <pre>
             * Data about the entity itself. Exactly one of the following fields must be
             * present (unless the entity is being deleted).
             * </pre>
             *
             * <code>optional .transit_realtime.TripUpdate trip_update = 3;</code>
             */
            public Builder setTripUpdate(GtfsRealtime.TripUpdate value) {
                if (tripUpdateBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    tripUpdate_ = value;
                    onChanged();
                } else {
                    tripUpdateBuilder_.setMessage(value);
                }
                bitField0_ |= 0x00000004;
                return this;
            }

            /**
             * <pre>
             * Data about the entity itself. Exactly one of the following fields must be
             * present (unless the entity is being deleted).
             * </pre>
             *
             * <code>optional .transit_realtime.TripUpdate trip_update = 3;</code>
             */
            public Builder setTripUpdate(
                    GtfsRealtime.TripUpdate.Builder builderForValue) {
                if (tripUpdateBuilder_ == null) {
                    tripUpdate_ = builderForValue.build();
                    onChanged();
                } else {
                    tripUpdateBuilder_.setMessage(builderForValue.build());
                }
                bitField0_ |= 0x00000004;
                return this;
            }

            /**
             * <pre>
             * Data about the entity itself. Exactly one of the following fields must be
             * present (unless the entity is being deleted).
             * </pre>
             *
             * <code>optional .transit_realtime.TripUpdate trip_update = 3;</code>
             */
            public Builder mergeTripUpdate(GtfsRealtime.TripUpdate value) {
                if (tripUpdateBuilder_ == null) {
                    if (((bitField0_ & 0x00000004) != 0) &&
                            tripUpdate_ != null &&
                            tripUpdate_ != GtfsRealtime.TripUpdate.getDefaultInstance()) {
                        tripUpdate_ =
                                GtfsRealtime.TripUpdate.newBuilder(tripUpdate_).mergeFrom(value).buildPartial();
                    } else {
                        tripUpdate_ = value;
                    }
                    onChanged();
                } else {
                    tripUpdateBuilder_.mergeFrom(value);
                }
                bitField0_ |= 0x00000004;
                return this;
            }

            /**
             * <pre>
             * Data about the entity itself. Exactly one of the following fields must be
             * present (unless the entity is being deleted).
             * </pre>
             *
             * <code>optional .transit_realtime.TripUpdate trip_update = 3;</code>
             */
            public Builder clearTripUpdate() {
                if (tripUpdateBuilder_ == null) {
                    tripUpdate_ = null;
                    onChanged();
                } else {
                    tripUpdateBuilder_.clear();
                }
                bitField0_ = (bitField0_ & ~0x00000004);
                return this;
            }

            /**
             * <pre>
             * Data about the entity itself. Exactly one of the following fields must be
             * present (unless the entity is being deleted).
             * </pre>
             *
             * <code>optional .transit_realtime.TripUpdate trip_update = 3;</code>
             */
            public GtfsRealtime.TripUpdate.Builder getTripUpdateBuilder() {
                bitField0_ |= 0x00000004;
                onChanged();
                return getTripUpdateFieldBuilder().getBuilder();
            }

            /**
             * <pre>
             * Data about the entity itself. Exactly one of the following fields must be
             * present (unless the entity is being deleted).
             * </pre>
             *
             * <code>optional .transit_realtime.TripUpdate trip_update = 3;</code>
             */
            public GtfsRealtime.TripUpdateOrBuilder getTripUpdateOrBuilder() {
                if (tripUpdateBuilder_ != null) {
                    return tripUpdateBuilder_.getMessageOrBuilder();
                } else {
                    return tripUpdate_ == null ?
                            GtfsRealtime.TripUpdate.getDefaultInstance() : tripUpdate_;
                }
            }

            /**
             * <pre>
             * Data about the entity itself. Exactly one of the following fields must be
             * present (unless the entity is being deleted).
             * </pre>
             *
             * <code>optional .transit_realtime.TripUpdate trip_update = 3;</code>
             */
            private com.google.protobuf.SingleFieldBuilderV3<
                    GtfsRealtime.TripUpdate, GtfsRealtime.TripUpdate.Builder, GtfsRealtime.TripUpdateOrBuilder>
            getTripUpdateFieldBuilder() {
                if (tripUpdateBuilder_ == null) {
                    tripUpdateBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
                            GtfsRealtime.TripUpdate, GtfsRealtime.TripUpdate.Builder, GtfsRealtime.TripUpdateOrBuilder>(
                            getTripUpdate(),
                            getParentForChildren(),
                            isClean());
                    tripUpdate_ = null;
                }
                return tripUpdateBuilder_;
            }

            private GtfsRealtime.VehiclePosition vehicle_;
            private com.google.protobuf.SingleFieldBuilderV3<
                    GtfsRealtime.VehiclePosition, GtfsRealtime.VehiclePosition.Builder, GtfsRealtime.VehiclePositionOrBuilder> vehicleBuilder_;

            /**
             * <code>optional .transit_realtime.VehiclePosition vehicle = 4;</code>
             */
            public boolean hasVehicle() {
                return ((bitField0_ & 0x00000008) != 0);
            }

            /**
             * <code>optional .transit_realtime.VehiclePosition vehicle = 4;</code>
             */
            public GtfsRealtime.VehiclePosition getVehicle() {
                if (vehicleBuilder_ == null) {
                    return vehicle_ == null ? GtfsRealtime.VehiclePosition.getDefaultInstance() : vehicle_;
                } else {
                    return vehicleBuilder_.getMessage();
                }
            }

            /**
             * <code>optional .transit_realtime.VehiclePosition vehicle = 4;</code>
             */
            public Builder setVehicle(GtfsRealtime.VehiclePosition value) {
                if (vehicleBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    vehicle_ = value;
                    onChanged();
                } else {
                    vehicleBuilder_.setMessage(value);
                }
                bitField0_ |= 0x00000008;
                return this;
            }

            /**
             * <code>optional .transit_realtime.VehiclePosition vehicle = 4;</code>
             */
            public Builder setVehicle(
                    GtfsRealtime.VehiclePosition.Builder builderForValue) {
                if (vehicleBuilder_ == null) {
                    vehicle_ = builderForValue.build();
                    onChanged();
                } else {
                    vehicleBuilder_.setMessage(builderForValue.build());
                }
                bitField0_ |= 0x00000008;
                return this;
            }

            /**
             * <code>optional .transit_realtime.VehiclePosition vehicle = 4;</code>
             */
            public Builder mergeVehicle(GtfsRealtime.VehiclePosition value) {
                if (vehicleBuilder_ == null) {
                    if (((bitField0_ & 0x00000008) != 0) &&
                            vehicle_ != null &&
                            vehicle_ != GtfsRealtime.VehiclePosition.getDefaultInstance()) {
                        vehicle_ =
                                GtfsRealtime.VehiclePosition.newBuilder(vehicle_).mergeFrom(value).buildPartial();
                    } else {
                        vehicle_ = value;
                    }
                    onChanged();
                } else {
                    vehicleBuilder_.mergeFrom(value);
                }
                bitField0_ |= 0x00000008;
                return this;
            }

            /**
             * <code>optional .transit_realtime.VehiclePosition vehicle = 4;</code>
             */
            public Builder clearVehicle() {
                if (vehicleBuilder_ == null) {
                    vehicle_ = null;
                    onChanged();
                } else {
                    vehicleBuilder_.clear();
                }
                bitField0_ = (bitField0_ & ~0x00000008);
                return this;
            }

            /**
             * <code>optional .transit_realtime.VehiclePosition vehicle = 4;</code>
             */
            public GtfsRealtime.VehiclePosition.Builder getVehicleBuilder() {
                bitField0_ |= 0x00000008;
                onChanged();
                return getVehicleFieldBuilder().getBuilder();
            }

            /**
             * <code>optional .transit_realtime.VehiclePosition vehicle = 4;</code>
             */
            public GtfsRealtime.VehiclePositionOrBuilder getVehicleOrBuilder() {
                if (vehicleBuilder_ != null) {
                    return vehicleBuilder_.getMessageOrBuilder();
                } else {
                    return vehicle_ == null ?
                            GtfsRealtime.VehiclePosition.getDefaultInstance() : vehicle_;
                }
            }

            /**
             * <code>optional .transit_realtime.VehiclePosition vehicle = 4;</code>
             */
            private com.google.protobuf.SingleFieldBuilderV3<
                    GtfsRealtime.VehiclePosition, GtfsRealtime.VehiclePosition.Builder, GtfsRealtime.VehiclePositionOrBuilder>
            getVehicleFieldBuilder() {
                if (vehicleBuilder_ == null) {
                    vehicleBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
                            GtfsRealtime.VehiclePosition, GtfsRealtime.VehiclePosition.Builder, GtfsRealtime.VehiclePositionOrBuilder>(
                            getVehicle(),
                            getParentForChildren(),
                            isClean());
                    vehicle_ = null;
                }
                return vehicleBuilder_;
            }

            private GtfsRealtime.Alert alert_;
            private com.google.protobuf.SingleFieldBuilderV3<
                    GtfsRealtime.Alert, GtfsRealtime.Alert.Builder, GtfsRealtime.AlertOrBuilder> alertBuilder_;

            /**
             * <code>optional .transit_realtime.Alert alert = 5;</code>
             */
            public boolean hasAlert() {
                return ((bitField0_ & 0x00000010) != 0);
            }

            /**
             * <code>optional .transit_realtime.Alert alert = 5;</code>
             */
            public GtfsRealtime.Alert getAlert() {
                if (alertBuilder_ == null) {
                    return alert_ == null ? GtfsRealtime.Alert.getDefaultInstance() : alert_;
                } else {
                    return alertBuilder_.getMessage();
                }
            }

            /**
             * <code>optional .transit_realtime.Alert alert = 5;</code>
             */
            public Builder setAlert(GtfsRealtime.Alert value) {
                if (alertBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    alert_ = value;
                    onChanged();
                } else {
                    alertBuilder_.setMessage(value);
                }
                bitField0_ |= 0x00000010;
                return this;
            }

            /**
             * <code>optional .transit_realtime.Alert alert = 5;</code>
             */
            public Builder setAlert(
                    GtfsRealtime.Alert.Builder builderForValue) {
                if (alertBuilder_ == null) {
                    alert_ = builderForValue.build();
                    onChanged();
                } else {
                    alertBuilder_.setMessage(builderForValue.build());
                }
                bitField0_ |= 0x00000010;
                return this;
            }

            /**
             * <code>optional .transit_realtime.Alert alert = 5;</code>
             */
            public Builder mergeAlert(GtfsRealtime.Alert value) {
                if (alertBuilder_ == null) {
                    if (((bitField0_ & 0x00000010) != 0) &&
                            alert_ != null &&
                            alert_ != GtfsRealtime.Alert.getDefaultInstance()) {
                        alert_ =
                                GtfsRealtime.Alert.newBuilder(alert_).mergeFrom(value).buildPartial();
                    } else {
                        alert_ = value;
                    }
                    onChanged();
                } else {
                    alertBuilder_.mergeFrom(value);
                }
                bitField0_ |= 0x00000010;
                return this;
            }

            /**
             * <code>optional .transit_realtime.Alert alert = 5;</code>
             */
            public Builder clearAlert() {
                if (alertBuilder_ == null) {
                    alert_ = null;
                    onChanged();
                } else {
                    alertBuilder_.clear();
                }
                bitField0_ = (bitField0_ & ~0x00000010);
                return this;
            }

            /**
             * <code>optional .transit_realtime.Alert alert = 5;</code>
             */
            public GtfsRealtime.Alert.Builder getAlertBuilder() {
                bitField0_ |= 0x00000010;
                onChanged();
                return getAlertFieldBuilder().getBuilder();
            }

            /**
             * <code>optional .transit_realtime.Alert alert = 5;</code>
             */
            public GtfsRealtime.AlertOrBuilder getAlertOrBuilder() {
                if (alertBuilder_ != null) {
                    return alertBuilder_.getMessageOrBuilder();
                } else {
                    return alert_ == null ?
                            GtfsRealtime.Alert.getDefaultInstance() : alert_;
                }
            }

            /**
             * <code>optional .transit_realtime.Alert alert = 5;</code>
             */
            private com.google.protobuf.SingleFieldBuilderV3<
                    GtfsRealtime.Alert, GtfsRealtime.Alert.Builder, GtfsRealtime.AlertOrBuilder>
            getAlertFieldBuilder() {
                if (alertBuilder_ == null) {
                    alertBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
                            GtfsRealtime.Alert, GtfsRealtime.Alert.Builder, GtfsRealtime.AlertOrBuilder>(
                            getAlert(),
                            getParentForChildren(),
                            isClean());
                    alert_ = null;
                }
                return alertBuilder_;
            }

            @java.lang.Override
            public final Builder setUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.setUnknownFields(unknownFields);
            }

            @java.lang.Override
            public final Builder mergeUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.mergeUnknownFields(unknownFields);
            }


            // @@protoc_insertion_point(builder_scope:transit_realtime.FeedEntity)
        }

        // @@protoc_insertion_point(class_scope:transit_realtime.FeedEntity)
        private static final GtfsRealtime.FeedEntity DEFAULT_INSTANCE;

        static {
            DEFAULT_INSTANCE = new GtfsRealtime.FeedEntity();
        }

        public static GtfsRealtime.FeedEntity getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        @java.lang.Deprecated
        public static final com.google.protobuf.Parser<FeedEntity>
                PARSER = new com.google.protobuf.AbstractParser<FeedEntity>() {
            @java.lang.Override
            public FeedEntity parsePartialFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return new FeedEntity(input, extensionRegistry);
            }
        };

        public static com.google.protobuf.Parser<FeedEntity> parser() {
            return PARSER;
        }

        @java.lang.Override
        public com.google.protobuf.Parser<FeedEntity> getParserForType() {
            return PARSER;
        }

        @java.lang.Override
        public GtfsRealtime.FeedEntity getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

    }

    public interface TripUpdateOrBuilder extends
            // @@protoc_insertion_point(interface_extends:transit_realtime.TripUpdate)
            com.google.protobuf.GeneratedMessageV3.
                    ExtendableMessageOrBuilder<TripUpdate> {

        /**
         * <pre>
         * The Trip that this message applies to. There can be at most one
         * TripUpdate entity for each actual trip instance.
         * If there is none, that means there is no prediction information available.
         * It does *not* mean that the trip is progressing according to schedule.
         * </pre>
         *
         * <code>required .transit_realtime.TripDescriptor trip = 1;</code>
         */
        boolean hasTrip();

        /**
         * <pre>
         * The Trip that this message applies to. There can be at most one
         * TripUpdate entity for each actual trip instance.
         * If there is none, that means there is no prediction information available.
         * It does *not* mean that the trip is progressing according to schedule.
         * </pre>
         *
         * <code>required .transit_realtime.TripDescriptor trip = 1;</code>
         */
        GtfsRealtime.TripDescriptor getTrip();

        /**
         * <pre>
         * The Trip that this message applies to. There can be at most one
         * TripUpdate entity for each actual trip instance.
         * If there is none, that means there is no prediction information available.
         * It does *not* mean that the trip is progressing according to schedule.
         * </pre>
         *
         * <code>required .transit_realtime.TripDescriptor trip = 1;</code>
         */
        GtfsRealtime.TripDescriptorOrBuilder getTripOrBuilder();

        /**
         * <pre>
         * Additional information on the vehicle that is serving this trip.
         * </pre>
         *
         * <code>optional .transit_realtime.VehicleDescriptor vehicle = 3;</code>
         */
        boolean hasVehicle();

        /**
         * <pre>
         * Additional information on the vehicle that is serving this trip.
         * </pre>
         *
         * <code>optional .transit_realtime.VehicleDescriptor vehicle = 3;</code>
         */
        GtfsRealtime.VehicleDescriptor getVehicle();

        /**
         * <pre>
         * Additional information on the vehicle that is serving this trip.
         * </pre>
         *
         * <code>optional .transit_realtime.VehicleDescriptor vehicle = 3;</code>
         */
        GtfsRealtime.VehicleDescriptorOrBuilder getVehicleOrBuilder();

        /**
         * <pre>
         * Updates to StopTimes for the trip (both future, i.e., predictions, and in
         * some cases, past ones, i.e., those that already happened).
         * The updates must be sorted by stop_sequence, and apply for all the
         * following stops of the trip up to the next specified one.
         * Example 1:
         * For a trip with 20 stops, a StopTimeUpdate with arrival delay and departure
         * delay of 0 for stop_sequence of the current stop means that the trip is
         * exactly on time.
         * Example 2:
         * For the same trip instance, 3 StopTimeUpdates are provided:
         * - delay of 5 min for stop_sequence 3
         * - delay of 1 min for stop_sequence 8
         * - delay of unspecified duration for stop_sequence 10
         * This will be interpreted as:
         * - stop_sequences 3,4,5,6,7 have delay of 5 min.
         * - stop_sequences 8,9 have delay of 1 min.
         * - stop_sequences 10,... have unknown delay.
         * </pre>
         *
         * <code>repeated .transit_realtime.TripUpdate.StopTimeUpdate stop_time_update = 2;</code>
         */
        java.util.List<GtfsRealtime.TripUpdate.StopTimeUpdate>
        getStopTimeUpdateList();

        /**
         * <pre>
         * Updates to StopTimes for the trip (both future, i.e., predictions, and in
         * some cases, past ones, i.e., those that already happened).
         * The updates must be sorted by stop_sequence, and apply for all the
         * following stops of the trip up to the next specified one.
         * Example 1:
         * For a trip with 20 stops, a StopTimeUpdate with arrival delay and departure
         * delay of 0 for stop_sequence of the current stop means that the trip is
         * exactly on time.
         * Example 2:
         * For the same trip instance, 3 StopTimeUpdates are provided:
         * - delay of 5 min for stop_sequence 3
         * - delay of 1 min for stop_sequence 8
         * - delay of unspecified duration for stop_sequence 10
         * This will be interpreted as:
         * - stop_sequences 3,4,5,6,7 have delay of 5 min.
         * - stop_sequences 8,9 have delay of 1 min.
         * - stop_sequences 10,... have unknown delay.
         * </pre>
         *
         * <code>repeated .transit_realtime.TripUpdate.StopTimeUpdate stop_time_update = 2;</code>
         */
        GtfsRealtime.TripUpdate.StopTimeUpdate getStopTimeUpdate(int index);

        /**
         * <pre>
         * Updates to StopTimes for the trip (both future, i.e., predictions, and in
         * some cases, past ones, i.e., those that already happened).
         * The updates must be sorted by stop_sequence, and apply for all the
         * following stops of the trip up to the next specified one.
         * Example 1:
         * For a trip with 20 stops, a StopTimeUpdate with arrival delay and departure
         * delay of 0 for stop_sequence of the current stop means that the trip is
         * exactly on time.
         * Example 2:
         * For the same trip instance, 3 StopTimeUpdates are provided:
         * - delay of 5 min for stop_sequence 3
         * - delay of 1 min for stop_sequence 8
         * - delay of unspecified duration for stop_sequence 10
         * This will be interpreted as:
         * - stop_sequences 3,4,5,6,7 have delay of 5 min.
         * - stop_sequences 8,9 have delay of 1 min.
         * - stop_sequences 10,... have unknown delay.
         * </pre>
         *
         * <code>repeated .transit_realtime.TripUpdate.StopTimeUpdate stop_time_update = 2;</code>
         */
        int getStopTimeUpdateCount();

        /**
         * <pre>
         * Updates to StopTimes for the trip (both future, i.e., predictions, and in
         * some cases, past ones, i.e., those that already happened).
         * The updates must be sorted by stop_sequence, and apply for all the
         * following stops of the trip up to the next specified one.
         * Example 1:
         * For a trip with 20 stops, a StopTimeUpdate with arrival delay and departure
         * delay of 0 for stop_sequence of the current stop means that the trip is
         * exactly on time.
         * Example 2:
         * For the same trip instance, 3 StopTimeUpdates are provided:
         * - delay of 5 min for stop_sequence 3
         * - delay of 1 min for stop_sequence 8
         * - delay of unspecified duration for stop_sequence 10
         * This will be interpreted as:
         * - stop_sequences 3,4,5,6,7 have delay of 5 min.
         * - stop_sequences 8,9 have delay of 1 min.
         * - stop_sequences 10,... have unknown delay.
         * </pre>
         *
         * <code>repeated .transit_realtime.TripUpdate.StopTimeUpdate stop_time_update = 2;</code>
         */
        java.util.List<? extends GtfsRealtime.TripUpdate.StopTimeUpdateOrBuilder>
        getStopTimeUpdateOrBuilderList();

        /**
         * <pre>
         * Updates to StopTimes for the trip (both future, i.e., predictions, and in
         * some cases, past ones, i.e., those that already happened).
         * The updates must be sorted by stop_sequence, and apply for all the
         * following stops of the trip up to the next specified one.
         * Example 1:
         * For a trip with 20 stops, a StopTimeUpdate with arrival delay and departure
         * delay of 0 for stop_sequence of the current stop means that the trip is
         * exactly on time.
         * Example 2:
         * For the same trip instance, 3 StopTimeUpdates are provided:
         * - delay of 5 min for stop_sequence 3
         * - delay of 1 min for stop_sequence 8
         * - delay of unspecified duration for stop_sequence 10
         * This will be interpreted as:
         * - stop_sequences 3,4,5,6,7 have delay of 5 min.
         * - stop_sequences 8,9 have delay of 1 min.
         * - stop_sequences 10,... have unknown delay.
         * </pre>
         *
         * <code>repeated .transit_realtime.TripUpdate.StopTimeUpdate stop_time_update = 2;</code>
         */
        GtfsRealtime.TripUpdate.StopTimeUpdateOrBuilder getStopTimeUpdateOrBuilder(
                int index);

        /**
         * <pre>
         * Moment at which the vehicle's real-time progress was measured. In POSIX
         * time (i.e., the number of seconds since January 1st 1970 00:00:00 UTC).
         * </pre>
         *
         * <code>optional uint64 timestamp = 4;</code>
         */
        boolean hasTimestamp();

        /**
         * <pre>
         * Moment at which the vehicle's real-time progress was measured. In POSIX
         * time (i.e., the number of seconds since January 1st 1970 00:00:00 UTC).
         * </pre>
         *
         * <code>optional uint64 timestamp = 4;</code>
         */
        long getTimestamp();

        /**
         * <pre>
         * The current schedule deviation for the trip.  Delay should only be
         * specified when the prediction is given relative to some existing schedule
         * in GTFS.
         * Delay (in seconds) can be positive (meaning that the vehicle is late) or
         * negative (meaning that the vehicle is ahead of schedule). Delay of 0
         * means that the vehicle is exactly on time.
         * Delay information in StopTimeUpdates take precedent of trip-level delay
         * information, such that trip-level delay is only propagated until the next
         * stop along the trip with a StopTimeUpdate delay value specified.
         * Feed providers are strongly encouraged to provide a TripUpdate.timestamp
         * value indicating when the delay value was last updated, in order to
         * evaluate the freshness of the data.
         * NOTE: This field is still experimental, and subject to change. It may be
         * formally adopted in the future.
         * </pre>
         *
         * <code>optional int32 delay = 5;</code>
         */
        boolean hasDelay();

        /**
         * <pre>
         * The current schedule deviation for the trip.  Delay should only be
         * specified when the prediction is given relative to some existing schedule
         * in GTFS.
         * Delay (in seconds) can be positive (meaning that the vehicle is late) or
         * negative (meaning that the vehicle is ahead of schedule). Delay of 0
         * means that the vehicle is exactly on time.
         * Delay information in StopTimeUpdates take precedent of trip-level delay
         * information, such that trip-level delay is only propagated until the next
         * stop along the trip with a StopTimeUpdate delay value specified.
         * Feed providers are strongly encouraged to provide a TripUpdate.timestamp
         * value indicating when the delay value was last updated, in order to
         * evaluate the freshness of the data.
         * NOTE: This field is still experimental, and subject to change. It may be
         * formally adopted in the future.
         * </pre>
         *
         * <code>optional int32 delay = 5;</code>
         */
        int getDelay();
    }

    /**
     * <pre>
     * Realtime update of the progress of a vehicle along a trip.
     * Depending on the value of ScheduleRelationship, a TripUpdate can specify:
     * - A trip that proceeds along the schedule.
     * - A trip that proceeds along a route but has no fixed schedule.
     * - A trip that have been added or removed with regard to schedule.
     * The updates can be for future, predicted arrival/departure events, or for
     * past events that already occurred.
     * Normally, updates should get more precise and more certain (see
     * uncertainty below) as the events gets closer to current time.
     * Even if that is not possible, the information for past events should be
     * precise and certain. In particular, if an update points to time in the past
     * but its update's uncertainty is not 0, the client should conclude that the
     * update is a (wrong) prediction and that the trip has not completed yet.
     * Note that the update can describe a trip that is already completed.
     * To this end, it is enough to provide an update for the last stop of the trip.
     * If the time of that is in the past, the client will conclude from that that
     * the whole trip is in the past (it is possible, although inconsequential, to
     * also provide updates for preceding stops).
     * This option is most relevant for a trip that has completed ahead of schedule,
     * but according to the schedule, the trip is still proceeding at the current
     * time. Removing the updates for this trip could make the client assume
     * that the trip is still proceeding.
     * Note that the feed provider is allowed, but not required, to purge past
     * updates - this is one case where this would be practically useful.
     * </pre>
     * <p>
     * Protobuf type {@code transit_realtime.TripUpdate}
     */
    public static final class TripUpdate extends
            com.google.protobuf.GeneratedMessageV3.ExtendableMessage<
                    TripUpdate> implements
            // @@protoc_insertion_point(message_implements:transit_realtime.TripUpdate)
            TripUpdateOrBuilder {
        private static final long serialVersionUID = 0L;

        // Use TripUpdate.newBuilder() to construct.
        private TripUpdate(com.google.protobuf.GeneratedMessageV3.ExtendableBuilder<GtfsRealtime.TripUpdate, ?> builder) {
            super(builder);
        }

        private TripUpdate() {
            stopTimeUpdate_ = java.util.Collections.emptyList();
        }

        @java.lang.Override
        @SuppressWarnings({"unused"})
        protected java.lang.Object newInstance(
                UnusedPrivateParameter unused) {
            return new TripUpdate();
        }

        @java.lang.Override
        public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
            return this.unknownFields;
        }

        private TripUpdate(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            if (extensionRegistry == null) {
                throw new java.lang.NullPointerException();
            }
            int mutable_bitField0_ = 0;
            com.google.protobuf.UnknownFieldSet.Builder unknownFields =
                    com.google.protobuf.UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        case 10: {
                            GtfsRealtime.TripDescriptor.Builder subBuilder = null;
                            if (((bitField0_ & 0x00000001) != 0)) {
                                subBuilder = trip_.toBuilder();
                            }
                            trip_ = input.readMessage(GtfsRealtime.TripDescriptor.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(trip_);
                                trip_ = subBuilder.buildPartial();
                            }
                            bitField0_ |= 0x00000001;
                            break;
                        }
                        case 18: {
                            if (!((mutable_bitField0_ & 0x00000004) != 0)) {
                                stopTimeUpdate_ = new java.util.ArrayList<GtfsRealtime.TripUpdate.StopTimeUpdate>();
                                mutable_bitField0_ |= 0x00000004;
                            }
                            stopTimeUpdate_.add(
                                    input.readMessage(GtfsRealtime.TripUpdate.StopTimeUpdate.PARSER, extensionRegistry));
                            break;
                        }
                        case 26: {
                            GtfsRealtime.VehicleDescriptor.Builder subBuilder = null;
                            if (((bitField0_ & 0x00000002) != 0)) {
                                subBuilder = vehicle_.toBuilder();
                            }
                            vehicle_ = input.readMessage(GtfsRealtime.VehicleDescriptor.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(vehicle_);
                                vehicle_ = subBuilder.buildPartial();
                            }
                            bitField0_ |= 0x00000002;
                            break;
                        }
                        case 32: {
                            bitField0_ |= 0x00000004;
                            timestamp_ = input.readUInt64();
                            break;
                        }
                        case 40: {
                            bitField0_ |= 0x00000008;
                            delay_ = input.readInt32();
                            break;
                        }
                        default: {
                            if (!parseUnknownField(
                                    input, unknownFields, extensionRegistry, tag)) {
                                done = true;
                            }
                            break;
                        }
                    }
                }
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (java.io.IOException e) {
                throw new com.google.protobuf.InvalidProtocolBufferException(
                        e).setUnfinishedMessage(this);
            } finally {
                if (((mutable_bitField0_ & 0x00000004) != 0)) {
                    stopTimeUpdate_ = java.util.Collections.unmodifiableList(stopTimeUpdate_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return GtfsRealtime.internal_static_transit_realtime_TripUpdate_descriptor;
        }

        @java.lang.Override
        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return GtfsRealtime.internal_static_transit_realtime_TripUpdate_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            GtfsRealtime.TripUpdate.class, GtfsRealtime.TripUpdate.Builder.class);
        }

        public interface StopTimeEventOrBuilder extends
                // @@protoc_insertion_point(interface_extends:transit_realtime.TripUpdate.StopTimeEvent)
                com.google.protobuf.GeneratedMessageV3.
                        ExtendableMessageOrBuilder<StopTimeEvent> {

            /**
             * <pre>
             * Delay (in seconds) can be positive (meaning that the vehicle is late) or
             * negative (meaning that the vehicle is ahead of schedule). Delay of 0
             * means that the vehicle is exactly on time.
             * </pre>
             *
             * <code>optional int32 delay = 1;</code>
             */
            boolean hasDelay();

            /**
             * <pre>
             * Delay (in seconds) can be positive (meaning that the vehicle is late) or
             * negative (meaning that the vehicle is ahead of schedule). Delay of 0
             * means that the vehicle is exactly on time.
             * </pre>
             *
             * <code>optional int32 delay = 1;</code>
             */
            int getDelay();

            /**
             * <pre>
             * Event as absolute time.
             * In Unix time (i.e., number of seconds since January 1st 1970 00:00:00
             * UTC).
             * </pre>
             *
             * <code>optional int64 time = 2;</code>
             */
            boolean hasTime();

            /**
             * <pre>
             * Event as absolute time.
             * In Unix time (i.e., number of seconds since January 1st 1970 00:00:00
             * UTC).
             * </pre>
             *
             * <code>optional int64 time = 2;</code>
             */
            long getTime();

            /**
             * <pre>
             * If uncertainty is omitted, it is interpreted as unknown.
             * If the prediction is unknown or too uncertain, the delay (or time) field
             * should be empty. In such case, the uncertainty field is ignored.
             * To specify a completely certain prediction, set its uncertainty to 0.
             * </pre>
             *
             * <code>optional int32 uncertainty = 3;</code>
             */
            boolean hasUncertainty();

            /**
             * <pre>
             * If uncertainty is omitted, it is interpreted as unknown.
             * If the prediction is unknown or too uncertain, the delay (or time) field
             * should be empty. In such case, the uncertainty field is ignored.
             * To specify a completely certain prediction, set its uncertainty to 0.
             * </pre>
             *
             * <code>optional int32 uncertainty = 3;</code>
             */
            int getUncertainty();
        }

        /**
         * <pre>
         * Timing information for a single predicted event (either arrival or
         * departure).
         * Timing consists of delay and/or estimated time, and uncertainty.
         * - delay should be used when the prediction is given relative to some
         *   existing schedule in GTFS.
         * - time should be given whether there is a predicted schedule or not. If
         *   both time and delay are specified, time will take precedence
         *   (although normally, time, if given for a scheduled trip, should be
         *   equal to scheduled time in GTFS + delay).
         * Uncertainty applies equally to both time and delay.
         * The uncertainty roughly specifies the expected error in true delay (but
         * note, we don't yet define its precise statistical meaning). It's possible
         * for the uncertainty to be 0, for example for trains that are driven under
         * computer timing control.
         * </pre>
         * <p>
         * Protobuf type {@code transit_realtime.TripUpdate.StopTimeEvent}
         */
        public static final class StopTimeEvent extends
                com.google.protobuf.GeneratedMessageV3.ExtendableMessage<
                        StopTimeEvent> implements
                // @@protoc_insertion_point(message_implements:transit_realtime.TripUpdate.StopTimeEvent)
                StopTimeEventOrBuilder {
            private static final long serialVersionUID = 0L;

            // Use StopTimeEvent.newBuilder() to construct.
            private StopTimeEvent(com.google.protobuf.GeneratedMessageV3.ExtendableBuilder<GtfsRealtime.TripUpdate.StopTimeEvent, ?> builder) {
                super(builder);
            }

            private StopTimeEvent() {
            }

            @java.lang.Override
            @SuppressWarnings({"unused"})
            protected java.lang.Object newInstance(
                    UnusedPrivateParameter unused) {
                return new StopTimeEvent();
            }

            @java.lang.Override
            public final com.google.protobuf.UnknownFieldSet
            getUnknownFields() {
                return this.unknownFields;
            }

            private StopTimeEvent(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                this();
                if (extensionRegistry == null) {
                    throw new java.lang.NullPointerException();
                }
                int mutable_bitField0_ = 0;
                com.google.protobuf.UnknownFieldSet.Builder unknownFields =
                        com.google.protobuf.UnknownFieldSet.newBuilder();
                try {
                    boolean done = false;
                    while (!done) {
                        int tag = input.readTag();
                        switch (tag) {
                            case 0:
                                done = true;
                                break;
                            case 8: {
                                bitField0_ |= 0x00000001;
                                delay_ = input.readInt32();
                                break;
                            }
                            case 16: {
                                bitField0_ |= 0x00000002;
                                time_ = input.readInt64();
                                break;
                            }
                            case 24: {
                                bitField0_ |= 0x00000004;
                                uncertainty_ = input.readInt32();
                                break;
                            }
                            default: {
                                if (!parseUnknownField(
                                        input, unknownFields, extensionRegistry, tag)) {
                                    done = true;
                                }
                                break;
                            }
                        }
                    }
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (java.io.IOException e) {
                    throw new com.google.protobuf.InvalidProtocolBufferException(
                            e).setUnfinishedMessage(this);
                } finally {
                    this.unknownFields = unknownFields.build();
                    makeExtensionsImmutable();
                }
            }

            public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
                return GtfsRealtime.internal_static_transit_realtime_TripUpdate_StopTimeEvent_descriptor;
            }

            @java.lang.Override
            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internalGetFieldAccessorTable() {
                return GtfsRealtime.internal_static_transit_realtime_TripUpdate_StopTimeEvent_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                GtfsRealtime.TripUpdate.StopTimeEvent.class, GtfsRealtime.TripUpdate.StopTimeEvent.Builder.class);
            }

            private int bitField0_;
            public static final int DELAY_FIELD_NUMBER = 1;
            private int delay_;

            /**
             * <pre>
             * Delay (in seconds) can be positive (meaning that the vehicle is late) or
             * negative (meaning that the vehicle is ahead of schedule). Delay of 0
             * means that the vehicle is exactly on time.
             * </pre>
             *
             * <code>optional int32 delay = 1;</code>
             */
            public boolean hasDelay() {
                return ((bitField0_ & 0x00000001) != 0);
            }

            /**
             * <pre>
             * Delay (in seconds) can be positive (meaning that the vehicle is late) or
             * negative (meaning that the vehicle is ahead of schedule). Delay of 0
             * means that the vehicle is exactly on time.
             * </pre>
             *
             * <code>optional int32 delay = 1;</code>
             */
            public int getDelay() {
                return delay_;
            }

            public static final int TIME_FIELD_NUMBER = 2;
            private long time_;

            /**
             * <pre>
             * Event as absolute time.
             * In Unix time (i.e., number of seconds since January 1st 1970 00:00:00
             * UTC).
             * </pre>
             *
             * <code>optional int64 time = 2;</code>
             */
            public boolean hasTime() {
                return ((bitField0_ & 0x00000002) != 0);
            }

            /**
             * <pre>
             * Event as absolute time.
             * In Unix time (i.e., number of seconds since January 1st 1970 00:00:00
             * UTC).
             * </pre>
             *
             * <code>optional int64 time = 2;</code>
             */
            public long getTime() {
                return time_;
            }

            public static final int UNCERTAINTY_FIELD_NUMBER = 3;
            private int uncertainty_;

            /**
             * <pre>
             * If uncertainty is omitted, it is interpreted as unknown.
             * If the prediction is unknown or too uncertain, the delay (or time) field
             * should be empty. In such case, the uncertainty field is ignored.
             * To specify a completely certain prediction, set its uncertainty to 0.
             * </pre>
             *
             * <code>optional int32 uncertainty = 3;</code>
             */
            public boolean hasUncertainty() {
                return ((bitField0_ & 0x00000004) != 0);
            }

            /**
             * <pre>
             * If uncertainty is omitted, it is interpreted as unknown.
             * If the prediction is unknown or too uncertain, the delay (or time) field
             * should be empty. In such case, the uncertainty field is ignored.
             * To specify a completely certain prediction, set its uncertainty to 0.
             * </pre>
             *
             * <code>optional int32 uncertainty = 3;</code>
             */
            public int getUncertainty() {
                return uncertainty_;
            }

            private byte memoizedIsInitialized = -1;

            @java.lang.Override
            public final boolean isInitialized() {
                byte isInitialized = memoizedIsInitialized;
                if (isInitialized == 1) return true;
                if (isInitialized == 0) return false;

                if (!extensionsAreInitialized()) {
                    memoizedIsInitialized = 0;
                    return false;
                }
                memoizedIsInitialized = 1;
                return true;
            }

            @java.lang.Override
            public void writeTo(com.google.protobuf.CodedOutputStream output)
                    throws java.io.IOException {
                com.google.protobuf.GeneratedMessageV3
                        .ExtendableMessage<GtfsRealtime.TripUpdate.StopTimeEvent>.ExtensionWriter
                        extensionWriter = newExtensionWriter();
                if (((bitField0_ & 0x00000001) != 0)) {
                    output.writeInt32(1, delay_);
                }
                if (((bitField0_ & 0x00000002) != 0)) {
                    output.writeInt64(2, time_);
                }
                if (((bitField0_ & 0x00000004) != 0)) {
                    output.writeInt32(3, uncertainty_);
                }
                extensionWriter.writeUntil(2000, output);
                unknownFields.writeTo(output);
            }

            @java.lang.Override
            public int getSerializedSize() {
                int size = memoizedSize;
                if (size != -1) return size;

                size = 0;
                if (((bitField0_ & 0x00000001) != 0)) {
                    size += com.google.protobuf.CodedOutputStream
                            .computeInt32Size(1, delay_);
                }
                if (((bitField0_ & 0x00000002) != 0)) {
                    size += com.google.protobuf.CodedOutputStream
                            .computeInt64Size(2, time_);
                }
                if (((bitField0_ & 0x00000004) != 0)) {
                    size += com.google.protobuf.CodedOutputStream
                            .computeInt32Size(3, uncertainty_);
                }
                size += extensionsSerializedSize();
                size += unknownFields.getSerializedSize();
                memoizedSize = size;
                return size;
            }

            @java.lang.Override
            public boolean equals(final java.lang.Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof GtfsRealtime.TripUpdate.StopTimeEvent)) {
                    return super.equals(obj);
                }
                GtfsRealtime.TripUpdate.StopTimeEvent other = (GtfsRealtime.TripUpdate.StopTimeEvent) obj;

                if (hasDelay() != other.hasDelay()) return false;
                if (hasDelay()) {
                    if (getDelay()
                            != other.getDelay()) return false;
                }
                if (hasTime() != other.hasTime()) return false;
                if (hasTime()) {
                    if (getTime()
                            != other.getTime()) return false;
                }
                if (hasUncertainty() != other.hasUncertainty()) return false;
                if (hasUncertainty()) {
                    if (getUncertainty()
                            != other.getUncertainty()) return false;
                }
                if (!unknownFields.equals(other.unknownFields)) return false;
                if (!getExtensionFields().equals(other.getExtensionFields()))
                    return false;
                return true;
            }

            @java.lang.Override
            public int hashCode() {
                if (memoizedHashCode != 0) {
                    return memoizedHashCode;
                }
                int hash = 41;
                hash = (19 * hash) + getDescriptor().hashCode();
                if (hasDelay()) {
                    hash = (37 * hash) + DELAY_FIELD_NUMBER;
                    hash = (53 * hash) + getDelay();
                }
                if (hasTime()) {
                    hash = (37 * hash) + TIME_FIELD_NUMBER;
                    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
                            getTime());
                }
                if (hasUncertainty()) {
                    hash = (37 * hash) + UNCERTAINTY_FIELD_NUMBER;
                    hash = (53 * hash) + getUncertainty();
                }
                hash = hashFields(hash, getExtensionFields());
                hash = (29 * hash) + unknownFields.hashCode();
                memoizedHashCode = hash;
                return hash;
            }

            public static GtfsRealtime.TripUpdate.StopTimeEvent parseFrom(
                    java.nio.ByteBuffer data)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return PARSER.parseFrom(data);
            }

            public static GtfsRealtime.TripUpdate.StopTimeEvent parseFrom(
                    java.nio.ByteBuffer data,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return PARSER.parseFrom(data, extensionRegistry);
            }

            public static GtfsRealtime.TripUpdate.StopTimeEvent parseFrom(
                    com.google.protobuf.ByteString data)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return PARSER.parseFrom(data);
            }

            public static GtfsRealtime.TripUpdate.StopTimeEvent parseFrom(
                    com.google.protobuf.ByteString data,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return PARSER.parseFrom(data, extensionRegistry);
            }

            public static GtfsRealtime.TripUpdate.StopTimeEvent parseFrom(byte[] data)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return PARSER.parseFrom(data);
            }

            public static GtfsRealtime.TripUpdate.StopTimeEvent parseFrom(
                    byte[] data,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return PARSER.parseFrom(data, extensionRegistry);
            }

            public static GtfsRealtime.TripUpdate.StopTimeEvent parseFrom(java.io.InputStream input)
                    throws java.io.IOException {
                return com.google.protobuf.GeneratedMessageV3
                        .parseWithIOException(PARSER, input);
            }

            public static GtfsRealtime.TripUpdate.StopTimeEvent parseFrom(
                    java.io.InputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                return com.google.protobuf.GeneratedMessageV3
                        .parseWithIOException(PARSER, input, extensionRegistry);
            }

            public static GtfsRealtime.TripUpdate.StopTimeEvent parseDelimitedFrom(java.io.InputStream input)
                    throws java.io.IOException {
                return com.google.protobuf.GeneratedMessageV3
                        .parseDelimitedWithIOException(PARSER, input);
            }

            public static GtfsRealtime.TripUpdate.StopTimeEvent parseDelimitedFrom(
                    java.io.InputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                return com.google.protobuf.GeneratedMessageV3
                        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
            }

            public static GtfsRealtime.TripUpdate.StopTimeEvent parseFrom(
                    com.google.protobuf.CodedInputStream input)
                    throws java.io.IOException {
                return com.google.protobuf.GeneratedMessageV3
                        .parseWithIOException(PARSER, input);
            }

            public static GtfsRealtime.TripUpdate.StopTimeEvent parseFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                return com.google.protobuf.GeneratedMessageV3
                        .parseWithIOException(PARSER, input, extensionRegistry);
            }

            @java.lang.Override
            public Builder newBuilderForType() {
                return newBuilder();
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.toBuilder();
            }

            public static Builder newBuilder(GtfsRealtime.TripUpdate.StopTimeEvent prototype) {
                return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
            }

            @java.lang.Override
            public Builder toBuilder() {
                return this == DEFAULT_INSTANCE
                        ? new Builder() : new Builder().mergeFrom(this);
            }

            @java.lang.Override
            protected Builder newBuilderForType(
                    com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
                Builder builder = new Builder(parent);
                return builder;
            }

            /**
             * <pre>
             * Timing information for a single predicted event (either arrival or
             * departure).
             * Timing consists of delay and/or estimated time, and uncertainty.
             * - delay should be used when the prediction is given relative to some
             *   existing schedule in GTFS.
             * - time should be given whether there is a predicted schedule or not. If
             *   both time and delay are specified, time will take precedence
             *   (although normally, time, if given for a scheduled trip, should be
             *   equal to scheduled time in GTFS + delay).
             * Uncertainty applies equally to both time and delay.
             * The uncertainty roughly specifies the expected error in true delay (but
             * note, we don't yet define its precise statistical meaning). It's possible
             * for the uncertainty to be 0, for example for trains that are driven under
             * computer timing control.
             * </pre>
             * <p>
             * Protobuf type {@code transit_realtime.TripUpdate.StopTimeEvent}
             */
            public static final class Builder extends
                    com.google.protobuf.GeneratedMessageV3.ExtendableBuilder<
                            GtfsRealtime.TripUpdate.StopTimeEvent, Builder> implements
                    // @@protoc_insertion_point(builder_implements:transit_realtime.TripUpdate.StopTimeEvent)
                    GtfsRealtime.TripUpdate.StopTimeEventOrBuilder {
                public static final com.google.protobuf.Descriptors.Descriptor
                getDescriptor() {
                    return GtfsRealtime.internal_static_transit_realtime_TripUpdate_StopTimeEvent_descriptor;
                }

                @java.lang.Override
                protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
                internalGetFieldAccessorTable() {
                    return GtfsRealtime.internal_static_transit_realtime_TripUpdate_StopTimeEvent_fieldAccessorTable
                            .ensureFieldAccessorsInitialized(
                                    GtfsRealtime.TripUpdate.StopTimeEvent.class, GtfsRealtime.TripUpdate.StopTimeEvent.Builder.class);
                }

                // Construct using GtfsRealtime.TripUpdate.StopTimeEvent.newBuilder()
                private Builder() {
                    maybeForceBuilderInitialization();
                }

                private Builder(
                        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
                    super(parent);
                    maybeForceBuilderInitialization();
                }

                private void maybeForceBuilderInitialization() {
                    if (com.google.protobuf.GeneratedMessageV3
                            .alwaysUseFieldBuilders) {
                    }
                }

                @java.lang.Override
                public Builder clear() {
                    super.clear();
                    delay_ = 0;
                    bitField0_ = (bitField0_ & ~0x00000001);
                    time_ = 0L;
                    bitField0_ = (bitField0_ & ~0x00000002);
                    uncertainty_ = 0;
                    bitField0_ = (bitField0_ & ~0x00000004);
                    return this;
                }

                @java.lang.Override
                public com.google.protobuf.Descriptors.Descriptor
                getDescriptorForType() {
                    return GtfsRealtime.internal_static_transit_realtime_TripUpdate_StopTimeEvent_descriptor;
                }

                @java.lang.Override
                public GtfsRealtime.TripUpdate.StopTimeEvent getDefaultInstanceForType() {
                    return GtfsRealtime.TripUpdate.StopTimeEvent.getDefaultInstance();
                }

                @java.lang.Override
                public GtfsRealtime.TripUpdate.StopTimeEvent build() {
                    GtfsRealtime.TripUpdate.StopTimeEvent result = buildPartial();
                    if (!result.isInitialized()) {
                        throw newUninitializedMessageException(result);
                    }
                    return result;
                }

                @java.lang.Override
                public GtfsRealtime.TripUpdate.StopTimeEvent buildPartial() {
                    GtfsRealtime.TripUpdate.StopTimeEvent result = new GtfsRealtime.TripUpdate.StopTimeEvent(this);
                    int from_bitField0_ = bitField0_;
                    int to_bitField0_ = 0;
                    if (((from_bitField0_ & 0x00000001) != 0)) {
                        result.delay_ = delay_;
                        to_bitField0_ |= 0x00000001;
                    }
                    if (((from_bitField0_ & 0x00000002) != 0)) {
                        result.time_ = time_;
                        to_bitField0_ |= 0x00000002;
                    }
                    if (((from_bitField0_ & 0x00000004) != 0)) {
                        result.uncertainty_ = uncertainty_;
                        to_bitField0_ |= 0x00000004;
                    }
                    result.bitField0_ = to_bitField0_;
                    onBuilt();
                    return result;
                }

                @java.lang.Override
                public Builder clone() {
                    return super.clone();
                }

                @java.lang.Override
                public Builder setField(
                        com.google.protobuf.Descriptors.FieldDescriptor field,
                        java.lang.Object value) {
                    return super.setField(field, value);
                }

                @java.lang.Override
                public Builder clearField(
                        com.google.protobuf.Descriptors.FieldDescriptor field) {
                    return super.clearField(field);
                }

                @java.lang.Override
                public Builder clearOneof(
                        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
                    return super.clearOneof(oneof);
                }

                @java.lang.Override
                public Builder setRepeatedField(
                        com.google.protobuf.Descriptors.FieldDescriptor field,
                        int index, java.lang.Object value) {
                    return super.setRepeatedField(field, index, value);
                }

                @java.lang.Override
                public Builder addRepeatedField(
                        com.google.protobuf.Descriptors.FieldDescriptor field,
                        java.lang.Object value) {
                    return super.addRepeatedField(field, value);
                }

                @java.lang.Override
                public <Type> Builder setExtension(
                        com.google.protobuf.GeneratedMessage.GeneratedExtension<
                                GtfsRealtime.TripUpdate.StopTimeEvent, Type> extension,
                        Type value) {
                    return super.setExtension(extension, value);
                }

                @java.lang.Override
                public <Type> Builder setExtension(
                        com.google.protobuf.GeneratedMessage.GeneratedExtension<
                                GtfsRealtime.TripUpdate.StopTimeEvent, java.util.List<Type>> extension,
                        int index, Type value) {
                    return super.setExtension(extension, index, value);
                }

                @java.lang.Override
                public <Type> Builder addExtension(
                        com.google.protobuf.GeneratedMessage.GeneratedExtension<
                                GtfsRealtime.TripUpdate.StopTimeEvent, java.util.List<Type>> extension,
                        Type value) {
                    return super.addExtension(extension, value);
                }

                @java.lang.Override
                public <Type> Builder clearExtension(
                        com.google.protobuf.GeneratedMessage.GeneratedExtension<
                                GtfsRealtime.TripUpdate.StopTimeEvent, ?> extension) {
                    return super.clearExtension(extension);
                }

                @java.lang.Override
                public Builder mergeFrom(com.google.protobuf.Message other) {
                    if (other instanceof GtfsRealtime.TripUpdate.StopTimeEvent) {
                        return mergeFrom((GtfsRealtime.TripUpdate.StopTimeEvent) other);
                    } else {
                        super.mergeFrom(other);
                        return this;
                    }
                }

                public Builder mergeFrom(GtfsRealtime.TripUpdate.StopTimeEvent other) {
                    if (other == GtfsRealtime.TripUpdate.StopTimeEvent.getDefaultInstance()) return this;
                    if (other.hasDelay()) {
                        setDelay(other.getDelay());
                    }
                    if (other.hasTime()) {
                        setTime(other.getTime());
                    }
                    if (other.hasUncertainty()) {
                        setUncertainty(other.getUncertainty());
                    }
                    this.mergeExtensionFields(other);
                    this.mergeUnknownFields(other.unknownFields);
                    onChanged();
                    return this;
                }

                @java.lang.Override
                public final boolean isInitialized() {
                    if (!extensionsAreInitialized()) {
                        return false;
                    }
                    return true;
                }

                @java.lang.Override
                public Builder mergeFrom(
                        com.google.protobuf.CodedInputStream input,
                        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                        throws java.io.IOException {
                    GtfsRealtime.TripUpdate.StopTimeEvent parsedMessage = null;
                    try {
                        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                        parsedMessage = (GtfsRealtime.TripUpdate.StopTimeEvent) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    } finally {
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                    }
                    return this;
                }

                private int bitField0_;

                private int delay_;

                /**
                 * <pre>
                 * Delay (in seconds) can be positive (meaning that the vehicle is late) or
                 * negative (meaning that the vehicle is ahead of schedule). Delay of 0
                 * means that the vehicle is exactly on time.
                 * </pre>
                 *
                 * <code>optional int32 delay = 1;</code>
                 */
                public boolean hasDelay() {
                    return ((bitField0_ & 0x00000001) != 0);
                }

                /**
                 * <pre>
                 * Delay (in seconds) can be positive (meaning that the vehicle is late) or
                 * negative (meaning that the vehicle is ahead of schedule). Delay of 0
                 * means that the vehicle is exactly on time.
                 * </pre>
                 *
                 * <code>optional int32 delay = 1;</code>
                 */
                public int getDelay() {
                    return delay_;
                }

                /**
                 * <pre>
                 * Delay (in seconds) can be positive (meaning that the vehicle is late) or
                 * negative (meaning that the vehicle is ahead of schedule). Delay of 0
                 * means that the vehicle is exactly on time.
                 * </pre>
                 *
                 * <code>optional int32 delay = 1;</code>
                 */
                public Builder setDelay(int value) {
                    bitField0_ |= 0x00000001;
                    delay_ = value;
                    onChanged();
                    return this;
                }

                /**
                 * <pre>
                 * Delay (in seconds) can be positive (meaning that the vehicle is late) or
                 * negative (meaning that the vehicle is ahead of schedule). Delay of 0
                 * means that the vehicle is exactly on time.
                 * </pre>
                 *
                 * <code>optional int32 delay = 1;</code>
                 */
                public Builder clearDelay() {
                    bitField0_ = (bitField0_ & ~0x00000001);
                    delay_ = 0;
                    onChanged();
                    return this;
                }

                private long time_;

                /**
                 * <pre>
                 * Event as absolute time.
                 * In Unix time (i.e., number of seconds since January 1st 1970 00:00:00
                 * UTC).
                 * </pre>
                 *
                 * <code>optional int64 time = 2;</code>
                 */
                public boolean hasTime() {
                    return ((bitField0_ & 0x00000002) != 0);
                }

                /**
                 * <pre>
                 * Event as absolute time.
                 * In Unix time (i.e., number of seconds since January 1st 1970 00:00:00
                 * UTC).
                 * </pre>
                 *
                 * <code>optional int64 time = 2;</code>
                 */
                public long getTime() {
                    return time_;
                }

                /**
                 * <pre>
                 * Event as absolute time.
                 * In Unix time (i.e., number of seconds since January 1st 1970 00:00:00
                 * UTC).
                 * </pre>
                 *
                 * <code>optional int64 time = 2;</code>
                 */
                public Builder setTime(long value) {
                    bitField0_ |= 0x00000002;
                    time_ = value;
                    onChanged();
                    return this;
                }

                /**
                 * <pre>
                 * Event as absolute time.
                 * In Unix time (i.e., number of seconds since January 1st 1970 00:00:00
                 * UTC).
                 * </pre>
                 *
                 * <code>optional int64 time = 2;</code>
                 */
                public Builder clearTime() {
                    bitField0_ = (bitField0_ & ~0x00000002);
                    time_ = 0L;
                    onChanged();
                    return this;
                }

                private int uncertainty_;

                /**
                 * <pre>
                 * If uncertainty is omitted, it is interpreted as unknown.
                 * If the prediction is unknown or too uncertain, the delay (or time) field
                 * should be empty. In such case, the uncertainty field is ignored.
                 * To specify a completely certain prediction, set its uncertainty to 0.
                 * </pre>
                 *
                 * <code>optional int32 uncertainty = 3;</code>
                 */
                public boolean hasUncertainty() {
                    return ((bitField0_ & 0x00000004) != 0);
                }

                /**
                 * <pre>
                 * If uncertainty is omitted, it is interpreted as unknown.
                 * If the prediction is unknown or too uncertain, the delay (or time) field
                 * should be empty. In such case, the uncertainty field is ignored.
                 * To specify a completely certain prediction, set its uncertainty to 0.
                 * </pre>
                 *
                 * <code>optional int32 uncertainty = 3;</code>
                 */
                public int getUncertainty() {
                    return uncertainty_;
                }

                /**
                 * <pre>
                 * If uncertainty is omitted, it is interpreted as unknown.
                 * If the prediction is unknown or too uncertain, the delay (or time) field
                 * should be empty. In such case, the uncertainty field is ignored.
                 * To specify a completely certain prediction, set its uncertainty to 0.
                 * </pre>
                 *
                 * <code>optional int32 uncertainty = 3;</code>
                 */
                public Builder setUncertainty(int value) {
                    bitField0_ |= 0x00000004;
                    uncertainty_ = value;
                    onChanged();
                    return this;
                }

                /**
                 * <pre>
                 * If uncertainty is omitted, it is interpreted as unknown.
                 * If the prediction is unknown or too uncertain, the delay (or time) field
                 * should be empty. In such case, the uncertainty field is ignored.
                 * To specify a completely certain prediction, set its uncertainty to 0.
                 * </pre>
                 *
                 * <code>optional int32 uncertainty = 3;</code>
                 */
                public Builder clearUncertainty() {
                    bitField0_ = (bitField0_ & ~0x00000004);
                    uncertainty_ = 0;
                    onChanged();
                    return this;
                }

                @java.lang.Override
                public final Builder setUnknownFields(
                        final com.google.protobuf.UnknownFieldSet unknownFields) {
                    return super.setUnknownFields(unknownFields);
                }

                @java.lang.Override
                public final Builder mergeUnknownFields(
                        final com.google.protobuf.UnknownFieldSet unknownFields) {
                    return super.mergeUnknownFields(unknownFields);
                }


                // @@protoc_insertion_point(builder_scope:transit_realtime.TripUpdate.StopTimeEvent)
            }

            // @@protoc_insertion_point(class_scope:transit_realtime.TripUpdate.StopTimeEvent)
            private static final GtfsRealtime.TripUpdate.StopTimeEvent DEFAULT_INSTANCE;

            static {
                DEFAULT_INSTANCE = new GtfsRealtime.TripUpdate.StopTimeEvent();
            }

            public static GtfsRealtime.TripUpdate.StopTimeEvent getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            @java.lang.Deprecated
            public static final com.google.protobuf.Parser<StopTimeEvent>
                    PARSER = new com.google.protobuf.AbstractParser<StopTimeEvent>() {
                @java.lang.Override
                public StopTimeEvent parsePartialFrom(
                        com.google.protobuf.CodedInputStream input,
                        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                        throws com.google.protobuf.InvalidProtocolBufferException {
                    return new StopTimeEvent(input, extensionRegistry);
                }
            };

            public static com.google.protobuf.Parser<StopTimeEvent> parser() {
                return PARSER;
            }

            @java.lang.Override
            public com.google.protobuf.Parser<StopTimeEvent> getParserForType() {
                return PARSER;
            }

            @java.lang.Override
            public GtfsRealtime.TripUpdate.StopTimeEvent getDefaultInstanceForType() {
                return DEFAULT_INSTANCE;
            }

        }

        public interface StopTimeUpdateOrBuilder extends
                // @@protoc_insertion_point(interface_extends:transit_realtime.TripUpdate.StopTimeUpdate)
                com.google.protobuf.GeneratedMessageV3.
                        ExtendableMessageOrBuilder<StopTimeUpdate> {

            /**
             * <pre>
             * Must be the same as in stop_times.txt in the corresponding GTFS feed.
             * </pre>
             *
             * <code>optional uint32 stop_sequence = 1;</code>
             */
            boolean hasStopSequence();

            /**
             * <pre>
             * Must be the same as in stop_times.txt in the corresponding GTFS feed.
             * </pre>
             *
             * <code>optional uint32 stop_sequence = 1;</code>
             */
            int getStopSequence();

            /**
             * <pre>
             * Must be the same as in stops.txt in the corresponding GTFS feed.
             * </pre>
             *
             * <code>optional string stop_id = 4;</code>
             */
            boolean hasStopId();

            /**
             * <pre>
             * Must be the same as in stops.txt in the corresponding GTFS feed.
             * </pre>
             *
             * <code>optional string stop_id = 4;</code>
             */
            java.lang.String getStopId();

            /**
             * <pre>
             * Must be the same as in stops.txt in the corresponding GTFS feed.
             * </pre>
             *
             * <code>optional string stop_id = 4;</code>
             */
            com.google.protobuf.ByteString
            getStopIdBytes();

            /**
             * <code>optional .transit_realtime.TripUpdate.StopTimeEvent arrival = 2;</code>
             */
            boolean hasArrival();

            /**
             * <code>optional .transit_realtime.TripUpdate.StopTimeEvent arrival = 2;</code>
             */
            GtfsRealtime.TripUpdate.StopTimeEvent getArrival();

            /**
             * <code>optional .transit_realtime.TripUpdate.StopTimeEvent arrival = 2;</code>
             */
            GtfsRealtime.TripUpdate.StopTimeEventOrBuilder getArrivalOrBuilder();

            /**
             * <code>optional .transit_realtime.TripUpdate.StopTimeEvent departure = 3;</code>
             */
            boolean hasDeparture();

            /**
             * <code>optional .transit_realtime.TripUpdate.StopTimeEvent departure = 3;</code>
             */
            GtfsRealtime.TripUpdate.StopTimeEvent getDeparture();

            /**
             * <code>optional .transit_realtime.TripUpdate.StopTimeEvent departure = 3;</code>
             */
            GtfsRealtime.TripUpdate.StopTimeEventOrBuilder getDepartureOrBuilder();

            /**
             * <code>optional .transit_realtime.TripUpdate.StopTimeUpdate.ScheduleRelationship schedule_relationship = 5 [default = SCHEDULED];</code>
             */
            boolean hasScheduleRelationship();

            /**
             * <code>optional .transit_realtime.TripUpdate.StopTimeUpdate.ScheduleRelationship schedule_relationship = 5 [default = SCHEDULED];</code>
             */
            GtfsRealtime.TripUpdate.StopTimeUpdate.ScheduleRelationship getScheduleRelationship();
        }

        /**
         * <pre>
         * Realtime update for arrival and/or departure events for a given stop on a
         * trip. Updates can be supplied for both past and future events.
         * The producer is allowed, although not required, to drop past events.
         * </pre>
         * <p>
         * Protobuf type {@code transit_realtime.TripUpdate.StopTimeUpdate}
         */
        public static final class StopTimeUpdate extends
                com.google.protobuf.GeneratedMessageV3.ExtendableMessage<
                        StopTimeUpdate> implements
                // @@protoc_insertion_point(message_implements:transit_realtime.TripUpdate.StopTimeUpdate)
                StopTimeUpdateOrBuilder {
            private static final long serialVersionUID = 0L;

            // Use StopTimeUpdate.newBuilder() to construct.
            private StopTimeUpdate(com.google.protobuf.GeneratedMessageV3.ExtendableBuilder<GtfsRealtime.TripUpdate.StopTimeUpdate, ?> builder) {
                super(builder);
            }

            private StopTimeUpdate() {
                stopId_ = "";
                scheduleRelationship_ = 0;
            }

            @java.lang.Override
            @SuppressWarnings({"unused"})
            protected java.lang.Object newInstance(
                    UnusedPrivateParameter unused) {
                return new StopTimeUpdate();
            }

            @java.lang.Override
            public final com.google.protobuf.UnknownFieldSet
            getUnknownFields() {
                return this.unknownFields;
            }

            private StopTimeUpdate(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                this();
                if (extensionRegistry == null) {
                    throw new java.lang.NullPointerException();
                }
                int mutable_bitField0_ = 0;
                com.google.protobuf.UnknownFieldSet.Builder unknownFields =
                        com.google.protobuf.UnknownFieldSet.newBuilder();
                try {
                    boolean done = false;
                    while (!done) {
                        int tag = input.readTag();
                        switch (tag) {
                            case 0:
                                done = true;
                                break;
                            case 8: {
                                bitField0_ |= 0x00000001;
                                stopSequence_ = input.readUInt32();
                                break;
                            }
                            case 18: {
                                GtfsRealtime.TripUpdate.StopTimeEvent.Builder subBuilder = null;
                                if (((bitField0_ & 0x00000004) != 0)) {
                                    subBuilder = arrival_.toBuilder();
                                }
                                arrival_ = input.readMessage(GtfsRealtime.TripUpdate.StopTimeEvent.PARSER, extensionRegistry);
                                if (subBuilder != null) {
                                    subBuilder.mergeFrom(arrival_);
                                    arrival_ = subBuilder.buildPartial();
                                }
                                bitField0_ |= 0x00000004;
                                break;
                            }
                            case 26: {
                                GtfsRealtime.TripUpdate.StopTimeEvent.Builder subBuilder = null;
                                if (((bitField0_ & 0x00000008) != 0)) {
                                    subBuilder = departure_.toBuilder();
                                }
                                departure_ = input.readMessage(GtfsRealtime.TripUpdate.StopTimeEvent.PARSER, extensionRegistry);
                                if (subBuilder != null) {
                                    subBuilder.mergeFrom(departure_);
                                    departure_ = subBuilder.buildPartial();
                                }
                                bitField0_ |= 0x00000008;
                                break;
                            }
                            case 34: {
                                com.google.protobuf.ByteString bs = input.readBytes();
                                bitField0_ |= 0x00000002;
                                stopId_ = bs;
                                break;
                            }
                            case 40: {
                                int rawValue = input.readEnum();
                                @SuppressWarnings("deprecation")
                                GtfsRealtime.TripUpdate.StopTimeUpdate.ScheduleRelationship value = GtfsRealtime.TripUpdate.StopTimeUpdate.ScheduleRelationship.valueOf(rawValue);
                                if (value == null) {
                                    unknownFields.mergeVarintField(5, rawValue);
                                } else {
                                    bitField0_ |= 0x00000010;
                                    scheduleRelationship_ = rawValue;
                                }
                                break;
                            }
                            default: {
                                if (!parseUnknownField(
                                        input, unknownFields, extensionRegistry, tag)) {
                                    done = true;
                                }
                                break;
                            }
                        }
                    }
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (java.io.IOException e) {
                    throw new com.google.protobuf.InvalidProtocolBufferException(
                            e).setUnfinishedMessage(this);
                } finally {
                    this.unknownFields = unknownFields.build();
                    makeExtensionsImmutable();
                }
            }

            public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
                return GtfsRealtime.internal_static_transit_realtime_TripUpdate_StopTimeUpdate_descriptor;
            }

            @java.lang.Override
            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internalGetFieldAccessorTable() {
                return GtfsRealtime.internal_static_transit_realtime_TripUpdate_StopTimeUpdate_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                GtfsRealtime.TripUpdate.StopTimeUpdate.class, GtfsRealtime.TripUpdate.StopTimeUpdate.Builder.class);
            }

            /**
             * <pre>
             * The relation between this StopTime and the static schedule.
             * </pre>
             * <p>
             * Protobuf enum {@code transit_realtime.TripUpdate.StopTimeUpdate.ScheduleRelationship}
             */
            public enum ScheduleRelationship
                    implements com.google.protobuf.ProtocolMessageEnum {
                /**
                 * <pre>
                 * The vehicle is proceeding in accordance with its static schedule of
                 * stops, although not necessarily according to the times of the schedule.
                 * At least one of arrival and departure must be provided. If the schedule
                 * for this stop contains both arrival and departure times then so must
                 * this update.
                 * </pre>
                 *
                 * <code>SCHEDULED = 0;</code>
                 */
                SCHEDULED(0),
                /**
                 * <pre>
                 * The stop is skipped, i.e., the vehicle will not stop at this stop.
                 * Arrival and departure are optional.
                 * </pre>
                 *
                 * <code>SKIPPED = 1;</code>
                 */
                SKIPPED(1),
                /**
                 * <pre>
                 * No data is given for this stop. The main intention for this value is to
                 * give the predictions only for part of a trip, i.e., if the last update
                 * for a trip has a NO_DATA specifier, then StopTimes for the rest of the
                 * stops in the trip are considered to be unspecified as well.
                 * Neither arrival nor departure should be supplied.
                 * </pre>
                 *
                 * <code>NO_DATA = 2;</code>
                 */
                NO_DATA(2),
                ;

                /**
                 * <pre>
                 * The vehicle is proceeding in accordance with its static schedule of
                 * stops, although not necessarily according to the times of the schedule.
                 * At least one of arrival and departure must be provided. If the schedule
                 * for this stop contains both arrival and departure times then so must
                 * this update.
                 * </pre>
                 *
                 * <code>SCHEDULED = 0;</code>
                 */
                public static final int SCHEDULED_VALUE = 0;
                /**
                 * <pre>
                 * The stop is skipped, i.e., the vehicle will not stop at this stop.
                 * Arrival and departure are optional.
                 * </pre>
                 *
                 * <code>SKIPPED = 1;</code>
                 */
                public static final int SKIPPED_VALUE = 1;
                /**
                 * <pre>
                 * No data is given for this stop. The main intention for this value is to
                 * give the predictions only for part of a trip, i.e., if the last update
                 * for a trip has a NO_DATA specifier, then StopTimes for the rest of the
                 * stops in the trip are considered to be unspecified as well.
                 * Neither arrival nor departure should be supplied.
                 * </pre>
                 *
                 * <code>NO_DATA = 2;</code>
                 */
                public static final int NO_DATA_VALUE = 2;


                public final int getNumber() {
                    return value;
                }

                /**
                 * @deprecated Use {@link #forNumber(int)} instead.
                 */
                @java.lang.Deprecated
                public static ScheduleRelationship valueOf(int value) {
                    return forNumber(value);
                }

                public static ScheduleRelationship forNumber(int value) {
                    switch (value) {
                        case 0:
                            return SCHEDULED;
                        case 1:
                            return SKIPPED;
                        case 2:
                            return NO_DATA;
                        default:
                            return null;
                    }
                }

                public static com.google.protobuf.Internal.EnumLiteMap<ScheduleRelationship>
                internalGetValueMap() {
                    return internalValueMap;
                }

                private static final com.google.protobuf.Internal.EnumLiteMap<
                        ScheduleRelationship> internalValueMap =
                        new com.google.protobuf.Internal.EnumLiteMap<ScheduleRelationship>() {
                            public ScheduleRelationship findValueByNumber(int number) {
                                return ScheduleRelationship.forNumber(number);
                            }
                        };

                public final com.google.protobuf.Descriptors.EnumValueDescriptor
                getValueDescriptor() {
                    return getDescriptor().getValues().get(ordinal());
                }

                public final com.google.protobuf.Descriptors.EnumDescriptor
                getDescriptorForType() {
                    return getDescriptor();
                }

                public static final com.google.protobuf.Descriptors.EnumDescriptor
                getDescriptor() {
                    return GtfsRealtime.TripUpdate.StopTimeUpdate.getDescriptor().getEnumTypes().get(0);
                }

                private static final ScheduleRelationship[] VALUES = values();

                public static ScheduleRelationship valueOf(
                        com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
                    if (desc.getType() != getDescriptor()) {
                        throw new java.lang.IllegalArgumentException(
                                "EnumValueDescriptor is not for this type.");
                    }
                    return VALUES[desc.getIndex()];
                }

                private final int value;

                private ScheduleRelationship(int value) {
                    this.value = value;
                }

                // @@protoc_insertion_point(enum_scope:transit_realtime.TripUpdate.StopTimeUpdate.ScheduleRelationship)
            }

            private int bitField0_;
            public static final int STOP_SEQUENCE_FIELD_NUMBER = 1;
            private int stopSequence_;

            /**
             * <pre>
             * Must be the same as in stop_times.txt in the corresponding GTFS feed.
             * </pre>
             *
             * <code>optional uint32 stop_sequence = 1;</code>
             */
            public boolean hasStopSequence() {
                return ((bitField0_ & 0x00000001) != 0);
            }

            /**
             * <pre>
             * Must be the same as in stop_times.txt in the corresponding GTFS feed.
             * </pre>
             *
             * <code>optional uint32 stop_sequence = 1;</code>
             */
            public int getStopSequence() {
                return stopSequence_;
            }

            public static final int STOP_ID_FIELD_NUMBER = 4;
            private volatile java.lang.Object stopId_;

            /**
             * <pre>
             * Must be the same as in stops.txt in the corresponding GTFS feed.
             * </pre>
             *
             * <code>optional string stop_id = 4;</code>
             */
            public boolean hasStopId() {
                return ((bitField0_ & 0x00000002) != 0);
            }

            /**
             * <pre>
             * Must be the same as in stops.txt in the corresponding GTFS feed.
             * </pre>
             *
             * <code>optional string stop_id = 4;</code>
             */
            public java.lang.String getStopId() {
                java.lang.Object ref = stopId_;
                if (ref instanceof java.lang.String) {
                    return (java.lang.String) ref;
                } else {
                    com.google.protobuf.ByteString bs =
                            (com.google.protobuf.ByteString) ref;
                    java.lang.String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        stopId_ = s;
                    }
                    return s;
                }
            }

            /**
             * <pre>
             * Must be the same as in stops.txt in the corresponding GTFS feed.
             * </pre>
             *
             * <code>optional string stop_id = 4;</code>
             */
            public com.google.protobuf.ByteString
            getStopIdBytes() {
                java.lang.Object ref = stopId_;
                if (ref instanceof java.lang.String) {
                    com.google.protobuf.ByteString b =
                            com.google.protobuf.ByteString.copyFromUtf8(
                                    (java.lang.String) ref);
                    stopId_ = b;
                    return b;
                } else {
                    return (com.google.protobuf.ByteString) ref;
                }
            }

            public static final int ARRIVAL_FIELD_NUMBER = 2;
            private GtfsRealtime.TripUpdate.StopTimeEvent arrival_;

            /**
             * <code>optional .transit_realtime.TripUpdate.StopTimeEvent arrival = 2;</code>
             */
            public boolean hasArrival() {
                return ((bitField0_ & 0x00000004) != 0);
            }

            /**
             * <code>optional .transit_realtime.TripUpdate.StopTimeEvent arrival = 2;</code>
             */
            public GtfsRealtime.TripUpdate.StopTimeEvent getArrival() {
                return arrival_ == null ? GtfsRealtime.TripUpdate.StopTimeEvent.getDefaultInstance() : arrival_;
            }

            /**
             * <code>optional .transit_realtime.TripUpdate.StopTimeEvent arrival = 2;</code>
             */
            public GtfsRealtime.TripUpdate.StopTimeEventOrBuilder getArrivalOrBuilder() {
                return arrival_ == null ? GtfsRealtime.TripUpdate.StopTimeEvent.getDefaultInstance() : arrival_;
            }

            public static final int DEPARTURE_FIELD_NUMBER = 3;
            private GtfsRealtime.TripUpdate.StopTimeEvent departure_;

            /**
             * <code>optional .transit_realtime.TripUpdate.StopTimeEvent departure = 3;</code>
             */
            public boolean hasDeparture() {
                return ((bitField0_ & 0x00000008) != 0);
            }

            /**
             * <code>optional .transit_realtime.TripUpdate.StopTimeEvent departure = 3;</code>
             */
            public GtfsRealtime.TripUpdate.StopTimeEvent getDeparture() {
                return departure_ == null ? GtfsRealtime.TripUpdate.StopTimeEvent.getDefaultInstance() : departure_;
            }

            /**
             * <code>optional .transit_realtime.TripUpdate.StopTimeEvent departure = 3;</code>
             */
            public GtfsRealtime.TripUpdate.StopTimeEventOrBuilder getDepartureOrBuilder() {
                return departure_ == null ? GtfsRealtime.TripUpdate.StopTimeEvent.getDefaultInstance() : departure_;
            }

            public static final int SCHEDULE_RELATIONSHIP_FIELD_NUMBER = 5;
            private int scheduleRelationship_;

            /**
             * <code>optional .transit_realtime.TripUpdate.StopTimeUpdate.ScheduleRelationship schedule_relationship = 5 [default = SCHEDULED];</code>
             */
            public boolean hasScheduleRelationship() {
                return ((bitField0_ & 0x00000010) != 0);
            }

            /**
             * <code>optional .transit_realtime.TripUpdate.StopTimeUpdate.ScheduleRelationship schedule_relationship = 5 [default = SCHEDULED];</code>
             */
            public GtfsRealtime.TripUpdate.StopTimeUpdate.ScheduleRelationship getScheduleRelationship() {
                @SuppressWarnings("deprecation")
                GtfsRealtime.TripUpdate.StopTimeUpdate.ScheduleRelationship result = GtfsRealtime.TripUpdate.StopTimeUpdate.ScheduleRelationship.valueOf(scheduleRelationship_);
                return result == null ? GtfsRealtime.TripUpdate.StopTimeUpdate.ScheduleRelationship.SCHEDULED : result;
            }

            private byte memoizedIsInitialized = -1;

            @java.lang.Override
            public final boolean isInitialized() {
                byte isInitialized = memoizedIsInitialized;
                if (isInitialized == 1) return true;
                if (isInitialized == 0) return false;

                if (hasArrival()) {
                    if (!getArrival().isInitialized()) {
                        memoizedIsInitialized = 0;
                        return false;
                    }
                }
                if (hasDeparture()) {
                    if (!getDeparture().isInitialized()) {
                        memoizedIsInitialized = 0;
                        return false;
                    }
                }
                if (!extensionsAreInitialized()) {
                    memoizedIsInitialized = 0;
                    return false;
                }
                memoizedIsInitialized = 1;
                return true;
            }

            @java.lang.Override
            public void writeTo(com.google.protobuf.CodedOutputStream output)
                    throws java.io.IOException {
                com.google.protobuf.GeneratedMessageV3
                        .ExtendableMessage<GtfsRealtime.TripUpdate.StopTimeUpdate>.ExtensionWriter
                        extensionWriter = newExtensionWriter();
                if (((bitField0_ & 0x00000001) != 0)) {
                    output.writeUInt32(1, stopSequence_);
                }
                if (((bitField0_ & 0x00000004) != 0)) {
                    output.writeMessage(2, getArrival());
                }
                if (((bitField0_ & 0x00000008) != 0)) {
                    output.writeMessage(3, getDeparture());
                }
                if (((bitField0_ & 0x00000002) != 0)) {
                    com.google.protobuf.GeneratedMessageV3.writeString(output, 4, stopId_);
                }
                if (((bitField0_ & 0x00000010) != 0)) {
                    output.writeEnum(5, scheduleRelationship_);
                }
                extensionWriter.writeUntil(2000, output);
                unknownFields.writeTo(output);
            }

            @java.lang.Override
            public int getSerializedSize() {
                int size = memoizedSize;
                if (size != -1) return size;

                size = 0;
                if (((bitField0_ & 0x00000001) != 0)) {
                    size += com.google.protobuf.CodedOutputStream
                            .computeUInt32Size(1, stopSequence_);
                }
                if (((bitField0_ & 0x00000004) != 0)) {
                    size += com.google.protobuf.CodedOutputStream
                            .computeMessageSize(2, getArrival());
                }
                if (((bitField0_ & 0x00000008) != 0)) {
                    size += com.google.protobuf.CodedOutputStream
                            .computeMessageSize(3, getDeparture());
                }
                if (((bitField0_ & 0x00000002) != 0)) {
                    size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, stopId_);
                }
                if (((bitField0_ & 0x00000010) != 0)) {
                    size += com.google.protobuf.CodedOutputStream
                            .computeEnumSize(5, scheduleRelationship_);
                }
                size += extensionsSerializedSize();
                size += unknownFields.getSerializedSize();
                memoizedSize = size;
                return size;
            }

            @java.lang.Override
            public boolean equals(final java.lang.Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof GtfsRealtime.TripUpdate.StopTimeUpdate)) {
                    return super.equals(obj);
                }
                GtfsRealtime.TripUpdate.StopTimeUpdate other = (GtfsRealtime.TripUpdate.StopTimeUpdate) obj;

                if (hasStopSequence() != other.hasStopSequence()) return false;
                if (hasStopSequence()) {
                    if (getStopSequence()
                            != other.getStopSequence()) return false;
                }
                if (hasStopId() != other.hasStopId()) return false;
                if (hasStopId()) {
                    if (!getStopId()
                            .equals(other.getStopId())) return false;
                }
                if (hasArrival() != other.hasArrival()) return false;
                if (hasArrival()) {
                    if (!getArrival()
                            .equals(other.getArrival())) return false;
                }
                if (hasDeparture() != other.hasDeparture()) return false;
                if (hasDeparture()) {
                    if (!getDeparture()
                            .equals(other.getDeparture())) return false;
                }
                if (hasScheduleRelationship() != other.hasScheduleRelationship()) return false;
                if (hasScheduleRelationship()) {
                    if (scheduleRelationship_ != other.scheduleRelationship_) return false;
                }
                if (!unknownFields.equals(other.unknownFields)) return false;
                if (!getExtensionFields().equals(other.getExtensionFields()))
                    return false;
                return true;
            }

            @java.lang.Override
            public int hashCode() {
                if (memoizedHashCode != 0) {
                    return memoizedHashCode;
                }
                int hash = 41;
                hash = (19 * hash) + getDescriptor().hashCode();
                if (hasStopSequence()) {
                    hash = (37 * hash) + STOP_SEQUENCE_FIELD_NUMBER;
                    hash = (53 * hash) + getStopSequence();
                }
                if (hasStopId()) {
                    hash = (37 * hash) + STOP_ID_FIELD_NUMBER;
                    hash = (53 * hash) + getStopId().hashCode();
                }
                if (hasArrival()) {
                    hash = (37 * hash) + ARRIVAL_FIELD_NUMBER;
                    hash = (53 * hash) + getArrival().hashCode();
                }
                if (hasDeparture()) {
                    hash = (37 * hash) + DEPARTURE_FIELD_NUMBER;
                    hash = (53 * hash) + getDeparture().hashCode();
                }
                if (hasScheduleRelationship()) {
                    hash = (37 * hash) + SCHEDULE_RELATIONSHIP_FIELD_NUMBER;
                    hash = (53 * hash) + scheduleRelationship_;
                }
                hash = hashFields(hash, getExtensionFields());
                hash = (29 * hash) + unknownFields.hashCode();
                memoizedHashCode = hash;
                return hash;
            }

            public static GtfsRealtime.TripUpdate.StopTimeUpdate parseFrom(
                    java.nio.ByteBuffer data)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return PARSER.parseFrom(data);
            }

            public static GtfsRealtime.TripUpdate.StopTimeUpdate parseFrom(
                    java.nio.ByteBuffer data,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return PARSER.parseFrom(data, extensionRegistry);
            }

            public static GtfsRealtime.TripUpdate.StopTimeUpdate parseFrom(
                    com.google.protobuf.ByteString data)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return PARSER.parseFrom(data);
            }

            public static GtfsRealtime.TripUpdate.StopTimeUpdate parseFrom(
                    com.google.protobuf.ByteString data,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return PARSER.parseFrom(data, extensionRegistry);
            }

            public static GtfsRealtime.TripUpdate.StopTimeUpdate parseFrom(byte[] data)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return PARSER.parseFrom(data);
            }

            public static GtfsRealtime.TripUpdate.StopTimeUpdate parseFrom(
                    byte[] data,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return PARSER.parseFrom(data, extensionRegistry);
            }

            public static GtfsRealtime.TripUpdate.StopTimeUpdate parseFrom(java.io.InputStream input)
                    throws java.io.IOException {
                return com.google.protobuf.GeneratedMessageV3
                        .parseWithIOException(PARSER, input);
            }

            public static GtfsRealtime.TripUpdate.StopTimeUpdate parseFrom(
                    java.io.InputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                return com.google.protobuf.GeneratedMessageV3
                        .parseWithIOException(PARSER, input, extensionRegistry);
            }

            public static GtfsRealtime.TripUpdate.StopTimeUpdate parseDelimitedFrom(java.io.InputStream input)
                    throws java.io.IOException {
                return com.google.protobuf.GeneratedMessageV3
                        .parseDelimitedWithIOException(PARSER, input);
            }

            public static GtfsRealtime.TripUpdate.StopTimeUpdate parseDelimitedFrom(
                    java.io.InputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                return com.google.protobuf.GeneratedMessageV3
                        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
            }

            public static GtfsRealtime.TripUpdate.StopTimeUpdate parseFrom(
                    com.google.protobuf.CodedInputStream input)
                    throws java.io.IOException {
                return com.google.protobuf.GeneratedMessageV3
                        .parseWithIOException(PARSER, input);
            }

            public static GtfsRealtime.TripUpdate.StopTimeUpdate parseFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                return com.google.protobuf.GeneratedMessageV3
                        .parseWithIOException(PARSER, input, extensionRegistry);
            }

            @java.lang.Override
            public Builder newBuilderForType() {
                return newBuilder();
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.toBuilder();
            }

            public static Builder newBuilder(GtfsRealtime.TripUpdate.StopTimeUpdate prototype) {
                return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
            }

            @java.lang.Override
            public Builder toBuilder() {
                return this == DEFAULT_INSTANCE
                        ? new Builder() : new Builder().mergeFrom(this);
            }

            @java.lang.Override
            protected Builder newBuilderForType(
                    com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
                Builder builder = new Builder(parent);
                return builder;
            }

            /**
             * <pre>
             * Realtime update for arrival and/or departure events for a given stop on a
             * trip. Updates can be supplied for both past and future events.
             * The producer is allowed, although not required, to drop past events.
             * </pre>
             * <p>
             * Protobuf type {@code transit_realtime.TripUpdate.StopTimeUpdate}
             */
            public static final class Builder extends
                    com.google.protobuf.GeneratedMessageV3.ExtendableBuilder<
                            GtfsRealtime.TripUpdate.StopTimeUpdate, Builder> implements
                    // @@protoc_insertion_point(builder_implements:transit_realtime.TripUpdate.StopTimeUpdate)
                    GtfsRealtime.TripUpdate.StopTimeUpdateOrBuilder {
                public static final com.google.protobuf.Descriptors.Descriptor
                getDescriptor() {
                    return GtfsRealtime.internal_static_transit_realtime_TripUpdate_StopTimeUpdate_descriptor;
                }

                @java.lang.Override
                protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
                internalGetFieldAccessorTable() {
                    return GtfsRealtime.internal_static_transit_realtime_TripUpdate_StopTimeUpdate_fieldAccessorTable
                            .ensureFieldAccessorsInitialized(
                                    GtfsRealtime.TripUpdate.StopTimeUpdate.class, GtfsRealtime.TripUpdate.StopTimeUpdate.Builder.class);
                }

                // Construct using GtfsRealtime.TripUpdate.StopTimeUpdate.newBuilder()
                private Builder() {
                    maybeForceBuilderInitialization();
                }

                private Builder(
                        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
                    super(parent);
                    maybeForceBuilderInitialization();
                }

                private void maybeForceBuilderInitialization() {
                    if (com.google.protobuf.GeneratedMessageV3
                            .alwaysUseFieldBuilders) {
                        getArrivalFieldBuilder();
                        getDepartureFieldBuilder();
                    }
                }

                @java.lang.Override
                public Builder clear() {
                    super.clear();
                    stopSequence_ = 0;
                    bitField0_ = (bitField0_ & ~0x00000001);
                    stopId_ = "";
                    bitField0_ = (bitField0_ & ~0x00000002);
                    if (arrivalBuilder_ == null) {
                        arrival_ = null;
                    } else {
                        arrivalBuilder_.clear();
                    }
                    bitField0_ = (bitField0_ & ~0x00000004);
                    if (departureBuilder_ == null) {
                        departure_ = null;
                    } else {
                        departureBuilder_.clear();
                    }
                    bitField0_ = (bitField0_ & ~0x00000008);
                    scheduleRelationship_ = 0;
                    bitField0_ = (bitField0_ & ~0x00000010);
                    return this;
                }

                @java.lang.Override
                public com.google.protobuf.Descriptors.Descriptor
                getDescriptorForType() {
                    return GtfsRealtime.internal_static_transit_realtime_TripUpdate_StopTimeUpdate_descriptor;
                }

                @java.lang.Override
                public GtfsRealtime.TripUpdate.StopTimeUpdate getDefaultInstanceForType() {
                    return GtfsRealtime.TripUpdate.StopTimeUpdate.getDefaultInstance();
                }

                @java.lang.Override
                public GtfsRealtime.TripUpdate.StopTimeUpdate build() {
                    GtfsRealtime.TripUpdate.StopTimeUpdate result = buildPartial();
                    if (!result.isInitialized()) {
                        throw newUninitializedMessageException(result);
                    }
                    return result;
                }

                @java.lang.Override
                public GtfsRealtime.TripUpdate.StopTimeUpdate buildPartial() {
                    GtfsRealtime.TripUpdate.StopTimeUpdate result = new GtfsRealtime.TripUpdate.StopTimeUpdate(this);
                    int from_bitField0_ = bitField0_;
                    int to_bitField0_ = 0;
                    if (((from_bitField0_ & 0x00000001) != 0)) {
                        result.stopSequence_ = stopSequence_;
                        to_bitField0_ |= 0x00000001;
                    }
                    if (((from_bitField0_ & 0x00000002) != 0)) {
                        to_bitField0_ |= 0x00000002;
                    }
                    result.stopId_ = stopId_;
                    if (((from_bitField0_ & 0x00000004) != 0)) {
                        if (arrivalBuilder_ == null) {
                            result.arrival_ = arrival_;
                        } else {
                            result.arrival_ = arrivalBuilder_.build();
                        }
                        to_bitField0_ |= 0x00000004;
                    }
                    if (((from_bitField0_ & 0x00000008) != 0)) {
                        if (departureBuilder_ == null) {
                            result.departure_ = departure_;
                        } else {
                            result.departure_ = departureBuilder_.build();
                        }
                        to_bitField0_ |= 0x00000008;
                    }
                    if (((from_bitField0_ & 0x00000010) != 0)) {
                        to_bitField0_ |= 0x00000010;
                    }
                    result.scheduleRelationship_ = scheduleRelationship_;
                    result.bitField0_ = to_bitField0_;
                    onBuilt();
                    return result;
                }

                @java.lang.Override
                public Builder clone() {
                    return super.clone();
                }

                @java.lang.Override
                public Builder setField(
                        com.google.protobuf.Descriptors.FieldDescriptor field,
                        java.lang.Object value) {
                    return super.setField(field, value);
                }

                @java.lang.Override
                public Builder clearField(
                        com.google.protobuf.Descriptors.FieldDescriptor field) {
                    return super.clearField(field);
                }

                @java.lang.Override
                public Builder clearOneof(
                        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
                    return super.clearOneof(oneof);
                }

                @java.lang.Override
                public Builder setRepeatedField(
                        com.google.protobuf.Descriptors.FieldDescriptor field,
                        int index, java.lang.Object value) {
                    return super.setRepeatedField(field, index, value);
                }

                @java.lang.Override
                public Builder addRepeatedField(
                        com.google.protobuf.Descriptors.FieldDescriptor field,
                        java.lang.Object value) {
                    return super.addRepeatedField(field, value);
                }

                @java.lang.Override
                public <Type> Builder setExtension(
                        com.google.protobuf.GeneratedMessage.GeneratedExtension<
                                GtfsRealtime.TripUpdate.StopTimeUpdate, Type> extension,
                        Type value) {
                    return super.setExtension(extension, value);
                }

                @java.lang.Override
                public <Type> Builder setExtension(
                        com.google.protobuf.GeneratedMessage.GeneratedExtension<
                                GtfsRealtime.TripUpdate.StopTimeUpdate, java.util.List<Type>> extension,
                        int index, Type value) {
                    return super.setExtension(extension, index, value);
                }

                @java.lang.Override
                public <Type> Builder addExtension(
                        com.google.protobuf.GeneratedMessage.GeneratedExtension<
                                GtfsRealtime.TripUpdate.StopTimeUpdate, java.util.List<Type>> extension,
                        Type value) {
                    return super.addExtension(extension, value);
                }

                @java.lang.Override
                public <Type> Builder clearExtension(
                        com.google.protobuf.GeneratedMessage.GeneratedExtension<
                                GtfsRealtime.TripUpdate.StopTimeUpdate, ?> extension) {
                    return super.clearExtension(extension);
                }

                @java.lang.Override
                public Builder mergeFrom(com.google.protobuf.Message other) {
                    if (other instanceof GtfsRealtime.TripUpdate.StopTimeUpdate) {
                        return mergeFrom((GtfsRealtime.TripUpdate.StopTimeUpdate) other);
                    } else {
                        super.mergeFrom(other);
                        return this;
                    }
                }

                public Builder mergeFrom(GtfsRealtime.TripUpdate.StopTimeUpdate other) {
                    if (other == GtfsRealtime.TripUpdate.StopTimeUpdate.getDefaultInstance()) return this;
                    if (other.hasStopSequence()) {
                        setStopSequence(other.getStopSequence());
                    }
                    if (other.hasStopId()) {
                        bitField0_ |= 0x00000002;
                        stopId_ = other.stopId_;
                        onChanged();
                    }
                    if (other.hasArrival()) {
                        mergeArrival(other.getArrival());
                    }
                    if (other.hasDeparture()) {
                        mergeDeparture(other.getDeparture());
                    }
                    if (other.hasScheduleRelationship()) {
                        setScheduleRelationship(other.getScheduleRelationship());
                    }
                    this.mergeExtensionFields(other);
                    this.mergeUnknownFields(other.unknownFields);
                    onChanged();
                    return this;
                }

                @java.lang.Override
                public final boolean isInitialized() {
                    if (hasArrival()) {
                        if (!getArrival().isInitialized()) {
                            return false;
                        }
                    }
                    if (hasDeparture()) {
                        if (!getDeparture().isInitialized()) {
                            return false;
                        }
                    }
                    if (!extensionsAreInitialized()) {
                        return false;
                    }
                    return true;
                }

                @java.lang.Override
                public Builder mergeFrom(
                        com.google.protobuf.CodedInputStream input,
                        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                        throws java.io.IOException {
                    GtfsRealtime.TripUpdate.StopTimeUpdate parsedMessage = null;
                    try {
                        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                        parsedMessage = (GtfsRealtime.TripUpdate.StopTimeUpdate) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    } finally {
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                    }
                    return this;
                }

                private int bitField0_;

                private int stopSequence_;

                /**
                 * <pre>
                 * Must be the same as in stop_times.txt in the corresponding GTFS feed.
                 * </pre>
                 *
                 * <code>optional uint32 stop_sequence = 1;</code>
                 */
                public boolean hasStopSequence() {
                    return ((bitField0_ & 0x00000001) != 0);
                }

                /**
                 * <pre>
                 * Must be the same as in stop_times.txt in the corresponding GTFS feed.
                 * </pre>
                 *
                 * <code>optional uint32 stop_sequence = 1;</code>
                 */
                public int getStopSequence() {
                    return stopSequence_;
                }

                /**
                 * <pre>
                 * Must be the same as in stop_times.txt in the corresponding GTFS feed.
                 * </pre>
                 *
                 * <code>optional uint32 stop_sequence = 1;</code>
                 */
                public Builder setStopSequence(int value) {
                    bitField0_ |= 0x00000001;
                    stopSequence_ = value;
                    onChanged();
                    return this;
                }

                /**
                 * <pre>
                 * Must be the same as in stop_times.txt in the corresponding GTFS feed.
                 * </pre>
                 *
                 * <code>optional uint32 stop_sequence = 1;</code>
                 */
                public Builder clearStopSequence() {
                    bitField0_ = (bitField0_ & ~0x00000001);
                    stopSequence_ = 0;
                    onChanged();
                    return this;
                }

                private java.lang.Object stopId_ = "";

                /**
                 * <pre>
                 * Must be the same as in stops.txt in the corresponding GTFS feed.
                 * </pre>
                 *
                 * <code>optional string stop_id = 4;</code>
                 */
                public boolean hasStopId() {
                    return ((bitField0_ & 0x00000002) != 0);
                }

                /**
                 * <pre>
                 * Must be the same as in stops.txt in the corresponding GTFS feed.
                 * </pre>
                 *
                 * <code>optional string stop_id = 4;</code>
                 */
                public java.lang.String getStopId() {
                    java.lang.Object ref = stopId_;
                    if (!(ref instanceof java.lang.String)) {
                        com.google.protobuf.ByteString bs =
                                (com.google.protobuf.ByteString) ref;
                        java.lang.String s = bs.toStringUtf8();
                        if (bs.isValidUtf8()) {
                            stopId_ = s;
                        }
                        return s;
                    } else {
                        return (java.lang.String) ref;
                    }
                }

                /**
                 * <pre>
                 * Must be the same as in stops.txt in the corresponding GTFS feed.
                 * </pre>
                 *
                 * <code>optional string stop_id = 4;</code>
                 */
                public com.google.protobuf.ByteString
                getStopIdBytes() {
                    java.lang.Object ref = stopId_;
                    if (ref instanceof String) {
                        com.google.protobuf.ByteString b =
                                com.google.protobuf.ByteString.copyFromUtf8(
                                        (java.lang.String) ref);
                        stopId_ = b;
                        return b;
                    } else {
                        return (com.google.protobuf.ByteString) ref;
                    }
                }

                /**
                 * <pre>
                 * Must be the same as in stops.txt in the corresponding GTFS feed.
                 * </pre>
                 *
                 * <code>optional string stop_id = 4;</code>
                 */
                public Builder setStopId(
                        java.lang.String value) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    bitField0_ |= 0x00000002;
                    stopId_ = value;
                    onChanged();
                    return this;
                }

                /**
                 * <pre>
                 * Must be the same as in stops.txt in the corresponding GTFS feed.
                 * </pre>
                 *
                 * <code>optional string stop_id = 4;</code>
                 */
                public Builder clearStopId() {
                    bitField0_ = (bitField0_ & ~0x00000002);
                    stopId_ = getDefaultInstance().getStopId();
                    onChanged();
                    return this;
                }

                /**
                 * <pre>
                 * Must be the same as in stops.txt in the corresponding GTFS feed.
                 * </pre>
                 *
                 * <code>optional string stop_id = 4;</code>
                 */
                public Builder setStopIdBytes(
                        com.google.protobuf.ByteString value) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    bitField0_ |= 0x00000002;
                    stopId_ = value;
                    onChanged();
                    return this;
                }

                private GtfsRealtime.TripUpdate.StopTimeEvent arrival_;
                private com.google.protobuf.SingleFieldBuilderV3<
                        GtfsRealtime.TripUpdate.StopTimeEvent, GtfsRealtime.TripUpdate.StopTimeEvent.Builder, GtfsRealtime.TripUpdate.StopTimeEventOrBuilder> arrivalBuilder_;

                /**
                 * <code>optional .transit_realtime.TripUpdate.StopTimeEvent arrival = 2;</code>
                 */
                public boolean hasArrival() {
                    return ((bitField0_ & 0x00000004) != 0);
                }

                /**
                 * <code>optional .transit_realtime.TripUpdate.StopTimeEvent arrival = 2;</code>
                 */
                public GtfsRealtime.TripUpdate.StopTimeEvent getArrival() {
                    if (arrivalBuilder_ == null) {
                        return arrival_ == null ? GtfsRealtime.TripUpdate.StopTimeEvent.getDefaultInstance() : arrival_;
                    } else {
                        return arrivalBuilder_.getMessage();
                    }
                }

                /**
                 * <code>optional .transit_realtime.TripUpdate.StopTimeEvent arrival = 2;</code>
                 */
                public Builder setArrival(GtfsRealtime.TripUpdate.StopTimeEvent value) {
                    if (arrivalBuilder_ == null) {
                        if (value == null) {
                            throw new NullPointerException();
                        }
                        arrival_ = value;
                        onChanged();
                    } else {
                        arrivalBuilder_.setMessage(value);
                    }
                    bitField0_ |= 0x00000004;
                    return this;
                }

                /**
                 * <code>optional .transit_realtime.TripUpdate.StopTimeEvent arrival = 2;</code>
                 */
                public Builder setArrival(
                        GtfsRealtime.TripUpdate.StopTimeEvent.Builder builderForValue) {
                    if (arrivalBuilder_ == null) {
                        arrival_ = builderForValue.build();
                        onChanged();
                    } else {
                        arrivalBuilder_.setMessage(builderForValue.build());
                    }
                    bitField0_ |= 0x00000004;
                    return this;
                }

                /**
                 * <code>optional .transit_realtime.TripUpdate.StopTimeEvent arrival = 2;</code>
                 */
                public Builder mergeArrival(GtfsRealtime.TripUpdate.StopTimeEvent value) {
                    if (arrivalBuilder_ == null) {
                        if (((bitField0_ & 0x00000004) != 0) &&
                                arrival_ != null &&
                                arrival_ != GtfsRealtime.TripUpdate.StopTimeEvent.getDefaultInstance()) {
                            arrival_ =
                                    GtfsRealtime.TripUpdate.StopTimeEvent.newBuilder(arrival_).mergeFrom(value).buildPartial();
                        } else {
                            arrival_ = value;
                        }
                        onChanged();
                    } else {
                        arrivalBuilder_.mergeFrom(value);
                    }
                    bitField0_ |= 0x00000004;
                    return this;
                }

                /**
                 * <code>optional .transit_realtime.TripUpdate.StopTimeEvent arrival = 2;</code>
                 */
                public Builder clearArrival() {
                    if (arrivalBuilder_ == null) {
                        arrival_ = null;
                        onChanged();
                    } else {
                        arrivalBuilder_.clear();
                    }
                    bitField0_ = (bitField0_ & ~0x00000004);
                    return this;
                }

                /**
                 * <code>optional .transit_realtime.TripUpdate.StopTimeEvent arrival = 2;</code>
                 */
                public GtfsRealtime.TripUpdate.StopTimeEvent.Builder getArrivalBuilder() {
                    bitField0_ |= 0x00000004;
                    onChanged();
                    return getArrivalFieldBuilder().getBuilder();
                }

                /**
                 * <code>optional .transit_realtime.TripUpdate.StopTimeEvent arrival = 2;</code>
                 */
                public GtfsRealtime.TripUpdate.StopTimeEventOrBuilder getArrivalOrBuilder() {
                    if (arrivalBuilder_ != null) {
                        return arrivalBuilder_.getMessageOrBuilder();
                    } else {
                        return arrival_ == null ?
                                GtfsRealtime.TripUpdate.StopTimeEvent.getDefaultInstance() : arrival_;
                    }
                }

                /**
                 * <code>optional .transit_realtime.TripUpdate.StopTimeEvent arrival = 2;</code>
                 */
                private com.google.protobuf.SingleFieldBuilderV3<
                        GtfsRealtime.TripUpdate.StopTimeEvent, GtfsRealtime.TripUpdate.StopTimeEvent.Builder, GtfsRealtime.TripUpdate.StopTimeEventOrBuilder>
                getArrivalFieldBuilder() {
                    if (arrivalBuilder_ == null) {
                        arrivalBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
                                GtfsRealtime.TripUpdate.StopTimeEvent, GtfsRealtime.TripUpdate.StopTimeEvent.Builder, GtfsRealtime.TripUpdate.StopTimeEventOrBuilder>(
                                getArrival(),
                                getParentForChildren(),
                                isClean());
                        arrival_ = null;
                    }
                    return arrivalBuilder_;
                }

                private GtfsRealtime.TripUpdate.StopTimeEvent departure_;
                private com.google.protobuf.SingleFieldBuilderV3<
                        GtfsRealtime.TripUpdate.StopTimeEvent, GtfsRealtime.TripUpdate.StopTimeEvent.Builder, GtfsRealtime.TripUpdate.StopTimeEventOrBuilder> departureBuilder_;

                /**
                 * <code>optional .transit_realtime.TripUpdate.StopTimeEvent departure = 3;</code>
                 */
                public boolean hasDeparture() {
                    return ((bitField0_ & 0x00000008) != 0);
                }

                /**
                 * <code>optional .transit_realtime.TripUpdate.StopTimeEvent departure = 3;</code>
                 */
                public GtfsRealtime.TripUpdate.StopTimeEvent getDeparture() {
                    if (departureBuilder_ == null) {
                        return departure_ == null ? GtfsRealtime.TripUpdate.StopTimeEvent.getDefaultInstance() : departure_;
                    } else {
                        return departureBuilder_.getMessage();
                    }
                }

                /**
                 * <code>optional .transit_realtime.TripUpdate.StopTimeEvent departure = 3;</code>
                 */
                public Builder setDeparture(GtfsRealtime.TripUpdate.StopTimeEvent value) {
                    if (departureBuilder_ == null) {
                        if (value == null) {
                            throw new NullPointerException();
                        }
                        departure_ = value;
                        onChanged();
                    } else {
                        departureBuilder_.setMessage(value);
                    }
                    bitField0_ |= 0x00000008;
                    return this;
                }

                /**
                 * <code>optional .transit_realtime.TripUpdate.StopTimeEvent departure = 3;</code>
                 */
                public Builder setDeparture(
                        GtfsRealtime.TripUpdate.StopTimeEvent.Builder builderForValue) {
                    if (departureBuilder_ == null) {
                        departure_ = builderForValue.build();
                        onChanged();
                    } else {
                        departureBuilder_.setMessage(builderForValue.build());
                    }
                    bitField0_ |= 0x00000008;
                    return this;
                }

                /**
                 * <code>optional .transit_realtime.TripUpdate.StopTimeEvent departure = 3;</code>
                 */
                public Builder mergeDeparture(GtfsRealtime.TripUpdate.StopTimeEvent value) {
                    if (departureBuilder_ == null) {
                        if (((bitField0_ & 0x00000008) != 0) &&
                                departure_ != null &&
                                departure_ != GtfsRealtime.TripUpdate.StopTimeEvent.getDefaultInstance()) {
                            departure_ =
                                    GtfsRealtime.TripUpdate.StopTimeEvent.newBuilder(departure_).mergeFrom(value).buildPartial();
                        } else {
                            departure_ = value;
                        }
                        onChanged();
                    } else {
                        departureBuilder_.mergeFrom(value);
                    }
                    bitField0_ |= 0x00000008;
                    return this;
                }

                /**
                 * <code>optional .transit_realtime.TripUpdate.StopTimeEvent departure = 3;</code>
                 */
                public Builder clearDeparture() {
                    if (departureBuilder_ == null) {
                        departure_ = null;
                        onChanged();
                    } else {
                        departureBuilder_.clear();
                    }
                    bitField0_ = (bitField0_ & ~0x00000008);
                    return this;
                }

                /**
                 * <code>optional .transit_realtime.TripUpdate.StopTimeEvent departure = 3;</code>
                 */
                public GtfsRealtime.TripUpdate.StopTimeEvent.Builder getDepartureBuilder() {
                    bitField0_ |= 0x00000008;
                    onChanged();
                    return getDepartureFieldBuilder().getBuilder();
                }

                /**
                 * <code>optional .transit_realtime.TripUpdate.StopTimeEvent departure = 3;</code>
                 */
                public GtfsRealtime.TripUpdate.StopTimeEventOrBuilder getDepartureOrBuilder() {
                    if (departureBuilder_ != null) {
                        return departureBuilder_.getMessageOrBuilder();
                    } else {
                        return departure_ == null ?
                                GtfsRealtime.TripUpdate.StopTimeEvent.getDefaultInstance() : departure_;
                    }
                }

                /**
                 * <code>optional .transit_realtime.TripUpdate.StopTimeEvent departure = 3;</code>
                 */
                private com.google.protobuf.SingleFieldBuilderV3<
                        GtfsRealtime.TripUpdate.StopTimeEvent, GtfsRealtime.TripUpdate.StopTimeEvent.Builder, GtfsRealtime.TripUpdate.StopTimeEventOrBuilder>
                getDepartureFieldBuilder() {
                    if (departureBuilder_ == null) {
                        departureBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
                                GtfsRealtime.TripUpdate.StopTimeEvent, GtfsRealtime.TripUpdate.StopTimeEvent.Builder, GtfsRealtime.TripUpdate.StopTimeEventOrBuilder>(
                                getDeparture(),
                                getParentForChildren(),
                                isClean());
                        departure_ = null;
                    }
                    return departureBuilder_;
                }

                private int scheduleRelationship_ = 0;

                /**
                 * <code>optional .transit_realtime.TripUpdate.StopTimeUpdate.ScheduleRelationship schedule_relationship = 5 [default = SCHEDULED];</code>
                 */
                public boolean hasScheduleRelationship() {
                    return ((bitField0_ & 0x00000010) != 0);
                }

                /**
                 * <code>optional .transit_realtime.TripUpdate.StopTimeUpdate.ScheduleRelationship schedule_relationship = 5 [default = SCHEDULED];</code>
                 */
                public GtfsRealtime.TripUpdate.StopTimeUpdate.ScheduleRelationship getScheduleRelationship() {
                    @SuppressWarnings("deprecation")
                    GtfsRealtime.TripUpdate.StopTimeUpdate.ScheduleRelationship result = GtfsRealtime.TripUpdate.StopTimeUpdate.ScheduleRelationship.valueOf(scheduleRelationship_);
                    return result == null ? GtfsRealtime.TripUpdate.StopTimeUpdate.ScheduleRelationship.SCHEDULED : result;
                }

                /**
                 * <code>optional .transit_realtime.TripUpdate.StopTimeUpdate.ScheduleRelationship schedule_relationship = 5 [default = SCHEDULED];</code>
                 */
                public Builder setScheduleRelationship(GtfsRealtime.TripUpdate.StopTimeUpdate.ScheduleRelationship value) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    bitField0_ |= 0x00000010;
                    scheduleRelationship_ = value.getNumber();
                    onChanged();
                    return this;
                }

                /**
                 * <code>optional .transit_realtime.TripUpdate.StopTimeUpdate.ScheduleRelationship schedule_relationship = 5 [default = SCHEDULED];</code>
                 */
                public Builder clearScheduleRelationship() {
                    bitField0_ = (bitField0_ & ~0x00000010);
                    scheduleRelationship_ = 0;
                    onChanged();
                    return this;
                }

                @java.lang.Override
                public final Builder setUnknownFields(
                        final com.google.protobuf.UnknownFieldSet unknownFields) {
                    return super.setUnknownFields(unknownFields);
                }

                @java.lang.Override
                public final Builder mergeUnknownFields(
                        final com.google.protobuf.UnknownFieldSet unknownFields) {
                    return super.mergeUnknownFields(unknownFields);
                }


                // @@protoc_insertion_point(builder_scope:transit_realtime.TripUpdate.StopTimeUpdate)
            }

            // @@protoc_insertion_point(class_scope:transit_realtime.TripUpdate.StopTimeUpdate)
            private static final GtfsRealtime.TripUpdate.StopTimeUpdate DEFAULT_INSTANCE;

            static {
                DEFAULT_INSTANCE = new GtfsRealtime.TripUpdate.StopTimeUpdate();
            }

            public static GtfsRealtime.TripUpdate.StopTimeUpdate getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            @java.lang.Deprecated
            public static final com.google.protobuf.Parser<StopTimeUpdate>
                    PARSER = new com.google.protobuf.AbstractParser<StopTimeUpdate>() {
                @java.lang.Override
                public StopTimeUpdate parsePartialFrom(
                        com.google.protobuf.CodedInputStream input,
                        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                        throws com.google.protobuf.InvalidProtocolBufferException {
                    return new StopTimeUpdate(input, extensionRegistry);
                }
            };

            public static com.google.protobuf.Parser<StopTimeUpdate> parser() {
                return PARSER;
            }

            @java.lang.Override
            public com.google.protobuf.Parser<StopTimeUpdate> getParserForType() {
                return PARSER;
            }

            @java.lang.Override
            public GtfsRealtime.TripUpdate.StopTimeUpdate getDefaultInstanceForType() {
                return DEFAULT_INSTANCE;
            }

        }

        private int bitField0_;
        public static final int TRIP_FIELD_NUMBER = 1;
        private GtfsRealtime.TripDescriptor trip_;

        /**
         * <pre>
         * The Trip that this message applies to. There can be at most one
         * TripUpdate entity for each actual trip instance.
         * If there is none, that means there is no prediction information available.
         * It does *not* mean that the trip is progressing according to schedule.
         * </pre>
         *
         * <code>required .transit_realtime.TripDescriptor trip = 1;</code>
         */
        public boolean hasTrip() {
            return ((bitField0_ & 0x00000001) != 0);
        }

        /**
         * <pre>
         * The Trip that this message applies to. There can be at most one
         * TripUpdate entity for each actual trip instance.
         * If there is none, that means there is no prediction information available.
         * It does *not* mean that the trip is progressing according to schedule.
         * </pre>
         *
         * <code>required .transit_realtime.TripDescriptor trip = 1;</code>
         */
        public GtfsRealtime.TripDescriptor getTrip() {
            return trip_ == null ? GtfsRealtime.TripDescriptor.getDefaultInstance() : trip_;
        }

        /**
         * <pre>
         * The Trip that this message applies to. There can be at most one
         * TripUpdate entity for each actual trip instance.
         * If there is none, that means there is no prediction information available.
         * It does *not* mean that the trip is progressing according to schedule.
         * </pre>
         *
         * <code>required .transit_realtime.TripDescriptor trip = 1;</code>
         */
        public GtfsRealtime.TripDescriptorOrBuilder getTripOrBuilder() {
            return trip_ == null ? GtfsRealtime.TripDescriptor.getDefaultInstance() : trip_;
        }

        public static final int VEHICLE_FIELD_NUMBER = 3;
        private GtfsRealtime.VehicleDescriptor vehicle_;

        /**
         * <pre>
         * Additional information on the vehicle that is serving this trip.
         * </pre>
         *
         * <code>optional .transit_realtime.VehicleDescriptor vehicle = 3;</code>
         */
        public boolean hasVehicle() {
            return ((bitField0_ & 0x00000002) != 0);
        }

        /**
         * <pre>
         * Additional information on the vehicle that is serving this trip.
         * </pre>
         *
         * <code>optional .transit_realtime.VehicleDescriptor vehicle = 3;</code>
         */
        public GtfsRealtime.VehicleDescriptor getVehicle() {
            return vehicle_ == null ? GtfsRealtime.VehicleDescriptor.getDefaultInstance() : vehicle_;
        }

        /**
         * <pre>
         * Additional information on the vehicle that is serving this trip.
         * </pre>
         *
         * <code>optional .transit_realtime.VehicleDescriptor vehicle = 3;</code>
         */
        public GtfsRealtime.VehicleDescriptorOrBuilder getVehicleOrBuilder() {
            return vehicle_ == null ? GtfsRealtime.VehicleDescriptor.getDefaultInstance() : vehicle_;
        }

        public static final int STOP_TIME_UPDATE_FIELD_NUMBER = 2;
        private java.util.List<GtfsRealtime.TripUpdate.StopTimeUpdate> stopTimeUpdate_;

        /**
         * <pre>
         * Updates to StopTimes for the trip (both future, i.e., predictions, and in
         * some cases, past ones, i.e., those that already happened).
         * The updates must be sorted by stop_sequence, and apply for all the
         * following stops of the trip up to the next specified one.
         * Example 1:
         * For a trip with 20 stops, a StopTimeUpdate with arrival delay and departure
         * delay of 0 for stop_sequence of the current stop means that the trip is
         * exactly on time.
         * Example 2:
         * For the same trip instance, 3 StopTimeUpdates are provided:
         * - delay of 5 min for stop_sequence 3
         * - delay of 1 min for stop_sequence 8
         * - delay of unspecified duration for stop_sequence 10
         * This will be interpreted as:
         * - stop_sequences 3,4,5,6,7 have delay of 5 min.
         * - stop_sequences 8,9 have delay of 1 min.
         * - stop_sequences 10,... have unknown delay.
         * </pre>
         *
         * <code>repeated .transit_realtime.TripUpdate.StopTimeUpdate stop_time_update = 2;</code>
         */
        public java.util.List<GtfsRealtime.TripUpdate.StopTimeUpdate> getStopTimeUpdateList() {
            return stopTimeUpdate_;
        }

        /**
         * <pre>
         * Updates to StopTimes for the trip (both future, i.e., predictions, and in
         * some cases, past ones, i.e., those that already happened).
         * The updates must be sorted by stop_sequence, and apply for all the
         * following stops of the trip up to the next specified one.
         * Example 1:
         * For a trip with 20 stops, a StopTimeUpdate with arrival delay and departure
         * delay of 0 for stop_sequence of the current stop means that the trip is
         * exactly on time.
         * Example 2:
         * For the same trip instance, 3 StopTimeUpdates are provided:
         * - delay of 5 min for stop_sequence 3
         * - delay of 1 min for stop_sequence 8
         * - delay of unspecified duration for stop_sequence 10
         * This will be interpreted as:
         * - stop_sequences 3,4,5,6,7 have delay of 5 min.
         * - stop_sequences 8,9 have delay of 1 min.
         * - stop_sequences 10,... have unknown delay.
         * </pre>
         *
         * <code>repeated .transit_realtime.TripUpdate.StopTimeUpdate stop_time_update = 2;</code>
         */
        public java.util.List<? extends GtfsRealtime.TripUpdate.StopTimeUpdateOrBuilder>
        getStopTimeUpdateOrBuilderList() {
            return stopTimeUpdate_;
        }

        /**
         * <pre>
         * Updates to StopTimes for the trip (both future, i.e., predictions, and in
         * some cases, past ones, i.e., those that already happened).
         * The updates must be sorted by stop_sequence, and apply for all the
         * following stops of the trip up to the next specified one.
         * Example 1:
         * For a trip with 20 stops, a StopTimeUpdate with arrival delay and departure
         * delay of 0 for stop_sequence of the current stop means that the trip is
         * exactly on time.
         * Example 2:
         * For the same trip instance, 3 StopTimeUpdates are provided:
         * - delay of 5 min for stop_sequence 3
         * - delay of 1 min for stop_sequence 8
         * - delay of unspecified duration for stop_sequence 10
         * This will be interpreted as:
         * - stop_sequences 3,4,5,6,7 have delay of 5 min.
         * - stop_sequences 8,9 have delay of 1 min.
         * - stop_sequences 10,... have unknown delay.
         * </pre>
         *
         * <code>repeated .transit_realtime.TripUpdate.StopTimeUpdate stop_time_update = 2;</code>
         */
        public int getStopTimeUpdateCount() {
            return stopTimeUpdate_.size();
        }

        /**
         * <pre>
         * Updates to StopTimes for the trip (both future, i.e., predictions, and in
         * some cases, past ones, i.e., those that already happened).
         * The updates must be sorted by stop_sequence, and apply for all the
         * following stops of the trip up to the next specified one.
         * Example 1:
         * For a trip with 20 stops, a StopTimeUpdate with arrival delay and departure
         * delay of 0 for stop_sequence of the current stop means that the trip is
         * exactly on time.
         * Example 2:
         * For the same trip instance, 3 StopTimeUpdates are provided:
         * - delay of 5 min for stop_sequence 3
         * - delay of 1 min for stop_sequence 8
         * - delay of unspecified duration for stop_sequence 10
         * This will be interpreted as:
         * - stop_sequences 3,4,5,6,7 have delay of 5 min.
         * - stop_sequences 8,9 have delay of 1 min.
         * - stop_sequences 10,... have unknown delay.
         * </pre>
         *
         * <code>repeated .transit_realtime.TripUpdate.StopTimeUpdate stop_time_update = 2;</code>
         */
        public GtfsRealtime.TripUpdate.StopTimeUpdate getStopTimeUpdate(int index) {
            return stopTimeUpdate_.get(index);
        }

        /**
         * <pre>
         * Updates to StopTimes for the trip (both future, i.e., predictions, and in
         * some cases, past ones, i.e., those that already happened).
         * The updates must be sorted by stop_sequence, and apply for all the
         * following stops of the trip up to the next specified one.
         * Example 1:
         * For a trip with 20 stops, a StopTimeUpdate with arrival delay and departure
         * delay of 0 for stop_sequence of the current stop means that the trip is
         * exactly on time.
         * Example 2:
         * For the same trip instance, 3 StopTimeUpdates are provided:
         * - delay of 5 min for stop_sequence 3
         * - delay of 1 min for stop_sequence 8
         * - delay of unspecified duration for stop_sequence 10
         * This will be interpreted as:
         * - stop_sequences 3,4,5,6,7 have delay of 5 min.
         * - stop_sequences 8,9 have delay of 1 min.
         * - stop_sequences 10,... have unknown delay.
         * </pre>
         *
         * <code>repeated .transit_realtime.TripUpdate.StopTimeUpdate stop_time_update = 2;</code>
         */
        public GtfsRealtime.TripUpdate.StopTimeUpdateOrBuilder getStopTimeUpdateOrBuilder(
                int index) {
            return stopTimeUpdate_.get(index);
        }

        public static final int TIMESTAMP_FIELD_NUMBER = 4;
        private long timestamp_;

        /**
         * <pre>
         * Moment at which the vehicle's real-time progress was measured. In POSIX
         * time (i.e., the number of seconds since January 1st 1970 00:00:00 UTC).
         * </pre>
         *
         * <code>optional uint64 timestamp = 4;</code>
         */
        public boolean hasTimestamp() {
            return ((bitField0_ & 0x00000004) != 0);
        }

        /**
         * <pre>
         * Moment at which the vehicle's real-time progress was measured. In POSIX
         * time (i.e., the number of seconds since January 1st 1970 00:00:00 UTC).
         * </pre>
         *
         * <code>optional uint64 timestamp = 4;</code>
         */
        public long getTimestamp() {
            return timestamp_;
        }

        public static final int DELAY_FIELD_NUMBER = 5;
        private int delay_;

        /**
         * <pre>
         * The current schedule deviation for the trip.  Delay should only be
         * specified when the prediction is given relative to some existing schedule
         * in GTFS.
         * Delay (in seconds) can be positive (meaning that the vehicle is late) or
         * negative (meaning that the vehicle is ahead of schedule). Delay of 0
         * means that the vehicle is exactly on time.
         * Delay information in StopTimeUpdates take precedent of trip-level delay
         * information, such that trip-level delay is only propagated until the next
         * stop along the trip with a StopTimeUpdate delay value specified.
         * Feed providers are strongly encouraged to provide a TripUpdate.timestamp
         * value indicating when the delay value was last updated, in order to
         * evaluate the freshness of the data.
         * NOTE: This field is still experimental, and subject to change. It may be
         * formally adopted in the future.
         * </pre>
         *
         * <code>optional int32 delay = 5;</code>
         */
        public boolean hasDelay() {
            return ((bitField0_ & 0x00000008) != 0);
        }

        /**
         * <pre>
         * The current schedule deviation for the trip.  Delay should only be
         * specified when the prediction is given relative to some existing schedule
         * in GTFS.
         * Delay (in seconds) can be positive (meaning that the vehicle is late) or
         * negative (meaning that the vehicle is ahead of schedule). Delay of 0
         * means that the vehicle is exactly on time.
         * Delay information in StopTimeUpdates take precedent of trip-level delay
         * information, such that trip-level delay is only propagated until the next
         * stop along the trip with a StopTimeUpdate delay value specified.
         * Feed providers are strongly encouraged to provide a TripUpdate.timestamp
         * value indicating when the delay value was last updated, in order to
         * evaluate the freshness of the data.
         * NOTE: This field is still experimental, and subject to change. It may be
         * formally adopted in the future.
         * </pre>
         *
         * <code>optional int32 delay = 5;</code>
         */
        public int getDelay() {
            return delay_;
        }

        private byte memoizedIsInitialized = -1;

        @java.lang.Override
        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            if (!hasTrip()) {
                memoizedIsInitialized = 0;
                return false;
            }
            if (!getTrip().isInitialized()) {
                memoizedIsInitialized = 0;
                return false;
            }
            if (hasVehicle()) {
                if (!getVehicle().isInitialized()) {
                    memoizedIsInitialized = 0;
                    return false;
                }
            }
            for (int i = 0; i < getStopTimeUpdateCount(); i++) {
                if (!getStopTimeUpdate(i).isInitialized()) {
                    memoizedIsInitialized = 0;
                    return false;
                }
            }
            if (!extensionsAreInitialized()) {
                memoizedIsInitialized = 0;
                return false;
            }
            memoizedIsInitialized = 1;
            return true;
        }

        @java.lang.Override
        public void writeTo(com.google.protobuf.CodedOutputStream output)
                throws java.io.IOException {
            com.google.protobuf.GeneratedMessageV3
                    .ExtendableMessage<GtfsRealtime.TripUpdate>.ExtensionWriter
                    extensionWriter = newExtensionWriter();
            if (((bitField0_ & 0x00000001) != 0)) {
                output.writeMessage(1, getTrip());
            }
            for (int i = 0; i < stopTimeUpdate_.size(); i++) {
                output.writeMessage(2, stopTimeUpdate_.get(i));
            }
            if (((bitField0_ & 0x00000002) != 0)) {
                output.writeMessage(3, getVehicle());
            }
            if (((bitField0_ & 0x00000004) != 0)) {
                output.writeUInt64(4, timestamp_);
            }
            if (((bitField0_ & 0x00000008) != 0)) {
                output.writeInt32(5, delay_);
            }
            extensionWriter.writeUntil(2000, output);
            unknownFields.writeTo(output);
        }

        @java.lang.Override
        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            if (((bitField0_ & 0x00000001) != 0)) {
                size += com.google.protobuf.CodedOutputStream
                        .computeMessageSize(1, getTrip());
            }
            for (int i = 0; i < stopTimeUpdate_.size(); i++) {
                size += com.google.protobuf.CodedOutputStream
                        .computeMessageSize(2, stopTimeUpdate_.get(i));
            }
            if (((bitField0_ & 0x00000002) != 0)) {
                size += com.google.protobuf.CodedOutputStream
                        .computeMessageSize(3, getVehicle());
            }
            if (((bitField0_ & 0x00000004) != 0)) {
                size += com.google.protobuf.CodedOutputStream
                        .computeUInt64Size(4, timestamp_);
            }
            if (((bitField0_ & 0x00000008) != 0)) {
                size += com.google.protobuf.CodedOutputStream
                        .computeInt32Size(5, delay_);
            }
            size += extensionsSerializedSize();
            size += unknownFields.getSerializedSize();
            memoizedSize = size;
            return size;
        }

        @java.lang.Override
        public boolean equals(final java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof GtfsRealtime.TripUpdate)) {
                return super.equals(obj);
            }
            GtfsRealtime.TripUpdate other = (GtfsRealtime.TripUpdate) obj;

            if (hasTrip() != other.hasTrip()) return false;
            if (hasTrip()) {
                if (!getTrip()
                        .equals(other.getTrip())) return false;
            }
            if (hasVehicle() != other.hasVehicle()) return false;
            if (hasVehicle()) {
                if (!getVehicle()
                        .equals(other.getVehicle())) return false;
            }
            if (!getStopTimeUpdateList()
                    .equals(other.getStopTimeUpdateList())) return false;
            if (hasTimestamp() != other.hasTimestamp()) return false;
            if (hasTimestamp()) {
                if (getTimestamp()
                        != other.getTimestamp()) return false;
            }
            if (hasDelay() != other.hasDelay()) return false;
            if (hasDelay()) {
                if (getDelay()
                        != other.getDelay()) return false;
            }
            if (!unknownFields.equals(other.unknownFields)) return false;
            if (!getExtensionFields().equals(other.getExtensionFields()))
                return false;
            return true;
        }

        @java.lang.Override
        public int hashCode() {
            if (memoizedHashCode != 0) {
                return memoizedHashCode;
            }
            int hash = 41;
            hash = (19 * hash) + getDescriptor().hashCode();
            if (hasTrip()) {
                hash = (37 * hash) + TRIP_FIELD_NUMBER;
                hash = (53 * hash) + getTrip().hashCode();
            }
            if (hasVehicle()) {
                hash = (37 * hash) + VEHICLE_FIELD_NUMBER;
                hash = (53 * hash) + getVehicle().hashCode();
            }
            if (getStopTimeUpdateCount() > 0) {
                hash = (37 * hash) + STOP_TIME_UPDATE_FIELD_NUMBER;
                hash = (53 * hash) + getStopTimeUpdateList().hashCode();
            }
            if (hasTimestamp()) {
                hash = (37 * hash) + TIMESTAMP_FIELD_NUMBER;
                hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
                        getTimestamp());
            }
            if (hasDelay()) {
                hash = (37 * hash) + DELAY_FIELD_NUMBER;
                hash = (53 * hash) + getDelay();
            }
            hash = hashFields(hash, getExtensionFields());
            hash = (29 * hash) + unknownFields.hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static GtfsRealtime.TripUpdate parseFrom(
                java.nio.ByteBuffer data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GtfsRealtime.TripUpdate parseFrom(
                java.nio.ByteBuffer data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GtfsRealtime.TripUpdate parseFrom(
                com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GtfsRealtime.TripUpdate parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GtfsRealtime.TripUpdate parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GtfsRealtime.TripUpdate parseFrom(
                byte[] data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GtfsRealtime.TripUpdate parseFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }

        public static GtfsRealtime.TripUpdate parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static GtfsRealtime.TripUpdate parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input);
        }

        public static GtfsRealtime.TripUpdate parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static GtfsRealtime.TripUpdate parseFrom(
                com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }

        public static GtfsRealtime.TripUpdate parseFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        @java.lang.Override
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GtfsRealtime.TripUpdate prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }

        @java.lang.Override
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE
                    ? new Builder() : new Builder().mergeFrom(this);
        }

        @java.lang.Override
        protected Builder newBuilderForType(
                com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        /**
         * <pre>
         * Realtime update of the progress of a vehicle along a trip.
         * Depending on the value of ScheduleRelationship, a TripUpdate can specify:
         * - A trip that proceeds along the schedule.
         * - A trip that proceeds along a route but has no fixed schedule.
         * - A trip that have been added or removed with regard to schedule.
         * The updates can be for future, predicted arrival/departure events, or for
         * past events that already occurred.
         * Normally, updates should get more precise and more certain (see
         * uncertainty below) as the events gets closer to current time.
         * Even if that is not possible, the information for past events should be
         * precise and certain. In particular, if an update points to time in the past
         * but its update's uncertainty is not 0, the client should conclude that the
         * update is a (wrong) prediction and that the trip has not completed yet.
         * Note that the update can describe a trip that is already completed.
         * To this end, it is enough to provide an update for the last stop of the trip.
         * If the time of that is in the past, the client will conclude from that that
         * the whole trip is in the past (it is possible, although inconsequential, to
         * also provide updates for preceding stops).
         * This option is most relevant for a trip that has completed ahead of schedule,
         * but according to the schedule, the trip is still proceeding at the current
         * time. Removing the updates for this trip could make the client assume
         * that the trip is still proceeding.
         * Note that the feed provider is allowed, but not required, to purge past
         * updates - this is one case where this would be practically useful.
         * </pre>
         * <p>
         * Protobuf type {@code transit_realtime.TripUpdate}
         */
        public static final class Builder extends
                com.google.protobuf.GeneratedMessageV3.ExtendableBuilder<
                        GtfsRealtime.TripUpdate, Builder> implements
                // @@protoc_insertion_point(builder_implements:transit_realtime.TripUpdate)
                GtfsRealtime.TripUpdateOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
                return GtfsRealtime.internal_static_transit_realtime_TripUpdate_descriptor;
            }

            @java.lang.Override
            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internalGetFieldAccessorTable() {
                return GtfsRealtime.internal_static_transit_realtime_TripUpdate_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                GtfsRealtime.TripUpdate.class, GtfsRealtime.TripUpdate.Builder.class);
            }

            // Construct using GtfsRealtime.TripUpdate.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(
                    com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.GeneratedMessageV3
                        .alwaysUseFieldBuilders) {
                    getTripFieldBuilder();
                    getVehicleFieldBuilder();
                    getStopTimeUpdateFieldBuilder();
                }
            }

            @java.lang.Override
            public Builder clear() {
                super.clear();
                if (tripBuilder_ == null) {
                    trip_ = null;
                } else {
                    tripBuilder_.clear();
                }
                bitField0_ = (bitField0_ & ~0x00000001);
                if (vehicleBuilder_ == null) {
                    vehicle_ = null;
                } else {
                    vehicleBuilder_.clear();
                }
                bitField0_ = (bitField0_ & ~0x00000002);
                if (stopTimeUpdateBuilder_ == null) {
                    stopTimeUpdate_ = java.util.Collections.emptyList();
                    bitField0_ = (bitField0_ & ~0x00000004);
                } else {
                    stopTimeUpdateBuilder_.clear();
                }
                timestamp_ = 0L;
                bitField0_ = (bitField0_ & ~0x00000008);
                delay_ = 0;
                bitField0_ = (bitField0_ & ~0x00000010);
                return this;
            }

            @java.lang.Override
            public com.google.protobuf.Descriptors.Descriptor
            getDescriptorForType() {
                return GtfsRealtime.internal_static_transit_realtime_TripUpdate_descriptor;
            }

            @java.lang.Override
            public GtfsRealtime.TripUpdate getDefaultInstanceForType() {
                return GtfsRealtime.TripUpdate.getDefaultInstance();
            }

            @java.lang.Override
            public GtfsRealtime.TripUpdate build() {
                GtfsRealtime.TripUpdate result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            @java.lang.Override
            public GtfsRealtime.TripUpdate buildPartial() {
                GtfsRealtime.TripUpdate result = new GtfsRealtime.TripUpdate(this);
                int from_bitField0_ = bitField0_;
                int to_bitField0_ = 0;
                if (((from_bitField0_ & 0x00000001) != 0)) {
                    if (tripBuilder_ == null) {
                        result.trip_ = trip_;
                    } else {
                        result.trip_ = tripBuilder_.build();
                    }
                    to_bitField0_ |= 0x00000001;
                }
                if (((from_bitField0_ & 0x00000002) != 0)) {
                    if (vehicleBuilder_ == null) {
                        result.vehicle_ = vehicle_;
                    } else {
                        result.vehicle_ = vehicleBuilder_.build();
                    }
                    to_bitField0_ |= 0x00000002;
                }
                if (stopTimeUpdateBuilder_ == null) {
                    if (((bitField0_ & 0x00000004) != 0)) {
                        stopTimeUpdate_ = java.util.Collections.unmodifiableList(stopTimeUpdate_);
                        bitField0_ = (bitField0_ & ~0x00000004);
                    }
                    result.stopTimeUpdate_ = stopTimeUpdate_;
                } else {
                    result.stopTimeUpdate_ = stopTimeUpdateBuilder_.build();
                }
                if (((from_bitField0_ & 0x00000008) != 0)) {
                    result.timestamp_ = timestamp_;
                    to_bitField0_ |= 0x00000004;
                }
                if (((from_bitField0_ & 0x00000010) != 0)) {
                    result.delay_ = delay_;
                    to_bitField0_ |= 0x00000008;
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            @java.lang.Override
            public Builder clone() {
                return super.clone();
            }

            @java.lang.Override
            public Builder setField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return super.setField(field, value);
            }

            @java.lang.Override
            public Builder clearField(
                    com.google.protobuf.Descriptors.FieldDescriptor field) {
                return super.clearField(field);
            }

            @java.lang.Override
            public Builder clearOneof(
                    com.google.protobuf.Descriptors.OneofDescriptor oneof) {
                return super.clearOneof(oneof);
            }

            @java.lang.Override
            public Builder setRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    int index, java.lang.Object value) {
                return super.setRepeatedField(field, index, value);
            }

            @java.lang.Override
            public Builder addRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return super.addRepeatedField(field, value);
            }

            @java.lang.Override
            public <Type> Builder setExtension(
                    com.google.protobuf.GeneratedMessage.GeneratedExtension<
                            GtfsRealtime.TripUpdate, Type> extension,
                    Type value) {
                return super.setExtension(extension, value);
            }

            @java.lang.Override
            public <Type> Builder setExtension(
                    com.google.protobuf.GeneratedMessage.GeneratedExtension<
                            GtfsRealtime.TripUpdate, java.util.List<Type>> extension,
                    int index, Type value) {
                return super.setExtension(extension, index, value);
            }

            @java.lang.Override
            public <Type> Builder addExtension(
                    com.google.protobuf.GeneratedMessage.GeneratedExtension<
                            GtfsRealtime.TripUpdate, java.util.List<Type>> extension,
                    Type value) {
                return super.addExtension(extension, value);
            }

            @java.lang.Override
            public <Type> Builder clearExtension(
                    com.google.protobuf.GeneratedMessage.GeneratedExtension<
                            GtfsRealtime.TripUpdate, ?> extension) {
                return super.clearExtension(extension);
            }

            @java.lang.Override
            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof GtfsRealtime.TripUpdate) {
                    return mergeFrom((GtfsRealtime.TripUpdate) other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(GtfsRealtime.TripUpdate other) {
                if (other == GtfsRealtime.TripUpdate.getDefaultInstance()) return this;
                if (other.hasTrip()) {
                    mergeTrip(other.getTrip());
                }
                if (other.hasVehicle()) {
                    mergeVehicle(other.getVehicle());
                }
                if (stopTimeUpdateBuilder_ == null) {
                    if (!other.stopTimeUpdate_.isEmpty()) {
                        if (stopTimeUpdate_.isEmpty()) {
                            stopTimeUpdate_ = other.stopTimeUpdate_;
                            bitField0_ = (bitField0_ & ~0x00000004);
                        } else {
                            ensureStopTimeUpdateIsMutable();
                            stopTimeUpdate_.addAll(other.stopTimeUpdate_);
                        }
                        onChanged();
                    }
                } else {
                    if (!other.stopTimeUpdate_.isEmpty()) {
                        if (stopTimeUpdateBuilder_.isEmpty()) {
                            stopTimeUpdateBuilder_.dispose();
                            stopTimeUpdateBuilder_ = null;
                            stopTimeUpdate_ = other.stopTimeUpdate_;
                            bitField0_ = (bitField0_ & ~0x00000004);
                            stopTimeUpdateBuilder_ =
                                    com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                                            getStopTimeUpdateFieldBuilder() : null;
                        } else {
                            stopTimeUpdateBuilder_.addAllMessages(other.stopTimeUpdate_);
                        }
                    }
                }
                if (other.hasTimestamp()) {
                    setTimestamp(other.getTimestamp());
                }
                if (other.hasDelay()) {
                    setDelay(other.getDelay());
                }
                this.mergeExtensionFields(other);
                this.mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            @java.lang.Override
            public final boolean isInitialized() {
                if (!hasTrip()) {
                    return false;
                }
                if (!getTrip().isInitialized()) {
                    return false;
                }
                if (hasVehicle()) {
                    if (!getVehicle().isInitialized()) {
                        return false;
                    }
                }
                for (int i = 0; i < getStopTimeUpdateCount(); i++) {
                    if (!getStopTimeUpdate(i).isInitialized()) {
                        return false;
                    }
                }
                if (!extensionsAreInitialized()) {
                    return false;
                }
                return true;
            }

            @java.lang.Override
            public Builder mergeFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                GtfsRealtime.TripUpdate parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (GtfsRealtime.TripUpdate) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private int bitField0_;

            private GtfsRealtime.TripDescriptor trip_;
            private com.google.protobuf.SingleFieldBuilderV3<
                    GtfsRealtime.TripDescriptor, GtfsRealtime.TripDescriptor.Builder, GtfsRealtime.TripDescriptorOrBuilder> tripBuilder_;

            /**
             * <pre>
             * The Trip that this message applies to. There can be at most one
             * TripUpdate entity for each actual trip instance.
             * If there is none, that means there is no prediction information available.
             * It does *not* mean that the trip is progressing according to schedule.
             * </pre>
             *
             * <code>required .transit_realtime.TripDescriptor trip = 1;</code>
             */
            public boolean hasTrip() {
                return ((bitField0_ & 0x00000001) != 0);
            }

            /**
             * <pre>
             * The Trip that this message applies to. There can be at most one
             * TripUpdate entity for each actual trip instance.
             * If there is none, that means there is no prediction information available.
             * It does *not* mean that the trip is progressing according to schedule.
             * </pre>
             *
             * <code>required .transit_realtime.TripDescriptor trip = 1;</code>
             */
            public GtfsRealtime.TripDescriptor getTrip() {
                if (tripBuilder_ == null) {
                    return trip_ == null ? GtfsRealtime.TripDescriptor.getDefaultInstance() : trip_;
                } else {
                    return tripBuilder_.getMessage();
                }
            }

            /**
             * <pre>
             * The Trip that this message applies to. There can be at most one
             * TripUpdate entity for each actual trip instance.
             * If there is none, that means there is no prediction information available.
             * It does *not* mean that the trip is progressing according to schedule.
             * </pre>
             *
             * <code>required .transit_realtime.TripDescriptor trip = 1;</code>
             */
            public Builder setTrip(GtfsRealtime.TripDescriptor value) {
                if (tripBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    trip_ = value;
                    onChanged();
                } else {
                    tripBuilder_.setMessage(value);
                }
                bitField0_ |= 0x00000001;
                return this;
            }

            /**
             * <pre>
             * The Trip that this message applies to. There can be at most one
             * TripUpdate entity for each actual trip instance.
             * If there is none, that means there is no prediction information available.
             * It does *not* mean that the trip is progressing according to schedule.
             * </pre>
             *
             * <code>required .transit_realtime.TripDescriptor trip = 1;</code>
             */
            public Builder setTrip(
                    GtfsRealtime.TripDescriptor.Builder builderForValue) {
                if (tripBuilder_ == null) {
                    trip_ = builderForValue.build();
                    onChanged();
                } else {
                    tripBuilder_.setMessage(builderForValue.build());
                }
                bitField0_ |= 0x00000001;
                return this;
            }

            /**
             * <pre>
             * The Trip that this message applies to. There can be at most one
             * TripUpdate entity for each actual trip instance.
             * If there is none, that means there is no prediction information available.
             * It does *not* mean that the trip is progressing according to schedule.
             * </pre>
             *
             * <code>required .transit_realtime.TripDescriptor trip = 1;</code>
             */
            public Builder mergeTrip(GtfsRealtime.TripDescriptor value) {
                if (tripBuilder_ == null) {
                    if (((bitField0_ & 0x00000001) != 0) &&
                            trip_ != null &&
                            trip_ != GtfsRealtime.TripDescriptor.getDefaultInstance()) {
                        trip_ =
                                GtfsRealtime.TripDescriptor.newBuilder(trip_).mergeFrom(value).buildPartial();
                    } else {
                        trip_ = value;
                    }
                    onChanged();
                } else {
                    tripBuilder_.mergeFrom(value);
                }
                bitField0_ |= 0x00000001;
                return this;
            }

            /**
             * <pre>
             * The Trip that this message applies to. There can be at most one
             * TripUpdate entity for each actual trip instance.
             * If there is none, that means there is no prediction information available.
             * It does *not* mean that the trip is progressing according to schedule.
             * </pre>
             *
             * <code>required .transit_realtime.TripDescriptor trip = 1;</code>
             */
            public Builder clearTrip() {
                if (tripBuilder_ == null) {
                    trip_ = null;
                    onChanged();
                } else {
                    tripBuilder_.clear();
                }
                bitField0_ = (bitField0_ & ~0x00000001);
                return this;
            }

            /**
             * <pre>
             * The Trip that this message applies to. There can be at most one
             * TripUpdate entity for each actual trip instance.
             * If there is none, that means there is no prediction information available.
             * It does *not* mean that the trip is progressing according to schedule.
             * </pre>
             *
             * <code>required .transit_realtime.TripDescriptor trip = 1;</code>
             */
            public GtfsRealtime.TripDescriptor.Builder getTripBuilder() {
                bitField0_ |= 0x00000001;
                onChanged();
                return getTripFieldBuilder().getBuilder();
            }

            /**
             * <pre>
             * The Trip that this message applies to. There can be at most one
             * TripUpdate entity for each actual trip instance.
             * If there is none, that means there is no prediction information available.
             * It does *not* mean that the trip is progressing according to schedule.
             * </pre>
             *
             * <code>required .transit_realtime.TripDescriptor trip = 1;</code>
             */
            public GtfsRealtime.TripDescriptorOrBuilder getTripOrBuilder() {
                if (tripBuilder_ != null) {
                    return tripBuilder_.getMessageOrBuilder();
                } else {
                    return trip_ == null ?
                            GtfsRealtime.TripDescriptor.getDefaultInstance() : trip_;
                }
            }

            /**
             * <pre>
             * The Trip that this message applies to. There can be at most one
             * TripUpdate entity for each actual trip instance.
             * If there is none, that means there is no prediction information available.
             * It does *not* mean that the trip is progressing according to schedule.
             * </pre>
             *
             * <code>required .transit_realtime.TripDescriptor trip = 1;</code>
             */
            private com.google.protobuf.SingleFieldBuilderV3<
                    GtfsRealtime.TripDescriptor, GtfsRealtime.TripDescriptor.Builder, GtfsRealtime.TripDescriptorOrBuilder>
            getTripFieldBuilder() {
                if (tripBuilder_ == null) {
                    tripBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
                            GtfsRealtime.TripDescriptor, GtfsRealtime.TripDescriptor.Builder, GtfsRealtime.TripDescriptorOrBuilder>(
                            getTrip(),
                            getParentForChildren(),
                            isClean());
                    trip_ = null;
                }
                return tripBuilder_;
            }

            private GtfsRealtime.VehicleDescriptor vehicle_;
            private com.google.protobuf.SingleFieldBuilderV3<
                    GtfsRealtime.VehicleDescriptor, GtfsRealtime.VehicleDescriptor.Builder, GtfsRealtime.VehicleDescriptorOrBuilder> vehicleBuilder_;

            /**
             * <pre>
             * Additional information on the vehicle that is serving this trip.
             * </pre>
             *
             * <code>optional .transit_realtime.VehicleDescriptor vehicle = 3;</code>
             */
            public boolean hasVehicle() {
                return ((bitField0_ & 0x00000002) != 0);
            }

            /**
             * <pre>
             * Additional information on the vehicle that is serving this trip.
             * </pre>
             *
             * <code>optional .transit_realtime.VehicleDescriptor vehicle = 3;</code>
             */
            public GtfsRealtime.VehicleDescriptor getVehicle() {
                if (vehicleBuilder_ == null) {
                    return vehicle_ == null ? GtfsRealtime.VehicleDescriptor.getDefaultInstance() : vehicle_;
                } else {
                    return vehicleBuilder_.getMessage();
                }
            }

            /**
             * <pre>
             * Additional information on the vehicle that is serving this trip.
             * </pre>
             *
             * <code>optional .transit_realtime.VehicleDescriptor vehicle = 3;</code>
             */
            public Builder setVehicle(GtfsRealtime.VehicleDescriptor value) {
                if (vehicleBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    vehicle_ = value;
                    onChanged();
                } else {
                    vehicleBuilder_.setMessage(value);
                }
                bitField0_ |= 0x00000002;
                return this;
            }

            /**
             * <pre>
             * Additional information on the vehicle that is serving this trip.
             * </pre>
             *
             * <code>optional .transit_realtime.VehicleDescriptor vehicle = 3;</code>
             */
            public Builder setVehicle(
                    GtfsRealtime.VehicleDescriptor.Builder builderForValue) {
                if (vehicleBuilder_ == null) {
                    vehicle_ = builderForValue.build();
                    onChanged();
                } else {
                    vehicleBuilder_.setMessage(builderForValue.build());
                }
                bitField0_ |= 0x00000002;
                return this;
            }

            /**
             * <pre>
             * Additional information on the vehicle that is serving this trip.
             * </pre>
             *
             * <code>optional .transit_realtime.VehicleDescriptor vehicle = 3;</code>
             */
            public Builder mergeVehicle(GtfsRealtime.VehicleDescriptor value) {
                if (vehicleBuilder_ == null) {
                    if (((bitField0_ & 0x00000002) != 0) &&
                            vehicle_ != null &&
                            vehicle_ != GtfsRealtime.VehicleDescriptor.getDefaultInstance()) {
                        vehicle_ =
                                GtfsRealtime.VehicleDescriptor.newBuilder(vehicle_).mergeFrom(value).buildPartial();
                    } else {
                        vehicle_ = value;
                    }
                    onChanged();
                } else {
                    vehicleBuilder_.mergeFrom(value);
                }
                bitField0_ |= 0x00000002;
                return this;
            }

            /**
             * <pre>
             * Additional information on the vehicle that is serving this trip.
             * </pre>
             *
             * <code>optional .transit_realtime.VehicleDescriptor vehicle = 3;</code>
             */
            public Builder clearVehicle() {
                if (vehicleBuilder_ == null) {
                    vehicle_ = null;
                    onChanged();
                } else {
                    vehicleBuilder_.clear();
                }
                bitField0_ = (bitField0_ & ~0x00000002);
                return this;
            }

            /**
             * <pre>
             * Additional information on the vehicle that is serving this trip.
             * </pre>
             *
             * <code>optional .transit_realtime.VehicleDescriptor vehicle = 3;</code>
             */
            public GtfsRealtime.VehicleDescriptor.Builder getVehicleBuilder() {
                bitField0_ |= 0x00000002;
                onChanged();
                return getVehicleFieldBuilder().getBuilder();
            }

            /**
             * <pre>
             * Additional information on the vehicle that is serving this trip.
             * </pre>
             *
             * <code>optional .transit_realtime.VehicleDescriptor vehicle = 3;</code>
             */
            public GtfsRealtime.VehicleDescriptorOrBuilder getVehicleOrBuilder() {
                if (vehicleBuilder_ != null) {
                    return vehicleBuilder_.getMessageOrBuilder();
                } else {
                    return vehicle_ == null ?
                            GtfsRealtime.VehicleDescriptor.getDefaultInstance() : vehicle_;
                }
            }

            /**
             * <pre>
             * Additional information on the vehicle that is serving this trip.
             * </pre>
             *
             * <code>optional .transit_realtime.VehicleDescriptor vehicle = 3;</code>
             */
            private com.google.protobuf.SingleFieldBuilderV3<
                    GtfsRealtime.VehicleDescriptor, GtfsRealtime.VehicleDescriptor.Builder, GtfsRealtime.VehicleDescriptorOrBuilder>
            getVehicleFieldBuilder() {
                if (vehicleBuilder_ == null) {
                    vehicleBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
                            GtfsRealtime.VehicleDescriptor, GtfsRealtime.VehicleDescriptor.Builder, GtfsRealtime.VehicleDescriptorOrBuilder>(
                            getVehicle(),
                            getParentForChildren(),
                            isClean());
                    vehicle_ = null;
                }
                return vehicleBuilder_;
            }

            private java.util.List<GtfsRealtime.TripUpdate.StopTimeUpdate> stopTimeUpdate_ =
                    java.util.Collections.emptyList();

            private void ensureStopTimeUpdateIsMutable() {
                if (!((bitField0_ & 0x00000004) != 0)) {
                    stopTimeUpdate_ = new java.util.ArrayList<GtfsRealtime.TripUpdate.StopTimeUpdate>(stopTimeUpdate_);
                    bitField0_ |= 0x00000004;
                }
            }

            private com.google.protobuf.RepeatedFieldBuilderV3<
                    GtfsRealtime.TripUpdate.StopTimeUpdate, GtfsRealtime.TripUpdate.StopTimeUpdate.Builder, GtfsRealtime.TripUpdate.StopTimeUpdateOrBuilder> stopTimeUpdateBuilder_;

            /**
             * <pre>
             * Updates to StopTimes for the trip (both future, i.e., predictions, and in
             * some cases, past ones, i.e., those that already happened).
             * The updates must be sorted by stop_sequence, and apply for all the
             * following stops of the trip up to the next specified one.
             * Example 1:
             * For a trip with 20 stops, a StopTimeUpdate with arrival delay and departure
             * delay of 0 for stop_sequence of the current stop means that the trip is
             * exactly on time.
             * Example 2:
             * For the same trip instance, 3 StopTimeUpdates are provided:
             * - delay of 5 min for stop_sequence 3
             * - delay of 1 min for stop_sequence 8
             * - delay of unspecified duration for stop_sequence 10
             * This will be interpreted as:
             * - stop_sequences 3,4,5,6,7 have delay of 5 min.
             * - stop_sequences 8,9 have delay of 1 min.
             * - stop_sequences 10,... have unknown delay.
             * </pre>
             *
             * <code>repeated .transit_realtime.TripUpdate.StopTimeUpdate stop_time_update = 2;</code>
             */
            public java.util.List<GtfsRealtime.TripUpdate.StopTimeUpdate> getStopTimeUpdateList() {
                if (stopTimeUpdateBuilder_ == null) {
                    return java.util.Collections.unmodifiableList(stopTimeUpdate_);
                } else {
                    return stopTimeUpdateBuilder_.getMessageList();
                }
            }

            /**
             * <pre>
             * Updates to StopTimes for the trip (both future, i.e., predictions, and in
             * some cases, past ones, i.e., those that already happened).
             * The updates must be sorted by stop_sequence, and apply for all the
             * following stops of the trip up to the next specified one.
             * Example 1:
             * For a trip with 20 stops, a StopTimeUpdate with arrival delay and departure
             * delay of 0 for stop_sequence of the current stop means that the trip is
             * exactly on time.
             * Example 2:
             * For the same trip instance, 3 StopTimeUpdates are provided:
             * - delay of 5 min for stop_sequence 3
             * - delay of 1 min for stop_sequence 8
             * - delay of unspecified duration for stop_sequence 10
             * This will be interpreted as:
             * - stop_sequences 3,4,5,6,7 have delay of 5 min.
             * - stop_sequences 8,9 have delay of 1 min.
             * - stop_sequences 10,... have unknown delay.
             * </pre>
             *
             * <code>repeated .transit_realtime.TripUpdate.StopTimeUpdate stop_time_update = 2;</code>
             */
            public int getStopTimeUpdateCount() {
                if (stopTimeUpdateBuilder_ == null) {
                    return stopTimeUpdate_.size();
                } else {
                    return stopTimeUpdateBuilder_.getCount();
                }
            }

            /**
             * <pre>
             * Updates to StopTimes for the trip (both future, i.e., predictions, and in
             * some cases, past ones, i.e., those that already happened).
             * The updates must be sorted by stop_sequence, and apply for all the
             * following stops of the trip up to the next specified one.
             * Example 1:
             * For a trip with 20 stops, a StopTimeUpdate with arrival delay and departure
             * delay of 0 for stop_sequence of the current stop means that the trip is
             * exactly on time.
             * Example 2:
             * For the same trip instance, 3 StopTimeUpdates are provided:
             * - delay of 5 min for stop_sequence 3
             * - delay of 1 min for stop_sequence 8
             * - delay of unspecified duration for stop_sequence 10
             * This will be interpreted as:
             * - stop_sequences 3,4,5,6,7 have delay of 5 min.
             * - stop_sequences 8,9 have delay of 1 min.
             * - stop_sequences 10,... have unknown delay.
             * </pre>
             *
             * <code>repeated .transit_realtime.TripUpdate.StopTimeUpdate stop_time_update = 2;</code>
             */
            public GtfsRealtime.TripUpdate.StopTimeUpdate getStopTimeUpdate(int index) {
                if (stopTimeUpdateBuilder_ == null) {
                    return stopTimeUpdate_.get(index);
                } else {
                    return stopTimeUpdateBuilder_.getMessage(index);
                }
            }

            /**
             * <pre>
             * Updates to StopTimes for the trip (both future, i.e., predictions, and in
             * some cases, past ones, i.e., those that already happened).
             * The updates must be sorted by stop_sequence, and apply for all the
             * following stops of the trip up to the next specified one.
             * Example 1:
             * For a trip with 20 stops, a StopTimeUpdate with arrival delay and departure
             * delay of 0 for stop_sequence of the current stop means that the trip is
             * exactly on time.
             * Example 2:
             * For the same trip instance, 3 StopTimeUpdates are provided:
             * - delay of 5 min for stop_sequence 3
             * - delay of 1 min for stop_sequence 8
             * - delay of unspecified duration for stop_sequence 10
             * This will be interpreted as:
             * - stop_sequences 3,4,5,6,7 have delay of 5 min.
             * - stop_sequences 8,9 have delay of 1 min.
             * - stop_sequences 10,... have unknown delay.
             * </pre>
             *
             * <code>repeated .transit_realtime.TripUpdate.StopTimeUpdate stop_time_update = 2;</code>
             */
            public Builder setStopTimeUpdate(
                    int index, GtfsRealtime.TripUpdate.StopTimeUpdate value) {
                if (stopTimeUpdateBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureStopTimeUpdateIsMutable();
                    stopTimeUpdate_.set(index, value);
                    onChanged();
                } else {
                    stopTimeUpdateBuilder_.setMessage(index, value);
                }
                return this;
            }

            /**
             * <pre>
             * Updates to StopTimes for the trip (both future, i.e., predictions, and in
             * some cases, past ones, i.e., those that already happened).
             * The updates must be sorted by stop_sequence, and apply for all the
             * following stops of the trip up to the next specified one.
             * Example 1:
             * For a trip with 20 stops, a StopTimeUpdate with arrival delay and departure
             * delay of 0 for stop_sequence of the current stop means that the trip is
             * exactly on time.
             * Example 2:
             * For the same trip instance, 3 StopTimeUpdates are provided:
             * - delay of 5 min for stop_sequence 3
             * - delay of 1 min for stop_sequence 8
             * - delay of unspecified duration for stop_sequence 10
             * This will be interpreted as:
             * - stop_sequences 3,4,5,6,7 have delay of 5 min.
             * - stop_sequences 8,9 have delay of 1 min.
             * - stop_sequences 10,... have unknown delay.
             * </pre>
             *
             * <code>repeated .transit_realtime.TripUpdate.StopTimeUpdate stop_time_update = 2;</code>
             */
            public Builder setStopTimeUpdate(
                    int index, GtfsRealtime.TripUpdate.StopTimeUpdate.Builder builderForValue) {
                if (stopTimeUpdateBuilder_ == null) {
                    ensureStopTimeUpdateIsMutable();
                    stopTimeUpdate_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    stopTimeUpdateBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            /**
             * <pre>
             * Updates to StopTimes for the trip (both future, i.e., predictions, and in
             * some cases, past ones, i.e., those that already happened).
             * The updates must be sorted by stop_sequence, and apply for all the
             * following stops of the trip up to the next specified one.
             * Example 1:
             * For a trip with 20 stops, a StopTimeUpdate with arrival delay and departure
             * delay of 0 for stop_sequence of the current stop means that the trip is
             * exactly on time.
             * Example 2:
             * For the same trip instance, 3 StopTimeUpdates are provided:
             * - delay of 5 min for stop_sequence 3
             * - delay of 1 min for stop_sequence 8
             * - delay of unspecified duration for stop_sequence 10
             * This will be interpreted as:
             * - stop_sequences 3,4,5,6,7 have delay of 5 min.
             * - stop_sequences 8,9 have delay of 1 min.
             * - stop_sequences 10,... have unknown delay.
             * </pre>
             *
             * <code>repeated .transit_realtime.TripUpdate.StopTimeUpdate stop_time_update = 2;</code>
             */
            public Builder addStopTimeUpdate(GtfsRealtime.TripUpdate.StopTimeUpdate value) {
                if (stopTimeUpdateBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureStopTimeUpdateIsMutable();
                    stopTimeUpdate_.add(value);
                    onChanged();
                } else {
                    stopTimeUpdateBuilder_.addMessage(value);
                }
                return this;
            }

            /**
             * <pre>
             * Updates to StopTimes for the trip (both future, i.e., predictions, and in
             * some cases, past ones, i.e., those that already happened).
             * The updates must be sorted by stop_sequence, and apply for all the
             * following stops of the trip up to the next specified one.
             * Example 1:
             * For a trip with 20 stops, a StopTimeUpdate with arrival delay and departure
             * delay of 0 for stop_sequence of the current stop means that the trip is
             * exactly on time.
             * Example 2:
             * For the same trip instance, 3 StopTimeUpdates are provided:
             * - delay of 5 min for stop_sequence 3
             * - delay of 1 min for stop_sequence 8
             * - delay of unspecified duration for stop_sequence 10
             * This will be interpreted as:
             * - stop_sequences 3,4,5,6,7 have delay of 5 min.
             * - stop_sequences 8,9 have delay of 1 min.
             * - stop_sequences 10,... have unknown delay.
             * </pre>
             *
             * <code>repeated .transit_realtime.TripUpdate.StopTimeUpdate stop_time_update = 2;</code>
             */
            public Builder addStopTimeUpdate(
                    int index, GtfsRealtime.TripUpdate.StopTimeUpdate value) {
                if (stopTimeUpdateBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureStopTimeUpdateIsMutable();
                    stopTimeUpdate_.add(index, value);
                    onChanged();
                } else {
                    stopTimeUpdateBuilder_.addMessage(index, value);
                }
                return this;
            }

            /**
             * <pre>
             * Updates to StopTimes for the trip (both future, i.e., predictions, and in
             * some cases, past ones, i.e., those that already happened).
             * The updates must be sorted by stop_sequence, and apply for all the
             * following stops of the trip up to the next specified one.
             * Example 1:
             * For a trip with 20 stops, a StopTimeUpdate with arrival delay and departure
             * delay of 0 for stop_sequence of the current stop means that the trip is
             * exactly on time.
             * Example 2:
             * For the same trip instance, 3 StopTimeUpdates are provided:
             * - delay of 5 min for stop_sequence 3
             * - delay of 1 min for stop_sequence 8
             * - delay of unspecified duration for stop_sequence 10
             * This will be interpreted as:
             * - stop_sequences 3,4,5,6,7 have delay of 5 min.
             * - stop_sequences 8,9 have delay of 1 min.
             * - stop_sequences 10,... have unknown delay.
             * </pre>
             *
             * <code>repeated .transit_realtime.TripUpdate.StopTimeUpdate stop_time_update = 2;</code>
             */
            public Builder addStopTimeUpdate(
                    GtfsRealtime.TripUpdate.StopTimeUpdate.Builder builderForValue) {
                if (stopTimeUpdateBuilder_ == null) {
                    ensureStopTimeUpdateIsMutable();
                    stopTimeUpdate_.add(builderForValue.build());
                    onChanged();
                } else {
                    stopTimeUpdateBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            /**
             * <pre>
             * Updates to StopTimes for the trip (both future, i.e., predictions, and in
             * some cases, past ones, i.e., those that already happened).
             * The updates must be sorted by stop_sequence, and apply for all the
             * following stops of the trip up to the next specified one.
             * Example 1:
             * For a trip with 20 stops, a StopTimeUpdate with arrival delay and departure
             * delay of 0 for stop_sequence of the current stop means that the trip is
             * exactly on time.
             * Example 2:
             * For the same trip instance, 3 StopTimeUpdates are provided:
             * - delay of 5 min for stop_sequence 3
             * - delay of 1 min for stop_sequence 8
             * - delay of unspecified duration for stop_sequence 10
             * This will be interpreted as:
             * - stop_sequences 3,4,5,6,7 have delay of 5 min.
             * - stop_sequences 8,9 have delay of 1 min.
             * - stop_sequences 10,... have unknown delay.
             * </pre>
             *
             * <code>repeated .transit_realtime.TripUpdate.StopTimeUpdate stop_time_update = 2;</code>
             */
            public Builder addStopTimeUpdate(
                    int index, GtfsRealtime.TripUpdate.StopTimeUpdate.Builder builderForValue) {
                if (stopTimeUpdateBuilder_ == null) {
                    ensureStopTimeUpdateIsMutable();
                    stopTimeUpdate_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    stopTimeUpdateBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            /**
             * <pre>
             * Updates to StopTimes for the trip (both future, i.e., predictions, and in
             * some cases, past ones, i.e., those that already happened).
             * The updates must be sorted by stop_sequence, and apply for all the
             * following stops of the trip up to the next specified one.
             * Example 1:
             * For a trip with 20 stops, a StopTimeUpdate with arrival delay and departure
             * delay of 0 for stop_sequence of the current stop means that the trip is
             * exactly on time.
             * Example 2:
             * For the same trip instance, 3 StopTimeUpdates are provided:
             * - delay of 5 min for stop_sequence 3
             * - delay of 1 min for stop_sequence 8
             * - delay of unspecified duration for stop_sequence 10
             * This will be interpreted as:
             * - stop_sequences 3,4,5,6,7 have delay of 5 min.
             * - stop_sequences 8,9 have delay of 1 min.
             * - stop_sequences 10,... have unknown delay.
             * </pre>
             *
             * <code>repeated .transit_realtime.TripUpdate.StopTimeUpdate stop_time_update = 2;</code>
             */
            public Builder addAllStopTimeUpdate(
                    java.lang.Iterable<? extends GtfsRealtime.TripUpdate.StopTimeUpdate> values) {
                if (stopTimeUpdateBuilder_ == null) {
                    ensureStopTimeUpdateIsMutable();
                    com.google.protobuf.AbstractMessageLite.Builder.addAll(
                            values, stopTimeUpdate_);
                    onChanged();
                } else {
                    stopTimeUpdateBuilder_.addAllMessages(values);
                }
                return this;
            }

            /**
             * <pre>
             * Updates to StopTimes for the trip (both future, i.e., predictions, and in
             * some cases, past ones, i.e., those that already happened).
             * The updates must be sorted by stop_sequence, and apply for all the
             * following stops of the trip up to the next specified one.
             * Example 1:
             * For a trip with 20 stops, a StopTimeUpdate with arrival delay and departure
             * delay of 0 for stop_sequence of the current stop means that the trip is
             * exactly on time.
             * Example 2:
             * For the same trip instance, 3 StopTimeUpdates are provided:
             * - delay of 5 min for stop_sequence 3
             * - delay of 1 min for stop_sequence 8
             * - delay of unspecified duration for stop_sequence 10
             * This will be interpreted as:
             * - stop_sequences 3,4,5,6,7 have delay of 5 min.
             * - stop_sequences 8,9 have delay of 1 min.
             * - stop_sequences 10,... have unknown delay.
             * </pre>
             *
             * <code>repeated .transit_realtime.TripUpdate.StopTimeUpdate stop_time_update = 2;</code>
             */
            public Builder clearStopTimeUpdate() {
                if (stopTimeUpdateBuilder_ == null) {
                    stopTimeUpdate_ = java.util.Collections.emptyList();
                    bitField0_ = (bitField0_ & ~0x00000004);
                    onChanged();
                } else {
                    stopTimeUpdateBuilder_.clear();
                }
                return this;
            }

            /**
             * <pre>
             * Updates to StopTimes for the trip (both future, i.e., predictions, and in
             * some cases, past ones, i.e., those that already happened).
             * The updates must be sorted by stop_sequence, and apply for all the
             * following stops of the trip up to the next specified one.
             * Example 1:
             * For a trip with 20 stops, a StopTimeUpdate with arrival delay and departure
             * delay of 0 for stop_sequence of the current stop means that the trip is
             * exactly on time.
             * Example 2:
             * For the same trip instance, 3 StopTimeUpdates are provided:
             * - delay of 5 min for stop_sequence 3
             * - delay of 1 min for stop_sequence 8
             * - delay of unspecified duration for stop_sequence 10
             * This will be interpreted as:
             * - stop_sequences 3,4,5,6,7 have delay of 5 min.
             * - stop_sequences 8,9 have delay of 1 min.
             * - stop_sequences 10,... have unknown delay.
             * </pre>
             *
             * <code>repeated .transit_realtime.TripUpdate.StopTimeUpdate stop_time_update = 2;</code>
             */
            public Builder removeStopTimeUpdate(int index) {
                if (stopTimeUpdateBuilder_ == null) {
                    ensureStopTimeUpdateIsMutable();
                    stopTimeUpdate_.remove(index);
                    onChanged();
                } else {
                    stopTimeUpdateBuilder_.remove(index);
                }
                return this;
            }

            /**
             * <pre>
             * Updates to StopTimes for the trip (both future, i.e., predictions, and in
             * some cases, past ones, i.e., those that already happened).
             * The updates must be sorted by stop_sequence, and apply for all the
             * following stops of the trip up to the next specified one.
             * Example 1:
             * For a trip with 20 stops, a StopTimeUpdate with arrival delay and departure
             * delay of 0 for stop_sequence of the current stop means that the trip is
             * exactly on time.
             * Example 2:
             * For the same trip instance, 3 StopTimeUpdates are provided:
             * - delay of 5 min for stop_sequence 3
             * - delay of 1 min for stop_sequence 8
             * - delay of unspecified duration for stop_sequence 10
             * This will be interpreted as:
             * - stop_sequences 3,4,5,6,7 have delay of 5 min.
             * - stop_sequences 8,9 have delay of 1 min.
             * - stop_sequences 10,... have unknown delay.
             * </pre>
             *
             * <code>repeated .transit_realtime.TripUpdate.StopTimeUpdate stop_time_update = 2;</code>
             */
            public GtfsRealtime.TripUpdate.StopTimeUpdate.Builder getStopTimeUpdateBuilder(
                    int index) {
                return getStopTimeUpdateFieldBuilder().getBuilder(index);
            }

            /**
             * <pre>
             * Updates to StopTimes for the trip (both future, i.e., predictions, and in
             * some cases, past ones, i.e., those that already happened).
             * The updates must be sorted by stop_sequence, and apply for all the
             * following stops of the trip up to the next specified one.
             * Example 1:
             * For a trip with 20 stops, a StopTimeUpdate with arrival delay and departure
             * delay of 0 for stop_sequence of the current stop means that the trip is
             * exactly on time.
             * Example 2:
             * For the same trip instance, 3 StopTimeUpdates are provided:
             * - delay of 5 min for stop_sequence 3
             * - delay of 1 min for stop_sequence 8
             * - delay of unspecified duration for stop_sequence 10
             * This will be interpreted as:
             * - stop_sequences 3,4,5,6,7 have delay of 5 min.
             * - stop_sequences 8,9 have delay of 1 min.
             * - stop_sequences 10,... have unknown delay.
             * </pre>
             *
             * <code>repeated .transit_realtime.TripUpdate.StopTimeUpdate stop_time_update = 2;</code>
             */
            public GtfsRealtime.TripUpdate.StopTimeUpdateOrBuilder getStopTimeUpdateOrBuilder(
                    int index) {
                if (stopTimeUpdateBuilder_ == null) {
                    return stopTimeUpdate_.get(index);
                } else {
                    return stopTimeUpdateBuilder_.getMessageOrBuilder(index);
                }
            }

            /**
             * <pre>
             * Updates to StopTimes for the trip (both future, i.e., predictions, and in
             * some cases, past ones, i.e., those that already happened).
             * The updates must be sorted by stop_sequence, and apply for all the
             * following stops of the trip up to the next specified one.
             * Example 1:
             * For a trip with 20 stops, a StopTimeUpdate with arrival delay and departure
             * delay of 0 for stop_sequence of the current stop means that the trip is
             * exactly on time.
             * Example 2:
             * For the same trip instance, 3 StopTimeUpdates are provided:
             * - delay of 5 min for stop_sequence 3
             * - delay of 1 min for stop_sequence 8
             * - delay of unspecified duration for stop_sequence 10
             * This will be interpreted as:
             * - stop_sequences 3,4,5,6,7 have delay of 5 min.
             * - stop_sequences 8,9 have delay of 1 min.
             * - stop_sequences 10,... have unknown delay.
             * </pre>
             *
             * <code>repeated .transit_realtime.TripUpdate.StopTimeUpdate stop_time_update = 2;</code>
             */
            public java.util.List<? extends GtfsRealtime.TripUpdate.StopTimeUpdateOrBuilder>
            getStopTimeUpdateOrBuilderList() {
                if (stopTimeUpdateBuilder_ != null) {
                    return stopTimeUpdateBuilder_.getMessageOrBuilderList();
                } else {
                    return java.util.Collections.unmodifiableList(stopTimeUpdate_);
                }
            }

            /**
             * <pre>
             * Updates to StopTimes for the trip (both future, i.e., predictions, and in
             * some cases, past ones, i.e., those that already happened).
             * The updates must be sorted by stop_sequence, and apply for all the
             * following stops of the trip up to the next specified one.
             * Example 1:
             * For a trip with 20 stops, a StopTimeUpdate with arrival delay and departure
             * delay of 0 for stop_sequence of the current stop means that the trip is
             * exactly on time.
             * Example 2:
             * For the same trip instance, 3 StopTimeUpdates are provided:
             * - delay of 5 min for stop_sequence 3
             * - delay of 1 min for stop_sequence 8
             * - delay of unspecified duration for stop_sequence 10
             * This will be interpreted as:
             * - stop_sequences 3,4,5,6,7 have delay of 5 min.
             * - stop_sequences 8,9 have delay of 1 min.
             * - stop_sequences 10,... have unknown delay.
             * </pre>
             *
             * <code>repeated .transit_realtime.TripUpdate.StopTimeUpdate stop_time_update = 2;</code>
             */
            public GtfsRealtime.TripUpdate.StopTimeUpdate.Builder addStopTimeUpdateBuilder() {
                return getStopTimeUpdateFieldBuilder().addBuilder(
                        GtfsRealtime.TripUpdate.StopTimeUpdate.getDefaultInstance());
            }

            /**
             * <pre>
             * Updates to StopTimes for the trip (both future, i.e., predictions, and in
             * some cases, past ones, i.e., those that already happened).
             * The updates must be sorted by stop_sequence, and apply for all the
             * following stops of the trip up to the next specified one.
             * Example 1:
             * For a trip with 20 stops, a StopTimeUpdate with arrival delay and departure
             * delay of 0 for stop_sequence of the current stop means that the trip is
             * exactly on time.
             * Example 2:
             * For the same trip instance, 3 StopTimeUpdates are provided:
             * - delay of 5 min for stop_sequence 3
             * - delay of 1 min for stop_sequence 8
             * - delay of unspecified duration for stop_sequence 10
             * This will be interpreted as:
             * - stop_sequences 3,4,5,6,7 have delay of 5 min.
             * - stop_sequences 8,9 have delay of 1 min.
             * - stop_sequences 10,... have unknown delay.
             * </pre>
             *
             * <code>repeated .transit_realtime.TripUpdate.StopTimeUpdate stop_time_update = 2;</code>
             */
            public GtfsRealtime.TripUpdate.StopTimeUpdate.Builder addStopTimeUpdateBuilder(
                    int index) {
                return getStopTimeUpdateFieldBuilder().addBuilder(
                        index, GtfsRealtime.TripUpdate.StopTimeUpdate.getDefaultInstance());
            }

            /**
             * <pre>
             * Updates to StopTimes for the trip (both future, i.e., predictions, and in
             * some cases, past ones, i.e., those that already happened).
             * The updates must be sorted by stop_sequence, and apply for all the
             * following stops of the trip up to the next specified one.
             * Example 1:
             * For a trip with 20 stops, a StopTimeUpdate with arrival delay and departure
             * delay of 0 for stop_sequence of the current stop means that the trip is
             * exactly on time.
             * Example 2:
             * For the same trip instance, 3 StopTimeUpdates are provided:
             * - delay of 5 min for stop_sequence 3
             * - delay of 1 min for stop_sequence 8
             * - delay of unspecified duration for stop_sequence 10
             * This will be interpreted as:
             * - stop_sequences 3,4,5,6,7 have delay of 5 min.
             * - stop_sequences 8,9 have delay of 1 min.
             * - stop_sequences 10,... have unknown delay.
             * </pre>
             *
             * <code>repeated .transit_realtime.TripUpdate.StopTimeUpdate stop_time_update = 2;</code>
             */
            public java.util.List<GtfsRealtime.TripUpdate.StopTimeUpdate.Builder>
            getStopTimeUpdateBuilderList() {
                return getStopTimeUpdateFieldBuilder().getBuilderList();
            }

            private com.google.protobuf.RepeatedFieldBuilderV3<
                    GtfsRealtime.TripUpdate.StopTimeUpdate, GtfsRealtime.TripUpdate.StopTimeUpdate.Builder, GtfsRealtime.TripUpdate.StopTimeUpdateOrBuilder>
            getStopTimeUpdateFieldBuilder() {
                if (stopTimeUpdateBuilder_ == null) {
                    stopTimeUpdateBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
                            GtfsRealtime.TripUpdate.StopTimeUpdate, GtfsRealtime.TripUpdate.StopTimeUpdate.Builder, GtfsRealtime.TripUpdate.StopTimeUpdateOrBuilder>(
                            stopTimeUpdate_,
                            ((bitField0_ & 0x00000004) != 0),
                            getParentForChildren(),
                            isClean());
                    stopTimeUpdate_ = null;
                }
                return stopTimeUpdateBuilder_;
            }

            private long timestamp_;

            /**
             * <pre>
             * Moment at which the vehicle's real-time progress was measured. In POSIX
             * time (i.e., the number of seconds since January 1st 1970 00:00:00 UTC).
             * </pre>
             *
             * <code>optional uint64 timestamp = 4;</code>
             */
            public boolean hasTimestamp() {
                return ((bitField0_ & 0x00000008) != 0);
            }

            /**
             * <pre>
             * Moment at which the vehicle's real-time progress was measured. In POSIX
             * time (i.e., the number of seconds since January 1st 1970 00:00:00 UTC).
             * </pre>
             *
             * <code>optional uint64 timestamp = 4;</code>
             */
            public long getTimestamp() {
                return timestamp_;
            }

            /**
             * <pre>
             * Moment at which the vehicle's real-time progress was measured. In POSIX
             * time (i.e., the number of seconds since January 1st 1970 00:00:00 UTC).
             * </pre>
             *
             * <code>optional uint64 timestamp = 4;</code>
             */
            public Builder setTimestamp(long value) {
                bitField0_ |= 0x00000008;
                timestamp_ = value;
                onChanged();
                return this;
            }

            /**
             * <pre>
             * Moment at which the vehicle's real-time progress was measured. In POSIX
             * time (i.e., the number of seconds since January 1st 1970 00:00:00 UTC).
             * </pre>
             *
             * <code>optional uint64 timestamp = 4;</code>
             */
            public Builder clearTimestamp() {
                bitField0_ = (bitField0_ & ~0x00000008);
                timestamp_ = 0L;
                onChanged();
                return this;
            }

            private int delay_;

            /**
             * <pre>
             * The current schedule deviation for the trip.  Delay should only be
             * specified when the prediction is given relative to some existing schedule
             * in GTFS.
             * Delay (in seconds) can be positive (meaning that the vehicle is late) or
             * negative (meaning that the vehicle is ahead of schedule). Delay of 0
             * means that the vehicle is exactly on time.
             * Delay information in StopTimeUpdates take precedent of trip-level delay
             * information, such that trip-level delay is only propagated until the next
             * stop along the trip with a StopTimeUpdate delay value specified.
             * Feed providers are strongly encouraged to provide a TripUpdate.timestamp
             * value indicating when the delay value was last updated, in order to
             * evaluate the freshness of the data.
             * NOTE: This field is still experimental, and subject to change. It may be
             * formally adopted in the future.
             * </pre>
             *
             * <code>optional int32 delay = 5;</code>
             */
            public boolean hasDelay() {
                return ((bitField0_ & 0x00000010) != 0);
            }

            /**
             * <pre>
             * The current schedule deviation for the trip.  Delay should only be
             * specified when the prediction is given relative to some existing schedule
             * in GTFS.
             * Delay (in seconds) can be positive (meaning that the vehicle is late) or
             * negative (meaning that the vehicle is ahead of schedule). Delay of 0
             * means that the vehicle is exactly on time.
             * Delay information in StopTimeUpdates take precedent of trip-level delay
             * information, such that trip-level delay is only propagated until the next
             * stop along the trip with a StopTimeUpdate delay value specified.
             * Feed providers are strongly encouraged to provide a TripUpdate.timestamp
             * value indicating when the delay value was last updated, in order to
             * evaluate the freshness of the data.
             * NOTE: This field is still experimental, and subject to change. It may be
             * formally adopted in the future.
             * </pre>
             *
             * <code>optional int32 delay = 5;</code>
             */
            public int getDelay() {
                return delay_;
            }

            /**
             * <pre>
             * The current schedule deviation for the trip.  Delay should only be
             * specified when the prediction is given relative to some existing schedule
             * in GTFS.
             * Delay (in seconds) can be positive (meaning that the vehicle is late) or
             * negative (meaning that the vehicle is ahead of schedule). Delay of 0
             * means that the vehicle is exactly on time.
             * Delay information in StopTimeUpdates take precedent of trip-level delay
             * information, such that trip-level delay is only propagated until the next
             * stop along the trip with a StopTimeUpdate delay value specified.
             * Feed providers are strongly encouraged to provide a TripUpdate.timestamp
             * value indicating when the delay value was last updated, in order to
             * evaluate the freshness of the data.
             * NOTE: This field is still experimental, and subject to change. It may be
             * formally adopted in the future.
             * </pre>
             *
             * <code>optional int32 delay = 5;</code>
             */
            public Builder setDelay(int value) {
                bitField0_ |= 0x00000010;
                delay_ = value;
                onChanged();
                return this;
            }

            /**
             * <pre>
             * The current schedule deviation for the trip.  Delay should only be
             * specified when the prediction is given relative to some existing schedule
             * in GTFS.
             * Delay (in seconds) can be positive (meaning that the vehicle is late) or
             * negative (meaning that the vehicle is ahead of schedule). Delay of 0
             * means that the vehicle is exactly on time.
             * Delay information in StopTimeUpdates take precedent of trip-level delay
             * information, such that trip-level delay is only propagated until the next
             * stop along the trip with a StopTimeUpdate delay value specified.
             * Feed providers are strongly encouraged to provide a TripUpdate.timestamp
             * value indicating when the delay value was last updated, in order to
             * evaluate the freshness of the data.
             * NOTE: This field is still experimental, and subject to change. It may be
             * formally adopted in the future.
             * </pre>
             *
             * <code>optional int32 delay = 5;</code>
             */
            public Builder clearDelay() {
                bitField0_ = (bitField0_ & ~0x00000010);
                delay_ = 0;
                onChanged();
                return this;
            }

            @java.lang.Override
            public final Builder setUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.setUnknownFields(unknownFields);
            }

            @java.lang.Override
            public final Builder mergeUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.mergeUnknownFields(unknownFields);
            }


            // @@protoc_insertion_point(builder_scope:transit_realtime.TripUpdate)
        }

        // @@protoc_insertion_point(class_scope:transit_realtime.TripUpdate)
        private static final GtfsRealtime.TripUpdate DEFAULT_INSTANCE;

        static {
            DEFAULT_INSTANCE = new GtfsRealtime.TripUpdate();
        }

        public static GtfsRealtime.TripUpdate getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        @java.lang.Deprecated
        public static final com.google.protobuf.Parser<TripUpdate>
                PARSER = new com.google.protobuf.AbstractParser<TripUpdate>() {
            @java.lang.Override
            public TripUpdate parsePartialFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return new TripUpdate(input, extensionRegistry);
            }
        };

        public static com.google.protobuf.Parser<TripUpdate> parser() {
            return PARSER;
        }

        @java.lang.Override
        public com.google.protobuf.Parser<TripUpdate> getParserForType() {
            return PARSER;
        }

        @java.lang.Override
        public GtfsRealtime.TripUpdate getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

    }

    public interface VehiclePositionOrBuilder extends
            // @@protoc_insertion_point(interface_extends:transit_realtime.VehiclePosition)
            com.google.protobuf.GeneratedMessageV3.
                    ExtendableMessageOrBuilder<VehiclePosition> {

        /**
         * <pre>
         * The Trip that this vehicle is serving.
         * Can be empty or partial if the vehicle can not be identified with a given
         * trip instance.
         * </pre>
         *
         * <code>optional .transit_realtime.TripDescriptor trip = 1;</code>
         */
        boolean hasTrip();

        /**
         * <pre>
         * The Trip that this vehicle is serving.
         * Can be empty or partial if the vehicle can not be identified with a given
         * trip instance.
         * </pre>
         *
         * <code>optional .transit_realtime.TripDescriptor trip = 1;</code>
         */
        GtfsRealtime.TripDescriptor getTrip();

        /**
         * <pre>
         * The Trip that this vehicle is serving.
         * Can be empty or partial if the vehicle can not be identified with a given
         * trip instance.
         * </pre>
         *
         * <code>optional .transit_realtime.TripDescriptor trip = 1;</code>
         */
        GtfsRealtime.TripDescriptorOrBuilder getTripOrBuilder();

        /**
         * <pre>
         * Additional information on the vehicle that is serving this trip.
         * </pre>
         *
         * <code>optional .transit_realtime.VehicleDescriptor vehicle = 8;</code>
         */
        boolean hasVehicle();

        /**
         * <pre>
         * Additional information on the vehicle that is serving this trip.
         * </pre>
         *
         * <code>optional .transit_realtime.VehicleDescriptor vehicle = 8;</code>
         */
        GtfsRealtime.VehicleDescriptor getVehicle();

        /**
         * <pre>
         * Additional information on the vehicle that is serving this trip.
         * </pre>
         *
         * <code>optional .transit_realtime.VehicleDescriptor vehicle = 8;</code>
         */
        GtfsRealtime.VehicleDescriptorOrBuilder getVehicleOrBuilder();

        /**
         * <pre>
         * Current position of this vehicle.
         * </pre>
         *
         * <code>optional .transit_realtime.Position position = 2;</code>
         */
        boolean hasPosition();

        /**
         * <pre>
         * Current position of this vehicle.
         * </pre>
         *
         * <code>optional .transit_realtime.Position position = 2;</code>
         */
        GtfsRealtime.Position getPosition();

        /**
         * <pre>
         * Current position of this vehicle.
         * </pre>
         *
         * <code>optional .transit_realtime.Position position = 2;</code>
         */
        GtfsRealtime.PositionOrBuilder getPositionOrBuilder();

        /**
         * <pre>
         * The stop sequence index of the current stop. The meaning of
         * current_stop_sequence (i.e., the stop that it refers to) is determined by
         * current_status.
         * If current_status is missing IN_TRANSIT_TO is assumed.
         * </pre>
         *
         * <code>optional uint32 current_stop_sequence = 3;</code>
         */
        boolean hasCurrentStopSequence();

        /**
         * <pre>
         * The stop sequence index of the current stop. The meaning of
         * current_stop_sequence (i.e., the stop that it refers to) is determined by
         * current_status.
         * If current_status is missing IN_TRANSIT_TO is assumed.
         * </pre>
         *
         * <code>optional uint32 current_stop_sequence = 3;</code>
         */
        int getCurrentStopSequence();

        /**
         * <pre>
         * Identifies the current stop. The value must be the same as in stops.txt in
         * the corresponding GTFS feed.
         * </pre>
         *
         * <code>optional string stop_id = 7;</code>
         */
        boolean hasStopId();

        /**
         * <pre>
         * Identifies the current stop. The value must be the same as in stops.txt in
         * the corresponding GTFS feed.
         * </pre>
         *
         * <code>optional string stop_id = 7;</code>
         */
        java.lang.String getStopId();

        /**
         * <pre>
         * Identifies the current stop. The value must be the same as in stops.txt in
         * the corresponding GTFS feed.
         * </pre>
         *
         * <code>optional string stop_id = 7;</code>
         */
        com.google.protobuf.ByteString
        getStopIdBytes();

        /**
         * <pre>
         * The exact status of the vehicle with respect to the current stop.
         * Ignored if current_stop_sequence is missing.
         * </pre>
         *
         * <code>optional .transit_realtime.VehiclePosition.VehicleStopStatus current_status = 4 [default = IN_TRANSIT_TO];</code>
         */
        boolean hasCurrentStatus();

        /**
         * <pre>
         * The exact status of the vehicle with respect to the current stop.
         * Ignored if current_stop_sequence is missing.
         * </pre>
         *
         * <code>optional .transit_realtime.VehiclePosition.VehicleStopStatus current_status = 4 [default = IN_TRANSIT_TO];</code>
         */
        GtfsRealtime.VehiclePosition.VehicleStopStatus getCurrentStatus();

        /**
         * <pre>
         * Moment at which the vehicle's position was measured. In POSIX time
         * (i.e., number of seconds since January 1st 1970 00:00:00 UTC).
         * </pre>
         *
         * <code>optional uint64 timestamp = 5;</code>
         */
        boolean hasTimestamp();

        /**
         * <pre>
         * Moment at which the vehicle's position was measured. In POSIX time
         * (i.e., number of seconds since January 1st 1970 00:00:00 UTC).
         * </pre>
         *
         * <code>optional uint64 timestamp = 5;</code>
         */
        long getTimestamp();

        /**
         * <code>optional .transit_realtime.VehiclePosition.CongestionLevel congestion_level = 6;</code>
         */
        boolean hasCongestionLevel();

        /**
         * <code>optional .transit_realtime.VehiclePosition.CongestionLevel congestion_level = 6;</code>
         */
        GtfsRealtime.VehiclePosition.CongestionLevel getCongestionLevel();

        /**
         * <code>optional .transit_realtime.VehiclePosition.OccupancyStatus occupancy_status = 9;</code>
         */
        boolean hasOccupancyStatus();

        /**
         * <code>optional .transit_realtime.VehiclePosition.OccupancyStatus occupancy_status = 9;</code>
         */
        GtfsRealtime.VehiclePosition.OccupancyStatus getOccupancyStatus();
    }

    /**
     * <pre>
     * Realtime positioning information for a given vehicle.
     * </pre>
     * <p>
     * Protobuf type {@code transit_realtime.VehiclePosition}
     */
    public static final class VehiclePosition extends
            com.google.protobuf.GeneratedMessageV3.ExtendableMessage<
                    VehiclePosition> implements
            // @@protoc_insertion_point(message_implements:transit_realtime.VehiclePosition)
            VehiclePositionOrBuilder {
        private static final long serialVersionUID = 0L;

        // Use VehiclePosition.newBuilder() to construct.
        private VehiclePosition(com.google.protobuf.GeneratedMessageV3.ExtendableBuilder<GtfsRealtime.VehiclePosition, ?> builder) {
            super(builder);
        }

        private VehiclePosition() {
            stopId_ = "";
            currentStatus_ = 2;
            congestionLevel_ = 0;
            occupancyStatus_ = 0;
        }

        @java.lang.Override
        @SuppressWarnings({"unused"})
        protected java.lang.Object newInstance(
                UnusedPrivateParameter unused) {
            return new VehiclePosition();
        }

        @java.lang.Override
        public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
            return this.unknownFields;
        }

        private VehiclePosition(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            if (extensionRegistry == null) {
                throw new java.lang.NullPointerException();
            }
            int mutable_bitField0_ = 0;
            com.google.protobuf.UnknownFieldSet.Builder unknownFields =
                    com.google.protobuf.UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        case 10: {
                            GtfsRealtime.TripDescriptor.Builder subBuilder = null;
                            if (((bitField0_ & 0x00000001) != 0)) {
                                subBuilder = trip_.toBuilder();
                            }
                            trip_ = input.readMessage(GtfsRealtime.TripDescriptor.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(trip_);
                                trip_ = subBuilder.buildPartial();
                            }
                            bitField0_ |= 0x00000001;
                            break;
                        }
                        case 18: {
                            GtfsRealtime.Position.Builder subBuilder = null;
                            if (((bitField0_ & 0x00000004) != 0)) {
                                subBuilder = position_.toBuilder();
                            }
                            position_ = input.readMessage(GtfsRealtime.Position.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(position_);
                                position_ = subBuilder.buildPartial();
                            }
                            bitField0_ |= 0x00000004;
                            break;
                        }
                        case 24: {
                            bitField0_ |= 0x00000008;
                            currentStopSequence_ = input.readUInt32();
                            break;
                        }
                        case 32: {
                            int rawValue = input.readEnum();
                            @SuppressWarnings("deprecation")
                            GtfsRealtime.VehiclePosition.VehicleStopStatus value = GtfsRealtime.VehiclePosition.VehicleStopStatus.valueOf(rawValue);
                            if (value == null) {
                                unknownFields.mergeVarintField(4, rawValue);
                            } else {
                                bitField0_ |= 0x00000020;
                                currentStatus_ = rawValue;
                            }
                            break;
                        }
                        case 40: {
                            bitField0_ |= 0x00000040;
                            timestamp_ = input.readUInt64();
                            break;
                        }
                        case 48: {
                            int rawValue = input.readEnum();
                            @SuppressWarnings("deprecation")
                            GtfsRealtime.VehiclePosition.CongestionLevel value = GtfsRealtime.VehiclePosition.CongestionLevel.valueOf(rawValue);
                            if (value == null) {
                                unknownFields.mergeVarintField(6, rawValue);
                            } else {
                                bitField0_ |= 0x00000080;
                                congestionLevel_ = rawValue;
                            }
                            break;
                        }
                        case 58: {
                            com.google.protobuf.ByteString bs = input.readBytes();
                            bitField0_ |= 0x00000010;
                            stopId_ = bs;
                            break;
                        }
                        case 66: {
                            GtfsRealtime.VehicleDescriptor.Builder subBuilder = null;
                            if (((bitField0_ & 0x00000002) != 0)) {
                                subBuilder = vehicle_.toBuilder();
                            }
                            vehicle_ = input.readMessage(GtfsRealtime.VehicleDescriptor.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(vehicle_);
                                vehicle_ = subBuilder.buildPartial();
                            }
                            bitField0_ |= 0x00000002;
                            break;
                        }
                        case 72: {
                            int rawValue = input.readEnum();
                            @SuppressWarnings("deprecation")
                            GtfsRealtime.VehiclePosition.OccupancyStatus value = GtfsRealtime.VehiclePosition.OccupancyStatus.valueOf(rawValue);
                            if (value == null) {
                                unknownFields.mergeVarintField(9, rawValue);
                            } else {
                                bitField0_ |= 0x00000100;
                                occupancyStatus_ = rawValue;
                            }
                            break;
                        }
                        default: {
                            if (!parseUnknownField(
                                    input, unknownFields, extensionRegistry, tag)) {
                                done = true;
                            }
                            break;
                        }
                    }
                }
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (java.io.IOException e) {
                throw new com.google.protobuf.InvalidProtocolBufferException(
                        e).setUnfinishedMessage(this);
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return GtfsRealtime.internal_static_transit_realtime_VehiclePosition_descriptor;
        }

        @java.lang.Override
        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return GtfsRealtime.internal_static_transit_realtime_VehiclePosition_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            GtfsRealtime.VehiclePosition.class, GtfsRealtime.VehiclePosition.Builder.class);
        }

        /**
         * Protobuf enum {@code transit_realtime.VehiclePosition.VehicleStopStatus}
         */
        public enum VehicleStopStatus
                implements com.google.protobuf.ProtocolMessageEnum {
            /**
             * <pre>
             * The vehicle is just about to arrive at the stop (on a stop
             * display, the vehicle symbol typically flashes).
             * </pre>
             *
             * <code>INCOMING_AT = 0;</code>
             */
            INCOMING_AT(0),
            /**
             * <pre>
             * The vehicle is standing at the stop.
             * </pre>
             *
             * <code>STOPPED_AT = 1;</code>
             */
            STOPPED_AT(1),
            /**
             * <pre>
             * The vehicle has departed and is in transit to the next stop.
             * </pre>
             *
             * <code>IN_TRANSIT_TO = 2;</code>
             */
            IN_TRANSIT_TO(2),
            ;

            /**
             * <pre>
             * The vehicle is just about to arrive at the stop (on a stop
             * display, the vehicle symbol typically flashes).
             * </pre>
             *
             * <code>INCOMING_AT = 0;</code>
             */
            public static final int INCOMING_AT_VALUE = 0;
            /**
             * <pre>
             * The vehicle is standing at the stop.
             * </pre>
             *
             * <code>STOPPED_AT = 1;</code>
             */
            public static final int STOPPED_AT_VALUE = 1;
            /**
             * <pre>
             * The vehicle has departed and is in transit to the next stop.
             * </pre>
             *
             * <code>IN_TRANSIT_TO = 2;</code>
             */
            public static final int IN_TRANSIT_TO_VALUE = 2;


            public final int getNumber() {
                return value;
            }

            /**
             * @deprecated Use {@link #forNumber(int)} instead.
             */
            @java.lang.Deprecated
            public static VehicleStopStatus valueOf(int value) {
                return forNumber(value);
            }

            public static VehicleStopStatus forNumber(int value) {
                switch (value) {
                    case 0:
                        return INCOMING_AT;
                    case 1:
                        return STOPPED_AT;
                    case 2:
                        return IN_TRANSIT_TO;
                    default:
                        return null;
                }
            }

            public static com.google.protobuf.Internal.EnumLiteMap<VehicleStopStatus>
            internalGetValueMap() {
                return internalValueMap;
            }

            private static final com.google.protobuf.Internal.EnumLiteMap<
                    VehicleStopStatus> internalValueMap =
                    new com.google.protobuf.Internal.EnumLiteMap<VehicleStopStatus>() {
                        public VehicleStopStatus findValueByNumber(int number) {
                            return VehicleStopStatus.forNumber(number);
                        }
                    };

            public final com.google.protobuf.Descriptors.EnumValueDescriptor
            getValueDescriptor() {
                return getDescriptor().getValues().get(ordinal());
            }

            public final com.google.protobuf.Descriptors.EnumDescriptor
            getDescriptorForType() {
                return getDescriptor();
            }

            public static final com.google.protobuf.Descriptors.EnumDescriptor
            getDescriptor() {
                return GtfsRealtime.VehiclePosition.getDescriptor().getEnumTypes().get(0);
            }

            private static final VehicleStopStatus[] VALUES = values();

            public static VehicleStopStatus valueOf(
                    com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
                if (desc.getType() != getDescriptor()) {
                    throw new java.lang.IllegalArgumentException(
                            "EnumValueDescriptor is not for this type.");
                }
                return VALUES[desc.getIndex()];
            }

            private final int value;

            private VehicleStopStatus(int value) {
                this.value = value;
            }

            // @@protoc_insertion_point(enum_scope:transit_realtime.VehiclePosition.VehicleStopStatus)
        }

        /**
         * <pre>
         * Congestion level that is affecting this vehicle.
         * </pre>
         * <p>
         * Protobuf enum {@code transit_realtime.VehiclePosition.CongestionLevel}
         */
        public enum CongestionLevel
                implements com.google.protobuf.ProtocolMessageEnum {
            /**
             * <code>UNKNOWN_CONGESTION_LEVEL = 0;</code>
             */
            UNKNOWN_CONGESTION_LEVEL(0),
            /**
             * <code>RUNNING_SMOOTHLY = 1;</code>
             */
            RUNNING_SMOOTHLY(1),
            /**
             * <code>STOP_AND_GO = 2;</code>
             */
            STOP_AND_GO(2),
            /**
             * <code>CONGESTION = 3;</code>
             */
            CONGESTION(3),
            /**
             * <pre>
             * People leaving their cars.
             * </pre>
             *
             * <code>SEVERE_CONGESTION = 4;</code>
             */
            SEVERE_CONGESTION(4),
            ;

            /**
             * <code>UNKNOWN_CONGESTION_LEVEL = 0;</code>
             */
            public static final int UNKNOWN_CONGESTION_LEVEL_VALUE = 0;
            /**
             * <code>RUNNING_SMOOTHLY = 1;</code>
             */
            public static final int RUNNING_SMOOTHLY_VALUE = 1;
            /**
             * <code>STOP_AND_GO = 2;</code>
             */
            public static final int STOP_AND_GO_VALUE = 2;
            /**
             * <code>CONGESTION = 3;</code>
             */
            public static final int CONGESTION_VALUE = 3;
            /**
             * <pre>
             * People leaving their cars.
             * </pre>
             *
             * <code>SEVERE_CONGESTION = 4;</code>
             */
            public static final int SEVERE_CONGESTION_VALUE = 4;


            public final int getNumber() {
                return value;
            }

            /**
             * @deprecated Use {@link #forNumber(int)} instead.
             */
            @java.lang.Deprecated
            public static CongestionLevel valueOf(int value) {
                return forNumber(value);
            }

            public static CongestionLevel forNumber(int value) {
                switch (value) {
                    case 0:
                        return UNKNOWN_CONGESTION_LEVEL;
                    case 1:
                        return RUNNING_SMOOTHLY;
                    case 2:
                        return STOP_AND_GO;
                    case 3:
                        return CONGESTION;
                    case 4:
                        return SEVERE_CONGESTION;
                    default:
                        return null;
                }
            }

            public static com.google.protobuf.Internal.EnumLiteMap<CongestionLevel>
            internalGetValueMap() {
                return internalValueMap;
            }

            private static final com.google.protobuf.Internal.EnumLiteMap<
                    CongestionLevel> internalValueMap =
                    new com.google.protobuf.Internal.EnumLiteMap<CongestionLevel>() {
                        public CongestionLevel findValueByNumber(int number) {
                            return CongestionLevel.forNumber(number);
                        }
                    };

            public final com.google.protobuf.Descriptors.EnumValueDescriptor
            getValueDescriptor() {
                return getDescriptor().getValues().get(ordinal());
            }

            public final com.google.protobuf.Descriptors.EnumDescriptor
            getDescriptorForType() {
                return getDescriptor();
            }

            public static final com.google.protobuf.Descriptors.EnumDescriptor
            getDescriptor() {
                return GtfsRealtime.VehiclePosition.getDescriptor().getEnumTypes().get(1);
            }

            private static final CongestionLevel[] VALUES = values();

            public static CongestionLevel valueOf(
                    com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
                if (desc.getType() != getDescriptor()) {
                    throw new java.lang.IllegalArgumentException(
                            "EnumValueDescriptor is not for this type.");
                }
                return VALUES[desc.getIndex()];
            }

            private final int value;

            private CongestionLevel(int value) {
                this.value = value;
            }

            // @@protoc_insertion_point(enum_scope:transit_realtime.VehiclePosition.CongestionLevel)
        }

        /**
         * <pre>
         * The degree of passenger occupancy of the vehicle. This field is still
         * experimental, and subject to change. It may be formally adopted in the
         * future.
         * </pre>
         * <p>
         * Protobuf enum {@code transit_realtime.VehiclePosition.OccupancyStatus}
         */
        public enum OccupancyStatus
                implements com.google.protobuf.ProtocolMessageEnum {
            /**
             * <pre>
             * The vehicle is considered empty by most measures, and has few or no
             * passengers onboard, but is still accepting passengers.
             * </pre>
             *
             * <code>EMPTY = 0;</code>
             */
            EMPTY(0),
            /**
             * <pre>
             * The vehicle has a relatively large percentage of seats available.
             * What percentage of free seats out of the total seats available is to be
             * considered large enough to fall into this category is determined at the
             * discretion of the producer.
             * </pre>
             *
             * <code>MANY_SEATS_AVAILABLE = 1;</code>
             */
            MANY_SEATS_AVAILABLE(1),
            /**
             * <pre>
             * The vehicle has a relatively small percentage of seats available.
             * What percentage of free seats out of the total seats available is to be
             * considered small enough to fall into this category is determined at the
             * discretion of the feed producer.
             * </pre>
             *
             * <code>FEW_SEATS_AVAILABLE = 2;</code>
             */
            FEW_SEATS_AVAILABLE(2),
            /**
             * <pre>
             * The vehicle can currently accommodate only standing passengers.
             * </pre>
             *
             * <code>STANDING_ROOM_ONLY = 3;</code>
             */
            STANDING_ROOM_ONLY(3),
            /**
             * <pre>
             * The vehicle can currently accommodate only standing passengers
             * and has limited space for them.
             * </pre>
             *
             * <code>CRUSHED_STANDING_ROOM_ONLY = 4;</code>
             */
            CRUSHED_STANDING_ROOM_ONLY(4),
            /**
             * <pre>
             * The vehicle is considered full by most measures, but may still be
             * allowing passengers to board.
             * </pre>
             *
             * <code>FULL = 5;</code>
             */
            FULL(5),
            /**
             * <pre>
             * The vehicle is not accepting additional passengers.
             * </pre>
             *
             * <code>NOT_ACCEPTING_PASSENGERS = 6;</code>
             */
            NOT_ACCEPTING_PASSENGERS(6),
            ;

            /**
             * <pre>
             * The vehicle is considered empty by most measures, and has few or no
             * passengers onboard, but is still accepting passengers.
             * </pre>
             *
             * <code>EMPTY = 0;</code>
             */
            public static final int EMPTY_VALUE = 0;
            /**
             * <pre>
             * The vehicle has a relatively large percentage of seats available.
             * What percentage of free seats out of the total seats available is to be
             * considered large enough to fall into this category is determined at the
             * discretion of the producer.
             * </pre>
             *
             * <code>MANY_SEATS_AVAILABLE = 1;</code>
             */
            public static final int MANY_SEATS_AVAILABLE_VALUE = 1;
            /**
             * <pre>
             * The vehicle has a relatively small percentage of seats available.
             * What percentage of free seats out of the total seats available is to be
             * considered small enough to fall into this category is determined at the
             * discretion of the feed producer.
             * </pre>
             *
             * <code>FEW_SEATS_AVAILABLE = 2;</code>
             */
            public static final int FEW_SEATS_AVAILABLE_VALUE = 2;
            /**
             * <pre>
             * The vehicle can currently accommodate only standing passengers.
             * </pre>
             *
             * <code>STANDING_ROOM_ONLY = 3;</code>
             */
            public static final int STANDING_ROOM_ONLY_VALUE = 3;
            /**
             * <pre>
             * The vehicle can currently accommodate only standing passengers
             * and has limited space for them.
             * </pre>
             *
             * <code>CRUSHED_STANDING_ROOM_ONLY = 4;</code>
             */
            public static final int CRUSHED_STANDING_ROOM_ONLY_VALUE = 4;
            /**
             * <pre>
             * The vehicle is considered full by most measures, but may still be
             * allowing passengers to board.
             * </pre>
             *
             * <code>FULL = 5;</code>
             */
            public static final int FULL_VALUE = 5;
            /**
             * <pre>
             * The vehicle is not accepting additional passengers.
             * </pre>
             *
             * <code>NOT_ACCEPTING_PASSENGERS = 6;</code>
             */
            public static final int NOT_ACCEPTING_PASSENGERS_VALUE = 6;


            public final int getNumber() {
                return value;
            }

            /**
             * @deprecated Use {@link #forNumber(int)} instead.
             */
            @java.lang.Deprecated
            public static OccupancyStatus valueOf(int value) {
                return forNumber(value);
            }

            public static OccupancyStatus forNumber(int value) {
                switch (value) {
                    case 0:
                        return EMPTY;
                    case 1:
                        return MANY_SEATS_AVAILABLE;
                    case 2:
                        return FEW_SEATS_AVAILABLE;
                    case 3:
                        return STANDING_ROOM_ONLY;
                    case 4:
                        return CRUSHED_STANDING_ROOM_ONLY;
                    case 5:
                        return FULL;
                    case 6:
                        return NOT_ACCEPTING_PASSENGERS;
                    default:
                        return null;
                }
            }

            public static com.google.protobuf.Internal.EnumLiteMap<OccupancyStatus>
            internalGetValueMap() {
                return internalValueMap;
            }

            private static final com.google.protobuf.Internal.EnumLiteMap<
                    OccupancyStatus> internalValueMap =
                    new com.google.protobuf.Internal.EnumLiteMap<OccupancyStatus>() {
                        public OccupancyStatus findValueByNumber(int number) {
                            return OccupancyStatus.forNumber(number);
                        }
                    };

            public final com.google.protobuf.Descriptors.EnumValueDescriptor
            getValueDescriptor() {
                return getDescriptor().getValues().get(ordinal());
            }

            public final com.google.protobuf.Descriptors.EnumDescriptor
            getDescriptorForType() {
                return getDescriptor();
            }

            public static final com.google.protobuf.Descriptors.EnumDescriptor
            getDescriptor() {
                return GtfsRealtime.VehiclePosition.getDescriptor().getEnumTypes().get(2);
            }

            private static final OccupancyStatus[] VALUES = values();

            public static OccupancyStatus valueOf(
                    com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
                if (desc.getType() != getDescriptor()) {
                    throw new java.lang.IllegalArgumentException(
                            "EnumValueDescriptor is not for this type.");
                }
                return VALUES[desc.getIndex()];
            }

            private final int value;

            private OccupancyStatus(int value) {
                this.value = value;
            }

            // @@protoc_insertion_point(enum_scope:transit_realtime.VehiclePosition.OccupancyStatus)
        }

        private int bitField0_;
        public static final int TRIP_FIELD_NUMBER = 1;
        private GtfsRealtime.TripDescriptor trip_;

        /**
         * <pre>
         * The Trip that this vehicle is serving.
         * Can be empty or partial if the vehicle can not be identified with a given
         * trip instance.
         * </pre>
         *
         * <code>optional .transit_realtime.TripDescriptor trip = 1;</code>
         */
        public boolean hasTrip() {
            return ((bitField0_ & 0x00000001) != 0);
        }

        /**
         * <pre>
         * The Trip that this vehicle is serving.
         * Can be empty or partial if the vehicle can not be identified with a given
         * trip instance.
         * </pre>
         *
         * <code>optional .transit_realtime.TripDescriptor trip = 1;</code>
         */
        public GtfsRealtime.TripDescriptor getTrip() {
            return trip_ == null ? GtfsRealtime.TripDescriptor.getDefaultInstance() : trip_;
        }

        /**
         * <pre>
         * The Trip that this vehicle is serving.
         * Can be empty or partial if the vehicle can not be identified with a given
         * trip instance.
         * </pre>
         *
         * <code>optional .transit_realtime.TripDescriptor trip = 1;</code>
         */
        public GtfsRealtime.TripDescriptorOrBuilder getTripOrBuilder() {
            return trip_ == null ? GtfsRealtime.TripDescriptor.getDefaultInstance() : trip_;
        }

        public static final int VEHICLE_FIELD_NUMBER = 8;
        private GtfsRealtime.VehicleDescriptor vehicle_;

        /**
         * <pre>
         * Additional information on the vehicle that is serving this trip.
         * </pre>
         *
         * <code>optional .transit_realtime.VehicleDescriptor vehicle = 8;</code>
         */
        public boolean hasVehicle() {
            return ((bitField0_ & 0x00000002) != 0);
        }

        /**
         * <pre>
         * Additional information on the vehicle that is serving this trip.
         * </pre>
         *
         * <code>optional .transit_realtime.VehicleDescriptor vehicle = 8;</code>
         */
        public GtfsRealtime.VehicleDescriptor getVehicle() {
            return vehicle_ == null ? GtfsRealtime.VehicleDescriptor.getDefaultInstance() : vehicle_;
        }

        /**
         * <pre>
         * Additional information on the vehicle that is serving this trip.
         * </pre>
         *
         * <code>optional .transit_realtime.VehicleDescriptor vehicle = 8;</code>
         */
        public GtfsRealtime.VehicleDescriptorOrBuilder getVehicleOrBuilder() {
            return vehicle_ == null ? GtfsRealtime.VehicleDescriptor.getDefaultInstance() : vehicle_;
        }

        public static final int POSITION_FIELD_NUMBER = 2;
        private GtfsRealtime.Position position_;

        /**
         * <pre>
         * Current position of this vehicle.
         * </pre>
         *
         * <code>optional .transit_realtime.Position position = 2;</code>
         */
        public boolean hasPosition() {
            return ((bitField0_ & 0x00000004) != 0);
        }

        /**
         * <pre>
         * Current position of this vehicle.
         * </pre>
         *
         * <code>optional .transit_realtime.Position position = 2;</code>
         */
        public GtfsRealtime.Position getPosition() {
            return position_ == null ? GtfsRealtime.Position.getDefaultInstance() : position_;
        }

        /**
         * <pre>
         * Current position of this vehicle.
         * </pre>
         *
         * <code>optional .transit_realtime.Position position = 2;</code>
         */
        public GtfsRealtime.PositionOrBuilder getPositionOrBuilder() {
            return position_ == null ? GtfsRealtime.Position.getDefaultInstance() : position_;
        }

        public static final int CURRENT_STOP_SEQUENCE_FIELD_NUMBER = 3;
        private int currentStopSequence_;

        /**
         * <pre>
         * The stop sequence index of the current stop. The meaning of
         * current_stop_sequence (i.e., the stop that it refers to) is determined by
         * current_status.
         * If current_status is missing IN_TRANSIT_TO is assumed.
         * </pre>
         *
         * <code>optional uint32 current_stop_sequence = 3;</code>
         */
        public boolean hasCurrentStopSequence() {
            return ((bitField0_ & 0x00000008) != 0);
        }

        /**
         * <pre>
         * The stop sequence index of the current stop. The meaning of
         * current_stop_sequence (i.e., the stop that it refers to) is determined by
         * current_status.
         * If current_status is missing IN_TRANSIT_TO is assumed.
         * </pre>
         *
         * <code>optional uint32 current_stop_sequence = 3;</code>
         */
        public int getCurrentStopSequence() {
            return currentStopSequence_;
        }

        public static final int STOP_ID_FIELD_NUMBER = 7;
        private volatile java.lang.Object stopId_;

        /**
         * <pre>
         * Identifies the current stop. The value must be the same as in stops.txt in
         * the corresponding GTFS feed.
         * </pre>
         *
         * <code>optional string stop_id = 7;</code>
         */
        public boolean hasStopId() {
            return ((bitField0_ & 0x00000010) != 0);
        }

        /**
         * <pre>
         * Identifies the current stop. The value must be the same as in stops.txt in
         * the corresponding GTFS feed.
         * </pre>
         *
         * <code>optional string stop_id = 7;</code>
         */
        public java.lang.String getStopId() {
            java.lang.Object ref = stopId_;
            if (ref instanceof java.lang.String) {
                return (java.lang.String) ref;
            } else {
                com.google.protobuf.ByteString bs =
                        (com.google.protobuf.ByteString) ref;
                java.lang.String s = bs.toStringUtf8();
                if (bs.isValidUtf8()) {
                    stopId_ = s;
                }
                return s;
            }
        }

        /**
         * <pre>
         * Identifies the current stop. The value must be the same as in stops.txt in
         * the corresponding GTFS feed.
         * </pre>
         *
         * <code>optional string stop_id = 7;</code>
         */
        public com.google.protobuf.ByteString
        getStopIdBytes() {
            java.lang.Object ref = stopId_;
            if (ref instanceof java.lang.String) {
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8(
                                (java.lang.String) ref);
                stopId_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        public static final int CURRENT_STATUS_FIELD_NUMBER = 4;
        private int currentStatus_;

        /**
         * <pre>
         * The exact status of the vehicle with respect to the current stop.
         * Ignored if current_stop_sequence is missing.
         * </pre>
         *
         * <code>optional .transit_realtime.VehiclePosition.VehicleStopStatus current_status = 4 [default = IN_TRANSIT_TO];</code>
         */
        public boolean hasCurrentStatus() {
            return ((bitField0_ & 0x00000020) != 0);
        }

        /**
         * <pre>
         * The exact status of the vehicle with respect to the current stop.
         * Ignored if current_stop_sequence is missing.
         * </pre>
         *
         * <code>optional .transit_realtime.VehiclePosition.VehicleStopStatus current_status = 4 [default = IN_TRANSIT_TO];</code>
         */
        public GtfsRealtime.VehiclePosition.VehicleStopStatus getCurrentStatus() {
            @SuppressWarnings("deprecation")
            GtfsRealtime.VehiclePosition.VehicleStopStatus result = GtfsRealtime.VehiclePosition.VehicleStopStatus.valueOf(currentStatus_);
            return result == null ? GtfsRealtime.VehiclePosition.VehicleStopStatus.IN_TRANSIT_TO : result;
        }

        public static final int TIMESTAMP_FIELD_NUMBER = 5;
        private long timestamp_;

        /**
         * <pre>
         * Moment at which the vehicle's position was measured. In POSIX time
         * (i.e., number of seconds since January 1st 1970 00:00:00 UTC).
         * </pre>
         *
         * <code>optional uint64 timestamp = 5;</code>
         */
        public boolean hasTimestamp() {
            return ((bitField0_ & 0x00000040) != 0);
        }

        /**
         * <pre>
         * Moment at which the vehicle's position was measured. In POSIX time
         * (i.e., number of seconds since January 1st 1970 00:00:00 UTC).
         * </pre>
         *
         * <code>optional uint64 timestamp = 5;</code>
         */
        public long getTimestamp() {
            return timestamp_;
        }

        public static final int CONGESTION_LEVEL_FIELD_NUMBER = 6;
        private int congestionLevel_;

        /**
         * <code>optional .transit_realtime.VehiclePosition.CongestionLevel congestion_level = 6;</code>
         */
        public boolean hasCongestionLevel() {
            return ((bitField0_ & 0x00000080) != 0);
        }

        /**
         * <code>optional .transit_realtime.VehiclePosition.CongestionLevel congestion_level = 6;</code>
         */
        public GtfsRealtime.VehiclePosition.CongestionLevel getCongestionLevel() {
            @SuppressWarnings("deprecation")
            GtfsRealtime.VehiclePosition.CongestionLevel result = GtfsRealtime.VehiclePosition.CongestionLevel.valueOf(congestionLevel_);
            return result == null ? GtfsRealtime.VehiclePosition.CongestionLevel.UNKNOWN_CONGESTION_LEVEL : result;
        }

        public static final int OCCUPANCY_STATUS_FIELD_NUMBER = 9;
        private int occupancyStatus_;

        /**
         * <code>optional .transit_realtime.VehiclePosition.OccupancyStatus occupancy_status = 9;</code>
         */
        public boolean hasOccupancyStatus() {
            return ((bitField0_ & 0x00000100) != 0);
        }

        /**
         * <code>optional .transit_realtime.VehiclePosition.OccupancyStatus occupancy_status = 9;</code>
         */
        public GtfsRealtime.VehiclePosition.OccupancyStatus getOccupancyStatus() {
            @SuppressWarnings("deprecation")
            GtfsRealtime.VehiclePosition.OccupancyStatus result = GtfsRealtime.VehiclePosition.OccupancyStatus.valueOf(occupancyStatus_);
            return result == null ? GtfsRealtime.VehiclePosition.OccupancyStatus.EMPTY : result;
        }

        private byte memoizedIsInitialized = -1;

        @java.lang.Override
        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            if (hasTrip()) {
                if (!getTrip().isInitialized()) {
                    memoizedIsInitialized = 0;
                    return false;
                }
            }
            if (hasVehicle()) {
                if (!getVehicle().isInitialized()) {
                    memoizedIsInitialized = 0;
                    return false;
                }
            }
            if (hasPosition()) {
                if (!getPosition().isInitialized()) {
                    memoizedIsInitialized = 0;
                    return false;
                }
            }
            if (!extensionsAreInitialized()) {
                memoizedIsInitialized = 0;
                return false;
            }
            memoizedIsInitialized = 1;
            return true;
        }

        @java.lang.Override
        public void writeTo(com.google.protobuf.CodedOutputStream output)
                throws java.io.IOException {
            com.google.protobuf.GeneratedMessageV3
                    .ExtendableMessage<GtfsRealtime.VehiclePosition>.ExtensionWriter
                    extensionWriter = newExtensionWriter();
            if (((bitField0_ & 0x00000001) != 0)) {
                output.writeMessage(1, getTrip());
            }
            if (((bitField0_ & 0x00000004) != 0)) {
                output.writeMessage(2, getPosition());
            }
            if (((bitField0_ & 0x00000008) != 0)) {
                output.writeUInt32(3, currentStopSequence_);
            }
            if (((bitField0_ & 0x00000020) != 0)) {
                output.writeEnum(4, currentStatus_);
            }
            if (((bitField0_ & 0x00000040) != 0)) {
                output.writeUInt64(5, timestamp_);
            }
            if (((bitField0_ & 0x00000080) != 0)) {
                output.writeEnum(6, congestionLevel_);
            }
            if (((bitField0_ & 0x00000010) != 0)) {
                com.google.protobuf.GeneratedMessageV3.writeString(output, 7, stopId_);
            }
            if (((bitField0_ & 0x00000002) != 0)) {
                output.writeMessage(8, getVehicle());
            }
            if (((bitField0_ & 0x00000100) != 0)) {
                output.writeEnum(9, occupancyStatus_);
            }
            extensionWriter.writeUntil(2000, output);
            unknownFields.writeTo(output);
        }

        @java.lang.Override
        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            if (((bitField0_ & 0x00000001) != 0)) {
                size += com.google.protobuf.CodedOutputStream
                        .computeMessageSize(1, getTrip());
            }
            if (((bitField0_ & 0x00000004) != 0)) {
                size += com.google.protobuf.CodedOutputStream
                        .computeMessageSize(2, getPosition());
            }
            if (((bitField0_ & 0x00000008) != 0)) {
                size += com.google.protobuf.CodedOutputStream
                        .computeUInt32Size(3, currentStopSequence_);
            }
            if (((bitField0_ & 0x00000020) != 0)) {
                size += com.google.protobuf.CodedOutputStream
                        .computeEnumSize(4, currentStatus_);
            }
            if (((bitField0_ & 0x00000040) != 0)) {
                size += com.google.protobuf.CodedOutputStream
                        .computeUInt64Size(5, timestamp_);
            }
            if (((bitField0_ & 0x00000080) != 0)) {
                size += com.google.protobuf.CodedOutputStream
                        .computeEnumSize(6, congestionLevel_);
            }
            if (((bitField0_ & 0x00000010) != 0)) {
                size += com.google.protobuf.GeneratedMessageV3.computeStringSize(7, stopId_);
            }
            if (((bitField0_ & 0x00000002) != 0)) {
                size += com.google.protobuf.CodedOutputStream
                        .computeMessageSize(8, getVehicle());
            }
            if (((bitField0_ & 0x00000100) != 0)) {
                size += com.google.protobuf.CodedOutputStream
                        .computeEnumSize(9, occupancyStatus_);
            }
            size += extensionsSerializedSize();
            size += unknownFields.getSerializedSize();
            memoizedSize = size;
            return size;
        }

        @java.lang.Override
        public boolean equals(final java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof GtfsRealtime.VehiclePosition)) {
                return super.equals(obj);
            }
            GtfsRealtime.VehiclePosition other = (GtfsRealtime.VehiclePosition) obj;

            if (hasTrip() != other.hasTrip()) return false;
            if (hasTrip()) {
                if (!getTrip()
                        .equals(other.getTrip())) return false;
            }
            if (hasVehicle() != other.hasVehicle()) return false;
            if (hasVehicle()) {
                if (!getVehicle()
                        .equals(other.getVehicle())) return false;
            }
            if (hasPosition() != other.hasPosition()) return false;
            if (hasPosition()) {
                if (!getPosition()
                        .equals(other.getPosition())) return false;
            }
            if (hasCurrentStopSequence() != other.hasCurrentStopSequence()) return false;
            if (hasCurrentStopSequence()) {
                if (getCurrentStopSequence()
                        != other.getCurrentStopSequence()) return false;
            }
            if (hasStopId() != other.hasStopId()) return false;
            if (hasStopId()) {
                if (!getStopId()
                        .equals(other.getStopId())) return false;
            }
            if (hasCurrentStatus() != other.hasCurrentStatus()) return false;
            if (hasCurrentStatus()) {
                if (currentStatus_ != other.currentStatus_) return false;
            }
            if (hasTimestamp() != other.hasTimestamp()) return false;
            if (hasTimestamp()) {
                if (getTimestamp()
                        != other.getTimestamp()) return false;
            }
            if (hasCongestionLevel() != other.hasCongestionLevel()) return false;
            if (hasCongestionLevel()) {
                if (congestionLevel_ != other.congestionLevel_) return false;
            }
            if (hasOccupancyStatus() != other.hasOccupancyStatus()) return false;
            if (hasOccupancyStatus()) {
                if (occupancyStatus_ != other.occupancyStatus_) return false;
            }
            if (!unknownFields.equals(other.unknownFields)) return false;
            if (!getExtensionFields().equals(other.getExtensionFields()))
                return false;
            return true;
        }

        @java.lang.Override
        public int hashCode() {
            if (memoizedHashCode != 0) {
                return memoizedHashCode;
            }
            int hash = 41;
            hash = (19 * hash) + getDescriptor().hashCode();
            if (hasTrip()) {
                hash = (37 * hash) + TRIP_FIELD_NUMBER;
                hash = (53 * hash) + getTrip().hashCode();
            }
            if (hasVehicle()) {
                hash = (37 * hash) + VEHICLE_FIELD_NUMBER;
                hash = (53 * hash) + getVehicle().hashCode();
            }
            if (hasPosition()) {
                hash = (37 * hash) + POSITION_FIELD_NUMBER;
                hash = (53 * hash) + getPosition().hashCode();
            }
            if (hasCurrentStopSequence()) {
                hash = (37 * hash) + CURRENT_STOP_SEQUENCE_FIELD_NUMBER;
                hash = (53 * hash) + getCurrentStopSequence();
            }
            if (hasStopId()) {
                hash = (37 * hash) + STOP_ID_FIELD_NUMBER;
                hash = (53 * hash) + getStopId().hashCode();
            }
            if (hasCurrentStatus()) {
                hash = (37 * hash) + CURRENT_STATUS_FIELD_NUMBER;
                hash = (53 * hash) + currentStatus_;
            }
            if (hasTimestamp()) {
                hash = (37 * hash) + TIMESTAMP_FIELD_NUMBER;
                hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
                        getTimestamp());
            }
            if (hasCongestionLevel()) {
                hash = (37 * hash) + CONGESTION_LEVEL_FIELD_NUMBER;
                hash = (53 * hash) + congestionLevel_;
            }
            if (hasOccupancyStatus()) {
                hash = (37 * hash) + OCCUPANCY_STATUS_FIELD_NUMBER;
                hash = (53 * hash) + occupancyStatus_;
            }
            hash = hashFields(hash, getExtensionFields());
            hash = (29 * hash) + unknownFields.hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static GtfsRealtime.VehiclePosition parseFrom(
                java.nio.ByteBuffer data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GtfsRealtime.VehiclePosition parseFrom(
                java.nio.ByteBuffer data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GtfsRealtime.VehiclePosition parseFrom(
                com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GtfsRealtime.VehiclePosition parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GtfsRealtime.VehiclePosition parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GtfsRealtime.VehiclePosition parseFrom(
                byte[] data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GtfsRealtime.VehiclePosition parseFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }

        public static GtfsRealtime.VehiclePosition parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static GtfsRealtime.VehiclePosition parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input);
        }

        public static GtfsRealtime.VehiclePosition parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static GtfsRealtime.VehiclePosition parseFrom(
                com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }

        public static GtfsRealtime.VehiclePosition parseFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        @java.lang.Override
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GtfsRealtime.VehiclePosition prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }

        @java.lang.Override
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE
                    ? new Builder() : new Builder().mergeFrom(this);
        }

        @java.lang.Override
        protected Builder newBuilderForType(
                com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        /**
         * <pre>
         * Realtime positioning information for a given vehicle.
         * </pre>
         * <p>
         * Protobuf type {@code transit_realtime.VehiclePosition}
         */
        public static final class Builder extends
                com.google.protobuf.GeneratedMessageV3.ExtendableBuilder<
                        GtfsRealtime.VehiclePosition, Builder> implements
                // @@protoc_insertion_point(builder_implements:transit_realtime.VehiclePosition)
                GtfsRealtime.VehiclePositionOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
                return GtfsRealtime.internal_static_transit_realtime_VehiclePosition_descriptor;
            }

            @java.lang.Override
            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internalGetFieldAccessorTable() {
                return GtfsRealtime.internal_static_transit_realtime_VehiclePosition_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                GtfsRealtime.VehiclePosition.class, GtfsRealtime.VehiclePosition.Builder.class);
            }

            // Construct using GtfsRealtime.VehiclePosition.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(
                    com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.GeneratedMessageV3
                        .alwaysUseFieldBuilders) {
                    getTripFieldBuilder();
                    getVehicleFieldBuilder();
                    getPositionFieldBuilder();
                }
            }

            @java.lang.Override
            public Builder clear() {
                super.clear();
                if (tripBuilder_ == null) {
                    trip_ = null;
                } else {
                    tripBuilder_.clear();
                }
                bitField0_ = (bitField0_ & ~0x00000001);
                if (vehicleBuilder_ == null) {
                    vehicle_ = null;
                } else {
                    vehicleBuilder_.clear();
                }
                bitField0_ = (bitField0_ & ~0x00000002);
                if (positionBuilder_ == null) {
                    position_ = null;
                } else {
                    positionBuilder_.clear();
                }
                bitField0_ = (bitField0_ & ~0x00000004);
                currentStopSequence_ = 0;
                bitField0_ = (bitField0_ & ~0x00000008);
                stopId_ = "";
                bitField0_ = (bitField0_ & ~0x00000010);
                currentStatus_ = 2;
                bitField0_ = (bitField0_ & ~0x00000020);
                timestamp_ = 0L;
                bitField0_ = (bitField0_ & ~0x00000040);
                congestionLevel_ = 0;
                bitField0_ = (bitField0_ & ~0x00000080);
                occupancyStatus_ = 0;
                bitField0_ = (bitField0_ & ~0x00000100);
                return this;
            }

            @java.lang.Override
            public com.google.protobuf.Descriptors.Descriptor
            getDescriptorForType() {
                return GtfsRealtime.internal_static_transit_realtime_VehiclePosition_descriptor;
            }

            @java.lang.Override
            public GtfsRealtime.VehiclePosition getDefaultInstanceForType() {
                return GtfsRealtime.VehiclePosition.getDefaultInstance();
            }

            @java.lang.Override
            public GtfsRealtime.VehiclePosition build() {
                GtfsRealtime.VehiclePosition result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            @java.lang.Override
            public GtfsRealtime.VehiclePosition buildPartial() {
                GtfsRealtime.VehiclePosition result = new GtfsRealtime.VehiclePosition(this);
                int from_bitField0_ = bitField0_;
                int to_bitField0_ = 0;
                if (((from_bitField0_ & 0x00000001) != 0)) {
                    if (tripBuilder_ == null) {
                        result.trip_ = trip_;
                    } else {
                        result.trip_ = tripBuilder_.build();
                    }
                    to_bitField0_ |= 0x00000001;
                }
                if (((from_bitField0_ & 0x00000002) != 0)) {
                    if (vehicleBuilder_ == null) {
                        result.vehicle_ = vehicle_;
                    } else {
                        result.vehicle_ = vehicleBuilder_.build();
                    }
                    to_bitField0_ |= 0x00000002;
                }
                if (((from_bitField0_ & 0x00000004) != 0)) {
                    if (positionBuilder_ == null) {
                        result.position_ = position_;
                    } else {
                        result.position_ = positionBuilder_.build();
                    }
                    to_bitField0_ |= 0x00000004;
                }
                if (((from_bitField0_ & 0x00000008) != 0)) {
                    result.currentStopSequence_ = currentStopSequence_;
                    to_bitField0_ |= 0x00000008;
                }
                if (((from_bitField0_ & 0x00000010) != 0)) {
                    to_bitField0_ |= 0x00000010;
                }
                result.stopId_ = stopId_;
                if (((from_bitField0_ & 0x00000020) != 0)) {
                    to_bitField0_ |= 0x00000020;
                }
                result.currentStatus_ = currentStatus_;
                if (((from_bitField0_ & 0x00000040) != 0)) {
                    result.timestamp_ = timestamp_;
                    to_bitField0_ |= 0x00000040;
                }
                if (((from_bitField0_ & 0x00000080) != 0)) {
                    to_bitField0_ |= 0x00000080;
                }
                result.congestionLevel_ = congestionLevel_;
                if (((from_bitField0_ & 0x00000100) != 0)) {
                    to_bitField0_ |= 0x00000100;
                }
                result.occupancyStatus_ = occupancyStatus_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            @java.lang.Override
            public Builder clone() {
                return super.clone();
            }

            @java.lang.Override
            public Builder setField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return super.setField(field, value);
            }

            @java.lang.Override
            public Builder clearField(
                    com.google.protobuf.Descriptors.FieldDescriptor field) {
                return super.clearField(field);
            }

            @java.lang.Override
            public Builder clearOneof(
                    com.google.protobuf.Descriptors.OneofDescriptor oneof) {
                return super.clearOneof(oneof);
            }

            @java.lang.Override
            public Builder setRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    int index, java.lang.Object value) {
                return super.setRepeatedField(field, index, value);
            }

            @java.lang.Override
            public Builder addRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return super.addRepeatedField(field, value);
            }

            @java.lang.Override
            public <Type> Builder setExtension(
                    com.google.protobuf.GeneratedMessage.GeneratedExtension<
                            GtfsRealtime.VehiclePosition, Type> extension,
                    Type value) {
                return super.setExtension(extension, value);
            }

            @java.lang.Override
            public <Type> Builder setExtension(
                    com.google.protobuf.GeneratedMessage.GeneratedExtension<
                            GtfsRealtime.VehiclePosition, java.util.List<Type>> extension,
                    int index, Type value) {
                return super.setExtension(extension, index, value);
            }

            @java.lang.Override
            public <Type> Builder addExtension(
                    com.google.protobuf.GeneratedMessage.GeneratedExtension<
                            GtfsRealtime.VehiclePosition, java.util.List<Type>> extension,
                    Type value) {
                return super.addExtension(extension, value);
            }

            @java.lang.Override
            public <Type> Builder clearExtension(
                    com.google.protobuf.GeneratedMessage.GeneratedExtension<
                            GtfsRealtime.VehiclePosition, ?> extension) {
                return super.clearExtension(extension);
            }

            @java.lang.Override
            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof GtfsRealtime.VehiclePosition) {
                    return mergeFrom((GtfsRealtime.VehiclePosition) other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(GtfsRealtime.VehiclePosition other) {
                if (other == GtfsRealtime.VehiclePosition.getDefaultInstance()) return this;
                if (other.hasTrip()) {
                    mergeTrip(other.getTrip());
                }
                if (other.hasVehicle()) {
                    mergeVehicle(other.getVehicle());
                }
                if (other.hasPosition()) {
                    mergePosition(other.getPosition());
                }
                if (other.hasCurrentStopSequence()) {
                    setCurrentStopSequence(other.getCurrentStopSequence());
                }
                if (other.hasStopId()) {
                    bitField0_ |= 0x00000010;
                    stopId_ = other.stopId_;
                    onChanged();
                }
                if (other.hasCurrentStatus()) {
                    setCurrentStatus(other.getCurrentStatus());
                }
                if (other.hasTimestamp()) {
                    setTimestamp(other.getTimestamp());
                }
                if (other.hasCongestionLevel()) {
                    setCongestionLevel(other.getCongestionLevel());
                }
                if (other.hasOccupancyStatus()) {
                    setOccupancyStatus(other.getOccupancyStatus());
                }
                this.mergeExtensionFields(other);
                this.mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            @java.lang.Override
            public final boolean isInitialized() {
                if (hasTrip()) {
                    if (!getTrip().isInitialized()) {
                        return false;
                    }
                }
                if (hasVehicle()) {
                    if (!getVehicle().isInitialized()) {
                        return false;
                    }
                }
                if (hasPosition()) {
                    if (!getPosition().isInitialized()) {
                        return false;
                    }
                }
                if (!extensionsAreInitialized()) {
                    return false;
                }
                return true;
            }

            @java.lang.Override
            public Builder mergeFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                GtfsRealtime.VehiclePosition parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (GtfsRealtime.VehiclePosition) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private int bitField0_;

            private GtfsRealtime.TripDescriptor trip_;
            private com.google.protobuf.SingleFieldBuilderV3<
                    GtfsRealtime.TripDescriptor, GtfsRealtime.TripDescriptor.Builder, GtfsRealtime.TripDescriptorOrBuilder> tripBuilder_;

            /**
             * <pre>
             * The Trip that this vehicle is serving.
             * Can be empty or partial if the vehicle can not be identified with a given
             * trip instance.
             * </pre>
             *
             * <code>optional .transit_realtime.TripDescriptor trip = 1;</code>
             */
            public boolean hasTrip() {
                return ((bitField0_ & 0x00000001) != 0);
            }

            /**
             * <pre>
             * The Trip that this vehicle is serving.
             * Can be empty or partial if the vehicle can not be identified with a given
             * trip instance.
             * </pre>
             *
             * <code>optional .transit_realtime.TripDescriptor trip = 1;</code>
             */
            public GtfsRealtime.TripDescriptor getTrip() {
                if (tripBuilder_ == null) {
                    return trip_ == null ? GtfsRealtime.TripDescriptor.getDefaultInstance() : trip_;
                } else {
                    return tripBuilder_.getMessage();
                }
            }

            /**
             * <pre>
             * The Trip that this vehicle is serving.
             * Can be empty or partial if the vehicle can not be identified with a given
             * trip instance.
             * </pre>
             *
             * <code>optional .transit_realtime.TripDescriptor trip = 1;</code>
             */
            public Builder setTrip(GtfsRealtime.TripDescriptor value) {
                if (tripBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    trip_ = value;
                    onChanged();
                } else {
                    tripBuilder_.setMessage(value);
                }
                bitField0_ |= 0x00000001;
                return this;
            }

            /**
             * <pre>
             * The Trip that this vehicle is serving.
             * Can be empty or partial if the vehicle can not be identified with a given
             * trip instance.
             * </pre>
             *
             * <code>optional .transit_realtime.TripDescriptor trip = 1;</code>
             */
            public Builder setTrip(
                    GtfsRealtime.TripDescriptor.Builder builderForValue) {
                if (tripBuilder_ == null) {
                    trip_ = builderForValue.build();
                    onChanged();
                } else {
                    tripBuilder_.setMessage(builderForValue.build());
                }
                bitField0_ |= 0x00000001;
                return this;
            }

            /**
             * <pre>
             * The Trip that this vehicle is serving.
             * Can be empty or partial if the vehicle can not be identified with a given
             * trip instance.
             * </pre>
             *
             * <code>optional .transit_realtime.TripDescriptor trip = 1;</code>
             */
            public Builder mergeTrip(GtfsRealtime.TripDescriptor value) {
                if (tripBuilder_ == null) {
                    if (((bitField0_ & 0x00000001) != 0) &&
                            trip_ != null &&
                            trip_ != GtfsRealtime.TripDescriptor.getDefaultInstance()) {
                        trip_ =
                                GtfsRealtime.TripDescriptor.newBuilder(trip_).mergeFrom(value).buildPartial();
                    } else {
                        trip_ = value;
                    }
                    onChanged();
                } else {
                    tripBuilder_.mergeFrom(value);
                }
                bitField0_ |= 0x00000001;
                return this;
            }

            /**
             * <pre>
             * The Trip that this vehicle is serving.
             * Can be empty or partial if the vehicle can not be identified with a given
             * trip instance.
             * </pre>
             *
             * <code>optional .transit_realtime.TripDescriptor trip = 1;</code>
             */
            public Builder clearTrip() {
                if (tripBuilder_ == null) {
                    trip_ = null;
                    onChanged();
                } else {
                    tripBuilder_.clear();
                }
                bitField0_ = (bitField0_ & ~0x00000001);
                return this;
            }

            /**
             * <pre>
             * The Trip that this vehicle is serving.
             * Can be empty or partial if the vehicle can not be identified with a given
             * trip instance.
             * </pre>
             *
             * <code>optional .transit_realtime.TripDescriptor trip = 1;</code>
             */
            public GtfsRealtime.TripDescriptor.Builder getTripBuilder() {
                bitField0_ |= 0x00000001;
                onChanged();
                return getTripFieldBuilder().getBuilder();
            }

            /**
             * <pre>
             * The Trip that this vehicle is serving.
             * Can be empty or partial if the vehicle can not be identified with a given
             * trip instance.
             * </pre>
             *
             * <code>optional .transit_realtime.TripDescriptor trip = 1;</code>
             */
            public GtfsRealtime.TripDescriptorOrBuilder getTripOrBuilder() {
                if (tripBuilder_ != null) {
                    return tripBuilder_.getMessageOrBuilder();
                } else {
                    return trip_ == null ?
                            GtfsRealtime.TripDescriptor.getDefaultInstance() : trip_;
                }
            }

            /**
             * <pre>
             * The Trip that this vehicle is serving.
             * Can be empty or partial if the vehicle can not be identified with a given
             * trip instance.
             * </pre>
             *
             * <code>optional .transit_realtime.TripDescriptor trip = 1;</code>
             */
            private com.google.protobuf.SingleFieldBuilderV3<
                    GtfsRealtime.TripDescriptor, GtfsRealtime.TripDescriptor.Builder, GtfsRealtime.TripDescriptorOrBuilder>
            getTripFieldBuilder() {
                if (tripBuilder_ == null) {
                    tripBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
                            GtfsRealtime.TripDescriptor, GtfsRealtime.TripDescriptor.Builder, GtfsRealtime.TripDescriptorOrBuilder>(
                            getTrip(),
                            getParentForChildren(),
                            isClean());
                    trip_ = null;
                }
                return tripBuilder_;
            }

            private GtfsRealtime.VehicleDescriptor vehicle_;
            private com.google.protobuf.SingleFieldBuilderV3<
                    GtfsRealtime.VehicleDescriptor, GtfsRealtime.VehicleDescriptor.Builder, GtfsRealtime.VehicleDescriptorOrBuilder> vehicleBuilder_;

            /**
             * <pre>
             * Additional information on the vehicle that is serving this trip.
             * </pre>
             *
             * <code>optional .transit_realtime.VehicleDescriptor vehicle = 8;</code>
             */
            public boolean hasVehicle() {
                return ((bitField0_ & 0x00000002) != 0);
            }

            /**
             * <pre>
             * Additional information on the vehicle that is serving this trip.
             * </pre>
             *
             * <code>optional .transit_realtime.VehicleDescriptor vehicle = 8;</code>
             */
            public GtfsRealtime.VehicleDescriptor getVehicle() {
                if (vehicleBuilder_ == null) {
                    return vehicle_ == null ? GtfsRealtime.VehicleDescriptor.getDefaultInstance() : vehicle_;
                } else {
                    return vehicleBuilder_.getMessage();
                }
            }

            /**
             * <pre>
             * Additional information on the vehicle that is serving this trip.
             * </pre>
             *
             * <code>optional .transit_realtime.VehicleDescriptor vehicle = 8;</code>
             */
            public Builder setVehicle(GtfsRealtime.VehicleDescriptor value) {
                if (vehicleBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    vehicle_ = value;
                    onChanged();
                } else {
                    vehicleBuilder_.setMessage(value);
                }
                bitField0_ |= 0x00000002;
                return this;
            }

            /**
             * <pre>
             * Additional information on the vehicle that is serving this trip.
             * </pre>
             *
             * <code>optional .transit_realtime.VehicleDescriptor vehicle = 8;</code>
             */
            public Builder setVehicle(
                    GtfsRealtime.VehicleDescriptor.Builder builderForValue) {
                if (vehicleBuilder_ == null) {
                    vehicle_ = builderForValue.build();
                    onChanged();
                } else {
                    vehicleBuilder_.setMessage(builderForValue.build());
                }
                bitField0_ |= 0x00000002;
                return this;
            }

            /**
             * <pre>
             * Additional information on the vehicle that is serving this trip.
             * </pre>
             *
             * <code>optional .transit_realtime.VehicleDescriptor vehicle = 8;</code>
             */
            public Builder mergeVehicle(GtfsRealtime.VehicleDescriptor value) {
                if (vehicleBuilder_ == null) {
                    if (((bitField0_ & 0x00000002) != 0) &&
                            vehicle_ != null &&
                            vehicle_ != GtfsRealtime.VehicleDescriptor.getDefaultInstance()) {
                        vehicle_ =
                                GtfsRealtime.VehicleDescriptor.newBuilder(vehicle_).mergeFrom(value).buildPartial();
                    } else {
                        vehicle_ = value;
                    }
                    onChanged();
                } else {
                    vehicleBuilder_.mergeFrom(value);
                }
                bitField0_ |= 0x00000002;
                return this;
            }

            /**
             * <pre>
             * Additional information on the vehicle that is serving this trip.
             * </pre>
             *
             * <code>optional .transit_realtime.VehicleDescriptor vehicle = 8;</code>
             */
            public Builder clearVehicle() {
                if (vehicleBuilder_ == null) {
                    vehicle_ = null;
                    onChanged();
                } else {
                    vehicleBuilder_.clear();
                }
                bitField0_ = (bitField0_ & ~0x00000002);
                return this;
            }

            /**
             * <pre>
             * Additional information on the vehicle that is serving this trip.
             * </pre>
             *
             * <code>optional .transit_realtime.VehicleDescriptor vehicle = 8;</code>
             */
            public GtfsRealtime.VehicleDescriptor.Builder getVehicleBuilder() {
                bitField0_ |= 0x00000002;
                onChanged();
                return getVehicleFieldBuilder().getBuilder();
            }

            /**
             * <pre>
             * Additional information on the vehicle that is serving this trip.
             * </pre>
             *
             * <code>optional .transit_realtime.VehicleDescriptor vehicle = 8;</code>
             */
            public GtfsRealtime.VehicleDescriptorOrBuilder getVehicleOrBuilder() {
                if (vehicleBuilder_ != null) {
                    return vehicleBuilder_.getMessageOrBuilder();
                } else {
                    return vehicle_ == null ?
                            GtfsRealtime.VehicleDescriptor.getDefaultInstance() : vehicle_;
                }
            }

            /**
             * <pre>
             * Additional information on the vehicle that is serving this trip.
             * </pre>
             *
             * <code>optional .transit_realtime.VehicleDescriptor vehicle = 8;</code>
             */
            private com.google.protobuf.SingleFieldBuilderV3<
                    GtfsRealtime.VehicleDescriptor, GtfsRealtime.VehicleDescriptor.Builder, GtfsRealtime.VehicleDescriptorOrBuilder>
            getVehicleFieldBuilder() {
                if (vehicleBuilder_ == null) {
                    vehicleBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
                            GtfsRealtime.VehicleDescriptor, GtfsRealtime.VehicleDescriptor.Builder, GtfsRealtime.VehicleDescriptorOrBuilder>(
                            getVehicle(),
                            getParentForChildren(),
                            isClean());
                    vehicle_ = null;
                }
                return vehicleBuilder_;
            }

            private GtfsRealtime.Position position_;
            private com.google.protobuf.SingleFieldBuilderV3<
                    GtfsRealtime.Position, GtfsRealtime.Position.Builder, GtfsRealtime.PositionOrBuilder> positionBuilder_;

            /**
             * <pre>
             * Current position of this vehicle.
             * </pre>
             *
             * <code>optional .transit_realtime.Position position = 2;</code>
             */
            public boolean hasPosition() {
                return ((bitField0_ & 0x00000004) != 0);
            }

            /**
             * <pre>
             * Current position of this vehicle.
             * </pre>
             *
             * <code>optional .transit_realtime.Position position = 2;</code>
             */
            public GtfsRealtime.Position getPosition() {
                if (positionBuilder_ == null) {
                    return position_ == null ? GtfsRealtime.Position.getDefaultInstance() : position_;
                } else {
                    return positionBuilder_.getMessage();
                }
            }

            /**
             * <pre>
             * Current position of this vehicle.
             * </pre>
             *
             * <code>optional .transit_realtime.Position position = 2;</code>
             */
            public Builder setPosition(GtfsRealtime.Position value) {
                if (positionBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    position_ = value;
                    onChanged();
                } else {
                    positionBuilder_.setMessage(value);
                }
                bitField0_ |= 0x00000004;
                return this;
            }

            /**
             * <pre>
             * Current position of this vehicle.
             * </pre>
             *
             * <code>optional .transit_realtime.Position position = 2;</code>
             */
            public Builder setPosition(
                    GtfsRealtime.Position.Builder builderForValue) {
                if (positionBuilder_ == null) {
                    position_ = builderForValue.build();
                    onChanged();
                } else {
                    positionBuilder_.setMessage(builderForValue.build());
                }
                bitField0_ |= 0x00000004;
                return this;
            }

            /**
             * <pre>
             * Current position of this vehicle.
             * </pre>
             *
             * <code>optional .transit_realtime.Position position = 2;</code>
             */
            public Builder mergePosition(GtfsRealtime.Position value) {
                if (positionBuilder_ == null) {
                    if (((bitField0_ & 0x00000004) != 0) &&
                            position_ != null &&
                            position_ != GtfsRealtime.Position.getDefaultInstance()) {
                        position_ =
                                GtfsRealtime.Position.newBuilder(position_).mergeFrom(value).buildPartial();
                    } else {
                        position_ = value;
                    }
                    onChanged();
                } else {
                    positionBuilder_.mergeFrom(value);
                }
                bitField0_ |= 0x00000004;
                return this;
            }

            /**
             * <pre>
             * Current position of this vehicle.
             * </pre>
             *
             * <code>optional .transit_realtime.Position position = 2;</code>
             */
            public Builder clearPosition() {
                if (positionBuilder_ == null) {
                    position_ = null;
                    onChanged();
                } else {
                    positionBuilder_.clear();
                }
                bitField0_ = (bitField0_ & ~0x00000004);
                return this;
            }

            /**
             * <pre>
             * Current position of this vehicle.
             * </pre>
             *
             * <code>optional .transit_realtime.Position position = 2;</code>
             */
            public GtfsRealtime.Position.Builder getPositionBuilder() {
                bitField0_ |= 0x00000004;
                onChanged();
                return getPositionFieldBuilder().getBuilder();
            }

            /**
             * <pre>
             * Current position of this vehicle.
             * </pre>
             *
             * <code>optional .transit_realtime.Position position = 2;</code>
             */
            public GtfsRealtime.PositionOrBuilder getPositionOrBuilder() {
                if (positionBuilder_ != null) {
                    return positionBuilder_.getMessageOrBuilder();
                } else {
                    return position_ == null ?
                            GtfsRealtime.Position.getDefaultInstance() : position_;
                }
            }

            /**
             * <pre>
             * Current position of this vehicle.
             * </pre>
             *
             * <code>optional .transit_realtime.Position position = 2;</code>
             */
            private com.google.protobuf.SingleFieldBuilderV3<
                    GtfsRealtime.Position, GtfsRealtime.Position.Builder, GtfsRealtime.PositionOrBuilder>
            getPositionFieldBuilder() {
                if (positionBuilder_ == null) {
                    positionBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
                            GtfsRealtime.Position, GtfsRealtime.Position.Builder, GtfsRealtime.PositionOrBuilder>(
                            getPosition(),
                            getParentForChildren(),
                            isClean());
                    position_ = null;
                }
                return positionBuilder_;
            }

            private int currentStopSequence_;

            /**
             * <pre>
             * The stop sequence index of the current stop. The meaning of
             * current_stop_sequence (i.e., the stop that it refers to) is determined by
             * current_status.
             * If current_status is missing IN_TRANSIT_TO is assumed.
             * </pre>
             *
             * <code>optional uint32 current_stop_sequence = 3;</code>
             */
            public boolean hasCurrentStopSequence() {
                return ((bitField0_ & 0x00000008) != 0);
            }

            /**
             * <pre>
             * The stop sequence index of the current stop. The meaning of
             * current_stop_sequence (i.e., the stop that it refers to) is determined by
             * current_status.
             * If current_status is missing IN_TRANSIT_TO is assumed.
             * </pre>
             *
             * <code>optional uint32 current_stop_sequence = 3;</code>
             */
            public int getCurrentStopSequence() {
                return currentStopSequence_;
            }

            /**
             * <pre>
             * The stop sequence index of the current stop. The meaning of
             * current_stop_sequence (i.e., the stop that it refers to) is determined by
             * current_status.
             * If current_status is missing IN_TRANSIT_TO is assumed.
             * </pre>
             *
             * <code>optional uint32 current_stop_sequence = 3;</code>
             */
            public Builder setCurrentStopSequence(int value) {
                bitField0_ |= 0x00000008;
                currentStopSequence_ = value;
                onChanged();
                return this;
            }

            /**
             * <pre>
             * The stop sequence index of the current stop. The meaning of
             * current_stop_sequence (i.e., the stop that it refers to) is determined by
             * current_status.
             * If current_status is missing IN_TRANSIT_TO is assumed.
             * </pre>
             *
             * <code>optional uint32 current_stop_sequence = 3;</code>
             */
            public Builder clearCurrentStopSequence() {
                bitField0_ = (bitField0_ & ~0x00000008);
                currentStopSequence_ = 0;
                onChanged();
                return this;
            }

            private java.lang.Object stopId_ = "";

            /**
             * <pre>
             * Identifies the current stop. The value must be the same as in stops.txt in
             * the corresponding GTFS feed.
             * </pre>
             *
             * <code>optional string stop_id = 7;</code>
             */
            public boolean hasStopId() {
                return ((bitField0_ & 0x00000010) != 0);
            }

            /**
             * <pre>
             * Identifies the current stop. The value must be the same as in stops.txt in
             * the corresponding GTFS feed.
             * </pre>
             *
             * <code>optional string stop_id = 7;</code>
             */
            public java.lang.String getStopId() {
                java.lang.Object ref = stopId_;
                if (!(ref instanceof java.lang.String)) {
                    com.google.protobuf.ByteString bs =
                            (com.google.protobuf.ByteString) ref;
                    java.lang.String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        stopId_ = s;
                    }
                    return s;
                } else {
                    return (java.lang.String) ref;
                }
            }

            /**
             * <pre>
             * Identifies the current stop. The value must be the same as in stops.txt in
             * the corresponding GTFS feed.
             * </pre>
             *
             * <code>optional string stop_id = 7;</code>
             */
            public com.google.protobuf.ByteString
            getStopIdBytes() {
                java.lang.Object ref = stopId_;
                if (ref instanceof String) {
                    com.google.protobuf.ByteString b =
                            com.google.protobuf.ByteString.copyFromUtf8(
                                    (java.lang.String) ref);
                    stopId_ = b;
                    return b;
                } else {
                    return (com.google.protobuf.ByteString) ref;
                }
            }

            /**
             * <pre>
             * Identifies the current stop. The value must be the same as in stops.txt in
             * the corresponding GTFS feed.
             * </pre>
             *
             * <code>optional string stop_id = 7;</code>
             */
            public Builder setStopId(
                    java.lang.String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000010;
                stopId_ = value;
                onChanged();
                return this;
            }

            /**
             * <pre>
             * Identifies the current stop. The value must be the same as in stops.txt in
             * the corresponding GTFS feed.
             * </pre>
             *
             * <code>optional string stop_id = 7;</code>
             */
            public Builder clearStopId() {
                bitField0_ = (bitField0_ & ~0x00000010);
                stopId_ = getDefaultInstance().getStopId();
                onChanged();
                return this;
            }

            /**
             * <pre>
             * Identifies the current stop. The value must be the same as in stops.txt in
             * the corresponding GTFS feed.
             * </pre>
             *
             * <code>optional string stop_id = 7;</code>
             */
            public Builder setStopIdBytes(
                    com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000010;
                stopId_ = value;
                onChanged();
                return this;
            }

            private int currentStatus_ = 2;

            /**
             * <pre>
             * The exact status of the vehicle with respect to the current stop.
             * Ignored if current_stop_sequence is missing.
             * </pre>
             *
             * <code>optional .transit_realtime.VehiclePosition.VehicleStopStatus current_status = 4 [default = IN_TRANSIT_TO];</code>
             */
            public boolean hasCurrentStatus() {
                return ((bitField0_ & 0x00000020) != 0);
            }

            /**
             * <pre>
             * The exact status of the vehicle with respect to the current stop.
             * Ignored if current_stop_sequence is missing.
             * </pre>
             *
             * <code>optional .transit_realtime.VehiclePosition.VehicleStopStatus current_status = 4 [default = IN_TRANSIT_TO];</code>
             */
            public GtfsRealtime.VehiclePosition.VehicleStopStatus getCurrentStatus() {
                @SuppressWarnings("deprecation")
                GtfsRealtime.VehiclePosition.VehicleStopStatus result = GtfsRealtime.VehiclePosition.VehicleStopStatus.valueOf(currentStatus_);
                return result == null ? GtfsRealtime.VehiclePosition.VehicleStopStatus.IN_TRANSIT_TO : result;
            }

            /**
             * <pre>
             * The exact status of the vehicle with respect to the current stop.
             * Ignored if current_stop_sequence is missing.
             * </pre>
             *
             * <code>optional .transit_realtime.VehiclePosition.VehicleStopStatus current_status = 4 [default = IN_TRANSIT_TO];</code>
             */
            public Builder setCurrentStatus(GtfsRealtime.VehiclePosition.VehicleStopStatus value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000020;
                currentStatus_ = value.getNumber();
                onChanged();
                return this;
            }

            /**
             * <pre>
             * The exact status of the vehicle with respect to the current stop.
             * Ignored if current_stop_sequence is missing.
             * </pre>
             *
             * <code>optional .transit_realtime.VehiclePosition.VehicleStopStatus current_status = 4 [default = IN_TRANSIT_TO];</code>
             */
            public Builder clearCurrentStatus() {
                bitField0_ = (bitField0_ & ~0x00000020);
                currentStatus_ = 2;
                onChanged();
                return this;
            }

            private long timestamp_;

            /**
             * <pre>
             * Moment at which the vehicle's position was measured. In POSIX time
             * (i.e., number of seconds since January 1st 1970 00:00:00 UTC).
             * </pre>
             *
             * <code>optional uint64 timestamp = 5;</code>
             */
            public boolean hasTimestamp() {
                return ((bitField0_ & 0x00000040) != 0);
            }

            /**
             * <pre>
             * Moment at which the vehicle's position was measured. In POSIX time
             * (i.e., number of seconds since January 1st 1970 00:00:00 UTC).
             * </pre>
             *
             * <code>optional uint64 timestamp = 5;</code>
             */
            public long getTimestamp() {
                return timestamp_;
            }

            /**
             * <pre>
             * Moment at which the vehicle's position was measured. In POSIX time
             * (i.e., number of seconds since January 1st 1970 00:00:00 UTC).
             * </pre>
             *
             * <code>optional uint64 timestamp = 5;</code>
             */
            public Builder setTimestamp(long value) {
                bitField0_ |= 0x00000040;
                timestamp_ = value;
                onChanged();
                return this;
            }

            /**
             * <pre>
             * Moment at which the vehicle's position was measured. In POSIX time
             * (i.e., number of seconds since January 1st 1970 00:00:00 UTC).
             * </pre>
             *
             * <code>optional uint64 timestamp = 5;</code>
             */
            public Builder clearTimestamp() {
                bitField0_ = (bitField0_ & ~0x00000040);
                timestamp_ = 0L;
                onChanged();
                return this;
            }

            private int congestionLevel_ = 0;

            /**
             * <code>optional .transit_realtime.VehiclePosition.CongestionLevel congestion_level = 6;</code>
             */
            public boolean hasCongestionLevel() {
                return ((bitField0_ & 0x00000080) != 0);
            }

            /**
             * <code>optional .transit_realtime.VehiclePosition.CongestionLevel congestion_level = 6;</code>
             */
            public GtfsRealtime.VehiclePosition.CongestionLevel getCongestionLevel() {
                @SuppressWarnings("deprecation")
                GtfsRealtime.VehiclePosition.CongestionLevel result = GtfsRealtime.VehiclePosition.CongestionLevel.valueOf(congestionLevel_);
                return result == null ? GtfsRealtime.VehiclePosition.CongestionLevel.UNKNOWN_CONGESTION_LEVEL : result;
            }

            /**
             * <code>optional .transit_realtime.VehiclePosition.CongestionLevel congestion_level = 6;</code>
             */
            public Builder setCongestionLevel(GtfsRealtime.VehiclePosition.CongestionLevel value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000080;
                congestionLevel_ = value.getNumber();
                onChanged();
                return this;
            }

            /**
             * <code>optional .transit_realtime.VehiclePosition.CongestionLevel congestion_level = 6;</code>
             */
            public Builder clearCongestionLevel() {
                bitField0_ = (bitField0_ & ~0x00000080);
                congestionLevel_ = 0;
                onChanged();
                return this;
            }

            private int occupancyStatus_ = 0;

            /**
             * <code>optional .transit_realtime.VehiclePosition.OccupancyStatus occupancy_status = 9;</code>
             */
            public boolean hasOccupancyStatus() {
                return ((bitField0_ & 0x00000100) != 0);
            }

            /**
             * <code>optional .transit_realtime.VehiclePosition.OccupancyStatus occupancy_status = 9;</code>
             */
            public GtfsRealtime.VehiclePosition.OccupancyStatus getOccupancyStatus() {
                @SuppressWarnings("deprecation")
                GtfsRealtime.VehiclePosition.OccupancyStatus result = GtfsRealtime.VehiclePosition.OccupancyStatus.valueOf(occupancyStatus_);
                return result == null ? GtfsRealtime.VehiclePosition.OccupancyStatus.EMPTY : result;
            }

            /**
             * <code>optional .transit_realtime.VehiclePosition.OccupancyStatus occupancy_status = 9;</code>
             */
            public Builder setOccupancyStatus(GtfsRealtime.VehiclePosition.OccupancyStatus value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000100;
                occupancyStatus_ = value.getNumber();
                onChanged();
                return this;
            }

            /**
             * <code>optional .transit_realtime.VehiclePosition.OccupancyStatus occupancy_status = 9;</code>
             */
            public Builder clearOccupancyStatus() {
                bitField0_ = (bitField0_ & ~0x00000100);
                occupancyStatus_ = 0;
                onChanged();
                return this;
            }

            @java.lang.Override
            public final Builder setUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.setUnknownFields(unknownFields);
            }

            @java.lang.Override
            public final Builder mergeUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.mergeUnknownFields(unknownFields);
            }


            // @@protoc_insertion_point(builder_scope:transit_realtime.VehiclePosition)
        }

        // @@protoc_insertion_point(class_scope:transit_realtime.VehiclePosition)
        private static final GtfsRealtime.VehiclePosition DEFAULT_INSTANCE;

        static {
            DEFAULT_INSTANCE = new GtfsRealtime.VehiclePosition();
        }

        public static GtfsRealtime.VehiclePosition getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        @java.lang.Deprecated
        public static final com.google.protobuf.Parser<VehiclePosition>
                PARSER = new com.google.protobuf.AbstractParser<VehiclePosition>() {
            @java.lang.Override
            public VehiclePosition parsePartialFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return new VehiclePosition(input, extensionRegistry);
            }
        };

        public static com.google.protobuf.Parser<VehiclePosition> parser() {
            return PARSER;
        }

        @java.lang.Override
        public com.google.protobuf.Parser<VehiclePosition> getParserForType() {
            return PARSER;
        }

        @java.lang.Override
        public GtfsRealtime.VehiclePosition getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

    }

    public interface AlertOrBuilder extends
            // @@protoc_insertion_point(interface_extends:transit_realtime.Alert)
            com.google.protobuf.GeneratedMessageV3.
                    ExtendableMessageOrBuilder<Alert> {

        /**
         * <pre>
         * Time when the alert should be shown to the user. If missing, the
         * alert will be shown as long as it appears in the feed.
         * If multiple ranges are given, the alert will be shown during all of them.
         * </pre>
         *
         * <code>repeated .transit_realtime.TimeRange active_period = 1;</code>
         */
        java.util.List<GtfsRealtime.TimeRange>
        getActivePeriodList();

        /**
         * <pre>
         * Time when the alert should be shown to the user. If missing, the
         * alert will be shown as long as it appears in the feed.
         * If multiple ranges are given, the alert will be shown during all of them.
         * </pre>
         *
         * <code>repeated .transit_realtime.TimeRange active_period = 1;</code>
         */
        GtfsRealtime.TimeRange getActivePeriod(int index);

        /**
         * <pre>
         * Time when the alert should be shown to the user. If missing, the
         * alert will be shown as long as it appears in the feed.
         * If multiple ranges are given, the alert will be shown during all of them.
         * </pre>
         *
         * <code>repeated .transit_realtime.TimeRange active_period = 1;</code>
         */
        int getActivePeriodCount();

        /**
         * <pre>
         * Time when the alert should be shown to the user. If missing, the
         * alert will be shown as long as it appears in the feed.
         * If multiple ranges are given, the alert will be shown during all of them.
         * </pre>
         *
         * <code>repeated .transit_realtime.TimeRange active_period = 1;</code>
         */
        java.util.List<? extends GtfsRealtime.TimeRangeOrBuilder>
        getActivePeriodOrBuilderList();

        /**
         * <pre>
         * Time when the alert should be shown to the user. If missing, the
         * alert will be shown as long as it appears in the feed.
         * If multiple ranges are given, the alert will be shown during all of them.
         * </pre>
         *
         * <code>repeated .transit_realtime.TimeRange active_period = 1;</code>
         */
        GtfsRealtime.TimeRangeOrBuilder getActivePeriodOrBuilder(
                int index);

        /**
         * <pre>
         * Entities whose users we should notify of this alert.
         * </pre>
         *
         * <code>repeated .transit_realtime.EntitySelector informed_entity = 5;</code>
         */
        java.util.List<GtfsRealtime.EntitySelector>
        getInformedEntityList();

        /**
         * <pre>
         * Entities whose users we should notify of this alert.
         * </pre>
         *
         * <code>repeated .transit_realtime.EntitySelector informed_entity = 5;</code>
         */
        GtfsRealtime.EntitySelector getInformedEntity(int index);

        /**
         * <pre>
         * Entities whose users we should notify of this alert.
         * </pre>
         *
         * <code>repeated .transit_realtime.EntitySelector informed_entity = 5;</code>
         */
        int getInformedEntityCount();

        /**
         * <pre>
         * Entities whose users we should notify of this alert.
         * </pre>
         *
         * <code>repeated .transit_realtime.EntitySelector informed_entity = 5;</code>
         */
        java.util.List<? extends GtfsRealtime.EntitySelectorOrBuilder>
        getInformedEntityOrBuilderList();

        /**
         * <pre>
         * Entities whose users we should notify of this alert.
         * </pre>
         *
         * <code>repeated .transit_realtime.EntitySelector informed_entity = 5;</code>
         */
        GtfsRealtime.EntitySelectorOrBuilder getInformedEntityOrBuilder(
                int index);

        /**
         * <code>optional .transit_realtime.Alert.Cause cause = 6 [default = UNKNOWN_CAUSE];</code>
         */
        boolean hasCause();

        /**
         * <code>optional .transit_realtime.Alert.Cause cause = 6 [default = UNKNOWN_CAUSE];</code>
         */
        GtfsRealtime.Alert.Cause getCause();

        /**
         * <code>optional .transit_realtime.Alert.Effect effect = 7 [default = UNKNOWN_EFFECT];</code>
         */
        boolean hasEffect();

        /**
         * <code>optional .transit_realtime.Alert.Effect effect = 7 [default = UNKNOWN_EFFECT];</code>
         */
        GtfsRealtime.Alert.Effect getEffect();

        /**
         * <pre>
         * The URL which provides additional information about the alert.
         * </pre>
         *
         * <code>optional .transit_realtime.TranslatedString url = 8;</code>
         */
        boolean hasUrl();

        /**
         * <pre>
         * The URL which provides additional information about the alert.
         * </pre>
         *
         * <code>optional .transit_realtime.TranslatedString url = 8;</code>
         */
        GtfsRealtime.TranslatedString getUrl();

        /**
         * <pre>
         * The URL which provides additional information about the alert.
         * </pre>
         *
         * <code>optional .transit_realtime.TranslatedString url = 8;</code>
         */
        GtfsRealtime.TranslatedStringOrBuilder getUrlOrBuilder();

        /**
         * <pre>
         * Alert header. Contains a short summary of the alert text as plain-text.
         * </pre>
         *
         * <code>optional .transit_realtime.TranslatedString header_text = 10;</code>
         */
        boolean hasHeaderText();

        /**
         * <pre>
         * Alert header. Contains a short summary of the alert text as plain-text.
         * </pre>
         *
         * <code>optional .transit_realtime.TranslatedString header_text = 10;</code>
         */
        GtfsRealtime.TranslatedString getHeaderText();

        /**
         * <pre>
         * Alert header. Contains a short summary of the alert text as plain-text.
         * </pre>
         *
         * <code>optional .transit_realtime.TranslatedString header_text = 10;</code>
         */
        GtfsRealtime.TranslatedStringOrBuilder getHeaderTextOrBuilder();

        /**
         * <pre>
         * Full description for the alert as plain-text. The information in the
         * description should add to the information of the header.
         * </pre>
         *
         * <code>optional .transit_realtime.TranslatedString description_text = 11;</code>
         */
        boolean hasDescriptionText();

        /**
         * <pre>
         * Full description for the alert as plain-text. The information in the
         * description should add to the information of the header.
         * </pre>
         *
         * <code>optional .transit_realtime.TranslatedString description_text = 11;</code>
         */
        GtfsRealtime.TranslatedString getDescriptionText();

        /**
         * <pre>
         * Full description for the alert as plain-text. The information in the
         * description should add to the information of the header.
         * </pre>
         *
         * <code>optional .transit_realtime.TranslatedString description_text = 11;</code>
         */
        GtfsRealtime.TranslatedStringOrBuilder getDescriptionTextOrBuilder();
    }

    /**
     * <pre>
     * An alert, indicating some sort of incident in the public transit network.
     * </pre>
     * <p>
     * Protobuf type {@code transit_realtime.Alert}
     */
    public static final class Alert extends
            com.google.protobuf.GeneratedMessageV3.ExtendableMessage<
                    Alert> implements
            // @@protoc_insertion_point(message_implements:transit_realtime.Alert)
            AlertOrBuilder {
        private static final long serialVersionUID = 0L;

        // Use Alert.newBuilder() to construct.
        private Alert(com.google.protobuf.GeneratedMessageV3.ExtendableBuilder<GtfsRealtime.Alert, ?> builder) {
            super(builder);
        }

        private Alert() {
            activePeriod_ = java.util.Collections.emptyList();
            informedEntity_ = java.util.Collections.emptyList();
            cause_ = 1;
            effect_ = 8;
        }

        @java.lang.Override
        @SuppressWarnings({"unused"})
        protected java.lang.Object newInstance(
                UnusedPrivateParameter unused) {
            return new Alert();
        }

        @java.lang.Override
        public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
            return this.unknownFields;
        }

        private Alert(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            if (extensionRegistry == null) {
                throw new java.lang.NullPointerException();
            }
            int mutable_bitField0_ = 0;
            com.google.protobuf.UnknownFieldSet.Builder unknownFields =
                    com.google.protobuf.UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        case 10: {
                            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
                                activePeriod_ = new java.util.ArrayList<GtfsRealtime.TimeRange>();
                                mutable_bitField0_ |= 0x00000001;
                            }
                            activePeriod_.add(
                                    input.readMessage(GtfsRealtime.TimeRange.PARSER, extensionRegistry));
                            break;
                        }
                        case 42: {
                            if (!((mutable_bitField0_ & 0x00000002) != 0)) {
                                informedEntity_ = new java.util.ArrayList<GtfsRealtime.EntitySelector>();
                                mutable_bitField0_ |= 0x00000002;
                            }
                            informedEntity_.add(
                                    input.readMessage(GtfsRealtime.EntitySelector.PARSER, extensionRegistry));
                            break;
                        }
                        case 48: {
                            int rawValue = input.readEnum();
                            @SuppressWarnings("deprecation")
                            GtfsRealtime.Alert.Cause value = GtfsRealtime.Alert.Cause.valueOf(rawValue);
                            if (value == null) {
                                unknownFields.mergeVarintField(6, rawValue);
                            } else {
                                bitField0_ |= 0x00000001;
                                cause_ = rawValue;
                            }
                            break;
                        }
                        case 56: {
                            int rawValue = input.readEnum();
                            @SuppressWarnings("deprecation")
                            GtfsRealtime.Alert.Effect value = GtfsRealtime.Alert.Effect.valueOf(rawValue);
                            if (value == null) {
                                unknownFields.mergeVarintField(7, rawValue);
                            } else {
                                bitField0_ |= 0x00000002;
                                effect_ = rawValue;
                            }
                            break;
                        }
                        case 66: {
                            GtfsRealtime.TranslatedString.Builder subBuilder = null;
                            if (((bitField0_ & 0x00000004) != 0)) {
                                subBuilder = url_.toBuilder();
                            }
                            url_ = input.readMessage(GtfsRealtime.TranslatedString.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(url_);
                                url_ = subBuilder.buildPartial();
                            }
                            bitField0_ |= 0x00000004;
                            break;
                        }
                        case 82: {
                            GtfsRealtime.TranslatedString.Builder subBuilder = null;
                            if (((bitField0_ & 0x00000008) != 0)) {
                                subBuilder = headerText_.toBuilder();
                            }
                            headerText_ = input.readMessage(GtfsRealtime.TranslatedString.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(headerText_);
                                headerText_ = subBuilder.buildPartial();
                            }
                            bitField0_ |= 0x00000008;
                            break;
                        }
                        case 90: {
                            GtfsRealtime.TranslatedString.Builder subBuilder = null;
                            if (((bitField0_ & 0x00000010) != 0)) {
                                subBuilder = descriptionText_.toBuilder();
                            }
                            descriptionText_ = input.readMessage(GtfsRealtime.TranslatedString.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(descriptionText_);
                                descriptionText_ = subBuilder.buildPartial();
                            }
                            bitField0_ |= 0x00000010;
                            break;
                        }
                        default: {
                            if (!parseUnknownField(
                                    input, unknownFields, extensionRegistry, tag)) {
                                done = true;
                            }
                            break;
                        }
                    }
                }
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (java.io.IOException e) {
                throw new com.google.protobuf.InvalidProtocolBufferException(
                        e).setUnfinishedMessage(this);
            } finally {
                if (((mutable_bitField0_ & 0x00000001) != 0)) {
                    activePeriod_ = java.util.Collections.unmodifiableList(activePeriod_);
                }
                if (((mutable_bitField0_ & 0x00000002) != 0)) {
                    informedEntity_ = java.util.Collections.unmodifiableList(informedEntity_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return GtfsRealtime.internal_static_transit_realtime_Alert_descriptor;
        }

        @java.lang.Override
        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return GtfsRealtime.internal_static_transit_realtime_Alert_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            GtfsRealtime.Alert.class, GtfsRealtime.Alert.Builder.class);
        }

        /**
         * <pre>
         * Cause of this alert.
         * </pre>
         * <p>
         * Protobuf enum {@code transit_realtime.Alert.Cause}
         */
        public enum Cause
                implements com.google.protobuf.ProtocolMessageEnum {
            /**
             * <code>UNKNOWN_CAUSE = 1;</code>
             */
            UNKNOWN_CAUSE(1),
            /**
             * <pre>
             * Not machine-representable.
             * </pre>
             *
             * <code>OTHER_CAUSE = 2;</code>
             */
            OTHER_CAUSE(2),
            /**
             * <code>TECHNICAL_PROBLEM = 3;</code>
             */
            TECHNICAL_PROBLEM(3),
            /**
             * <pre>
             * Public transit agency employees stopped working.
             * </pre>
             *
             * <code>STRIKE = 4;</code>
             */
            STRIKE(4),
            /**
             * <pre>
             * People are blocking the streets.
             * </pre>
             *
             * <code>DEMONSTRATION = 5;</code>
             */
            DEMONSTRATION(5),
            /**
             * <code>ACCIDENT = 6;</code>
             */
            ACCIDENT(6),
            /**
             * <code>HOLIDAY = 7;</code>
             */
            HOLIDAY(7),
            /**
             * <code>WEATHER = 8;</code>
             */
            WEATHER(8),
            /**
             * <code>MAINTENANCE = 9;</code>
             */
            MAINTENANCE(9),
            /**
             * <code>CONSTRUCTION = 10;</code>
             */
            CONSTRUCTION(10),
            /**
             * <code>POLICE_ACTIVITY = 11;</code>
             */
            POLICE_ACTIVITY(11),
            /**
             * <code>MEDICAL_EMERGENCY = 12;</code>
             */
            MEDICAL_EMERGENCY(12),
            ;

            /**
             * <code>UNKNOWN_CAUSE = 1;</code>
             */
            public static final int UNKNOWN_CAUSE_VALUE = 1;
            /**
             * <pre>
             * Not machine-representable.
             * </pre>
             *
             * <code>OTHER_CAUSE = 2;</code>
             */
            public static final int OTHER_CAUSE_VALUE = 2;
            /**
             * <code>TECHNICAL_PROBLEM = 3;</code>
             */
            public static final int TECHNICAL_PROBLEM_VALUE = 3;
            /**
             * <pre>
             * Public transit agency employees stopped working.
             * </pre>
             *
             * <code>STRIKE = 4;</code>
             */
            public static final int STRIKE_VALUE = 4;
            /**
             * <pre>
             * People are blocking the streets.
             * </pre>
             *
             * <code>DEMONSTRATION = 5;</code>
             */
            public static final int DEMONSTRATION_VALUE = 5;
            /**
             * <code>ACCIDENT = 6;</code>
             */
            public static final int ACCIDENT_VALUE = 6;
            /**
             * <code>HOLIDAY = 7;</code>
             */
            public static final int HOLIDAY_VALUE = 7;
            /**
             * <code>WEATHER = 8;</code>
             */
            public static final int WEATHER_VALUE = 8;
            /**
             * <code>MAINTENANCE = 9;</code>
             */
            public static final int MAINTENANCE_VALUE = 9;
            /**
             * <code>CONSTRUCTION = 10;</code>
             */
            public static final int CONSTRUCTION_VALUE = 10;
            /**
             * <code>POLICE_ACTIVITY = 11;</code>
             */
            public static final int POLICE_ACTIVITY_VALUE = 11;
            /**
             * <code>MEDICAL_EMERGENCY = 12;</code>
             */
            public static final int MEDICAL_EMERGENCY_VALUE = 12;


            public final int getNumber() {
                return value;
            }

            /**
             * @deprecated Use {@link #forNumber(int)} instead.
             */
            @java.lang.Deprecated
            public static Cause valueOf(int value) {
                return forNumber(value);
            }

            public static Cause forNumber(int value) {
                switch (value) {
                    case 1:
                        return UNKNOWN_CAUSE;
                    case 2:
                        return OTHER_CAUSE;
                    case 3:
                        return TECHNICAL_PROBLEM;
                    case 4:
                        return STRIKE;
                    case 5:
                        return DEMONSTRATION;
                    case 6:
                        return ACCIDENT;
                    case 7:
                        return HOLIDAY;
                    case 8:
                        return WEATHER;
                    case 9:
                        return MAINTENANCE;
                    case 10:
                        return CONSTRUCTION;
                    case 11:
                        return POLICE_ACTIVITY;
                    case 12:
                        return MEDICAL_EMERGENCY;
                    default:
                        return null;
                }
            }

            public static com.google.protobuf.Internal.EnumLiteMap<Cause>
            internalGetValueMap() {
                return internalValueMap;
            }

            private static final com.google.protobuf.Internal.EnumLiteMap<
                    Cause> internalValueMap =
                    new com.google.protobuf.Internal.EnumLiteMap<Cause>() {
                        public Cause findValueByNumber(int number) {
                            return Cause.forNumber(number);
                        }
                    };

            public final com.google.protobuf.Descriptors.EnumValueDescriptor
            getValueDescriptor() {
                return getDescriptor().getValues().get(ordinal());
            }

            public final com.google.protobuf.Descriptors.EnumDescriptor
            getDescriptorForType() {
                return getDescriptor();
            }

            public static final com.google.protobuf.Descriptors.EnumDescriptor
            getDescriptor() {
                return GtfsRealtime.Alert.getDescriptor().getEnumTypes().get(0);
            }

            private static final Cause[] VALUES = values();

            public static Cause valueOf(
                    com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
                if (desc.getType() != getDescriptor()) {
                    throw new java.lang.IllegalArgumentException(
                            "EnumValueDescriptor is not for this type.");
                }
                return VALUES[desc.getIndex()];
            }

            private final int value;

            private Cause(int value) {
                this.value = value;
            }

            // @@protoc_insertion_point(enum_scope:transit_realtime.Alert.Cause)
        }

        /**
         * <pre>
         * What is the effect of this problem on the affected entity.
         * </pre>
         * <p>
         * Protobuf enum {@code transit_realtime.Alert.Effect}
         */
        public enum Effect
                implements com.google.protobuf.ProtocolMessageEnum {
            /**
             * <code>NO_SERVICE = 1;</code>
             */
            NO_SERVICE(1),
            /**
             * <code>REDUCED_SERVICE = 2;</code>
             */
            REDUCED_SERVICE(2),
            /**
             * <pre>
             * We don't care about INsignificant delays: they are hard to detect, have
             * little impact on the user, and would clutter the results as they are too
             * frequent.
             * </pre>
             *
             * <code>SIGNIFICANT_DELAYS = 3;</code>
             */
            SIGNIFICANT_DELAYS(3),
            /**
             * <code>DETOUR = 4;</code>
             */
            DETOUR(4),
            /**
             * <code>ADDITIONAL_SERVICE = 5;</code>
             */
            ADDITIONAL_SERVICE(5),
            /**
             * <code>MODIFIED_SERVICE = 6;</code>
             */
            MODIFIED_SERVICE(6),
            /**
             * <code>OTHER_EFFECT = 7;</code>
             */
            OTHER_EFFECT(7),
            /**
             * <code>UNKNOWN_EFFECT = 8;</code>
             */
            UNKNOWN_EFFECT(8),
            /**
             * <code>STOP_MOVED = 9;</code>
             */
            STOP_MOVED(9),
            ;

            /**
             * <code>NO_SERVICE = 1;</code>
             */
            public static final int NO_SERVICE_VALUE = 1;
            /**
             * <code>REDUCED_SERVICE = 2;</code>
             */
            public static final int REDUCED_SERVICE_VALUE = 2;
            /**
             * <pre>
             * We don't care about INsignificant delays: they are hard to detect, have
             * little impact on the user, and would clutter the results as they are too
             * frequent.
             * </pre>
             *
             * <code>SIGNIFICANT_DELAYS = 3;</code>
             */
            public static final int SIGNIFICANT_DELAYS_VALUE = 3;
            /**
             * <code>DETOUR = 4;</code>
             */
            public static final int DETOUR_VALUE = 4;
            /**
             * <code>ADDITIONAL_SERVICE = 5;</code>
             */
            public static final int ADDITIONAL_SERVICE_VALUE = 5;
            /**
             * <code>MODIFIED_SERVICE = 6;</code>
             */
            public static final int MODIFIED_SERVICE_VALUE = 6;
            /**
             * <code>OTHER_EFFECT = 7;</code>
             */
            public static final int OTHER_EFFECT_VALUE = 7;
            /**
             * <code>UNKNOWN_EFFECT = 8;</code>
             */
            public static final int UNKNOWN_EFFECT_VALUE = 8;
            /**
             * <code>STOP_MOVED = 9;</code>
             */
            public static final int STOP_MOVED_VALUE = 9;


            public final int getNumber() {
                return value;
            }

            /**
             * @deprecated Use {@link #forNumber(int)} instead.
             */
            @java.lang.Deprecated
            public static Effect valueOf(int value) {
                return forNumber(value);
            }

            public static Effect forNumber(int value) {
                switch (value) {
                    case 1:
                        return NO_SERVICE;
                    case 2:
                        return REDUCED_SERVICE;
                    case 3:
                        return SIGNIFICANT_DELAYS;
                    case 4:
                        return DETOUR;
                    case 5:
                        return ADDITIONAL_SERVICE;
                    case 6:
                        return MODIFIED_SERVICE;
                    case 7:
                        return OTHER_EFFECT;
                    case 8:
                        return UNKNOWN_EFFECT;
                    case 9:
                        return STOP_MOVED;
                    default:
                        return null;
                }
            }

            public static com.google.protobuf.Internal.EnumLiteMap<Effect>
            internalGetValueMap() {
                return internalValueMap;
            }

            private static final com.google.protobuf.Internal.EnumLiteMap<
                    Effect> internalValueMap =
                    new com.google.protobuf.Internal.EnumLiteMap<Effect>() {
                        public Effect findValueByNumber(int number) {
                            return Effect.forNumber(number);
                        }
                    };

            public final com.google.protobuf.Descriptors.EnumValueDescriptor
            getValueDescriptor() {
                return getDescriptor().getValues().get(ordinal());
            }

            public final com.google.protobuf.Descriptors.EnumDescriptor
            getDescriptorForType() {
                return getDescriptor();
            }

            public static final com.google.protobuf.Descriptors.EnumDescriptor
            getDescriptor() {
                return GtfsRealtime.Alert.getDescriptor().getEnumTypes().get(1);
            }

            private static final Effect[] VALUES = values();

            public static Effect valueOf(
                    com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
                if (desc.getType() != getDescriptor()) {
                    throw new java.lang.IllegalArgumentException(
                            "EnumValueDescriptor is not for this type.");
                }
                return VALUES[desc.getIndex()];
            }

            private final int value;

            private Effect(int value) {
                this.value = value;
            }

            // @@protoc_insertion_point(enum_scope:transit_realtime.Alert.Effect)
        }

        private int bitField0_;
        public static final int ACTIVE_PERIOD_FIELD_NUMBER = 1;
        private java.util.List<GtfsRealtime.TimeRange> activePeriod_;

        /**
         * <pre>
         * Time when the alert should be shown to the user. If missing, the
         * alert will be shown as long as it appears in the feed.
         * If multiple ranges are given, the alert will be shown during all of them.
         * </pre>
         *
         * <code>repeated .transit_realtime.TimeRange active_period = 1;</code>
         */
        public java.util.List<GtfsRealtime.TimeRange> getActivePeriodList() {
            return activePeriod_;
        }

        /**
         * <pre>
         * Time when the alert should be shown to the user. If missing, the
         * alert will be shown as long as it appears in the feed.
         * If multiple ranges are given, the alert will be shown during all of them.
         * </pre>
         *
         * <code>repeated .transit_realtime.TimeRange active_period = 1;</code>
         */
        public java.util.List<? extends GtfsRealtime.TimeRangeOrBuilder>
        getActivePeriodOrBuilderList() {
            return activePeriod_;
        }

        /**
         * <pre>
         * Time when the alert should be shown to the user. If missing, the
         * alert will be shown as long as it appears in the feed.
         * If multiple ranges are given, the alert will be shown during all of them.
         * </pre>
         *
         * <code>repeated .transit_realtime.TimeRange active_period = 1;</code>
         */
        public int getActivePeriodCount() {
            return activePeriod_.size();
        }

        /**
         * <pre>
         * Time when the alert should be shown to the user. If missing, the
         * alert will be shown as long as it appears in the feed.
         * If multiple ranges are given, the alert will be shown during all of them.
         * </pre>
         *
         * <code>repeated .transit_realtime.TimeRange active_period = 1;</code>
         */
        public GtfsRealtime.TimeRange getActivePeriod(int index) {
            return activePeriod_.get(index);
        }

        /**
         * <pre>
         * Time when the alert should be shown to the user. If missing, the
         * alert will be shown as long as it appears in the feed.
         * If multiple ranges are given, the alert will be shown during all of them.
         * </pre>
         *
         * <code>repeated .transit_realtime.TimeRange active_period = 1;</code>
         */
        public GtfsRealtime.TimeRangeOrBuilder getActivePeriodOrBuilder(
                int index) {
            return activePeriod_.get(index);
        }

        public static final int INFORMED_ENTITY_FIELD_NUMBER = 5;
        private java.util.List<GtfsRealtime.EntitySelector> informedEntity_;

        /**
         * <pre>
         * Entities whose users we should notify of this alert.
         * </pre>
         *
         * <code>repeated .transit_realtime.EntitySelector informed_entity = 5;</code>
         */
        public java.util.List<GtfsRealtime.EntitySelector> getInformedEntityList() {
            return informedEntity_;
        }

        /**
         * <pre>
         * Entities whose users we should notify of this alert.
         * </pre>
         *
         * <code>repeated .transit_realtime.EntitySelector informed_entity = 5;</code>
         */
        public java.util.List<? extends GtfsRealtime.EntitySelectorOrBuilder>
        getInformedEntityOrBuilderList() {
            return informedEntity_;
        }

        /**
         * <pre>
         * Entities whose users we should notify of this alert.
         * </pre>
         *
         * <code>repeated .transit_realtime.EntitySelector informed_entity = 5;</code>
         */
        public int getInformedEntityCount() {
            return informedEntity_.size();
        }

        /**
         * <pre>
         * Entities whose users we should notify of this alert.
         * </pre>
         *
         * <code>repeated .transit_realtime.EntitySelector informed_entity = 5;</code>
         */
        public GtfsRealtime.EntitySelector getInformedEntity(int index) {
            return informedEntity_.get(index);
        }

        /**
         * <pre>
         * Entities whose users we should notify of this alert.
         * </pre>
         *
         * <code>repeated .transit_realtime.EntitySelector informed_entity = 5;</code>
         */
        public GtfsRealtime.EntitySelectorOrBuilder getInformedEntityOrBuilder(
                int index) {
            return informedEntity_.get(index);
        }

        public static final int CAUSE_FIELD_NUMBER = 6;
        private int cause_;

        /**
         * <code>optional .transit_realtime.Alert.Cause cause = 6 [default = UNKNOWN_CAUSE];</code>
         */
        public boolean hasCause() {
            return ((bitField0_ & 0x00000001) != 0);
        }

        /**
         * <code>optional .transit_realtime.Alert.Cause cause = 6 [default = UNKNOWN_CAUSE];</code>
         */
        public GtfsRealtime.Alert.Cause getCause() {
            @SuppressWarnings("deprecation")
            GtfsRealtime.Alert.Cause result = GtfsRealtime.Alert.Cause.valueOf(cause_);
            return result == null ? GtfsRealtime.Alert.Cause.UNKNOWN_CAUSE : result;
        }

        public static final int EFFECT_FIELD_NUMBER = 7;
        private int effect_;

        /**
         * <code>optional .transit_realtime.Alert.Effect effect = 7 [default = UNKNOWN_EFFECT];</code>
         */
        public boolean hasEffect() {
            return ((bitField0_ & 0x00000002) != 0);
        }

        /**
         * <code>optional .transit_realtime.Alert.Effect effect = 7 [default = UNKNOWN_EFFECT];</code>
         */
        public GtfsRealtime.Alert.Effect getEffect() {
            @SuppressWarnings("deprecation")
            GtfsRealtime.Alert.Effect result = GtfsRealtime.Alert.Effect.valueOf(effect_);
            return result == null ? GtfsRealtime.Alert.Effect.UNKNOWN_EFFECT : result;
        }

        public static final int URL_FIELD_NUMBER = 8;
        private GtfsRealtime.TranslatedString url_;

        /**
         * <pre>
         * The URL which provides additional information about the alert.
         * </pre>
         *
         * <code>optional .transit_realtime.TranslatedString url = 8;</code>
         */
        public boolean hasUrl() {
            return ((bitField0_ & 0x00000004) != 0);
        }

        /**
         * <pre>
         * The URL which provides additional information about the alert.
         * </pre>
         *
         * <code>optional .transit_realtime.TranslatedString url = 8;</code>
         */
        public GtfsRealtime.TranslatedString getUrl() {
            return url_ == null ? GtfsRealtime.TranslatedString.getDefaultInstance() : url_;
        }

        /**
         * <pre>
         * The URL which provides additional information about the alert.
         * </pre>
         *
         * <code>optional .transit_realtime.TranslatedString url = 8;</code>
         */
        public GtfsRealtime.TranslatedStringOrBuilder getUrlOrBuilder() {
            return url_ == null ? GtfsRealtime.TranslatedString.getDefaultInstance() : url_;
        }

        public static final int HEADER_TEXT_FIELD_NUMBER = 10;
        private GtfsRealtime.TranslatedString headerText_;

        /**
         * <pre>
         * Alert header. Contains a short summary of the alert text as plain-text.
         * </pre>
         *
         * <code>optional .transit_realtime.TranslatedString header_text = 10;</code>
         */
        public boolean hasHeaderText() {
            return ((bitField0_ & 0x00000008) != 0);
        }

        /**
         * <pre>
         * Alert header. Contains a short summary of the alert text as plain-text.
         * </pre>
         *
         * <code>optional .transit_realtime.TranslatedString header_text = 10;</code>
         */
        public GtfsRealtime.TranslatedString getHeaderText() {
            return headerText_ == null ? GtfsRealtime.TranslatedString.getDefaultInstance() : headerText_;
        }

        /**
         * <pre>
         * Alert header. Contains a short summary of the alert text as plain-text.
         * </pre>
         *
         * <code>optional .transit_realtime.TranslatedString header_text = 10;</code>
         */
        public GtfsRealtime.TranslatedStringOrBuilder getHeaderTextOrBuilder() {
            return headerText_ == null ? GtfsRealtime.TranslatedString.getDefaultInstance() : headerText_;
        }

        public static final int DESCRIPTION_TEXT_FIELD_NUMBER = 11;
        private GtfsRealtime.TranslatedString descriptionText_;

        /**
         * <pre>
         * Full description for the alert as plain-text. The information in the
         * description should add to the information of the header.
         * </pre>
         *
         * <code>optional .transit_realtime.TranslatedString description_text = 11;</code>
         */
        public boolean hasDescriptionText() {
            return ((bitField0_ & 0x00000010) != 0);
        }

        /**
         * <pre>
         * Full description for the alert as plain-text. The information in the
         * description should add to the information of the header.
         * </pre>
         *
         * <code>optional .transit_realtime.TranslatedString description_text = 11;</code>
         */
        public GtfsRealtime.TranslatedString getDescriptionText() {
            return descriptionText_ == null ? GtfsRealtime.TranslatedString.getDefaultInstance() : descriptionText_;
        }

        /**
         * <pre>
         * Full description for the alert as plain-text. The information in the
         * description should add to the information of the header.
         * </pre>
         *
         * <code>optional .transit_realtime.TranslatedString description_text = 11;</code>
         */
        public GtfsRealtime.TranslatedStringOrBuilder getDescriptionTextOrBuilder() {
            return descriptionText_ == null ? GtfsRealtime.TranslatedString.getDefaultInstance() : descriptionText_;
        }

        private byte memoizedIsInitialized = -1;

        @java.lang.Override
        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            for (int i = 0; i < getActivePeriodCount(); i++) {
                if (!getActivePeriod(i).isInitialized()) {
                    memoizedIsInitialized = 0;
                    return false;
                }
            }
            for (int i = 0; i < getInformedEntityCount(); i++) {
                if (!getInformedEntity(i).isInitialized()) {
                    memoizedIsInitialized = 0;
                    return false;
                }
            }
            if (hasUrl()) {
                if (!getUrl().isInitialized()) {
                    memoizedIsInitialized = 0;
                    return false;
                }
            }
            if (hasHeaderText()) {
                if (!getHeaderText().isInitialized()) {
                    memoizedIsInitialized = 0;
                    return false;
                }
            }
            if (hasDescriptionText()) {
                if (!getDescriptionText().isInitialized()) {
                    memoizedIsInitialized = 0;
                    return false;
                }
            }
            if (!extensionsAreInitialized()) {
                memoizedIsInitialized = 0;
                return false;
            }
            memoizedIsInitialized = 1;
            return true;
        }

        @java.lang.Override
        public void writeTo(com.google.protobuf.CodedOutputStream output)
                throws java.io.IOException {
            com.google.protobuf.GeneratedMessageV3
                    .ExtendableMessage<GtfsRealtime.Alert>.ExtensionWriter
                    extensionWriter = newExtensionWriter();
            for (int i = 0; i < activePeriod_.size(); i++) {
                output.writeMessage(1, activePeriod_.get(i));
            }
            for (int i = 0; i < informedEntity_.size(); i++) {
                output.writeMessage(5, informedEntity_.get(i));
            }
            if (((bitField0_ & 0x00000001) != 0)) {
                output.writeEnum(6, cause_);
            }
            if (((bitField0_ & 0x00000002) != 0)) {
                output.writeEnum(7, effect_);
            }
            if (((bitField0_ & 0x00000004) != 0)) {
                output.writeMessage(8, getUrl());
            }
            if (((bitField0_ & 0x00000008) != 0)) {
                output.writeMessage(10, getHeaderText());
            }
            if (((bitField0_ & 0x00000010) != 0)) {
                output.writeMessage(11, getDescriptionText());
            }
            extensionWriter.writeUntil(2000, output);
            unknownFields.writeTo(output);
        }

        @java.lang.Override
        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            for (int i = 0; i < activePeriod_.size(); i++) {
                size += com.google.protobuf.CodedOutputStream
                        .computeMessageSize(1, activePeriod_.get(i));
            }
            for (int i = 0; i < informedEntity_.size(); i++) {
                size += com.google.protobuf.CodedOutputStream
                        .computeMessageSize(5, informedEntity_.get(i));
            }
            if (((bitField0_ & 0x00000001) != 0)) {
                size += com.google.protobuf.CodedOutputStream
                        .computeEnumSize(6, cause_);
            }
            if (((bitField0_ & 0x00000002) != 0)) {
                size += com.google.protobuf.CodedOutputStream
                        .computeEnumSize(7, effect_);
            }
            if (((bitField0_ & 0x00000004) != 0)) {
                size += com.google.protobuf.CodedOutputStream
                        .computeMessageSize(8, getUrl());
            }
            if (((bitField0_ & 0x00000008) != 0)) {
                size += com.google.protobuf.CodedOutputStream
                        .computeMessageSize(10, getHeaderText());
            }
            if (((bitField0_ & 0x00000010) != 0)) {
                size += com.google.protobuf.CodedOutputStream
                        .computeMessageSize(11, getDescriptionText());
            }
            size += extensionsSerializedSize();
            size += unknownFields.getSerializedSize();
            memoizedSize = size;
            return size;
        }

        @java.lang.Override
        public boolean equals(final java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof GtfsRealtime.Alert)) {
                return super.equals(obj);
            }
            GtfsRealtime.Alert other = (GtfsRealtime.Alert) obj;

            if (!getActivePeriodList()
                    .equals(other.getActivePeriodList())) return false;
            if (!getInformedEntityList()
                    .equals(other.getInformedEntityList())) return false;
            if (hasCause() != other.hasCause()) return false;
            if (hasCause()) {
                if (cause_ != other.cause_) return false;
            }
            if (hasEffect() != other.hasEffect()) return false;
            if (hasEffect()) {
                if (effect_ != other.effect_) return false;
            }
            if (hasUrl() != other.hasUrl()) return false;
            if (hasUrl()) {
                if (!getUrl()
                        .equals(other.getUrl())) return false;
            }
            if (hasHeaderText() != other.hasHeaderText()) return false;
            if (hasHeaderText()) {
                if (!getHeaderText()
                        .equals(other.getHeaderText())) return false;
            }
            if (hasDescriptionText() != other.hasDescriptionText()) return false;
            if (hasDescriptionText()) {
                if (!getDescriptionText()
                        .equals(other.getDescriptionText())) return false;
            }
            if (!unknownFields.equals(other.unknownFields)) return false;
            if (!getExtensionFields().equals(other.getExtensionFields()))
                return false;
            return true;
        }

        @java.lang.Override
        public int hashCode() {
            if (memoizedHashCode != 0) {
                return memoizedHashCode;
            }
            int hash = 41;
            hash = (19 * hash) + getDescriptor().hashCode();
            if (getActivePeriodCount() > 0) {
                hash = (37 * hash) + ACTIVE_PERIOD_FIELD_NUMBER;
                hash = (53 * hash) + getActivePeriodList().hashCode();
            }
            if (getInformedEntityCount() > 0) {
                hash = (37 * hash) + INFORMED_ENTITY_FIELD_NUMBER;
                hash = (53 * hash) + getInformedEntityList().hashCode();
            }
            if (hasCause()) {
                hash = (37 * hash) + CAUSE_FIELD_NUMBER;
                hash = (53 * hash) + cause_;
            }
            if (hasEffect()) {
                hash = (37 * hash) + EFFECT_FIELD_NUMBER;
                hash = (53 * hash) + effect_;
            }
            if (hasUrl()) {
                hash = (37 * hash) + URL_FIELD_NUMBER;
                hash = (53 * hash) + getUrl().hashCode();
            }
            if (hasHeaderText()) {
                hash = (37 * hash) + HEADER_TEXT_FIELD_NUMBER;
                hash = (53 * hash) + getHeaderText().hashCode();
            }
            if (hasDescriptionText()) {
                hash = (37 * hash) + DESCRIPTION_TEXT_FIELD_NUMBER;
                hash = (53 * hash) + getDescriptionText().hashCode();
            }
            hash = hashFields(hash, getExtensionFields());
            hash = (29 * hash) + unknownFields.hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static GtfsRealtime.Alert parseFrom(
                java.nio.ByteBuffer data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GtfsRealtime.Alert parseFrom(
                java.nio.ByteBuffer data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GtfsRealtime.Alert parseFrom(
                com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GtfsRealtime.Alert parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GtfsRealtime.Alert parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GtfsRealtime.Alert parseFrom(
                byte[] data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GtfsRealtime.Alert parseFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }

        public static GtfsRealtime.Alert parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static GtfsRealtime.Alert parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input);
        }

        public static GtfsRealtime.Alert parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static GtfsRealtime.Alert parseFrom(
                com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }

        public static GtfsRealtime.Alert parseFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        @java.lang.Override
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GtfsRealtime.Alert prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }

        @java.lang.Override
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE
                    ? new Builder() : new Builder().mergeFrom(this);
        }

        @java.lang.Override
        protected Builder newBuilderForType(
                com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        /**
         * <pre>
         * An alert, indicating some sort of incident in the public transit network.
         * </pre>
         * <p>
         * Protobuf type {@code transit_realtime.Alert}
         */
        public static final class Builder extends
                com.google.protobuf.GeneratedMessageV3.ExtendableBuilder<
                        GtfsRealtime.Alert, Builder> implements
                // @@protoc_insertion_point(builder_implements:transit_realtime.Alert)
                GtfsRealtime.AlertOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
                return GtfsRealtime.internal_static_transit_realtime_Alert_descriptor;
            }

            @java.lang.Override
            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internalGetFieldAccessorTable() {
                return GtfsRealtime.internal_static_transit_realtime_Alert_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                GtfsRealtime.Alert.class, GtfsRealtime.Alert.Builder.class);
            }

            // Construct using GtfsRealtime.Alert.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(
                    com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.GeneratedMessageV3
                        .alwaysUseFieldBuilders) {
                    getActivePeriodFieldBuilder();
                    getInformedEntityFieldBuilder();
                    getUrlFieldBuilder();
                    getHeaderTextFieldBuilder();
                    getDescriptionTextFieldBuilder();
                }
            }

            @java.lang.Override
            public Builder clear() {
                super.clear();
                if (activePeriodBuilder_ == null) {
                    activePeriod_ = java.util.Collections.emptyList();
                    bitField0_ = (bitField0_ & ~0x00000001);
                } else {
                    activePeriodBuilder_.clear();
                }
                if (informedEntityBuilder_ == null) {
                    informedEntity_ = java.util.Collections.emptyList();
                    bitField0_ = (bitField0_ & ~0x00000002);
                } else {
                    informedEntityBuilder_.clear();
                }
                cause_ = 1;
                bitField0_ = (bitField0_ & ~0x00000004);
                effect_ = 8;
                bitField0_ = (bitField0_ & ~0x00000008);
                if (urlBuilder_ == null) {
                    url_ = null;
                } else {
                    urlBuilder_.clear();
                }
                bitField0_ = (bitField0_ & ~0x00000010);
                if (headerTextBuilder_ == null) {
                    headerText_ = null;
                } else {
                    headerTextBuilder_.clear();
                }
                bitField0_ = (bitField0_ & ~0x00000020);
                if (descriptionTextBuilder_ == null) {
                    descriptionText_ = null;
                } else {
                    descriptionTextBuilder_.clear();
                }
                bitField0_ = (bitField0_ & ~0x00000040);
                return this;
            }

            @java.lang.Override
            public com.google.protobuf.Descriptors.Descriptor
            getDescriptorForType() {
                return GtfsRealtime.internal_static_transit_realtime_Alert_descriptor;
            }

            @java.lang.Override
            public GtfsRealtime.Alert getDefaultInstanceForType() {
                return GtfsRealtime.Alert.getDefaultInstance();
            }

            @java.lang.Override
            public GtfsRealtime.Alert build() {
                GtfsRealtime.Alert result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            @java.lang.Override
            public GtfsRealtime.Alert buildPartial() {
                GtfsRealtime.Alert result = new GtfsRealtime.Alert(this);
                int from_bitField0_ = bitField0_;
                int to_bitField0_ = 0;
                if (activePeriodBuilder_ == null) {
                    if (((bitField0_ & 0x00000001) != 0)) {
                        activePeriod_ = java.util.Collections.unmodifiableList(activePeriod_);
                        bitField0_ = (bitField0_ & ~0x00000001);
                    }
                    result.activePeriod_ = activePeriod_;
                } else {
                    result.activePeriod_ = activePeriodBuilder_.build();
                }
                if (informedEntityBuilder_ == null) {
                    if (((bitField0_ & 0x00000002) != 0)) {
                        informedEntity_ = java.util.Collections.unmodifiableList(informedEntity_);
                        bitField0_ = (bitField0_ & ~0x00000002);
                    }
                    result.informedEntity_ = informedEntity_;
                } else {
                    result.informedEntity_ = informedEntityBuilder_.build();
                }
                if (((from_bitField0_ & 0x00000004) != 0)) {
                    to_bitField0_ |= 0x00000001;
                }
                result.cause_ = cause_;
                if (((from_bitField0_ & 0x00000008) != 0)) {
                    to_bitField0_ |= 0x00000002;
                }
                result.effect_ = effect_;
                if (((from_bitField0_ & 0x00000010) != 0)) {
                    if (urlBuilder_ == null) {
                        result.url_ = url_;
                    } else {
                        result.url_ = urlBuilder_.build();
                    }
                    to_bitField0_ |= 0x00000004;
                }
                if (((from_bitField0_ & 0x00000020) != 0)) {
                    if (headerTextBuilder_ == null) {
                        result.headerText_ = headerText_;
                    } else {
                        result.headerText_ = headerTextBuilder_.build();
                    }
                    to_bitField0_ |= 0x00000008;
                }
                if (((from_bitField0_ & 0x00000040) != 0)) {
                    if (descriptionTextBuilder_ == null) {
                        result.descriptionText_ = descriptionText_;
                    } else {
                        result.descriptionText_ = descriptionTextBuilder_.build();
                    }
                    to_bitField0_ |= 0x00000010;
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            @java.lang.Override
            public Builder clone() {
                return super.clone();
            }

            @java.lang.Override
            public Builder setField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return super.setField(field, value);
            }

            @java.lang.Override
            public Builder clearField(
                    com.google.protobuf.Descriptors.FieldDescriptor field) {
                return super.clearField(field);
            }

            @java.lang.Override
            public Builder clearOneof(
                    com.google.protobuf.Descriptors.OneofDescriptor oneof) {
                return super.clearOneof(oneof);
            }

            @java.lang.Override
            public Builder setRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    int index, java.lang.Object value) {
                return super.setRepeatedField(field, index, value);
            }

            @java.lang.Override
            public Builder addRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return super.addRepeatedField(field, value);
            }

            @java.lang.Override
            public <Type> Builder setExtension(
                    com.google.protobuf.GeneratedMessage.GeneratedExtension<
                            GtfsRealtime.Alert, Type> extension,
                    Type value) {
                return super.setExtension(extension, value);
            }

            @java.lang.Override
            public <Type> Builder setExtension(
                    com.google.protobuf.GeneratedMessage.GeneratedExtension<
                            GtfsRealtime.Alert, java.util.List<Type>> extension,
                    int index, Type value) {
                return super.setExtension(extension, index, value);
            }

            @java.lang.Override
            public <Type> Builder addExtension(
                    com.google.protobuf.GeneratedMessage.GeneratedExtension<
                            GtfsRealtime.Alert, java.util.List<Type>> extension,
                    Type value) {
                return super.addExtension(extension, value);
            }

            @java.lang.Override
            public <Type> Builder clearExtension(
                    com.google.protobuf.GeneratedMessage.GeneratedExtension<
                            GtfsRealtime.Alert, ?> extension) {
                return super.clearExtension(extension);
            }

            @java.lang.Override
            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof GtfsRealtime.Alert) {
                    return mergeFrom((GtfsRealtime.Alert) other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(GtfsRealtime.Alert other) {
                if (other == GtfsRealtime.Alert.getDefaultInstance()) return this;
                if (activePeriodBuilder_ == null) {
                    if (!other.activePeriod_.isEmpty()) {
                        if (activePeriod_.isEmpty()) {
                            activePeriod_ = other.activePeriod_;
                            bitField0_ = (bitField0_ & ~0x00000001);
                        } else {
                            ensureActivePeriodIsMutable();
                            activePeriod_.addAll(other.activePeriod_);
                        }
                        onChanged();
                    }
                } else {
                    if (!other.activePeriod_.isEmpty()) {
                        if (activePeriodBuilder_.isEmpty()) {
                            activePeriodBuilder_.dispose();
                            activePeriodBuilder_ = null;
                            activePeriod_ = other.activePeriod_;
                            bitField0_ = (bitField0_ & ~0x00000001);
                            activePeriodBuilder_ =
                                    com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                                            getActivePeriodFieldBuilder() : null;
                        } else {
                            activePeriodBuilder_.addAllMessages(other.activePeriod_);
                        }
                    }
                }
                if (informedEntityBuilder_ == null) {
                    if (!other.informedEntity_.isEmpty()) {
                        if (informedEntity_.isEmpty()) {
                            informedEntity_ = other.informedEntity_;
                            bitField0_ = (bitField0_ & ~0x00000002);
                        } else {
                            ensureInformedEntityIsMutable();
                            informedEntity_.addAll(other.informedEntity_);
                        }
                        onChanged();
                    }
                } else {
                    if (!other.informedEntity_.isEmpty()) {
                        if (informedEntityBuilder_.isEmpty()) {
                            informedEntityBuilder_.dispose();
                            informedEntityBuilder_ = null;
                            informedEntity_ = other.informedEntity_;
                            bitField0_ = (bitField0_ & ~0x00000002);
                            informedEntityBuilder_ =
                                    com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                                            getInformedEntityFieldBuilder() : null;
                        } else {
                            informedEntityBuilder_.addAllMessages(other.informedEntity_);
                        }
                    }
                }
                if (other.hasCause()) {
                    setCause(other.getCause());
                }
                if (other.hasEffect()) {
                    setEffect(other.getEffect());
                }
                if (other.hasUrl()) {
                    mergeUrl(other.getUrl());
                }
                if (other.hasHeaderText()) {
                    mergeHeaderText(other.getHeaderText());
                }
                if (other.hasDescriptionText()) {
                    mergeDescriptionText(other.getDescriptionText());
                }
                this.mergeExtensionFields(other);
                this.mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            @java.lang.Override
            public final boolean isInitialized() {
                for (int i = 0; i < getActivePeriodCount(); i++) {
                    if (!getActivePeriod(i).isInitialized()) {
                        return false;
                    }
                }
                for (int i = 0; i < getInformedEntityCount(); i++) {
                    if (!getInformedEntity(i).isInitialized()) {
                        return false;
                    }
                }
                if (hasUrl()) {
                    if (!getUrl().isInitialized()) {
                        return false;
                    }
                }
                if (hasHeaderText()) {
                    if (!getHeaderText().isInitialized()) {
                        return false;
                    }
                }
                if (hasDescriptionText()) {
                    if (!getDescriptionText().isInitialized()) {
                        return false;
                    }
                }
                if (!extensionsAreInitialized()) {
                    return false;
                }
                return true;
            }

            @java.lang.Override
            public Builder mergeFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                GtfsRealtime.Alert parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (GtfsRealtime.Alert) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private int bitField0_;

            private java.util.List<GtfsRealtime.TimeRange> activePeriod_ =
                    java.util.Collections.emptyList();

            private void ensureActivePeriodIsMutable() {
                if (!((bitField0_ & 0x00000001) != 0)) {
                    activePeriod_ = new java.util.ArrayList<GtfsRealtime.TimeRange>(activePeriod_);
                    bitField0_ |= 0x00000001;
                }
            }

            private com.google.protobuf.RepeatedFieldBuilderV3<
                    GtfsRealtime.TimeRange, GtfsRealtime.TimeRange.Builder, GtfsRealtime.TimeRangeOrBuilder> activePeriodBuilder_;

            /**
             * <pre>
             * Time when the alert should be shown to the user. If missing, the
             * alert will be shown as long as it appears in the feed.
             * If multiple ranges are given, the alert will be shown during all of them.
             * </pre>
             *
             * <code>repeated .transit_realtime.TimeRange active_period = 1;</code>
             */
            public java.util.List<GtfsRealtime.TimeRange> getActivePeriodList() {
                if (activePeriodBuilder_ == null) {
                    return java.util.Collections.unmodifiableList(activePeriod_);
                } else {
                    return activePeriodBuilder_.getMessageList();
                }
            }

            /**
             * <pre>
             * Time when the alert should be shown to the user. If missing, the
             * alert will be shown as long as it appears in the feed.
             * If multiple ranges are given, the alert will be shown during all of them.
             * </pre>
             *
             * <code>repeated .transit_realtime.TimeRange active_period = 1;</code>
             */
            public int getActivePeriodCount() {
                if (activePeriodBuilder_ == null) {
                    return activePeriod_.size();
                } else {
                    return activePeriodBuilder_.getCount();
                }
            }

            /**
             * <pre>
             * Time when the alert should be shown to the user. If missing, the
             * alert will be shown as long as it appears in the feed.
             * If multiple ranges are given, the alert will be shown during all of them.
             * </pre>
             *
             * <code>repeated .transit_realtime.TimeRange active_period = 1;</code>
             */
            public GtfsRealtime.TimeRange getActivePeriod(int index) {
                if (activePeriodBuilder_ == null) {
                    return activePeriod_.get(index);
                } else {
                    return activePeriodBuilder_.getMessage(index);
                }
            }

            /**
             * <pre>
             * Time when the alert should be shown to the user. If missing, the
             * alert will be shown as long as it appears in the feed.
             * If multiple ranges are given, the alert will be shown during all of them.
             * </pre>
             *
             * <code>repeated .transit_realtime.TimeRange active_period = 1;</code>
             */
            public Builder setActivePeriod(
                    int index, GtfsRealtime.TimeRange value) {
                if (activePeriodBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureActivePeriodIsMutable();
                    activePeriod_.set(index, value);
                    onChanged();
                } else {
                    activePeriodBuilder_.setMessage(index, value);
                }
                return this;
            }

            /**
             * <pre>
             * Time when the alert should be shown to the user. If missing, the
             * alert will be shown as long as it appears in the feed.
             * If multiple ranges are given, the alert will be shown during all of them.
             * </pre>
             *
             * <code>repeated .transit_realtime.TimeRange active_period = 1;</code>
             */
            public Builder setActivePeriod(
                    int index, GtfsRealtime.TimeRange.Builder builderForValue) {
                if (activePeriodBuilder_ == null) {
                    ensureActivePeriodIsMutable();
                    activePeriod_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    activePeriodBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            /**
             * <pre>
             * Time when the alert should be shown to the user. If missing, the
             * alert will be shown as long as it appears in the feed.
             * If multiple ranges are given, the alert will be shown during all of them.
             * </pre>
             *
             * <code>repeated .transit_realtime.TimeRange active_period = 1;</code>
             */
            public Builder addActivePeriod(GtfsRealtime.TimeRange value) {
                if (activePeriodBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureActivePeriodIsMutable();
                    activePeriod_.add(value);
                    onChanged();
                } else {
                    activePeriodBuilder_.addMessage(value);
                }
                return this;
            }

            /**
             * <pre>
             * Time when the alert should be shown to the user. If missing, the
             * alert will be shown as long as it appears in the feed.
             * If multiple ranges are given, the alert will be shown during all of them.
             * </pre>
             *
             * <code>repeated .transit_realtime.TimeRange active_period = 1;</code>
             */
            public Builder addActivePeriod(
                    int index, GtfsRealtime.TimeRange value) {
                if (activePeriodBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureActivePeriodIsMutable();
                    activePeriod_.add(index, value);
                    onChanged();
                } else {
                    activePeriodBuilder_.addMessage(index, value);
                }
                return this;
            }

            /**
             * <pre>
             * Time when the alert should be shown to the user. If missing, the
             * alert will be shown as long as it appears in the feed.
             * If multiple ranges are given, the alert will be shown during all of them.
             * </pre>
             *
             * <code>repeated .transit_realtime.TimeRange active_period = 1;</code>
             */
            public Builder addActivePeriod(
                    GtfsRealtime.TimeRange.Builder builderForValue) {
                if (activePeriodBuilder_ == null) {
                    ensureActivePeriodIsMutable();
                    activePeriod_.add(builderForValue.build());
                    onChanged();
                } else {
                    activePeriodBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            /**
             * <pre>
             * Time when the alert should be shown to the user. If missing, the
             * alert will be shown as long as it appears in the feed.
             * If multiple ranges are given, the alert will be shown during all of them.
             * </pre>
             *
             * <code>repeated .transit_realtime.TimeRange active_period = 1;</code>
             */
            public Builder addActivePeriod(
                    int index, GtfsRealtime.TimeRange.Builder builderForValue) {
                if (activePeriodBuilder_ == null) {
                    ensureActivePeriodIsMutable();
                    activePeriod_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    activePeriodBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            /**
             * <pre>
             * Time when the alert should be shown to the user. If missing, the
             * alert will be shown as long as it appears in the feed.
             * If multiple ranges are given, the alert will be shown during all of them.
             * </pre>
             *
             * <code>repeated .transit_realtime.TimeRange active_period = 1;</code>
             */
            public Builder addAllActivePeriod(
                    java.lang.Iterable<? extends GtfsRealtime.TimeRange> values) {
                if (activePeriodBuilder_ == null) {
                    ensureActivePeriodIsMutable();
                    com.google.protobuf.AbstractMessageLite.Builder.addAll(
                            values, activePeriod_);
                    onChanged();
                } else {
                    activePeriodBuilder_.addAllMessages(values);
                }
                return this;
            }

            /**
             * <pre>
             * Time when the alert should be shown to the user. If missing, the
             * alert will be shown as long as it appears in the feed.
             * If multiple ranges are given, the alert will be shown during all of them.
             * </pre>
             *
             * <code>repeated .transit_realtime.TimeRange active_period = 1;</code>
             */
            public Builder clearActivePeriod() {
                if (activePeriodBuilder_ == null) {
                    activePeriod_ = java.util.Collections.emptyList();
                    bitField0_ = (bitField0_ & ~0x00000001);
                    onChanged();
                } else {
                    activePeriodBuilder_.clear();
                }
                return this;
            }

            /**
             * <pre>
             * Time when the alert should be shown to the user. If missing, the
             * alert will be shown as long as it appears in the feed.
             * If multiple ranges are given, the alert will be shown during all of them.
             * </pre>
             *
             * <code>repeated .transit_realtime.TimeRange active_period = 1;</code>
             */
            public Builder removeActivePeriod(int index) {
                if (activePeriodBuilder_ == null) {
                    ensureActivePeriodIsMutable();
                    activePeriod_.remove(index);
                    onChanged();
                } else {
                    activePeriodBuilder_.remove(index);
                }
                return this;
            }

            /**
             * <pre>
             * Time when the alert should be shown to the user. If missing, the
             * alert will be shown as long as it appears in the feed.
             * If multiple ranges are given, the alert will be shown during all of them.
             * </pre>
             *
             * <code>repeated .transit_realtime.TimeRange active_period = 1;</code>
             */
            public GtfsRealtime.TimeRange.Builder getActivePeriodBuilder(
                    int index) {
                return getActivePeriodFieldBuilder().getBuilder(index);
            }

            /**
             * <pre>
             * Time when the alert should be shown to the user. If missing, the
             * alert will be shown as long as it appears in the feed.
             * If multiple ranges are given, the alert will be shown during all of them.
             * </pre>
             *
             * <code>repeated .transit_realtime.TimeRange active_period = 1;</code>
             */
            public GtfsRealtime.TimeRangeOrBuilder getActivePeriodOrBuilder(
                    int index) {
                if (activePeriodBuilder_ == null) {
                    return activePeriod_.get(index);
                } else {
                    return activePeriodBuilder_.getMessageOrBuilder(index);
                }
            }

            /**
             * <pre>
             * Time when the alert should be shown to the user. If missing, the
             * alert will be shown as long as it appears in the feed.
             * If multiple ranges are given, the alert will be shown during all of them.
             * </pre>
             *
             * <code>repeated .transit_realtime.TimeRange active_period = 1;</code>
             */
            public java.util.List<? extends GtfsRealtime.TimeRangeOrBuilder>
            getActivePeriodOrBuilderList() {
                if (activePeriodBuilder_ != null) {
                    return activePeriodBuilder_.getMessageOrBuilderList();
                } else {
                    return java.util.Collections.unmodifiableList(activePeriod_);
                }
            }

            /**
             * <pre>
             * Time when the alert should be shown to the user. If missing, the
             * alert will be shown as long as it appears in the feed.
             * If multiple ranges are given, the alert will be shown during all of them.
             * </pre>
             *
             * <code>repeated .transit_realtime.TimeRange active_period = 1;</code>
             */
            public GtfsRealtime.TimeRange.Builder addActivePeriodBuilder() {
                return getActivePeriodFieldBuilder().addBuilder(
                        GtfsRealtime.TimeRange.getDefaultInstance());
            }

            /**
             * <pre>
             * Time when the alert should be shown to the user. If missing, the
             * alert will be shown as long as it appears in the feed.
             * If multiple ranges are given, the alert will be shown during all of them.
             * </pre>
             *
             * <code>repeated .transit_realtime.TimeRange active_period = 1;</code>
             */
            public GtfsRealtime.TimeRange.Builder addActivePeriodBuilder(
                    int index) {
                return getActivePeriodFieldBuilder().addBuilder(
                        index, GtfsRealtime.TimeRange.getDefaultInstance());
            }

            /**
             * <pre>
             * Time when the alert should be shown to the user. If missing, the
             * alert will be shown as long as it appears in the feed.
             * If multiple ranges are given, the alert will be shown during all of them.
             * </pre>
             *
             * <code>repeated .transit_realtime.TimeRange active_period = 1;</code>
             */
            public java.util.List<GtfsRealtime.TimeRange.Builder>
            getActivePeriodBuilderList() {
                return getActivePeriodFieldBuilder().getBuilderList();
            }

            private com.google.protobuf.RepeatedFieldBuilderV3<
                    GtfsRealtime.TimeRange, GtfsRealtime.TimeRange.Builder, GtfsRealtime.TimeRangeOrBuilder>
            getActivePeriodFieldBuilder() {
                if (activePeriodBuilder_ == null) {
                    activePeriodBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
                            GtfsRealtime.TimeRange, GtfsRealtime.TimeRange.Builder, GtfsRealtime.TimeRangeOrBuilder>(
                            activePeriod_,
                            ((bitField0_ & 0x00000001) != 0),
                            getParentForChildren(),
                            isClean());
                    activePeriod_ = null;
                }
                return activePeriodBuilder_;
            }

            private java.util.List<GtfsRealtime.EntitySelector> informedEntity_ =
                    java.util.Collections.emptyList();

            private void ensureInformedEntityIsMutable() {
                if (!((bitField0_ & 0x00000002) != 0)) {
                    informedEntity_ = new java.util.ArrayList<GtfsRealtime.EntitySelector>(informedEntity_);
                    bitField0_ |= 0x00000002;
                }
            }

            private com.google.protobuf.RepeatedFieldBuilderV3<
                    GtfsRealtime.EntitySelector, GtfsRealtime.EntitySelector.Builder, GtfsRealtime.EntitySelectorOrBuilder> informedEntityBuilder_;

            /**
             * <pre>
             * Entities whose users we should notify of this alert.
             * </pre>
             *
             * <code>repeated .transit_realtime.EntitySelector informed_entity = 5;</code>
             */
            public java.util.List<GtfsRealtime.EntitySelector> getInformedEntityList() {
                if (informedEntityBuilder_ == null) {
                    return java.util.Collections.unmodifiableList(informedEntity_);
                } else {
                    return informedEntityBuilder_.getMessageList();
                }
            }

            /**
             * <pre>
             * Entities whose users we should notify of this alert.
             * </pre>
             *
             * <code>repeated .transit_realtime.EntitySelector informed_entity = 5;</code>
             */
            public int getInformedEntityCount() {
                if (informedEntityBuilder_ == null) {
                    return informedEntity_.size();
                } else {
                    return informedEntityBuilder_.getCount();
                }
            }

            /**
             * <pre>
             * Entities whose users we should notify of this alert.
             * </pre>
             *
             * <code>repeated .transit_realtime.EntitySelector informed_entity = 5;</code>
             */
            public GtfsRealtime.EntitySelector getInformedEntity(int index) {
                if (informedEntityBuilder_ == null) {
                    return informedEntity_.get(index);
                } else {
                    return informedEntityBuilder_.getMessage(index);
                }
            }

            /**
             * <pre>
             * Entities whose users we should notify of this alert.
             * </pre>
             *
             * <code>repeated .transit_realtime.EntitySelector informed_entity = 5;</code>
             */
            public Builder setInformedEntity(
                    int index, GtfsRealtime.EntitySelector value) {
                if (informedEntityBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureInformedEntityIsMutable();
                    informedEntity_.set(index, value);
                    onChanged();
                } else {
                    informedEntityBuilder_.setMessage(index, value);
                }
                return this;
            }

            /**
             * <pre>
             * Entities whose users we should notify of this alert.
             * </pre>
             *
             * <code>repeated .transit_realtime.EntitySelector informed_entity = 5;</code>
             */
            public Builder setInformedEntity(
                    int index, GtfsRealtime.EntitySelector.Builder builderForValue) {
                if (informedEntityBuilder_ == null) {
                    ensureInformedEntityIsMutable();
                    informedEntity_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    informedEntityBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            /**
             * <pre>
             * Entities whose users we should notify of this alert.
             * </pre>
             *
             * <code>repeated .transit_realtime.EntitySelector informed_entity = 5;</code>
             */
            public Builder addInformedEntity(GtfsRealtime.EntitySelector value) {
                if (informedEntityBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureInformedEntityIsMutable();
                    informedEntity_.add(value);
                    onChanged();
                } else {
                    informedEntityBuilder_.addMessage(value);
                }
                return this;
            }

            /**
             * <pre>
             * Entities whose users we should notify of this alert.
             * </pre>
             *
             * <code>repeated .transit_realtime.EntitySelector informed_entity = 5;</code>
             */
            public Builder addInformedEntity(
                    int index, GtfsRealtime.EntitySelector value) {
                if (informedEntityBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureInformedEntityIsMutable();
                    informedEntity_.add(index, value);
                    onChanged();
                } else {
                    informedEntityBuilder_.addMessage(index, value);
                }
                return this;
            }

            /**
             * <pre>
             * Entities whose users we should notify of this alert.
             * </pre>
             *
             * <code>repeated .transit_realtime.EntitySelector informed_entity = 5;</code>
             */
            public Builder addInformedEntity(
                    GtfsRealtime.EntitySelector.Builder builderForValue) {
                if (informedEntityBuilder_ == null) {
                    ensureInformedEntityIsMutable();
                    informedEntity_.add(builderForValue.build());
                    onChanged();
                } else {
                    informedEntityBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            /**
             * <pre>
             * Entities whose users we should notify of this alert.
             * </pre>
             *
             * <code>repeated .transit_realtime.EntitySelector informed_entity = 5;</code>
             */
            public Builder addInformedEntity(
                    int index, GtfsRealtime.EntitySelector.Builder builderForValue) {
                if (informedEntityBuilder_ == null) {
                    ensureInformedEntityIsMutable();
                    informedEntity_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    informedEntityBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            /**
             * <pre>
             * Entities whose users we should notify of this alert.
             * </pre>
             *
             * <code>repeated .transit_realtime.EntitySelector informed_entity = 5;</code>
             */
            public Builder addAllInformedEntity(
                    java.lang.Iterable<? extends GtfsRealtime.EntitySelector> values) {
                if (informedEntityBuilder_ == null) {
                    ensureInformedEntityIsMutable();
                    com.google.protobuf.AbstractMessageLite.Builder.addAll(
                            values, informedEntity_);
                    onChanged();
                } else {
                    informedEntityBuilder_.addAllMessages(values);
                }
                return this;
            }

            /**
             * <pre>
             * Entities whose users we should notify of this alert.
             * </pre>
             *
             * <code>repeated .transit_realtime.EntitySelector informed_entity = 5;</code>
             */
            public Builder clearInformedEntity() {
                if (informedEntityBuilder_ == null) {
                    informedEntity_ = java.util.Collections.emptyList();
                    bitField0_ = (bitField0_ & ~0x00000002);
                    onChanged();
                } else {
                    informedEntityBuilder_.clear();
                }
                return this;
            }

            /**
             * <pre>
             * Entities whose users we should notify of this alert.
             * </pre>
             *
             * <code>repeated .transit_realtime.EntitySelector informed_entity = 5;</code>
             */
            public Builder removeInformedEntity(int index) {
                if (informedEntityBuilder_ == null) {
                    ensureInformedEntityIsMutable();
                    informedEntity_.remove(index);
                    onChanged();
                } else {
                    informedEntityBuilder_.remove(index);
                }
                return this;
            }

            /**
             * <pre>
             * Entities whose users we should notify of this alert.
             * </pre>
             *
             * <code>repeated .transit_realtime.EntitySelector informed_entity = 5;</code>
             */
            public GtfsRealtime.EntitySelector.Builder getInformedEntityBuilder(
                    int index) {
                return getInformedEntityFieldBuilder().getBuilder(index);
            }

            /**
             * <pre>
             * Entities whose users we should notify of this alert.
             * </pre>
             *
             * <code>repeated .transit_realtime.EntitySelector informed_entity = 5;</code>
             */
            public GtfsRealtime.EntitySelectorOrBuilder getInformedEntityOrBuilder(
                    int index) {
                if (informedEntityBuilder_ == null) {
                    return informedEntity_.get(index);
                } else {
                    return informedEntityBuilder_.getMessageOrBuilder(index);
                }
            }

            /**
             * <pre>
             * Entities whose users we should notify of this alert.
             * </pre>
             *
             * <code>repeated .transit_realtime.EntitySelector informed_entity = 5;</code>
             */
            public java.util.List<? extends GtfsRealtime.EntitySelectorOrBuilder>
            getInformedEntityOrBuilderList() {
                if (informedEntityBuilder_ != null) {
                    return informedEntityBuilder_.getMessageOrBuilderList();
                } else {
                    return java.util.Collections.unmodifiableList(informedEntity_);
                }
            }

            /**
             * <pre>
             * Entities whose users we should notify of this alert.
             * </pre>
             *
             * <code>repeated .transit_realtime.EntitySelector informed_entity = 5;</code>
             */
            public GtfsRealtime.EntitySelector.Builder addInformedEntityBuilder() {
                return getInformedEntityFieldBuilder().addBuilder(
                        GtfsRealtime.EntitySelector.getDefaultInstance());
            }

            /**
             * <pre>
             * Entities whose users we should notify of this alert.
             * </pre>
             *
             * <code>repeated .transit_realtime.EntitySelector informed_entity = 5;</code>
             */
            public GtfsRealtime.EntitySelector.Builder addInformedEntityBuilder(
                    int index) {
                return getInformedEntityFieldBuilder().addBuilder(
                        index, GtfsRealtime.EntitySelector.getDefaultInstance());
            }

            /**
             * <pre>
             * Entities whose users we should notify of this alert.
             * </pre>
             *
             * <code>repeated .transit_realtime.EntitySelector informed_entity = 5;</code>
             */
            public java.util.List<GtfsRealtime.EntitySelector.Builder>
            getInformedEntityBuilderList() {
                return getInformedEntityFieldBuilder().getBuilderList();
            }

            private com.google.protobuf.RepeatedFieldBuilderV3<
                    GtfsRealtime.EntitySelector, GtfsRealtime.EntitySelector.Builder, GtfsRealtime.EntitySelectorOrBuilder>
            getInformedEntityFieldBuilder() {
                if (informedEntityBuilder_ == null) {
                    informedEntityBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
                            GtfsRealtime.EntitySelector, GtfsRealtime.EntitySelector.Builder, GtfsRealtime.EntitySelectorOrBuilder>(
                            informedEntity_,
                            ((bitField0_ & 0x00000002) != 0),
                            getParentForChildren(),
                            isClean());
                    informedEntity_ = null;
                }
                return informedEntityBuilder_;
            }

            private int cause_ = 1;

            /**
             * <code>optional .transit_realtime.Alert.Cause cause = 6 [default = UNKNOWN_CAUSE];</code>
             */
            public boolean hasCause() {
                return ((bitField0_ & 0x00000004) != 0);
            }

            /**
             * <code>optional .transit_realtime.Alert.Cause cause = 6 [default = UNKNOWN_CAUSE];</code>
             */
            public GtfsRealtime.Alert.Cause getCause() {
                @SuppressWarnings("deprecation")
                GtfsRealtime.Alert.Cause result = GtfsRealtime.Alert.Cause.valueOf(cause_);
                return result == null ? GtfsRealtime.Alert.Cause.UNKNOWN_CAUSE : result;
            }

            /**
             * <code>optional .transit_realtime.Alert.Cause cause = 6 [default = UNKNOWN_CAUSE];</code>
             */
            public Builder setCause(GtfsRealtime.Alert.Cause value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000004;
                cause_ = value.getNumber();
                onChanged();
                return this;
            }

            /**
             * <code>optional .transit_realtime.Alert.Cause cause = 6 [default = UNKNOWN_CAUSE];</code>
             */
            public Builder clearCause() {
                bitField0_ = (bitField0_ & ~0x00000004);
                cause_ = 1;
                onChanged();
                return this;
            }

            private int effect_ = 8;

            /**
             * <code>optional .transit_realtime.Alert.Effect effect = 7 [default = UNKNOWN_EFFECT];</code>
             */
            public boolean hasEffect() {
                return ((bitField0_ & 0x00000008) != 0);
            }

            /**
             * <code>optional .transit_realtime.Alert.Effect effect = 7 [default = UNKNOWN_EFFECT];</code>
             */
            public GtfsRealtime.Alert.Effect getEffect() {
                @SuppressWarnings("deprecation")
                GtfsRealtime.Alert.Effect result = GtfsRealtime.Alert.Effect.valueOf(effect_);
                return result == null ? GtfsRealtime.Alert.Effect.UNKNOWN_EFFECT : result;
            }

            /**
             * <code>optional .transit_realtime.Alert.Effect effect = 7 [default = UNKNOWN_EFFECT];</code>
             */
            public Builder setEffect(GtfsRealtime.Alert.Effect value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000008;
                effect_ = value.getNumber();
                onChanged();
                return this;
            }

            /**
             * <code>optional .transit_realtime.Alert.Effect effect = 7 [default = UNKNOWN_EFFECT];</code>
             */
            public Builder clearEffect() {
                bitField0_ = (bitField0_ & ~0x00000008);
                effect_ = 8;
                onChanged();
                return this;
            }

            private GtfsRealtime.TranslatedString url_;
            private com.google.protobuf.SingleFieldBuilderV3<
                    GtfsRealtime.TranslatedString, GtfsRealtime.TranslatedString.Builder, GtfsRealtime.TranslatedStringOrBuilder> urlBuilder_;

            /**
             * <pre>
             * The URL which provides additional information about the alert.
             * </pre>
             *
             * <code>optional .transit_realtime.TranslatedString url = 8;</code>
             */
            public boolean hasUrl() {
                return ((bitField0_ & 0x00000010) != 0);
            }

            /**
             * <pre>
             * The URL which provides additional information about the alert.
             * </pre>
             *
             * <code>optional .transit_realtime.TranslatedString url = 8;</code>
             */
            public GtfsRealtime.TranslatedString getUrl() {
                if (urlBuilder_ == null) {
                    return url_ == null ? GtfsRealtime.TranslatedString.getDefaultInstance() : url_;
                } else {
                    return urlBuilder_.getMessage();
                }
            }

            /**
             * <pre>
             * The URL which provides additional information about the alert.
             * </pre>
             *
             * <code>optional .transit_realtime.TranslatedString url = 8;</code>
             */
            public Builder setUrl(GtfsRealtime.TranslatedString value) {
                if (urlBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    url_ = value;
                    onChanged();
                } else {
                    urlBuilder_.setMessage(value);
                }
                bitField0_ |= 0x00000010;
                return this;
            }

            /**
             * <pre>
             * The URL which provides additional information about the alert.
             * </pre>
             *
             * <code>optional .transit_realtime.TranslatedString url = 8;</code>
             */
            public Builder setUrl(
                    GtfsRealtime.TranslatedString.Builder builderForValue) {
                if (urlBuilder_ == null) {
                    url_ = builderForValue.build();
                    onChanged();
                } else {
                    urlBuilder_.setMessage(builderForValue.build());
                }
                bitField0_ |= 0x00000010;
                return this;
            }

            /**
             * <pre>
             * The URL which provides additional information about the alert.
             * </pre>
             *
             * <code>optional .transit_realtime.TranslatedString url = 8;</code>
             */
            public Builder mergeUrl(GtfsRealtime.TranslatedString value) {
                if (urlBuilder_ == null) {
                    if (((bitField0_ & 0x00000010) != 0) &&
                            url_ != null &&
                            url_ != GtfsRealtime.TranslatedString.getDefaultInstance()) {
                        url_ =
                                GtfsRealtime.TranslatedString.newBuilder(url_).mergeFrom(value).buildPartial();
                    } else {
                        url_ = value;
                    }
                    onChanged();
                } else {
                    urlBuilder_.mergeFrom(value);
                }
                bitField0_ |= 0x00000010;
                return this;
            }

            /**
             * <pre>
             * The URL which provides additional information about the alert.
             * </pre>
             *
             * <code>optional .transit_realtime.TranslatedString url = 8;</code>
             */
            public Builder clearUrl() {
                if (urlBuilder_ == null) {
                    url_ = null;
                    onChanged();
                } else {
                    urlBuilder_.clear();
                }
                bitField0_ = (bitField0_ & ~0x00000010);
                return this;
            }

            /**
             * <pre>
             * The URL which provides additional information about the alert.
             * </pre>
             *
             * <code>optional .transit_realtime.TranslatedString url = 8;</code>
             */
            public GtfsRealtime.TranslatedString.Builder getUrlBuilder() {
                bitField0_ |= 0x00000010;
                onChanged();
                return getUrlFieldBuilder().getBuilder();
            }

            /**
             * <pre>
             * The URL which provides additional information about the alert.
             * </pre>
             *
             * <code>optional .transit_realtime.TranslatedString url = 8;</code>
             */
            public GtfsRealtime.TranslatedStringOrBuilder getUrlOrBuilder() {
                if (urlBuilder_ != null) {
                    return urlBuilder_.getMessageOrBuilder();
                } else {
                    return url_ == null ?
                            GtfsRealtime.TranslatedString.getDefaultInstance() : url_;
                }
            }

            /**
             * <pre>
             * The URL which provides additional information about the alert.
             * </pre>
             *
             * <code>optional .transit_realtime.TranslatedString url = 8;</code>
             */
            private com.google.protobuf.SingleFieldBuilderV3<
                    GtfsRealtime.TranslatedString, GtfsRealtime.TranslatedString.Builder, GtfsRealtime.TranslatedStringOrBuilder>
            getUrlFieldBuilder() {
                if (urlBuilder_ == null) {
                    urlBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
                            GtfsRealtime.TranslatedString, GtfsRealtime.TranslatedString.Builder, GtfsRealtime.TranslatedStringOrBuilder>(
                            getUrl(),
                            getParentForChildren(),
                            isClean());
                    url_ = null;
                }
                return urlBuilder_;
            }

            private GtfsRealtime.TranslatedString headerText_;
            private com.google.protobuf.SingleFieldBuilderV3<
                    GtfsRealtime.TranslatedString, GtfsRealtime.TranslatedString.Builder, GtfsRealtime.TranslatedStringOrBuilder> headerTextBuilder_;

            /**
             * <pre>
             * Alert header. Contains a short summary of the alert text as plain-text.
             * </pre>
             *
             * <code>optional .transit_realtime.TranslatedString header_text = 10;</code>
             */
            public boolean hasHeaderText() {
                return ((bitField0_ & 0x00000020) != 0);
            }

            /**
             * <pre>
             * Alert header. Contains a short summary of the alert text as plain-text.
             * </pre>
             *
             * <code>optional .transit_realtime.TranslatedString header_text = 10;</code>
             */
            public GtfsRealtime.TranslatedString getHeaderText() {
                if (headerTextBuilder_ == null) {
                    return headerText_ == null ? GtfsRealtime.TranslatedString.getDefaultInstance() : headerText_;
                } else {
                    return headerTextBuilder_.getMessage();
                }
            }

            /**
             * <pre>
             * Alert header. Contains a short summary of the alert text as plain-text.
             * </pre>
             *
             * <code>optional .transit_realtime.TranslatedString header_text = 10;</code>
             */
            public Builder setHeaderText(GtfsRealtime.TranslatedString value) {
                if (headerTextBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    headerText_ = value;
                    onChanged();
                } else {
                    headerTextBuilder_.setMessage(value);
                }
                bitField0_ |= 0x00000020;
                return this;
            }

            /**
             * <pre>
             * Alert header. Contains a short summary of the alert text as plain-text.
             * </pre>
             *
             * <code>optional .transit_realtime.TranslatedString header_text = 10;</code>
             */
            public Builder setHeaderText(
                    GtfsRealtime.TranslatedString.Builder builderForValue) {
                if (headerTextBuilder_ == null) {
                    headerText_ = builderForValue.build();
                    onChanged();
                } else {
                    headerTextBuilder_.setMessage(builderForValue.build());
                }
                bitField0_ |= 0x00000020;
                return this;
            }

            /**
             * <pre>
             * Alert header. Contains a short summary of the alert text as plain-text.
             * </pre>
             *
             * <code>optional .transit_realtime.TranslatedString header_text = 10;</code>
             */
            public Builder mergeHeaderText(GtfsRealtime.TranslatedString value) {
                if (headerTextBuilder_ == null) {
                    if (((bitField0_ & 0x00000020) != 0) &&
                            headerText_ != null &&
                            headerText_ != GtfsRealtime.TranslatedString.getDefaultInstance()) {
                        headerText_ =
                                GtfsRealtime.TranslatedString.newBuilder(headerText_).mergeFrom(value).buildPartial();
                    } else {
                        headerText_ = value;
                    }
                    onChanged();
                } else {
                    headerTextBuilder_.mergeFrom(value);
                }
                bitField0_ |= 0x00000020;
                return this;
            }

            /**
             * <pre>
             * Alert header. Contains a short summary of the alert text as plain-text.
             * </pre>
             *
             * <code>optional .transit_realtime.TranslatedString header_text = 10;</code>
             */
            public Builder clearHeaderText() {
                if (headerTextBuilder_ == null) {
                    headerText_ = null;
                    onChanged();
                } else {
                    headerTextBuilder_.clear();
                }
                bitField0_ = (bitField0_ & ~0x00000020);
                return this;
            }

            /**
             * <pre>
             * Alert header. Contains a short summary of the alert text as plain-text.
             * </pre>
             *
             * <code>optional .transit_realtime.TranslatedString header_text = 10;</code>
             */
            public GtfsRealtime.TranslatedString.Builder getHeaderTextBuilder() {
                bitField0_ |= 0x00000020;
                onChanged();
                return getHeaderTextFieldBuilder().getBuilder();
            }

            /**
             * <pre>
             * Alert header. Contains a short summary of the alert text as plain-text.
             * </pre>
             *
             * <code>optional .transit_realtime.TranslatedString header_text = 10;</code>
             */
            public GtfsRealtime.TranslatedStringOrBuilder getHeaderTextOrBuilder() {
                if (headerTextBuilder_ != null) {
                    return headerTextBuilder_.getMessageOrBuilder();
                } else {
                    return headerText_ == null ?
                            GtfsRealtime.TranslatedString.getDefaultInstance() : headerText_;
                }
            }

            /**
             * <pre>
             * Alert header. Contains a short summary of the alert text as plain-text.
             * </pre>
             *
             * <code>optional .transit_realtime.TranslatedString header_text = 10;</code>
             */
            private com.google.protobuf.SingleFieldBuilderV3<
                    GtfsRealtime.TranslatedString, GtfsRealtime.TranslatedString.Builder, GtfsRealtime.TranslatedStringOrBuilder>
            getHeaderTextFieldBuilder() {
                if (headerTextBuilder_ == null) {
                    headerTextBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
                            GtfsRealtime.TranslatedString, GtfsRealtime.TranslatedString.Builder, GtfsRealtime.TranslatedStringOrBuilder>(
                            getHeaderText(),
                            getParentForChildren(),
                            isClean());
                    headerText_ = null;
                }
                return headerTextBuilder_;
            }

            private GtfsRealtime.TranslatedString descriptionText_;
            private com.google.protobuf.SingleFieldBuilderV3<
                    GtfsRealtime.TranslatedString, GtfsRealtime.TranslatedString.Builder, GtfsRealtime.TranslatedStringOrBuilder> descriptionTextBuilder_;

            /**
             * <pre>
             * Full description for the alert as plain-text. The information in the
             * description should add to the information of the header.
             * </pre>
             *
             * <code>optional .transit_realtime.TranslatedString description_text = 11;</code>
             */
            public boolean hasDescriptionText() {
                return ((bitField0_ & 0x00000040) != 0);
            }

            /**
             * <pre>
             * Full description for the alert as plain-text. The information in the
             * description should add to the information of the header.
             * </pre>
             *
             * <code>optional .transit_realtime.TranslatedString description_text = 11;</code>
             */
            public GtfsRealtime.TranslatedString getDescriptionText() {
                if (descriptionTextBuilder_ == null) {
                    return descriptionText_ == null ? GtfsRealtime.TranslatedString.getDefaultInstance() : descriptionText_;
                } else {
                    return descriptionTextBuilder_.getMessage();
                }
            }

            /**
             * <pre>
             * Full description for the alert as plain-text. The information in the
             * description should add to the information of the header.
             * </pre>
             *
             * <code>optional .transit_realtime.TranslatedString description_text = 11;</code>
             */
            public Builder setDescriptionText(GtfsRealtime.TranslatedString value) {
                if (descriptionTextBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    descriptionText_ = value;
                    onChanged();
                } else {
                    descriptionTextBuilder_.setMessage(value);
                }
                bitField0_ |= 0x00000040;
                return this;
            }

            /**
             * <pre>
             * Full description for the alert as plain-text. The information in the
             * description should add to the information of the header.
             * </pre>
             *
             * <code>optional .transit_realtime.TranslatedString description_text = 11;</code>
             */
            public Builder setDescriptionText(
                    GtfsRealtime.TranslatedString.Builder builderForValue) {
                if (descriptionTextBuilder_ == null) {
                    descriptionText_ = builderForValue.build();
                    onChanged();
                } else {
                    descriptionTextBuilder_.setMessage(builderForValue.build());
                }
                bitField0_ |= 0x00000040;
                return this;
            }

            /**
             * <pre>
             * Full description for the alert as plain-text. The information in the
             * description should add to the information of the header.
             * </pre>
             *
             * <code>optional .transit_realtime.TranslatedString description_text = 11;</code>
             */
            public Builder mergeDescriptionText(GtfsRealtime.TranslatedString value) {
                if (descriptionTextBuilder_ == null) {
                    if (((bitField0_ & 0x00000040) != 0) &&
                            descriptionText_ != null &&
                            descriptionText_ != GtfsRealtime.TranslatedString.getDefaultInstance()) {
                        descriptionText_ =
                                GtfsRealtime.TranslatedString.newBuilder(descriptionText_).mergeFrom(value).buildPartial();
                    } else {
                        descriptionText_ = value;
                    }
                    onChanged();
                } else {
                    descriptionTextBuilder_.mergeFrom(value);
                }
                bitField0_ |= 0x00000040;
                return this;
            }

            /**
             * <pre>
             * Full description for the alert as plain-text. The information in the
             * description should add to the information of the header.
             * </pre>
             *
             * <code>optional .transit_realtime.TranslatedString description_text = 11;</code>
             */
            public Builder clearDescriptionText() {
                if (descriptionTextBuilder_ == null) {
                    descriptionText_ = null;
                    onChanged();
                } else {
                    descriptionTextBuilder_.clear();
                }
                bitField0_ = (bitField0_ & ~0x00000040);
                return this;
            }

            /**
             * <pre>
             * Full description for the alert as plain-text. The information in the
             * description should add to the information of the header.
             * </pre>
             *
             * <code>optional .transit_realtime.TranslatedString description_text = 11;</code>
             */
            public GtfsRealtime.TranslatedString.Builder getDescriptionTextBuilder() {
                bitField0_ |= 0x00000040;
                onChanged();
                return getDescriptionTextFieldBuilder().getBuilder();
            }

            /**
             * <pre>
             * Full description for the alert as plain-text. The information in the
             * description should add to the information of the header.
             * </pre>
             *
             * <code>optional .transit_realtime.TranslatedString description_text = 11;</code>
             */
            public GtfsRealtime.TranslatedStringOrBuilder getDescriptionTextOrBuilder() {
                if (descriptionTextBuilder_ != null) {
                    return descriptionTextBuilder_.getMessageOrBuilder();
                } else {
                    return descriptionText_ == null ?
                            GtfsRealtime.TranslatedString.getDefaultInstance() : descriptionText_;
                }
            }

            /**
             * <pre>
             * Full description for the alert as plain-text. The information in the
             * description should add to the information of the header.
             * </pre>
             *
             * <code>optional .transit_realtime.TranslatedString description_text = 11;</code>
             */
            private com.google.protobuf.SingleFieldBuilderV3<
                    GtfsRealtime.TranslatedString, GtfsRealtime.TranslatedString.Builder, GtfsRealtime.TranslatedStringOrBuilder>
            getDescriptionTextFieldBuilder() {
                if (descriptionTextBuilder_ == null) {
                    descriptionTextBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
                            GtfsRealtime.TranslatedString, GtfsRealtime.TranslatedString.Builder, GtfsRealtime.TranslatedStringOrBuilder>(
                            getDescriptionText(),
                            getParentForChildren(),
                            isClean());
                    descriptionText_ = null;
                }
                return descriptionTextBuilder_;
            }

            @java.lang.Override
            public final Builder setUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.setUnknownFields(unknownFields);
            }

            @java.lang.Override
            public final Builder mergeUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.mergeUnknownFields(unknownFields);
            }


            // @@protoc_insertion_point(builder_scope:transit_realtime.Alert)
        }

        // @@protoc_insertion_point(class_scope:transit_realtime.Alert)
        private static final GtfsRealtime.Alert DEFAULT_INSTANCE;

        static {
            DEFAULT_INSTANCE = new GtfsRealtime.Alert();
        }

        public static GtfsRealtime.Alert getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        @java.lang.Deprecated
        public static final com.google.protobuf.Parser<Alert>
                PARSER = new com.google.protobuf.AbstractParser<Alert>() {
            @java.lang.Override
            public Alert parsePartialFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return new Alert(input, extensionRegistry);
            }
        };

        public static com.google.protobuf.Parser<Alert> parser() {
            return PARSER;
        }

        @java.lang.Override
        public com.google.protobuf.Parser<Alert> getParserForType() {
            return PARSER;
        }

        @java.lang.Override
        public GtfsRealtime.Alert getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

    }

    public interface TimeRangeOrBuilder extends
            // @@protoc_insertion_point(interface_extends:transit_realtime.TimeRange)
            com.google.protobuf.GeneratedMessageV3.
                    ExtendableMessageOrBuilder<TimeRange> {

        /**
         * <pre>
         * Start time, in POSIX time (i.e., number of seconds since January 1st 1970
         * 00:00:00 UTC).
         * If missing, the interval starts at minus infinity.
         * </pre>
         *
         * <code>optional uint64 start = 1;</code>
         */
        boolean hasStart();

        /**
         * <pre>
         * Start time, in POSIX time (i.e., number of seconds since January 1st 1970
         * 00:00:00 UTC).
         * If missing, the interval starts at minus infinity.
         * </pre>
         *
         * <code>optional uint64 start = 1;</code>
         */
        long getStart();

        /**
         * <pre>
         * End time, in POSIX time (i.e., number of seconds since January 1st 1970
         * 00:00:00 UTC).
         * If missing, the interval ends at plus infinity.
         * </pre>
         *
         * <code>optional uint64 end = 2;</code>
         */
        boolean hasEnd();

        /**
         * <pre>
         * End time, in POSIX time (i.e., number of seconds since January 1st 1970
         * 00:00:00 UTC).
         * If missing, the interval ends at plus infinity.
         * </pre>
         *
         * <code>optional uint64 end = 2;</code>
         */
        long getEnd();
    }

    /**
     * <pre>
     * A time interval. The interval is considered active at time 't' if 't' is
     * greater than or equal to the start time and less than the end time.
     * </pre>
     * <p>
     * Protobuf type {@code transit_realtime.TimeRange}
     */
    public static final class TimeRange extends
            com.google.protobuf.GeneratedMessageV3.ExtendableMessage<
                    TimeRange> implements
            // @@protoc_insertion_point(message_implements:transit_realtime.TimeRange)
            TimeRangeOrBuilder {
        private static final long serialVersionUID = 0L;

        // Use TimeRange.newBuilder() to construct.
        private TimeRange(com.google.protobuf.GeneratedMessageV3.ExtendableBuilder<GtfsRealtime.TimeRange, ?> builder) {
            super(builder);
        }

        private TimeRange() {
        }

        @java.lang.Override
        @SuppressWarnings({"unused"})
        protected java.lang.Object newInstance(
                UnusedPrivateParameter unused) {
            return new TimeRange();
        }

        @java.lang.Override
        public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
            return this.unknownFields;
        }

        private TimeRange(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            if (extensionRegistry == null) {
                throw new java.lang.NullPointerException();
            }
            int mutable_bitField0_ = 0;
            com.google.protobuf.UnknownFieldSet.Builder unknownFields =
                    com.google.protobuf.UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        case 8: {
                            bitField0_ |= 0x00000001;
                            start_ = input.readUInt64();
                            break;
                        }
                        case 16: {
                            bitField0_ |= 0x00000002;
                            end_ = input.readUInt64();
                            break;
                        }
                        default: {
                            if (!parseUnknownField(
                                    input, unknownFields, extensionRegistry, tag)) {
                                done = true;
                            }
                            break;
                        }
                    }
                }
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (java.io.IOException e) {
                throw new com.google.protobuf.InvalidProtocolBufferException(
                        e).setUnfinishedMessage(this);
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return GtfsRealtime.internal_static_transit_realtime_TimeRange_descriptor;
        }

        @java.lang.Override
        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return GtfsRealtime.internal_static_transit_realtime_TimeRange_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            GtfsRealtime.TimeRange.class, GtfsRealtime.TimeRange.Builder.class);
        }

        private int bitField0_;
        public static final int START_FIELD_NUMBER = 1;
        private long start_;

        /**
         * <pre>
         * Start time, in POSIX time (i.e., number of seconds since January 1st 1970
         * 00:00:00 UTC).
         * If missing, the interval starts at minus infinity.
         * </pre>
         *
         * <code>optional uint64 start = 1;</code>
         */
        public boolean hasStart() {
            return ((bitField0_ & 0x00000001) != 0);
        }

        /**
         * <pre>
         * Start time, in POSIX time (i.e., number of seconds since January 1st 1970
         * 00:00:00 UTC).
         * If missing, the interval starts at minus infinity.
         * </pre>
         *
         * <code>optional uint64 start = 1;</code>
         */
        public long getStart() {
            return start_;
        }

        public static final int END_FIELD_NUMBER = 2;
        private long end_;

        /**
         * <pre>
         * End time, in POSIX time (i.e., number of seconds since January 1st 1970
         * 00:00:00 UTC).
         * If missing, the interval ends at plus infinity.
         * </pre>
         *
         * <code>optional uint64 end = 2;</code>
         */
        public boolean hasEnd() {
            return ((bitField0_ & 0x00000002) != 0);
        }

        /**
         * <pre>
         * End time, in POSIX time (i.e., number of seconds since January 1st 1970
         * 00:00:00 UTC).
         * If missing, the interval ends at plus infinity.
         * </pre>
         *
         * <code>optional uint64 end = 2;</code>
         */
        public long getEnd() {
            return end_;
        }

        private byte memoizedIsInitialized = -1;

        @java.lang.Override
        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            if (!extensionsAreInitialized()) {
                memoizedIsInitialized = 0;
                return false;
            }
            memoizedIsInitialized = 1;
            return true;
        }

        @java.lang.Override
        public void writeTo(com.google.protobuf.CodedOutputStream output)
                throws java.io.IOException {
            com.google.protobuf.GeneratedMessageV3
                    .ExtendableMessage<GtfsRealtime.TimeRange>.ExtensionWriter
                    extensionWriter = newExtensionWriter();
            if (((bitField0_ & 0x00000001) != 0)) {
                output.writeUInt64(1, start_);
            }
            if (((bitField0_ & 0x00000002) != 0)) {
                output.writeUInt64(2, end_);
            }
            extensionWriter.writeUntil(2000, output);
            unknownFields.writeTo(output);
        }

        @java.lang.Override
        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            if (((bitField0_ & 0x00000001) != 0)) {
                size += com.google.protobuf.CodedOutputStream
                        .computeUInt64Size(1, start_);
            }
            if (((bitField0_ & 0x00000002) != 0)) {
                size += com.google.protobuf.CodedOutputStream
                        .computeUInt64Size(2, end_);
            }
            size += extensionsSerializedSize();
            size += unknownFields.getSerializedSize();
            memoizedSize = size;
            return size;
        }

        @java.lang.Override
        public boolean equals(final java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof GtfsRealtime.TimeRange)) {
                return super.equals(obj);
            }
            GtfsRealtime.TimeRange other = (GtfsRealtime.TimeRange) obj;

            if (hasStart() != other.hasStart()) return false;
            if (hasStart()) {
                if (getStart()
                        != other.getStart()) return false;
            }
            if (hasEnd() != other.hasEnd()) return false;
            if (hasEnd()) {
                if (getEnd()
                        != other.getEnd()) return false;
            }
            if (!unknownFields.equals(other.unknownFields)) return false;
            if (!getExtensionFields().equals(other.getExtensionFields()))
                return false;
            return true;
        }

        @java.lang.Override
        public int hashCode() {
            if (memoizedHashCode != 0) {
                return memoizedHashCode;
            }
            int hash = 41;
            hash = (19 * hash) + getDescriptor().hashCode();
            if (hasStart()) {
                hash = (37 * hash) + START_FIELD_NUMBER;
                hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
                        getStart());
            }
            if (hasEnd()) {
                hash = (37 * hash) + END_FIELD_NUMBER;
                hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
                        getEnd());
            }
            hash = hashFields(hash, getExtensionFields());
            hash = (29 * hash) + unknownFields.hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static GtfsRealtime.TimeRange parseFrom(
                java.nio.ByteBuffer data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GtfsRealtime.TimeRange parseFrom(
                java.nio.ByteBuffer data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GtfsRealtime.TimeRange parseFrom(
                com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GtfsRealtime.TimeRange parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GtfsRealtime.TimeRange parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GtfsRealtime.TimeRange parseFrom(
                byte[] data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GtfsRealtime.TimeRange parseFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }

        public static GtfsRealtime.TimeRange parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static GtfsRealtime.TimeRange parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input);
        }

        public static GtfsRealtime.TimeRange parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static GtfsRealtime.TimeRange parseFrom(
                com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }

        public static GtfsRealtime.TimeRange parseFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        @java.lang.Override
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GtfsRealtime.TimeRange prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }

        @java.lang.Override
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE
                    ? new Builder() : new Builder().mergeFrom(this);
        }

        @java.lang.Override
        protected Builder newBuilderForType(
                com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        /**
         * <pre>
         * A time interval. The interval is considered active at time 't' if 't' is
         * greater than or equal to the start time and less than the end time.
         * </pre>
         * <p>
         * Protobuf type {@code transit_realtime.TimeRange}
         */
        public static final class Builder extends
                com.google.protobuf.GeneratedMessageV3.ExtendableBuilder<
                        GtfsRealtime.TimeRange, Builder> implements
                // @@protoc_insertion_point(builder_implements:transit_realtime.TimeRange)
                GtfsRealtime.TimeRangeOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
                return GtfsRealtime.internal_static_transit_realtime_TimeRange_descriptor;
            }

            @java.lang.Override
            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internalGetFieldAccessorTable() {
                return GtfsRealtime.internal_static_transit_realtime_TimeRange_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                GtfsRealtime.TimeRange.class, GtfsRealtime.TimeRange.Builder.class);
            }

            // Construct using GtfsRealtime.TimeRange.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(
                    com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.GeneratedMessageV3
                        .alwaysUseFieldBuilders) {
                }
            }

            @java.lang.Override
            public Builder clear() {
                super.clear();
                start_ = 0L;
                bitField0_ = (bitField0_ & ~0x00000001);
                end_ = 0L;
                bitField0_ = (bitField0_ & ~0x00000002);
                return this;
            }

            @java.lang.Override
            public com.google.protobuf.Descriptors.Descriptor
            getDescriptorForType() {
                return GtfsRealtime.internal_static_transit_realtime_TimeRange_descriptor;
            }

            @java.lang.Override
            public GtfsRealtime.TimeRange getDefaultInstanceForType() {
                return GtfsRealtime.TimeRange.getDefaultInstance();
            }

            @java.lang.Override
            public GtfsRealtime.TimeRange build() {
                GtfsRealtime.TimeRange result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            @java.lang.Override
            public GtfsRealtime.TimeRange buildPartial() {
                GtfsRealtime.TimeRange result = new GtfsRealtime.TimeRange(this);
                int from_bitField0_ = bitField0_;
                int to_bitField0_ = 0;
                if (((from_bitField0_ & 0x00000001) != 0)) {
                    result.start_ = start_;
                    to_bitField0_ |= 0x00000001;
                }
                if (((from_bitField0_ & 0x00000002) != 0)) {
                    result.end_ = end_;
                    to_bitField0_ |= 0x00000002;
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            @java.lang.Override
            public Builder clone() {
                return super.clone();
            }

            @java.lang.Override
            public Builder setField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return super.setField(field, value);
            }

            @java.lang.Override
            public Builder clearField(
                    com.google.protobuf.Descriptors.FieldDescriptor field) {
                return super.clearField(field);
            }

            @java.lang.Override
            public Builder clearOneof(
                    com.google.protobuf.Descriptors.OneofDescriptor oneof) {
                return super.clearOneof(oneof);
            }

            @java.lang.Override
            public Builder setRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    int index, java.lang.Object value) {
                return super.setRepeatedField(field, index, value);
            }

            @java.lang.Override
            public Builder addRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return super.addRepeatedField(field, value);
            }

            @java.lang.Override
            public <Type> Builder setExtension(
                    com.google.protobuf.GeneratedMessage.GeneratedExtension<
                            GtfsRealtime.TimeRange, Type> extension,
                    Type value) {
                return super.setExtension(extension, value);
            }

            @java.lang.Override
            public <Type> Builder setExtension(
                    com.google.protobuf.GeneratedMessage.GeneratedExtension<
                            GtfsRealtime.TimeRange, java.util.List<Type>> extension,
                    int index, Type value) {
                return super.setExtension(extension, index, value);
            }

            @java.lang.Override
            public <Type> Builder addExtension(
                    com.google.protobuf.GeneratedMessage.GeneratedExtension<
                            GtfsRealtime.TimeRange, java.util.List<Type>> extension,
                    Type value) {
                return super.addExtension(extension, value);
            }

            @java.lang.Override
            public <Type> Builder clearExtension(
                    com.google.protobuf.GeneratedMessage.GeneratedExtension<
                            GtfsRealtime.TimeRange, ?> extension) {
                return super.clearExtension(extension);
            }

            @java.lang.Override
            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof GtfsRealtime.TimeRange) {
                    return mergeFrom((GtfsRealtime.TimeRange) other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(GtfsRealtime.TimeRange other) {
                if (other == GtfsRealtime.TimeRange.getDefaultInstance()) return this;
                if (other.hasStart()) {
                    setStart(other.getStart());
                }
                if (other.hasEnd()) {
                    setEnd(other.getEnd());
                }
                this.mergeExtensionFields(other);
                this.mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            @java.lang.Override
            public final boolean isInitialized() {
                if (!extensionsAreInitialized()) {
                    return false;
                }
                return true;
            }

            @java.lang.Override
            public Builder mergeFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                GtfsRealtime.TimeRange parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (GtfsRealtime.TimeRange) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private int bitField0_;

            private long start_;

            /**
             * <pre>
             * Start time, in POSIX time (i.e., number of seconds since January 1st 1970
             * 00:00:00 UTC).
             * If missing, the interval starts at minus infinity.
             * </pre>
             *
             * <code>optional uint64 start = 1;</code>
             */
            public boolean hasStart() {
                return ((bitField0_ & 0x00000001) != 0);
            }

            /**
             * <pre>
             * Start time, in POSIX time (i.e., number of seconds since January 1st 1970
             * 00:00:00 UTC).
             * If missing, the interval starts at minus infinity.
             * </pre>
             *
             * <code>optional uint64 start = 1;</code>
             */
            public long getStart() {
                return start_;
            }

            /**
             * <pre>
             * Start time, in POSIX time (i.e., number of seconds since January 1st 1970
             * 00:00:00 UTC).
             * If missing, the interval starts at minus infinity.
             * </pre>
             *
             * <code>optional uint64 start = 1;</code>
             */
            public Builder setStart(long value) {
                bitField0_ |= 0x00000001;
                start_ = value;
                onChanged();
                return this;
            }

            /**
             * <pre>
             * Start time, in POSIX time (i.e., number of seconds since January 1st 1970
             * 00:00:00 UTC).
             * If missing, the interval starts at minus infinity.
             * </pre>
             *
             * <code>optional uint64 start = 1;</code>
             */
            public Builder clearStart() {
                bitField0_ = (bitField0_ & ~0x00000001);
                start_ = 0L;
                onChanged();
                return this;
            }

            private long end_;

            /**
             * <pre>
             * End time, in POSIX time (i.e., number of seconds since January 1st 1970
             * 00:00:00 UTC).
             * If missing, the interval ends at plus infinity.
             * </pre>
             *
             * <code>optional uint64 end = 2;</code>
             */
            public boolean hasEnd() {
                return ((bitField0_ & 0x00000002) != 0);
            }

            /**
             * <pre>
             * End time, in POSIX time (i.e., number of seconds since January 1st 1970
             * 00:00:00 UTC).
             * If missing, the interval ends at plus infinity.
             * </pre>
             *
             * <code>optional uint64 end = 2;</code>
             */
            public long getEnd() {
                return end_;
            }

            /**
             * <pre>
             * End time, in POSIX time (i.e., number of seconds since January 1st 1970
             * 00:00:00 UTC).
             * If missing, the interval ends at plus infinity.
             * </pre>
             *
             * <code>optional uint64 end = 2;</code>
             */
            public Builder setEnd(long value) {
                bitField0_ |= 0x00000002;
                end_ = value;
                onChanged();
                return this;
            }

            /**
             * <pre>
             * End time, in POSIX time (i.e., number of seconds since January 1st 1970
             * 00:00:00 UTC).
             * If missing, the interval ends at plus infinity.
             * </pre>
             *
             * <code>optional uint64 end = 2;</code>
             */
            public Builder clearEnd() {
                bitField0_ = (bitField0_ & ~0x00000002);
                end_ = 0L;
                onChanged();
                return this;
            }

            @java.lang.Override
            public final Builder setUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.setUnknownFields(unknownFields);
            }

            @java.lang.Override
            public final Builder mergeUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.mergeUnknownFields(unknownFields);
            }


            // @@protoc_insertion_point(builder_scope:transit_realtime.TimeRange)
        }

        // @@protoc_insertion_point(class_scope:transit_realtime.TimeRange)
        private static final GtfsRealtime.TimeRange DEFAULT_INSTANCE;

        static {
            DEFAULT_INSTANCE = new GtfsRealtime.TimeRange();
        }

        public static GtfsRealtime.TimeRange getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        @java.lang.Deprecated
        public static final com.google.protobuf.Parser<TimeRange>
                PARSER = new com.google.protobuf.AbstractParser<TimeRange>() {
            @java.lang.Override
            public TimeRange parsePartialFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return new TimeRange(input, extensionRegistry);
            }
        };

        public static com.google.protobuf.Parser<TimeRange> parser() {
            return PARSER;
        }

        @java.lang.Override
        public com.google.protobuf.Parser<TimeRange> getParserForType() {
            return PARSER;
        }

        @java.lang.Override
        public GtfsRealtime.TimeRange getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

    }

    public interface PositionOrBuilder extends
            // @@protoc_insertion_point(interface_extends:transit_realtime.Position)
            com.google.protobuf.GeneratedMessageV3.
                    ExtendableMessageOrBuilder<Position> {

        /**
         * <pre>
         * Degrees North, in the WGS-84 coordinate system.
         * </pre>
         *
         * <code>required float latitude = 1;</code>
         */
        boolean hasLatitude();

        /**
         * <pre>
         * Degrees North, in the WGS-84 coordinate system.
         * </pre>
         *
         * <code>required float latitude = 1;</code>
         */
        float getLatitude();

        /**
         * <pre>
         * Degrees East, in the WGS-84 coordinate system.
         * </pre>
         *
         * <code>required float longitude = 2;</code>
         */
        boolean hasLongitude();

        /**
         * <pre>
         * Degrees East, in the WGS-84 coordinate system.
         * </pre>
         *
         * <code>required float longitude = 2;</code>
         */
        float getLongitude();

        /**
         * <pre>
         * Bearing, in degrees, clockwise from North, i.e., 0 is North and 90 is East.
         * This can be the compass bearing, or the direction towards the next stop
         * or intermediate location.
         * This should not be direction deduced from the sequence of previous
         * positions, which can be computed from previous data.
         * </pre>
         *
         * <code>optional float bearing = 3;</code>
         */
        boolean hasBearing();

        /**
         * <pre>
         * Bearing, in degrees, clockwise from North, i.e., 0 is North and 90 is East.
         * This can be the compass bearing, or the direction towards the next stop
         * or intermediate location.
         * This should not be direction deduced from the sequence of previous
         * positions, which can be computed from previous data.
         * </pre>
         *
         * <code>optional float bearing = 3;</code>
         */
        float getBearing();

        /**
         * <pre>
         * Odometer value, in meters.
         * </pre>
         *
         * <code>optional double odometer = 4;</code>
         */
        boolean hasOdometer();

        /**
         * <pre>
         * Odometer value, in meters.
         * </pre>
         *
         * <code>optional double odometer = 4;</code>
         */
        double getOdometer();

        /**
         * <pre>
         * Momentary speed measured by the vehicle, in meters per second.
         * </pre>
         *
         * <code>optional float speed = 5;</code>
         */
        boolean hasSpeed();

        /**
         * <pre>
         * Momentary speed measured by the vehicle, in meters per second.
         * </pre>
         *
         * <code>optional float speed = 5;</code>
         */
        float getSpeed();
    }

    /**
     * <pre>
     * A position.
     * </pre>
     * <p>
     * Protobuf type {@code transit_realtime.Position}
     */
    public static final class Position extends
            com.google.protobuf.GeneratedMessageV3.ExtendableMessage<
                    Position> implements
            // @@protoc_insertion_point(message_implements:transit_realtime.Position)
            PositionOrBuilder {
        private static final long serialVersionUID = 0L;

        // Use Position.newBuilder() to construct.
        private Position(com.google.protobuf.GeneratedMessageV3.ExtendableBuilder<GtfsRealtime.Position, ?> builder) {
            super(builder);
        }

        private Position() {
        }

        @java.lang.Override
        @SuppressWarnings({"unused"})
        protected java.lang.Object newInstance(
                UnusedPrivateParameter unused) {
            return new Position();
        }

        @java.lang.Override
        public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
            return this.unknownFields;
        }

        private Position(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            if (extensionRegistry == null) {
                throw new java.lang.NullPointerException();
            }
            int mutable_bitField0_ = 0;
            com.google.protobuf.UnknownFieldSet.Builder unknownFields =
                    com.google.protobuf.UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        case 13: {
                            bitField0_ |= 0x00000001;
                            latitude_ = input.readFloat();
                            break;
                        }
                        case 21: {
                            bitField0_ |= 0x00000002;
                            longitude_ = input.readFloat();
                            break;
                        }
                        case 29: {
                            bitField0_ |= 0x00000004;
                            bearing_ = input.readFloat();
                            break;
                        }
                        case 33: {
                            bitField0_ |= 0x00000008;
                            odometer_ = input.readDouble();
                            break;
                        }
                        case 45: {
                            bitField0_ |= 0x00000010;
                            speed_ = input.readFloat();
                            break;
                        }
                        default: {
                            if (!parseUnknownField(
                                    input, unknownFields, extensionRegistry, tag)) {
                                done = true;
                            }
                            break;
                        }
                    }
                }
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (java.io.IOException e) {
                throw new com.google.protobuf.InvalidProtocolBufferException(
                        e).setUnfinishedMessage(this);
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return GtfsRealtime.internal_static_transit_realtime_Position_descriptor;
        }

        @java.lang.Override
        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return GtfsRealtime.internal_static_transit_realtime_Position_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            GtfsRealtime.Position.class, GtfsRealtime.Position.Builder.class);
        }

        private int bitField0_;
        public static final int LATITUDE_FIELD_NUMBER = 1;
        private float latitude_;

        /**
         * <pre>
         * Degrees North, in the WGS-84 coordinate system.
         * </pre>
         *
         * <code>required float latitude = 1;</code>
         */
        public boolean hasLatitude() {
            return ((bitField0_ & 0x00000001) != 0);
        }

        /**
         * <pre>
         * Degrees North, in the WGS-84 coordinate system.
         * </pre>
         *
         * <code>required float latitude = 1;</code>
         */
        public float getLatitude() {
            return latitude_;
        }

        public static final int LONGITUDE_FIELD_NUMBER = 2;
        private float longitude_;

        /**
         * <pre>
         * Degrees East, in the WGS-84 coordinate system.
         * </pre>
         *
         * <code>required float longitude = 2;</code>
         */
        public boolean hasLongitude() {
            return ((bitField0_ & 0x00000002) != 0);
        }

        /**
         * <pre>
         * Degrees East, in the WGS-84 coordinate system.
         * </pre>
         *
         * <code>required float longitude = 2;</code>
         */
        public float getLongitude() {
            return longitude_;
        }

        public static final int BEARING_FIELD_NUMBER = 3;
        private float bearing_;

        /**
         * <pre>
         * Bearing, in degrees, clockwise from North, i.e., 0 is North and 90 is East.
         * This can be the compass bearing, or the direction towards the next stop
         * or intermediate location.
         * This should not be direction deduced from the sequence of previous
         * positions, which can be computed from previous data.
         * </pre>
         *
         * <code>optional float bearing = 3;</code>
         */
        public boolean hasBearing() {
            return ((bitField0_ & 0x00000004) != 0);
        }

        /**
         * <pre>
         * Bearing, in degrees, clockwise from North, i.e., 0 is North and 90 is East.
         * This can be the compass bearing, or the direction towards the next stop
         * or intermediate location.
         * This should not be direction deduced from the sequence of previous
         * positions, which can be computed from previous data.
         * </pre>
         *
         * <code>optional float bearing = 3;</code>
         */
        public float getBearing() {
            return bearing_;
        }

        public static final int ODOMETER_FIELD_NUMBER = 4;
        private double odometer_;

        /**
         * <pre>
         * Odometer value, in meters.
         * </pre>
         *
         * <code>optional double odometer = 4;</code>
         */
        public boolean hasOdometer() {
            return ((bitField0_ & 0x00000008) != 0);
        }

        /**
         * <pre>
         * Odometer value, in meters.
         * </pre>
         *
         * <code>optional double odometer = 4;</code>
         */
        public double getOdometer() {
            return odometer_;
        }

        public static final int SPEED_FIELD_NUMBER = 5;
        private float speed_;

        /**
         * <pre>
         * Momentary speed measured by the vehicle, in meters per second.
         * </pre>
         *
         * <code>optional float speed = 5;</code>
         */
        public boolean hasSpeed() {
            return ((bitField0_ & 0x00000010) != 0);
        }

        /**
         * <pre>
         * Momentary speed measured by the vehicle, in meters per second.
         * </pre>
         *
         * <code>optional float speed = 5;</code>
         */
        public float getSpeed() {
            return speed_;
        }

        private byte memoizedIsInitialized = -1;

        @java.lang.Override
        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            if (!hasLatitude()) {
                memoizedIsInitialized = 0;
                return false;
            }
            if (!hasLongitude()) {
                memoizedIsInitialized = 0;
                return false;
            }
            if (!extensionsAreInitialized()) {
                memoizedIsInitialized = 0;
                return false;
            }
            memoizedIsInitialized = 1;
            return true;
        }

        @java.lang.Override
        public void writeTo(com.google.protobuf.CodedOutputStream output)
                throws java.io.IOException {
            com.google.protobuf.GeneratedMessageV3
                    .ExtendableMessage<GtfsRealtime.Position>.ExtensionWriter
                    extensionWriter = newExtensionWriter();
            if (((bitField0_ & 0x00000001) != 0)) {
                output.writeFloat(1, latitude_);
            }
            if (((bitField0_ & 0x00000002) != 0)) {
                output.writeFloat(2, longitude_);
            }
            if (((bitField0_ & 0x00000004) != 0)) {
                output.writeFloat(3, bearing_);
            }
            if (((bitField0_ & 0x00000008) != 0)) {
                output.writeDouble(4, odometer_);
            }
            if (((bitField0_ & 0x00000010) != 0)) {
                output.writeFloat(5, speed_);
            }
            extensionWriter.writeUntil(2000, output);
            unknownFields.writeTo(output);
        }

        @java.lang.Override
        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            if (((bitField0_ & 0x00000001) != 0)) {
                size += com.google.protobuf.CodedOutputStream
                        .computeFloatSize(1, latitude_);
            }
            if (((bitField0_ & 0x00000002) != 0)) {
                size += com.google.protobuf.CodedOutputStream
                        .computeFloatSize(2, longitude_);
            }
            if (((bitField0_ & 0x00000004) != 0)) {
                size += com.google.protobuf.CodedOutputStream
                        .computeFloatSize(3, bearing_);
            }
            if (((bitField0_ & 0x00000008) != 0)) {
                size += com.google.protobuf.CodedOutputStream
                        .computeDoubleSize(4, odometer_);
            }
            if (((bitField0_ & 0x00000010) != 0)) {
                size += com.google.protobuf.CodedOutputStream
                        .computeFloatSize(5, speed_);
            }
            size += extensionsSerializedSize();
            size += unknownFields.getSerializedSize();
            memoizedSize = size;
            return size;
        }

        @java.lang.Override
        public boolean equals(final java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof GtfsRealtime.Position)) {
                return super.equals(obj);
            }
            GtfsRealtime.Position other = (GtfsRealtime.Position) obj;

            if (hasLatitude() != other.hasLatitude()) return false;
            if (hasLatitude()) {
                if (java.lang.Float.floatToIntBits(getLatitude())
                        != java.lang.Float.floatToIntBits(
                        other.getLatitude())) return false;
            }
            if (hasLongitude() != other.hasLongitude()) return false;
            if (hasLongitude()) {
                if (java.lang.Float.floatToIntBits(getLongitude())
                        != java.lang.Float.floatToIntBits(
                        other.getLongitude())) return false;
            }
            if (hasBearing() != other.hasBearing()) return false;
            if (hasBearing()) {
                if (java.lang.Float.floatToIntBits(getBearing())
                        != java.lang.Float.floatToIntBits(
                        other.getBearing())) return false;
            }
            if (hasOdometer() != other.hasOdometer()) return false;
            if (hasOdometer()) {
                if (java.lang.Double.doubleToLongBits(getOdometer())
                        != java.lang.Double.doubleToLongBits(
                        other.getOdometer())) return false;
            }
            if (hasSpeed() != other.hasSpeed()) return false;
            if (hasSpeed()) {
                if (java.lang.Float.floatToIntBits(getSpeed())
                        != java.lang.Float.floatToIntBits(
                        other.getSpeed())) return false;
            }
            if (!unknownFields.equals(other.unknownFields)) return false;
            if (!getExtensionFields().equals(other.getExtensionFields()))
                return false;
            return true;
        }

        @java.lang.Override
        public int hashCode() {
            if (memoizedHashCode != 0) {
                return memoizedHashCode;
            }
            int hash = 41;
            hash = (19 * hash) + getDescriptor().hashCode();
            if (hasLatitude()) {
                hash = (37 * hash) + LATITUDE_FIELD_NUMBER;
                hash = (53 * hash) + java.lang.Float.floatToIntBits(
                        getLatitude());
            }
            if (hasLongitude()) {
                hash = (37 * hash) + LONGITUDE_FIELD_NUMBER;
                hash = (53 * hash) + java.lang.Float.floatToIntBits(
                        getLongitude());
            }
            if (hasBearing()) {
                hash = (37 * hash) + BEARING_FIELD_NUMBER;
                hash = (53 * hash) + java.lang.Float.floatToIntBits(
                        getBearing());
            }
            if (hasOdometer()) {
                hash = (37 * hash) + ODOMETER_FIELD_NUMBER;
                hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
                        java.lang.Double.doubleToLongBits(getOdometer()));
            }
            if (hasSpeed()) {
                hash = (37 * hash) + SPEED_FIELD_NUMBER;
                hash = (53 * hash) + java.lang.Float.floatToIntBits(
                        getSpeed());
            }
            hash = hashFields(hash, getExtensionFields());
            hash = (29 * hash) + unknownFields.hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static GtfsRealtime.Position parseFrom(
                java.nio.ByteBuffer data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GtfsRealtime.Position parseFrom(
                java.nio.ByteBuffer data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GtfsRealtime.Position parseFrom(
                com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GtfsRealtime.Position parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GtfsRealtime.Position parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GtfsRealtime.Position parseFrom(
                byte[] data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GtfsRealtime.Position parseFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }

        public static GtfsRealtime.Position parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static GtfsRealtime.Position parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input);
        }

        public static GtfsRealtime.Position parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static GtfsRealtime.Position parseFrom(
                com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }

        public static GtfsRealtime.Position parseFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        @java.lang.Override
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GtfsRealtime.Position prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }

        @java.lang.Override
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE
                    ? new Builder() : new Builder().mergeFrom(this);
        }

        @java.lang.Override
        protected Builder newBuilderForType(
                com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        /**
         * <pre>
         * A position.
         * </pre>
         * <p>
         * Protobuf type {@code transit_realtime.Position}
         */
        public static final class Builder extends
                com.google.protobuf.GeneratedMessageV3.ExtendableBuilder<
                        GtfsRealtime.Position, Builder> implements
                // @@protoc_insertion_point(builder_implements:transit_realtime.Position)
                GtfsRealtime.PositionOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
                return GtfsRealtime.internal_static_transit_realtime_Position_descriptor;
            }

            @java.lang.Override
            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internalGetFieldAccessorTable() {
                return GtfsRealtime.internal_static_transit_realtime_Position_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                GtfsRealtime.Position.class, GtfsRealtime.Position.Builder.class);
            }

            // Construct using GtfsRealtime.Position.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(
                    com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.GeneratedMessageV3
                        .alwaysUseFieldBuilders) {
                }
            }

            @java.lang.Override
            public Builder clear() {
                super.clear();
                latitude_ = 0F;
                bitField0_ = (bitField0_ & ~0x00000001);
                longitude_ = 0F;
                bitField0_ = (bitField0_ & ~0x00000002);
                bearing_ = 0F;
                bitField0_ = (bitField0_ & ~0x00000004);
                odometer_ = 0D;
                bitField0_ = (bitField0_ & ~0x00000008);
                speed_ = 0F;
                bitField0_ = (bitField0_ & ~0x00000010);
                return this;
            }

            @java.lang.Override
            public com.google.protobuf.Descriptors.Descriptor
            getDescriptorForType() {
                return GtfsRealtime.internal_static_transit_realtime_Position_descriptor;
            }

            @java.lang.Override
            public GtfsRealtime.Position getDefaultInstanceForType() {
                return GtfsRealtime.Position.getDefaultInstance();
            }

            @java.lang.Override
            public GtfsRealtime.Position build() {
                GtfsRealtime.Position result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            @java.lang.Override
            public GtfsRealtime.Position buildPartial() {
                GtfsRealtime.Position result = new GtfsRealtime.Position(this);
                int from_bitField0_ = bitField0_;
                int to_bitField0_ = 0;
                if (((from_bitField0_ & 0x00000001) != 0)) {
                    result.latitude_ = latitude_;
                    to_bitField0_ |= 0x00000001;
                }
                if (((from_bitField0_ & 0x00000002) != 0)) {
                    result.longitude_ = longitude_;
                    to_bitField0_ |= 0x00000002;
                }
                if (((from_bitField0_ & 0x00000004) != 0)) {
                    result.bearing_ = bearing_;
                    to_bitField0_ |= 0x00000004;
                }
                if (((from_bitField0_ & 0x00000008) != 0)) {
                    result.odometer_ = odometer_;
                    to_bitField0_ |= 0x00000008;
                }
                if (((from_bitField0_ & 0x00000010) != 0)) {
                    result.speed_ = speed_;
                    to_bitField0_ |= 0x00000010;
                }
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            @java.lang.Override
            public Builder clone() {
                return super.clone();
            }

            @java.lang.Override
            public Builder setField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return super.setField(field, value);
            }

            @java.lang.Override
            public Builder clearField(
                    com.google.protobuf.Descriptors.FieldDescriptor field) {
                return super.clearField(field);
            }

            @java.lang.Override
            public Builder clearOneof(
                    com.google.protobuf.Descriptors.OneofDescriptor oneof) {
                return super.clearOneof(oneof);
            }

            @java.lang.Override
            public Builder setRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    int index, java.lang.Object value) {
                return super.setRepeatedField(field, index, value);
            }

            @java.lang.Override
            public Builder addRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return super.addRepeatedField(field, value);
            }

            @java.lang.Override
            public <Type> Builder setExtension(
                    com.google.protobuf.GeneratedMessage.GeneratedExtension<
                            GtfsRealtime.Position, Type> extension,
                    Type value) {
                return super.setExtension(extension, value);
            }

            @java.lang.Override
            public <Type> Builder setExtension(
                    com.google.protobuf.GeneratedMessage.GeneratedExtension<
                            GtfsRealtime.Position, java.util.List<Type>> extension,
                    int index, Type value) {
                return super.setExtension(extension, index, value);
            }

            @java.lang.Override
            public <Type> Builder addExtension(
                    com.google.protobuf.GeneratedMessage.GeneratedExtension<
                            GtfsRealtime.Position, java.util.List<Type>> extension,
                    Type value) {
                return super.addExtension(extension, value);
            }

            @java.lang.Override
            public <Type> Builder clearExtension(
                    com.google.protobuf.GeneratedMessage.GeneratedExtension<
                            GtfsRealtime.Position, ?> extension) {
                return super.clearExtension(extension);
            }

            @java.lang.Override
            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof GtfsRealtime.Position) {
                    return mergeFrom((GtfsRealtime.Position) other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(GtfsRealtime.Position other) {
                if (other == GtfsRealtime.Position.getDefaultInstance()) return this;
                if (other.hasLatitude()) {
                    setLatitude(other.getLatitude());
                }
                if (other.hasLongitude()) {
                    setLongitude(other.getLongitude());
                }
                if (other.hasBearing()) {
                    setBearing(other.getBearing());
                }
                if (other.hasOdometer()) {
                    setOdometer(other.getOdometer());
                }
                if (other.hasSpeed()) {
                    setSpeed(other.getSpeed());
                }
                this.mergeExtensionFields(other);
                this.mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            @java.lang.Override
            public final boolean isInitialized() {
                if (!hasLatitude()) {
                    return false;
                }
                if (!hasLongitude()) {
                    return false;
                }
                if (!extensionsAreInitialized()) {
                    return false;
                }
                return true;
            }

            @java.lang.Override
            public Builder mergeFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                GtfsRealtime.Position parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (GtfsRealtime.Position) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private int bitField0_;

            private float latitude_;

            /**
             * <pre>
             * Degrees North, in the WGS-84 coordinate system.
             * </pre>
             *
             * <code>required float latitude = 1;</code>
             */
            public boolean hasLatitude() {
                return ((bitField0_ & 0x00000001) != 0);
            }

            /**
             * <pre>
             * Degrees North, in the WGS-84 coordinate system.
             * </pre>
             *
             * <code>required float latitude = 1;</code>
             */
            public float getLatitude() {
                return latitude_;
            }

            /**
             * <pre>
             * Degrees North, in the WGS-84 coordinate system.
             * </pre>
             *
             * <code>required float latitude = 1;</code>
             */
            public Builder setLatitude(float value) {
                bitField0_ |= 0x00000001;
                latitude_ = value;
                onChanged();
                return this;
            }

            /**
             * <pre>
             * Degrees North, in the WGS-84 coordinate system.
             * </pre>
             *
             * <code>required float latitude = 1;</code>
             */
            public Builder clearLatitude() {
                bitField0_ = (bitField0_ & ~0x00000001);
                latitude_ = 0F;
                onChanged();
                return this;
            }

            private float longitude_;

            /**
             * <pre>
             * Degrees East, in the WGS-84 coordinate system.
             * </pre>
             *
             * <code>required float longitude = 2;</code>
             */
            public boolean hasLongitude() {
                return ((bitField0_ & 0x00000002) != 0);
            }

            /**
             * <pre>
             * Degrees East, in the WGS-84 coordinate system.
             * </pre>
             *
             * <code>required float longitude = 2;</code>
             */
            public float getLongitude() {
                return longitude_;
            }

            /**
             * <pre>
             * Degrees East, in the WGS-84 coordinate system.
             * </pre>
             *
             * <code>required float longitude = 2;</code>
             */
            public Builder setLongitude(float value) {
                bitField0_ |= 0x00000002;
                longitude_ = value;
                onChanged();
                return this;
            }

            /**
             * <pre>
             * Degrees East, in the WGS-84 coordinate system.
             * </pre>
             *
             * <code>required float longitude = 2;</code>
             */
            public Builder clearLongitude() {
                bitField0_ = (bitField0_ & ~0x00000002);
                longitude_ = 0F;
                onChanged();
                return this;
            }

            private float bearing_;

            /**
             * <pre>
             * Bearing, in degrees, clockwise from North, i.e., 0 is North and 90 is East.
             * This can be the compass bearing, or the direction towards the next stop
             * or intermediate location.
             * This should not be direction deduced from the sequence of previous
             * positions, which can be computed from previous data.
             * </pre>
             *
             * <code>optional float bearing = 3;</code>
             */
            public boolean hasBearing() {
                return ((bitField0_ & 0x00000004) != 0);
            }

            /**
             * <pre>
             * Bearing, in degrees, clockwise from North, i.e., 0 is North and 90 is East.
             * This can be the compass bearing, or the direction towards the next stop
             * or intermediate location.
             * This should not be direction deduced from the sequence of previous
             * positions, which can be computed from previous data.
             * </pre>
             *
             * <code>optional float bearing = 3;</code>
             */
            public float getBearing() {
                return bearing_;
            }

            /**
             * <pre>
             * Bearing, in degrees, clockwise from North, i.e., 0 is North and 90 is East.
             * This can be the compass bearing, or the direction towards the next stop
             * or intermediate location.
             * This should not be direction deduced from the sequence of previous
             * positions, which can be computed from previous data.
             * </pre>
             *
             * <code>optional float bearing = 3;</code>
             */
            public Builder setBearing(float value) {
                bitField0_ |= 0x00000004;
                bearing_ = value;
                onChanged();
                return this;
            }

            /**
             * <pre>
             * Bearing, in degrees, clockwise from North, i.e., 0 is North and 90 is East.
             * This can be the compass bearing, or the direction towards the next stop
             * or intermediate location.
             * This should not be direction deduced from the sequence of previous
             * positions, which can be computed from previous data.
             * </pre>
             *
             * <code>optional float bearing = 3;</code>
             */
            public Builder clearBearing() {
                bitField0_ = (bitField0_ & ~0x00000004);
                bearing_ = 0F;
                onChanged();
                return this;
            }

            private double odometer_;

            /**
             * <pre>
             * Odometer value, in meters.
             * </pre>
             *
             * <code>optional double odometer = 4;</code>
             */
            public boolean hasOdometer() {
                return ((bitField0_ & 0x00000008) != 0);
            }

            /**
             * <pre>
             * Odometer value, in meters.
             * </pre>
             *
             * <code>optional double odometer = 4;</code>
             */
            public double getOdometer() {
                return odometer_;
            }

            /**
             * <pre>
             * Odometer value, in meters.
             * </pre>
             *
             * <code>optional double odometer = 4;</code>
             */
            public Builder setOdometer(double value) {
                bitField0_ |= 0x00000008;
                odometer_ = value;
                onChanged();
                return this;
            }

            /**
             * <pre>
             * Odometer value, in meters.
             * </pre>
             *
             * <code>optional double odometer = 4;</code>
             */
            public Builder clearOdometer() {
                bitField0_ = (bitField0_ & ~0x00000008);
                odometer_ = 0D;
                onChanged();
                return this;
            }

            private float speed_;

            /**
             * <pre>
             * Momentary speed measured by the vehicle, in meters per second.
             * </pre>
             *
             * <code>optional float speed = 5;</code>
             */
            public boolean hasSpeed() {
                return ((bitField0_ & 0x00000010) != 0);
            }

            /**
             * <pre>
             * Momentary speed measured by the vehicle, in meters per second.
             * </pre>
             *
             * <code>optional float speed = 5;</code>
             */
            public float getSpeed() {
                return speed_;
            }

            /**
             * <pre>
             * Momentary speed measured by the vehicle, in meters per second.
             * </pre>
             *
             * <code>optional float speed = 5;</code>
             */
            public Builder setSpeed(float value) {
                bitField0_ |= 0x00000010;
                speed_ = value;
                onChanged();
                return this;
            }

            /**
             * <pre>
             * Momentary speed measured by the vehicle, in meters per second.
             * </pre>
             *
             * <code>optional float speed = 5;</code>
             */
            public Builder clearSpeed() {
                bitField0_ = (bitField0_ & ~0x00000010);
                speed_ = 0F;
                onChanged();
                return this;
            }

            @java.lang.Override
            public final Builder setUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.setUnknownFields(unknownFields);
            }

            @java.lang.Override
            public final Builder mergeUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.mergeUnknownFields(unknownFields);
            }


            // @@protoc_insertion_point(builder_scope:transit_realtime.Position)
        }

        // @@protoc_insertion_point(class_scope:transit_realtime.Position)
        private static final GtfsRealtime.Position DEFAULT_INSTANCE;

        static {
            DEFAULT_INSTANCE = new GtfsRealtime.Position();
        }

        public static GtfsRealtime.Position getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        @java.lang.Deprecated
        public static final com.google.protobuf.Parser<Position>
                PARSER = new com.google.protobuf.AbstractParser<Position>() {
            @java.lang.Override
            public Position parsePartialFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return new Position(input, extensionRegistry);
            }
        };

        public static com.google.protobuf.Parser<Position> parser() {
            return PARSER;
        }

        @java.lang.Override
        public com.google.protobuf.Parser<Position> getParserForType() {
            return PARSER;
        }

        @java.lang.Override
        public GtfsRealtime.Position getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

    }

    public interface TripDescriptorOrBuilder extends
            // @@protoc_insertion_point(interface_extends:transit_realtime.TripDescriptor)
            com.google.protobuf.GeneratedMessageV3.
                    ExtendableMessageOrBuilder<TripDescriptor> {

        /**
         * <pre>
         * The trip_id from the GTFS feed that this selector refers to.
         * For non frequency-based trips, this field is enough to uniquely identify
         * the trip. For frequency-based trip, start_time and start_date might also be
         * necessary.
         * </pre>
         *
         * <code>optional string trip_id = 1;</code>
         */
        boolean hasTripId();

        /**
         * <pre>
         * The trip_id from the GTFS feed that this selector refers to.
         * For non frequency-based trips, this field is enough to uniquely identify
         * the trip. For frequency-based trip, start_time and start_date might also be
         * necessary.
         * </pre>
         *
         * <code>optional string trip_id = 1;</code>
         */
        java.lang.String getTripId();

        /**
         * <pre>
         * The trip_id from the GTFS feed that this selector refers to.
         * For non frequency-based trips, this field is enough to uniquely identify
         * the trip. For frequency-based trip, start_time and start_date might also be
         * necessary.
         * </pre>
         *
         * <code>optional string trip_id = 1;</code>
         */
        com.google.protobuf.ByteString
        getTripIdBytes();

        /**
         * <pre>
         * The route_id from the GTFS that this selector refers to.
         * </pre>
         *
         * <code>optional string route_id = 5;</code>
         */
        boolean hasRouteId();

        /**
         * <pre>
         * The route_id from the GTFS that this selector refers to.
         * </pre>
         *
         * <code>optional string route_id = 5;</code>
         */
        java.lang.String getRouteId();

        /**
         * <pre>
         * The route_id from the GTFS that this selector refers to.
         * </pre>
         *
         * <code>optional string route_id = 5;</code>
         */
        com.google.protobuf.ByteString
        getRouteIdBytes();

        /**
         * <pre>
         * The direction_id from the GTFS feed trips.txt file, indicating the
         * direction of travel for trips this selector refers to. This field is
         * still experimental, and subject to change. It may be formally adopted in
         * the future.
         * </pre>
         *
         * <code>optional uint32 direction_id = 6;</code>
         */
        boolean hasDirectionId();

        /**
         * <pre>
         * The direction_id from the GTFS feed trips.txt file, indicating the
         * direction of travel for trips this selector refers to. This field is
         * still experimental, and subject to change. It may be formally adopted in
         * the future.
         * </pre>
         *
         * <code>optional uint32 direction_id = 6;</code>
         */
        int getDirectionId();

        /**
         * <pre>
         * The initially scheduled start time of this trip instance.
         * When the trip_id corresponds to a non-frequency-based trip, this field
         * should either be omitted or be equal to the value in the GTFS feed. When
         * the trip_id corresponds to a frequency-based trip, the start_time must be
         * specified for trip updates and vehicle positions. If the trip corresponds
         * to exact_times=1 GTFS record, then start_time must be some multiple
         * (including zero) of headway_secs later than frequencies.txt start_time for
         * the corresponding time period. If the trip corresponds to exact_times=0,
         * then its start_time may be arbitrary, and is initially expected to be the
         * first departure of the trip. Once established, the start_time of this
         * frequency-based trip should be considered immutable, even if the first
         * departure time changes -- that time change may instead be reflected in a
         * StopTimeUpdate.
         * Format and semantics of the field is same as that of
         * GTFS/frequencies.txt/start_time, e.g., 11:15:35 or 25:15:35.
         * </pre>
         *
         * <code>optional string start_time = 2;</code>
         */
        boolean hasStartTime();

        /**
         * <pre>
         * The initially scheduled start time of this trip instance.
         * When the trip_id corresponds to a non-frequency-based trip, this field
         * should either be omitted or be equal to the value in the GTFS feed. When
         * the trip_id corresponds to a frequency-based trip, the start_time must be
         * specified for trip updates and vehicle positions. If the trip corresponds
         * to exact_times=1 GTFS record, then start_time must be some multiple
         * (including zero) of headway_secs later than frequencies.txt start_time for
         * the corresponding time period. If the trip corresponds to exact_times=0,
         * then its start_time may be arbitrary, and is initially expected to be the
         * first departure of the trip. Once established, the start_time of this
         * frequency-based trip should be considered immutable, even if the first
         * departure time changes -- that time change may instead be reflected in a
         * StopTimeUpdate.
         * Format and semantics of the field is same as that of
         * GTFS/frequencies.txt/start_time, e.g., 11:15:35 or 25:15:35.
         * </pre>
         *
         * <code>optional string start_time = 2;</code>
         */
        java.lang.String getStartTime();

        /**
         * <pre>
         * The initially scheduled start time of this trip instance.
         * When the trip_id corresponds to a non-frequency-based trip, this field
         * should either be omitted or be equal to the value in the GTFS feed. When
         * the trip_id corresponds to a frequency-based trip, the start_time must be
         * specified for trip updates and vehicle positions. If the trip corresponds
         * to exact_times=1 GTFS record, then start_time must be some multiple
         * (including zero) of headway_secs later than frequencies.txt start_time for
         * the corresponding time period. If the trip corresponds to exact_times=0,
         * then its start_time may be arbitrary, and is initially expected to be the
         * first departure of the trip. Once established, the start_time of this
         * frequency-based trip should be considered immutable, even if the first
         * departure time changes -- that time change may instead be reflected in a
         * StopTimeUpdate.
         * Format and semantics of the field is same as that of
         * GTFS/frequencies.txt/start_time, e.g., 11:15:35 or 25:15:35.
         * </pre>
         *
         * <code>optional string start_time = 2;</code>
         */
        com.google.protobuf.ByteString
        getStartTimeBytes();

        /**
         * <pre>
         * The scheduled start date of this trip instance.
         * Must be provided to disambiguate trips that are so late as to collide with
         * a scheduled trip on a next day. For example, for a train that departs 8:00
         * and 20:00 every day, and is 12 hours late, there would be two distinct
         * trips on the same time.
         * This field can be provided but is not mandatory for schedules in which such
         * collisions are impossible - for example, a service running on hourly
         * schedule where a vehicle that is one hour late is not considered to be
         * related to schedule anymore.
         * In YYYYMMDD format.
         * </pre>
         *
         * <code>optional string start_date = 3;</code>
         */
        boolean hasStartDate();

        /**
         * <pre>
         * The scheduled start date of this trip instance.
         * Must be provided to disambiguate trips that are so late as to collide with
         * a scheduled trip on a next day. For example, for a train that departs 8:00
         * and 20:00 every day, and is 12 hours late, there would be two distinct
         * trips on the same time.
         * This field can be provided but is not mandatory for schedules in which such
         * collisions are impossible - for example, a service running on hourly
         * schedule where a vehicle that is one hour late is not considered to be
         * related to schedule anymore.
         * In YYYYMMDD format.
         * </pre>
         *
         * <code>optional string start_date = 3;</code>
         */
        java.lang.String getStartDate();

        /**
         * <pre>
         * The scheduled start date of this trip instance.
         * Must be provided to disambiguate trips that are so late as to collide with
         * a scheduled trip on a next day. For example, for a train that departs 8:00
         * and 20:00 every day, and is 12 hours late, there would be two distinct
         * trips on the same time.
         * This field can be provided but is not mandatory for schedules in which such
         * collisions are impossible - for example, a service running on hourly
         * schedule where a vehicle that is one hour late is not considered to be
         * related to schedule anymore.
         * In YYYYMMDD format.
         * </pre>
         *
         * <code>optional string start_date = 3;</code>
         */
        com.google.protobuf.ByteString
        getStartDateBytes();

        /**
         * <code>optional .transit_realtime.TripDescriptor.ScheduleRelationship schedule_relationship = 4;</code>
         */
        boolean hasScheduleRelationship();

        /**
         * <code>optional .transit_realtime.TripDescriptor.ScheduleRelationship schedule_relationship = 4;</code>
         */
        GtfsRealtime.TripDescriptor.ScheduleRelationship getScheduleRelationship();
    }

    /**
     * <pre>
     * A descriptor that identifies an instance of a GTFS trip, or all instances of
     * a trip along a route.
     * - To specify a single trip instance, the trip_id (and if necessary,
     *   start_time) is set. If route_id is also set, then it should be same as one
     *   that the given trip corresponds to.
     * - To specify all the trips along a given route, only the route_id should be
     *   set. Note that if the trip_id is not known, then stop sequence ids in
     *   TripUpdate are not sufficient, and stop_ids must be provided as well. In
     *   addition, absolute arrival/departure times must be provided.
     * </pre>
     * <p>
     * Protobuf type {@code transit_realtime.TripDescriptor}
     */
    public static final class TripDescriptor extends
            com.google.protobuf.GeneratedMessageV3.ExtendableMessage<
                    TripDescriptor> implements
            // @@protoc_insertion_point(message_implements:transit_realtime.TripDescriptor)
            TripDescriptorOrBuilder {
        private static final long serialVersionUID = 0L;

        // Use TripDescriptor.newBuilder() to construct.
        private TripDescriptor(com.google.protobuf.GeneratedMessageV3.ExtendableBuilder<GtfsRealtime.TripDescriptor, ?> builder) {
            super(builder);
        }

        private TripDescriptor() {
            tripId_ = "";
            routeId_ = "";
            startTime_ = "";
            startDate_ = "";
            scheduleRelationship_ = 0;
        }

        @java.lang.Override
        @SuppressWarnings({"unused"})
        protected java.lang.Object newInstance(
                UnusedPrivateParameter unused) {
            return new TripDescriptor();
        }

        @java.lang.Override
        public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
            return this.unknownFields;
        }

        private TripDescriptor(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            if (extensionRegistry == null) {
                throw new java.lang.NullPointerException();
            }
            int mutable_bitField0_ = 0;
            com.google.protobuf.UnknownFieldSet.Builder unknownFields =
                    com.google.protobuf.UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        case 10: {
                            com.google.protobuf.ByteString bs = input.readBytes();
                            bitField0_ |= 0x00000001;
                            tripId_ = bs;
                            break;
                        }
                        case 18: {
                            com.google.protobuf.ByteString bs = input.readBytes();
                            bitField0_ |= 0x00000008;
                            startTime_ = bs;
                            break;
                        }
                        case 26: {
                            com.google.protobuf.ByteString bs = input.readBytes();
                            bitField0_ |= 0x00000010;
                            startDate_ = bs;
                            break;
                        }
                        case 32: {
                            int rawValue = input.readEnum();
                            @SuppressWarnings("deprecation")
                            GtfsRealtime.TripDescriptor.ScheduleRelationship value = GtfsRealtime.TripDescriptor.ScheduleRelationship.valueOf(rawValue);
                            if (value == null) {
                                unknownFields.mergeVarintField(4, rawValue);
                            } else {
                                bitField0_ |= 0x00000020;
                                scheduleRelationship_ = rawValue;
                            }
                            break;
                        }
                        case 42: {
                            com.google.protobuf.ByteString bs = input.readBytes();
                            bitField0_ |= 0x00000002;
                            routeId_ = bs;
                            break;
                        }
                        case 48: {
                            bitField0_ |= 0x00000004;
                            directionId_ = input.readUInt32();
                            break;
                        }
                        default: {
                            if (!parseUnknownField(
                                    input, unknownFields, extensionRegistry, tag)) {
                                done = true;
                            }
                            break;
                        }
                    }
                }
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (java.io.IOException e) {
                throw new com.google.protobuf.InvalidProtocolBufferException(
                        e).setUnfinishedMessage(this);
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return GtfsRealtime.internal_static_transit_realtime_TripDescriptor_descriptor;
        }

        @java.lang.Override
        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return GtfsRealtime.internal_static_transit_realtime_TripDescriptor_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            GtfsRealtime.TripDescriptor.class, GtfsRealtime.TripDescriptor.Builder.class);
        }

        /**
         * <pre>
         * The relation between this trip and the static schedule. If a trip is done
         * in accordance with temporary schedule, not reflected in GTFS, then it
         * shouldn't be marked as SCHEDULED, but likely as ADDED.
         * </pre>
         * <p>
         * Protobuf enum {@code transit_realtime.TripDescriptor.ScheduleRelationship}
         */
        public enum ScheduleRelationship
                implements com.google.protobuf.ProtocolMessageEnum {
            /**
             * <pre>
             * Trip that is running in accordance with its GTFS schedule, or is close
             * enough to the scheduled trip to be associated with it.
             * </pre>
             *
             * <code>SCHEDULED = 0;</code>
             */
            SCHEDULED(0),
            /**
             * <pre>
             * An extra trip that was added in addition to a running schedule, for
             * example, to replace a broken vehicle or to respond to sudden passenger
             * load.
             * </pre>
             *
             * <code>ADDED = 1;</code>
             */
            ADDED(1),
            /**
             * <pre>
             * A trip that is running with no schedule associated to it, for example, if
             * there is no schedule at all.
             * </pre>
             *
             * <code>UNSCHEDULED = 2;</code>
             */
            UNSCHEDULED(2),
            /**
             * <pre>
             * A trip that existed in the schedule but was removed.
             * </pre>
             *
             * <code>CANCELED = 3;</code>
             */
            CANCELED(3),
            ;

            /**
             * <pre>
             * Trip that is running in accordance with its GTFS schedule, or is close
             * enough to the scheduled trip to be associated with it.
             * </pre>
             *
             * <code>SCHEDULED = 0;</code>
             */
            public static final int SCHEDULED_VALUE = 0;
            /**
             * <pre>
             * An extra trip that was added in addition to a running schedule, for
             * example, to replace a broken vehicle or to respond to sudden passenger
             * load.
             * </pre>
             *
             * <code>ADDED = 1;</code>
             */
            public static final int ADDED_VALUE = 1;
            /**
             * <pre>
             * A trip that is running with no schedule associated to it, for example, if
             * there is no schedule at all.
             * </pre>
             *
             * <code>UNSCHEDULED = 2;</code>
             */
            public static final int UNSCHEDULED_VALUE = 2;
            /**
             * <pre>
             * A trip that existed in the schedule but was removed.
             * </pre>
             *
             * <code>CANCELED = 3;</code>
             */
            public static final int CANCELED_VALUE = 3;


            public final int getNumber() {
                return value;
            }

            /**
             * @deprecated Use {@link #forNumber(int)} instead.
             */
            @java.lang.Deprecated
            public static ScheduleRelationship valueOf(int value) {
                return forNumber(value);
            }

            public static ScheduleRelationship forNumber(int value) {
                switch (value) {
                    case 0:
                        return SCHEDULED;
                    case 1:
                        return ADDED;
                    case 2:
                        return UNSCHEDULED;
                    case 3:
                        return CANCELED;
                    default:
                        return null;
                }
            }

            public static com.google.protobuf.Internal.EnumLiteMap<ScheduleRelationship>
            internalGetValueMap() {
                return internalValueMap;
            }

            private static final com.google.protobuf.Internal.EnumLiteMap<
                    ScheduleRelationship> internalValueMap =
                    new com.google.protobuf.Internal.EnumLiteMap<ScheduleRelationship>() {
                        public ScheduleRelationship findValueByNumber(int number) {
                            return ScheduleRelationship.forNumber(number);
                        }
                    };

            public final com.google.protobuf.Descriptors.EnumValueDescriptor
            getValueDescriptor() {
                return getDescriptor().getValues().get(ordinal());
            }

            public final com.google.protobuf.Descriptors.EnumDescriptor
            getDescriptorForType() {
                return getDescriptor();
            }

            public static final com.google.protobuf.Descriptors.EnumDescriptor
            getDescriptor() {
                return GtfsRealtime.TripDescriptor.getDescriptor().getEnumTypes().get(0);
            }

            private static final ScheduleRelationship[] VALUES = values();

            public static ScheduleRelationship valueOf(
                    com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
                if (desc.getType() != getDescriptor()) {
                    throw new java.lang.IllegalArgumentException(
                            "EnumValueDescriptor is not for this type.");
                }
                return VALUES[desc.getIndex()];
            }

            private final int value;

            private ScheduleRelationship(int value) {
                this.value = value;
            }

            // @@protoc_insertion_point(enum_scope:transit_realtime.TripDescriptor.ScheduleRelationship)
        }

        private int bitField0_;
        public static final int TRIP_ID_FIELD_NUMBER = 1;
        private volatile java.lang.Object tripId_;

        /**
         * <pre>
         * The trip_id from the GTFS feed that this selector refers to.
         * For non frequency-based trips, this field is enough to uniquely identify
         * the trip. For frequency-based trip, start_time and start_date might also be
         * necessary.
         * </pre>
         *
         * <code>optional string trip_id = 1;</code>
         */
        public boolean hasTripId() {
            return ((bitField0_ & 0x00000001) != 0);
        }

        /**
         * <pre>
         * The trip_id from the GTFS feed that this selector refers to.
         * For non frequency-based trips, this field is enough to uniquely identify
         * the trip. For frequency-based trip, start_time and start_date might also be
         * necessary.
         * </pre>
         *
         * <code>optional string trip_id = 1;</code>
         */
        public java.lang.String getTripId() {
            java.lang.Object ref = tripId_;
            if (ref instanceof java.lang.String) {
                return (java.lang.String) ref;
            } else {
                com.google.protobuf.ByteString bs =
                        (com.google.protobuf.ByteString) ref;
                java.lang.String s = bs.toStringUtf8();
                if (bs.isValidUtf8()) {
                    tripId_ = s;
                }
                return s;
            }
        }

        /**
         * <pre>
         * The trip_id from the GTFS feed that this selector refers to.
         * For non frequency-based trips, this field is enough to uniquely identify
         * the trip. For frequency-based trip, start_time and start_date might also be
         * necessary.
         * </pre>
         *
         * <code>optional string trip_id = 1;</code>
         */
        public com.google.protobuf.ByteString
        getTripIdBytes() {
            java.lang.Object ref = tripId_;
            if (ref instanceof java.lang.String) {
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8(
                                (java.lang.String) ref);
                tripId_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        public static final int ROUTE_ID_FIELD_NUMBER = 5;
        private volatile java.lang.Object routeId_;

        /**
         * <pre>
         * The route_id from the GTFS that this selector refers to.
         * </pre>
         *
         * <code>optional string route_id = 5;</code>
         */
        public boolean hasRouteId() {
            return ((bitField0_ & 0x00000002) != 0);
        }

        /**
         * <pre>
         * The route_id from the GTFS that this selector refers to.
         * </pre>
         *
         * <code>optional string route_id = 5;</code>
         */
        public java.lang.String getRouteId() {
            java.lang.Object ref = routeId_;
            if (ref instanceof java.lang.String) {
                return (java.lang.String) ref;
            } else {
                com.google.protobuf.ByteString bs =
                        (com.google.protobuf.ByteString) ref;
                java.lang.String s = bs.toStringUtf8();
                if (bs.isValidUtf8()) {
                    routeId_ = s;
                }
                return s;
            }
        }

        /**
         * <pre>
         * The route_id from the GTFS that this selector refers to.
         * </pre>
         *
         * <code>optional string route_id = 5;</code>
         */
        public com.google.protobuf.ByteString
        getRouteIdBytes() {
            java.lang.Object ref = routeId_;
            if (ref instanceof java.lang.String) {
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8(
                                (java.lang.String) ref);
                routeId_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        public static final int DIRECTION_ID_FIELD_NUMBER = 6;
        private int directionId_;

        /**
         * <pre>
         * The direction_id from the GTFS feed trips.txt file, indicating the
         * direction of travel for trips this selector refers to. This field is
         * still experimental, and subject to change. It may be formally adopted in
         * the future.
         * </pre>
         *
         * <code>optional uint32 direction_id = 6;</code>
         */
        public boolean hasDirectionId() {
            return ((bitField0_ & 0x00000004) != 0);
        }

        /**
         * <pre>
         * The direction_id from the GTFS feed trips.txt file, indicating the
         * direction of travel for trips this selector refers to. This field is
         * still experimental, and subject to change. It may be formally adopted in
         * the future.
         * </pre>
         *
         * <code>optional uint32 direction_id = 6;</code>
         */
        public int getDirectionId() {
            return directionId_;
        }

        public static final int START_TIME_FIELD_NUMBER = 2;
        private volatile java.lang.Object startTime_;

        /**
         * <pre>
         * The initially scheduled start time of this trip instance.
         * When the trip_id corresponds to a non-frequency-based trip, this field
         * should either be omitted or be equal to the value in the GTFS feed. When
         * the trip_id corresponds to a frequency-based trip, the start_time must be
         * specified for trip updates and vehicle positions. If the trip corresponds
         * to exact_times=1 GTFS record, then start_time must be some multiple
         * (including zero) of headway_secs later than frequencies.txt start_time for
         * the corresponding time period. If the trip corresponds to exact_times=0,
         * then its start_time may be arbitrary, and is initially expected to be the
         * first departure of the trip. Once established, the start_time of this
         * frequency-based trip should be considered immutable, even if the first
         * departure time changes -- that time change may instead be reflected in a
         * StopTimeUpdate.
         * Format and semantics of the field is same as that of
         * GTFS/frequencies.txt/start_time, e.g., 11:15:35 or 25:15:35.
         * </pre>
         *
         * <code>optional string start_time = 2;</code>
         */
        public boolean hasStartTime() {
            return ((bitField0_ & 0x00000008) != 0);
        }

        /**
         * <pre>
         * The initially scheduled start time of this trip instance.
         * When the trip_id corresponds to a non-frequency-based trip, this field
         * should either be omitted or be equal to the value in the GTFS feed. When
         * the trip_id corresponds to a frequency-based trip, the start_time must be
         * specified for trip updates and vehicle positions. If the trip corresponds
         * to exact_times=1 GTFS record, then start_time must be some multiple
         * (including zero) of headway_secs later than frequencies.txt start_time for
         * the corresponding time period. If the trip corresponds to exact_times=0,
         * then its start_time may be arbitrary, and is initially expected to be the
         * first departure of the trip. Once established, the start_time of this
         * frequency-based trip should be considered immutable, even if the first
         * departure time changes -- that time change may instead be reflected in a
         * StopTimeUpdate.
         * Format and semantics of the field is same as that of
         * GTFS/frequencies.txt/start_time, e.g., 11:15:35 or 25:15:35.
         * </pre>
         *
         * <code>optional string start_time = 2;</code>
         */
        public java.lang.String getStartTime() {
            java.lang.Object ref = startTime_;
            if (ref instanceof java.lang.String) {
                return (java.lang.String) ref;
            } else {
                com.google.protobuf.ByteString bs =
                        (com.google.protobuf.ByteString) ref;
                java.lang.String s = bs.toStringUtf8();
                if (bs.isValidUtf8()) {
                    startTime_ = s;
                }
                return s;
            }
        }

        /**
         * <pre>
         * The initially scheduled start time of this trip instance.
         * When the trip_id corresponds to a non-frequency-based trip, this field
         * should either be omitted or be equal to the value in the GTFS feed. When
         * the trip_id corresponds to a frequency-based trip, the start_time must be
         * specified for trip updates and vehicle positions. If the trip corresponds
         * to exact_times=1 GTFS record, then start_time must be some multiple
         * (including zero) of headway_secs later than frequencies.txt start_time for
         * the corresponding time period. If the trip corresponds to exact_times=0,
         * then its start_time may be arbitrary, and is initially expected to be the
         * first departure of the trip. Once established, the start_time of this
         * frequency-based trip should be considered immutable, even if the first
         * departure time changes -- that time change may instead be reflected in a
         * StopTimeUpdate.
         * Format and semantics of the field is same as that of
         * GTFS/frequencies.txt/start_time, e.g., 11:15:35 or 25:15:35.
         * </pre>
         *
         * <code>optional string start_time = 2;</code>
         */
        public com.google.protobuf.ByteString
        getStartTimeBytes() {
            java.lang.Object ref = startTime_;
            if (ref instanceof java.lang.String) {
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8(
                                (java.lang.String) ref);
                startTime_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        public static final int START_DATE_FIELD_NUMBER = 3;
        private volatile java.lang.Object startDate_;

        /**
         * <pre>
         * The scheduled start date of this trip instance.
         * Must be provided to disambiguate trips that are so late as to collide with
         * a scheduled trip on a next day. For example, for a train that departs 8:00
         * and 20:00 every day, and is 12 hours late, there would be two distinct
         * trips on the same time.
         * This field can be provided but is not mandatory for schedules in which such
         * collisions are impossible - for example, a service running on hourly
         * schedule where a vehicle that is one hour late is not considered to be
         * related to schedule anymore.
         * In YYYYMMDD format.
         * </pre>
         *
         * <code>optional string start_date = 3;</code>
         */
        public boolean hasStartDate() {
            return ((bitField0_ & 0x00000010) != 0);
        }

        /**
         * <pre>
         * The scheduled start date of this trip instance.
         * Must be provided to disambiguate trips that are so late as to collide with
         * a scheduled trip on a next day. For example, for a train that departs 8:00
         * and 20:00 every day, and is 12 hours late, there would be two distinct
         * trips on the same time.
         * This field can be provided but is not mandatory for schedules in which such
         * collisions are impossible - for example, a service running on hourly
         * schedule where a vehicle that is one hour late is not considered to be
         * related to schedule anymore.
         * In YYYYMMDD format.
         * </pre>
         *
         * <code>optional string start_date = 3;</code>
         */
        public java.lang.String getStartDate() {
            java.lang.Object ref = startDate_;
            if (ref instanceof java.lang.String) {
                return (java.lang.String) ref;
            } else {
                com.google.protobuf.ByteString bs =
                        (com.google.protobuf.ByteString) ref;
                java.lang.String s = bs.toStringUtf8();
                if (bs.isValidUtf8()) {
                    startDate_ = s;
                }
                return s;
            }
        }

        /**
         * <pre>
         * The scheduled start date of this trip instance.
         * Must be provided to disambiguate trips that are so late as to collide with
         * a scheduled trip on a next day. For example, for a train that departs 8:00
         * and 20:00 every day, and is 12 hours late, there would be two distinct
         * trips on the same time.
         * This field can be provided but is not mandatory for schedules in which such
         * collisions are impossible - for example, a service running on hourly
         * schedule where a vehicle that is one hour late is not considered to be
         * related to schedule anymore.
         * In YYYYMMDD format.
         * </pre>
         *
         * <code>optional string start_date = 3;</code>
         */
        public com.google.protobuf.ByteString
        getStartDateBytes() {
            java.lang.Object ref = startDate_;
            if (ref instanceof java.lang.String) {
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8(
                                (java.lang.String) ref);
                startDate_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        public static final int SCHEDULE_RELATIONSHIP_FIELD_NUMBER = 4;
        private int scheduleRelationship_;

        /**
         * <code>optional .transit_realtime.TripDescriptor.ScheduleRelationship schedule_relationship = 4;</code>
         */
        public boolean hasScheduleRelationship() {
            return ((bitField0_ & 0x00000020) != 0);
        }

        /**
         * <code>optional .transit_realtime.TripDescriptor.ScheduleRelationship schedule_relationship = 4;</code>
         */
        public GtfsRealtime.TripDescriptor.ScheduleRelationship getScheduleRelationship() {
            @SuppressWarnings("deprecation")
            GtfsRealtime.TripDescriptor.ScheduleRelationship result = GtfsRealtime.TripDescriptor.ScheduleRelationship.valueOf(scheduleRelationship_);
            return result == null ? GtfsRealtime.TripDescriptor.ScheduleRelationship.SCHEDULED : result;
        }

        private byte memoizedIsInitialized = -1;

        @java.lang.Override
        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            if (!extensionsAreInitialized()) {
                memoizedIsInitialized = 0;
                return false;
            }
            memoizedIsInitialized = 1;
            return true;
        }

        @java.lang.Override
        public void writeTo(com.google.protobuf.CodedOutputStream output)
                throws java.io.IOException {
            com.google.protobuf.GeneratedMessageV3
                    .ExtendableMessage<GtfsRealtime.TripDescriptor>.ExtensionWriter
                    extensionWriter = newExtensionWriter();
            if (((bitField0_ & 0x00000001) != 0)) {
                com.google.protobuf.GeneratedMessageV3.writeString(output, 1, tripId_);
            }
            if (((bitField0_ & 0x00000008) != 0)) {
                com.google.protobuf.GeneratedMessageV3.writeString(output, 2, startTime_);
            }
            if (((bitField0_ & 0x00000010) != 0)) {
                com.google.protobuf.GeneratedMessageV3.writeString(output, 3, startDate_);
            }
            if (((bitField0_ & 0x00000020) != 0)) {
                output.writeEnum(4, scheduleRelationship_);
            }
            if (((bitField0_ & 0x00000002) != 0)) {
                com.google.protobuf.GeneratedMessageV3.writeString(output, 5, routeId_);
            }
            if (((bitField0_ & 0x00000004) != 0)) {
                output.writeUInt32(6, directionId_);
            }
            extensionWriter.writeUntil(2000, output);
            unknownFields.writeTo(output);
        }

        @java.lang.Override
        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            if (((bitField0_ & 0x00000001) != 0)) {
                size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, tripId_);
            }
            if (((bitField0_ & 0x00000008) != 0)) {
                size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, startTime_);
            }
            if (((bitField0_ & 0x00000010) != 0)) {
                size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, startDate_);
            }
            if (((bitField0_ & 0x00000020) != 0)) {
                size += com.google.protobuf.CodedOutputStream
                        .computeEnumSize(4, scheduleRelationship_);
            }
            if (((bitField0_ & 0x00000002) != 0)) {
                size += com.google.protobuf.GeneratedMessageV3.computeStringSize(5, routeId_);
            }
            if (((bitField0_ & 0x00000004) != 0)) {
                size += com.google.protobuf.CodedOutputStream
                        .computeUInt32Size(6, directionId_);
            }
            size += extensionsSerializedSize();
            size += unknownFields.getSerializedSize();
            memoizedSize = size;
            return size;
        }

        @java.lang.Override
        public boolean equals(final java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof GtfsRealtime.TripDescriptor)) {
                return super.equals(obj);
            }
            GtfsRealtime.TripDescriptor other = (GtfsRealtime.TripDescriptor) obj;

            if (hasTripId() != other.hasTripId()) return false;
            if (hasTripId()) {
                if (!getTripId()
                        .equals(other.getTripId())) return false;
            }
            if (hasRouteId() != other.hasRouteId()) return false;
            if (hasRouteId()) {
                if (!getRouteId()
                        .equals(other.getRouteId())) return false;
            }
            if (hasDirectionId() != other.hasDirectionId()) return false;
            if (hasDirectionId()) {
                if (getDirectionId()
                        != other.getDirectionId()) return false;
            }
            if (hasStartTime() != other.hasStartTime()) return false;
            if (hasStartTime()) {
                if (!getStartTime()
                        .equals(other.getStartTime())) return false;
            }
            if (hasStartDate() != other.hasStartDate()) return false;
            if (hasStartDate()) {
                if (!getStartDate()
                        .equals(other.getStartDate())) return false;
            }
            if (hasScheduleRelationship() != other.hasScheduleRelationship()) return false;
            if (hasScheduleRelationship()) {
                if (scheduleRelationship_ != other.scheduleRelationship_) return false;
            }
            if (!unknownFields.equals(other.unknownFields)) return false;
            if (!getExtensionFields().equals(other.getExtensionFields()))
                return false;
            return true;
        }

        @java.lang.Override
        public int hashCode() {
            if (memoizedHashCode != 0) {
                return memoizedHashCode;
            }
            int hash = 41;
            hash = (19 * hash) + getDescriptor().hashCode();
            if (hasTripId()) {
                hash = (37 * hash) + TRIP_ID_FIELD_NUMBER;
                hash = (53 * hash) + getTripId().hashCode();
            }
            if (hasRouteId()) {
                hash = (37 * hash) + ROUTE_ID_FIELD_NUMBER;
                hash = (53 * hash) + getRouteId().hashCode();
            }
            if (hasDirectionId()) {
                hash = (37 * hash) + DIRECTION_ID_FIELD_NUMBER;
                hash = (53 * hash) + getDirectionId();
            }
            if (hasStartTime()) {
                hash = (37 * hash) + START_TIME_FIELD_NUMBER;
                hash = (53 * hash) + getStartTime().hashCode();
            }
            if (hasStartDate()) {
                hash = (37 * hash) + START_DATE_FIELD_NUMBER;
                hash = (53 * hash) + getStartDate().hashCode();
            }
            if (hasScheduleRelationship()) {
                hash = (37 * hash) + SCHEDULE_RELATIONSHIP_FIELD_NUMBER;
                hash = (53 * hash) + scheduleRelationship_;
            }
            hash = hashFields(hash, getExtensionFields());
            hash = (29 * hash) + unknownFields.hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static GtfsRealtime.TripDescriptor parseFrom(
                java.nio.ByteBuffer data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GtfsRealtime.TripDescriptor parseFrom(
                java.nio.ByteBuffer data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GtfsRealtime.TripDescriptor parseFrom(
                com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GtfsRealtime.TripDescriptor parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GtfsRealtime.TripDescriptor parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GtfsRealtime.TripDescriptor parseFrom(
                byte[] data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GtfsRealtime.TripDescriptor parseFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }

        public static GtfsRealtime.TripDescriptor parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static GtfsRealtime.TripDescriptor parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input);
        }

        public static GtfsRealtime.TripDescriptor parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static GtfsRealtime.TripDescriptor parseFrom(
                com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }

        public static GtfsRealtime.TripDescriptor parseFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        @java.lang.Override
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GtfsRealtime.TripDescriptor prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }

        @java.lang.Override
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE
                    ? new Builder() : new Builder().mergeFrom(this);
        }

        @java.lang.Override
        protected Builder newBuilderForType(
                com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        /**
         * <pre>
         * A descriptor that identifies an instance of a GTFS trip, or all instances of
         * a trip along a route.
         * - To specify a single trip instance, the trip_id (and if necessary,
         *   start_time) is set. If route_id is also set, then it should be same as one
         *   that the given trip corresponds to.
         * - To specify all the trips along a given route, only the route_id should be
         *   set. Note that if the trip_id is not known, then stop sequence ids in
         *   TripUpdate are not sufficient, and stop_ids must be provided as well. In
         *   addition, absolute arrival/departure times must be provided.
         * </pre>
         * <p>
         * Protobuf type {@code transit_realtime.TripDescriptor}
         */
        public static final class Builder extends
                com.google.protobuf.GeneratedMessageV3.ExtendableBuilder<
                        GtfsRealtime.TripDescriptor, Builder> implements
                // @@protoc_insertion_point(builder_implements:transit_realtime.TripDescriptor)
                GtfsRealtime.TripDescriptorOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
                return GtfsRealtime.internal_static_transit_realtime_TripDescriptor_descriptor;
            }

            @java.lang.Override
            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internalGetFieldAccessorTable() {
                return GtfsRealtime.internal_static_transit_realtime_TripDescriptor_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                GtfsRealtime.TripDescriptor.class, GtfsRealtime.TripDescriptor.Builder.class);
            }

            // Construct using GtfsRealtime.TripDescriptor.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(
                    com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.GeneratedMessageV3
                        .alwaysUseFieldBuilders) {
                }
            }

            @java.lang.Override
            public Builder clear() {
                super.clear();
                tripId_ = "";
                bitField0_ = (bitField0_ & ~0x00000001);
                routeId_ = "";
                bitField0_ = (bitField0_ & ~0x00000002);
                directionId_ = 0;
                bitField0_ = (bitField0_ & ~0x00000004);
                startTime_ = "";
                bitField0_ = (bitField0_ & ~0x00000008);
                startDate_ = "";
                bitField0_ = (bitField0_ & ~0x00000010);
                scheduleRelationship_ = 0;
                bitField0_ = (bitField0_ & ~0x00000020);
                return this;
            }

            @java.lang.Override
            public com.google.protobuf.Descriptors.Descriptor
            getDescriptorForType() {
                return GtfsRealtime.internal_static_transit_realtime_TripDescriptor_descriptor;
            }

            @java.lang.Override
            public GtfsRealtime.TripDescriptor getDefaultInstanceForType() {
                return GtfsRealtime.TripDescriptor.getDefaultInstance();
            }

            @java.lang.Override
            public GtfsRealtime.TripDescriptor build() {
                GtfsRealtime.TripDescriptor result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            @java.lang.Override
            public GtfsRealtime.TripDescriptor buildPartial() {
                GtfsRealtime.TripDescriptor result = new GtfsRealtime.TripDescriptor(this);
                int from_bitField0_ = bitField0_;
                int to_bitField0_ = 0;
                if (((from_bitField0_ & 0x00000001) != 0)) {
                    to_bitField0_ |= 0x00000001;
                }
                result.tripId_ = tripId_;
                if (((from_bitField0_ & 0x00000002) != 0)) {
                    to_bitField0_ |= 0x00000002;
                }
                result.routeId_ = routeId_;
                if (((from_bitField0_ & 0x00000004) != 0)) {
                    result.directionId_ = directionId_;
                    to_bitField0_ |= 0x00000004;
                }
                if (((from_bitField0_ & 0x00000008) != 0)) {
                    to_bitField0_ |= 0x00000008;
                }
                result.startTime_ = startTime_;
                if (((from_bitField0_ & 0x00000010) != 0)) {
                    to_bitField0_ |= 0x00000010;
                }
                result.startDate_ = startDate_;
                if (((from_bitField0_ & 0x00000020) != 0)) {
                    to_bitField0_ |= 0x00000020;
                }
                result.scheduleRelationship_ = scheduleRelationship_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            @java.lang.Override
            public Builder clone() {
                return super.clone();
            }

            @java.lang.Override
            public Builder setField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return super.setField(field, value);
            }

            @java.lang.Override
            public Builder clearField(
                    com.google.protobuf.Descriptors.FieldDescriptor field) {
                return super.clearField(field);
            }

            @java.lang.Override
            public Builder clearOneof(
                    com.google.protobuf.Descriptors.OneofDescriptor oneof) {
                return super.clearOneof(oneof);
            }

            @java.lang.Override
            public Builder setRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    int index, java.lang.Object value) {
                return super.setRepeatedField(field, index, value);
            }

            @java.lang.Override
            public Builder addRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return super.addRepeatedField(field, value);
            }

            @java.lang.Override
            public <Type> Builder setExtension(
                    com.google.protobuf.GeneratedMessage.GeneratedExtension<
                            GtfsRealtime.TripDescriptor, Type> extension,
                    Type value) {
                return super.setExtension(extension, value);
            }

            @java.lang.Override
            public <Type> Builder setExtension(
                    com.google.protobuf.GeneratedMessage.GeneratedExtension<
                            GtfsRealtime.TripDescriptor, java.util.List<Type>> extension,
                    int index, Type value) {
                return super.setExtension(extension, index, value);
            }

            @java.lang.Override
            public <Type> Builder addExtension(
                    com.google.protobuf.GeneratedMessage.GeneratedExtension<
                            GtfsRealtime.TripDescriptor, java.util.List<Type>> extension,
                    Type value) {
                return super.addExtension(extension, value);
            }

            @java.lang.Override
            public <Type> Builder clearExtension(
                    com.google.protobuf.GeneratedMessage.GeneratedExtension<
                            GtfsRealtime.TripDescriptor, ?> extension) {
                return super.clearExtension(extension);
            }

            @java.lang.Override
            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof GtfsRealtime.TripDescriptor) {
                    return mergeFrom((GtfsRealtime.TripDescriptor) other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(GtfsRealtime.TripDescriptor other) {
                if (other == GtfsRealtime.TripDescriptor.getDefaultInstance()) return this;
                if (other.hasTripId()) {
                    bitField0_ |= 0x00000001;
                    tripId_ = other.tripId_;
                    onChanged();
                }
                if (other.hasRouteId()) {
                    bitField0_ |= 0x00000002;
                    routeId_ = other.routeId_;
                    onChanged();
                }
                if (other.hasDirectionId()) {
                    setDirectionId(other.getDirectionId());
                }
                if (other.hasStartTime()) {
                    bitField0_ |= 0x00000008;
                    startTime_ = other.startTime_;
                    onChanged();
                }
                if (other.hasStartDate()) {
                    bitField0_ |= 0x00000010;
                    startDate_ = other.startDate_;
                    onChanged();
                }
                if (other.hasScheduleRelationship()) {
                    setScheduleRelationship(other.getScheduleRelationship());
                }
                this.mergeExtensionFields(other);
                this.mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            @java.lang.Override
            public final boolean isInitialized() {
                if (!extensionsAreInitialized()) {
                    return false;
                }
                return true;
            }

            @java.lang.Override
            public Builder mergeFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                GtfsRealtime.TripDescriptor parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (GtfsRealtime.TripDescriptor) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private int bitField0_;

            private java.lang.Object tripId_ = "";

            /**
             * <pre>
             * The trip_id from the GTFS feed that this selector refers to.
             * For non frequency-based trips, this field is enough to uniquely identify
             * the trip. For frequency-based trip, start_time and start_date might also be
             * necessary.
             * </pre>
             *
             * <code>optional string trip_id = 1;</code>
             */
            public boolean hasTripId() {
                return ((bitField0_ & 0x00000001) != 0);
            }

            /**
             * <pre>
             * The trip_id from the GTFS feed that this selector refers to.
             * For non frequency-based trips, this field is enough to uniquely identify
             * the trip. For frequency-based trip, start_time and start_date might also be
             * necessary.
             * </pre>
             *
             * <code>optional string trip_id = 1;</code>
             */
            public java.lang.String getTripId() {
                java.lang.Object ref = tripId_;
                if (!(ref instanceof java.lang.String)) {
                    com.google.protobuf.ByteString bs =
                            (com.google.protobuf.ByteString) ref;
                    java.lang.String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        tripId_ = s;
                    }
                    return s;
                } else {
                    return (java.lang.String) ref;
                }
            }

            /**
             * <pre>
             * The trip_id from the GTFS feed that this selector refers to.
             * For non frequency-based trips, this field is enough to uniquely identify
             * the trip. For frequency-based trip, start_time and start_date might also be
             * necessary.
             * </pre>
             *
             * <code>optional string trip_id = 1;</code>
             */
            public com.google.protobuf.ByteString
            getTripIdBytes() {
                java.lang.Object ref = tripId_;
                if (ref instanceof String) {
                    com.google.protobuf.ByteString b =
                            com.google.protobuf.ByteString.copyFromUtf8(
                                    (java.lang.String) ref);
                    tripId_ = b;
                    return b;
                } else {
                    return (com.google.protobuf.ByteString) ref;
                }
            }

            /**
             * <pre>
             * The trip_id from the GTFS feed that this selector refers to.
             * For non frequency-based trips, this field is enough to uniquely identify
             * the trip. For frequency-based trip, start_time and start_date might also be
             * necessary.
             * </pre>
             *
             * <code>optional string trip_id = 1;</code>
             */
            public Builder setTripId(
                    java.lang.String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000001;
                tripId_ = value;
                onChanged();
                return this;
            }

            /**
             * <pre>
             * The trip_id from the GTFS feed that this selector refers to.
             * For non frequency-based trips, this field is enough to uniquely identify
             * the trip. For frequency-based trip, start_time and start_date might also be
             * necessary.
             * </pre>
             *
             * <code>optional string trip_id = 1;</code>
             */
            public Builder clearTripId() {
                bitField0_ = (bitField0_ & ~0x00000001);
                tripId_ = getDefaultInstance().getTripId();
                onChanged();
                return this;
            }

            /**
             * <pre>
             * The trip_id from the GTFS feed that this selector refers to.
             * For non frequency-based trips, this field is enough to uniquely identify
             * the trip. For frequency-based trip, start_time and start_date might also be
             * necessary.
             * </pre>
             *
             * <code>optional string trip_id = 1;</code>
             */
            public Builder setTripIdBytes(
                    com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000001;
                tripId_ = value;
                onChanged();
                return this;
            }

            private java.lang.Object routeId_ = "";

            /**
             * <pre>
             * The route_id from the GTFS that this selector refers to.
             * </pre>
             *
             * <code>optional string route_id = 5;</code>
             */
            public boolean hasRouteId() {
                return ((bitField0_ & 0x00000002) != 0);
            }

            /**
             * <pre>
             * The route_id from the GTFS that this selector refers to.
             * </pre>
             *
             * <code>optional string route_id = 5;</code>
             */
            public java.lang.String getRouteId() {
                java.lang.Object ref = routeId_;
                if (!(ref instanceof java.lang.String)) {
                    com.google.protobuf.ByteString bs =
                            (com.google.protobuf.ByteString) ref;
                    java.lang.String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        routeId_ = s;
                    }
                    return s;
                } else {
                    return (java.lang.String) ref;
                }
            }

            /**
             * <pre>
             * The route_id from the GTFS that this selector refers to.
             * </pre>
             *
             * <code>optional string route_id = 5;</code>
             */
            public com.google.protobuf.ByteString
            getRouteIdBytes() {
                java.lang.Object ref = routeId_;
                if (ref instanceof String) {
                    com.google.protobuf.ByteString b =
                            com.google.protobuf.ByteString.copyFromUtf8(
                                    (java.lang.String) ref);
                    routeId_ = b;
                    return b;
                } else {
                    return (com.google.protobuf.ByteString) ref;
                }
            }

            /**
             * <pre>
             * The route_id from the GTFS that this selector refers to.
             * </pre>
             *
             * <code>optional string route_id = 5;</code>
             */
            public Builder setRouteId(
                    java.lang.String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000002;
                routeId_ = value;
                onChanged();
                return this;
            }

            /**
             * <pre>
             * The route_id from the GTFS that this selector refers to.
             * </pre>
             *
             * <code>optional string route_id = 5;</code>
             */
            public Builder clearRouteId() {
                bitField0_ = (bitField0_ & ~0x00000002);
                routeId_ = getDefaultInstance().getRouteId();
                onChanged();
                return this;
            }

            /**
             * <pre>
             * The route_id from the GTFS that this selector refers to.
             * </pre>
             *
             * <code>optional string route_id = 5;</code>
             */
            public Builder setRouteIdBytes(
                    com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000002;
                routeId_ = value;
                onChanged();
                return this;
            }

            private int directionId_;

            /**
             * <pre>
             * The direction_id from the GTFS feed trips.txt file, indicating the
             * direction of travel for trips this selector refers to. This field is
             * still experimental, and subject to change. It may be formally adopted in
             * the future.
             * </pre>
             *
             * <code>optional uint32 direction_id = 6;</code>
             */
            public boolean hasDirectionId() {
                return ((bitField0_ & 0x00000004) != 0);
            }

            /**
             * <pre>
             * The direction_id from the GTFS feed trips.txt file, indicating the
             * direction of travel for trips this selector refers to. This field is
             * still experimental, and subject to change. It may be formally adopted in
             * the future.
             * </pre>
             *
             * <code>optional uint32 direction_id = 6;</code>
             */
            public int getDirectionId() {
                return directionId_;
            }

            /**
             * <pre>
             * The direction_id from the GTFS feed trips.txt file, indicating the
             * direction of travel for trips this selector refers to. This field is
             * still experimental, and subject to change. It may be formally adopted in
             * the future.
             * </pre>
             *
             * <code>optional uint32 direction_id = 6;</code>
             */
            public Builder setDirectionId(int value) {
                bitField0_ |= 0x00000004;
                directionId_ = value;
                onChanged();
                return this;
            }

            /**
             * <pre>
             * The direction_id from the GTFS feed trips.txt file, indicating the
             * direction of travel for trips this selector refers to. This field is
             * still experimental, and subject to change. It may be formally adopted in
             * the future.
             * </pre>
             *
             * <code>optional uint32 direction_id = 6;</code>
             */
            public Builder clearDirectionId() {
                bitField0_ = (bitField0_ & ~0x00000004);
                directionId_ = 0;
                onChanged();
                return this;
            }

            private java.lang.Object startTime_ = "";

            /**
             * <pre>
             * The initially scheduled start time of this trip instance.
             * When the trip_id corresponds to a non-frequency-based trip, this field
             * should either be omitted or be equal to the value in the GTFS feed. When
             * the trip_id corresponds to a frequency-based trip, the start_time must be
             * specified for trip updates and vehicle positions. If the trip corresponds
             * to exact_times=1 GTFS record, then start_time must be some multiple
             * (including zero) of headway_secs later than frequencies.txt start_time for
             * the corresponding time period. If the trip corresponds to exact_times=0,
             * then its start_time may be arbitrary, and is initially expected to be the
             * first departure of the trip. Once established, the start_time of this
             * frequency-based trip should be considered immutable, even if the first
             * departure time changes -- that time change may instead be reflected in a
             * StopTimeUpdate.
             * Format and semantics of the field is same as that of
             * GTFS/frequencies.txt/start_time, e.g., 11:15:35 or 25:15:35.
             * </pre>
             *
             * <code>optional string start_time = 2;</code>
             */
            public boolean hasStartTime() {
                return ((bitField0_ & 0x00000008) != 0);
            }

            /**
             * <pre>
             * The initially scheduled start time of this trip instance.
             * When the trip_id corresponds to a non-frequency-based trip, this field
             * should either be omitted or be equal to the value in the GTFS feed. When
             * the trip_id corresponds to a frequency-based trip, the start_time must be
             * specified for trip updates and vehicle positions. If the trip corresponds
             * to exact_times=1 GTFS record, then start_time must be some multiple
             * (including zero) of headway_secs later than frequencies.txt start_time for
             * the corresponding time period. If the trip corresponds to exact_times=0,
             * then its start_time may be arbitrary, and is initially expected to be the
             * first departure of the trip. Once established, the start_time of this
             * frequency-based trip should be considered immutable, even if the first
             * departure time changes -- that time change may instead be reflected in a
             * StopTimeUpdate.
             * Format and semantics of the field is same as that of
             * GTFS/frequencies.txt/start_time, e.g., 11:15:35 or 25:15:35.
             * </pre>
             *
             * <code>optional string start_time = 2;</code>
             */
            public java.lang.String getStartTime() {
                java.lang.Object ref = startTime_;
                if (!(ref instanceof java.lang.String)) {
                    com.google.protobuf.ByteString bs =
                            (com.google.protobuf.ByteString) ref;
                    java.lang.String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        startTime_ = s;
                    }
                    return s;
                } else {
                    return (java.lang.String) ref;
                }
            }

            /**
             * <pre>
             * The initially scheduled start time of this trip instance.
             * When the trip_id corresponds to a non-frequency-based trip, this field
             * should either be omitted or be equal to the value in the GTFS feed. When
             * the trip_id corresponds to a frequency-based trip, the start_time must be
             * specified for trip updates and vehicle positions. If the trip corresponds
             * to exact_times=1 GTFS record, then start_time must be some multiple
             * (including zero) of headway_secs later than frequencies.txt start_time for
             * the corresponding time period. If the trip corresponds to exact_times=0,
             * then its start_time may be arbitrary, and is initially expected to be the
             * first departure of the trip. Once established, the start_time of this
             * frequency-based trip should be considered immutable, even if the first
             * departure time changes -- that time change may instead be reflected in a
             * StopTimeUpdate.
             * Format and semantics of the field is same as that of
             * GTFS/frequencies.txt/start_time, e.g., 11:15:35 or 25:15:35.
             * </pre>
             *
             * <code>optional string start_time = 2;</code>
             */
            public com.google.protobuf.ByteString
            getStartTimeBytes() {
                java.lang.Object ref = startTime_;
                if (ref instanceof String) {
                    com.google.protobuf.ByteString b =
                            com.google.protobuf.ByteString.copyFromUtf8(
                                    (java.lang.String) ref);
                    startTime_ = b;
                    return b;
                } else {
                    return (com.google.protobuf.ByteString) ref;
                }
            }

            /**
             * <pre>
             * The initially scheduled start time of this trip instance.
             * When the trip_id corresponds to a non-frequency-based trip, this field
             * should either be omitted or be equal to the value in the GTFS feed. When
             * the trip_id corresponds to a frequency-based trip, the start_time must be
             * specified for trip updates and vehicle positions. If the trip corresponds
             * to exact_times=1 GTFS record, then start_time must be some multiple
             * (including zero) of headway_secs later than frequencies.txt start_time for
             * the corresponding time period. If the trip corresponds to exact_times=0,
             * then its start_time may be arbitrary, and is initially expected to be the
             * first departure of the trip. Once established, the start_time of this
             * frequency-based trip should be considered immutable, even if the first
             * departure time changes -- that time change may instead be reflected in a
             * StopTimeUpdate.
             * Format and semantics of the field is same as that of
             * GTFS/frequencies.txt/start_time, e.g., 11:15:35 or 25:15:35.
             * </pre>
             *
             * <code>optional string start_time = 2;</code>
             */
            public Builder setStartTime(
                    java.lang.String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000008;
                startTime_ = value;
                onChanged();
                return this;
            }

            /**
             * <pre>
             * The initially scheduled start time of this trip instance.
             * When the trip_id corresponds to a non-frequency-based trip, this field
             * should either be omitted or be equal to the value in the GTFS feed. When
             * the trip_id corresponds to a frequency-based trip, the start_time must be
             * specified for trip updates and vehicle positions. If the trip corresponds
             * to exact_times=1 GTFS record, then start_time must be some multiple
             * (including zero) of headway_secs later than frequencies.txt start_time for
             * the corresponding time period. If the trip corresponds to exact_times=0,
             * then its start_time may be arbitrary, and is initially expected to be the
             * first departure of the trip. Once established, the start_time of this
             * frequency-based trip should be considered immutable, even if the first
             * departure time changes -- that time change may instead be reflected in a
             * StopTimeUpdate.
             * Format and semantics of the field is same as that of
             * GTFS/frequencies.txt/start_time, e.g., 11:15:35 or 25:15:35.
             * </pre>
             *
             * <code>optional string start_time = 2;</code>
             */
            public Builder clearStartTime() {
                bitField0_ = (bitField0_ & ~0x00000008);
                startTime_ = getDefaultInstance().getStartTime();
                onChanged();
                return this;
            }

            /**
             * <pre>
             * The initially scheduled start time of this trip instance.
             * When the trip_id corresponds to a non-frequency-based trip, this field
             * should either be omitted or be equal to the value in the GTFS feed. When
             * the trip_id corresponds to a frequency-based trip, the start_time must be
             * specified for trip updates and vehicle positions. If the trip corresponds
             * to exact_times=1 GTFS record, then start_time must be some multiple
             * (including zero) of headway_secs later than frequencies.txt start_time for
             * the corresponding time period. If the trip corresponds to exact_times=0,
             * then its start_time may be arbitrary, and is initially expected to be the
             * first departure of the trip. Once established, the start_time of this
             * frequency-based trip should be considered immutable, even if the first
             * departure time changes -- that time change may instead be reflected in a
             * StopTimeUpdate.
             * Format and semantics of the field is same as that of
             * GTFS/frequencies.txt/start_time, e.g., 11:15:35 or 25:15:35.
             * </pre>
             *
             * <code>optional string start_time = 2;</code>
             */
            public Builder setStartTimeBytes(
                    com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000008;
                startTime_ = value;
                onChanged();
                return this;
            }

            private java.lang.Object startDate_ = "";

            /**
             * <pre>
             * The scheduled start date of this trip instance.
             * Must be provided to disambiguate trips that are so late as to collide with
             * a scheduled trip on a next day. For example, for a train that departs 8:00
             * and 20:00 every day, and is 12 hours late, there would be two distinct
             * trips on the same time.
             * This field can be provided but is not mandatory for schedules in which such
             * collisions are impossible - for example, a service running on hourly
             * schedule where a vehicle that is one hour late is not considered to be
             * related to schedule anymore.
             * In YYYYMMDD format.
             * </pre>
             *
             * <code>optional string start_date = 3;</code>
             */
            public boolean hasStartDate() {
                return ((bitField0_ & 0x00000010) != 0);
            }

            /**
             * <pre>
             * The scheduled start date of this trip instance.
             * Must be provided to disambiguate trips that are so late as to collide with
             * a scheduled trip on a next day. For example, for a train that departs 8:00
             * and 20:00 every day, and is 12 hours late, there would be two distinct
             * trips on the same time.
             * This field can be provided but is not mandatory for schedules in which such
             * collisions are impossible - for example, a service running on hourly
             * schedule where a vehicle that is one hour late is not considered to be
             * related to schedule anymore.
             * In YYYYMMDD format.
             * </pre>
             *
             * <code>optional string start_date = 3;</code>
             */
            public java.lang.String getStartDate() {
                java.lang.Object ref = startDate_;
                if (!(ref instanceof java.lang.String)) {
                    com.google.protobuf.ByteString bs =
                            (com.google.protobuf.ByteString) ref;
                    java.lang.String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        startDate_ = s;
                    }
                    return s;
                } else {
                    return (java.lang.String) ref;
                }
            }

            /**
             * <pre>
             * The scheduled start date of this trip instance.
             * Must be provided to disambiguate trips that are so late as to collide with
             * a scheduled trip on a next day. For example, for a train that departs 8:00
             * and 20:00 every day, and is 12 hours late, there would be two distinct
             * trips on the same time.
             * This field can be provided but is not mandatory for schedules in which such
             * collisions are impossible - for example, a service running on hourly
             * schedule where a vehicle that is one hour late is not considered to be
             * related to schedule anymore.
             * In YYYYMMDD format.
             * </pre>
             *
             * <code>optional string start_date = 3;</code>
             */
            public com.google.protobuf.ByteString
            getStartDateBytes() {
                java.lang.Object ref = startDate_;
                if (ref instanceof String) {
                    com.google.protobuf.ByteString b =
                            com.google.protobuf.ByteString.copyFromUtf8(
                                    (java.lang.String) ref);
                    startDate_ = b;
                    return b;
                } else {
                    return (com.google.protobuf.ByteString) ref;
                }
            }

            /**
             * <pre>
             * The scheduled start date of this trip instance.
             * Must be provided to disambiguate trips that are so late as to collide with
             * a scheduled trip on a next day. For example, for a train that departs 8:00
             * and 20:00 every day, and is 12 hours late, there would be two distinct
             * trips on the same time.
             * This field can be provided but is not mandatory for schedules in which such
             * collisions are impossible - for example, a service running on hourly
             * schedule where a vehicle that is one hour late is not considered to be
             * related to schedule anymore.
             * In YYYYMMDD format.
             * </pre>
             *
             * <code>optional string start_date = 3;</code>
             */
            public Builder setStartDate(
                    java.lang.String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000010;
                startDate_ = value;
                onChanged();
                return this;
            }

            /**
             * <pre>
             * The scheduled start date of this trip instance.
             * Must be provided to disambiguate trips that are so late as to collide with
             * a scheduled trip on a next day. For example, for a train that departs 8:00
             * and 20:00 every day, and is 12 hours late, there would be two distinct
             * trips on the same time.
             * This field can be provided but is not mandatory for schedules in which such
             * collisions are impossible - for example, a service running on hourly
             * schedule where a vehicle that is one hour late is not considered to be
             * related to schedule anymore.
             * In YYYYMMDD format.
             * </pre>
             *
             * <code>optional string start_date = 3;</code>
             */
            public Builder clearStartDate() {
                bitField0_ = (bitField0_ & ~0x00000010);
                startDate_ = getDefaultInstance().getStartDate();
                onChanged();
                return this;
            }

            /**
             * <pre>
             * The scheduled start date of this trip instance.
             * Must be provided to disambiguate trips that are so late as to collide with
             * a scheduled trip on a next day. For example, for a train that departs 8:00
             * and 20:00 every day, and is 12 hours late, there would be two distinct
             * trips on the same time.
             * This field can be provided but is not mandatory for schedules in which such
             * collisions are impossible - for example, a service running on hourly
             * schedule where a vehicle that is one hour late is not considered to be
             * related to schedule anymore.
             * In YYYYMMDD format.
             * </pre>
             *
             * <code>optional string start_date = 3;</code>
             */
            public Builder setStartDateBytes(
                    com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000010;
                startDate_ = value;
                onChanged();
                return this;
            }

            private int scheduleRelationship_ = 0;

            /**
             * <code>optional .transit_realtime.TripDescriptor.ScheduleRelationship schedule_relationship = 4;</code>
             */
            public boolean hasScheduleRelationship() {
                return ((bitField0_ & 0x00000020) != 0);
            }

            /**
             * <code>optional .transit_realtime.TripDescriptor.ScheduleRelationship schedule_relationship = 4;</code>
             */
            public GtfsRealtime.TripDescriptor.ScheduleRelationship getScheduleRelationship() {
                @SuppressWarnings("deprecation")
                GtfsRealtime.TripDescriptor.ScheduleRelationship result = GtfsRealtime.TripDescriptor.ScheduleRelationship.valueOf(scheduleRelationship_);
                return result == null ? GtfsRealtime.TripDescriptor.ScheduleRelationship.SCHEDULED : result;
            }

            /**
             * <code>optional .transit_realtime.TripDescriptor.ScheduleRelationship schedule_relationship = 4;</code>
             */
            public Builder setScheduleRelationship(GtfsRealtime.TripDescriptor.ScheduleRelationship value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000020;
                scheduleRelationship_ = value.getNumber();
                onChanged();
                return this;
            }

            /**
             * <code>optional .transit_realtime.TripDescriptor.ScheduleRelationship schedule_relationship = 4;</code>
             */
            public Builder clearScheduleRelationship() {
                bitField0_ = (bitField0_ & ~0x00000020);
                scheduleRelationship_ = 0;
                onChanged();
                return this;
            }

            @java.lang.Override
            public final Builder setUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.setUnknownFields(unknownFields);
            }

            @java.lang.Override
            public final Builder mergeUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.mergeUnknownFields(unknownFields);
            }


            // @@protoc_insertion_point(builder_scope:transit_realtime.TripDescriptor)
        }

        // @@protoc_insertion_point(class_scope:transit_realtime.TripDescriptor)
        private static final GtfsRealtime.TripDescriptor DEFAULT_INSTANCE;

        static {
            DEFAULT_INSTANCE = new GtfsRealtime.TripDescriptor();
        }

        public static GtfsRealtime.TripDescriptor getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        @java.lang.Deprecated
        public static final com.google.protobuf.Parser<TripDescriptor>
                PARSER = new com.google.protobuf.AbstractParser<TripDescriptor>() {
            @java.lang.Override
            public TripDescriptor parsePartialFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return new TripDescriptor(input, extensionRegistry);
            }
        };

        public static com.google.protobuf.Parser<TripDescriptor> parser() {
            return PARSER;
        }

        @java.lang.Override
        public com.google.protobuf.Parser<TripDescriptor> getParserForType() {
            return PARSER;
        }

        @java.lang.Override
        public GtfsRealtime.TripDescriptor getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

    }

    public interface VehicleDescriptorOrBuilder extends
            // @@protoc_insertion_point(interface_extends:transit_realtime.VehicleDescriptor)
            com.google.protobuf.GeneratedMessageV3.
                    ExtendableMessageOrBuilder<VehicleDescriptor> {

        /**
         * <pre>
         * Internal system identification of the vehicle. Should be unique per
         * vehicle, and can be used for tracking the vehicle as it proceeds through
         * the system.
         * </pre>
         *
         * <code>optional string id = 1;</code>
         */
        boolean hasId();

        /**
         * <pre>
         * Internal system identification of the vehicle. Should be unique per
         * vehicle, and can be used for tracking the vehicle as it proceeds through
         * the system.
         * </pre>
         *
         * <code>optional string id = 1;</code>
         */
        java.lang.String getId();

        /**
         * <pre>
         * Internal system identification of the vehicle. Should be unique per
         * vehicle, and can be used for tracking the vehicle as it proceeds through
         * the system.
         * </pre>
         *
         * <code>optional string id = 1;</code>
         */
        com.google.protobuf.ByteString
        getIdBytes();

        /**
         * <pre>
         * User visible label, i.e., something that must be shown to the passenger to
         * help identify the correct vehicle.
         * </pre>
         *
         * <code>optional string label = 2;</code>
         */
        boolean hasLabel();

        /**
         * <pre>
         * User visible label, i.e., something that must be shown to the passenger to
         * help identify the correct vehicle.
         * </pre>
         *
         * <code>optional string label = 2;</code>
         */
        java.lang.String getLabel();

        /**
         * <pre>
         * User visible label, i.e., something that must be shown to the passenger to
         * help identify the correct vehicle.
         * </pre>
         *
         * <code>optional string label = 2;</code>
         */
        com.google.protobuf.ByteString
        getLabelBytes();

        /**
         * <pre>
         * The license plate of the vehicle.
         * </pre>
         *
         * <code>optional string license_plate = 3;</code>
         */
        boolean hasLicensePlate();

        /**
         * <pre>
         * The license plate of the vehicle.
         * </pre>
         *
         * <code>optional string license_plate = 3;</code>
         */
        java.lang.String getLicensePlate();

        /**
         * <pre>
         * The license plate of the vehicle.
         * </pre>
         *
         * <code>optional string license_plate = 3;</code>
         */
        com.google.protobuf.ByteString
        getLicensePlateBytes();
    }

    /**
     * <pre>
     * Identification information for the vehicle performing the trip.
     * </pre>
     * <p>
     * Protobuf type {@code transit_realtime.VehicleDescriptor}
     */
    public static final class VehicleDescriptor extends
            com.google.protobuf.GeneratedMessageV3.ExtendableMessage<
                    VehicleDescriptor> implements
            // @@protoc_insertion_point(message_implements:transit_realtime.VehicleDescriptor)
            VehicleDescriptorOrBuilder {
        private static final long serialVersionUID = 0L;

        // Use VehicleDescriptor.newBuilder() to construct.
        private VehicleDescriptor(com.google.protobuf.GeneratedMessageV3.ExtendableBuilder<GtfsRealtime.VehicleDescriptor, ?> builder) {
            super(builder);
        }

        private VehicleDescriptor() {
            id_ = "";
            label_ = "";
            licensePlate_ = "";
        }

        @java.lang.Override
        @SuppressWarnings({"unused"})
        protected java.lang.Object newInstance(
                UnusedPrivateParameter unused) {
            return new VehicleDescriptor();
        }

        @java.lang.Override
        public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
            return this.unknownFields;
        }

        private VehicleDescriptor(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            if (extensionRegistry == null) {
                throw new java.lang.NullPointerException();
            }
            int mutable_bitField0_ = 0;
            com.google.protobuf.UnknownFieldSet.Builder unknownFields =
                    com.google.protobuf.UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        case 10: {
                            com.google.protobuf.ByteString bs = input.readBytes();
                            bitField0_ |= 0x00000001;
                            id_ = bs;
                            break;
                        }
                        case 18: {
                            com.google.protobuf.ByteString bs = input.readBytes();
                            bitField0_ |= 0x00000002;
                            label_ = bs;
                            break;
                        }
                        case 26: {
                            com.google.protobuf.ByteString bs = input.readBytes();
                            bitField0_ |= 0x00000004;
                            licensePlate_ = bs;
                            break;
                        }
                        default: {
                            if (!parseUnknownField(
                                    input, unknownFields, extensionRegistry, tag)) {
                                done = true;
                            }
                            break;
                        }
                    }
                }
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (java.io.IOException e) {
                throw new com.google.protobuf.InvalidProtocolBufferException(
                        e).setUnfinishedMessage(this);
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return GtfsRealtime.internal_static_transit_realtime_VehicleDescriptor_descriptor;
        }

        @java.lang.Override
        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return GtfsRealtime.internal_static_transit_realtime_VehicleDescriptor_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            GtfsRealtime.VehicleDescriptor.class, GtfsRealtime.VehicleDescriptor.Builder.class);
        }

        private int bitField0_;
        public static final int ID_FIELD_NUMBER = 1;
        private volatile java.lang.Object id_;

        /**
         * <pre>
         * Internal system identification of the vehicle. Should be unique per
         * vehicle, and can be used for tracking the vehicle as it proceeds through
         * the system.
         * </pre>
         *
         * <code>optional string id = 1;</code>
         */
        public boolean hasId() {
            return ((bitField0_ & 0x00000001) != 0);
        }

        /**
         * <pre>
         * Internal system identification of the vehicle. Should be unique per
         * vehicle, and can be used for tracking the vehicle as it proceeds through
         * the system.
         * </pre>
         *
         * <code>optional string id = 1;</code>
         */
        public java.lang.String getId() {
            java.lang.Object ref = id_;
            if (ref instanceof java.lang.String) {
                return (java.lang.String) ref;
            } else {
                com.google.protobuf.ByteString bs =
                        (com.google.protobuf.ByteString) ref;
                java.lang.String s = bs.toStringUtf8();
                if (bs.isValidUtf8()) {
                    id_ = s;
                }
                return s;
            }
        }

        /**
         * <pre>
         * Internal system identification of the vehicle. Should be unique per
         * vehicle, and can be used for tracking the vehicle as it proceeds through
         * the system.
         * </pre>
         *
         * <code>optional string id = 1;</code>
         */
        public com.google.protobuf.ByteString
        getIdBytes() {
            java.lang.Object ref = id_;
            if (ref instanceof java.lang.String) {
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8(
                                (java.lang.String) ref);
                id_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        public static final int LABEL_FIELD_NUMBER = 2;
        private volatile java.lang.Object label_;

        /**
         * <pre>
         * User visible label, i.e., something that must be shown to the passenger to
         * help identify the correct vehicle.
         * </pre>
         *
         * <code>optional string label = 2;</code>
         */
        public boolean hasLabel() {
            return ((bitField0_ & 0x00000002) != 0);
        }

        /**
         * <pre>
         * User visible label, i.e., something that must be shown to the passenger to
         * help identify the correct vehicle.
         * </pre>
         *
         * <code>optional string label = 2;</code>
         */
        public java.lang.String getLabel() {
            java.lang.Object ref = label_;
            if (ref instanceof java.lang.String) {
                return (java.lang.String) ref;
            } else {
                com.google.protobuf.ByteString bs =
                        (com.google.protobuf.ByteString) ref;
                java.lang.String s = bs.toStringUtf8();
                if (bs.isValidUtf8()) {
                    label_ = s;
                }
                return s;
            }
        }

        /**
         * <pre>
         * User visible label, i.e., something that must be shown to the passenger to
         * help identify the correct vehicle.
         * </pre>
         *
         * <code>optional string label = 2;</code>
         */
        public com.google.protobuf.ByteString
        getLabelBytes() {
            java.lang.Object ref = label_;
            if (ref instanceof java.lang.String) {
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8(
                                (java.lang.String) ref);
                label_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        public static final int LICENSE_PLATE_FIELD_NUMBER = 3;
        private volatile java.lang.Object licensePlate_;

        /**
         * <pre>
         * The license plate of the vehicle.
         * </pre>
         *
         * <code>optional string license_plate = 3;</code>
         */
        public boolean hasLicensePlate() {
            return ((bitField0_ & 0x00000004) != 0);
        }

        /**
         * <pre>
         * The license plate of the vehicle.
         * </pre>
         *
         * <code>optional string license_plate = 3;</code>
         */
        public java.lang.String getLicensePlate() {
            java.lang.Object ref = licensePlate_;
            if (ref instanceof java.lang.String) {
                return (java.lang.String) ref;
            } else {
                com.google.protobuf.ByteString bs =
                        (com.google.protobuf.ByteString) ref;
                java.lang.String s = bs.toStringUtf8();
                if (bs.isValidUtf8()) {
                    licensePlate_ = s;
                }
                return s;
            }
        }

        /**
         * <pre>
         * The license plate of the vehicle.
         * </pre>
         *
         * <code>optional string license_plate = 3;</code>
         */
        public com.google.protobuf.ByteString
        getLicensePlateBytes() {
            java.lang.Object ref = licensePlate_;
            if (ref instanceof java.lang.String) {
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8(
                                (java.lang.String) ref);
                licensePlate_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        private byte memoizedIsInitialized = -1;

        @java.lang.Override
        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            if (!extensionsAreInitialized()) {
                memoizedIsInitialized = 0;
                return false;
            }
            memoizedIsInitialized = 1;
            return true;
        }

        @java.lang.Override
        public void writeTo(com.google.protobuf.CodedOutputStream output)
                throws java.io.IOException {
            com.google.protobuf.GeneratedMessageV3
                    .ExtendableMessage<GtfsRealtime.VehicleDescriptor>.ExtensionWriter
                    extensionWriter = newExtensionWriter();
            if (((bitField0_ & 0x00000001) != 0)) {
                com.google.protobuf.GeneratedMessageV3.writeString(output, 1, id_);
            }
            if (((bitField0_ & 0x00000002) != 0)) {
                com.google.protobuf.GeneratedMessageV3.writeString(output, 2, label_);
            }
            if (((bitField0_ & 0x00000004) != 0)) {
                com.google.protobuf.GeneratedMessageV3.writeString(output, 3, licensePlate_);
            }
            extensionWriter.writeUntil(2000, output);
            unknownFields.writeTo(output);
        }

        @java.lang.Override
        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            if (((bitField0_ & 0x00000001) != 0)) {
                size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, id_);
            }
            if (((bitField0_ & 0x00000002) != 0)) {
                size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, label_);
            }
            if (((bitField0_ & 0x00000004) != 0)) {
                size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, licensePlate_);
            }
            size += extensionsSerializedSize();
            size += unknownFields.getSerializedSize();
            memoizedSize = size;
            return size;
        }

        @java.lang.Override
        public boolean equals(final java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof GtfsRealtime.VehicleDescriptor)) {
                return super.equals(obj);
            }
            GtfsRealtime.VehicleDescriptor other = (GtfsRealtime.VehicleDescriptor) obj;

            if (hasId() != other.hasId()) return false;
            if (hasId()) {
                if (!getId()
                        .equals(other.getId())) return false;
            }
            if (hasLabel() != other.hasLabel()) return false;
            if (hasLabel()) {
                if (!getLabel()
                        .equals(other.getLabel())) return false;
            }
            if (hasLicensePlate() != other.hasLicensePlate()) return false;
            if (hasLicensePlate()) {
                if (!getLicensePlate()
                        .equals(other.getLicensePlate())) return false;
            }
            if (!unknownFields.equals(other.unknownFields)) return false;
            if (!getExtensionFields().equals(other.getExtensionFields()))
                return false;
            return true;
        }

        @java.lang.Override
        public int hashCode() {
            if (memoizedHashCode != 0) {
                return memoizedHashCode;
            }
            int hash = 41;
            hash = (19 * hash) + getDescriptor().hashCode();
            if (hasId()) {
                hash = (37 * hash) + ID_FIELD_NUMBER;
                hash = (53 * hash) + getId().hashCode();
            }
            if (hasLabel()) {
                hash = (37 * hash) + LABEL_FIELD_NUMBER;
                hash = (53 * hash) + getLabel().hashCode();
            }
            if (hasLicensePlate()) {
                hash = (37 * hash) + LICENSE_PLATE_FIELD_NUMBER;
                hash = (53 * hash) + getLicensePlate().hashCode();
            }
            hash = hashFields(hash, getExtensionFields());
            hash = (29 * hash) + unknownFields.hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static GtfsRealtime.VehicleDescriptor parseFrom(
                java.nio.ByteBuffer data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GtfsRealtime.VehicleDescriptor parseFrom(
                java.nio.ByteBuffer data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GtfsRealtime.VehicleDescriptor parseFrom(
                com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GtfsRealtime.VehicleDescriptor parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GtfsRealtime.VehicleDescriptor parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GtfsRealtime.VehicleDescriptor parseFrom(
                byte[] data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GtfsRealtime.VehicleDescriptor parseFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }

        public static GtfsRealtime.VehicleDescriptor parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static GtfsRealtime.VehicleDescriptor parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input);
        }

        public static GtfsRealtime.VehicleDescriptor parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static GtfsRealtime.VehicleDescriptor parseFrom(
                com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }

        public static GtfsRealtime.VehicleDescriptor parseFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        @java.lang.Override
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GtfsRealtime.VehicleDescriptor prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }

        @java.lang.Override
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE
                    ? new Builder() : new Builder().mergeFrom(this);
        }

        @java.lang.Override
        protected Builder newBuilderForType(
                com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        /**
         * <pre>
         * Identification information for the vehicle performing the trip.
         * </pre>
         * <p>
         * Protobuf type {@code transit_realtime.VehicleDescriptor}
         */
        public static final class Builder extends
                com.google.protobuf.GeneratedMessageV3.ExtendableBuilder<
                        GtfsRealtime.VehicleDescriptor, Builder> implements
                // @@protoc_insertion_point(builder_implements:transit_realtime.VehicleDescriptor)
                GtfsRealtime.VehicleDescriptorOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
                return GtfsRealtime.internal_static_transit_realtime_VehicleDescriptor_descriptor;
            }

            @java.lang.Override
            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internalGetFieldAccessorTable() {
                return GtfsRealtime.internal_static_transit_realtime_VehicleDescriptor_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                GtfsRealtime.VehicleDescriptor.class, GtfsRealtime.VehicleDescriptor.Builder.class);
            }

            // Construct using GtfsRealtime.VehicleDescriptor.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(
                    com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.GeneratedMessageV3
                        .alwaysUseFieldBuilders) {
                }
            }

            @java.lang.Override
            public Builder clear() {
                super.clear();
                id_ = "";
                bitField0_ = (bitField0_ & ~0x00000001);
                label_ = "";
                bitField0_ = (bitField0_ & ~0x00000002);
                licensePlate_ = "";
                bitField0_ = (bitField0_ & ~0x00000004);
                return this;
            }

            @java.lang.Override
            public com.google.protobuf.Descriptors.Descriptor
            getDescriptorForType() {
                return GtfsRealtime.internal_static_transit_realtime_VehicleDescriptor_descriptor;
            }

            @java.lang.Override
            public GtfsRealtime.VehicleDescriptor getDefaultInstanceForType() {
                return GtfsRealtime.VehicleDescriptor.getDefaultInstance();
            }

            @java.lang.Override
            public GtfsRealtime.VehicleDescriptor build() {
                GtfsRealtime.VehicleDescriptor result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            @java.lang.Override
            public GtfsRealtime.VehicleDescriptor buildPartial() {
                GtfsRealtime.VehicleDescriptor result = new GtfsRealtime.VehicleDescriptor(this);
                int from_bitField0_ = bitField0_;
                int to_bitField0_ = 0;
                if (((from_bitField0_ & 0x00000001) != 0)) {
                    to_bitField0_ |= 0x00000001;
                }
                result.id_ = id_;
                if (((from_bitField0_ & 0x00000002) != 0)) {
                    to_bitField0_ |= 0x00000002;
                }
                result.label_ = label_;
                if (((from_bitField0_ & 0x00000004) != 0)) {
                    to_bitField0_ |= 0x00000004;
                }
                result.licensePlate_ = licensePlate_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            @java.lang.Override
            public Builder clone() {
                return super.clone();
            }

            @java.lang.Override
            public Builder setField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return super.setField(field, value);
            }

            @java.lang.Override
            public Builder clearField(
                    com.google.protobuf.Descriptors.FieldDescriptor field) {
                return super.clearField(field);
            }

            @java.lang.Override
            public Builder clearOneof(
                    com.google.protobuf.Descriptors.OneofDescriptor oneof) {
                return super.clearOneof(oneof);
            }

            @java.lang.Override
            public Builder setRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    int index, java.lang.Object value) {
                return super.setRepeatedField(field, index, value);
            }

            @java.lang.Override
            public Builder addRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return super.addRepeatedField(field, value);
            }

            @java.lang.Override
            public <Type> Builder setExtension(
                    com.google.protobuf.GeneratedMessage.GeneratedExtension<
                            GtfsRealtime.VehicleDescriptor, Type> extension,
                    Type value) {
                return super.setExtension(extension, value);
            }

            @java.lang.Override
            public <Type> Builder setExtension(
                    com.google.protobuf.GeneratedMessage.GeneratedExtension<
                            GtfsRealtime.VehicleDescriptor, java.util.List<Type>> extension,
                    int index, Type value) {
                return super.setExtension(extension, index, value);
            }

            @java.lang.Override
            public <Type> Builder addExtension(
                    com.google.protobuf.GeneratedMessage.GeneratedExtension<
                            GtfsRealtime.VehicleDescriptor, java.util.List<Type>> extension,
                    Type value) {
                return super.addExtension(extension, value);
            }

            @java.lang.Override
            public <Type> Builder clearExtension(
                    com.google.protobuf.GeneratedMessage.GeneratedExtension<
                            GtfsRealtime.VehicleDescriptor, ?> extension) {
                return super.clearExtension(extension);
            }

            @java.lang.Override
            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof GtfsRealtime.VehicleDescriptor) {
                    return mergeFrom((GtfsRealtime.VehicleDescriptor) other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(GtfsRealtime.VehicleDescriptor other) {
                if (other == GtfsRealtime.VehicleDescriptor.getDefaultInstance()) return this;
                if (other.hasId()) {
                    bitField0_ |= 0x00000001;
                    id_ = other.id_;
                    onChanged();
                }
                if (other.hasLabel()) {
                    bitField0_ |= 0x00000002;
                    label_ = other.label_;
                    onChanged();
                }
                if (other.hasLicensePlate()) {
                    bitField0_ |= 0x00000004;
                    licensePlate_ = other.licensePlate_;
                    onChanged();
                }
                this.mergeExtensionFields(other);
                this.mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            @java.lang.Override
            public final boolean isInitialized() {
                if (!extensionsAreInitialized()) {
                    return false;
                }
                return true;
            }

            @java.lang.Override
            public Builder mergeFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                GtfsRealtime.VehicleDescriptor parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (GtfsRealtime.VehicleDescriptor) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private int bitField0_;

            private java.lang.Object id_ = "";

            /**
             * <pre>
             * Internal system identification of the vehicle. Should be unique per
             * vehicle, and can be used for tracking the vehicle as it proceeds through
             * the system.
             * </pre>
             *
             * <code>optional string id = 1;</code>
             */
            public boolean hasId() {
                return ((bitField0_ & 0x00000001) != 0);
            }

            /**
             * <pre>
             * Internal system identification of the vehicle. Should be unique per
             * vehicle, and can be used for tracking the vehicle as it proceeds through
             * the system.
             * </pre>
             *
             * <code>optional string id = 1;</code>
             */
            public java.lang.String getId() {
                java.lang.Object ref = id_;
                if (!(ref instanceof java.lang.String)) {
                    com.google.protobuf.ByteString bs =
                            (com.google.protobuf.ByteString) ref;
                    java.lang.String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        id_ = s;
                    }
                    return s;
                } else {
                    return (java.lang.String) ref;
                }
            }

            /**
             * <pre>
             * Internal system identification of the vehicle. Should be unique per
             * vehicle, and can be used for tracking the vehicle as it proceeds through
             * the system.
             * </pre>
             *
             * <code>optional string id = 1;</code>
             */
            public com.google.protobuf.ByteString
            getIdBytes() {
                java.lang.Object ref = id_;
                if (ref instanceof String) {
                    com.google.protobuf.ByteString b =
                            com.google.protobuf.ByteString.copyFromUtf8(
                                    (java.lang.String) ref);
                    id_ = b;
                    return b;
                } else {
                    return (com.google.protobuf.ByteString) ref;
                }
            }

            /**
             * <pre>
             * Internal system identification of the vehicle. Should be unique per
             * vehicle, and can be used for tracking the vehicle as it proceeds through
             * the system.
             * </pre>
             *
             * <code>optional string id = 1;</code>
             */
            public Builder setId(
                    java.lang.String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000001;
                id_ = value;
                onChanged();
                return this;
            }

            /**
             * <pre>
             * Internal system identification of the vehicle. Should be unique per
             * vehicle, and can be used for tracking the vehicle as it proceeds through
             * the system.
             * </pre>
             *
             * <code>optional string id = 1;</code>
             */
            public Builder clearId() {
                bitField0_ = (bitField0_ & ~0x00000001);
                id_ = getDefaultInstance().getId();
                onChanged();
                return this;
            }

            /**
             * <pre>
             * Internal system identification of the vehicle. Should be unique per
             * vehicle, and can be used for tracking the vehicle as it proceeds through
             * the system.
             * </pre>
             *
             * <code>optional string id = 1;</code>
             */
            public Builder setIdBytes(
                    com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000001;
                id_ = value;
                onChanged();
                return this;
            }

            private java.lang.Object label_ = "";

            /**
             * <pre>
             * User visible label, i.e., something that must be shown to the passenger to
             * help identify the correct vehicle.
             * </pre>
             *
             * <code>optional string label = 2;</code>
             */
            public boolean hasLabel() {
                return ((bitField0_ & 0x00000002) != 0);
            }

            /**
             * <pre>
             * User visible label, i.e., something that must be shown to the passenger to
             * help identify the correct vehicle.
             * </pre>
             *
             * <code>optional string label = 2;</code>
             */
            public java.lang.String getLabel() {
                java.lang.Object ref = label_;
                if (!(ref instanceof java.lang.String)) {
                    com.google.protobuf.ByteString bs =
                            (com.google.protobuf.ByteString) ref;
                    java.lang.String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        label_ = s;
                    }
                    return s;
                } else {
                    return (java.lang.String) ref;
                }
            }

            /**
             * <pre>
             * User visible label, i.e., something that must be shown to the passenger to
             * help identify the correct vehicle.
             * </pre>
             *
             * <code>optional string label = 2;</code>
             */
            public com.google.protobuf.ByteString
            getLabelBytes() {
                java.lang.Object ref = label_;
                if (ref instanceof String) {
                    com.google.protobuf.ByteString b =
                            com.google.protobuf.ByteString.copyFromUtf8(
                                    (java.lang.String) ref);
                    label_ = b;
                    return b;
                } else {
                    return (com.google.protobuf.ByteString) ref;
                }
            }

            /**
             * <pre>
             * User visible label, i.e., something that must be shown to the passenger to
             * help identify the correct vehicle.
             * </pre>
             *
             * <code>optional string label = 2;</code>
             */
            public Builder setLabel(
                    java.lang.String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000002;
                label_ = value;
                onChanged();
                return this;
            }

            /**
             * <pre>
             * User visible label, i.e., something that must be shown to the passenger to
             * help identify the correct vehicle.
             * </pre>
             *
             * <code>optional string label = 2;</code>
             */
            public Builder clearLabel() {
                bitField0_ = (bitField0_ & ~0x00000002);
                label_ = getDefaultInstance().getLabel();
                onChanged();
                return this;
            }

            /**
             * <pre>
             * User visible label, i.e., something that must be shown to the passenger to
             * help identify the correct vehicle.
             * </pre>
             *
             * <code>optional string label = 2;</code>
             */
            public Builder setLabelBytes(
                    com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000002;
                label_ = value;
                onChanged();
                return this;
            }

            private java.lang.Object licensePlate_ = "";

            /**
             * <pre>
             * The license plate of the vehicle.
             * </pre>
             *
             * <code>optional string license_plate = 3;</code>
             */
            public boolean hasLicensePlate() {
                return ((bitField0_ & 0x00000004) != 0);
            }

            /**
             * <pre>
             * The license plate of the vehicle.
             * </pre>
             *
             * <code>optional string license_plate = 3;</code>
             */
            public java.lang.String getLicensePlate() {
                java.lang.Object ref = licensePlate_;
                if (!(ref instanceof java.lang.String)) {
                    com.google.protobuf.ByteString bs =
                            (com.google.protobuf.ByteString) ref;
                    java.lang.String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        licensePlate_ = s;
                    }
                    return s;
                } else {
                    return (java.lang.String) ref;
                }
            }

            /**
             * <pre>
             * The license plate of the vehicle.
             * </pre>
             *
             * <code>optional string license_plate = 3;</code>
             */
            public com.google.protobuf.ByteString
            getLicensePlateBytes() {
                java.lang.Object ref = licensePlate_;
                if (ref instanceof String) {
                    com.google.protobuf.ByteString b =
                            com.google.protobuf.ByteString.copyFromUtf8(
                                    (java.lang.String) ref);
                    licensePlate_ = b;
                    return b;
                } else {
                    return (com.google.protobuf.ByteString) ref;
                }
            }

            /**
             * <pre>
             * The license plate of the vehicle.
             * </pre>
             *
             * <code>optional string license_plate = 3;</code>
             */
            public Builder setLicensePlate(
                    java.lang.String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000004;
                licensePlate_ = value;
                onChanged();
                return this;
            }

            /**
             * <pre>
             * The license plate of the vehicle.
             * </pre>
             *
             * <code>optional string license_plate = 3;</code>
             */
            public Builder clearLicensePlate() {
                bitField0_ = (bitField0_ & ~0x00000004);
                licensePlate_ = getDefaultInstance().getLicensePlate();
                onChanged();
                return this;
            }

            /**
             * <pre>
             * The license plate of the vehicle.
             * </pre>
             *
             * <code>optional string license_plate = 3;</code>
             */
            public Builder setLicensePlateBytes(
                    com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000004;
                licensePlate_ = value;
                onChanged();
                return this;
            }

            @java.lang.Override
            public final Builder setUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.setUnknownFields(unknownFields);
            }

            @java.lang.Override
            public final Builder mergeUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.mergeUnknownFields(unknownFields);
            }


            // @@protoc_insertion_point(builder_scope:transit_realtime.VehicleDescriptor)
        }

        // @@protoc_insertion_point(class_scope:transit_realtime.VehicleDescriptor)
        private static final GtfsRealtime.VehicleDescriptor DEFAULT_INSTANCE;

        static {
            DEFAULT_INSTANCE = new GtfsRealtime.VehicleDescriptor();
        }

        public static GtfsRealtime.VehicleDescriptor getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        @java.lang.Deprecated
        public static final com.google.protobuf.Parser<VehicleDescriptor>
                PARSER = new com.google.protobuf.AbstractParser<VehicleDescriptor>() {
            @java.lang.Override
            public VehicleDescriptor parsePartialFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return new VehicleDescriptor(input, extensionRegistry);
            }
        };

        public static com.google.protobuf.Parser<VehicleDescriptor> parser() {
            return PARSER;
        }

        @java.lang.Override
        public com.google.protobuf.Parser<VehicleDescriptor> getParserForType() {
            return PARSER;
        }

        @java.lang.Override
        public GtfsRealtime.VehicleDescriptor getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

    }

    public interface EntitySelectorOrBuilder extends
            // @@protoc_insertion_point(interface_extends:transit_realtime.EntitySelector)
            com.google.protobuf.GeneratedMessageV3.
                    ExtendableMessageOrBuilder<EntitySelector> {

        /**
         * <pre>
         * The values of the fields should correspond to the appropriate fields in the
         * GTFS feed.
         * At least one specifier must be given. If several are given, then the
         * matching has to apply to all the given specifiers.
         * </pre>
         *
         * <code>optional string agency_id = 1;</code>
         */
        boolean hasAgencyId();

        /**
         * <pre>
         * The values of the fields should correspond to the appropriate fields in the
         * GTFS feed.
         * At least one specifier must be given. If several are given, then the
         * matching has to apply to all the given specifiers.
         * </pre>
         *
         * <code>optional string agency_id = 1;</code>
         */
        java.lang.String getAgencyId();

        /**
         * <pre>
         * The values of the fields should correspond to the appropriate fields in the
         * GTFS feed.
         * At least one specifier must be given. If several are given, then the
         * matching has to apply to all the given specifiers.
         * </pre>
         *
         * <code>optional string agency_id = 1;</code>
         */
        com.google.protobuf.ByteString
        getAgencyIdBytes();

        /**
         * <code>optional string route_id = 2;</code>
         */
        boolean hasRouteId();

        /**
         * <code>optional string route_id = 2;</code>
         */
        java.lang.String getRouteId();

        /**
         * <code>optional string route_id = 2;</code>
         */
        com.google.protobuf.ByteString
        getRouteIdBytes();

        /**
         * <pre>
         * corresponds to route_type in GTFS.
         * </pre>
         *
         * <code>optional int32 route_type = 3;</code>
         */
        boolean hasRouteType();

        /**
         * <pre>
         * corresponds to route_type in GTFS.
         * </pre>
         *
         * <code>optional int32 route_type = 3;</code>
         */
        int getRouteType();

        /**
         * <code>optional .transit_realtime.TripDescriptor trip = 4;</code>
         */
        boolean hasTrip();

        /**
         * <code>optional .transit_realtime.TripDescriptor trip = 4;</code>
         */
        GtfsRealtime.TripDescriptor getTrip();

        /**
         * <code>optional .transit_realtime.TripDescriptor trip = 4;</code>
         */
        GtfsRealtime.TripDescriptorOrBuilder getTripOrBuilder();

        /**
         * <code>optional string stop_id = 5;</code>
         */
        boolean hasStopId();

        /**
         * <code>optional string stop_id = 5;</code>
         */
        java.lang.String getStopId();

        /**
         * <code>optional string stop_id = 5;</code>
         */
        com.google.protobuf.ByteString
        getStopIdBytes();
    }

    /**
     * <pre>
     * A selector for an entity in a GTFS feed.
     * </pre>
     * <p>
     * Protobuf type {@code transit_realtime.EntitySelector}
     */
    public static final class EntitySelector extends
            com.google.protobuf.GeneratedMessageV3.ExtendableMessage<
                    EntitySelector> implements
            // @@protoc_insertion_point(message_implements:transit_realtime.EntitySelector)
            EntitySelectorOrBuilder {
        private static final long serialVersionUID = 0L;

        // Use EntitySelector.newBuilder() to construct.
        private EntitySelector(com.google.protobuf.GeneratedMessageV3.ExtendableBuilder<GtfsRealtime.EntitySelector, ?> builder) {
            super(builder);
        }

        private EntitySelector() {
            agencyId_ = "";
            routeId_ = "";
            stopId_ = "";
        }

        @java.lang.Override
        @SuppressWarnings({"unused"})
        protected java.lang.Object newInstance(
                UnusedPrivateParameter unused) {
            return new EntitySelector();
        }

        @java.lang.Override
        public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
            return this.unknownFields;
        }

        private EntitySelector(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            if (extensionRegistry == null) {
                throw new java.lang.NullPointerException();
            }
            int mutable_bitField0_ = 0;
            com.google.protobuf.UnknownFieldSet.Builder unknownFields =
                    com.google.protobuf.UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        case 10: {
                            com.google.protobuf.ByteString bs = input.readBytes();
                            bitField0_ |= 0x00000001;
                            agencyId_ = bs;
                            break;
                        }
                        case 18: {
                            com.google.protobuf.ByteString bs = input.readBytes();
                            bitField0_ |= 0x00000002;
                            routeId_ = bs;
                            break;
                        }
                        case 24: {
                            bitField0_ |= 0x00000004;
                            routeType_ = input.readInt32();
                            break;
                        }
                        case 34: {
                            GtfsRealtime.TripDescriptor.Builder subBuilder = null;
                            if (((bitField0_ & 0x00000008) != 0)) {
                                subBuilder = trip_.toBuilder();
                            }
                            trip_ = input.readMessage(GtfsRealtime.TripDescriptor.PARSER, extensionRegistry);
                            if (subBuilder != null) {
                                subBuilder.mergeFrom(trip_);
                                trip_ = subBuilder.buildPartial();
                            }
                            bitField0_ |= 0x00000008;
                            break;
                        }
                        case 42: {
                            com.google.protobuf.ByteString bs = input.readBytes();
                            bitField0_ |= 0x00000010;
                            stopId_ = bs;
                            break;
                        }
                        default: {
                            if (!parseUnknownField(
                                    input, unknownFields, extensionRegistry, tag)) {
                                done = true;
                            }
                            break;
                        }
                    }
                }
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (java.io.IOException e) {
                throw new com.google.protobuf.InvalidProtocolBufferException(
                        e).setUnfinishedMessage(this);
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return GtfsRealtime.internal_static_transit_realtime_EntitySelector_descriptor;
        }

        @java.lang.Override
        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return GtfsRealtime.internal_static_transit_realtime_EntitySelector_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            GtfsRealtime.EntitySelector.class, GtfsRealtime.EntitySelector.Builder.class);
        }

        private int bitField0_;
        public static final int AGENCY_ID_FIELD_NUMBER = 1;
        private volatile java.lang.Object agencyId_;

        /**
         * <pre>
         * The values of the fields should correspond to the appropriate fields in the
         * GTFS feed.
         * At least one specifier must be given. If several are given, then the
         * matching has to apply to all the given specifiers.
         * </pre>
         *
         * <code>optional string agency_id = 1;</code>
         */
        public boolean hasAgencyId() {
            return ((bitField0_ & 0x00000001) != 0);
        }

        /**
         * <pre>
         * The values of the fields should correspond to the appropriate fields in the
         * GTFS feed.
         * At least one specifier must be given. If several are given, then the
         * matching has to apply to all the given specifiers.
         * </pre>
         *
         * <code>optional string agency_id = 1;</code>
         */
        public java.lang.String getAgencyId() {
            java.lang.Object ref = agencyId_;
            if (ref instanceof java.lang.String) {
                return (java.lang.String) ref;
            } else {
                com.google.protobuf.ByteString bs =
                        (com.google.protobuf.ByteString) ref;
                java.lang.String s = bs.toStringUtf8();
                if (bs.isValidUtf8()) {
                    agencyId_ = s;
                }
                return s;
            }
        }

        /**
         * <pre>
         * The values of the fields should correspond to the appropriate fields in the
         * GTFS feed.
         * At least one specifier must be given. If several are given, then the
         * matching has to apply to all the given specifiers.
         * </pre>
         *
         * <code>optional string agency_id = 1;</code>
         */
        public com.google.protobuf.ByteString
        getAgencyIdBytes() {
            java.lang.Object ref = agencyId_;
            if (ref instanceof java.lang.String) {
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8(
                                (java.lang.String) ref);
                agencyId_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        public static final int ROUTE_ID_FIELD_NUMBER = 2;
        private volatile java.lang.Object routeId_;

        /**
         * <code>optional string route_id = 2;</code>
         */
        public boolean hasRouteId() {
            return ((bitField0_ & 0x00000002) != 0);
        }

        /**
         * <code>optional string route_id = 2;</code>
         */
        public java.lang.String getRouteId() {
            java.lang.Object ref = routeId_;
            if (ref instanceof java.lang.String) {
                return (java.lang.String) ref;
            } else {
                com.google.protobuf.ByteString bs =
                        (com.google.protobuf.ByteString) ref;
                java.lang.String s = bs.toStringUtf8();
                if (bs.isValidUtf8()) {
                    routeId_ = s;
                }
                return s;
            }
        }

        /**
         * <code>optional string route_id = 2;</code>
         */
        public com.google.protobuf.ByteString
        getRouteIdBytes() {
            java.lang.Object ref = routeId_;
            if (ref instanceof java.lang.String) {
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8(
                                (java.lang.String) ref);
                routeId_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        public static final int ROUTE_TYPE_FIELD_NUMBER = 3;
        private int routeType_;

        /**
         * <pre>
         * corresponds to route_type in GTFS.
         * </pre>
         *
         * <code>optional int32 route_type = 3;</code>
         */
        public boolean hasRouteType() {
            return ((bitField0_ & 0x00000004) != 0);
        }

        /**
         * <pre>
         * corresponds to route_type in GTFS.
         * </pre>
         *
         * <code>optional int32 route_type = 3;</code>
         */
        public int getRouteType() {
            return routeType_;
        }

        public static final int TRIP_FIELD_NUMBER = 4;
        private GtfsRealtime.TripDescriptor trip_;

        /**
         * <code>optional .transit_realtime.TripDescriptor trip = 4;</code>
         */
        public boolean hasTrip() {
            return ((bitField0_ & 0x00000008) != 0);
        }

        /**
         * <code>optional .transit_realtime.TripDescriptor trip = 4;</code>
         */
        public GtfsRealtime.TripDescriptor getTrip() {
            return trip_ == null ? GtfsRealtime.TripDescriptor.getDefaultInstance() : trip_;
        }

        /**
         * <code>optional .transit_realtime.TripDescriptor trip = 4;</code>
         */
        public GtfsRealtime.TripDescriptorOrBuilder getTripOrBuilder() {
            return trip_ == null ? GtfsRealtime.TripDescriptor.getDefaultInstance() : trip_;
        }

        public static final int STOP_ID_FIELD_NUMBER = 5;
        private volatile java.lang.Object stopId_;

        /**
         * <code>optional string stop_id = 5;</code>
         */
        public boolean hasStopId() {
            return ((bitField0_ & 0x00000010) != 0);
        }

        /**
         * <code>optional string stop_id = 5;</code>
         */
        public java.lang.String getStopId() {
            java.lang.Object ref = stopId_;
            if (ref instanceof java.lang.String) {
                return (java.lang.String) ref;
            } else {
                com.google.protobuf.ByteString bs =
                        (com.google.protobuf.ByteString) ref;
                java.lang.String s = bs.toStringUtf8();
                if (bs.isValidUtf8()) {
                    stopId_ = s;
                }
                return s;
            }
        }

        /**
         * <code>optional string stop_id = 5;</code>
         */
        public com.google.protobuf.ByteString
        getStopIdBytes() {
            java.lang.Object ref = stopId_;
            if (ref instanceof java.lang.String) {
                com.google.protobuf.ByteString b =
                        com.google.protobuf.ByteString.copyFromUtf8(
                                (java.lang.String) ref);
                stopId_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        private byte memoizedIsInitialized = -1;

        @java.lang.Override
        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            if (hasTrip()) {
                if (!getTrip().isInitialized()) {
                    memoizedIsInitialized = 0;
                    return false;
                }
            }
            if (!extensionsAreInitialized()) {
                memoizedIsInitialized = 0;
                return false;
            }
            memoizedIsInitialized = 1;
            return true;
        }

        @java.lang.Override
        public void writeTo(com.google.protobuf.CodedOutputStream output)
                throws java.io.IOException {
            com.google.protobuf.GeneratedMessageV3
                    .ExtendableMessage<GtfsRealtime.EntitySelector>.ExtensionWriter
                    extensionWriter = newExtensionWriter();
            if (((bitField0_ & 0x00000001) != 0)) {
                com.google.protobuf.GeneratedMessageV3.writeString(output, 1, agencyId_);
            }
            if (((bitField0_ & 0x00000002) != 0)) {
                com.google.protobuf.GeneratedMessageV3.writeString(output, 2, routeId_);
            }
            if (((bitField0_ & 0x00000004) != 0)) {
                output.writeInt32(3, routeType_);
            }
            if (((bitField0_ & 0x00000008) != 0)) {
                output.writeMessage(4, getTrip());
            }
            if (((bitField0_ & 0x00000010) != 0)) {
                com.google.protobuf.GeneratedMessageV3.writeString(output, 5, stopId_);
            }
            extensionWriter.writeUntil(2000, output);
            unknownFields.writeTo(output);
        }

        @java.lang.Override
        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            if (((bitField0_ & 0x00000001) != 0)) {
                size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, agencyId_);
            }
            if (((bitField0_ & 0x00000002) != 0)) {
                size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, routeId_);
            }
            if (((bitField0_ & 0x00000004) != 0)) {
                size += com.google.protobuf.CodedOutputStream
                        .computeInt32Size(3, routeType_);
            }
            if (((bitField0_ & 0x00000008) != 0)) {
                size += com.google.protobuf.CodedOutputStream
                        .computeMessageSize(4, getTrip());
            }
            if (((bitField0_ & 0x00000010) != 0)) {
                size += com.google.protobuf.GeneratedMessageV3.computeStringSize(5, stopId_);
            }
            size += extensionsSerializedSize();
            size += unknownFields.getSerializedSize();
            memoizedSize = size;
            return size;
        }

        @java.lang.Override
        public boolean equals(final java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof GtfsRealtime.EntitySelector)) {
                return super.equals(obj);
            }
            GtfsRealtime.EntitySelector other = (GtfsRealtime.EntitySelector) obj;

            if (hasAgencyId() != other.hasAgencyId()) return false;
            if (hasAgencyId()) {
                if (!getAgencyId()
                        .equals(other.getAgencyId())) return false;
            }
            if (hasRouteId() != other.hasRouteId()) return false;
            if (hasRouteId()) {
                if (!getRouteId()
                        .equals(other.getRouteId())) return false;
            }
            if (hasRouteType() != other.hasRouteType()) return false;
            if (hasRouteType()) {
                if (getRouteType()
                        != other.getRouteType()) return false;
            }
            if (hasTrip() != other.hasTrip()) return false;
            if (hasTrip()) {
                if (!getTrip()
                        .equals(other.getTrip())) return false;
            }
            if (hasStopId() != other.hasStopId()) return false;
            if (hasStopId()) {
                if (!getStopId()
                        .equals(other.getStopId())) return false;
            }
            if (!unknownFields.equals(other.unknownFields)) return false;
            if (!getExtensionFields().equals(other.getExtensionFields()))
                return false;
            return true;
        }

        @java.lang.Override
        public int hashCode() {
            if (memoizedHashCode != 0) {
                return memoizedHashCode;
            }
            int hash = 41;
            hash = (19 * hash) + getDescriptor().hashCode();
            if (hasAgencyId()) {
                hash = (37 * hash) + AGENCY_ID_FIELD_NUMBER;
                hash = (53 * hash) + getAgencyId().hashCode();
            }
            if (hasRouteId()) {
                hash = (37 * hash) + ROUTE_ID_FIELD_NUMBER;
                hash = (53 * hash) + getRouteId().hashCode();
            }
            if (hasRouteType()) {
                hash = (37 * hash) + ROUTE_TYPE_FIELD_NUMBER;
                hash = (53 * hash) + getRouteType();
            }
            if (hasTrip()) {
                hash = (37 * hash) + TRIP_FIELD_NUMBER;
                hash = (53 * hash) + getTrip().hashCode();
            }
            if (hasStopId()) {
                hash = (37 * hash) + STOP_ID_FIELD_NUMBER;
                hash = (53 * hash) + getStopId().hashCode();
            }
            hash = hashFields(hash, getExtensionFields());
            hash = (29 * hash) + unknownFields.hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static GtfsRealtime.EntitySelector parseFrom(
                java.nio.ByteBuffer data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GtfsRealtime.EntitySelector parseFrom(
                java.nio.ByteBuffer data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GtfsRealtime.EntitySelector parseFrom(
                com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GtfsRealtime.EntitySelector parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GtfsRealtime.EntitySelector parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GtfsRealtime.EntitySelector parseFrom(
                byte[] data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GtfsRealtime.EntitySelector parseFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }

        public static GtfsRealtime.EntitySelector parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static GtfsRealtime.EntitySelector parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input);
        }

        public static GtfsRealtime.EntitySelector parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static GtfsRealtime.EntitySelector parseFrom(
                com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }

        public static GtfsRealtime.EntitySelector parseFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        @java.lang.Override
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GtfsRealtime.EntitySelector prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }

        @java.lang.Override
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE
                    ? new Builder() : new Builder().mergeFrom(this);
        }

        @java.lang.Override
        protected Builder newBuilderForType(
                com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        /**
         * <pre>
         * A selector for an entity in a GTFS feed.
         * </pre>
         * <p>
         * Protobuf type {@code transit_realtime.EntitySelector}
         */
        public static final class Builder extends
                com.google.protobuf.GeneratedMessageV3.ExtendableBuilder<
                        GtfsRealtime.EntitySelector, Builder> implements
                // @@protoc_insertion_point(builder_implements:transit_realtime.EntitySelector)
                GtfsRealtime.EntitySelectorOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
                return GtfsRealtime.internal_static_transit_realtime_EntitySelector_descriptor;
            }

            @java.lang.Override
            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internalGetFieldAccessorTable() {
                return GtfsRealtime.internal_static_transit_realtime_EntitySelector_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                GtfsRealtime.EntitySelector.class, GtfsRealtime.EntitySelector.Builder.class);
            }

            // Construct using GtfsRealtime.EntitySelector.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(
                    com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.GeneratedMessageV3
                        .alwaysUseFieldBuilders) {
                    getTripFieldBuilder();
                }
            }

            @java.lang.Override
            public Builder clear() {
                super.clear();
                agencyId_ = "";
                bitField0_ = (bitField0_ & ~0x00000001);
                routeId_ = "";
                bitField0_ = (bitField0_ & ~0x00000002);
                routeType_ = 0;
                bitField0_ = (bitField0_ & ~0x00000004);
                if (tripBuilder_ == null) {
                    trip_ = null;
                } else {
                    tripBuilder_.clear();
                }
                bitField0_ = (bitField0_ & ~0x00000008);
                stopId_ = "";
                bitField0_ = (bitField0_ & ~0x00000010);
                return this;
            }

            @java.lang.Override
            public com.google.protobuf.Descriptors.Descriptor
            getDescriptorForType() {
                return GtfsRealtime.internal_static_transit_realtime_EntitySelector_descriptor;
            }

            @java.lang.Override
            public GtfsRealtime.EntitySelector getDefaultInstanceForType() {
                return GtfsRealtime.EntitySelector.getDefaultInstance();
            }

            @java.lang.Override
            public GtfsRealtime.EntitySelector build() {
                GtfsRealtime.EntitySelector result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            @java.lang.Override
            public GtfsRealtime.EntitySelector buildPartial() {
                GtfsRealtime.EntitySelector result = new GtfsRealtime.EntitySelector(this);
                int from_bitField0_ = bitField0_;
                int to_bitField0_ = 0;
                if (((from_bitField0_ & 0x00000001) != 0)) {
                    to_bitField0_ |= 0x00000001;
                }
                result.agencyId_ = agencyId_;
                if (((from_bitField0_ & 0x00000002) != 0)) {
                    to_bitField0_ |= 0x00000002;
                }
                result.routeId_ = routeId_;
                if (((from_bitField0_ & 0x00000004) != 0)) {
                    result.routeType_ = routeType_;
                    to_bitField0_ |= 0x00000004;
                }
                if (((from_bitField0_ & 0x00000008) != 0)) {
                    if (tripBuilder_ == null) {
                        result.trip_ = trip_;
                    } else {
                        result.trip_ = tripBuilder_.build();
                    }
                    to_bitField0_ |= 0x00000008;
                }
                if (((from_bitField0_ & 0x00000010) != 0)) {
                    to_bitField0_ |= 0x00000010;
                }
                result.stopId_ = stopId_;
                result.bitField0_ = to_bitField0_;
                onBuilt();
                return result;
            }

            @java.lang.Override
            public Builder clone() {
                return super.clone();
            }

            @java.lang.Override
            public Builder setField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return super.setField(field, value);
            }

            @java.lang.Override
            public Builder clearField(
                    com.google.protobuf.Descriptors.FieldDescriptor field) {
                return super.clearField(field);
            }

            @java.lang.Override
            public Builder clearOneof(
                    com.google.protobuf.Descriptors.OneofDescriptor oneof) {
                return super.clearOneof(oneof);
            }

            @java.lang.Override
            public Builder setRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    int index, java.lang.Object value) {
                return super.setRepeatedField(field, index, value);
            }

            @java.lang.Override
            public Builder addRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return super.addRepeatedField(field, value);
            }

            @java.lang.Override
            public <Type> Builder setExtension(
                    com.google.protobuf.GeneratedMessage.GeneratedExtension<
                            GtfsRealtime.EntitySelector, Type> extension,
                    Type value) {
                return super.setExtension(extension, value);
            }

            @java.lang.Override
            public <Type> Builder setExtension(
                    com.google.protobuf.GeneratedMessage.GeneratedExtension<
                            GtfsRealtime.EntitySelector, java.util.List<Type>> extension,
                    int index, Type value) {
                return super.setExtension(extension, index, value);
            }

            @java.lang.Override
            public <Type> Builder addExtension(
                    com.google.protobuf.GeneratedMessage.GeneratedExtension<
                            GtfsRealtime.EntitySelector, java.util.List<Type>> extension,
                    Type value) {
                return super.addExtension(extension, value);
            }

            @java.lang.Override
            public <Type> Builder clearExtension(
                    com.google.protobuf.GeneratedMessage.GeneratedExtension<
                            GtfsRealtime.EntitySelector, ?> extension) {
                return super.clearExtension(extension);
            }

            @java.lang.Override
            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof GtfsRealtime.EntitySelector) {
                    return mergeFrom((GtfsRealtime.EntitySelector) other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(GtfsRealtime.EntitySelector other) {
                if (other == GtfsRealtime.EntitySelector.getDefaultInstance()) return this;
                if (other.hasAgencyId()) {
                    bitField0_ |= 0x00000001;
                    agencyId_ = other.agencyId_;
                    onChanged();
                }
                if (other.hasRouteId()) {
                    bitField0_ |= 0x00000002;
                    routeId_ = other.routeId_;
                    onChanged();
                }
                if (other.hasRouteType()) {
                    setRouteType(other.getRouteType());
                }
                if (other.hasTrip()) {
                    mergeTrip(other.getTrip());
                }
                if (other.hasStopId()) {
                    bitField0_ |= 0x00000010;
                    stopId_ = other.stopId_;
                    onChanged();
                }
                this.mergeExtensionFields(other);
                this.mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            @java.lang.Override
            public final boolean isInitialized() {
                if (hasTrip()) {
                    if (!getTrip().isInitialized()) {
                        return false;
                    }
                }
                if (!extensionsAreInitialized()) {
                    return false;
                }
                return true;
            }

            @java.lang.Override
            public Builder mergeFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                GtfsRealtime.EntitySelector parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (GtfsRealtime.EntitySelector) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private int bitField0_;

            private java.lang.Object agencyId_ = "";

            /**
             * <pre>
             * The values of the fields should correspond to the appropriate fields in the
             * GTFS feed.
             * At least one specifier must be given. If several are given, then the
             * matching has to apply to all the given specifiers.
             * </pre>
             *
             * <code>optional string agency_id = 1;</code>
             */
            public boolean hasAgencyId() {
                return ((bitField0_ & 0x00000001) != 0);
            }

            /**
             * <pre>
             * The values of the fields should correspond to the appropriate fields in the
             * GTFS feed.
             * At least one specifier must be given. If several are given, then the
             * matching has to apply to all the given specifiers.
             * </pre>
             *
             * <code>optional string agency_id = 1;</code>
             */
            public java.lang.String getAgencyId() {
                java.lang.Object ref = agencyId_;
                if (!(ref instanceof java.lang.String)) {
                    com.google.protobuf.ByteString bs =
                            (com.google.protobuf.ByteString) ref;
                    java.lang.String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        agencyId_ = s;
                    }
                    return s;
                } else {
                    return (java.lang.String) ref;
                }
            }

            /**
             * <pre>
             * The values of the fields should correspond to the appropriate fields in the
             * GTFS feed.
             * At least one specifier must be given. If several are given, then the
             * matching has to apply to all the given specifiers.
             * </pre>
             *
             * <code>optional string agency_id = 1;</code>
             */
            public com.google.protobuf.ByteString
            getAgencyIdBytes() {
                java.lang.Object ref = agencyId_;
                if (ref instanceof String) {
                    com.google.protobuf.ByteString b =
                            com.google.protobuf.ByteString.copyFromUtf8(
                                    (java.lang.String) ref);
                    agencyId_ = b;
                    return b;
                } else {
                    return (com.google.protobuf.ByteString) ref;
                }
            }

            /**
             * <pre>
             * The values of the fields should correspond to the appropriate fields in the
             * GTFS feed.
             * At least one specifier must be given. If several are given, then the
             * matching has to apply to all the given specifiers.
             * </pre>
             *
             * <code>optional string agency_id = 1;</code>
             */
            public Builder setAgencyId(
                    java.lang.String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000001;
                agencyId_ = value;
                onChanged();
                return this;
            }

            /**
             * <pre>
             * The values of the fields should correspond to the appropriate fields in the
             * GTFS feed.
             * At least one specifier must be given. If several are given, then the
             * matching has to apply to all the given specifiers.
             * </pre>
             *
             * <code>optional string agency_id = 1;</code>
             */
            public Builder clearAgencyId() {
                bitField0_ = (bitField0_ & ~0x00000001);
                agencyId_ = getDefaultInstance().getAgencyId();
                onChanged();
                return this;
            }

            /**
             * <pre>
             * The values of the fields should correspond to the appropriate fields in the
             * GTFS feed.
             * At least one specifier must be given. If several are given, then the
             * matching has to apply to all the given specifiers.
             * </pre>
             *
             * <code>optional string agency_id = 1;</code>
             */
            public Builder setAgencyIdBytes(
                    com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000001;
                agencyId_ = value;
                onChanged();
                return this;
            }

            private java.lang.Object routeId_ = "";

            /**
             * <code>optional string route_id = 2;</code>
             */
            public boolean hasRouteId() {
                return ((bitField0_ & 0x00000002) != 0);
            }

            /**
             * <code>optional string route_id = 2;</code>
             */
            public java.lang.String getRouteId() {
                java.lang.Object ref = routeId_;
                if (!(ref instanceof java.lang.String)) {
                    com.google.protobuf.ByteString bs =
                            (com.google.protobuf.ByteString) ref;
                    java.lang.String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        routeId_ = s;
                    }
                    return s;
                } else {
                    return (java.lang.String) ref;
                }
            }

            /**
             * <code>optional string route_id = 2;</code>
             */
            public com.google.protobuf.ByteString
            getRouteIdBytes() {
                java.lang.Object ref = routeId_;
                if (ref instanceof String) {
                    com.google.protobuf.ByteString b =
                            com.google.protobuf.ByteString.copyFromUtf8(
                                    (java.lang.String) ref);
                    routeId_ = b;
                    return b;
                } else {
                    return (com.google.protobuf.ByteString) ref;
                }
            }

            /**
             * <code>optional string route_id = 2;</code>
             */
            public Builder setRouteId(
                    java.lang.String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000002;
                routeId_ = value;
                onChanged();
                return this;
            }

            /**
             * <code>optional string route_id = 2;</code>
             */
            public Builder clearRouteId() {
                bitField0_ = (bitField0_ & ~0x00000002);
                routeId_ = getDefaultInstance().getRouteId();
                onChanged();
                return this;
            }

            /**
             * <code>optional string route_id = 2;</code>
             */
            public Builder setRouteIdBytes(
                    com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000002;
                routeId_ = value;
                onChanged();
                return this;
            }

            private int routeType_;

            /**
             * <pre>
             * corresponds to route_type in GTFS.
             * </pre>
             *
             * <code>optional int32 route_type = 3;</code>
             */
            public boolean hasRouteType() {
                return ((bitField0_ & 0x00000004) != 0);
            }

            /**
             * <pre>
             * corresponds to route_type in GTFS.
             * </pre>
             *
             * <code>optional int32 route_type = 3;</code>
             */
            public int getRouteType() {
                return routeType_;
            }

            /**
             * <pre>
             * corresponds to route_type in GTFS.
             * </pre>
             *
             * <code>optional int32 route_type = 3;</code>
             */
            public Builder setRouteType(int value) {
                bitField0_ |= 0x00000004;
                routeType_ = value;
                onChanged();
                return this;
            }

            /**
             * <pre>
             * corresponds to route_type in GTFS.
             * </pre>
             *
             * <code>optional int32 route_type = 3;</code>
             */
            public Builder clearRouteType() {
                bitField0_ = (bitField0_ & ~0x00000004);
                routeType_ = 0;
                onChanged();
                return this;
            }

            private GtfsRealtime.TripDescriptor trip_;
            private com.google.protobuf.SingleFieldBuilderV3<
                    GtfsRealtime.TripDescriptor, GtfsRealtime.TripDescriptor.Builder, GtfsRealtime.TripDescriptorOrBuilder> tripBuilder_;

            /**
             * <code>optional .transit_realtime.TripDescriptor trip = 4;</code>
             */
            public boolean hasTrip() {
                return ((bitField0_ & 0x00000008) != 0);
            }

            /**
             * <code>optional .transit_realtime.TripDescriptor trip = 4;</code>
             */
            public GtfsRealtime.TripDescriptor getTrip() {
                if (tripBuilder_ == null) {
                    return trip_ == null ? GtfsRealtime.TripDescriptor.getDefaultInstance() : trip_;
                } else {
                    return tripBuilder_.getMessage();
                }
            }

            /**
             * <code>optional .transit_realtime.TripDescriptor trip = 4;</code>
             */
            public Builder setTrip(GtfsRealtime.TripDescriptor value) {
                if (tripBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    trip_ = value;
                    onChanged();
                } else {
                    tripBuilder_.setMessage(value);
                }
                bitField0_ |= 0x00000008;
                return this;
            }

            /**
             * <code>optional .transit_realtime.TripDescriptor trip = 4;</code>
             */
            public Builder setTrip(
                    GtfsRealtime.TripDescriptor.Builder builderForValue) {
                if (tripBuilder_ == null) {
                    trip_ = builderForValue.build();
                    onChanged();
                } else {
                    tripBuilder_.setMessage(builderForValue.build());
                }
                bitField0_ |= 0x00000008;
                return this;
            }

            /**
             * <code>optional .transit_realtime.TripDescriptor trip = 4;</code>
             */
            public Builder mergeTrip(GtfsRealtime.TripDescriptor value) {
                if (tripBuilder_ == null) {
                    if (((bitField0_ & 0x00000008) != 0) &&
                            trip_ != null &&
                            trip_ != GtfsRealtime.TripDescriptor.getDefaultInstance()) {
                        trip_ =
                                GtfsRealtime.TripDescriptor.newBuilder(trip_).mergeFrom(value).buildPartial();
                    } else {
                        trip_ = value;
                    }
                    onChanged();
                } else {
                    tripBuilder_.mergeFrom(value);
                }
                bitField0_ |= 0x00000008;
                return this;
            }

            /**
             * <code>optional .transit_realtime.TripDescriptor trip = 4;</code>
             */
            public Builder clearTrip() {
                if (tripBuilder_ == null) {
                    trip_ = null;
                    onChanged();
                } else {
                    tripBuilder_.clear();
                }
                bitField0_ = (bitField0_ & ~0x00000008);
                return this;
            }

            /**
             * <code>optional .transit_realtime.TripDescriptor trip = 4;</code>
             */
            public GtfsRealtime.TripDescriptor.Builder getTripBuilder() {
                bitField0_ |= 0x00000008;
                onChanged();
                return getTripFieldBuilder().getBuilder();
            }

            /**
             * <code>optional .transit_realtime.TripDescriptor trip = 4;</code>
             */
            public GtfsRealtime.TripDescriptorOrBuilder getTripOrBuilder() {
                if (tripBuilder_ != null) {
                    return tripBuilder_.getMessageOrBuilder();
                } else {
                    return trip_ == null ?
                            GtfsRealtime.TripDescriptor.getDefaultInstance() : trip_;
                }
            }

            /**
             * <code>optional .transit_realtime.TripDescriptor trip = 4;</code>
             */
            private com.google.protobuf.SingleFieldBuilderV3<
                    GtfsRealtime.TripDescriptor, GtfsRealtime.TripDescriptor.Builder, GtfsRealtime.TripDescriptorOrBuilder>
            getTripFieldBuilder() {
                if (tripBuilder_ == null) {
                    tripBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
                            GtfsRealtime.TripDescriptor, GtfsRealtime.TripDescriptor.Builder, GtfsRealtime.TripDescriptorOrBuilder>(
                            getTrip(),
                            getParentForChildren(),
                            isClean());
                    trip_ = null;
                }
                return tripBuilder_;
            }

            private java.lang.Object stopId_ = "";

            /**
             * <code>optional string stop_id = 5;</code>
             */
            public boolean hasStopId() {
                return ((bitField0_ & 0x00000010) != 0);
            }

            /**
             * <code>optional string stop_id = 5;</code>
             */
            public java.lang.String getStopId() {
                java.lang.Object ref = stopId_;
                if (!(ref instanceof java.lang.String)) {
                    com.google.protobuf.ByteString bs =
                            (com.google.protobuf.ByteString) ref;
                    java.lang.String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        stopId_ = s;
                    }
                    return s;
                } else {
                    return (java.lang.String) ref;
                }
            }

            /**
             * <code>optional string stop_id = 5;</code>
             */
            public com.google.protobuf.ByteString
            getStopIdBytes() {
                java.lang.Object ref = stopId_;
                if (ref instanceof String) {
                    com.google.protobuf.ByteString b =
                            com.google.protobuf.ByteString.copyFromUtf8(
                                    (java.lang.String) ref);
                    stopId_ = b;
                    return b;
                } else {
                    return (com.google.protobuf.ByteString) ref;
                }
            }

            /**
             * <code>optional string stop_id = 5;</code>
             */
            public Builder setStopId(
                    java.lang.String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000010;
                stopId_ = value;
                onChanged();
                return this;
            }

            /**
             * <code>optional string stop_id = 5;</code>
             */
            public Builder clearStopId() {
                bitField0_ = (bitField0_ & ~0x00000010);
                stopId_ = getDefaultInstance().getStopId();
                onChanged();
                return this;
            }

            /**
             * <code>optional string stop_id = 5;</code>
             */
            public Builder setStopIdBytes(
                    com.google.protobuf.ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                bitField0_ |= 0x00000010;
                stopId_ = value;
                onChanged();
                return this;
            }

            @java.lang.Override
            public final Builder setUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.setUnknownFields(unknownFields);
            }

            @java.lang.Override
            public final Builder mergeUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.mergeUnknownFields(unknownFields);
            }


            // @@protoc_insertion_point(builder_scope:transit_realtime.EntitySelector)
        }

        // @@protoc_insertion_point(class_scope:transit_realtime.EntitySelector)
        private static final GtfsRealtime.EntitySelector DEFAULT_INSTANCE;

        static {
            DEFAULT_INSTANCE = new GtfsRealtime.EntitySelector();
        }

        public static GtfsRealtime.EntitySelector getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        @java.lang.Deprecated
        public static final com.google.protobuf.Parser<EntitySelector>
                PARSER = new com.google.protobuf.AbstractParser<EntitySelector>() {
            @java.lang.Override
            public EntitySelector parsePartialFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return new EntitySelector(input, extensionRegistry);
            }
        };

        public static com.google.protobuf.Parser<EntitySelector> parser() {
            return PARSER;
        }

        @java.lang.Override
        public com.google.protobuf.Parser<EntitySelector> getParserForType() {
            return PARSER;
        }

        @java.lang.Override
        public GtfsRealtime.EntitySelector getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

    }

    public interface TranslatedStringOrBuilder extends
            // @@protoc_insertion_point(interface_extends:transit_realtime.TranslatedString)
            com.google.protobuf.GeneratedMessageV3.
                    ExtendableMessageOrBuilder<TranslatedString> {

        /**
         * <pre>
         * At least one translation must be provided.
         * </pre>
         *
         * <code>repeated .transit_realtime.TranslatedString.Translation translation = 1;</code>
         */
        java.util.List<GtfsRealtime.TranslatedString.Translation>
        getTranslationList();

        /**
         * <pre>
         * At least one translation must be provided.
         * </pre>
         *
         * <code>repeated .transit_realtime.TranslatedString.Translation translation = 1;</code>
         */
        GtfsRealtime.TranslatedString.Translation getTranslation(int index);

        /**
         * <pre>
         * At least one translation must be provided.
         * </pre>
         *
         * <code>repeated .transit_realtime.TranslatedString.Translation translation = 1;</code>
         */
        int getTranslationCount();

        /**
         * <pre>
         * At least one translation must be provided.
         * </pre>
         *
         * <code>repeated .transit_realtime.TranslatedString.Translation translation = 1;</code>
         */
        java.util.List<? extends GtfsRealtime.TranslatedString.TranslationOrBuilder>
        getTranslationOrBuilderList();

        /**
         * <pre>
         * At least one translation must be provided.
         * </pre>
         *
         * <code>repeated .transit_realtime.TranslatedString.Translation translation = 1;</code>
         */
        GtfsRealtime.TranslatedString.TranslationOrBuilder getTranslationOrBuilder(
                int index);
    }

    /**
     * <pre>
     * An internationalized message containing per-language versions of a snippet of
     * text or a URL.
     * One of the strings from a message will be picked up. The resolution proceeds
     * as follows:
     * 1. If the UI language matches the language code of a translation,
     *    the first matching translation is picked.
     * 2. If a default UI language (e.g., English) matches the language code of a
     *    translation, the first matching translation is picked.
     * 3. If some translation has an unspecified language code, that translation is
     *    picked.
     * </pre>
     * <p>
     * Protobuf type {@code transit_realtime.TranslatedString}
     */
    public static final class TranslatedString extends
            com.google.protobuf.GeneratedMessageV3.ExtendableMessage<
                    TranslatedString> implements
            // @@protoc_insertion_point(message_implements:transit_realtime.TranslatedString)
            TranslatedStringOrBuilder {
        private static final long serialVersionUID = 0L;

        // Use TranslatedString.newBuilder() to construct.
        private TranslatedString(com.google.protobuf.GeneratedMessageV3.ExtendableBuilder<GtfsRealtime.TranslatedString, ?> builder) {
            super(builder);
        }

        private TranslatedString() {
            translation_ = java.util.Collections.emptyList();
        }

        @java.lang.Override
        @SuppressWarnings({"unused"})
        protected java.lang.Object newInstance(
                UnusedPrivateParameter unused) {
            return new TranslatedString();
        }

        @java.lang.Override
        public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
            return this.unknownFields;
        }

        private TranslatedString(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            this();
            if (extensionRegistry == null) {
                throw new java.lang.NullPointerException();
            }
            int mutable_bitField0_ = 0;
            com.google.protobuf.UnknownFieldSet.Builder unknownFields =
                    com.google.protobuf.UnknownFieldSet.newBuilder();
            try {
                boolean done = false;
                while (!done) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            done = true;
                            break;
                        case 10: {
                            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
                                translation_ = new java.util.ArrayList<GtfsRealtime.TranslatedString.Translation>();
                                mutable_bitField0_ |= 0x00000001;
                            }
                            translation_.add(
                                    input.readMessage(GtfsRealtime.TranslatedString.Translation.PARSER, extensionRegistry));
                            break;
                        }
                        default: {
                            if (!parseUnknownField(
                                    input, unknownFields, extensionRegistry, tag)) {
                                done = true;
                            }
                            break;
                        }
                    }
                }
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (java.io.IOException e) {
                throw new com.google.protobuf.InvalidProtocolBufferException(
                        e).setUnfinishedMessage(this);
            } finally {
                if (((mutable_bitField0_ & 0x00000001) != 0)) {
                    translation_ = java.util.Collections.unmodifiableList(translation_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
            return GtfsRealtime.internal_static_transit_realtime_TranslatedString_descriptor;
        }

        @java.lang.Override
        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
            return GtfsRealtime.internal_static_transit_realtime_TranslatedString_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            GtfsRealtime.TranslatedString.class, GtfsRealtime.TranslatedString.Builder.class);
        }

        public interface TranslationOrBuilder extends
                // @@protoc_insertion_point(interface_extends:transit_realtime.TranslatedString.Translation)
                com.google.protobuf.GeneratedMessageV3.
                        ExtendableMessageOrBuilder<Translation> {

            /**
             * <pre>
             * A UTF-8 string containing the message.
             * </pre>
             *
             * <code>required string text = 1;</code>
             */
            boolean hasText();

            /**
             * <pre>
             * A UTF-8 string containing the message.
             * </pre>
             *
             * <code>required string text = 1;</code>
             */
            java.lang.String getText();

            /**
             * <pre>
             * A UTF-8 string containing the message.
             * </pre>
             *
             * <code>required string text = 1;</code>
             */
            com.google.protobuf.ByteString
            getTextBytes();

            /**
             * <pre>
             * BCP-47 language code. Can be omitted if the language is unknown or if
             * no i18n is done at all for the feed. At most one translation is
             * allowed to have an unspecified language tag.
             * </pre>
             *
             * <code>optional string language = 2;</code>
             */
            boolean hasLanguage();

            /**
             * <pre>
             * BCP-47 language code. Can be omitted if the language is unknown or if
             * no i18n is done at all for the feed. At most one translation is
             * allowed to have an unspecified language tag.
             * </pre>
             *
             * <code>optional string language = 2;</code>
             */
            java.lang.String getLanguage();

            /**
             * <pre>
             * BCP-47 language code. Can be omitted if the language is unknown or if
             * no i18n is done at all for the feed. At most one translation is
             * allowed to have an unspecified language tag.
             * </pre>
             *
             * <code>optional string language = 2;</code>
             */
            com.google.protobuf.ByteString
            getLanguageBytes();
        }

        /**
         * Protobuf type {@code transit_realtime.TranslatedString.Translation}
         */
        public static final class Translation extends
                com.google.protobuf.GeneratedMessageV3.ExtendableMessage<
                        Translation> implements
                // @@protoc_insertion_point(message_implements:transit_realtime.TranslatedString.Translation)
                TranslationOrBuilder {
            private static final long serialVersionUID = 0L;

            // Use Translation.newBuilder() to construct.
            private Translation(com.google.protobuf.GeneratedMessageV3.ExtendableBuilder<GtfsRealtime.TranslatedString.Translation, ?> builder) {
                super(builder);
            }

            private Translation() {
                text_ = "";
                language_ = "";
            }

            @java.lang.Override
            @SuppressWarnings({"unused"})
            protected java.lang.Object newInstance(
                    UnusedPrivateParameter unused) {
                return new Translation();
            }

            @java.lang.Override
            public final com.google.protobuf.UnknownFieldSet
            getUnknownFields() {
                return this.unknownFields;
            }

            private Translation(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                this();
                if (extensionRegistry == null) {
                    throw new java.lang.NullPointerException();
                }
                int mutable_bitField0_ = 0;
                com.google.protobuf.UnknownFieldSet.Builder unknownFields =
                        com.google.protobuf.UnknownFieldSet.newBuilder();
                try {
                    boolean done = false;
                    while (!done) {
                        int tag = input.readTag();
                        switch (tag) {
                            case 0:
                                done = true;
                                break;
                            case 10: {
                                com.google.protobuf.ByteString bs = input.readBytes();
                                bitField0_ |= 0x00000001;
                                text_ = bs;
                                break;
                            }
                            case 18: {
                                com.google.protobuf.ByteString bs = input.readBytes();
                                bitField0_ |= 0x00000002;
                                language_ = bs;
                                break;
                            }
                            default: {
                                if (!parseUnknownField(
                                        input, unknownFields, extensionRegistry, tag)) {
                                    done = true;
                                }
                                break;
                            }
                        }
                    }
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (java.io.IOException e) {
                    throw new com.google.protobuf.InvalidProtocolBufferException(
                            e).setUnfinishedMessage(this);
                } finally {
                    this.unknownFields = unknownFields.build();
                    makeExtensionsImmutable();
                }
            }

            public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
                return GtfsRealtime.internal_static_transit_realtime_TranslatedString_Translation_descriptor;
            }

            @java.lang.Override
            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internalGetFieldAccessorTable() {
                return GtfsRealtime.internal_static_transit_realtime_TranslatedString_Translation_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                GtfsRealtime.TranslatedString.Translation.class, GtfsRealtime.TranslatedString.Translation.Builder.class);
            }

            private int bitField0_;
            public static final int TEXT_FIELD_NUMBER = 1;
            private volatile java.lang.Object text_;

            /**
             * <pre>
             * A UTF-8 string containing the message.
             * </pre>
             *
             * <code>required string text = 1;</code>
             */
            public boolean hasText() {
                return ((bitField0_ & 0x00000001) != 0);
            }

            /**
             * <pre>
             * A UTF-8 string containing the message.
             * </pre>
             *
             * <code>required string text = 1;</code>
             */
            public java.lang.String getText() {
                java.lang.Object ref = text_;
                if (ref instanceof java.lang.String) {
                    return (java.lang.String) ref;
                } else {
                    com.google.protobuf.ByteString bs =
                            (com.google.protobuf.ByteString) ref;
                    java.lang.String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        text_ = s;
                    }
                    return s;
                }
            }

            /**
             * <pre>
             * A UTF-8 string containing the message.
             * </pre>
             *
             * <code>required string text = 1;</code>
             */
            public com.google.protobuf.ByteString
            getTextBytes() {
                java.lang.Object ref = text_;
                if (ref instanceof java.lang.String) {
                    com.google.protobuf.ByteString b =
                            com.google.protobuf.ByteString.copyFromUtf8(
                                    (java.lang.String) ref);
                    text_ = b;
                    return b;
                } else {
                    return (com.google.protobuf.ByteString) ref;
                }
            }

            public static final int LANGUAGE_FIELD_NUMBER = 2;
            private volatile java.lang.Object language_;

            /**
             * <pre>
             * BCP-47 language code. Can be omitted if the language is unknown or if
             * no i18n is done at all for the feed. At most one translation is
             * allowed to have an unspecified language tag.
             * </pre>
             *
             * <code>optional string language = 2;</code>
             */
            public boolean hasLanguage() {
                return ((bitField0_ & 0x00000002) != 0);
            }

            /**
             * <pre>
             * BCP-47 language code. Can be omitted if the language is unknown or if
             * no i18n is done at all for the feed. At most one translation is
             * allowed to have an unspecified language tag.
             * </pre>
             *
             * <code>optional string language = 2;</code>
             */
            public java.lang.String getLanguage() {
                java.lang.Object ref = language_;
                if (ref instanceof java.lang.String) {
                    return (java.lang.String) ref;
                } else {
                    com.google.protobuf.ByteString bs =
                            (com.google.protobuf.ByteString) ref;
                    java.lang.String s = bs.toStringUtf8();
                    if (bs.isValidUtf8()) {
                        language_ = s;
                    }
                    return s;
                }
            }

            /**
             * <pre>
             * BCP-47 language code. Can be omitted if the language is unknown or if
             * no i18n is done at all for the feed. At most one translation is
             * allowed to have an unspecified language tag.
             * </pre>
             *
             * <code>optional string language = 2;</code>
             */
            public com.google.protobuf.ByteString
            getLanguageBytes() {
                java.lang.Object ref = language_;
                if (ref instanceof java.lang.String) {
                    com.google.protobuf.ByteString b =
                            com.google.protobuf.ByteString.copyFromUtf8(
                                    (java.lang.String) ref);
                    language_ = b;
                    return b;
                } else {
                    return (com.google.protobuf.ByteString) ref;
                }
            }

            private byte memoizedIsInitialized = -1;

            @java.lang.Override
            public final boolean isInitialized() {
                byte isInitialized = memoizedIsInitialized;
                if (isInitialized == 1) return true;
                if (isInitialized == 0) return false;

                if (!hasText()) {
                    memoizedIsInitialized = 0;
                    return false;
                }
                if (!extensionsAreInitialized()) {
                    memoizedIsInitialized = 0;
                    return false;
                }
                memoizedIsInitialized = 1;
                return true;
            }

            @java.lang.Override
            public void writeTo(com.google.protobuf.CodedOutputStream output)
                    throws java.io.IOException {
                com.google.protobuf.GeneratedMessageV3
                        .ExtendableMessage<GtfsRealtime.TranslatedString.Translation>.ExtensionWriter
                        extensionWriter = newExtensionWriter();
                if (((bitField0_ & 0x00000001) != 0)) {
                    com.google.protobuf.GeneratedMessageV3.writeString(output, 1, text_);
                }
                if (((bitField0_ & 0x00000002) != 0)) {
                    com.google.protobuf.GeneratedMessageV3.writeString(output, 2, language_);
                }
                extensionWriter.writeUntil(2000, output);
                unknownFields.writeTo(output);
            }

            @java.lang.Override
            public int getSerializedSize() {
                int size = memoizedSize;
                if (size != -1) return size;

                size = 0;
                if (((bitField0_ & 0x00000001) != 0)) {
                    size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, text_);
                }
                if (((bitField0_ & 0x00000002) != 0)) {
                    size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, language_);
                }
                size += extensionsSerializedSize();
                size += unknownFields.getSerializedSize();
                memoizedSize = size;
                return size;
            }

            @java.lang.Override
            public boolean equals(final java.lang.Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof GtfsRealtime.TranslatedString.Translation)) {
                    return super.equals(obj);
                }
                GtfsRealtime.TranslatedString.Translation other = (GtfsRealtime.TranslatedString.Translation) obj;

                if (hasText() != other.hasText()) return false;
                if (hasText()) {
                    if (!getText()
                            .equals(other.getText())) return false;
                }
                if (hasLanguage() != other.hasLanguage()) return false;
                if (hasLanguage()) {
                    if (!getLanguage()
                            .equals(other.getLanguage())) return false;
                }
                if (!unknownFields.equals(other.unknownFields)) return false;
                if (!getExtensionFields().equals(other.getExtensionFields()))
                    return false;
                return true;
            }

            @java.lang.Override
            public int hashCode() {
                if (memoizedHashCode != 0) {
                    return memoizedHashCode;
                }
                int hash = 41;
                hash = (19 * hash) + getDescriptor().hashCode();
                if (hasText()) {
                    hash = (37 * hash) + TEXT_FIELD_NUMBER;
                    hash = (53 * hash) + getText().hashCode();
                }
                if (hasLanguage()) {
                    hash = (37 * hash) + LANGUAGE_FIELD_NUMBER;
                    hash = (53 * hash) + getLanguage().hashCode();
                }
                hash = hashFields(hash, getExtensionFields());
                hash = (29 * hash) + unknownFields.hashCode();
                memoizedHashCode = hash;
                return hash;
            }

            public static GtfsRealtime.TranslatedString.Translation parseFrom(
                    java.nio.ByteBuffer data)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return PARSER.parseFrom(data);
            }

            public static GtfsRealtime.TranslatedString.Translation parseFrom(
                    java.nio.ByteBuffer data,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return PARSER.parseFrom(data, extensionRegistry);
            }

            public static GtfsRealtime.TranslatedString.Translation parseFrom(
                    com.google.protobuf.ByteString data)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return PARSER.parseFrom(data);
            }

            public static GtfsRealtime.TranslatedString.Translation parseFrom(
                    com.google.protobuf.ByteString data,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return PARSER.parseFrom(data, extensionRegistry);
            }

            public static GtfsRealtime.TranslatedString.Translation parseFrom(byte[] data)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return PARSER.parseFrom(data);
            }

            public static GtfsRealtime.TranslatedString.Translation parseFrom(
                    byte[] data,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return PARSER.parseFrom(data, extensionRegistry);
            }

            public static GtfsRealtime.TranslatedString.Translation parseFrom(java.io.InputStream input)
                    throws java.io.IOException {
                return com.google.protobuf.GeneratedMessageV3
                        .parseWithIOException(PARSER, input);
            }

            public static GtfsRealtime.TranslatedString.Translation parseFrom(
                    java.io.InputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                return com.google.protobuf.GeneratedMessageV3
                        .parseWithIOException(PARSER, input, extensionRegistry);
            }

            public static GtfsRealtime.TranslatedString.Translation parseDelimitedFrom(java.io.InputStream input)
                    throws java.io.IOException {
                return com.google.protobuf.GeneratedMessageV3
                        .parseDelimitedWithIOException(PARSER, input);
            }

            public static GtfsRealtime.TranslatedString.Translation parseDelimitedFrom(
                    java.io.InputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                return com.google.protobuf.GeneratedMessageV3
                        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
            }

            public static GtfsRealtime.TranslatedString.Translation parseFrom(
                    com.google.protobuf.CodedInputStream input)
                    throws java.io.IOException {
                return com.google.protobuf.GeneratedMessageV3
                        .parseWithIOException(PARSER, input);
            }

            public static GtfsRealtime.TranslatedString.Translation parseFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                return com.google.protobuf.GeneratedMessageV3
                        .parseWithIOException(PARSER, input, extensionRegistry);
            }

            @java.lang.Override
            public Builder newBuilderForType() {
                return newBuilder();
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.toBuilder();
            }

            public static Builder newBuilder(GtfsRealtime.TranslatedString.Translation prototype) {
                return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
            }

            @java.lang.Override
            public Builder toBuilder() {
                return this == DEFAULT_INSTANCE
                        ? new Builder() : new Builder().mergeFrom(this);
            }

            @java.lang.Override
            protected Builder newBuilderForType(
                    com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
                Builder builder = new Builder(parent);
                return builder;
            }

            /**
             * Protobuf type {@code transit_realtime.TranslatedString.Translation}
             */
            public static final class Builder extends
                    com.google.protobuf.GeneratedMessageV3.ExtendableBuilder<
                            GtfsRealtime.TranslatedString.Translation, Builder> implements
                    // @@protoc_insertion_point(builder_implements:transit_realtime.TranslatedString.Translation)
                    GtfsRealtime.TranslatedString.TranslationOrBuilder {
                public static final com.google.protobuf.Descriptors.Descriptor
                getDescriptor() {
                    return GtfsRealtime.internal_static_transit_realtime_TranslatedString_Translation_descriptor;
                }

                @java.lang.Override
                protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
                internalGetFieldAccessorTable() {
                    return GtfsRealtime.internal_static_transit_realtime_TranslatedString_Translation_fieldAccessorTable
                            .ensureFieldAccessorsInitialized(
                                    GtfsRealtime.TranslatedString.Translation.class, GtfsRealtime.TranslatedString.Translation.Builder.class);
                }

                // Construct using GtfsRealtime.TranslatedString.Translation.newBuilder()
                private Builder() {
                    maybeForceBuilderInitialization();
                }

                private Builder(
                        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
                    super(parent);
                    maybeForceBuilderInitialization();
                }

                private void maybeForceBuilderInitialization() {
                    if (com.google.protobuf.GeneratedMessageV3
                            .alwaysUseFieldBuilders) {
                    }
                }

                @java.lang.Override
                public Builder clear() {
                    super.clear();
                    text_ = "";
                    bitField0_ = (bitField0_ & ~0x00000001);
                    language_ = "";
                    bitField0_ = (bitField0_ & ~0x00000002);
                    return this;
                }

                @java.lang.Override
                public com.google.protobuf.Descriptors.Descriptor
                getDescriptorForType() {
                    return GtfsRealtime.internal_static_transit_realtime_TranslatedString_Translation_descriptor;
                }

                @java.lang.Override
                public GtfsRealtime.TranslatedString.Translation getDefaultInstanceForType() {
                    return GtfsRealtime.TranslatedString.Translation.getDefaultInstance();
                }

                @java.lang.Override
                public GtfsRealtime.TranslatedString.Translation build() {
                    GtfsRealtime.TranslatedString.Translation result = buildPartial();
                    if (!result.isInitialized()) {
                        throw newUninitializedMessageException(result);
                    }
                    return result;
                }

                @java.lang.Override
                public GtfsRealtime.TranslatedString.Translation buildPartial() {
                    GtfsRealtime.TranslatedString.Translation result = new GtfsRealtime.TranslatedString.Translation(this);
                    int from_bitField0_ = bitField0_;
                    int to_bitField0_ = 0;
                    if (((from_bitField0_ & 0x00000001) != 0)) {
                        to_bitField0_ |= 0x00000001;
                    }
                    result.text_ = text_;
                    if (((from_bitField0_ & 0x00000002) != 0)) {
                        to_bitField0_ |= 0x00000002;
                    }
                    result.language_ = language_;
                    result.bitField0_ = to_bitField0_;
                    onBuilt();
                    return result;
                }

                @java.lang.Override
                public Builder clone() {
                    return super.clone();
                }

                @java.lang.Override
                public Builder setField(
                        com.google.protobuf.Descriptors.FieldDescriptor field,
                        java.lang.Object value) {
                    return super.setField(field, value);
                }

                @java.lang.Override
                public Builder clearField(
                        com.google.protobuf.Descriptors.FieldDescriptor field) {
                    return super.clearField(field);
                }

                @java.lang.Override
                public Builder clearOneof(
                        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
                    return super.clearOneof(oneof);
                }

                @java.lang.Override
                public Builder setRepeatedField(
                        com.google.protobuf.Descriptors.FieldDescriptor field,
                        int index, java.lang.Object value) {
                    return super.setRepeatedField(field, index, value);
                }

                @java.lang.Override
                public Builder addRepeatedField(
                        com.google.protobuf.Descriptors.FieldDescriptor field,
                        java.lang.Object value) {
                    return super.addRepeatedField(field, value);
                }

                @java.lang.Override
                public <Type> Builder setExtension(
                        com.google.protobuf.GeneratedMessage.GeneratedExtension<
                                GtfsRealtime.TranslatedString.Translation, Type> extension,
                        Type value) {
                    return super.setExtension(extension, value);
                }

                @java.lang.Override
                public <Type> Builder setExtension(
                        com.google.protobuf.GeneratedMessage.GeneratedExtension<
                                GtfsRealtime.TranslatedString.Translation, java.util.List<Type>> extension,
                        int index, Type value) {
                    return super.setExtension(extension, index, value);
                }

                @java.lang.Override
                public <Type> Builder addExtension(
                        com.google.protobuf.GeneratedMessage.GeneratedExtension<
                                GtfsRealtime.TranslatedString.Translation, java.util.List<Type>> extension,
                        Type value) {
                    return super.addExtension(extension, value);
                }

                @java.lang.Override
                public <Type> Builder clearExtension(
                        com.google.protobuf.GeneratedMessage.GeneratedExtension<
                                GtfsRealtime.TranslatedString.Translation, ?> extension) {
                    return super.clearExtension(extension);
                }

                @java.lang.Override
                public Builder mergeFrom(com.google.protobuf.Message other) {
                    if (other instanceof GtfsRealtime.TranslatedString.Translation) {
                        return mergeFrom((GtfsRealtime.TranslatedString.Translation) other);
                    } else {
                        super.mergeFrom(other);
                        return this;
                    }
                }

                public Builder mergeFrom(GtfsRealtime.TranslatedString.Translation other) {
                    if (other == GtfsRealtime.TranslatedString.Translation.getDefaultInstance()) return this;
                    if (other.hasText()) {
                        bitField0_ |= 0x00000001;
                        text_ = other.text_;
                        onChanged();
                    }
                    if (other.hasLanguage()) {
                        bitField0_ |= 0x00000002;
                        language_ = other.language_;
                        onChanged();
                    }
                    this.mergeExtensionFields(other);
                    this.mergeUnknownFields(other.unknownFields);
                    onChanged();
                    return this;
                }

                @java.lang.Override
                public final boolean isInitialized() {
                    if (!hasText()) {
                        return false;
                    }
                    if (!extensionsAreInitialized()) {
                        return false;
                    }
                    return true;
                }

                @java.lang.Override
                public Builder mergeFrom(
                        com.google.protobuf.CodedInputStream input,
                        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                        throws java.io.IOException {
                    GtfsRealtime.TranslatedString.Translation parsedMessage = null;
                    try {
                        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                        parsedMessage = (GtfsRealtime.TranslatedString.Translation) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    } finally {
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                    }
                    return this;
                }

                private int bitField0_;

                private java.lang.Object text_ = "";

                /**
                 * <pre>
                 * A UTF-8 string containing the message.
                 * </pre>
                 *
                 * <code>required string text = 1;</code>
                 */
                public boolean hasText() {
                    return ((bitField0_ & 0x00000001) != 0);
                }

                /**
                 * <pre>
                 * A UTF-8 string containing the message.
                 * </pre>
                 *
                 * <code>required string text = 1;</code>
                 */
                public java.lang.String getText() {
                    java.lang.Object ref = text_;
                    if (!(ref instanceof java.lang.String)) {
                        com.google.protobuf.ByteString bs =
                                (com.google.protobuf.ByteString) ref;
                        java.lang.String s = bs.toStringUtf8();
                        if (bs.isValidUtf8()) {
                            text_ = s;
                        }
                        return s;
                    } else {
                        return (java.lang.String) ref;
                    }
                }

                /**
                 * <pre>
                 * A UTF-8 string containing the message.
                 * </pre>
                 *
                 * <code>required string text = 1;</code>
                 */
                public com.google.protobuf.ByteString
                getTextBytes() {
                    java.lang.Object ref = text_;
                    if (ref instanceof String) {
                        com.google.protobuf.ByteString b =
                                com.google.protobuf.ByteString.copyFromUtf8(
                                        (java.lang.String) ref);
                        text_ = b;
                        return b;
                    } else {
                        return (com.google.protobuf.ByteString) ref;
                    }
                }

                /**
                 * <pre>
                 * A UTF-8 string containing the message.
                 * </pre>
                 *
                 * <code>required string text = 1;</code>
                 */
                public Builder setText(
                        java.lang.String value) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    bitField0_ |= 0x00000001;
                    text_ = value;
                    onChanged();
                    return this;
                }

                /**
                 * <pre>
                 * A UTF-8 string containing the message.
                 * </pre>
                 *
                 * <code>required string text = 1;</code>
                 */
                public Builder clearText() {
                    bitField0_ = (bitField0_ & ~0x00000001);
                    text_ = getDefaultInstance().getText();
                    onChanged();
                    return this;
                }

                /**
                 * <pre>
                 * A UTF-8 string containing the message.
                 * </pre>
                 *
                 * <code>required string text = 1;</code>
                 */
                public Builder setTextBytes(
                        com.google.protobuf.ByteString value) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    bitField0_ |= 0x00000001;
                    text_ = value;
                    onChanged();
                    return this;
                }

                private java.lang.Object language_ = "";

                /**
                 * <pre>
                 * BCP-47 language code. Can be omitted if the language is unknown or if
                 * no i18n is done at all for the feed. At most one translation is
                 * allowed to have an unspecified language tag.
                 * </pre>
                 *
                 * <code>optional string language = 2;</code>
                 */
                public boolean hasLanguage() {
                    return ((bitField0_ & 0x00000002) != 0);
                }

                /**
                 * <pre>
                 * BCP-47 language code. Can be omitted if the language is unknown or if
                 * no i18n is done at all for the feed. At most one translation is
                 * allowed to have an unspecified language tag.
                 * </pre>
                 *
                 * <code>optional string language = 2;</code>
                 */
                public java.lang.String getLanguage() {
                    java.lang.Object ref = language_;
                    if (!(ref instanceof java.lang.String)) {
                        com.google.protobuf.ByteString bs =
                                (com.google.protobuf.ByteString) ref;
                        java.lang.String s = bs.toStringUtf8();
                        if (bs.isValidUtf8()) {
                            language_ = s;
                        }
                        return s;
                    } else {
                        return (java.lang.String) ref;
                    }
                }

                /**
                 * <pre>
                 * BCP-47 language code. Can be omitted if the language is unknown or if
                 * no i18n is done at all for the feed. At most one translation is
                 * allowed to have an unspecified language tag.
                 * </pre>
                 *
                 * <code>optional string language = 2;</code>
                 */
                public com.google.protobuf.ByteString
                getLanguageBytes() {
                    java.lang.Object ref = language_;
                    if (ref instanceof String) {
                        com.google.protobuf.ByteString b =
                                com.google.protobuf.ByteString.copyFromUtf8(
                                        (java.lang.String) ref);
                        language_ = b;
                        return b;
                    } else {
                        return (com.google.protobuf.ByteString) ref;
                    }
                }

                /**
                 * <pre>
                 * BCP-47 language code. Can be omitted if the language is unknown or if
                 * no i18n is done at all for the feed. At most one translation is
                 * allowed to have an unspecified language tag.
                 * </pre>
                 *
                 * <code>optional string language = 2;</code>
                 */
                public Builder setLanguage(
                        java.lang.String value) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    bitField0_ |= 0x00000002;
                    language_ = value;
                    onChanged();
                    return this;
                }

                /**
                 * <pre>
                 * BCP-47 language code. Can be omitted if the language is unknown or if
                 * no i18n is done at all for the feed. At most one translation is
                 * allowed to have an unspecified language tag.
                 * </pre>
                 *
                 * <code>optional string language = 2;</code>
                 */
                public Builder clearLanguage() {
                    bitField0_ = (bitField0_ & ~0x00000002);
                    language_ = getDefaultInstance().getLanguage();
                    onChanged();
                    return this;
                }

                /**
                 * <pre>
                 * BCP-47 language code. Can be omitted if the language is unknown or if
                 * no i18n is done at all for the feed. At most one translation is
                 * allowed to have an unspecified language tag.
                 * </pre>
                 *
                 * <code>optional string language = 2;</code>
                 */
                public Builder setLanguageBytes(
                        com.google.protobuf.ByteString value) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    bitField0_ |= 0x00000002;
                    language_ = value;
                    onChanged();
                    return this;
                }

                @java.lang.Override
                public final Builder setUnknownFields(
                        final com.google.protobuf.UnknownFieldSet unknownFields) {
                    return super.setUnknownFields(unknownFields);
                }

                @java.lang.Override
                public final Builder mergeUnknownFields(
                        final com.google.protobuf.UnknownFieldSet unknownFields) {
                    return super.mergeUnknownFields(unknownFields);
                }


                // @@protoc_insertion_point(builder_scope:transit_realtime.TranslatedString.Translation)
            }

            // @@protoc_insertion_point(class_scope:transit_realtime.TranslatedString.Translation)
            private static final GtfsRealtime.TranslatedString.Translation DEFAULT_INSTANCE;

            static {
                DEFAULT_INSTANCE = new GtfsRealtime.TranslatedString.Translation();
            }

            public static GtfsRealtime.TranslatedString.Translation getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            @java.lang.Deprecated
            public static final com.google.protobuf.Parser<Translation>
                    PARSER = new com.google.protobuf.AbstractParser<Translation>() {
                @java.lang.Override
                public Translation parsePartialFrom(
                        com.google.protobuf.CodedInputStream input,
                        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                        throws com.google.protobuf.InvalidProtocolBufferException {
                    return new Translation(input, extensionRegistry);
                }
            };

            public static com.google.protobuf.Parser<Translation> parser() {
                return PARSER;
            }

            @java.lang.Override
            public com.google.protobuf.Parser<Translation> getParserForType() {
                return PARSER;
            }

            @java.lang.Override
            public GtfsRealtime.TranslatedString.Translation getDefaultInstanceForType() {
                return DEFAULT_INSTANCE;
            }

        }

        public static final int TRANSLATION_FIELD_NUMBER = 1;
        private java.util.List<GtfsRealtime.TranslatedString.Translation> translation_;

        /**
         * <pre>
         * At least one translation must be provided.
         * </pre>
         *
         * <code>repeated .transit_realtime.TranslatedString.Translation translation = 1;</code>
         */
        public java.util.List<GtfsRealtime.TranslatedString.Translation> getTranslationList() {
            return translation_;
        }

        /**
         * <pre>
         * At least one translation must be provided.
         * </pre>
         *
         * <code>repeated .transit_realtime.TranslatedString.Translation translation = 1;</code>
         */
        public java.util.List<? extends GtfsRealtime.TranslatedString.TranslationOrBuilder>
        getTranslationOrBuilderList() {
            return translation_;
        }

        /**
         * <pre>
         * At least one translation must be provided.
         * </pre>
         *
         * <code>repeated .transit_realtime.TranslatedString.Translation translation = 1;</code>
         */
        public int getTranslationCount() {
            return translation_.size();
        }

        /**
         * <pre>
         * At least one translation must be provided.
         * </pre>
         *
         * <code>repeated .transit_realtime.TranslatedString.Translation translation = 1;</code>
         */
        public GtfsRealtime.TranslatedString.Translation getTranslation(int index) {
            return translation_.get(index);
        }

        /**
         * <pre>
         * At least one translation must be provided.
         * </pre>
         *
         * <code>repeated .transit_realtime.TranslatedString.Translation translation = 1;</code>
         */
        public GtfsRealtime.TranslatedString.TranslationOrBuilder getTranslationOrBuilder(
                int index) {
            return translation_.get(index);
        }

        private byte memoizedIsInitialized = -1;

        @java.lang.Override
        public final boolean isInitialized() {
            byte isInitialized = memoizedIsInitialized;
            if (isInitialized == 1) return true;
            if (isInitialized == 0) return false;

            for (int i = 0; i < getTranslationCount(); i++) {
                if (!getTranslation(i).isInitialized()) {
                    memoizedIsInitialized = 0;
                    return false;
                }
            }
            if (!extensionsAreInitialized()) {
                memoizedIsInitialized = 0;
                return false;
            }
            memoizedIsInitialized = 1;
            return true;
        }

        @java.lang.Override
        public void writeTo(com.google.protobuf.CodedOutputStream output)
                throws java.io.IOException {
            com.google.protobuf.GeneratedMessageV3
                    .ExtendableMessage<GtfsRealtime.TranslatedString>.ExtensionWriter
                    extensionWriter = newExtensionWriter();
            for (int i = 0; i < translation_.size(); i++) {
                output.writeMessage(1, translation_.get(i));
            }
            extensionWriter.writeUntil(2000, output);
            unknownFields.writeTo(output);
        }

        @java.lang.Override
        public int getSerializedSize() {
            int size = memoizedSize;
            if (size != -1) return size;

            size = 0;
            for (int i = 0; i < translation_.size(); i++) {
                size += com.google.protobuf.CodedOutputStream
                        .computeMessageSize(1, translation_.get(i));
            }
            size += extensionsSerializedSize();
            size += unknownFields.getSerializedSize();
            memoizedSize = size;
            return size;
        }

        @java.lang.Override
        public boolean equals(final java.lang.Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof GtfsRealtime.TranslatedString)) {
                return super.equals(obj);
            }
            GtfsRealtime.TranslatedString other = (GtfsRealtime.TranslatedString) obj;

            if (!getTranslationList()
                    .equals(other.getTranslationList())) return false;
            if (!unknownFields.equals(other.unknownFields)) return false;
            if (!getExtensionFields().equals(other.getExtensionFields()))
                return false;
            return true;
        }

        @java.lang.Override
        public int hashCode() {
            if (memoizedHashCode != 0) {
                return memoizedHashCode;
            }
            int hash = 41;
            hash = (19 * hash) + getDescriptor().hashCode();
            if (getTranslationCount() > 0) {
                hash = (37 * hash) + TRANSLATION_FIELD_NUMBER;
                hash = (53 * hash) + getTranslationList().hashCode();
            }
            hash = hashFields(hash, getExtensionFields());
            hash = (29 * hash) + unknownFields.hashCode();
            memoizedHashCode = hash;
            return hash;
        }

        public static GtfsRealtime.TranslatedString parseFrom(
                java.nio.ByteBuffer data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GtfsRealtime.TranslatedString parseFrom(
                java.nio.ByteBuffer data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GtfsRealtime.TranslatedString parseFrom(
                com.google.protobuf.ByteString data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GtfsRealtime.TranslatedString parseFrom(
                com.google.protobuf.ByteString data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GtfsRealtime.TranslatedString parseFrom(byte[] data)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GtfsRealtime.TranslatedString parseFrom(
                byte[] data,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GtfsRealtime.TranslatedString parseFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }

        public static GtfsRealtime.TranslatedString parseFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static GtfsRealtime.TranslatedString parseDelimitedFrom(java.io.InputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input);
        }

        public static GtfsRealtime.TranslatedString parseDelimitedFrom(
                java.io.InputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static GtfsRealtime.TranslatedString parseFrom(
                com.google.protobuf.CodedInputStream input)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input);
        }

        public static GtfsRealtime.TranslatedString parseFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws java.io.IOException {
            return com.google.protobuf.GeneratedMessageV3
                    .parseWithIOException(PARSER, input, extensionRegistry);
        }

        @java.lang.Override
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GtfsRealtime.TranslatedString prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }

        @java.lang.Override
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE
                    ? new Builder() : new Builder().mergeFrom(this);
        }

        @java.lang.Override
        protected Builder newBuilderForType(
                com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
            Builder builder = new Builder(parent);
            return builder;
        }

        /**
         * <pre>
         * An internationalized message containing per-language versions of a snippet of
         * text or a URL.
         * One of the strings from a message will be picked up. The resolution proceeds
         * as follows:
         * 1. If the UI language matches the language code of a translation,
         *    the first matching translation is picked.
         * 2. If a default UI language (e.g., English) matches the language code of a
         *    translation, the first matching translation is picked.
         * 3. If some translation has an unspecified language code, that translation is
         *    picked.
         * </pre>
         * <p>
         * Protobuf type {@code transit_realtime.TranslatedString}
         */
        public static final class Builder extends
                com.google.protobuf.GeneratedMessageV3.ExtendableBuilder<
                        GtfsRealtime.TranslatedString, Builder> implements
                // @@protoc_insertion_point(builder_implements:transit_realtime.TranslatedString)
                GtfsRealtime.TranslatedStringOrBuilder {
            public static final com.google.protobuf.Descriptors.Descriptor
            getDescriptor() {
                return GtfsRealtime.internal_static_transit_realtime_TranslatedString_descriptor;
            }

            @java.lang.Override
            protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internalGetFieldAccessorTable() {
                return GtfsRealtime.internal_static_transit_realtime_TranslatedString_fieldAccessorTable
                        .ensureFieldAccessorsInitialized(
                                GtfsRealtime.TranslatedString.class, GtfsRealtime.TranslatedString.Builder.class);
            }

            // Construct using GtfsRealtime.TranslatedString.newBuilder()
            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(
                    com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (com.google.protobuf.GeneratedMessageV3
                        .alwaysUseFieldBuilders) {
                    getTranslationFieldBuilder();
                }
            }

            @java.lang.Override
            public Builder clear() {
                super.clear();
                if (translationBuilder_ == null) {
                    translation_ = java.util.Collections.emptyList();
                    bitField0_ = (bitField0_ & ~0x00000001);
                } else {
                    translationBuilder_.clear();
                }
                return this;
            }

            @java.lang.Override
            public com.google.protobuf.Descriptors.Descriptor
            getDescriptorForType() {
                return GtfsRealtime.internal_static_transit_realtime_TranslatedString_descriptor;
            }

            @java.lang.Override
            public GtfsRealtime.TranslatedString getDefaultInstanceForType() {
                return GtfsRealtime.TranslatedString.getDefaultInstance();
            }

            @java.lang.Override
            public GtfsRealtime.TranslatedString build() {
                GtfsRealtime.TranslatedString result = buildPartial();
                if (!result.isInitialized()) {
                    throw newUninitializedMessageException(result);
                }
                return result;
            }

            @java.lang.Override
            public GtfsRealtime.TranslatedString buildPartial() {
                GtfsRealtime.TranslatedString result = new GtfsRealtime.TranslatedString(this);
                int from_bitField0_ = bitField0_;
                if (translationBuilder_ == null) {
                    if (((bitField0_ & 0x00000001) != 0)) {
                        translation_ = java.util.Collections.unmodifiableList(translation_);
                        bitField0_ = (bitField0_ & ~0x00000001);
                    }
                    result.translation_ = translation_;
                } else {
                    result.translation_ = translationBuilder_.build();
                }
                onBuilt();
                return result;
            }

            @java.lang.Override
            public Builder clone() {
                return super.clone();
            }

            @java.lang.Override
            public Builder setField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return super.setField(field, value);
            }

            @java.lang.Override
            public Builder clearField(
                    com.google.protobuf.Descriptors.FieldDescriptor field) {
                return super.clearField(field);
            }

            @java.lang.Override
            public Builder clearOneof(
                    com.google.protobuf.Descriptors.OneofDescriptor oneof) {
                return super.clearOneof(oneof);
            }

            @java.lang.Override
            public Builder setRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    int index, java.lang.Object value) {
                return super.setRepeatedField(field, index, value);
            }

            @java.lang.Override
            public Builder addRepeatedField(
                    com.google.protobuf.Descriptors.FieldDescriptor field,
                    java.lang.Object value) {
                return super.addRepeatedField(field, value);
            }

            @java.lang.Override
            public <Type> Builder setExtension(
                    com.google.protobuf.GeneratedMessage.GeneratedExtension<
                            GtfsRealtime.TranslatedString, Type> extension,
                    Type value) {
                return super.setExtension(extension, value);
            }

            @java.lang.Override
            public <Type> Builder setExtension(
                    com.google.protobuf.GeneratedMessage.GeneratedExtension<
                            GtfsRealtime.TranslatedString, java.util.List<Type>> extension,
                    int index, Type value) {
                return super.setExtension(extension, index, value);
            }

            @java.lang.Override
            public <Type> Builder addExtension(
                    com.google.protobuf.GeneratedMessage.GeneratedExtension<
                            GtfsRealtime.TranslatedString, java.util.List<Type>> extension,
                    Type value) {
                return super.addExtension(extension, value);
            }

            @java.lang.Override
            public <Type> Builder clearExtension(
                    com.google.protobuf.GeneratedMessage.GeneratedExtension<
                            GtfsRealtime.TranslatedString, ?> extension) {
                return super.clearExtension(extension);
            }

            @java.lang.Override
            public Builder mergeFrom(com.google.protobuf.Message other) {
                if (other instanceof GtfsRealtime.TranslatedString) {
                    return mergeFrom((GtfsRealtime.TranslatedString) other);
                } else {
                    super.mergeFrom(other);
                    return this;
                }
            }

            public Builder mergeFrom(GtfsRealtime.TranslatedString other) {
                if (other == GtfsRealtime.TranslatedString.getDefaultInstance()) return this;
                if (translationBuilder_ == null) {
                    if (!other.translation_.isEmpty()) {
                        if (translation_.isEmpty()) {
                            translation_ = other.translation_;
                            bitField0_ = (bitField0_ & ~0x00000001);
                        } else {
                            ensureTranslationIsMutable();
                            translation_.addAll(other.translation_);
                        }
                        onChanged();
                    }
                } else {
                    if (!other.translation_.isEmpty()) {
                        if (translationBuilder_.isEmpty()) {
                            translationBuilder_.dispose();
                            translationBuilder_ = null;
                            translation_ = other.translation_;
                            bitField0_ = (bitField0_ & ~0x00000001);
                            translationBuilder_ =
                                    com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                                            getTranslationFieldBuilder() : null;
                        } else {
                            translationBuilder_.addAllMessages(other.translation_);
                        }
                    }
                }
                this.mergeExtensionFields(other);
                this.mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            @java.lang.Override
            public final boolean isInitialized() {
                for (int i = 0; i < getTranslationCount(); i++) {
                    if (!getTranslation(i).isInitialized()) {
                        return false;
                    }
                }
                if (!extensionsAreInitialized()) {
                    return false;
                }
                return true;
            }

            @java.lang.Override
            public Builder mergeFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws java.io.IOException {
                GtfsRealtime.TranslatedString parsedMessage = null;
                try {
                    parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
                } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                    parsedMessage = (GtfsRealtime.TranslatedString) e.getUnfinishedMessage();
                    throw e.unwrapIOException();
                } finally {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                }
                return this;
            }

            private int bitField0_;

            private java.util.List<GtfsRealtime.TranslatedString.Translation> translation_ =
                    java.util.Collections.emptyList();

            private void ensureTranslationIsMutable() {
                if (!((bitField0_ & 0x00000001) != 0)) {
                    translation_ = new java.util.ArrayList<GtfsRealtime.TranslatedString.Translation>(translation_);
                    bitField0_ |= 0x00000001;
                }
            }

            private com.google.protobuf.RepeatedFieldBuilderV3<
                    GtfsRealtime.TranslatedString.Translation, GtfsRealtime.TranslatedString.Translation.Builder, GtfsRealtime.TranslatedString.TranslationOrBuilder> translationBuilder_;

            /**
             * <pre>
             * At least one translation must be provided.
             * </pre>
             *
             * <code>repeated .transit_realtime.TranslatedString.Translation translation = 1;</code>
             */
            public java.util.List<GtfsRealtime.TranslatedString.Translation> getTranslationList() {
                if (translationBuilder_ == null) {
                    return java.util.Collections.unmodifiableList(translation_);
                } else {
                    return translationBuilder_.getMessageList();
                }
            }

            /**
             * <pre>
             * At least one translation must be provided.
             * </pre>
             *
             * <code>repeated .transit_realtime.TranslatedString.Translation translation = 1;</code>
             */
            public int getTranslationCount() {
                if (translationBuilder_ == null) {
                    return translation_.size();
                } else {
                    return translationBuilder_.getCount();
                }
            }

            /**
             * <pre>
             * At least one translation must be provided.
             * </pre>
             *
             * <code>repeated .transit_realtime.TranslatedString.Translation translation = 1;</code>
             */
            public GtfsRealtime.TranslatedString.Translation getTranslation(int index) {
                if (translationBuilder_ == null) {
                    return translation_.get(index);
                } else {
                    return translationBuilder_.getMessage(index);
                }
            }

            /**
             * <pre>
             * At least one translation must be provided.
             * </pre>
             *
             * <code>repeated .transit_realtime.TranslatedString.Translation translation = 1;</code>
             */
            public Builder setTranslation(
                    int index, GtfsRealtime.TranslatedString.Translation value) {
                if (translationBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureTranslationIsMutable();
                    translation_.set(index, value);
                    onChanged();
                } else {
                    translationBuilder_.setMessage(index, value);
                }
                return this;
            }

            /**
             * <pre>
             * At least one translation must be provided.
             * </pre>
             *
             * <code>repeated .transit_realtime.TranslatedString.Translation translation = 1;</code>
             */
            public Builder setTranslation(
                    int index, GtfsRealtime.TranslatedString.Translation.Builder builderForValue) {
                if (translationBuilder_ == null) {
                    ensureTranslationIsMutable();
                    translation_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    translationBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            /**
             * <pre>
             * At least one translation must be provided.
             * </pre>
             *
             * <code>repeated .transit_realtime.TranslatedString.Translation translation = 1;</code>
             */
            public Builder addTranslation(GtfsRealtime.TranslatedString.Translation value) {
                if (translationBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureTranslationIsMutable();
                    translation_.add(value);
                    onChanged();
                } else {
                    translationBuilder_.addMessage(value);
                }
                return this;
            }

            /**
             * <pre>
             * At least one translation must be provided.
             * </pre>
             *
             * <code>repeated .transit_realtime.TranslatedString.Translation translation = 1;</code>
             */
            public Builder addTranslation(
                    int index, GtfsRealtime.TranslatedString.Translation value) {
                if (translationBuilder_ == null) {
                    if (value == null) {
                        throw new NullPointerException();
                    }
                    ensureTranslationIsMutable();
                    translation_.add(index, value);
                    onChanged();
                } else {
                    translationBuilder_.addMessage(index, value);
                }
                return this;
            }

            /**
             * <pre>
             * At least one translation must be provided.
             * </pre>
             *
             * <code>repeated .transit_realtime.TranslatedString.Translation translation = 1;</code>
             */
            public Builder addTranslation(
                    GtfsRealtime.TranslatedString.Translation.Builder builderForValue) {
                if (translationBuilder_ == null) {
                    ensureTranslationIsMutable();
                    translation_.add(builderForValue.build());
                    onChanged();
                } else {
                    translationBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            /**
             * <pre>
             * At least one translation must be provided.
             * </pre>
             *
             * <code>repeated .transit_realtime.TranslatedString.Translation translation = 1;</code>
             */
            public Builder addTranslation(
                    int index, GtfsRealtime.TranslatedString.Translation.Builder builderForValue) {
                if (translationBuilder_ == null) {
                    ensureTranslationIsMutable();
                    translation_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    translationBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            /**
             * <pre>
             * At least one translation must be provided.
             * </pre>
             *
             * <code>repeated .transit_realtime.TranslatedString.Translation translation = 1;</code>
             */
            public Builder addAllTranslation(
                    java.lang.Iterable<? extends GtfsRealtime.TranslatedString.Translation> values) {
                if (translationBuilder_ == null) {
                    ensureTranslationIsMutable();
                    com.google.protobuf.AbstractMessageLite.Builder.addAll(
                            values, translation_);
                    onChanged();
                } else {
                    translationBuilder_.addAllMessages(values);
                }
                return this;
            }

            /**
             * <pre>
             * At least one translation must be provided.
             * </pre>
             *
             * <code>repeated .transit_realtime.TranslatedString.Translation translation = 1;</code>
             */
            public Builder clearTranslation() {
                if (translationBuilder_ == null) {
                    translation_ = java.util.Collections.emptyList();
                    bitField0_ = (bitField0_ & ~0x00000001);
                    onChanged();
                } else {
                    translationBuilder_.clear();
                }
                return this;
            }

            /**
             * <pre>
             * At least one translation must be provided.
             * </pre>
             *
             * <code>repeated .transit_realtime.TranslatedString.Translation translation = 1;</code>
             */
            public Builder removeTranslation(int index) {
                if (translationBuilder_ == null) {
                    ensureTranslationIsMutable();
                    translation_.remove(index);
                    onChanged();
                } else {
                    translationBuilder_.remove(index);
                }
                return this;
            }

            /**
             * <pre>
             * At least one translation must be provided.
             * </pre>
             *
             * <code>repeated .transit_realtime.TranslatedString.Translation translation = 1;</code>
             */
            public GtfsRealtime.TranslatedString.Translation.Builder getTranslationBuilder(
                    int index) {
                return getTranslationFieldBuilder().getBuilder(index);
            }

            /**
             * <pre>
             * At least one translation must be provided.
             * </pre>
             *
             * <code>repeated .transit_realtime.TranslatedString.Translation translation = 1;</code>
             */
            public GtfsRealtime.TranslatedString.TranslationOrBuilder getTranslationOrBuilder(
                    int index) {
                if (translationBuilder_ == null) {
                    return translation_.get(index);
                } else {
                    return translationBuilder_.getMessageOrBuilder(index);
                }
            }

            /**
             * <pre>
             * At least one translation must be provided.
             * </pre>
             *
             * <code>repeated .transit_realtime.TranslatedString.Translation translation = 1;</code>
             */
            public java.util.List<? extends GtfsRealtime.TranslatedString.TranslationOrBuilder>
            getTranslationOrBuilderList() {
                if (translationBuilder_ != null) {
                    return translationBuilder_.getMessageOrBuilderList();
                } else {
                    return java.util.Collections.unmodifiableList(translation_);
                }
            }

            /**
             * <pre>
             * At least one translation must be provided.
             * </pre>
             *
             * <code>repeated .transit_realtime.TranslatedString.Translation translation = 1;</code>
             */
            public GtfsRealtime.TranslatedString.Translation.Builder addTranslationBuilder() {
                return getTranslationFieldBuilder().addBuilder(
                        GtfsRealtime.TranslatedString.Translation.getDefaultInstance());
            }

            /**
             * <pre>
             * At least one translation must be provided.
             * </pre>
             *
             * <code>repeated .transit_realtime.TranslatedString.Translation translation = 1;</code>
             */
            public GtfsRealtime.TranslatedString.Translation.Builder addTranslationBuilder(
                    int index) {
                return getTranslationFieldBuilder().addBuilder(
                        index, GtfsRealtime.TranslatedString.Translation.getDefaultInstance());
            }

            /**
             * <pre>
             * At least one translation must be provided.
             * </pre>
             *
             * <code>repeated .transit_realtime.TranslatedString.Translation translation = 1;</code>
             */
            public java.util.List<GtfsRealtime.TranslatedString.Translation.Builder>
            getTranslationBuilderList() {
                return getTranslationFieldBuilder().getBuilderList();
            }

            private com.google.protobuf.RepeatedFieldBuilderV3<
                    GtfsRealtime.TranslatedString.Translation, GtfsRealtime.TranslatedString.Translation.Builder, GtfsRealtime.TranslatedString.TranslationOrBuilder>
            getTranslationFieldBuilder() {
                if (translationBuilder_ == null) {
                    translationBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
                            GtfsRealtime.TranslatedString.Translation, GtfsRealtime.TranslatedString.Translation.Builder, GtfsRealtime.TranslatedString.TranslationOrBuilder>(
                            translation_,
                            ((bitField0_ & 0x00000001) != 0),
                            getParentForChildren(),
                            isClean());
                    translation_ = null;
                }
                return translationBuilder_;
            }

            @java.lang.Override
            public final Builder setUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.setUnknownFields(unknownFields);
            }

            @java.lang.Override
            public final Builder mergeUnknownFields(
                    final com.google.protobuf.UnknownFieldSet unknownFields) {
                return super.mergeUnknownFields(unknownFields);
            }


            // @@protoc_insertion_point(builder_scope:transit_realtime.TranslatedString)
        }

        // @@protoc_insertion_point(class_scope:transit_realtime.TranslatedString)
        private static final GtfsRealtime.TranslatedString DEFAULT_INSTANCE;

        static {
            DEFAULT_INSTANCE = new GtfsRealtime.TranslatedString();
        }

        public static GtfsRealtime.TranslatedString getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        @java.lang.Deprecated
        public static final com.google.protobuf.Parser<TranslatedString>
                PARSER = new com.google.protobuf.AbstractParser<TranslatedString>() {
            @java.lang.Override
            public TranslatedString parsePartialFrom(
                    com.google.protobuf.CodedInputStream input,
                    com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                    throws com.google.protobuf.InvalidProtocolBufferException {
                return new TranslatedString(input, extensionRegistry);
            }
        };

        public static com.google.protobuf.Parser<TranslatedString> parser() {
            return PARSER;
        }

        @java.lang.Override
        public com.google.protobuf.Parser<TranslatedString> getParserForType() {
            return PARSER;
        }

        @java.lang.Override
        public GtfsRealtime.TranslatedString getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }

    }

    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_transit_realtime_FeedMessage_descriptor;
    private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_transit_realtime_FeedMessage_fieldAccessorTable;
    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_transit_realtime_FeedHeader_descriptor;
    private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_transit_realtime_FeedHeader_fieldAccessorTable;
    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_transit_realtime_FeedEntity_descriptor;
    private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_transit_realtime_FeedEntity_fieldAccessorTable;
    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_transit_realtime_TripUpdate_descriptor;
    private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_transit_realtime_TripUpdate_fieldAccessorTable;
    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_transit_realtime_TripUpdate_StopTimeEvent_descriptor;
    private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_transit_realtime_TripUpdate_StopTimeEvent_fieldAccessorTable;
    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_transit_realtime_TripUpdate_StopTimeUpdate_descriptor;
    private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_transit_realtime_TripUpdate_StopTimeUpdate_fieldAccessorTable;
    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_transit_realtime_VehiclePosition_descriptor;
    private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_transit_realtime_VehiclePosition_fieldAccessorTable;
    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_transit_realtime_Alert_descriptor;
    private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_transit_realtime_Alert_fieldAccessorTable;
    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_transit_realtime_TimeRange_descriptor;
    private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_transit_realtime_TimeRange_fieldAccessorTable;
    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_transit_realtime_Position_descriptor;
    private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_transit_realtime_Position_fieldAccessorTable;
    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_transit_realtime_TripDescriptor_descriptor;
    private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_transit_realtime_TripDescriptor_fieldAccessorTable;
    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_transit_realtime_VehicleDescriptor_descriptor;
    private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_transit_realtime_VehicleDescriptor_fieldAccessorTable;
    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_transit_realtime_EntitySelector_descriptor;
    private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_transit_realtime_EntitySelector_fieldAccessorTable;
    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_transit_realtime_TranslatedString_descriptor;
    private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_transit_realtime_TranslatedString_fieldAccessorTable;
    private static final com.google.protobuf.Descriptors.Descriptor
            internal_static_transit_realtime_TranslatedString_Translation_descriptor;
    private static final
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
            internal_static_transit_realtime_TranslatedString_Translation_fieldAccessorTable;

    public static com.google.protobuf.Descriptors.FileDescriptor
    getDescriptor() {
        return descriptor;
    }

    private static com.google.protobuf.Descriptors.FileDescriptor
            descriptor;

    static {
        java.lang.String[] descriptorData = {
                "\n\023gtfs-realtime.proto\022\020transit_realtime\"" +
                        "q\n\013FeedMessage\022,\n\006header\030\001 \002(\0132\034.transit" +
                        "_realtime.FeedHeader\022,\n\006entity\030\002 \003(\0132\034.t" +
                        "ransit_realtime.FeedEntity*\006\010\350\007\020\320\017\"\317\001\n\nF" +
                        "eedHeader\022\035\n\025gtfs_realtime_version\030\001 \002(\t" +
                        "\022Q\n\016incrementality\030\002 \001(\0162+.transit_realt" +
                        "ime.FeedHeader.Incrementality:\014FULL_DATA" +
                        "SET\022\021\n\ttimestamp\030\003 \001(\004\"4\n\016Incrementality" +
                        "\022\020\n\014FULL_DATASET\020\000\022\020\n\014DIFFERENTIAL\020\001*\006\010\350" +
                        "\007\020\320\017\"\312\001\n\nFeedEntity\022\n\n\002id\030\001 \002(\t\022\031\n\nis_de" +
                        "leted\030\002 \001(\010:\005false\0221\n\013trip_update\030\003 \001(\0132" +
                        "\034.transit_realtime.TripUpdate\0222\n\007vehicle" +
                        "\030\004 \001(\0132!.transit_realtime.VehiclePositio" +
                        "n\022&\n\005alert\030\005 \001(\0132\027.transit_realtime.Aler" +
                        "t*\006\010\350\007\020\320\017\"\232\005\n\nTripUpdate\022.\n\004trip\030\001 \002(\0132 " +
                        ".transit_realtime.TripDescriptor\0224\n\007vehi" +
                        "cle\030\003 \001(\0132#.transit_realtime.VehicleDesc" +
                        "riptor\022E\n\020stop_time_update\030\002 \003(\0132+.trans" +
                        "it_realtime.TripUpdate.StopTimeUpdate\022\021\n" +
                        "\ttimestamp\030\004 \001(\004\022\r\n\005delay\030\005 \001(\005\032I\n\rStopT" +
                        "imeEvent\022\r\n\005delay\030\001 \001(\005\022\014\n\004time\030\002 \001(\003\022\023\n" +
                        "\013uncertainty\030\003 \001(\005*\006\010\350\007\020\320\017\032\351\002\n\016StopTimeU" +
                        "pdate\022\025\n\rstop_sequence\030\001 \001(\r\022\017\n\007stop_id\030" +
                        "\004 \001(\t\022;\n\007arrival\030\002 \001(\0132*.transit_realtim" +
                        "e.TripUpdate.StopTimeEvent\022=\n\tdeparture\030" +
                        "\003 \001(\0132*.transit_realtime.TripUpdate.Stop" +
                        "TimeEvent\022j\n\025schedule_relationship\030\005 \001(\016" +
                        "2@.transit_realtime.TripUpdate.StopTimeU" +
                        "pdate.ScheduleRelationship:\tSCHEDULED\"?\n" +
                        "\024ScheduleRelationship\022\r\n\tSCHEDULED\020\000\022\013\n\007" +
                        "SKIPPED\020\001\022\013\n\007NO_DATA\020\002*\006\010\350\007\020\320\017*\006\010\350\007\020\320\017\"\340" +
                        "\006\n\017VehiclePosition\022.\n\004trip\030\001 \001(\0132 .trans" +
                        "it_realtime.TripDescriptor\0224\n\007vehicle\030\010 " +
                        "\001(\0132#.transit_realtime.VehicleDescriptor" +
                        "\022,\n\010position\030\002 \001(\0132\032.transit_realtime.Po" +
                        "sition\022\035\n\025current_stop_sequence\030\003 \001(\r\022\017\n" +
                        "\007stop_id\030\007 \001(\t\022Z\n\016current_status\030\004 \001(\01623" +
                        ".transit_realtime.VehiclePosition.Vehicl" +
                        "eStopStatus:\rIN_TRANSIT_TO\022\021\n\ttimestamp\030" +
                        "\005 \001(\004\022K\n\020congestion_level\030\006 \001(\01621.transi" +
                        "t_realtime.VehiclePosition.CongestionLev" +
                        "el\022K\n\020occupancy_status\030\t \001(\01621.transit_r" +
                        "ealtime.VehiclePosition.OccupancyStatus\"" +
                        "G\n\021VehicleStopStatus\022\017\n\013INCOMING_AT\020\000\022\016\n" +
                        "\nSTOPPED_AT\020\001\022\021\n\rIN_TRANSIT_TO\020\002\"}\n\017Cong" +
                        "estionLevel\022\034\n\030UNKNOWN_CONGESTION_LEVEL\020" +
                        "\000\022\024\n\020RUNNING_SMOOTHLY\020\001\022\017\n\013STOP_AND_GO\020\002" +
                        "\022\016\n\nCONGESTION\020\003\022\025\n\021SEVERE_CONGESTION\020\004\"" +
                        "\257\001\n\017OccupancyStatus\022\t\n\005EMPTY\020\000\022\030\n\024MANY_S" +
                        "EATS_AVAILABLE\020\001\022\027\n\023FEW_SEATS_AVAILABLE\020" +
                        "\002\022\026\n\022STANDING_ROOM_ONLY\020\003\022\036\n\032CRUSHED_STA" +
                        "NDING_ROOM_ONLY\020\004\022\010\n\004FULL\020\005\022\034\n\030NOT_ACCEP" +
                        "TING_PASSENGERS\020\006*\006\010\350\007\020\320\017\"\266\006\n\005Alert\0222\n\ra" +
                        "ctive_period\030\001 \003(\0132\033.transit_realtime.Ti" +
                        "meRange\0229\n\017informed_entity\030\005 \003(\0132 .trans" +
                        "it_realtime.EntitySelector\022;\n\005cause\030\006 \001(" +
                        "\0162\035.transit_realtime.Alert.Cause:\rUNKNOW" +
                        "N_CAUSE\022>\n\006effect\030\007 \001(\0162\036.transit_realti" +
                        "me.Alert.Effect:\016UNKNOWN_EFFECT\022/\n\003url\030\010" +
                        " \001(\0132\".transit_realtime.TranslatedString" +
                        "\0227\n\013header_text\030\n \001(\0132\".transit_realtime" +
                        ".TranslatedString\022<\n\020description_text\030\013 " +
                        "\001(\0132\".transit_realtime.TranslatedString\"" +
                        "\330\001\n\005Cause\022\021\n\rUNKNOWN_CAUSE\020\001\022\017\n\013OTHER_CA" +
                        "USE\020\002\022\025\n\021TECHNICAL_PROBLEM\020\003\022\n\n\006STRIKE\020\004" +
                        "\022\021\n\rDEMONSTRATION\020\005\022\014\n\010ACCIDENT\020\006\022\013\n\007HOL" +
                        "IDAY\020\007\022\013\n\007WEATHER\020\010\022\017\n\013MAINTENANCE\020\t\022\020\n\014" +
                        "CONSTRUCTION\020\n\022\023\n\017POLICE_ACTIVITY\020\013\022\025\n\021M" +
                        "EDICAL_EMERGENCY\020\014\"\265\001\n\006Effect\022\016\n\nNO_SERV" +
                        "ICE\020\001\022\023\n\017REDUCED_SERVICE\020\002\022\026\n\022SIGNIFICAN" +
                        "T_DELAYS\020\003\022\n\n\006DETOUR\020\004\022\026\n\022ADDITIONAL_SER" +
                        "VICE\020\005\022\024\n\020MODIFIED_SERVICE\020\006\022\020\n\014OTHER_EF" +
                        "FECT\020\007\022\022\n\016UNKNOWN_EFFECT\020\010\022\016\n\nSTOP_MOVED" +
                        "\020\t*\006\010\350\007\020\320\017\"/\n\tTimeRange\022\r\n\005start\030\001 \001(\004\022\013" +
                        "\n\003end\030\002 \001(\004*\006\010\350\007\020\320\017\"i\n\010Position\022\020\n\010latit" +
                        "ude\030\001 \002(\002\022\021\n\tlongitude\030\002 \002(\002\022\017\n\007bearing\030" +
                        "\003 \001(\002\022\020\n\010odometer\030\004 \001(\001\022\r\n\005speed\030\005 \001(\002*\006" +
                        "\010\350\007\020\320\017\"\240\002\n\016TripDescriptor\022\017\n\007trip_id\030\001 \001" +
                        "(\t\022\020\n\010route_id\030\005 \001(\t\022\024\n\014direction_id\030\006 \001" +
                        "(\r\022\022\n\nstart_time\030\002 \001(\t\022\022\n\nstart_date\030\003 \001" +
                        "(\t\022T\n\025schedule_relationship\030\004 \001(\01625.tran" +
                        "sit_realtime.TripDescriptor.ScheduleRela" +
                        "tionship\"O\n\024ScheduleRelationship\022\r\n\tSCHE" +
                        "DULED\020\000\022\t\n\005ADDED\020\001\022\017\n\013UNSCHEDULED\020\002\022\014\n\010C" +
                        "ANCELED\020\003*\006\010\350\007\020\320\017\"M\n\021VehicleDescriptor\022\n" +
                        "\n\002id\030\001 \001(\t\022\r\n\005label\030\002 \001(\t\022\025\n\rlicense_pla" +
                        "te\030\003 \001(\t*\006\010\350\007\020\320\017\"\222\001\n\016EntitySelector\022\021\n\ta" +
                        "gency_id\030\001 \001(\t\022\020\n\010route_id\030\002 \001(\t\022\022\n\nrout" +
                        "e_type\030\003 \001(\005\022.\n\004trip\030\004 \001(\0132 .transit_rea" +
                        "ltime.TripDescriptor\022\017\n\007stop_id\030\005 \001(\t*\006\010" +
                        "\350\007\020\320\017\"\226\001\n\020TranslatedString\022C\n\013translatio" +
                        "n\030\001 \003(\0132..transit_realtime.TranslatedStr" +
                        "ing.Translation\0325\n\013Translation\022\014\n\004text\030\001" +
                        " \002(\t\022\020\n\010language\030\002 \001(\t*\006\010\350\007\020\320\017*\006\010\350\007\020\320\017B\035" +
                        "\n\033com.google.transit.realtime"
        };
        descriptor = com.google.protobuf.Descriptors.FileDescriptor
                .internalBuildGeneratedFileFrom(descriptorData,
                        new com.google.protobuf.Descriptors.FileDescriptor[]{
                        });
        internal_static_transit_realtime_FeedMessage_descriptor =
                getDescriptor().getMessageTypes().get(0);
        internal_static_transit_realtime_FeedMessage_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_transit_realtime_FeedMessage_descriptor,
                new java.lang.String[]{"Header", "Entity",});
        internal_static_transit_realtime_FeedHeader_descriptor =
                getDescriptor().getMessageTypes().get(1);
        internal_static_transit_realtime_FeedHeader_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_transit_realtime_FeedHeader_descriptor,
                new java.lang.String[]{"GtfsRealtimeVersion", "Incrementality", "Timestamp",});
        internal_static_transit_realtime_FeedEntity_descriptor =
                getDescriptor().getMessageTypes().get(2);
        internal_static_transit_realtime_FeedEntity_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_transit_realtime_FeedEntity_descriptor,
                new java.lang.String[]{"Id", "IsDeleted", "TripUpdate", "Vehicle", "Alert",});
        internal_static_transit_realtime_TripUpdate_descriptor =
                getDescriptor().getMessageTypes().get(3);
        internal_static_transit_realtime_TripUpdate_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_transit_realtime_TripUpdate_descriptor,
                new java.lang.String[]{"Trip", "Vehicle", "StopTimeUpdate", "Timestamp", "Delay",});
        internal_static_transit_realtime_TripUpdate_StopTimeEvent_descriptor =
                internal_static_transit_realtime_TripUpdate_descriptor.getNestedTypes().get(0);
        internal_static_transit_realtime_TripUpdate_StopTimeEvent_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_transit_realtime_TripUpdate_StopTimeEvent_descriptor,
                new java.lang.String[]{"Delay", "Time", "Uncertainty",});
        internal_static_transit_realtime_TripUpdate_StopTimeUpdate_descriptor =
                internal_static_transit_realtime_TripUpdate_descriptor.getNestedTypes().get(1);
        internal_static_transit_realtime_TripUpdate_StopTimeUpdate_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_transit_realtime_TripUpdate_StopTimeUpdate_descriptor,
                new java.lang.String[]{"StopSequence", "StopId", "Arrival", "Departure", "ScheduleRelationship",});
        internal_static_transit_realtime_VehiclePosition_descriptor =
                getDescriptor().getMessageTypes().get(4);
        internal_static_transit_realtime_VehiclePosition_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_transit_realtime_VehiclePosition_descriptor,
                new java.lang.String[]{"Trip", "Vehicle", "Position", "CurrentStopSequence", "StopId", "CurrentStatus", "Timestamp", "CongestionLevel", "OccupancyStatus",});
        internal_static_transit_realtime_Alert_descriptor =
                getDescriptor().getMessageTypes().get(5);
        internal_static_transit_realtime_Alert_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_transit_realtime_Alert_descriptor,
                new java.lang.String[]{"ActivePeriod", "InformedEntity", "Cause", "Effect", "Url", "HeaderText", "DescriptionText",});
        internal_static_transit_realtime_TimeRange_descriptor =
                getDescriptor().getMessageTypes().get(6);
        internal_static_transit_realtime_TimeRange_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_transit_realtime_TimeRange_descriptor,
                new java.lang.String[]{"Start", "End",});
        internal_static_transit_realtime_Position_descriptor =
                getDescriptor().getMessageTypes().get(7);
        internal_static_transit_realtime_Position_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_transit_realtime_Position_descriptor,
                new java.lang.String[]{"Latitude", "Longitude", "Bearing", "Odometer", "Speed",});
        internal_static_transit_realtime_TripDescriptor_descriptor =
                getDescriptor().getMessageTypes().get(8);
        internal_static_transit_realtime_TripDescriptor_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_transit_realtime_TripDescriptor_descriptor,
                new java.lang.String[]{"TripId", "RouteId", "DirectionId", "StartTime", "StartDate", "ScheduleRelationship",});
        internal_static_transit_realtime_VehicleDescriptor_descriptor =
                getDescriptor().getMessageTypes().get(9);
        internal_static_transit_realtime_VehicleDescriptor_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_transit_realtime_VehicleDescriptor_descriptor,
                new java.lang.String[]{"Id", "Label", "LicensePlate",});
        internal_static_transit_realtime_EntitySelector_descriptor =
                getDescriptor().getMessageTypes().get(10);
        internal_static_transit_realtime_EntitySelector_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_transit_realtime_EntitySelector_descriptor,
                new java.lang.String[]{"AgencyId", "RouteId", "RouteType", "Trip", "StopId",});
        internal_static_transit_realtime_TranslatedString_descriptor =
                getDescriptor().getMessageTypes().get(11);
        internal_static_transit_realtime_TranslatedString_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_transit_realtime_TranslatedString_descriptor,
                new java.lang.String[]{"Translation",});
        internal_static_transit_realtime_TranslatedString_Translation_descriptor =
                internal_static_transit_realtime_TranslatedString_descriptor.getNestedTypes().get(0);
        internal_static_transit_realtime_TranslatedString_Translation_fieldAccessorTable = new
                com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_transit_realtime_TranslatedString_Translation_descriptor,
                new java.lang.String[]{"Text", "Language",});
    }

    // @@protoc_insertion_point(outer_class_scope)
}