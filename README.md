# Padrões de Projetos - Avaliação Semestral

Aluno: Alceu Sant Ana Borges

## Como executar

Cada questão é independente e usa apenas a biblioteca padrão do Java.

```bash
cd questao1/src
javac *.java
java Main
```

```bash
cd questao2/src
javac *.java
java Main
```

## Questão 1 - Provisionamento Multinuvem

| Requisito | Padrão | Onde está |
| --- | --- | --- |
| RNF01, RNF02, RNF03, RNF06 | Abstract Factory | `FabricaNuvem`, `FabricaAws`, `FabricaAzure` e os produtos `MaquinaVirtual`, `Armazenamento`, `Fila` |
| RNF04 | Singleton | `Configuracao` |
| RNF05 | Singleton (thread-safe) | `Auditoria` |

## Questão 2 - Casa de Leilões Online

| Requisito | Padrão | Onde está |
| --- | --- | --- |
| RNF01 | Observer | `Sujeito`, `Observador`, `Lote`, `Participante`, `PainelLeiloeiro`, `Auditor` |
| RNF02 | Strategy | `RegraComissao` e as classes `Comissao...` |
| RNF03, RNF04 | Decorator | `Fatura`, `FaturaBase`, `ServicoAdicional` e os serviços concretos |

Os diagramas de classes estão em `questao1/diagrama` e `questao2/diagrama` (PlantUML e PNG).
