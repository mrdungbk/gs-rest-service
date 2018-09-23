CREATE DATABASE `devicemngt` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;

CREATE TABLE `student` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(100) NOT NULL,
  `BRANCH` varchar(255) NOT NULL,
  `PERCENTAGE` int(3) NOT NULL,
  `PHONE` int(11) NOT NULL,
  `EMAIL` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `read_recordById`(IN emp_id int, IN email text)
BEGIN
    SELECT *
    FROM STUDENT
    WHERE ID = emp_id
      AND EMAIL = email;
  END$$
DELIMITER ;

