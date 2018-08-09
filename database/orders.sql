--------------------------------------------------------
--  文件已创建 - 星期四-八月-09-2018   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table ORDERS
--------------------------------------------------------

  CREATE TABLE "RAINBOWSIX6"."ORDERS" 
   (	"ORDERID" NUMBER(20,0), 
	"COMID" NUMBER(20,0), 
	"ORDERSTATE" VARCHAR2(20 BYTE), 
	"BSID" NUMBER(20,0)
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;
REM INSERTING into RAINBOWSIX6.ORDERS
SET DEFINE OFF;
--------------------------------------------------------
--  Constraints for Table ORDERS
--------------------------------------------------------

  ALTER TABLE "RAINBOWSIX6"."ORDERS" MODIFY ("ORDERID" NOT NULL ENABLE);
