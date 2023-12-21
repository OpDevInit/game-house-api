INSERT INTO
    tb_games (email, name, password)
VALUES (
        'nina@gmail.com',
        'Nina Brown',
        '$2a$10$NYFZ/8WaQ3Qb6FCs.00jce4nxX9w7AkgWVsQCG6oUwTAcZqP9Flqu'
    );

INSERT INTO
    tb_games (email, name, password)
VALUES (
        'leia@gmail.com',
        'Leia Red',
        '$2a$10$NYFZ/8WaQ3Qb6FCs.00jce4nxX9w7AkgWVsQCG6oUwTAcZqP9Flqu'
    );

INSERT INTO tb_category (game_type) VALUES ('RPG');
INSERT INTO tb_category (game_type)VALUES ('RogueLike');

INSERT INTO tb_game_category (user_id, category_id) VALUES (1, 1);

INSERT INTO tb_game_category (user_id, category_id) VALUES (1, 2);

INSERT INTO tb_game_category (user_id, category_id) VALUES (2, 2);