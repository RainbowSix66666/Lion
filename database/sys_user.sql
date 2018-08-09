--------------------------------------------------------
--  文件已创建 - 星期四-八月-09-2018   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table SYS_USER
--------------------------------------------------------

  CREATE TABLE "RAINBOWSIX6"."SYS_USER" 
   (	"USERID" NUMBER(20,0), 
	"USERNAME" VARCHAR2(32 BYTE), 
	"USERPASSWORD" VARCHAR2(128 BYTE), 
	"BVOID" NUMBER(20,0), 
	"MVOID" NUMBER(20,0), 
	"PAYPACKAGEID" NUMBER(20,0), 
	"ROLENAME" VARCHAR2(32 BYTE)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
REM INSERTING into RAINBOWSIX6.SYS_USER
SET DEFINE OFF;
--------------------------------------------------------
--  DDL for Index SYS_C0011303
--------------------------------------------------------

  CREATE UNIQUE INDEX "RAINBOWSIX6"."SYS_C0011303" ON "RAINBOWSIX6"."SYS_USER" ("USERID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C0011304
--------------------------------------------------------

  CREATE UNIQUE INDEX "RAINBOWSIX6"."SYS_C0011304" ON "RAINBOWSIX6"."SYS_USER" ("USERNAME") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table SYS_USER
--------------------------------------------------------

  ALTER TABLE "RAINBOWSIX6"."SYS_USER" MODIFY ("USERNAME" NOT NULL ENABLE);
 
  ALTER TABLE "RAINBOWSIX6"."SYS_USER" MODIFY ("USERPASSWORD" NOT NULL ENABLE);
 
  ALTER TABLE "RAINBOWSIX6"."SYS_USER" ADD PRIMARY KEY ("USERID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS"  ENABLE;
 
  ALTER TABLE "RAINBOWSIX6"."SYS_USER" ADD UNIQUE ("USERNAME")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS"  ENABLE;
