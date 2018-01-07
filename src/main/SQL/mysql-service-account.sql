CREATE USER 'al'@'localhost' IDENTIFIED BY 'theman244';

GRANT SELECT ON springguru.* to 'al'@'localhost';
GRANT INSERT ON springguru.* to 'al'@'localhost';
GRANT DELETE ON springguru.* to 'al'@'localhost';
GRANT UPDATE ON springguru.* to 'al'@'localhost';



CREATE USER 'al'@'localhost' IDENTIFIED BY 'theman244';

GRANT SELECT ON prod.* to 'al'@'localhost';
GRANT INSERT ON prod.* to 'al'@'localhost';
GRANT DELETE ON prod.* to 'al'@'localhost';
GRANT UPDATE ON prod.* to 'al'@'localhost';