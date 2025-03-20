# for i in {1..10}; do
#     java -cp "classes:lib/*" main.Main data/j_caesar.xml data/query/q$i.txt data/result/q$i.xml
# done
java -cp "classes:lib/*" main.Main data/j_caesar.xml data/query/query1.txt data/result/queryRewrite1.txt data/result/query1.xml
for i in {2..4}; do
    java -cp "classes:lib/*" main.Main data/large-data.xml data/query/query$i.txt data/result/queryRewrite$i.txt data/result/query$i.xml
done
# java -cp "classes:lib/*" main.Main data/input.xml data/query/Ex1.txt data/result/queryRewriteEx1.txt data/result/queryEx1.xml
# java -cp "classes:lib/*" main.Main data/input.xml data/query/Ex3.txt data/result/queryRewriteEx3.txt data/result/queryEx3.xml
