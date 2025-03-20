## CSE232B
Project of CSE232B at UC San Diego Winter 2025 [Database Systems Implementation]: Construction of an XQuery processor with Join optimizations.

### How to run
```bash
cd M3
./compile.sh
./run.sh
```
The XQuery results will be genrated at `/data/result`


### Introduction

- M1: an XPath evaluator
- M2: an XQuery evaluator
- M3: an XQuery evaluator with a rewritter to rewrite queries that can be optimized using hash join
