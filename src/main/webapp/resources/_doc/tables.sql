CREATE TABLE TBL_PRODUCT (
	PNO NUMBER NOT NULL,
	TITLE VARCHAR2(100) NOT NULL,
	CONTENT VARCHAR2(2000) NOT NULL,
	WRITER VARCHAR2(100) NOT NULL,
	REGD8 DATE DEFAULT sysdate,
	MODD8 DATE DEFAULT sysdate,
	READCOUNT NUMBER DEFAULT 0 NULL,
	IMGFILE VARCHAR2(2000)
);
ALTER TABLE TBL_PRODUCT
ADD CONSTRAINT TBL_PRODUCT_PK PRIMARY KEY (PNO)
ENABLE;
CREATE SEQUENCE SEQ_PRODUCT INCREMENT BY 1 MINVALUE 0 NOCYCLE NOCACHE NOORDER;

----------------------------------------------------------------------notice------------------------------------------------
CREATE SEQUENCE SEQ_NOTICE START WITH 1 INCREMENT BY 1 NOCACHE;
CREATE TABLE tbl_NOTICE(
NNO NUMBER(10,0) NOT NULL,
NTITLE VARCHAR2(1000) NOT NULL,
NCONTENT varchar2(1000) NOT NULL,
NWRITER varchar2(100) NOT NULL,
NIMG VARCHAR2(2000),
NFILE VARCHAR2(2000),
REGD8 DATE DEFAULT sysdate,
MODD8 DATE DEFAULT sysdate,
READCOUNT NUMBER(10,0) DEFAULT 0
);
ALTER TABLE TBL_NOTICE
ADD CONSTRAINT pk_NOTICE PRIMARY key(NNO);
-----------------------member---------------------------
CREATE TABLE tbl_member(
email varchar2(1000) NOT NULL,
nickname varchar2(100) NOT NULL,
pwd varchar2(100) NOT NULL,
REGD8 DATE DEFAULT sysdate,
grade NUMBER DEFAULT 0
);
ALTER TABLE TBL_member
ADD CONSTRAINT pk_member PRIMARY key(email);
