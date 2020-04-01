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
CREATE SEQUENCE SEQ_PRODUCT INCREMENT BY 1 MINVALUE 0 NOCYCLE NOCACHE NOORDER ;