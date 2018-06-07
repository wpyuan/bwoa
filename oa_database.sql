---------------------------------------------------
-- Export file for user BWJF                     --
-- Created by Administrator on 2018/6/7, 9:54:49 --
---------------------------------------------------

spool oa_database.log

prompt
prompt Creating table AREA
prompt ===================
prompt
create table BWJF.AREA
(
  AREAID      NUMBER not null,
  NAME        VARCHAR2(50),
  PARENTID    NUMBER,
  STATUS      NUMBER(1) default 1,
  DESCRIPTION VARCHAR2(2000),
  PROVINCEID  NUMBER,
  CITYID      NUMBER,
  CREATEDATE  DATE,
  CREATEBY    VARCHAR2(50),
  UPDATEDATE  DATE,
  UPDATEBY    VARCHAR2(50),
  REGIONLEVEL NUMBER,
  TOWNSID     NUMBER,
  LINK        VARCHAR2(50)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column BWJF.AREA.AREAID
  is '区域ID（主键）';
comment on column BWJF.AREA.NAME
  is '区域名称';
comment on column BWJF.AREA.PARENTID
  is '父区域ID';
comment on column BWJF.AREA.STATUS
  is '区域是否有效，1:有效，0：无效';
comment on column BWJF.AREA.DESCRIPTION
  is '区域描述';
comment on column BWJF.AREA.PROVINCEID
  is '省ID';
comment on column BWJF.AREA.CITYID
  is '市ID';
comment on column BWJF.AREA.CREATEDATE
  is '创建时间';
comment on column BWJF.AREA.CREATEBY
  is '创建人';
comment on column BWJF.AREA.UPDATEDATE
  is '更新时间';
comment on column BWJF.AREA.UPDATEBY
  is '更新人';
comment on column BWJF.AREA.REGIONLEVEL
  is '区域等级（省为一级，依次类推）';
comment on column BWJF.AREA.TOWNSID
  is '乡镇ID';
comment on column BWJF.AREA.LINK
  is '区域详细信息跳转链接';
alter table BWJF.AREA
  add constraint PK_AREAID primary key (AREAID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table BWJF.AREA
  add constraint FK_PARENTID foreign key (PARENTID)
  references BWJF.AREA (AREAID) on delete cascade;
create index BWJF.I_AREA_CTIY on BWJF.AREA (CITYID)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index BWJF.I_AREA_PARENT on BWJF.AREA (PARENTID)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index BWJF.I_AREA_PROVINCE on BWJF.AREA (PROVINCEID)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index BWJF.I_AREA_TOWN on BWJF.AREA (TOWNSID)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table DEPARTMENT
prompt =========================
prompt
create table BWJF.DEPARTMENT
(
  DEPARTMENTID NUMBER not null,
  NAME         VARCHAR2(50),
  STATUS       NUMBER(1) default 1
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column BWJF.DEPARTMENT.DEPARTMENTID
  is '部门ID（主键）';
comment on column BWJF.DEPARTMENT.NAME
  is '部门名称';
comment on column BWJF.DEPARTMENT.STATUS
  is '部门是否有效（1：有效，0：无效）默认有效';
alter table BWJF.DEPARTMENT
  add constraint PK_DEPARTMENTID primary key (DEPARTMENTID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table EMPLOYEE
prompt =======================
prompt
create table BWJF.EMPLOYEE
(
  EMPLOYEEID          NUMBER not null,
  NAME                VARCHAR2(20),
  IDCARD              NUMBER(18),
  PHONE               VARCHAR2(50),
  ADDRESS             VARCHAR2(100),
  LASTJOB             VARCHAR2(50),
  NOWJOB              VARCHAR2(50),
  NATIVEPLACE         VARCHAR2(50),
  EDUCATIONAL         VARCHAR2(20),
  DEPARTMENTID        NUMBER,
  HIREDATE            DATE,
  EMAIL               VARCHAR2(30),
  SEX                 VARCHAR2(2),
  NATION              VARCHAR2(30),
  BIRTHDAY            DATE,
  POLITICSSTATUS      VARCHAR2(20),
  WORKDATE            DATE,
  SPECIALTY           VARCHAR2(2000),
  FAMILYRELATIONSHIPS VARCHAR2(2000),
  SOCIALRELATIONS     VARCHAR2(2000),
  RESUME              VARCHAR2(2000),
  REMARK              VARCHAR2(2000),
  PROBATIONPERIOD     DATE,
  POSITIVEPHASE       DATE,
  GRADUATIONDATE      DATE,
  STATUS              NUMBER(1) default 1,
  TELEPHONE           VARCHAR2(50),
  QQ                  VARCHAR2(50)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column BWJF.EMPLOYEE.EMPLOYEEID
  is '员工ID(主键)';
comment on column BWJF.EMPLOYEE.NAME
  is '员工姓名';
comment on column BWJF.EMPLOYEE.IDCARD
  is '身份证号';
comment on column BWJF.EMPLOYEE.PHONE
  is '手机号';
comment on column BWJF.EMPLOYEE.ADDRESS
  is '现地址';
comment on column BWJF.EMPLOYEE.LASTJOB
  is '原职位';
comment on column BWJF.EMPLOYEE.NOWJOB
  is '现职位';
comment on column BWJF.EMPLOYEE.NATIVEPLACE
  is '籍贯';
comment on column BWJF.EMPLOYEE.EDUCATIONAL
  is '学历';
comment on column BWJF.EMPLOYEE.DEPARTMENTID
  is '部门ID（外键）';
comment on column BWJF.EMPLOYEE.HIREDATE
  is '入职时间';
comment on column BWJF.EMPLOYEE.EMAIL
  is '邮箱';
comment on column BWJF.EMPLOYEE.SEX
  is '员工性别';
comment on column BWJF.EMPLOYEE.NATION
  is '民族';
comment on column BWJF.EMPLOYEE.BIRTHDAY
  is '出生日期';
comment on column BWJF.EMPLOYEE.POLITICSSTATUS
  is '政治面貌';
comment on column BWJF.EMPLOYEE.WORKDATE
  is '工作时间';
comment on column BWJF.EMPLOYEE.SPECIALTY
  is '特长';
comment on column BWJF.EMPLOYEE.FAMILYRELATIONSHIPS
  is '家庭关系';
comment on column BWJF.EMPLOYEE.SOCIALRELATIONS
  is '社会关系';
comment on column BWJF.EMPLOYEE.RESUME
  is '个人简历';
comment on column BWJF.EMPLOYEE.REMARK
  is '备注';
comment on column BWJF.EMPLOYEE.PROBATIONPERIOD
  is '试用日期';
comment on column BWJF.EMPLOYEE.POSITIVEPHASE
  is '转正日期';
comment on column BWJF.EMPLOYEE.GRADUATIONDATE
  is '毕业时间';
comment on column BWJF.EMPLOYEE.STATUS
  is '员工是否离职（1：在职，0：离职，默认在职）';
comment on column BWJF.EMPLOYEE.TELEPHONE
  is '电话';
comment on column BWJF.EMPLOYEE.QQ
  is 'QQ';
alter table BWJF.EMPLOYEE
  add constraint PK_EMPLOYEEID primary key (EMPLOYEEID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table BWJF.EMPLOYEE
  add constraint FK_DEPARTMENTID foreign key (DEPARTMENTID)
  references BWJF.DEPARTMENT (DEPARTMENTID);
create index BWJF.I_EMPLOYEE_NAME on BWJF.EMPLOYEE (NAME)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index BWJF.I_EMPOYEE_DEPRATMENT on BWJF.EMPLOYEE (DEPARTMENTID)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table ROLE
prompt ===================
prompt
create table BWJF.ROLE
(
  ROLEID NUMBER not null,
  NAME   VARCHAR2(20)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column BWJF.ROLE.ROLEID
  is '角色ID(主键)';
comment on column BWJF.ROLE.NAME
  is '角色名称';
alter table BWJF.ROLE
  add constraint PK_ROLEID primary key (ROLEID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table ACCOUNT
prompt ======================
prompt
create table BWJF.ACCOUNT
(
  ACCOUNTID  VARCHAR2(50) not null,
  EMPLOYEEID NUMBER,
  ROLEID     NUMBER,
  AREAID     NUMBER,
  PASSWORD   VARCHAR2(50),
  STATUS     NUMBER(1) default 1,
  CREATEDATE DATE,
  CREATEBY   VARCHAR2(50),
  UPDATEDATE DATE,
  UPDATEBY   VARCHAR2(50)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column BWJF.ACCOUNT.ACCOUNTID
  is '账户ID（主键）';
comment on column BWJF.ACCOUNT.EMPLOYEEID
  is '员工外键';
comment on column BWJF.ACCOUNT.ROLEID
  is '角色外键';
comment on column BWJF.ACCOUNT.AREAID
  is '区域外键';
comment on column BWJF.ACCOUNT.PASSWORD
  is '账户密码';
comment on column BWJF.ACCOUNT.STATUS
  is '账户状态（员工是否离职，1：在职，0：离职，默认在职）';
comment on column BWJF.ACCOUNT.CREATEDATE
  is '创建时间';
comment on column BWJF.ACCOUNT.CREATEBY
  is '创建人';
comment on column BWJF.ACCOUNT.UPDATEDATE
  is '更新时间';
comment on column BWJF.ACCOUNT.UPDATEBY
  is '更新人';
alter table BWJF.ACCOUNT
  add constraint PK_ACCOUNTID primary key (ACCOUNTID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table BWJF.ACCOUNT
  add constraint FK_AREAID foreign key (AREAID)
  references BWJF.AREA (AREAID);
alter table BWJF.ACCOUNT
  add constraint FK_EMPLOYEEID foreign key (EMPLOYEEID)
  references BWJF.EMPLOYEE (EMPLOYEEID);
alter table BWJF.ACCOUNT
  add constraint FK_ROLEID foreign key (ROLEID)
  references BWJF.ROLE (ROLEID);
create index BWJF.I_ACCOUNT_AREA on BWJF.ACCOUNT (AREAID)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index BWJF.I_ACCOUNT_EMPLOYEE on BWJF.ACCOUNT (EMPLOYEEID)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index BWJF.I_ACCOUNT_ROLE on BWJF.ACCOUNT (ROLEID)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table ASCC
prompt ===================
prompt
create table BWJF.ASCC
(
  ASCCID          NUMBER not null,
  YEAR            VARCHAR2(10),
  HOUSEHOLDNUMBER NUMBER,
  CREATEDATE      DATE,
  UPDATEDATE      DATE,
  CREATEBY        VARCHAR2(50),
  AREAID          NUMBER
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column BWJF.ASCC.ASCCID
  is '年服务费收取户数编号（主键）';
comment on column BWJF.ASCC.YEAR
  is '年份';
comment on column BWJF.ASCC.HOUSEHOLDNUMBER
  is '户数';
comment on column BWJF.ASCC.CREATEDATE
  is '创建时间';
comment on column BWJF.ASCC.UPDATEDATE
  is '更新时间';
comment on column BWJF.ASCC.CREATEBY
  is '创建人';
comment on column BWJF.ASCC.AREAID
  is '所属区域（外键）';
alter table BWJF.ASCC
  add constraint PK_ASCCID primary key (ASCCID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table BWJF.ASCC
  add constraint FK_ASCCACCOUNTID foreign key (CREATEBY)
  references BWJF.ACCOUNT (ACCOUNTID);
alter table BWJF.ASCC
  add constraint FK_ASCCAREAID foreign key (AREAID)
  references BWJF.AREA (AREAID);
create index BWJF.I_ASCC_AREA on BWJF.ASCC (AREAID)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table CITY
prompt ===================
prompt
create table BWJF.CITY
(
  CITYID NUMBER not null,
  NAME   VARCHAR2(50),
  STATUS NUMBER(1) default 1
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column BWJF.CITY.CITYID
  is '城市ID';
comment on column BWJF.CITY.NAME
  is '城市名称';
comment on column BWJF.CITY.STATUS
  is '是否有效（1：有效 0：无效）';
alter table BWJF.CITY
  add constraint PK_CITYID primary key (CITYID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table COLLECTMONEY
prompt ===========================
prompt
create table BWJF.COLLECTMONEY
(
  UUID     VARCHAR2(100) not null,
  REVENUE  NUMBER,
  TRANSFER NUMBER
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column BWJF.COLLECTMONEY.UUID
  is '唯一验证标识（主键）';
comment on column BWJF.COLLECTMONEY.REVENUE
  is '收入金额';
comment on column BWJF.COLLECTMONEY.TRANSFER
  is '转账金额';
alter table BWJF.COLLECTMONEY
  add constraint PK_UUID primary key (UUID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table EQUIPMENT
prompt ========================
prompt
create table BWJF.EQUIPMENT
(
  EQUIPMENTID NUMBER not null,
  NAME        VARCHAR2(50),
  UNITPRICE   NUMBER
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column BWJF.EQUIPMENT.EQUIPMENTID
  is '设备编号（主键）';
comment on column BWJF.EQUIPMENT.NAME
  is '设备名称';
comment on column BWJF.EQUIPMENT.UNITPRICE
  is '单价';
alter table BWJF.EQUIPMENT
  add constraint PK_EQUIPMENTID primary key (EQUIPMENTID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table ESCALATIONTAX
prompt ============================
prompt
create table BWJF.ESCALATIONTAX
(
  ESCALATIONTAXID NUMBER not null,
  NAME            VARCHAR2(50),
  PRICE           NUMBER,
  AREAID          NUMBER,
  STOCK           NUMBER,
  BADDISC         NUMBER
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column BWJF.ESCALATIONTAX.ESCALATIONTAXID
  is '报税盘编号（主键）';
comment on column BWJF.ESCALATIONTAX.NAME
  is '报税盘名称';
comment on column BWJF.ESCALATIONTAX.PRICE
  is '报税盘价格';
comment on column BWJF.ESCALATIONTAX.AREAID
  is '区域编号（外键）';
comment on column BWJF.ESCALATIONTAX.STOCK
  is '库存';
comment on column BWJF.ESCALATIONTAX.BADDISC
  is '坏盘库存';
alter table BWJF.ESCALATIONTAX
  add constraint PK_ESCALATIONTAXID primary key (ESCALATIONTAXID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table BWJF.ESCALATIONTAX
  add constraint FK_ESCALATIONTAX_AREAID foreign key (AREAID)
  references BWJF.AREA (AREAID);

prompt
prompt Creating table EUM_STATUS
prompt =========================
prompt
create table BWJF.EUM_STATUS
(
  STATUS_ID NUMBER(4),
  NAME      VARCHAR2(10)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table EUM_STATUS_2
prompt ===========================
prompt
create table BWJF.EUM_STATUS_2
(
  STATUS_ID NUMBER(4),
  NAME      VARCHAR2(10)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table MENU
prompt ===================
prompt
create table BWJF.MENU
(
  MENUID      NUMBER not null,
  PARENTID    NUMBER,
  DESCRIPTION VARCHAR2(50),
  LINK        VARCHAR2(50),
  NAME        VARCHAR2(50)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column BWJF.MENU.MENUID
  is '菜单ID（主键）';
comment on column BWJF.MENU.PARENTID
  is '父菜单ID（内联外键）';
comment on column BWJF.MENU.DESCRIPTION
  is '菜单描述';
comment on column BWJF.MENU.LINK
  is '菜单跳转链接';
comment on column BWJF.MENU.NAME
  is '菜单名称';
alter table BWJF.MENU
  add constraint PK_MENUID primary key (MENUID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table BWJF.MENU
  add constraint FK_MENUPARENT foreign key (PARENTID)
  references BWJF.MENU (MENUID) on delete cascade;
create index BWJF.I_MENU_PARENT on BWJF.MENU (PARENTID)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table SERVICECHARGE
prompt ============================
prompt
create table BWJF.SERVICECHARGE
(
  SERVICECHARGEID NUMBER not null,
  FAMILYTYPE      VARCHAR2(50),
  PLATETYPE       VARCHAR2(50),
  PRICE           NUMBER
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column BWJF.SERVICECHARGE.SERVICECHARGEID
  is '服务费编号';
comment on column BWJF.SERVICECHARGE.FAMILYTYPE
  is '户型';
comment on column BWJF.SERVICECHARGE.PLATETYPE
  is '盘型';
comment on column BWJF.SERVICECHARGE.PRICE
  is '价格';
alter table BWJF.SERVICECHARGE
  add constraint PK_SERVICECHARGEID primary key (SERVICECHARGEID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table TAXDISC
prompt ======================
prompt
create table BWJF.TAXDISC
(
  TAXDISCID   NUMBER not null,
  USERTYPE    VARCHAR2(50),
  TAXDISCTYPE VARCHAR2(50),
  PRICE       NUMBER,
  AREAID      NUMBER,
  STOCK       NUMBER,
  BADDISC     NUMBER
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column BWJF.TAXDISC.TAXDISCID
  is '税控盘编号（主键）';
comment on column BWJF.TAXDISC.USERTYPE
  is '用户类型';
comment on column BWJF.TAXDISC.TAXDISCTYPE
  is '税盘类型';
comment on column BWJF.TAXDISC.PRICE
  is '价格';
comment on column BWJF.TAXDISC.AREAID
  is '区域编号（外键）';
comment on column BWJF.TAXDISC.STOCK
  is '库存';
comment on column BWJF.TAXDISC.BADDISC
  is '坏盘库存';
alter table BWJF.TAXDISC
  add constraint PK_TAXDISCID primary key (TAXDISCID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table BWJF.TAXDISC
  add constraint FK_TAXDISC_AREAID foreign key (AREAID)
  references BWJF.AREA (AREAID);

prompt
prompt Creating table PERFORMANCEINFO
prompt ==============================
prompt
create table BWJF.PERFORMANCEINFO
(
  PERFORMANCEINFOID NUMBER not null,
  EMPLOYEEID        NUMBER,
  EQUIPMENTID       NUMBER,
  SERVICECHARGEID   NUMBER,
  QUANTITY          NUMBER,
  CREATEDATE        DATE,
  UPDATEDATE        DATE,
  ISINVOICE         NUMBER(1) default 0,
  UUID              VARCHAR2(50),
  TAXDISCID         NUMBER,
  ESCALATIONTAXID   NUMBER,
  DATATIME          DATE
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column BWJF.PERFORMANCEINFO.PERFORMANCEINFOID
  is '绩效信息表编号（主键）';
comment on column BWJF.PERFORMANCEINFO.EMPLOYEEID
  is '员工编号（外键）';
comment on column BWJF.PERFORMANCEINFO.EQUIPMENTID
  is '设备编号（外键）';
comment on column BWJF.PERFORMANCEINFO.SERVICECHARGEID
  is '服务费外键（外键）';
comment on column BWJF.PERFORMANCEINFO.QUANTITY
  is '数量（设备，或者服务费户数）';
comment on column BWJF.PERFORMANCEINFO.CREATEDATE
  is '创建时间';
comment on column BWJF.PERFORMANCEINFO.UPDATEDATE
  is '更新时间';
comment on column BWJF.PERFORMANCEINFO.ISINVOICE
  is '是否开具发票';
comment on column BWJF.PERFORMANCEINFO.UUID
  is '唯一收款标识（外键）';
comment on column BWJF.PERFORMANCEINFO.TAXDISCID
  is '税控盘编号（外键）';
comment on column BWJF.PERFORMANCEINFO.ESCALATIONTAXID
  is '报税盘编号（外键）';
comment on column BWJF.PERFORMANCEINFO.DATATIME
  is '数据时间';
alter table BWJF.PERFORMANCEINFO
  add constraint PK_PERFORMANCEINFOID primary key (PERFORMANCEINFOID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table BWJF.PERFORMANCEINFO
  add constraint FK_EQUIPMENTID foreign key (EQUIPMENTID)
  references BWJF.EQUIPMENT (EQUIPMENTID);
alter table BWJF.PERFORMANCEINFO
  add constraint FK_ESCALATIONTAXID foreign key (ESCALATIONTAXID)
  references BWJF.ESCALATIONTAX (ESCALATIONTAXID);
alter table BWJF.PERFORMANCEINFO
  add constraint FK_INFO_EMPLOYEEID foreign key (EMPLOYEEID)
  references BWJF.EMPLOYEE (EMPLOYEEID);
alter table BWJF.PERFORMANCEINFO
  add constraint FK_SERVICECHARGEID foreign key (SERVICECHARGEID)
  references BWJF.SERVICECHARGE (SERVICECHARGEID);
alter table BWJF.PERFORMANCEINFO
  add constraint FK_TAXDISCID foreign key (TAXDISCID)
  references BWJF.TAXDISC (TAXDISCID);
alter table BWJF.PERFORMANCEINFO
  add constraint FK_UUID foreign key (UUID)
  references BWJF.COLLECTMONEY (UUID);
create index BWJF.I_INFO_DATATIME on BWJF.PERFORMANCEINFO (DATATIME)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index BWJF.I_INFO_EMPLOYEE on BWJF.PERFORMANCEINFO (EMPLOYEEID)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index BWJF.I_INFO_EQUIPMENT on BWJF.PERFORMANCEINFO (EQUIPMENTID)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index BWJF.I_INFO_ESCALTION on BWJF.PERFORMANCEINFO (ESCALATIONTAXID)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index BWJF.I_INFO_SERVICECHARGE on BWJF.PERFORMANCEINFO (SERVICECHARGEID)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index BWJF.I_INFO_TAX on BWJF.PERFORMANCEINFO (TAXDISCID)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table PROVINCE
prompt =======================
prompt
create table BWJF.PROVINCE
(
  PROVINCEID NUMBER not null,
  NAME       VARCHAR2(50),
  STATUS     NUMBER(1) default 1
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column BWJF.PROVINCE.PROVINCEID
  is '省ID';
comment on column BWJF.PROVINCE.NAME
  is '省名称';
comment on column BWJF.PROVINCE.STATUS
  is '是否有效（1：有效 0：无效）';
alter table BWJF.PROVINCE
  add constraint PK_PROVINCEID primary key (PROVINCEID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table ROLEMENU
prompt =======================
prompt
create table BWJF.ROLEMENU
(
  ROLEMENUID NUMBER not null,
  MENUID     NUMBER,
  ROLEID     NUMBER
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column BWJF.ROLEMENU.ROLEMENUID
  is '角色菜单ID（主键）';
comment on column BWJF.ROLEMENU.MENUID
  is '菜单ID（外键）';
comment on column BWJF.ROLEMENU.ROLEID
  is '角色ID（外键）';
alter table BWJF.ROLEMENU
  add constraint PK_ROLEMENUID primary key (ROLEMENUID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table BWJF.ROLEMENU
  add constraint FK_MENUID foreign key (MENUID)
  references BWJF.MENU (MENUID);
alter table BWJF.ROLEMENU
  add constraint FK_ROLE foreign key (ROLEID)
  references BWJF.ROLE (ROLEID);
create index BWJF.I_RM_MENU on BWJF.ROLEMENU (MENUID)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index BWJF.I_RM_ROLE on BWJF.ROLEMENU (ROLEID)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table TAXDISCREPLACE
prompt =============================
prompt
create table BWJF.TAXDISCREPLACE
(
  TAXDISCREPLACEID NUMBER not null,
  REPLACETYPE      NUMBER default 0,
  PRICE            NUMBER,
  QUANTITY         NUMBER,
  EMPLOYEEID       NUMBER,
  UUID             VARCHAR2(100),
  DATADATE         DATE,
  CREATETIME       DATE
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column BWJF.TAXDISCREPLACE.TAXDISCREPLACEID
  is '税控盘更换编号（主键）';
comment on column BWJF.TAXDISCREPLACE.REPLACETYPE
  is '更换类型（有偿：1/免费：0）';
comment on column BWJF.TAXDISCREPLACE.PRICE
  is '价格';
comment on column BWJF.TAXDISCREPLACE.QUANTITY
  is '数量';
comment on column BWJF.TAXDISCREPLACE.EMPLOYEEID
  is '员工编号（外键）';
comment on column BWJF.TAXDISCREPLACE.UUID
  is '收款标识';
comment on column BWJF.TAXDISCREPLACE.DATADATE
  is '数据日期';
comment on column BWJF.TAXDISCREPLACE.CREATETIME
  is '创建时间';
alter table BWJF.TAXDISCREPLACE
  add constraint PK_TAXDISCREPLACEID primary key (TAXDISCREPLACEID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table BWJF.TAXDISCREPLACE
  add constraint FK_TDR_EMPLOYEEID foreign key (EMPLOYEEID)
  references BWJF.EMPLOYEE (EMPLOYEEID);
alter table BWJF.TAXDISCREPLACE
  add constraint FK_TDR_UUID foreign key (UUID)
  references BWJF.COLLECTMONEY (UUID);
create index BWJF.I_TR_DATATIME on BWJF.TAXDISCREPLACE (DATADATE)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index BWJF.I_TR_EMPLOYEE on BWJF.TAXDISCREPLACE (EMPLOYEEID)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create index BWJF.I_TR_UUID on BWJF.TAXDISCREPLACE (UUID)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table TOWN
prompt ===================
prompt
create table BWJF.TOWN
(
  TOWNID NUMBER not null,
  NAME   VARCHAR2(50),
  STATUS NUMBER(1) default 1
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column BWJF.TOWN.TOWNID
  is '乡镇ID';
comment on column BWJF.TOWN.NAME
  is '乡镇名称';
comment on column BWJF.TOWN.STATUS
  is '是否有效（1：有效 0：无效）';
alter table BWJF.TOWN
  add constraint PK_TOWNID primary key (TOWNID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table ZZSFP_ACCOUNT
prompt ============================
prompt
create table BWJF.ZZSFP_ACCOUNT
(
  ACCTID          INTEGER not null,
  ACCTNAME        VARCHAR2(64),
  ACCTNICKNAME    VARCHAR2(64),
  ACCTPASSWORD    VARCHAR2(64),
  ACCTSTATE       NUMBER(2) default '0',
  ACCTSUPER       NUMBER(1) default '0',
  ACCTDELETESTATE NUMBER(1) default '0',
  CREATETIME      DATE,
  CREATOR         VARCHAR2(64)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table BWJF.ZZSFP_ACCOUNT
  add primary key (ACCTID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create unique index BWJF.ACCTNAME on BWJF.ZZSFP_ACCOUNT (ACCTNAME)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table ZZSFP_ACCOUNT_ROLE
prompt =================================
prompt
create table BWJF.ZZSFP_ACCOUNT_ROLE
(
  AOID      NUMBER(20) not null,
  ACCTNAME  VARCHAR2(64),
  ROLELABEL VARCHAR2(64),
  ADDTIME   DATE default sysdate not null
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table BWJF.ZZSFP_ACCOUNT_ROLE
  add primary key (AOID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table ZZSFP_MODULE
prompt ===========================
prompt
create table BWJF.ZZSFP_MODULE
(
  MODULEID        NUMBER(20) not null,
  MODULENAME      VARCHAR2(64),
  MODULECODE      VARCHAR2(12) default '0',
  MODULESUPERCODE VARCHAR2(12),
  MODULEPAGE      VARCHAR2(128),
  MODULELEVEL     NUMBER(1) default '0',
  ADDTIME         DATE default sysdate not null
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table BWJF.ZZSFP_MODULE
  add primary key (MODULEID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create unique index BWJF.MODULECODE on BWJF.ZZSFP_MODULE (MODULECODE)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create unique index BWJF.MODULENAME on BWJF.ZZSFP_MODULE (MODULENAME)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create unique index BWJF.MODULEPAGE on BWJF.ZZSFP_MODULE (MODULEPAGE)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table ZZSFP_ROLE
prompt =========================
prompt
create table BWJF.ZZSFP_ROLE
(
  ROLEID          NUMBER(20) not null,
  ROLENAME        VARCHAR2(128),
  ROLEDESCRIPTION VARCHAR2(1024),
  ROLELABEL       VARCHAR2(64),
  CREATETIME      DATE,
  CREATOR         VARCHAR2(64),
  MODDATE         DATE default sysdate not null
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table BWJF.ZZSFP_ROLE
  add primary key (ROLEID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
create unique index BWJF.ROLELABEL on BWJF.ZZSFP_ROLE (ROLELABEL)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table ZZSFP_ROLE_MODULE
prompt ================================
prompt
create table BWJF.ZZSFP_ROLE_MODULE
(
  ID              NUMBER(20) not null,
  ROLELABEL       VARCHAR2(64),
  MODULECODE      VARCHAR2(12),
  MOSULESUPERCODE VARCHAR2(12),
  FINDS           NUMBER(1) default '0',
  ADDS            NUMBER(1) default '0',
  DELETES         NUMBER(1) default '0',
  MODIFYS         NUMBER(1) default '0',
  ADDDATE         DATE default sysdate not null
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table BWJF.ZZSFP_ROLE_MODULE
  add primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating sequence AREA_AUTOINC_SEQ
prompt ==================================
prompt
create sequence BWJF.AREA_AUTOINC_SEQ
minvalue 1
maxvalue 99999999
start with 103
increment by 1
nocache
order;

prompt
prompt Creating sequence ASCC_AUTOINC_SEQ
prompt ==================================
prompt
create sequence BWJF.ASCC_AUTOINC_SEQ
minvalue 1
maxvalue 99999999999
start with 39681
increment by 1
cache 20;

prompt
prompt Creating sequence DEPARTMENT_AUTOINC_SEQ
prompt ========================================
prompt
create sequence BWJF.DEPARTMENT_AUTOINC_SEQ
minvalue 1
maxvalue 99999999
start with 69
increment by 1
nocache
order;

prompt
prompt Creating sequence EMPLOYEE_ATUOINC_SEQ
prompt ======================================
prompt
create sequence BWJF.EMPLOYEE_ATUOINC_SEQ
minvalue 1
maxvalue 999999
start with 921
increment by 1
cache 20
order;

prompt
prompt Creating sequence EQUIPMENTRECORD_AUTOINC_SEQ
prompt =============================================
prompt
create sequence BWJF.EQUIPMENTRECORD_AUTOINC_SEQ
minvalue 1
maxvalue 99999999999
start with 61
increment by 1
cache 20;

prompt
prompt Creating sequence EQUIPMENT_AUTOINC_SEQ
prompt =======================================
prompt
create sequence BWJF.EQUIPMENT_AUTOINC_SEQ
minvalue 1
maxvalue 99999999999
start with 41
increment by 1
cache 20;

prompt
prompt Creating sequence ETR_AUTOINC_SEQ
prompt =================================
prompt
create sequence BWJF.ETR_AUTOINC_SEQ
minvalue 1
maxvalue 999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence MENU_AUTOINC_SEQ
prompt ==================================
prompt
create sequence BWJF.MENU_AUTOINC_SEQ
minvalue 1
maxvalue 99999999
start with 71
increment by 1
nocache
order;

prompt
prompt Creating sequence PERFORMANCEINFO_AUTOINC_SEQ
prompt =============================================
prompt
create sequence BWJF.PERFORMANCEINFO_AUTOINC_SEQ
minvalue 1
maxvalue 999999999999
start with 18361
increment by 1
cache 20;

prompt
prompt Creating sequence ROLEMENU_ATUOINC_SEQ
prompt ======================================
prompt
create sequence BWJF.ROLEMENU_ATUOINC_SEQ
minvalue 1
maxvalue 999999
start with 1261
increment by 1
cache 20
order;

prompt
prompt Creating sequence ROLE_AUTOINC_SEQ
prompt ==================================
prompt
create sequence BWJF.ROLE_AUTOINC_SEQ
minvalue 1
maxvalue 999999
start with 221
increment by 1
cache 20
order;

prompt
prompt Creating sequence SCR_AUTOINC_SEQ
prompt =================================
prompt
create sequence BWJF.SCR_AUTOINC_SEQ
minvalue 1
maxvalue 9999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence SERVICECHARGE_AUTOINC_SEQ
prompt ===========================================
prompt
create sequence BWJF.SERVICECHARGE_AUTOINC_SEQ
minvalue 1
maxvalue 99999999999999
start with 21
increment by 1
cache 20;

prompt
prompt Creating sequence TAXDISCRECORD_AUTOINC_SEQ
prompt ===========================================
prompt
create sequence BWJF.TAXDISCRECORD_AUTOINC_SEQ
minvalue 1
maxvalue 999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence TAXDISCREPLACE_ATUOINC_SEQ
prompt ============================================
prompt
create sequence BWJF.TAXDISCREPLACE_ATUOINC_SEQ
minvalue 1
maxvalue 999999999999999
start with 2641
increment by 1
cache 20;

prompt
prompt Creating sequence TAXDISC_AUTOINC_SEQ
prompt =====================================
prompt
create sequence BWJF.TAXDISC_AUTOINC_SEQ
minvalue 1
maxvalue 9999999999999
start with 21
increment by 1
cache 20;

prompt
prompt Creating trigger AREA_AUTOINC_TG
prompt ================================
prompt
create or replace trigger BWJF.area_autoinc_tg
before insert on area for each row
begin
select area_autoinc_seq.nextval into :new.areaId from dual;
end area_autoinc_tg;
/

prompt
prompt Creating trigger ASCC_AUTOINC_TG
prompt ================================
prompt
create or replace trigger BWJF.ascc_autoinc_tg
  before insert
  on ascc 
  for each row
declare
  -- local variables here
begin
  select ascc_autoinc_seq.nextval into :new.asccId from dual;
end ascc_autoinc_tg;
/

prompt
prompt Creating trigger DEPARTMENT_AUTOINC_TG
prompt ======================================
prompt
create or replace trigger BWJF.department_autoinc_tg
before insert on department for each row
begin
select department_autoinc_seq.nextval into :new.departmentId from dual;
end department_autoinc_tg;
/

prompt
prompt Creating trigger EMPLOYEE_AUTOINC_TG
prompt ====================================
prompt
create or replace trigger BWJF.employee_autoinc_tg
before insert on employee for each row
begin
select EMPLOYEE_ATUOINC_SEQ.nextval into :new.employeeId from dual;
end employee_autoinc_tg;
/

prompt
prompt Creating trigger EQUIPMENT_AUTOINC_TG
prompt =====================================
prompt
create or replace trigger BWJF.equipment_autoinc_tg
  before insert
  on equipment 
  for each row
declare
  -- local variables here
begin
  select equipment_autoinc_seq.nextval into :new.equipmentId from dual;
end equipment_autoinc_tg;
/

prompt
prompt Creating trigger MENU_AUTOINC_TG
prompt ================================
prompt
create or replace trigger BWJF.menu_autoinc_tg
before insert on menu for each row
begin
select menu_autoinc_seq.nextval into :new.menuId from dual;
end menu_autoinc_tg;
/

prompt
prompt Creating trigger PERFORMANCEINFO_AUTOINC_TG
prompt ===========================================
prompt
create or replace trigger BWJF.performanceinfo_autoinc_tg
  before insert
  on performanceinfo 
  for each row
declare
  -- local variables here
begin
  select performanceinfo_autoinc_seq.nextval into :new.performanceinfoId from dual;
end performanceinfo_autoinc_tg;
/

prompt
prompt Creating trigger ROLEMENU_AUTOINC_TG
prompt ====================================
prompt
create or replace trigger BWJF.rolemenu_autoinc_tg
before insert on rolemenu for each row
begin
select rolemenu_atuoinc_seq.nextval into :new.rolemenuId from dual;
end rolemenu_autoinc_tg;
/

prompt
prompt Creating trigger ROLE_AUTOINC_TG
prompt ================================
prompt
create or replace trigger BWJF.role_autoinc_tg
before insert on role for each row
begin
select role_autoinc_seq.nextval into :new.roleId from dual;
end role_autoinc_tg;
/

prompt
prompt Creating trigger SERVICECHARGE_AUTOINC_TG
prompt =========================================
prompt
create or replace trigger BWJF.servicecharge_autoinc_tg
  before insert
  on servicecharge 
  for each row
declare
  -- local variables here
begin
  select servicecharge_autoinc_seq.nextval into :new.servicechargeId from dual;
end servicecharge_autoinc_tg;
/

prompt
prompt Creating trigger TAXDISCREPLACE_AUTOINC_TG
prompt ==========================================
prompt
create or replace trigger BWJF.taxdiscreplace_autoinc_tg
  before insert
  on taxdiscreplace 
  for each row
declare
  -- local variables here
begin
  select TAXDISCREPLACE_ATUOINC_SEQ.nextval into :new.taxdiscreplaceId from dual;
end taxdiscreplace_autoinc_tg;
/

prompt
prompt Creating trigger TAXDISC_AUTOINC_TG
prompt ===================================
prompt
create or replace trigger BWJF.taxdisc_autoinc_tg
  before insert
  on taxdisc 
  for each row
declare
  -- local variables here
begin
  select taxdisc_autoinc_seq.nextval into :new.taxdiscId from dual;
end taxdisc_autoinc_tg;
/


spool off
