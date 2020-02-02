DROP TABLE IF EXISTS `test`.`personas`;
CREATE TABLE  `test`.`personas` (
  `id` int(11) NOT NULL auto_increment,
  `nombre` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

