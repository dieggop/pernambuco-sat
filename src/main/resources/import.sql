insert into usuario (ativo,name,password,username,email,numero_telefone) values (1,'Ikeblem Silva','$2a$10$xlgzlAisr20m4OM3oR0O3OcHzyZWol8AUdpv/ivJLkRl5.CQgS8J6','kleber','ikeblem@email.com','99999999')

INSERT INTO regras (regra) values ('EDITAR')
INSERT INTO regras (regra) values ('ADICIONAR')
INSERT INTO regras (regra) values ('EXCLUIR')
INSERT INTO regras (regra) values ('LISTAR')
INSERT INTO regras (regra) values ('MOSTRAR')

INSERT INTO usuario_regras (usuarios_id, regras_id) values (1,1)
INSERT INTO usuario_regras (usuarios_id, regras_id) values (1,2)
INSERT INTO usuario_regras (usuarios_id, regras_id) values (1,3)
INSERT INTO usuario_regras (usuarios_id, regras_id) values (1,4)
INSERT INTO usuario_regras (usuarios_id, regras_id) values (1,5)

INSERT INTO usuario_regras (usuarios_id, regras_id) values (2,1)
INSERT INTO usuario_regras (usuarios_id, regras_id) values (2,2)
INSERT INTO usuario_regras (usuarios_id, regras_id) values (2,4)
INSERT INTO usuario_regras (usuarios_id, regras_id) values (2,5)

insert into categoria (nome) values ('categoria 4');
insert into categoria (nome) values ('categoria 5');
insert into categoria (nome) values ('categoria 6');
insert into categoria (nome) values ('categoria 7');
insert into categoria (nome) values ('categoria 8');
insert into categoria (nome) values ('categoria 9');
insert into categoria (nome) values ('categoria 10');