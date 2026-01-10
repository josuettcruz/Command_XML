# Coommand_xml

## Este é um projeto que permite ler arquivos XML e guardá-los em uma classe correspondente.
### Leitura do XML
Nesse projeto, uma classe fica dentro de uma lista:

> List<[nome da classe]> = new ArrayList();

Isso permite com que cada __TAG__ de um __arquivo XML__ fique dentro de uma __classe__
Isso permite com que um arquivo seja lido completamente!

### TAGs do XML
Ao ler um __arquivo XML__ cada __TAG__ não se resume a texto, podendo ser:
- NÚMERO
- DATA
- HORA
- TEMPO DE MÍDIA
- (outros)

Para isso, foi criado um __pacote__ chamado __model__ com várias __classes__ correspondentes aos __tipos de dados__ listados à cima!
A função delas é bem simples:
_Os dados são lidos pelo __XML__ e entram nessas classes como texto!_
_Depois disso, saem com o tipo de dados desejados!_
_Tirando assim o uso de funções internas como:_
> ParseInt();
