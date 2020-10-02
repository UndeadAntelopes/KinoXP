-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema kinoxp
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema kinoxp
-- -----------------------------------------------------
DROP DATABASE IF EXISTS `kinoxp`;
CREATE SCHEMA IF NOT EXISTS `kinoxp` DEFAULT CHARACTER SET utf8 ;
USE `kinoxp` ;
-- -----------------------------------------------------
-- Table `kinoxp`.`genres`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kinoxp`.`genres` (
  `genres_id` INT NOT NULL AUTO_INCREMENT,
  `genre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`genres_id`),
  UNIQUE INDEX `genres_id_UNIQUE` (`genres_id` ASC) VISIBLE)
ENGINE = InnoDB;
-- -----------------------------------------------------
-- Table `kinoxp`.`movies`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kinoxp`.`movies` (
  `movie_id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `description` VARCHAR(200) NOT NULL,
  `duration` TIME NOT NULL,
  `age_limit` VARCHAR(15) NOT NULL,
  `genres_id` INT NOT NULL,
  UNIQUE INDEX `Movie_ID_UNIQUE` (`movie_id` ASC) VISIBLE,
  PRIMARY KEY (`movie_id`),
  INDEX `fk_movies_genres1_idx` (`genres_id` ASC) VISIBLE,
  CONSTRAINT `fk_movies_genres1`
    FOREIGN KEY (`genres_id`)
    REFERENCES `kinoxp`.`genres` (`genres_id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
-- -----------------------------------------------------
-- Table `kinoxp`.`schedule`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kinoxp`.`schedule` (
  `schedule_id` INT NOT NULL AUTO_INCREMENT,
  `start` TIMESTAMP NOT NULL,
  `end` TIMESTAMP NOT NULL,
  PRIMARY KEY (`schedule_id`),
  UNIQUE INDEX `schedule_id_UNIQUE` (`schedule_id` ASC) VISIBLE)
ENGINE = InnoDB;
-- -----------------------------------------------------
-- Table `kinoxp`.`movies_has_schedule`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kinoxp`.`movies_has_schedule` (
  `movies_movie_id` INT NOT NULL,
  `schedule_schedule_id` INT NOT NULL,
  PRIMARY KEY (`movies_movie_id`, `schedule_schedule_id`),
  INDEX `fk_movies_has_schedule_schedule1_idx` (`schedule_schedule_id` ASC) VISIBLE,
  INDEX `fk_movies_has_schedule_movies_idx` (`movies_movie_id` ASC) VISIBLE,
  CONSTRAINT `fk_movies_has_schedule_movies`
    FOREIGN KEY (`movies_movie_id`)
    REFERENCES `kinoxp`.`movies` (`movie_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_movies_has_schedule_schedule1`
    FOREIGN KEY (`schedule_schedule_id`)
    REFERENCES `kinoxp`.`schedule` (`schedule_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

INSERT INTO `kinoxp`.`genres` VALUES
(1, 'Sci-Fi'),
(2, 'Erotic'),
(3, 'Action'),
(4, 'Romance Comedy'),
(5, 'Comedy');

INSERT INTO `kinoxp`.`schedule` VALUES
(1, '2020-10-15 10:00:00', '2020-10-15 11:25:00'),
(2, '2020-10-15 12:00:00', '2020-10-15 12:50:00'),
(3, '2020-10-15 13:00:00', '2020-10-15 14:45:00'),
(4, '2020-10-15 15:00:00', '2020-10-15 16:00:00'),
(5, '2020-10-15 16:15:00', '2020-10-15 17:30:00');

INSERT INTO `kinoxp`.`movies` VALUES
(1, 'Invaders from the Moon', 'Joey thought it was just another normal day at the farm. He was so wrong ...', '01:25:00', '12+', 1),
(2, 'The new coworker', 'He never thought it can rise so high, but then he met her.', '00:50:00', '18+', 2),
(3, 'Payday', 'What should you do when the gouvernment steals from you. Johan took a bloody approach.', '01:45:00', '12+', 3),
(4, 'How I met your step-brother', 'Anna and Zoey thought that puberty is bad, until they have met Zoey new step-brother. Their lives were not the same.', '01:00:00', '12+', 4),
(5, 'What I did in Vegas', 'So what is in Vegas? There is desert, there are casinos, there are cheap hookers, and then ther is Mr. Chau.', '01:15:00', '12+', 5);

INSERT INTO `kinoxp`.`movies_has_schedule` VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5);