insert into usuario (ativo,name,password,username,email,numeroTelefone) values (1,'Dieggo Carrilho','$2a$10$uUjoIG3ZCXuL3McCOSjpw.aO51qeKzRtwsIfN.2qOstSFuZhhzRJC','dieggo','dieggo@email.com','997282363')

INSERT INTO REGRAS (regra) values ('admin_editar')
INSERT INTO REGRAS (regra) values ('admin_adicionar')
INSERT INTO REGRAS (regra) values ('admin_excluir')
INSERT INTO REGRAS (regra) values ('admin_listar')
INSERT INTO REGRAS (regra) values ('admin_mostrar')
INSERT INTO REGRAS (regra) values ('USER')
INSERT INTO REGRAS (regra) values ('ADMIN')

INSERT INTO USUARIO_REGRAS (usuarios_id, regras_id) values (1,6)

insert into categoria (nome) values ('categoria 4');
insert into categoria (nome) values ('categoria 5');
insert into categoria (nome) values ('categoria 6');
insert into categoria (nome) values ('categoria 7');
insert into categoria (nome) values ('categoria 8');
insert into categoria (nome) values ('categoria 9');
insert into categoria (nome) values ('categoria 10');