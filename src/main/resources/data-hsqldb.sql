INSERT INTO products(id, name) VALUES 
(100, 'First Product'),
(101, 'Second Product'),
(102, 'Third product'),
(103, 'Fourth Product'),
(104, 'Fifth Product'),
(105, 'Sixth Product');

INSERT INTO product_relations (product_id, related_product_id) VALUES
(100, 101),
(100, 102),
(100, 103);