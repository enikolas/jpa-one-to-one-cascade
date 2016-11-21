CREATE TABLE IF NOT EXISTS `body_part` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));


CREATE TABLE IF NOT EXISTS `body_part_hit` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_body_part` INT NOT NULL,
  `perc_damage_hit` DECIMAL(4,2) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_body_part_hit_1_idx` (`id_body_part` ASC),
  CONSTRAINT `fk_body_part_hit_1`
    FOREIGN KEY (`id_body_part`)
    REFERENCES `body_part` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
