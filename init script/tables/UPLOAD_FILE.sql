 CREATE TABLE `UPLOAD_FILE`
   (	`ID` VARCHAR2(30 BYTE) NOT NULL ENABLE,
   `FILE_NAME` VARCHAR2(100),
	`CONTENT` BLOB, 
	`LAST_UPDATE_DATE` DATE,
	`LAST_UPDATE_BY` VARCHAR2(50 BYTE), 
	 CONSTRAINT `BLOB_CONTENT_PK` PRIMARY KEY (`ID`)
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE `DMH_DATA_COMP`  ENABLE
   ) 