
CREATE TABLE public.servico
(
  id serial PRIMARY KEY,
  nome character varying(200),
  download numeric(20,0),
  upload numeric(20,0),
  status boolean
);


CREATE TABLE public.atendimento
(
  id serial PRIMARY KEY,
  motivo character varying(200) NOT NULL,
  cliente_id integer REFERENCES cliente(id),
  data_atendimento date,
  status character varying(50),
  descricao character varying(255),
  servico_id integer REFERENCES servico(id)

);

CREATE TABLE public.caixa
(
  id serial PRIMARY KEY,
  nome character varying(200) NOT NULL,
  latitude character varying(20),
  longitude character varying(20),
  cidade_id integer REFERENCES cidade(id)
);
CREATE TABLE public.cidade
(
  id serial PRIMARY KEY,
  nome character varying(200),
  estado character varying(200),
  cep character varying(200) NOT NULL,
  status boolean
);
CREATE TABLE public.cliente
(
  id serial PRIMARY KEY,
  nome character varying(200) NOT NULL,
  cpf character varying(15) NOT NULL,
  rg character varying(255),
  data_nascimento date,
  endereco_id integer
);
CREATE TABLE public.concentrador
(
  id serial PRIMARY KEY,
  nome character varying(200) NOT NULL,
  ip character varying(15) NOT NULL,
  login character varying(200) NOT NULL,
  senha character varying(200) NOT NULL,
  cidade_id integer REFERENCES cidade(id)
);
CREATE TABLE public.contato
(
  id serial PRIMARY KEY,
  responsavel character varying(200),
  tipo character varying(200),
  contato character varying(100),
  cliente_id integer REFERENCES cliente(id)
);
CREATE TABLE public.contrato
(
  id serial PRIMARY KEY,
  valor_instalacao numeric(4,0),
  valor_mensal numeric(4,0),
  numero_parcelas numeric(4,0),
  cliente_id integer REFERENCES cliente(id),
  servico_id integer REFERENCES servico(id)
);
CREATE TABLE public.endereco
(
  id serial PRIMARY KEY,
  numero numeric(20,0),
  rua character varying(20) NOT NULL,
  bairro character varying(20),
  cidade_id integer REFERENCES cidade(id),
  complemento character varying(255)
);
CREATE TABLE public.funcionario
(
  id serial PRIMARY KEY,
  nome character varying(200),
  cargo character varying(200),
  data_contrato date,
  login character varying(200) NOT NULL,
  senha character varying(200) NOT NULL,
  endereco_id integer REFERENCES cidade(id)
);
CREATE TABLE public.movimentacao
(
  id serial PRIMARY KEY,
  descricao character varying(500),
  situacao character varying(100),
  valor numeric(10,0),
  data_movimentacao date,
  status boolean,
  tipo character varying(20)
);
CREATE TABLE public.parcela
(
  id serial PRIMARY KEY,
  valor numeric(10,0),
  data_vencimento date,
  contrato_id integer references contrato(id),
  status character varying(50)
);

CREATE TABLE public.porta
(
  id serial PRIMARY KEY,
  numero numeric(20,0),
  switch_id integer REFERENCES switch(id),
  status character varying(50)
);
CREATE TABLE public.servicocliente
(
  id serial PRIMARY KEY,
  servico_id integer REFERENCES servico(id),
  switch_id integer REFERENCES switch(id),
  porta_id integer REFERENCES porta(id),
  endereco_id integer REFERENCES endereco(id),
  cliente_id integer REFERENCES cliente(id),
  login character varying(255),
  senha character varying(255),
  descricao character varying(255)
  );
CREATE TABLE public.switch
(
  id serial PRIMARY KEY,
  nome character varying(200) NOT NULL,
  numero_de_portas numeric(10,0),
  ip character varying(15) NOT NULL,
  login character varying(200),
  senha character varying(10) NOT NULL,
  caixa_id integer REFERENCES caixa(id),
  concentrador_id integer REFERENCES concentrador(id)
);

