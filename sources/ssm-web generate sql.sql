INSERT INTO `ssm_web`.`user_info` (`USERID`, `PETNAME`, `SEX`, `BIRTH`,
                                   `ICON`, `PHONE`, `EMAIL`, `ADDRESS`, `LEVEL`, `SIGNATURE`, `BRIEF`, `SYS_TIME`)
VALUES ('c53010a7-009f-11e7-9020-a0481c12b3a5', '寒江夜雨', '男', '19930314', '', '18609281937', 'ne_lucifer@163.com',
'陕西西安', '0','', NULL, CURDATE());

INSERT INTO `ssm_web`.`user_login` (`USERID`, `UNAME`, `UPHONE`, `UPASS`, `SYS_TIME`)
VALUES ('c53010a7-009f-11e7-9020-a0481c12b3a5', 'ne_lucifer', '18609281937', '1', CURDATE());

