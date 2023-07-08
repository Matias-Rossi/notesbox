USE notesbox;

DELIMITER $$

CREATE PROCEDURE sample_melodies()
BEGIN
    DECLARE userCount INT;

    SELECT COUNT(*) INTO userCount FROM users WHERE email = 'mr@mail.com';

    IF userCount = 0 THEN
        -- ADDRESS
        INSERT INTO addresses (id, disabled, apartment, city, country, floor, number, province, street)
        VALUES (1, false, NULL, 'Buenos Aires', 'Argentina', NULL, 210, 'CABA', 'Rivadavia');

        -- USER
        INSERT INTO users (type, id, disabled, email, hashed_password, name, address_id)
        VALUES ('Customer', 1, 0, 'mr@mail.com', '$argon2id$v=19$m=1024,t=1,p=1$+OCEBx7uYyWddQdF2d3FjA$82tFkTY9BEbAHU36co6mpPADADyjyuRODV5052GYYCE', 'Matias Rossi', 1);

        SELECT 'Sample user created' AS message;
    ELSE
        SELECT 'Sample user already present' AS message;
    END IF;

END$$

DELIMITER ;

CALL sample_melodies();
