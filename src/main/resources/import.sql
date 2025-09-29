--user
INSERT INTO tb_user(display_name, username, password) VALUES ('Teste1', 'teste1','eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJ0ZXN0ZTEiLCJleHAiOjE3NTkyNjg2MTJ9.yKYMxrkOj1biqLpSF9GmLKeOyEh9PEpG4ooBia79MY_MdS55ctUYUJN4mNGR8aeErPeGzIG_3TlVE2iQ8UO_mw');
INSERT INTO tb_user(display_name, username, password) VALUES ('Teste2', 'teste2','eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJ0ZXN0ZTIiLCJleHAiOjE3NTkyNjg2Njd9.dXkF82gVEA-wga2uC0bv1cQwZoZhQScLOGgZJvgIrL9HXew9m0c1yZPC2391XOj_3keo-C49WuMoh5UK89e9Fg');


-- categorias
INSERT INTO tb_categoria (nome) VALUES ('Abstratos');
INSERT INTO tb_categoria (nome) VALUES ('Paisagens');
INSERT INTO tb_categoria (nome) VALUES ('Animais');
INSERT INTO tb_categoria (nome) VALUES ('Arte Clássica');
INSERT INTO tb_categoria (nome) VALUES ('Fotografias');

-- produtos
INSERT INTO tb_produto (nome, descricao, preco, url_imagem, categoria_id) VALUES ('Quadro Abstrato Cores Vibrantes','Tela em canvas com moldura de madeira, 70x100cm, pintura digital com formas geométricas coloridas.',299.90,'https://exemplo.com/quadros/abstrato1.jpg',1);
INSERT INTO tb_produto (nome, descricao, preco, url_imagem, categoria_id) VALUES ('Conjunto 3 Quadros Abstratos Minimalistas','Kit com 3 quadros 40x60cm cada, tons neutros, impressão em alta resolução.',459.00,'https://exemplo.com/quadros/abstrato2.jpg',1);
INSERT INTO tb_produto (nome, descricao, preco, url_imagem, categoria_id) VALUES ('Quadro Paisagem Montanhas ao Entardecer','Quadro decorativo em canvas, 80x120cm, cores quentes, ideal para sala de estar.',389.90,'https://exemplo.com/quadros/paisagem1.jpg',2);
INSERT INTO tb_produto (nome, descricao, preco, url_imagem, categoria_id) VALUES ('Quadro Praia Paradisíaca','Fotografia impressa em canvas com moldura de madeira, 100x70cm.',329.99,'https://exemplo.com/quadros/paisagem2.jpg',2);
INSERT INTO tb_produto (nome, descricao, preco, url_imagem, categoria_id) VALUES ('Quadro Leão Realista','Quadro decorativo com imagem de leão em cores vibrantes, 60x90cm.',279.99,'https://exemplo.com/quadros/animal1.jpg',3);
INSERT INTO tb_produto (nome, descricao, preco, url_imagem, categoria_id) VALUES ('Quadro Abstrato de Gato','Arte digital em canvas, 50x70cm, estilo colorido moderno.',199.99,'https://exemplo.com/quadros/animal2.jpg',3);
INSERT INTO tb_produto (nome, descricao, preco, url_imagem, categoria_id) VALUES ('Quadro Monalisa - Reprodução','Reprodução impressa em canvas da famosa obra de Leonardo da Vinci, 60x90cm.',399.99,'https://exemplo.com/quadros/classico1.jpg',4);
INSERT INTO tb_produto (nome, descricao, preco, url_imagem, categoria_id) VALUES ('Quadro Noite Estrelada - Van Gogh','Reprodução em canvas da icônica pintura de Van Gogh, 80x100cm.',459.90,'https://exemplo.com/quadros/classico2.jpg',4);
INSERT INTO tb_produto (nome, descricao, preco, url_imagem, categoria_id) VALUES ('Fotografia P&B Cidade Antiga','Fotografia artística em preto e branco, 70x100cm, moldura preta.',249.90,'https://exemplo.com/quadros/foto1.jpg',5);
INSERT INTO tb_produto (nome, descricao, preco, url_imagem, categoria_id) VALUES ('Fotografia Colorida Aurora Boreal','Fotografia em alta resolução impressa em canvas, 100x70cm.',349.90,'https://exemplo.com/quadros/foto2.jpg',5);

-- endereços
INSERT INTO tb_endereco (usuario_id, logradouro, complemento, cep, bairro, cidade, estado, numero) VALUES (1,'Av. Paulista','Ap 1203, Bloco B','01311-000','Bela Vista','São Paulo','SP','1570');
INSERT INTO tb_endereco (usuario_id, logradouro, complemento, cep, bairro, cidade, estado, numero) VALUES (1,'Rua das Palmeiras',NULL,'88010-400','Centro','Florianópolis','SC','245');
INSERT INTO tb_endereco (usuario_id, logradouro, complemento, cep, bairro, cidade, estado, numero) VALUES (2,'Rua XV de Novembro','Sala 402','80020-310','Centro','Curitiba','PR','1289');
INSERT INTO tb_endereco (usuario_id, logradouro, complemento, cep, bairro, cidade, estado, numero) VALUES (2,'Av. Beira Mar',NULL,'60165-121','Meireles','Fortaleza','CE','3000');

-- pedido
INSERT INTO tb_pedido (data, user_id) VALUES ('2025-09-20',1);
INSERT INTO tb_pedido (data, user_id) VALUES ('2025-09-23',2);

-- itens do pedido
INSERT INTO tb_itens_pedido ( preco, quantidade, pedido_id, produto_id) VALUES (299.90,1, 1, 1);
INSERT INTO tb_itens_pedido ( preco, quantidade, pedido_id, produto_id) VALUES (389.90,2, 1, 3);
INSERT INTO tb_itens_pedido ( preco, quantidade, pedido_id, produto_id) VALUES (199.90,1, 2, 2);
INSERT INTO tb_itens_pedido ( preco, quantidade, pedido_id, produto_id) VALUES (260.00,2, 2, 4);

