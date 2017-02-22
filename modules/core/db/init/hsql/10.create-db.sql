-- begin TOTALFIELD_PRODUCT
create table TOTALFIELD_PRODUCT (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    PRICE decimal(19, 2) not null,
    --
    primary key (ID)
)^
-- end TOTALFIELD_PRODUCT
-- begin TOTALFIELD_SERVICE
create table TOTALFIELD_SERVICE (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    HOURLY_PRICE decimal(19, 2) not null,
    STANDARD_ESTIMATION decimal(19, 2),
    --
    primary key (ID)
)^
-- end TOTALFIELD_SERVICE
-- begin TOTALFIELD_ORDER_PRODUCT_ITEM
create table TOTALFIELD_ORDER_PRODUCT_ITEM (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    PRODUCT_ID varchar(36) not null,
    QUANTITY integer not null,
    AMOUNT decimal(19, 2),
    ORDER_ID varchar(36),
    --
    primary key (ID)
)^
-- end TOTALFIELD_ORDER_PRODUCT_ITEM
-- begin TOTALFIELD_ORDER_SERVICE_ITEM
create table TOTALFIELD_ORDER_SERVICE_ITEM (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    SERVICE_ID varchar(36),
    HOURS decimal(19, 2) not null,
    AMOUNT decimal(19, 2),
    ORDER_ID varchar(36),
    --
    primary key (ID)
)^
-- end TOTALFIELD_ORDER_SERVICE_ITEM
-- begin TOTALFIELD_ORDER
create table TOTALFIELD_ORDER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NUMBER_ varchar(255) not null,
    TOTAL_AMOUNT decimal(19, 2),
    --
    primary key (ID)
)^
-- end TOTALFIELD_ORDER
