drop database if exists ssm_web;
create database ssm_web;
use ssm_web;
/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2017/3/4 16:48:36                            */
/*==============================================================*/


drop table if exists BLOG;

drop table if exists BLOG_AGREE;

drop table if exists BLOG_COMMENT;

drop table if exists MODULE_INFO;

drop table if exists NOTE_INFO;

drop table if exists PLAN_INFO;

drop table if exists SYS_DICT;

drop table if exists SYS_INTERACTIVE_LOG;

drop table if exists SYS_OPERATE_LOG;

drop table if exists TASK_INFO;

drop table if exists USER_INFO;

drop table if exists USER_LOGIN;

/*==============================================================*/
/* Table: BLOG                                                  */
/*==============================================================*/
create table BLOG
(
   BLOGID               varchar(64) not null,
   USERID               varchar(64) not null,
   BIMG                 varchar(200),
   BTITLE               varchar(500) not null,
   BCONTENT2            text,
   BCONTENT3            text,
   BCONTENT4            text,
   BCONTENT             text not null,
   BTYPE                varchar(2) not null,
   SAVETIME             datetime not null,
   ISSUETIME            datetime not null,
   STATUS               char(2) not null,
   SYS_TIME             datetime not null,
   primary key (BLOGID, USERID)
);

/*==============================================================*/
/* Table: BLOG_AGREE                                            */
/*==============================================================*/
create table BLOG_AGREE
(
   AGREEID              varchar(64) not null,
   USERID               varchar(64) not null,
   ABLOGID              varchar(64) not null,
   AUSERID              varchar(64),
   STATUS               char(2) not null,
   SYS_TIME             datetime not null,
   primary key (AGREEID, USERID, ABLOGID)
);

/*==============================================================*/
/* Table: BLOG_COMMENT                                          */
/*==============================================================*/
create table BLOG_COMMENT
(
   COMMONID             varchar(64) not null,
   ASSESSEEID           varchar(64) not null,
   ARGUEDBID            varchar(64),
   ARGUEDMID            varchar(64),
   CRITICUID            varchar(64) not null,
   COMMON_CONTENT       varchar(2000) not null,
   COMMON_TIME          datetime not null,
   COMMON_TYPE          char(2) not null comment '0：文章一级评论；1：针对留言的评论',
   SYS_TIME             datetime not null,
   primary key (COMMONID, ASSESSEEID, CRITICUID)
);

/*==============================================================*/
/* Table: MODULE_INFO                                           */
/*==============================================================*/
create table MODULE_INFO
(
   MID                  varchar(64) not null,
   MNAME                varchar(20) not null,
   PID                  varchar(64),
   PNAME                varchar(20),
   DSTART               date comment '如类别项为0，则开始时间和结束时间非空',
   DEND                 date,
   MTYPE                char(2) not null comment '取值：0：项目；1：模块；2：子模块；
            如果类别为！0，则上级模块ID与名称不能为空',
   STATUS               char(1) not null,
   SYS_TIME             datetime not null,
   primary key (MID)
);

/*==============================================================*/
/* Table: NOTE_INFO                                             */
/*==============================================================*/
create table NOTE_INFO
(
   NOTEID               varchar(64),
   USERID               varchar(64),
   N_NAME               varchar(100),
   N_TITLE              varchar(200),
   N_CONTETN            varchar(4000),
   N_TYPE               char(2),
   SYS_TIME             datetime
);

/*==============================================================*/
/* Table: PLAN_INFO                                             */
/*==============================================================*/
create table PLAN_INFO
(
   PLANID               varchar(64) not null,
   USERID               varchar(64) not null,
   P_NAME               varchar(20) not null,
   P_CONTENT            varchar(200) not null,
   P_TYPE               varchar(20) not null,
   STATUS               char(2) not null,
   SYS_TIME             datetime not null,
   primary key (PLANID, USERID)
);

/*==============================================================*/
/* Table: SYS_DICT                                              */
/*==============================================================*/
create table SYS_DICT
(
   DID                  varchar(64) not null,
   DNAME                varchar(20),
   VID                  varchar(64) not null,
   VNAME                varchar(30),
   ENDDATE              date,
   EXPLAINS             varchar(200),
   STATUS               char(1) not null,
   primary key (DID, VID)
);

/*==============================================================*/
/* Table: SYS_INTERACTIVE_LOG                                   */
/*==============================================================*/
create table SYS_INTERACTIVE_LOG
(
   LOGID                varchar(64) not null,
   CALLTIME             datetime not null,
   DATAINTO             text not null,
   CALLRES              text not null,
   CALLWAY              char(2),
   SYS_TIME             datetime not null,
   primary key (LOGID)
);

/*==============================================================*/
/* Table: SYS_OPERATE_LOG                                       */
/*==============================================================*/
create table SYS_OPERATE_LOG
(
   LOGID                varchar(64) not null,
   USERID               varchar(64) not null,
   FUNCID               varchar(2),
   FUNCNAME             varchar(20),
   CALLTIME             datetime,
   CALLWAY              char(2),
   SYS_TIME             datetime not null,
   primary key (LOGID)
);

/*==============================================================*/
/* Table: TASK_INFO                                             */
/*==============================================================*/
create table TASK_INFO
(
   TASKID               varchar(64) not null,
   USERID               varchar(64) not null,
   TNAME                varchar(20),
   TFROM                varchar(20),
   TBRIEF               varchar(30),
   TCONTENT             varchar(200),
   TWAY                 varchar(200),
   REMARK               varchar(200),
   TLEVEL               varchar(20) not null,
   TTYPE                varchar(20) not null,
   ASSIGNTIME           datetime,
   PSTART               datetime,
   PEND                 datetime,
   PUZZLES              varchar(200),
   MINDS                varchar(200),
   FSTART               datetime,
   FEND                 datetime,
   STATUS               char(1) not null,
   USEFLAG              char(1) not null,
   SYS_TIME             datetime not null,
   primary key (TASKID, USERID)
);

/*==============================================================*/
/* Table: USER_INFO                                             */
/*==============================================================*/
create table USER_INFO
(
   USERID               varchar(64) not null,
   PETNAME              varchar(15),
   NAME                 varchar(50),
   SEX                  varchar(10),
   BIRTH                datetime,
   ICON                 varchar(200),
   PHONE                varchar(20),
   EMAIL                varchar(30),
   ADDRESS              varchar(30),
   LEVEL                char(2) not null comment '0:普通用户；1:管理员；2：超管
            见字典表',
   SIGNATURE            varchar(30),
   BRIEF                varchar(50),
   SYS_TIME             datetime not null,
   primary key (USERID)
);

/*==============================================================*/
/* Table: USER_LOGIN                                            */
/*==============================================================*/
create table USER_LOGIN
(
   USERID               varchar(64) not null,
   UNAME                varchar(20) not null,
   UPHONE               varchar(15),
   UPASS                varchar(20) not null,
   TOKEN                varbinary(64),
   SYS_TIME             datetime not null,
   primary key (USERID)
);

alter table BLOG add constraint FK_Reference_4 foreign key (USERID)
      references USER_INFO (USERID) on delete restrict on update restrict;

alter table PLAN_INFO add constraint FK_Reference_3 foreign key (USERID)
      references USER_INFO (USERID) on delete restrict on update restrict;

alter table TASK_INFO add constraint FK_Reference_2 foreign key (USERID)
      references USER_INFO (USERID) on delete restrict on update restrict;

alter table USER_LOGIN add constraint FK_Reference_1 foreign key (USERID)
      references USER_INFO (USERID) on delete restrict on update restrict;

