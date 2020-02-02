DROP TABLE IF EXISTS `test`.`contactos`;
CREATE TABLE  `test`.`contactos` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `nombre` varchar(255) default NULL,
  `comentario` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;