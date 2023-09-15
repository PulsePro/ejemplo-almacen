INSERT INTO albaran (id) VALUES
    ('5164228b-4fed-42ef-aff2-878a5eb3947d'),
    ('371c2cde-ae80-4b52-9ea9-f62732421256');

INSERT INTO producto (id, name) VALUES
    ('1a70c4f9-76e9-48fb-a6c0-7cd8b4afc5e3', 'Producto 1'),
    ('6c776f48-a148-469d-8975-05b6ae400dd8', 'Producto 2'),
    ('e693ad60-c98c-4b63-8758-abe3ca1574fb', 'Producto 3');

INSERT INTO albaran_producto (albaran_id, producto_id, cantidad) VALUES
    ('5164228b-4fed-42ef-aff2-878a5eb3947d', '1a70c4f9-76e9-48fb-a6c0-7cd8b4afc5e3', 5),
    ('5164228b-4fed-42ef-aff2-878a5eb3947d', '6c776f48-a148-469d-8975-05b6ae400dd8', 10),
    ('371c2cde-ae80-4b52-9ea9-f62732421256', '1a70c4f9-76e9-48fb-a6c0-7cd8b4afc5e3', 15),
    ('371c2cde-ae80-4b52-9ea9-f62732421256', 'e693ad60-c98c-4b63-8758-abe3ca1574fb', 22);
