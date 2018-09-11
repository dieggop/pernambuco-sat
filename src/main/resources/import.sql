insert into usuario (ativo,name,password,username,email,numero_telefone) values (1,'Dieggo Carrilho','$2a$10$uUjoIG3ZCXuL3McCOSjpw.aO51qeKzRtwsIfN.2qOstSFuZhhzRJC','dieggo','dieggo@email.com','997282363');

INSERT INTO REGRAS (regra) values ('admin_editar');
INSERT INTO REGRAS (regra) values ('admin_adicionar');
INSERT INTO REGRAS (regra) values ('admin_excluir');
INSERT INTO REGRAS (regra) values ('admin_listar');
INSERT INTO REGRAS (regra) values ('admin_mostrar');
INSERT INTO REGRAS (regra) values ('USER');
INSERT INTO REGRAS (regra) values ('ADMIN');

INSERT INTO USUARIO_REGRAS (usuarios_id, regras_id) values (1,6);