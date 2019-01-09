create table orders
(
  OrderId     int auto_increment
    primary key,
  UPhone      varchar(11)    null,
  PId         int            null,
  AId         int            null,
  Money       decimal(10, 2) null,
  Expect      int            null,
  ExpectType  int            null,
  ExceptOther varchar(200)   null,
  OrderDate   datetime       null
)
  engine = MyISAM;

create index AId
  on orders (AId);

create index PId
  on orders (PId);

create index UPhone
  on orders (UPhone);

create table project
(
  PId         int auto_increment
    primary key,
  UPhone      varchar(11)    null,
  PName       varchar(60)    not null,
  PDesc       varchar(500)   not null,
  PSD         datetime       null,
  PED         datetime       null,
  PTarget     decimal(10, 2) null,
  PNM         decimal(10, 2) null,
  PNP         int            null,
  PMilestone  varchar(200)   not null,
  PCategoryId int            null,
  PRemark     varchar(200)   null,
  PMF         int            null,
  PLimit      int            null,
  PTeam       varchar(500)   null,
  PState      int            null,
  PPlan       varchar(500)   null
)
  engine = MyISAM;

create index PCategoryId
  on project (PCategoryId);

create index UPhone
  on project (UPhone);

create table projectcomment
(
  PCId     int auto_increment
    primary key,
  CPid     int          null,
  PCTime   datetime     null,
  PComment varchar(100) null,
  UPhone   varchar(11)  null
)
  engine = MyISAM;

create index CPid
  on projectcomment (CPid);

create index UPhone
  on projectcomment (UPhone);

create table projectimg
(
  ImgId   int auto_increment
    primary key,
  Pid     int         null,
  ImgPath varchar(50) null
)
  engine = MyISAM;

create index Pid
  on projectimg (Pid);

create table projecttype
(
  ProjectTypeId   int         not null
    primary key,
  ProjectTypeName varchar(30) null
)
  engine = MyISAM;

INSERT INTO ecommerce.projecttype (ProjectTypeId, ProjectTypeName) VALUES (1, '数码');
INSERT INTO ecommerce.projecttype (ProjectTypeId, ProjectTypeName) VALUES (2, '生活');
INSERT INTO ecommerce.projecttype (ProjectTypeId, ProjectTypeName) VALUES (3, '艺术');
create table users
(
  UPhone varchar(11) not null
    primary key,
  UName  varchar(20) not null,
  UPwd   varchar(32) not null,
  UType  int         not null,
  UFlag  int         not null
)
  engine = MyISAM;

create table usersaddress
(
  AId     int auto_increment
    primary key,
  Address varchar(60) not null,
  aUPhone varchar(11) null
)
  engine = MyISAM;

create index aUPhone
  on usersaddress (aUPhone);

create table usersinfo
(
  UPhone      varchar(11)  not null
    primary key,
  UName       varchar(20)  null,
  UZipCode    char(6)      not null,
  UEmail      varchar(100) not null,
  UCardNumber varchar(100) null
)
  engine = MyISAM;
